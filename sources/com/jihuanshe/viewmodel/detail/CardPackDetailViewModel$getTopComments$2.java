package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.TopCommentInfo;
import e.l.h.i.e;
import e.n.p;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailViewModel$getTopComments$2 extends Lambda implements l<e<TopCommentInfo>, t1> {
    public final /* synthetic */ CardPackDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailViewModel$getTopComments$2(CardPackDetailViewModel cardPackDetailViewModel) {
        super(1);
        this.this$0 = cardPackDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(e<TopCommentInfo> eVar) {
        invoke2(eVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e e<TopCommentInfo> eVar) {
        Integer e2;
        String str;
        this.this$0.D0().setValue(eVar == null ? null : eVar.b());
        boolean z = false;
        int intValue = (eVar == null || (e2 = eVar.e()) == null) ? 0 : e2.intValue();
        this.this$0.F0().setValue(Boolean.valueOf(intValue != 0));
        p E0 = this.this$0.E0();
        if (intValue >= 0 && intValue <= 99) {
            z = true;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append('(');
            sb.append(intValue);
            sb.append(')');
            str = sb.toString();
        } else {
            str = "(99+)";
        }
        E0.setValue(str);
    }
}
