package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ReflectJavaClass$innerClassNames$1 extends Lambda implements l<Class<?>, Boolean> {
    public static final ReflectJavaClass$innerClassNames$1 INSTANCE = new ReflectJavaClass$innerClassNames$1();

    public ReflectJavaClass$innerClassNames$1() {
        super(1);
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Class<?> cls) {
        return Boolean.valueOf(invoke2(cls));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Class<?> cls) {
        return cls.getSimpleName().length() == 0;
    }
}
