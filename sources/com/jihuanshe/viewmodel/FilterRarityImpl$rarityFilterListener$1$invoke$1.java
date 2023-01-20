package com.jihuanshe.viewmodel;

import com.jihuanshe.model.Rarity;
import h.k2.u.l;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class FilterRarityImpl$rarityFilterListener$1$invoke$1 extends Lambda implements l<Rarity, CharSequence> {
    public static final FilterRarityImpl$rarityFilterListener$1$invoke$1 INSTANCE = new FilterRarityImpl$rarityFilterListener$1$invoke$1();

    public FilterRarityImpl$rarityFilterListener$1$invoke$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final CharSequence invoke(@d Rarity rarity) {
        return rarity.getRarity();
    }
}
