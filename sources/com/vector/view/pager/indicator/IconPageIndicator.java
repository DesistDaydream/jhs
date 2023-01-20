package com.vector.view.pager.indicator;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import androidx.annotation.Dimension;
import androidx.annotation.DrawableRes;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.vector.R;
import com.vector.view.pager.ViewPager2;
import e.t.u.p;

/* loaded from: classes3.dex */
public class IconPageIndicator extends HorizontalScrollView implements e.t.v.h.d.c {
    private final IcsLinearLayout a;
    private ViewPager b;

    /* renamed from: c  reason: collision with root package name */
    private ViewPager2 f7985c;

    /* renamed from: d  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f7986d;

    /* renamed from: e  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f7987e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f7988f;

    /* renamed from: g  reason: collision with root package name */
    private int f7989g;

    /* renamed from: h  reason: collision with root package name */
    private int f7990h;

    /* renamed from: i  reason: collision with root package name */
    private int f7991i;

    /* renamed from: j  reason: collision with root package name */
    private ViewPager2.OnPageChangeCallback f7992j;
    @DrawableRes

    /* renamed from: k  reason: collision with root package name */
    private int f7993k;

    /* loaded from: classes3.dex */
    public class a extends ViewPager2.OnPageChangeCallback {
        public a() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrollStateChanged(int i2) {
            if (IconPageIndicator.this.f7987e != null) {
                IconPageIndicator.this.f7987e.onPageScrollStateChanged(i2);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageScrolled(int i2, float f2, int i3) {
            if (IconPageIndicator.this.f7987e != null) {
                IconPageIndicator.this.f7987e.onPageScrolled(i2, f2, i3);
            }
        }

        @Override // androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
        public void onPageSelected(int i2) {
            e.t.v.h.d.b bVar = (e.t.v.h.d.b) IconPageIndicator.this.f7985c.getAdapter();
            if (bVar.isPagerLoop()) {
                i2 %= bVar.getRealCount();
            }
            IconPageIndicator.this.setCurrentItem(i2);
            if (IconPageIndicator.this.f7987e != null) {
                IconPageIndicator.this.f7987e.onPageSelected(i2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            IconPageIndicator.this.smoothScrollTo(this.a.getLeft() - ((IconPageIndicator.this.getWidth() - this.a.getWidth()) / 2), 0);
            IconPageIndicator.this.f7988f = null;
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        @Dimension(unit = 0)
        private float a;
        @Dimension(unit = 0)
        private int b;
        @DrawableRes

        /* renamed from: c  reason: collision with root package name */
        private int f7994c;

        /* loaded from: classes3.dex */
        public static class a {
            @Dimension(unit = 0)
            private float a;
            @Dimension(unit = 0)
            private int b;
            @DrawableRes

            /* renamed from: c  reason: collision with root package name */
            private int f7995c;

            private a() {
            }

            public static a b() {
                return new a();
            }

            public c a() {
                c cVar = new c(null);
                cVar.a = this.a;
                cVar.f7994c = this.f7995c;
                cVar.b = this.b;
                return cVar;
            }

            public a c(@DrawableRes int i2) {
                this.f7995c = i2;
                return this;
            }

            public a d(@Dimension(unit = 0) int i2) {
                this.b = i2;
                return this;
            }

            public a e(@Dimension(unit = 0) float f2) {
                this.a = f2;
                return this;
            }

            public a f(@Dimension(unit = 0) int i2) {
                this.a = i2;
                return this;
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }

        public int d() {
            return this.f7994c;
        }

        public int e() {
            return this.b;
        }

        public float f() {
            return this.a;
        }

        private c() {
        }
    }

    public IconPageIndicator(Context context) {
        this(context, null);
    }

    private void g(int i2) {
        View childAt = this.a.getChildAt(i2);
        Runnable runnable = this.f7988f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        b bVar = new b(childAt);
        this.f7988f = bVar;
        post(bVar);
    }

    @Override // e.t.v.h.d.c
    public void a(com.vector.view.pager.ViewPager2 viewPager2, int i2) {
        setViewPager2(viewPager2);
        setCurrentItem(i2);
    }

    @Override // e.t.v.h.d.c
    public void b(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    @Override // e.t.v.h.d.c
    public void e() {
        e.t.v.h.d.b bVar;
        this.a.removeAllViews();
        ViewPager viewPager = this.b;
        if (viewPager != null) {
            bVar = (e.t.v.h.d.b) viewPager.getAdapter();
        } else {
            bVar = (e.t.v.h.d.b) this.f7985c.getAdapter();
        }
        int realCount = bVar.isPagerLoop() ? bVar.getRealCount() : bVar.getPageCount();
        for (int i2 = 0; i2 < realCount; i2++) {
            ImageView imageView = new ImageView(getContext(), null, R.attr.vpiIconPageIndicatorStyle);
            imageView.setImageResource(this.f7993k);
            int i3 = this.f7990h;
            if (i3 > 0) {
                imageView.setPadding(i3, 0, i3, 0);
            }
            int i4 = this.f7991i;
            if (i4 > 0) {
                this.a.addView(imageView, p.l(i4, i4));
            } else {
                this.a.addView(imageView);
            }
        }
        if (this.f7989g > realCount) {
            this.f7989g = realCount - 1;
        }
        setCurrentItem(this.f7989g);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f7988f;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f7988f;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f7986d;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f7986d;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        e.t.v.h.d.b bVar = (e.t.v.h.d.b) this.b.getAdapter();
        if (bVar.isPagerLoop()) {
            i2 %= bVar.getRealCount();
        }
        setCurrentItem(i2);
        ViewPager.OnPageChangeListener onPageChangeListener = this.f7986d;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
    }

    @Override // e.t.v.h.d.c
    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.b;
        if (viewPager == null && this.f7985c == null) {
            throw new IllegalStateException("ViewPager has not been bound.");
        }
        this.f7989g = i2;
        if (viewPager != null && !((e.t.v.h.d.b) viewPager.getAdapter()).isPagerLoop()) {
            this.b.setCurrentItem(i2);
        }
        com.vector.view.pager.ViewPager2 viewPager2 = this.f7985c;
        if (viewPager2 != null && !((e.t.v.h.d.b) viewPager2.getAdapter()).isPagerLoop()) {
            this.f7985c.setCurrentItem(i2);
        }
        int childCount = this.a.getChildCount();
        int i3 = 0;
        while (i3 < childCount) {
            View childAt = this.a.getChildAt(i3);
            boolean z = i3 == i2;
            childAt.setSelected(z);
            childAt.requestLayout();
            if (z) {
                g(i2);
            }
            i3++;
        }
    }

    public void setIndicatorSize(int i2) {
        this.f7991i = i2;
    }

    public void setIndicatorSpace(int i2) {
        this.f7990h = i2;
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f7987e = onPageChangeCallback;
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f7986d = onPageChangeListener;
    }

    public void setResId(@DrawableRes int i2) {
        this.f7993k = i2;
    }

    @Override // e.t.v.h.d.c
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.b;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
        }
        if (viewPager.getAdapter() != null) {
            this.b = viewPager;
            viewPager.addOnPageChangeListener(this);
            e();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    @Override // e.t.v.h.d.c
    public void setViewPager2(com.vector.view.pager.ViewPager2 viewPager2) {
        com.vector.view.pager.ViewPager2 viewPager22 = this.f7985c;
        if (viewPager22 == viewPager2) {
            return;
        }
        if (viewPager22 != null) {
            viewPager22.f(this.f7992j);
        }
        this.f7985c = viewPager2;
        viewPager2.d(this.f7992j);
        e();
    }

    public IconPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f7992j = new a();
        setHorizontalScrollBarEnabled(false);
        IcsLinearLayout icsLinearLayout = new IcsLinearLayout(context, R.attr.vpiIconPageIndicatorStyle);
        this.a = icsLinearLayout;
        addView(icsLinearLayout, new FrameLayout.LayoutParams(-2, -1, 17));
    }
}
