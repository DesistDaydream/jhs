package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class at extends m.a {
    private Context a;

    public at(Context context) {
        this.a = context;
    }

    private boolean b() {
        return com.xiaomi.b.b.b.a(this.a).a().d();
    }

    @Override // com.xiaomi.push.m.a
    public String a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                com.xiaomi.b.b.b.a(this.a).d();
                com.xiaomi.a.a.a.c.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("fail to send perf data. " + e2);
        }
    }
}
