package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.u.l;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class FunctionsKt$IDENTITY$1 extends Lambda implements l<Object, Object> {
    public static final FunctionsKt$IDENTITY$1 INSTANCE = new FunctionsKt$IDENTITY$1();

    public FunctionsKt$IDENTITY$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @e
    public final Object invoke(@e Object obj) {
        return obj;
    }
}
