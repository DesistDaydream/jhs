package e.j.e.s;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/* loaded from: classes2.dex */
public abstract class j {

    /* loaded from: classes2.dex */
    public class a extends j {
        public final /* synthetic */ Method a;
        public final /* synthetic */ Object b;

        public a(Method method, Object obj) {
            this.a = method;
            this.b = obj;
        }

        @Override // e.j.e.s.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(this.b, cls);
        }
    }

    /* loaded from: classes2.dex */
    public class b extends j {
        public final /* synthetic */ Method a;
        public final /* synthetic */ int b;

        public b(Method method, int i2) {
            this.a = method;
            this.b = i2;
        }

        @Override // e.j.e.s.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(null, cls, Integer.valueOf(this.b));
        }
    }

    /* loaded from: classes2.dex */
    public class c extends j {
        public final /* synthetic */ Method a;

        public c(Method method) {
            this.a = method;
        }

        @Override // e.j.e.s.j
        public <T> T c(Class<T> cls) throws Exception {
            j.a(cls);
            return (T) this.a.invoke(null, cls, Object.class);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends j {
        @Override // e.j.e.s.j
        public <T> T c(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    public static void a(Class<?> cls) {
        int modifiers = cls.getModifiers();
        if (!Modifier.isInterface(modifiers)) {
            if (Modifier.isAbstract(modifiers)) {
                throw new UnsupportedOperationException("Abstract class can't be instantiated! Class name: " + cls.getName());
            }
            return;
        }
        throw new UnsupportedOperationException("Interface can't be instantiated! Interface name: " + cls.getName());
    }

    public static j b() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public abstract <T> T c(Class<T> cls) throws Exception;
}
