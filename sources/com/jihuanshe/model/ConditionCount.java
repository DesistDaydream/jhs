package com.jihuanshe.model;

import com.meizu.cloud.pushsdk.constants.PushConstants;
import e.j.e.r.c;

/* loaded from: classes2.dex */
public final class ConditionCount {
    @c("1")
    private final int best;
    @c("2")
    private final int better;
    @c("3")
    private final int damage;
    @c(PushConstants.PUSH_TYPE_WITHDRAW_NOTIFICATION)
    private final int level;

    public ConditionCount(int i2, int i3, int i4, int i5) {
        this.best = i2;
        this.better = i3;
        this.damage = i4;
        this.level = i5;
    }

    public final int getBest() {
        return this.best;
    }

    public final int getBetter() {
        return this.better;
    }

    public final int getDamage() {
        return this.damage;
    }

    public final int getLevel() {
        return this.level;
    }
}
