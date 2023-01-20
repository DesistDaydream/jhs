package com.ss.android.socialbase.downloader.g;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.c;
import com.ss.android.socialbase.downloader.i.h;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {
    private static final h<Integer, a> a = new h<>(16, 16);
    private static final a b = new a(null);

    /* renamed from: c  reason: collision with root package name */
    private static JSONObject f5705c;

    /* renamed from: d  reason: collision with root package name */
    private static JSONObject f5706d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f5707e;

    /* renamed from: f  reason: collision with root package name */
    private static boolean f5708f;

    /* renamed from: g  reason: collision with root package name */
    private static a f5709g;

    /* renamed from: h  reason: collision with root package name */
    private final JSONObject f5710h;

    /* renamed from: i  reason: collision with root package name */
    private final JSONObject f5711i;

    /* renamed from: j  reason: collision with root package name */
    private final Boolean f5712j;

    /* renamed from: k  reason: collision with root package name */
    private int f5713k;

    static {
        a();
    }

    private a(JSONObject jSONObject) {
        Boolean bool;
        this.f5710h = jSONObject;
        JSONObject jSONObject2 = null;
        r0 = null;
        r0 = null;
        Boolean bool2 = null;
        if (jSONObject == null || f("bugfix")) {
            bool = null;
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("bugfix");
            if (optJSONObject != null && optJSONObject.has("default") && !f("default")) {
                bool2 = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
            }
            Boolean bool3 = bool2;
            jSONObject2 = optJSONObject;
            bool = bool3;
        }
        this.f5711i = jSONObject2;
        this.f5712j = bool;
    }

    public static void a() {
        JSONObject E = c.E();
        f5708f = E.optInt("disable_task_setting", 0) == 1;
        f5705c = E.optJSONObject("disabled_task_keys");
        JSONObject optJSONObject = E.optJSONObject("bugfix");
        Boolean bool = null;
        if (optJSONObject != null && optJSONObject.has("default")) {
            bool = Boolean.valueOf(optJSONObject.optInt("default", 0) == 1);
        }
        f5706d = optJSONObject;
        f5707e = bool;
    }

    @NonNull
    public static JSONObject b() {
        return c.E();
    }

    @NonNull
    public static a c() {
        return b;
    }

    public static boolean f(String str) {
        JSONObject jSONObject = f5705c;
        return jSONObject != null && jSONObject.optInt(str, 0) == 1;
    }

    public JSONObject d(String str) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optJSONObject(str);
        }
        return b().optJSONObject(str);
    }

    public JSONArray e(String str) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optJSONArray(str);
        }
        return b().optJSONArray(str);
    }

    public boolean b(String str, boolean z) {
        if (this.f5711i != null && !f(str)) {
            if (this.f5711i.has(str)) {
                return this.f5711i.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool = this.f5712j;
            if (bool != null) {
                return bool.booleanValue();
            }
        }
        JSONObject jSONObject = f5706d;
        if (jSONObject != null) {
            if (jSONObject.has(str)) {
                return f5706d.optInt(str, z ? 1 : 0) == 1;
            }
            Boolean bool2 = f5707e;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
        }
        return z;
    }

    public String c(String str) {
        return a(str, "");
    }

    private static a c(int i2) {
        DownloadInfo downloadInfo;
        if (f5708f) {
            return b;
        }
        Context N = c.N();
        if (N != null && (downloadInfo = Downloader.getInstance(N).getDownloadInfo(i2)) != null) {
            return b(downloadInfo);
        }
        return b;
    }

    public static void a(String str, boolean z) {
        try {
            if (f5706d == null) {
                f5706d = new JSONObject();
            }
            f5706d.put(str, z ? 1 : 0);
        } catch (JSONException unused) {
        }
    }

    @NonNull
    public static a a(int i2) {
        return a(i2, (DownloadInfo) null);
    }

    public int b(String str) {
        return a(str, 0);
    }

    @NonNull
    public static a a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return b;
        }
        return a(downloadInfo.getId(), downloadInfo);
    }

    public static void b(int i2) {
        a aVar = f5709g;
        if (aVar != null && aVar.f5713k == i2) {
            f5709g = null;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            hVar.remove(Integer.valueOf(i2));
        }
    }

    private static a a(int i2, DownloadInfo downloadInfo) {
        a aVar;
        a aVar2 = f5709g;
        if (aVar2 == null || aVar2.f5713k != i2) {
            h<Integer, a> hVar = a;
            synchronized (hVar) {
                aVar = hVar.get(Integer.valueOf(i2));
            }
            if (aVar == null) {
                aVar = downloadInfo == null ? c(i2) : b(downloadInfo);
                synchronized (hVar) {
                    hVar.put(Integer.valueOf(i2), aVar);
                }
            }
            aVar.f5713k = i2;
            f5709g = aVar;
            return aVar;
        }
        return aVar2;
    }

    private static a b(DownloadInfo downloadInfo) {
        if (f5708f) {
            return b;
        }
        try {
            String downloadSettingString = downloadInfo.getDownloadSettingString();
            if (!TextUtils.isEmpty(downloadSettingString)) {
                return new a(new JSONObject(downloadSettingString));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return b;
    }

    public boolean a(String str) {
        return b(str, false);
    }

    public int a(String str, int i2) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optInt(str, i2);
        }
        return b().optInt(str, i2);
    }

    public long a(String str, long j2) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optLong(str, j2);
        }
        return b().optLong(str, j2);
    }

    public double a(String str, double d2) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optDouble(str, d2);
        }
        return b().optDouble(str, d2);
    }

    public String a(String str, String str2) {
        JSONObject jSONObject = this.f5710h;
        if (jSONObject != null && jSONObject.has(str) && !f(str)) {
            return this.f5710h.optString(str, str2);
        }
        return b().optString(str, str2);
    }

    @NonNull
    public static a a(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject != b() && !f5708f) {
            a aVar = f5709g;
            if (aVar == null || aVar.f5710h != jSONObject) {
                h<Integer, a> hVar = a;
                synchronized (hVar) {
                    for (a aVar2 : hVar.values()) {
                        if (aVar2.f5710h == jSONObject) {
                            f5709g = aVar2;
                            return aVar2;
                        }
                    }
                    a aVar3 = new a(jSONObject);
                    f5709g = aVar3;
                    return aVar3;
                }
            }
            return aVar;
        }
        return b;
    }

    public static void a(int i2, JSONObject jSONObject) {
        if (jSONObject == null || jSONObject == b() || f5708f) {
            return;
        }
        h<Integer, a> hVar = a;
        synchronized (hVar) {
            a aVar = f5709g;
            if (aVar != null && aVar.f5710h == jSONObject) {
                aVar.f5713k = i2;
            } else {
                aVar = null;
                Iterator<a> it = hVar.values().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    a next = it.next();
                    if (next.f5710h == jSONObject) {
                        next.f5713k = i2;
                        aVar = next;
                        break;
                    }
                }
                if (aVar == null) {
                    aVar = new a(jSONObject);
                    aVar.f5713k = i2;
                }
                f5709g = aVar;
            }
            a.put(Integer.valueOf(i2), aVar);
        }
    }
}
