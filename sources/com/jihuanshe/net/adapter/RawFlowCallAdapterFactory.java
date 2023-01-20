package com.jihuanshe.net.adapter;

import h.k2.v.f0;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlinx.coroutines.flow.Flow;
import l.e;
import l.s;

/* loaded from: classes2.dex */
public final class RawFlowCallAdapterFactory extends e.a {
    @Override // l.e.a
    @k.e.a.e
    public e<?, ?> get(@d Type type, @d Annotation[] annotationArr, @d s sVar) {
        if (f0.g(e.a.getRawType(type), Flow.class)) {
            if (type instanceof ParameterizedType) {
                return new RawFlowCallAdapter(e.a.getParameterUpperBound(0, (ParameterizedType) type));
            }
            throw new IllegalStateException("Flow return type must be parameterized as Flow<T> or Flow<out T>".toString());
        }
        return null;
    }
}
