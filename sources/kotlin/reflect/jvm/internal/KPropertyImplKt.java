package kotlin.reflect.jvm.internal;

import h.p2.b0.g.s.b;
import h.p2.b0.g.t.c.j0;
import h.p2.b0.g.t.c.k;
import h.p2.b0.g.t.k.c;
import h.p2.b0.g.t.l.b.x.g;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KPropertyImpl;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a \u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0002\u001a\f\u0010\t\u001a\u00020\b*\u00020\nH\u0002\"\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u000b"}, d2 = {"boundReceiver", "", "Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;", "getBoundReceiver", "(Lkotlin/reflect/jvm/internal/KPropertyImpl$Accessor;)Ljava/lang/Object;", "computeCallerForAccessor", "Lkotlin/reflect/jvm/internal/calls/Caller;", "isGetter", "", "isJvmFieldPropertyInCompanionObject", "Lkotlin/reflect/jvm/internal/impl/descriptors/PropertyDescriptor;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPropertyImplKt {
    public static final /* synthetic */ b a(KPropertyImpl.a aVar, boolean z) {
        return c(aVar, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final h.p2.b0.g.s.b<?> c(kotlin.reflect.jvm.internal.KPropertyImpl.a<?, ?> r7, boolean r8) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.KPropertyImplKt.c(kotlin.reflect.jvm.internal.KPropertyImpl$a, boolean):h.p2.b0.g.s.b");
    }

    @e
    public static final Object d(@d KPropertyImpl.a<?, ?> aVar) {
        return aVar.N().O();
    }

    public static final boolean e(j0 j0Var) {
        k b = j0Var.b();
        if (c.x(b)) {
            k b2 = b.b();
            return !(c.C(b2) || c.t(b2)) || ((j0Var instanceof g) && h.p2.b0.g.t.f.a0.f.g.f(((g) j0Var).d0()));
        }
        return false;
    }
}
