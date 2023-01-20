package h.p2.b0.g.t.c.f1.a;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: classes3.dex */
public final class n {
    @k.e.a.d
    public static final n a = new n();

    private n() {
    }

    @k.e.a.d
    public final String a(@k.e.a.d Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        int length = parameterTypes.length;
        int i2 = 0;
        while (i2 < length) {
            Class<?> cls = parameterTypes[i2];
            i2++;
            sb.append(ReflectClassUtilKt.b(cls));
        }
        sb.append(")V");
        return sb.toString();
    }

    @k.e.a.d
    public final String b(@k.e.a.d Field field) {
        return ReflectClassUtilKt.b(field.getType());
    }

    @k.e.a.d
    public final String c(@k.e.a.d Method method) {
        StringBuilder sb = new StringBuilder();
        sb.append("(");
        Class<?>[] parameterTypes = method.getParameterTypes();
        int length = parameterTypes.length;
        int i2 = 0;
        while (i2 < length) {
            Class<?> cls = parameterTypes[i2];
            i2++;
            sb.append(ReflectClassUtilKt.b(cls));
        }
        sb.append(")");
        sb.append(ReflectClassUtilKt.b(method.getReturnType()));
        return sb.toString();
    }
}
