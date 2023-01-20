package e.j.d.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.PowerManager;
import android.util.Log;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdReceiver;
import java.io.IOException;

/* loaded from: classes2.dex */
public final class w implements Runnable {
    private final long a;
    private final PowerManager.WakeLock b;

    /* renamed from: c  reason: collision with root package name */
    private final FirebaseInstanceId f11263c;

    /* renamed from: d  reason: collision with root package name */
    private final y f11264d;

    @e.j.a.b.c.x.d0
    public w(FirebaseInstanceId firebaseInstanceId, j jVar, y yVar, long j2) {
        this.f11263c = firebaseInstanceId;
        this.f11264d = yVar;
        this.a = j2;
        PowerManager.WakeLock newWakeLock = ((PowerManager) a().getSystemService("power")).newWakeLock(1, "fiid-sync");
        this.b = newWakeLock;
        newWakeLock.setReferenceCounted(false);
    }

    @e.j.a.b.c.x.d0
    private final boolean c() throws IOException {
        t u = this.f11263c.u();
        if (this.f11263c.t(u)) {
            try {
                String z = this.f11263c.z();
                if (z == null) {
                    Log.e("FirebaseInstanceId", "Token retrieval failed: null");
                    return false;
                }
                if (Log.isLoggable("FirebaseInstanceId", 3)) {
                    Log.d("FirebaseInstanceId", "Token successfully retrieved");
                }
                if ((u == null || (u != null && !z.equals(u.a))) && FirebaseApp.DEFAULT_APP_NAME.equals(this.f11263c.n().getName())) {
                    if (Log.isLoggable("FirebaseInstanceId", 3)) {
                        String valueOf = String.valueOf(this.f11263c.n().getName());
                        Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Invoking onNewToken for app: ".concat(valueOf) : new String("Invoking onNewToken for app: "));
                    }
                    Intent intent = new Intent("com.google.firebase.messaging.NEW_TOKEN");
                    intent.putExtra("token", z);
                    Context a = a();
                    Intent intent2 = new Intent(a, FirebaseInstanceIdReceiver.class);
                    intent2.setAction("com.google.firebase.MESSAGING_EVENT");
                    intent2.putExtra("wrapped_intent", intent);
                    a.sendBroadcast(intent2);
                }
                return true;
            } catch (IOException e2) {
                if (!"SERVICE_NOT_AVAILABLE".equals(e2.getMessage()) && !"INTERNAL_SERVER_ERROR".equals(e2.getMessage())) {
                    if (e2.getMessage() == null) {
                        String message = e2.getMessage();
                        StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 52);
                        sb.append("Token retrieval failed: ");
                        sb.append(message);
                        sb.append(". Will retry token retrieval");
                        Log.e("FirebaseInstanceId", sb.toString());
                        return false;
                    }
                    throw e2;
                }
                Log.e("FirebaseInstanceId", "Token retrieval failed without exception message. Will retry token retrieval");
                return false;
            } catch (SecurityException unused) {
                Log.e("FirebaseInstanceId", "Token retrieval failed with SecurityException. Will retry token retrieval");
                return false;
            }
        }
        return true;
    }

    public final Context a() {
        return this.f11263c.n().getApplicationContext();
    }

    public final boolean b() {
        ConnectivityManager connectivityManager = (ConnectivityManager) a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override // java.lang.Runnable
    @SuppressLint({"Wakelock"})
    public final void run() {
        if (r.b().c(a())) {
            this.b.acquire();
        }
        try {
            try {
                this.f11263c.s(true);
                if (!this.f11263c.E()) {
                    this.f11263c.s(false);
                    if (r.b().c(a())) {
                        this.b.release();
                    }
                } else if (r.b().f(a()) && !b()) {
                    new v(this).a();
                    if (r.b().c(a())) {
                        this.b.release();
                    }
                } else {
                    if (c() && this.f11264d.c(this.f11263c)) {
                        this.f11263c.s(false);
                    } else {
                        this.f11263c.q(this.a);
                    }
                    if (r.b().c(a())) {
                        this.b.release();
                    }
                }
            } catch (IOException e2) {
                String message = e2.getMessage();
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + 93);
                sb.append("Topic sync or token retrieval failed on hard failure exceptions: ");
                sb.append(message);
                sb.append(". Won't retry the operation.");
                Log.e("FirebaseInstanceId", sb.toString());
                this.f11263c.s(false);
                if (r.b().c(a())) {
                    this.b.release();
                }
            }
        } catch (Throwable th) {
            if (r.b().c(a())) {
                this.b.release();
            }
            throw th;
        }
    }
}
