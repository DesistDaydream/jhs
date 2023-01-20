package e.b.a.q;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import androidx.annotation.NonNull;
import e.b.a.q.c;

/* loaded from: classes.dex */
public final class e implements c {

    /* renamed from: f  reason: collision with root package name */
    private static final String f9839f = "ConnectivityMonitor";
    private final Context a;
    public final c.a b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f9840c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f9841d;

    /* renamed from: e  reason: collision with root package name */
    private final BroadcastReceiver f9842e = new a();

    /* loaded from: classes.dex */
    public class a extends BroadcastReceiver {
        public a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(@NonNull Context context, Intent intent) {
            e eVar = e.this;
            boolean z = eVar.f9840c;
            eVar.f9840c = eVar.a(context);
            if (z != e.this.f9840c) {
                if (Log.isLoggable(e.f9839f, 3)) {
                    Log.d(e.f9839f, "connectivity changed, isConnected: " + e.this.f9840c);
                }
                e eVar2 = e.this;
                eVar2.b.a(eVar2.f9840c);
            }
        }
    }

    public e(@NonNull Context context, @NonNull c.a aVar) {
        this.a = context.getApplicationContext();
        this.b = aVar;
    }

    private void b() {
        if (this.f9841d) {
            return;
        }
        this.f9840c = a(this.a);
        try {
            this.a.registerReceiver(this.f9842e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f9841d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable(f9839f, 5)) {
                Log.w(f9839f, "Failed to register", e2);
            }
        }
    }

    private void c() {
        if (this.f9841d) {
            this.a.unregisterReceiver(this.f9842e);
            this.f9841d = false;
        }
    }

    @SuppressLint({"MissingPermission"})
    public boolean a(@NonNull Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) e.b.a.v.l.d((ConnectivityManager) context.getSystemService("connectivity"))).getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable(f9839f, 5)) {
                Log.w(f9839f, "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }

    @Override // e.b.a.q.m
    public void onDestroy() {
    }

    @Override // e.b.a.q.m
    public void onStart() {
        b();
    }

    @Override // e.b.a.q.m
    public void onStop() {
        c();
    }
}
