package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.k2.v.f0;
import h.p2.b0.g.t.b.k.c;
import h.p2.b0.g.t.c.f;
import h.p2.b0.g.t.n.c1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: classes3.dex */
public final class SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 extends Lambda implements l<c1, Boolean> {
    public static final SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1 INSTANCE = new SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1();

    public SignatureEnhancement$SignatureParts$enhance$containsFunctionN$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public final Boolean invoke(c1 c1Var) {
        f c2 = c1Var.I0().c();
        if (c2 == null) {
            return Boolean.FALSE;
        }
        h.p2.b0.g.t.g.f name = c2.getName();
        c cVar = c.a;
        return Boolean.valueOf(f0.g(name, cVar.i().g()) && f0.g(DescriptorUtilsKt.e(c2), cVar.i()));
    }
}
