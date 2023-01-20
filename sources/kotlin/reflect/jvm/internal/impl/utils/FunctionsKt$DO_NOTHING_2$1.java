package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.u.p;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class FunctionsKt$DO_NOTHING_2$1 extends Lambda implements p<Object, Object, t1> {
    public static final FunctionsKt$DO_NOTHING_2$1 INSTANCE = new FunctionsKt$DO_NOTHING_2$1();

    public FunctionsKt$DO_NOTHING_2$1() {
        super(2);
    }

    @Override // h.k2.u.p
    public /* bridge */ /* synthetic */ t1 invoke(Object obj, Object obj2) {
        invoke2(obj, obj2);
        return t1.a;
    }

    @Override // h.k2.u.p
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Object obj, @e Object obj2) {
    }
}
