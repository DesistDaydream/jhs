package com.vector.util;

import com.effective.android.panel.Constants;
import e.t.o.f;
import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class UIUtil$navigationBarHeight$2 extends Lambda implements a<Integer> {
    public static final UIUtil$navigationBarHeight$2 INSTANCE = new UIUtil$navigationBarHeight$2();

    public UIUtil$navigationBarHeight$2() {
        super(0);
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ Integer invoke2() {
        return Integer.valueOf(invoke());
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [int, java.lang.Integer] */
    @Override // h.k2.u.a
    public final Integer invoke() {
        f fVar = f.a;
        int identifier = fVar.e().getIdentifier(Constants.NAVIGATION_BAR_HEIGHT_RES_NAME, Constants.DIMEN, Constants.ANDROID);
        if (identifier > 0) {
            return fVar.e().getDimensionPixelSize(identifier);
        }
        return null;
    }
}
