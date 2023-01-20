package h.p2.b0.g.t.c.d1;

/* loaded from: classes3.dex */
public class c0 extends c {

    /* renamed from: f  reason: collision with root package name */
    public static final /* synthetic */ boolean f15090f = false;

    /* renamed from: d  reason: collision with root package name */
    private final h.p2.b0.g.t.c.k f15091d;

    /* renamed from: e  reason: collision with root package name */
    private h.p2.b0.g.t.k.r.i.e f15092e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.k.r.i.e eVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar2) {
        super(eVar2);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (eVar2 == null) {
            A(2);
        }
        this.f15091d = kVar;
        this.f15092e = eVar;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 3 || i2 == 4) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 3 || i2 == 4) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "value";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
            case 4:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
                break;
            case 5:
                objArr[0] = "newOwner";
                break;
            case 6:
                objArr[0] = "outType";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 3) {
            objArr[1] = "getValue";
        } else if (i2 != 4) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ReceiverParameterDescriptorImpl";
        } else {
            objArr[1] = "getContainingDeclaration";
        }
        if (i2 != 3 && i2 != 4) {
            if (i2 == 5) {
                objArr[2] = "copy";
            } else if (i2 != 6) {
                objArr[2] = "<init>";
            } else {
                objArr[2] = "setOutType";
            }
        }
        String format = String.format(str, objArr);
        if (i2 != 3 && i2 != 4) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.k b() {
        h.p2.b0.g.t.c.k kVar = this.f15091d;
        if (kVar == null) {
            A(4);
        }
        return kVar;
    }

    @Override // h.p2.b0.g.t.c.m0
    @k.e.a.d
    public h.p2.b0.g.t.k.r.i.e getValue() {
        h.p2.b0.g.t.k.r.i.e eVar = this.f15092e;
        if (eVar == null) {
            A(3);
        }
        return eVar;
    }
}
