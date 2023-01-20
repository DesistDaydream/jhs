package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.os.Build;

/* loaded from: classes.dex */
public final class b1 {
    public static a1 a(Context context) {
        if (i.e()) {
            return new g1(new m1());
        }
        if (m1.a()) {
            return new m1();
        }
        if (e1.a()) {
            return s0.b() ? new f1(context) : new e1(context);
        } else if (i.a(context) || i.c()) {
            return new v0();
        } else {
            if (i.g()) {
                return new g1();
            }
            if (i.f()) {
                return new x0();
            }
            if (Build.VERSION.SDK_INT > 28) {
                return i.h() ? new i1() : i.j() ? new y0() : i.i() ? new w0() : i.k() ? new n0() : new r0();
            } else if (i.d() || !v0.d(context)) {
                return null;
            } else {
                return new v0();
            }
        }
    }
}
