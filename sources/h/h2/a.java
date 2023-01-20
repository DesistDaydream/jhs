package h.h2;

import com.moor.imkf.YKFConstants;
import h.a2.q;
import h.q0;
import h.s0;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.NoSuchElementException;
import java.util.Objects;
import kotlin.Metadata;

@h.k2.g(name = "ByteStreamsKt")
@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0000\u001a\u00020\u0005*\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u0017\u0010\u0007\u001a\u00020\b*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u000b\u001a\u00020\f*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\r\u001a\u00020\u000e*\u00020\u000f2\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u001c\u0010\u0010\u001a\u00020\u0011*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u001a\r\u0010\u0013\u001a\u00020\u000e*\u00020\u0014H\u0087\b\u001a\u001d\u0010\u0013\u001a\u00020\u000e*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0087\b\u001a\r\u0010\u0017\u001a\u00020\u0018*\u00020\u0001H\u0086\u0002\u001a\f\u0010\u0019\u001a\u00020\u0014*\u00020\u0002H\u0007\u001a\u0016\u0010\u0019\u001a\u00020\u0014*\u00020\u00022\b\b\u0002\u0010\u001a\u001a\u00020\u0004H\u0007\u001a\u0017\u0010\u001b\u001a\u00020\u001c*\u00020\u00022\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b\u001a\u0017\u0010\u001d\u001a\u00020\u001e*\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\nH\u0087\b¨\u0006\u001f"}, d2 = {"buffered", "Ljava/io/BufferedInputStream;", "Ljava/io/InputStream;", "bufferSize", "", "Ljava/io/BufferedOutputStream;", "Ljava/io/OutputStream;", "bufferedReader", "Ljava/io/BufferedReader;", "charset", "Ljava/nio/charset/Charset;", "bufferedWriter", "Ljava/io/BufferedWriter;", "byteInputStream", "Ljava/io/ByteArrayInputStream;", "", "copyTo", "", YKFConstants.INVESTIGATE_TYPE_OUT, "inputStream", "", "offset", "length", "iterator", "Lkotlin/collections/ByteIterator;", "readBytes", "estimatedSize", "reader", "Ljava/io/InputStreamReader;", "writer", "Ljava/io/OutputStreamWriter;", "kotlin-stdlib"}, k = 2, mv = {1, 5, 1})
/* loaded from: classes3.dex */
public final class a {

    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\t\u0010\u0011\u001a\u00020\u0003H\u0096\u0002J\b\u0010\b\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0005\"\u0004\b\u0010\u0010\u0007¨\u0006\u0015"}, d2 = {"kotlin/io/ByteStreamsKt$iterator$1", "Lkotlin/collections/ByteIterator;", "finished", "", "getFinished", "()Z", "setFinished", "(Z)V", "nextByte", "", "getNextByte", "()I", "setNextByte", "(I)V", "nextPrepared", "getNextPrepared", "setNextPrepared", "hasNext", "", "prepareNext", "", "kotlin-stdlib"}, k = 1, mv = {1, 5, 1})
    /* renamed from: h.h2.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static final class C0423a extends q {
        private int a = -1;
        private boolean b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f14870c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ BufferedInputStream f14871d;

        public C0423a(BufferedInputStream bufferedInputStream) {
            this.f14871d = bufferedInputStream;
        }

        private final void h() {
            if (this.b || this.f14870c) {
                return;
            }
            int read = this.f14871d.read();
            this.a = read;
            this.b = true;
            this.f14870c = read == -1;
        }

        public final boolean d() {
            return this.f14870c;
        }

        public final int f() {
            return this.a;
        }

        public final boolean g() {
            return this.b;
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            h();
            return !this.f14870c;
        }

        public final void i(boolean z) {
            this.f14870c = z;
        }

        public final void j(int i2) {
            this.a = i2;
        }

        @Override // h.a2.q
        public byte k() {
            h();
            if (!this.f14870c) {
                byte b = (byte) this.a;
                this.b = false;
                return b;
            }
            throw new NoSuchElementException("Input stream is over.");
        }

        public final void l(boolean z) {
            this.b = z;
        }
    }

    @h.g2.f
    private static final BufferedInputStream a(InputStream inputStream, int i2) {
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    @h.g2.f
    private static final BufferedOutputStream b(OutputStream outputStream, int i2) {
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    public static /* synthetic */ BufferedInputStream c(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return inputStream instanceof BufferedInputStream ? (BufferedInputStream) inputStream : new BufferedInputStream(inputStream, i2);
    }

    public static /* synthetic */ BufferedOutputStream d(OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return outputStream instanceof BufferedOutputStream ? (BufferedOutputStream) outputStream : new BufferedOutputStream(outputStream, i2);
    }

    @h.g2.f
    private static final BufferedReader e(InputStream inputStream, Charset charset) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    public static /* synthetic */ BufferedReader f(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
    }

    @h.g2.f
    private static final BufferedWriter g(OutputStream outputStream, Charset charset) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    public static /* synthetic */ BufferedWriter h(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192);
    }

    @h.g2.f
    private static final ByteArrayInputStream i(String str, Charset charset) {
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return new ByteArrayInputStream(str.getBytes(charset));
    }

    public static /* synthetic */ ByteArrayInputStream j(String str, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        return new ByteArrayInputStream(str.getBytes(charset));
    }

    public static final long k(@k.e.a.d InputStream inputStream, @k.e.a.d OutputStream outputStream, int i2) {
        byte[] bArr = new byte[i2];
        int read = inputStream.read(bArr);
        long j2 = 0;
        while (read >= 0) {
            outputStream.write(bArr, 0, read);
            j2 += read;
            read = inputStream.read(bArr);
        }
        return j2;
    }

    public static /* synthetic */ long l(InputStream inputStream, OutputStream outputStream, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 8192;
        }
        return k(inputStream, outputStream, i2);
    }

    @h.g2.f
    private static final ByteArrayInputStream m(byte[] bArr) {
        return new ByteArrayInputStream(bArr);
    }

    @h.g2.f
    private static final ByteArrayInputStream n(byte[] bArr, int i2, int i3) {
        return new ByteArrayInputStream(bArr, i2, i3);
    }

    @k.e.a.d
    public static final q o(@k.e.a.d BufferedInputStream bufferedInputStream) {
        return new C0423a(bufferedInputStream);
    }

    @s0(version = "1.3")
    @k.e.a.d
    public static final byte[] p(@k.e.a.d InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(8192, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        return byteArrayOutputStream.toByteArray();
    }

    @h.j(errorSince = "1.5", warningSince = "1.3")
    @h.i(message = "Use readBytes() overload without estimatedSize parameter", replaceWith = @q0(expression = "readBytes()", imports = {}))
    @k.e.a.d
    public static final byte[] q(@k.e.a.d InputStream inputStream, int i2) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(Math.max(i2, inputStream.available()));
        l(inputStream, byteArrayOutputStream, 0, 2, null);
        return byteArrayOutputStream.toByteArray();
    }

    public static /* synthetic */ byte[] r(InputStream inputStream, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i2 = 8192;
        }
        return q(inputStream, i2);
    }

    @h.g2.f
    private static final InputStreamReader s(InputStream inputStream, Charset charset) {
        return new InputStreamReader(inputStream, charset);
    }

    public static /* synthetic */ InputStreamReader t(InputStream inputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return new InputStreamReader(inputStream, charset);
    }

    @h.g2.f
    private static final OutputStreamWriter u(OutputStream outputStream, Charset charset) {
        return new OutputStreamWriter(outputStream, charset);
    }

    public static /* synthetic */ OutputStreamWriter v(OutputStream outputStream, Charset charset, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            charset = h.t2.d.a;
        }
        return new OutputStreamWriter(outputStream, charset);
    }
}
