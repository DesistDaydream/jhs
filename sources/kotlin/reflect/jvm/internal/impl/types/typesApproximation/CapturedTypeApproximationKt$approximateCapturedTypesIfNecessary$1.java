package kotlin.reflect.jvm.internal.impl.types.typesApproximation;

import h.k2.u.l;
import h.p2.b0.g.t.n.c1;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.resolve.calls.inference.CapturedTypeConstructorKt;

/* loaded from: classes3.dex */
public final class CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 extends Lambda implements l<c1, Boolean> {
    public static final CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1 INSTANCE = new CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1();

    public CapturedTypeApproximationKt$approximateCapturedTypesIfNecessary$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public final Boolean invoke(c1 c1Var) {
        return Boolean.valueOf(CapturedTypeConstructorKt.d(c1Var));
    }
}
