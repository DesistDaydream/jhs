package org.repackage.com.zui.opendeviceidlibrary;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import java.util.Objects;
import org.repackage.com.zui.deviceidservice.IDeviceidInterface;

/* loaded from: classes4.dex */
public class OpenDeviceId {

    /* renamed from: c  reason: collision with root package name */
    private static String f17172c = "OpenDeviceId library";

    /* renamed from: d  reason: collision with root package name */
    private static boolean f17173d = false;
    private IDeviceidInterface b;

    /* renamed from: e  reason: collision with root package name */
    private ServiceConnection f17174e;
    private Context a = null;

    /* renamed from: f  reason: collision with root package name */
    private CallBack f17175f = null;

    /* loaded from: classes4.dex */
    public interface CallBack<T> {
        void a(T t, OpenDeviceId openDeviceId);
    }

    public String b() {
        if (this.a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.b();
                }
                return null;
            } catch (RemoteException e2) {
                b("getUDID error, RemoteException!");
                e2.printStackTrace();
                return null;
            } catch (Exception e3) {
                b("getUDID error, Exception!");
                e3.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public boolean c() {
        try {
            if (this.b != null) {
                a("Device support opendeviceid");
                return this.b.c();
            }
            return false;
        } catch (RemoteException unused) {
            b("isSupport error, RemoteException!");
            return false;
        }
    }

    public String d() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            a("liufeng, getVAID package：" + packageName);
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.b;
                    if (iDeviceidInterface != null) {
                        return iDeviceidInterface.a(packageName);
                    }
                    return null;
                } catch (RemoteException e2) {
                    b("getVAID error, RemoteException!");
                    e2.printStackTrace();
                    return null;
                }
            }
            a("input package is null!");
            return null;
        }
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public String e() {
        Context context = this.a;
        if (context != null) {
            String packageName = context.getPackageName();
            a("liufeng, getAAID package：" + packageName);
            String str = null;
            if (packageName != null && !packageName.equals("")) {
                try {
                    IDeviceidInterface iDeviceidInterface = this.b;
                    if (iDeviceidInterface != null) {
                        str = iDeviceidInterface.b(packageName);
                        return ((str == null || "".equals(str)) && this.b.c(packageName)) ? this.b.b(packageName) : str;
                    }
                    return null;
                } catch (RemoteException unused) {
                    b("getAAID error, RemoteException!");
                    return str;
                }
            }
            a("input package is null!");
            return null;
        }
        a("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void f() {
        try {
            this.a.unbindService(this.f17174e);
            a("unBind Service successful");
        } catch (IllegalArgumentException unused) {
            b("unBind Service exception");
        }
        this.b = null;
    }

    public int a(Context context, CallBack<String> callBack) {
        Objects.requireNonNull(context, "Context can not be null.");
        this.a = context;
        this.f17175f = callBack;
        this.f17174e = new ServiceConnection() { // from class: org.repackage.com.zui.opendeviceidlibrary.OpenDeviceId.1
            @Override // android.content.ServiceConnection
            public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                OpenDeviceId.this.b = IDeviceidInterface.Stub.a(iBinder);
                if (OpenDeviceId.this.f17175f != null) {
                    OpenDeviceId.this.f17175f.a("Deviceid Service Connected", OpenDeviceId.this);
                }
                OpenDeviceId.this.a("Service onServiceConnected");
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                OpenDeviceId.this.b = null;
                OpenDeviceId.this.a("Service onServiceDisconnected");
            }
        };
        Intent intent = new Intent();
        intent.setClassName("org.repackage.com.zui.deviceidservice", "org.repackage.com.zui.deviceidservice.DeviceidService");
        if (this.a.bindService(intent, this.f17174e, 1)) {
            a("bindService Successful!");
            return 1;
        }
        a("bindService Failed!");
        return -1;
    }

    private void b(String str) {
        if (f17173d) {
            Log.e(f17172c, str);
        }
    }

    public String a() {
        if (this.a != null) {
            try {
                IDeviceidInterface iDeviceidInterface = this.b;
                if (iDeviceidInterface != null) {
                    return iDeviceidInterface.a();
                }
                return null;
            } catch (RemoteException e2) {
                b("getOAID error, RemoteException!");
                e2.printStackTrace();
                return null;
            }
        }
        b("Context is null.");
        throw new IllegalArgumentException("Context is null, must be new OpenDeviceId first");
    }

    public void a(boolean z) {
        f17173d = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str) {
        if (f17173d) {
            Log.i(f17172c, str);
        }
    }
}
