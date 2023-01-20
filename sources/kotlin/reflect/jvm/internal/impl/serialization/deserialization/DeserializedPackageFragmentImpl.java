package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.f.z.a;
import h.p2.b0.g.t.g.c;
import h.p2.b0.g.t.l.b.g;
import h.p2.b0.g.t.l.b.k;
import h.p2.b0.g.t.l.b.r;
import h.p2.b0.g.t.l.b.x.f;
import h.p2.b0.g.t.m.m;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;

/* loaded from: classes3.dex */
public abstract class DeserializedPackageFragmentImpl extends k {
    @d

    /* renamed from: g  reason: collision with root package name */
    private final a f16796g;
    @e

    /* renamed from: h  reason: collision with root package name */
    private final h.p2.b0.g.t.l.b.x.e f16797h;
    @d

    /* renamed from: i  reason: collision with root package name */
    private final h.p2.b0.g.t.f.z.d f16798i;
    @d

    /* renamed from: j  reason: collision with root package name */
    private final r f16799j;
    @e

    /* renamed from: k  reason: collision with root package name */
    private ProtoBuf.PackageFragment f16800k;

    /* renamed from: l  reason: collision with root package name */
    private MemberScope f16801l;

    public DeserializedPackageFragmentImpl(@d c cVar, @d m mVar, @d z zVar, @d ProtoBuf.PackageFragment packageFragment, @d a aVar, @e h.p2.b0.g.t.l.b.x.e eVar) {
        super(cVar, mVar, zVar);
        this.f16796g = aVar;
        this.f16797h = eVar;
        h.p2.b0.g.t.f.z.d dVar = new h.p2.b0.g.t.f.z.d(packageFragment.getStrings(), packageFragment.getQualifiedNames());
        this.f16798i = dVar;
        this.f16799j = new r(packageFragment, dVar, aVar, new DeserializedPackageFragmentImpl$classDataFinder$1(this));
        this.f16800k = packageFragment;
    }

    @Override // h.p2.b0.g.t.l.b.k
    public void H0(@d g gVar) {
        ProtoBuf.PackageFragment packageFragment = this.f16800k;
        if (packageFragment != null) {
            this.f16800k = null;
            this.f16801l = new f(this, packageFragment.getPackage(), this.f16798i, this.f16796g, this.f16797h, gVar, new DeserializedPackageFragmentImpl$initialize$1(this));
            return;
        }
        throw new IllegalStateException("Repeated call to DeserializedPackageFragmentImpl::initialize".toString());
    }

    @Override // h.p2.b0.g.t.l.b.k
    @d
    /* renamed from: J0 */
    public r C0() {
        return this.f16799j;
    }

    @Override // h.p2.b0.g.t.c.b0
    @d
    public MemberScope q() {
        MemberScope memberScope = this.f16801l;
        Objects.requireNonNull(memberScope);
        return memberScope;
    }
}
