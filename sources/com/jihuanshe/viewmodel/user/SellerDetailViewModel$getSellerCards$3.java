package com.jihuanshe.viewmodel.user;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.GameCard;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerDetailViewModel$getSellerCards$3 extends Lambda implements l<Result<e<GameCard>>, t1> {
    public final /* synthetic */ boolean $changeRarity;
    public final /* synthetic */ SellerDetailViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerDetailViewModel$getSellerCards$3(boolean z, SellerDetailViewModel sellerDetailViewModel) {
        super(1);
        this.$changeRarity = z;
        this.this$0 = sellerDetailViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<e<GameCard>> result) {
        invoke2(result);
        return t1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Type inference failed for: r5v1, types: [java.lang.Object] */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.e com.jihuanshe.base.model.Result<e.l.h.i.e<com.jihuanshe.model.GameCard>> r9) {
        /*
            r8 = this;
            java.lang.Class<com.jihuanshe.model.Rarity> r0 = com.jihuanshe.model.Rarity.class
            boolean r1 = r8.$changeRarity
            r2 = 0
            if (r1 == 0) goto L70
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r3 = r8.this$0     // Catch: java.lang.Exception -> L6b
            e.n.f r3 = r3.G0()     // Catch: java.lang.Exception -> L6b
            e.l.r.f0 r4 = e.l.r.f0.a     // Catch: java.lang.Exception -> L6b
            com.google.gson.Gson r5 = r4.a()     // Catch: java.lang.Exception -> L6b
            if (r9 != 0) goto L1c
        L1a:
            r6 = r2
            goto L29
        L1c:
            okhttp3.Headers r6 = r9.getHeader()     // Catch: java.lang.Exception -> L6b
            if (r6 != 0) goto L23
            goto L1a
        L23:
            java.lang.String r7 = "banner"
            java.lang.String r6 = r6.get(r7)     // Catch: java.lang.Exception -> L6b
        L29:
            java.lang.Class<com.jihuanshe.model.Banner> r7 = com.jihuanshe.model.Banner.class
            java.lang.Object r5 = r5.n(r6, r7)     // Catch: java.lang.Exception -> L6b
            r3.setValue(r5)     // Catch: java.lang.Exception -> L6b
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r3 = r8.this$0     // Catch: java.lang.Exception -> L6b
            boolean r3 = r3.d1()     // Catch: java.lang.Exception -> L6b
            if (r3 == 0) goto L53
            if (r9 != 0) goto L3e
        L3c:
            r3 = r2
            goto L4b
        L3e:
            okhttp3.Headers r3 = r9.getHeader()     // Catch: java.lang.Exception -> L6b
            if (r3 != 0) goto L45
            goto L3c
        L45:
            java.lang.String r5 = "rarities_count"
            java.lang.String r3 = r3.get(r5)     // Catch: java.lang.Exception -> L6b
        L4b:
            java.util.List r0 = r4.b(r3, r0)     // Catch: java.lang.Exception -> L6b
            r1.addAll(r0)     // Catch: java.lang.Exception -> L6b
            goto L6b
        L53:
            if (r9 != 0) goto L57
        L55:
            r3 = r2
            goto L64
        L57:
            okhttp3.Headers r3 = r9.getHeader()     // Catch: java.lang.Exception -> L6b
            if (r3 != 0) goto L5e
            goto L55
        L5e:
            java.lang.String r5 = "product_rarities"
            java.lang.String r3 = r3.get(r5)     // Catch: java.lang.Exception -> L6b
        L64:
            java.util.List r0 = r4.b(r3, r0)     // Catch: java.lang.Exception -> L6b
            r1.addAll(r0)     // Catch: java.lang.Exception -> L6b
        L6b:
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r0 = r8.this$0
            r0.b0(r1)
        L70:
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r0 = r8.this$0
            e.l.h.i.f r0 = com.jihuanshe.viewmodel.user.SellerDetailViewModel.z0(r0)
            boolean r0 = r0.f()
            if (r0 == 0) goto L96
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r0 = r8.this$0
            com.eth.model.NLive r0 = r0.H0()
            if (r9 != 0) goto L85
            goto L92
        L85:
            java.lang.Object r9 = r9.getData()
            e.l.h.i.e r9 = (e.l.h.i.e) r9
            if (r9 != 0) goto L8e
            goto L92
        L8e:
            java.util.List r2 = r9.b()
        L92:
            r0.setValue(r2)
            goto Ld1
        L96:
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r0 = r8.this$0
            com.eth.model.NLive r0 = r0.H0()
            com.jihuanshe.viewmodel.user.SellerDetailViewModel r1 = r8.this$0
            com.eth.model.NLive r1 = r1.H0()
            java.lang.Object r1 = r1.getValue()
            java.util.List r1 = (java.util.List) r1
            if (r1 != 0) goto Lab
            goto Lce
        Lab:
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r1)
            if (r1 != 0) goto Lb2
            goto Lce
        Lb2:
            if (r9 != 0) goto Lb5
            goto Lc2
        Lb5:
            java.lang.Object r9 = r9.getData()
            e.l.h.i.e r9 = (e.l.h.i.e) r9
            if (r9 != 0) goto Lbe
            goto Lc2
        Lbe:
            java.util.List r2 = r9.b()
        Lc2:
            if (r2 != 0) goto Lc8
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.E()
        Lc8:
            r1.addAll(r2)
            h.t1 r9 = h.t1.a
            r2 = r1
        Lce:
            r0.setValue(r2)
        Ld1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.user.SellerDetailViewModel$getSellerCards$3.invoke2(com.jihuanshe.base.model.Result):void");
    }
}
