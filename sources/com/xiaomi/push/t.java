package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;

/* loaded from: classes3.dex */
public class t implements v {
    private static boolean a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f9200c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f9201d = 0;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f9202e = null;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f9203f = false;

    /* renamed from: g  reason: collision with root package name */
    private volatile String f9204g = null;

    /* renamed from: h  reason: collision with root package name */
    private final Object f9205h = new Object();

    /* loaded from: classes3.dex */
    public class a implements ServiceConnection {
        private a() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                t.this.f9202e = b.a(iBinder);
                t.this.f9203f = b.b(iBinder);
                t.this.d();
                t.this.f9201d = 2;
                synchronized (t.this.f9205h) {
                    try {
                        t.this.f9205h.notifyAll();
                    } catch (Exception unused) {
                    }
                }
            } catch (Exception unused2) {
                t.this.d();
                t.this.f9201d = 2;
                synchronized (t.this.f9205h) {
                    try {
                        t.this.f9205h.notifyAll();
                    } catch (Exception unused3) {
                    }
                }
            } catch (Throwable th) {
                t.this.d();
                t.this.f9201d = 2;
                synchronized (t.this.f9205h) {
                    try {
                        t.this.f9205h.notifyAll();
                    } catch (Exception unused4) {
                    }
                    throw th;
                }
            }
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes3.dex */
    public static class b {
        public static String a(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public static boolean b(IBinder iBinder) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.uodis.opendevice.aidl.OpenDeviceIdentifierService");
                iBinder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readInt() != 0;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public t(Context context) {
        this.b = context;
        c();
    }

    private void a(String str) {
        if (this.f9201d != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f9205h) {
            try {
                com.xiaomi.a.a.a.c.a("huawei's " + str + " wait...");
                this.f9205h.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        boolean z;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.huawei.hwid", 128);
            z = (packageInfo.applicationInfo.flags & 1) != 0;
            a = packageInfo.versionCode >= 20602000;
        } catch (Exception unused) {
        }
        return z;
    }

    private void c() {
        boolean z;
        this.f9200c = new a();
        Intent intent = new Intent("com.uodis.opendevice.OPENIDS_SERVICE");
        intent.setPackage("com.huawei.hwid");
        try {
            z = this.b.bindService(intent, this.f9200c, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f9201d = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ServiceConnection serviceConnection = this.f9200c;
        if (serviceConnection != null) {
            try {
                this.b.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        return a;
    }

    @Override // com.xiaomi.push.v
    public String b() {
        a("getOAID");
        return this.f9202e;
    }
}
