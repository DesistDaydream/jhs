package com.jihuanshe.viewmodel.shop;

import com.jihuanshe.model.Game;
import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellCalendarViewModel$getGameIds$1 extends Lambda implements l<Game, CharSequence> {
    public static final SellCalendarViewModel$getGameIds$1 INSTANCE = new SellCalendarViewModel$getGameIds$1();

    public SellCalendarViewModel$getGameIds$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d Game game) {
        return String.valueOf(game.getGame_subKey_id());
    }
}
