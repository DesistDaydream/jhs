package h.p2.b0.g.s;

import h.p2.b0.g.q;
import h.p2.b0.g.t.c.j;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.c.m0;
import h.p2.b0.g.t.c.x0;
import h.p2.b0.g.t.n.z;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KotlinReflectionInternalError;
import kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a6\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\n0\t\"\n\b\u0000\u0010\n*\u0004\u0018\u00010\u000b*\b\u0012\u0004\u0012\u0002H\n0\t2\u0006\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\f\u001a\u00020\rH\u0000\u001a\u0018\u0010\u000e\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\u0018\u0010\u0011\u001a\u00020\u000f*\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0007\u001a\u00020\u0002H\u0000\u001a\f\u0010\u0012\u001a\u00020\r*\u00020\u0002H\u0002\u001a\u0014\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u0004\u0018\u00010\u0014H\u0000\u001a\u0012\u0010\u0013\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010*\u00020\u0001H\u0000\"\u001a\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0015"}, d2 = {"expectedReceiverType", "Lkotlin/reflect/jvm/internal/impl/types/KotlinType;", "Lkotlin/reflect/jvm/internal/impl/descriptors/CallableMemberDescriptor;", "getExpectedReceiverType", "(Lorg/jetbrains/kotlin/descriptors/CallableMemberDescriptor;)Lorg/jetbrains/kotlin/types/KotlinType;", "coerceToExpectedReceiverType", "", "descriptor", "createInlineClassAwareCallerIfNeeded", "Lkotlin/reflect/jvm/internal/calls/Caller;", "M", "Ljava/lang/reflect/Member;", "isDefault", "", "getBoxMethod", "Ljava/lang/reflect/Method;", "Ljava/lang/Class;", "getUnboxMethod", "hasInlineClassReceiver", "toInlineClass", "Lkotlin/reflect/jvm/internal/impl/descriptors/DeclarationDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class f {
    @k.e.a.e
    public static final Object a(@k.e.a.e Object obj, @k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        z e2;
        Class<?> i2;
        Method f2;
        return (((callableMemberDescriptor instanceof j0) && h.p2.b0.g.t.k.d.d((x0) callableMemberDescriptor)) || (e2 = e(callableMemberDescriptor)) == null || (i2 = i(e2)) == null || (f2 = f(i2, callableMemberDescriptor)) == null) ? obj : f2.invoke(obj, new Object[0]);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003f, code lost:
        if (h.p2.b0.g.t.k.d.c(r0) != true) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
        if (g(r5) == false) goto L17;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    @k.e.a.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <M extends java.lang.reflect.Member> h.p2.b0.g.s.b<M> b(@k.e.a.d h.p2.b0.g.s.b<? extends M> r4, @k.e.a.d kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor r5, boolean r6) {
        /*
            boolean r0 = h.p2.b0.g.t.k.d.a(r5)
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L4b
            java.util.List r0 = r5.h()
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L18
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L18
        L16:
            r0 = 0
            goto L33
        L18:
            java.util.Iterator r0 = r0.iterator()
        L1c:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L16
            java.lang.Object r3 = r0.next()
            h.p2.b0.g.t.c.v0 r3 = (h.p2.b0.g.t.c.v0) r3
            h.p2.b0.g.t.n.z r3 = r3.getType()
            boolean r3 = h.p2.b0.g.t.k.d.c(r3)
            if (r3 == 0) goto L1c
            r0 = 1
        L33:
            if (r0 != 0) goto L4b
            h.p2.b0.g.t.n.z r0 = r5.getReturnType()
            if (r0 == 0) goto L41
            boolean r0 = h.p2.b0.g.t.k.d.c(r0)
            if (r0 == r2) goto L4b
        L41:
            boolean r0 = r4 instanceof h.p2.b0.g.s.a
            if (r0 != 0) goto L4c
            boolean r0 = g(r5)
            if (r0 == 0) goto L4c
        L4b:
            r1 = 1
        L4c:
            if (r1 == 0) goto L54
            h.p2.b0.g.s.e r0 = new h.p2.b0.g.s.e
            r0.<init>(r5, r4, r6)
            r4 = r0
        L54:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: h.p2.b0.g.s.f.b(h.p2.b0.g.s.b, kotlin.reflect.jvm.internal.impl.descriptors.CallableMemberDescriptor, boolean):h.p2.b0.g.s.b");
    }

    public static /* synthetic */ b c(b bVar, CallableMemberDescriptor callableMemberDescriptor, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return b(bVar, callableMemberDescriptor, z);
    }

    @k.e.a.d
    public static final Method d(@k.e.a.d Class<?> cls, @k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        try {
            return cls.getDeclaredMethod("box-impl", f(cls, callableMemberDescriptor).getReturnType());
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No box method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final z e(CallableMemberDescriptor callableMemberDescriptor) {
        m0 Q = callableMemberDescriptor.Q();
        m0 M = callableMemberDescriptor.M();
        if (Q != null) {
            return Q.getType();
        }
        if (M == null) {
            return null;
        }
        if (callableMemberDescriptor instanceof j) {
            return M.getType();
        }
        k b = callableMemberDescriptor.b();
        if (!(b instanceof h.p2.b0.g.t.c.d)) {
            b = null;
        }
        h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) b;
        if (dVar != null) {
            return dVar.r();
        }
        return null;
    }

    @k.e.a.d
    public static final Method f(@k.e.a.d Class<?> cls, @k.e.a.d CallableMemberDescriptor callableMemberDescriptor) {
        try {
            return cls.getDeclaredMethod("unbox-impl", new Class[0]);
        } catch (NoSuchMethodException unused) {
            throw new KotlinReflectionInternalError("No unbox method found in inline class: " + cls + " (calling " + callableMemberDescriptor + ')');
        }
    }

    private static final boolean g(CallableMemberDescriptor callableMemberDescriptor) {
        z e2 = e(callableMemberDescriptor);
        return e2 != null && h.p2.b0.g.t.k.d.c(e2);
    }

    @k.e.a.e
    public static final Class<?> h(@k.e.a.e k kVar) {
        if ((kVar instanceof h.p2.b0.g.t.c.d) && h.p2.b0.g.t.k.d.b(kVar)) {
            h.p2.b0.g.t.c.d dVar = (h.p2.b0.g.t.c.d) kVar;
            Class<?> o = q.o(dVar);
            if (o != null) {
                return o;
            }
            throw new KotlinReflectionInternalError("Class object for the class " + dVar.getName() + " cannot be found (classId=" + DescriptorUtilsKt.h((h.p2.b0.g.t.c.f) kVar) + ')');
        }
        return null;
    }

    @k.e.a.e
    public static final Class<?> i(@k.e.a.d z zVar) {
        return h(zVar.I0().c());
    }
}
