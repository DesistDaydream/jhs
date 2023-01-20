package com.tencent.tpns.baseapi.base;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Build;
import androidx.core.app.NotificationCompat;
import com.tencent.tpns.baseapi.base.util.Logger;

/* loaded from: classes3.dex */
public class TPushAlarmManager {
    private static TPushAlarmManager a = new TPushAlarmManager();
    private static AlarmManager b = null;

    private TPushAlarmManager() {
    }

    private static synchronized void a(Context context) {
        synchronized (TPushAlarmManager.class) {
            if (b == null && context != null) {
                b = (AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM);
            }
        }
    }

    public static TPushAlarmManager getAlarmManager(Context context) {
        if (b == null) {
            a(context);
        }
        return a;
    }

    public void cancal(PendingIntent pendingIntent) {
        AlarmManager alarmManager = b;
        if (alarmManager != null) {
            alarmManager.cancel(pendingIntent);
        }
    }

    public void set(int i2, long j2, PendingIntent pendingIntent, boolean z) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 23 && !z) {
            try {
                Logger.d("TPushAlarmManager", "Alarm setExactAndAllowWhileIdle  delay: " + j2);
                b.setExactAndAllowWhileIdle(i2, j2, pendingIntent);
            } catch (Throwable th) {
                Logger.e("TPushAlarmManager", "Alarm scheule using setExactAndAllowWhileIdle, error: " + j2, th);
            }
        } else if (i3 >= 19) {
            try {
                Logger.d("TPushAlarmManager", "Alarm scheule using setExact, delay: " + j2);
                b.setExact(i2, j2, pendingIntent);
            } catch (Throwable th2) {
                Logger.e("TPushAlarmManager", "Alarm scheule using setExact, error: " + j2, th2);
            }
        } else {
            try {
                Logger.d("TPushAlarmManager", "Alarm scheule using set, delay: " + j2);
                b.set(i2, j2, pendingIntent);
            } catch (Throwable th3) {
                Logger.e("TPushAlarmManager", "Alarm scheule using set, error: " + j2, th3);
            }
        }
    }

    public void setRepeating(long j2, long j3, PendingIntent pendingIntent) {
        AlarmManager alarmManager = b;
        if (alarmManager != null) {
            alarmManager.setRepeating(2, j2, j3, pendingIntent);
        }
    }
}
