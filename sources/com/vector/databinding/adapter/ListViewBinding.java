package com.vector.databinding.adapter;

import androidx.databinding.BindingAdapter;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.vector.design.ui.adapter.RecyclerClickSupport;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import com.vector.view.swipe.header.BaseHeader;
import e.t.j.h.d0;
import e.t.j.h.e0;
import e.t.j.h.f0;
import e.t.j.h.l;
import e.t.j.h.m;
import e.t.j.i.d.c;
import e.t.j.i.d.g;
import h.k2.k;
import h.k2.u.p;
import h.k2.u.r;
import h.t1;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jy\u0010+\u001a\u00020,\"\u0004\b\u0000\u0010-\"\u000e\b\u0001\u0010.*\b\u0012\u0004\u0012\u0002H-0/2\u0006\u00100\u001a\u0002012\u0006\u00102\u001a\u0002H.2\b\u00103\u001a\u0004\u0018\u0001042\u000e\u00105\u001a\n\u0012\u0004\u0012\u0002H-\u0018\u0001062\b\u00107\u001a\u0004\u0018\u0001082\b\u00109\u001a\u0004\u0018\u0001082\n\b\u0001\u0010:\u001a\u0004\u0018\u00010;2\n\b\u0001\u0010<\u001a\u0004\u0018\u00010;H\u0007¢\u0006\u0002\u0010=J\u0018\u0010>\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010?\u001a\u00020@H\u0007J\u001a\u0010A\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010B\u001a\u0004\u0018\u00010CH\u0007J\u0018\u0010D\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010E\u001a\u000204H\u0007J\u001a\u0010F\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010G\u001a\u0004\u0018\u00010HH\u0007J\u0018\u0010I\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010J\u001a\u00020;H\u0007J\"\u0010K\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u000204H\u0007J\u0018\u0010O\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010P\u001a\u00020QH\u0007J\u0018\u0010R\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010S\u001a\u000204H\u0007J\u001a\u0010T\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010U\u001a\u0004\u0018\u00010\u0004H\u0007J.\u0010V\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010W\u001a\u0004\u0018\u00010X2\b\u0010Y\u001a\u0004\u0018\u00010X2\b\u0010Z\u001a\u0004\u0018\u00010XH\u0007J\u0018\u0010[\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010W\u001a\u00020\\H\u0007J\u0018\u0010]\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010W\u001a\u00020\\H\u0007J.\u0010^\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010W\u001a\u0004\u0018\u00010_2\b\u0010Y\u001a\u0004\u0018\u00010_2\b\u0010Z\u001a\u0004\u0018\u00010_H\u0007J$\u0010`\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010a\u001a\u0004\u0018\u00010b2\b\u0010c\u001a\u0004\u0018\u00010dH\u0007J\u001a\u0010e\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\u0010W\u001a\u0004\u0018\u00010fH\u0007J\u0018\u0010g\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010h\u001a\u000204H\u0007J\u0018\u0010i\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010j\u001a\u00020kH\u0007J\u0018\u0010l\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010S\u001a\u000204H\u0007J\u0018\u0010m\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010?\u001a\u00020nH\u0007J\u0018\u0010o\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010?\u001a\u00020pH\u0007J\u0018\u0010q\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010r\u001a\u00020;H\u0007J\u0018\u0010s\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010t\u001a\u00020;H\u0007J\u001a\u0010u\u001a\u00020,2\u0006\u00100\u001a\u0002012\b\b\u0002\u0010v\u001a\u000204H\u0007J\u0018\u0010w\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010x\u001a\u000204H\u0007J\u0018\u0010y\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u00107\u001a\u00020zH\u0007J\u0018\u0010{\u001a\u00020,2\u0006\u00100\u001a\u0002012\u0006\u0010?\u001a\u00020|H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006}"}, d2 = {"Lcom/vector/databinding/adapter/ListViewBinding;", "", "()V", "ADAPTER", "", "DATA", "DECORATION", "EMPTY_FOOTER_ID", "ENABLE_REFRESH", "ERROR_FOOTER_ID", "FOOTER", "HAS_STABLE_IDS", "HEADER", "ITEM_VIEW_CACHE_SIZE", "LAYOUT_MANAGER", "LAYOUT_MANAGER_STACK_FORM_END", "LISTVIEW_ITEM_ANIMATOR", "MANAGER", "NESTED_SCROLLING_ENABLED", "NO_MORE_TEXT", "ON_FOOTER_CLICK", "ON_FOOTER_LONG_CLICK", "ON_HEADER_CLICK", "ON_HEADER_LONG_CLICK", "ON_ITEM_CLICK", "ON_ITEM_LONG_CLICK", "ON_LOAD_MORE", "ON_LOAD_MORE2", "ON_SCROLL", "ON_SCROLL_STATE_CHANGED", "ON_SWIPE", "PRELOAD", "PRELOAD_RATE", "SCROLLABLE_HEIGHT", "SCROLL_BAR_ENABLED", "SCROLL_TO_POSITION", "SHOW_NO_MORE_FOOTER", "SMOOTH_SCROLL", "SWIPE_HEADER", "TRIGGER_SCROLL_BY", "TRIGGER_SCROLL_TO_POSITION", "TRIGGER_SWIPE_REFRESH", "TRIGGER_TO_TOP", "setAdapter", "", ExifInterface.GPS_DIRECTION_TRUE, ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/vector/design/ui/adapter/MultiAdapterEx;", "view", "Lcom/vector/view/scrollable/ListView;", "adapter", "has", "", "data", "", "header", "Landroid/view/View;", "footer", "emptyFooterId", "", "errorFooterId", "(Lcom/vector/view/scrollable/ListView;Lcom/vector/design/ui/adapter/MultiAdapterEx;Ljava/lang/Boolean;Ljava/util/List;Landroid/view/View;Landroid/view/View;Ljava/lang/Integer;Ljava/lang/Integer;)V", "setAutoSwipeRefresh", "trigger", "Lcom/vector/databinding/trigger/list/ListRefreshTrigger;", "setDecoration", "decoration", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "setEnabledRefresh", "enabledRefresh", "setItemAnimator", "animator", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator;", "setItemViewCacheSize", "size", "setLayoutManager", "factory", "Lcom/vector/util/LayoutManagers$LayoutManagerFactory;", "stackEnd", "setManager", "layoutManager", "Landroidx/recyclerview/widget/RecyclerView$LayoutManager;", "setNestedScrollingEnabled", "isEnabled", "setNoMoreText", "text", "setOnClick", "binding", "Lcom/vector/databinding/onBind/OnItemClickBinding;", "headerBinding", "footerBinding", "setOnLoadMore", "Lcom/vector/databinding/onBind/OnLoadMoreBinding;", "setOnLoadMore2", "setOnLongClick", "Lcom/vector/databinding/onBind/OnItemLongClickBinding;", "setOnScroll", "onScroll", "Lcom/vector/databinding/onBind/OnScrollBinding;", "onStateChanged", "Lcom/vector/databinding/onBind/OnScrollStateChangedBinding;", "setOnSwipe", "Lcom/vector/databinding/onBind/OnSwipeBinding;", "setPreload", "enable", "setPreloadRate", "rate", "", "setScrollBarEnabled", "setScrollBy", "Lcom/vector/databinding/trigger/list/ListScrollByTrigger;", "setScrollToPosition", "Lcom/vector/databinding/trigger/list/ListScrollToPositionTrigger;", "setScrollableHeight", "height", "setSelectedItemPosition", "position", "setShowNoMoreFooter", TTLogUtil.TAG_EVENT_SHOW, "setSmoothScroll", "smoothScroll", "setSwipeHeader", "Lcom/vector/view/swipe/header/BaseHeader;", "setToTop", "Lcom/vector/databinding/trigger/list/ListToTopTrigger;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class ListViewBinding {
    @d
    private static final String A = "android:listView_scrollableHeight";
    @d
    private static final String B = "android:listView_emptyFooterResId";
    @d
    private static final String C = "android:listView_errorFooterResId";
    @d
    private static final String D = "android:listView_enabledRefresh";
    @d
    private static final String E = "android:listView_preload";
    @d
    private static final String F = "android:listView_preload_rate";
    @d
    private static final String G = "android:listView_trigger_SwipeRefresh";
    @d
    private static final String H = "android:listView_trigger_toTop";
    @d
    private static final String I = "android:listView_trigger_scrollBy";
    @d
    private static final String J = "android:listView_trigger_scrollToPosition";
    @d
    private static final String K = "android:listView_showNoMoreFooter";
    @d
    private static final String L = "android:listView_itemAnimator";
    @d
    private static final String M = "android:listView_itemViewCacheSize";
    @d
    private static final String N = "android:listView_noMoreText";
    @d
    public static final ListViewBinding a = new ListViewBinding();
    @d
    private static final String b = "android:listView_onScroll";
    @d

    /* renamed from: c  reason: collision with root package name */
    private static final String f7678c = "android:listView_onScrollStateChanged";
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final String f7679d = "android:listView_onItemClick";
    @d

    /* renamed from: e  reason: collision with root package name */
    private static final String f7680e = "android:listView_onHeaderClick";
    @d

    /* renamed from: f  reason: collision with root package name */
    private static final String f7681f = "android:listView_onFooterClick";
    @d

    /* renamed from: g  reason: collision with root package name */
    private static final String f7682g = "android:listView_onItemLongClick";
    @d

    /* renamed from: h  reason: collision with root package name */
    private static final String f7683h = "android:listView_onHeaderLongClick";
    @d

    /* renamed from: i  reason: collision with root package name */
    private static final String f7684i = "android:listView_onFooterLongClick";
    @d

    /* renamed from: j  reason: collision with root package name */
    private static final String f7685j = "android:listView_adapter";
    @d

    /* renamed from: k  reason: collision with root package name */
    private static final String f7686k = "android:listView_data";
    @d

    /* renamed from: l  reason: collision with root package name */
    private static final String f7687l = "android:listView_decoration";
    @d

    /* renamed from: m  reason: collision with root package name */
    private static final String f7688m = "android:listView_swipeHeader";
    @d
    private static final String n = "android:listView_onSwipe";
    @d
    private static final String o = "android:listView_onLoadMore";
    @d
    private static final String p = "android:listView_onLoadMore2";
    @d
    private static final String q = "android:listView_header";
    @d
    private static final String r = "android:listView_footer";
    @d
    private static final String s = "android:listView_scrollToPosition";
    @d
    private static final String t = "android:listView_smoothScroll";
    @d
    private static final String u = "android:listView_layoutManager";
    @d
    private static final String v = "android:listView_manager";
    @d
    private static final String w = "android:listView_layoutManager_stackEnd";
    @d
    private static final String x = "android:listView_hasStableIds";
    @d
    private static final String y = "android:listView_scrollBarEnabled";
    @d
    private static final String z = "android:listView_nestedScrollingEnabled";

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H\u0016J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"com/vector/databinding/adapter/ListViewBinding$setOnScroll$1", "Lcom/vector/design/ui/delegate/OnScrollMixListener;", "state", "", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "onScrolled", "dx", "dy", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends e.t.k.a.e.a {
        private int a;
        public final /* synthetic */ e0 b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d0 f7689c;

        public a(e0 e0Var, d0 d0Var) {
            this.b = e0Var;
            this.f7689c = d0Var;
        }

        @Override // e.t.k.a.e.a, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(@d RecyclerView recyclerView, int i2) {
            p<RecyclerView, Integer, t1> a;
            this.a = i2;
            e0 e0Var = this.b;
            if (e0Var == null || (a = e0Var.a()) == null) {
                return;
            }
            a.invoke(recyclerView, Integer.valueOf(i2));
        }

        @Override // e.t.k.a.e.a, androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(@d RecyclerView recyclerView, int i2, int i3) {
            r<RecyclerView, Integer, Integer, Integer, t1> a;
            d0 d0Var = this.f7689c;
            if (d0Var == null || (a = d0Var.a()) == null) {
                return;
            }
            a.invoke(recyclerView, Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(this.a));
        }
    }

    private ListViewBinding() {
    }

    @BindingAdapter({t})
    @k
    public static final void A(@d ListView listView, boolean z2) {
        listView.setSmoothScroll(z2);
    }

    @BindingAdapter({f7688m})
    @k
    public static final void B(@d ListView listView, @d BaseHeader baseHeader) {
        listView.setHeader(baseHeader);
    }

    @BindingAdapter({H})
    @k
    public static final void C(@d ListView listView, @d g gVar) {
        gVar.a(new ListViewBinding$setToTop$1(listView));
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        if (h.k2.v.f0.g(r0 == null ? null : r0.l(), r7) == false) goto L12;
     */
    @androidx.databinding.BindingAdapter(requireAll = false, value = {com.vector.databinding.adapter.ListViewBinding.f7685j, com.vector.databinding.adapter.ListViewBinding.x, com.vector.databinding.adapter.ListViewBinding.f7686k, com.vector.databinding.adapter.ListViewBinding.q, com.vector.databinding.adapter.ListViewBinding.r, com.vector.databinding.adapter.ListViewBinding.B, com.vector.databinding.adapter.ListViewBinding.C})
    @h.k2.k
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, A extends e.t.k.a.c.f<T>> void a(@k.e.a.d com.vector.view.scrollable.ListView r6, @k.e.a.d A r7, @k.e.a.e java.lang.Boolean r8, @k.e.a.e java.util.List<? extends T> r9, @k.e.a.e android.view.View r10, @k.e.a.e android.view.View r11, @androidx.annotation.LayoutRes @k.e.a.e java.lang.Integer r12, @androidx.annotation.LayoutRes @k.e.a.e java.lang.Integer r13) {
        /*
            e.t.k.a.c.c r0 = r6.getAdapter()
            if (r0 == 0) goto L18
            e.t.k.a.c.c r0 = r6.getAdapter()
            if (r0 != 0) goto Le
            r0 = 0
            goto L12
        Le:
            e.t.k.a.c.f r0 = r0.l()
        L12:
            boolean r0 = h.k2.v.f0.g(r0, r7)
            if (r0 != 0) goto L45
        L18:
            if (r12 == 0) goto L1d
            r6.setEmptyFooterResId(r12)
        L1d:
            if (r13 == 0) goto L22
            r6.setErrorFooterResId(r13)
        L22:
            if (r8 == 0) goto L2b
            boolean r8 = r8.booleanValue()
            r6.setHasStableIds(r8)
        L2b:
            e.t.k.a.c.c r8 = new e.t.k.a.c.c
            r8.<init>(r7)
            if (r10 == 0) goto L35
            r8.d(r10)
        L35:
            if (r11 == 0) goto L40
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            r0 = r8
            r1 = r11
            e.t.k.a.c.c.c(r0, r1, r2, r3, r4, r5)
        L40:
            h.t1 r10 = h.t1.a
            r6.setAdapter(r8)
        L45:
            r7.setData(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vector.databinding.adapter.ListViewBinding.a(com.vector.view.scrollable.ListView, e.t.k.a.c.f, java.lang.Boolean, java.util.List, android.view.View, android.view.View, java.lang.Integer, java.lang.Integer):void");
    }

    @BindingAdapter({G})
    @k
    public static final void b(@d ListView listView, @d e.t.j.i.d.a aVar) {
        aVar.a(new ListViewBinding$setAutoSwipeRefresh$1(listView));
    }

    @BindingAdapter({f7687l})
    @k
    public static final void c(@d ListView listView, @e RecyclerView.ItemDecoration itemDecoration) {
        if (itemDecoration == null) {
            return;
        }
        listView.I(itemDecoration);
    }

    @BindingAdapter({D})
    @k
    public static final void d(@d ListView listView, boolean z2) {
        listView.setEnabledRefresh(z2);
    }

    @BindingAdapter({L})
    @k
    public static final void e(@d ListView listView, @e RecyclerView.ItemAnimator itemAnimator) {
        listView.getScrollable().setItemAnimator(itemAnimator);
    }

    @BindingAdapter({M})
    @k
    public static final void f(@d ListView listView, int i2) {
        listView.setItemViewCacheSize(i2);
    }

    @BindingAdapter(requireAll = false, value = {u, w})
    @k
    public static final void g(@d ListView listView, @d LayoutManagers.a aVar, boolean z2) {
        RecyclerView.LayoutManager create = aVar.create(listView.getContext());
        if (create instanceof GridLayoutManager) {
            listView.getScrollable().setHasFixedSize(true);
        }
        listView.R(create, z2);
    }

    public static /* synthetic */ void h(ListView listView, LayoutManagers.a aVar, boolean z2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z2 = false;
        }
        g(listView, aVar, z2);
    }

    @BindingAdapter(requireAll = false, value = {v})
    @k
    public static final void i(@d ListView listView, @d RecyclerView.LayoutManager layoutManager) {
        ListView.S(listView, layoutManager, false, 2, null);
    }

    @BindingAdapter({z})
    @k
    public static final void j(@d ListView listView, boolean z2) {
        listView.setNestedScrollingEnabled(z2);
    }

    @BindingAdapter({N})
    @k
    public static final void k(@d ListView listView, @e String str) {
        if (str == null) {
            return;
        }
        listView.setNoMoreText(str);
    }

    @BindingAdapter(requireAll = false, value = {f7679d, f7680e, f7681f})
    @k
    public static final void l(@d ListView listView, @e l lVar, @e l lVar2, @e l lVar3) {
        RecyclerClickSupport.f7735d.a(listView.getScrollable()).d(new ListViewBinding$setOnClick$1(listView, lVar2, lVar3, lVar));
    }

    @BindingAdapter({o})
    @k
    public static final void m(@d ListView listView, @d e.t.j.h.p pVar) {
        listView.e();
        listView.setOnLoadMoreListener(new ListViewBinding$setOnLoadMore$1(pVar, listView));
    }

    @BindingAdapter({p})
    @k
    public static final void n(@d ListView listView, @d e.t.j.h.p pVar) {
        listView.setOnLoadMoreListener(new ListViewBinding$setOnLoadMore2$1(pVar, listView));
    }

    @BindingAdapter(requireAll = false, value = {f7682g, f7683h, f7684i})
    @k
    public static final void o(@d ListView listView, @e m mVar, @e m mVar2, @e m mVar3) {
        RecyclerClickSupport.f7735d.a(listView.getScrollable()).e(new ListViewBinding$setOnLongClick$1(listView, mVar2, mVar3, mVar));
    }

    @BindingAdapter(requireAll = false, value = {b, f7678c})
    @k
    public static final void p(@d ListView listView, @e d0 d0Var, @e e0 e0Var) {
        if (d0Var == null && e0Var == null) {
            return;
        }
        listView.a(new a(e0Var, d0Var));
    }

    @BindingAdapter({n})
    @k
    public static final void q(@d ListView listView, @e f0 f0Var) {
        if (f0Var == null) {
            return;
        }
        listView.setOnSwipeRefreshListener(new ListViewBinding$setOnSwipe$1(f0Var, listView));
    }

    @BindingAdapter({E})
    @k
    public static final void r(@d ListView listView, boolean z2) {
        listView.setPreLoad(z2);
    }

    @BindingAdapter({F})
    @k
    public static final void s(@d ListView listView, float f2) {
        listView.setPreloadRate(f2);
    }

    @BindingAdapter({y})
    @k
    public static final void t(@d ListView listView, boolean z2) {
        listView.setScrollBarEnabled(z2);
    }

    @BindingAdapter({I})
    @k
    public static final void u(@d ListView listView, @d c cVar) {
        cVar.a(new ListViewBinding$setScrollBy$1(listView));
    }

    @BindingAdapter({J})
    @k
    public static final void v(@d ListView listView, @d e.t.j.i.d.e eVar) {
        eVar.a(new ListViewBinding$setScrollToPosition$1(listView));
    }

    @BindingAdapter({A})
    @k
    public static final void w(@d ListView listView, int i2) {
        listView.setScrollableHeight(i2);
    }

    @BindingAdapter({s})
    @k
    public static final void x(@d ListView listView, int i2) {
        listView.Q(i2, null);
    }

    @BindingAdapter({K})
    @k
    public static final void y(@d ListView listView, boolean z2) {
        listView.setShowNoMoreData(z2);
    }

    public static /* synthetic */ void z(ListView listView, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        y(listView, z2);
    }
}
