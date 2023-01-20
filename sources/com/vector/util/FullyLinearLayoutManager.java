package com.vector.util;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B!\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\b\u0010\f\u001a\u00020\bH\u0016J4\u0010\r\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u000bH\u0002J,\u0010\u0016\u001a\u00020\u000e2\n\u0010\u000f\u001a\u00060\u0010R\u00020\u00112\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/vector/util/FullyLinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "orientation", "", "reverseLayout", "", "(Landroid/content/Context;IZ)V", "mMeasuredDimension", "", "canScrollVertically", "measureScrapChild", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "position", "widthSpec", "heightSpec", "measuredDimension", "onMeasure", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FullyLinearLayoutManager extends LinearLayoutManager {
    @d
    public static final a b = new a(null);

    /* renamed from: c */
    private static final String f7869c = FullyLinearLayoutManager.class.getSimpleName();
    @d
    private final int[] a;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/vector/util/FullyLinearLayoutManager$Companion;", "", "()V", "TAG", "", "kotlin.jvm.PlatformType", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public FullyLinearLayoutManager(@e Context context) {
        super(context);
        this.a = new int[2];
    }

    private final void k(RecyclerView.Recycler recycler, int i2, int i3, int i4, int[] iArr) {
        try {
            View viewForPosition = recycler.getViewForPosition(0);
            ViewGroup.LayoutParams layoutParams = viewForPosition.getLayoutParams();
            if (layoutParams != null) {
                RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
                viewForPosition.measure(ViewGroup.getChildMeasureSpec(i3, getPaddingLeft() + getPaddingRight(), ((ViewGroup.MarginLayoutParams) layoutParams2).width), ViewGroup.getChildMeasureSpec(i4, getPaddingTop() + getPaddingBottom(), ((ViewGroup.MarginLayoutParams) layoutParams2).height));
                iArr[0] = viewForPosition.getMeasuredWidth() + ((ViewGroup.MarginLayoutParams) layoutParams2).leftMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).rightMargin;
                iArr[1] = viewForPosition.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) layoutParams2).bottomMargin + ((ViewGroup.MarginLayoutParams) layoutParams2).topMargin;
                recycler.recycleView(viewForPosition);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onMeasure(@d RecyclerView.Recycler recycler, @d RecyclerView.State state, int i2, int i3) {
        int i4;
        int mode = View.MeasureSpec.getMode(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i2);
        int size2 = View.MeasureSpec.getSize(i3);
        String str = f7869c;
        Log.i(str, "onMeasure called. \nwidthMode " + mode + " \nheightMode " + i3 + " \nwidthSize " + size + " \nheightSize " + size2 + " \ngetItemCount() " + getItemCount());
        int itemCount = getItemCount();
        int i5 = 0;
        if (itemCount > 0) {
            int i6 = 0;
            i4 = 0;
            int i7 = 0;
            while (true) {
                int i8 = i6 + 1;
                k(recycler, i6, View.MeasureSpec.makeMeasureSpec(i6, 0), View.MeasureSpec.makeMeasureSpec(i6, 0), this.a);
                if (getOrientation() == 0) {
                    int[] iArr = this.a;
                    i7 += iArr[0];
                    if (i6 == 0) {
                        i4 = iArr[1];
                    }
                } else {
                    int[] iArr2 = this.a;
                    i4 += iArr2[1];
                    if (i6 == 0) {
                        i7 = iArr2[0];
                    }
                }
                if (i8 >= itemCount) {
                    break;
                }
                i6 = i8;
            }
            i5 = i7;
        } else {
            i4 = 0;
        }
        if (mode != 1073741824) {
            size = i5;
        }
        if (mode2 != 1073741824) {
            size2 = i4;
        }
        setMeasuredDimension(size, size2);
    }

    public FullyLinearLayoutManager(@e Context context, int i2, boolean z) {
        super(context, i2, z);
        this.a = new int[2];
    }
}
