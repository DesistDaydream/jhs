package com.jihuanshe.viewmodel.user;

import com.jihuanshe.model.User;
import com.jihuanshe.model.WithDrawResult;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinViewModel$withDraw$1 extends Lambda implements l<WithDrawResult, t1> {
    public final /* synthetic */ CoinViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinViewModel$withDraw$1(CoinViewModel coinViewModel) {
        super(1);
        this.this$0 = coinViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(WithDrawResult withDrawResult) {
        invoke2(withDrawResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e WithDrawResult withDrawResult) {
        User value = this.this$0.u0().getValue();
        if (value != null) {
            value.setBalance(withDrawResult == null ? 0.0f : withDrawResult.getBalance());
        }
        this.this$0.u0().n();
    }
}
