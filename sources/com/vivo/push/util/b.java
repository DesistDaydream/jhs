package com.vivo.push.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public class b {
    public Context a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private volatile SharedPreferences f8155c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap<String, String> f8156d = new HashMap<>();

    /* renamed from: e  reason: collision with root package name */
    private HashMap<String, Long> f8157e = new HashMap<>();

    /* renamed from: f  reason: collision with root package name */
    private HashMap<String, Integer> f8158f = new HashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private HashMap<String, Boolean> f8159g = new HashMap<>();

    private List<String> c(String str) {
        Object a;
        String[] split;
        if (this.a == null) {
            p.c("BaseSharePreference", " parsLocalIv error mContext is null ");
            return null;
        }
        ArrayList arrayList = new ArrayList();
        try {
            Context context = this.a;
            a = z.a(context, context.getPackageName(), str);
        } catch (Exception e2) {
            p.c("BaseSharePreference", " parsLocalIv error e =" + e2.getMessage());
            e2.printStackTrace();
        }
        if (a == null) {
            return null;
        }
        String str2 = new String(Base64.decode(a.toString(), 2));
        if (!TextUtils.isEmpty(str2) && (split = str2.split(",#@")) != null && split.length >= 4) {
            for (String str3 : split) {
                arrayList.add(str3.replace(",#@", ""));
            }
            if (arrayList.size() >= 4) {
                return arrayList;
            }
        }
        return null;
    }

    public final void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            this.b = str;
            this.f8155c = context.getSharedPreferences(str, 0);
            this.a = context;
            List<String> c2 = c("local_iv");
            if (c2 != null && c2.size() >= 4) {
                HashMap hashMap = new HashMap();
                hashMap.put("com.vivo.push.secure_sub_iv", c2.get(1));
                hashMap.put("com.vivo.push.secure_sub_key", c2.get(2));
                hashMap.put("com.vivo.push.secure_cache_iv", c2.get(3));
                hashMap.put("com.vivo.push.secure_cache_key", c2.get(0));
                a(hashMap);
                return;
            }
            p.a("BaseSharePreference", " initSecureCode error list is null ");
            return;
        }
        throw new RuntimeException("sharedFileName can't be null");
    }

    public final String b(String str, String str2) {
        String str3 = this.f8156d.get(str);
        if (str3 != null) {
            return str3;
        }
        b();
        if (this.f8155c != null) {
            str3 = this.f8155c.getString(str, str2);
            if (!TextUtils.isEmpty(str3) && !str3.equals(str2)) {
                this.f8156d.put(str, str3);
            }
        }
        return str3;
    }

    public final long b(String str, long j2) {
        Long l2 = this.f8157e.get(str);
        if (l2 != null) {
            return l2.longValue();
        }
        b();
        if (this.f8155c != null) {
            l2 = Long.valueOf(this.f8155c.getLong(str, j2));
            if (!l2.equals(Long.valueOf(j2))) {
                this.f8157e.put(str, l2);
            }
        }
        return l2.longValue();
    }

    public final void a(String str, String str2) {
        this.f8156d.put(str, str2);
        b();
        if (this.f8155c != null) {
            SharedPreferences.Editor edit = this.f8155c.edit();
            edit.putString(str, str2);
            a(edit);
        }
    }

    public final void b(String str) {
        this.f8157e.remove(str);
        this.f8158f.remove(str);
        this.f8159g.remove(str);
        this.f8156d.remove(str);
        b();
        if (this.f8155c != null) {
            SharedPreferences.Editor edit = this.f8155c.edit();
            if (this.f8155c.contains(str)) {
                edit.remove(str);
                a(edit);
            }
        }
    }

    private void a(Map<String, String> map) {
        if (map.size() > 0) {
            b();
            if (this.f8155c != null) {
                SharedPreferences.Editor edit = this.f8155c.edit();
                for (String str : map.keySet()) {
                    String str2 = map.get(str);
                    this.f8156d.put(str, str2);
                    edit.putString(str, str2);
                }
                a(edit);
            }
        }
    }

    private void b() {
        if (this.f8155c == null) {
            Context context = this.a;
            if (context != null) {
                this.f8155c = context.getSharedPreferences(this.b, 0);
                return;
            }
            throw new RuntimeException("SharedPreferences is not init", new Throwable());
        }
    }

    public final void a(String str, int i2) {
        this.f8158f.put(str, Integer.valueOf(i2));
        b();
        if (this.f8155c != null) {
            SharedPreferences.Editor edit = this.f8155c.edit();
            edit.putInt(str, i2);
            a(edit);
        }
    }

    public final void a(String str, long j2) {
        this.f8157e.put(str, Long.valueOf(j2));
        b();
        if (this.f8155c != null) {
            SharedPreferences.Editor edit = this.f8155c.edit();
            edit.putLong(str, j2);
            a(edit);
        }
    }

    public final int a(String str) {
        Integer num = this.f8158f.get(str);
        if (num != null) {
            return num.intValue();
        }
        b();
        if (this.f8155c != null) {
            num = Integer.valueOf(this.f8155c.getInt(str, 0));
            if (!num.equals(0)) {
                this.f8158f.put(str, num);
            }
        }
        return num.intValue();
    }

    public static void a(SharedPreferences.Editor editor) {
        if (editor == null) {
            return;
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            editor.apply();
        } else {
            editor.commit();
        }
    }

    public final void a() {
        this.f8157e.clear();
        this.f8158f.clear();
        this.f8159g.clear();
        this.f8156d.clear();
        b();
        if (this.f8155c != null) {
            SharedPreferences.Editor edit = this.f8155c.edit();
            edit.clear();
            a(edit);
        }
    }
}
