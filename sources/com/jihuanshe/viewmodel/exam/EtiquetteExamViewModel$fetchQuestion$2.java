package com.jihuanshe.viewmodel.exam;

import com.jihuanshe.model.EtiquetteQuestion;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EtiquetteExamViewModel$fetchQuestion$2 extends Lambda implements l<List<? extends EtiquetteQuestion>, t1> {
    public final /* synthetic */ EtiquetteExamViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamViewModel$fetchQuestion$2(EtiquetteExamViewModel etiquetteExamViewModel) {
        super(1);
        this.this$0 = etiquetteExamViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends EtiquetteQuestion> list) {
        invoke2((List<EtiquetteQuestion>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<EtiquetteQuestion> list) {
        if (list == null) {
            return;
        }
        this.this$0.u0().clear();
        this.this$0.u0().addAll(list);
        this.this$0.z0().setValue(Integer.valueOf(list.size()));
        this.this$0.B0();
    }
}
