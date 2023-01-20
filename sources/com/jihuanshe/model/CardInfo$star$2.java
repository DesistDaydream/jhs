package com.jihuanshe.model;

import h.k2.u.a;
import h.r0;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardInfo$star$2 extends Lambda implements a<List<Integer>> {
    public final /* synthetic */ CardInfo this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardInfo$star$2(CardInfo cardInfo) {
        super(0);
        this.this$0 = cardInfo;
    }

    @Override // h.k2.u.a
    @d
    public final List<Integer> invoke() {
        ArrayList arrayList = new ArrayList();
        CardInfo cardInfo = this.this$0;
        try {
            Result.a aVar = Result.Companion;
            String lv = cardInfo.getLv();
            Integer valueOf = lv == null ? null : Integer.valueOf(Integer.parseInt(lv));
            if (valueOf != null) {
                int intValue = valueOf.intValue();
                int i2 = 0;
                if (intValue > 0) {
                    do {
                        i2++;
                        arrayList.add(1);
                    } while (i2 < intValue);
                    Result.m106constructorimpl(t1.a);
                } else {
                    Result.m106constructorimpl(t1.a);
                }
            }
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
        return arrayList;
    }
}
