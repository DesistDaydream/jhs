package kotlin.reflect.jvm.internal.impl.utils;

import h.k2.u.l;
import h.t1;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class FunctionsKt$DO_NOTHING$1 extends Lambda implements l<Object, t1> {
    public static final FunctionsKt$DO_NOTHING$1 INSTANCE = new FunctionsKt$DO_NOTHING$1();

    public FunctionsKt$DO_NOTHING$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ t1 invoke(Object obj) {
        invoke2(obj);
        return t1.a;
    }

    @Override // h.k2.u.l
    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final void invoke2(@e Object obj) {
    }
}
