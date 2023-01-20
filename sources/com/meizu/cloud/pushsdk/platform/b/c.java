package com.meizu.cloud.pushsdk.platform.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.BasicPushStatus;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;

/* loaded from: classes2.dex */
public abstract class c<T extends BasicPushStatus> {
    public final Context a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f4948c;

    /* renamed from: d  reason: collision with root package name */
    public String f4949d;

    /* renamed from: e  reason: collision with root package name */
    public final com.meizu.cloud.pushsdk.platform.a.a f4950e;

    /* renamed from: h  reason: collision with root package name */
    private ScheduledExecutorService f4953h;

    /* renamed from: f  reason: collision with root package name */
    public boolean f4951f = true;

    /* renamed from: g  reason: collision with root package name */
    public boolean f4952g = true;

    /* renamed from: i  reason: collision with root package name */
    private String f4954i = null;

    public c(Context context, String str, String str2, com.meizu.cloud.pushsdk.platform.a.a aVar, ScheduledExecutorService scheduledExecutorService) {
        this.f4953h = scheduledExecutorService;
        this.a = context;
        this.b = str;
        this.f4948c = str2;
        this.f4950e = aVar;
    }

    private boolean a(int i2) {
        return i2 >= 110000 && i2 <= 200000;
    }

    private boolean b(T t) {
        int intValue = Integer.valueOf(t.getCode()).intValue();
        return (intValue > 200 && intValue < 600) || (intValue > 1000 && intValue < 2000) || intValue == 0;
    }

    private boolean h() {
        return this.f4952g && !this.a.getPackageName().equals(this.f4954i);
    }

    public String a(Context context, String str) {
        String str2 = null;
        if (!TextUtils.isEmpty(str)) {
            List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(new Intent(str), 0);
            if (queryIntentServices != null) {
                Iterator<ResolveInfo> it = queryIntentServices.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ResolveInfo next = it.next();
                    if (PushConstants.PUSH_PACKAGE_NAME.equals(next.serviceInfo.packageName)) {
                        ServiceInfo serviceInfo = next.serviceInfo;
                        this.f4954i = serviceInfo.packageName;
                        str2 = serviceInfo.name;
                        break;
                    }
                }
                if (TextUtils.isEmpty(str2) && queryIntentServices.size() > 0) {
                    this.f4954i = queryIntentServices.get(0).serviceInfo.packageName;
                    str2 = queryIntentServices.get(0).serviceInfo.name;
                }
            }
        }
        e.p.a.a.a.c("Strategy", "current process packageName " + this.f4954i);
        return str2;
    }

    public void a(Intent intent) {
        try {
            intent.setPackage(this.f4954i);
            intent.setAction(PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION);
            this.a.startService(intent);
        } catch (Exception e2) {
            e.p.a.a.a.f("Strategy", "start RemoteService error " + e2.getMessage());
        }
    }

    public abstract void a(T t);

    public void a(boolean z) {
        this.f4951f = z;
    }

    public abstract boolean a();

    public abstract T b();

    public void b(String str) {
        this.b = str;
    }

    public abstract Intent c();

    public void c(String str) {
        this.f4948c = str;
    }

    public void d(String str) {
        this.f4949d = str;
    }

    public Intent[] d() {
        return null;
    }

    public abstract T e();

    public abstract T f();

    public abstract int g();

    public boolean k() {
        return this.f4952g && this.f4951f && !TextUtils.isEmpty(a(this.a, PushConstants.MZ_PUSH_MANAGER_SERVICE_ACTION));
    }

    public boolean l() {
        return 2 == g() || 32 == g();
    }

    public boolean m() {
        ScheduledExecutorService scheduledExecutorService = this.f4953h;
        if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(new Runnable() { // from class: com.meizu.cloud.pushsdk.platform.b.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.n();
                }
            });
            return true;
        }
        return n();
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean n() {
        /*
            Method dump skipped, instructions count: 285
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.platform.b.c.n():boolean");
    }
}
