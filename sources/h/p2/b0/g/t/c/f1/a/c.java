package h.p2.b0.g.t.c.f1.a;

import h.k2.v.f0;
import h.p2.b0.g.t.b.g;
import h.p2.b0.g.t.e.b.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;
import java.util.Set;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.impl.builtins.PrimitiveType;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;
import kotlin.reflect.jvm.internal.impl.resolve.jvm.JvmPrimitiveType;

/* loaded from: classes3.dex */
public final class c {
    @k.e.a.d
    public static final c a = new c();

    private c() {
    }

    private final h.p2.b0.g.t.k.n.f a(Class<?> cls) {
        int i2 = 0;
        while (cls.isArray()) {
            i2++;
            cls = cls.getComponentType();
        }
        if (cls.isPrimitive()) {
            if (f0.g(cls, Void.TYPE)) {
                return new h.p2.b0.g.t.k.n.f(h.p2.b0.g.t.g.b.m(g.a.f15039f.l()), i2);
            }
            PrimitiveType primitiveType = JvmPrimitiveType.get(cls.getName()).getPrimitiveType();
            if (i2 > 0) {
                return new h.p2.b0.g.t.k.n.f(h.p2.b0.g.t.g.b.m(primitiveType.getArrayTypeFqName()), i2 - 1);
            }
            return new h.p2.b0.g.t.k.n.f(h.p2.b0.g.t.g.b.m(primitiveType.getTypeFqName()), i2);
        }
        h.p2.b0.g.t.g.b a2 = ReflectClassUtilKt.a(cls);
        h.p2.b0.g.t.g.b n = h.p2.b0.g.t.b.k.c.a.n(a2.b());
        if (n != null) {
            a2 = n;
        }
        return new h.p2.b0.g.t.k.n.f(a2, i2);
    }

    private final void c(Class<?> cls, m.d dVar) {
        Constructor<?>[] constructorArr;
        int i2;
        int i3;
        Constructor<?>[] declaredConstructors = cls.getDeclaredConstructors();
        int length = declaredConstructors.length;
        int i4 = 0;
        while (i4 < length) {
            Constructor<?> constructor = declaredConstructors[i4];
            int i5 = i4 + 1;
            m.e b = dVar.b(h.p2.b0.g.t.g.f.i("<init>"), n.a.a(constructor));
            if (b == null) {
                constructorArr = declaredConstructors;
                i2 = length;
                i3 = i5;
            } else {
                Annotation[] declaredAnnotations = constructor.getDeclaredAnnotations();
                int length2 = declaredAnnotations.length;
                int i6 = 0;
                while (i6 < length2) {
                    Annotation annotation = declaredAnnotations[i6];
                    i6++;
                    f(b, annotation);
                }
                Annotation[][] parameterAnnotations = constructor.getParameterAnnotations();
                if (!(parameterAnnotations.length == 0)) {
                    int length3 = constructor.getParameterTypes().length - parameterAnnotations.length;
                    int length4 = parameterAnnotations.length;
                    int i7 = 0;
                    while (i7 < length4) {
                        Annotation[] annotationArr = parameterAnnotations[i7];
                        int i8 = i7 + 1;
                        int length5 = annotationArr.length;
                        int i9 = 0;
                        while (i9 < length5) {
                            Annotation annotation2 = annotationArr[i9];
                            i9++;
                            Class<?> c2 = h.k2.a.c(h.k2.a.a(annotation2));
                            Constructor<?>[] constructorArr2 = declaredConstructors;
                            int i10 = length;
                            int i11 = i5;
                            m.a b2 = b.b(i7 + length3, ReflectClassUtilKt.a(c2), new b(annotation2));
                            if (b2 != null) {
                                a.h(b2, annotation2, c2);
                            }
                            declaredConstructors = constructorArr2;
                            length = i10;
                            i5 = i11;
                        }
                        i7 = i8;
                    }
                }
                constructorArr = declaredConstructors;
                i2 = length;
                i3 = i5;
                b.a();
            }
            declaredConstructors = constructorArr;
            length = i2;
            i4 = i3;
        }
    }

    private final void d(Class<?> cls, m.d dVar) {
        Field[] declaredFields = cls.getDeclaredFields();
        int length = declaredFields.length;
        int i2 = 0;
        while (i2 < length) {
            Field field = declaredFields[i2];
            i2++;
            m.c a2 = dVar.a(h.p2.b0.g.t.g.f.f(field.getName()), n.a.b(field), null);
            if (a2 != null) {
                Annotation[] declaredAnnotations = field.getDeclaredAnnotations();
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    f(a2, annotation);
                }
                a2.a();
            }
        }
    }

    private final void e(Class<?> cls, m.d dVar) {
        Method[] methodArr;
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            m.e b = dVar.b(h.p2.b0.g.t.g.f.f(method.getName()), n.a.c(method));
            if (b == null) {
                methodArr = declaredMethods;
            } else {
                Annotation[] declaredAnnotations = method.getDeclaredAnnotations();
                int length2 = declaredAnnotations.length;
                int i3 = 0;
                while (i3 < length2) {
                    Annotation annotation = declaredAnnotations[i3];
                    i3++;
                    f(b, annotation);
                }
                Annotation[][] parameterAnnotations = method.getParameterAnnotations();
                int length3 = parameterAnnotations.length;
                int i4 = 0;
                while (i4 < length3) {
                    Annotation[] annotationArr = parameterAnnotations[i4];
                    int i5 = i4 + 1;
                    int length4 = annotationArr.length;
                    int i6 = 0;
                    while (i6 < length4) {
                        Annotation annotation2 = annotationArr[i6];
                        i6++;
                        Class<?> c2 = h.k2.a.c(h.k2.a.a(annotation2));
                        Method[] methodArr2 = declaredMethods;
                        m.a b2 = b.b(i4, ReflectClassUtilKt.a(c2), new b(annotation2));
                        if (b2 != null) {
                            a.h(b2, annotation2, c2);
                        }
                        declaredMethods = methodArr2;
                    }
                    i4 = i5;
                }
                methodArr = declaredMethods;
                b.a();
            }
            declaredMethods = methodArr;
        }
    }

    private final void f(m.c cVar, Annotation annotation) {
        Class<?> c2 = h.k2.a.c(h.k2.a.a(annotation));
        m.a c3 = cVar.c(ReflectClassUtilKt.a(c2), new b(annotation));
        if (c3 == null) {
            return;
        }
        a.h(c3, annotation, c2);
    }

    private final void g(m.a aVar, h.p2.b0.g.t.g.f fVar, Object obj) {
        Set set;
        Class<?> cls = obj.getClass();
        if (!f0.g(cls, Class.class)) {
            set = i.a;
            if (set.contains(cls)) {
                aVar.e(fVar, obj);
                return;
            } else if (ReflectClassUtilKt.h(cls)) {
                if (!cls.isEnum()) {
                    cls = cls.getEnclosingClass();
                }
                aVar.b(fVar, ReflectClassUtilKt.a(cls), h.p2.b0.g.t.g.f.f(((Enum) obj).name()));
                return;
            } else if (Annotation.class.isAssignableFrom(cls)) {
                Class<?> cls2 = (Class) ArraysKt___ArraysKt.Cs(cls.getInterfaces());
                m.a c2 = aVar.c(fVar, ReflectClassUtilKt.a(cls2));
                if (c2 == null) {
                    return;
                }
                h(c2, (Annotation) obj, cls2);
                return;
            } else if (cls.isArray()) {
                m.b f2 = aVar.f(fVar);
                if (f2 == null) {
                    return;
                }
                Class<?> componentType = cls.getComponentType();
                int i2 = 0;
                if (componentType.isEnum()) {
                    h.p2.b0.g.t.g.b a2 = ReflectClassUtilKt.a(componentType);
                    Object[] objArr = (Object[]) obj;
                    int length = objArr.length;
                    while (i2 < length) {
                        Object obj2 = objArr[i2];
                        i2++;
                        Objects.requireNonNull(obj2, "null cannot be cast to non-null type kotlin.Enum<*>");
                        f2.d(a2, h.p2.b0.g.t.g.f.f(((Enum) obj2).name()));
                    }
                } else if (f0.g(componentType, Class.class)) {
                    Object[] objArr2 = (Object[]) obj;
                    int length2 = objArr2.length;
                    while (i2 < length2) {
                        Object obj3 = objArr2[i2];
                        i2++;
                        Objects.requireNonNull(obj3, "null cannot be cast to non-null type java.lang.Class<*>");
                        f2.e(a((Class) obj3));
                    }
                } else if (Annotation.class.isAssignableFrom(componentType)) {
                    Object[] objArr3 = (Object[]) obj;
                    int length3 = objArr3.length;
                    while (i2 < length3) {
                        Object obj4 = objArr3[i2];
                        i2++;
                        m.a b = f2.b(ReflectClassUtilKt.a(componentType));
                        if (b != null) {
                            Objects.requireNonNull(obj4, "null cannot be cast to non-null type kotlin.Annotation");
                            h(b, (Annotation) obj4, componentType);
                        }
                    }
                } else {
                    Object[] objArr4 = (Object[]) obj;
                    int length4 = objArr4.length;
                    while (i2 < length4) {
                        Object obj5 = objArr4[i2];
                        i2++;
                        f2.c(obj5);
                    }
                }
                f2.a();
                return;
            } else {
                throw new UnsupportedOperationException("Unsupported annotation argument value (" + cls + "): " + obj);
            }
        }
        aVar.d(fVar, a((Class) obj));
    }

    private final void h(m.a aVar, Annotation annotation, Class<?> cls) {
        Method[] declaredMethods = cls.getDeclaredMethods();
        int length = declaredMethods.length;
        int i2 = 0;
        while (i2 < length) {
            Method method = declaredMethods[i2];
            i2++;
            try {
                g(aVar, h.p2.b0.g.t.g.f.f(method.getName()), method.invoke(annotation, new Object[0]));
            } catch (IllegalAccessException unused) {
            }
        }
        aVar.a();
    }

    public final void b(@k.e.a.d Class<?> cls, @k.e.a.d m.c cVar) {
        Annotation[] declaredAnnotations = cls.getDeclaredAnnotations();
        int length = declaredAnnotations.length;
        int i2 = 0;
        while (i2 < length) {
            Annotation annotation = declaredAnnotations[i2];
            i2++;
            f(cVar, annotation);
        }
        cVar.a();
    }

    public final void i(@k.e.a.d Class<?> cls, @k.e.a.d m.d dVar) {
        e(cls, dVar);
        c(cls, dVar);
        d(cls, dVar);
    }
}
