package com.jihuanshe.viewmodel.user.wish;

import com.jihuanshe.model.Product;
import e.g.e.a;
import h.k2.u.l;
import h.k2.v.t0;
import h.t1;
import java.util.HashMap;
import java.util.Objects;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListViewModel$handleWish$b$2 extends Lambda implements l<a, t1> {
    public final /* synthetic */ Product $item;
    public final /* synthetic */ WishListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListViewModel$handleWish$b$2(WishListViewModel wishListViewModel, Product product) {
        super(1);
        this.this$0 = wishListViewModel;
        this.$item = product;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(a aVar) {
        invoke2(aVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d a aVar) {
        HashMap hashMap;
        hashMap = this.this$0.f4594e;
        Integer id = this.$item.getId();
        Objects.requireNonNull(hashMap, "null cannot be cast to non-null type kotlin.collections.MutableMap<K, V>");
        t0.k(hashMap).remove(id);
    }
}
