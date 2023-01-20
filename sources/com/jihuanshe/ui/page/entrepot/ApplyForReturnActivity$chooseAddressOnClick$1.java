package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.ui.page.order.AddressActivityCreator;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnActivity$chooseAddressOnClick$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ ApplyForReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnActivity$chooseAddressOnClick$1(ApplyForReturnActivity applyForReturnActivity) {
        super(1);
        this.this$0 = applyForReturnActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        AddressActivityCreator.create().start(this.this$0);
    }
}
