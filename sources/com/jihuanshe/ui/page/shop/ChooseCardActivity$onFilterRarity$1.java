package com.jihuanshe.ui.page.shop;

import com.jihuanshe.model.Rarity;
import com.jihuanshe.viewmodel.shop.ChooseCardViewModel;
import h.k2.u.l;
import h.t1;
import java.util.Iterator;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ChooseCardActivity$onFilterRarity$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ ChooseCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChooseCardActivity$onFilterRarity$1(ChooseCardActivity chooseCardActivity) {
        super(1);
        this.this$0 = chooseCardActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<Rarity> list) {
        Iterator<T> it;
        if (list != null) {
            String str = "";
            while (list.iterator().hasNext()) {
                str = str + ',' + ((Rarity) it.next()).getRarity();
            }
            ((ChooseCardViewModel) this.this$0.L()).N().setValue(str);
        }
    }
}
