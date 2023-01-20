package com.jihuanshe.viewmodel.search.cardrepo;

import com.jihuanshe.base.model.Result;
import com.jihuanshe.model.GameCard;
import e.l.h.i.b;
import e.l.h.i.e;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardRepoSearchViewModel$getCards$1 extends Lambda implements l<Result<b<e<GameCard>>>, t1> {
    public final /* synthetic */ CardRepoSearchViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardRepoSearchViewModel$getCards$1(CardRepoSearchViewModel cardRepoSearchViewModel) {
        super(1);
        this.this$0 = cardRepoSearchViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Result<b<e<GameCard>>> result) {
        invoke2(result);
        return t1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x003f  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0062  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.e com.jihuanshe.base.model.Result<e.l.h.i.b<e.l.h.i.e<com.jihuanshe.model.GameCard>>> r6) {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r1 = 0
            e.l.r.f0 r2 = e.l.r.f0.a     // Catch: java.lang.Exception -> L2c
            if (r6 != 0) goto Lc
        La:
            r3 = r1
            goto L19
        Lc:
            okhttp3.Headers r3 = r6.getHeader()     // Catch: java.lang.Exception -> L2c
            if (r3 != 0) goto L13
            goto La
        L13:
            java.lang.String r4 = "rarities_count"
            java.lang.String r3 = r3.get(r4)     // Catch: java.lang.Exception -> L2c
        L19:
            java.lang.Class<com.jihuanshe.model.Rarity> r4 = com.jihuanshe.model.Rarity.class
            java.util.List r2 = r2.b(r3, r4)     // Catch: java.lang.Exception -> L2c
            r0.addAll(r2)     // Catch: java.lang.Exception -> L2c
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r2 = r5.this$0     // Catch: java.lang.Exception -> L2c
            e.n.f r2 = r2.z0()     // Catch: java.lang.Exception -> L2c
            r2.r(r0)     // Catch: java.lang.Exception -> L2c
            goto L2d
        L2c:
        L2d:
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r0 = r5.this$0
            r2 = 0
            r0.D0(r2)
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r0 = r5.this$0
            e.l.h.i.f r0 = r0.y0()
            boolean r0 = r0.f()
            if (r0 == 0) goto L62
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r0 = r5.this$0
            com.eth.model.NLive r0 = r0.w0()
            if (r6 != 0) goto L48
            goto L5e
        L48:
            java.lang.Object r6 = r6.getData()
            e.l.h.i.b r6 = (e.l.h.i.b) r6
            if (r6 != 0) goto L51
            goto L5e
        L51:
            java.lang.Object r6 = r6.a()
            e.l.h.i.e r6 = (e.l.h.i.e) r6
            if (r6 != 0) goto L5a
            goto L5e
        L5a:
            java.util.List r1 = r6.b()
        L5e:
            r0.setValue(r1)
            goto La6
        L62:
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r0 = r5.this$0
            com.eth.model.NLive r0 = r0.w0()
            com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel r2 = r5.this$0
            com.eth.model.NLive r2 = r2.w0()
            java.lang.Object r2 = r2.getValue()
            java.util.List r2 = (java.util.List) r2
            if (r2 != 0) goto L77
            goto La3
        L77:
            java.util.List r2 = kotlin.collections.CollectionsKt___CollectionsKt.L5(r2)
            if (r2 != 0) goto L7e
            goto La3
        L7e:
            if (r6 != 0) goto L81
            goto L97
        L81:
            java.lang.Object r6 = r6.getData()
            e.l.h.i.b r6 = (e.l.h.i.b) r6
            if (r6 != 0) goto L8a
            goto L97
        L8a:
            java.lang.Object r6 = r6.a()
            e.l.h.i.e r6 = (e.l.h.i.e) r6
            if (r6 != 0) goto L93
            goto L97
        L93:
            java.util.List r1 = r6.b()
        L97:
            if (r1 != 0) goto L9d
            java.util.List r1 = kotlin.collections.CollectionsKt__CollectionsKt.E()
        L9d:
            r2.addAll(r1)
            h.t1 r6 = h.t1.a
            r1 = r2
        La3:
            r0.setValue(r1)
        La6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.viewmodel.search.cardrepo.CardRepoSearchViewModel$getCards$1.invoke2(com.jihuanshe.base.model.Result):void");
    }
}
