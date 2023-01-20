package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_for12.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes.dex */
public class h extends i {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: d  reason: collision with root package name */
    private static volatile h f931d;

    private h(Context context) {
        super(context);
    }

    public static h a(Context context) {
        if (f931d == null) {
            synchronized (h.class) {
                if (f931d == null) {
                    f931d = new h(context);
                }
            }
        }
        return f931d;
    }
}
