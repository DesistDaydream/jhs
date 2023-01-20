package com.jihuanshe.ui.widget.imagepreview;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.jihuanshe.R;
import com.jihuanshe.ui.widget.imagepreview.GPreviewBuilder;
import com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo;
import com.jihuanshe.ui.widget.imagepreview.wight.BezierBannerView;
import com.jihuanshe.ui.widget.imagepreview.wight.PhotoViewPager;
import com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView;
import com.vivo.push.PushClientConstants;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class GPreviewActivity extends FragmentActivity {
    private List<IThumbViewInfo> b;

    /* renamed from: c  reason: collision with root package name */
    public int f4285c;

    /* renamed from: e  reason: collision with root package name */
    private PhotoViewPager f4287e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f4288f;

    /* renamed from: g  reason: collision with root package name */
    private BezierBannerView f4289g;

    /* renamed from: h  reason: collision with root package name */
    private GPreviewBuilder.IndicatorType f4290h;
    public boolean a = false;

    /* renamed from: d  reason: collision with root package name */
    private List<e.l.q.c.t0.e.a> f4286d = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f4291i = true;

    /* loaded from: classes2.dex */
    public class PhotoPagerAdapter extends FragmentStatePagerAdapter {
        public PhotoPagerAdapter(FragmentManager fragmentManager) {
            super(fragmentManager);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            if (GPreviewActivity.this.f4286d == null) {
                return 0;
            }
            return GPreviewActivity.this.f4286d.size();
        }

        @Override // androidx.fragment.app.FragmentStatePagerAdapter
        public Fragment getItem(int i2) {
            return (Fragment) GPreviewActivity.this.f4286d.get(i2);
        }
    }

    /* loaded from: classes2.dex */
    public class a implements ViewPager.OnPageChangeListener {
        public a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (GPreviewActivity.this.f4288f != null) {
                GPreviewActivity.this.f4288f.setText(GPreviewActivity.this.getString(R.string.string_count, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(GPreviewActivity.this.b.size())}));
            }
            GPreviewActivity gPreviewActivity = GPreviewActivity.this;
            gPreviewActivity.f4285c = i2;
            gPreviewActivity.f4287e.setCurrentItem(GPreviewActivity.this.f4285c, true);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            GPreviewActivity.this.f4287e.getViewTreeObserver().removeGlobalOnLayoutListener(this);
            ((e.l.q.c.t0.e.a) GPreviewActivity.this.f4286d.get(GPreviewActivity.this.f4285c)).x();
        }
    }

    /* loaded from: classes2.dex */
    public class c implements SmoothImageView.j {
        public c() {
        }

        @Override // com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.j
        public void a(SmoothImageView.Status status) {
            GPreviewActivity.this.v().setEnabled(true);
            GPreviewActivity.this.t();
        }
    }

    private void initData() {
        this.b = getIntent().getParcelableArrayListExtra("imagePaths");
        this.f4285c = getIntent().getIntExtra("position", -1);
        this.f4290h = (GPreviewBuilder.IndicatorType) getIntent().getSerializableExtra("type");
        this.f4291i = getIntent().getBooleanExtra("isShow", true);
        int intExtra = getIntent().getIntExtra("duration", 300);
        boolean booleanExtra = getIntent().getBooleanExtra("isFullscreen", false);
        boolean booleanExtra2 = getIntent().getBooleanExtra("isScale", false);
        SmoothImageView.setFullscreen(booleanExtra);
        SmoothImageView.setIsScale(booleanExtra2);
        if (booleanExtra) {
            setTheme(16973841);
        }
        try {
            SmoothImageView.setDuration(intExtra);
            w(this.b, this.f4285c, (Class) getIntent().getSerializableExtra(PushClientConstants.TAG_CLASS_NAME));
        } catch (Exception unused) {
            w(this.b, this.f4285c, e.l.q.c.t0.e.a.class);
        }
    }

    @SuppressLint({"StringFormatMatches"})
    private void initView() {
        this.f4287e = (PhotoViewPager) findViewById(R.id.viewPager);
        this.f4287e.setAdapter(new PhotoPagerAdapter(getSupportFragmentManager()));
        this.f4287e.setCurrentItem(this.f4285c);
        this.f4287e.setOffscreenPageLimit(3);
        this.f4289g = (BezierBannerView) findViewById(R.id.bezierBannerView);
        TextView textView = (TextView) findViewById(R.id.ltAddDot);
        this.f4288f = textView;
        if (this.f4290h == GPreviewBuilder.IndicatorType.Dot) {
            this.f4289g.setVisibility(0);
            this.f4289g.c(this.f4287e);
        } else {
            textView.setVisibility(0);
            this.f4288f.setText(getString(R.string.string_count, new Object[]{Integer.valueOf(this.f4285c + 1), Integer.valueOf(this.b.size())}));
            this.f4287e.addOnPageChangeListener(new a());
        }
        if (this.f4286d.size() == 1 && !this.f4291i) {
            this.f4289g.setVisibility(8);
            this.f4288f.setVisibility(8);
        }
        this.f4287e.getViewTreeObserver().addOnGlobalLayoutListener(new b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void t() {
        finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    public void finish() {
        e.l.q.c.t0.e.a.f14242m = null;
        super.finish();
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.a = false;
        y();
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        initData();
        if (this.b == null) {
            return;
        }
        if (x() == 0) {
            setContentView(R.layout.activity_image_preview_photo);
        } else {
            setContentView(x());
        }
        initView();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        e.l.q.c.t0.b.a().b().a(this);
        PhotoViewPager photoViewPager = this.f4287e;
        if (photoViewPager != null) {
            photoViewPager.setAdapter(null);
            this.f4287e.clearOnPageChangeListeners();
            this.f4287e.removeAllViews();
            this.f4287e = null;
        }
        List<e.l.q.c.t0.e.a> list = this.f4286d;
        if (list != null) {
            list.clear();
            this.f4286d = null;
        }
        List<IThumbViewInfo> list2 = this.b;
        if (list2 != null) {
            list2.clear();
            this.b = null;
        }
        super.onDestroy();
    }

    public List<e.l.q.c.t0.e.a> u() {
        return this.f4286d;
    }

    public PhotoViewPager v() {
        return this.f4287e;
    }

    public void w(List<IThumbViewInfo> list, int i2, Class<? extends e.l.q.c.t0.e.a> cls) {
        if (list != null) {
            int size = list.size();
            int i3 = 0;
            while (i3 < size) {
                this.f4286d.add(e.l.q.c.t0.e.a.t(cls, list.get(i3), i2 == i3, getIntent().getBooleanExtra("isSingleFling", false), getIntent().getBooleanExtra("isDrag", false), getIntent().getFloatExtra("sensitivity", 0.5f)));
                i3++;
            }
            return;
        }
        finish();
    }

    public int x() {
        return 0;
    }

    public void y() {
        if (this.a) {
            return;
        }
        v().setEnabled(false);
        this.a = true;
        int currentItem = this.f4287e.getCurrentItem();
        if (currentItem < this.b.size()) {
            e.l.q.c.t0.e.a aVar = this.f4286d.get(currentItem);
            TextView textView = this.f4288f;
            if (textView != null) {
                textView.setVisibility(8);
            } else {
                this.f4289g.setVisibility(8);
            }
            aVar.q(0);
            aVar.y(new c());
            return;
        }
        t();
    }
}
