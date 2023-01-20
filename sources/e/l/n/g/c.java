package e.l.n.g;

import j.o;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.ResponseBody;

/* loaded from: classes2.dex */
public final class c extends ResponseBody {
    @k.e.a.e
    private final Headers a;
    @k.e.a.d
    private final ResponseBody b;

    public c(@k.e.a.e Headers headers, @k.e.a.d ResponseBody responseBody) {
        this.a = headers;
        this.b = responseBody;
    }

    @Override // okhttp3.ResponseBody
    public long contentLength() {
        return this.b.contentLength();
    }

    @Override // okhttp3.ResponseBody
    @k.e.a.e
    public MediaType contentType() {
        return this.b.contentType();
    }

    @k.e.a.e
    public final Headers j() {
        return this.a;
    }

    @Override // okhttp3.ResponseBody
    @k.e.a.d
    public o source() {
        return this.b.source();
    }
}
