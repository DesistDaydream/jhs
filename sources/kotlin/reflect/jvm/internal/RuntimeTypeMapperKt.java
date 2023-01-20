package kotlin.reflect.jvm.internal;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"signature", "", "Ljava/lang/reflect/Method;", "getSignature", "(Ljava/lang/reflect/Method;)Ljava/lang/String;", "kotlin-reflection"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class RuntimeTypeMapperKt {
    public static final /* synthetic */ String a(Method method) {
        return b(method);
    }

    public static final String b(Method method) {
        return method.getName() + ArraysKt___ArraysKt.Ig(method.getParameterTypes(), "", "(", ")", 0, null, RuntimeTypeMapperKt$signature$1.INSTANCE, 24, null) + ReflectClassUtilKt.b(method.getReturnType());
    }
}
