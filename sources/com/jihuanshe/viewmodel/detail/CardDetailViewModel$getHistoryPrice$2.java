package com.jihuanshe.viewmodel.detail;

import com.jihuanshe.R;
import com.jihuanshe.model.DatePrice;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import e.n.f;
import h.k2.u.l;
import h.t1;
import java.util.List;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailViewModel$getHistoryPrice$2 extends Lambda implements l<List<? extends DatePrice>, t1> {
    public final /* synthetic */ int $cvId;
    public final /* synthetic */ CardDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailViewModel$getHistoryPrice$2(CardDetailViewModel cardDetailViewModel, int i2) {
        super(1);
        this.this$0 = cardDetailViewModel;
        this.$cvId = i2;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends DatePrice> list) {
        invoke2((List<DatePrice>) list);
        return t1.a;
    }

    /* JADX WARN: Type inference failed for: r1v8, types: [java.lang.Object] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e List<DatePrice> list) {
        int O0 = this.this$0.O0();
        int i2 = this.$cvId;
        if (O0 == i2) {
            return;
        }
        this.this$0.h1(i2);
        if ((list == null ? null : Integer.valueOf(list.size())).intValue() > 0) {
            this.this$0.N0().setValue(CollectionsKt___CollectionsKt.J2(list, list.size() - 1));
            f<CharSequence> P0 = this.this$0.P0();
            StringUtil stringUtil = StringUtil.a;
            DatePrice datePrice = (DatePrice) CollectionsKt___CollectionsKt.J2(list, list.size() - 1);
            P0.r(stringUtil.b(datePrice == null ? 0.0f : datePrice.getPrice(), R.string.shop_price, false, 15, R.string.shop_no_price, false));
            return;
        }
        this.this$0.N0().setValue(null);
        this.this$0.P0().setValue(Res.w(Res.a, R.string.shop_no_price, null, 2, null));
    }
}
