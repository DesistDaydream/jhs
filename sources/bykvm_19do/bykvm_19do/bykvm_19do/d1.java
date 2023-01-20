package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;

/* loaded from: classes.dex */
public final class d1 {
    private final SharedPreferences a;

    @WorkerThread
    public d1(Context context) {
        this.a = context.getSharedPreferences("device_register_oaid_refine", 0);
    }

    private static void a(SharedPreferences sharedPreferences, String[] strArr) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        boolean z = false;
        for (String str : strArr) {
            if (sharedPreferences.contains(str)) {
                edit.remove(str);
                z = true;
            }
        }
        if (z) {
            edit.apply();
        }
    }

    @Nullable
    @WorkerThread
    public c1 a() {
        return c1.a(this.a.getString("oaid", ""));
    }

    @WorkerThread
    public void a(@Nullable c1 c1Var) {
        if (c1Var == null) {
            return;
        }
        this.a.edit().putString("oaid", c1Var.b().toString()).apply();
    }

    public void b() {
        a(this.a, new String[]{"oaid"});
    }
}
