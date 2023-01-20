package h.p2.a0;

import h.k2.g;
import h.p2.r;
import h.s0;
import kotlin.Metadata;
import kotlin.reflect.jvm.internal.KTypeImpl;
import kotlin.reflect.jvm.internal.impl.types.typeUtil.TypeUtilsKt;

@g(name = "KTypes")
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¨\u0006\u0007"}, d2 = {"isSubtypeOf", "", "Lkotlin/reflect/KType;", "other", "isSupertypeOf", "withNullability", "nullable", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class e {
    @s0(version = "1.1")
    public static final boolean a(@k.e.a.d r rVar, @k.e.a.d r rVar2) {
        return TypeUtilsKt.l(((KTypeImpl) rVar).getType(), ((KTypeImpl) rVar2).getType());
    }

    @s0(version = "1.1")
    public static final boolean b(@k.e.a.d r rVar, @k.e.a.d r rVar2) {
        return a(rVar2, rVar);
    }

    @s0(version = "1.1")
    @k.e.a.d
    public static final r c(@k.e.a.d r rVar, boolean z) {
        return ((KTypeImpl) rVar).h(z);
    }
}
