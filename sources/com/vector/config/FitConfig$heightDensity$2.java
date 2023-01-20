package com.vector.config;

import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0007\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class FitConfig$heightDensity$2 extends Lambda implements a<Float> {
    public static final FitConfig$heightDensity$2 INSTANCE = new FitConfig$heightDensity$2();

    public FitConfig$heightDensity$2() {
        super(0);
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Float, float] */
    @Override // h.k2.u.a
    public final Float invoke() {
        FitConfig fitConfig = FitConfig.a;
        return fitConfig.b() / fitConfig.d();
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Float invoke2() {
        return Float.valueOf(invoke());
    }
}
