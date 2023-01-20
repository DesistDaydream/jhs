package com.xiaomi.push;

import com.xiaomi.push.p;

/* loaded from: classes3.dex */
public final class gh extends p.b {
    public final /* synthetic */ Runnable a;

    public gh(Runnable runnable) {
        this.a = runnable;
    }

    @Override // com.xiaomi.push.p.b
    public void b() {
        this.a.run();
    }
}
