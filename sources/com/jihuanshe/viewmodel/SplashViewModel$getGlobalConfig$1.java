package com.jihuanshe.viewmodel;

import com.jihuanshe.model.GlobalConfig;
import e.l.m.c;
import e.l.r.o0;
import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashViewModel$getGlobalConfig$1 extends Lambda implements l<GlobalConfig, t1> {
    public final /* synthetic */ SplashViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashViewModel$getGlobalConfig$1(SplashViewModel splashViewModel) {
        super(1);
        this.this$0 = splashViewModel;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(GlobalConfig globalConfig) {
        invoke2(globalConfig);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e GlobalConfig globalConfig) {
        c.f14093c.v(globalConfig == null ? null : globalConfig.getPk());
        if (globalConfig != null) {
            o0.f14291c.v(globalConfig);
        }
        this.this$0.u0().setValue(Boolean.TRUE);
    }
}
