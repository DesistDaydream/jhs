package h.p2.b0.g.t.c.d1;

import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;

/* loaded from: classes3.dex */
public abstract class f extends a {

    /* renamed from: g  reason: collision with root package name */
    private final h.p2.b0.g.t.c.k f15103g;

    /* renamed from: h  reason: collision with root package name */
    private final o0 f15104h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f15105i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public f(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d o0 o0Var, boolean z) {
        super(mVar, fVar);
        if (mVar == null) {
            h0(0);
        }
        if (kVar == null) {
            h0(1);
        }
        if (fVar == null) {
            h0(2);
        }
        if (o0Var == null) {
            h0(3);
        }
        this.f15103g = kVar;
        this.f15104h = o0Var;
        this.f15105i = z;
    }

    private static /* synthetic */ void h0(int i2) {
        String str = (i2 == 4 || i2 == 5) ? "@NotNull method %s.%s must not return null" : "Argument for @NotNull parameter '%s' of %s.%s must not be null";
        Object[] objArr = new Object[(i2 == 4 || i2 == 5) ? 2 : 3];
        if (i2 == 1) {
            objArr[0] = "containingDeclaration";
        } else if (i2 == 2) {
            objArr[0] = "name";
        } else if (i2 == 3) {
            objArr[0] = MessageKey.MSG_SOURCE;
        } else if (i2 == 4 || i2 == 5) {
            objArr[0] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[0] = "storageManager";
        }
        if (i2 == 4) {
            objArr[1] = "getContainingDeclaration";
        } else if (i2 != 5) {
            objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/ClassDescriptorBase";
        } else {
            objArr[1] = "getSource";
        }
        if (i2 != 4 && i2 != 5) {
            objArr[2] = "<init>";
        }
        String format = String.format(str, objArr);
        if (i2 != 4 && i2 != 5) {
            throw new IllegalArgumentException(format);
        }
        throw new IllegalStateException(format);
    }

    @Override // h.p2.b0.g.t.c.d, h.p2.b0.g.t.c.l, h.p2.b0.g.t.c.k
    @k.e.a.d
    public h.p2.b0.g.t.c.k b() {
        h.p2.b0.g.t.c.k kVar = this.f15103g;
        if (kVar == null) {
            h0(4);
        }
        return kVar;
    }

    @Override // h.p2.b0.g.t.c.n
    @k.e.a.d
    public o0 getSource() {
        o0 o0Var = this.f15104h;
        if (o0Var == null) {
            h0(5);
        }
        return o0Var;
    }

    @Override // h.p2.b0.g.t.c.w
    public boolean isExternal() {
        return this.f15105i;
    }
}
