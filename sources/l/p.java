package l;

import java.io.IOException;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;

/* loaded from: classes4.dex */
public final class p {

    /* renamed from: m  reason: collision with root package name */
    private static final String f17066m = " \"<>^`{}|\\?#";
    private final String a;
    private final HttpUrl b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private String f17067c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private HttpUrl.Builder f17068d;

    /* renamed from: e  reason: collision with root package name */
    private final Request.Builder f17069e = new Request.Builder();

    /* renamed from: f  reason: collision with root package name */
    private final Headers.Builder f17070f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private MediaType f17071g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f17072h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private MultipartBody.Builder f17073i;
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    private FormBody.Builder f17074j;
    @Nullable

    /* renamed from: k  reason: collision with root package name */
    private RequestBody f17075k;

    /* renamed from: l  reason: collision with root package name */
    private static final char[] f17065l = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final Pattern n = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");

    /* loaded from: classes4.dex */
    public static class a extends RequestBody {
        private final RequestBody a;
        private final MediaType b;

        public a(RequestBody requestBody, MediaType mediaType) {
            this.a = requestBody;
            this.b = mediaType;
        }

        @Override // okhttp3.RequestBody
        public long contentLength() throws IOException {
            return this.a.contentLength();
        }

        @Override // okhttp3.RequestBody
        public MediaType contentType() {
            return this.b;
        }

        @Override // okhttp3.RequestBody
        public void writeTo(j.n nVar) throws IOException {
            this.a.writeTo(nVar);
        }
    }

    public p(String str, HttpUrl httpUrl, @Nullable String str2, @Nullable Headers headers, @Nullable MediaType mediaType, boolean z, boolean z2, boolean z3) {
        this.a = str;
        this.b = httpUrl;
        this.f17067c = str2;
        this.f17071g = mediaType;
        this.f17072h = z;
        if (headers != null) {
            this.f17070f = headers.newBuilder();
        } else {
            this.f17070f = new Headers.Builder();
        }
        if (z2) {
            this.f17074j = new FormBody.Builder();
        } else if (z3) {
            MultipartBody.Builder builder = new MultipartBody.Builder();
            this.f17073i = builder;
            builder.setType(MultipartBody.FORM);
        }
    }

    private static String i(String str, boolean z) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt >= 32 && codePointAt < 127 && f17066m.indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                i2 += Character.charCount(codePointAt);
            } else {
                j.m mVar = new j.m();
                mVar.D(str, 0, i2);
                j(mVar, str, i2, length, z);
                return mVar.p0();
            }
        }
        return str;
    }

    private static void j(j.m mVar, String str, int i2, int i3, boolean z) {
        j.m mVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt >= 32 && codePointAt < 127 && f17066m.indexOf(codePointAt) == -1 && (z || (codePointAt != 47 && codePointAt != 37))) {
                    mVar.w(codePointAt);
                } else {
                    if (mVar2 == null) {
                        mVar2 = new j.m();
                    }
                    mVar2.w(codePointAt);
                    while (!mVar2.b0()) {
                        int readByte = mVar2.readByte() & 255;
                        mVar.writeByte(37);
                        char[] cArr = f17065l;
                        mVar.writeByte(cArr[(readByte >> 4) & 15]);
                        mVar.writeByte(cArr[readByte & 15]);
                    }
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public void a(String str, String str2, boolean z) {
        if (z) {
            this.f17074j.addEncoded(str, str2);
        } else {
            this.f17074j.add(str, str2);
        }
    }

    public void b(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.f17071g = MediaType.get(str2);
                return;
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        }
        this.f17070f.add(str, str2);
    }

    public void c(Headers headers) {
        this.f17070f.addAll(headers);
    }

    public void d(Headers headers, RequestBody requestBody) {
        this.f17073i.addPart(headers, requestBody);
    }

    public void e(MultipartBody.Part part) {
        this.f17073i.addPart(part);
    }

    public void f(String str, String str2, boolean z) {
        if (this.f17067c != null) {
            String i2 = i(str2, z);
            String str3 = this.f17067c;
            String replace = str3.replace("{" + str + "}", i2);
            if (!n.matcher(replace).matches()) {
                this.f17067c = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    public void g(String str, @Nullable String str2, boolean z) {
        String str3 = this.f17067c;
        if (str3 != null) {
            HttpUrl.Builder newBuilder = this.b.newBuilder(str3);
            this.f17068d = newBuilder;
            if (newBuilder != null) {
                this.f17067c = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.f17067c);
            }
        }
        if (z) {
            this.f17068d.addEncodedQueryParameter(str, str2);
        } else {
            this.f17068d.addQueryParameter(str, str2);
        }
    }

    public <T> void h(Class<T> cls, @Nullable T t) {
        this.f17069e.tag(cls, t);
    }

    public Request.Builder k() {
        HttpUrl resolve;
        HttpUrl.Builder builder = this.f17068d;
        if (builder != null) {
            resolve = builder.build();
        } else {
            resolve = this.b.resolve(this.f17067c);
            if (resolve == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.b + ", Relative: " + this.f17067c);
            }
        }
        a aVar = this.f17075k;
        if (aVar == null) {
            FormBody.Builder builder2 = this.f17074j;
            if (builder2 != null) {
                aVar = builder2.build();
            } else {
                MultipartBody.Builder builder3 = this.f17073i;
                if (builder3 != null) {
                    aVar = builder3.build();
                } else if (this.f17072h) {
                    aVar = RequestBody.create((MediaType) null, new byte[0]);
                }
            }
        }
        MediaType mediaType = this.f17071g;
        if (mediaType != null) {
            if (aVar != null) {
                aVar = new a(aVar, mediaType);
            } else {
                this.f17070f.add("Content-Type", mediaType.toString());
            }
        }
        return this.f17069e.url(resolve).headers(this.f17070f.build()).method(this.a, aVar);
    }

    public void l(RequestBody requestBody) {
        this.f17075k = requestBody;
    }

    public void m(Object obj) {
        this.f17067c = obj.toString();
    }
}
