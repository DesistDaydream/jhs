package com.jihuanshe.ui.widget;

import android.view.View;
import com.jihuanshe.model.Game;
import e.l.m.b;
import e.l.o.a.a.a;
import h.k2.u.l;
import h.k2.u.p;
import h.k2.v.f0;
import h.t1;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GamesPopupWindow$onFilterItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ GamesPopupWindow this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GamesPopupWindow$onFilterItemClick$1(GamesPopupWindow gamesPopupWindow) {
        super(2);
        this.this$0 = gamesPopupWindow;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        Integer warehouse;
        a aVar = a.a;
        Game game = (Game) CollectionsKt___CollectionsKt.J2(aVar.e(), i2);
        if (game == null) {
            return;
        }
        if (f0.g(this.this$0.c(), Boolean.TRUE) && (warehouse = game.getWarehouse()) != null && warehouse.intValue() == 0) {
            return;
        }
        b.f14084c.z(game.getName());
        GameBar.b.a().setValue(game);
        l<Game, t1> e2 = this.this$0.e();
        if (e2 != null) {
            e2.invoke(aVar.e().get(i2));
        }
        l<Boolean, t1> j2 = this.this$0.j();
        if (j2 != null) {
            j2.invoke(Boolean.FALSE);
        }
        this.this$0.dismiss();
    }
}
