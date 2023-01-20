package kotlin.reflect.full;

import h.k2.g;
import h.k2.v.f0;
import h.p2.c;
import h.s0;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.reflect.KParameter;

@g(name = "KCallables")
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a9\u0010\u000f\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00130\u0012\"\u0004\u0018\u00010\u0013H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0014\u001a7\u0010\u0015\u001a\u0002H\u0010\"\u0004\b\u0000\u0010\u0010*\b\u0012\u0004\u0012\u0002H\u00100\u00022\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u0016H\u0087@ø\u0001\u0000¢\u0006\u0002\u0010\u0017\u001a\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\"$\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"$\u0010\u0007\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"(\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b*\u0006\u0012\u0002\b\u00030\u00028FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001b"}, d2 = {"extensionReceiverParameter", "Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KCallable;", "getExtensionReceiverParameter$annotations", "(Lkotlin/reflect/KCallable;)V", "getExtensionReceiverParameter", "(Lkotlin/reflect/KCallable;)Lkotlin/reflect/KParameter;", "instanceParameter", "getInstanceParameter$annotations", "getInstanceParameter", "valueParameters", "", "getValueParameters$annotations", "getValueParameters", "(Lkotlin/reflect/KCallable;)Ljava/util/List;", "callSuspend", "R", "args", "", "", "(Lkotlin/reflect/KCallable;[Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "callSuspendBy", "", "(Lkotlin/reflect/KCallable;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "findParameterByName", "name", "", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KCallables {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0039  */
    @k.e.a.e
    @h.s0(version = "1.3")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object a(@k.e.a.d h.p2.c<? extends R> r4, @k.e.a.d java.lang.Object[] r5, @k.e.a.d h.e2.c<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables$callSuspend$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.KCallables$callSuspend$1 r0 = (kotlin.reflect.full.KCallables$callSuspend$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlin.reflect.full.KCallables$callSuspend$1 r0 = new kotlin.reflect.full.KCallables$callSuspend$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r4 = r0.L$1
            java.lang.Object[] r4 = (java.lang.Object[]) r4
            java.lang.Object r4 = r0.L$0
            h.p2.c r4 = (h.p2.c) r4
            h.r0.n(r6)
            goto L7c
        L31:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L39:
            h.r0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4c
            int r6 = r5.length
            java.lang.Object[] r5 = java.util.Arrays.copyOf(r5, r6)
            java.lang.Object r4 = r4.call(r5)
            return r4
        L4c:
            boolean r6 = r4 instanceof h.p2.i
            if (r6 == 0) goto L9e
            r0.L$0 = r4
            r0.L$1 = r5
            r0.label = r3
            h.k2.v.r0 r6 = new h.k2.v.r0
            r2 = 2
            r6.<init>(r2)
            r6.b(r5)
            r6.a(r0)
            int r5 = r6.c()
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Object[] r5 = r6.d(r5)
            java.lang.Object r6 = r4.call(r5)
            java.lang.Object r5 = h.e2.j.b.h()
            if (r6 != r5) goto L79
            h.e2.k.a.f.c(r0)
        L79:
            if (r6 != r1) goto L7c
            return r1
        L7c:
            h.p2.r r5 = r4.getReturnType()
            h.p2.g r5 = r5.a()
            java.lang.Class<h.t1> r0 = h.t1.class
            h.p2.d r0 = h.k2.v.n0.d(r0)
            boolean r5 = h.k2.v.f0.g(r5, r0)
            if (r5 == 0) goto L9d
            h.p2.r r4 = r4.getReturnType()
            boolean r4 = r4.b()
            if (r4 != 0) goto L9d
            h.t1 r4 = h.t1.a
            return r4
        L9d:
            return r6
        L9e:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspend on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.a(h.p2.c, java.lang.Object[], h.e2.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARN: Type inference failed for: r2v1, types: [T, kotlin.reflect.jvm.internal.KCallableImpl] */
    @k.e.a.e
    @h.s0(version = "1.3")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <R> java.lang.Object b(@k.e.a.d h.p2.c<? extends R> r4, @k.e.a.d java.util.Map<kotlin.reflect.KParameter, ? extends java.lang.Object> r5, @k.e.a.d h.e2.c<? super R> r6) {
        /*
            boolean r0 = r6 instanceof kotlin.reflect.full.KCallables$callSuspendBy$1
            if (r0 == 0) goto L13
            r0 = r6
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = (kotlin.reflect.full.KCallables$callSuspendBy$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            kotlin.reflect.full.KCallables$callSuspendBy$1 r0 = new kotlin.reflect.full.KCallables$callSuspendBy$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = h.e2.j.b.h()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L3d
            if (r2 != r3) goto L35
            java.lang.Object r4 = r0.L$2
            kotlin.jvm.internal.Ref$ObjectRef r4 = (kotlin.jvm.internal.Ref.ObjectRef) r4
            java.lang.Object r4 = r0.L$1
            java.util.Map r4 = (java.util.Map) r4
            java.lang.Object r4 = r0.L$0
            h.p2.c r4 = (h.p2.c) r4
            h.r0.n(r6)
            goto L76
        L35:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3d:
            h.r0.n(r6)
            boolean r6 = r4.isSuspend()
            if (r6 != 0) goto L4b
            java.lang.Object r4 = r4.callBy(r5)
            return r4
        L4b:
            boolean r6 = r4 instanceof h.p2.i
            if (r6 == 0) goto Laf
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
            kotlin.reflect.jvm.internal.KCallableImpl r2 = h.p2.b0.g.q.a(r4)
            if (r2 == 0) goto L98
            r6.element = r2
            r0.L$0 = r4
            r0.L$1 = r5
            r0.L$2 = r6
            r0.label = r3
            kotlin.reflect.jvm.internal.KCallableImpl r2 = (kotlin.reflect.jvm.internal.KCallableImpl) r2
            java.lang.Object r6 = r2.l(r5, r0)
            java.lang.Object r5 = h.e2.j.b.h()
            if (r6 != r5) goto L73
            h.e2.k.a.f.c(r0)
        L73:
            if (r6 != r1) goto L76
            return r1
        L76:
            h.p2.r r5 = r4.getReturnType()
            h.p2.g r5 = r5.a()
            java.lang.Class<h.t1> r0 = h.t1.class
            h.p2.d r0 = h.k2.v.n0.d(r0)
            boolean r5 = h.k2.v.f0.g(r5, r0)
            if (r5 == 0) goto L97
            h.p2.r r4 = r4.getReturnType()
            boolean r4 = r4.b()
            if (r4 != 0) goto L97
            h.t1 r4 = h.t1.a
            return r4
        L97:
            return r6
        L98:
            kotlin.reflect.jvm.internal.KotlinReflectionInternalError r5 = new kotlin.reflect.jvm.internal.KotlinReflectionInternalError
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "This callable does not support a default call: "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        Laf:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Cannot callSuspendBy on a property "
            r6.append(r0)
            r6.append(r4)
            java.lang.String r4 = ": suspend properties are not supported yet"
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            r5.<init>(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.full.KCallables.b(h.p2.c, java.util.Map, h.e2.c):java.lang.Object");
    }

    @e
    @s0(version = "1.1")
    public static final KParameter c(@d c<?> cVar, @d String str) {
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        boolean z = false;
        Object obj2 = null;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (f0.g(((KParameter) next).getName(), str)) {
                    if (z) {
                        break;
                    }
                    z = true;
                    obj2 = next;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @e
    public static final KParameter d(@d c<?> cVar) {
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).i() == KParameter.Kind.EXTENSION_RECEIVER) {
                    if (z) {
                        break;
                    }
                    obj2 = next;
                    z = true;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void e(c cVar) {
    }

    @e
    public static final KParameter f(@d c<?> cVar) {
        Iterator<T> it = cVar.getParameters().iterator();
        Object obj = null;
        Object obj2 = null;
        boolean z = false;
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (((KParameter) next).i() == KParameter.Kind.INSTANCE) {
                    if (z) {
                        break;
                    }
                    obj2 = next;
                    z = true;
                }
            } else if (z) {
                obj = obj2;
            }
        }
        return (KParameter) obj;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void g(c cVar) {
    }

    @d
    public static final List<KParameter> h(@d c<?> cVar) {
        List<KParameter> parameters = cVar.getParameters();
        ArrayList arrayList = new ArrayList();
        for (Object obj : parameters) {
            if (((KParameter) obj).i() == KParameter.Kind.VALUE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    @s0(version = "1.1")
    public static /* synthetic */ void i(c cVar) {
    }
}
