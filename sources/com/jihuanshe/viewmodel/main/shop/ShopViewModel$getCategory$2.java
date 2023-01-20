package com.jihuanshe.viewmodel.main.shop;

import com.eth.model.NLive;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ShopViewModel$getCategory$2 extends Lambda implements l<List<? extends Category>, t1> {
    public final /* synthetic */ ShopViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopViewModel$getCategory$2(ShopViewModel shopViewModel) {
        super(1);
        this.this$0 = shopViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Category> list) {
        invoke2((List<Category>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Category> list) {
        List<CardPackage> plist;
        CardPackage cardPackage = null;
        Category category = list == null ? null : (Category) CollectionsKt___CollectionsKt.J2(list, 0);
        this.this$0.x0().setValue(category);
        NLive<CardPackage> w0 = this.this$0.w0();
        if (category != null && (plist = category.getPlist()) != null) {
            cardPackage = (CardPackage) CollectionsKt___CollectionsKt.J2(plist, 0);
        }
        w0.setValue(cardPackage);
        this.this$0.s().setValue(Boolean.FALSE);
    }
}
