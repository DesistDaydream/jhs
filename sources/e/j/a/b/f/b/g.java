package e.j.a.b.f.b;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import androidx.annotation.RequiresApi;

/* loaded from: classes2.dex */
public final class g {
    private static volatile boolean a = !b();

    @RequiresApi(24)
    @TargetApi(24)
    public static Context a(Context context) {
        return context.isDeviceProtectedStorage() ? context : context.createDeviceProtectedStorageContext();
    }

    public static boolean b() {
        return Build.VERSION.SDK_INT >= 24;
    }
}
