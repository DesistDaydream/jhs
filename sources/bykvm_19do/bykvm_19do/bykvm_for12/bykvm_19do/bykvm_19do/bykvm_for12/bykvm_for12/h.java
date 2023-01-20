package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_for12.bykvm_for12;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public class h {
    private static volatile h a;
    private static HashMap<Integer, f> b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<Integer, a> f260c;

    private h() {
        b = new HashMap<>();
        f260c = new HashMap<>();
    }

    public static h a() {
        h hVar;
        synchronized (h.class) {
            if (a == null) {
                synchronized (h.class) {
                    if (a == null) {
                        a = new h();
                    }
                }
            }
            hVar = a;
        }
        return hVar;
    }

    public a a(int i2, Context context) {
        if (f260c.get(Integer.valueOf(i2)) == null) {
            f260c.put(Integer.valueOf(i2), new a(context, i2));
        }
        return f260c.get(Integer.valueOf(i2));
    }

    public f a(int i2) {
        if (b.get(Integer.valueOf(i2)) == null) {
            b.put(Integer.valueOf(i2), new f(i2));
        }
        return b.get(Integer.valueOf(i2));
    }
}
