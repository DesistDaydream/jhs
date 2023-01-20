package com.jihuanshe.ui.page.user;

import com.jihuanshe.base.ext.BinderKt;
import com.jihuanshe.model.WithDrawResult;
import com.jihuanshe.viewmodel.user.CoinViewModel;
import h.k2.u.a;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CoinActivity$onClickWithDraw$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ CoinActivity this$0;

    /* renamed from: com.jihuanshe.ui.page.user.CoinActivity$onClickWithDraw$1$1$1$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static final class AnonymousClass1 extends Lambda implements l<WithDrawResult, t1> {
        public final /* synthetic */ CoinActivity this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CoinActivity coinActivity) {
            super(1);
            this.this$0 = coinActivity;
        }

        @Override // h.k2.u.l
        public /* bridge */ /* synthetic */ t1 invoke(WithDrawResult withDrawResult) {
            invoke2(withDrawResult);
            return t1.a;
        }

        /* renamed from: invoke  reason: avoid collision after fix types in other method */
        public final void invoke2(@e WithDrawResult withDrawResult) {
            this.this$0.c0().A();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoinActivity$onClickWithDraw$1$1$1(CoinActivity coinActivity) {
        super(0);
        this.this$0 = coinActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        BinderKt.p(BinderKt.k(e.g.d.a.j(((CoinViewModel) this.this$0.L()).v0(this.this$0.d0().getValue().intValue()), null, new AnonymousClass1(this.this$0), 1, null), this.this$0, false, 2, null));
    }
}
