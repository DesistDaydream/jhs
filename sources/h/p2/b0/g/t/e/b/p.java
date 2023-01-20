package h.p2.b0.g.t.e.b;

import h.k2.v.f0;
import h.p2.b0.g.t.f.a0.f.d;
import kotlin.NoWhenBranchMatchedException;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;

/* loaded from: classes3.dex */
public final class p {
    @k.e.a.d
    public static final a b = new a(null);
    @k.e.a.d
    private final String a;

    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        @h.k2.k
        @k.e.a.d
        public final p a(@k.e.a.d String str, @k.e.a.d String str2) {
            return new p(str + '#' + str2, null);
        }

        @h.k2.k
        @k.e.a.d
        public final p b(@k.e.a.d h.p2.b0.g.t.f.a0.f.d dVar) {
            if (dVar instanceof d.b) {
                return d(dVar.c(), dVar.b());
            }
            if (dVar instanceof d.a) {
                return a(dVar.c(), dVar.b());
            }
            throw new NoWhenBranchMatchedException();
        }

        @h.k2.k
        @k.e.a.d
        public final p c(@k.e.a.d h.p2.b0.g.t.f.z.c cVar, @k.e.a.d JvmProtoBuf.JvmMethodSignature jvmMethodSignature) {
            return d(cVar.getString(jvmMethodSignature.getName()), cVar.getString(jvmMethodSignature.getDesc()));
        }

        @h.k2.k
        @k.e.a.d
        public final p d(@k.e.a.d String str, @k.e.a.d String str2) {
            return new p(f0.C(str, str2), null);
        }

        @h.k2.k
        @k.e.a.d
        public final p e(@k.e.a.d p pVar, int i2) {
            return new p(pVar.a() + '@' + i2, null);
        }
    }

    private p(String str) {
        this.a = str;
    }

    public /* synthetic */ p(String str, h.k2.v.u uVar) {
        this(str);
    }

    @k.e.a.d
    public final String a() {
        return this.a;
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p) && f0.g(this.a, ((p) obj).a);
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @k.e.a.d
    public String toString() {
        return "MemberSignature(signature=" + this.a + ')';
    }
}
