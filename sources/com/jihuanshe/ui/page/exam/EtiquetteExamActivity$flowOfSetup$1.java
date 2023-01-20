package com.jihuanshe.ui.page.exam;

import com.jihuanshe.R;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import com.vector.util.Res;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EtiquetteExamActivity$flowOfSetup$1 extends Lambda implements l<Integer, t1> {
    public final /* synthetic */ EtiquetteExamActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamActivity$flowOfSetup$1(EtiquetteExamActivity etiquetteExamActivity) {
        super(1);
        this.this$0 = etiquetteExamActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Integer num) {
        invoke(num.intValue());
        return t1.a;
    }

    public final void invoke(int i2) {
        if (i2 == 2) {
            ((EtiquetteExamViewModel) this.this$0.L()).y0().setValue(Res.w(Res.a, R.string.etiquette_reanswer, null, 2, null));
        } else if (i2 != 3) {
        } else {
            ((EtiquetteExamViewModel) this.this$0.L()).y0().setValue(Res.w(Res.a, R.string.etiquette_back, null, 2, null));
        }
    }
}
