package h.p2.b0.g.t.e.b;

import h.p2.b0.g.t.n.f0;
import h.p2.b0.g.t.n.z;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;

/* loaded from: classes3.dex */
public final class e implements h.p2.b0.g.t.l.b.m {
    @k.e.a.d
    public static final e a = new e();

    private e() {
    }

    @Override // h.p2.b0.g.t.l.b.m
    @k.e.a.d
    public z a(@k.e.a.d ProtoBuf.Type type, @k.e.a.d String str, @k.e.a.d f0 f0Var, @k.e.a.d f0 f0Var2) {
        if (!h.k2.v.f0.g(str, "kotlin.jvm.PlatformType")) {
            return h.p2.b0.g.t.n.s.j("Error java flexible type with id: " + str + ". (" + f0Var + ".." + f0Var2 + ')');
        } else if (type.hasExtension(JvmProtoBuf.f16708g)) {
            return new RawTypeImpl(f0Var, f0Var2);
        } else {
            KotlinTypeFactory kotlinTypeFactory = KotlinTypeFactory.a;
            return KotlinTypeFactory.d(f0Var, f0Var2);
        }
    }
}
