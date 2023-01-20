package com.jihuanshe.base.magicindicator.commonnavigator;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import com.jihuanshe.base.R;
import e.l.h.h.c;
import e.l.h.h.g.a.b;
import e.l.h.h.g.a.d;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class CommonNavigator extends FrameLayout implements e.l.h.h.f.a, c.a {
    private HorizontalScrollView a;
    private LinearLayout b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f3791c;

    /* renamed from: d  reason: collision with root package name */
    private e.l.h.h.g.a.c f3792d;

    /* renamed from: e  reason: collision with root package name */
    private e.l.h.h.g.a.a f3793e;

    /* renamed from: f  reason: collision with root package name */
    private c f3794f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f3795g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f3796h;

    /* renamed from: i  reason: collision with root package name */
    private float f3797i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f3798j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f3799k;

    /* renamed from: l  reason: collision with root package name */
    private int f3800l;

    /* renamed from: m  reason: collision with root package name */
    private int f3801m;
    private boolean n;
    private boolean o;
    private boolean p;
    private List<e.l.h.h.g.b.a> q;
    private DataSetObserver r;

    /* loaded from: classes2.dex */
    public class a extends DataSetObserver {
        public a() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            CommonNavigator.this.f3794f.m(CommonNavigator.this.f3793e.a());
            CommonNavigator.this.l();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
        }
    }

    public CommonNavigator(Context context) {
        super(context);
        this.f3797i = 0.5f;
        this.f3798j = true;
        this.f3799k = true;
        this.p = true;
        this.q = new ArrayList();
        this.r = new a();
        c cVar = new c();
        this.f3794f = cVar;
        cVar.k(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        View inflate;
        removeAllViews();
        if (this.f3795g) {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_pager_navigator_no_scroll, this);
        } else {
            inflate = LayoutInflater.from(getContext()).inflate(R.layout.layout_pager_navigator, this);
        }
        this.a = (HorizontalScrollView) inflate.findViewById(R.id.scroll_view);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.title_container);
        this.b = linearLayout;
        linearLayout.setPadding(this.f3801m, 0, this.f3800l, 0);
        LinearLayout linearLayout2 = (LinearLayout) inflate.findViewById(R.id.indicator_container);
        this.f3791c = linearLayout2;
        if (this.n) {
            linearLayout2.getParent().bringChildToFront(this.f3791c);
        }
        m();
    }

    private void m() {
        LinearLayout.LayoutParams layoutParams;
        int g2 = this.f3794f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            d d2 = this.f3793e.d(getContext(), i2);
            if (d2 instanceof View) {
                View view = (View) d2;
                if (this.f3795g) {
                    layoutParams = new LinearLayout.LayoutParams(0, -1);
                    layoutParams.weight = this.f3793e.e(getContext(), i2);
                } else {
                    layoutParams = new LinearLayout.LayoutParams(-2, -1);
                }
                this.b.addView(view, layoutParams);
            }
        }
        e.l.h.h.g.a.a aVar = this.f3793e;
        if (aVar != null) {
            e.l.h.h.g.a.c c2 = aVar.c(getContext());
            this.f3792d = c2;
            if (c2 instanceof View) {
                this.f3791c.addView((View) this.f3792d, new FrameLayout.LayoutParams(-1, -1));
            }
            onPageSelected(this.f3793e.b());
        }
    }

    private void u() {
        this.q.clear();
        int g2 = this.f3794f.g();
        for (int i2 = 0; i2 < g2; i2++) {
            e.l.h.h.g.b.a aVar = new e.l.h.h.g.b.a();
            View childAt = this.b.getChildAt(i2);
            if (childAt != null) {
                aVar.a = childAt.getLeft();
                aVar.b = childAt.getTop();
                aVar.f12118c = childAt.getRight();
                int bottom = childAt.getBottom();
                aVar.f12119d = bottom;
                if (childAt instanceof b) {
                    b bVar = (b) childAt;
                    aVar.f12120e = bVar.getContentLeft();
                    aVar.f12121f = bVar.getContentTop();
                    aVar.f12122g = bVar.getContentRight();
                    aVar.f12123h = bVar.getContentBottom();
                } else {
                    aVar.f12120e = aVar.a;
                    aVar.f12121f = aVar.b;
                    aVar.f12122g = aVar.f12118c;
                    aVar.f12123h = bottom;
                }
            }
            this.q.add(aVar);
        }
    }

    @Override // e.l.h.h.c.a
    public void a(int i2, int i3) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).a(i2, i3);
        } else if (!(childAt instanceof ViewGroup)) {
        } else {
            int i4 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                if (i4 >= viewGroup.getChildCount()) {
                    return;
                }
                View childAt2 = viewGroup.getChildAt(i4);
                if (childAt2 instanceof d) {
                    ((d) childAt2).a(i2, i3);
                }
                i4++;
            }
        }
    }

    @Override // e.l.h.h.c.a
    public void b(int i2, int i3, float f2, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).b(i2, i3, f2, z);
        }
    }

    @Override // e.l.h.h.c.a
    public void c(int i2, int i3) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).c(i2, i3);
        } else if (childAt instanceof ViewGroup) {
            int i4 = 0;
            while (true) {
                ViewGroup viewGroup = (ViewGroup) childAt;
                if (i4 >= viewGroup.getChildCount()) {
                    break;
                }
                View childAt2 = viewGroup.getChildAt(i4);
                if (childAt2 instanceof d) {
                    ((d) childAt2).c(i2, i3);
                }
                i4++;
            }
        }
        if (this.f3795g || this.f3799k || this.a == null || this.q.size() <= 0) {
            return;
        }
        e.l.h.h.g.b.a aVar = this.q.get(Math.min(this.q.size() - 1, i2));
        if (this.f3796h) {
            float d2 = aVar.d() - (this.a.getWidth() * this.f3797i);
            if (this.f3798j) {
                this.a.smoothScrollTo((int) d2, 0);
                return;
            } else {
                this.a.scrollTo((int) d2, 0);
                return;
            }
        }
        int scrollX = this.a.getScrollX();
        int i5 = aVar.a;
        if (scrollX > i5) {
            if (this.f3798j) {
                this.a.smoothScrollTo(i5, 0);
                return;
            } else {
                this.a.scrollTo(i5, 0);
                return;
            }
        }
        int scrollX2 = this.a.getScrollX() + getWidth();
        int i6 = aVar.f12118c;
        if (scrollX2 < i6) {
            if (this.f3798j) {
                this.a.smoothScrollTo(i6 - getWidth(), 0);
            } else {
                this.a.scrollTo(i6 - getWidth(), 0);
            }
        }
    }

    @Override // e.l.h.h.c.a
    public void d(int i2, int i3, float f2, boolean z) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return;
        }
        View childAt = linearLayout.getChildAt(i2);
        if (childAt instanceof d) {
            ((d) childAt).d(i2, i3, f2, z);
        }
    }

    @Override // e.l.h.h.f.a
    public void e() {
        e.l.h.h.g.a.a aVar = this.f3793e;
        if (aVar != null) {
            aVar.f();
        }
    }

    @Override // e.l.h.h.f.a
    public void f() {
        l();
    }

    @Override // e.l.h.h.f.a
    public void g() {
    }

    public e.l.h.h.g.a.a getAdapter() {
        return this.f3793e;
    }

    public int getLeftPadding() {
        return this.f3801m;
    }

    public e.l.h.h.g.a.c getPagerIndicator() {
        return this.f3792d;
    }

    public int getRightPadding() {
        return this.f3800l;
    }

    public float getScrollPivotX() {
        return this.f3797i;
    }

    public LinearLayout getTitleContainer() {
        return this.b;
    }

    public d k(int i2) {
        LinearLayout linearLayout = this.b;
        if (linearLayout == null) {
            return null;
        }
        return (d) linearLayout.getChildAt(i2);
    }

    public boolean n() {
        return this.f3795g;
    }

    public boolean o() {
        return this.f3796h;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        if (this.f3793e != null) {
            u();
            e.l.h.h.g.a.c cVar = this.f3792d;
            if (cVar != null) {
                cVar.a(this.q);
            }
            if (this.p && this.f3794f.f() == 0) {
                onPageSelected(this.f3794f.e());
                onPageScrolled(this.f3794f.e(), 0.0f, 0);
            }
        }
    }

    @Override // e.l.h.h.f.a
    public void onPageScrollStateChanged(int i2) {
        if (this.f3793e != null) {
            this.f3794f.h(i2);
            e.l.h.h.g.a.c cVar = this.f3792d;
            if (cVar != null) {
                cVar.onPageScrollStateChanged(i2);
            }
        }
    }

    @Override // e.l.h.h.f.a
    public void onPageScrolled(int i2, float f2, int i3) {
        if (this.f3793e != null) {
            this.f3794f.i(i2, f2, i3);
            e.l.h.h.g.a.c cVar = this.f3792d;
            if (cVar != null) {
                cVar.onPageScrolled(i2, f2, i3);
            }
            if (this.a == null || this.q.size() <= 0 || i2 < 0 || i2 >= this.q.size() || !this.f3799k) {
                return;
            }
            int min = Math.min(this.q.size() - 1, i2);
            int min2 = Math.min(this.q.size() - 1, i2 + 1);
            float d2 = this.q.get(min).d() - (this.a.getWidth() * this.f3797i);
            this.a.scrollTo((int) (d2 + (((this.q.get(min2).d() - (this.a.getWidth() * this.f3797i)) - d2) * f2)), 0);
        }
    }

    @Override // e.l.h.h.f.a
    public void onPageSelected(int i2) {
        if (this.f3793e != null) {
            this.f3794f.j(i2);
            e.l.h.h.g.a.c cVar = this.f3792d;
            if (cVar != null) {
                cVar.onPageSelected(i2);
            }
        }
    }

    public boolean p() {
        return this.f3799k;
    }

    public boolean q() {
        return this.n;
    }

    public boolean r() {
        return this.p;
    }

    public boolean s() {
        return this.o;
    }

    public void setAdapter(e.l.h.h.g.a.a aVar) {
        e.l.h.h.g.a.a aVar2 = this.f3793e;
        if (aVar2 == aVar) {
            return;
        }
        if (aVar2 != null) {
            aVar2.i(this.r);
        }
        this.f3793e = aVar;
        if (aVar != null) {
            aVar.h(this.r);
            this.f3794f.m(this.f3793e.a());
            if (this.b != null) {
                this.f3793e.f();
                return;
            }
            return;
        }
        this.f3794f.m(0);
        l();
    }

    public void setAdjustMode(boolean z) {
        this.f3795g = z;
    }

    public void setEnablePivotScroll(boolean z) {
        this.f3796h = z;
    }

    public void setFollowTouch(boolean z) {
        this.f3799k = z;
    }

    public void setIndicatorOnTop(boolean z) {
        this.n = z;
    }

    public void setLeftPadding(int i2) {
        this.f3801m = i2;
    }

    public void setReselectWhenLayout(boolean z) {
        this.p = z;
    }

    public void setRightPadding(int i2) {
        this.f3800l = i2;
    }

    public void setScrollPivotX(float f2) {
        this.f3797i = f2;
    }

    public void setSkimOver(boolean z) {
        this.o = z;
        this.f3794f.l(z);
    }

    public void setSmoothScroll(boolean z) {
        this.f3798j = z;
    }

    public boolean t() {
        return this.f3798j;
    }
}
