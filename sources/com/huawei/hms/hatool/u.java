package com.huawei.hms.hatool;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class u {
    public String a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f3608c;

    /* renamed from: d  reason: collision with root package name */
    public List<q> f3609d;

    /* renamed from: e  reason: collision with root package name */
    public String f3610e;

    public u(String str, String str2, String str3, List<q> list, String str4) {
        this.a = str;
        this.b = str2;
        this.f3608c = str3;
        this.f3609d = list;
        this.f3610e = str4;
    }

    public final String a(String str, String str2) {
        String str3;
        String f2 = c.f(str, str2);
        if (TextUtils.isEmpty(f2)) {
            y.a("hmsSdk", "No report address,TAG : %s,TYPE: %s ", str, str2);
            return "";
        }
        if ("oper".equals(str2)) {
            str3 = "{url}/common/hmshioperqrt";
        } else if ("maint".equals(str2)) {
            str3 = "{url}/common/hmshimaintqrt";
        } else if (!"diffprivacy".equals(str2)) {
            return "";
        } else {
            str3 = "{url}/common/common2";
        }
        return str3.replace("{url}", f2);
    }

    public void a() {
        n0 l0Var;
        o0 c2;
        String str;
        String a = a(this.a, this.b);
        if (!TextUtils.isEmpty(a) || "preins".equals(this.b)) {
            if (!"_hms_config_tag".equals(this.a) && !"_openness_config_tag".equals(this.a)) {
                b();
            }
            C0510r d2 = d();
            if (d2 != null) {
                byte[] a2 = a(d2);
                if (a2.length == 0) {
                    str = "request body is empty";
                } else {
                    l0Var = new i0(a2, a, this.a, this.b, this.f3610e, this.f3609d);
                    c2 = o0.b();
                }
            } else {
                l0Var = new l0(this.f3609d, this.a, this.f3610e, this.b);
                c2 = o0.c();
            }
            c2.a(l0Var);
            return;
        }
        str = "collectUrl is empty";
        y.e("hmsSdk", str);
    }

    public final byte[] a(C0510r c0510r) {
        String str;
        try {
            JSONObject a = c0510r.a();
            if (a == null) {
                y.e("hmsSdk", "uploadEvents is null");
                return new byte[0];
            }
            return t0.a(a.toString().getBytes("UTF-8"));
        } catch (UnsupportedEncodingException unused) {
            str = "sendData(): getBytes - Unsupported coding format!!";
            y.e("hmsSdk", str);
            return new byte[0];
        } catch (JSONException unused2) {
            str = "uploadEvents to json error";
            y.e("hmsSdk", str);
            return new byte[0];
        }
    }

    public final void b() {
        if (q0.a(b.i(), "backup_event", 5242880)) {
            y.d("hmsSdk", "backup file reach max limited size, discard new event ");
            return;
        }
        JSONArray c2 = c();
        String a = u0.a(this.a, this.b, this.f3610e);
        y.c("hmsSdk", "Update data cached into backup,spKey: " + a);
        g0.b(b.i(), "backup_event", a, c2.toString());
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (q qVar : this.f3609d) {
            try {
                jSONArray.put(qVar.d());
            } catch (JSONException unused) {
                y.c("hmsSdk", "handleEvents: json error,Abandon this data");
            }
        }
        return jSONArray;
    }

    public final C0510r d() {
        return d1.a(this.f3609d, this.a, this.b, this.f3610e, this.f3608c);
    }
}
