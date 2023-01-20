package h.p2.b0.g.t.c.f1.b;

import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: classes3.dex */
public final class a {
    @k.e.a.d
    public static final a a = new a();
    @k.e.a.e
    private static C0441a b;

    /* renamed from: h.p2.b0.g.t.c.f1.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0441a {
        @k.e.a.e
        private final Method a;
        @k.e.a.e
        private final Method b;

        public C0441a(@k.e.a.e Method method, @k.e.a.e Method method2) {
            this.a = method;
            this.b = method2;
        }

        @k.e.a.e
        public final Method a() {
            return this.b;
        }

        @k.e.a.e
        public final Method b() {
            return this.a;
        }
    }

    private a() {
    }

    @k.e.a.d
    public final C0441a a(@k.e.a.d Member member) {
        Class<?> cls = member.getClass();
        try {
            return new C0441a(cls.getMethod("getParameters", new Class[0]), ReflectClassUtilKt.f(cls).loadClass("java.lang.reflect.Parameter").getMethod("getName", new Class[0]));
        } catch (NoSuchMethodException unused) {
            return new C0441a(null, null);
        }
    }

    @k.e.a.e
    public final List<String> b(@k.e.a.d Member member) {
        Method a2;
        C0441a c0441a = b;
        if (c0441a == null) {
            c0441a = a(member);
            b = c0441a;
        }
        Method b2 = c0441a.b();
        if (b2 == null || (a2 = c0441a.a()) == null) {
            return null;
        }
        Object invoke = b2.invoke(member, new Object[0]);
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type kotlin.Array<*>");
        Object[] objArr = (Object[]) invoke;
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            Object invoke2 = a2.invoke(obj, new Object[0]);
            Objects.requireNonNull(invoke2, "null cannot be cast to non-null type kotlin.String");
            arrayList.add((String) invoke2);
        }
        return arrayList;
    }
}
