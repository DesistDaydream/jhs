package okhttp3;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.android.tpush.common.MessageKey;
import h.h2.b;
import h.i;
import h.k2.g;
import h.k2.k;
import h.k2.u.l;
import h.k2.v.c0;
import h.k2.v.u;
import i.b.q0;
import j.m;
import j.o;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 +2\u00020\u0001:\u0002,+B\u0007¢\u0006\u0004\b*\u0010'JB\u0010\t\u001a\u00028\u0000\"\b\b\u0000\u0010\u0003*\u00020\u00022\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\u00042\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0004H\u0082\b¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\f\u0010\rJ\u0011\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H&¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0005H&¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u001a\u001a\u00020\u0019¢\u0006\u0004\b\u001a\u0010\u001bJ\r\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b\u001d\u0010\u001eJ\r\u0010 \u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\r\u0010#\u001a\u00020\"¢\u0006\u0004\b#\u0010$J\u000f\u0010&\u001a\u00020%H\u0016¢\u0006\u0004\b&\u0010'R\u0018\u0010(\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)¨\u0006-"}, d2 = {"Lokhttp3/ResponseBody;", "Ljava/io/Closeable;", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlin/Function1;", "Lj/o;", "consumer", "", "sizeMapper", "consumeSource", "(Lh/k2/u/l;Lh/k2/u/l;)Ljava/lang/Object;", "Ljava/nio/charset/Charset;", "charset", "()Ljava/nio/charset/Charset;", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Ljava/io/InputStream;", "byteStream", "()Ljava/io/InputStream;", MessageKey.MSG_SOURCE, "()Lj/o;", "", "bytes", "()[B", "Lokio/ByteString;", "byteString", "()Lokio/ByteString;", "Ljava/io/Reader;", "charStream", "()Ljava/io/Reader;", "", "string", "()Ljava/lang/String;", "Lh/t1;", "close", "()V", "reader", "Ljava/io/Reader;", "<init>", "Companion", "BomAwareReader", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    private Reader reader;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\u0014¢\u0006\u0004\b\u0017\u0010\u0018J'\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bR\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0012\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0015\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "", "cbuf", "", q0.f15782e, "len", "read", "([CII)I", "Lh/t1;", "close", "()V", "Lj/o;", MessageKey.MSG_SOURCE, "Lj/o;", "delegate", "Ljava/io/Reader;", "", "closed", "Z", "Ljava/nio/charset/Charset;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Lj/o;Ljava/nio/charset/Charset;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final o source;

        public BomAwareReader(@d o oVar, @d Charset charset) {
            this.source = oVar;
            this.charset = charset;
        }

        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader != null) {
                reader.close();
            } else {
                this.source.close();
            }
        }

        @Override // java.io.Reader
        public int read(@d char[] cArr, int i2, int i3) throws IOException {
            if (!this.closed) {
                Reader reader = this.delegate;
                if (reader == null) {
                    reader = new InputStreamReader(this.source.inputStream(), Util.readBomAsCharset(this.source, this.charset));
                    this.delegate = reader;
                }
                return reader.read(cArr, i2, i3);
            }
            throw new IOException("Stream closed");
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\fJ)\u0010\u0011\u001a\u00020\u0005*\u00020\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0006\u0010\u0010J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0013J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0012\u001a\u00020\u000bH\u0007¢\u0006\u0004\b\u0006\u0010\u0015J)\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\rH\u0007¢\u0006\u0004\b\u0006\u0010\u0016¨\u0006\u0019"}, d2 = {"Lokhttp3/ResponseBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/ResponseBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "toResponseBody", "", "([BLokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lokio/ByteString;", "(Lokio/ByteString;Lokhttp3/MediaType;)Lokhttp3/ResponseBody;", "Lj/o;", "", "contentLength", "(Lj/o;Lokhttp3/MediaType;J)Lokhttp3/ResponseBody;", "asResponseBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;[B)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;Lokio/ByteString;)Lokhttp3/ResponseBody;", "(Lokhttp3/MediaType;JLj/o;)Lokhttp3/ResponseBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @g(name = "create")
        @k
        @d
        public final ResponseBody create(@d String str, @e MediaType mediaType) {
            Charset charset = h.t2.d.a;
            if (mediaType != null) {
                Charset charset$default = MediaType.charset$default(mediaType, null, 1, null);
                if (charset$default == null) {
                    MediaType.Companion companion = MediaType.Companion;
                    mediaType = companion.parse(mediaType + "; charset=utf-8");
                } else {
                    charset = charset$default;
                }
            }
            m k0 = new m().k0(str, charset);
            return create(k0, mediaType, k0.O0());
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ ResponseBody create$default(Companion companion, o oVar, MediaType mediaType, long j2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            if ((i2 & 2) != 0) {
                j2 = -1;
            }
            return companion.create(oVar, mediaType, j2);
        }

        @g(name = "create")
        @k
        @d
        public final ResponseBody create(@d byte[] bArr, @e MediaType mediaType) {
            return create(new m().write(bArr), mediaType, bArr.length);
        }

        @g(name = "create")
        @k
        @d
        public final ResponseBody create(@d ByteString byteString, @e MediaType mediaType) {
            return create(new m().r0(byteString), mediaType, byteString.size());
        }

        @g(name = "create")
        @k
        @d
        public final ResponseBody create(@d final o oVar, @e final MediaType mediaType, final long j2) {
            return new ResponseBody() { // from class: okhttp3.ResponseBody$Companion$asResponseBody$1
                @Override // okhttp3.ResponseBody
                public long contentLength() {
                    return j2;
                }

                @Override // okhttp3.ResponseBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.ResponseBody
                @d
                public o source() {
                    return o.this;
                }
            };
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @d
        public final ResponseBody create(@e MediaType mediaType, @d String str) {
            return create(str, mediaType);
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @d
        public final ResponseBody create(@e MediaType mediaType, @d byte[] bArr) {
            return create(bArr, mediaType);
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
        @d
        public final ResponseBody create(@e MediaType mediaType, @d ByteString byteString) {
            return create(byteString, mediaType);
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
        @d
        public final ResponseBody create(@e MediaType mediaType, long j2, @d o oVar) {
            return create(oVar, mediaType, j2);
        }
    }

    private final Charset charset() {
        Charset charset;
        MediaType contentType = contentType();
        return (contentType == null || (charset = contentType.charset(h.t2.d.a)) == null) ? h.t2.d.a : charset;
    }

    /* JADX WARN: Type inference failed for: r6v3, types: [T, java.lang.Object] */
    private final <T> T consumeSource(l<? super o, ? extends T> lVar, l<? super T, Integer> lVar2) {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            o source = source();
            try {
                T invoke = lVar.invoke(source);
                c0.d(1);
                b.a(source, null);
                c0.c(1);
                int intValue = lVar2.invoke(invoke).intValue();
                if (contentLength == -1 || contentLength == intValue) {
                    return invoke;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + intValue + ") disagree");
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @g(name = "create")
    @k
    @d
    public static final ResponseBody create(@d o oVar, @e MediaType mediaType, long j2) {
        return Companion.create(oVar, mediaType, j2);
    }

    @g(name = "create")
    @k
    @d
    public static final ResponseBody create(@d String str, @e MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.asResponseBody(contentType, contentLength)", imports = {"okhttp3.ResponseBody.Companion.asResponseBody"}))
    @d
    public static final ResponseBody create(@e MediaType mediaType, long j2, @d o oVar) {
        return Companion.create(mediaType, j2, oVar);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @d
    public static final ResponseBody create(@e MediaType mediaType, @d String str) {
        return Companion.create(mediaType, str);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @d
    public static final ResponseBody create(@e MediaType mediaType, @d ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @h.q0(expression = "content.toResponseBody(contentType)", imports = {"okhttp3.ResponseBody.Companion.toResponseBody"}))
    @d
    public static final ResponseBody create(@e MediaType mediaType, @d byte[] bArr) {
        return Companion.create(mediaType, bArr);
    }

    @g(name = "create")
    @k
    @d
    public static final ResponseBody create(@d ByteString byteString, @e MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @g(name = "create")
    @k
    @d
    public static final ResponseBody create(@d byte[] bArr, @e MediaType mediaType) {
        return Companion.create(bArr, mediaType);
    }

    @d
    public final InputStream byteStream() {
        return source().inputStream();
    }

    @d
    public final ByteString byteString() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            o source = source();
            try {
                ByteString j0 = source.j0();
                b.a(source, null);
                int size = j0.size();
                if (contentLength == -1 || contentLength == size) {
                    return j0;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + size + ") disagree");
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @d
    public final byte[] bytes() throws IOException {
        long contentLength = contentLength();
        if (contentLength <= Integer.MAX_VALUE) {
            o source = source();
            try {
                byte[] Z = source.Z();
                b.a(source, null);
                int length = Z.length;
                if (contentLength == -1 || contentLength == length) {
                    return Z;
                }
                throw new IOException("Content-Length (" + contentLength + ") and stream length (" + length + ") disagree");
            } finally {
            }
        } else {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength);
        }
    }

    @d
    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader != null) {
            return reader;
        }
        BomAwareReader bomAwareReader = new BomAwareReader(source(), charset());
        this.reader = bomAwareReader;
        return bomAwareReader;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        Util.closeQuietly(source());
    }

    public abstract long contentLength();

    @e
    public abstract MediaType contentType();

    @d
    public abstract o source();

    @d
    public final String string() throws IOException {
        o source = source();
        try {
            String g0 = source.g0(Util.readBomAsCharset(source, charset()));
            b.a(source, null);
            return g0;
        } finally {
        }
    }
}
