package com.xiaomi.push.service;

import android.content.SharedPreferences;
import com.xiaomi.push.da;
import com.xiaomi.push.db;
import com.xiaomi.push.gf;
import com.xiaomi.push.ii;
import com.xiaomi.push.jl;
import com.xiaomi.push.p;
import java.io.BufferedOutputStream;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class ay {
    private static String a;

    /* renamed from: e */
    private static ay f9111e = new ay();
    private List<a> b = new ArrayList();

    /* renamed from: c */
    private da.a f9112c;

    /* renamed from: d */
    private p.b f9113d;

    /* loaded from: classes3.dex */
    public static abstract class a {
        public void a(da.a aVar) {
        }

        public void a(db.b bVar) {
        }
    }

    private ay() {
    }

    public static ay a() {
        return f9111e;
    }

    public static synchronized String e() {
        String str;
        synchronized (ay.class) {
            if (a == null) {
                SharedPreferences sharedPreferences = jl.a().getSharedPreferences("XMPushServiceConfig", 0);
                String string = sharedPreferences.getString("DeviceUUID", null);
                a = string;
                if (string == null) {
                    String a2 = ii.a(jl.a(), false);
                    a = a2;
                    if (a2 != null) {
                        sharedPreferences.edit().putString("DeviceUUID", a).commit();
                    }
                }
            }
            str = a;
        }
        return str;
    }

    private void f() {
        if (this.f9112c == null) {
            h();
        }
    }

    private void g() {
        if (this.f9113d != null) {
            return;
        }
        az azVar = new az(this);
        this.f9113d = azVar;
        gf.a(azVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void h() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = com.xiaomi.push.jl.a()     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.lang.String r2 = "XMCloudCfg"
            java.io.FileInputStream r1 = r1.openFileInput(r2)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            r2.<init>(r1)     // Catch: java.lang.Throwable -> L23 java.lang.Exception -> L27
            com.xiaomi.push.ab r0 = com.xiaomi.push.ab.a(r2)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            com.xiaomi.push.da$a r0 = com.xiaomi.push.da.a.b(r0)     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r4.f9112c = r0     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
            r2.close()     // Catch: java.lang.Exception -> L21 java.lang.Throwable -> L4f
        L1d:
            com.xiaomi.push.c.a(r2)
            goto L43
        L21:
            r0 = move-exception
            goto L2a
        L23:
            r1 = move-exception
            r2 = r0
            r0 = r1
            goto L50
        L27:
            r1 = move-exception
            r2 = r0
            r0 = r1
        L2a:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L4f
            r1.<init>()     // Catch: java.lang.Throwable -> L4f
            java.lang.String r3 = "load config failure: "
            r1.append(r3)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> L4f
            r1.append(r0)     // Catch: java.lang.Throwable -> L4f
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Throwable -> L4f
            com.xiaomi.a.a.a.c.a(r0)     // Catch: java.lang.Throwable -> L4f
            goto L1d
        L43:
            com.xiaomi.push.da$a r0 = r4.f9112c
            if (r0 != 0) goto L4e
            com.xiaomi.push.da$a r0 = new com.xiaomi.push.da$a
            r0.<init>()
            r4.f9112c = r0
        L4e:
            return
        L4f:
            r0 = move-exception
        L50:
            com.xiaomi.push.c.a(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.ay.h():void");
    }

    public void i() {
        try {
            if (this.f9112c != null) {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(jl.a().openFileOutput("XMCloudCfg", 0));
                com.xiaomi.push.bc a2 = com.xiaomi.push.bc.a(bufferedOutputStream);
                this.f9112c.a(a2);
                a2.a();
                bufferedOutputStream.close();
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("save config failure: " + e2.getMessage());
        }
    }

    public void a(db.b bVar) {
        a[] aVarArr;
        if (bVar.f() && bVar.e() > c()) {
            g();
        }
        synchronized (this) {
            List<a> list = this.b;
            aVarArr = (a[]) list.toArray(new a[list.size()]);
        }
        for (a aVar : aVarArr) {
            aVar.a(bVar);
        }
    }

    public synchronized void a(a aVar) {
        this.b.add(aVar);
    }

    public synchronized void b() {
        this.b.clear();
    }

    public int c() {
        f();
        da.a aVar = this.f9112c;
        if (aVar != null) {
            return aVar.a();
        }
        return 0;
    }

    public da.a d() {
        f();
        return this.f9112c;
    }
}
