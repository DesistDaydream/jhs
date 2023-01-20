package com.vector.view.scrollable;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSmoothScroller;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.qiniu.android.collect.ReportItem;
import com.vector.R;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.design.ui.delegate.SwipeRefresh;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import com.vector.view.pager.ViewPager;
import com.vector.view.scrollable.ListView;
import com.vector.view.scrollable.ListView$innerScrollListener$2;
import com.vector.view.swipe.ScrollableExtend;
import com.vector.view.swipe.SwipeRefreshLayout;
import com.vector.view.swipe.footer.BaseFooter;
import com.vector.view.swipe.footer.DefaultFooter;
import e.j.a.b.c.r.c0;
import e.t.l.k;
import e.t.u.p;
import e.t.v.j.g;
import h.k2.h;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.ArrayList;
import java.util.List;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000Ï\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r*\u00012\b\u0016\u0018\u0000 ¦\u00012\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0004¦\u0001§\u0001B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u000e\u0010g\u001a\u00020h2\u0006\u0010i\u001a\u00020jJ\u0010\u0010k\u001a\u00020h2\u0006\u0010l\u001a\u00020QH\u0016J\u0010\u0010m\u001a\u00020h2\u0006\u0010n\u001a\u00020\u001fH\u0016J\u0010\u0010o\u001a\u00020h2\u0006\u0010n\u001a\u00020\u001fH\u0016J\u0010\u0010p\u001a\u00020h2\u0006\u0010q\u001a\u00020rH\u0002J\u0010\u0010s\u001a\u00020h2\u0006\u0010n\u001a\u00020\u001fH\u0002J\u0012\u0010t\u001a\u00020\u001f2\b\u0010u\u001a\u0004\u0018\u00010vH\u0016J\b\u0010w\u001a\u00020\u0003H\u0016J\u0010\u0010x\u001a\u00020h2\u0006\u0010y\u001a\u00020zH\u0007J\u0006\u0010{\u001a\u00020hJ\u0006\u0010|\u001a\u00020hJ\b\u0010}\u001a\u00020hH\u0014J\b\u0010~\u001a\u00020hH\u0014J\u0013\u0010\u007f\u001a\u00020h2\t\u0010q\u001a\u0005\u0018\u00010\u0080\u0001H\u0014J\t\u0010\u0081\u0001\u001a\u00020hH\u0016J \u0010\u0082\u0001\u001a\u00020h2\u0007\u0010\u0083\u0001\u001a\u00020\t2\b\u0010^\u001a\u0004\u0018\u00010\u001f¢\u0006\u0003\u0010\u0084\u0001J\u000f\u0010\u0085\u0001\u001a\u00020h2\u0006\u0010\\\u001a\u00020\tJ\u001e\u0010\u0086\u0001\u001a\u00020h2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0088\u00012\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u001fJ+\u0010\u008a\u0001\u001a\u00020h2\u0007\u0010\u008b\u0001\u001a\u00020\t2\u0007\u0010\u008c\u0001\u001a\u00020\t2\u0007\u0010\u008d\u0001\u001a\u00020\t2\u0007\u0010\u008e\u0001\u001a\u00020\tJ\u0012\u0010\u008f\u0001\u001a\u00020h2\u0007\u0010\u0090\u0001\u001a\u00020\u001fH\u0016J\u0011\u0010\u0091\u0001\u001a\u00020h2\b\u0010\u0092\u0001\u001a\u00030\u0093\u0001J1\u0010\u0094\u0001\u001a\u00020h2&\u0010\u0095\u0001\u001a!\u0012\u0016\u0012\u00140\u0097\u0001¢\u0006\u000e\b\u0098\u0001\u0012\t\b\u0099\u0001\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020h0\u0096\u0001H\u0016J1\u0010\u009a\u0001\u001a\u00020h2&\u0010\u0095\u0001\u001a!\u0012\u0016\u0012\u00140\u009b\u0001¢\u0006\u000e\b\u0098\u0001\u0012\t\b\u0099\u0001\u0012\u0004\b\b(q\u0012\u0004\u0012\u00020h0\u0096\u0001H\u0016J\u0010\u0010\u009c\u0001\u001a\u00020h2\u0007\u0010\u009d\u0001\u001a\u00020\u001fJ\u0010\u0010\u009e\u0001\u001a\u00020h2\u0007\u0010\u009f\u0001\u001a\u00020\tJ\u000f\u0010 \u0001\u001a\u00020h2\u0006\u0010n\u001a\u00020\u001fJ\u0013\u0010¡\u0001\u001a\u00020h2\b\u0010¢\u0001\u001a\u00030\u0097\u0001H\u0016J\t\u0010£\u0001\u001a\u00020hH\u0016J\u0012\u0010¤\u0001\u001a\u00020h2\u0007\u0010q\u001a\u00030\u0097\u0001H\u0016J\t\u0010¥\u0001\u001a\u00020hH\u0016R0\u0010\r\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f2\f\u0010\u000b\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0014\u001a\u00020\u00158FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0018\u0010&\u001a\u0004\u0018\u00010\u001b8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u000e\u0010(\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u0010\n\u0002\u0010%\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010$R\u001a\u0010,\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\u001b\u00101\u001a\u0002028BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b5\u0010\u0019\u001a\u0004\b3\u00104R\u000e\u00106\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u00108\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\u0014\u0010=\u001a\u00020>X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b?\u0010@R\u000e\u0010A\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u0004\u0018\u00010CX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010E\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010.\"\u0004\bG\u00100R\u000e\u0010H\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010I\u001a\u00020JX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0016\u0010O\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010PX\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010R\u001a\u00020\u00038FX\u0086\u0084\u0002¢\u0006\f\n\u0004\bU\u0010\u0019\u001a\u0004\bS\u0010TR\u001f\u0010V\u001a\u00060WR\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bZ\u0010\u0019\u001a\u0004\bX\u0010YR\u000e\u0010[\u001a\u00020\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\\\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b]\u0010:R\u001a\u0010^\u001a\u00020\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010.\"\u0004\b`\u00100R\u000e\u0010a\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010c\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010d\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010e\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010f\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006¨\u0001"}, d2 = {"Lcom/vector/view/scrollable/ListView;", "Lcom/vector/view/swipe/SwipeRefreshLayout;", "Lcom/vector/view/scrollable/ScrollableView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/vector/design/ui/adapter/ExtendAdapterWrapper;", "adapter", "getAdapter", "()Lcom/vector/design/ui/adapter/ExtendAdapterWrapper;", "setAdapter", "(Lcom/vector/design/ui/adapter/ExtendAdapterWrapper;)V", "getAttrs", "()Landroid/util/AttributeSet;", "dataObserver", "Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "getDataObserver", "()Landroidx/recyclerview/widget/RecyclerView$AdapterDataObserver;", "dataObserver$delegate", "Lkotlin/Lazy;", "emptyFooter", "Landroid/view/View;", "getEmptyFooter", "()Landroid/view/View;", "emptyFooterAdded", "", "emptyFooterResId", "getEmptyFooterResId", "()Ljava/lang/Integer;", "setEmptyFooterResId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "errorFooter", "getErrorFooter", "errorFooterAdded", "errorFooterResId", "getErrorFooterResId", "setErrorFooterResId", "hasStableIds", "getHasStableIds", "()Z", "setHasStableIds", "(Z)V", "innerScrollListener", "com/vector/view/scrollable/ListView$innerScrollListener$2$1", "getInnerScrollListener", "()Lcom/vector/view/scrollable/ListView$innerScrollListener$2$1;", "innerScrollListener$delegate", "isLoadingMore", "isSelectTouch", "limitShowNoMore", "getLimitShowNoMore", "()I", "setLimitShowNoMore", "(I)V", "loadMoreFooter", "Lcom/vector/view/swipe/footer/BaseFooter;", "getLoadMoreFooter", "()Lcom/vector/view/swipe/footer/BaseFooter;", "loadMoreFooterAdded", "loadMoreListener", "Lcom/vector/design/ui/delegate/LoadMore$Listener;", "mTouchSlop", "preLoad", "getPreLoad", "setPreLoad", "preLoadStarted", "preloadRate", "", "getPreloadRate", "()F", "setPreloadRate", "(F)V", "scrollListeners", "", "Lcom/vector/design/ui/delegate/OnScrollMixListener;", "scrollable", "getScrollable", "()Landroidx/recyclerview/widget/RecyclerView;", "scrollable$delegate", "scroller", "Lcom/vector/view/scrollable/ListView$StartScroller;", "getScroller", "()Lcom/vector/view/scrollable/ListView$StartScroller;", "scroller$delegate", "showNoMoreFooter", "size", "getSize", "smoothScroll", "getSmoothScroll", "setSmoothScroll", "startX", "startY", "touchMoveX", "touchMoveY", "touchX", "touchY", "addItemDecoration", "", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "addOnScrollListener", c0.a.a, "changeEmptyFooterState", TTLogUtil.TAG_EVENT_SHOW, "changeErrorFooterState", "changeFooterState", "state", "Lcom/vector/view/scrollable/FooterState;", "changeLoadMoreFooterState", "dispatchTouchEvent", "ev", "Landroid/view/MotionEvent;", "getRecyclerView", "handleViewPagerTouchEvent", "viewPager", "Lcom/vector/view/pager/ViewPager;", "idleLoadMoreState", "notifyDataSetChanged", "onAttachedToWindow", "onDetachedFromWindow", "onRestoreInstanceState", "Landroid/os/Parcelable;", "resetLoadMoreState", "scrollToPosition", "position", "(ILjava/lang/Boolean;)V", "setItemViewCacheSize", "setLayoutManager", "layoutStyle", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "stackFormEnd", "setListPadding", "left", "top", "right", "bottom", "setNestedScrollingEnabled", "enabled", "setNoMoreText", "text", "", "setOnLoadMoreListener", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Lcom/vector/design/ui/delegate/LoadMore$State;", "Lkotlin/ParameterName;", "name", "setOnSwipeRefreshListener", "Lcom/vector/design/ui/delegate/SwipeRefresh$State;", "setScrollBarEnabled", "isEnabled", "setScrollableHeight", "height", "setShowNoMoreData", "startLoadMore", "lastState", "startSwipeRefresh", "stopLoadMore", "stopSwipeRefresh", "Companion", "StartScroller", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public class ListView extends SwipeRefreshLayout implements g<RecyclerView> {
    private static final int G0 = 0;
    @k.e.a.d
    public static final a l0 = new a(null);
    private static final float m0 = 0.8f;
    @k.e.a.e
    private final AttributeSet C;
    @k.e.a.d
    private final w D;
    private boolean E;
    private boolean F;
    private int G;
    @k.e.a.e
    private e.t.k.a.c.c<?> H;
    private boolean I;
    private boolean J;
    @k.e.a.e
    private View K;
    @k.e.a.e
    private Integer L;
    @k.e.a.e
    private View M;
    @k.e.a.e
    private Integer N;
    @k.e.a.d
    private final w O;
    private boolean P;
    private float Q;
    private boolean R;
    @k.e.a.d
    private final w S;
    private boolean T;
    private boolean U;
    private boolean V;
    @k.e.a.e
    private LoadMore.b W;
    @k.e.a.d
    private final BaseFooter a0;
    @k.e.a.e
    private List<e.t.k.a.e.a> b0;
    @k.e.a.d
    private final w c0;
    private int d0;
    private int e0;
    private final int f0;
    private float g0;
    private float h0;
    private float i0;
    private float j0;
    private boolean k0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/vector/view/scrollable/ListView$Companion;", "", "()V", "LIMIT_SHOW_NO_MORE_FOOTER", "", "PRELOAD_RATE", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014J\b\u0010\u0007\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/vector/view/scrollable/ListView$StartScroller;", "Landroidx/recyclerview/widget/LinearSmoothScroller;", "context", "Landroid/content/Context;", "(Lcom/vector/view/scrollable/ListView;Landroid/content/Context;)V", "getHorizontalSnapPreference", "", "getVerticalSnapPreference", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public final class b extends LinearSmoothScroller {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(@k.e.a.e Context context) {
            super(context);
            ListView.this = r1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getHorizontalSnapPreference() {
            return -1;
        }

        @Override // androidx.recyclerview.widget.LinearSmoothScroller
        public int getVerticalSnapPreference() {
            return -1;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[FooterState.values().length];
            iArr[FooterState.LOADING.ordinal()] = 1;
            iArr[FooterState.ERROR.ordinal()] = 2;
            iArr[FooterState.GONE.ordinal()] = 3;
            iArr[FooterState.NO_MORE.ordinal()] = 4;
            a = iArr;
            int[] iArr2 = new int[LoadMore.State.values().length];
            iArr2[LoadMore.State.CONTINUE.ordinal()] = 1;
            iArr2[LoadMore.State.ERROR.ordinal()] = 2;
            iArr2[LoadMore.State.END.ordinal()] = 3;
            iArr2[LoadMore.State.NO_MORE.ordinal()] = 4;
            b = iArr2;
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vector/view/scrollable/ListView$setOnLoadMoreListener$1", "Lcom/vector/design/ui/delegate/LoadMore$Listener;", "onLoadMore", "", "lastState", "Lcom/vector/design/ui/delegate/LoadMore$State;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class d implements LoadMore.b {
        public final /* synthetic */ l<LoadMore.State, t1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public d(l<? super LoadMore.State, t1> lVar) {
            this.a = lVar;
        }

        @Override // com.vector.design.ui.delegate.LoadMore.b
        public void a(@k.e.a.d LoadMore.State state) {
            this.a.invoke(state);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/vector/view/scrollable/ListView$setOnSwipeRefreshListener$1", "Lcom/vector/design/ui/delegate/SwipeRefresh$Listener;", "onSwipeStateChanged", "", "state", "Lcom/vector/design/ui/delegate/SwipeRefresh$State;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class e implements SwipeRefresh.b {
        public final /* synthetic */ l<SwipeRefresh.State, t1> a;

        /* JADX WARN: Multi-variable type inference failed */
        public e(l<? super SwipeRefresh.State, t1> lVar) {
            this.a = lVar;
        }

        @Override // com.vector.design.ui.delegate.SwipeRefresh.b
        public void a(@k.e.a.d SwipeRefresh.State state) {
            this.a.invoke(state);
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"com/vector/ext/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "vector_release", "com/vector/ext/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class f implements View.OnLayoutChangeListener {
        public f() {
            ListView.this = r1;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@k.e.a.d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            ListView.this.A();
        }
    }

    @h
    public ListView(@k.e.a.d Context context) {
        this(context, null, 0, 6, null);
    }

    @h
    public ListView(@k.e.a.d Context context, @k.e.a.e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ ListView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final void J(FooterState footerState) {
        int i2 = c.a[footerState.ordinal()];
        if (i2 == 1) {
            K(true);
            getLoadMoreFooter().a(ScrollableExtend.State.LOADING);
            return;
        }
        boolean z = false;
        if (i2 == 2) {
            e.t.k.a.c.c<?> adapter = getAdapter();
            if (adapter != null && adapter.m()) {
                z = true;
            }
            K(!z);
            getLoadMoreFooter().a(ScrollableExtend.State.ERROR);
            getLoadMoreFooter().setOnRetryClick(new ListView$changeFooterState$1(this));
        } else if (i2 == 3) {
            K(false);
            getLoadMoreFooter().a(ScrollableExtend.State.IDLE);
        } else if (i2 != 4) {
        } else {
            K(true);
            getLoadMoreFooter().a(ScrollableExtend.State.FINISH);
        }
    }

    private final void K(boolean z) {
        if (this.W == null) {
            return;
        }
        if (z) {
            if (this.V || getAdapter() == null) {
                return;
            }
            e.t.k.a.c.c<?> adapter = getAdapter();
            if (adapter != null) {
                e.t.k.a.c.c.c(adapter, getLoadMoreFooter(), false, false, 6, null);
            }
            this.V = true;
        } else if (this.V) {
            e.t.k.a.c.c<?> adapter2 = getAdapter();
            if (adapter2 != null) {
                adapter2.w(getLoadMoreFooter());
            }
            this.V = false;
        }
    }

    public static final boolean M(ListView listView, ViewPager viewPager, View view, MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            listView.g0 = motionEvent.getX();
            listView.h0 = motionEvent.getY();
            viewPager.setScrollable(false);
            listView.k0 = false;
        } else if (action == 1) {
            viewPager.setScrollable(true);
            listView.k0 = false;
        } else if (action == 2) {
            listView.i0 = motionEvent.getX();
            float y = motionEvent.getY();
            listView.j0 = y;
            if (!listView.k0) {
                float abs = Math.abs(y - listView.h0);
                float abs2 = Math.abs(listView.i0 - listView.g0);
                int i2 = listView.f0;
                if (abs > i2 || abs2 > i2) {
                    if (abs > abs2) {
                        viewPager.setScrollable(false);
                        listView.k0 = true;
                    } else {
                        viewPager.setScrollable(true);
                        listView.k0 = true;
                    }
                }
            }
        }
        return false;
    }

    public static /* synthetic */ void S(ListView listView, RecyclerView.LayoutManager layoutManager, boolean z, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setLayoutManager");
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        listView.R(layoutManager, z);
    }

    private final View getEmptyFooter() {
        if (this.K == null && this.L != null) {
            Context context = getContext();
            Integer num = this.L;
            if (num != null) {
                View i2 = k.i(context, num.intValue(), null, false, 6, null);
                this.K = i2;
                Integer num2 = this.L;
                i2.setLayoutParams(p.v(-1, (num2 != null && num2.intValue() == R.layout.view_common_empty) ? -1 : -2));
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        return this.K;
    }

    private final View getErrorFooter() {
        if (this.M == null && this.N != null) {
            Context context = getContext();
            Integer num = this.N;
            if (num == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            this.M = k.i(context, num.intValue(), null, false, 6, null);
        }
        return this.M;
    }

    private final ListView$innerScrollListener$2.a getInnerScrollListener() {
        return (ListView$innerScrollListener$2.a) this.c0.getValue();
    }

    private final b getScroller() {
        return (b) this.O.getValue();
    }

    public final void I(@k.e.a.d RecyclerView.ItemDecoration itemDecoration) {
        getScrollable().addItemDecoration(itemDecoration);
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public final void L(@k.e.a.d final ViewPager viewPager) {
        getScrollable().setOnTouchListener(new View.OnTouchListener() { // from class: e.t.v.j.d
            {
                ListView.this = this;
            }

            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                boolean M;
                M = ListView.M(ListView.this, viewPager, view, motionEvent);
                return M;
            }
        });
    }

    public final void N() {
        this.T = false;
        J(FooterState.GONE);
    }

    public final void P() {
        RecyclerView.Adapter adapter = getScrollable().getAdapter();
        if (adapter == null) {
            return;
        }
        adapter.notifyDataSetChanged();
    }

    public final void Q(int i2, @k.e.a.e Boolean bool) {
        if (bool == null ? this.E : bool.booleanValue()) {
            getScroller().setTargetPosition(i2);
            RecyclerView.LayoutManager layoutManager = getScrollable().getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            layoutManager.startSmoothScroll(getScroller());
            return;
        }
        if (getScrollable().getScrollState() != 0) {
            getScrollable().stopScroll();
        }
        getScrollable().scrollToPosition(i2);
    }

    public final void R(@k.e.a.e RecyclerView.LayoutManager layoutManager, boolean z) {
        getScrollable().setLayoutManager(layoutManager);
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            if (linearLayoutManager.getOrientation() == 0) {
                getScrollable().setHorizontalScrollBarEnabled(true);
            }
            linearLayoutManager.setStackFromEnd(z);
        }
    }

    public final void T(int i2, int i3, int i4, int i5) {
        getScrollable().setPadding(i2, i3, i4, i5);
        getScrollable().setClipToPadding(false);
        requestLayout();
    }

    @Override // e.t.k.a.e.b
    public void a(@k.e.a.d e.t.k.a.e.a aVar) {
        if (this.b0 == null) {
            this.b0 = new ArrayList();
        }
        List<e.t.k.a.e.a> list = this.b0;
        if (list == null) {
            return;
        }
        list.add(aVar);
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void b(boolean z) {
        if (this.N == null) {
            return;
        }
        boolean z2 = false;
        if (z) {
            if (this.J || this.I) {
                return;
            }
            e.t.k.a.c.c<?> adapter = getAdapter();
            if (adapter != null && adapter.m()) {
                z2 = true;
            }
            if (z2) {
                e.t.k.a.c.c<?> adapter2 = getAdapter();
                if (adapter2 != null) {
                    View errorFooter = getErrorFooter();
                    if (errorFooter == null) {
                        return;
                    }
                    e.t.k.a.c.c.c(adapter2, errorFooter, false, true, 2, null);
                }
                this.J = true;
            }
        } else if (this.J) {
            e.t.k.a.c.c<?> adapter3 = getAdapter();
            if (adapter3 != null) {
                View errorFooter2 = getErrorFooter();
                if (errorFooter2 == null) {
                    return;
                }
                adapter3.w(errorFooter2);
            }
            this.J = false;
        }
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void c(boolean z) {
        if (this.L == null) {
            return;
        }
        if (z) {
            if (this.I) {
                return;
            }
            e.t.k.a.c.c<?> adapter = getAdapter();
            if (adapter != null) {
                View emptyFooter = getEmptyFooter();
                if (emptyFooter == null) {
                    return;
                }
                e.t.k.a.c.c.c(adapter, emptyFooter, true, false, 4, null);
            }
            this.I = true;
        } else if (this.I) {
            e.t.k.a.c.c<?> adapter2 = getAdapter();
            if (adapter2 != null) {
                View emptyFooter2 = getEmptyFooter();
                if (emptyFooter2 == null) {
                    return;
                }
                adapter2.w(emptyFooter2);
            }
            this.I = false;
        }
    }

    @Override // com.vector.design.ui.delegate.SwipeRefresh.a
    public void d() {
        B();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@k.e.a.e MotionEvent motionEvent) {
        if (motionEvent != null) {
            try {
                int action = motionEvent.getAction();
                if (action != 0) {
                    if (action != 1) {
                        if (action != 2) {
                            if (action != 3) {
                            }
                        } else if (Math.abs(((int) motionEvent.getX()) - this.d0) > Math.abs(((int) motionEvent.getY()) - this.e0)) {
                            getParent().requestDisallowInterceptTouchEvent(false);
                        } else {
                            getParent().requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    getParent().requestDisallowInterceptTouchEvent(false);
                } else {
                    this.d0 = (int) motionEvent.getX();
                    this.e0 = (int) motionEvent.getY();
                    getParent().requestDisallowInterceptTouchEvent(true);
                }
            } catch (IllegalArgumentException e2) {
                e2.printStackTrace();
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void e() {
        this.T = false;
        J(FooterState.LOADING);
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void f(@k.e.a.d LoadMore.State state) {
        this.T = false;
        int i2 = c.b[state.ordinal()];
        if (i2 == 1) {
            J(FooterState.LOADING);
        } else if (i2 == 2) {
            J(FooterState.ERROR);
        } else if (i2 == 3) {
            J(FooterState.GONE);
        } else if (i2 != 4) {
        } else {
            if (this.U) {
                J(FooterState.NO_MORE);
            } else {
                J(FooterState.GONE);
            }
        }
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void g(@k.e.a.d LoadMore.State state) {
        this.T = true;
        J(FooterState.LOADING);
        LoadMore.b bVar = this.W;
        if (bVar == null) {
            return;
        }
        bVar.a(state);
    }

    @k.e.a.e
    public e.t.k.a.c.c<?> getAdapter() {
        return this.H;
    }

    @k.e.a.e
    public final AttributeSet getAttrs() {
        return this.C;
    }

    @k.e.a.d
    public final RecyclerView.AdapterDataObserver getDataObserver() {
        return (RecyclerView.AdapterDataObserver) this.S.getValue();
    }

    @k.e.a.e
    public final Integer getEmptyFooterResId() {
        return this.L;
    }

    @k.e.a.e
    public final Integer getErrorFooterResId() {
        return this.N;
    }

    public final boolean getHasStableIds() {
        return this.F;
    }

    public final int getLimitShowNoMore() {
        return this.G;
    }

    @k.e.a.d
    public BaseFooter getLoadMoreFooter() {
        return this.a0;
    }

    public final boolean getPreLoad() {
        return this.P;
    }

    public final float getPreloadRate() {
        return this.Q;
    }

    @k.e.a.d
    public RecyclerView getRecyclerView() {
        RecyclerView recyclerView = new RecyclerView(getContext(), this.C);
        recyclerView.setItemViewCacheSize(0);
        return recyclerView;
    }

    @Override // e.t.v.j.g
    public int getSize() {
        e.t.k.a.c.c<?> adapter = getAdapter();
        if (adapter == null) {
            return 0;
        }
        return adapter.getItemCount();
    }

    public final boolean getSmoothScroll() {
        return this.E;
    }

    @Override // com.vector.design.ui.delegate.SwipeRefresh.a
    public void h() {
        if (ViewCompat.isLaidOut(this) && !isLayoutRequested()) {
            A();
        } else {
            addOnLayoutChangeListener(new f());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getScrollable().addOnScrollListener(getInnerScrollListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getScrollable().removeOnScrollListener(getInnerScrollListener());
    }

    @Override // android.view.View
    public void onRestoreInstanceState(@k.e.a.e Parcelable parcelable) {
        try {
            super.onRestoreInstanceState(parcelable);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void setAdapter(@k.e.a.e e.t.k.a.c.c<?> cVar) {
        if (cVar == null || f0.g(this.H, cVar)) {
            return;
        }
        e.t.k.a.c.c<?> cVar2 = this.H;
        if (cVar2 != null) {
            cVar2.unregisterAdapterDataObserver(getDataObserver());
        }
        cVar.setHasStableIds(this.F);
        getScrollable().setAdapter(cVar);
        cVar.registerAdapterDataObserver(getDataObserver());
        this.H = cVar;
    }

    public final void setEmptyFooterResId(@k.e.a.e Integer num) {
        this.L = num;
    }

    public final void setErrorFooterResId(@k.e.a.e Integer num) {
        this.N = num;
    }

    public final void setHasStableIds(boolean z) {
        this.F = z;
    }

    public final void setItemViewCacheSize(int i2) {
        getScrollable().setItemViewCacheSize(i2);
    }

    public final void setLimitShowNoMore(int i2) {
        this.G = i2;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        getScrollable().setNestedScrollingEnabled(z);
    }

    public final void setNoMoreText(@k.e.a.d String str) {
        getLoadMoreFooter().setNoMoreText(str);
    }

    @Override // com.vector.design.ui.delegate.LoadMore.a
    public void setOnLoadMoreListener(@k.e.a.d l<? super LoadMore.State, t1> lVar) {
        this.W = new d(lVar);
    }

    @Override // com.vector.design.ui.delegate.SwipeRefresh.a
    public void setOnSwipeRefreshListener(@k.e.a.d l<? super SwipeRefresh.State, t1> lVar) {
        setEnabledRefresh(true);
        setListener(new e(lVar));
    }

    public final void setPreLoad(boolean z) {
        this.P = z;
    }

    public final void setPreloadRate(float f2) {
        this.Q = f2;
    }

    public final void setScrollBarEnabled(boolean z) {
        getScrollable().setVerticalScrollBarEnabled(z);
        getScrollable().setHorizontalScrollBarEnabled(z);
    }

    public final void setScrollableHeight(int i2) {
        ViewKt.F(getScrollable(), i2);
    }

    public final void setShowNoMoreData(boolean z) {
        this.U = z;
    }

    public final void setSmoothScroll(boolean z) {
        this.E = z;
    }

    @h
    public ListView(@k.e.a.d Context context, @k.e.a.e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.C = attributeSet;
        this.D = z.c(new ListView$scrollable$2(this));
        this.O = z.c(new ListView$scroller$2(this, context));
        this.P = true;
        this.Q = m0;
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.S = z.b(lazyThreadSafetyMode, new ListView$dataObserver$2(this));
        l<Context, BaseFooter> b2 = e.t.a.c().b();
        BaseFooter invoke = b2 == null ? null : b2.invoke(context);
        this.a0 = invoke == null ? new DefaultFooter(context) : invoke;
        this.c0 = z.b(lazyThreadSafetyMode, new ListView$innerScrollListener$2(this));
        S(this, LayoutManagers.j(LayoutManagers.a, null, false, 3, null).create(context), false, 2, null);
        if (getId() == -1) {
            setId(ViewCompat.generateViewId());
        }
        this.f0 = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // e.t.v.j.g
    @k.e.a.d
    public final RecyclerView getScrollable() {
        return (RecyclerView) this.D.getValue();
    }
}
