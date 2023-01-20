package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes3.dex */
public class gn {
    private static volatile gn a;
    private final Context b;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, go> f8678c = new HashMap();

    private gn(Context context) {
        this.b = context;
    }

    public static gn a(Context context) {
        if (context == null) {
            com.xiaomi.a.a.a.c.d("[TinyDataManager]:mContext is null, TinyDataManager.getInstance(Context) failed.");
            return null;
        }
        if (a == null) {
            synchronized (gn.class) {
                if (a == null) {
                    a = new gn(context);
                }
            }
        }
        return a;
    }

    private boolean a(String str, String str2, String str3, String str4, long j2, String str5) {
        gu guVar = new gu();
        guVar.d(str3);
        guVar.c(str4);
        guVar.a(j2);
        guVar.b(str5);
        guVar.c(true);
        guVar.a("push_sdk_channel");
        guVar.e(str2);
        return a(guVar, str);
    }

    public go a() {
        go goVar = this.f8678c.get("UPLOADER_PUSH_CHANNEL");
        if (goVar != null) {
            return goVar;
        }
        go goVar2 = this.f8678c.get("UPLOADER_HTTP");
        if (goVar2 != null) {
            return goVar2;
        }
        return null;
    }

    public void a(go goVar, String str) {
        if (goVar == null) {
            com.xiaomi.a.a.a.c.d("[TinyDataManager]: please do not add null mUploader to TinyDataManager.");
        } else if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.d("[TinyDataManager]: can not add a provider from unkown resource.");
        } else {
            b().put(str, goVar);
        }
    }

    public boolean a(gu guVar, String str) {
        if (TextUtils.isEmpty(str)) {
            com.xiaomi.a.a.a.c.a("pkgName is null or empty, upload ClientUploadDataItem failed.");
            return false;
        } else if (com.xiaomi.push.service.bc.a(guVar, false)) {
            return false;
        } else {
            if (TextUtils.isEmpty(guVar.m())) {
                guVar.f(com.xiaomi.push.service.bc.a());
            }
            guVar.g(str);
            com.xiaomi.push.service.be.a(this.b, guVar);
            return true;
        }
    }

    public boolean a(String str, String str2, long j2, String str3) {
        return a(this.b.getPackageName(), this.b.getPackageName(), str, str2, j2, str3);
    }

    public Map<String, go> b() {
        return this.f8678c;
    }
}
