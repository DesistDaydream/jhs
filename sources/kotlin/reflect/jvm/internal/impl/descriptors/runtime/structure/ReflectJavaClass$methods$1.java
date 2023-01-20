package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import java.lang.reflect.Method;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ReflectJavaClass$methods$1 extends Lambda implements l<Method, Boolean> {
    public final /* synthetic */ ReflectJavaClass this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReflectJavaClass$methods$1(ReflectJavaClass reflectJavaClass) {
        super(1);
        this.this$0 = reflectJavaClass;
    }

    @Override // h.k2.u.l
    public /* bridge */ /* synthetic */ Boolean invoke(Method method) {
        return Boolean.valueOf(invoke2(method));
    }

    /* renamed from: invoke  reason: avoid collision after fix types in other method */
    public final boolean invoke2(Method method) {
        boolean a0;
        if (!method.isSynthetic()) {
            if (!this.this$0.w()) {
                return true;
            }
            a0 = this.this$0.a0(method);
            if (!a0) {
                return true;
            }
        }
        return false;
    }
}
