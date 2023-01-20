package com.vector.util;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.umeng.analytics.pro.am;
import h.k2.v.f0;
import h.k2.v.u;
import java.lang.reflect.Field;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 ,2\u00020\u0001:\u0001,B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tB\u000f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fB\u001f\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\rJ\u0006\u0010\u0015\u001a\u00020\u0016J \u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J6\u0010\u001d\u001a\u00020\u00162\n\u0010\u001e\u001a\u00060\u001fR\u00020\u000b2\u0006\u0010 \u001a\u00020\u00062\u0006\u0010!\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020\u00062\b\u0010#\u001a\u0004\u0018\u00010\u000fH\u0002J,\u0010$\u001a\u00020\u00162\n\u0010\u001e\u001a\u00060\u001fR\u00020\u000b2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0016J\u000e\u0010)\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010*\u001a\u00020\u00162\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010+\u001a\u00020\u00162\u0006\u0010\u0012\u001a\u00020\u0006R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/vector/util/ScrollLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "view", "Landroidx/recyclerview/widget/RecyclerView;", "(Landroidx/recyclerview/widget/RecyclerView;)V", "(Landroidx/recyclerview/widget/RecyclerView;IZ)V", "childDimensions", "", "childSize", "hasChildSize", "overScrollMode", "tmpRect", "Landroid/graphics/Rect;", "clearChildSize", "", "initChildDimensions", "width", "height", "vertical", "logMeasureWarning", "child", "measureChild", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "position", "widthSize", "heightSize", "dimensions", "onMeasure", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "widthSpec", "heightSpec", "setChildSize", "setOrientation", "setOverScrollMode", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ScrollLinearLayoutManager extends LinearLayoutManager {
    @d

    /* renamed from: g */
    public static final a f7909g = new a(null);

    /* renamed from: h */
    private static boolean f7910h = true;
    @e

    /* renamed from: i */
    private static Field f7911i = null;

    /* renamed from: j */
    private static final int f7912j = 0;

    /* renamed from: k */
    private static final int f7913k = 1;

    /* renamed from: l */
    private static final int f7914l = 100;
    @d
    private final int[] a;
    @e
    private final RecyclerView b;

    /* renamed from: c */
    private int f7915c;

    /* renamed from: d */
    private boolean f7916d;

    /* renamed from: e */
    private int f7917e;
    @d

    /* renamed from: f */
    private final Rect f7918f;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0006\u0010\u000f\u001a\u00020\u0004J\b\u0010\u0010\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/vector/util/ScrollLinearLayoutManager$Companion;", "", "()V", "CHILD_HEIGHT", "", "CHILD_WIDTH", "DEFAULT_CHILD_SIZE", "canMakeInsetsDirty", "", "insetsDirtyField", "Ljava/lang/reflect/Field;", "makeInsetsDirty", "", am.ax, "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "makeUnspecifiedSpec", "onMakeInsertDirtyFailed", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        public final void b(RecyclerView.LayoutParams layoutParams) {
            if (ScrollLinearLayoutManager.f7910h) {
                try {
                    if (ScrollLinearLayoutManager.f7911i == null) {
                        ScrollLinearLayoutManager.f7911i = RecyclerView.LayoutParams.class.getDeclaredField("mInsetsDirty");
                        ScrollLinearLayoutManager.f7911i.setAccessible(true);
                    }
                    Field field = ScrollLinearLayoutManager.f7911i;
                    if (field == null) {
                        return;
                    }
                    field.set(layoutParams, Boolean.TRUE);
                } catch (IllegalAccessException unused) {
                    d();
                } catch (NoSuchFieldException unused2) {
                    d();
                }
            }
        }

        private final void d() {
            ScrollLinearLayoutManager.f7910h = false;
        }

        public final int c() {
            return View.MeasureSpec.makeMeasureSpec(0, 0);
        }
    }

    public ScrollLinearLayoutManager(@e Context context) {
        super(context);
        this.a = new int[2];
        this.f7915c = 100;
        this.f7918f = new Rect();
        this.b = null;
    }

    private final void p(int i2, int i3, boolean z) {
        if (this.a[0] == 0) {
            int[] iArr = this.a;
            if (iArr[1] != 0) {
                return;
            }
            if (z) {
                iArr[0] = i2;
                iArr[1] = this.f7915c;
                return;
            }
            iArr[0] = this.f7915c;
            iArr[1] = i3;
        }
    }

    private final void q(int i2) {
    }

    private final void r(RecyclerView.Recycler recycler, int i2, int i3, int i4, int[] iArr) {
        try {
            View viewForPosition = recycler.getViewForPosition(i2);
            ViewGroup.LayoutParams layoutParams = viewForPosition.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            int paddingLeft = getPaddingLeft() + getPaddingRight();
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int i5 = ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
            int i6 = ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin;
            a aVar = f7909g;
            aVar.b(layoutParams2);
            calculateItemDecorationsForChild(viewForPosition, this.f7918f);
            viewForPosition.measure(RecyclerView.LayoutManager.getChildMeasureSpec(i3, paddingLeft + i5 + getRightDecorationWidth(viewForPosition) + getLeftDecorationWidth(viewForPosition), ((ViewGroup.MarginLayoutParams) layoutParams2).width, canScrollHorizontally()), RecyclerView.LayoutManager.getChildMeasureSpec(i4, paddingTop + i6 + getTopDecorationHeight(viewForPosition) + getBottomDecorationHeight(viewForPosition), ((ViewGroup.MarginLayoutParams) layoutParams2).height, canScrollVertically()));
            iArr[0] = getDecoratedMeasuredWidth(viewForPosition) + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
            iArr[1] = getDecoratedMeasuredHeight(viewForPosition) + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
            aVar.b(layoutParams2);
            recycler.recycleView(viewForPosition);
        } catch (IndexOutOfBoundsException unused) {
        }
    }

    public final void o() {
        this.f7916d = false;
        s(100);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@d RecyclerView.Recycler recycler, @d RecyclerView.State state, int i2, int i3) {
        boolean z;
        int i4;
        int i5;
        int paddingLeft;
        int paddingTop;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        char c2 = 1;
        boolean z2 = mode != 0;
        boolean z3 = mode2 != 0;
        boolean z4 = mode == 1073741824;
        boolean z5 = mode2 == 1073741824;
        int c3 = f7909g.c();
        if (z4 && z5) {
            super.onMeasure(recycler, state, i2, i3);
            return;
        }
        boolean z6 = getOrientation() == 1;
        p(size, size2, z6);
        recycler.clear();
        int itemCount = state.getItemCount();
        int itemCount2 = getItemCount();
        if (itemCount2 > 0) {
            int i11 = 0;
            i5 = 0;
            int i12 = 0;
            while (true) {
                int i13 = i11 + 1;
                if (z6) {
                    if (this.f7916d) {
                        i6 = i13;
                        i7 = itemCount2;
                        i8 = itemCount;
                        z = z6;
                        i10 = i11;
                    } else if (i11 < itemCount) {
                        i6 = i13;
                        i7 = itemCount2;
                        i8 = itemCount;
                        z = z6;
                        r(recycler, i11, size, c3, this.a);
                        i10 = i11;
                    } else {
                        i6 = i13;
                        i7 = itemCount2;
                        i8 = itemCount;
                        z = z6;
                        i10 = i11;
                        q(i10);
                    }
                    i4 = i12 + this.a[c2];
                    if (i10 == 0) {
                        i5 = this.a[0];
                    }
                    if (z3 && i4 >= size2) {
                        break;
                    }
                    i12 = i4;
                } else {
                    i6 = i13;
                    i7 = itemCount2;
                    i8 = itemCount;
                    z = z6;
                    int i14 = i11;
                    if (this.f7916d) {
                        i9 = i14;
                    } else if (i14 < i8) {
                        i8 = i8;
                        i9 = i14;
                        r(recycler, i14, c3, size2, this.a);
                    } else {
                        i8 = i8;
                        i9 = i14;
                        q(i9);
                    }
                    int i15 = i5 + this.a[0];
                    if (i9 == 0) {
                        i12 = this.a[1];
                    }
                    if (z2 && i15 >= size) {
                        i5 = i15;
                        break;
                    }
                    i5 = i15;
                }
                int i16 = i6;
                int i17 = i7;
                if (i16 >= i17) {
                    break;
                }
                i11 = i16;
                itemCount2 = i17;
                itemCount = i8;
                z6 = z;
                c2 = 1;
            }
            i4 = i12;
        } else {
            z = z6;
            i4 = 0;
            i5 = 0;
        }
        if (z4) {
            paddingLeft = size;
        } else {
            paddingLeft = i5 + getPaddingLeft() + getPaddingRight();
            if (z2) {
                paddingLeft = Math.min(paddingLeft, size);
            }
        }
        if (z5) {
            paddingTop = size2;
        } else {
            paddingTop = i4 + getPaddingTop() + getPaddingBottom();
            if (z3) {
                paddingTop = Math.min(paddingTop, size2);
            }
        }
        setMeasuredDimension(paddingLeft, paddingTop);
        RecyclerView recyclerView = this.b;
        if (recyclerView == null || this.f7917e != 1) {
            return;
        }
        ViewCompat.setOverScrollMode(recyclerView, (z && (!z3 || paddingTop < size2)) || (!z && (!z2 || paddingLeft < size)) ? 2 : 0);
    }

    public final void s(int i2) {
        this.f7916d = true;
        if (this.f7915c != i2) {
            this.f7915c = i2;
            requestLayout();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void setOrientation(int i2) {
        if (this.a != null && getOrientation() != i2) {
            int[] iArr = this.a;
            iArr[0] = 0;
            iArr[1] = 0;
        }
        super.setOrientation(i2);
    }

    public final void t(int i2) {
        if (i2 >= 0 && i2 <= 2) {
            RecyclerView recyclerView = this.b;
            if (recyclerView != null) {
                this.f7917e = i2;
                ViewCompat.setOverScrollMode(recyclerView, i2);
                return;
            }
            throw new IllegalStateException("view == null".toString());
        }
        throw new IllegalArgumentException(f0.C("Unknown overscroll mode: ", Integer.valueOf(i2)).toString());
    }

    public ScrollLinearLayoutManager(@e Context context, int i2, boolean z) {
        super(context, i2, z);
        this.a = new int[2];
        this.f7915c = 100;
        this.f7918f = new Rect();
        this.b = null;
    }

    public ScrollLinearLayoutManager(@d RecyclerView recyclerView) {
        super(recyclerView.getContext());
        this.a = new int[2];
        this.f7915c = 100;
        this.f7918f = new Rect();
        this.b = recyclerView;
        this.f7917e = ViewCompat.getOverScrollMode(recyclerView);
    }

    public ScrollLinearLayoutManager(@d RecyclerView recyclerView, int i2, boolean z) {
        super(recyclerView.getContext(), i2, z);
        this.a = new int[2];
        this.f7915c = 100;
        this.f7918f = new Rect();
        this.b = recyclerView;
        this.f7917e = ViewCompat.getOverScrollMode(recyclerView);
    }
}
