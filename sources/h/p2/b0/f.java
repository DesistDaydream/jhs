package h.p2.b0;

import androidx.exifinterface.media.ExifInterface;
import h.k2.g;
import h.k2.v.f0;
import h.p2.b0.g.q;
import h.p2.h;
import h.p2.i;
import h.p2.j;
import h.p2.n;
import h.p2.p;
import h.p2.r;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.reflect.TypesJVMKt;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.internal.KCallableImpl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KPropertyImpl;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;

@g(name = "ReflectJvmMapping")
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010%\u001a\u0004\u0018\u00010&*\u00020'H\u0002\"/\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u001b\u0010\b\u001a\u0004\u0018\u00010\t*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u001b\u0010\r\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\n8F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\"\u001b\u0010\u0011\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013\"\u001b\u0010\u0014\u001a\u0004\u0018\u00010\u000e*\u0006\u0012\u0002\b\u00030\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\"\u0015\u0010\u0018\u001a\u00020\u0019*\u00020\u001a8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c\"-\u0010\u001d\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0003\"\b\b\u0000\u0010\u0002*\u00020\u001e*\b\u0012\u0004\u0012\u0002H\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 \"\u001b\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0003*\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!\"\u001b\u0010\"\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n*\u00020\t8F¢\u0006\u0006\u001a\u0004\b#\u0010$¨\u0006("}, d2 = {"javaConstructor", "Ljava/lang/reflect/Constructor;", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/reflect/KFunction;", "getJavaConstructor$annotations", "(Lkotlin/reflect/KFunction;)V", "getJavaConstructor", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Constructor;", "javaField", "Ljava/lang/reflect/Field;", "Lkotlin/reflect/KProperty;", "getJavaField", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Field;", "javaGetter", "Ljava/lang/reflect/Method;", "getJavaGetter", "(Lkotlin/reflect/KProperty;)Ljava/lang/reflect/Method;", "javaMethod", "getJavaMethod", "(Lkotlin/reflect/KFunction;)Ljava/lang/reflect/Method;", "javaSetter", "Lkotlin/reflect/KMutableProperty;", "getJavaSetter", "(Lkotlin/reflect/KMutableProperty;)Ljava/lang/reflect/Method;", "javaType", "Ljava/lang/reflect/Type;", "Lkotlin/reflect/KType;", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "kotlinFunction", "", "getKotlinFunction", "(Ljava/lang/reflect/Constructor;)Lkotlin/reflect/KFunction;", "(Ljava/lang/reflect/Method;)Lkotlin/reflect/KFunction;", "kotlinProperty", "getKotlinProperty", "(Ljava/lang/reflect/Field;)Lkotlin/reflect/KProperty;", "getKPackage", "Lkotlin/reflect/KDeclarationContainer;", "Ljava/lang/reflect/Member;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class f {
    @k.e.a.e
    public static final <T> Constructor<T> a(@k.e.a.d i<? extends T> iVar) {
        h.p2.b0.g.s.b<?> G;
        KCallableImpl<?> a = q.a(iVar);
        Object b = (a == null || (G = a.G()) == null) ? null : G.b();
        return b instanceof Constructor ? b : null;
    }

    public static /* synthetic */ void b(i iVar) {
    }

    @k.e.a.e
    public static final Field c(@k.e.a.d n<?> nVar) {
        KPropertyImpl<?> c2 = q.c(nVar);
        if (c2 != null) {
            return c2.S();
        }
        return null;
    }

    @k.e.a.e
    public static final Method d(@k.e.a.d n<?> nVar) {
        return e(nVar.getGetter());
    }

    @k.e.a.e
    public static final Method e(@k.e.a.d i<?> iVar) {
        h.p2.b0.g.s.b<?> G;
        KCallableImpl<?> a = q.a(iVar);
        Object b = (a == null || (G = a.G()) == null) ? null : G.b();
        return b instanceof Method ? b : null;
    }

    @k.e.a.e
    public static final Method f(@k.e.a.d j<?> jVar) {
        return e(jVar.getSetter());
    }

    @k.e.a.d
    public static final Type g(@k.e.a.d r rVar) {
        Type c2 = ((KTypeImpl) rVar).c();
        return c2 != null ? c2 : TypesJVMKt.f(rVar);
    }

    private static final h h(Member member) {
        KotlinClassHeader c2;
        h.p2.b0.g.t.c.f1.a.f a = h.p2.b0.g.t.c.f1.a.f.f15191c.a(member.getDeclaringClass());
        KotlinClassHeader.Kind c3 = (a == null || (c2 = a.c()) == null) ? null : c2.c();
        if (c3 == null) {
            return null;
        }
        int i2 = e.a[c3.ordinal()];
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            return new KPackageImpl(member.getDeclaringClass(), null, 2, null);
        }
        return null;
    }

    @k.e.a.e
    public static final <T> i<T> i(@k.e.a.d Constructor<T> constructor) {
        T t;
        Iterator<T> it = h.k2.a.g(constructor.getDeclaringClass()).g().iterator();
        while (true) {
            if (!it.hasNext()) {
                t = null;
                break;
            }
            t = it.next();
            if (f0.g(a((i) t), constructor)) {
                break;
            }
        }
        return (i) t;
    }

    @k.e.a.e
    public static final i<?> j(@k.e.a.d Method method) {
        Object obj;
        boolean z;
        Object obj2 = null;
        if (Modifier.isStatic(method.getModifiers())) {
            h h2 = h(method);
            if (h2 != null) {
                Collection<h.p2.c<?>> q = h2.q();
                ArrayList arrayList = new ArrayList();
                for (Object obj3 : q) {
                    if (obj3 instanceof i) {
                        arrayList.add(obj3);
                    }
                }
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Object next = it.next();
                    if (f0.g(e((i) next), method)) {
                        obj2 = next;
                        break;
                    }
                }
                return (i) obj2;
            }
            h.p2.d<?> g2 = KClasses.g(h.k2.a.g(method.getDeclaringClass()));
            if (g2 != null) {
                Iterator<T> it2 = KClasses.y(g2).iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    Method e2 = e((i) obj);
                    if (e2 != null && f0.g(e2.getName(), method.getName()) && Arrays.equals(e2.getParameterTypes(), method.getParameterTypes()) && f0.g(e2.getReturnType(), method.getReturnType())) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                }
                i<?> iVar = (i) obj;
                if (iVar != null) {
                    return iVar;
                }
            }
        }
        Iterator<T> it3 = KClasses.y(h.k2.a.g(method.getDeclaringClass())).iterator();
        while (true) {
            if (!it3.hasNext()) {
                break;
            }
            Object next2 = it3.next();
            if (f0.g(e((i) next2), method)) {
                obj2 = next2;
                break;
            }
        }
        return (i) obj2;
    }

    @k.e.a.e
    public static final n<?> k(@k.e.a.d Field field) {
        Object obj = null;
        if (field.isSynthetic()) {
            return null;
        }
        h h2 = h(field);
        if (h2 != null) {
            Collection<h.p2.c<?>> q = h2.q();
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : q) {
                if (obj2 instanceof n) {
                    arrayList.add(obj2);
                }
            }
            Iterator it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (f0.g(c((n) next), field)) {
                    obj = next;
                    break;
                }
            }
            return (n) obj;
        }
        Iterator it2 = KClasses.G(h.k2.a.g(field.getDeclaringClass())).iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            Object next2 = it2.next();
            if (f0.g(c((p) next2), field)) {
                obj = next2;
                break;
            }
        }
        return (n) obj;
    }
}
