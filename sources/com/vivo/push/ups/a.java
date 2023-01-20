package com.vivo.push.ups;

import android.content.Context;
import com.vivo.push.IPushActionListener;
import com.vivo.push.PushClient;

/* loaded from: classes3.dex */
public final class a implements IPushActionListener {
    public final /* synthetic */ UPSRegisterCallback a;
    public final /* synthetic */ Context b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VUpsManager f8153c;

    public a(VUpsManager vUpsManager, UPSRegisterCallback uPSRegisterCallback, Context context) {
        this.f8153c = vUpsManager;
        this.a = uPSRegisterCallback;
        this.b = context;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        this.a.onResult(new TokenResult(i2, PushClient.getInstance(this.b).getRegId()));
    }
}
