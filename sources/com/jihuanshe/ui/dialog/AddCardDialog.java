package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.databinding.ViewDataBinding;
import com.eth.model.NLive;
import com.jihuanshe.R;
import com.jihuanshe.model.CardInfo;
import com.jihuanshe.model.CardPack;
import com.jihuanshe.model.CardProductNew;
import com.jihuanshe.model.CardVersion;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.GameKt;
import com.jihuanshe.model.WantCard;
import com.jihuanshe.ui.widget.GameBar;
import com.vector.ext.bind.BindViewKt;
import com.vector.network.image.NImageView;
import com.vector.util.LayoutManagers;
import e.l.g.j0;
import e.l.g.x0;
import e.l.k.e6;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.f;
import e.n.i;
import e.n.l;
import e.t.j.h.d;
import e.t.j.h.g;
import h.k2.u.a;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.m2.e;
import h.p2.n;
import h.t1;
import h.w;
import h.z;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.PropertyReference1Impl;

/* loaded from: classes2.dex */
public final class AddCardDialog extends BaseDialog {
    public static final /* synthetic */ n<Object>[] V;
    @d
    private final e A;
    @d
    private final l B;
    private final int C;
    @d
    private final i D;
    @d
    private final w E;
    @d
    private final w F;
    @d
    private final w G;
    @d
    private final w H;
    @d
    private final e.t.j.h.l I;
    @d
    private final w J;
    @d
    private final f<CardVersion> K;
    @d
    private final f<CardPack> L;
    @d
    private final l M;
    @d
    private final g N;
    @d
    private l O;
    @d
    private final g P;
    @d
    private final g Q;
    @d
    private final g R;
    @d
    private final g S;
    @d
    private final g T;
    @k.e.a.e
    private e6 U;
    @k.e.a.e
    private final CardInfo t;
    @k.e.a.e
    private final List<CardPack> u;
    @k.e.a.e
    private final GameCard v;
    @k.e.a.e
    private final WantCard w;
    private final boolean x;
    @k.e.a.e
    private final NLive<CardProductNew> y;
    @d
    private final e z;

    static {
        n<Object>[] nVarArr = new n[7];
        nVarArr[0] = n0.r(new PropertyReference1Impl(n0.d(AddCardDialog.class), "priceEt", "getPriceEt()Landroid/widget/EditText;"));
        nVarArr[1] = n0.r(new PropertyReference1Impl(n0.d(AddCardDialog.class), "remarkEt", "getRemarkEt()Landroid/widget/EditText;"));
        V = nVarArr;
    }

    public /* synthetic */ AddCardDialog(Context context, CardInfo cardInfo, List list, GameCard gameCard, WantCard wantCard, boolean z, NLive nLive, a aVar, h.k2.u.l lVar, h.k2.u.l lVar2, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : cardInfo, list, (i2 & 8) != 0 ? null : gameCard, (i2 & 16) != 0 ? null : wantCard, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : nLive, (i2 & 128) != 0 ? null : aVar, (i2 & 256) != 0 ? null : lVar, (i2 & 512) != 0 ? null : lVar2);
    }

    @d
    public final g C(int i2) {
        return e.t.j.h.d.a.a(new AddCardDialog$chooseRarity$1(this, i2));
    }

    @d
    public final g D(@d NImageView nImageView) {
        return e.t.j.h.d.a.a(new AddCardDialog$onClickImage$1(this, nImageView));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        e6 e2 = e6.e(getLayoutInflater(), this, false);
        this.U = e2;
        e2.h(this);
        return this.U;
    }

    @d
    public final x0 getAdapter() {
        return (x0) this.G.getValue();
    }

    @d
    public final j0 getAdapterBot() {
        return (j0) this.H.getValue();
    }

    @k.e.a.e
    public final e6 getBinding() {
        return this.U;
    }

    @k.e.a.e
    public final CardInfo getCardInfo() {
        return this.t;
    }

    @k.e.a.e
    public final List<CardPack> getCardPacks() {
        return this.u;
    }

    @k.e.a.e
    public final NLive<CardProductNew> getCardProductNew() {
        return this.y;
    }

    @d
    public final l getCount() {
        return this.B;
    }

    @d
    public final f<CardVersion> getCurCardVer() {
        return this.K;
    }

    @d
    public final List<Integer> getData() {
        return (List) this.J.getValue();
    }

    @k.e.a.e
    public final GameCard getGameCard() {
        return this.v;
    }

    public final boolean getHasRarity() {
        return this.x;
    }

    @d
    public final TextView getHeader() {
        return (TextView) this.F.getValue();
    }

    @d
    public final l getIgnore() {
        return this.O;
    }

    @d
    public final LayoutManagers.a getLayoutManager() {
        return (LayoutManagers.a) this.E.getValue();
    }

    public final int getMax() {
        return this.C;
    }

    @d
    public final g getOnClickClose() {
        return this.S;
    }

    @d
    public final g getOnClickIgnore() {
        return this.Q;
    }

    @d
    public final g getOnClickMark() {
        return this.T;
    }

    @d
    public final g getOnClickVersion() {
        return this.P;
    }

    @d
    public final g getOnDeleteClick() {
        return this.N;
    }

    @d
    public final e.t.j.h.l getOnItemClick() {
        return this.I;
    }

    @d
    public final g getOnSave() {
        return this.R;
    }

    @d
    public final EditText getPriceEt() {
        return (EditText) this.z.a(this, V[0]);
    }

    @d
    public final l getRarity() {
        return this.M;
    }

    @d
    public final EditText getRemarkEt() {
        return (EditText) this.A.a(this, V[1]);
    }

    @d
    public final i getShowNo() {
        return this.D;
    }

    @d
    public final f<CardPack> getVersion() {
        return this.L;
    }

    @k.e.a.e
    public final WantCard getWantCard() {
        return this.w;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setMoveWithKeyboard(true);
        setGravity(80);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public final void setBinding(@k.e.a.e e6 e6Var) {
        this.U = e6Var;
    }

    public final void setIgnore(@d l lVar) {
        this.O = lVar;
    }

    public AddCardDialog(@d Context context, @k.e.a.e CardInfo cardInfo, @k.e.a.e List<CardPack> list, @k.e.a.e GameCard gameCard, @k.e.a.e WantCard wantCard, boolean z, @k.e.a.e NLive<CardProductNew> nLive, @k.e.a.e a<t1> aVar, @k.e.a.e h.k2.u.l<? super WantCard, t1> lVar, @k.e.a.e h.k2.u.l<? super Integer, t1> lVar2) {
        super(context);
        CardVersion cardVersion;
        Object obj;
        CardPack cardPack;
        boolean g2;
        List<CardVersion> versions;
        Object obj2;
        boolean g3;
        List<CardVersion> versions2;
        this.t = cardInfo;
        this.u = list;
        this.v = gameCard;
        this.w = wantCard;
        this.x = z;
        this.y = nLive;
        this.z = BindViewKt.p(this, R.id.priceEt);
        this.A = BindViewKt.p(this, R.id.remarkEt);
        this.B = new l(Integer.valueOf(wantCard == null ? 1 : wantCard.getQuantity()));
        this.C = GameKt.getMax(GameBar.b.a().getValue());
        this.D = new i(Boolean.FALSE);
        this.E = z.c(AddCardDialog$layoutManager$2.INSTANCE);
        this.F = z.c(new AddCardDialog$header$2(context));
        this.G = z.c(AddCardDialog$adapter$2.INSTANCE);
        this.H = z.c(AddCardDialog$adapterBot$2.INSTANCE);
        this.I = d.e.a.a(new AddCardDialog$onItemClick$1(lVar2));
        this.J = z.c(new AddCardDialog$data$2(this));
        if (gameCard == null) {
            if (cardInfo == null || (versions = cardInfo.getVersions()) == null) {
                cardVersion = null;
            } else {
                Iterator<T> it = versions.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj2 = null;
                        break;
                    }
                    obj2 = it.next();
                    int id = ((CardVersion) obj2).getId();
                    WantCard wantCard2 = getWantCard();
                    if (wantCard2 == null) {
                        g3 = false;
                        continue;
                    } else {
                        g3 = f0.g(Integer.valueOf(id), wantCard2.getVersionId());
                        continue;
                    }
                    if (g3) {
                        break;
                    }
                }
                cardVersion = (CardVersion) obj2;
            }
            if (cardVersion == null) {
                CardInfo cardInfo2 = this.t;
                cardVersion = (cardInfo2 == null || (versions2 = cardInfo2.getVersions()) == null) ? null : (CardVersion) CollectionsKt___CollectionsKt.J2(versions2, 0);
            }
        } else {
            cardVersion = new CardVersion(gameCard.getVersionId(), gameCard.getVersionNum(), gameCard.getRarity(), Float.valueOf(gameCard.getMinPrice()), Float.valueOf(gameCard.getAvgPrice()), null, gameCard.getImg());
        }
        this.K = new f<>(cardVersion);
        List<CardPack> list2 = this.u;
        if (list2 == null) {
            cardPack = null;
        } else {
            Iterator<T> it2 = list2.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                int versionId = ((CardPack) obj).getVersionId();
                WantCard wantCard3 = getWantCard();
                if (wantCard3 == null) {
                    g2 = false;
                    continue;
                } else {
                    g2 = f0.g(Integer.valueOf(versionId), wantCard3.getVersionId());
                    continue;
                }
                if (g2) {
                    break;
                }
            }
            cardPack = (CardPack) obj;
        }
        if (cardPack == null) {
            List<CardPack> list3 = this.u;
            cardPack = list3 == null ? null : (CardPack) CollectionsKt___CollectionsKt.J2(list3, 0);
            if (cardPack == null) {
                GameCard gameCard2 = this.v;
                cardPack = new CardPack(0, gameCard2 == null ? null : gameCard2.getNwName());
                GameCard gameCard3 = getGameCard();
                cardPack.setMinPrice(gameCard3 == null ? 0.0f : gameCard3.getMinPrice());
                GameCard gameCard4 = getGameCard();
                cardPack.setVersionStr(gameCard4 == null ? null : gameCard4.rarityStr());
                GameCard gameCard5 = getGameCard();
                cardPack.setVersionId(gameCard5 == null ? 0 : gameCard5.getVersionId());
                GameCard gameCard6 = getGameCard();
                cardPack.setImage(gameCard6 != null ? gameCard6.getImg() : null);
                t1 t1Var = t1.a;
            }
        }
        this.L = new f<>(cardPack);
        this.M = new l(1);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.N = dVar.a(new AddCardDialog$onDeleteClick$1(context, this, aVar));
        WantCard wantCard4 = this.w;
        this.O = new l(Integer.valueOf(wantCard4 != null ? wantCard4.getIgnoreVersion() : 0));
        this.P = dVar.a(new AddCardDialog$onClickVersion$1(this, context));
        this.Q = dVar.a(new AddCardDialog$onClickIgnore$1(this));
        this.R = dVar.a(new AddCardDialog$onSave$1(this, lVar));
        this.S = dVar.a(new AddCardDialog$onClickClose$1(this));
        this.T = dVar.a(new AddCardDialog$onClickMark$1(this));
    }
}
