package com.vector.view.pager.indicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import androidx.annotation.DrawableRes;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;
import com.vector.R;
import com.vector.view.pager.ViewPager2;

/* loaded from: classes3.dex */
public class TabPageIndicator extends HorizontalScrollView implements e.t.v.h.d.c {

    /* renamed from: m  reason: collision with root package name */
    private static final CharSequence f7996m = "";
    private Runnable a;
    private int b;

    /* renamed from: c  reason: collision with root package name */
    private int f7997c;

    /* renamed from: d  reason: collision with root package name */
    private float f7998d;
    @DrawableRes

    /* renamed from: e  reason: collision with root package name */
    private int f7999e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f8000f;

    /* renamed from: g  reason: collision with root package name */
    private final IcsLinearLayout f8001g;

    /* renamed from: h  reason: collision with root package name */
    private ViewPager f8002h;

    /* renamed from: i  reason: collision with root package name */
    private ViewPager.OnPageChangeListener f8003i;

    /* renamed from: j  reason: collision with root package name */
    private int f8004j;

    /* renamed from: k  reason: collision with root package name */
    private int f8005k;

    /* renamed from: l  reason: collision with root package name */
    private c f8006l;

    /* loaded from: classes3.dex */
    public class TabView extends AppCompatTextView {
        private int a;

        public TabView(Context context) {
            super(context, null, R.attr.vpiTabPageIndicatorStyle);
        }

        public int f() {
            return this.a;
        }

        @Override // androidx.appcompat.widget.AppCompatTextView, android.widget.TextView, android.view.View
        public void onMeasure(int i2, int i3) {
            super.onMeasure(i2, i3);
            if (TabPageIndicator.this.f8004j <= 0 || getMeasuredWidth() <= TabPageIndicator.this.f8004j) {
                return;
            }
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(TabPageIndicator.this.f8004j, 1073741824), i3);
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int currentItem = TabPageIndicator.this.f8002h.getCurrentItem();
            int f2 = ((TabView) view).f();
            TabPageIndicator.this.f8002h.setCurrentItem(f2);
            if (currentItem != f2 || TabPageIndicator.this.f8006l == null) {
                return;
            }
            TabPageIndicator.this.f8006l.a(f2);
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
            TabPageIndicator.this.smoothScrollTo(this.a.getLeft() - ((TabPageIndicator.this.getWidth() - this.a.getWidth()) / 2), 0);
            TabPageIndicator.this.a = null;
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a(int i2);
    }

    public TabPageIndicator(Context context) {
        this(context, null);
    }

    private void h(int i2, CharSequence charSequence, int i3) {
        TabView tabView = new TabView(getContext());
        tabView.a = i2;
        tabView.setFocusable(true);
        tabView.setOnClickListener(this.f8000f);
        tabView.setText(charSequence);
        tabView.setGravity(17);
        tabView.setTextColor(this.f7997c);
        tabView.setTextSize(1, this.f7998d);
        if (i3 != 0) {
            tabView.setCompoundDrawablesWithIntrinsicBounds(i3, 0, 0, 0);
        }
        this.f8001g.addView(tabView, new LinearLayout.LayoutParams(0, -1, 1.0f));
    }

    private void i(int i2) {
        View childAt = this.f8001g.getChildAt(i2);
        Runnable runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        b bVar = new b(childAt);
        this.a = bVar;
        post(bVar);
    }

    @Override // e.t.v.h.d.c
    public void a(ViewPager2 viewPager2, int i2) {
    }

    @Override // e.t.v.h.d.c
    public void b(ViewPager viewPager, int i2) {
        setViewPager(viewPager);
        setCurrentItem(i2);
    }

    @Override // e.t.v.h.d.c
    public void e() {
        this.f8001g.removeAllViews();
        PagerAdapter adapter = this.f8002h.getAdapter();
        e.t.v.h.d.b bVar = adapter instanceof e.t.v.h.d.b ? (e.t.v.h.d.b) adapter : null;
        int count = adapter.getCount();
        for (int i2 = 0; i2 < count; i2++) {
            CharSequence pageTitle = adapter.getPageTitle(i2);
            if (pageTitle == null) {
                pageTitle = f7996m;
            }
            h(i2, pageTitle, bVar != null ? this.f7999e : 0);
        }
        if (this.f8005k > count) {
            this.f8005k = count - 1;
        }
        setCurrentItem(this.f8005k);
        requestLayout();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.a;
        if (runnable != null) {
            post(runnable);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        boolean z = mode == 1073741824;
        setFillViewport(z);
        int childCount = this.f8001g.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            this.f8004j = -1;
        } else if (childCount > 2) {
            this.f8004j = (int) (View.MeasureSpec.getSize(i2) * 0.4f);
        } else {
            this.f8004j = View.MeasureSpec.getSize(i2) / 2;
        }
        int measuredWidth = getMeasuredWidth();
        super.onMeasure(i2, i3);
        int measuredWidth2 = getMeasuredWidth();
        if (!z || measuredWidth == measuredWidth2) {
            return;
        }
        setCurrentItem(this.f8005k);
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i2) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8003i;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrollStateChanged(i2);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i2, float f2, int i3) {
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8003i;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageScrolled(i2, f2, i3);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i2) {
        setCurrentItem(i2);
        ViewPager.OnPageChangeListener onPageChangeListener = this.f8003i;
        if (onPageChangeListener != null) {
            onPageChangeListener.onPageSelected(i2);
        }
    }

    @Override // e.t.v.h.d.c
    public void setCurrentItem(int i2) {
        ViewPager viewPager = this.f8002h;
        if (viewPager != null) {
            this.f8005k = i2;
            viewPager.setCurrentItem(i2);
            int childCount = this.f8001g.getChildCount();
            int i3 = 0;
            while (i3 < childCount) {
                View childAt = this.f8001g.getChildAt(i3);
                TabView tabView = (TabView) childAt;
                tabView.setTextColor(this.f7997c);
                boolean z = i3 == i2;
                childAt.setSelected(z);
                if (z) {
                    i(i2);
                    tabView.setTextColor(this.b);
                }
                i3++;
            }
            return;
        }
        throw new IllegalStateException("ViewPager has not been bound.");
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeCallback(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
    }

    @Override // e.t.v.h.d.c
    public void setOnPageChangeListener(ViewPager.OnPageChangeListener onPageChangeListener) {
        this.f8003i = onPageChangeListener;
    }

    public void setOnTabReselectedListener(c cVar) {
        this.f8006l = cVar;
    }

    @Override // e.t.v.h.d.c
    public void setViewPager(ViewPager viewPager) {
        ViewPager viewPager2 = this.f8002h;
        if (viewPager2 == viewPager) {
            return;
        }
        if (viewPager2 != null) {
            viewPager2.removeOnPageChangeListener(this);
        }
        if (viewPager.getAdapter() != null) {
            this.f8002h = viewPager;
            viewPager.addOnPageChangeListener(this);
            e();
            return;
        }
        throw new IllegalStateException("ViewPager does not have adapter instance.");
    }

    @Override // e.t.v.h.d.c
    public void setViewPager2(com.vector.view.pager.ViewPager2 viewPager2) {
    }

    public TabPageIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.b = -12276993;
        this.f7997c = -10066330;
        this.f7998d = 16.0f;
        this.f8000f = new a();
        setHorizontalScrollBarEnabled(false);
        IcsLinearLayout icsLinearLayout = new IcsLinearLayout(context, R.attr.vpiTabPageIndicatorStyle);
        this.f8001g = icsLinearLayout;
        addView(icsLinearLayout, new ViewGroup.LayoutParams(-2, -1));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.tabPagerIndicator);
        this.b = obtainStyledAttributes.getInteger(R.styleable.tabPagerIndicator_selectedTextColor, -12276993);
        this.f7997c = obtainStyledAttributes.getInteger(R.styleable.tabPagerIndicator_normalTextColor, -10066330);
        this.f7998d = obtainStyledAttributes.getInteger(R.styleable.tabPagerIndicator_tabTextSize, 16);
    }
}
