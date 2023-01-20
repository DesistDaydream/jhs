package okhttp3;

import h.h2.b;
import h.i;
import h.k2.g;
import h.k2.h;
import h.k2.k;
import h.k2.v.u;
import h.q0;
import j.m0;
import j.n;
import j.z;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import k.e.a.d;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.internal.Util;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u0011\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\bH&¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0016¢\u0006\u0004\b\u0010\u0010\u000f¨\u0006\u0014"}, d2 = {"Lokhttp3/RequestBody;", "", "Lokhttp3/MediaType;", "contentType", "()Lokhttp3/MediaType;", "", "contentLength", "()J", "Lj/n;", "sink", "Lh/t1;", "writeTo", "(Lj/n;)V", "", "isDuplex", "()Z", "isOneShot", "<init>", "()V", "Companion", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001f\u0010\b\u001a\u00020\u0005*\u00020\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J\u001f\u0010\b\u001a\u00020\u0005*\u00020\t2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\nJ3\u0010\b\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0006\u0010\u000fJ\u001f\u0010\u0012\u001a\u00020\u0005*\u00020\u00102\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0011J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0006\u0010\u0014J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\tH\u0007¢\u0006\u0004\b\u0006\u0010\u0015J5\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0013\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\fH\u0007¢\u0006\u0004\b\u0006\u0010\u0016J!\u0010\u0006\u001a\u00020\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0017\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u0006\u0010\u0018¨\u0006\u001b"}, d2 = {"Lokhttp3/RequestBody$Companion;", "", "", "Lokhttp3/MediaType;", "contentType", "Lokhttp3/RequestBody;", "create", "(Ljava/lang/String;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "toRequestBody", "Lokio/ByteString;", "(Lokio/ByteString;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "", "", "offset", "byteCount", "([BLokhttp3/MediaType;II)Lokhttp3/RequestBody;", "Ljava/io/File;", "(Ljava/io/File;Lokhttp3/MediaType;)Lokhttp3/RequestBody;", "asRequestBody", "content", "(Lokhttp3/MediaType;Ljava/lang/String;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;Lokio/ByteString;)Lokhttp3/RequestBody;", "(Lokhttp3/MediaType;[BII)Lokhttp3/RequestBody;", "file", "(Lokhttp3/MediaType;Ljava/io/File;)Lokhttp3/RequestBody;", "<init>", "()V", "okhttp"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, String str, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d String str, @e MediaType mediaType) {
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
            byte[] bytes = str.getBytes(charset);
            return create(bytes, mediaType, 0, bytes.length);
        }

        @h
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @k
        @d
        public final RequestBody create(@e MediaType mediaType, @d byte[] bArr) {
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        @h
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @k
        @d
        public final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i2) {
            return create$default(this, mediaType, bArr, i2, 0, 8, (Object) null);
        }

        @h
        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d byte[] bArr) {
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @h
        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d byte[] bArr, @e MediaType mediaType) {
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        @h
        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i2) {
            return create$default(this, bArr, mediaType, i2, 0, 4, (Object) null);
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                mediaType = null;
            }
            if ((i4 & 2) != 0) {
                i2 = 0;
            }
            if ((i4 & 4) != 0) {
                i3 = bArr.length;
            }
            return companion.create(bArr, mediaType, i2, i3);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, File file, MediaType mediaType, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        public static /* synthetic */ RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 4) != 0) {
                i2 = 0;
            }
            if ((i4 & 8) != 0) {
                i3 = bArr.length;
            }
            return companion.create(mediaType, bArr, i2, i3);
        }

        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d final ByteString byteString, @e final MediaType mediaType) {
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return ByteString.this.size();
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n nVar) {
                    nVar.r0(ByteString.this);
                }
            };
        }

        @h
        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d final byte[] bArr, @e final MediaType mediaType, final int i2, final int i3) {
            Util.checkOffsetAndCount(bArr.length, i2, i3);
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$toRequestBody$2
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return i3;
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n nVar) {
                    nVar.write(bArr, i2, i3);
                }
            };
        }

        @g(name = "create")
        @k
        @d
        public final RequestBody create(@d final File file, @e final MediaType mediaType) {
            return new RequestBody() { // from class: okhttp3.RequestBody$Companion$asRequestBody$1
                @Override // okhttp3.RequestBody
                public long contentLength() {
                    return file.length();
                }

                @Override // okhttp3.RequestBody
                @e
                public MediaType contentType() {
                    return mediaType;
                }

                @Override // okhttp3.RequestBody
                public void writeTo(@d n nVar) {
                    m0 l2 = z.l(file);
                    try {
                        nVar.E(l2);
                        b.a(l2, null);
                    } finally {
                    }
                }
            };
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @d
        public final RequestBody create(@e MediaType mediaType, @d String str) {
            return create(str, mediaType);
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @d
        public final RequestBody create(@e MediaType mediaType, @d ByteString byteString) {
            return create(byteString, mediaType);
        }

        @h
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
        @k
        @d
        public final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i2, int i3) {
            return create(bArr, mediaType, i2, i3);
        }

        @k
        @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @q0(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
        @d
        public final RequestBody create(@e MediaType mediaType, @d File file) {
            return create(file, mediaType);
        }
    }

    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d File file, @e MediaType mediaType) {
        return Companion.create(file, mediaType);
    }

    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d String str, @e MediaType mediaType) {
        return Companion.create(str, mediaType);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @q0(expression = "file.asRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.asRequestBody"}))
    @d
    public static final RequestBody create(@e MediaType mediaType, @d File file) {
        return Companion.create(mediaType, file);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @d
    public static final RequestBody create(@e MediaType mediaType, @d String str) {
        return Companion.create(mediaType, str);
    }

    @k
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @d
    public static final RequestBody create(@e MediaType mediaType, @d ByteString byteString) {
        return Companion.create(mediaType, byteString);
    }

    @h
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @k
    @d
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr) {
        return Companion.create$default(Companion, mediaType, bArr, 0, 0, 12, (Object) null);
    }

    @h
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @k
    @d
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i2) {
        return Companion.create$default(Companion, mediaType, bArr, i2, 0, 8, (Object) null);
    }

    @h
    @i(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @q0(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"okhttp3.RequestBody.Companion.toRequestBody"}))
    @k
    @d
    public static final RequestBody create(@e MediaType mediaType, @d byte[] bArr, int i2, int i3) {
        return Companion.create(mediaType, bArr, i2, i3);
    }

    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d ByteString byteString, @e MediaType mediaType) {
        return Companion.create(byteString, mediaType);
    }

    @h
    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d byte[] bArr) {
        return Companion.create$default(Companion, bArr, (MediaType) null, 0, 0, 7, (Object) null);
    }

    @h
    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType) {
        return Companion.create$default(Companion, bArr, mediaType, 0, 0, 6, (Object) null);
    }

    @h
    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i2) {
        return Companion.create$default(Companion, bArr, mediaType, i2, 0, 4, (Object) null);
    }

    @h
    @g(name = "create")
    @k
    @d
    public static final RequestBody create(@d byte[] bArr, @e MediaType mediaType, int i2, int i3) {
        return Companion.create(bArr, mediaType, i2, i3);
    }

    public long contentLength() throws IOException {
        return -1L;
    }

    @e
    public abstract MediaType contentType();

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public abstract void writeTo(@d n nVar) throws IOException;
}
