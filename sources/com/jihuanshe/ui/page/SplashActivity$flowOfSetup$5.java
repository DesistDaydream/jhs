package com.jihuanshe.ui.page;

import com.jihuanshe.R;
import e.l.h.j.b.e;
import h.k2.u.l;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$flowOfSetup$5 extends Lambda implements l<Boolean, t1> {
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$flowOfSetup$5(SplashActivity splashActivity) {
        super(1);
        this.this$0 = splashActivity;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return t1.a;
    }

    public final void invoke(boolean z) {
        e.b(this.this$0, R.string.error_network, (r12 & 2) != 0 ? null : null, (r12 & 4) != 0 ? null : null, (r12 & 8) == 0 ? null : null, (r12 & 16) != 0 ? 1 : 0, (r12 & 32) != 0 ? 80 : null);
        this.this$0.finish();
    }
}
