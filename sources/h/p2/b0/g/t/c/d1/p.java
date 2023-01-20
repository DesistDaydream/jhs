package h.p2.b0.g.t.c.d1;

/* loaded from: classes3.dex */
public class p extends c {

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.c.d f15148d;

    /* renamed from: e  reason: collision with root package name */
    private final h.p2.b0.g.t.k.r.i.c f15149e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p(@k.e.a.d h.p2.b0.g.t.c.d dVar) {
        super(h.p2.b0.g.t.c.b1.e.w0.b());
        if (dVar == null) {
            A(0);
        }
        this.f15148d = dVar;
        this.f15149e = new h.p2.b0.g.t.k.r.i.c(dVar, null);
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 1 || i2 == 2) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 1 || i2 == 2) ? 2 : 3];
        if (i2 == 1 || i2 == 2) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else if (i2 != 3) {
            objArr[0] = "descriptor";
        } else {
            objArr[0] = "newOwner";
        }
        if (i2 == 1) {
            objArr[1] = "getValue";
        } else if (i2 != 2) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/LazyClassReceiverParameterDescriptor";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 1 && i2 != 2) {
            if (i2 != 3) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "copy";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 1 && i2 != 2) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.k b() {
        h.p2.b0.g.t.c.d dVar = this.f15148d;
        if (dVar == null) {
            A(2);
        }
        return dVar;
    }

    @Override // h.p2.b0.g.t.c.m0
    @k.e.a.d
    public h.p2.b0.g.t.k.r.i.e getValue() {
        h.p2.b0.g.t.k.r.i.c cVar = this.f15149e;
        if (cVar == null) {
            A(1);
        }
        return cVar;
    }

    @Override // h.p2.b0.g.t.c.d1.i
    public String toString() {
        return "class " + this.f15148d.getName() + "::this";
    }
}
