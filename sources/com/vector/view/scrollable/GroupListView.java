package com.vector.view.scrollable;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import androidx.appcompat.view.ContextThemeWrapper;
import com.qiniu.android.collect.ReportItem;
import com.vector.R;
import com.vector.design.ui.delegate.LoadMore;
import com.vector.view.ExpandableListViewEx;
import com.vector.view.scrollable.GroupListView;
import com.vector.view.scrollable.GroupListView$innerOnScrollListener$2;
import com.vector.view.swipe.footer.BaseFooter;
import e.j.a.b.c.r.c0;
import e.t.v.j.h;
import h.k2.u.q;
import h.k2.u.r;
import h.k2.v.f0;
import h.k2.v.u;
import h.w;
import h.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\b\u0006\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001)\u0018\u0000 _2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001_B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0018\u0010A\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001f2\b\b\u0002\u0010D\u001a\u00020\u0013J\u000e\u0010E\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001fJ\u000e\u0010F\u001a\u00020B2\u0006\u0010G\u001a\u000209J\b\u0010H\u001a\u00020BH\u0002J\b\u0010I\u001a\u00020BH\u0002J\b\u0010J\u001a\u00020BH\u0014J\b\u0010K\u001a\u00020BH\u0014J\u0010\u0010L\u001a\u00020B2\u0006\u0010C\u001a\u00020\u001fH\u0002J\u001e\u0010M\u001a\u00020B2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\t2\u0006\u0010P\u001a\u00020\u0013J\u000e\u0010Q\u001a\u00020B2\u0006\u0010N\u001a\u00020\tJ\u001c\u0010R\u001a\u00020B2\u0006\u0010C\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002J\u000e\u0010S\u001a\u00020B2\u0006\u0010T\u001a\u00020\u0013Jl\u0010U\u001a\u00020B2d\u0010V\u001a`\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(O\u0012\u0013\u0012\u00110/¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\u00130Wj\u0002`[JW\u0010\\\u001a\u00020B2O\u0010V\u001aK\u0012\u0013\u0012\u00110\u001f¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(C\u0012\u0013\u0012\u00110\t¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(N\u0012\u0013\u0012\u00110/¢\u0006\f\bX\u0012\b\bY\u0012\u0004\b\b(Z\u0012\u0004\u0012\u00020\u00130]j\u0002`^R8\u0010\r\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f2\u0010\u0010\u000b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001e\u001a\u0004\u0018\u00010\u001fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010%\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0015\"\u0004\b'\u0010\u0017R\u001b\u0010(\u001a\u00020)8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u001d\u001a\u0004\b*\u0010+R\u000e\u0010-\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u00100\u001a\u0002018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u001d\u001a\u0004\b2\u00103R\u0010\u00105\u001a\u0004\u0018\u000106X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\n\u0012\u0004\u0012\u000209\u0018\u000108X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010:\u001a\u0004\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b=\u0010\u001d\u001a\u0004\b;\u0010<R\u0014\u0010>\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b?\u0010@¨\u0006`"}, d2 = {"Lcom/vector/view/scrollable/GroupListView;", "Landroid/widget/FrameLayout;", "Lcom/vector/view/scrollable/ScrollableViewNullable;", "Lcom/vector/view/ExpandableListViewEx;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;", "adapter", "getAdapter", "()Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;", "setAdapter", "(Lcom/vector/design/ui/adapter/GroupMultiAdapterEx;)V", "autoExpandCollapse", "", "getAutoExpandCollapse", "()Z", "setAutoExpandCollapse", "(Z)V", "dataSetObserver", "Landroid/database/DataSetObserver;", "getDataSetObserver", "()Landroid/database/DataSetObserver;", "dataSetObserver$delegate", "Lkotlin/Lazy;", "emptyFooter", "Landroid/view/View;", "getEmptyFooter", "()Landroid/view/View;", "setEmptyFooter", "(Landroid/view/View;)V", "emptyFooterAdded", "expandAll", "getExpandAll", "setExpandAll", "innerOnScrollListener", "com/vector/view/scrollable/GroupListView$innerOnScrollListener$2$1", "getInnerOnScrollListener", "()Lcom/vector/view/scrollable/GroupListView$innerOnScrollListener$2$1;", "innerOnScrollListener$delegate", "isLoadingMore", "lastClickTime", "", "loadMoreFooter", "Lcom/vector/view/swipe/footer/BaseFooter;", "getLoadMoreFooter", "()Lcom/vector/view/swipe/footer/BaseFooter;", "loadMoreFooter$delegate", "loadMoreListener", "Lcom/vector/design/ui/delegate/LoadMore$Listener;", "scrollListeners", "", "Lcom/vector/design/ui/delegate/OnScrollMixListener;", "scrollable", "getScrollable", "()Lcom/vector/view/ExpandableListViewEx;", "scrollable$delegate", "size", "getSize", "()I", "addFooter", "", "v", "selectable", "addHeader", "addOnScrollListener", c0.a.a, "collapseGroupAllGroups", "expandAllGroups", "onAttachedToWindow", "onDetachedFromWindow", "removeFooter", "scrollToChild", "groupPosition", "childPosition", "shouldExpandGroup", "scrollToGroup", "setAttrs", "setFloatGroup", "float", "setOnChildClickListener", ReportItem.LogTypeBlock, "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "id", "Lcom/vector/view/scrollable/OnChildClick;", "setOnGroupClickListener", "Lkotlin/Function3;", "Lcom/vector/view/scrollable/OnGroupClick;", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class GroupListView extends FrameLayout implements h<ExpandableListViewEx> {
    @d
    public static final a n = new a(null);
    public static final int o = 1000;
    @d
    private final w a;
    @e
    private e.t.k.a.c.e<?, ?> b;

    /* renamed from: c */
    private boolean f8039c;

    /* renamed from: d */
    private boolean f8040d;
    @d

    /* renamed from: e */
    private final w f8041e;

    /* renamed from: f */
    private boolean f8042f;
    @e

    /* renamed from: g */
    private View f8043g;

    /* renamed from: h */
    private boolean f8044h;
    @e

    /* renamed from: i */
    private LoadMore.b f8045i;
    @d

    /* renamed from: j */
    private final w f8046j;
    @e

    /* renamed from: k */
    private List<e.t.k.a.e.a> f8047k;
    @d

    /* renamed from: l */
    private final w f8048l;

    /* renamed from: m */
    private long f8049m;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vector/view/scrollable/GroupListView$Companion;", "", "()V", "MIN_CLICK_INTERVAL", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @h.k2.h
    public GroupListView(@d Context context) {
        this(context, null, 0, 6, null);
    }

    @h.k2.h
    public GroupListView(@d Context context, @e AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public /* synthetic */ GroupListView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public static /* synthetic */ void g(GroupListView groupListView, View view, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        groupListView.f(view, z);
    }

    private final DataSetObserver getDataSetObserver() {
        return (DataSetObserver) this.f8041e.getValue();
    }

    private final GroupListView$innerOnScrollListener$2.a getInnerOnScrollListener() {
        return (GroupListView$innerOnScrollListener$2.a) this.f8048l.getValue();
    }

    private final BaseFooter getLoadMoreFooter() {
        return (BaseFooter) this.f8046j.getValue();
    }

    public final void j() {
        e.t.k.a.c.e<?, ?> eVar = this.b;
        int i2 = 0;
        int groupCount = eVar == null ? 0 : eVar.getGroupCount();
        if (groupCount <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            ExpandableListViewEx scrollable = getScrollable();
            if (scrollable != null) {
                scrollable.collapseGroup(i2);
            }
            if (i3 >= groupCount) {
                return;
            }
            i2 = i3;
        }
    }

    public final void k() {
        e.t.k.a.c.e<?, ?> eVar = this.b;
        int i2 = 0;
        int groupCount = eVar == null ? 0 : eVar.getGroupCount();
        if (groupCount <= 0) {
            return;
        }
        while (true) {
            int i3 = i2 + 1;
            ExpandableListViewEx scrollable = getScrollable();
            if (scrollable != null) {
                scrollable.expandGroup(i2);
            }
            if (i3 >= groupCount) {
                return;
            }
            i2 = i3;
        }
    }

    public static /* synthetic */ boolean l(q qVar, ExpandableListView expandableListView, View view, int i2, long j2) {
        return t(qVar, expandableListView, view, i2, j2);
    }

    public static /* synthetic */ boolean m(GroupListView groupListView, r rVar, ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        return s(groupListView, rVar, expandableListView, view, i2, i3, j2);
    }

    private final void n(View view) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.removeFooterView(view);
    }

    private final void q(ExpandableListViewEx expandableListViewEx, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = new ContextThemeWrapper(getContext(), R.style.View_List_Group).obtainStyledAttributes(attributeSet, R.styleable.GroupListView);
        expandableListViewEx.setGroupIndicator(obtainStyledAttributes.getDrawable(R.styleable.GroupListView_android_groupIndicator));
        expandableListViewEx.setChildDivider(obtainStyledAttributes.getDrawable(R.styleable.GroupListView_android_childDivider));
        obtainStyledAttributes.recycle();
    }

    public static /* synthetic */ void r(GroupListView groupListView, ExpandableListViewEx expandableListViewEx, AttributeSet attributeSet, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            attributeSet = null;
        }
        groupListView.q(expandableListViewEx, attributeSet);
    }

    public static final boolean s(GroupListView groupListView, r rVar, ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - groupListView.f8049m > 1000) {
            groupListView.f8049m = currentTimeMillis;
            return ((Boolean) rVar.invoke(view, Integer.valueOf(i2), Integer.valueOf(i3), Long.valueOf(j2))).booleanValue();
        }
        return false;
    }

    public static final boolean t(q qVar, ExpandableListView expandableListView, View view, int i2, long j2) {
        return ((Boolean) qVar.invoke(view, Integer.valueOf(i2), Long.valueOf(j2))).booleanValue();
    }

    public final void f(@d View view, boolean z) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.addFooterView(view, null, z);
    }

    @e
    public final e.t.k.a.c.e<?, ?> getAdapter() {
        return this.b;
    }

    public final boolean getAutoExpandCollapse() {
        return this.f8040d;
    }

    @e
    public final View getEmptyFooter() {
        return this.f8043g;
    }

    public final boolean getExpandAll() {
        return this.f8039c;
    }

    @Override // e.t.v.j.h
    public int getSize() {
        e.t.k.a.c.e<?, ?> eVar = this.b;
        if (eVar == null) {
            return 0;
        }
        return eVar.getGroupCount();
    }

    public final void h(@d View view) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.addHeaderView(view);
    }

    public final void i(@d e.t.k.a.e.a aVar) {
        if (this.f8047k == null) {
            this.f8047k = new ArrayList();
        }
        List<e.t.k.a.e.a> list = this.f8047k;
        if (list == null) {
            return;
        }
        list.add(aVar);
    }

    public final void o(int i2, int i3, boolean z) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setSelectedChild(i2, i3, z);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setOnScrollListener(getInnerOnScrollListener());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setOnScrollListener(null);
    }

    public final void p(int i2) {
        ExpandableListViewEx scrollable;
        e.t.k.a.c.e<?, ?> eVar = this.b;
        if (i2 >= (eVar == null ? 0 : eVar.getGroupCount()) || (scrollable = getScrollable()) == null) {
            return;
        }
        scrollable.setSelectedGroup(i2);
    }

    public final void setAdapter(@e e.t.k.a.c.e<?, ?> eVar) {
        if (eVar == null || f0.g(this.b, eVar)) {
            return;
        }
        e.t.k.a.c.e<?, ?> eVar2 = this.b;
        if (eVar2 != null) {
            eVar2.unregisterDataSetObserver(getDataSetObserver());
        }
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable != null) {
            scrollable.setAdapter((BaseExpandableListAdapter) eVar);
        }
        eVar.registerDataSetObserver(getDataSetObserver());
        this.b = eVar;
    }

    public final void setAutoExpandCollapse(boolean z) {
        this.f8040d = z;
    }

    public final void setEmptyFooter(@e View view) {
        this.f8043g = view;
    }

    public final void setExpandAll(boolean z) {
        this.f8039c = z;
    }

    public final void setFloatGroup(boolean z) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setFloatingGroupEnabled(z);
    }

    public final void setOnChildClickListener(@d final r<? super View, ? super Integer, ? super Integer, ? super Long, Boolean> rVar) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setOnChildClickListener(new ExpandableListView.OnChildClickListener() { // from class: e.t.v.j.c
            @Override // android.widget.ExpandableListView.OnChildClickListener
            public final boolean onChildClick(ExpandableListView expandableListView, View view, int i2, int i3, long j2) {
                return GroupListView.m(GroupListView.this, rVar, expandableListView, view, i2, i3, j2);
            }
        });
    }

    public final void setOnGroupClickListener(@d final q<? super View, ? super Integer, ? super Long, Boolean> qVar) {
        ExpandableListViewEx scrollable = getScrollable();
        if (scrollable == null) {
            return;
        }
        scrollable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() { // from class: e.t.v.j.b
            @Override // android.widget.ExpandableListView.OnGroupClickListener
            public final boolean onGroupClick(ExpandableListView expandableListView, View view, int i2, long j2) {
                return GroupListView.l(q.this, expandableListView, view, i2, j2);
            }
        });
    }

    @h.k2.h
    public GroupListView(@d Context context, @e AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.a = z.c(new GroupListView$scrollable$2(context, attributeSet, this));
        this.f8039c = true;
        this.f8040d = true;
        this.f8041e = z.c(new GroupListView$dataSetObserver$2(this));
        this.f8046j = z.c(new GroupListView$loadMoreFooter$2(context));
        this.f8048l = z.b(LazyThreadSafetyMode.NONE, new GroupListView$innerOnScrollListener$2(this));
    }

    @Override // e.t.v.j.h
    @e
    public ExpandableListViewEx getScrollable() {
        return (ExpandableListViewEx) this.a.getValue();
    }
}
