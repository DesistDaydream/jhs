package okio;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.moor.imkf.YKFConstants;
import com.umeng.analytics.pro.am;
import com.umeng.analytics.pro.cb;
import e.j.a.b.c.f;
import h.a2.n;
import h.i;
import h.k2.d;
import h.k2.g;
import h.k2.h;
import h.k2.k;
import h.k2.v.u;
import h.q0;
import j.j;
import j.m;
import j.q0.b;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Objects;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import k.e.a.e;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\u0012\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0019\b\u0016\u0018\u0000 r2\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u0002:\u0001sB\u0011\b\u0000\u0012\u0006\u0010e\u001a\u000209¢\u0006\u0004\bp\u0010qJ\u0017\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000f\u0010\u0013\u001a\u00020\fH\u0016¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u000f\u0010\u0016\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0017\u0010\u0015J\u000f\u0010\u0018\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u0018\u0010\u0015J\u0017\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\fH\u0010¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010 \u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b \u0010\u001fJ\u0017\u0010!\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0000H\u0016¢\u0006\u0004\b!\u0010\u001fJ\u001f\u0010$\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\u0000H\u0010¢\u0006\u0004\b\"\u0010#J\u000f\u0010%\u001a\u00020\fH\u0016¢\u0006\u0004\b%\u0010\u000eJ\u000f\u0010&\u001a\u00020\fH\u0016¢\u0006\u0004\b&\u0010\u000eJ\u000f\u0010'\u001a\u00020\u0000H\u0016¢\u0006\u0004\b'\u0010\u0015J\u000f\u0010(\u001a\u00020\u0000H\u0016¢\u0006\u0004\b(\u0010\u0015J#\u0010,\u001a\u00020\u00002\b\b\u0002\u0010*\u001a\u00020)2\b\b\u0002\u0010+\u001a\u00020)H\u0017¢\u0006\u0004\b,\u0010-J\u0017\u00102\u001a\u00020/2\u0006\u0010.\u001a\u00020)H\u0010¢\u0006\u0004\b0\u00101J\u0018\u00105\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0087\u0002¢\u0006\u0004\b4\u00101J\u000f\u00108\u001a\u00020)H\u0010¢\u0006\u0004\b6\u00107J\u000f\u0010:\u001a\u000209H\u0016¢\u0006\u0004\b:\u0010;J\u000f\u0010=\u001a\u000209H\u0010¢\u0006\u0004\b<\u0010;J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u0017\u0010B\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ'\u0010B\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0006\u0010F\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0010¢\u0006\u0004\bH\u0010IJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010NJ/\u0010M\u001a\u00020L2\u0006\u0010F\u001a\u00020)2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020)2\u0006\u0010G\u001a\u00020)H\u0016¢\u0006\u0004\bM\u0010OJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u00020\u0000¢\u0006\u0004\bQ\u0010RJ\u0015\u0010Q\u001a\u00020L2\u0006\u0010P\u001a\u000209¢\u0006\u0004\bQ\u0010SJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u00020\u0000¢\u0006\u0004\bU\u0010RJ\u0015\u0010U\u001a\u00020L2\u0006\u0010T\u001a\u000209¢\u0006\u0004\bU\u0010SJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bW\u0010XJ!\u0010W\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bW\u0010YJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u00020\u00002\b\b\u0002\u0010V\u001a\u00020)H\u0007¢\u0006\u0004\bZ\u0010XJ!\u0010Z\u001a\u00020)2\u0006\u0010J\u001a\u0002092\b\b\u0002\u0010V\u001a\u00020)H\u0017¢\u0006\u0004\bZ\u0010YJ\u001a\u0010\\\u001a\u00020L2\b\u0010J\u001a\u0004\u0018\u00010[H\u0096\u0002¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020)H\u0016¢\u0006\u0004\b^\u00107J\u0018\u0010_\u001a\u00020)2\u0006\u0010J\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b_\u0010`J\u000f\u0010a\u001a\u00020\fH\u0016¢\u0006\u0004\ba\u0010\u000eJ\u0017\u00104\u001a\u00020/2\u0006\u00103\u001a\u00020)H\u0007¢\u0006\u0004\bb\u00101J\u000f\u0010d\u001a\u00020)H\u0007¢\u0006\u0004\bc\u00107R\u0013\u0010d\u001a\u00020)8G@\u0006¢\u0006\u0006\u001a\u0004\bd\u00107R\u001c\u0010e\u001a\u0002098\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\be\u0010f\u001a\u0004\bg\u0010;R$\u0010\r\u001a\u0004\u0018\u00010\f8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b\r\u0010h\u001a\u0004\bi\u0010\u000e\"\u0004\bj\u0010kR\"\u0010^\u001a\u00020)8\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b^\u0010l\u001a\u0004\bm\u00107\"\u0004\bn\u0010o¨\u0006t"}, d2 = {"Lokio/ByteString;", "Ljava/io/Serializable;", "", "Ljava/io/ObjectInputStream;", YKFConstants.INVESTIGATE_TYPE_IN, "Lh/t1;", "readObject", "(Ljava/io/ObjectInputStream;)V", "Ljava/io/ObjectOutputStream;", YKFConstants.INVESTIGATE_TYPE_OUT, "writeObject", "(Ljava/io/ObjectOutputStream;)V", "", "utf8", "()Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "string", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "base64", "md5", "()Lokio/ByteString;", "sha1", "sha256", "sha512", "algorithm", "digest$okio", "(Ljava/lang/String;)Lokio/ByteString;", "digest", "key", "hmacSha1", "(Lokio/ByteString;)Lokio/ByteString;", "hmacSha256", "hmacSha512", "hmac$okio", "(Ljava/lang/String;Lokio/ByteString;)Lokio/ByteString;", "hmac", "base64Url", "hex", "toAsciiLowercase", "toAsciiUppercase", "", "beginIndex", "endIndex", "substring", "(II)Lokio/ByteString;", "pos", "", "internalGet$okio", "(I)B", "internalGet", "index", "getByte", "get", "getSize$okio", "()I", "getSize", "", "toByteArray", "()[B", "internalArray$okio", "internalArray", "Ljava/nio/ByteBuffer;", "asByteBuffer", "()Ljava/nio/ByteBuffer;", "Ljava/io/OutputStream;", "write", "(Ljava/io/OutputStream;)V", "Lj/m;", "buffer", "offset", "byteCount", "write$okio", "(Lj/m;II)V", "other", "otherOffset", "", "rangeEquals", "(ILokio/ByteString;II)Z", "(I[BII)Z", "prefix", "startsWith", "(Lokio/ByteString;)Z", "([B)Z", "suffix", "endsWith", "fromIndex", "indexOf", "(Lokio/ByteString;I)I", "([BI)I", "lastIndexOf", "", "equals", "(Ljava/lang/Object;)Z", TTDownloadField.TT_HASHCODE, "compareTo", "(Lokio/ByteString;)I", "toString", "-deprecated_getByte", "-deprecated_size", "size", "data", "[B", "getData$okio", "Ljava/lang/String;", "getUtf8$okio", "setUtf8$okio", "(Ljava/lang/String;)V", ExpandableTextView.P, "getHashCode$okio", "setHashCode$okio", "(I)V", "<init>", "([B)V", "Companion", am.av, "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class ByteString implements Serializable, Comparable<ByteString> {
    public static final a Companion = new a(null);
    @d
    @k.e.a.d
    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private static final long serialVersionUID = 1;
    @k.e.a.d
    private final byte[] data;
    private transient int hashCode;
    @e
    private transient String utf8;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\t\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b,\u0010-J\u001b\u0010\u0006\u001a\u00020\u00052\n\u0010\u0004\u001a\u00020\u0002\"\u00020\u0003H\u0007¢\u0006\u0004\b\u0006\u0010\u0007J'\u0010\u000b\u001a\u00020\u0005*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\u000e\u001a\u00020\u0005*\u00020\rH\u0007¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0011\u001a\u00020\u0005*\u00020\u0010H\u0007¢\u0006\u0004\b\u0011\u0010\u0012J\u001d\u0010\u0015\u001a\u00020\u0005*\u00020\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u0015\u0010\u0016J\u0015\u0010\u0017\u001a\u0004\u0018\u00010\u0005*\u00020\u0010H\u0007¢\u0006\u0004\b\u0017\u0010\u0012J\u0013\u0010\u0018\u001a\u00020\u0005*\u00020\u0010H\u0007¢\u0006\u0004\b\u0018\u0010\u0012J\u001b\u0010\u001a\u001a\u00020\u0005*\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001c\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001d\u0010\u0012J\u0017\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0010H\u0007¢\u0006\u0004\b\u001e\u0010\u0012J\u001f\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u0013H\u0007¢\u0006\u0004\b\u001f\u0010\u0016J\u0017\u0010 \u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0010H\u0007¢\u0006\u0004\b \u0010\u0012J\u0017\u0010\"\u001a\u00020\u00052\u0006\u0010!\u001a\u00020\rH\u0007¢\u0006\u0004\b\"\u0010\u000fJ'\u0010$\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b$\u0010\fJ\u001f\u0010&\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u00192\u0006\u0010\n\u001a\u00020\bH\u0007¢\u0006\u0004\b&\u0010\u001bR\u0016\u0010'\u001a\u00020\u00058\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010*\u001a\u00020)8\u0002@\u0002X\u0082T¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006."}, d2 = {"okio/ByteString$a", "", "", "", "data", "Lokio/ByteString;", "n", "([B)Lokio/ByteString;", "", "offset", "byteCount", "o", "([BII)Lokio/ByteString;", "Ljava/nio/ByteBuffer;", "m", "(Ljava/nio/ByteBuffer;)Lokio/ByteString;", "", NotifyType.LIGHTS, "(Ljava/lang/String;)Lokio/ByteString;", "Ljava/nio/charset/Charset;", "charset", "j", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lokio/ByteString;", "h", "i", "Ljava/io/InputStream;", "q", "(Ljava/io/InputStream;I)Lokio/ByteString;", "string", am.av, "b", "c", f.f10128d, "buffer", com.huawei.hms.push.e.a, "array", "f", "inputstream", "g", "EMPTY", "Lokio/ByteString;", "", "serialVersionUID", "J", "<init>", "()V", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a {
        private a() {
        }

        public static /* synthetic */ ByteString k(a aVar, String str, Charset charset, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                charset = h.t2.d.a;
            }
            return aVar.j(str, charset);
        }

        public static /* synthetic */ ByteString p(a aVar, byte[] bArr, int i2, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = bArr.length;
            }
            return aVar.o(bArr, i2, i3);
        }

        @g(name = "-deprecated_decodeBase64")
        @e
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "string.decodeBase64()", imports = {"okio.ByteString.Companion.decodeBase64"}))
        public final ByteString a(@k.e.a.d String str) {
            return h(str);
        }

        @g(name = "-deprecated_decodeHex")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "string.decodeHex()", imports = {"okio.ByteString.Companion.decodeHex"}))
        @k.e.a.d
        public final ByteString b(@k.e.a.d String str) {
            return i(str);
        }

        @g(name = "-deprecated_encodeString")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "string.encode(charset)", imports = {"okio.ByteString.Companion.encode"}))
        @k.e.a.d
        public final ByteString c(@k.e.a.d String str, @k.e.a.d Charset charset) {
            return j(str, charset);
        }

        @g(name = "-deprecated_encodeUtf8")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "string.encodeUtf8()", imports = {"okio.ByteString.Companion.encodeUtf8"}))
        @k.e.a.d
        public final ByteString d(@k.e.a.d String str) {
            return l(str);
        }

        @g(name = "-deprecated_of")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "buffer.toByteString()", imports = {"okio.ByteString.Companion.toByteString"}))
        @k.e.a.d
        public final ByteString e(@k.e.a.d ByteBuffer byteBuffer) {
            return m(byteBuffer);
        }

        @g(name = "-deprecated_of")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "array.toByteString(offset, byteCount)", imports = {"okio.ByteString.Companion.toByteString"}))
        @k.e.a.d
        public final ByteString f(@k.e.a.d byte[] bArr, int i2, int i3) {
            return o(bArr, i2, i3);
        }

        @g(name = "-deprecated_read")
        @i(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @q0(expression = "inputstream.readByteString(byteCount)", imports = {"okio.ByteString.Companion.readByteString"}))
        @k.e.a.d
        public final ByteString g(@k.e.a.d InputStream inputStream, int i2) {
            return q(inputStream, i2);
        }

        @k
        @e
        public final ByteString h(@k.e.a.d String str) {
            byte[] a = j.a.a(str);
            if (a != null) {
                return new ByteString(a);
            }
            return null;
        }

        @k
        @k.e.a.d
        public final ByteString i(@k.e.a.d String str) {
            if (str.length() % 2 == 0) {
                int length = str.length() / 2;
                byte[] bArr = new byte[length];
                for (int i2 = 0; i2 < length; i2++) {
                    int i3 = i2 * 2;
                    bArr[i2] = (byte) ((b.b(str.charAt(i3)) << 4) + b.b(str.charAt(i3 + 1)));
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("Unexpected hex string: " + str).toString());
        }

        @g(name = "encodeString")
        @k
        @k.e.a.d
        public final ByteString j(@k.e.a.d String str, @k.e.a.d Charset charset) {
            return new ByteString(str.getBytes(charset));
        }

        @k
        @k.e.a.d
        public final ByteString l(@k.e.a.d String str) {
            ByteString byteString = new ByteString(j.i.a(str));
            byteString.setUtf8$okio(str);
            return byteString;
        }

        @g(name = "of")
        @k
        @k.e.a.d
        public final ByteString m(@k.e.a.d ByteBuffer byteBuffer) {
            byte[] bArr = new byte[byteBuffer.remaining()];
            byteBuffer.get(bArr);
            return new ByteString(bArr);
        }

        @k
        @k.e.a.d
        public final ByteString n(@k.e.a.d byte... bArr) {
            return new ByteString(Arrays.copyOf(bArr, bArr.length));
        }

        @g(name = "of")
        @k
        @k.e.a.d
        public final ByteString o(@k.e.a.d byte[] bArr, int i2, int i3) {
            j.e(bArr.length, i2, i3);
            return new ByteString(n.G1(bArr, i2, i3 + i2));
        }

        @g(name = "read")
        @k
        @k.e.a.d
        public final ByteString q(@k.e.a.d InputStream inputStream, int i2) throws IOException {
            int i3 = 0;
            if (i2 >= 0) {
                byte[] bArr = new byte[i2];
                while (i3 < i2) {
                    int read = inputStream.read(bArr, i3, i2 - i3);
                    if (read == -1) {
                        throw new EOFException();
                    }
                    i3 += read;
                }
                return new ByteString(bArr);
            }
            throw new IllegalArgumentException(("byteCount < 0: " + i2).toString());
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public ByteString(@k.e.a.d byte[] bArr) {
        this.data = bArr;
    }

    @k
    @e
    public static final ByteString decodeBase64(@k.e.a.d String str) {
        return Companion.h(str);
    }

    @k
    @k.e.a.d
    public static final ByteString decodeHex(@k.e.a.d String str) {
        return Companion.i(str);
    }

    @g(name = "encodeString")
    @k
    @k.e.a.d
    public static final ByteString encodeString(@k.e.a.d String str, @k.e.a.d Charset charset) {
        return Companion.j(str, charset);
    }

    @k
    @k.e.a.d
    public static final ByteString encodeUtf8(@k.e.a.d String str) {
        return Companion.l(str);
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return byteString.indexOf(byteString2, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int indexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = 0;
            }
            return byteString.indexOf(bArr, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: indexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, ByteString byteString2, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = byteString.size();
            }
            return byteString.lastIndexOf(byteString2, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    public static /* synthetic */ int lastIndexOf$default(ByteString byteString, byte[] bArr, int i2, int i3, Object obj) {
        if (obj == null) {
            if ((i3 & 2) != 0) {
                i2 = byteString.size();
            }
            return byteString.lastIndexOf(bArr, i2);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: lastIndexOf");
    }

    @g(name = "of")
    @k
    @k.e.a.d
    public static final ByteString of(@k.e.a.d ByteBuffer byteBuffer) {
        return Companion.m(byteBuffer);
    }

    @k
    @k.e.a.d
    public static final ByteString of(@k.e.a.d byte... bArr) {
        return Companion.n(bArr);
    }

    @g(name = "of")
    @k
    @k.e.a.d
    public static final ByteString of(@k.e.a.d byte[] bArr, int i2, int i3) {
        return Companion.o(bArr, i2, i3);
    }

    @g(name = "read")
    @k
    @k.e.a.d
    public static final ByteString read(@k.e.a.d InputStream inputStream, int i2) throws IOException {
        return Companion.q(inputStream, i2);
    }

    private final void readObject(ObjectInputStream objectInputStream) throws IOException {
        ByteString q = Companion.q(objectInputStream, objectInputStream.readInt());
        Field declaredField = ByteString.class.getDeclaredField("data");
        declaredField.setAccessible(true);
        declaredField.set(this, q.data);
    }

    public static /* synthetic */ ByteString substring$default(ByteString byteString, int i2, int i3, int i4, Object obj) {
        if (obj == null) {
            if ((i4 & 1) != 0) {
                i2 = 0;
            }
            if ((i4 & 2) != 0) {
                i3 = byteString.size();
            }
            return byteString.substring(i2, i3);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: substring");
    }

    private final void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.data.length);
        objectOutputStream.write(this.data);
    }

    @g(name = "-deprecated_getByte")
    @i(level = DeprecationLevel.ERROR, message = "moved to operator function", replaceWith = @q0(expression = "this[index]", imports = {}))
    /* renamed from: -deprecated_getByte  reason: not valid java name */
    public final byte m252deprecated_getByte(int i2) {
        return getByte(i2);
    }

    @g(name = "-deprecated_size")
    @i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "size", imports = {}))
    /* renamed from: -deprecated_size  reason: not valid java name */
    public final int m253deprecated_size() {
        return size();
    }

    @k.e.a.d
    public ByteBuffer asByteBuffer() {
        return ByteBuffer.wrap(this.data).asReadOnlyBuffer();
    }

    @k.e.a.d
    public String base64() {
        return j.a.c(getData$okio(), null, 1, null);
    }

    @k.e.a.d
    public String base64Url() {
        return j.a.b(getData$okio(), j.a.e());
    }

    @k.e.a.d
    public ByteString digest$okio(@k.e.a.d String str) {
        return new ByteString(MessageDigest.getInstance(str).digest(this.data));
    }

    public final boolean endsWith(@k.e.a.d ByteString byteString) {
        return rangeEquals(size() - byteString.size(), byteString, 0, byteString.size());
    }

    public boolean equals(@e Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == getData$okio().length && byteString.rangeEquals(0, getData$okio(), 0, getData$okio().length)) {
                return true;
            }
        }
        return false;
    }

    @g(name = "getByte")
    public final byte getByte(int i2) {
        return internalGet$okio(i2);
    }

    @k.e.a.d
    public final byte[] getData$okio() {
        return this.data;
    }

    public final int getHashCode$okio() {
        return this.hashCode;
    }

    public int getSize$okio() {
        return getData$okio().length;
    }

    @e
    public final String getUtf8$okio() {
        return this.utf8;
    }

    public int hashCode() {
        int hashCode$okio = getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int hashCode = Arrays.hashCode(getData$okio());
        setHashCode$okio(hashCode);
        return hashCode;
    }

    @k.e.a.d
    public String hex() {
        byte[] data$okio;
        char[] cArr = new char[getData$okio().length * 2];
        int i2 = 0;
        for (byte b : getData$okio()) {
            int i3 = i2 + 1;
            cArr[i2] = b.I()[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = b.I()[b & cb.f7124m];
        }
        return new String(cArr);
    }

    @k.e.a.d
    public ByteString hmac$okio(@k.e.a.d String str, @k.e.a.d ByteString byteString) {
        try {
            Mac mac = Mac.getInstance(str);
            mac.init(new SecretKeySpec(byteString.toByteArray(), str));
            return new ByteString(mac.doFinal(this.data));
        } catch (InvalidKeyException e2) {
            throw new IllegalArgumentException(e2);
        }
    }

    @k.e.a.d
    public ByteString hmacSha1(@k.e.a.d ByteString byteString) {
        return hmac$okio("HmacSHA1", byteString);
    }

    @k.e.a.d
    public ByteString hmacSha256(@k.e.a.d ByteString byteString) {
        return hmac$okio("HmacSHA256", byteString);
    }

    @k.e.a.d
    public ByteString hmacSha512(@k.e.a.d ByteString byteString) {
        return hmac$okio("HmacSHA512", byteString);
    }

    @h
    public final int indexOf(@k.e.a.d ByteString byteString) {
        return indexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @h
    public final int indexOf(@k.e.a.d ByteString byteString, int i2) {
        return indexOf(byteString.internalArray$okio(), i2);
    }

    @h
    public final int indexOf(@k.e.a.d byte[] bArr) {
        return indexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @k.e.a.d
    public byte[] internalArray$okio() {
        return getData$okio();
    }

    public byte internalGet$okio(int i2) {
        return getData$okio()[i2];
    }

    @h
    public final int lastIndexOf(@k.e.a.d ByteString byteString) {
        return lastIndexOf$default(this, byteString, 0, 2, (Object) null);
    }

    @h
    public final int lastIndexOf(@k.e.a.d ByteString byteString, int i2) {
        return lastIndexOf(byteString.internalArray$okio(), i2);
    }

    @h
    public final int lastIndexOf(@k.e.a.d byte[] bArr) {
        return lastIndexOf$default(this, bArr, 0, 2, (Object) null);
    }

    @k.e.a.d
    public ByteString md5() {
        return digest$okio("MD5");
    }

    public boolean rangeEquals(int i2, @k.e.a.d ByteString byteString, int i3, int i4) {
        return byteString.rangeEquals(i3, getData$okio(), i2, i4);
    }

    public final void setHashCode$okio(int i2) {
        this.hashCode = i2;
    }

    public final void setUtf8$okio(@e String str) {
        this.utf8 = str;
    }

    @k.e.a.d
    public ByteString sha1() {
        return digest$okio("SHA-1");
    }

    @k.e.a.d
    public ByteString sha256() {
        return digest$okio("SHA-256");
    }

    @k.e.a.d
    public ByteString sha512() {
        return digest$okio("SHA-512");
    }

    @g(name = "size")
    public final int size() {
        return getSize$okio();
    }

    public final boolean startsWith(@k.e.a.d ByteString byteString) {
        return rangeEquals(0, byteString, 0, byteString.size());
    }

    @k.e.a.d
    public String string(@k.e.a.d Charset charset) {
        return new String(this.data, charset);
    }

    @h
    @k.e.a.d
    public final ByteString substring() {
        return substring$default(this, 0, 0, 3, null);
    }

    @h
    @k.e.a.d
    public final ByteString substring(int i2) {
        return substring$default(this, i2, 0, 2, null);
    }

    @h
    @k.e.a.d
    public ByteString substring(int i2, int i3) {
        if (i2 >= 0) {
            if (i3 <= getData$okio().length) {
                if (i3 - i2 >= 0) {
                    return (i2 == 0 && i3 == getData$okio().length) ? this : new ByteString(n.G1(getData$okio(), i2, i3));
                }
                throw new IllegalArgumentException("endIndex < beginIndex".toString());
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        throw new IllegalArgumentException("beginIndex < 0".toString());
    }

    @k.e.a.d
    public ByteString toAsciiLowercase() {
        byte b;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b2 = getData$okio()[i2];
            byte b3 = (byte) 65;
            if (b2 >= b3 && b2 <= (b = (byte) 90)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i2] = (byte) (b2 + 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b4 = copyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i3] = (byte) (b4 + 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @k.e.a.d
    public ByteString toAsciiUppercase() {
        byte b;
        for (int i2 = 0; i2 < getData$okio().length; i2++) {
            byte b2 = getData$okio()[i2];
            byte b3 = (byte) 97;
            if (b2 >= b3 && b2 <= (b = (byte) 122)) {
                byte[] data$okio = getData$okio();
                byte[] copyOf = Arrays.copyOf(data$okio, data$okio.length);
                copyOf[i2] = (byte) (b2 - 32);
                for (int i3 = i2 + 1; i3 < copyOf.length; i3++) {
                    byte b4 = copyOf[i3];
                    if (b4 >= b3 && b4 <= b) {
                        copyOf[i3] = (byte) (b4 - 32);
                    }
                }
                return new ByteString(copyOf);
            }
        }
        return this;
    }

    @k.e.a.d
    public byte[] toByteArray() {
        byte[] data$okio = getData$okio();
        return Arrays.copyOf(data$okio, data$okio.length);
    }

    @k.e.a.d
    public String toString() {
        if (getData$okio().length == 0) {
            return "[size=0]";
        }
        int a2 = b.a(getData$okio(), 64);
        if (a2 == -1) {
            if (getData$okio().length <= 64) {
                return "[hex=" + hex() + ']';
            }
            StringBuilder sb = new StringBuilder();
            sb.append("[size=");
            sb.append(getData$okio().length);
            sb.append(" hex=");
            if (64 <= getData$okio().length) {
                sb.append((64 == getData$okio().length ? this : new ByteString(n.G1(getData$okio(), 0, 64))).hex());
                sb.append("…]");
                return sb.toString();
            }
            throw new IllegalArgumentException(("endIndex > length(" + getData$okio().length + ')').toString());
        }
        String utf8 = utf8();
        Objects.requireNonNull(utf8, "null cannot be cast to non-null type java.lang.String");
        String k2 = h.t2.u.k2(h.t2.u.k2(h.t2.u.k2(utf8.substring(0, a2), "\\", "\\\\", false, 4, null), "\n", "\\n", false, 4, null), "\r", "\\r", false, 4, null);
        if (a2 < utf8.length()) {
            return "[size=" + getData$okio().length + " text=" + k2 + "…]";
        }
        return "[text=" + k2 + ']';
    }

    @k.e.a.d
    public String utf8() {
        String utf8$okio = getUtf8$okio();
        if (utf8$okio == null) {
            String c2 = j.i.c(internalArray$okio());
            setUtf8$okio(c2);
            return c2;
        }
        return utf8$okio;
    }

    public void write(@k.e.a.d OutputStream outputStream) throws IOException {
        outputStream.write(this.data);
    }

    public void write$okio(@k.e.a.d m mVar, int i2, int i3) {
        b.G(this, mVar, i2, i3);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002b A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002d A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(@k.e.a.d okio.ByteString r10) {
        /*
            r9 = this;
            int r0 = r9.size()
            int r1 = r10.size()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        Le:
            r5 = -1
            r6 = 1
            if (r4 >= r2) goto L26
            byte r7 = r9.getByte(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r8 = r10.getByte(r4)
            r8 = r8 & 255(0xff, float:3.57E-43)
            if (r7 != r8) goto L23
            int r4 = r4 + 1
            goto Le
        L23:
            if (r7 >= r8) goto L2d
            goto L2b
        L26:
            if (r0 != r1) goto L29
            goto L2e
        L29:
            if (r0 >= r1) goto L2d
        L2b:
            r3 = -1
            goto L2e
        L2d:
            r3 = 1
        L2e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.ByteString.compareTo(okio.ByteString):int");
    }

    public final boolean endsWith(@k.e.a.d byte[] bArr) {
        return rangeEquals(size() - bArr.length, bArr, 0, bArr.length);
    }

    @h
    public int indexOf(@k.e.a.d byte[] bArr, int i2) {
        int length = getData$okio().length - bArr.length;
        int max = Math.max(i2, 0);
        if (max <= length) {
            while (!j.d(getData$okio(), max, bArr, 0, bArr.length)) {
                if (max != length) {
                    max++;
                }
            }
            return max;
        }
        return -1;
    }

    @h
    public int lastIndexOf(@k.e.a.d byte[] bArr, int i2) {
        for (int min = Math.min(i2, getData$okio().length - bArr.length); min >= 0; min--) {
            if (j.d(getData$okio(), min, bArr, 0, bArr.length)) {
                return min;
            }
        }
        return -1;
    }

    public boolean rangeEquals(int i2, @k.e.a.d byte[] bArr, int i3, int i4) {
        return i2 >= 0 && i2 <= getData$okio().length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && j.d(getData$okio(), i2, bArr, i3, i4);
    }

    public final boolean startsWith(@k.e.a.d byte[] bArr) {
        return rangeEquals(0, bArr, 0, bArr.length);
    }
}
