package h.p2.b0.g;

import h.k2.v.b0;
import h.k2.v.o0;
import h.p2.s;
import h.p2.t;
import java.util.Collections;
import java.util.List;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.MutablePropertyReference2;
import kotlin.jvm.internal.PropertyReference0;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.jvm.internal.PropertyReference2;
import kotlin.reflect.KVariance;
import kotlin.reflect.jvm.ReflectLambdaKt;
import kotlin.reflect.jvm.internal.KClassImpl;
import kotlin.reflect.jvm.internal.KDeclarationContainerImpl;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.KMutableProperty0Impl;
import kotlin.reflect.jvm.internal.KMutableProperty1Impl;
import kotlin.reflect.jvm.internal.KMutableProperty2Impl;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.KProperty0Impl;
import kotlin.reflect.jvm.internal.KProperty1Impl;
import kotlin.reflect.jvm.internal.KProperty2Impl;
import kotlin.reflect.jvm.internal.ReflectionObjectRenderer;

/* loaded from: classes3.dex */
public class m extends o0 {
    public static void r() {
        e.a();
        k.a();
    }

    private static KDeclarationContainerImpl s(CallableReference callableReference) {
        h.p2.h owner = callableReference.getOwner();
        return owner instanceof KDeclarationContainerImpl ? (KDeclarationContainerImpl) owner : b.f14993d;
    }

    @Override // h.k2.v.o0
    public h.p2.d a(Class cls) {
        return new KClassImpl(cls);
    }

    @Override // h.k2.v.o0
    public h.p2.d b(Class cls, String str) {
        return new KClassImpl(cls);
    }

    @Override // h.k2.v.o0
    public h.p2.i c(FunctionReference functionReference) {
        return new KFunctionImpl(s(functionReference), functionReference.getName(), functionReference.getSignature(), functionReference.getBoundReceiver());
    }

    @Override // h.k2.v.o0
    public h.p2.d d(Class cls) {
        return e.b(cls);
    }

    @Override // h.k2.v.o0
    public h.p2.d e(Class cls, String str) {
        return e.b(cls);
    }

    @Override // h.k2.v.o0
    public h.p2.h f(Class cls, String str) {
        return new KPackageImpl(cls, str);
    }

    @Override // h.k2.v.o0
    public h.p2.k g(MutablePropertyReference0 mutablePropertyReference0) {
        return new KMutableProperty0Impl(s(mutablePropertyReference0), mutablePropertyReference0.getName(), mutablePropertyReference0.getSignature(), mutablePropertyReference0.getBoundReceiver());
    }

    @Override // h.k2.v.o0
    public h.p2.l h(MutablePropertyReference1 mutablePropertyReference1) {
        return new KMutableProperty1Impl(s(mutablePropertyReference1), mutablePropertyReference1.getName(), mutablePropertyReference1.getSignature(), mutablePropertyReference1.getBoundReceiver());
    }

    @Override // h.k2.v.o0
    public h.p2.m i(MutablePropertyReference2 mutablePropertyReference2) {
        return new KMutableProperty2Impl(s(mutablePropertyReference2), mutablePropertyReference2.getName(), mutablePropertyReference2.getSignature());
    }

    @Override // h.k2.v.o0
    public h.p2.o j(PropertyReference0 propertyReference0) {
        return new KProperty0Impl(s(propertyReference0), propertyReference0.getName(), propertyReference0.getSignature(), propertyReference0.getBoundReceiver());
    }

    @Override // h.k2.v.o0
    public h.p2.p k(PropertyReference1 propertyReference1) {
        return new KProperty1Impl(s(propertyReference1), propertyReference1.getName(), propertyReference1.getSignature(), propertyReference1.getBoundReceiver());
    }

    @Override // h.k2.v.o0
    public h.p2.q l(PropertyReference2 propertyReference2) {
        return new KProperty2Impl(s(propertyReference2), propertyReference2.getName(), propertyReference2.getSignature());
    }

    @Override // h.k2.v.o0
    public String m(b0 b0Var) {
        KFunctionImpl b;
        h.p2.i a = ReflectLambdaKt.a(b0Var);
        if (a != null && (b = q.b(a)) != null) {
            return ReflectionObjectRenderer.b.e(b.J());
        }
        return super.m(b0Var);
    }

    @Override // h.k2.v.o0
    public String n(Lambda lambda) {
        return m(lambda);
    }

    @Override // h.k2.v.o0
    public void o(s sVar, List<h.p2.r> list) {
    }

    @Override // h.k2.v.o0
    public h.p2.r p(h.p2.g gVar, List<t> list, boolean z) {
        return h.p2.a0.c.b(gVar, list, z, Collections.emptyList());
    }

    @Override // h.k2.v.o0
    public s q(Object obj, String str, KVariance kVariance, boolean z) {
        List<s> typeParameters;
        if (obj instanceof h.p2.d) {
            typeParameters = ((h.p2.d) obj).getTypeParameters();
        } else if (obj instanceof h.p2.c) {
            typeParameters = ((h.p2.c) obj).getTypeParameters();
        } else {
            throw new IllegalArgumentException("Type parameter container must be a class or a callable: " + obj);
        }
        for (s sVar : typeParameters) {
            if (sVar.getName().equals(str)) {
                return sVar;
            }
        }
        throw new IllegalArgumentException("Type parameter " + str + " is not found in container: " + obj);
    }
}
