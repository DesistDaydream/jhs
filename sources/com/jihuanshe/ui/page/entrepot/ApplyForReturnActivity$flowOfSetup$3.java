package com.jihuanshe.ui.page.entrepot;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import com.vector.view.scrollable.ListView;
import e.g.d.a;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnActivity$flowOfSetup$3 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ ApplyForReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnActivity$flowOfSetup$3(ApplyForReturnActivity applyForReturnActivity) {
        super(1);
        this.this$0 = applyForReturnActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        ListView f0;
        ((ApplyForReturnViewModel) this.this$0.L()).x0().p();
        ((ApplyForReturnViewModel) this.this$0.L()).E0().p();
        this.this$0.d0().clear();
        if (i2 == 2) {
            a u0 = ApplyForReturnViewModel.u0((ApplyForReturnViewModel) this.this$0.L(), null, 1, null);
            ApplyForReturnActivity applyForReturnActivity = this.this$0;
            f0 = applyForReturnActivity.f0();
            BinderKt.e(u0, applyForReturnActivity, f0, false, 4, null);
            return;
        }
        this.this$0.F();
    }
}
