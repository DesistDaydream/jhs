package com.vector.util;

import h.k2.u.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Screen$hasVirtualBar$2 extends Lambda implements a<Boolean> {
    public static final Screen$hasVirtualBar$2 INSTANCE = new Screen$hasVirtualBar$2();

    public Screen$hasVirtualBar$2() {
        super(0);
    }

    @Override // h.k2.u.a
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    @Override // h.k2.u.a
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2() {
        Screen screen = Screen.a;
        return screen.e() - Screen.j() != screen.h() ? 1 : null;
    }
}
