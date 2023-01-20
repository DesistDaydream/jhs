package com.jihuanshe;

import com.vector.config.AppBarConfig;
import h.k2.u.l;
import h.t1;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class JApp$configureAppBar$1 extends Lambda implements l<AppBarConfig, t1> {
    public final /* synthetic */ JApp this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JApp$configureAppBar$1(JApp jApp) {
        super(1);
        this.this$0 = jApp;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(AppBarConfig appBarConfig) {
        invoke2(appBarConfig);
        return t1.a;
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@d AppBarConfig appBarConfig) {
        appBarConfig.B(48);
        appBarConfig.t(R.color.white);
        appBarConfig.D(22);
        appBarConfig.J(16);
        appBarConfig.I(17);
        appBarConfig.H(R.color.common_text_color);
        appBarConfig.v(R.color.common_bg_color);
        appBarConfig.w(e.t.o.d.a.a(this.this$0).d(1));
        appBarConfig.F(AppBarConfig.Shape.WRAP);
    }
}
