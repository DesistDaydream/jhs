package com.vivo.push.ups;

import com.vivo.push.IPushActionListener;

/* loaded from: classes3.dex */
public final class c implements IPushActionListener {
    public final /* synthetic */ UPSTurnCallback a;
    public final /* synthetic */ VUpsManager b;

    public c(VUpsManager vUpsManager, UPSTurnCallback uPSTurnCallback) {
        this.b = vUpsManager;
        this.a = uPSTurnCallback;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new CodeResult(i2));
    }
}
