package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.f0;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class Rarity {
    @c("count")
    @e
    private Integer count;
    @c("rarity")
    @d
    private final String rarity;

    public Rarity(@d String str, @e Integer num) {
        this.rarity = str;
        this.count = num;
    }

    public static /* synthetic */ Rarity copy$default(Rarity rarity, String str, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = rarity.rarity;
        }
        if ((i2 & 2) != 0) {
            num = rarity.count;
        }
        return rarity.copy(str, num);
    }

    @d
    public final String component1() {
        return this.rarity;
    }

    @e
    public final Integer component2() {
        return this.count;
    }

    @d
    public final Rarity copy(@d String str, @e Integer num) {
        return new Rarity(str, num);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(Rarity.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.Rarity");
            return f0.g(this.rarity, ((Rarity) obj).rarity);
        }
        return false;
    }

    @e
    public final Integer getCount() {
        return this.count;
    }

    @e
    public final Integer getCountReal() {
        Integer num = this.count;
        if (num != null && num.intValue() == -1) {
            return null;
        }
        return this.count;
    }

    @d
    public final String getCountStr() {
        Integer num = this.count;
        return (num == null || (num != null && num.intValue() == -1)) ? "" : String.valueOf(this.count);
    }

    @d
    public final String getRarity() {
        return this.rarity;
    }

    public int hashCode() {
        return this.rarity.hashCode();
    }

    public final void setCount(@e Integer num) {
        this.count = num;
    }

    @d
    public String toString() {
        return "Rarity(rarity=" + this.rarity + ", count=" + this.count + ')';
    }
}
