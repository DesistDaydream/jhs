package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class b implements bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_19do.b, h, f, e, g {

    /* renamed from: e  reason: collision with root package name */
    private static volatile b f994e;
    private h a = new j();
    private f b = new c();

    /* renamed from: c  reason: collision with root package name */
    private e f995c = new a();

    /* renamed from: d  reason: collision with root package name */
    private g f996d = new i();

    private b() {
    }

    public static b h() {
        if (f994e == null) {
            synchronized (b.class) {
                if (f994e == null) {
                    f994e = new b();
                }
            }
        }
        return f994e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a a(String str) {
        return this.f995c.a(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public List<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.a> a() {
        return this.f995c.a();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public void a(Map<String, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c> map) {
        this.a.a(map);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public void a(JSONArray jSONArray) {
        this.f996d.a(jSONArray);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        this.b.a(jSONObject);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        return this.b.b();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c b(String str) {
        return this.f996d.b(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void b(JSONObject jSONObject) {
        this.f995c.b(jSONObject);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        return this.b.c();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.h
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_case1.c c(String str) {
        return this.a.c(str);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public void d() {
        this.f995c.d();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.e
    public boolean e() {
        return this.f995c.e();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        return this.b.f();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.g
    public boolean g() {
        return this.f996d.g();
    }
}
