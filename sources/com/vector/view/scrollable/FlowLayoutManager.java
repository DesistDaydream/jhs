package com.vector.view.scrollable;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.mobads.sdk.internal.bc;
import com.vector.R;
import com.vector.view.scrollable.FlowLayoutManager;
import h.k2.v.u;
import h.o2.k;
import h.t1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0011\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0005TUVWXB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u001b\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&2\u0006\u0010'\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u0014H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\u0014\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\"0!H\u0002J\u0006\u0010,\u001a\u00020\u0003J\u0012\u0010-\u001a\u0004\u0018\u00010\"2\u0006\u0010.\u001a\u00020\u0003H\u0016J\b\u0010/\u001a\u000200H\u0016J\u0012\u00101\u001a\u0004\u0018\u00010\u00182\u0006\u00102\u001a\u00020\u0003H\u0002J\u0012\u00103\u001a\u0004\u0018\u00010\u00182\u0006\u00104\u001a\u00020\u0003H\u0002J\u0010\u00105\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002J\u0010\u00106\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0003H\u0002J\u0014\u00107\u001a\u0002082\n\u00109\u001a\u00060:R\u00020;H\u0002J$\u0010<\u001a\u0002082\f\u0010=\u001a\b\u0012\u0002\b\u0003\u0018\u00010>2\f\u0010?\u001a\b\u0012\u0002\b\u0003\u0018\u00010>H\u0016J \u0010@\u001a\u0002082\u0006\u0010A\u001a\u00020;2\u0006\u0010B\u001a\u00020\u00032\u0006\u0010C\u001a\u00020\u0003H\u0016J\u001c\u0010D\u001a\u0002082\n\u00109\u001a\u00060:R\u00020;2\u0006\u0010E\u001a\u00020FH\u0016J$\u0010G\u001a\u00020\u00032\u0006\u0010H\u001a\u00020\u00032\n\u00109\u001a\u00060:R\u00020;2\u0006\u0010E\u001a\u00020FH\u0016J\u0010\u0010I\u001a\u0002082\u0006\u0010.\u001a\u00020\u0003H\u0016J$\u0010J\u001a\u00020\u00032\u0006\u0010K\u001a\u00020\u00032\n\u00109\u001a\u00060:R\u00020;2\u0006\u0010E\u001a\u00020FH\u0016J$\u0010L\u001a\u0002082\b\u0010A\u001a\u0004\u0018\u00010;2\b\u0010E\u001a\u0004\u0018\u00010F2\u0006\u0010.\u001a\u00020\u0003H\u0016J\b\u0010M\u001a\u00020\u0014H\u0016J\b\u0010N\u001a\u000208H\u0002J\b\u0010O\u001a\u000208H\u0002J\u001e\u0010P\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030Q*\u00020\u00062\u0006\u0010.\u001a\u00020\u0003J\u0012\u0010R\u001a\u00020\u0014*\u00020\u00182\u0006\u0010S\u001a\u00020\u0018R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\rR\u000e\u0010\u0012\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR\u0014\u0010\u001b\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\rR\u0014\u0010\u001d\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\rR\u000e\u0010\u001f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\"\u0012\u0004\u0012\u00020\u00030!X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006Y"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager;", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "numberOfDivisions", "", "orientation", "anInterface", "Lcom/vector/view/scrollable/FlowLayoutManager$Interface;", "(IILcom/vector/view/scrollable/FlowLayoutManager$Interface;)V", "TAG", "", "kotlin.jvm.PlatformType", "availableHeight", "getAvailableHeight", "()I", "availableWidth", "getAvailableWidth", "columnWidth", "getColumnWidth", "horizontalOffset", "isFirstLayoutPass", "", "()Z", "rectList", "", "Landroid/graphics/Rect;", "rowHeight", "getRowHeight", "totalChildrenHeight", "getTotalChildrenHeight", "totalChildrenWidth", "getTotalChildrenWidth", "verticalOffset", "viewToItemIndexMap", "", "Landroid/view/View;", "visibleChildren", "", "arrayOfZeros", "", "size", "(I)[Ljava/lang/Integer;", "canScrollHorizontally", "canScrollVertically", "detachAllChildren", "findFirstVisibleItemPosition", "findViewByPosition", "position", "generateDefaultLayoutParams", "Landroidx/recyclerview/widget/RecyclerView$LayoutParams;", "getChildRectForChildIndex", "childIndex", "getChildRectForItemIndex", "itemIndex", "getGlobalColumnOfPosition", "getGlobalRowOfPosition", "layoutChildren", "", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "onAdapterChanged", "oldAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "newAdapter", "onItemsRemoved", "recyclerView", "positionStart", "itemCount", "onLayoutChildren", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scrollHorizontallyBy", "dx", "scrollToPosition", "scrollVerticallyBy", "dy", "smoothScrollToPosition", "supportsPredictiveItemAnimations", "updateLayout", "updateVisibleChildren", "getSizeForChild", "Lkotlin/Pair;", "intersects", "other", "HorizontalLayoutState", "InsetDecoration", "Interface", "LayoutState", "VerticalLayoutState", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FlowLayoutManager extends RecyclerView.LayoutManager {
    private final int a;
    private final int b;
    @k.e.a.d

    /* renamed from: c */
    private final c f8023c;

    /* renamed from: d */
    private final String f8024d;
    @k.e.a.d

    /* renamed from: e */
    private final List<Rect> f8025e;
    @k.e.a.d

    /* renamed from: f */
    private final Map<View, Integer> f8026f;
    @k.e.a.d

    /* renamed from: g */
    private final Set<Integer> f8027g;

    /* renamed from: h */
    private int f8028h;

    /* renamed from: i */
    private int f8029i;

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager$InsetDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "context", "Landroid/content/Context;", "(Lcom/vector/view/scrollable/FlowLayoutManager;Landroid/content/Context;)V", "bottomInset", "", "leftInset", "mInsets", "onlyOnce", "", "rightInset", "topInset", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class b extends RecyclerView.ItemDecoration {
        private final int a;
        private int b;

        /* renamed from: c */
        private int f8032c;

        /* renamed from: d */
        private int f8033d;

        /* renamed from: e */
        private int f8034e;

        /* renamed from: f */
        private boolean f8035f = true;

        public b(@k.e.a.d Context context) {
            FlowLayoutManager.this = r1;
            this.a = context.getResources().getDimensionPixelSize(R.dimen.default_card_insets);
        }

        public static final void a(RecyclerView recyclerView, int i2, b bVar) {
            RecyclerView.Adapter adapter = recyclerView.getAdapter();
            if (adapter != null) {
                adapter.notifyItemChanged(i2);
            }
            bVar.f8035f = false;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(@k.e.a.d Rect rect, @k.e.a.d View view, @k.e.a.d final RecyclerView recyclerView, @k.e.a.d RecyclerView.State state) {
            Integer num = (Integer) FlowLayoutManager.this.f8026f.get(view);
            if (num == null) {
                return;
            }
            final int intValue = num.intValue();
            Rect rect2 = (Rect) FlowLayoutManager.this.f8025e.get(intValue);
            Log.d("Rect", rect2.top + ", " + rect2.bottom + ", " + rect2.left + ", " + rect2.right);
            if (FlowLayoutManager.this.b == 1) {
                this.f8033d = rect2.left <= 0 ? 0 : this.a / 2;
                this.b = rect2.top <= 0 ? 0 : this.a / 2;
                this.f8034e = rect2.right >= FlowLayoutManager.this.y() - FlowLayoutManager.this.a ? 0 : this.a / 2;
                this.f8032c = rect2.bottom < FlowLayoutManager.this.G() ? this.a / 2 : 0;
            } else {
                this.f8033d = rect2.left <= 0 ? 0 : this.a / 2;
                this.b = rect2.top <= 0 ? 0 : this.a / 2;
                this.f8034e = rect2.right >= FlowLayoutManager.this.H() ? 0 : this.a / 2;
                this.f8032c = rect2.bottom <= FlowLayoutManager.this.x() - FlowLayoutManager.this.a ? this.a / 2 : 0;
            }
            rect.set(this.f8033d, this.b, this.f8034e, this.f8032c);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = (layoutParams.width - this.f8033d) - this.f8034e;
            layoutParams.height = (layoutParams.height - this.b) - this.f8032c;
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
            view.setLayoutParams((RecyclerView.LayoutParams) layoutParams);
            if (this.f8035f) {
                new Handler().post(new Runnable() { // from class: e.t.v.j.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        FlowLayoutManager.b.a(recyclerView, intValue, this);
                    }
                });
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0004H&¨\u0006\u0006"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager$Interface;", "", "getProportionalSizeForChild", "Lkotlin/Pair;", "", "position", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public interface c {
        @k.e.a.d
        Pair<Integer, Integer> a(int i2);
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u001c\n\u0002\b\u0002\b\"\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010\t\u001a\u0004\u0018\u00010\u00002\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H&J\u0012\u0010\f\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\rH\u0004J\u0012\u0010\u000e\u001a\u00020\u0003*\b\u0012\u0004\u0012\u00020\u00030\rH\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000f"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager$LayoutState;", "", "x", "", "y", "(II)V", "getX", "()I", "getY", "pivot", "width", "height", "maxIndex", "", "minIndex", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static abstract class d {
        private final int a;
        private final int b;

        public d(int i2, int i3) {
            this.a = i2;
            this.b = i3;
        }

        public final int a() {
            return this.a;
        }

        public final int b() {
            return this.b;
        }

        public final int c(@k.e.a.d Iterable<Integer> iterable) {
            List<Pair> V5 = CollectionsKt___CollectionsKt.V5(iterable, new k(0, CollectionsKt___CollectionsKt.K1(iterable) - 1));
            Pair pair = new Pair(Integer.MIN_VALUE, -1);
            for (Pair pair2 : V5) {
                if (((Number) pair.getFirst()).intValue() < ((Number) pair2.getFirst()).intValue()) {
                    pair = new Pair(pair2.getFirst(), pair2.getSecond());
                }
            }
            return ((Number) pair.getSecond()).intValue();
        }

        public final int d(@k.e.a.d Iterable<Integer> iterable) {
            List<Pair> V5 = CollectionsKt___CollectionsKt.V5(iterable, new k(0, CollectionsKt___CollectionsKt.K1(iterable) - 1));
            Pair pair = new Pair(Integer.MAX_VALUE, -1);
            for (Pair pair2 : V5) {
                if (((Number) pair.getFirst()).intValue() > ((Number) pair2.getFirst()).intValue()) {
                    pair = new Pair(pair2.getFirst(), pair2.getSecond());
                }
            }
            return ((Number) pair.getSecond()).intValue();
        }

        @k.e.a.e
        public abstract d e(int i2, int i3);
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vector/view/scrollable/FlowLayoutManager$smoothScrollToPosition$scroller$1", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "computeScrollVectorForPosition", "Landroid/graphics/PointF;", "targetPosition", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class f extends LinearSmoothScroller {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public f(Context context) {
            super(context);
            FlowLayoutManager.this = r1;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.SmoothScroller
        @k.e.a.d
        public PointF computeScrollVectorForPosition(int i2) {
            Rect rect = (Rect) FlowLayoutManager.this.f8025e.get(i2);
            return FlowLayoutManager.this.b == 1 ? new PointF(0.0f, rect.top) : new PointF(rect.right, 0.0f);
        }
    }

    public /* synthetic */ FlowLayoutManager(int i2, int i3, c cVar, int i4, u uVar) {
        this(i2, (i4 & 2) != 0 ? 1 : i3, cVar);
    }

    private final Rect A(int i2) {
        return this.f8025e.get(i2);
    }

    public final int B() {
        return this.b == 1 ? y() / this.a : E();
    }

    private final int C(int i2) {
        return i2 % this.a;
    }

    private final int D(int i2) {
        return i2 / this.a;
    }

    public final int E() {
        return this.b == 0 ? x() / this.a : B();
    }

    public final int G() {
        int i2 = 0;
        for (Rect rect : this.f8025e) {
            i2 = Math.max(i2, rect.bottom);
        }
        return i2;
    }

    public final int H() {
        int i2 = 0;
        for (Rect rect : this.f8025e) {
            i2 = Math.max(i2, rect.right);
        }
        return i2;
    }

    private final boolean J() {
        return getChildCount() <= 0;
    }

    private final void K(RecyclerView.Recycler recycler) {
        Map<Integer, View> w = w();
        if (this.b == 1) {
            for (Number number : this.f8027g) {
                int intValue = number.intValue();
                View view = w.get(Integer.valueOf(intValue));
                if (view == null) {
                    View viewForPosition = recycler.getViewForPosition(intValue);
                    Rect rect = this.f8025e.get(intValue);
                    viewForPosition.getLayoutParams().width = rect.width();
                    viewForPosition.getLayoutParams().height = rect.height();
                    addView(viewForPosition);
                    this.f8026f.put(viewForPosition, Integer.valueOf(intValue));
                    measureChildWithMargins(viewForPosition, 0, 0);
                    int i2 = rect.top;
                    int i3 = this.f8028h;
                    layoutDecorated(viewForPosition, rect.left, i2 - i3, rect.right, rect.bottom - i3);
                } else {
                    attachView(view);
                    w.remove(Integer.valueOf(intValue));
                }
            }
        } else {
            for (Number number2 : this.f8027g) {
                int intValue2 = number2.intValue();
                View view2 = w.get(Integer.valueOf(intValue2));
                if (view2 == null) {
                    View viewForPosition2 = recycler.getViewForPosition(intValue2);
                    Rect rect2 = this.f8025e.get(intValue2);
                    viewForPosition2.getLayoutParams().width = rect2.width();
                    viewForPosition2.getLayoutParams().height = rect2.height();
                    addView(viewForPosition2);
                    this.f8026f.put(viewForPosition2, Integer.valueOf(intValue2));
                    measureChildWithMargins(viewForPosition2, 0, 0);
                    int i4 = rect2.left;
                    int i5 = this.f8029i;
                    layoutDecorated(viewForPosition2, i4 - i5, rect2.top, rect2.right - i5, rect2.bottom);
                } else {
                    attachView(view2);
                    w.remove(Integer.valueOf(intValue2));
                }
            }
        }
        for (Map.Entry<Integer, View> entry : w.entrySet()) {
            this.f8026f.remove(entry.getValue());
            recycler.recycleView(entry.getValue());
        }
    }

    private final void L() {
        d aVar;
        this.f8025e.clear();
        if (this.b == 1) {
            aVar = new e();
        } else {
            aVar = new a();
        }
        if (this.b == 1) {
            int itemCount = getItemCount();
            if (itemCount <= 0) {
                return;
            }
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                Pair<Integer, Integer> F = F(this.f8023c, i2);
                int intValue = F.component1().intValue();
                int intValue2 = F.component2().intValue();
                if (aVar.a() <= 0) {
                    intValue += y() - (this.a * B());
                }
                d e2 = aVar.e(intValue, intValue2);
                if (e2 != null) {
                    this.f8025e.add(new Rect(e2.a(), e2.b(), e2.a() + intValue, e2.b() + intValue2));
                    aVar = e2;
                } else {
                    this.f8025e.add(new Rect(0, 0, 0, 0));
                }
                if (i3 >= itemCount) {
                    return;
                }
                i2 = i3;
            }
        } else {
            int itemCount2 = getItemCount();
            if (itemCount2 <= 0) {
                return;
            }
            int i4 = 0;
            while (true) {
                int i5 = i4 + 1;
                Pair<Integer, Integer> F2 = F(this.f8023c, i4);
                int intValue3 = F2.component1().intValue();
                int intValue4 = F2.component2().intValue();
                if (aVar.b() <= 0) {
                    intValue4 += x() - (this.a * E());
                }
                d e3 = aVar.e(intValue3, intValue4);
                if (e3 != null) {
                    this.f8025e.add(new Rect(e3.a(), e3.b(), e3.a() + intValue3, e3.b() + intValue4));
                    aVar = e3;
                } else {
                    this.f8025e.add(new Rect(0, 0, 0, 0));
                }
                if (i5 >= itemCount2) {
                    return;
                }
                i4 = i5;
            }
        }
    }

    private final void M() {
        Rect rect;
        this.f8027g.clear();
        int i2 = 0;
        if (this.b == 1) {
            rect = new Rect(0, this.f8028h, y(), this.f8028h + x());
        } else {
            int i3 = this.f8029i;
            rect = new Rect(i3, 0, y() + i3, x());
        }
        int size = this.f8025e.size();
        if (size <= 0) {
            return;
        }
        while (true) {
            int i4 = i2 + 1;
            if (I(rect, this.f8025e.get(i2))) {
                this.f8027g.add(Integer.valueOf(i2));
            }
            if (i4 >= size) {
                return;
            }
            i2 = i4;
        }
    }

    public final Integer[] v(int i2) {
        Integer[] numArr = new Integer[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            numArr[i3] = 0;
        }
        return numArr;
    }

    private final Map<Integer, View> w() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int childCount = getChildCount();
        if (childCount > 0) {
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                View childAt = getChildAt(i2);
                Integer num = this.f8026f.get(childAt);
                if (num != null) {
                    linkedHashMap.put(Integer.valueOf(num.intValue()), childAt);
                }
                if (i3 >= childCount) {
                    break;
                }
                i2 = i3;
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            detachView((View) entry.getValue());
        }
        return linkedHashMap;
    }

    public final int x() {
        return (getHeight() - getPaddingTop()) - getPaddingBottom();
    }

    public final int y() {
        return (getWidth() - getPaddingLeft()) - getPaddingRight();
    }

    private final Rect z(int i2) {
        Integer num;
        View childAt = getChildAt(i2);
        if (childAt == null || (num = this.f8026f.get(childAt)) == null) {
            return null;
        }
        return A(num.intValue());
    }

    @k.e.a.d
    public final Pair<Integer, Integer> F(@k.e.a.d c cVar, int i2) {
        Pair<Integer, Integer> a2 = cVar.a(i2);
        return new Pair<>(Integer.valueOf(a2.component1().intValue() * B()), Integer.valueOf(a2.component2().intValue() * E()));
    }

    public final boolean I(@k.e.a.d Rect rect, @k.e.a.d Rect rect2) {
        return rect.intersects(rect2.left, rect2.top, rect2.right, rect2.bottom);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollHorizontally() {
        return this.b == 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean canScrollVertically() {
        return this.b == 1;
    }

    public final int findFirstVisibleItemPosition() {
        List d5 = CollectionsKt___CollectionsKt.d5(CollectionsKt___CollectionsKt.I5(this.f8027g));
        return ((Number) (CollectionsKt__CollectionsKt.G(d5) >= 0 ? d5.get(0) : -1)).intValue();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @k.e.a.e
    public View findViewByPosition(int i2) {
        return (View) e.t.v.j.e.a(this.f8026f, Integer.valueOf(i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    @k.e.a.d
    public RecyclerView.LayoutParams generateDefaultLayoutParams() {
        return new RecyclerView.LayoutParams(-2, -2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onAdapterChanged(@k.e.a.e RecyclerView.Adapter<?> adapter, @k.e.a.e RecyclerView.Adapter<?> adapter2) {
        removeAllViews();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onItemsRemoved(@k.e.a.d RecyclerView recyclerView, int i2, int i3) {
        List<Rect> list = this.f8025e;
        list.remove(CollectionsKt__CollectionsKt.G(list));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void onLayoutChildren(@k.e.a.d RecyclerView.Recycler recycler, @k.e.a.d RecyclerView.State state) {
        if (getItemCount() <= 0) {
            detachAndScrapAttachedViews(recycler);
        } else if (getChildCount() > 0 || !state.isPreLayout()) {
            L();
            M();
            detachAndScrapAttachedViews(recycler);
            K(recycler);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollHorizontallyBy(int i2, @k.e.a.d RecyclerView.Recycler recycler, @k.e.a.d RecyclerView.State state) {
        if (getItemCount() > 0 && H() >= y()) {
            if (i2 > 0) {
                if (this.f8029i + y() + i2 > H()) {
                    i2 = (H() - this.f8029i) - y();
                }
            } else {
                int i3 = this.f8029i;
                if (i3 + i2 <= 0) {
                    i2 = -i3;
                }
            }
            offsetChildrenHorizontal(-i2);
            this.f8029i += i2;
            M();
            K(recycler);
            return i2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void scrollToPosition(int i2) {
        if (i2 >= 0 && i2 < this.f8025e.size()) {
            Rect rect = this.f8025e.get(i2);
            if (this.b == 1) {
                int x = this.f8028h + x();
                int i3 = rect.top;
                int i4 = this.f8028h;
                if (i3 >= i4 && rect.bottom <= x) {
                    Log.d("scrollToPosition", rect.top + " don't move");
                    return;
                }
                int i5 = rect.bottom - i3;
                if (i3 >= i4 && i5 <= x()) {
                    this.f8028h = rect.bottom - x();
                } else {
                    this.f8028h = rect.top;
                }
            } else {
                int y = this.f8029i + y();
                int i6 = rect.right;
                int i7 = this.f8029i;
                if (i6 >= i7 && i6 <= y) {
                    Log.d("scrollToPosition", rect.right + " don't move");
                    return;
                }
                int i8 = rect.left;
                int i9 = i6 - i8;
                if (i8 >= i7 && i9 <= y()) {
                    this.f8029i = rect.right - y();
                } else {
                    this.f8029i = rect.left;
                }
            }
            removeAllViews();
            requestLayout();
            return;
        }
        String str = this.f8024d;
        Log.e(str, "Cannot scroll to " + i2 + ", item count is " + (this.f8025e.size() - 1));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public int scrollVerticallyBy(int i2, @k.e.a.d RecyclerView.Recycler recycler, @k.e.a.d RecyclerView.State state) {
        if (getItemCount() > 0 && G() >= x()) {
            if (i2 > 0) {
                if (this.f8028h + x() + i2 > G()) {
                    i2 = (G() - this.f8028h) - x();
                }
            } else {
                int i3 = this.f8028h;
                if (i3 + i2 <= 0) {
                    i2 = -i3;
                }
            }
            offsetChildrenVertical(-i2);
            this.f8028h += i2;
            M();
            K(recycler);
            return i2;
        }
        return 0;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public void smoothScrollToPosition(@k.e.a.e RecyclerView recyclerView, @k.e.a.e RecyclerView.State state, int i2) {
        if (recyclerView == null) {
            return;
        }
        if (i2 >= 0 && i2 < this.f8025e.size()) {
            f fVar = new f(recyclerView.getContext());
            fVar.setTargetPosition(i2);
            startSmoothScroll(fVar);
            return;
        }
        String str = this.f8024d;
        Log.e(str, "Cannot scroll to " + i2 + ", item count is " + this.f8025e.size());
    }

    @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
    public boolean supportsPredictiveItemAnimations() {
        return true;
    }

    public FlowLayoutManager(int i2, int i3, @k.e.a.d c cVar) {
        this.a = i2;
        this.b = i3;
        this.f8023c = cVar;
        this.f8024d = FlowLayoutManager.class.getSimpleName();
        this.f8025e = new ArrayList();
        this.f8026f = new LinkedHashMap();
        this.f8027g = new LinkedHashSet();
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001a"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager$HorizontalLayoutState;", "Lcom/vector/view/scrollable/FlowLayoutManager$LayoutState;", "(Lcom/vector/view/scrollable/FlowLayoutManager;)V", "x", "", "y", "rowLimits", "", "(Lcom/vector/view/scrollable/FlowLayoutManager;II[Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "findGapPosition", "Lkotlin/Pair;", "height", "hasSpace", "", bc.f1474i, "", "col", "row", "pivot", "Lcom/vector/view/scrollable/FlowLayoutManager;", "width", "toString", "", "updateColumnLimits", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class a extends d {
        @k.e.a.d

        /* renamed from: c */
        private Integer[] f8030c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private a(int i2, int i3, Integer[] numArr) {
            super(i2, i3);
            FlowLayoutManager.this = r1;
            this.f8030c = numArr;
        }

        private final Pair<Integer, Integer> f(int i2) {
            List<Integer> ey = ArraysKt___ArraysKt.ey(this.f8030c);
            int d2 = d(ey);
            int c2 = c(ey);
            int intValue = ey.get(d2).intValue();
            int intValue2 = ey.get(c2).intValue();
            if (intValue > intValue2) {
                return null;
            }
            int i3 = intValue;
            while (true) {
                int i4 = i3 + 1;
                k kVar = new k(i3 == intValue ? d2 : 0, ey.size() - 1);
                ArrayList arrayList = new ArrayList();
                for (Integer num : kVar) {
                    if (g(ey, i3, num.intValue(), i2)) {
                        arrayList.add(num);
                    }
                }
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    return new Pair<>(Integer.valueOf(i3), Integer.valueOf(((Number) it.next()).intValue()));
                } else if (i3 == intValue2) {
                    return null;
                } else {
                    i3 = i4;
                }
            }
        }

        private final boolean g(List<Integer> list, int i2, int i3, int i4) {
            int i5 = (i3 + i4) - 1;
            if (i3 <= i5) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    int i8 = i3 + 1;
                    if ((i3 + i4) - i6 > list.size() || list.get(i3).intValue() > i2) {
                        return false;
                    }
                    if (i3 == i5) {
                        break;
                    }
                    i6 = i7;
                    i3 = i8;
                }
            }
            return true;
        }

        private final void i(int i2, int i3, int i4) {
            int i5 = (i4 + i2) - 1;
            Integer num = (Integer) CollectionsKt___CollectionsKt.F3(ArraysKt___ArraysKt.nt(this.f8030c, new k(i2, i5)));
            int intValue = num == null ? 0 : num.intValue();
            if (i2 > i5) {
                return;
            }
            while (true) {
                int i6 = i2 + 1;
                this.f8030c[i2] = Integer.valueOf(intValue + i3);
                if (i2 == i5) {
                    return;
                }
                i2 = i6;
            }
        }

        @Override // com.vector.view.scrollable.FlowLayoutManager.d
        @k.e.a.e
        /* renamed from: h */
        public a e(int i2, int i3) {
            Pair<Integer, Integer> f2;
            int B = i2 / FlowLayoutManager.this.B();
            int E = i3 / FlowLayoutManager.this.E();
            if (E <= FlowLayoutManager.this.a && (f2 = f(E)) != null) {
                int intValue = f2.component1().intValue();
                int intValue2 = f2.component2().intValue();
                i(intValue2, B, E);
                FlowLayoutManager flowLayoutManager = FlowLayoutManager.this;
                return new a(intValue * flowLayoutManager.B(), intValue2 * FlowLayoutManager.this.E(), this.f8030c);
            }
            return null;
        }

        @k.e.a.d
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(a());
            sb.append(", ");
            sb.append(b());
            sb.append(", ");
            Integer[] numArr = this.f8030c;
            if (numArr.length > 0) {
                int intValue = numArr[0].intValue();
                return "(0, " + intValue + ')';
            }
            sb.append(t1.a);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public a() {
            this(0, 0, r3.v(r3.a));
            FlowLayoutManager.this = r3;
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B%\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007¢\u0006\u0002\u0010\bJ\u001e\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\u0004H\u0002J.\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002J\u001e\u0010\u0013\u001a\b\u0018\u00010\u0000R\u00020\u00142\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J \u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0002R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/vector/view/scrollable/FlowLayoutManager$VerticalLayoutState;", "Lcom/vector/view/scrollable/FlowLayoutManager$LayoutState;", "(Lcom/vector/view/scrollable/FlowLayoutManager;)V", "x", "", "y", "columnLimits", "", "(Lcom/vector/view/scrollable/FlowLayoutManager;II[Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "findGapPosition", "Lkotlin/Pair;", "width", "hasSpace", "", bc.f1474i, "", "col", "row", "pivot", "Lcom/vector/view/scrollable/FlowLayoutManager;", "height", "toString", "", "updateColumnLimits", "", "column", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class e extends d {
        @k.e.a.d

        /* renamed from: c */
        private Integer[] f8037c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        private e(int i2, int i3, Integer[] numArr) {
            super(i2, i3);
            FlowLayoutManager.this = r1;
            this.f8037c = numArr;
        }

        private final Pair<Integer, Integer> f(int i2) {
            List<Integer> ey = ArraysKt___ArraysKt.ey(this.f8037c);
            int d2 = d(ey);
            int c2 = c(ey);
            int intValue = ey.get(d2).intValue();
            int intValue2 = ey.get(c2).intValue();
            if (intValue > intValue2) {
                return null;
            }
            int i3 = intValue;
            while (true) {
                int i4 = i3 + 1;
                k kVar = new k(i3 == intValue ? d2 : 0, ey.size() - 1);
                ArrayList arrayList = new ArrayList();
                for (Integer num : kVar) {
                    if (g(ey, num.intValue(), i3, i2)) {
                        arrayList.add(num);
                    }
                }
                Iterator it = arrayList.iterator();
                if (it.hasNext()) {
                    return new Pair<>(Integer.valueOf(((Number) it.next()).intValue()), Integer.valueOf(i3));
                }
                if (i3 == intValue2) {
                    return null;
                }
                i3 = i4;
            }
        }

        private final boolean g(List<Integer> list, int i2, int i3, int i4) {
            int i5 = (i2 + i4) - 1;
            if (i2 <= i5) {
                int i6 = 0;
                while (true) {
                    int i7 = i6 + 1;
                    int i8 = i2 + 1;
                    if ((i2 + i4) - i6 > list.size() || list.get(i2).intValue() > i3) {
                        return false;
                    }
                    if (i2 == i5) {
                        break;
                    }
                    i6 = i7;
                    i2 = i8;
                }
            }
            return true;
        }

        private final void i(int i2, int i3, int i4) {
            int i5 = (i3 + i2) - 1;
            Integer num = (Integer) CollectionsKt___CollectionsKt.F3(ArraysKt___ArraysKt.nt(this.f8037c, new k(i2, i5)));
            int intValue = num == null ? 0 : num.intValue();
            if (i2 > i5) {
                return;
            }
            while (true) {
                int i6 = i2 + 1;
                this.f8037c[i2] = Integer.valueOf(intValue + i4);
                if (i2 == i5) {
                    return;
                }
                i2 = i6;
            }
        }

        @Override // com.vector.view.scrollable.FlowLayoutManager.d
        @k.e.a.e
        /* renamed from: h */
        public e e(int i2, int i3) {
            Pair<Integer, Integer> f2;
            int B = i2 / FlowLayoutManager.this.B();
            int E = i3 / FlowLayoutManager.this.E();
            if (B <= FlowLayoutManager.this.a && (f2 = f(B)) != null) {
                int intValue = f2.component1().intValue();
                int intValue2 = f2.component2().intValue();
                i(intValue, B, E);
                FlowLayoutManager flowLayoutManager = FlowLayoutManager.this;
                return new e(intValue * flowLayoutManager.B(), intValue2 * FlowLayoutManager.this.E(), this.f8037c);
            }
            return null;
        }

        @k.e.a.d
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(a());
            sb.append(", ");
            sb.append(b());
            sb.append(", ");
            Integer[] numArr = this.f8037c;
            if (numArr.length > 0) {
                int intValue = numArr[0].intValue();
                return "(0, " + intValue + ')';
            }
            sb.append(t1.a);
            sb.append(')');
            return sb.toString();
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public e() {
            this(0, 0, r3.v(r3.a));
            FlowLayoutManager.this = r3;
        }
    }
}
