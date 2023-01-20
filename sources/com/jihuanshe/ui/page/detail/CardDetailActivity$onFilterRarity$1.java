package com.jihuanshe.ui.page.detail;

import com.jihuanshe.model.Rarity;
import h.k2.u.l;
import h.t1;
import java.util.List;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CardDetailActivity$onFilterRarity$1 extends Lambda implements l<List<? extends Rarity>, t1> {
    public final /* synthetic */ CardDetailActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CardDetailActivity$onFilterRarity$1(CardDetailActivity cardDetailActivity) {
        super(1);
        this.this$0 = cardDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(List<? extends Rarity> list) {
        invoke2((List<Rarity>) list);
        return t1.a;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x005f  */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.e java.util.List<com.jihuanshe.model.Rarity> r15) {
        /*
            r14 = this;
            if (r15 == 0) goto Lcf
            r0 = 0
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r15, r0)
            com.jihuanshe.model.Rarity r1 = (com.jihuanshe.model.Rarity) r1
            r2 = 0
            if (r1 != 0) goto Le
            r1 = r2
            goto L12
        Le:
            java.lang.String r1 = r1.getRarity()
        L12:
            com.vector.util.Res r3 = com.vector.util.Res.a
            r4 = 2131755450(0x7f1001ba, float:1.914178E38)
            r5 = 2
            java.lang.String r4 = com.vector.util.Res.w(r3, r4, r2, r5, r2)
            boolean r4 = h.k2.v.f0.g(r1, r4)
            r6 = 1
            if (r4 == 0) goto L25
        L23:
            r5 = 1
            goto L50
        L25:
            r4 = 2131755451(0x7f1001bb, float:1.9141782E38)
            java.lang.String r4 = com.vector.util.Res.w(r3, r4, r2, r5, r2)
            boolean r4 = h.k2.v.f0.g(r1, r4)
            if (r4 == 0) goto L33
            goto L50
        L33:
            r4 = 2131755452(0x7f1001bc, float:1.9141784E38)
            java.lang.String r4 = com.vector.util.Res.w(r3, r4, r2, r5, r2)
            boolean r4 = h.k2.v.f0.g(r1, r4)
            if (r4 == 0) goto L42
            r5 = 3
            goto L50
        L42:
            r4 = 2131755453(0x7f1001bd, float:1.9141786E38)
            java.lang.String r3 = com.vector.util.Res.w(r3, r4, r2, r5, r2)
            boolean r1 = h.k2.v.f0.g(r1, r3)
            if (r1 == 0) goto L23
            r5 = 4
        L50:
            com.jihuanshe.ui.page.detail.CardDetailActivity r1 = r14.this$0
            com.jihuanshe.ui.widget.ConditionFilterBtn r1 = com.jihuanshe.ui.page.detail.CardDetailActivity.Y(r1)
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.J2(r15, r0)
            com.jihuanshe.model.Rarity r15 = (com.jihuanshe.model.Rarity) r15
            if (r15 != 0) goto L5f
            goto L63
        L5f:
            java.lang.String r2 = r15.getRarity()
        L63:
            r1.setText(r2)
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            e.t.k.b.a r15 = r15.L()
            com.jihuanshe.viewmodel.detail.CardDetailViewModel r15 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel) r15
            e.n.f r15 = r15.J0()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r5)
            r15.setValue(r1)
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            e.t.k.b.a r15 = r15.L()
            r1 = r15
            com.jihuanshe.viewmodel.detail.CardDetailViewModel r1 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel) r1
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            e.t.k.b.a r15 = r15.L()
            com.jihuanshe.viewmodel.detail.CardDetailViewModel r15 = (com.jihuanshe.viewmodel.detail.CardDetailViewModel) r15
            com.eth.model.NLive r15 = r15.C0()
            java.lang.Object r15 = r15.getValue()
            com.jihuanshe.model.CardDetailInfo r15 = (com.jihuanshe.model.CardDetailInfo) r15
            if (r15 != 0) goto L98
        L96:
            r2 = 0
            goto La4
        L98:
            java.lang.Integer r15 = r15.getId()
            if (r15 != 0) goto L9f
            goto L96
        L9f:
            int r0 = r15.intValue()
            r2 = r0
        La4:
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            java.lang.String r3 = r15.w0()
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            java.lang.String r4 = r15.x0()
            r5 = 0
            r6 = 8
            r7 = 0
            e.g.d.a r8 = com.jihuanshe.viewmodel.detail.CardDetailViewModel.R0(r1, r2, r3, r4, r5, r6, r7)
            com.jihuanshe.ui.page.detail.CardDetailActivity r9 = r14.this$0
            com.vector.view.scrollable.ListView r10 = com.jihuanshe.ui.page.detail.CardDetailActivity.Z(r9)
            r11 = 0
            r12 = 4
            r13 = 0
            e.g.d.a r15 = com.jihuanshe.base.ext.BinderKt.e(r8, r9, r10, r11, r12, r13)
            com.jihuanshe.base.ext.BinderKt.p(r15)
            com.jihuanshe.ui.page.detail.CardDetailActivity r15 = r14.this$0
            java.lang.String r0 = "品相筛选"
            r15.w1(r0)
        Lcf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.page.detail.CardDetailActivity$onFilterRarity$1.invoke2(java.util.List):void");
    }
}
