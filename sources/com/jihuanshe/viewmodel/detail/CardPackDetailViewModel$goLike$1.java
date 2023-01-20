package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.model.PackDetailResult;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardPackDetailViewModel$goLike$1 extends Lambda implements l<t1, t1> {
    public final /* synthetic */ CardPackDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackDetailViewModel$goLike$1(CardPackDetailViewModel cardPackDetailViewModel) {
        super(1);
        this.this$0 = cardPackDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
        invoke2(t1Var);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e t1 t1Var) {
        Integer likeCount;
        PackDetailResult value = this.this$0.B0().getValue();
        if (value != null) {
            value.setLike(true);
        }
        PackDetailResult value2 = this.this$0.B0().getValue();
        if (value2 != null) {
            PackDetailResult value3 = this.this$0.B0().getValue();
            Integer num = null;
            if (value3 != null && (likeCount = value3.getLikeCount()) != null) {
                num = Integer.valueOf(likeCount.intValue() + 1);
            }
            value2.setLikeCount(num);
        }
        this.this$0.B0().n();
    }
}
