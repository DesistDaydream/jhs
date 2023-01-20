package com.xiaomi.push;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class jh {
    private static volatile jh a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private Handler f9019c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    private Map<String, Map<String, String>> f9020d = new HashMap();

    private jh(Context context) {
        this.b = context;
    }

    public static jh a(Context context) {
        if (a == null) {
            synchronized (jh.class) {
                if (a == null) {
                    a = new jh(context);
                }
            }
        }
        return a;
    }

    private synchronized String a(String str, String str2) {
        if (this.f9020d != null && !TextUtils.isEmpty(str)) {
            if (!TextUtils.isEmpty(str2)) {
                try {
                    Map<String, String> map = this.f9020d.get(str);
                    if (map != null) {
                        return map.get(str2);
                    }
                    return "";
                } catch (Throwable unused) {
                    return "";
                }
            }
        }
        return "";
    }

    private synchronized void c(String str, String str2, String str3) {
        if (this.f9020d == null) {
            this.f9020d = new HashMap();
        }
        Map<String, String> map = this.f9020d.get(str);
        if (map == null) {
            map = new HashMap<>();
        }
        map.put(str2, str3);
        this.f9020d.put(str, map);
    }

    public synchronized void a(String str, String str2, String str3) {
        c(str, str2, str3);
        this.f9019c.post(new ji(this, str, str2, str3));
    }

    public synchronized String b(String str, String str2, String str3) {
        String a2 = a(str, str2);
        if (TextUtils.isEmpty(a2)) {
            return this.b.getSharedPreferences(str, 4).getString(str2, str3);
        }
        return a2;
    }
}
