package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes3.dex */
public final class b implements IPushActionListener {
    public final /* synthetic */ UPSRegisterCallback a;
    public final /* synthetic */ VUpsManager b;

    public b(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback) {
        this.b = vUpsManager;
        this.a = uPSRegisterCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new TokenResult(i2, ""));
    }
}
