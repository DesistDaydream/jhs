package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.Logger;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public class e {
    private static long a = 1800000;
    private static Handler b = new Handler(Looper.getMainLooper());

    /* loaded from: classes.dex */
    public static final class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ LocationManager b;

        public a(Context context, LocationManager locationManager) {
            this.a = context;
            this.b = locationManager;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b(this.a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements LocationListener {
        public final /* synthetic */ Context a;
        public final /* synthetic */ LocationManager b;

        public b(Context context, LocationManager locationManager) {
            this.a = context;
            this.b = locationManager;
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location != null && e.b(location)) {
                e.b(this.a, location);
            }
            e.b(this.b, this);
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i2, Bundle bundle) {
        }
    }

    /* loaded from: classes.dex */
    public static final class c implements Runnable {
        public final /* synthetic */ LocationManager a;
        public final /* synthetic */ LocationListener b;

        public c(LocationManager locationManager, LocationListener locationListener) {
            this.a = locationManager;
            this.b = locationListener;
        }

        @Override // java.lang.Runnable
        public void run() {
            e.b(this.a, this.b);
        }
    }

    /* loaded from: classes.dex */
    public static class d implements Callable<Location> {
        private LocationManager a;
        private String b;

        public d(LocationManager locationManager, String str) {
            this.a = locationManager;
            this.b = str;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Location call() throws Exception {
            long currentTimeMillis = System.currentTimeMillis();
            Location lastKnownLocation = this.a.getLastKnownLocation(this.b);
            long currentTimeMillis2 = System.currentTimeMillis();
            Logger.d("AdLocationUtils", "location:" + lastKnownLocation + ",getLastKnownLocation use time :" + (currentTimeMillis2 - currentTimeMillis));
            return lastKnownLocation;
        }
    }

    private static Location a(LocationManager locationManager) {
        Location a2 = a(locationManager, "gps");
        if (a2 == null) {
            a2 = a(locationManager, "network");
        }
        return a2 == null ? a(locationManager, "passive") : a2;
    }

    private static Location a(LocationManager locationManager, String str) {
        try {
            FutureTask futureTask = new FutureTask(new d(locationManager, str));
            ThreadHelper.runOnThreadPool(futureTask);
            Location location = (Location) futureTask.get(1L, TimeUnit.SECONDS);
            Logger.d("AdLocationUtils", "location:" + location);
            return location;
        } catch (Throwable unused) {
            return null;
        }
    }

    @Nullable
    private static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d a(Context context) {
        c0 a2 = c0.a((String) null, context);
        float a3 = a2.a("latitude", -1.0f);
        float a4 = a2.a("longitude", -1.0f);
        if (a3 == -1.0f || a4 == -1.0f) {
            return null;
        }
        return new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d(a3, a4);
    }

    @Nullable
    public static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d b(Context context) {
        if (bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.b.I().s().isCanUseLocation()) {
            Context d2 = context == null ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.a.d() : context.getApplicationContext();
            if (d2 != null) {
                bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d a2 = a(d2);
                if (!c(d2)) {
                    return a2;
                }
                int a3 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(d2, "android.permission.ACCESS_FINE_LOCATION");
                int a4 = bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.c.a(d2, "android.permission.ACCESS_COARSE_LOCATION");
                if (a3 == 0 || a4 == 0) {
                    return d(d2);
                }
            }
        }
        return null;
    }

    private static String b(LocationManager locationManager) {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        if (locationManager.isProviderEnabled("passive")) {
            return "passive";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, Location location) {
        if (b(location)) {
            c0 a2 = c0.a((String) null, context);
            a2.b("latitude", (float) location.getLatitude());
            a2.b("longitude", (float) location.getLongitude());
            a2.b("lbstime", System.currentTimeMillis());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(Context context, LocationManager locationManager) {
        if (context == null || locationManager == null) {
            return;
        }
        b bVar = new b(context, locationManager);
        try {
            String b2 = b(locationManager);
            if (TextUtils.isEmpty(b2)) {
                return;
            }
            locationManager.requestSingleUpdate(b2, bVar, Looper.getMainLooper());
            b.postDelayed(new c(locationManager, bVar), JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
            b(locationManager, bVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b(LocationManager locationManager, LocationListener locationListener) {
        if (locationManager == null || locationListener == null) {
            return;
        }
        try {
            locationManager.removeUpdates(locationListener);
        } catch (Throwable th) {
            if (Logger.isDebug()) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(Location location) {
        return (location.getLatitude() == 0.0d || location.getLongitude() == 0.0d) ? false : true;
    }

    private static boolean c(Context context) {
        long a2 = c0.a((String) null, context).a("lbstime", -1L);
        return a2 == -1 || System.currentTimeMillis() - a2 > a;
    }

    private static bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d d(Context context) {
        LocationManager locationManager = (LocationManager) context.getSystemService("location");
        bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d dVar = null;
        if (locationManager != null) {
            try {
                Location a2 = a(locationManager);
                if (a2 != null && b(a2)) {
                    b(context, a2);
                    dVar = new bykvm_19do.bykvm_19do.bykvm_if122.bykvm_try19.d((float) a2.getLatitude(), (float) a2.getLongitude());
                }
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    new Handler(Looper.getMainLooper()).post(new a(context, locationManager));
                } else {
                    b(context, locationManager);
                }
            } catch (Throwable th) {
                if (Logger.isDebug()) {
                    th.printStackTrace();
                }
            }
        }
        return dVar;
    }
}
