package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public interface h<F, T> {

    /* loaded from: classes4.dex */
    public static abstract class a {
        public static Type a(int i2, ParameterizedType parameterizedType) {
            return w.g(i2, parameterizedType);
        }

        public static Class<?> b(Type type) {
            return w.h(type);
        }

        @Nullable
        public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
            return null;
        }

        @Nullable
        public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }

        @Nullable
        public h<?, String> e(Type type, Annotation[] annotationArr, s sVar) {
            return null;
        }
    }

    @Nullable
    T convert(F f2) throws IOException;
}
