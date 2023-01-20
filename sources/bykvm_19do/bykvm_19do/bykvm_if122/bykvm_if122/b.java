package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import android.annotation.SuppressLint;
import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.n;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class b {
    @SuppressLint({"StaticFieldLeak"})
    private static volatile b b;
    private final bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a a;

    private b(Context context) {
        if (context == null) {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d();
        } else {
            context.getApplicationContext();
        }
        a.b bVar = new a.b();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a a = bVar.a(com.heytap.mcssdk.constant.a.q, timeUnit).b(com.heytap.mcssdk.constant.a.q, timeUnit).c(com.heytap.mcssdk.constant.a.q, timeUnit).a(true).a();
        this.a = a;
        n g2 = a.b().g();
        if (g2 != null) {
            g2.a(16);
        }
    }

    public static b b() {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d());
                }
            }
        }
        return b;
    }

    public bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.a a() {
        return this.a;
    }
}
