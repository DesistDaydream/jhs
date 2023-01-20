package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.model.WareCache;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SubmitOrderActivity$flowOfSetup$1 extends Lambda implements l<WareCache, t1> {
    public static final SubmitOrderActivity$flowOfSetup$1 INSTANCE = new SubmitOrderActivity$flowOfSetup$1();

    public SubmitOrderActivity$flowOfSetup$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(WareCache wareCache) {
        invoke2(wareCache);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d WareCache wareCache) {
        UserKV.f3913c.E(wareCache);
    }
}
