package bykvm_19do.bykvm_19do.bykvm_19do;

import org.json.JSONObject;

/* loaded from: classes.dex */
public class z1 extends t1 {

    /* renamed from: d */
    public static final long[] f212d = {com.heytap.mcssdk.constant.a.f3314d, com.heytap.mcssdk.constant.a.f3314d, com.heytap.mcssdk.constant.a.f3314d, 120000, 120000, 120000, 180000, 180000};

    /* renamed from: e */
    public static final long[] f213e = {180000, 180000, 360000, 360000, 540000, 540000};

    /* renamed from: f */
    private static final long[] f214f = {com.heytap.mcssdk.constant.a.q, com.heytap.mcssdk.constant.a.q, 20000, 20000, com.heytap.mcssdk.constant.a.f3314d, 6000, 180000, 180000, 540000, 540000};

    public z1(v1 v1Var) {
        super(v1Var);
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean a() {
        return true;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long b() {
        return (this.a.e().c() ? 21600000 : 43200000) + this.a.d().l();
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public long[] c() {
        int k2 = this.a.d().k();
        if (k2 != 0) {
            if (k2 != 1) {
                if (k2 == 2) {
                    return f212d;
                }
                l0.a(null);
            }
            return f213e;
        }
        return f214f;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public boolean d() {
        JSONObject jSONObject = new JSONObject();
        JSONObject a = this.a.d().a();
        if (a != null) {
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", a);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject a2 = s.a(t.a(this.a.a(), this.a.d().a(), this.a.f().c(), true, a.j()), jSONObject);
            if (a2 != null) {
                return this.a.d().a(a2, a2.optString("device_id", ""), a2.optString("install_id", ""), a2.optString("ssid", ""));
            }
        } else {
            l0.a(null);
        }
        return false;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_19do.t1
    public String e() {
        return "r";
    }
}
