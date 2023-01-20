package e.j.a.b.c.y;

import android.content.Context;
import e.j.a.b.c.x.d0;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public class c {
    private static c b = new c();
    private b a = null;

    @e.j.a.b.c.m.a
    public static b a(Context context) {
        return b.b(context);
    }

    @d0
    private final synchronized b b(Context context) {
        if (this.a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.a = new b(context);
        }
        return this.a;
    }
}
