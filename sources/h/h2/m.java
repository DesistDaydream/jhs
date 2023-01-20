package h.h2;

import h.k2.v.f0;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0014\u001a\u00020\u0004H\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0010H\u0002J\u0018\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0002J\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020!H\u0002J\u0010\u0010#\u001a\u00020!2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lkotlin/io/LineReader;", "", "()V", "BUFFER_SIZE", "", "byteBuf", "Ljava/nio/ByteBuffer;", "bytes", "", "charBuf", "Ljava/nio/CharBuffer;", "chars", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "compactBytes", "decode", "endOfInput", "decodeEndOfInput", "nBytes", "nChars", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "resetAll", "", "trimStringBuilder", "updateCharset", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class m {
    private static final int a = 32;
    private static CharsetDecoder b;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f14887c;

    /* renamed from: d  reason: collision with root package name */
    private static final byte[] f14888d;

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f14889e;

    /* renamed from: f  reason: collision with root package name */
    private static final ByteBuffer f14890f;

    /* renamed from: g  reason: collision with root package name */
    private static final CharBuffer f14891g;
    @k.e.a.d

    /* renamed from: i  reason: collision with root package name */
    public static final m f14893i = new m();

    /* renamed from: h  reason: collision with root package name */
    private static final StringBuilder f14892h = new StringBuilder();

    static {
        byte[] bArr = new byte[32];
        f14888d = bArr;
        char[] cArr = new char[32];
        f14889e = cArr;
        f14890f = ByteBuffer.wrap(bArr);
        f14891g = CharBuffer.wrap(cArr);
    }

    private m() {
    }

    private final int c() {
        ByteBuffer byteBuffer = f14890f;
        byteBuffer.compact();
        int position = byteBuffer.position();
        byteBuffer.position(0);
        return position;
    }

    private final int d(boolean z) {
        while (true) {
            CharsetDecoder charsetDecoder = b;
            ByteBuffer byteBuffer = f14890f;
            CharBuffer charBuffer = f14891g;
            CoderResult decode = charsetDecoder.decode(byteBuffer, charBuffer, z);
            if (decode.isError()) {
                g();
                decode.throwException();
            }
            int position = charBuffer.position();
            if (!decode.isOverflow()) {
                return position;
            }
            StringBuilder sb = f14892h;
            char[] cArr = f14889e;
            int i2 = position - 1;
            sb.append(cArr, 0, i2);
            charBuffer.position(0);
            charBuffer.limit(32);
            charBuffer.put(cArr[i2]);
        }
    }

    private final int e(int i2, int i3) {
        ByteBuffer byteBuffer = f14890f;
        byteBuffer.limit(i2);
        f14891g.position(i3);
        int d2 = d(true);
        b.reset();
        byteBuffer.position(0);
        return d2;
    }

    private final void g() {
        b.reset();
        f14890f.position(0);
        f14892h.setLength(0);
    }

    private final void h() {
        StringBuilder sb = f14892h;
        sb.setLength(32);
        sb.trimToSize();
    }

    private final void i(Charset charset) {
        b = charset.newDecoder();
        ByteBuffer byteBuffer = f14890f;
        byteBuffer.clear();
        CharBuffer charBuffer = f14891g;
        charBuffer.clear();
        byteBuffer.put((byte) 10);
        byteBuffer.flip();
        boolean z = false;
        b.decode(byteBuffer, charBuffer, false);
        if (charBuffer.position() == 1 && charBuffer.get(0) == '\n') {
            z = true;
        }
        f14887c = z;
        g();
    }

    @k.e.a.e
    public final synchronized String f(@k.e.a.d InputStream inputStream, @k.e.a.d Charset charset) {
        CharsetDecoder charsetDecoder;
        int e2;
        boolean z = true;
        if (b == null || (!f0.g(charsetDecoder.charset(), charset))) {
            i(charset);
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int read = inputStream.read();
            if (read == -1) {
                if ((f14892h.length() == 0) && i2 == 0 && i3 == 0) {
                    return null;
                }
                e2 = e(i2, i3);
            } else {
                int i4 = i2 + 1;
                f14888d[i2] = (byte) read;
                if (read != 10 && i4 != 32 && f14887c) {
                    i2 = i4;
                }
                ByteBuffer byteBuffer = f14890f;
                byteBuffer.limit(i4);
                f14891g.position(i3);
                i3 = d(false);
                if (i3 > 0 && f14889e[i3 - 1] == '\n') {
                    byteBuffer.position(0);
                    e2 = i3;
                    break;
                }
                i2 = c();
            }
        }
        if (e2 > 0) {
            char[] cArr = f14889e;
            if (cArr[e2 - 1] == '\n' && e2 - 1 > 0 && cArr[e2 - 1] == '\r') {
                e2--;
            }
        }
        StringBuilder sb = f14892h;
        if (sb.length() != 0) {
            z = false;
        }
        if (z) {
            return new String(f14889e, 0, e2);
        }
        sb.append(f14889e, 0, e2);
        String sb2 = sb.toString();
        if (sb.length() > 32) {
            h();
        }
        sb.setLength(0);
        return sb2;
    }
}
