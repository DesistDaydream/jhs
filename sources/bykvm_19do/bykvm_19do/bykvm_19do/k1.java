package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class k1 extends t1 {

    /* renamed from: d */
    private long f140d;

    public k1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        long K = this.a.c().K();
        if (K < 600000) {
            K = 600000;
        }
        return K + this.f140d;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long[] c() {
        return z1.f213e;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        JSONObject a = this.a.d().a();
        if (this.a.d().k() != 0 && a != null) {
            long currentTimeMillis = System.currentTimeMillis();
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("header", this.a.d().a());
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("_gen_time", currentTimeMillis);
            JSONObject d2 = s.d(s.a(t.a(this.a.a(), this.a.d().a(), this.a.f().a(), true, a.j()), s.f160e), jSONObject);
            if (d2 != null) {
                a.f().b(!m0.a(a.b(), d2), d2);
                if (l0.a) {
                    l0.a("getAbConfig " + d2, null);
                }
                this.a.d().a(d2);
                this.f140d = currentTimeMillis;
                return true;
            }
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public String e() {
        return "ab";
    }
}
