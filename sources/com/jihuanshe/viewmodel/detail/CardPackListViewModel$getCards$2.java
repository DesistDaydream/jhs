package com.jihuanshe.viewmodel.detail;

import com.eth.model.NLive;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.GameCard;
import com.jihuanshe.model.Rarity;
import e.l.h.i.b;
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
public final class CardPackListViewModel$getCards$2 extends Lambda implements l<Result<b<e<GameCard>>>, t1> {
    public final /* synthetic */ boolean $changeRarity;
    public final /* synthetic */ CardPackListViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardPackListViewModel$getCards$2(boolean z, CardPackListViewModel cardPackListViewModel) {
        super(1);
        this.$changeRarity = z;
        this.this$0 = cardPackListViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<b<e<GameCard>>> result) {
        invoke2(result);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e Result<b<e<GameCard>>> result) {
        f fVar;
        List<GameCard> L5;
        b<e<GameCard>> data;
        e<GameCard> a;
        b<e<GameCard>> data2;
        e<GameCard> a2;
        f0 f0Var;
        Headers header;
        String str;
        List<GameCard> list = null;
        if (this.$changeRarity) {
            ArrayList arrayList = new ArrayList();
            try {
                f0Var = f0.a;
            } catch (Exception unused) {
            }
            if (result != null && (header = result.getHeader()) != null) {
                str = header.get("rarities_count");
                arrayList.addAll(f0Var.b(str, Rarity.class));
                this.this$0.a(arrayList);
            }
            str = null;
            arrayList.addAll(f0Var.b(str, Rarity.class));
            this.this$0.a(arrayList);
        }
        fVar = this.this$0.f4390e;
        if (fVar.f()) {
            NLive<List<GameCard>> t0 = this.this$0.t0();
            if (result != null && (data2 = result.getData()) != null && (a2 = data2.a()) != null) {
                list = a2.b();
            }
            t0.setValue(list);
            return;
        }
        NLive<List<GameCard>> t02 = this.this$0.t0();
        List<GameCard> value = this.this$0.t0().getValue();
        if (value != null && (L5 = CollectionsKt___CollectionsKt.L5(value)) != null) {
            if (result != null && (data = result.getData()) != null && (a = data.a()) != null) {
                list = a.b();
            }
            if (list == null) {
                list = CollectionsKt__CollectionsKt.E();
            }
            L5.addAll(list);
            t1 t1Var = t1.a;
            list = L5;
        }
        t02.setValue(list);
    }
}
