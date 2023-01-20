package com.jihuanshe.model;

import k.e.a.e;

/* loaded from: classes2.dex */
public final class GameKt {
    public static final int getMax(@e Game game) {
        if (game == null || game.getMaxCount() == null) {
            return 3;
        }
        return game.getMaxCount().intValue();
    }

    public static final float ratio(@e Game game) {
        if (game == null || game.getWidth() == 0 || game.getHeight() == 0) {
            return 0.6885246f;
        }
        return (game.getWidth() * 1.0f) / game.getHeight();
    }
}
