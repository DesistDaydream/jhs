package kotlin.reflect.jvm;

import h.p2.b0.a;
import h.p2.b0.g.b;
import h.p2.b0.g.q;
import h.p2.b0.g.t.c.n0;
import h.p2.b0.g.t.f.a0.f.f;
import h.p2.b0.g.t.f.a0.f.g;
import h.p2.i;
import h.r;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.KFunctionImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0007¨\u0006\u0004"}, d2 = {"reflect", "Lkotlin/reflect/KFunction;", "R", "Lkotlin/Function;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class ReflectLambdaKt {
    @a
    @e
    public static final <R> i<R> a(@d r<? extends R> rVar) {
        Metadata metadata = (Metadata) rVar.getClass().getAnnotation(Metadata.class);
        if (metadata != null) {
            String[] d1 = metadata.d1();
            if (d1.length == 0) {
                d1 = null;
            }
            if (d1 != null) {
                Pair<f, ProtoBuf.Function> j2 = g.j(d1, metadata.d2());
                f component1 = j2.component1();
                ProtoBuf.Function component2 = j2.component2();
                n0 n0Var = (n0) q.g(rVar.getClass(), component2, component1, new h.p2.b0.g.t.f.z.g(component2.getTypeTable()), new h.p2.b0.g.t.f.a0.f.e(metadata.mv(), (metadata.xi() & 8) != 0), ReflectLambdaKt$reflect$descriptor$1.INSTANCE);
                if (n0Var != null) {
                    return new KFunctionImpl(b.f14993d, n0Var);
                }
            }
        }
        return null;
    }
}
