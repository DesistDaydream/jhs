package kotlin.reflect.jvm.internal;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import h.k2.v.b0;
import h.k2.v.f0;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.b0.g.c;
import h.p2.b0.g.l;
import h.p2.b0.g.o;
import h.p2.b0.g.q;
import h.p2.b0.g.s.c;
import h.p2.b0.g.s.f;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.k.p.b;
import h.p2.i;
import h.p2.n;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00032\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00042\u00020\u0005B)\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\fB\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fB5\b\u0002\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0002¢\u0006\u0002\u0010\u0012J&\u00102\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u000304032\n\u00105\u001a\u0006\u0012\u0002\b\u0003042\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u00106\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0010\u00109\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0010\u0010:\u001a\u0002072\u0006\u00105\u001a\u000208H\u0002J\u0013\u0010;\u001a\u00020)2\b\u0010<\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010=\u001a\u00020\u0014H\u0016J\b\u0010>\u001a\u00020\tH\u0016R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R!\u0010!\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u001e\u001a\u0004\b\"\u0010\u001cR\u001b\u0010\r\u001a\u00020\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b$\u0010%R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b(\u0010*R\u0014\u0010+\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b+\u0010*R\u0014\u0010,\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b,\u0010*R\u0014\u0010-\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010*R\u0014\u0010.\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b.\u0010*R\u0014\u0010/\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b/\u0010*R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b0\u00101R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lkotlin/reflect/jvm/internal/KFunctionImpl;", "Lkotlin/reflect/jvm/internal/KCallableImpl;", "", "Lkotlin/reflect/KFunction;", "Lkotlin/jvm/internal/FunctionBase;", "Lkotlin/reflect/jvm/internal/FunctionWithAllInvokes;", "container", "Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "name", "", "signature", "boundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V", "descriptor", "Lkotlin/reflect/jvm/internal/impl/descriptors/FunctionDescriptor;", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;)V", "descriptorInitialValue", "rawBoundReceiver", "(Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;Ljava/lang/String;Ljava/lang/String;Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;Ljava/lang/Object;)V", "arity", "", "getArity", "()I", "getBoundReceiver", "()Ljava/lang/Object;", "caller", "Lkotlin/reflect/jvm/internal/calls/Caller;", "getCaller", "()Lkotlin/reflect/jvm/internal/calls/Caller;", "caller$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazyVal;", "getContainer", "()Lkotlin/reflect/jvm/internal/KDeclarationContainerImpl;", "defaultCaller", "getDefaultCaller", "defaultCaller$delegate", "getDescriptor", "()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;", "descriptor$delegate", "Lkotlin/reflect/jvm/internal/ReflectProperties$LazySoftVal;", "isBound", "", "()Z", "isExternal", "isInfix", "isInline", "isOperator", "isSuspend", "getName", "()Ljava/lang/String;", "createConstructorCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl;", "Ljava/lang/reflect/Constructor;", "member", "createInstanceMethodCaller", "Lkotlin/reflect/jvm/internal/calls/CallerImpl$Method;", "Ljava/lang/reflect/Method;", "createJvmStaticInObjectCaller", "createStaticMethodCaller", "equals", "other", TTDownloadField.TT_HASHCODE, "toString", "kotlin-reflection"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KFunctionImpl extends KCallableImpl<Object> implements b0<Object>, i<Object>, c {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ n[] f16351k = {n0.r(new PropertyReference1Impl(n0.d(KFunctionImpl.class), "descriptor", "getDescriptor()Lorg/jetbrains/kotlin/descriptors/FunctionDescriptor;")), n0.r(new PropertyReference1Impl(n0.d(KFunctionImpl.class), "caller", "getCaller()Lkotlin/reflect/jvm/internal/calls/Caller;")), n0.r(new PropertyReference1Impl(n0.d(KFunctionImpl.class), "defaultCaller", "getDefaultCaller()Lkotlin/reflect/jvm/internal/calls/Caller;"))};
    @d

    /* renamed from: e  reason: collision with root package name */
    private final l.a f16352e;
    @d

    /* renamed from: f  reason: collision with root package name */
    private final l.b f16353f;
    @e

    /* renamed from: g  reason: collision with root package name */
    private final l.b f16354g;
    @d

    /* renamed from: h  reason: collision with root package name */
    private final KDeclarationContainerImpl f16355h;

    /* renamed from: i  reason: collision with root package name */
    private final String f16356i;

    /* renamed from: j  reason: collision with root package name */
    private final Object f16357j;

    public /* synthetic */ KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, v vVar, Object obj, int i2, u uVar) {
        this(kDeclarationContainerImpl, str, str2, vVar, (i2 & 16) != 0 ? CallableReference.NO_RECEIVER : obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final h.p2.b0.g.s.c<Constructor<?>> R(Constructor<?> constructor, v vVar) {
        if (b.f(vVar)) {
            if (L()) {
                return new c.a(constructor, V());
            }
            return new c.b(constructor);
        } else if (L()) {
            return new c.C0428c(constructor, V());
        } else {
            return new c.e(constructor);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.h S(Method method) {
        return L() ? new c.h.a(method, V()) : new c.h.d(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.h T(Method method) {
        return L() ? new c.h.b(method) : new c.h.e(method);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final c.h U(Method method) {
        return L() ? new c.h.C0431c(method, V()) : new c.h.f(method);
    }

    private final Object V() {
        return f.a(this.f16357j, J());
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    public h.p2.b0.g.s.b<?> G() {
        return (h.p2.b0.g.s.b) this.f16353f.b(this, f16351k[1]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    public KDeclarationContainerImpl H() {
        return this.f16355h;
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @e
    public h.p2.b0.g.s.b<?> I() {
        return (h.p2.b0.g.s.b) this.f16354g.b(this, f16351k[2]);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    public boolean L() {
        return !f0.g(this.f16357j, CallableReference.NO_RECEIVER);
    }

    @Override // kotlin.reflect.jvm.internal.KCallableImpl
    @d
    /* renamed from: W */
    public v J() {
        return (v) this.f16352e.b(this, f16351k[0]);
    }

    public boolean equals(@e Object obj) {
        KFunctionImpl b = q.b(obj);
        return b != null && f0.g(H(), b.H()) && f0.g(getName(), b.getName()) && f0.g(this.f16356i, b.f16356i) && f0.g(this.f16357j, b.f16357j);
    }

    @Override // h.k2.v.b0
    public int getArity() {
        return h.p2.b0.g.s.d.a(G());
    }

    @Override // h.p2.c
    @d
    public String getName() {
        return J().getName().b();
    }

    public int hashCode() {
        return (((H().hashCode() * 31) + getName().hashCode()) * 31) + this.f16356i.hashCode();
    }

    @Override // h.k2.u.a
    @e
    public Object invoke() {
        return c.a.a(this);
    }

    @Override // h.p2.i
    public boolean isExternal() {
        return J().isExternal();
    }

    @Override // h.p2.i
    public boolean isInfix() {
        return J().isInfix();
    }

    @Override // h.p2.i
    public boolean isInline() {
        return J().isInline();
    }

    @Override // h.p2.i
    public boolean isOperator() {
        return J().isOperator();
    }

    @Override // h.p2.c
    public boolean isSuspend() {
        return J().isSuspend();
    }

    @d
    public String toString() {
        return ReflectionObjectRenderer.b.d(J());
    }

    private KFunctionImpl(KDeclarationContainerImpl kDeclarationContainerImpl, String str, String str2, v vVar, Object obj) {
        this.f16355h = kDeclarationContainerImpl;
        this.f16356i = str2;
        this.f16357j = obj;
        this.f16352e = l.c(vVar, new KFunctionImpl$descriptor$2(this, str));
        this.f16353f = l.b(new KFunctionImpl$caller$2(this));
        this.f16354g = l.b(new KFunctionImpl$defaultCaller$2(this));
    }

    @Override // h.k2.u.l
    @e
    public Object invoke(@e Object obj) {
        return c.a.b(this, obj);
    }

    @Override // h.k2.u.p
    @e
    public Object invoke(@e Object obj, @e Object obj2) {
        return c.a.c(this, obj, obj2);
    }

    @Override // h.k2.u.q
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3) {
        return c.a.d(this, obj, obj2, obj3);
    }

    @Override // h.k2.u.r
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4) {
        return c.a.e(this, obj, obj2, obj3, obj4);
    }

    public KFunctionImpl(@d KDeclarationContainerImpl kDeclarationContainerImpl, @d String str, @d String str2, @e Object obj) {
        this(kDeclarationContainerImpl, str, str2, null, obj);
    }

    @Override // h.k2.u.s
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5) {
        return c.a.f(this, obj, obj2, obj3, obj4, obj5);
    }

    public KFunctionImpl(@d KDeclarationContainerImpl kDeclarationContainerImpl, @d v vVar) {
        this(kDeclarationContainerImpl, vVar.getName().b(), o.b.g(vVar).a(), vVar, null, 16, null);
    }

    @Override // h.k2.u.t
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6) {
        return c.a.g(this, obj, obj2, obj3, obj4, obj5, obj6);
    }

    @Override // h.k2.u.u
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7) {
        return c.a.h(this, obj, obj2, obj3, obj4, obj5, obj6, obj7);
    }

    @Override // h.k2.u.v
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8) {
        return c.a.i(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8);
    }

    @Override // h.k2.u.w
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9) {
        return c.a.j(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9);
    }

    @Override // h.k2.u.b
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10) {
        return c.a.k(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10);
    }

    @Override // h.k2.u.c
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11) {
        return c.a.l(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11);
    }

    @Override // h.k2.u.d
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12) {
        return c.a.m(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12);
    }

    @Override // h.k2.u.e
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13) {
        return c.a.n(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13);
    }

    @Override // h.k2.u.f
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14) {
        return c.a.o(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14);
    }

    @Override // h.k2.u.g
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15) {
        return c.a.p(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15);
    }

    @Override // h.k2.u.h
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16) {
        return c.a.q(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16);
    }

    @Override // h.k2.u.i
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17) {
        return c.a.r(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17);
    }

    @Override // h.k2.u.j
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17, @e Object obj18) {
        return c.a.s(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18);
    }

    @Override // h.k2.u.k
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17, @e Object obj18, @e Object obj19) {
        return c.a.t(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19);
    }

    @Override // h.k2.u.m
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17, @e Object obj18, @e Object obj19, @e Object obj20) {
        return c.a.u(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20);
    }

    @Override // h.k2.u.n
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17, @e Object obj18, @e Object obj19, @e Object obj20, @e Object obj21) {
        return c.a.v(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21);
    }

    @Override // h.k2.u.o
    @e
    public Object invoke(@e Object obj, @e Object obj2, @e Object obj3, @e Object obj4, @e Object obj5, @e Object obj6, @e Object obj7, @e Object obj8, @e Object obj9, @e Object obj10, @e Object obj11, @e Object obj12, @e Object obj13, @e Object obj14, @e Object obj15, @e Object obj16, @e Object obj17, @e Object obj18, @e Object obj19, @e Object obj20, @e Object obj21, @e Object obj22) {
        return c.a.w(this, obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10, obj11, obj12, obj13, obj14, obj15, obj16, obj17, obj18, obj19, obj20, obj21, obj22);
    }
}
