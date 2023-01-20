package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1;

import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c implements f {
    private int b = -1;

    /* renamed from: c  reason: collision with root package name */
    private int f1008c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f1009d = -1;
    private c0 a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_long108.d.O();

    private JSONObject a() {
        String a = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.a(this.a.d("app_common_config"), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
        if (a != null && !TextUtils.isEmpty(a)) {
            try {
                return new JSONObject(a);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private void b(JSONObject jSONObject) {
        int optInt = jSONObject.optInt("event_batch_size", 100);
        this.b = optInt;
        if (optInt <= 0 || optInt > 1000) {
            this.b = 100;
        }
        long optLong = jSONObject.optLong("event_routine_interval", 120000L);
        this.f1009d = optLong;
        if (optLong < com.heytap.mcssdk.constant.a.q || optLong > 300000) {
            this.f1009d = 120000L;
        }
        this.f1008c = jSONObject.optInt("event_send_type", 0);
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.c.a(jSONObject.optInt("if_use_new_loglib", 0));
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_for12.bykvm_if122.b.d().a(jSONObject.optInt("pre_fetch_count", 20));
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public void a(JSONObject jSONObject) {
        if (jSONObject != null) {
            b(jSONObject);
            String b = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.a.b(jSONObject.toString(), bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.b.a());
            if (b != null && !TextUtils.isEmpty(b)) {
                this.a.b("app_common_config", b);
            }
            bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.bykvm_for12.a.j().a(jSONObject);
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int b() {
        JSONObject a;
        int i2 = this.b;
        if (i2 == -1) {
            if (this.a == null || (a = a()) == null) {
                return 100;
            }
            b(a);
            return this.b;
        }
        return i2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public long c() {
        JSONObject a;
        long j2 = this.f1009d;
        if (j2 == -1) {
            if (this.a == null || (a = a()) == null) {
                return 120000L;
            }
            b(a);
            return this.f1009d;
        }
        return j2;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_new1.f
    public int f() {
        JSONObject a;
        int i2 = this.f1008c;
        if (i2 == -1) {
            if (this.a == null || (a = a()) == null) {
                return 0;
            }
            b(a);
            return this.f1008c;
        }
        return i2;
    }
}
