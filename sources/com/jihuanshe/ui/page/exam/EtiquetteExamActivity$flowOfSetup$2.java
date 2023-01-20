package com.jihuanshe.ui.page.exam;

import android.text.SpannableStringBuilder;
import com.jihuanshe.R;
import com.jihuanshe.mmkv.UserKV;
import com.jihuanshe.viewmodel.exam.EtiquetteExamViewModel;
import com.vector.util.Res;
import e.l.h.f.e;
import h.a2.u;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt__StringsKt;

/* loaded from: classes2.dex */
public final class EtiquetteExamActivity$flowOfSetup$2 extends Lambda implements l<List<? extends Integer>, t1> {
    public final /* synthetic */ EtiquetteExamActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EtiquetteExamActivity$flowOfSetup$2(EtiquetteExamActivity etiquetteExamActivity) {
        super(1);
        this.this$0 = etiquetteExamActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Integer> list) {
        invoke2((List<Integer>) list);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d List<Integer> list) {
        if (list.isEmpty()) {
            UserKV.f3913c.D(true);
            ((EtiquetteExamViewModel) this.this$0.L()).A0().setValue(3);
            return;
        }
        ((EtiquetteExamViewModel) this.this$0.L()).A0().setValue(2);
        ArrayList arrayList = new ArrayList(u.Y(list, 10));
        for (Number number : list) {
            arrayList.add(Integer.valueOf(number.intValue() + 1));
        }
        String Z2 = CollectionsKt___CollectionsKt.Z2(arrayList, "、", null, null, 0, null, null, 62, null);
        String v = Res.a.v(R.string.etiquette_exam_err_tips, Z2);
        int r3 = StringsKt__StringsKt.r3(v, Z2, 0, false, 6, null);
        ((EtiquetteExamViewModel) this.this$0.L()).w0().setValue(e.h(new SpannableStringBuilder(v), -65536, r3, Integer.valueOf(Z2.length() + r3)));
    }
}
