package com.jihuanshe.viewmodel.user.wish;

import com.jihuanshe.model.Product;
import h.k2.u.l;
import h.k2.v.t0;
import h.t1;
import java.util.HashMap;
import java.util.Objects;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListViewModel$handleWish$1$1$b$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ Product $item;
    public final /* synthetic */ WishListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListViewModel$handleWish$1$1$b$1(WishListViewModel wishListViewModel, Product product) {
        super(1);
        this.this$0 = wishListViewModel;
        this.$item = product;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        HashMap hashMap;
        hashMap = this.this$0.f4594e;
        Integer id = this.$item.getId();
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        t0.k(hashMap).remove(id);
    }
}
