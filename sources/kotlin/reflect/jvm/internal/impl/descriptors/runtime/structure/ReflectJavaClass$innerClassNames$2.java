package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.p2.b0.g.t.g.f;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ReflectJavaClass$innerClassNames$2 extends Lambda implements l<Class<?>, f> {
    public static final ReflectJavaClass$innerClassNames$2 INSTANCE = new ReflectJavaClass$innerClassNames$2();

    public ReflectJavaClass$innerClassNames$2() {
        super(1);
    }

    @Override // h.k2.u.l
    @e
    public final f invoke(Class<?> cls) {
        String simpleName = cls.getSimpleName();
        if (!f.h(simpleName)) {
            simpleName = null;
        }
        if (simpleName == null) {
            return null;
        }
        return f.f(simpleName);
    }
}
