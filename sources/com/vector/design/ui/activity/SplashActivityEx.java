package com.vector.design.ui.activity;

import androidx.annotation.CallSuper;
import com.vector.ext.AnyKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\b\u0010\t\u001a\u00020\bH\u0017J\b\u0010\n\u001a\u00020\bH&R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/vector/design/ui/activity/SplashActivityEx;", "Lcom/vector/design/ui/activity/SimpleActivityEx;", "()V", "pastDelay", "", "getPastDelay", "()J", "doPass", "", "flowOfSetup", "passTo", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SplashActivityEx extends SimpleActivityEx {
    /* JADX INFO: Access modifiers changed from: private */
    public final void L() {
        AnyKt.A(M(), TimeUnit.MILLISECONDS, null, new SplashActivityEx$doPass$1(this), 4, null);
    }

    public long M() {
        return 800L;
    }

    public abstract void N();

    @Override // com.vector.design.ui.activity.SimpleActivityEx, e.t.k.a.a
    @CallSuper
    public void d() {
        v(new SplashActivityEx$flowOfSetup$1(this));
    }
}
