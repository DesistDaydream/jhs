package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.push.gg;
import com.xiaomi.push.ii;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class b {
    private static volatile b a;

    /* renamed from: a  reason: collision with other field name */
    private Context f38a;

    /* renamed from: a  reason: collision with other field name */
    private a f39a;

    /* renamed from: a  reason: collision with other field name */
    public String f40a;

    /* renamed from: a  reason: collision with other field name */
    private Map<String, a> f41a;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with other field name */
        private Context f42a;

        /* renamed from: a  reason: collision with other field name */
        public String f43a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f8227c;

        /* renamed from: d  reason: collision with root package name */
        public String f8228d;

        /* renamed from: e  reason: collision with root package name */
        public String f8229e;

        /* renamed from: f  reason: collision with root package name */
        public String f8230f;

        /* renamed from: g  reason: collision with root package name */
        public String f8231g;

        /* renamed from: h  reason: collision with root package name */
        public String f8232h;

        /* renamed from: a  reason: collision with other field name */
        public boolean f44a = true;

        /* renamed from: b  reason: collision with other field name */
        public boolean f45b = false;
        public int a = 1;

        public a(Context context) {
            this.f42a = context;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f43a = jSONObject.getString("appId");
                aVar.b = jSONObject.getString("appToken");
                aVar.f8227c = jSONObject.getString("regId");
                aVar.f8228d = jSONObject.getString("regSec");
                aVar.f8230f = jSONObject.getString("devId");
                aVar.f8229e = jSONObject.getString("vName");
                aVar.f44a = jSONObject.getBoolean("valid");
                aVar.f45b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.f8231g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.a.a.a.c.a(th);
                return null;
            }
        }

        private String a() {
            Context context = this.f42a;
            return gg.a(context, context.getPackageName());
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f43a);
                jSONObject.put("appToken", aVar.b);
                jSONObject.put("regId", aVar.f8227c);
                jSONObject.put("regSec", aVar.f8228d);
                jSONObject.put("devId", aVar.f8230f);
                jSONObject.put("vName", aVar.f8229e);
                jSONObject.put("valid", aVar.f44a);
                jSONObject.put("paused", aVar.f45b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.f8231g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.a.a.a.c.a(th);
                return null;
            }
        }

        /* renamed from: a  reason: collision with other method in class */
        public void m87a() {
            b.a(this.f42a).edit().clear().commit();
            this.f43a = null;
            this.b = null;
            this.f8227c = null;
            this.f8228d = null;
            this.f8230f = null;
            this.f8229e = null;
            this.f44a = false;
            this.f45b = false;
            this.f8232h = null;
            this.a = 1;
        }

        public void a(int i2) {
            this.a = i2;
        }

        public void a(String str, String str2) {
            this.f8227c = str;
            this.f8228d = str2;
            this.f8230f = ii.j(this.f42a);
            this.f8229e = a();
            this.f44a = true;
        }

        public void a(String str, String str2, String str3) {
            this.f43a = str;
            this.b = str2;
            this.f8231g = str3;
            SharedPreferences.Editor edit = b.a(this.f42a).edit();
            edit.putString("appId", this.f43a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        public void a(boolean z) {
            this.f45b = z;
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m88a() {
            return m89a(this.f43a, this.b);
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m89a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f43a, str);
            boolean equals2 = TextUtils.equals(this.b, str2);
            boolean z = !TextUtils.isEmpty(this.f8227c);
            boolean z2 = !TextUtils.isEmpty(this.f8228d);
            boolean z3 = TextUtils.equals(this.f8230f, ii.j(this.f42a)) || TextUtils.equals(this.f8230f, ii.i(this.f42a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.a.a.a.c.f(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f44a = false;
            b.a(this.f42a).edit().putBoolean("valid", this.f44a).commit();
        }

        public void b(String str, String str2, String str3) {
            this.f8227c = str;
            this.f8228d = str2;
            this.f8230f = ii.j(this.f42a);
            this.f8229e = a();
            this.f44a = true;
            this.f8232h = str3;
            SharedPreferences.Editor edit = b.a(this.f42a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f8230f);
            edit.putString("vName", a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f43a = str;
            this.b = str2;
            this.f8231g = str3;
        }
    }

    private b(Context context) {
        this.f38a = context;
        c();
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public static b m74a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f39a = new a(this.f38a);
        this.f41a = new HashMap();
        SharedPreferences a2 = a(this.f38a);
        this.f39a.f43a = a2.getString("appId", null);
        this.f39a.b = a2.getString("appToken", null);
        this.f39a.f8227c = a2.getString("regId", null);
        this.f39a.f8228d = a2.getString("regSec", null);
        this.f39a.f8230f = a2.getString("devId", null);
        if (!TextUtils.isEmpty(this.f39a.f8230f) && ii.a(this.f39a.f8230f)) {
            this.f39a.f8230f = ii.j(this.f38a);
            a2.edit().putString("devId", this.f39a.f8230f).commit();
        }
        this.f39a.f8229e = a2.getString("vName", null);
        this.f39a.f44a = a2.getBoolean("valid", true);
        this.f39a.f45b = a2.getBoolean("paused", false);
        this.f39a.a = a2.getInt("envType", 1);
        this.f39a.f8231g = a2.getString("regResource", null);
        this.f39a.f8232h = a2.getString("appRegion", null);
    }

    public int a() {
        return this.f39a.a;
    }

    public a a(String str) {
        if (this.f41a.containsKey(str)) {
            return this.f41a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences a2 = a(this.f38a);
        if (a2.contains(str2)) {
            a a3 = a.a(this.f38a, a2.getString(str2, ""));
            this.f41a.put(str2, a3);
            return a3;
        }
        return null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m75a() {
        return this.f39a.f43a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m76a() {
        this.f39a.m87a();
    }

    public void a(int i2) {
        this.f39a.a(i2);
        a(this.f38a).edit().putInt("envType", i2).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m77a(String str) {
        SharedPreferences.Editor edit = a(this.f38a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f39a.f8229e = str;
    }

    public void a(String str, a aVar) {
        this.f41a.put(str, aVar);
        String a2 = a.a(aVar);
        a(this.f38a).edit().putString("hybrid_app_info_" + str, a2).commit();
    }

    public void a(String str, String str2, String str3) {
        this.f39a.a(str, str2, str3);
    }

    public void a(boolean z) {
        this.f39a.a(z);
        a(this.f38a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m78a() {
        Context context = this.f38a;
        return !TextUtils.equals(gg.a(context, context.getPackageName()), this.f39a.f8229e);
    }

    public boolean a(String str, String str2) {
        return this.f39a.m89a(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m79a(String str, String str2, String str3) {
        a a2 = a(str3);
        return a2 != null && TextUtils.equals(str, a2.f43a) && TextUtils.equals(str2, a2.b);
    }

    public String b() {
        return this.f39a.b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m80b() {
        this.f39a.b();
    }

    public void b(String str) {
        this.f41a.remove(str);
        a(this.f38a).edit().remove("hybrid_app_info_" + str).commit();
    }

    public void b(String str, String str2, String str3) {
        this.f39a.b(str, str2, str3);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m81b() {
        if (this.f39a.m88a()) {
            return true;
        }
        com.xiaomi.a.a.a.c.a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m82c() {
        return this.f39a.f8227c;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m83c() {
        return this.f39a.m88a();
    }

    public String d() {
        return this.f39a.f8228d;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m84d() {
        return (TextUtils.isEmpty(this.f39a.f43a) || TextUtils.isEmpty(this.f39a.b) || TextUtils.isEmpty(this.f39a.f8227c) || TextUtils.isEmpty(this.f39a.f8228d)) ? false : true;
    }

    public String e() {
        return this.f39a.f8231g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m85e() {
        return this.f39a.f45b;
    }

    public String f() {
        return this.f39a.f8232h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m86f() {
        return !this.f39a.f44a;
    }
}
