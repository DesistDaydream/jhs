package com.jihuanshe.ui.page.exam;

import android.view.View;
import com.jihuanshe.R;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import com.vector.util.Res;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EtiquetteExamActivity$onClickStart$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ EtiquetteExamActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamActivity$onClickStart$1(EtiquetteExamActivity etiquetteExamActivity) {
        super(1);
        this.this$0 = etiquetteExamActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d View view) {
        if (((EtiquetteExamViewModel) this.this$0.L()).u0().isEmpty()) {
            e.h(this.this$0, Res.w(Res.a, R.string.error_network, null, 2, null), null, null, null, 0, null, 62, null);
        } else {
            ((EtiquetteExamViewModel) this.this$0.L()).A0().setValue(1);
        }
    }
}
