package com.jihuanshe.ui.page.order;

import android.view.View;
import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SellerOrderDetailActivity$onClickCommit$1 extends Lambda implements l<View, t1> {
    public final /* synthetic */ SellerOrderDetailActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickCommit$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<t1, t1> {
        public final /* synthetic */ SellerOrderDetailActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SellerOrderDetailActivity sellerOrderDetailActivity) {
            super(1);
            this.this$0 = sellerOrderDetailActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(t1 t1Var) {
            invoke2(t1Var);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e t1 t1Var) {
            ((SellerOrderDetailViewModel) this.this$0.L()).D0().setValue(3);
            BinderKt.k(((SellerOrderDetailViewModel) this.this$0.L()).v0(this.this$0.c0()), this.this$0, false, 2, null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SellerOrderDetailActivity$onClickCommit$1(SellerOrderDetailActivity sellerOrderDetailActivity) {
        super(1);
        this.this$0 = sellerOrderDetailActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(View view) {
        invoke2(view);
        return t1.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0074, code lost:
        if ((r7 == null || r7.length() == 0) != false) goto L28;
     */
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void invoke2(@k.e.a.d android.view.View r19) {
        /*
            r18 = this;
            r0 = r18
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r1 = r0.this$0
            e.l.k.k2 r1 = r1.Y()
            r2 = 0
            if (r1 != 0) goto Ld
        Lb:
            r1 = r2
            goto L1a
        Ld:
            android.widget.RadioGroup r1 = r1.F
            if (r1 != 0) goto L12
            goto Lb
        L12:
            int r1 = r1.getCheckedRadioButtonId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
        L1a:
            r3 = 2131297461(0x7f0904b5, float:1.8212868E38)
            r4 = 2
            r5 = 1
            if (r1 != 0) goto L22
            goto L2a
        L22:
            int r1 = r1.intValue()
            if (r1 != r3) goto L2a
            r1 = 1
            goto L2b
        L2a:
            r1 = 2
        L2b:
            r3 = 0
            if (r1 != r5) goto L8e
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r6 = r0.this$0
            e.t.k.b.a r6 = r6.L()
            com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel r6 = (com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel) r6
            e.n.p r6 = r6.A0()
            java.lang.Object r6 = r6.getValue()
            java.lang.String r6 = (java.lang.String) r6
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r7 = r0.this$0
            e.l.k.k2 r7 = r7.Y()
            if (r7 != 0) goto L4a
        L48:
            r7 = r2
            goto L5a
        L4a:
            android.widget.EditText r7 = r7.f12989d
            if (r7 != 0) goto L4f
            goto L48
        L4f:
            android.text.Editable r7 = r7.getText()
            if (r7 != 0) goto L56
            goto L48
        L56:
            java.lang.String r7 = r7.toString()
        L5a:
            if (r6 == 0) goto L65
            int r8 = r6.length()
            if (r8 != 0) goto L63
            goto L65
        L63:
            r8 = 0
            goto L66
        L65:
            r8 = 1
        L66:
            if (r8 != 0) goto L76
            if (r7 == 0) goto L73
            int r8 = r7.length()
            if (r8 != 0) goto L71
            goto L73
        L71:
            r8 = 0
            goto L74
        L73:
            r8 = 1
        L74:
            if (r8 == 0) goto L90
        L76:
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r9 = r0.this$0
            com.vector.util.Res r1 = com.vector.util.Res.a
            r3 = 2131755923(0x7f100393, float:1.9142739E38)
            java.lang.String r10 = com.vector.util.Res.w(r1, r3, r2, r4, r2)
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 62
            r17 = 0
            e.l.h.j.b.e.h(r9, r10, r11, r12, r13, r14, r15, r16, r17)
            return
        L8e:
            r6 = r2
            r7 = r6
        L90:
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r8 = r0.this$0
            e.t.k.b.a r8 = r8.L()
            com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel r8 = (com.jihuanshe.viewmodel.order.SellerOrderDetailViewModel) r8
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r9 = r0.this$0
            int r9 = r9.c0()
            e.g.d.a r1 = r8.I0(r9, r1, r6, r7)
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickCommit$1$1 r6 = new com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickCommit$1$1
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r7 = r0.this$0
            r6.<init>(r7)
            e.g.d.a r1 = e.g.d.a.j(r1, r2, r6, r5, r2)
            com.jihuanshe.ui.page.order.SellerOrderDetailActivity r5 = r0.this$0
            e.g.d.a r1 = com.jihuanshe.base.ext.BinderKt.k(r1, r5, r3, r4, r2)
            com.jihuanshe.base.ext.BinderKt.p(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.ui.page.order.SellerOrderDetailActivity$onClickCommit$1.invoke2(android.view.View):void");
    }
}
