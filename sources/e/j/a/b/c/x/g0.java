package e.j.a.b.c.x;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.PowerManager;
import android.os.SystemClock;

/* loaded from: classes2.dex */
public final class g0 {
    private static long b;
    private static final IntentFilter a = new IntentFilter("android.intent.action.BATTERY_CHANGED");

    /* renamed from: c  reason: collision with root package name */
    private static float f10468c = Float.NaN;

    @TargetApi(20)
    public static int a(Context context) {
        boolean isScreenOn;
        if (context == null || context.getApplicationContext() == null) {
            return -1;
        }
        Intent registerReceiver = context.getApplicationContext().registerReceiver(null, a);
        int i2 = ((registerReceiver == null ? 0 : registerReceiver.getIntExtra("plugged", 0)) & 7) != 0 ? 1 : 0;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager == null) {
            return -1;
        }
        if (v.i()) {
            isScreenOn = powerManager.isInteractive();
        } else {
            isScreenOn = powerManager.isScreenOn();
        }
        return (isScreenOn ? 2 : 0) | i2;
    }

    public static synchronized float b(Context context) {
        synchronized (g0.class) {
            if (SystemClock.elapsedRealtime() - b < com.heytap.mcssdk.constant.a.f3314d && !Float.isNaN(f10468c)) {
                return f10468c;
            }
            Intent registerReceiver = context.getApplicationContext().registerReceiver(null, a);
            if (registerReceiver != null) {
                f10468c = registerReceiver.getIntExtra("level", -1) / registerReceiver.getIntExtra("scale", -1);
            }
            b = SystemClock.elapsedRealtime();
            return f10468c;
        }
    }
}
