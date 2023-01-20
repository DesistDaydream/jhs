package com.xiaomi.push;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.m;

/* loaded from: classes3.dex */
public class cv {
    private static volatile cv a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private a f8356c;

    /* loaded from: classes3.dex */
    public interface a {
        void a();
    }

    private cv(Context context) {
        this.b = context;
    }

    public static int a(int i2) {
        return Math.max(60, i2);
    }

    public static cv a(Context context) {
        if (a == null) {
            synchronized (cv.class) {
                if (a == null) {
                    a = new cv(context);
                }
            }
        }
        return a;
    }

    private void a(com.xiaomi.push.service.ad adVar, m mVar, boolean z) {
        if (adVar.a(gv.UploadSwitch.a(), true)) {
            cz czVar = new cz(this.b);
            if (z) {
                mVar.a((m.a) czVar, a(adVar.a(gv.UploadFrequency.a(), RemoteMessageConst.DEFAULT_TTL)));
            } else {
                mVar.a((m.a) czVar);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b() {
        a aVar;
        m a2 = m.a(this.b);
        com.xiaomi.push.service.ad a3 = com.xiaomi.push.service.ad.a(this.b);
        SharedPreferences sharedPreferences = this.b.getSharedPreferences("mipush_extra", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = sharedPreferences.getLong("first_try_ts", currentTimeMillis);
        if (j2 == currentTimeMillis) {
            sharedPreferences.edit().putLong("first_try_ts", currentTimeMillis).commit();
        }
        if (Math.abs(currentTimeMillis - j2) < com.baidu.mobads.sdk.internal.bc.f1470e) {
            return;
        }
        a(a3, a2, false);
        if (a3.a(gv.StorageCollectionSwitch.a(), true)) {
            int a4 = a(a3.a(gv.StorageCollectionFrequency.a(), RemoteMessageConst.DEFAULT_TTL));
            a2.a(new cy(this.b, a4), a4, 0);
        }
        if (jc.a(this.b) && (aVar = this.f8356c) != null) {
            aVar.a();
        }
        if (a3.a(gv.ActivityTSSwitch.a(), false)) {
            c();
        }
        a(a3, a2, true);
    }

    private boolean c() {
        try {
            Context context = this.b;
            if (!(context instanceof Application)) {
                context = context.getApplicationContext();
            }
            ((Application) context).registerActivityLifecycleCallbacks(new cp(this.b, String.valueOf(System.currentTimeMillis() / 1000)));
            return true;
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
            return false;
        }
    }

    public void a() {
        m.a(this.b).a(new cw(this));
    }
}
