package com.xiaomi.mipush.sdk;

import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.push.cf;
import com.xiaomi.push.dt;
import com.xiaomi.push.gq;
import com.xiaomi.push.gr;
import com.xiaomi.push.gu;
import com.xiaomi.push.gv;
import com.xiaomi.push.ha;
import com.xiaomi.push.hd;
import com.xiaomi.push.hn;
import com.xiaomi.push.hq;
import com.xiaomi.push.hr;
import com.xiaomi.push.hx;
import com.xiaomi.push.ib;
import com.xiaomi.push.ic;
import com.xiaomi.push.jc;
import com.xiaomi.push.service.ce;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public class ao {
    private static ao a = null;

    /* renamed from: a */
    private static final ArrayList<a> f24a = new ArrayList<>();
    private static boolean b = false;

    /* renamed from: a */
    private long f25a;

    /* renamed from: a */
    private Context f26a;

    /* renamed from: a */
    private Handler f28a;

    /* renamed from: a */
    private Messenger f29a;

    /* renamed from: a */
    private boolean f33a;

    /* renamed from: a */
    private List<Message> f32a = new ArrayList();

    /* renamed from: c */
    private boolean f8222c = false;

    /* renamed from: a */
    private Intent f27a = null;

    /* renamed from: a */
    private Integer f30a = null;

    /* renamed from: a */
    private String f31a = null;

    /* loaded from: classes3.dex */
    public static class a<T extends ic<T, ?>> {
        public gq a;

        /* renamed from: a */
        public T f34a;

        /* renamed from: a */
        public boolean f35a;
    }

    private ao(Context context) {
        this.f33a = false;
        this.f28a = null;
        this.f26a = context.getApplicationContext();
        this.f33a = m61c();
        b = m62d();
        this.f28a = new ap(this, Looper.getMainLooper());
        if (jc.a(context)) {
            ce.a(new aq(this));
        }
        Intent b2 = b();
        if (b2 != null) {
            b(b2);
        }
    }

    private synchronized int a() {
        return this.f26a.getSharedPreferences("mipush_extra", 0).getInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, -1);
    }

    /* renamed from: a */
    private Intent m56a() {
        return (!m67a() || "com.xiaomi.xmsf".equals(this.f26a.getPackageName())) ? e() : d();
    }

    private Message a(Intent intent) {
        Message obtain = Message.obtain();
        obtain.what = 17;
        obtain.obj = intent;
        return obtain;
    }

    public static synchronized ao a(Context context) {
        ao aoVar;
        synchronized (ao.class) {
            if (a == null) {
                a = new ao(context);
            }
            aoVar = a;
        }
        return aoVar;
    }

    /* renamed from: a */
    private String m59a() {
        try {
            return this.f26a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 106 ? "com.xiaomi.push.service.XMPushService" : "com.xiaomi.xmsf.push.service.XMPushService";
        } catch (Exception unused) {
            return "com.xiaomi.xmsf.push.service.XMPushService";
        }
    }

    public void a(String str, au auVar, boolean z, HashMap<String, String> hashMap) {
        hq hqVar;
        String str2;
        if (b.m74a(this.f26a).m81b() && com.xiaomi.push.al.c(this.f26a)) {
            hq hqVar2 = new hq();
            hqVar2.a(true);
            Intent m56a = m56a();
            if (TextUtils.isEmpty(str)) {
                str = com.xiaomi.push.service.ag.a();
                hqVar2.a(str);
                hqVar = z ? new hq(str, true) : null;
                synchronized (af.class) {
                    af.a(this.f26a).m52a(str);
                }
            } else {
                hqVar2.a(str);
                hqVar = z ? new hq(str, true) : null;
            }
            switch (at.a[auVar.ordinal()]) {
                case 1:
                    ha haVar = ha.DisablePushMessage;
                    hqVar2.c(haVar.ah);
                    hqVar.c(haVar.ah);
                    if (hashMap != null) {
                        hqVar2.a(hashMap);
                        hqVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.DISABLE_PUSH_MESSAGE";
                    m56a.setAction(str2);
                    break;
                case 2:
                    ha haVar2 = ha.EnablePushMessage;
                    hqVar2.c(haVar2.ah);
                    hqVar.c(haVar2.ah);
                    if (hashMap != null) {
                        hqVar2.a(hashMap);
                        hqVar.a(hashMap);
                    }
                    str2 = "com.xiaomi.mipush.ENABLE_PUSH_MESSAGE";
                    m56a.setAction(str2);
                    break;
                case 3:
                case 4:
                case 5:
                case 6:
                    hqVar2.c(ha.ThirdPartyRegUpdate.ah);
                    if (hashMap != null) {
                        hqVar2.a(hashMap);
                        break;
                    }
                    break;
            }
            com.xiaomi.a.a.a.c.f("type:" + auVar + ", " + str);
            hqVar2.b(b.m74a(this.f26a).m75a());
            hqVar2.d(this.f26a.getPackageName());
            gq gqVar = gq.Notification;
            a((ao) hqVar2, gqVar, false, (hd) null);
            if (z) {
                hqVar.b(b.m74a(this.f26a).m75a());
                hqVar.d(this.f26a.getPackageName());
                Context context = this.f26a;
                byte[] a2 = ib.a(ai.a(context, hqVar, gqVar, false, context.getPackageName(), b.m74a(this.f26a).m75a()));
                if (a2 != null) {
                    cf.a(this.f26a.getPackageName(), this.f26a, hqVar, gqVar, a2.length);
                    m56a.putExtra("mipush_payload", a2);
                    m56a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", true);
                    m56a.putExtra("mipush_app_id", b.m74a(this.f26a).m75a());
                    m56a.putExtra("mipush_app_token", b.m74a(this.f26a).b());
                    c(m56a);
                }
            }
            Message obtain = Message.obtain();
            obtain.what = 19;
            int ordinal = auVar.ordinal();
            obtain.obj = str;
            obtain.arg1 = ordinal;
            this.f28a.sendMessageDelayed(obtain, 5000L);
        }
    }

    private Intent b() {
        if ("com.xiaomi.xmsf".equals(this.f26a.getPackageName())) {
            com.xiaomi.a.a.a.c.c("pushChannel xmsf create own channel");
            return e();
        }
        return c();
    }

    private void b(Intent intent) {
        try {
            if (jc.a() || Build.VERSION.SDK_INT < 26) {
                this.f26a.startService(intent);
            } else {
                d(intent);
            }
        } catch (Exception e2) {
            com.xiaomi.a.a.a.c.a(e2);
        }
    }

    private Intent c() {
        if (m67a()) {
            com.xiaomi.a.a.a.c.c("pushChannel app start miui china channel");
            return d();
        }
        com.xiaomi.a.a.a.c.c("pushChannel app start  own channel");
        return e();
    }

    private synchronized void c(int i2) {
        this.f26a.getSharedPreferences("mipush_extra", 0).edit().putInt(Constants.EXTRA_KEY_BOOT_SERVICE_MODE, i2).commit();
    }

    private void c(Intent intent) {
        com.xiaomi.push.service.ad a2 = com.xiaomi.push.service.ad.a(this.f26a);
        int a3 = gv.ServiceBootMode.a();
        gr grVar = gr.START;
        int a4 = a2.a(a3, grVar.a());
        int a5 = a();
        gr grVar2 = gr.BIND;
        boolean z = a4 == grVar2.a() && b;
        int a6 = z ? grVar2.a() : grVar.a();
        if (a6 != a5) {
            m68a(a6);
        }
        if (z) {
            d(intent);
        } else {
            b(intent);
        }
    }

    /* renamed from: c */
    private boolean m61c() {
        try {
            PackageInfo packageInfo = this.f26a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4);
            if (packageInfo == null) {
                return false;
            }
            return packageInfo.versionCode >= 105;
        } catch (Throwable unused) {
            return false;
        }
    }

    private Intent d() {
        Intent intent = new Intent();
        String packageName = this.f26a.getPackageName();
        intent.setPackage("com.xiaomi.xmsf");
        intent.setClassName("com.xiaomi.xmsf", m59a());
        intent.putExtra("mipush_app_package", packageName);
        h();
        return intent;
    }

    private synchronized void d(Intent intent) {
        if (this.f8222c) {
            Message a2 = a(intent);
            if (this.f32a.size() >= 50) {
                this.f32a.remove(0);
            }
            this.f32a.add(a2);
            return;
        }
        if (this.f29a == null) {
            this.f26a.bindService(intent, new as(this), 1);
            this.f8222c = true;
            this.f32a.clear();
            this.f32a.add(a(intent));
        } else {
            try {
                this.f29a.send(a(intent));
            } catch (RemoteException unused) {
                this.f29a = null;
                this.f8222c = false;
            }
        }
    }

    /* renamed from: d */
    private boolean m62d() {
        if (m67a()) {
            try {
                return this.f26a.getPackageManager().getPackageInfo("com.xiaomi.xmsf", 4).versionCode >= 108;
            } catch (Exception unused) {
            }
        }
        return true;
    }

    private Intent e() {
        Intent intent = new Intent();
        String packageName = this.f26a.getPackageName();
        i();
        intent.setComponent(new ComponentName(this.f26a, "com.xiaomi.push.service.XMPushService"));
        intent.putExtra("mipush_app_package", packageName);
        return intent;
    }

    /* renamed from: e */
    private boolean m63e() {
        String packageName = this.f26a.getPackageName();
        return packageName.contains("miui") || packageName.contains("xiaomi") || (this.f26a.getApplicationInfo().flags & 1) != 0;
    }

    private void g() {
        this.f25a = SystemClock.elapsedRealtime();
    }

    private void h() {
        try {
            PackageManager packageManager = this.f26a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f26a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 2, 1);
        } catch (Throwable unused) {
        }
    }

    private void i() {
        try {
            PackageManager packageManager = this.f26a.getPackageManager();
            ComponentName componentName = new ComponentName(this.f26a, "com.xiaomi.push.service.XMPushService");
            if (packageManager.getComponentEnabledSetting(componentName) == 1) {
                return;
            }
            packageManager.setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public long m64a() {
        return this.f25a;
    }

    /* renamed from: a */
    public void m65a() {
        b(m56a());
    }

    public void a(int i2) {
        a(i2, 0);
    }

    public void a(int i2, int i3) {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m56a.putExtra(com.xiaomi.push.service.an.B, this.f26a.getPackageName());
        m56a.putExtra(com.xiaomi.push.service.an.C, i2);
        m56a.putExtra(com.xiaomi.push.service.an.D, i3);
        c(m56a);
    }

    public void a(int i2, String str) {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.thirdparty");
        m56a.putExtra("com.xiaomi.mipush.thirdparty_LEVEL", i2);
        m56a.putExtra("com.xiaomi.mipush.thirdparty_DESC", str);
        b(m56a);
    }

    /* renamed from: a */
    public void m66a(Intent intent) {
        intent.fillIn(m56a(), 24);
        c(intent);
    }

    public final void a(gu guVar) {
        Intent m56a = m56a();
        byte[] a2 = ib.a(guVar);
        if (a2 == null) {
            com.xiaomi.a.a.a.c.a("send TinyData failed, because tinyDataBytes is null.");
            return;
        }
        m56a.setAction("com.xiaomi.mipush.SEND_TINYDATA");
        m56a.putExtra("mipush_payload", a2);
        b(m56a);
    }

    public final void a(hr hrVar, boolean z) {
        dt.a(this.f26a.getApplicationContext()).a(this.f26a.getPackageName(), "E100003", hrVar.c(), 6001, null);
        this.f27a = null;
        b.m74a(this.f26a).f40a = hrVar.c();
        Intent m56a = m56a();
        byte[] a2 = ib.a(ai.a(this.f26a, hrVar, gq.Registration));
        if (a2 == null) {
            com.xiaomi.a.a.a.c.a("register fail, because msgBytes is null.");
            return;
        }
        m56a.setAction("com.xiaomi.mipush.REGISTER_APP");
        m56a.putExtra("mipush_app_id", b.m74a(this.f26a).m75a());
        m56a.putExtra("mipush_payload", a2);
        m56a.putExtra("mipush_session", this.f31a);
        m56a.putExtra("mipush_env_chanage", z);
        m56a.putExtra("mipush_env_type", b.m74a(this.f26a).a());
        if (!com.xiaomi.push.al.c(this.f26a) || !m70b()) {
            this.f27a = m56a;
            return;
        }
        g();
        c(m56a);
    }

    public final void a(hx hxVar) {
        byte[] a2 = ib.a(ai.a(this.f26a, hxVar, gq.UnRegistration));
        if (a2 == null) {
            com.xiaomi.a.a.a.c.a("unregister fail, because msgBytes is null.");
            return;
        }
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.UNREGISTER_APP");
        m56a.putExtra("mipush_app_id", b.m74a(this.f26a).m75a());
        m56a.putExtra("mipush_payload", a2);
        c(m56a);
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, hd hdVar) {
        a((ao) t, gqVar, !gqVar.equals(gq.Registration), hdVar);
    }

    public <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z) {
        a aVar = new a();
        aVar.f34a = t;
        aVar.a = gqVar;
        aVar.f35a = z;
        ArrayList<a> arrayList = f24a;
        synchronized (arrayList) {
            arrayList.add(aVar);
            if (arrayList.size() > 10) {
                arrayList.remove(0);
            }
        }
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, hd hdVar) {
        a(t, gqVar, z, true, hdVar, true);
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, hd hdVar, boolean z2) {
        a(t, gqVar, z, true, hdVar, z2);
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, boolean z2, hd hdVar, boolean z3) {
        a(t, gqVar, z, z2, hdVar, z3, this.f26a.getPackageName(), b.m74a(this.f26a).m75a());
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, boolean z2, hd hdVar, boolean z3, String str, String str2) {
        a(t, gqVar, z, z2, hdVar, z3, str, str2, true);
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, boolean z2, hd hdVar, boolean z3, String str, String str2, boolean z4) {
        a(t, gqVar, z, z2, hdVar, z3, str, str2, z4, true);
    }

    public final <T extends ic<T, ?>> void a(T t, gq gqVar, boolean z, boolean z2, hd hdVar, boolean z3, String str, String str2, boolean z4, boolean z5) {
        if (z5 && !b.m74a(this.f26a).m83c()) {
            if (z2) {
                a((ao) t, gqVar, z);
                return;
            } else {
                com.xiaomi.a.a.a.c.a("drop the message before initialization.");
                return;
            }
        }
        hn a2 = z4 ? ai.a(this.f26a, t, gqVar, z, str, str2) : ai.b(this.f26a, t, gqVar, z, str, str2);
        if (hdVar != null) {
            a2.a(hdVar);
        }
        byte[] a3 = ib.a(a2);
        if (a3 == null) {
            com.xiaomi.a.a.a.c.a("send message fail, because msgBytes is null.");
            return;
        }
        cf.a(this.f26a.getPackageName(), this.f26a, t, gqVar, a3.length);
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.SEND_MESSAGE");
        m56a.putExtra("mipush_payload", a3);
        m56a.putExtra("com.xiaomi.mipush.MESSAGE_CACHE", z3);
        c(m56a);
    }

    public final void a(String str, au auVar, e eVar) {
        af.a(this.f26a).a(auVar, "syncing");
        a(str, auVar, false, i.m93a(this.f26a, eVar));
    }

    public void a(String str, String str2) {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.CLEAR_NOTIFICATION");
        m56a.putExtra(com.xiaomi.push.service.an.B, this.f26a.getPackageName());
        m56a.putExtra(com.xiaomi.push.service.an.H, str);
        m56a.putExtra(com.xiaomi.push.service.an.I, str2);
        c(m56a);
    }

    public final void a(boolean z) {
        a(z, (String) null);
    }

    public final void a(boolean z, String str) {
        au auVar;
        af a2;
        au auVar2;
        if (z) {
            af a3 = af.a(this.f26a);
            auVar = au.DISABLE_PUSH;
            a3.a(auVar, "syncing");
            a2 = af.a(this.f26a);
            auVar2 = au.ENABLE_PUSH;
        } else {
            af a4 = af.a(this.f26a);
            auVar = au.ENABLE_PUSH;
            a4.a(auVar, "syncing");
            a2 = af.a(this.f26a);
            auVar2 = au.DISABLE_PUSH;
        }
        a2.a(auVar2, "");
        a(str, auVar, true, (HashMap<String, String>) null);
    }

    /* renamed from: a */
    public boolean m67a() {
        return this.f33a && 1 == b.m74a(this.f26a).a();
    }

    /* renamed from: a */
    public boolean m68a(int i2) {
        if (b.m74a(this.f26a).m81b()) {
            c(i2);
            hq hqVar = new hq();
            hqVar.a(com.xiaomi.push.service.ag.a());
            hqVar.b(b.m74a(this.f26a).m75a());
            hqVar.d(this.f26a.getPackageName());
            hqVar.c(ha.ClientABTest.ah);
            HashMap hashMap = new HashMap();
            hqVar.f8869h = hashMap;
            hashMap.put("boot_mode", i2 + "");
            a(this.f26a).a((ao) hqVar, gq.Notification, false, (hd) null);
            return true;
        }
        return false;
    }

    /* renamed from: b */
    public final void m69b() {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.DISABLE_PUSH");
        c(m56a);
    }

    public void b(int i2) {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m56a.putExtra(com.xiaomi.push.service.an.B, this.f26a.getPackageName());
        m56a.putExtra(com.xiaomi.push.service.an.E, i2);
        String str = com.xiaomi.push.service.an.G;
        m56a.putExtra(str, com.xiaomi.push.aq.b(this.f26a.getPackageName() + i2));
        c(m56a);
    }

    /* renamed from: b */
    public boolean m70b() {
        if (m67a() && m63e()) {
            if (this.f30a == null) {
                Integer valueOf = Integer.valueOf(com.xiaomi.push.service.aq.a(this.f26a).b());
                this.f30a = valueOf;
                if (valueOf.intValue() == 0) {
                    this.f26a.getContentResolver().registerContentObserver(com.xiaomi.push.service.aq.a(this.f26a).c(), false, new ar(this, new Handler(Looper.getMainLooper())));
                }
            }
            return this.f30a.intValue() != 0;
        }
        return true;
    }

    /* renamed from: c */
    public void m71c() {
        if (this.f27a != null) {
            g();
            c(this.f27a);
            this.f27a = null;
        }
    }

    /* renamed from: d */
    public void m72d() {
        ArrayList<a> arrayList = f24a;
        synchronized (arrayList) {
            boolean z = Thread.currentThread() == Looper.getMainLooper().getThread();
            Iterator<a> it = arrayList.iterator();
            while (it.hasNext()) {
                a next = it.next();
                a(next.f34a, next.a, next.f35a, false, null, true);
                if (!z) {
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException unused) {
                    }
                }
            }
            f24a.clear();
        }
    }

    /* renamed from: e */
    public void m73e() {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.CLEAR_HEADSUPNOTIFICATION");
        Application application = (Application) com.xiaomi.push.am.a("android.app.ActivityThread", "currentApplication", new Object[0]);
        String packageName = (application == null || application.getApplicationContext() == null) ? null : application.getApplicationContext().getPackageName();
        String packageName2 = this.f26a.getPackageName();
        if (TextUtils.isEmpty(packageName) || packageName.equals(packageName2)) {
            packageName = packageName2;
        } else {
            com.xiaomi.a.a.a.c.a("application package name: " + packageName + ", not equals context package name: " + packageName2);
        }
        m56a.putExtra(com.xiaomi.push.service.an.B, packageName);
        c(m56a);
    }

    public void f() {
        Intent m56a = m56a();
        m56a.setAction("com.xiaomi.mipush.SET_NOTIFICATION_TYPE");
        m56a.putExtra(com.xiaomi.push.service.an.B, this.f26a.getPackageName());
        m56a.putExtra(com.xiaomi.push.service.an.G, com.xiaomi.push.aq.b(this.f26a.getPackageName()));
        c(m56a);
    }
}
