package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.PackDetailResult;
import e.l.l.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailViewModel$getPackDetail$2 extends Lambda implements l<PackDetailResult, t1> {
    public final /* synthetic */ String $key;
    public final /* synthetic */ String $subKey;
    public final /* synthetic */ CardPackDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailViewModel$getPackDetail$2(String str, String str2, CardPackDetailViewModel cardPackDetailViewModel) {
        super(1);
        this.$key = str;
        this.$subKey = str2;
        this.this$0 = cardPackDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(PackDetailResult packDetailResult) {
        invoke2(packDetailResult);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e PackDetailResult packDetailResult) {
        if (packDetailResult != null) {
            packDetailResult.setGame(a.b(this.$key, this.$subKey));
        }
        this.this$0.B0().setValue(packDetailResult);
    }
}
