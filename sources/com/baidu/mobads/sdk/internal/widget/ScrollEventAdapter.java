package com.baidu.mobads.sdk.internal.widget;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.widget.ViewPager2;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ScrollEventAdapter extends RecyclerView.OnScrollListener {
    private static final int a = 0;
    private static final int b = 1;

    /* renamed from: c */
    private static final int f1638c = 2;

    /* renamed from: d */
    private static final int f1639d = 3;

    /* renamed from: e */
    private static final int f1640e = 4;

    /* renamed from: f */
    private static final int f1641f = -1;

    /* renamed from: g */
    private ViewPager2.OnPageChangeCallback f1642g;
    @NonNull

    /* renamed from: h */
    private final ViewPager2 f1643h;
    @NonNull

    /* renamed from: i */
    private final RecyclerView f1644i;
    @NonNull

    /* renamed from: j */
    private final LinearLayoutManager f1645j;

    /* renamed from: k */
    private int f1646k;

    /* renamed from: l */
    private int f1647l;

    /* renamed from: m */
    private ScrollEventValues f1648m;
    private int n;
    private int o;
    private boolean p;
    private boolean q;
    private boolean r;
    private boolean s;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface AdapterState {
    }

    /* loaded from: classes.dex */
    public static final class ScrollEventValues {
        public int a;
        public float b;

        /* renamed from: c */
        public int f1649c;

        public void a() {
            this.a = -1;
            this.b = 0.0f;
            this.f1649c = 0;
        }
    }

    public ScrollEventAdapter(@NonNull ViewPager2 viewPager2) {
        this.f1643h = viewPager2;
        RecyclerView recyclerView = viewPager2.f1657j;
        this.f1644i = recyclerView;
        this.f1645j = (LinearLayoutManager) recyclerView.getLayoutManager();
        this.f1648m = new ScrollEventValues();
        i();
    }

    private void a(boolean z) {
        this.s = z;
        this.f1646k = z ? 4 : 1;
        int i2 = this.o;
        if (i2 != -1) {
            this.n = i2;
            this.o = -1;
        } else if (this.n == -1) {
            this.n = l();
        }
        a(1);
    }

    private void i() {
        this.f1646k = 0;
        this.f1647l = 0;
        this.f1648m.a();
        this.n = -1;
        this.o = -1;
        this.p = false;
        this.q = false;
        this.s = false;
        this.r = false;
    }

    private void j() {
        int top;
        ScrollEventValues scrollEventValues = this.f1648m;
        int findFirstVisibleItemPosition = this.f1645j.findFirstVisibleItemPosition();
        scrollEventValues.a = findFirstVisibleItemPosition;
        if (findFirstVisibleItemPosition == -1) {
            scrollEventValues.a();
            return;
        }
        View findViewByPosition = this.f1645j.findViewByPosition(findFirstVisibleItemPosition);
        if (findViewByPosition == null) {
            scrollEventValues.a();
            return;
        }
        int leftDecorationWidth = this.f1645j.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f1645j.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f1645j.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f1645j.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = findViewByPosition.getWidth() + leftDecorationWidth + rightDecorationWidth;
        if (this.f1645j.getOrientation() == 0) {
            top = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f1644i.getPaddingLeft();
            if (this.f1643h.c()) {
                top = -top;
            }
            height = width;
        } else {
            top = (findViewByPosition.getTop() - topDecorationHeight) - this.f1644i.getPaddingTop();
        }
        int i2 = -top;
        scrollEventValues.f1649c = i2;
        if (i2 < 0) {
            if (new AnimateLayoutChangeDetector(this.f1645j).a()) {
                throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
            }
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", Integer.valueOf(scrollEventValues.f1649c)));
        }
        scrollEventValues.b = height == 0 ? 0.0f : i2 / height;
    }

    private boolean k() {
        int i2 = this.f1646k;
        return i2 == 1 || i2 == 4;
    }

    private int l() {
        return this.f1645j.findFirstVisibleItemPosition();
    }

    public void b() {
        this.f1646k = 4;
        a(true);
    }

    public void c() {
        if (!f() || this.s) {
            this.s = false;
            j();
            ScrollEventValues scrollEventValues = this.f1648m;
            if (scrollEventValues.f1649c == 0) {
                int i2 = scrollEventValues.a;
                if (i2 != this.n) {
                    b(i2);
                }
                a(0);
                i();
                return;
            }
            a(2);
        }
    }

    public int d() {
        return this.f1647l;
    }

    public boolean e() {
        return this.f1647l == 0;
    }

    public boolean f() {
        return this.f1647l == 1;
    }

    public boolean g() {
        return this.s;
    }

    public double h() {
        j();
        ScrollEventValues scrollEventValues = this.f1648m;
        return scrollEventValues.a + scrollEventValues.b;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i2) {
        boolean z = true;
        if ((this.f1646k != 1 || this.f1647l != 1) && i2 == 1) {
            a(false);
        } else if (k() && i2 == 2) {
            if (this.q) {
                a(2);
                this.p = true;
            }
        } else {
            if (k() && i2 == 0) {
                j();
                if (!this.q) {
                    int i3 = this.f1648m.a;
                    if (i3 != -1) {
                        a(i3, 0.0f, 0);
                    }
                } else {
                    ScrollEventValues scrollEventValues = this.f1648m;
                    if (scrollEventValues.f1649c == 0) {
                        int i4 = this.n;
                        int i5 = scrollEventValues.a;
                        if (i4 != i5) {
                            b(i5);
                        }
                    } else {
                        z = false;
                    }
                }
                if (z) {
                    a(0);
                    i();
                }
            }
            if (this.f1646k == 2 && i2 == 0 && this.r) {
                j();
                ScrollEventValues scrollEventValues2 = this.f1648m;
                if (scrollEventValues2.f1649c == 0) {
                    int i6 = this.o;
                    int i7 = scrollEventValues2.a;
                    if (i6 != i7) {
                        if (i7 == -1) {
                            i7 = 0;
                        }
                        b(i7);
                    }
                    a(0);
                    i();
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x001d, code lost:
        if ((r5 < 0) == r3.f1643h.c()) goto L36;
     */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0025  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0039  */
    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onScrolled(@androidx.annotation.NonNull androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.q = r4
            r3.j()
            boolean r0 = r3.p
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L3d
            r3.p = r2
            if (r6 > 0) goto L22
            if (r6 != 0) goto L20
            if (r5 >= 0) goto L16
            r5 = 1
            goto L17
        L16:
            r5 = 0
        L17:
            com.baidu.mobads.sdk.internal.widget.ViewPager2 r6 = r3.f1643h
            boolean r6 = r6.c()
            if (r5 != r6) goto L20
            goto L22
        L20:
            r5 = 0
            goto L23
        L22:
            r5 = 1
        L23:
            if (r5 == 0) goto L2f
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f1648m
            int r6 = r5.f1649c
            if (r6 == 0) goto L2f
            int r5 = r5.a
            int r5 = r5 + r4
            goto L33
        L2f:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f1648m
            int r5 = r5.a
        L33:
            r3.o = r5
            int r6 = r3.n
            if (r6 == r5) goto L4b
            r3.b(r5)
            goto L4b
        L3d:
            int r5 = r3.f1646k
            if (r5 != 0) goto L4b
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f1648m
            int r5 = r5.a
            if (r5 != r1) goto L48
            r5 = 0
        L48:
            r3.b(r5)
        L4b:
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f1648m
            int r6 = r5.a
            if (r6 != r1) goto L52
            r6 = 0
        L52:
            float r0 = r5.b
            int r5 = r5.f1649c
            r3.a(r6, r0, r5)
            com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter$ScrollEventValues r5 = r3.f1648m
            int r6 = r5.a
            int r0 = r3.o
            if (r6 == r0) goto L63
            if (r0 != r1) goto L71
        L63:
            int r5 = r5.f1649c
            if (r5 != 0) goto L71
            int r5 = r3.f1647l
            if (r5 == r4) goto L71
            r3.a(r2)
            r3.i()
        L71:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.widget.ScrollEventAdapter.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }

    private void b(int i2) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1642g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageSelected(i2);
        }
    }

    public void a() {
        this.r = true;
    }

    public void a(int i2, boolean z) {
        this.f1646k = z ? 2 : 3;
        this.s = false;
        boolean z2 = this.o != i2;
        this.o = i2;
        a(2);
        if (z2) {
            b(i2);
        }
    }

    public void a(ViewPager2.OnPageChangeCallback onPageChangeCallback) {
        this.f1642g = onPageChangeCallback;
    }

    private void a(int i2) {
        if ((this.f1646k == 3 && this.f1647l == 0) || this.f1647l == i2) {
            return;
        }
        this.f1647l = i2;
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1642g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrollStateChanged(i2);
        }
    }

    private void a(int i2, float f2, int i3) {
        ViewPager2.OnPageChangeCallback onPageChangeCallback = this.f1642g;
        if (onPageChangeCallback != null) {
            onPageChangeCallback.onPageScrolled(i2, f2, i3);
        }
    }
}
