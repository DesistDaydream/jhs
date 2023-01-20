package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes.dex */
public final class q0 {
    private static final AtomicBoolean a = new AtomicBoolean(false);
    private static String b = "";

    public static String a(SharedPreferences sharedPreferences) {
        if (a.compareAndSet(false, true)) {
            String string = sharedPreferences.getString("cdid", "");
            b = string;
            if (TextUtils.isEmpty(string)) {
                b = UUID.randomUUID().toString();
                sharedPreferences.edit().putString("cdid", b).apply();
            }
        }
        return b;
    }
}
