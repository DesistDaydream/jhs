package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class a implements b, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b {

    /* renamed from: d  reason: collision with root package name */
    private static volatile a f997d;

    /* renamed from: e  reason: collision with root package name */
    private static volatile boolean f998e;
    private b a;
    private int b = 0;

    /* renamed from: c  reason: collision with root package name */
    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b f999c = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.a();

    /* renamed from: bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class RunnableC0048a implements Runnable {
        public RunnableC0048a(a aVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.h().c("11111");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.h().a("11111");
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.h().f();
        }
    }

    private a() {
        this.a = q() ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.h() : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j();
    }

    public static a r() {
        if (f997d == null) {
            synchronized (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.b.class) {
                if (f997d == null) {
                    f997d = new a();
                }
            }
        }
        return f997d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        return this.a.a(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        return this.a.a();
    }

    public void a(Map<String, Object> map) {
        if (r().h()) {
            r().c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.f928c);
        } else if (!r().m()) {
            return;
        }
        map.put("if_use_new_sdkinit", Integer.valueOf(r().o()));
        map.put("init_splash_fill_duration", Long.valueOf(r().k()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        this.a.a(jSONArray);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            if (!f998e) {
                f998e = true;
                if (jSONObject.has("if_use_new_sdkinit")) {
                    try {
                        this.b = Integer.parseInt(jSONObject.optString("if_use_new_sdkinit"));
                    } catch (Exception unused) {
                    }
                }
                this.b = 0;
            }
            d.R().b("use_new_sdk_init", this.b);
            this.a.a(jSONObject);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        return this.a.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public c b(String str) {
        return this.a.b(str);
    }

    public void b(Map<String, Object> map) {
        if (r().h() || r().m()) {
            map.put("if_use_new_sdkinit", Integer.valueOf(r().o()));
            map.put("init_splash_request_duration", Long.valueOf(r().l()));
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        this.a.b(jSONObject);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        return this.a.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void c(String str) {
        this.f999c.c(str);
    }

    public void c(Map<String, Object> map) {
        if (r().h()) {
            r().c(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.a.f928c);
        } else if (!r().m()) {
            return;
        }
        map.put("if_use_new_sdkinit", Integer.valueOf(r().o()));
        map.put("call_init_method_duration", Long.valueOf(r().i()));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        this.a.d();
    }

    public boolean d(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a = a(str);
        return a != null && a.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        return this.a.e();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        return this.a.f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        return this.a.g();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean h() {
        return this.f999c.h();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long i() {
        return this.f999c.i();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void j() {
        this.f999c.j();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long k() {
        return this.f999c.k();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public long l() {
        return this.f999c.l();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public boolean m() {
        return this.f999c.m();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_if122.b
    public void n() {
        this.f999c.n();
    }

    public int o() {
        int i2 = this.b;
        if (i2 != 1) {
            return 0;
        }
        return i2;
    }

    public void p() {
        ThreadHelper.runOnThreadPool(new RunnableC0048a(this));
    }

    public boolean q() {
        if (this.b == 0) {
            this.b = d.R().a("use_new_sdk_init", 0);
        }
        return this.b == 1;
    }
}
