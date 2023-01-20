package com.umeng.analytics.pro;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import com.umeng.analytics.pro.a;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class ab implements z {
    private static final String a = "Coolpad";
    private static final String b = "com.coolpad.deviceidsupport";

    /* renamed from: c  reason: collision with root package name */
    private static final String f6989c = "com.coolpad.deviceidsupport.DeviceIdService";

    /* renamed from: d  reason: collision with root package name */
    private static a f6990d;

    /* renamed from: f  reason: collision with root package name */
    private CountDownLatch f6992f;

    /* renamed from: g  reason: collision with root package name */
    private Context f6993g;

    /* renamed from: e  reason: collision with root package name */
    private String f6991e = "";

    /* renamed from: h  reason: collision with root package name */
    private final ServiceConnection f6994h = new ServiceConnection() { // from class: com.umeng.analytics.pro.ab.1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            try {
                a unused = ab.f6990d = a.AbstractBinderC0278a.a(iBinder);
                ab.this.f6991e = ab.f6990d.b(ab.this.f6993g.getPackageName());
                Log.d(ab.a, "onServiceConnected: oaid = " + ab.this.f6991e);
            } catch (RemoteException | NullPointerException e2) {
                Log.e(ab.a, "onServiceConnected failed e=" + e2.getMessage());
            }
            ab.this.f6992f.countDown();
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(ab.a, "onServiceDisconnected");
            a unused = ab.f6990d = null;
        }
    };

    private void b(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName(b, f6989c));
            if (context.bindService(intent, this.f6994h, 1)) {
                return;
            }
            Log.e(a, "bindService return false");
        } catch (Throwable th) {
            Log.e(a, "bindService failed. e=" + th.getMessage());
            this.f6992f.countDown();
        }
    }

    private void c(Context context) {
        try {
            Log.d(a, "call unbindService.");
            context.unbindService(this.f6994h);
        } catch (Throwable th) {
            Log.e(a, "unbindService failed. e=" + th.getMessage());
        }
    }

    @Override // com.umeng.analytics.pro.z
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        this.f6993g = context.getApplicationContext();
        this.f6992f = new CountDownLatch(1);
        try {
            b(context);
            if (!this.f6992f.await(500L, TimeUnit.MILLISECONDS)) {
                Log.e(a, "getOAID time-out");
            }
            return this.f6991e;
        } catch (InterruptedException e2) {
            Log.e(a, "getOAID interrupted. e=" + e2.getMessage());
            return null;
        } finally {
            c(context);
        }
    }
}
