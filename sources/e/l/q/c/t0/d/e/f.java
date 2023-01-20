package e.l.q.c.t0.d.e;

import android.content.Context;
import android.os.Build;

/* loaded from: classes2.dex */
public final class f {
    public static d a(Context context, e eVar) {
        d cVar;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 < 5) {
            cVar = new a(context);
        } else if (i2 < 8) {
            cVar = new b(context);
        } else {
            cVar = new c(context);
        }
        cVar.a(eVar);
        return cVar;
    }
}
