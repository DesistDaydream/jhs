package com.jihuanshe.viewmodel.shop;

import com.jihuanshe.model.CardPackage;
import com.jihuanshe.model.Category;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardViewModel$getCategory$1 extends Lambda implements l<List<? extends Category>, t1> {
    public final /* synthetic */ AddCardViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardViewModel$getCategory$1(AddCardViewModel addCardViewModel) {
        super(1);
        this.this$0 = addCardViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Category> list) {
        invoke2((List<Category>) list);
        return t1.a;
    }

    /* renamed from: invoke */
    public final void invoke2(@e List<Category> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            int i2 = 0;
            for (Object obj : list) {
                int i3 = i2 + 1;
                if (i2 < 0) {
                    CollectionsKt__CollectionsKt.W();
                }
                Category category = (Category) obj;
                arrayList.add(category);
                List<CardPackage> plist = category.getPlist();
                if (plist == null) {
                    plist = CollectionsKt__CollectionsKt.E();
                }
                arrayList.addAll(plist);
                i2 = i3;
            }
        }
        this.this$0.s0().setValue(arrayList);
    }
}
