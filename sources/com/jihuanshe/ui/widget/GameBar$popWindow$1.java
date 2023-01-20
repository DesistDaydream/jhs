package com.jihuanshe.ui.widget;

import com.jihuanshe.model.Game;
import e.l.m.b;
import e.l.o.a.a.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class GameBar$popWindow$1 extends Lambda implements l<Integer, t1> {
    public static final GameBar$popWindow$1 INSTANCE = new GameBar$popWindow$1();

    public GameBar$popWindow$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        Game game = a.a.e().get(i2);
        b.f14084c.z(game.getName());
        GameBar.b.a().setValue(game);
    }
}
