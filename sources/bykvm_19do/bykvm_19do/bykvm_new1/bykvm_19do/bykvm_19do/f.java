package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_19do;

import android.content.Context;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class f {
    private static volatile f b;
    private final c a;

    private f(@NonNull Context context) {
        this.a = new c(context);
    }

    public static f a(Context context) {
        if (b == null) {
            synchronized (f.class) {
                if (b == null) {
                    b = new f(context);
                }
            }
        }
        return b;
    }

    public void a() {
        this.a.a();
    }
}
