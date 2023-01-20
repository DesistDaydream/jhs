package h.p2.b0.g.t.n;

import kotlin.reflect.jvm.internal.impl.types.TypeSubstitutor;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class v0 {
    @k.e.a.d
    public static final b a = new b(null);
    @h.k2.d
    @k.e.a.d
    public static final v0 b = new a();

    /* loaded from: classes3.dex */
    public static final class a extends v0 {
        @Override // h.p2.b0.g.t.n.v0
        public /* bridge */ /* synthetic */ s0 e(z zVar) {
            return (s0) h(zVar);
        }

        @Override // h.p2.b0.g.t.n.v0
        public boolean f() {
            return true;
        }

        @k.e.a.e
        public Void h(@k.e.a.d z zVar) {
            return null;
        }

        @k.e.a.d
        public String toString() {
            return "Empty TypeSubstitution";
        }
    }

    /* loaded from: classes3.dex */
    public static final class b {
        private b() {
        }

        public /* synthetic */ b(h.k2.v.u uVar) {
            this();
        }
    }

    public boolean a() {
        return false;
    }

    public boolean b() {
        return false;
    }

    @k.e.a.d
    public final TypeSubstitutor c() {
        return TypeSubstitutor.g(this);
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.b1.e d(@k.e.a.d h.p2.b0.g.t.c.b1.e eVar) {
        return eVar;
    }

    @k.e.a.e
    public abstract s0 e(@k.e.a.d z zVar);

    public boolean f() {
        return false;
    }

    @k.e.a.d
    public z g(@k.e.a.d z zVar, @k.e.a.d Variance variance) {
        return zVar;
    }
}
