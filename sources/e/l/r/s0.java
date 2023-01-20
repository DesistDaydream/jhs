package e.l.r;

import android.content.Context;
import android.os.Vibrator;

/* loaded from: classes2.dex */
public class s0 {
    private static Vibrator a;

    public static void a() {
        Vibrator vibrator = a;
        if (vibrator != null) {
            vibrator.cancel();
        }
    }

    public static void b(Context context, long[] jArr, int i2) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        a = vibrator;
        vibrator.vibrate(jArr, i2);
    }

    public static void c(Context context, int i2) {
        Vibrator vibrator = (Vibrator) context.getSystemService("vibrator");
        a = vibrator;
        vibrator.vibrate(i2);
    }
}
