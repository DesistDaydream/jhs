package com.jihuanshe.ui.page.entrepot;

import android.view.View;
import com.jihuanshe.model.ReturnCardInfo;
import com.jihuanshe.viewmodel.entrepot.ApplyForReturnViewModel;
import h.k2.u.p;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class ApplyForReturnActivity$onItemClick$1 extends Lambda implements p<View, Integer, t1> {
    public final /* synthetic */ ApplyForReturnActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplyForReturnActivity$onItemClick$1(ApplyForReturnActivity applyForReturnActivity) {
        super(2);
        this.this$0 = applyForReturnActivity;
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(View view, Integer num) {
        invoke(view, num.intValue());
        return t1.a;
    }

    public final void invoke(@e View view, int i2) {
        ReturnCardInfo returnCardInfo;
        List<ReturnCardInfo> value = ((ApplyForReturnViewModel) this.this$0.L()).x0().getValue();
        ReturnCardInfo returnCardInfo2 = value == null ? null : (ReturnCardInfo) CollectionsKt___CollectionsKt.J2(value, i2);
        if (returnCardInfo2 == null) {
            return;
        }
        List<ReturnCardInfo> value2 = ((ApplyForReturnViewModel) this.this$0.L()).x0().getValue();
        ReturnCardInfo returnCardInfo3 = value2 == null ? null : value2.get(i2);
        if (returnCardInfo3 != null) {
            returnCardInfo3.setChecked(!returnCardInfo2.isChecked());
        }
        ((ApplyForReturnViewModel) this.this$0.L()).x0().n();
        List<ReturnCardInfo> value3 = ((ApplyForReturnViewModel) this.this$0.L()).x0().getValue();
        if ((value3 == null || (returnCardInfo = value3.get(i2)) == null || !returnCardInfo.isChecked()) ? false : true) {
            List<ReturnCardInfo> d0 = this.this$0.d0();
            List<ReturnCardInfo> value4 = ((ApplyForReturnViewModel) this.this$0.L()).x0().getValue();
            d0.add(value4 != null ? value4.get(i2) : null);
        } else {
            List<ReturnCardInfo> d02 = this.this$0.d0();
            List<ReturnCardInfo> value5 = ((ApplyForReturnViewModel) this.this$0.L()).x0().getValue();
            d02.remove(value5 != null ? value5.get(i2) : null);
        }
        ((ApplyForReturnViewModel) this.this$0.L()).E0().setValue(Integer.valueOf(this.this$0.d0().size()));
    }
}
