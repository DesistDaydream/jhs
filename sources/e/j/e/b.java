package e.j.e;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class b {
    private final Field a;

    public b(Field field) {
        e.j.e.s.a.b(field);
        this.a = field;
    }

    public Object a(Object obj) throws IllegalAccessException {
        return this.a.get(obj);
    }

    public <T extends Annotation> T b(Class<T> cls) {
        return (T) this.a.getAnnotation(cls);
    }

    public Collection<Annotation> c() {
        return Arrays.asList(this.a.getAnnotations());
    }

    public Class<?> d() {
        return this.a.getType();
    }

    public Type e() {
        return this.a.getGenericType();
    }

    public Class<?> f() {
        return this.a.getDeclaringClass();
    }

    public String g() {
        return this.a.getName();
    }

    public boolean h(int i2) {
        return (i2 & this.a.getModifiers()) != 0;
    }

    public boolean i() {
        return this.a.isSynthetic();
    }
}
