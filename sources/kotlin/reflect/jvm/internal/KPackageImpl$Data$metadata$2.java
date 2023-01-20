package kotlin.reflect.jvm.internal;

import h.k2.u.a;
import h.p2.b0.g.t.f.a0.f.e;
import h.p2.b0.g.t.f.a0.f.f;
import h.p2.b0.g.t.f.a0.f.g;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.KPackageImpl;
import kotlin.reflect.jvm.internal.impl.load.kotlin.header.KotlinClassHeader;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lkotlin/Triple;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmNameResolver;", "Lkotlin/reflect/jvm/internal/impl/metadata/ProtoBuf$Package;", "Lkotlin/reflect/jvm/internal/impl/metadata/jvm/deserialization/JvmMetadataVersion;", "invoke"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class KPackageImpl$Data$metadata$2 extends Lambda implements a<Triple<? extends f, ? extends ProtoBuf.Package, ? extends e>> {
    public final /* synthetic */ KPackageImpl.Data this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KPackageImpl$Data$metadata$2(KPackageImpl.Data data) {
        super(0);
        this.this$0 = data;
    }

    @Override // h.k2.u.a
    @k.e.a.e
    public final Triple<? extends f, ? extends ProtoBuf.Package, ? extends e> invoke() {
        h.p2.b0.g.t.c.f1.a.f c2;
        KotlinClassHeader c3;
        c2 = this.this$0.c();
        if (c2 == null || (c3 = c2.c()) == null) {
            return null;
        }
        String[] a = c3.a();
        String[] g2 = c3.g();
        if (a == null || g2 == null) {
            return null;
        }
        Pair<f, ProtoBuf.Package> m2 = g.m(a, g2);
        return new Triple<>(m2.component1(), m2.component2(), c3.d());
    }
}
