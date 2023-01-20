package kotlin.reflect.jvm.internal.impl.descriptors;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.g.c;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class PackageFragmentProviderImpl$getSubPackagesOf$2 extends Lambda implements l<c, Boolean> {
    public final /* synthetic */ c $fqName;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PackageFragmentProviderImpl$getSubPackagesOf$2(c cVar) {
        super(1);
        this.$fqName = cVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(c cVar) {
        return Boolean.valueOf(invoke2(cVar));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(@d c cVar) {
        return !cVar.d() && f0.g(cVar.e(), this.$fqName);
    }
}
