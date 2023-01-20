package e.t.j.h;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebView;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.qiniu.android.collect.ReportItem;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.vector.databinding.onBind.State;
import com.vector.design.ui.delegate.LoadMore;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001:\u000b\u001d\u001e\u001f !\"#$%&'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006J>\u0010\f\u001a\u00020\r26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u000b0\u000eJS\u0010\u0011\u001a\u00020\u00122K\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u0013J)\u0010\u0018\u001a\u00020\u00192!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000f0\u0006J>\u0010\u001a\u001a\u00020\u001b26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000f0\u000e¨\u0006("}, d2 = {"Lcom/vector/databinding/onBind/Bind;", "", "()V", "onClick", "Lcom/vector/databinding/onBind/OnClickBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "onFocusChanged", "Lcom/vector/databinding/onBind/OnFocusChangedBinding;", "Lkotlin/Function2;", "", "focus", "onKeyListener", "Lcom/vector/databinding/onBind/OnKeyBinding;", "Lkotlin/Function3;", "", "keyCode", "Landroid/view/KeyEvent;", "event", "onLongClick", "Lcom/vector/databinding/onBind/OnLongClickBinding;", "onTouch", "Lcom/vector/databinding/onBind/OnTouchBinding;", "Landroid/view/MotionEvent;", "AppBar", "CompoundButton", "Edit", "GroupList", "List", "RadioGroup", "Refresh", "SideBar", "ToggleButton", "ViewPager", "Web", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    @k.e.a.d
    public static final d a = new d();

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J>\u0010\u000e\u001a\u00020\u000f26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\r0\u0006¨\u0006\u0012"}, d2 = {"Lcom/vector/databinding/onBind/Bind$AppBar;", "", "()V", "onOffsetChanged", "Lcom/vector/databinding/onBind/OnOffsetChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Lcom/google/android/material/appbar/AppBarLayout;", "Lkotlin/ParameterName;", "name", "appBarLayout", "", "verticalOffset", "", "onOffsetStateChanged", "Lcom/vector/databinding/onBind/OnOffsetStateChangedBinding;", "Lcom/vector/databinding/onBind/State;", "state", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.d
        public static final a a = new a();

        private a() {
        }

        @k.e.a.d
        public final t a(@k.e.a.d h.k2.u.p<? super AppBarLayout, ? super Integer, t1> pVar) {
            return new t(pVar);
        }

        @k.e.a.d
        public final u b(@k.e.a.d h.k2.u.p<? super AppBarLayout, ? super State, t1> pVar) {
            return new u(pVar);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006¨\u0006\u000e"}, d2 = {"Lcom/vector/databinding/onBind/Bind$CompoundButton;", "", "()V", "onCheckedChanged", "Lcom/vector/databinding/onBind/OnCheckedChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Landroid/widget/CompoundButton;", "Lkotlin/ParameterName;", "name", "v", "", "isChecked", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b {
        @k.e.a.d
        public static final b a = new b();

        private b() {
        }

        @k.e.a.d
        public final e.t.j.h.e a(@k.e.a.d h.k2.u.p<? super CompoundButton, ? super Boolean, t1> pVar) {
            return new e.t.j.h.e(pVar);
        }
    }

    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006Jh\u0010\f\u001a\u00020\r2`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u000b0\u000eJ>\u0010\u0014\u001a\u00020\u001526\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u001a0\u0016Jh\u0010\u001b\u001a\u00020\u001c2`\u0010\u0005\u001a\\\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001d\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000e¨\u0006\u001e"}, d2 = {"Lcom/vector/databinding/onBind/Bind$Edit;", "", "()V", "afterTextChanged", "Lcom/vector/databinding/onBind/AfterTextChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "Landroid/text/Editable;", "Lkotlin/ParameterName;", "name", "s", "", "beforeTextChanged", "Lcom/vector/databinding/onBind/BeforeTextChangedBinding;", "Lkotlin/Function4;", "", "", MessageKey.MSG_ACCEPT_TIME_START, "count", "after", "onEditorAction", "Lcom/vector/databinding/onBind/OnEditorActionBinding;", "Lkotlin/Function2;", "Landroid/widget/TextView;", "v", TUIConstants.TUIChat.INPUT_MORE_ACTION_ID, "", "onTextChanged", "Lcom/vector/databinding/onBind/OnTextChangedBinding;", "before", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class c {
        @k.e.a.d
        public static final c a = new c();

        private c() {
        }

        @k.e.a.d
        public final e.t.j.h.a a(@k.e.a.d h.k2.u.l<? super Editable, t1> lVar) {
            return new e.t.j.h.a(lVar);
        }

        @k.e.a.d
        public final e.t.j.h.c b(@k.e.a.d h.k2.u.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, t1> rVar) {
            return new e.t.j.h.c(rVar);
        }

        @k.e.a.d
        public final e.t.j.h.h c(@k.e.a.d h.k2.u.p<? super TextView, ? super Integer, Boolean> pVar) {
            return new e.t.j.h.h(pVar);
        }

        @k.e.a.d
        public final h0 d(@k.e.a.d h.k2.u.r<? super CharSequence, ? super Integer, ? super Integer, ? super Integer, t1> rVar) {
            return new h0(rVar);
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jl\u0010\u0003\u001a\u00020\u00042d\u0010\u0005\u001a`\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0006j\u0002`\u0011JW\u0010\u0012\u001a\u00020\u00132O\u0010\u0005\u001aK\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u00100\u0014j\u0002`\u0015¨\u0006\u0016"}, d2 = {"Lcom/vector/databinding/onBind/Bind$GroupList;", "", "()V", "onChildClick", "Lcom/vector/databinding/onBind/OnChildClickBinder;", ReportItem.LogTypeBlock, "Lkotlin/Function4;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "v", "", "groupPosition", "childPosition", "", "id", "", "Lcom/vector/view/scrollable/OnChildClick;", "onGroupClick", "Lcom/vector/databinding/onBind/OnGroupClickBinder;", "Lkotlin/Function3;", "Lcom/vector/view/scrollable/OnGroupClick;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* renamed from: e.t.j.h.d$d */
    /* loaded from: classes3.dex */
    public static final class C0409d {
        @k.e.a.d
        public static final C0409d a = new C0409d();

        private C0409d() {
        }

        @k.e.a.d
        public final e.t.j.h.f a(@k.e.a.d h.k2.u.r<? super View, ? super Integer, ? super Integer, ? super Long, Boolean> rVar) {
            return new e.t.j.h.f(rVar);
        }

        @k.e.a.d
        public final e.t.j.h.k b(@k.e.a.d h.k2.u.q<? super View, ? super Integer, ? super Long, Boolean> qVar) {
            return new e.t.j.h.k(qVar);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J@\u0010\u0003\u001a\u00020\u000428\u0010\u0005\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J@\u0010\u000e\u001a\u00020\u000f28\u0010\u0005\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00100\u0006Jj\u0010\u0011\u001a\u00020\u00122b\u0010\u0005\u001a^\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\r0\u0013J@\u0010\u0019\u001a\u00020\u001a28\u0010\u0005\u001a4\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\r0\u0006¨\u0006\u001c"}, d2 = {"Lcom/vector/databinding/onBind/Bind$List;", "", "()V", "onItemClick", "Lcom/vector/databinding/onBind/OnItemClickBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "position", "", "onItemLongClick", "Lcom/vector/databinding/onBind/OnItemLongClickBinding;", "", "onScroll", "Lcom/vector/databinding/onBind/OnScrollBinding;", "Lkotlin/Function4;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "scrollX", "scrollY", "state", "onScrollStateChanged", "Lcom/vector/databinding/onBind/OnScrollStateChangedBinding;", "newState", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class e {
        @k.e.a.d
        public static final e a = new e();

        private e() {
        }

        @k.e.a.d
        public final l a(@k.e.a.d h.k2.u.p<? super View, ? super Integer, t1> pVar) {
            return new l(pVar);
        }

        @k.e.a.d
        public final m b(@k.e.a.d h.k2.u.p<? super View, ? super Integer, Boolean> pVar) {
            return new m(pVar);
        }

        @k.e.a.d
        public final d0 c(@k.e.a.d h.k2.u.r<? super RecyclerView, ? super Integer, ? super Integer, ? super Integer, t1> rVar) {
            return new d0(rVar);
        }

        @k.e.a.d
        public final e0 d(@k.e.a.d h.k2.u.p<? super RecyclerView, ? super Integer, t1> pVar) {
            return new e0(pVar);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J>\u0010\u0003\u001a\u00020\u000426\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¨\u0006\r"}, d2 = {"Lcom/vector/databinding/onBind/Bind$RadioGroup;", "", "()V", "onCheckedChanged", "Lcom/vector/databinding/onBind/OnRadioGroupCheckedChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "index", "checkedId", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class f {
        @k.e.a.d
        public static final f a = new f();

        private f() {
        }

        @k.e.a.d
        public final c0 a(@k.e.a.d h.k2.u.p<? super Integer, ? super Integer, t1> pVar) {
            return new c0(pVar);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042:\u0010\u0005\u001a6\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J-\u0010\u000e\u001a\u00020\u000f2%\u0010\u0005\u001a!\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\r0\u0010¨\u0006\u0011"}, d2 = {"Lcom/vector/databinding/onBind/Bind$Refresh;", "", "()V", "onLoadMore", "Lcom/vector/databinding/onBind/OnLoadMoreBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Lcom/vector/view/scrollable/ScrollableView;", "Lkotlin/ParameterName;", "name", "view", "Lcom/vector/design/ui/delegate/LoadMore$State;", "state", "", "onSwipe", "Lcom/vector/databinding/onBind/OnSwipeBinding;", "Lkotlin/Function1;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class g {
        @k.e.a.d
        public static final g a = new g();

        private g() {
        }

        @k.e.a.d
        public final p a(@k.e.a.d h.k2.u.p<? super e.t.v.j.g<?>, ? super LoadMore.State, t1> pVar) {
            return new p(pVar);
        }

        @k.e.a.d
        public final f0 b(@k.e.a.d h.k2.u.l<? super e.t.v.j.g<?>, t1> lVar) {
            return new f0(lVar);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JW\u0010\u0003\u001a\u00020\u00042O\u0010\u0005\u001aK\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000e\u0012\u0004\u0012\u00020\u000f0\u0006j\u0002`\u0010¨\u0006\u0011"}, d2 = {"Lcom/vector/databinding/onBind/Bind$SideBar;", "", "()V", "onTouchLetter", "Lcom/vector/databinding/onBind/OnTouchLetterBinder;", ReportItem.LogTypeBlock, "Lkotlin/Function3;", "", "Lkotlin/ParameterName;", "name", "index", "", "s", "", "isFocus", "", "Lcom/vector/view/OnTouchLetterListener;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class h {
        @k.e.a.d
        public static final h a = new h();

        private h() {
        }

        @k.e.a.d
        public final l0 a(@k.e.a.d h.k2.u.q<? super Integer, ? super String, ? super Boolean, t1> qVar) {
            return new l0(qVar);
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JD\u0010\u0003\u001a\u00020\u00042<\u0010\u0005\u001a8\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006j\u0002`\u000e¨\u0006\u000f"}, d2 = {"Lcom/vector/databinding/onBind/Bind$ToggleButton;", "", "()V", "onCheckedChanged", "Lcom/vector/databinding/onBind/OnToggleButtonCheckedChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "checked", "", "Lcom/vector/view/OnToggleButtonCheckedChanged;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class i {
        @k.e.a.d
        public static final i a = new i();

        private i() {
        }

        @k.e.a.d
        public final j0 a(@k.e.a.d h.k2.u.p<? super View, ? super Boolean, t1> pVar) {
            return new j0(pVar);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J)\u0010\u0003\u001a\u00020\u00042!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0006JS\u0010\f\u001a\u00020\r2K\u0010\u0005\u001aG\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u000b0\u000eJ)\u0010\u0013\u001a\u00020\u00142!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u000b0\u0006¨\u0006\u0015"}, d2 = {"Lcom/vector/databinding/onBind/Bind$ViewPager;", "", "()V", "onPageScrollStateChanged", "Lcom/vector/databinding/onBind/OnPageScrollStateChangedBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "state", "", "onPageScrolled", "Lcom/vector/databinding/onBind/OnPageScrolledBinding;", "Lkotlin/Function3;", "position", "", "positionOffset", "positionOffsetPixels", "onPageSelected", "Lcom/vector/databinding/onBind/OnPageSelectedBinding;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class j {
        @k.e.a.d
        public static final j a = new j();

        private j() {
        }

        @k.e.a.d
        public final w a(@k.e.a.d h.k2.u.l<? super Integer, t1> lVar) {
            return new w(lVar);
        }

        @k.e.a.d
        public final x b(@k.e.a.d h.k2.u.q<? super Integer, ? super Float, ? super Integer, t1> qVar) {
            return new x(qVar);
        }

        @k.e.a.d
        public final y c(@k.e.a.d h.k2.u.l<? super Integer, t1> lVar) {
            return new y(lVar);
        }
    }

    @Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J>\u0010\u000e\u001a\u00020\u000f26\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00100\u0006JB\u0010\u0011\u001a\u00020\u00122:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006JB\u0010\u0013\u001a\u00020\u00142:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\u0006J)\u0010\u0015\u001a\u00020\u00162!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\r0\u0017J)\u0010\u001a\u001a\u00020\u001b2!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\r0\u0017¨\u0006\u001d"}, d2 = {"Lcom/vector/databinding/onBind/Bind$Web;", "", "()V", "onLoadSchemeUri", "Lcom/vector/databinding/onBind/OnLoadSchemeUriBinding;", ReportItem.LogTypeBlock, "Lkotlin/Function2;", "Landroid/webkit/WebView;", "Lkotlin/ParameterName;", "name", "web", "", "url", "", "onLoading", "Lcom/vector/databinding/onBind/OnLoadingBinding;", "", "onPageEnd", "Lcom/vector/databinding/onBind/OnPageEndBinding;", "onPageStart", "Lcom/vector/databinding/onBind/OnPageStartBinding;", "onProgressChanged", "Lcom/vector/databinding/onBind/OnProgressChangedBinding;", "Lkotlin/Function1;", "", "progress", "onTitleChanged", "Lcom/vector/databinding/onBind/OnTitleChangedBinding;", "text", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class k {
        @k.e.a.d
        public static final k a = new k();

        private k() {
        }

        @k.e.a.d
        public final q a(@k.e.a.d h.k2.u.p<? super WebView, ? super String, t1> pVar) {
            return new q(pVar);
        }

        @k.e.a.d
        public final r b(@k.e.a.d h.k2.u.p<? super WebView, ? super String, Boolean> pVar) {
            return new r(pVar);
        }

        @k.e.a.d
        public final v c(@k.e.a.d h.k2.u.p<? super WebView, ? super String, t1> pVar) {
            return new v(pVar);
        }

        @k.e.a.d
        public final z d(@k.e.a.d h.k2.u.p<? super WebView, ? super String, t1> pVar) {
            return new z(pVar);
        }

        @k.e.a.d
        public final b0 e(@k.e.a.d h.k2.u.l<? super Integer, t1> lVar) {
            return new b0(lVar);
        }

        @k.e.a.d
        public final i0 f(@k.e.a.d h.k2.u.l<? super String, t1> lVar) {
            return new i0(lVar);
        }
    }

    private d() {
    }

    @k.e.a.d
    public final e.t.j.h.g a(@k.e.a.d h.k2.u.l<? super View, t1> lVar) {
        return new e.t.j.h.g(lVar);
    }

    @k.e.a.d
    public final e.t.j.h.i b(@k.e.a.d h.k2.u.p<? super View, ? super Boolean, t1> pVar) {
        return new e.t.j.h.i(pVar);
    }

    @k.e.a.d
    public final n c(@k.e.a.d h.k2.u.q<? super View, ? super Integer, ? super KeyEvent, Boolean> qVar) {
        return new n(qVar);
    }

    @k.e.a.d
    public final s d(@k.e.a.d h.k2.u.l<? super View, Boolean> lVar) {
        return new s(lVar);
    }

    @k.e.a.d
    public final k0 e(@k.e.a.d h.k2.u.p<? super View, ? super MotionEvent, Boolean> pVar) {
        return new k0(pVar);
    }
}
