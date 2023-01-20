package okhttp3;

import com.moor.imkf.lib.jsoup.helper.HttpConnection;
import h.i;
import h.k2.d;
import h.k2.g;
import h.k2.h;
import h.k2.k;
import h.k2.v.f0;
import h.k2.v.u;
import h.q0;
import h.t2.y;
import j.m;
import j.n;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.Headers;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 +2\u00020\u0001:\u0003,+-B'\b\u0000\u0012\u0006\u0010$\u001a\u00020#\u0012\u0006\u0010\u0012\u001a\u00020\u000e\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a¢\u0006\u0004\b)\u0010*J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0011\u0010\u0010J\u000f\u0010\u0016\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0019\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0017\u0010\u0018J\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001aH\u0007¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020 2\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b!\u0010\"R\u0013\u0010\u0019\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0018R\u0013\u0010\u0016\u001a\u00020\u00138G@\u0006¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0015R\u0016\u0010$\u001a\u00020#8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b$\u0010%R\u0016\u0010\u000f\u001a\u00020\u000e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u0010&R\u0019\u0010\u0012\u001a\u00020\u000e8\u0007@\u0006¢\u0006\f\n\u0004\b\u0012\u0010&\u001a\u0004\b\u0012\u0010\u0010R\u001f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001a8\u0007@\u0006¢\u0006\f\n\u0004\b\u001d\u0010'\u001a\u0004\b\u001d\u0010\u001cR\u0016\u0010\u001e\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001e\u0010(¨\u0006."}, d2 = {"Lokhttp3/MultipartBody;", "Lokhttp3/RequestBody;", "Lj/n;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Lj/n;Z)J", "", "index", "Lokhttp3/MultipartBody$Part;", "part", "(I)Lokhttp3/MultipartBody$Part;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "-deprecated_type", "type", "", "-deprecated_boundary", "()Ljava/lang/String;", "boundary", "-deprecated_size", "()I", "size", "", "-deprecated_parts", "()Ljava/util/List;", "parts", "contentLength", "()J", "Lh/t1;", "writeTo", "(Lj/n;)V", "Lokio/ByteString;", "boundaryByteString", "Lokio/ByteString;", "Lokhttp3/MediaType;", "Ljava/util/List;", "J", "<init>", "(Lokio/ByteString;Lokhttp3/MediaType;Ljava/util/List;)V", "Companion", "Builder", "Part", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class MultipartBody extends RequestBody {
    @d
    @k.e.a.d
    public static final MediaType ALTERNATIVE;
    private static final byte[] COLONSPACE;
    private static final byte[] CRLF;
    public static final Companion Companion = new Companion(null);
    private static final byte[] DASHDASH;
    @d
    @k.e.a.d
    public static final MediaType DIGEST;
    @d
    @k.e.a.d
    public static final MediaType FORM;
    @d
    @k.e.a.d
    public static final MediaType MIXED;
    @d
    @k.e.a.d
    public static final MediaType PARALLEL;
    private final ByteString boundaryByteString;
    private long contentLength;
    private final MediaType contentType;
    @k.e.a.d
    private final List<Part> parts;
    @k.e.a.d
    private final MediaType type;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0002\u0010\u001b\u001a\u00020\r¢\u0006\u0004\b!\u0010\"J\u0015\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\b\u001a\u00020\u00002\b\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\fJ\u001d\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r¢\u0006\u0004\b\u0010\u0010\u0011J'\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\r2\b\u0010\u0012\u001a\u0004\u0018\u00010\r2\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0010\u0010\u0013J\u0015\u0010\b\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\b\u0010\u0016J\r\u0010\u0018\u001a\u00020\u0017¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u00020\u001a8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00140\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lokhttp3/MultipartBody$Builder;", "", "Lokhttp3/MediaType;", "type", "setType", "(Lokhttp3/MediaType;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/RequestBody;", "body", "addPart", "(Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "", "name", "value", "addFormDataPart", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/MultipartBody$Builder;", "filename", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/MultipartBody$Part;", "part", "(Lokhttp3/MultipartBody$Part;)Lokhttp3/MultipartBody$Builder;", "Lokhttp3/MultipartBody;", "build", "()Lokhttp3/MultipartBody;", "Lokio/ByteString;", "boundary", "Lokio/ByteString;", "Lokhttp3/MediaType;", "", "parts", "Ljava/util/List;", "<init>", "(Ljava/lang/String;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private final ByteString boundary;
        private final List<Part> parts;
        private MediaType type;

        @h
        public Builder() {
            this(null, 1, null);
        }

        @h
        public Builder(@k.e.a.d String str) {
            this.boundary = ByteString.Companion.l(str);
            this.type = MultipartBody.MIXED;
            this.parts = new ArrayList();
        }

        @k.e.a.d
        public final Builder addFormDataPart(@k.e.a.d String str, @k.e.a.d String str2) {
            addPart(Part.Companion.createFormData(str, str2));
            return this;
        }

        @k.e.a.d
        public final Builder addPart(@k.e.a.d RequestBody requestBody) {
            addPart(Part.Companion.create(requestBody));
            return this;
        }

        @k.e.a.d
        public final MultipartBody build() {
            if (!this.parts.isEmpty()) {
                return new MultipartBody(this.boundary, this.type, Util.toImmutableList(this.parts));
            }
            throw new IllegalStateException("Multipart body must have at least one part.".toString());
        }

        @k.e.a.d
        public final Builder setType(@k.e.a.d MediaType mediaType) {
            if (f0.g(mediaType.type(), "multipart")) {
                this.type = mediaType;
                return this;
            }
            throw new IllegalArgumentException(("multipart != " + mediaType).toString());
        }

        @k.e.a.d
        public final Builder addFormDataPart(@k.e.a.d String str, @e String str2, @k.e.a.d RequestBody requestBody) {
            addPart(Part.Companion.createFormData(str, str2, requestBody));
            return this;
        }

        @k.e.a.d
        public final Builder addPart(@e Headers headers, @k.e.a.d RequestBody requestBody) {
            addPart(Part.Companion.create(headers, requestBody));
            return this;
        }

        @k.e.a.d
        public final Builder addPart(@k.e.a.d Part part) {
            this.parts.add(part);
            return this;
        }

        public /* synthetic */ Builder(String str, int i2, u uVar) {
            this((i2 & 1) != 0 ? UUID.randomUUID().toString() : str);
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\t\u001a\u00020\u0006*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0005\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\r8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0011\u0010\u000fR\u0016\u0010\u0012\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\fR\u0016\u0010\u0013\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010\fR\u0016\u0010\u0014\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\fR\u0016\u0010\u0015\u001a\u00020\n8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\f¨\u0006\u0018"}, d2 = {"Lokhttp3/MultipartBody$Companion;", "", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "key", "Lh/t1;", "appendQuotedString$okhttp", "(Ljava/lang/StringBuilder;Ljava/lang/String;)V", "appendQuotedString", "Lokhttp3/MediaType;", "ALTERNATIVE", "Lokhttp3/MediaType;", "", "COLONSPACE", "[B", "CRLF", "DASHDASH", "DIGEST", "FORM", "MIXED", "PARALLEL", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public final void appendQuotedString$okhttp(@k.e.a.d StringBuilder sb, @k.e.a.d String str) {
            sb.append(y.a);
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                char charAt = str.charAt(i2);
                if (charAt == '\n') {
                    sb.append("%0A");
                } else if (charAt == '\r') {
                    sb.append("%0D");
                } else if (charAt != '\"') {
                    sb.append(charAt);
                } else {
                    sb.append("%22");
                }
            }
            sb.append(y.a);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u001b\b\u0002\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\t\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\bR\u001b\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0007@\u0006¢\u0006\f\n\u0004\b\u0005\u0010\n\u001a\u0004\b\u0005\u0010\u0004R\u0019\u0010\t\u001a\u00020\u00068\u0007@\u0006¢\u0006\f\n\u0004\b\t\u0010\u000b\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Lokhttp3/MultipartBody$Part;", "", "Lokhttp3/Headers;", "-deprecated_headers", "()Lokhttp3/Headers;", "headers", "Lokhttp3/RequestBody;", "-deprecated_body", "()Lokhttp3/RequestBody;", "body", "Lokhttp3/Headers;", "Lokhttp3/RequestBody;", "<init>", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Part {
        public static final Companion Companion = new Companion(null);
        @k.e.a.d
        private final RequestBody body;
        @e
        private final Headers headers;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J!\u0010\u0005\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0005\u0010\tJ\u001f\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0004\b\r\u0010\u000eJ)\u0010\r\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\u0010\u000f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\r\u0010\u0010¨\u0006\u0013"}, d2 = {"Lokhttp3/MultipartBody$Part$Companion;", "", "Lokhttp3/RequestBody;", "body", "Lokhttp3/MultipartBody$Part;", "create", "(Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Part;", "Lokhttp3/Headers;", "headers", "(Lokhttp3/Headers;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Part;", "", "name", "value", "createFormData", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/MultipartBody$Part;", "filename", "(Ljava/lang/String;Ljava/lang/String;Lokhttp3/RequestBody;)Lokhttp3/MultipartBody$Part;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
        /* loaded from: classes4.dex */
        public static final class Companion {
            private Companion() {
            }

            @k
            @k.e.a.d
            public final Part create(@k.e.a.d RequestBody requestBody) {
                return create(null, requestBody);
            }

            @k
            @k.e.a.d
            public final Part createFormData(@k.e.a.d String str, @k.e.a.d String str2) {
                return createFormData(str, null, RequestBody.Companion.create$default(RequestBody.Companion, str2, (MediaType) null, 1, (Object) null));
            }

            public /* synthetic */ Companion(u uVar) {
                this();
            }

            @k
            @k.e.a.d
            public final Part create(@e Headers headers, @k.e.a.d RequestBody requestBody) {
                if ((headers != null ? headers.get("Content-Type") : null) == null) {
                    if ((headers != null ? headers.get("Content-Length") : null) == null) {
                        return new Part(headers, requestBody, null);
                    }
                    throw new IllegalArgumentException("Unexpected header: Content-Length".toString());
                }
                throw new IllegalArgumentException("Unexpected header: Content-Type".toString());
            }

            @k
            @k.e.a.d
            public final Part createFormData(@k.e.a.d String str, @e String str2, @k.e.a.d RequestBody requestBody) {
                StringBuilder sb = new StringBuilder();
                sb.append("form-data; name=");
                Companion companion = MultipartBody.Companion;
                companion.appendQuotedString$okhttp(sb, str);
                if (str2 != null) {
                    sb.append("; filename=");
                    companion.appendQuotedString$okhttp(sb, str2);
                }
                return create(new Headers.Builder().addUnsafeNonAscii("Content-Disposition", sb.toString()).build(), requestBody);
            }
        }

        private Part(Headers headers, RequestBody requestBody) {
            this.headers = headers;
            this.body = requestBody;
        }

        @k
        @k.e.a.d
        public static final Part create(@e Headers headers, @k.e.a.d RequestBody requestBody) {
            return Companion.create(headers, requestBody);
        }

        @k
        @k.e.a.d
        public static final Part create(@k.e.a.d RequestBody requestBody) {
            return Companion.create(requestBody);
        }

        @k
        @k.e.a.d
        public static final Part createFormData(@k.e.a.d String str, @k.e.a.d String str2) {
            return Companion.createFormData(str, str2);
        }

        @k
        @k.e.a.d
        public static final Part createFormData(@k.e.a.d String str, @e String str2, @k.e.a.d RequestBody requestBody) {
            return Companion.createFormData(str, str2, requestBody);
        }

        @g(name = "-deprecated_body")
        @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "body", imports = {}))
        @k.e.a.d
        /* renamed from: -deprecated_body  reason: not valid java name */
        public final RequestBody m200deprecated_body() {
            return this.body;
        }

        @g(name = "-deprecated_headers")
        @e
        @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "headers", imports = {}))
        /* renamed from: -deprecated_headers  reason: not valid java name */
        public final Headers m201deprecated_headers() {
            return this.headers;
        }

        @g(name = "body")
        @k.e.a.d
        public final RequestBody body() {
            return this.body;
        }

        @g(name = "headers")
        @e
        public final Headers headers() {
            return this.headers;
        }

        public /* synthetic */ Part(Headers headers, RequestBody requestBody, u uVar) {
            this(headers, requestBody);
        }
    }

    static {
        MediaType.Companion companion = MediaType.Companion;
        MIXED = companion.get("multipart/mixed");
        ALTERNATIVE = companion.get("multipart/alternative");
        DIGEST = companion.get("multipart/digest");
        PARALLEL = companion.get("multipart/parallel");
        FORM = companion.get(HttpConnection.MULTIPART_FORM_DATA);
        COLONSPACE = new byte[]{(byte) 58, (byte) 32};
        CRLF = new byte[]{(byte) 13, (byte) 10};
        byte b = (byte) 45;
        DASHDASH = new byte[]{b, b};
    }

    public MultipartBody(@k.e.a.d ByteString byteString, @k.e.a.d MediaType mediaType, @k.e.a.d List<Part> list) {
        this.boundaryByteString = byteString;
        this.type = mediaType;
        this.parts = list;
        MediaType.Companion companion = MediaType.Companion;
        this.contentType = companion.get(mediaType + "; boundary=" + boundary());
        this.contentLength = -1L;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final long writeOrCountBytes(n nVar, boolean z) throws IOException {
        m mVar;
        if (z) {
            nVar = new m();
            mVar = nVar;
        } else {
            mVar = 0;
        }
        int size = this.parts.size();
        long j2 = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Part part = this.parts.get(i2);
            Headers headers = part.headers();
            RequestBody body = part.body();
            nVar.write(DASHDASH);
            nVar.r0(this.boundaryByteString);
            nVar.write(CRLF);
            if (headers != null) {
                int size2 = headers.size();
                for (int i3 = 0; i3 < size2; i3++) {
                    nVar.B(headers.name(i3)).write(COLONSPACE).B(headers.value(i3)).write(CRLF);
                }
            }
            MediaType contentType = body.contentType();
            if (contentType != null) {
                nVar.B("Content-Type: ").B(contentType.toString()).write(CRLF);
            }
            long contentLength = body.contentLength();
            if (contentLength != -1) {
                nVar.B("Content-Length: ").S(contentLength).write(CRLF);
            } else if (z) {
                mVar.l();
                return -1L;
            }
            byte[] bArr = CRLF;
            nVar.write(bArr);
            if (z) {
                j2 += contentLength;
            } else {
                body.writeTo(nVar);
            }
            nVar.write(bArr);
        }
        byte[] bArr2 = DASHDASH;
        nVar.write(bArr2);
        nVar.r0(this.boundaryByteString);
        nVar.write(bArr2);
        nVar.write(CRLF);
        if (z) {
            long O0 = j2 + mVar.O0();
            mVar.l();
            return O0;
        }
        return j2;
    }

    @g(name = "-deprecated_boundary")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "boundary", imports = {}))
    @k.e.a.d
    /* renamed from: -deprecated_boundary  reason: not valid java name */
    public final String m196deprecated_boundary() {
        return boundary();
    }

    @g(name = "-deprecated_parts")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "parts", imports = {}))
    @k.e.a.d
    /* renamed from: -deprecated_parts  reason: not valid java name */
    public final List<Part> m197deprecated_parts() {
        return this.parts;
    }

    @g(name = "-deprecated_size")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m198deprecated_size() {
        return size();
    }

    @g(name = "-deprecated_type")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "type", imports = {}))
    @k.e.a.d
    /* renamed from: -deprecated_type  reason: not valid java name */
    public final MediaType m199deprecated_type() {
        return this.type;
    }

    @g(name = "boundary")
    @k.e.a.d
    public final String boundary() {
        return this.boundaryByteString.utf8();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() throws IOException {
        long j2 = this.contentLength;
        if (j2 == -1) {
            long writeOrCountBytes = writeOrCountBytes(null, true);
            this.contentLength = writeOrCountBytes;
            return writeOrCountBytes;
        }
        return j2;
    }

    @Override // okhttp3.RequestBody
    @k.e.a.d
    public MediaType contentType() {
        return this.contentType;
    }

    @k.e.a.d
    public final Part part(int i2) {
        return this.parts.get(i2);
    }

    @g(name = "parts")
    @k.e.a.d
    public final List<Part> parts() {
        return this.parts;
    }

    @g(name = "size")
    public final int size() {
        return this.parts.size();
    }

    @g(name = "type")
    @k.e.a.d
    public final MediaType type() {
        return this.type;
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@k.e.a.d n nVar) throws IOException {
        writeOrCountBytes(nVar, false);
    }
}
