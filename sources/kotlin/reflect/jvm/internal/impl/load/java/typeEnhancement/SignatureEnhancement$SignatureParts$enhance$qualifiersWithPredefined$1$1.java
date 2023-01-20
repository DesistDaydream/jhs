package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.y.e;
import h.p2.b0.g.t.e.a.y.n;
import k.e.a.d;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1 extends Lambda implements l<Integer, e> {
    public final /* synthetic */ n $predefined;
    public final /* synthetic */ l<Integer, e> $qualifiers;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SignatureEnhancement$SignatureParts$enhance$qualifiersWithPredefined$1$1(n nVar, l<? super Integer, e> lVar) {
        super(1);
        this.$predefined = nVar;
        this.$qualifiers = lVar;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    @d
    public final e invoke(int i2) {
        e eVar = this.$predefined.a().get(Integer.valueOf(i2));
        return eVar == null ? this.$qualifiers.invoke(Integer.valueOf(i2)) : eVar;
    }
}
