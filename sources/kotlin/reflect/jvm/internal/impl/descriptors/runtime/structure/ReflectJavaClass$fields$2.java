package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.k2.v.n0;
import h.p2.b0.g.t.c.f1.b.n;
import h.p2.h;
import java.lang.reflect.Field;
import k.e.a.d;
import kotlin.jvm.internal.FunctionReference;

/* loaded from: classes3.dex */
public /* synthetic */ class ReflectJavaClass$fields$2 extends FunctionReference implements l<Field, n> {
    public static final ReflectJavaClass$fields$2 INSTANCE = new ReflectJavaClass$fields$2();

    public ReflectJavaClass$fields$2() {
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
        return n0.d(n.class);
    }

    @Override // kotlin.jvm.internal.CallableReference
    @d
    public final String getSignature() {
        return "<init>(Ljava/lang/reflect/Field;)V";
    }

    @Override // h.k2.u.l
    @d
    public final n invoke(@d Field field) {
        return new n(field);
    }
}
