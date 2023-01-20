package com.vector.design.ui.activity;

import h.k2.u.a;
import h.t1;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class SplashActivityEx$doPass$1 extends Lambda implements a<t1> {
    public final /* synthetic */ SplashActivityEx this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivityEx$doPass$1(SplashActivityEx splashActivityEx) {
        super(0);
        this.this$0 = splashActivityEx;
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ t1 invoke() {
        invoke2();
        return t1.a;
    }

    @Override // h.k2.u.a
    /* renamed from: invoke */
    public final void invoke2() {
        if (!this.this$0.isFinishing()) {
            this.this$0.N();
        }
        this.this$0.finish();
    }
}
