package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;

/* loaded from: classes3.dex */
public abstract class j extends i implements h.p2.b0.g.t.c.l {
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private final h.p2.b0.g.t.c.k f15118c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private final o0 f15119d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var) {
        super(eVar, fVar);
        if (kVar == null) {
            A(0);
        }
        if (eVar == null) {
            A(1);
        }
        if (fVar == null) {
            A(2);
        }
        if (o0Var == null) {
            A(3);
        }
        this.f15118c = kVar;
        this.f15119d = o0Var;
    }

    private static /* synthetic */ void A(int i2) {
        String str = (i2 == 4 || i2 == 5 || i2 == 6) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5 || i2 == 6) ? 2 : 3];
        switch (i2) {
            case 1:
                objArr[0] = "annotations";
                break;
            case 2:
                objArr[0] = "name";
                break;
            case 3:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 4:
            case 5:
            case 6:
                objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
                break;
            default:
                objArr[0] = "containingDeclaration";
                break;
        }
        if (i2 == 4) {
            objArr[1] = "getOriginal";
        } else if (i2 == 5) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 6) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/DeclarationDescriptorNonRootImpl";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5 && i2 != 6) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @k.e.a.d
    public h.p2.b0.g.t.c.k b() {
        h.p2.b0.g.t.c.k kVar = this.f15118c;
        if (kVar == null) {
            A(5);
        }
        return kVar;
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        o0 o0Var = this.f15119d;
        if (o0Var == null) {
            A(6);
        }
        return o0Var;
    }

    @Override // h.p2.b0.g.t.c.d1.i, h.p2.b0.g.t.c.k
    @k.e.a.d
    /* renamed from: h0 */
    public h.p2.b0.g.t.c.n a() {
        h.p2.b0.g.t.c.n nVar = (h.p2.b0.g.t.c.n) super.a();
        if (nVar == null) {
            A(4);
        }
        return nVar;
    }
}
