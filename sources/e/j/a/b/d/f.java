package e.j.a.b.d;

import android.os.IBinder;
import e.j.a.b.d.d;
import java.lang.reflect.Field;

@e.j.a.b.c.m.a
/* loaded from: classes2.dex */
public final class f<T> extends d.a {
    private final T b;

    private f(T t) {
        this.b = t;
    }

    @e.j.a.b.c.m.a
    public static <T> d b0(T t) {
        return new f(t);
    }

    @e.j.a.b.c.m.a
    public static <T> T c(d dVar) {
        if (dVar instanceof f) {
            return ((f) dVar).b;
        }
        IBinder asBinder = dVar.asBinder();
        Field[] declaredFields = asBinder.getClass().getDeclaredFields();
        Field field = null;
        int i2 = 0;
        for (Field field2 : declaredFields) {
            if (!field2.isSynthetic()) {
                i2++;
                field = field2;
            }
        }
        if (i2 == 1) {
            if (!field.isAccessible()) {
                field.setAccessible(true);
                try {
                    return (T) field.get(asBinder);
                } catch (IllegalAccessException e2) {
                    throw new IllegalArgumentException("Could not access the field in remoteBinder.", e2);
                } catch (NullPointerException e3) {
                    throw new IllegalArgumentException("Binder object is null.", e3);
                }
            }
            throw new IllegalArgumentException("IObjectWrapper declared field not private!");
        }
        int length = declaredFields.length;
        StringBuilder sb = new StringBuilder(64);
        sb.append("Unexpected number of IObjectWrapper declared fields: ");
        sb.append(length);
        throw new IllegalArgumentException(sb.toString());
    }
}
