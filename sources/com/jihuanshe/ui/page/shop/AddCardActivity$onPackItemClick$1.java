package com.jihuanshe.ui.page.shop;

import android.view.View;
import com.jihuanshe.model.CardPackage;
import com.jihuanshe.viewmodel.shop.AddCardViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class AddCardActivity$onPackItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ AddCardActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AddCardActivity$onPackItemClick$1(AddCardActivity addCardActivity) {
        super(2);
        this.this$0 = addCardActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        List<Object> value = ((AddCardViewModel) this.this$0.L()).s0().getValue();
        Object J2 = value == null ? null : CollectionsKt___CollectionsKt.J2(value, i2);
        if (J2 != null && (J2 instanceof CardPackage)) {
            ChooseCardActivityCreator.create(Integer.valueOf(this.this$0.getType()), Integer.valueOf(this.this$0.d0()), (CardPackage) J2, null).start(this.this$0);
        }
    }
}
