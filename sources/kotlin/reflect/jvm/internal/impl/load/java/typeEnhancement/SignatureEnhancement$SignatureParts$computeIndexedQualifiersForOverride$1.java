package kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement;

import h.k2.u.l;
import h.p2.b0.g.t.e.a.y.e;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1 extends Lambda implements l<Integer, e> {
    public final /* synthetic */ e[] $computedResult;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SignatureEnhancement$SignatureParts$computeIndexedQualifiersForOverride$1(e[] eVarArr) {
        super(1);
        this.$computedResult = eVarArr;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ e invoke(Integer num) {
        return invoke(num.intValue());
    }

    @d
    public final e invoke(int i2) {
        e[] eVarArr = this.$computedResult;
        return (i2 < 0 || i2 > ArraysKt___ArraysKt.Td(eVarArr)) ? e.f15295e.a() : eVarArr[i2];
    }
}
