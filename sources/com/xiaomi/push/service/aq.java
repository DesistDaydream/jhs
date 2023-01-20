package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.provider.Settings;

/* loaded from: classes3.dex */
public class aq {
    private static aq a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private int f9103c = 0;

    private aq(Context context) {
        this.b = context.getApplicationContext();
    }

    public static aq a(Context context) {
        if (a == null) {
            a = new aq(context);
        }
        return a;
    }

    public boolean a() {
        String str = com.xiaomi.push.f.a;
        return str.contains("xmsf") || str.contains("xiaomi") || str.contains("miui");
    }

    @SuppressLint({"NewApi"})
    public int b() {
        int i2 = this.f9103c;
        if (i2 != 0) {
            return i2;
        }
        try {
            this.f9103c = Settings.Global.getInt(this.b.getContentResolver(), "device_provisioned", 0);
        } catch (Exception unused) {
        }
        return this.f9103c;
    }

    @SuppressLint({"NewApi"})
    public Uri c() {
        return Settings.Global.getUriFor("device_provisioned");
    }
}
