package com.jihuanshe.viewmodel.user.wish;

import androidx.lifecycle.ViewModelKt;
import com.eth.ext.FlowKt;
import com.jihuanshe.model.Constants;
import com.jihuanshe.model.Product;
import e.l.n.c.k;
import h.k2.u.a;
import h.k2.v.f0;
import h.t1;
import java.util.HashMap;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class WishListViewModel$handleWish$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ a<t1> $callBack;
    public final /* synthetic */ Product $item;
    public final /* synthetic */ WishListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WishListViewModel$handleWish$1$1(WishListViewModel wishListViewModel, Product product, a<t1> aVar) {
        super(0);
        this.this$0 = wishListViewModel;
        this.$item = product;
        this.$callBack = aVar;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashMap hashMap;
        HashMap hashMap2;
        hashMap = this.this$0.f4594e;
        Integer id = this.$item.getId();
        Object obj = hashMap.get(Integer.valueOf(id == null ? -1 : id.intValue()));
        if (obj == null) {
            obj = null;
        }
        e.g.d.a aVar = (e.g.d.a) obj;
        if (aVar != null) {
            aVar.b();
        }
        this.$item.setInWishList(false);
        k kVar = (k) e.l.n.a.d(k.class, true, false, false, 60L, true);
        String type = this.$item.getType();
        String type2 = this.$item.getType();
        Constants.Companion companion = Constants.Companion;
        e.g.d.a h2 = e.g.d.a.h(e.g.d.a.o(e.g.d.a.j(FlowKt.c(kVar.f(type, f0.g(type2, companion.getTYPE_CARD()) ? this.$item.getId() : null, f0.g(this.$item.getType(), companion.getTYPE_PACK()) ? this.$item.getId() : null, this.$item.getGameKey(), this.$item.getGameSubKey())), null, new WishListViewModel$handleWish$1$1$b$1(this.this$0, this.$item), 1, null), null, new WishListViewModel$handleWish$1$1$b$2(this.this$0, this.$item), 1, null), ViewModelKt.getViewModelScope(this.this$0), null, 2, null);
        Integer id2 = this.$item.getId();
        if (id2 != null) {
            WishListViewModel wishListViewModel = this.this$0;
            int intValue = id2.intValue();
            hashMap2 = wishListViewModel.f4594e;
            e.g.d.a aVar2 = (e.g.d.a) hashMap2.put(Integer.valueOf(intValue), h2);
        }
        this.$callBack.invoke();
    }
}
