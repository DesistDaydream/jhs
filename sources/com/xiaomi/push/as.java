package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class as extends m.a {
    private Context a;

    public as(Context context) {
        this.a = context;
    }

    private boolean b() {
        return com.xiaomi.b.b.b.a(this.a).a().c();
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                com.xiaomi.a.a.a.c.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.b.b.b.a(this.a).c();
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }
}
