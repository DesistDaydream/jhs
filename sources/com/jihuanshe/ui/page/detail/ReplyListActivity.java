package com.jihuanshe.ui.page.detail;

import android.content.Intent;
import android.net.Uri;
import android.text.Editable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.adapter.ReplyListAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ReplyDetailInfo;
import com.jihuanshe.model.User;
import com.jihuanshe.repo.ReportRepo;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.ReportCommentDialog;
import com.jihuanshe.ui.widget.ReviewPopupWindow;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.detail.ReplyListViewModel;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import com.vector.util.UIUtil;
import e.l.g.w0;
import e.l.k.w1;
import e.l.q.b.d.c;
import e.l.q.c.o0;
import e.l.r.p0;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
import e.t.j.h.p;
import e.t.o.d;
import h.k2.u.l;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ReplyListActivity extends BaseActivity<ReplyListViewModel> implements o0.a {
    @d
    public static final a O;
    public static final /* synthetic */ n<Object>[] P;
    private static final int Q = 10000;
    @d
    private static final String R = "ReplyListActivity";
    @d
    private final g A;
    @d
    private final l<Pair<String, String>, t1> B;
    @d
    private final l<Boolean, t1> C;
    @e
    private ReplyDetailInfo D;
    @d
    private final e.t.j.h.l E;
    @d
    private final h F;
    @d
    private final g G;
    @d
    private final p H;
    @d
    private final w I;
    @d
    private final w J;
    @e
    private o0 K;
    private boolean L;
    @e
    private e.t.k.a.f.h M;
    @e
    private ReportCommentDialog N;
    @d
    private final g z;
    private final int n = -UIUtil.c();
    @f.a.a.a
    @e
    private Integer reviewId = 0;
    @f.a.a.a(true)
    @e
    private Integer sortIndex = 0;
    @d
    private final e.t.r.a.a o = new e.t.r.a.a(0, 0, 3, null);
    private final MovementMethod p = LinkMovementMethod.getInstance();
    @d
    private final w q = z.c(new ReplyListActivity$reviewViewModel$2(this));
    @d
    private final w r = z.c(new ReplyListActivity$header$2(this));
    @d
    private final h.m2.e s = BindViewKt.n(this, R.id.editText);
    @d
    private final h.m2.e t = BindViewKt.n(this, R.id.lineView);
    @d
    private final h.m2.e u = BindViewKt.n(this, R.id.llBar);
    @d
    private final w v = z.c(ReplyListActivity$decoration$2.INSTANCE);
    @d
    private final w w = z.c(ReplyListActivity$layoutManager$2.INSTANCE);
    @d
    private final w x = z.c(new ReplyListActivity$adapter$2(this));
    @d
    private final ImagePicker y = new ImagePicker(this, 0, 0.0f, new ReplyListActivity$imagePicker$1(this), 6, (u) null);

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class b implements p0.b {
        public b() {
        }

        @Override // e.l.r.p0.b
        public void a(int i2) {
            ReplyListActivity.this.l0().clearFocus();
            ViewKt.I(ReplyListActivity.this.o0());
            Editable text = ReplyListActivity.this.l0().getText();
            if (text == null || text.length() == 0) {
                ReplyListActivity.this.J0(null);
                ReplyListActivity.this.l0().setHint(Res.w(Res.a, R.string.comment_edit_hint, null, 2, null));
            }
        }

        @Override // e.l.r.p0.b
        public void b(int i2) {
            ReplyListActivity.this.l0().requestFocus();
            ViewKt.n(ReplyListActivity.this.o0());
        }
    }

    static {
        n<Object>[] nVarArr = new n[10];
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(ReplyListActivity.class), "editText", "getEditText()Landroid/widget/EditText;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(ReplyListActivity.class), "lineView", "getLineView()Landroid/view/View;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(ReplyListActivity.class), "llBar", "getLlBar()Landroid/widget/LinearLayout;"));
        P = nVarArr;
        O = new a(null);
    }

    public ReplyListActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.z = dVar.a(new ReplyListActivity$onClickFavor$1(this));
        this.A = dVar.a(new ReplyListActivity$onClickMineMore$1(this));
        this.B = new ReplyListActivity$chooseFilter$1(this);
        this.C = new ReplyListActivity$showState$1(this);
        this.E = d.e.a.a(new ReplyListActivity$onItemClick$1(this));
        this.F = d.c.a.c(new ReplyListActivity$onEditAction$1(this));
        this.G = dVar.a(new ReplyListActivity$onClickHeader$1(this));
        this.H = d.g.a.a(new ReplyListActivity$onLoadMore$1(this));
        this.I = z.c(ReplyListActivity$sortLayoutManager$2.INSTANCE);
        this.J = z.c(ReplyListActivity$sortAdapter$2.INSTANCE);
        this.L = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(Uri uri) {
        if (uri == null) {
            return;
        }
        e.t.k.a.f.h hVar = this.M;
        if (hVar != null) {
            hVar.n();
        }
        e.t.k.a.f.h hVar2 = new e.t.k.a.f.h(this, false, 2, null);
        this.M = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new ReplyListActivity$handleUri$1(uri, this, null), 2, null);
    }

    private final void G0() {
        p0.f14296d.a(this, new b());
        f.g(y0().B0(), null, new ReplyListActivity$initObserver$2(this), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void N0(View view, List<String> list, ReplyDetailInfo replyDetailInfo, h.k2.u.a<t1> aVar) {
        new ReviewPopupWindow(this, list.get(0), e.t.j.h.d.a.a(new ReplyListActivity$showPopWindow$1(aVar))).showAsDropDown(view, -d.a.c(e.t.o.d.a, null, 1, null).d(55), 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g0(View view, boolean z) {
        if (z) {
            e.l.l.a.d(new ReplyListActivity$flowOfSetup$1$1(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText l0() {
        return (EditText) this.s.a(this, P[2]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final View o0() {
        return (View) this.t.a(this, P[3]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout p0() {
        return (LinearLayout) this.u.a(this, P[4]);
    }

    @k.e.a.d
    public final l<Boolean, t1> A0() {
        return this.C;
    }

    @k.e.a.d
    public final w0 B0() {
        return (w0) this.J.getValue();
    }

    @e
    public final Integer C0() {
        return this.sortIndex;
    }

    @k.e.a.d
    public final LayoutManagers.a D0() {
        return (LayoutManagers.a) this.I.getValue();
    }

    public final int E0() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        Integer num = this.reviewId;
        if (num == null) {
            return;
        }
        num.intValue();
        ReplyListViewModel replyListViewModel = (ReplyListViewModel) L();
        int intValue = this.reviewId.intValue();
        Pair<String, String> value = y0().B0().getValue();
        e.g.d.a.o(BinderKt.s(ReplyListViewModel.D0(replyListViewModel, intValue, value == null ? null : value.getSecond(), null, 4, null), this, false, false, 4, null), null, new ReplyListActivity$onRetryClick$1(this), 1, null);
    }

    @k.e.a.d
    public final g I0(@e ReplyDetailInfo replyDetailInfo) {
        return e.t.j.h.d.a.a(new ReplyListActivity$onCLickGoCardDetail$1(replyDetailInfo, this));
    }

    public final void J0(@e ReplyDetailInfo replyDetailInfo) {
        this.D = replyDetailInfo;
    }

    public final void K0(@e Integer num) {
        this.reviewId = num;
    }

    public final void L0(@e Integer num) {
        this.sortIndex = num;
    }

    public final void M0(@k.e.a.d ReplyDetailInfo replyDetailInfo, @k.e.a.d View view) {
        e.l.l.a.d(new ReplyListActivity$showPopUpWindow$1(replyDetailInfo, this, view));
    }

    public final void O0(@k.e.a.d ReplyDetailInfo replyDetailInfo) {
        ReportCommentDialog reportCommentDialog = this.N;
        if (reportCommentDialog != null) {
            reportCommentDialog.h();
        }
        ReportRepo reportRepo = ReportRepo.a;
        this.N = new ReportCommentDialog(this, reportRepo.d(), this.y, new ReplyListActivity$showReportDialog$1(this, replyDetailInfo));
        reportRepo.b(LifecycleOwnerKt.getLifecycleScope(this));
        ReportCommentDialog reportCommentDialog2 = this.N;
        if (reportCommentDialog2 == null) {
            return;
        }
        reportCommentDialog2.y();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        this.K = new o0(l0(), Res.k(R.color.service_charge_color), this);
        l0().addTextChangedListener(this.K);
        f<Pair<String, String>> B0 = y0().B0();
        List<Pair<String, String>> sort_type_review = Constants.Companion.getSORT_TYPE_REVIEW();
        Integer num = this.sortIndex;
        B0.r(sort_type_review.get(num == null ? 0 : num.intValue()));
        l0().setOnFocusChangeListener(c.a);
        G0();
        F();
    }

    @k.e.a.d
    public final ReplyListAdapter h0() {
        return (ReplyListAdapter) this.x.getValue();
    }

    @Override // e.l.q.c.o0.a
    public void i() {
        AtUserActivityCreator.create(Integer.valueOf(UserKV.f3913c.v())).start(this, 10000);
    }

    @k.e.a.d
    public final l<Pair<String, String>, t1> i0() {
        return this.B;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ReplyListActivity$flowOfAppBar$1.INSTANCE);
    }

    @e
    public final ReplyDetailInfo j0() {
        return this.D;
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b k0() {
        return (e.l.h.j.b.f.b) this.v.getValue();
    }

    @k.e.a.d
    public final View m0() {
        return (View) this.r.getValue();
    }

    @k.e.a.d
    public final LayoutManagers.a n0() {
        return (LayoutManagers.a) this.w.getValue();
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        o0 o0Var;
        Boolean bool = Boolean.TRUE;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 10000 || i3 != -1) {
            if (i2 == 10000 && i3 == 0) {
                y0().K0().setValue(bool);
                String obj = l0().getText().toString();
                EditText l0 = l0();
                Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
                l0.setText(obj.substring(0, obj.length() - 1));
                return;
            }
            return;
        }
        y0().K0().setValue(bool);
        User user = intent == null ? null : (User) intent.getParcelableExtra(AtUserActivity.C);
        if (user == null || (o0Var = this.K) == null) {
            return;
        }
        String name = user.getName();
        if (name == null) {
            name = "";
        }
        o0Var.g(name, user.getId());
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        w1 f2 = w1.f(getLayoutInflater());
        f2.j(this);
        f2.l((ReplyListViewModel) L());
        f2.k(y0());
        return f2;
    }

    public final MovementMethod q0() {
        return this.p;
    }

    @k.e.a.d
    public final g r0() {
        return this.z;
    }

    @k.e.a.d
    public final g s0() {
        return this.G;
    }

    @k.e.a.d
    public final g t0() {
        return this.A;
    }

    @k.e.a.d
    public final h u0() {
        return this.F;
    }

    @k.e.a.d
    public final e.t.j.h.l v0() {
        return this.E;
    }

    @k.e.a.d
    public final p w0() {
        return this.H;
    }

    @e
    public final Integer x0() {
        return this.reviewId;
    }

    @k.e.a.d
    public final ReviewListViewModel y0() {
        return (ReviewListViewModel) this.q.getValue();
    }

    @k.e.a.d
    public final e.t.r.a.a z0() {
        return this.o;
    }
}
