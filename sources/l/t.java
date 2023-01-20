package l;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public abstract class t<T> {
    public static <T> t<T> b(s sVar, Method method) {
        q b = q.b(sVar, method);
        Type genericReturnType = method.getGenericReturnType();
        if (!w.j(genericReturnType)) {
            if (genericReturnType != Void.TYPE) {
                return j.f(sVar, method, b);
            }
            throw w.m(method, "Service methods cannot return void.", new Object[0]);
        }
        throw w.m(method, "Method return type must not include a type variable or wildcard: %s", genericReturnType);
    }

    @Nullable
    public abstract T a(Object[] objArr);
}
