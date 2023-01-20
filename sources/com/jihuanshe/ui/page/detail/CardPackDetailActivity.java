package com.jihuanshe.ui.page.detail;

import android.content.Intent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.jihuanshe.R;
import com.jihuanshe.adapter.CommentAdapter;
import com.jihuanshe.base.ext.AppBarKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.Game;
import com.jihuanshe.model.PackDetailResult;
import com.jihuanshe.model.User;
import com.jihuanshe.ui.BaseActivity;
import com.jihuanshe.ui.dialog.CardCommentsDialog;
import com.jihuanshe.viewmodel.detail.CardPackDetailViewModel;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import com.vector.view.scrollable.ListView;
import e.l.k.s;
import e.l.r.r;
import e.n.f;
import e.t.j.h.d;
import e.t.j.h.g;
import e.t.j.h.l;
import f.a.a.a;
import h.k2.v.n0;
import h.p2.n;
import h.w;
import h.z;
import inject.annotation.creator.Creator;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.PropertyReference1Impl;

@Creator
/* loaded from: classes2.dex */
public final class CardPackDetailActivity extends BaseActivity<CardPackDetailViewModel> {
    public static final /* synthetic */ n<Object>[] F;
    @d
    private final g A;
    @d
    private final g B;
    @d
    private final g C;
    @d
    private final g D;
    private boolean E;
    @a
    @e
    private String gameKey = "";
    @a
    @e
    private String gameSubKey = "";
    @d
    private final h.m2.e n = BindViewKt.n(this, R.id.listView);
    @d
    private final g o;
    @d
    private final g p;
    @a
    private int packId;
    @e
    private CardCommentsDialog q;
    @d
    private final g r;
    @d
    private final w s;
    @d
    private final w t;
    @d
    private final l u;
    @d
    private final w v;
    @d
    private final l w;
    @d
    private final g x;
    @d
    private final g y;
    @d
    private final g z;

    static {
        n<Object>[] nVarArr = new n[4];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(CardPackDetailActivity.class), "listView", "getListView()Lcom/vector/view/scrollable/ListView;"));
        F = nVarArr;
    }

    public CardPackDetailActivity() {
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.o = dVar.a(new CardPackDetailActivity$onClickNameCN$1(this));
        this.p = dVar.a(new CardPackDetailActivity$onClickNameOrigin$1(this));
        this.r = dVar.a(new CardPackDetailActivity$onClickGoComment$1(this));
        this.s = z.c(new CardPackDetailActivity$adapterComment$2(this));
        this.t = z.c(CardPackDetailActivity$layoutManagerComment$2.INSTANCE);
        d.e eVar = d.e.a;
        this.u = eVar.a(new CardPackDetailActivity$onCommentItemClick$1(this));
        this.v = z.c(CardPackDetailActivity$adapter$2.INSTANCE);
        this.w = eVar.a(new CardPackDetailActivity$onItemClick$1(this));
        this.x = dVar.a(new CardPackDetailActivity$onClickTipScore$1(this));
        this.y = dVar.a(new CardPackDetailActivity$onClickRank$1(this));
        this.z = dVar.a(new CardPackDetailActivity$onClickCardMore$1(this));
        this.A = dVar.a(new CardPackDetailActivity$onClickLike$1(this));
        this.B = dVar.a(new CardPackDetailActivity$onClickScore$1(this));
        this.C = dVar.a(new CardPackDetailActivity$onClickReview$1(this));
        this.D = dVar.a(new CardPackDetailActivity$onClickDesire$1(this));
    }

    public final void D0() {
        PackDetailResult value = ((CardPackDetailViewModel) L()).B0().getValue();
        r rVar = r.a;
        String M = M();
        Game b = e.l.l.a.b(this.gameKey, this.gameSubKey);
        rVar.l(M, b == null ? null : b.getShortName(), value == null ? null : value.getNameCN(), value == null ? null : value.getNumber(), value == null ? null : value.getReleasedAt(), value == null ? null : value.getCardVersionCount(), value == null ? null : value.getScoreNum(), value == null ? null : value.getGradeTotal(), value == null ? null : value.getLikeCount(), value == null ? null : value.getGradeUserTotal(), value == null ? null : value.getDesireCount());
    }

    private final ListView e0() {
        return (ListView) this.n.a(this, F[0]);
    }

    public final void s0() {
        ReviewListActivityCreator.create(((CardPackDetailViewModel) L()).C0(), null, Integer.valueOf(this.packId), null, this.gameKey, this.gameSubKey).start(this);
    }

    private final void t0() {
        f.g(((CardPackDetailViewModel) L()).B0(), null, new CardPackDetailActivity$initObserver$1(this), 1, null);
    }

    private final boolean v0(RecyclerView recyclerView) {
        return recyclerView != null && recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange();
    }

    public final void A0(int i2) {
        this.packId = i2;
    }

    public final void B0(boolean z) {
        this.E = z;
    }

    public final void C0(@k.e.a.d String str) {
        PackDetailResult value = ((CardPackDetailViewModel) L()).B0().getValue();
        r rVar = r.a;
        Game b = e.l.l.a.b(this.gameKey, this.gameSubKey);
        rVar.e(b == null ? null : b.getShortName(), value == null ? null : value.getNameCN(), value == null ? null : value.getNumber(), null, null, null, null, str);
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    public void F() {
        BinderKt.p(e.g.d.a.j(((CardPackDetailViewModel) L()).A0(this.packId, this.gameKey, this.gameSubKey), null, new CardPackDetailActivity$onRetryClick$1(this), 1, null));
    }

    @k.e.a.d
    public final e.l.g.l Y() {
        return (e.l.g.l) this.v.getValue();
    }

    @k.e.a.d
    public final CommentAdapter Z() {
        return (CommentAdapter) this.s.getValue();
    }

    @e
    public final CardCommentsDialog a0() {
        return this.q;
    }

    @e
    public final String b0() {
        return this.gameKey;
    }

    @e
    public final String c0() {
        return this.gameSubKey;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void d() {
        t0();
        F();
    }

    @k.e.a.d
    public final LayoutManagers.a d0() {
        return (LayoutManagers.a) this.t.getValue();
    }

    @k.e.a.d
    public final g f0() {
        return this.z;
    }

    @k.e.a.d
    public final g g0() {
        return this.D;
    }

    @k.e.a.d
    public final g h0() {
        return this.r;
    }

    @k.e.a.d
    public final g i0() {
        return this.A;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    public void j() {
        AppBarKt.b(w(), this, 0, null, 6, null);
        w().getMid().g(CardPackDetailActivity$flowOfAppBar$1.INSTANCE);
    }

    @k.e.a.d
    public final g j0() {
        return this.o;
    }

    @k.e.a.d
    public final g k0() {
        return this.p;
    }

    @k.e.a.d
    public final g l0() {
        return this.y;
    }

    @k.e.a.d
    public final g m0() {
        return this.C;
    }

    @k.e.a.d
    public final g n0() {
        return this.B;
    }

    @k.e.a.d
    public final g o0() {
        return this.x;
    }

    @Override // com.vector.design.ui.activity.ActivityEx, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, @e Intent intent) {
        CardCommentsDialog cardCommentsDialog;
        CardCommentsDialog cardCommentsDialog2;
        super.onActivityResult(i2, i3, intent);
        if (i2 == 10001) {
            if (i3 != -1) {
                if (i3 == 0 && (cardCommentsDialog2 = this.q) != null) {
                    cardCommentsDialog2.D();
                    return;
                }
                return;
            }
            User user = intent == null ? null : (User) intent.getParcelableExtra(AtUserActivity.C);
            if (user == null || (cardCommentsDialog = this.q) == null) {
                return;
            }
            cardCommentsDialog.K(user);
        }
    }

    @Override // com.jihuanshe.ui.BaseActivity, com.vector.design.ui.activity.SimpleActivityEx, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.E) {
            F();
        } else {
            this.E = true;
        }
    }

    @k.e.a.d
    public final l p0() {
        return this.u;
    }

    @Override // com.vector.design.ui.activity.SimpleActivityEx
    @k.e.a.d
    public ViewDataBinding q() {
        s e2 = s.e(getLayoutInflater());
        e2.i(this);
        e2.j((CardPackDetailViewModel) L());
        return e2;
    }

    @k.e.a.d
    public final l q0() {
        return this.w;
    }

    public final int r0() {
        return this.packId;
    }

    public final boolean u0() {
        return this.E;
    }

    @k.e.a.d
    public final g w0(@k.e.a.d NImageView nImageView) {
        return e.t.j.h.d.a.a(new CardPackDetailActivity$onClickPreview$1(this, nImageView));
    }

    public final void x0(@e CardCommentsDialog cardCommentsDialog) {
        this.q = cardCommentsDialog;
    }

    public final void y0(@e String str) {
        this.gameKey = str;
    }

    public final void z0(@e String str) {
        this.gameSubKey = str;
    }
}
