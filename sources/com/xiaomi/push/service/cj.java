package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Base64;
import com.xiaomi.push.hh;
import com.xiaomi.push.hn;
import com.xiaomi.push.hs;
import com.xiaomi.push.ib;
import com.xiaomi.push.ih;

/* loaded from: classes3.dex */
public class cj {
    public static hs a(hn hnVar) {
        byte[] f2 = hnVar.f();
        hs hsVar = new hs();
        try {
            ib.a(hsVar, f2);
            return hsVar;
        } catch (ih unused) {
            return null;
        }
    }

    public static void a(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("ext_fcm_container_buffer");
        String stringExtra2 = intent.getStringExtra("mipush_app_package");
        if (TextUtils.isEmpty(stringExtra) || TextUtils.isEmpty(stringExtra2)) {
            return;
        }
        try {
            byte[] b = b(Base64.decode(stringExtra, 2), context.getSharedPreferences("mipush_apps_scrt", 0).getString(stringExtra2, null));
            if (b != null) {
                n.a(context, cu.a(b), b);
            } else {
                com.xiaomi.a.a.a.c.a("notify fcm notification error ：dencrypt failed");
            }
        } catch (Throwable th) {
            com.xiaomi.a.a.a.c.a("notify fcm notification error ", th);
        }
    }

    public static void a(Context context, String str, String str2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        context.getSharedPreferences("mipush_apps_scrt", 0).edit().putString(str, str2).apply();
    }

    public static byte[] a(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("secret is empty, return null");
            return null;
        }
        try {
            return hh.b(com.xiaomi.push.ao.b(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("encryption error. ", e2);
            return null;
        }
    }

    public static byte[] b(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("secret is empty, return null");
            return null;
        }
        try {
            return hh.a(com.xiaomi.push.ao.b(str), bArr);
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a("dencryption error. ", e2);
            return null;
        }
    }
}
