package com.jihuanshe.viewmodel.main.shop;

import com.baidu.mobads.sdk.api.IAdInterListener;
import com.eth.model.NLive;
import com.google.gson.Gson;
import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.Banner;
import com.jihuanshe.model.BannerPack;
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
public final class ShopViewModel$getCards$3 extends Lambda implements l<Result<b<e<GameCard>>>, t1> {
    public final /* synthetic */ boolean $changeRarity;
    public final /* synthetic */ ShopViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ShopViewModel$getCards$3(boolean z, ShopViewModel shopViewModel) {
        super(1);
        this.$changeRarity = z;
        this.this$0 = shopViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<b<e<GameCard>>> result) {
        invoke2(result);
        return t1.a;
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.Object] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@k.e.a.e Result<b<e<GameCard>>> result) {
        f fVar;
        List<GameCard> L5;
        b<e<GameCard>> data;
        e<GameCard> a;
        b<e<GameCard>> data2;
        e<GameCard> a2;
        Headers header;
        Headers header2;
        Headers header3;
        f0 f0Var;
        Headers header4;
        String str;
        List<GameCard> list = null;
        r1 = null;
        String str2 = null;
        r1 = null;
        r1 = null;
        List<GameCard> list2 = null;
        list = null;
        if (this.$changeRarity) {
            ArrayList arrayList = new ArrayList();
            try {
                f0Var = f0.a;
            } catch (Exception unused) {
            }
            if (result != null && (header4 = result.getHeader()) != null) {
                str = header4.get("rarities_count");
                arrayList.addAll(f0Var.b(str, Rarity.class));
                this.this$0.a(arrayList);
            }
            str = null;
            arrayList.addAll(f0Var.b(str, Rarity.class));
            this.this$0.a(arrayList);
        }
        fVar = this.this$0.f4475c;
        if (fVar.f()) {
            this.this$0.y0().setValue((result == null || (data2 = result.getData()) == null || (a2 = data2.a()) == null) ? null : a2.b());
            String str3 = (result == null || (header = result.getHeader()) == null) ? null : header.get(IAdInterListener.AdProdType.PRODUCT_BANNER);
            boolean z = false;
            if (str3 == null || str3.length() == 0) {
                String str4 = (result == null || (header3 = result.getHeader()) == null) ? null : header3.get("banner_image");
                if (!((str4 == null || str4.length() == 0) ? true : true)) {
                    this.this$0.q0().setValue(new Banner(str4, null, 2, null));
                } else {
                    this.this$0.q0().setValue(new Banner("", null, 2, null));
                }
            } else {
                this.this$0.q0().setValue(f0.a.a().n(str3, Banner.class));
            }
            e.n.f<BannerPack> r0 = this.this$0.r0();
            Gson a3 = f0.a.a();
            if (result != null && (header2 = result.getHeader()) != null) {
                str2 = header2.get("pack");
            }
            r0.setValue(a3.n(str2, BannerPack.class));
            return;
        }
        NLive<List<GameCard>> y0 = this.this$0.y0();
        List<GameCard> value = this.this$0.y0().getValue();
        if (value != null && (L5 = CollectionsKt___CollectionsKt.L5(value)) != null) {
            if (result != null && (data = result.getData()) != null && (a = data.a()) != null) {
                list2 = a.b();
            }
            if (list2 == null) {
                list2 = CollectionsKt__CollectionsKt.E();
            }
            L5.addAll(list2);
            t1 t1Var = t1.a;
            list = L5;
        }
        y0.setValue(list);
    }
}
