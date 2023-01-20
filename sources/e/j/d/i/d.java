package e.j.d.i;

import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import com.huawei.hms.push.constant.RemoteMessageConst;
import e.j.a.b.c.x.v;
import e.j.a.b.j.n;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public final class d {
    private final Executor a;
    private final Context b;

    /* renamed from: c */
    private final c f11278c;

    /* renamed from: d */
    private final Bundle f11279d;

    public d(Context context, Bundle bundle, Executor executor) {
        this.a = executor;
        this.b = context;
        this.f11279d = bundle;
        this.f11278c = new c(context, context.getPackageName());
    }

    public final boolean a() {
        boolean z;
        if ("1".equals(c.e(this.f11279d, "gcm.n.noui"))) {
            return true;
        }
        if (!((KeyguardManager) this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode()) {
            if (!v.j()) {
                SystemClock.sleep(10L);
            }
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.b.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == myPid) {
                        if (next.importance == 100) {
                            z = true;
                        }
                    }
                }
            }
        }
        z = false;
        if (z) {
            return false;
        }
        j k2 = j.k(c.e(this.f11279d, "gcm.n.image"));
        if (k2 != null) {
            k2.n(this.a);
        }
        e d2 = this.f11278c.d(this.f11279d);
        NotificationCompat.Builder builder = d2.a;
        if (k2 != null) {
            try {
                Bitmap bitmap = (Bitmap) n.b(k2.j(), 5L, TimeUnit.SECONDS);
                builder.setLargeIcon(bitmap);
                builder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(bitmap).bigLargeIcon(null));
            } catch (InterruptedException unused) {
                Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
                k2.close();
                Thread.currentThread().interrupt();
            } catch (ExecutionException unused2) {
            } catch (TimeoutException unused3) {
                Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
                k2.close();
            }
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            Log.d("FirebaseMessaging", "Showing notification");
        }
        ((NotificationManager) this.b.getSystemService(RemoteMessageConst.NOTIFICATION)).notify(d2.b, 0, d2.a.build());
        return true;
    }
}
