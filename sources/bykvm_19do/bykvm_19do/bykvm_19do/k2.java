package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.XGPushNotificationBuilder;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class k2 {

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f141h = {"channel", "package", "app_version"};
    private boolean a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private final j2 f142c;

    /* renamed from: f  reason: collision with root package name */
    private final SharedPreferences f145f;

    /* renamed from: e  reason: collision with root package name */
    private final ArrayList<e2> f144e = new ArrayList<>(32);

    /* renamed from: g  reason: collision with root package name */
    private int f146g = 0;

    /* renamed from: d  reason: collision with root package name */
    private JSONObject f143d = new JSONObject();

    public k2(Context context, j2 j2Var) {
        this.b = context;
        this.f142c = j2Var;
        this.f145f = j2Var.w();
        s0.a(j2Var.r());
        s0.a(j2Var.s());
        s0.a(context);
    }

    private String a(Set<String> set) {
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            }
        }
        return sb.toString();
    }

    public static void a(JSONObject jSONObject, String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        jSONObject.put(str, str2);
    }

    private boolean a(e2 e2Var) {
        boolean z = !this.f142c.J() && e2Var.f105d;
        if (l0.a) {
            l0.a("needSyncFromSub " + e2Var + ExpandableTextView.N + z, null);
        }
        return z;
    }

    public static boolean a(String str) {
        int length = str != null ? str.length() : 0;
        if (length < 13 || length > 128) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = str.charAt(i2);
            if ((charAt < '0' || charAt > '9') && ((charAt < 'a' || charAt > 'f') && ((charAt < 'A' || charAt > 'F') && charAt != '-'))) {
                return false;
            }
        }
        return true;
    }

    private void b(JSONObject jSONObject) {
        synchronized (this) {
            if (jSONObject == null) {
                l0.b("null abconfig", null);
            } else {
                String optString = n().optString("ab_version");
                if (!TextUtils.isEmpty(optString)) {
                    String[] split = optString.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    Set<String> hashSet = new HashSet<>();
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str)) {
                            hashSet.add(str);
                        }
                    }
                    Iterator<String> keys = jSONObject.keys();
                    HashSet hashSet2 = new HashSet();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        if (next instanceof String) {
                            String str2 = next;
                            if (!TextUtils.isEmpty(str2)) {
                                try {
                                    hashSet2.add(jSONObject.getJSONObject(str2).optString("vid"));
                                } catch (JSONException e2) {
                                    l0.a(e2);
                                }
                            }
                        }
                    }
                    hashSet.retainAll(hashSet2);
                    b("ab_version", a(hashSet));
                }
            }
        }
    }

    public static boolean b(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str) || "unknown".equalsIgnoreCase(str) || "Null".equalsIgnoreCase(str)) {
            return false;
        }
        int i2 = 0;
        while (true) {
            if (i2 >= str.length()) {
                z = true;
                break;
            } else if (str.charAt(i2) != '0') {
                break;
            } else {
                i2++;
            }
        }
        return !z;
    }

    private boolean b(String str, Object obj) {
        boolean z;
        Object opt = n().opt(str);
        if ((obj == null || obj.equals(opt)) && (obj != null || opt == null)) {
            z = false;
        } else {
            synchronized (this) {
                try {
                    JSONObject jSONObject = this.f143d;
                    JSONObject jSONObject2 = new JSONObject();
                    m0.b(jSONObject2, jSONObject);
                    jSONObject2.put(str, obj);
                    this.f143d = jSONObject2;
                } catch (JSONException e2) {
                    l0.a(e2);
                }
            }
            z = true;
        }
        l0.a("updateHeader, " + str + ", " + opt + ", " + obj, null);
        return z;
    }

    private JSONObject n() {
        return this.f143d;
    }

    public <T> T a(String str, T t) {
        JSONObject n = n();
        Object obj = (n == null || (obj = n.opt(str)) == null) ? null : null;
        return obj == null ? t : (T) obj;
    }

    public JSONObject a() {
        if (this.a) {
            return n();
        }
        return null;
    }

    public void a(HashMap<String, Object> hashMap) {
        JSONObject jSONObject = null;
        if (hashMap != null && !hashMap.isEmpty()) {
            try {
                jSONObject = n().optJSONObject(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE);
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                for (Map.Entry<String, Object> entry : hashMap.entrySet()) {
                    if (!TextUtils.isEmpty(entry.getKey())) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                }
            } catch (JSONException e2) {
                l0.a(e2);
            }
        }
        if (b(XGPushNotificationBuilder.CUSTOM_NOTIFICATION_BUILDER_TYPE, jSONObject)) {
            this.f142c.b(jSONObject);
        }
    }

    public void a(JSONObject jSONObject) {
        this.f142c.c(jSONObject);
        b(jSONObject);
    }

    public boolean a(JSONObject jSONObject, String str, String str2, String str3) {
        boolean b;
        int i2;
        boolean z;
        boolean z2;
        if (l0.a) {
            l0.a("saveRegisterInfo, " + str + ", " + str2 + ", " + str3 + ", " + jSONObject, null);
        }
        boolean b2 = b(str);
        boolean b3 = b(str2);
        try {
            b = b(str3);
            i2 = this.f145f.getInt("version_code", 0);
        } catch (JSONException e2) {
            e = e2;
        }
        try {
            int optInt = n().optInt("version_code", 0);
            SharedPreferences.Editor edit = this.f145f.edit();
            if (i2 != optInt) {
                edit.putInt("version_code", optInt);
            }
            if (b2) {
                long currentTimeMillis = System.currentTimeMillis();
                edit.putLong("register_time", currentTimeMillis);
                b("register_time", Long.valueOf(currentTimeMillis));
            } else if (!b2) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("response", jSONObject);
                a.a("tt_fetch_did_error", jSONObject2);
            }
            String optString = n().optString("device_id", "");
            if (b2 && b("device_id", str)) {
                edit.putString("device_id", str);
                z = true;
            } else {
                z = false;
            }
            String optString2 = n().optString("install_id", "");
            if (b3 && b("install_id", str2)) {
                edit.putString("install_id", str2);
                z = true;
            }
            String optString3 = n().optString("ssid", "");
            if (b && b("ssid", str3)) {
                edit.putString("ssid", str3);
                z2 = true;
            } else {
                z2 = z;
            }
            a.f().a(z2, optString, str, optString2, str2, optString3, str3);
            edit.apply();
        } catch (JSONException e3) {
            e = e3;
            l0.a(e);
            if (b2) {
            }
        }
        return !b2 && b3;
    }

    public JSONObject b() {
        JSONObject a = a();
        if (a != null) {
            try {
                String a2 = s0.a(a.optJSONObject("oaid"));
                if (TextUtils.isEmpty(a2)) {
                    return a;
                }
                JSONObject jSONObject = new JSONObject();
                m0.b(jSONObject, a);
                jSONObject.put("oaid", a2);
                return jSONObject;
            } catch (Exception e2) {
                l0.a(e2);
                return a;
            }
        }
        return a;
    }

    public int c() {
        int optInt = this.a ? n().optInt("version_code", -1) : -1;
        for (int i2 = 0; i2 < 3 && optInt == -1; i2++) {
            e();
            optInt = this.a ? n().optInt("version_code", -1) : -1;
        }
        return optInt;
    }

    public String d() {
        String optString = this.a ? n().optString("app_version", null) : null;
        for (int i2 = 0; i2 < 3 && optString == null; i2++) {
            e();
            optString = this.a ? n().optString("app_version", null) : null;
        }
        return optString;
    }

    public boolean e() {
        String[] strArr;
        synchronized (this.f144e) {
            if (this.f144e.size() == 0) {
                this.f144e.add(new f2(this.b, this.f142c));
                this.f144e.add(new h2(this.b));
                this.f144e.add(new i2(this.b, this.f142c));
                this.f144e.add(new l2(this.b));
                this.f144e.add(new m2(this.b));
                this.f144e.add(new n2(this.b, this.f142c));
                this.f144e.add(new j(this.b));
                this.f144e.add(new l(this.b));
                this.f144e.add(new m(this.b, this.f142c));
                this.f144e.add(new n());
                this.f144e.add(new o(this.f142c));
                this.f144e.add(new p(this.b));
                this.f144e.add(new q(this.b));
                this.f144e.add(new r(this.b, this.f142c));
                this.f144e.add(new c2(this.b, this.f142c));
                this.f144e.add(new k(this.b, this.f142c));
                this.f144e.add(new g2(this.b, this.f142c));
            }
        }
        JSONObject n = n();
        JSONObject jSONObject = new JSONObject();
        m0.b(jSONObject, n);
        Iterator<e2> it = this.f144e.iterator();
        boolean z = true;
        int i2 = 0;
        int i3 = 0;
        while (it.hasNext()) {
            e2 next = it.next();
            if (!next.a || next.f104c || a(next)) {
                try {
                    next.a = next.a(jSONObject);
                } catch (SecurityException e2) {
                    if (!next.b) {
                        i3++;
                        l0.b("loadHeader, " + this.f146g, e2);
                        if (!next.a && this.f146g > 10) {
                            next.a = true;
                        }
                    }
                } catch (JSONException e3) {
                    l0.a(e3);
                }
                if (!next.a && !next.b) {
                    i2++;
                }
            }
            z &= next.a || next.b;
        }
        if (z) {
            int length = f141h.length;
            for (int i4 = 0; i4 < length; i4++) {
                z &= !TextUtils.isEmpty(jSONObject.optString(strArr[i4]));
            }
            String optString = jSONObject.optString("user_unique_id", null);
            if (!TextUtils.isEmpty(optString)) {
                try {
                    jSONObject.put("user_unique_id", optString);
                } catch (JSONException unused) {
                }
            }
        }
        this.f143d = jSONObject;
        this.a = z;
        if (l0.a) {
            l0.a("loadHeader, " + this.a + ", " + this.f146g + ", " + this.f143d.toString(), null);
        } else {
            l0.d("loadHeader, " + this.a + ", " + this.f146g, null);
        }
        if (i3 > 0 && i3 == i2) {
            this.f146g++;
            if (k() != 0) {
                this.f146g += 10;
            }
        }
        if (this.a) {
            a.f().a(g(), h(), i());
        }
        return this.a;
    }

    public String f() {
        return n().optString("user_unique_id", "");
    }

    public String g() {
        return n().optString("device_id", "");
    }

    public String h() {
        return n().optString("install_id", "");
    }

    public String i() {
        return n().optString("ssid", "");
    }

    public String j() {
        return n().optString("user_unique_id", "");
    }

    public int k() {
        String optString = n().optString("device_id", "");
        n().optString("install_id", "");
        if (b(optString)) {
            return this.f145f.getInt("version_code", 0) == n().optInt("version_code", -1) ? 1 : 2;
        }
        return 0;
    }

    public long l() {
        return n().optLong("register_time", 0L);
    }

    public String m() {
        return n().optString("ab_sdk_version", "");
    }
}
