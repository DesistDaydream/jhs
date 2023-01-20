package h.p2.b0.g.t.l.b.w;

import h.k2.v.u;
import h.p2.b0.g.t.c.z;
import h.p2.b0.g.t.m.m;
import java.io.InputStream;
import k.e.a.d;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.DeserializedPackageFragmentImpl;

/* loaded from: classes3.dex */
public final class b extends DeserializedPackageFragmentImpl implements h.p2.b0.g.t.b.a {
    @d
    public static final a n = new a(null);

    /* renamed from: m  reason: collision with root package name */
    private final boolean f15543m;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final b a(@d h.p2.b0.g.t.g.c cVar, @d m mVar, @d z zVar, @d InputStream inputStream, boolean z) {
            try {
                h.p2.b0.g.t.f.y.a a = h.p2.b0.g.t.f.y.a.f15369g.a(inputStream);
                if (a != null) {
                    if (a.h()) {
                        ProtoBuf.PackageFragment parseFrom = ProtoBuf.PackageFragment.parseFrom(inputStream, h.p2.b0.g.t.l.b.w.a.n.e());
                        h.h2.b.a(inputStream, null);
                        return new b(cVar, mVar, zVar, parseFrom, a, z, null);
                    }
                    throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + h.p2.b0.g.t.f.y.a.f15370h + ", actual " + a + ". Please update Kotlin");
                }
                throw null;
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    h.h2.b.a(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    private b(h.p2.b0.g.t.g.c cVar, m mVar, z zVar, ProtoBuf.PackageFragment packageFragment, h.p2.b0.g.t.f.y.a aVar, boolean z) {
        super(cVar, mVar, zVar, packageFragment, aVar, null);
        this.f15543m = z;
    }

    public /* synthetic */ b(h.p2.b0.g.t.g.c cVar, m mVar, z zVar, ProtoBuf.PackageFragment packageFragment, h.p2.b0.g.t.f.y.a aVar, boolean z, u uVar) {
        this(cVar, mVar, zVar, packageFragment, aVar, z);
    }
}
