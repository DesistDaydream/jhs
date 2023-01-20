package androidx.core.app;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Build;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public final class AlarmManagerCompat {
    private AlarmManagerCompat() {
    }

    @SuppressLint({"MissingPermission"})
    public static void setAlarmClock(@NonNull AlarmManager alarmManager, long j2, @NonNull PendingIntent pendingIntent, @NonNull PendingIntent pendingIntent2) {
        if (Build.VERSION.SDK_INT >= 21) {
            alarmManager.setAlarmClock(new AlarmManager.AlarmClockInfo(j2, pendingIntent), pendingIntent2);
        } else {
            setExact(alarmManager, 0, j2, pendingIntent2);
        }
    }

    public static void setAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setAndAllowWhileIdle(i2, j2, pendingIntent);
        } else {
            alarmManager.set(i2, j2, pendingIntent);
        }
    }

    public static void setExact(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 19) {
            alarmManager.setExact(i2, j2, pendingIntent);
        } else {
            alarmManager.set(i2, j2, pendingIntent);
        }
    }

    public static void setExactAndAllowWhileIdle(@NonNull AlarmManager alarmManager, int i2, long j2, @NonNull PendingIntent pendingIntent) {
        if (Build.VERSION.SDK_INT >= 23) {
            alarmManager.setExactAndAllowWhileIdle(i2, j2, pendingIntent);
        } else {
            setExact(alarmManager, i2, j2, pendingIntent);
        }
    }
}
