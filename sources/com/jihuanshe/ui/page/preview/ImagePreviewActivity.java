package com.jihuanshe.ui.page.preview;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager.widget.ViewPager;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.ext.AppbarKt;
import com.jihuanshe.ui.page.preview.ImagePreviewActivity;
import com.jihuanshe.ui.page.user.SellerDetailActivityCreator;
import com.jihuanshe.ui.widget.imagepreview.GPreviewBuilder;
import com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo;
import com.jihuanshe.ui.widget.imagepreview.wight.BezierBannerView;
import com.jihuanshe.ui.widget.imagepreview.wight.PhotoViewPager;
import com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView;
import com.vector.design.ui.activity.SimpleActivityEx;
import com.vector.ext.view.ViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.Res;
import com.vivo.push.PushClientConstants;
import e.l.k.c1;
import e.t.l.b0;
import e.t.u.m;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

/* loaded from: classes2.dex */
public final class ImagePreviewActivity extends SimpleActivityEx {

    /* renamed from: l */
    private boolean f4033l;
    @e

    /* renamed from: m */
    private List<? extends IThumbViewInfo> f4034m;
    private int n;
    @e
    private PhotoViewPager p;
    @e
    private TextView q;
    @e
    private BezierBannerView r;
    @e
    private ConstraintLayout s;
    @e
    private NImageView t;
    @e
    private TextView u;
    @e
    private GPreviewBuilder.IndicatorType v;
    private boolean x;
    @e
    private TextView y;
    @e
    private c1 z;
    @d

    /* renamed from: k */
    private final e.t.r.a.a f4032k = new e.t.r.a.a(0, 0, 3, null);
    @d
    private List<e.l.q.c.t0.e.a> o = new ArrayList();
    private boolean w = true;

    /* loaded from: classes2.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        public a() {
            ImagePreviewActivity.this = r1;
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            TextView textView = ImagePreviewActivity.this.q;
            if (textView != null) {
                textView.setText(ImagePreviewActivity.this.getString(R.string.string_count, new Object[]{Integer.valueOf(i2 + 1), Integer.valueOf(ImagePreviewActivity.this.f4034m.size())}));
            }
            ImagePreviewActivity.this.f0(i2);
            PhotoViewPager photoViewPager = ImagePreviewActivity.this.p;
            if (photoViewPager != null) {
                photoViewPager.setCurrentItem(ImagePreviewActivity.this.U(), true);
            }
            TextView textView2 = ImagePreviewActivity.this.u;
            if (textView2 != null) {
                textView2.setText(((IThumbViewInfo) ImagePreviewActivity.this.f4034m.get(i2)).getUserName());
            }
            NImageView nImageView = ImagePreviewActivity.this.t;
            if (nImageView != null) {
                nImageView.s(R.drawable.svg_default_avatar);
            }
            NImageView nImageView2 = ImagePreviewActivity.this.t;
            if (nImageView2 != null) {
                nImageView2.j(ImagePreviewActivity.this.X());
            }
            NImageView nImageView3 = ImagePreviewActivity.this.t;
            if (nImageView3 != null) {
                nImageView3.url(((IThumbViewInfo) ImagePreviewActivity.this.f4034m.get(i2)).getAvatar());
            }
            NImageView nImageView4 = ImagePreviewActivity.this.t;
            if (nImageView4 == null) {
                return;
            }
            nImageView4.e();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements ViewTreeObserver.OnGlobalLayoutListener {
        public b() {
            ImagePreviewActivity.this = r1;
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            IThumbViewInfo iThumbViewInfo;
            IThumbViewInfo iThumbViewInfo2;
            PhotoViewPager photoViewPager = ImagePreviewActivity.this.p;
            String str = null;
            (photoViewPager == null ? null : photoViewPager.getViewTreeObserver()).removeGlobalOnLayoutListener(this);
            ((e.l.q.c.t0.e.a) ImagePreviewActivity.this.o.get(ImagePreviewActivity.this.U())).x();
            List list = ImagePreviewActivity.this.f4034m;
            String avatar = (list == null || (iThumbViewInfo = (IThumbViewInfo) CollectionsKt___CollectionsKt.J2(list, ImagePreviewActivity.this.U())) == null) ? null : iThumbViewInfo.getAvatar();
            boolean z = false;
            if (avatar == null || avatar.length() == 0) {
                List list2 = ImagePreviewActivity.this.f4034m;
                if (list2 != null && (iThumbViewInfo2 = (IThumbViewInfo) CollectionsKt___CollectionsKt.J2(list2, ImagePreviewActivity.this.U())) != null) {
                    str = iThumbViewInfo2.getUserName();
                }
                if ((str == null || str.length() == 0) ? true : true) {
                    ViewKt.n(ImagePreviewActivity.this.s);
                    return;
                }
            }
            ViewKt.I(ImagePreviewActivity.this.s);
            TextView textView = ImagePreviewActivity.this.u;
            if (textView != null) {
                textView.setText(((IThumbViewInfo) ImagePreviewActivity.this.f4034m.get(ImagePreviewActivity.this.U())).getUserName());
            }
            NImageView nImageView = ImagePreviewActivity.this.t;
            if (nImageView != null) {
                nImageView.s(R.drawable.svg_default_avatar);
            }
            NImageView nImageView2 = ImagePreviewActivity.this.t;
            if (nImageView2 != null) {
                nImageView2.j(ImagePreviewActivity.this.X());
            }
            NImageView nImageView3 = ImagePreviewActivity.this.t;
            if (nImageView3 != null) {
                nImageView3.url(((IThumbViewInfo) ImagePreviewActivity.this.f4034m.get(ImagePreviewActivity.this.U())).getAvatar());
            }
            NImageView nImageView4 = ImagePreviewActivity.this.t;
            if (nImageView4 == null) {
                return;
            }
            nImageView4.e();
        }
    }

    private final void R() {
        finish();
        overridePendingTransition(0, 0);
    }

    public static final void S(ImagePreviewActivity imagePreviewActivity, View view) {
        SellerDetailActivityCreator.create(Integer.valueOf(Integer.parseInt(imagePreviewActivity.f4034m.get(imagePreviewActivity.U()).getUserId())), 0).start(imagePreviewActivity);
    }

    public static final void j0(ImagePreviewActivity imagePreviewActivity, SmoothImageView.Status status) {
        PhotoViewPager photoViewPager = imagePreviewActivity.p;
        if (photoViewPager != null) {
            photoViewPager.setEnabled(true);
        }
        imagePreviewActivity.R();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void H() {
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void I() {
    }

    @e
    public final c1 T() {
        return this.z;
    }

    public final int U() {
        return this.n;
    }

    @e
    public final List<e.l.q.c.t0.e.a> V() {
        return this.o;
    }

    @e
    public final TextView W() {
        return this.y;
    }

    @d
    public final e.t.r.a.a X() {
        return this.f4032k;
    }

    @e
    public final PhotoViewPager Y() {
        return this.p;
    }

    public final void Z(@e List<? extends IThumbViewInfo> list, int i2, @e Class<? extends e.l.q.c.t0.e.a> cls) {
        if (list != null) {
            int size = list.size();
            if (size <= 0) {
                return;
            }
            int i3 = 0;
            while (true) {
                int i4 = i3 + 1;
                this.o.add(e.l.q.c.t0.e.a.t(cls, list.get(i3), i2 == i3, getIntent().getBooleanExtra("isSingleFling", false), getIntent().getBooleanExtra("isDrag", false), getIntent().getFloatExtra("sensitivity", 0.5f)));
                if (i4 >= size) {
                    return;
                }
                i3 = i4;
            }
        } else {
            finish();
        }
    }

    public final boolean a0() {
        return this.f4033l;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    @SuppressLint({"StringFormatMatches"})
    public void d() {
        ViewTreeObserver viewTreeObserver;
        this.p.setAdapter(new PhotoPagerAdapter(getSupportFragmentManager(), this.o));
        this.p.setCurrentItem(this.n);
        PhotoViewPager photoViewPager = this.p;
        if (photoViewPager != null) {
            photoViewPager.setOffscreenPageLimit(3);
        }
        ConstraintLayout constraintLayout = this.s;
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new View.OnClickListener() { // from class: e.l.q.b.h.i
                {
                    ImagePreviewActivity.this = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ImagePreviewActivity.S(ImagePreviewActivity.this, view);
                }
            });
        }
        GPreviewBuilder.IndicatorType indicatorType = this.v;
        if (indicatorType == GPreviewBuilder.IndicatorType.Dot) {
            BezierBannerView bezierBannerView = this.r;
            if (bezierBannerView != null) {
                bezierBannerView.setVisibility(0);
            }
            BezierBannerView bezierBannerView2 = this.r;
            if (bezierBannerView2 != null) {
                c1 c1Var = this.z;
                bezierBannerView2.c(c1Var == null ? null : c1Var.f12387g);
            }
        } else if (indicatorType == GPreviewBuilder.IndicatorType.Number) {
            TextView textView = this.q;
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = this.q;
            if (textView2 != null) {
                textView2.setText(getString(R.string.string_count, new Object[]{Integer.valueOf(this.n + 1), Integer.valueOf(this.f4034m.size())}));
            }
            PhotoViewPager photoViewPager2 = this.p;
            if (photoViewPager2 != null) {
                photoViewPager2.addOnPageChangeListener(new a());
            }
        } else {
            ViewKt.n(this.q);
        }
        if (this.o.size() == 1 && !this.w) {
            BezierBannerView bezierBannerView3 = this.r;
            if (bezierBannerView3 != null) {
                bezierBannerView3.setVisibility(8);
            }
            TextView textView3 = this.q;
            if (textView3 != null) {
                textView3.setVisibility(8);
            }
        }
        PhotoViewPager photoViewPager3 = this.p;
        if (photoViewPager3 == null || (viewTreeObserver = photoViewPager3.getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new b());
    }

    public final void d0(@e c1 c1Var) {
        this.z = c1Var;
    }

    public final int e0() {
        return 0;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void f() {
        this.f4034m = getIntent().getParcelableArrayListExtra("imagePaths");
        this.n = getIntent().getIntExtra("position", -1);
        this.v = (GPreviewBuilder.IndicatorType) getIntent().getSerializableExtra("type");
        this.w = getIntent().getBooleanExtra("isShow", true);
        int intExtra = getIntent().getIntExtra("duration", 300);
        boolean booleanExtra = getIntent().getBooleanExtra("isScale", false);
        this.x = getIntent().getBooleanExtra("isSelect", false);
        SmoothImageView.setIsScale(booleanExtra);
        try {
            SmoothImageView.setDuration(intExtra);
            Z(this.f4034m, this.n, (Class) getIntent().getSerializableExtra(PushClientConstants.TAG_CLASS_NAME));
        } catch (Exception unused) {
            Z(this.f4034m, this.n, e.l.q.c.t0.e.a.class);
        }
    }

    public final void f0(int i2) {
        this.n = i2;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, android.app.Activity
    public void finish() {
        e.l.q.c.t0.e.a.f14242m = null;
        super.finish();
    }

    public final void g0(@e TextView textView) {
        this.y = textView;
    }

    public final void h0(boolean z) {
        this.f4033l = z;
    }

    public final void i0() {
        if (this.f4033l) {
            return;
        }
        PhotoViewPager photoViewPager = this.p;
        if (photoViewPager != null) {
            photoViewPager.setEnabled(false);
        }
        this.f4033l = true;
        PhotoViewPager photoViewPager2 = this.p;
        Integer valueOf = photoViewPager2 == null ? null : Integer.valueOf(photoViewPager2.getCurrentItem());
        if (valueOf != null) {
            if (valueOf.intValue() < this.f4034m.size()) {
                e.l.q.c.t0.e.a aVar = this.o.get(valueOf.intValue());
                TextView textView = this.q;
                if (textView != null) {
                    textView.setVisibility(8);
                } else {
                    BezierBannerView bezierBannerView = this.r;
                    if (bezierBannerView != null) {
                        bezierBannerView.setVisibility(8);
                    }
                }
                aVar.q(0);
                aVar.y(new SmoothImageView.j() { // from class: e.l.q.b.h.j
                    {
                        ImagePreviewActivity.this = this;
                    }

                    @Override // com.jihuanshe.ui.widget.imagepreview.wight.SmoothImageView.j
                    public final void a(SmoothImageView.Status status) {
                        ImagePreviewActivity.j0(ImagePreviewActivity.this, status);
                    }
                });
                return;
            }
            R();
        }
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        b0.a(getWindow(), Res.k(R.color.black_111111));
        e.t.l.d.d(this, new m.b(R.color.black));
        w().setBackgroundResource(R.color.black_111111);
        AppBarKt.d(w(), this, 0, null, 6, null);
        TextView g2 = w().getMid().g(ImagePreviewActivity$flowOfAppBar$1.INSTANCE);
        this.y = g2;
        g2.setTextColor(Res.k(R.color.white));
        if (this.x) {
            AppbarKt.f(w(), 0, new ImagePreviewActivity$flowOfAppBar$2(this), 1, null);
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        this.f4033l = false;
        i0();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        List L5;
        e.l.q.c.t0.b.a().b().a(this);
        PhotoViewPager photoViewPager = this.p;
        if (photoViewPager != null) {
            photoViewPager.setAdapter(null);
        }
        PhotoViewPager photoViewPager2 = this.p;
        if (photoViewPager2 != null) {
            photoViewPager2.clearOnPageChangeListeners();
        }
        PhotoViewPager photoViewPager3 = this.p;
        if (photoViewPager3 != null) {
            photoViewPager3.removeAllViews();
        }
        this.o.clear();
        List<? extends IThumbViewInfo> list = this.f4034m;
        if (list != null && (L5 = CollectionsKt___CollectionsKt.L5(list)) != null) {
            L5.clear();
        }
        super.onDestroy();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @d
    public ViewDataBinding q() {
        c1 d2 = c1.d(getLayoutInflater());
        this.z = d2;
        this.p = d2.f12387g;
        this.q = this.z.f12384d;
        this.r = this.z.b;
        this.s = this.z.f12383c;
        this.t = this.z.a;
        this.u = this.z.f12385e;
        return this.z;
    }
}
