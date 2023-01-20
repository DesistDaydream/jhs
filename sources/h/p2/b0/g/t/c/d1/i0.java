package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;

/* loaded from: classes3.dex */
public abstract class i0 extends h0 {

    /* renamed from: i  reason: collision with root package name */
    public static final /* synthetic */ boolean f15115i = false;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f15116g;

    /* renamed from: h  reason: collision with root package name */
    public h.p2.b0.g.t.m.i<h.p2.b0.g.t.k.n.g<?>> f15117h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(@k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.e h.p2.b0.g.t.n.z zVar, boolean z, @k.e.a.d o0 o0Var) {
        super(kVar, eVar, fVar, zVar, o0Var);
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
        this.f15116g = z;
    }

    private static /* synthetic */ void A(int i2) {
        Object[] objArr = new Object[3];
        if (i2 == 1) {
            objArr[0] = "annotations";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = MessageKey.MSG_SOURCE;
        } else if (i2 != 4) {
            objArr[0] = "containingDeclaration";
        } else {
            objArr[0] = "compileTimeInitializer";
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/VariableDescriptorWithInitializerImpl";
        if (i2 != 4) {
            objArr[2] = "<init>";
        } else {
            objArr[2] = "setCompileTimeInitializer";
        }
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    public void H0(@k.e.a.d h.p2.b0.g.t.m.i<h.p2.b0.g.t.k.n.g<?>> iVar) {
        if (iVar == null) {
            A(4);
        }
        this.f15117h = iVar;
    }

    @Override // h.p2.b0.g.t.c.x0
    public boolean O() {
        return this.f15116g;
    }

    @Override // h.p2.b0.g.t.c.x0
    @k.e.a.e
    public h.p2.b0.g.t.k.n.g<?> m0() {
        h.p2.b0.g.t.m.i<h.p2.b0.g.t.k.n.g<?>> iVar = this.f15117h;
        if (iVar != null) {
            return iVar.invoke();
        }
        return null;
    }
}
