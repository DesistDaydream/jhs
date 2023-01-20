package com.xiaomi.push;

import java.util.Date;

/* loaded from: classes3.dex */
public class fa implements fe {
    public final /* synthetic */ ez a;

    public fa(ez ezVar) {
        this.a = ezVar;
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar) {
        com.xiaomi.a.a.a.c.c("[Slim] " + this.a.b.format(new Date()) + " Connection started (" + this.a.f8558c.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, int i2, Exception exc) {
        com.xiaomi.a.a.a.c.c("[Slim] " + this.a.b.format(new Date()) + " Connection closed (" + this.a.f8558c.hashCode() + ")");
    }

    @Override // com.xiaomi.push.fe
    public void a(fb fbVar, Exception exc) {
        com.xiaomi.a.a.a.c.c("[Slim] " + this.a.b.format(new Date()) + " Reconnection failed due to an exception (" + this.a.f8558c.hashCode() + ")");
        exc.printStackTrace();
    }

    @Override // com.xiaomi.push.fe
    public void b(fb fbVar) {
        com.xiaomi.a.a.a.c.c("[Slim] " + this.a.b.format(new Date()) + " Connection reconnected (" + this.a.f8558c.hashCode() + ")");
    }
}
