package com.jihuanshe.base.magicindicator.commonnavigator.titles.badge;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import e.l.h.h.g.a.b;
import e.l.h.h.g.a.d;
import e.l.h.h.g.c.b.a;

/* loaded from: classes2.dex */
public class BadgePagerTitleView extends FrameLayout implements b {
    private d a;
    private View b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f3858c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f3859d;

    /* renamed from: e  reason: collision with root package name */
    private a f3860e;

    /* renamed from: f  reason: collision with root package name */
    private a f3861f;

    public BadgePagerTitleView(Context context) {
        super(context);
        this.f3858c = true;
        this.f3859d = false;
    }

    @Override // e.l.h.h.g.a.d
    public void a(int i2, int i3) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.a(i2, i3);
        }
        View view = this.b;
        if (view == null || !this.f3859d) {
            return;
        }
        view.setVisibility(8);
    }

    @Override // e.l.h.h.g.a.d
    public void b(int i2, int i3, float f2, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.b(i2, i3, f2, z);
        }
    }

    @Override // e.l.h.h.g.a.d
    public void c(int i2, int i3) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.c(i2, i3);
        }
        View view = this.b;
        if (view != null) {
            view.setVisibility(0);
        }
        if (this.f3858c) {
            setBadgeView(null);
        }
    }

    @Override // e.l.h.h.g.a.d
    public void d(int i2, int i3, float f2, boolean z) {
        d dVar = this.a;
        if (dVar != null) {
            dVar.d(i2, i3, f2, z);
        }
    }

    public boolean e() {
        return this.f3858c;
    }

    public boolean f() {
        return this.f3859d;
    }

    public View getBadgeView() {
        return this.b;
    }

    @Override // e.l.h.h.g.a.b
    public int getContentBottom() {
        d dVar = this.a;
        if (dVar instanceof b) {
            return ((b) dVar).getContentBottom();
        }
        return getBottom();
    }

    @Override // e.l.h.h.g.a.b
    public int getContentLeft() {
        if (this.a instanceof b) {
            return getLeft() + ((b) this.a).getContentLeft();
        }
        return getLeft();
    }

    @Override // e.l.h.h.g.a.b
    public int getContentRight() {
        if (this.a instanceof b) {
            return getLeft() + ((b) this.a).getContentRight();
        }
        return getRight();
    }

    @Override // e.l.h.h.g.a.b
    public int getContentTop() {
        d dVar = this.a;
        if (dVar instanceof b) {
            return ((b) dVar).getContentTop();
        }
        return getTop();
    }

    public d getInnerPagerTitleView() {
        return this.a;
    }

    public a getXBadgeRule() {
        return this.f3860e;
    }

    public a getYBadgeRule() {
        return this.f3861f;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        super.onLayout(z, i2, i3, i4, i5);
        d dVar = this.a;
        if (!(dVar instanceof View) || this.b == null) {
            return;
        }
        int[] iArr = new int[14];
        View view = (View) dVar;
        iArr[0] = view.getLeft();
        iArr[1] = view.getTop();
        iArr[2] = view.getRight();
        iArr[3] = view.getBottom();
        d dVar2 = this.a;
        if (dVar2 instanceof b) {
            b bVar = (b) dVar2;
            iArr[4] = bVar.getContentLeft();
            iArr[5] = bVar.getContentTop();
            iArr[6] = bVar.getContentRight();
            iArr[7] = bVar.getContentBottom();
        } else {
            for (int i6 = 4; i6 < 8; i6++) {
                iArr[i6] = iArr[i6 - 4];
            }
        }
        iArr[8] = view.getWidth() / 2;
        iArr[9] = view.getHeight() / 2;
        iArr[10] = iArr[4] / 2;
        iArr[11] = iArr[5] / 2;
        iArr[12] = iArr[6] + ((iArr[2] - iArr[6]) / 2);
        iArr[13] = iArr[7] + ((iArr[3] - iArr[7]) / 2);
        a aVar = this.f3860e;
        if (aVar != null) {
            int b = iArr[aVar.a().ordinal()] + this.f3860e.b();
            View view2 = this.b;
            view2.offsetLeftAndRight(b - view2.getLeft());
        }
        a aVar2 = this.f3861f;
        if (aVar2 != null) {
            int b2 = iArr[aVar2.a().ordinal()] + this.f3861f.b();
            View view3 = this.b;
            view3.offsetTopAndBottom(b2 - view3.getTop());
        }
    }

    public void setAutoCancelBadge(boolean z) {
        this.f3858c = z;
    }

    public void setBadgeView(View view) {
        if (this.b == view) {
            return;
        }
        this.b = view;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setInnerPagerTitleView(d dVar) {
        if (this.a == dVar) {
            return;
        }
        this.a = dVar;
        removeAllViews();
        if (this.a instanceof View) {
            addView((View) this.a, new FrameLayout.LayoutParams(-1, -1));
        }
        if (this.b != null) {
            addView(this.b, new FrameLayout.LayoutParams(-2, -2));
        }
    }

    public void setUnSelectedBadgeGone(boolean z) {
        this.f3859d = z;
    }

    public void setXBadgeRule(a aVar) {
        this.f3860e = aVar;
    }

    public void setYBadgeRule(a aVar) {
        this.f3861f = aVar;
    }
}
