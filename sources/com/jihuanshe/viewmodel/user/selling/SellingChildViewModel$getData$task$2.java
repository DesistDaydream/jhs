package com.jihuanshe.viewmodel.user.selling;

import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import e.l.h.i.e;
import e.l.h.i.f;
import e.l.r.f0;
import h.k2.u.l;
import h.t1;
import java.util.ArrayList;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Lambda;
import okhttp3.Headers;

/* loaded from: classes2.dex */
public final class SellingChildViewModel$getData$task$2 extends Lambda implements l<Result<e<GameCard>>, t1> {
    public final /* synthetic */ SellingChildViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellingChildViewModel$getData$task$2(SellingChildViewModel sellingChildViewModel) {
        super(1);
        this.this$0 = sellingChildViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<e<GameCard>> result) {
        invoke2(result);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e Result<e<GameCard>> result) {
        f fVar;
        f fVar2;
        List<GameCard> L5;
        e<GameCard> data;
        e<GameCard> data2;
        f0 f0Var;
        Headers header;
        String str;
        fVar = this.this$0.f4587d;
        List<GameCard> list = null;
        if (fVar.f()) {
            ArrayList arrayList = new ArrayList();
            try {
                f0Var = f0.a;
            } catch (Exception unused) {
            }
            if (result != null && (header = result.getHeader()) != null) {
                str = header.get("rarities_count");
                arrayList.addAll(f0Var.b(str, Rarity.class));
                this.this$0.N().setValue(arrayList);
            }
            str = null;
            arrayList.addAll(f0Var.b(str, Rarity.class));
            this.this$0.N().setValue(arrayList);
        }
        fVar2 = this.this$0.f4587d;
        if (fVar2.f()) {
            NLive<List<GameCard>> D0 = this.this$0.D0();
            if (result != null && (data2 = result.getData()) != null) {
                list = data2.b();
            }
            D0.setValue(list);
            return;
        }
        NLive<List<GameCard>> D02 = this.this$0.D0();
        List<GameCard> value = this.this$0.D0().getValue();
        if (value != null && (L5 = CollectionsKt___CollectionsKt.L5(value)) != null) {
            if (result != null && (data = result.getData()) != null) {
                list = data.b();
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.E();
            }
            L5.addAll(list);
            t1 t1Var = t1.a;
            list = L5;
        }
        D02.setValue(list);
    }
}
