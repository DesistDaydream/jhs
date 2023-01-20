package com.xiaomi.b.b;

import android.content.Context;
import com.xiaomi.push.ar;
import com.xiaomi.push.as;
import com.xiaomi.push.at;
import com.xiaomi.push.au;
import com.xiaomi.push.av;
import com.xiaomi.push.ay;
import com.xiaomi.push.jc;
import com.xiaomi.push.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes3.dex */
public class b {
    private static final int a;
    private static volatile b b;

    /* renamed from: c  reason: collision with root package name */
    private ExecutorService f8210c = Executors.newSingleThreadExecutor();

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, HashMap<String, com.xiaomi.b.a.d>> f8211d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, ArrayList<com.xiaomi.b.a.d>> f8212e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private Context f8213f;

    /* renamed from: g  reason: collision with root package name */
    private com.xiaomi.b.a.a f8214g;

    /* renamed from: h  reason: collision with root package name */
    private String f8215h;

    /* renamed from: i  reason: collision with root package name */
    private com.xiaomi.b.c.a f8216i;

    /* renamed from: j  reason: collision with root package name */
    private com.xiaomi.b.c.b f8217j;

    static {
        a = jc.a() ? 30 : 10;
    }

    private b(Context context) {
        this.f8213f = context;
    }

    public static b a(Context context) {
        if (b == null) {
            synchronized (b.class) {
                if (b == null) {
                    b = new b(context);
                }
            }
        }
        return b;
    }

    private void a(m.a aVar, int i2) {
        m.a(this.f8213f).b(aVar, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.xiaomi.b.a.b bVar) {
        com.xiaomi.b.c.a aVar = this.f8216i;
        if (aVar != null) {
            aVar.b(bVar);
            if (g() < 10) {
                a(new e(this), a);
                return;
            }
            e();
            m.a(this.f8213f).a("100888");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.xiaomi.b.a.c cVar) {
        com.xiaomi.b.c.b bVar = this.f8217j;
        if (bVar != null) {
            bVar.b(cVar);
            if (h() < 10) {
                a(new g(this), a);
                return;
            }
            f();
            m.a(this.f8213f).a("100889");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        try {
            this.f8216i.b();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("we: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        try {
            this.f8217j.b();
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.d("wp: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int g() {
        HashMap<String, ArrayList<com.xiaomi.b.a.d>> hashMap = this.f8212e;
        if (hashMap != null) {
            int i2 = 0;
            for (String str : hashMap.keySet()) {
                ArrayList<com.xiaomi.b.a.d> arrayList = this.f8212e.get(str);
                i2 += arrayList != null ? arrayList.size() : 0;
            }
            return i2;
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int h() {
        HashMap<String, HashMap<String, com.xiaomi.b.a.d>> hashMap = this.f8211d;
        int i2 = 0;
        if (hashMap != null) {
            for (String str : hashMap.keySet()) {
                HashMap<String, com.xiaomi.b.a.d> hashMap2 = this.f8211d.get(str);
                if (hashMap2 != null) {
                    for (String str2 : hashMap2.keySet()) {
                        com.xiaomi.b.a.d dVar = hashMap2.get(str2);
                        if (dVar instanceof com.xiaomi.b.a.c) {
                            i2 = (int) (i2 + ((com.xiaomi.b.a.c) dVar).b);
                        }
                    }
                }
            }
        }
        return i2;
    }

    private void i() {
        if (a(this.f8213f).a().c()) {
            as asVar = new as(this.f8213f);
            int f2 = (int) a(this.f8213f).a().f();
            if (f2 < 1800) {
                f2 = 1800;
            }
            if (System.currentTimeMillis() - ay.a(this.f8213f).b("sp_client_report_status", "event_last_upload_time", 0L) > f2 * 1000) {
                m.a(this.f8213f).a(new i(this, asVar), 10);
            }
            synchronized (b.class) {
                if (!m.a(this.f8213f).a((m.a) asVar, f2)) {
                    m.a(this.f8213f).a("100886");
                    m.a(this.f8213f).a((m.a) asVar, f2);
                }
            }
        }
    }

    private void j() {
        if (a(this.f8213f).a().d()) {
            at atVar = new at(this.f8213f);
            int g2 = (int) a(this.f8213f).a().g();
            if (g2 < 1800) {
                g2 = 1800;
            }
            if (System.currentTimeMillis() - ay.a(this.f8213f).b("sp_client_report_status", "perf_last_upload_time", 0L) > g2 * 1000) {
                m.a(this.f8213f).a(new j(this, atVar), 15);
            }
            synchronized (b.class) {
                if (!m.a(this.f8213f).a((m.a) atVar, g2)) {
                    m.a(this.f8213f).a("100887");
                    m.a(this.f8213f).a((m.a) atVar, g2);
                }
            }
        }
    }

    public synchronized com.xiaomi.b.a.a a() {
        if (this.f8214g == null) {
            this.f8214g = com.xiaomi.b.a.a.a(this.f8213f);
        }
        return this.f8214g;
    }

    public com.xiaomi.b.a.b a(int i2, String str) {
        com.xiaomi.b.a.b bVar = new com.xiaomi.b.a.b();
        bVar.f8203d = str;
        bVar.f8202c = System.currentTimeMillis();
        bVar.b = i2;
        bVar.a = ar.a(6);
        bVar.f8207e = 1000;
        bVar.f8209g = 1001;
        bVar.f8208f = "E100004";
        bVar.a(this.f8213f.getPackageName());
        bVar.b(this.f8215h);
        return bVar;
    }

    public void a(com.xiaomi.b.a.a aVar, com.xiaomi.b.c.a aVar2, com.xiaomi.b.c.b bVar) {
        this.f8214g = aVar;
        this.f8216i = aVar2;
        this.f8217j = bVar;
        aVar2.a(this.f8212e);
        this.f8217j.a(this.f8211d);
    }

    public void a(com.xiaomi.b.a.b bVar) {
        if (a().c()) {
            this.f8210c.execute(new c(this, bVar));
        }
    }

    public void a(com.xiaomi.b.a.c cVar) {
        if (a().d()) {
            this.f8210c.execute(new d(this, cVar));
        }
    }

    public void a(String str) {
        this.f8215h = str;
    }

    public void a(boolean z, boolean z2, long j2, long j3) {
        com.xiaomi.b.a.a aVar = this.f8214g;
        if (aVar != null) {
            if (z == aVar.c() && z2 == this.f8214g.d() && j2 == this.f8214g.f() && j3 == this.f8214g.g()) {
                return;
            }
            long f2 = this.f8214g.f();
            long g2 = this.f8214g.g();
            com.xiaomi.b.a.a a2 = com.xiaomi.b.a.a.a().a(av.a(this.f8213f)).a(this.f8214g.b()).b(z).b(j2).c(z2).c(j3).a(this.f8213f);
            this.f8214g = a2;
            if (!a2.c()) {
                m.a(this.f8213f).a("100886");
            } else if (f2 != a2.f()) {
                com.xiaomi.a.a.a.c.c(this.f8213f.getPackageName() + "reset event job " + a2.f());
                i();
            }
            if (!this.f8214g.d()) {
                m.a(this.f8213f).a("100887");
            } else if (g2 != a2.g()) {
                com.xiaomi.a.a.a.c.c(this.f8213f.getPackageName() + " reset perf job " + a2.g());
                j();
            }
        }
    }

    public void b() {
        a(this.f8213f).i();
        a(this.f8213f).j();
    }

    public void c() {
        if (a().c()) {
            au auVar = new au();
            auVar.a(this.f8213f);
            auVar.a(this.f8216i);
            this.f8210c.execute(auVar);
        }
    }

    public void d() {
        if (a().d()) {
            au auVar = new au();
            auVar.a(this.f8217j);
            auVar.a(this.f8213f);
            this.f8210c.execute(auVar);
        }
    }
}
