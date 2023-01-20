package l;

import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

/* loaded from: classes4.dex */
public interface e<R, T> {

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static Type getParameterUpperBound(int i2, ParameterizedType parameterizedType) {
            return w.g(i2, parameterizedType);
        }

        public static Class<?> getRawType(Type type) {
            return w.h(type);
        }

        @Nullable
        public abstract e<?, ?> get(Type type, Annotation[] annotationArr, s sVar);
    }

    T adapt(d<R> dVar);

    Type responseType();
}
