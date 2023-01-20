package h.p2.b0.g.t.c.d1;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import h.p2.b0.g.t.c.o0;
import h.p2.b0.g.t.c.r0;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class b extends d {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@k.e.a.d h.p2.b0.g.t.m.m mVar, @k.e.a.d h.p2.b0.g.t.c.k kVar, @k.e.a.d h.p2.b0.g.t.c.b1.e eVar, @k.e.a.d h.p2.b0.g.t.g.f fVar, @k.e.a.d Variance variance, boolean z, int i2, @k.e.a.d o0 o0Var, @k.e.a.d r0 r0Var) {
        super(mVar, kVar, eVar, fVar, variance, z, i2, o0Var, r0Var);
        if (mVar == null) {
            A(0);
        }
        if (kVar == null) {
            A(1);
        }
        if (eVar == null) {
            A(2);
        }
        if (fVar == null) {
            A(3);
        }
        if (variance == null) {
            A(4);
        }
        if (o0Var == null) {
            A(5);
        }
        if (r0Var == null) {
            A(6);
        }
    }

    private static /* synthetic */ void A(int i2) {
        Object[] objArr = new Object[3];
        switch (i2) {
            case 1:
                objArr[0] = "containingDeclaration";
                break;
            case 2:
                objArr[0] = "annotations";
                break;
            case 3:
                objArr[0] = "name";
                break;
            case 4:
                objArr[0] = "variance";
                break;
            case 5:
                objArr[0] = MessageKey.MSG_SOURCE;
                break;
            case 6:
                objArr[0] = "supertypeLoopChecker";
                break;
            default:
                objArr[0] = "storageManager";
                break;
        }
        objArr[1] = "kotlin/reflect/jvm/internal/impl/descriptors/impl/AbstractLazyTypeParameterDescriptor";
        objArr[2] = "<init>";
        throw new IllegalArgumentException(String.format("Argument for @NotNull parameter '%s' of %s.%s must not be null", objArr));
    }

    @Override // h.p2.b0.g.t.c.d1.i
    public String toString() {
        Object[] objArr = new Object[3];
        String str = "";
        objArr[0] = l() ? "reified " : "";
        if (o() != Variance.INVARIANT) {
            str = o() + ExpandableTextView.N;
        }
        objArr[1] = str;
        objArr[2] = getName();
        return String.format("%s%s%s", objArr);
    }
}
