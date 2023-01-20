package com.vivo.push;

/* loaded from: classes3.dex */
public final class i implements IPushActionListener {
    public final /* synthetic */ e a;

    public i(e eVar) {
        this.a = eVar;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        com.vivo.push.util.b bVar;
        com.vivo.push.util.b bVar2;
        if (i2 == 0) {
            this.a.f8131k = "";
            bVar2 = this.a.f8130j;
            bVar2.a("APP_TOKEN", "");
            this.a.m();
            this.a.f8130j.b("APP_TAGS");
            return;
        }
        this.a.f8131k = null;
        bVar = this.a.f8130j;
        bVar.b("APP_TOKEN");
    }
}
