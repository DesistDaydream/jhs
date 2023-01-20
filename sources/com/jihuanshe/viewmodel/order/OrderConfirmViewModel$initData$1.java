package com.jihuanshe.viewmodel.order;

import com.jihuanshe.model.CardProduct;
import com.jihuanshe.model.UserAddress;
import e.l.l.a;
import e.l.n.c.n;
import h.e2.c;
import h.e2.j.b;
import h.k2.u.q;
import h.r0;
import h.t1;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Pair;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;

/* loaded from: classes2.dex */
public final class OrderConfirmViewModel$initData$1 extends SuspendLambda implements q<List<? extends UserAddress>, n, c<? super Pair<? extends UserAddress, ? extends n>>, Object> {
    public /* synthetic */ Object L$0;
    public /* synthetic */ Object L$1;
    public int label;

    public OrderConfirmViewModel$initData$1(c<? super OrderConfirmViewModel$initData$1> cVar) {
        super(3, cVar);
    }

    @Override // h.k2.u.q
    public /* bridge */ /* synthetic */ Object invoke(List<? extends UserAddress> list, n nVar, c<? super Pair<? extends UserAddress, ? extends n>> cVar) {
        return invoke2((List<UserAddress>) list, nVar, (c<? super Pair<UserAddress, n>>) cVar);
    }

    @e
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Object invoke2(@d List<UserAddress> list, @d n nVar, @e c<? super Pair<UserAddress, n>> cVar) {
        OrderConfirmViewModel$initData$1 orderConfirmViewModel$initData$1 = new OrderConfirmViewModel$initData$1(cVar);
        orderConfirmViewModel$initData$1.L$0 = list;
        orderConfirmViewModel$initData$1.L$1 = nVar;
        return orderConfirmViewModel$initData$1.invokeSuspend(t1.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    @e
    public final Object invokeSuspend(@d Object obj) {
        b.h();
        if (this.label == 0) {
            r0.n(obj);
            List list = (List) this.L$0;
            n nVar = (n) this.L$1;
            List<CardProduct> b = nVar.b();
            if (b != null) {
                for (CardProduct cardProduct : b) {
                    cardProduct.setGame(a.b(cardProduct.getGameKey(), cardProduct.getGameSubKey()));
                }
            }
            return new Pair(CollectionsKt___CollectionsKt.J2(list, 0), nVar);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
