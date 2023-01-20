package com.ss.android.downloadlib.a.b;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.ss.android.downloadlib.a.b.c;
import com.ss.android.downloadlib.addownload.j;
import com.umeng.analytics.pro.am;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class a {

    /* renamed from: d  reason: collision with root package name */
    private static String f5193d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f5194e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f5195f = "";

    /* renamed from: g  reason: collision with root package name */
    private static volatile a f5196g;
    public c a;

    /* renamed from: k  reason: collision with root package name */
    private Context f5201k;

    /* renamed from: h  reason: collision with root package name */
    private boolean f5198h = true;

    /* renamed from: i  reason: collision with root package name */
    private boolean f5199i = false;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f5200j = false;

    /* renamed from: l  reason: collision with root package name */
    private final List<Pair<b, d>> f5202l = new ArrayList();
    public final List<InterfaceC0172a> b = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private final ServiceConnection f5203m = new ServiceConnection() { // from class: com.ss.android.downloadlib.a.b.a.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            synchronized (a.this.f5197c) {
                a.this.a(false);
                a.this.a = c.a.a(iBinder);
                a.this.c();
                for (InterfaceC0172a interfaceC0172a : a.this.b) {
                    interfaceC0172a.a();
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            synchronized (a.this.f5197c) {
                a.this.a(false);
                a aVar = a.this;
                aVar.a = null;
                for (InterfaceC0172a interfaceC0172a : aVar.b) {
                    interfaceC0172a.b();
                }
            }
        }
    };
    private String n = "";

    /* renamed from: c  reason: collision with root package name */
    public final Object f5197c = new Object();

    /* renamed from: com.ss.android.downloadlib.a.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0172a {
        void a();

        void b();
    }

    private a() {
    }

    public static a a() {
        if (f5196g == null) {
            synchronized (a.class) {
                if (f5196g == null) {
                    f5196g = new a();
                }
            }
        }
        return f5196g;
    }

    public void b() {
        if (this.a != null) {
            this.f5201k.unbindService(this.f5203m);
            this.a = null;
        }
        this.b.clear();
        this.f5202l.clear();
    }

    public void c() {
        for (Pair<b, d> pair : this.f5202l) {
            try {
                this.a.a((b) pair.first, (d) pair.second);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
        this.f5202l.clear();
    }

    public boolean d() {
        return this.f5200j;
    }

    public boolean a(Context context, boolean z) {
        if (TextUtils.isEmpty(f5193d)) {
            JSONObject i2 = j.i();
            String optString = i2.optString("s");
            f5193d = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString("q"), optString);
            f5194e = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(am.aH), optString);
            f5195f = com.ss.android.socialbase.appdownloader.f.c.a(i2.optString(IAdInterListener.AdReqParam.WIDTH), optString);
        }
        this.f5199i = z;
        if (context != null) {
            this.f5201k = context.getApplicationContext();
            if (TextUtils.isEmpty(f5195f)) {
                f5195f = this.f5201k.getPackageName();
            }
            if (this.a != null || d()) {
                return true;
            }
            return this.f5201k.bindService(a(context), this.f5203m, 33);
        }
        return true;
    }

    public Intent a(Context context) {
        Intent intent = new Intent();
        intent.setAction(f5193d);
        List<ResolveInfo> queryIntentServices = context.getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.size() != 1) {
            return null;
        }
        for (ResolveInfo resolveInfo : queryIntentServices) {
            ServiceInfo serviceInfo = resolveInfo.serviceInfo;
            String str = serviceInfo.packageName;
            String str2 = serviceInfo.name;
            if (f5194e.equals(str)) {
                ComponentName componentName = new ComponentName(str, str2);
                Intent intent2 = new Intent(intent);
                intent2.setComponent(componentName);
                return intent2;
            }
        }
        return null;
    }

    public void a(b bVar, d dVar) {
        synchronized (this.f5197c) {
            bVar.f5206e = f5195f;
            if (TextUtils.isEmpty(bVar.f5207f)) {
                bVar.f5207f = this.n;
            }
            c cVar = this.a;
            if (cVar != null) {
                try {
                    cVar.a(bVar, dVar);
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                }
            } else if (d() || a(this.f5201k, this.f5199i)) {
                this.f5202l.add(Pair.create(bVar, dVar));
            }
        }
    }

    public void a(boolean z) {
        this.f5200j = z;
    }
}
