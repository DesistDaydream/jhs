package com.xiaomi.push;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.os.Build;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import java.security.MessageDigest;

/* loaded from: classes3.dex */
public class ad implements v {
    private static boolean a;
    private Context b;

    /* renamed from: c  reason: collision with root package name */
    private ServiceConnection f8247c;

    /* renamed from: d  reason: collision with root package name */
    private volatile int f8248d = 0;

    /* renamed from: e  reason: collision with root package name */
    private volatile a f8249e = null;

    /* renamed from: f  reason: collision with root package name */
    private final Object f8250f = new Object();

    /* loaded from: classes3.dex */
    public class a {
        public String a;
        public String b;

        /* renamed from: c  reason: collision with root package name */
        public String f8251c;

        /* renamed from: d  reason: collision with root package name */
        public String f8252d;

        private a() {
            this.a = null;
            this.b = null;
            this.f8251c = null;
            this.f8252d = null;
        }
    }

    /* loaded from: classes3.dex */
    public class b implements ServiceConnection {
        private b() {
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (ad.this.f8249e != null) {
                return;
            }
            new Thread(new af(this, iBinder)).start();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static String a(IBinder iBinder, String str, String str2, String str3) {
            Parcel obtain = Parcel.obtain();
            Parcel obtain2 = Parcel.obtain();
            try {
                obtain.writeInterfaceToken("com.heytap.openid.IOpenID");
                obtain.writeString(str);
                obtain.writeString(str2);
                obtain.writeString(str3);
                iBinder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }
    }

    public ad(Context context) {
        this.b = context;
        c();
    }

    private void a(String str) {
        if (this.f8248d != 1 || Looper.myLooper() == Looper.getMainLooper()) {
            return;
        }
        synchronized (this.f8250f) {
            try {
                com.xiaomi.a.a.a.c.a("oppo's " + str + " wait...");
                this.f8250f.wait(3000L);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.heytap.openid", 128);
            if (packageInfo != null) {
                long longVersionCode = Build.VERSION.SDK_INT >= 28 ? packageInfo.getLongVersionCode() : packageInfo.versionCode;
                boolean z = (packageInfo.applicationInfo.flags & 1) != 0;
                a = longVersionCode >= 1;
                if (z) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    private void c() {
        boolean z;
        this.f8247c = new b();
        Intent intent = new Intent();
        intent.setClassName("com.heytap.openid", "com.heytap.openid.IdentifyService");
        intent.setAction("action.com.heytap.openid.OPEN_ID_SERVICE");
        try {
            z = this.b.bindService(intent, this.f8247c, 1);
        } catch (Exception unused) {
            z = false;
        }
        this.f8248d = z ? 1 : 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        ServiceConnection serviceConnection = this.f8247c;
        if (serviceConnection != null) {
            try {
                this.b.unbindService(serviceConnection);
            } catch (Exception unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String e() {
        try {
            Signature[] signatureArr = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures;
            MessageDigest messageDigest = MessageDigest.getInstance("SHA1");
            StringBuilder sb = new StringBuilder();
            for (byte b2 : messageDigest.digest(signatureArr[0].toByteArray())) {
                sb.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3));
            }
            return sb.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    @Override // com.xiaomi.push.v
    public boolean a() {
        return a;
    }

    @Override // com.xiaomi.push.v
    public String b() {
        a("getOAID");
        if (this.f8249e == null) {
            return null;
        }
        return this.f8249e.b;
    }
}
