package e.g.c;

import com.eth.adapter.FlowCallAdapter;
import h.k2.v.f0;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import k.e.a.d;
import kotlin.Metadata;
import kotlinx.coroutines.flow.Flow;
import l.e;
import l.s;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J6\u0010\u0003\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0002¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"Lcom/eth/adapter/FlowCallAdapterFactory;", "Lretrofit2/CallAdapter$Factory;", "()V", "get", "Lretrofit2/CallAdapter;", "returnType", "Ljava/lang/reflect/Type;", "annotations", "", "", "retrofit", "Lretrofit2/Retrofit;", "(Ljava/lang/reflect/Type;[Ljava/lang/annotation/Annotation;Lretrofit2/Retrofit;)Lretrofit2/CallAdapter;", "eth_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes.dex */
public final class a extends e.a {
    @Override // l.e.a
    @k.e.a.e
    public e<?, ?> get(@d Type type, @d Annotation[] annotationArr, @d s sVar) {
        if (f0.g(e.a.getRawType(type), Flow.class)) {
            if (type instanceof ParameterizedType) {
                return new FlowCallAdapter(e.a.getParameterUpperBound(0, (ParameterizedType) type));
            }
            throw new IllegalStateException("Flow return type must be parameterized as Flow<T> or Flow<out T>".toString());
        }
        return null;
    }
}
