package l.x.a;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import j.m;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import l.h;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes4.dex */
public final class b<T> implements h<T, RequestBody> {

    /* renamed from: c  reason: collision with root package name */
    private static final MediaType f17110c = MediaType.get("application/json; charset=UTF-8");

    /* renamed from: d  reason: collision with root package name */
    private static final Charset f17111d = Charset.forName("UTF-8");
    private final Gson a;
    private final TypeAdapter<T> b;

    public b(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // l.h
    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        m mVar = new m();
        e.j.e.u.c w = this.a.w(new OutputStreamWriter(mVar.v0(), f17111d));
        this.b.i(w, t);
        w.close();
        return RequestBody.create(f17110c, mVar.j0());
    }
}
