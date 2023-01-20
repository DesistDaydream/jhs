package com.jihuanshe.ui.page;

import com.jihuanshe.JApp;
import com.jihuanshe.utils.KefuUtil;
import e.l.m.c;
import e.l.r.q0;
import e.l.r.r;
import h.k2.u.a;
import h.t1;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$flowOfSetup$2 extends Lambda implements a<t1> {
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$flowOfSetup$2(SplashActivity splashActivity) {
        super(0);
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
        c.f14093c.x(1);
        q0.a.a();
        ((JApp) e.t.a.b()).x();
        KefuUtil.a.c((JApp) e.t.a.b());
        e.l.f.a.a.b();
        r.a.a(e.t.a.b());
        if (this.this$0.A().u0().getValue() != null) {
            this.this$0.A().u0().n();
        }
    }
}
