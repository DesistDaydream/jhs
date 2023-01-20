package okhttp3;

import h.i;
import h.k2.g;
import h.k2.h;
import h.k2.v.u;
import h.q0;
import j.m;
import j.n;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.HttpUrl;
import okhttp3.internal.Util;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\b\u0018\u0000 \"2\u00020\u0001:\u0002#\"B%\b\u0000\u0012\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c\u0012\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c¢\u0006\u0004\b \u0010!J!\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u000f\u0010\u0010J\u0015\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0011\u0010\u0010J\u0015\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0012\u0010\u0010J\u0015\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\t¢\u0006\u0004\b\u0013\u0010\u0010J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0013\u0010\f\u001a\u00020\t8G@\u0006¢\u0006\u0006\u001a\u0004\b\f\u0010\u000bR\u001c\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001c8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010\u001e¨\u0006$"}, d2 = {"Lokhttp3/FormBody;", "Lokhttp3/RequestBody;", "Lj/n;", "sink", "", "countBytes", "", "writeOrCountBytes", "(Lj/n;Z)J", "", "-deprecated_size", "()I", "size", "index", "", "encodedName", "(I)Ljava/lang/String;", "name", "encodedValue", "value", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "contentLength", "()J", "Lh/t1;", "writeTo", "(Lj/n;)V", "", "encodedValues", "Ljava/util/List;", "encodedNames", "<init>", "(Ljava/util/List;Ljava/util/List;)V", "Companion", "Builder", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class FormBody extends RequestBody {
    private final List<String> encodedNames;
    private final List<String> encodedValues;
    public static final Companion Companion = new Companion(null);
    private static final MediaType CONTENT_TYPE = MediaType.Companion.get("application/x-www-form-urlencoded");

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0003\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lokhttp3/FormBody$Companion;", "", "Lokhttp3/MediaType;", "CONTENT_TYPE", "Lokhttp3/MediaType;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    public FormBody(@d List<String> list, @d List<String> list2) {
        this.encodedNames = Util.toImmutableList(list);
        this.encodedValues = Util.toImmutableList(list2);
    }

    private final long writeOrCountBytes(n nVar, boolean z) {
        m mVar = z ? new m() : nVar.getBuffer();
        int size = this.encodedNames.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (i2 > 0) {
                mVar.writeByte(38);
            }
            mVar.B(this.encodedNames.get(i2));
            mVar.writeByte(61);
            mVar.B(this.encodedValues.get(i2));
        }
        if (z) {
            long O0 = mVar.O0();
            mVar.l();
            return O0;
        }
        return 0L;
    }

    @g(name = "-deprecated_size")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m158deprecated_size() {
        return size();
    }

    @Override // okhttp3.RequestBody
    public long contentLength() {
        return writeOrCountBytes(null, true);
    }

    @Override // okhttp3.RequestBody
    @d
    public MediaType contentType() {
        return CONTENT_TYPE;
    }

    @d
    public final String encodedName(int i2) {
        return this.encodedNames.get(i2);
    }

    @d
    public final String encodedValue(int i2) {
        return this.encodedValues.get(i2);
    }

    @d
    public final String name(int i2) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedName(i2), 0, 0, true, 3, null);
    }

    @g(name = "size")
    public final int size() {
        return this.encodedNames.size();
    }

    @d
    public final String value(int i2) {
        return HttpUrl.Companion.percentDecode$okhttp$default(HttpUrl.Companion, encodedValue(i2), 0, 0, true, 3, null);
    }

    @Override // okhttp3.RequestBody
    public void writeTo(@d n nVar) throws IOException {
        writeOrCountBytes(nVar, false);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f¢\u0006\u0004\b\u0012\u0010\u0013J\u001d\u0010\u0005\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\u0006J\r\u0010\t\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0010\u0010\u0011¨\u0006\u0014"}, d2 = {"Lokhttp3/FormBody$Builder;", "", "", "name", "value", "add", "(Ljava/lang/String;Ljava/lang/String;)Lokhttp3/FormBody$Builder;", "addEncoded", "Lokhttp3/FormBody;", "build", "()Lokhttp3/FormBody;", "", "values", "Ljava/util/List;", "names", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Builder {
        private final Charset charset;
        private final List<String> names;
        private final List<String> values;

        @h
        public Builder() {
            this(null, 1, null);
        }

        @h
        public Builder(@e Charset charset) {
            this.charset = charset;
            this.names = new ArrayList();
            this.values = new ArrayList();
        }

        @d
        public final Builder add(@d String str, @d String str2) {
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, false, false, true, false, this.charset, 91, null));
            return this;
        }

        @d
        public final Builder addEncoded(@d String str, @d String str2) {
            List<String> list = this.names;
            HttpUrl.Companion companion = HttpUrl.Companion;
            list.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            this.values.add(HttpUrl.Companion.canonicalize$okhttp$default(companion, str2, 0, 0, HttpUrl.FORM_ENCODE_SET, true, false, true, false, this.charset, 83, null));
            return this;
        }

        @d
        public final FormBody build() {
            return new FormBody(this.names, this.values);
        }

        public /* synthetic */ Builder(Charset charset, int i2, u uVar) {
            this((i2 & 1) != 0 ? null : charset);
        }
    }
}
