package e.t.j.g;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.AbsListView;
import androidx.databinding.BindingAdapter;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.pangle.servermanager.AbsServerManager;
import com.vector.view.ExpandableListViewEx;
import com.vector.view.scrollable.GroupListView;
import h.r0;
import h.t1;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jm\u0010\u0016\u001a\u00020\u0017\"\u000e\b\u0000\u0010\u0018*\b\u0012\u0004\u0012\u0002H\u001a0\u0019\"\u0004\b\u0001\u0010\u001a\"\u0014\b\u0002\u0010\u001b*\u000e\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001a0\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u0002H\u001b2\u000e\u0010 \u001a\n\u0012\u0004\u0012\u0002H\u0018\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010#H\u0007¢\u0006\u0002\u0010%J\u001f\u0010&\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007¢\u0006\u0002\u0010)J\u001a\u0010*\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010+\u001a\u0004\u0018\u00010,H\u0007J\u001a\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010#H\u0007J\u001f\u0010/\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010'\u001a\u0004\u0018\u00010(H\u0007¢\u0006\u0002\u0010)J\u0018\u00100\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00101\u001a\u000202H\u0007J\u0018\u00103\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001e2\u0006\u00104\u001a\u000202H\u0007J\u001a\u00105\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\b\u00106\u001a\u0004\u0018\u00010,H\u0007J\u001c\u00107\u001a\u00020\u00172\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u00108\u001a\u0004\u0018\u000109H\u0007J\u0018\u0010:\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u00108\u001a\u00020;H\u0007J\u001a\u0010<\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u001e2\b\u0010=\u001a\u0004\u0018\u00010>H\u0007J\u0018\u0010?\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010'\u001a\u00020(H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006@"}, d2 = {"Lcom/vector/databinding/adapter/GroupListViewBinding;", "", "()V", "ADAPTER", "", "COLLAPSE", "DATA", "DIVIDER", "EMPTY_FOOTER", "ENABLE_REFRESH", "EXPAND", "EXPAND_ALL_GROUPS", "FLOAT_GROUP", "FOOTER", "GROUP_INDICATOR", "HEADER", "ON_Child_CLICK", "ON_GROUP_CLICK", "ON_LOAD_MORE", "ON_SCROLL", "ON_SWIPE", "SCROLL_TO_GROUP", "setAdapter", "", "GROUP", "Lcom/vector/model/Group;", "CHILD", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;", "view", "Lcom/vector/view/scrollable/GroupListView;", "adapter", "data", "", "header", "Landroid/view/View;", "footer", "(Lcom/vector/view/scrollable/GroupListView;Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;Ljava/util/List;Landroid/view/View;Landroid/view/View;)V", "setCollapse", "groupPosition", "", "(Lcom/vector/view/scrollable/GroupListView;Ljava/lang/Integer;)V", "setDivider", "divider", "Landroid/graphics/drawable/Drawable;", "setEmptyFooter", "groupListView", "setExpand", "setExpandAllGroups", "expandAll", "", "setFloatGroup", "float", "setGroupIndicator", "indicator", "setOnChildClick", AbsServerManager.BUNDLE_BINDER, "Lcom/vector/databinding/onBind/OnChildClickBinder;", "setOnGroupClick", "Lcom/vector/databinding/onBind/OnGroupClickBinder;", "setOnScroll", "onScroll", "Lcom/vector/databinding/onBind/OnScrollBinding;", "setScrollToGroup", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class w {
    @k.e.a.d
    public static final w a = new w();
    @k.e.a.d
    private static final String b = "android:groupListView_onScroll";
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final String f14520c = "android:groupListView_adapter";
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final String f14521d = "android:groupListView_data";
    @k.e.a.d

    /* renamed from: e  reason: collision with root package name */
    private static final String f14522e = "android:groupListView_header";
    @k.e.a.d

    /* renamed from: f  reason: collision with root package name */
    private static final String f14523f = "android:groupListView_footer";
    @k.e.a.d

    /* renamed from: g  reason: collision with root package name */
    private static final String f14524g = "android:groupListView_onGroupClick";
    @k.e.a.d

    /* renamed from: h  reason: collision with root package name */
    private static final String f14525h = "android:groupListView_onChildClick";
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    private static final String f14526i = "android:groupListView_onSwipe";
    @k.e.a.d

    /* renamed from: j  reason: collision with root package name */
    private static final String f14527j = "android:groupListView_onLoadMore";
    @k.e.a.d

    /* renamed from: k  reason: collision with root package name */
    private static final String f14528k = "android:groupListView_expandAllGroups";
    @k.e.a.d

    /* renamed from: l  reason: collision with root package name */
    private static final String f14529l = "android:groupListView_scrollToGroup";
    @k.e.a.d

    /* renamed from: m  reason: collision with root package name */
    private static final String f14530m = "android:groupListView_divider";
    @k.e.a.d
    private static final String n = "android:groupListView_indicator";
    @k.e.a.d
    private static final String o = "android:groupListView_expand";
    @k.e.a.d
    private static final String p = "android:groupListView_collapse";
    @k.e.a.d
    private static final String q = "android:groupListView_floatGroup";
    @k.e.a.d
    private static final String r = "android:groupListView_emptyFooter";
    @k.e.a.d
    private static final String s = "android:groupListView_enableRefresh";

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0016¨\u0006\n"}, d2 = {"com/vector/databinding/adapter/GroupListViewBinding$setOnScroll$1", "Lcom/vector/design/ui/delegate/OnScrollMixListener;", "onScroll", "", "view", "Landroid/widget/AbsListView;", "firstVisibleItem", "", "visibleItemCount", "totalItemCount", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a extends e.t.k.a.e.a {
        public final /* synthetic */ e.t.j.h.d0 a;

        public a(e.t.j.h.d0 d0Var) {
            this.a = d0Var;
        }

        @Override // e.t.k.a.e.a, android.widget.AbsListView.OnScrollListener
        public void onScroll(@k.e.a.d AbsListView absListView, int i2, int i3, int i4) {
            this.a.a().invoke(null, 0, 0, 0);
        }
    }

    private w() {
    }

    @BindingAdapter(requireAll = false, value = {f14520c, f14521d, f14522e, f14523f})
    @h.k2.k
    public static final <GROUP extends e.t.q.a<CHILD>, CHILD, A extends e.t.k.a.c.e<GROUP, CHILD>> void a(@k.e.a.d GroupListView groupListView, @k.e.a.d A a2, @k.e.a.e List<? extends GROUP> list, @k.e.a.e View view, @k.e.a.e View view2) {
        Object m106constructorimpl;
        try {
            Result.a aVar = Result.Companion;
            if (groupListView.getAdapter() == null || !h.k2.v.f0.g(groupListView.getAdapter(), a2)) {
                groupListView.setAdapter(a2);
                if (view != null) {
                    groupListView.h(view);
                }
                if (view2 != null) {
                    GroupListView.g(groupListView, view2, false, 2, null);
                }
                ExpandableListViewEx scrollable = groupListView.getScrollable();
                if (scrollable != null) {
                    scrollable.setDividerHeight(0);
                }
            }
            a2.g(list);
            m106constructorimpl = Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            m106constructorimpl = Result.m106constructorimpl(r0.a(th));
        }
        Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(m106constructorimpl);
        if (m109exceptionOrNullimpl != null) {
            String message = m109exceptionOrNullimpl.getMessage();
            if (message == null) {
                message = "";
            }
            Log.e("GroupListViewBinding", message);
        }
    }

    @BindingAdapter({p})
    @h.k2.k
    public static final void b(@k.e.a.d GroupListView groupListView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        ExpandableListViewEx scrollable = groupListView.getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.collapseGroup(intValue);
    }

    @BindingAdapter({f14530m})
    @h.k2.k
    public static final void c(@k.e.a.d GroupListView groupListView, @k.e.a.e Drawable drawable) {
        ExpandableListViewEx scrollable = groupListView.getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setDivider(drawable);
    }

    @BindingAdapter({r})
    @h.k2.k
    public static final void d(@k.e.a.d GroupListView groupListView, @k.e.a.e View view) {
        if (view == null) {
            return;
        }
        groupListView.setEmptyFooter(view);
    }

    @BindingAdapter({o})
    @h.k2.k
    public static final void e(@k.e.a.d GroupListView groupListView, @k.e.a.e Integer num) {
        if (num == null) {
            return;
        }
        int intValue = num.intValue();
        ExpandableListViewEx scrollable = groupListView.getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.expandGroup(intValue);
    }

    @BindingAdapter({f14528k})
    @h.k2.k
    public static final void f(@k.e.a.d GroupListView groupListView, boolean z) {
        groupListView.setExpandAll(z);
    }

    @BindingAdapter({q})
    @h.k2.k
    public static final void g(@k.e.a.d GroupListView groupListView, boolean z) {
        groupListView.setFloatGroup(z);
    }

    @BindingAdapter({n})
    @h.k2.k
    public static final void h(@k.e.a.d GroupListView groupListView, @k.e.a.e Drawable drawable) {
        ExpandableListViewEx scrollable = groupListView.getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setGroupIndicator(drawable);
    }

    @BindingAdapter({f14525h})
    @h.k2.k
    public static final void i(@k.e.a.e GroupListView groupListView, @k.e.a.e e.t.j.h.f fVar) {
        Object m106constructorimpl;
        t1 t1Var;
        if (fVar != null) {
            try {
                Result.a aVar = Result.Companion;
                if (groupListView == null) {
                    t1Var = null;
                } else {
                    groupListView.setOnChildClickListener(fVar.a());
                    t1Var = t1.a;
                }
                m106constructorimpl = Result.m106constructorimpl(t1Var);
            } catch (Throwable th) {
                Result.a aVar2 = Result.Companion;
                m106constructorimpl = Result.m106constructorimpl(r0.a(th));
            }
            Throwable m109exceptionOrNullimpl = Result.m109exceptionOrNullimpl(m106constructorimpl);
            if (m109exceptionOrNullimpl != null) {
                String message = m109exceptionOrNullimpl.getMessage();
                if (message == null) {
                    message = "";
                }
                Log.e("GroupListViewBinding", message);
            }
        }
    }

    @BindingAdapter({f14524g})
    @h.k2.k
    public static final void j(@k.e.a.d GroupListView groupListView, @k.e.a.d e.t.j.h.k kVar) {
        groupListView.setOnGroupClickListener(kVar.a());
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void k(@k.e.a.d GroupListView groupListView, @k.e.a.e e.t.j.h.d0 d0Var) {
        if (d0Var != null) {
            groupListView.i(new a(d0Var));
        }
    }

    @BindingAdapter({f14529l})
    @h.k2.k
    public static final void l(@k.e.a.d GroupListView groupListView, int i2) {
        groupListView.p(i2);
    }
}
