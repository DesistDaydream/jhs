package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.u;
import java.util.List;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class VerifyInfo {
    @c("banks")
    @e
    private final List<String> banks;
    @c("merchant_tips")
    @e
    private final String shopTips;
    @c("tips")
    @e
    private final String tips;

    public VerifyInfo() {
        this(null, null, null, 7, null);
    }

    public VerifyInfo(@e List<String> list, @e String str, @e String str2) {
        this.banks = list;
        this.tips = str;
        this.shopTips = str2;
    }

    @e
    public final List<String> getBanks() {
        return this.banks;
    }

    @e
    public final String getShopTips() {
        return this.shopTips;
    }

    @e
    public final String getTips() {
        return this.tips;
    }

    public /* synthetic */ VerifyInfo(List list, String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }
}
