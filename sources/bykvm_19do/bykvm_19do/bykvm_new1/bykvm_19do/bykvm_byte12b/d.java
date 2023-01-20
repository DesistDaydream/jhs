package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_byte12b;

import android.content.Context;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.h;
import bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.i;

/* loaded from: classes.dex */
public final class d implements Runnable {
    private Context a;

    private d(Context context) {
        this.a = context;
    }

    public static void a(Context context) {
        a(context, 0);
    }

    public static void a(Context context, int i2) {
        try {
            if (!i.e().e().equals(context.getPackageName())) {
                return;
            }
        } catch (Exception unused) {
        }
        h.a().postDelayed(new d(context), i2);
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            new bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_new1.d(this.a).a(bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do.bykvm_case1.i.c(this.a));
        } finally {
            try {
            } finally {
            }
        }
    }
}
