package e.l.n.f;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import h.k2.v.u;
import j.m;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import k.e.a.d;
import l.h;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/* loaded from: classes2.dex */
public final class b<T> implements h<T, RequestBody> {
    @d

    /* renamed from: c  reason: collision with root package name */
    public static final a f14113c = new a(null);
    @d

    /* renamed from: d  reason: collision with root package name */
    private static final MediaType f14114d = MediaType.Companion.get("application/json; charset=UTF-8");

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f14115e = Charset.forName("UTF-8");
    @d
    private final Gson a;
    @d
    private final TypeAdapter<T> b;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public b(@d Gson gson, @d TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // l.h
    @d
    /* renamed from: a */
    public RequestBody convert(T t) throws IOException {
        m mVar = new m();
        e.j.e.u.c w = this.a.w(new OutputStreamWriter(mVar.v0(), f14115e));
        this.b.i(w, t);
        w.close();
        return RequestBody.Companion.create(mVar.j0(), f14114d);
    }
}
