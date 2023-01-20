package h.p2.b0.g.t.f.z;

import h.k2.v.u;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* loaded from: classes3.dex */
public final class i {
    @k.e.a.d
    public static final a b = new a(null);
    @k.e.a.d

    /* renamed from: c */
    private static final i f15405c = new i(CollectionsKt__CollectionsKt.E());
    @k.e.a.d
    private final List<ProtoBuf.VersionRequirement> a;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @k.e.a.d
        public final i a(@k.e.a.d ProtoBuf.VersionRequirementTable versionRequirementTable) {
            return versionRequirementTable.getRequirementCount() == 0 ? b() : new i(versionRequirementTable.getRequirementList(), null);
        }

        @k.e.a.d
        public final i b() {
            return i.f15405c;
        }
    }

    private i(List<ProtoBuf.VersionRequirement> list) {
        this.a = list;
    }

    public /* synthetic */ i(List list, u uVar) {
        this(list);
    }

    @k.e.a.e
    public final ProtoBuf.VersionRequirement b(int i2) {
        return (ProtoBuf.VersionRequirement) CollectionsKt___CollectionsKt.J2(this.a, i2);
    }
}
