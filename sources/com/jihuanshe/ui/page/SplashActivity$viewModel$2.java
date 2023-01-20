package com.jihuanshe.ui.page;

import androidx.lifecycle.ViewModelProvider;
import com.jihuanshe.viewmodel.SplashViewModel;
import h.k2.u.a;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes2.dex */
public final class SplashActivity$viewModel$2 extends Lambda implements a<SplashViewModel> {
    public final /* synthetic */ SplashActivity this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SplashActivity$viewModel$2(SplashActivity splashActivity) {
        super(0);
        this.this$0 = splashActivity;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h.k2.u.a
    @d
    public final SplashViewModel invoke() {
        return (SplashViewModel) new ViewModelProvider(this.this$0).get(SplashViewModel.class);
    }
}
