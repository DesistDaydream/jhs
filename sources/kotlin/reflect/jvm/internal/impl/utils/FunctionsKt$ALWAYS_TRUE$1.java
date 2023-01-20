package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.u.l;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class FunctionsKt$ALWAYS_TRUE$1 extends Lambda implements l<Object, Boolean> {
    public static final FunctionsKt$ALWAYS_TRUE$1 INSTANCE = new FunctionsKt$ALWAYS_TRUE$1();

    public FunctionsKt$ALWAYS_TRUE$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return Boolean.valueOf(invoke2(obj));
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final Boolean invoke2(@e Object obj) {
        return 1;
    }
}
