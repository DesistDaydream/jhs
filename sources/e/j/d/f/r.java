package e.j.d.f;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.util.Log;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.tencent.android.tpns.mqtt.MqttTopic;
import java.util.ArrayDeque;
import java.util.Queue;
import javax.annotation.concurrent.GuardedBy;

/* loaded from: classes2.dex */
public final class r {

    /* renamed from: e  reason: collision with root package name */
    private static r f11253e;
    @Nullable
    @GuardedBy("this")
    private String a = null;
    private Boolean b = null;

    /* renamed from: c  reason: collision with root package name */
    private Boolean f11254c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Queue<Intent> f11255d = new ArrayDeque();

    private r() {
    }

    public static synchronized r b() {
        r rVar;
        synchronized (r.class) {
            if (f11253e == null) {
                f11253e = new r();
            }
            rVar = f11253e;
        }
        return rVar;
    }

    private final int d(Context context, Intent intent) {
        ComponentName startService;
        String g2 = g(context, intent);
        if (g2 != null) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                String valueOf = String.valueOf(g2);
                Log.d("FirebaseInstanceId", valueOf.length() != 0 ? "Restricting intent to a specific service: ".concat(valueOf) : new String("Restricting intent to a specific service: "));
            }
            intent.setClassName(context.getPackageName(), g2);
        }
        try {
            if (c(context)) {
                startService = WakefulBroadcastReceiver.startWakefulService(context, intent);
            } else {
                startService = context.startService(intent);
                Log.d("FirebaseInstanceId", "Missing wake lock permission, service start may be delayed");
            }
            if (startService == null) {
                Log.e("FirebaseInstanceId", "Error while delivering the message: ServiceIntent not found.");
                return 404;
            }
            return -1;
        } catch (IllegalStateException e2) {
            String valueOf2 = String.valueOf(e2);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf2).length() + 45);
            sb.append("Failed to start service while in background: ");
            sb.append(valueOf2);
            Log.e("FirebaseInstanceId", sb.toString());
            return 402;
        } catch (SecurityException e3) {
            Log.e("FirebaseInstanceId", "Error while delivering the message to the serviceIntent", e3);
            return 401;
        }
    }

    @Nullable
    private final synchronized String g(Context context, Intent intent) {
        ServiceInfo serviceInfo;
        String str;
        String str2 = this.a;
        if (str2 != null) {
            return str2;
        }
        ResolveInfo resolveService = context.getPackageManager().resolveService(intent, 0);
        if (resolveService != null && (serviceInfo = resolveService.serviceInfo) != null) {
            if (context.getPackageName().equals(serviceInfo.packageName) && (str = serviceInfo.name) != null) {
                if (str.startsWith(".")) {
                    String valueOf = String.valueOf(context.getPackageName());
                    String valueOf2 = String.valueOf(serviceInfo.name);
                    this.a = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                } else {
                    this.a = serviceInfo.name;
                }
                return this.a;
            }
            String str3 = serviceInfo.packageName;
            String str4 = serviceInfo.name;
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 94 + String.valueOf(str4).length());
            sb.append("Error resolving target intent service, skipping classname enforcement. Resolved service was: ");
            sb.append(str3);
            sb.append(MqttTopic.TOPIC_LEVEL_SEPARATOR);
            sb.append(str4);
            Log.e("FirebaseInstanceId", sb.toString());
            return null;
        }
        Log.e("FirebaseInstanceId", "Failed to resolve target intent service, skipping classname enforcement");
        return null;
    }

    @MainThread
    public final int a(Context context, Intent intent) {
        if (Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Starting service");
        }
        this.f11255d.offer(intent);
        Intent intent2 = new Intent("com.google.firebase.MESSAGING_EVENT");
        intent2.setPackage(context.getPackageName());
        return d(context, intent2);
    }

    public final boolean c(Context context) {
        if (this.b == null) {
            this.b = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.WAKE_LOCK") == 0);
        }
        if (!this.b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.WAKE_LOCK this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.b.booleanValue();
    }

    @MainThread
    public final Intent e() {
        return this.f11255d.poll();
    }

    public final boolean f(Context context) {
        if (this.f11254c == null) {
            this.f11254c = Boolean.valueOf(context.checkCallingOrSelfPermission("android.permission.ACCESS_NETWORK_STATE") == 0);
        }
        if (!this.b.booleanValue() && Log.isLoggable("FirebaseInstanceId", 3)) {
            Log.d("FirebaseInstanceId", "Missing Permission: android.permission.ACCESS_NETWORK_STATE this should normally be included by the manifest merger, but may needed to be manually added to your manifest");
        }
        return this.f11254c.booleanValue();
    }
}
