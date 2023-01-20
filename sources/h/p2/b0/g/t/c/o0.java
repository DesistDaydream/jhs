package h.p2.b0.g.t.c;

/* loaded from: classes3.dex */
public interface o0 {
    public static final o0 a = new a();

    /* loaded from: classes3.dex */
    public static class a implements o0 {
        private static /* synthetic */ void d(int i2) {
            throw new IllegalStateException(String.format("@NotNull method %s.%s must not return null", "kotlin/reflect/jvm/internal/impl/descriptors/SourceElement$1", "getContainingFile"));
        }

        @Override // h.p2.b0.g.t.c.o0
        @k.e.a.d
        public p0 b() {
            p0 p0Var = p0.a;
            if (p0Var == null) {
                d(0);
            }
            return p0Var;
        }

        public String toString() {
            return "NO_SOURCE";
        }
    }

    @k.e.a.d
    p0 b();
}
