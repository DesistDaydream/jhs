package h.p2.b0.g.t.o;

import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.c.v0;
import h.p2.b0.g.t.n.z;
import h.p2.b0.g.t.o.b;
import kotlin.reflect.jvm.internal.impl.builtins.ReflectionTypes;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

/* loaded from: classes3.dex */
public final class d implements b {
    @k.e.a.d
    public static final d a = new d();
    @k.e.a.d
    private static final String b = "second parameter must be of type KProperty<*> or its supertype";

    private d() {
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.e
    public String a(@k.e.a.d v vVar) {
        return b.a.a(this, vVar);
    }

    @Override // h.p2.b0.g.t.o.b
    public boolean b(@k.e.a.d v vVar) {
        v0 v0Var = vVar.h().get(1);
        z a2 = ReflectionTypes.f16411k.a(DescriptorUtilsKt.l(v0Var));
        if (a2 == null) {
            return false;
        }
        return TypeUtilsKt.l(a2, TypeUtilsKt.o(v0Var.getType()));
    }

    @Override // h.p2.b0.g.t.o.b
    @k.e.a.d
    public String getDescription() {
        return b;
    }
}
