package com.xiaomi.push;

import android.content.Context;
import android.os.IBinder;
import com.xiaomi.push.ad;

/* loaded from: classes3.dex */
public class af implements Runnable {
    public final /* synthetic */ IBinder a;
    public final /* synthetic */ ad.b b;

    public af(ad.b bVar, IBinder iBinder) {
        this.b = bVar;
        this.a = iBinder;
    }

    @Override // java.lang.Runnable
    public void run() {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        Context context;
        String e2;
        Object obj5;
        Object obj6;
        try {
            context = ad.this.b;
            String packageName = context.getPackageName();
            e2 = ad.this.e();
            ad.a aVar = new ad.a();
            aVar.a = ad.c.a(this.a, packageName, e2, "GUID");
            aVar.b = ad.c.a(this.a, packageName, e2, "OUID");
            aVar.f8251c = ad.c.a(this.a, packageName, e2, "DUID");
            aVar.f8252d = ad.c.a(this.a, packageName, e2, "AUID");
            ad.this.f8249e = aVar;
            ad.this.d();
            ad.this.f8248d = 2;
            obj5 = ad.this.f8250f;
            synchronized (obj5) {
                try {
                    obj6 = ad.this.f8250f;
                    obj6.notifyAll();
                } catch (Exception unused) {
                }
            }
        } catch (Exception unused2) {
            ad.this.d();
            ad.this.f8248d = 2;
            obj3 = ad.this.f8250f;
            synchronized (obj3) {
                try {
                    obj4 = ad.this.f8250f;
                    obj4.notifyAll();
                } catch (Exception unused3) {
                }
            }
        } catch (Throwable th) {
            ad.this.d();
            ad.this.f8248d = 2;
            obj = ad.this.f8250f;
            synchronized (obj) {
                try {
                    obj2 = ad.this.f8250f;
                    obj2.notifyAll();
                } catch (Exception unused4) {
                }
                throw th;
            }
        }
    }
}
