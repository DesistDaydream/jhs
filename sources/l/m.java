package l;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Optional;
import javax.annotation.Nullable;
import l.h;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@IgnoreJRERequirement
/* loaded from: classes4.dex */
public final class m extends h.a {
    public static final h.a a = new m();

    @IgnoreJRERequirement
    /* loaded from: classes4.dex */
    public static final class a<T> implements h<ResponseBody, Optional<T>> {
        public final h<ResponseBody, T> a;

        public a(h<ResponseBody, T> hVar) {
            this.a = hVar;
        }

        @Override // l.h
        /* renamed from: a */
        public Optional<T> convert(ResponseBody responseBody) throws IOException {
            return Optional.ofNullable(this.a.convert(responseBody));
        }
    }

    @Override // l.h.a
    @Nullable
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        if (h.a.b(type) != Optional.class) {
            return null;
        }
        return new a(sVar.n(h.a.a(0, (ParameterizedType) type), annotationArr));
    }
}
