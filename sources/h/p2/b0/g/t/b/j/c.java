package h.p2.b0.g.t.b.j;

import h.a2.t;
import h.p2.b0.g.t.c.v;
import h.p2.b0.g.t.m.m;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.reflect.jvm.internal.impl.builtins.functions.FunctionClassKind;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope;

/* loaded from: classes3.dex */
public final class c extends GivenFunctionsMemberScope {

    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[FunctionClassKind.values().length];
            iArr[FunctionClassKind.Function.ordinal()] = 1;
            iArr[FunctionClassKind.SuspendFunction.ordinal()] = 2;
            a = iArr;
        }
    }

    public c(@k.e.a.d m mVar, @k.e.a.d b bVar) {
        super(mVar, bVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.GivenFunctionsMemberScope
    @k.e.a.d
    public List<v> j() {
        int i2 = a.a[((b) m()).Q0().ordinal()];
        if (i2 != 1) {
            if (i2 != 2) {
                return CollectionsKt__CollectionsKt.E();
            }
            return t.k(d.D.a((b) m(), true));
        }
        return t.k(d.D.a((b) m(), false));
    }
}
