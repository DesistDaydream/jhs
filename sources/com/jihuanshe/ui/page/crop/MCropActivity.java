package com.jihuanshe.ui.page.crop;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.PorterDuff;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.crop.MCropActivity;
import com.jihuanshe.ui.widget.SeekBarView;
import com.jihuanshe.ui.widget.crop.MCropView;
import com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView;
import com.vector.util.Res;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.callback.BitmapCropCallback;
import com.yalantis.ucrop.model.AspectRatio;
import com.yalantis.ucrop.util.SelectedStateListDrawable;
import com.yalantis.ucrop.view.MUCropView;
import com.yalantis.ucrop.view.OverlayView;
import com.yalantis.ucrop.view.TransformImageView;
import com.yalantis.ucrop.view.widget.AspectRatioTextView;
import com.yalantis.ucrop.view.widget.HorizontalProgressWheelView;
import h.t1;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class MCropActivity extends AppCompatActivity {
    public static final int Y = 90;
    public static final Bitmap.CompressFormat Z = Bitmap.CompressFormat.JPEG;
    public static final int a0 = 0;
    public static final int b0 = 1;
    public static final int c0 = 2;
    public static final int d0 = 3;
    private static final String e0 = "UCropActivity";
    private static final long f0 = 50;
    private static final int g0 = 3;
    private static final int h0 = 15000;
    private static final int i0 = 42;
    private ImageView A;
    private ImageView B;
    private TextView D;
    private TextView E;
    private MHorizontalProgressWheelView F;
    private View G;
    private View H;
    private View I;
    private ImageView J;
    private View K;
    private Transition L;
    private SeekBarView P;
    private SeekBarView Q;
    private SeekBarView R;
    private SeekBarView S;
    private String a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f4013c;

    /* renamed from: d  reason: collision with root package name */
    private int f4014d;

    /* renamed from: e  reason: collision with root package name */
    private int f4015e;
    @ColorInt

    /* renamed from: f  reason: collision with root package name */
    private int f4016f;
    @DrawableRes

    /* renamed from: g  reason: collision with root package name */
    private int f4017g;
    @DrawableRes

    /* renamed from: h  reason: collision with root package name */
    private int f4018h;

    /* renamed from: i  reason: collision with root package name */
    private int f4019i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f4020j;

    /* renamed from: l  reason: collision with root package name */
    private MUCropView f4022l;

    /* renamed from: m  reason: collision with root package name */
    private MCropView f4023m;
    private OverlayView n;
    private ViewGroup o;
    private ViewGroup p;
    private ViewGroup q;
    private ViewGroup r;
    private ViewGroup s;
    private ViewGroup t;
    private ViewGroup u;
    private ViewGroup v;
    private ViewGroup w;
    private ViewGroup x;
    private ImageView y;
    private ImageView z;

    /* renamed from: k  reason: collision with root package name */
    private boolean f4021k = true;
    private List<ViewGroup> C = new ArrayList();
    private Bitmap.CompressFormat M = Z;
    private int N = 90;
    private int[] O = {1, 2, 3, 0};
    private boolean T = false;
    private TransformImageView.TransformImageListener U = new j();
    private final View.OnClickListener V = new a();
    private final View.OnClickListener W = new b();
    private final View.OnClickListener X = new c();

    /* loaded from: classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            MCropActivity.this.setWidgetState(view.getId());
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.isSelected()) {
                return;
            }
            MCropActivity.this.D(view.getId());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == R.id.leftIv) {
                MCropActivity.this.F.c(-90.0f);
                MCropActivity.this.rotateByAngle(-90);
                return;
            }
            MCropActivity.this.F.c(90.0f);
            MCropActivity.this.rotateByAngle(90);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements BitmapCropCallback {
        public d() {
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onBitmapCropped(@NonNull Uri uri, int i2, int i3, int i4, int i5) {
            MCropActivity mCropActivity = MCropActivity.this;
            mCropActivity.setResultUri(uri, mCropActivity.f4023m.getTargetAspectRatio(), i2, i3, i4, i5);
            MCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.callback.BitmapCropCallback
        public void onCropFailure(@NonNull Throwable th) {
            MCropActivity.this.setResultError(th);
            MCropActivity.this.finish();
        }
    }

    /* loaded from: classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MCropActivity.this.cropAndSaveImage();
        }
    }

    /* loaded from: classes2.dex */
    public class f implements SeekBarView.d {
        public f() {
        }

        @Override // com.jihuanshe.ui.widget.SeekBarView.d
        public void onProgress(int i2) {
            MCropActivity.this.f4023m.setBright(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class g implements SeekBarView.d {
        public g() {
        }

        @Override // com.jihuanshe.ui.widget.SeekBarView.d
        public void onProgress(int i2) {
            MCropActivity.this.f4023m.setSuiation(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements SeekBarView.d {
        public h() {
        }

        @Override // com.jihuanshe.ui.widget.SeekBarView.d
        public void onProgress(int i2) {
            MCropActivity.this.f4023m.setContrast(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class i implements SeekBarView.d {
        public i() {
        }

        @Override // com.jihuanshe.ui.widget.SeekBarView.d
        public void onProgress(int i2) {
            MCropActivity.this.f4023m.setTemp(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class j implements TransformImageView.TransformImageListener {
        public j() {
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadComplete() {
            MCropActivity.this.f4022l.animate().alpha(1.0f).setDuration(300L).setInterpolator(new AccelerateInterpolator());
            MCropActivity.this.G.setClickable(false);
            MCropActivity.this.f4021k = false;
            MCropActivity.this.supportInvalidateOptionsMenu();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onLoadFailure(@NonNull Exception exc) {
            MCropActivity.this.setResultError(exc);
            MCropActivity.this.finish();
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onRotate(float f2) {
            MCropActivity.this.setAngleText(f2);
        }

        @Override // com.yalantis.ucrop.view.TransformImageView.TransformImageListener
        public void onScale(float f2) {
            MCropActivity.this.setScaleText(f2);
        }
    }

    /* loaded from: classes2.dex */
    public class k implements View.OnClickListener {
        public k() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MCropActivity.this.f4023m.setTargetAspectRatio(((AspectRatioTextView) ((ViewGroup) view).getChildAt(0)).getAspectRatio(view.isSelected()));
            MCropActivity.this.f4023m.setImageToWrapCropBounds();
            if (view.isSelected()) {
                return;
            }
            for (ViewGroup viewGroup : MCropActivity.this.C) {
                viewGroup.setSelected(viewGroup == view);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class l implements MHorizontalProgressWheelView.a {
        public l() {
        }

        @Override // com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView.a
        public void a(float f2, float f3, float f4) {
            MCropActivity.this.f4023m.postRotate(f4);
        }

        @Override // com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView.a
        public void onScrollEnd() {
            MCropActivity.this.f4023m.setImageToWrapCropBounds();
        }

        @Override // com.jihuanshe.ui.widget.crop.MHorizontalProgressWheelView.a
        public void onScrollStart() {
            MCropActivity.this.f4023m.cancelAllAnimations();
        }
    }

    /* loaded from: classes2.dex */
    public class m implements HorizontalProgressWheelView.ScrollingListener {
        public m() {
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScroll(float f2, float f3) {
            if (f2 > 0.0f) {
                MCropActivity.this.f4023m.zoomInImage(MCropActivity.this.f4023m.getCurrentScale() + (f2 * ((MCropActivity.this.f4023m.getMaxScale() - MCropActivity.this.f4023m.getMinScale()) / 15000.0f)));
            } else {
                MCropActivity.this.f4023m.zoomOutImage(MCropActivity.this.f4023m.getCurrentScale() + (f2 * ((MCropActivity.this.f4023m.getMaxScale() - MCropActivity.this.f4023m.getMinScale()) / 15000.0f)));
            }
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollEnd() {
            MCropActivity.this.f4023m.setImageToWrapCropBounds();
        }

        @Override // com.yalantis.ucrop.view.widget.HorizontalProgressWheelView.ScrollingListener
        public void onScrollStart() {
            MCropActivity.this.f4023m.cancelAllAnimations();
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface n {
    }

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: B */
    public /* synthetic */ void C(View view) {
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D(@IdRes int i2) {
        this.z.setSelected(i2 == R.id.compareIv);
        this.A.setSelected(i2 == R.id.tempIv);
        this.B.setSelected(i2 == R.id.saturationIv);
        this.y.setSelected(i2 == R.id.brightIv);
        this.R.setVisibility(this.z.isSelected() ? 0 : 8);
        this.S.setVisibility(this.A.isSelected() ? 0 : 8);
        this.Q.setVisibility(this.B.isSelected() ? 0 : 8);
        this.P.setVisibility(this.y.isSelected() ? 0 : 8);
    }

    private void E() {
        MCropView mCropView = this.f4023m;
        mCropView.zoomInImage(mCropView.getMinScale());
        this.f4023m.setImageToWrapCropBounds(false);
    }

    private void addBlockingView() {
        if (this.G == null) {
            this.G = new View(this);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
            layoutParams.addRule(3, R.id.toolbar);
            this.G.setLayoutParams(layoutParams);
            this.G.setClickable(true);
        }
        ((RelativeLayout) findViewById(R.id.ucrop_photobox)).addView(this.G);
    }

    private void changeSelectedTab(int i2) {
        TransitionManager.beginDelayedTransition((ViewGroup) findViewById(R.id.ucrop_photobox), this.L);
        this.q.findViewById(R.id.text_view_scale).setVisibility(i2 == R.id.state_scale ? 0 : 8);
        this.o.findViewById(R.id.text_view_crop).setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
        this.p.findViewById(R.id.text_view_rotate).setVisibility(i2 != R.id.state_rotate ? 8 : 0);
    }

    private void initiateRootViews() {
        MUCropView mUCropView = (MUCropView) findViewById(R.id.ucrop);
        this.f4022l = mUCropView;
        this.f4023m = mUCropView.getCropImageView();
        this.n = this.f4022l.getOverlayView();
        this.f4023m.setImageListener(new h.k2.u.a() { // from class: e.l.q.b.c.a
            {
                MCropActivity.this = this;
            }

            @Override // h.k2.u.a
            public final Object invoke() {
                return MCropActivity.this.A();
            }
        });
        this.f4023m.setTransformImageListener(this.U);
        ((ImageView) findViewById(R.id.image_view_logo)).setColorFilter(this.f4019i, PorterDuff.Mode.SRC_ATOP);
        findViewById(R.id.ucrop_frame).setBackgroundColor(this.f4016f);
        if (this.f4020j) {
            return;
        }
        ((RelativeLayout.LayoutParams) findViewById(R.id.ucrop_frame).getLayoutParams()).bottomMargin = 0;
        findViewById(R.id.ucrop_frame).requestLayout();
    }

    private void processOptions(@NonNull Intent intent) {
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_COMPRESSION_FORMAT_NAME);
        Bitmap.CompressFormat valueOf = !TextUtils.isEmpty(stringExtra) ? Bitmap.CompressFormat.valueOf(stringExtra) : null;
        if (valueOf == null) {
            valueOf = Z;
        }
        this.M = valueOf;
        this.N = intent.getIntExtra(UCrop.Options.EXTRA_COMPRESSION_QUALITY, 90);
        int[] intArrayExtra = intent.getIntArrayExtra(UCrop.Options.EXTRA_ALLOWED_GESTURES);
        if (intArrayExtra != null && intArrayExtra.length == 3) {
            this.O = intArrayExtra;
        }
        this.f4023m.setMaxBitmapSize(intent.getIntExtra(UCrop.Options.EXTRA_MAX_BITMAP_SIZE, 0));
        this.f4023m.setMaxScaleMultiplier(intent.getFloatExtra(UCrop.Options.EXTRA_MAX_SCALE_MULTIPLIER, 10.0f));
        this.f4023m.setImageToWrapCropBoundsAnimDuration(intent.getIntExtra(UCrop.Options.EXTRA_IMAGE_TO_CROP_BOUNDS_ANIM_DURATION, 500));
        this.n.setFreestyleCropEnabled(intent.getBooleanExtra(UCrop.Options.EXTRA_FREE_STYLE_CROP, false));
        this.n.setDimmedColor(intent.getIntExtra(UCrop.Options.EXTRA_DIMMED_LAYER_COLOR, getResources().getColor(R.color.ucrop_color_default_dimmed)));
        this.n.setCircleDimmedLayer(intent.getBooleanExtra(UCrop.Options.EXTRA_CIRCLE_DIMMED_LAYER, false));
        this.n.setShowCropFrame(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_FRAME, true));
        this.n.setCropFrameColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_frame)));
        this.n.setCropFrameStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_FRAME_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_frame_stoke_width)));
        this.n.setShowCropGrid(intent.getBooleanExtra(UCrop.Options.EXTRA_SHOW_CROP_GRID, true));
        this.n.setCropGridRowCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_ROW_COUNT, 2));
        this.n.setCropGridColumnCount(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLUMN_COUNT, 2));
        this.n.setCropGridColor(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_COLOR, getResources().getColor(R.color.ucrop_color_default_crop_grid)));
        this.n.setCropGridStrokeWidth(intent.getIntExtra(UCrop.Options.EXTRA_CROP_GRID_STROKE_WIDTH, getResources().getDimensionPixelSize(R.dimen.ucrop_default_crop_grid_stoke_width)));
        float floatExtra = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_X, 0.0f);
        float floatExtra2 = intent.getFloatExtra(UCrop.EXTRA_ASPECT_RATIO_Y, 0.0f);
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        int i2 = (floatExtra > 0.0f ? 1 : (floatExtra == 0.0f ? 0 : -1));
        if (i2 > 0 && floatExtra2 > 0.0f) {
            ViewGroup viewGroup = this.o;
            if (viewGroup != null) {
                viewGroup.setVisibility(8);
            }
            this.f4023m.setTargetAspectRatio(floatExtra / floatExtra2);
        } else if (parcelableArrayListExtra != null && intExtra < parcelableArrayListExtra.size()) {
            this.f4023m.setTargetAspectRatio(((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioX() / ((AspectRatio) parcelableArrayListExtra.get(intExtra)).getAspectRatioY());
        } else if (i2 > 0) {
            this.f4023m.setTargetAspectRatio(floatExtra);
        } else {
            this.f4023m.setTargetAspectRatio(0.0f);
        }
        int intExtra2 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_X, 0);
        int intExtra3 = intent.getIntExtra(UCrop.EXTRA_MAX_SIZE_Y, 0);
        if (intExtra2 > 0 && intExtra3 > 0) {
            this.f4023m.setMaxResultImageSizeX(intExtra2);
            this.f4023m.setMaxResultImageSizeY(intExtra3);
        }
        this.T = intent.getBooleanExtra("is_min", false);
    }

    private void resetRotation() {
        MCropView mCropView = this.f4023m;
        mCropView.postRotate(-mCropView.getCurrentAngle());
        this.f4023m.setImageToWrapCropBounds();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rotateByAngle(int i2) {
        this.f4023m.postRotate(i2);
        this.f4023m.setImageToWrapCropBounds();
    }

    private void setAllowedGestures(int i2) {
        boolean z = true;
        this.f4023m.setCanTouch(i2 != 3);
        MCropView mCropView = this.f4023m;
        int[] iArr = this.O;
        if (iArr[i2] != 3 && iArr[i2] != 1) {
            z = false;
        }
        mCropView.setScaleEnabled(z);
        this.f4023m.setRotateEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAngleText(float f2) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f°", Float.valueOf(f2)));
        }
    }

    private void setAngleTextColor(int i2) {
        TextView textView = this.D;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    private void setImageData(@NonNull Intent intent) {
        Uri uri = (Uri) intent.getParcelableExtra(UCrop.EXTRA_INPUT_URI);
        Uri uri2 = (Uri) intent.getParcelableExtra(UCrop.EXTRA_OUTPUT_URI);
        processOptions(intent);
        if (uri != null && uri2 != null) {
            try {
                this.f4023m.setImageUri(uri, uri2);
                return;
            } catch (Exception e2) {
                setResultError(e2);
                finish();
                return;
            }
        }
        setResultError(new NullPointerException(getString(R.string.ucrop_error_input_data_is_absent)));
        finish();
    }

    private void setInitialState() {
        if (this.f4020j) {
            if (this.o.getVisibility() == 0) {
                setWidgetState(R.id.state_aspect_ratio);
                return;
            } else {
                setWidgetState(R.id.state_scale);
                return;
            }
        }
        setAllowedGestures(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setScaleText(float f2) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%d%%", Integer.valueOf((int) (f2 * 100.0f))));
        }
    }

    private void setScaleTextColor(int i2) {
        TextView textView = this.E;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    @TargetApi(21)
    private void setStatusBarColor(@ColorInt int i2) {
        Window window;
        if (Build.VERSION.SDK_INT < 21 || (window = getWindow()) == null) {
            return;
        }
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(i2);
        window.setNavigationBarColor(Res.k(R.color.black));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setWidgetState(@IdRes int i2) {
        if (this.f4020j) {
            this.o.setSelected(i2 == R.id.state_aspect_ratio);
            this.r.setSelected(i2 == R.id.state_adjust);
            this.s.setVisibility(8);
            this.t.setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
            this.x.setVisibility(i2 == R.id.state_aspect_ratio ? 0 : 8);
            this.u.setVisibility(i2 == R.id.state_scale ? 0 : 8);
            this.v.setVisibility(i2 == R.id.state_adjust ? 0 : 8);
            this.w.setVisibility(i2 == R.id.state_adjust ? 0 : 8);
            if (i2 == R.id.state_scale) {
                setAllowedGestures(0);
            } else if (i2 == R.id.state_rotate) {
                setAllowedGestures(1);
            } else if (i2 == R.id.state_adjust) {
                setAllowedGestures(3);
            } else {
                setAllowedGestures(2);
            }
        }
    }

    private void setupAppBar() {
        setStatusBarColor(this.f4013c);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.findViewById(R.id.backIv).setOnClickListener(new View.OnClickListener() { // from class: e.l.q.b.c.b
            {
                MCropActivity.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MCropActivity.this.C(view);
            }
        });
        setSupportActionBar(toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            supportActionBar.setDisplayShowTitleEnabled(false);
        }
    }

    private void setupAspectRatioWidget(@NonNull Intent intent) {
        int intExtra = intent.getIntExtra(UCrop.Options.EXTRA_ASPECT_RATIO_SELECTED_BY_DEFAULT, 0);
        ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(UCrop.Options.EXTRA_ASPECT_RATIO_OPTIONS);
        if (parcelableArrayListExtra == null || parcelableArrayListExtra.isEmpty()) {
            intExtra = 2;
            parcelableArrayListExtra = new ArrayList();
            parcelableArrayListExtra.add(new AspectRatio(null, 1.0f, 1.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 4.0f));
            parcelableArrayListExtra.add(new AspectRatio(getString(R.string.ucrop_label_original).toUpperCase(), 0.0f, 0.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 3.0f, 2.0f));
            parcelableArrayListExtra.add(new AspectRatio(null, 16.0f, 9.0f));
        }
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.layout_aspect_ratio);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -1);
        layoutParams.weight = 1.0f;
        Iterator it = parcelableArrayListExtra.iterator();
        while (it.hasNext()) {
            FrameLayout frameLayout = (FrameLayout) getLayoutInflater().inflate(R.layout.ucrop_aspect_ratio, (ViewGroup) null);
            frameLayout.setLayoutParams(layoutParams);
            AspectRatioTextView aspectRatioTextView = (AspectRatioTextView) frameLayout.getChildAt(0);
            aspectRatioTextView.setActiveColor(this.f4014d);
            aspectRatioTextView.setAspectRatio((AspectRatio) it.next());
            linearLayout.addView(frameLayout);
            this.C.add(frameLayout);
        }
        this.C.get(intExtra).setSelected(true);
        for (ViewGroup viewGroup : this.C) {
            viewGroup.setOnClickListener(new k());
        }
    }

    private void setupRotateWidget() {
        this.D = (TextView) findViewById(R.id.text_view_rotate);
        MHorizontalProgressWheelView mHorizontalProgressWheelView = (MHorizontalProgressWheelView) findViewById(R.id.rotate_scroll_wheel);
        this.F = mHorizontalProgressWheelView;
        mHorizontalProgressWheelView.setMiddleLineColor(Res.k(R.color.common_color));
        this.F.setScrollingListener(new l());
        setAngleTextColor(this.f4014d);
        setAngleText(0.0f);
    }

    private void setupScaleWidget() {
        this.E = (TextView) findViewById(R.id.text_view_scale);
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setScrollingListener(new m());
        ((HorizontalProgressWheelView) findViewById(R.id.scale_scroll_wheel)).setMiddleLineColor(this.f4014d);
        setScaleTextColor(this.f4014d);
    }

    private void setupStatesWrapper() {
        ImageView imageView = (ImageView) findViewById(R.id.image_view_state_scale);
        ImageView imageView2 = (ImageView) findViewById(R.id.image_view_state_rotate);
        ImageView imageView3 = (ImageView) findViewById(R.id.image_view_state_aspect_ratio);
        imageView.setImageDrawable(new SelectedStateListDrawable(imageView.getDrawable(), this.f4014d));
        imageView2.setImageDrawable(new SelectedStateListDrawable(imageView2.getDrawable(), this.f4014d));
        imageView3.setImageDrawable(new SelectedStateListDrawable(imageView3.getDrawable(), this.f4014d));
    }

    private void setupViews(@NonNull Intent intent) {
        this.f4013c = intent.getIntExtra(UCrop.Options.EXTRA_STATUS_BAR_COLOR, ContextCompat.getColor(this, R.color.black_111111));
        this.b = intent.getIntExtra(UCrop.Options.EXTRA_TOOL_BAR_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar));
        this.f4014d = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_COLOR_CONTROLS_WIDGET_ACTIVE, Res.k(R.color.common_color));
        this.f4015e = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_COLOR_TOOLBAR, ContextCompat.getColor(this, R.color.ucrop_color_toolbar_widget));
        this.f4017g = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CANCEL_DRAWABLE, R.drawable.ucrop_ic_cross);
        this.f4018h = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_WIDGET_CROP_DRAWABLE, R.drawable.ucrop_ic_done);
        String stringExtra = intent.getStringExtra(UCrop.Options.EXTRA_UCROP_TITLE_TEXT_TOOLBAR);
        this.a = stringExtra;
        if (stringExtra == null) {
            stringExtra = Res.a.v(R.string.image_add_image, new Object[0]);
        }
        this.a = stringExtra;
        this.f4019i = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_LOGO_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_default_logo));
        this.f4020j = !intent.getBooleanExtra(UCrop.Options.EXTRA_HIDE_BOTTOM_CONTROLS, false);
        this.f4016f = intent.getIntExtra(UCrop.Options.EXTRA_UCROP_ROOT_VIEW_BACKGROUND_COLOR, ContextCompat.getColor(this, R.color.ucrop_color_crop_background));
        setupAppBar();
        initiateRootViews();
        if (this.f4020j) {
            ViewGroup viewGroup = (ViewGroup) ((ViewGroup) findViewById(R.id.ucrop_photobox)).findViewById(R.id.controls_wrapper);
            viewGroup.setVisibility(0);
            LayoutInflater.from(this).inflate(R.layout.jhs_ucrop_controls, viewGroup, true);
            AutoTransition autoTransition = new AutoTransition();
            this.L = autoTransition;
            autoTransition.setDuration(f0);
            ViewGroup viewGroup2 = (ViewGroup) findViewById(R.id.state_aspect_ratio);
            this.o = viewGroup2;
            viewGroup2.setOnClickListener(this.V);
            ViewGroup viewGroup3 = (ViewGroup) findViewById(R.id.state_rotate);
            this.p = viewGroup3;
            viewGroup3.setOnClickListener(this.V);
            ViewGroup viewGroup4 = (ViewGroup) findViewById(R.id.state_scale);
            this.q = viewGroup4;
            viewGroup4.setOnClickListener(this.V);
            ViewGroup viewGroup5 = (ViewGroup) findViewById(R.id.state_adjust);
            this.r = viewGroup5;
            viewGroup5.setOnClickListener(this.V);
            this.w = (ViewGroup) findViewById(R.id.sbLayout);
            this.y = (ImageView) findViewById(R.id.brightIv);
            this.A = (ImageView) findViewById(R.id.tempIv);
            this.B = (ImageView) findViewById(R.id.saturationIv);
            this.z = (ImageView) findViewById(R.id.compareIv);
            this.y.setOnClickListener(this.W);
            this.A.setOnClickListener(this.W);
            this.B.setOnClickListener(this.W);
            this.z.setOnClickListener(this.W);
            this.H = findViewById(R.id.rightIv);
            this.I = findViewById(R.id.leftIv);
            this.H.setOnClickListener(this.X);
            this.I.setOnClickListener(this.X);
            this.s = (ViewGroup) findViewById(R.id.layout_aspect_ratio);
            this.t = (ViewGroup) findViewById(R.id.layout_rotate_wheel);
            this.x = (ViewGroup) findViewById(R.id.view_clip);
            this.u = (ViewGroup) findViewById(R.id.layout_scale_wheel);
            this.v = (ViewGroup) findViewById(R.id.layout_adjust_view);
            this.P = (SeekBarView) findViewById(R.id.brightSB);
            this.Q = (SeekBarView) findViewById(R.id.suiationSB);
            this.R = (SeekBarView) findViewById(R.id.compareSB);
            this.S = (SeekBarView) findViewById(R.id.tempSB);
            View findViewById = findViewById(R.id.saveBtn);
            this.K = findViewById;
            findViewById.setOnClickListener(new e());
            this.P.j(new f());
            this.Q.j(new g());
            this.R.j(new h());
            this.S.j(new i());
            setupAspectRatioWidget(intent);
            setupRotateWidget();
            setupScaleWidget();
            setupStatesWrapper();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ t1 A() {
        if (this.T) {
            E();
            return null;
        }
        return null;
    }

    public void cropAndSaveImage() {
        this.G.setClickable(true);
        this.f4021k = true;
        supportInvalidateOptionsMenu();
        this.f4023m.cropAndSaveImage(this.M, this.N, new d());
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_mcrop);
        Intent intent = getIntent();
        setupViews(intent);
        setImageData(intent);
        setInitialState();
        addBlockingView();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        MCropView mCropView = this.f4023m;
        if (mCropView != null) {
            mCropView.cancelAllAnimations();
        }
    }

    public void setResultError(Throwable th) {
        setResult(96, new Intent().putExtra(UCrop.EXTRA_ERROR, th));
    }

    public void setResultUri(Uri uri, float f2, int i2, int i3, int i4, int i5) {
        setResult(-1, new Intent().putExtra(UCrop.EXTRA_OUTPUT_URI, uri).putExtra(UCrop.EXTRA_OUTPUT_CROP_ASPECT_RATIO, f2).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_WIDTH, i4).putExtra(UCrop.EXTRA_OUTPUT_IMAGE_HEIGHT, i5).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_X, i2).putExtra(UCrop.EXTRA_OUTPUT_OFFSET_Y, i3));
    }
}
