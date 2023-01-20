package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.c.f1.b.k;
import h.p2.h;
import java.lang.reflect.Constructor;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$constructors$2 extends FunctionReference implements l<Constructor<?>, k> {
    public static final ReflectJavaClass$constructors$2 INSTANCE = new ReflectJavaClass$constructors$2();

    public ReflectJavaClass$constructors$2() {
        super(1);
    }

    @Override // kotlin.jvm.internal.CallableReference, h.p2.c
    @d
    public final String getName() {
        return "<init>";
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final h getOwner() {
        return n0.d(k.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Constructor;)V";
    }

    @Override // h.k2.u.l
    @d
    public final k invoke(@d Constructor<?> constructor) {
        return new k(constructor);
    }
}
