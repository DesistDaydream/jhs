package com.vivo.push;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;

/* loaded from: classes3.dex */
public abstract class o {
    private int a;
    private String b;

    public o(int i2) {
        this.a = -1;
        if (i2 >= 0) {
            this.a = i2;
            return;
        }
        throw new IllegalArgumentException("PushCommand: the value of command must > 0.");
    }

    private void e(a aVar) {
        aVar.a(com.heytap.mcssdk.constant.b.y, this.a);
        aVar.a("client_pkgname", this.b);
        c(aVar);
    }

    public final String a() {
        return this.b;
    }

    public final int b() {
        return this.a;
    }

    public abstract void c(a aVar);

    public boolean c() {
        return false;
    }

    public abstract void d(a aVar);

    public String toString() {
        return getClass().getSimpleName();
    }

    public final void a(String str) {
        this.b = str;
    }

    public final void b(Intent intent) {
        a a = a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a.a(PushConstants.MZ_PUSH_MESSAGE_METHOD, this.a);
        e(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(Intent intent) {
        a a = a.a(intent);
        if (a == null) {
            com.vivo.push.util.p.b("PushCommand", "bundleWapper is null");
            return;
        }
        a(a);
        Bundle b = a.b();
        if (b != null) {
            intent.putExtras(b);
        }
    }

    public final void a(a aVar) {
        String a = p.a(this.a);
        if (a == null) {
            a = "";
        }
        aVar.a(PushConstants.MZ_PUSH_MESSAGE_METHOD, a);
        e(aVar);
    }

    public final void b(a aVar) {
        String a = aVar.a();
        if (!TextUtils.isEmpty(a)) {
            this.b = a;
        } else {
            this.b = aVar.a("client_pkgname");
        }
        d(aVar);
    }
}
