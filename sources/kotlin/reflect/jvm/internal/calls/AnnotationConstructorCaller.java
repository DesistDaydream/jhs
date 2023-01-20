package kotlin.reflect.jvm.internal.calls;

import h.a2.t0;
import h.a2.u;
import h.p2.b0.g.s.b;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\b\u0004\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001:\u0002 !B?\u0012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006¢\u0006\u0002\u0010\u000eJ\u001b\u0010\u001c\u001a\u0004\u0018\u00010\u00102\n\u0010\u001d\u001a\u0006\u0012\u0002\b\u00030\u001eH\u0016¢\u0006\u0002\u0010\u001fR\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00040\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\""}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller;", "Lkotlin/reflect/jvm/internal/calls/Caller;", "", "jClass", "Ljava/lang/Class;", "parameterNames", "", "", "callMode", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "origin", "Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "methods", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/util/List;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;Ljava/util/List;)V", "defaultValues", "", "erasedParameterTypes", "member", "getMember", "()Ljava/lang/Void;", "parameterTypes", "Ljava/lang/reflect/Type;", "getParameterTypes", "()Ljava/util/List;", "returnType", "getReturnType", "()Ljava/lang/reflect/Type;", "call", "args", "", "([Ljava/lang/Object;)Ljava/lang/Object;", "CallMode", "Origin", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class AnnotationConstructorCaller implements b {
    @d
    private final List<Type> a;
    private final List<Class<?>> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<Object> f16400c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<?> f16401d;

    /* renamed from: e  reason: collision with root package name */
    private final List<String> f16402e;

    /* renamed from: f  reason: collision with root package name */
    private final CallMode f16403f;

    /* renamed from: g  reason: collision with root package name */
    private final List<Method> f16404g;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$CallMode;", "", "(Ljava/lang/String;I)V", "CALL_BY_NAME", "POSITIONAL_CALL", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public enum CallMode {
        CALL_BY_NAME,
        POSITIONAL_CALL
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lkotlin/reflect/jvm/internal/calls/AnnotationConstructorCaller$Origin;", "", "(Ljava/lang/String;I)V", "JAVA", "KOTLIN", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
    /* loaded from: classes3.dex */
    public enum Origin {
        JAVA,
        KOTLIN
    }

    public AnnotationConstructorCaller(@d Class<?> cls, @d List<String> list, @d CallMode callMode, @d Origin origin, @d List<Method> list2) {
        this.f16401d = cls;
        this.f16402e = list;
        this.f16403f = callMode;
        this.f16404g = list2;
        ArrayList arrayList = new ArrayList(u.Y(list2, 10));
        for (Method method : list2) {
            arrayList.add(method.getGenericReturnType());
        }
        this.a = arrayList;
        List<Method> list3 = this.f16404g;
        ArrayList arrayList2 = new ArrayList(u.Y(list3, 10));
        for (Method method2 : list3) {
            Class<?> returnType = method2.getReturnType();
            Class<?> g2 = ReflectClassUtilKt.g(returnType);
            if (g2 != null) {
                returnType = g2;
            }
            arrayList2.add(returnType);
        }
        this.b = arrayList2;
        List<Method> list4 = this.f16404g;
        ArrayList arrayList3 = new ArrayList(u.Y(list4, 10));
        for (Method method3 : list4) {
            arrayList3.add(method3.getDefaultValue());
        }
        this.f16400c = arrayList3;
        if (this.f16403f == CallMode.POSITIONAL_CALL && origin == Origin.JAVA && (!CollectionsKt___CollectionsKt.d4(this.f16402e, "value").isEmpty())) {
            throw new UnsupportedOperationException("Positional call of a Java annotation constructor is allowed only if there are no parameters or one parameter named \"value\". This restriction exists because Java annotations (in contrast to Kotlin)do not impose any order on their arguments. Use KCallable#callBy instead.");
        }
    }

    @Override // h.p2.b0.g.s.b
    @d
    public List<Type> a() {
        return this.a;
    }

    @Override // h.p2.b0.g.s.b
    public /* bridge */ /* synthetic */ Member b() {
        return (Member) d();
    }

    public void c(@d Object[] objArr) {
        b.a.a(this, objArr);
    }

    @Override // h.p2.b0.g.s.b
    @e
    public Object call(@d Object[] objArr) {
        c(objArr);
        ArrayList arrayList = new ArrayList(objArr.length);
        int length = objArr.length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            Object obj = objArr[i2];
            int i4 = i3 + 1;
            Object f2 = (obj == null && this.f16403f == CallMode.CALL_BY_NAME) ? this.f16400c.get(i3) : AnnotationConstructorCallerKt.f(obj, this.b.get(i3));
            if (f2 == null) {
                AnnotationConstructorCallerKt.e(i3, this.f16402e.get(i3), this.b.get(i3));
                throw null;
            }
            arrayList.add(f2);
            i2++;
            i3 = i4;
        }
        return AnnotationConstructorCallerKt.c(this.f16401d, t0.B0(CollectionsKt___CollectionsKt.V5(this.f16402e, arrayList)), this.f16404g);
    }

    @e
    public Void d() {
        return null;
    }

    @Override // h.p2.b0.g.s.b
    @d
    public Type getReturnType() {
        return this.f16401d;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AnnotationConstructorCaller(java.lang.Class r7, java.util.List r8, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.CallMode r9, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.Origin r10, java.util.List r11, int r12, h.k2.v.u r13) {
        /*
            r6 = this;
            r12 = r12 & 16
            if (r12 == 0) goto L2a
            java.util.ArrayList r11 = new java.util.ArrayList
            r12 = 10
            int r12 = h.a2.u.Y(r8, r12)
            r11.<init>(r12)
            java.util.Iterator r12 = r8.iterator()
        L13:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L2a
            java.lang.Object r13 = r12.next()
            java.lang.String r13 = (java.lang.String) r13
            r0 = 0
            java.lang.Class[] r0 = new java.lang.Class[r0]
            java.lang.reflect.Method r13 = r7.getDeclaredMethod(r13, r0)
            r11.add(r13)
            goto L13
        L2a:
            r5 = r11
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r1, r2, r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller.<init>(java.lang.Class, java.util.List, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$CallMode, kotlin.reflect.jvm.internal.calls.AnnotationConstructorCaller$Origin, java.util.List, int, h.k2.v.u):void");
    }
}
