package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.ge;
import com.xiaomi.push.jc;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class a {
    private static a a;

    /* renamed from: e  reason: collision with root package name */
    private static String f9052e;

    /* renamed from: f  reason: collision with root package name */
    private static String f9053f = ge.a(5) + Constants.ACCEPT_TIME_SEPARATOR_SERVER;

    /* renamed from: g  reason: collision with root package name */
    private static long f9054g = 0;
    private Context b;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9056d;

    /* renamed from: j  reason: collision with root package name */
    private Messenger f9059j;

    /* renamed from: c  reason: collision with root package name */
    private Messenger f9055c = null;

    /* renamed from: h  reason: collision with root package name */
    private List<Message> f9057h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private boolean f9058i = false;

    private a(Context context) {
        this.f9056d = false;
        this.b = context.getApplicationContext();
        if (a()) {
            com.xiaomi.a.a.a.c.c("use miui push service");
            this.f9056d = true;
        }
    }

    public static a a(Context context) {
        if (a == null) {
            a = new a(context);
        }
        return a;
    }

    private boolean a() {
        if (com.xiaomi.push.f.f8567f) {
            return false;
        }
        try {
            PackageInfo packageInfo = this.b.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 104;
        } catch (Exception unused) {
            return false;
        }
    }

    private synchronized void b(Intent intent) {
        if (this.f9058i) {
            Message c2 = c(intent);
            if (this.f9057h.size() >= 50) {
                this.f9057h.remove(0);
            }
            this.f9057h.add(c2);
            return;
        }
        if (this.f9059j == null) {
            this.b.bindService(intent, new ax(this), 1);
            this.f9058i = true;
            this.f9057h.clear();
            this.f9057h.add(c(intent));
        } else {
            try {
                this.f9059j.send(c(intent));
            } catch (RemoteException unused) {
                this.f9059j = null;
                this.f9058i = false;
            }
        }
    }

    private Message c(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public boolean a(Intent intent) {
        try {
            if (jc.a() || Build.VERSION.SDK_INT < 26) {
                this.b.startService(intent);
                return true;
            }
            b(intent);
            return true;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return false;
        }
    }
}
