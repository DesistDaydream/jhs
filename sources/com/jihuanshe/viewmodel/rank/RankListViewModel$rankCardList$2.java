package com.jihuanshe.viewmodel.rank;

import com.eth.model.NLive;
import com.jihuanshe.model.RankCardInfo;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class RankListViewModel$rankCardList$2 extends Lambda implements l<e<RankCardInfo>, t1> {
    public final /* synthetic */ RankListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RankListViewModel$rankCardList$2(RankListViewModel rankListViewModel) {
        super(1);
        this.this$0 = rankListViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(e<RankCardInfo> eVar) {
        invoke2(eVar);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e e<RankCardInfo> eVar) {
        List<RankCardInfo> L5;
        if (this.this$0.q0().f()) {
            this.this$0.p0().setValue(eVar != null ? eVar.b() : null);
            return;
        }
        NLive<List<RankCardInfo>> p0 = this.this$0.p0();
        List<RankCardInfo> value = this.this$0.p0().getValue();
        if (value != null && (L5 = CollectionsKt___CollectionsKt.L5(value)) != null) {
            r1 = eVar != null ? eVar.b() : null;
            if (r1 == null) {
                r1 = CollectionsKt__CollectionsKt.E();
            }
            L5.addAll(r1);
            t1 t1Var = t1.a;
            r1 = L5;
        }
        p0.setValue(r1);
    }
}
