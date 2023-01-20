package com.tencent.android.tpush.common;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;

/* loaded from: classes3.dex */
public class h {
    private static volatile h a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f6094c;

    /* renamed from: d  reason: collision with root package name */
    private int f6095d = -1;

    private h(Context context) {
        this.b = false;
        this.f6094c = false;
        this.b = d.a();
        this.f6094c = com.tencent.android.tpush.c.a.a(context);
    }

    public static h a(Context context) {
        if (a == null) {
            synchronized (h.class) {
                if (a == null) {
                    a = new h(context);
                }
            }
        }
        return a;
    }

    public boolean b() {
        if (this.f6095d == -1) {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                String lowerCase = str.trim().toLowerCase();
                if (!"meizu".equals(lowerCase) && !"oppo".equals(lowerCase) && !"xiaomi".equals(lowerCase) && !"vivo".equals(lowerCase) && !"huawei".equals(lowerCase) && !this.b) {
                    this.f6095d = 0;
                } else {
                    this.f6095d = 1;
                }
            }
        }
        return this.f6095d == 1;
    }

    public boolean c() {
        return this.f6094c;
    }

    public boolean a() {
        return this.b;
    }
}
