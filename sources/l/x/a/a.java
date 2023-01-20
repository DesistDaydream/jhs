package l.x.a;

import com.google.gson.Gson;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Objects;
import l.h;
import l.s;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class a extends h.a {
    private final Gson a;

    private a(Gson gson) {
        this.a = gson;
    }

    public static a f() {
        return g(new Gson());
    }

    public static a g(Gson gson) {
        Objects.requireNonNull(gson, "gson == null");
        return new a(gson);
    }

    @Override // l.h.a
    public h<?, RequestBody> c(Type type, Annotation[] annotationArr, Annotation[] annotationArr2, s sVar) {
        return new b(this.a, this.a.p(e.j.e.t.a.get(type)));
    }

    @Override // l.h.a
    public h<ResponseBody, ?> d(Type type, Annotation[] annotationArr, s sVar) {
        return new c(this.a, this.a.p(e.j.e.t.a.get(type)));
    }
}
