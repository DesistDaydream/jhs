package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.ak;
import com.effective.android.panel.Constants;
import dalvik.system.DexClassLoader;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;

/* loaded from: classes.dex */
public class d {
    private static volatile d a;

    private d() {
    }

    public static d a() {
        if (a == null) {
            synchronized (d.class) {
                if (a == null) {
                    a = new d();
                }
            }
        }
        return a;
    }

    public void a(double d2, ak.b bVar) {
        cg a2 = cg.a();
        String c2 = a2.c(v.a);
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("v", "" + d2);
        hashMap.put(com.umeng.analytics.pro.am.x, Constants.ANDROID);
        hashMap.put("tp", a(bc.a((Context) null).d()));
        hashMap.put("bdr", a(bc.a((Context) null).b()));
        ak akVar = new ak(a2.a(c2, hashMap));
        akVar.a(bVar);
        akVar.b();
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException | NullPointerException unused) {
            return str;
        }
    }

    public DexClassLoader a(String str, String str2, String str3, ClassLoader classLoader) {
        return new DexClassLoader(str, str2, str3, classLoader);
    }
}
