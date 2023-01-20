package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.e.a.d;
import k.e.a.e;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ReflectClassUtilKt$parameterizedTypeArguments$1 extends Lambda implements l<ParameterizedType, ParameterizedType> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$1 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$1();

    public ReflectClassUtilKt$parameterizedTypeArguments$1() {
        super(1);
    }

    @Override // h.k2.u.l
    @e
    public final ParameterizedType invoke(@d ParameterizedType parameterizedType) {
        Type ownerType = parameterizedType.getOwnerType();
        if (ownerType instanceof ParameterizedType) {
            return (ParameterizedType) ownerType;
        }
        return null;
    }
}
