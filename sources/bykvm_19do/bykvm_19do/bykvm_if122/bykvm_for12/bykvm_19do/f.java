package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.c0;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class f implements e<bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i> {
    private Context a;

    public f(Context context) {
        if (context != null) {
            this.a = context.getApplicationContext();
        }
    }

    private bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i a(String str, boolean z) {
        String str2;
        String str3;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                String[] split = jSONObject.getString("unity_id").split("_");
                String str4 = split.length > 0 ? split[0] : "";
                String str5 = split.length > 1 ? split[1] : "";
                if (z) {
                    str2 = "";
                    str3 = str2;
                } else {
                    String string = jSONObject.getString("waterfall_show_rules_version");
                    str3 = jSONObject.getString("adn_rit_show_rules_version");
                    str2 = string;
                }
                return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i(str4, str5, str2, str3, jSONObject.getInt("timing_mode"), jSONObject.getString("show_pacing"), jSONObject.getString("show_pacing_rule_id"), jSONObject.getString("show_time"));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i iVar) {
        synchronized (this) {
            if (this.a != null && iVar != null) {
                c0 a = c0.a("pacing_" + iVar.d(), this.a);
                String g2 = iVar.g();
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("unity_id", iVar.g());
                    if (!iVar.h()) {
                        jSONObject.put("waterfall_show_rules_version", iVar.e());
                        jSONObject.put("adn_rit_show_rules_version", iVar.b());
                    }
                    jSONObject.put("timing_mode", iVar.f());
                    jSONObject.put("show_pacing", iVar.i() + "");
                    jSONObject.put("show_pacing_rule_id", iVar.j());
                    jSONObject.put("show_time", iVar.k() + "");
                    a.b(g2, jSONObject.toString());
                } catch (JSONException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str) {
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (this.a != null && !TextUtils.isEmpty(str)) {
                c0.a("pacing_" + str, this.a).f(str);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e
    public void a(String str, long j2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b = b(str);
                b.a(j2);
                a(b);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public void a(String str, String str2) {
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (this.a != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                c0 a = c0.a("pacing_" + str, this.a);
                a.f(str + "_" + str2);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.e
    public void a(String str, String str2, long j2) {
        synchronized (this) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b = b(str, str2);
                b.a(j2);
                a(b);
            }
        }
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b(String str) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i a;
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (TextUtils.isEmpty(str)) {
                a = null;
            } else {
                a = a(c0.a("pacing_" + str, this.a).a(str, ""), false);
            }
        }
        return a;
    }

    @Override // bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do.g
    public bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i b(String str, String str2) {
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_byte12b.i a;
        synchronized (this) {
            if (str.contains("_")) {
                throw new RuntimeException(" has slotId");
            }
            if (TextUtils.isEmpty(str)) {
                a = null;
            } else {
                c0 a2 = c0.a("pacing_" + str, this.a);
                a = a(a2.a(str + "_" + str2, ""), true);
            }
        }
        return a;
    }
}
