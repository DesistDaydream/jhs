package kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure;

import h.k2.u.l;
import h.q2.m;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes3.dex */
public final class ReflectClassUtilKt$parameterizedTypeArguments$2 extends Lambda implements l<ParameterizedType, m<? extends Type>> {
    public static final ReflectClassUtilKt$parameterizedTypeArguments$2 INSTANCE = new ReflectClassUtilKt$parameterizedTypeArguments$2();

    public ReflectClassUtilKt$parameterizedTypeArguments$2() {
        super(1);
    }

    @Override // h.k2.u.l
    @d
    public final m<Type> invoke(@d ParameterizedType parameterizedType) {
        return ArraysKt___ArraysKt.h5(parameterizedType.getActualTypeArguments());
    }
}
