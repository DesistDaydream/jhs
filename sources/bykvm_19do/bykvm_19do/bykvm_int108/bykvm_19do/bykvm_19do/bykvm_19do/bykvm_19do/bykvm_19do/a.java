package bykvm_19do.bykvm_19do.bykvm_int108.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do.bykvm_19do;

import android.annotation.SuppressLint;
import android.content.Context;

/* loaded from: classes.dex */
public class a extends b {
    @SuppressLint({"StaticFieldLeak"})

    /* renamed from: c  reason: collision with root package name */
    private static volatile a f1061c;

    private a(Context context) {
        super(context);
    }

    public static a a(Context context) {
        if (f1061c == null) {
            synchronized (a.class) {
                if (f1061c == null) {
                    f1061c = new a(context);
                }
            }
        }
        return f1061c;
    }
}
