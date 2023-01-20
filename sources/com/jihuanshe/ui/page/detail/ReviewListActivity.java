package com.jihuanshe.ui.page.detail;

import android.content.Intent;
import android.net.Uri;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.jihuanshe.R;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.ReplyListInfo;
import com.jihuanshe.model.ReviewListInfo;
import com.jihuanshe.model.User;
import com.jihuanshe.repo.ReportRepo;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.ui.dialog.ReportCommentDialog;
import com.jihuanshe.utils.ImagePicker;
import com.jihuanshe.viewmodel.detail.ReviewListViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.ext.view.ViewKt;
import com.vector.util.LayoutManagers;
import com.vector.util.Res;
import com.vector.util.UIUtil;
import com.vector.view.scrollable.ListView;
import e.l.g.r0;
import e.l.k.y1;
import e.l.q.c.o0;
import e.l.r.p0;
import e.l.r.s;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.h;
import e.t.j.h.p;
import h.k2.u.l;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import i.b.b1;
import i.b.i;
import inject.annotation.creator.Creator;
import java.util.Objects;
import k.e.a.e;
import kotlin.Pair;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class ReviewListActivity extends BaseActivity<ReviewListViewModel> implements o0.a {
    @k.e.a.d
    public static final a S;
    public static final /* synthetic */ n<Object>[] T;
    public static final int U = 10000;
    public static final int V = 10001;
    @k.e.a.d
    private static final String W = "SellerConfirmActivity";
    @e
    private CardCommentsDialog B;
    @k.e.a.d
    private final g C;
    @k.e.a.d
    private final h D;
    @k.e.a.d
    private final g E;
    private boolean F;
    @k.e.a.d
    private final g G;
    @k.e.a.d
    private final l<Pair<String, String>, t1> H;
    @k.e.a.d
    private final l<Boolean, t1> I;
    @e
    private ReviewListInfo J;
    @k.e.a.d
    private final g K;
    @k.e.a.d
    private final p L;
    @e
    private o0 M;
    private boolean N;
    private boolean O;
    @e
    private e.t.k.a.f.h P;
    @e
    private ReportCommentDialog Q;
    private boolean R;
    private final int n = -UIUtil.c();
    private final MovementMethod o = LinkMovementMethod.getInstance();
    @f.a.a.a
    @e
    private String type = "";
    @f.a.a.a
    @e
    private Integer cvId = 0;
    @e
    private Integer p = 0;
    @f.a.a.a
    @e
    private Integer pId = 0;
    @f.a.a.a
    @e
    private Integer reviewId = 0;
    @f.a.a.a
    @e
    private String gameKey = "";
    @f.a.a.a
    @e
    private String gameSubKey = "";
    @k.e.a.d
    private final h.m2.e q = BindViewKt.n(this, R.id.listView);
    @k.e.a.d
    private final h.m2.e r = BindViewKt.n(this, R.id.clEditTop);
    @k.e.a.d
    private final h.m2.e s = BindViewKt.n(this, R.id.llEditBot);
    @k.e.a.d
    private final h.m2.e t = BindViewKt.n(this, R.id.editText);
    @k.e.a.d
    private final h.m2.e u = BindViewKt.n(this, R.id.llBar);
    @k.e.a.d
    private final e.t.r.a.a v = new e.t.r.a.a(0, 0, 3, null);
    @k.e.a.d
    private final w w = z.c(ReviewListActivity$decoration$2.INSTANCE);
    @k.e.a.d
    private final w x = z.c(ReviewListActivity$layoutManager$2.INSTANCE);
    @k.e.a.d
    private final w y = z.c(new ReviewListActivity$adapter$2(this));
    @k.e.a.d
    private final w z = z.c(new ReviewListActivity$header$2(this));
    @k.e.a.d
    private final ImagePicker A = new ImagePicker(this, 0, 0.0f, new ReviewListActivity$imagePicker$1(this), 6, (u) null);

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
            if (f0.g(((ReviewListViewModel) ReviewListActivity.this.L()).K0().getValue(), Boolean.TRUE)) {
                ((ReviewListViewModel) ReviewListActivity.this.L()).K0().setValue(Boolean.FALSE);
            }
        }

        @Override // e.l.r.p0.b
        public void b(int i2) {
            if (f0.g(((ReviewListViewModel) ReviewListActivity.this.L()).K0().getValue(), Boolean.FALSE)) {
                ((ReviewListViewModel) ReviewListActivity.this.L()).K0().setValue(Boolean.TRUE);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static final class c implements Animation.AnimationListener {
        public c() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@e Animation animation) {
            ReviewListActivity.this.f1(false);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@e Animation animation) {
            ReviewListActivity.this.f1(true);
        }
    }

    /* loaded from: classes2.dex */
    public static final class d implements Animation.AnimationListener {
        public final /* synthetic */ View b;

        public d(View view) {
            this.b = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(@e Animation animation) {
            ReviewListActivity.this.f1(false);
            ViewKt.n(this.b);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(@e Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(@e Animation animation) {
            ReviewListActivity.this.f1(true);
        }
    }

    static {
        n<Object>[] nVarArr = new n[9];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(ReviewListActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(ReviewListActivity.class), "clEditTop", "getClEditTop()Landroidx/constraintlayout/widget/ConstraintLayout;"));
        nVarArr[2] = n0.r(new PropertyReference1Impl(n0.d(ReviewListActivity.class), "llEditBot", "getLlEditBot()Landroid/widget/LinearLayout;"));
        nVarArr[3] = n0.r(new PropertyReference1Impl(n0.d(ReviewListActivity.class), "editText", "getEditText()Landroid/widget/EditText;"));
        nVarArr[4] = n0.r(new PropertyReference1Impl(n0.d(ReviewListActivity.class), "llBar", "getLlBar()Landroid/widget/LinearLayout;"));
        T = nVarArr;
        S = new a(null);
    }

    public ReviewListActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.C = dVar.a(new ReviewListActivity$onClickGoComment$1(this));
        this.D = d.c.a.c(new ReviewListActivity$onEditAction$1(this));
        this.E = dVar.a(new ReviewListActivity$onClickMore$1(this));
        this.F = true;
        this.G = dVar.a(new ReviewListActivity$onClickLikeMine$1(this));
        this.H = new ReviewListActivity$chooseFilter$1(this);
        this.I = new ReviewListActivity$showState$1(this);
        this.K = dVar.a(new ReviewListActivity$onClickHeader$1(this));
        this.L = d.g.a.a(new ReviewListActivity$onLoadMore$1(this));
        this.N = true;
        this.O = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void F0(Uri uri) {
        if (uri == null) {
            return;
        }
        e.t.k.a.f.h hVar = this.P;
        if (hVar != null) {
            hVar.n();
        }
        e.t.k.a.f.h hVar2 = new e.t.k.a.f.h(this, false, 2, null);
        this.P = hVar2;
        if (hVar2 != null) {
            hVar2.W();
        }
        i.f(LifecycleOwnerKt.getLifecycleScope(this), b1.c(), null, new ReviewListActivity$handleUri$1(uri, this, null), 2, null);
    }

    private final void G0() {
        p0.f14296d.a(this, new b());
        f.g(((ReviewListViewModel) L()).B0(), null, new ReviewListActivity$initObserver$2(this), 1, null);
        f.g(((ReviewListViewModel) L()).A0(), null, new ReviewListActivity$initObserver$3(this), 1, null);
        f.g(((ReviewListViewModel) L()).K0(), null, new ReviewListActivity$initObserver$4(this), 1, null);
        l0().setOnFocusChangeListener(e.l.q.b.d.d.a);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void H0(View view, boolean z) {
        if (z) {
            e.l.l.a.d(new ReviewListActivity$initObserver$5$1(view));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ConstraintLayout i0() {
        return (ConstraintLayout) this.r.a(this, T[1]);
    }

    private final void k1(View view) {
        ViewKt.I(view);
        TranslateAnimation h2 = s.a.h(300L);
        h2.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(h2);
        view.startAnimation(h2);
        h2.setAnimationListener(new c());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final EditText l0() {
        return (EditText) this.t.a(this, T[3]);
    }

    private final void l1(View view) {
        TranslateAnimation b2 = s.a.b(300L);
        b2.setInterpolator(new AccelerateDecelerateInterpolator());
        view.setAnimation(b2);
        view.startAnimation(b2);
        b2.setAnimationListener(new d(view));
    }

    private final ListView q0() {
        return (ListView) this.q.a(this, T[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final LinearLayout r0() {
        return (LinearLayout) this.u.a(this, T[4]);
    }

    private final LinearLayout s0() {
        return (LinearLayout) this.s.a(this, T[2]);
    }

    @e
    public final Integer A0() {
        return this.pId;
    }

    @e
    public final Integer B0() {
        return this.reviewId;
    }

    @k.e.a.d
    public final e.t.r.a.a C0() {
        return this.v;
    }

    @k.e.a.d
    public final l<Boolean, t1> D0() {
        return this.I;
    }

    public final int E0() {
        return this.n;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        e.g.d.a H0;
        ReviewListViewModel reviewListViewModel = (ReviewListViewModel) L();
        String str = this.type;
        reviewListViewModel.C0(str == null ? "" : str, this.cvId, this.pId, this.gameKey, this.gameSubKey);
        ReviewListViewModel reviewListViewModel2 = (ReviewListViewModel) L();
        String str2 = this.type;
        String str3 = str2 == null ? "" : str2;
        Integer num = this.cvId;
        Integer num2 = this.pId;
        Pair<String, String> value = ((ReviewListViewModel) L()).B0().getValue();
        H0 = reviewListViewModel2.H0(str3, num, num2, value == null ? null : value.getSecond(), 0, f0.g(this.type, Constants.Companion.getTYPE_CARD()) ? ((ReviewListViewModel) L()).A0().getValue() : null, this.gameKey, this.gameSubKey, (r21 & 256) != 0 ? null : null);
        BinderKt.p(BinderKt.e(H0, this, q0(), false, 4, null));
    }

    public final boolean I0() {
        return this.F;
    }

    public final boolean J0() {
        return this.O;
    }

    public final boolean K0() {
        return this.N;
    }

    public final boolean L0() {
        return this.R;
    }

    @k.e.a.d
    public final g N0(@k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onCLickGoCardDetail$1(reviewListInfo, this));
    }

    @k.e.a.d
    public final g O0(int i2) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onChoiceType$1(this, i2));
    }

    @k.e.a.d
    public final g P0(@k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onClickAvatar$1(reviewListInfo, this));
    }

    @k.e.a.d
    public final g Q0(@k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onClickContent$1(this, reviewListInfo));
    }

    @k.e.a.d
    public final g R0(@e ReplyListInfo replyListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onClickItemAvatar$1(replyListInfo, this));
    }

    @k.e.a.d
    public final g S0(@e CharSequence charSequence, @k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onClickReply$1(charSequence, reviewListInfo, this));
    }

    @k.e.a.d
    public final g T0(@k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onItemChildAllReply$1(reviewListInfo, this));
    }

    @k.e.a.d
    public final g U0(@k.e.a.d ImageView imageView, @k.e.a.d TextView textView, @k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onItemChildLike$1(imageView, this, reviewListInfo, textView));
    }

    @k.e.a.d
    public final g V0(@k.e.a.d ReviewListInfo reviewListInfo) {
        return e.t.j.h.d.a.a(new ReviewListActivity$onItemChildMore$1(reviewListInfo, this));
    }

    public final void W0(@e CardCommentsDialog cardCommentsDialog) {
        this.B = cardCommentsDialog;
    }

    public final void X0(@e Integer num) {
        this.p = num;
    }

    public final void Y0(@e ReviewListInfo reviewListInfo) {
        this.J = reviewListInfo;
    }

    public final void Z0(@e Integer num) {
        this.cvId = num;
    }

    public final void a1(boolean z) {
        this.F = z;
    }

    public final void b1(boolean z) {
        this.O = z;
    }

    public final void c1(boolean z) {
        this.N = z;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        this.M = new o0(l0(), Res.k(R.color.service_charge_color), this);
        l0().addTextChangedListener(this.M);
        ((ReviewListViewModel) L()).J0().setValue(Boolean.valueOf(f0.g(this.type, Constants.Companion.getTYPE_CARD())));
        G0();
        F();
    }

    @k.e.a.d
    public final r0 d0() {
        return (r0) this.y.getValue();
    }

    public final void d1(@e String str) {
        this.gameKey = str;
    }

    @e
    public final CardCommentsDialog e0() {
        return this.B;
    }

    public final void e1(@e String str) {
        this.gameSubKey = str;
    }

    @e
    public final Integer f0() {
        return this.p;
    }

    public final void f1(boolean z) {
        this.R = z;
    }

    @k.e.a.d
    public final l<Pair<String, String>, t1> g0() {
        return this.H;
    }

    public final void g1(@e Integer num) {
        this.pId = num;
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final ReviewListInfo h0() {
        return this.J;
    }

    public final void h1(@e Integer num) {
        this.reviewId = num;
    }

    @Override // e.l.q.c.o0.a
    public void i() {
        AtUserActivityCreator.create(Integer.valueOf(UserKV.f3913c.v())).start(this, 10000);
    }

    public final void i1(@e String str) {
        this.type = str;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(ReviewListActivity$flowOfAppBar$1.INSTANCE);
    }

    @e
    public final Integer j0() {
        return this.cvId;
    }

    public final void j1(@k.e.a.d ReviewListInfo reviewListInfo) {
        ReportCommentDialog reportCommentDialog = this.Q;
        if (reportCommentDialog != null) {
            reportCommentDialog.h();
        }
        ReportRepo reportRepo = ReportRepo.a;
        this.Q = new ReportCommentDialog(this, reportRepo.d(), this.A, new ReviewListActivity$showReportDialog$1(this, reviewListInfo));
        reportRepo.b(LifecycleOwnerKt.getLifecycleScope(this));
        ReportCommentDialog reportCommentDialog2 = this.Q;
        if (reportCommentDialog2 == null) {
            return;
        }
        reportCommentDialog2.y();
    }

    @k.e.a.d
    public final e.l.h.j.b.f.b k0() {
        return (e.l.h.j.b.f.b) this.w.getValue();
    }

    @e
    public final String m0() {
        return this.gameKey;
    }

    @e
    public final String n0() {
        return this.gameSubKey;
    }

    @k.e.a.d
    public final View o0() {
        return (View) this.z.getValue();
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        User user;
        o0 o0Var;
        CardCommentsDialog cardCommentsDialog;
        CardCommentsDialog cardCommentsDialog2;
        Boolean bool = Boolean.TRUE;
        super.onActivityResult(i2, i3, intent);
        if (i2 != 10000) {
            if (i2 != 10001) {
                return;
            }
            if (i3 != -1) {
                if (i3 == 0 && (cardCommentsDialog2 = this.B) != null) {
                    cardCommentsDialog2.D();
                    return;
                }
                return;
            }
            user = intent != null ? (User) intent.getParcelableExtra(AtUserActivity.C) : null;
            if (user == null || (cardCommentsDialog = this.B) == null) {
                return;
            }
            cardCommentsDialog.K(user);
        } else if (i3 != -1) {
            if (i3 != 0) {
                return;
            }
            ((ReviewListViewModel) L()).K0().setValue(bool);
            String obj = l0().getText().toString();
            EditText l0 = l0();
            Objects.requireNonNull(obj, "null cannot be cast to non-null type java.lang.String");
            l0.setText(obj.substring(0, obj.length() - 1));
        } else {
            ((ReviewListViewModel) L()).K0().setValue(bool);
            user = intent != null ? (User) intent.getParcelableExtra(AtUserActivity.C) : null;
            if (user == null || (o0Var = this.M) == null) {
                return;
            }
            String name = user.getName();
            if (name == null) {
                name = "";
            }
            o0Var.g(name, user.getId());
        }
    }

    @Override // com.jihuanshe.ui.BaseActivity, com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.F) {
            this.F = false;
        } else {
            F();
        }
    }

    @k.e.a.d
    public final LayoutManagers.a p0() {
        return (LayoutManagers.a) this.x.getValue();
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        y1 e2 = y1.e(getLayoutInflater());
        e2.i(this);
        e2.j((ReviewListViewModel) L());
        return e2;
    }

    public final MovementMethod t0() {
        return this.o;
    }

    @k.e.a.d
    public final g u0() {
        return this.C;
    }

    @k.e.a.d
    public final g v0() {
        return this.K;
    }

    @k.e.a.d
    public final g w0() {
        return this.G;
    }

    @k.e.a.d
    public final g x0() {
        return this.E;
    }

    @k.e.a.d
    public final h y0() {
        return this.D;
    }

    @k.e.a.d
    public final p z0() {
        return this.L;
    }
}
