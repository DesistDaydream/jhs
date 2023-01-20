package h.p2.b0.g.t.e.a;

import h.k2.v.f0;
import h.p2.b0.g.t.e.a.x.u;
import java.util.Arrays;
import java.util.Set;

/* loaded from: classes3.dex */
public interface i {
    @k.e.a.e
    h.p2.b0.g.t.e.a.x.g a(@k.e.a.d a aVar);

    @k.e.a.e
    u b(@k.e.a.d h.p2.b0.g.t.g.c cVar);

    @k.e.a.e
    Set<String> c(@k.e.a.d h.p2.b0.g.t.g.c cVar);

    /* loaded from: classes3.dex */
    public static final class a {
        @k.e.a.d
        private final h.p2.b0.g.t.g.b a;
        @k.e.a.e
        private final byte[] b;
        @k.e.a.e

        /* renamed from: c  reason: collision with root package name */
        private final h.p2.b0.g.t.e.a.x.g f15239c;

        public a(@k.e.a.d h.p2.b0.g.t.g.b bVar, @k.e.a.e byte[] bArr, @k.e.a.e h.p2.b0.g.t.e.a.x.g gVar) {
            this.a = bVar;
            this.b = bArr;
            this.f15239c = gVar;
        }

        @k.e.a.d
        public final h.p2.b0.g.t.g.b a() {
            return this.a;
        }

        public boolean equals(@k.e.a.e Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return f0.g(this.a, aVar.a) && f0.g(this.b, aVar.b) && f0.g(this.f15239c, aVar.f15239c);
            }
            return false;
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            h.p2.b0.g.t.e.a.x.g gVar = this.f15239c;
            return hashCode2 + (gVar != null ? gVar.hashCode() : 0);
        }

        @k.e.a.d
        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.f15239c + ')';
        }

        public /* synthetic */ a(h.p2.b0.g.t.g.b bVar, byte[] bArr, h.p2.b0.g.t.e.a.x.g gVar, int i2, h.k2.v.u uVar) {
            this(bVar, (i2 & 2) != 0 ? null : bArr, (i2 & 4) != 0 ? null : gVar);
        }
    }
}
