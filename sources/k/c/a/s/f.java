package k.c.a.s;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import k.c.a.f;

/* loaded from: classes4.dex */
public class f {
    public final Map<Class<? extends Throwable>, Integer> a = new HashMap();

    public f a(Class<? extends Throwable> cls, int i2) {
        this.a.put(cls, Integer.valueOf(i2));
        return this;
    }

    public Integer b(Throwable th) {
        int i2 = 20;
        Throwable th2 = th;
        do {
            Integer c2 = c(th2);
            if (c2 == null) {
                th2 = th2.getCause();
                i2--;
                if (i2 <= 0 || th2 == th) {
                    break;
                }
            } else {
                return c2;
            }
        } while (th2 != null);
        f.a.a().b(Level.FINE, "No specific message resource ID found for " + th);
        return null;
    }

    public Integer c(Throwable th) {
        Class<?> cls = th.getClass();
        Integer num = this.a.get(cls);
        if (num == null) {
            Class<? extends Throwable> cls2 = null;
            for (Map.Entry<Class<? extends Throwable>, Integer> entry : this.a.entrySet()) {
                Class<? extends Throwable> key = entry.getKey();
                if (key.isAssignableFrom(cls) && (cls2 == null || cls2.isAssignableFrom(key))) {
                    num = entry.getValue();
                    cls2 = key;
                }
            }
        }
        return num;
    }
}
