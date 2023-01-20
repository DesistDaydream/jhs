package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.c.f1.b.q;
import h.p2.h;
import java.lang.reflect.Method;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$methods$2 extends FunctionReference implements l<Method, q> {
    public static final ReflectJavaClass$methods$2 INSTANCE = new ReflectJavaClass$methods$2();

    public ReflectJavaClass$methods$2() {
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
        return n0.d(q.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Method;)V";
    }

    @Override // h.k2.u.l
    @d
    public final q invoke(@d Method method) {
        return new q(method);
    }
}
