package com.meizu.cloud.pushsdk.d.e.a;

import com.meizu.cloud.pushsdk.d.b.a.b;
import com.meizu.cloud.pushsdk.d.e.a;
import com.meizu.cloud.pushsdk.d.f.c;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public class a extends com.meizu.cloud.pushsdk.d.e.a {
    private static final String n = "a";
    private static ScheduledExecutorService o;

    public a(a.C0161a c0161a) {
        super(c0161a);
        b.a(this.f4862k);
        c();
    }

    @Override // com.meizu.cloud.pushsdk.d.e.a
    public void a(final com.meizu.cloud.pushsdk.d.c.b bVar, final boolean z) {
        b.a(new Runnable() { // from class: com.meizu.cloud.pushsdk.d.e.a.a.2
            @Override // java.lang.Runnable
            public void run() {
                a.super.a(bVar, z);
            }
        });
    }

    public void c() {
        if (o == null && this.f4860i) {
            c.b(n, "Session checking has been resumed.", new Object[0]);
            final com.meizu.cloud.pushsdk.d.e.b bVar = this.f4855d;
            ScheduledExecutorService newSingleThreadScheduledExecutor = Executors.newSingleThreadScheduledExecutor();
            o = newSingleThreadScheduledExecutor;
            Runnable runnable = new Runnable() { // from class: com.meizu.cloud.pushsdk.d.e.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    bVar.b();
                }
            };
            long j2 = this.f4861j;
            newSingleThreadScheduledExecutor.scheduleAtFixedRate(runnable, j2, j2, this.f4863l);
        }
    }
}
