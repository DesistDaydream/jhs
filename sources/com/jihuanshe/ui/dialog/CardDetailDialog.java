package com.jihuanshe.ui.dialog;

import android.content.Context;
import android.view.View;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.LifecycleOwnerKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.CardBaseInfo;
import com.jihuanshe.model.Game;
import com.vector.ext.AnyKt;
import e.l.g.x0;
import e.l.k.u3;
import e.l.n.c.b;
import e.l.q.a.k0.k;
import e.l.q.a.k0.r;
import e.n.f;
import e.t.j.h.g;
import h.i;
import h.k2.u.a;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@i(message = "use CardBaseInfoDetailDialog instead")
/* loaded from: classes2.dex */
public final class CardDetailDialog extends BaseDialog {
    @d
    private final w A;
    @d
    private List<String> B;
    @d
    private final w C;
    @d
    private final f<CardBaseInfo> D;
    @d
    private final g E;
    @d
    private final g F;
    @d
    private final g G;
    @d
    private final g H;
    @d
    private final g I;
    @e
    private Integer t;
    @e
    private Integer u;
    @e
    private String v;
    @e
    private String w;
    @d
    private final a<t1> x;
    @d
    private final l<Integer, t1> y;
    @d
    private final l<List<String>, t1> z;

    public /* synthetic */ CardDetailDialog(Context context, Integer num, Integer num2, String str, String str2, a aVar, l lVar, l lVar2, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : num2, (i2 & 8) != 0 ? null : str, (i2 & 16) != 0 ? null : str2, aVar, lVar, lVar2);
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public ViewDataBinding d() {
        u3 e2 = u3.e(getLayoutInflater(), this, false);
        e2.h(this);
        return e2;
    }

    @d
    public final f<CardBaseInfo> getCardInfo() {
        return this.D;
    }

    @d
    public final l<List<String>, t1> getErrorCorrect() {
        return this.z;
    }

    @e
    public final Game getGame() {
        return (Game) this.A.getValue();
    }

    @e
    public final String getGameKey() {
        return this.v;
    }

    @e
    public final String getGameSubKey() {
        return this.w;
    }

    @d
    public final l<Integer, t1> getGoPack() {
        return this.y;
    }

    @Override // android.view.View
    @e
    public final Integer getId() {
        return this.t;
    }

    @d
    public final g getOnClickClose() {
        return this.I;
    }

    @d
    public final g getOnClickError() {
        return this.E;
    }

    @d
    public final g getOnClickGoPack() {
        return this.G;
    }

    @d
    public final g getOnClickPreview() {
        return this.H;
    }

    @d
    public final g getOnClickShare() {
        return this.F;
    }

    @d
    public final a<t1> getShare() {
        return this.x;
    }

    @d
    public final x0 getStarAdapter() {
        return (x0) this.C.getValue();
    }

    @e
    public final Integer getVersionId() {
        return this.u;
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    public void k() {
        setGravity(80);
        if (AnyKt.l(this.t) || AnyKt.l(this.u)) {
            return;
        }
        b bVar = (b) e.l.n.a.d(b.class, true, true, true, 60L, true);
        String str = this.v;
        Integer num = this.u;
        BinderKt.p(e.g.d.a.h(e.g.d.a.j(FlowKt.c(bVar.c(str, num == null ? 0 : num.intValue())), null, new CardDetailDialog$flowOfSetup$1(this), 1, null), LifecycleOwnerKt.getLifecycleScope(this), null, 2, null));
    }

    @Override // com.jihuanshe.ui.dialog.BaseDialog
    @d
    public k l(@d View view) {
        return new r(view);
    }

    public final void setGameKey(@e String str) {
        this.v = str;
    }

    public final void setGameSubKey(@e String str) {
        this.w = str;
    }

    public final void setId(@e Integer num) {
        this.t = num;
    }

    public final void setVersionId(@e Integer num) {
        this.u = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public CardDetailDialog(@d Context context, @e Integer num, @e Integer num2, @e String str, @e String str2, @d a<t1> aVar, @d l<? super Integer, t1> lVar, @d l<? super List<String>, t1> lVar2) {
        super(context);
        this.t = num;
        this.u = num2;
        this.v = str;
        this.w = str2;
        this.x = aVar;
        this.y = lVar;
        this.z = lVar2;
        this.A = z.c(new CardDetailDialog$game$2(this));
        this.B = new ArrayList();
        this.C = z.c(CardDetailDialog$starAdapter$2.INSTANCE);
        this.D = new f<>(null, 1, null);
        e.t.j.h.d dVar = e.t.j.h.d.a;
        this.E = dVar.a(new CardDetailDialog$onClickError$1(this));
        this.F = dVar.a(new CardDetailDialog$onClickShare$1(this));
        this.G = dVar.a(CardDetailDialog$onClickGoPack$1.INSTANCE);
        this.H = dVar.a(new CardDetailDialog$onClickPreview$1(context, this));
        this.I = dVar.a(new CardDetailDialog$onClickClose$1(this));
    }
}
