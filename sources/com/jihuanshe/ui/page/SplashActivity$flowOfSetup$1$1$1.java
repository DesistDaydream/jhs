package com.jihuanshe.ui.page;

import com.jihuanshe.ui.dialog.PrivateDialog;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$flowOfSetup$1$1$1 extends Lambda implements a<t1> {
    public final /* synthetic */ PrivateDialog $it;
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$flowOfSetup$1$1$1(PrivateDialog privateDialog, SplashActivity splashActivity) {
        super(0);
        this.$it = privateDialog;
        this.this$0 = splashActivity;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$it.h();
        this.this$0.finish();
    }
}
