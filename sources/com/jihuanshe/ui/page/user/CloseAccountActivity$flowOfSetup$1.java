package com.jihuanshe.ui.page.user;

import com.jihuanshe.ui.page.web.CommonWebViewActivityCreator;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class CloseAccountActivity$flowOfSetup$1 extends Lambda implements a<t1> {
    public final /* synthetic */ CloseAccountActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CloseAccountActivity$flowOfSetup$1(CloseAccountActivity closeAccountActivity) {
        super(0);
        this.this$0 = closeAccountActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        CommonWebViewActivityCreator.create("https://api.jihuanshe.com/api/market/articles?type=delete_account").start(this.this$0);
    }
}
