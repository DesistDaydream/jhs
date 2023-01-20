package l.x.a;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonToken;
import java.io.IOException;
import l.h;
import okhttp3.ResponseBody;

/* loaded from: classes4.dex */
public final class c<T> implements h<ResponseBody, T> {
    private final Gson a;
    private final TypeAdapter<T> b;

    public c(Gson gson, TypeAdapter<T> typeAdapter) {
        this.a = gson;
        this.b = typeAdapter;
    }

    @Override // l.h
    /* renamed from: a */
    public T convert(ResponseBody responseBody) throws IOException {
        e.j.e.u.a v = this.a.v(responseBody.charStream());
        try {
            T e2 = this.b.e(v);
            if (v.C0() == JsonToken.END_DOCUMENT) {
                return e2;
            }
            throw new JsonIOException("JSON document was not fully consumed.");
        } finally {
            responseBody.close();
        }
    }
}
