package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class c0 {
    private static Map<String, c0> b = new HashMap();
    private SharedPreferences a;

    private c0(String str, Context context) {
        if (context != null) {
            this.a = context.getApplicationContext().getSharedPreferences(str, 0);
        }
    }

    public static c0 a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            str = "tt_ad_mediation_sdk_sp";
        }
        c0 c0Var = b.get(str);
        if (c0Var == null) {
            c0 c0Var2 = new c0(str, context);
            b.put(str, c0Var2);
            return c0Var2;
        }
        return c0Var;
    }

    public static void a(JSONObject jSONObject) {
        try {
            String d2 = a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d("gm_key_v3_bug");
            JSONArray jSONArray = !TextUtils.isEmpty(d2) ? new JSONArray(d2) : new JSONArray();
            if (jSONArray.length() >= 100) {
                jSONArray.put(99, jSONObject);
            } else {
                jSONArray.put(jSONObject);
            }
            a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).b("gm_key_v3_bug", jSONArray.toString());
        } catch (Throwable unused) {
        }
    }

    public static JSONArray c() {
        try {
            String d2 = a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).d("gm_key_v3_bug");
            if (!TextUtils.isEmpty(d2)) {
                JSONArray jSONArray = new JSONArray(d2);
                a("gm_v3_temp", bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d()).f("gm_key_v3_bug");
                return jSONArray;
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    public float a(@NonNull String str, float f2) {
        try {
            return this.a.getFloat(str, f2);
        } catch (Throwable unused) {
            return f2;
        }
    }

    public int a(@NonNull String str, int i2) {
        try {
            return this.a.getInt(str, i2);
        } catch (Throwable unused) {
            return i2;
        }
    }

    public long a(@NonNull String str, long j2) {
        try {
            return this.a.getLong(str, j2);
        } catch (Throwable unused) {
            return j2;
        }
    }

    public String a(@NonNull String str, @NonNull String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public void a() {
        try {
            this.a.edit().clear().commit();
        } catch (Throwable unused) {
        }
    }

    public boolean a(@NonNull String str) {
        return a(str, false);
    }

    public boolean a(@NonNull String str, boolean z) {
        try {
            return this.a.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public int b(@NonNull String str) {
        return a(str, -1);
    }

    public String b() {
        return a("any_door_id", (String) null);
    }

    public void b(@NonNull String str, float f2) {
        try {
            this.a.edit().putFloat(str, f2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, int i2) {
        try {
            this.a.edit().putInt(str, i2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, long j2) {
        try {
            this.a.edit().putLong(str, j2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, @NonNull String str2) {
        try {
            this.a.edit().putString(str, str2).apply();
        } catch (Throwable unused) {
        }
    }

    public void b(@NonNull String str, boolean z) {
        try {
            this.a.edit().putBoolean(str, z).apply();
        } catch (Throwable unused) {
        }
    }

    public long c(@NonNull String str) {
        return a(str, -1L);
    }

    public String d(@NonNull String str) {
        try {
            return a(str, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public void e(String str) {
        b("any_door_id", str);
    }

    public void f(@NonNull String str) {
        try {
            this.a.edit().remove(str).apply();
        } catch (Throwable unused) {
        }
    }
}
