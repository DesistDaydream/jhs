package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashSet;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class j2 {
    private final Context a;
    private final h b;

    /* renamed from: c  reason: collision with root package name */
    private final SharedPreferences f133c;

    /* renamed from: d  reason: collision with root package name */
    private final SharedPreferences f134d;

    /* renamed from: e  reason: collision with root package name */
    private final SharedPreferences f135e;

    /* renamed from: f  reason: collision with root package name */
    private volatile JSONObject f136f;

    /* renamed from: g  reason: collision with root package name */
    private volatile JSONObject f137g;

    public j2(Context context, h hVar) {
        this.a = context;
        this.b = hVar;
        this.f135e = context.getSharedPreferences("embed_applog_stats", 0);
        this.f133c = context.getSharedPreferences("embed_header_custom", 0);
        this.f134d = context.getSharedPreferences("embed_last_sp_session", 0);
    }

    public int A() {
        return this.f135e.getInt("bav_monitor_rate", 0);
    }

    public String B() {
        return this.b.e();
    }

    public String C() {
        return this.b.j();
    }

    public String D() {
        return this.b.k();
    }

    public String E() {
        return this.b.l();
    }

    public String F() {
        return this.b.q();
    }

    public String G() {
        return this.f133c.getString("header_custom_info", null);
    }

    public String H() {
        return this.f133c.getString("ab_sdk_version", "");
    }

    public String I() {
        return this.f133c.getString("user_unique_id", null);
    }

    public boolean J() {
        if (this.b.p() == 0) {
            String a = m0.a(this.a);
            if (TextUtils.isEmpty(a)) {
                this.b.a(0);
            } else {
                this.b.a(a.contains(Constants.COLON_SEPARATOR) ? 2 : 1);
            }
        }
        return this.b.p() == 1;
    }

    public long K() {
        return this.f135e.getLong("abtest_fetch_interval", 0L);
    }

    public String L() {
        return !TextUtils.isEmpty(this.b.d()) ? this.b.d() : this.f133c.getString("ab_version", null);
    }

    public JSONObject M() {
        JSONObject jSONObject = this.f136f;
        if (jSONObject == null) {
            synchronized (this) {
                try {
                    if (N()) {
                        jSONObject = new JSONObject(this.f133c.getString("ab_configure", ""));
                    }
                } catch (JSONException unused) {
                }
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                this.f136f = jSONObject;
            }
        }
        return jSONObject;
    }

    public boolean N() {
        return this.f135e.getBoolean("bav_ab_config", false);
    }

    public boolean O() {
        return this.f135e.getBoolean("bav_log_collect", false);
    }

    public long P() {
        return this.f135e.getLong("session_interval", JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS);
    }

    public long Q() {
        return this.f135e.getLong("batch_event_interval", JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS);
    }

    public String R() {
        return null;
    }

    public String S() {
        return this.b.r();
    }

    public String a() {
        return this.f135e.getString("user_agent", null);
    }

    public void a(long j2) {
    }

    public void a(String str, int i2) {
        this.f134d.edit().putString("session_last_day", str).putInt("session_order", i2).apply();
    }

    public void a(HashSet<String> hashSet, HashSet<String> hashSet2) {
    }

    public void a(JSONObject jSONObject) {
        if (l0.a) {
            l0.a("setConfig, " + jSONObject.toString(), null);
        }
        this.f137g = jSONObject;
        long currentTimeMillis = System.currentTimeMillis();
        SharedPreferences.Editor edit = this.f135e.edit();
        long optInt = jSONObject.optInt("session_interval", 0);
        if (optInt <= 0 || optInt > 604800) {
            edit.remove("session_interval");
        } else {
            edit.putLong("session_interval", optInt * 1000);
        }
        long optInt2 = jSONObject.optInt("batch_event_interval", 0);
        if (optInt2 <= 0 || optInt2 > 604800) {
            edit.remove("batch_event_interval");
        } else {
            edit.putLong("batch_event_interval", optInt2 * 1000);
        }
        int optInt3 = jSONObject.optInt("send_launch_timely", 0);
        if (optInt3 <= 0 || optInt3 > 604800) {
            edit.remove("send_launch_timely");
        } else {
            edit.putInt("send_launch_timely", optInt3);
        }
        long optInt4 = jSONObject.optInt("abtest_fetch_interval", 0);
        if (optInt4 <= 20 || optInt4 > 604800) {
            edit.remove("abtest_fetch_interval");
        } else {
            edit.putLong("abtest_fetch_interval", optInt4 * 1000);
        }
        if (jSONObject.optBoolean("bav_log_collect", true)) {
            edit.putBoolean("bav_log_collect", true);
        } else {
            edit.remove("bav_log_collect");
        }
        if (jSONObject.optBoolean("bav_ab_config", false)) {
            edit.putBoolean("bav_ab_config", true);
        } else {
            edit.remove("bav_ab_config");
        }
        int optInt5 = jSONObject.optInt("bav_monitor_rate", 0);
        if (optInt5 <= 0 || optInt5 > 100) {
            edit.remove("bav_monitor_rate");
            k0.a(false);
        } else {
            edit.putInt("bav_monitor_rate", optInt5);
            k0.a(true);
        }
        edit.putLong("app_log_last_config_time", currentTimeMillis);
        edit.apply();
    }

    public boolean a(ArrayList<u> arrayList) {
        return true;
    }

    public long b() {
        return com.heytap.mcssdk.constant.a.q;
    }

    public void b(JSONObject jSONObject) {
        this.f133c.edit().putString("header_custom_info", jSONObject != null ? jSONObject.toString() : "").apply();
    }

    public String c() {
        return this.b.i();
    }

    public void c(JSONObject jSONObject) {
        l0.a("setAbConfig, " + jSONObject.toString(), null);
        this.f133c.edit().putString("ab_configure", jSONObject.toString()).apply();
        this.f136f = null;
    }

    public int d() {
        return this.b.x();
    }

    public int e() {
        return this.b.u();
    }

    public int f() {
        return this.b.m();
    }

    public String g() {
        return this.b.w();
    }

    public String h() {
        return this.b.t();
    }

    public String i() {
        return this.b.a();
    }

    public String j() {
        return this.b.c();
    }

    public String k() {
        return this.b.b();
    }

    public String l() {
        return this.b.y();
    }

    public String m() {
        return this.b.h() == null ? "" : this.b.h();
    }

    public String n() {
        return this.b.g() == null ? "" : this.b.g();
    }

    public boolean o() {
        return this.b.A();
    }

    public h p() {
        return this.b;
    }

    public CharSequence q() {
        return this.b.z();
    }

    public String r() {
        return this.b.n();
    }

    public boolean s() {
        return this.b.C();
    }

    public String t() {
        return this.b.f();
    }

    public String u() {
        return this.f134d.getString("session_last_day", "");
    }

    public int v() {
        return this.f134d.getInt("session_order", 0);
    }

    public SharedPreferences w() {
        return this.f135e;
    }

    public boolean x() {
        return this.b.B();
    }

    public JSONObject y() {
        return this.f137g;
    }

    public long z() {
        return this.f135e.getLong("app_log_last_config_time", 0L);
    }
}
