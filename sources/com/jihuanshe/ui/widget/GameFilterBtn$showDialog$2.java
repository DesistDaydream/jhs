package com.jihuanshe.ui.widget;

import com.jihuanshe.model.Game;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GameFilterBtn$showDialog$2 extends Lambda implements l<Game, t1> {
    public final /* synthetic */ GameFilterBtn this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GameFilterBtn$showDialog$2(GameFilterBtn gameFilterBtn) {
        super(1);
        this.this$0 = gameFilterBtn;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Game game) {
        invoke2(game);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Game game) {
        GameFilterBtn gameFilterBtn = this.this$0;
        String name = game == null ? null : game.getName();
        if (name == null) {
            name = this.this$0.f4112i;
        }
        gameFilterBtn.setText(name);
        this.this$0.setCurrent(game);
        l<Game, t1> listener = this.this$0.getListener();
        if (listener == null) {
            return;
        }
        listener.invoke(this.this$0.getCurrent());
    }
}
