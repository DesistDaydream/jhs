package e.t.u;

import androidx.core.graphics.drawable.IconCompat;
import h.k2.v.f0;
import h.k2.v.n0;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0002J \u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\n\u001a\u00020\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004J \u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\b\b\u0002\u0010\b\u001a\u00020\tJ$\u0010\u0003\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00042\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004¨\u0006\u000b"}, d2 = {"Lcom/vector/util/GenericUtil;", "", "()V", "getClassType", "Lkotlin/reflect/KClass;", "clz", "Ljava/lang/Class;", "destClz", "index", "", IconCompat.EXTRA_OBJ, "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    @k.e.a.d
    public static final j a = new j();

    private j() {
    }

    private final h.p2.d<?> a(Class<?> cls, int i2) {
        Type type = null;
        while (cls.getSuperclass() != null) {
            type = cls.getGenericSuperclass();
            if (type instanceof ParameterizedType) {
                break;
            }
            cls = cls.getSuperclass();
            Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<*>");
        }
        if (f0.g(cls, Object.class)) {
            return h.k2.a.g(cls);
        }
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.reflect.ParameterizedType");
        Type[] actualTypeArguments = ((ParameterizedType) type).getActualTypeArguments();
        if (i2 < actualTypeArguments.length && i2 >= 0) {
            if (!(actualTypeArguments[i2] instanceof Class)) {
                return n0.d(Object.class);
            }
            Type type2 = actualTypeArguments[i2];
            Objects.requireNonNull(type2, "null cannot be cast to non-null type java.lang.Class<*>");
            return h.k2.a.g((Class) type2);
        }
        throw new RuntimeException(f0.C("input index", i2 < 0 ? "can not less than 0" : "Total number of parameters exceeded"));
    }

    private final h.p2.d<?> b(Class<?> cls, Class<?> cls2) {
        while (cls.getSuperclass() != null) {
            Type genericSuperclass = cls.getGenericSuperclass();
            if (!(genericSuperclass instanceof ParameterizedType)) {
                cls = cls.getSuperclass();
                Objects.requireNonNull(cls, "null cannot be cast to non-null type java.lang.Class<*>");
            } else {
                Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
                int i2 = 0;
                int length = actualTypeArguments.length;
                while (i2 < length) {
                    Type type = actualTypeArguments[i2];
                    i2++;
                    Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<*>");
                    Class<?> cls3 = (Class) type;
                    if (cls2.isAssignableFrom(cls3)) {
                        return h.k2.a.g(cls3);
                    }
                }
                return null;
            }
        }
        return null;
    }

    public static /* synthetic */ h.p2.d f(j jVar, h.p2.d dVar, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return jVar.d(dVar, i2);
    }

    @k.e.a.e
    public final h.p2.d<?> c(@k.e.a.d Object obj, @k.e.a.d h.p2.d<?> dVar) {
        return b(obj.getClass(), h.k2.a.c(dVar));
    }

    @k.e.a.d
    public final h.p2.d<?> d(@k.e.a.d h.p2.d<?> dVar, int i2) {
        return a(h.k2.a.c(dVar), i2);
    }

    @k.e.a.e
    public final h.p2.d<?> e(@k.e.a.d h.p2.d<?> dVar, @k.e.a.d h.p2.d<?> dVar2) {
        return a.b(h.k2.a.c(dVar), h.k2.a.c(dVar2));
    }
}
