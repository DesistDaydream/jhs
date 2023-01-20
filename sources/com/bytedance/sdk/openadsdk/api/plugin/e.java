package com.bytedance.sdk.openadsdk.api.plugin;

import android.os.SystemClock;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class e {
    private String a;
    private long b;

    /* renamed from: c  reason: collision with root package name */
    private long f2428c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Long> f2429d = new HashMap();

    private e(String str, long j2) {
        this.a = str;
        this.b = j2;
        this.f2428c = j2;
    }

    public static e a(String str) {
        return new e(str, SystemClock.elapsedRealtime());
    }

    public long b(String str) {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.f2428c;
        this.f2428c = SystemClock.elapsedRealtime();
        this.f2429d.put(str, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public long a() {
        long elapsedRealtime = SystemClock.elapsedRealtime() - this.b;
        this.f2429d.put(this.a, Long.valueOf(elapsedRealtime));
        return elapsedRealtime;
    }

    public void a(JSONObject jSONObject, long j2) {
        if (jSONObject == null) {
            return;
        }
        for (Map.Entry<String, Long> entry : this.f2429d.entrySet()) {
            String key = entry.getKey();
            Long value = entry.getValue();
            if (!TextUtils.isEmpty(key) && value.longValue() > j2) {
                try {
                    jSONObject.put(key, value);
                } catch (JSONException unused) {
                }
            }
        }
    }
}
