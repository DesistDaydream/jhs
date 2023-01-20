package com.jihuanshe.viewmodel.exam;

import com.jihuanshe.model.EtiquetteExamResult;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class EtiquetteExamViewModel$commitAnswer$1 extends Lambda implements l<List<? extends EtiquetteExamResult>, t1> {
    public final /* synthetic */ EtiquetteExamViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamViewModel$commitAnswer$1(EtiquetteExamViewModel etiquetteExamViewModel) {
        super(1);
        this.this$0 = etiquetteExamViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends EtiquetteExamResult> list) {
        invoke2((List<EtiquetteExamResult>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<EtiquetteExamResult> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : list) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt__CollectionsKt.W();
            }
            Integer correct = ((EtiquetteExamResult) obj).getCorrect();
            if (correct == null || correct.intValue() != 1) {
                arrayList.add(Integer.valueOf(i2));
            }
            i2 = i3;
        }
        this.this$0.v0().r(arrayList);
    }
}
