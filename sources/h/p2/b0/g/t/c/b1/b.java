package h.p2.b0.g.t.c.b1;

/* loaded from: classes3.dex */
public class b implements a {
    private final e a;

    public b(@k.e.a.d e eVar) {
        if (eVar == null) {
            A(0);
        }
        this.a = eVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str = i2 != 1 ? "Argument for @NotNull parameter '%s' of %s.%s must not be null" : "@NotNull method %s.%s must not return null";
        Object[] objArr = new Object[i2 != 1 ? 3 : 2];
        if (i2 != 1) {
            objArr[0] = "annotations";
        } else {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        }
        if (i2 != 1) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/annotations/AnnotatedImpl";
        } else {
            objArr[1] = "getAnnotations";
        }
        if (i2 != 1) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 == 1) {
            throw new IllegalStateException(format);
        }
    }

    @Override // h.p2.b0.g.t.c.b1.a
    @k.e.a.d
    public e getAnnotations() {
        e eVar = this.a;
        if (eVar == null) {
            A(1);
        }
        return eVar;
    }
}
