package j;

import androidx.exifinterface.media.ExifInterface;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.EOFException;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010R\u001a\u00020O¢\u0006\u0004\bX\u0010YJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\r\u0010\u000eJ'\u0010\u0011\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0013H\u0016¢\u0006\u0004\b\u0015\u0010\u0016J'\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0019\u0010\u001aJ\u0017\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u001f\u0010 \u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b \u0010!J/\u0010\"\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020$H\u0016¢\u0006\u0004\b\t\u0010%J'\u0010\t\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020$2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\t\u0010&J\u0017\u0010\t\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020'H\u0016¢\u0006\u0004\b\t\u0010(J\u0017\u0010*\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020)H\u0016¢\u0006\u0004\b*\u0010+J\u001f\u0010,\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020)2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b,\u0010-J\u0017\u0010/\u001a\u00020\u00012\u0006\u0010.\u001a\u00020\u000fH\u0016¢\u0006\u0004\b/\u0010\u001dJ\u0017\u00101\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u000fH\u0016¢\u0006\u0004\b1\u0010\u001dJ\u0017\u00102\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u000fH\u0016¢\u0006\u0004\b2\u0010\u001dJ\u0017\u00104\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u000fH\u0016¢\u0006\u0004\b4\u0010\u001dJ\u0017\u00105\u001a\u00020\u00012\u0006\u00103\u001a\u00020\u000fH\u0016¢\u0006\u0004\b5\u0010\u001dJ\u0017\u00107\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b7\u00108J\u0017\u00109\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b9\u00108J\u0017\u0010:\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b:\u00108J\u0017\u0010;\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u0006H\u0016¢\u0006\u0004\b;\u00108J\u000f\u0010<\u001a\u00020\u0001H\u0016¢\u0006\u0004\b<\u0010=J\u000f\u00106\u001a\u00020\u0001H\u0016¢\u0006\u0004\b6\u0010=J\u000f\u0010?\u001a\u00020>H\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010A\u001a\u00020\bH\u0016¢\u0006\u0004\bA\u0010BJ\u000f\u0010D\u001a\u00020CH\u0016¢\u0006\u0004\bD\u0010EJ\u000f\u0010F\u001a\u00020\bH\u0016¢\u0006\u0004\bF\u0010BJ\u000f\u0010H\u001a\u00020GH\u0016¢\u0006\u0004\bH\u0010IJ\u000f\u0010J\u001a\u00020\u0013H\u0016¢\u0006\u0004\bJ\u0010KR\u001d\u0010N\u001a\u00020\u00028Ö\u0002@\u0016X\u0096\u0004¢\u0006\f\u0012\u0004\bM\u0010B\u001a\u0004\bL\u0010\u0004R\u0016\u0010R\u001a\u00020O8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u0016\u0010W\u001a\u00020C8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b.\u0010V¨\u0006Z"}, d2 = {"Lj/g0;", "Lj/n;", "Lj/m;", am.aH, "()Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "Lokio/ByteString;", "byteString", "r0", "(Lokio/ByteString;)Lj/n;", "", "offset", ExifInterface.LONGITUDE_WEST, "(Lokio/ByteString;II)Lj/n;", "", "string", "B", "(Ljava/lang/String;)Lj/n;", "beginIndex", "endIndex", "D", "(Ljava/lang/String;II)Lj/n;", "codePoint", IAdInterListener.AdReqParam.WIDTH, "(I)Lj/n;", "Ljava/nio/charset/Charset;", "charset", "k0", "(Ljava/lang/String;Ljava/nio/charset/Charset;)Lj/n;", "P", "(Ljava/lang/String;IILjava/nio/charset/Charset;)Lj/n;", "", "([B)Lj/n;", "([BII)Lj/n;", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "Lj/m0;", ExifInterface.LONGITUDE_EAST, "(Lj/m0;)J", "l0", "(Lj/m0;J)Lj/n;", "b", "writeByte", "s", "writeShort", "e0", "i", "writeInt", "a0", "v", "t0", "(J)Lj/n;", "x", ExifInterface.LATITUDE_SOUTH, "i0", am.aD, "()Lj/n;", "Ljava/io/OutputStream;", "v0", "()Ljava/io/OutputStream;", "flush", "()V", "", "isOpen", "()Z", "close", "Lj/o0;", "timeout", "()Lj/o0;", "toString", "()Ljava/lang/String;", "getBuffer", "getBuffer$annotations", "buffer", "Lj/k0;", "c", "Lj/k0;", "sink", am.av, "Lj/m;", "bufferField", "Z", "closed", "<init>", "(Lj/k0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g0 implements n {
    @h.k2.d
    @k.e.a.d
    public final m a = new m();
    @h.k2.d
    public boolean b;
    @h.k2.d
    @k.e.a.d

    /* renamed from: c */
    public final k0 f15977c;

    public g0(@k.e.a.d k0 k0Var) {
        this.f15977c = k0Var;
    }

    public static /* synthetic */ void j() {
    }

    @Override // j.n
    @k.e.a.d
    public n B(@k.e.a.d String str) {
        if (!this.b) {
            this.a.B(str);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n D(@k.e.a.d String str, int i2, int i3) {
        if (!this.b) {
            this.a.D(str, i2, i3);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    public long E(@k.e.a.d m0 m0Var) {
        long j2 = 0;
        while (true) {
            long read = m0Var.read(this.a, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            z();
        }
    }

    @Override // j.n
    @k.e.a.d
    public n P(@k.e.a.d String str, int i2, int i3, @k.e.a.d Charset charset) {
        if (!this.b) {
            this.a.P(str, i2, i3, charset);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n S(long j2) {
        if (!this.b) {
            this.a.S(j2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n W(@k.e.a.d ByteString byteString, int i2, int i3) {
        if (!this.b) {
            this.a.W(byteString, i2, i3);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n a0(int i2) {
        if (!this.b) {
            this.a.a0(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        Throwable th = null;
        try {
            if (this.a.O0() > 0) {
                k0 k0Var = this.f15977c;
                m mVar = this.a;
                k0Var.write(mVar, mVar.O0());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f15977c.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        this.b = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.n
    @k.e.a.d
    public n e0(int i2) {
        if (!this.b) {
            this.a.e0(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n, j.k0, java.io.Flushable
    public void flush() {
        if (!this.b) {
            if (this.a.O0() > 0) {
                k0 k0Var = this.f15977c;
                m mVar = this.a;
                k0Var.write(mVar, mVar.O0());
            }
            this.f15977c.flush();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public m getBuffer() {
        return this.a;
    }

    @Override // j.n
    @k.e.a.d
    public n i0(long j2) {
        if (!this.b) {
            this.a.i0(j2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.b;
    }

    @Override // j.n
    @k.e.a.d
    public n k0(@k.e.a.d String str, @k.e.a.d Charset charset) {
        if (!this.b) {
            this.a.k0(str, charset);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n l0(@k.e.a.d m0 m0Var, long j2) {
        while (j2 > 0) {
            long read = m0Var.read(this.a, j2);
            if (read != -1) {
                j2 -= read;
                z();
            } else {
                throw new EOFException();
            }
        }
        return this;
    }

    @Override // j.n
    @k.e.a.d
    public n r0(@k.e.a.d ByteString byteString) {
        if (!this.b) {
            this.a.r0(byteString);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n t0(long j2) {
        if (!this.b) {
            this.a.t0(j2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.k0
    @k.e.a.d
    public o0 timeout() {
        return this.f15977c.timeout();
    }

    @k.e.a.d
    public String toString() {
        return "buffer(" + this.f15977c + ')';
    }

    @Override // j.n
    @k.e.a.d
    public m u() {
        return this.a;
    }

    @Override // j.n
    @k.e.a.d
    public n v() {
        if (!this.b) {
            long O0 = this.a.O0();
            if (O0 > 0) {
                this.f15977c.write(this.a, O0);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public OutputStream v0() {
        return new a();
    }

    @Override // j.n
    @k.e.a.d
    public n w(int i2) {
        if (!this.b) {
            this.a.w(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // java.nio.channels.WritableByteChannel
    public int write(@k.e.a.d ByteBuffer byteBuffer) {
        if (!this.b) {
            int write = this.a.write(byteBuffer);
            z();
            return write;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n writeByte(int i2) {
        if (!this.b) {
            this.a.writeByte(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n writeInt(int i2) {
        if (!this.b) {
            this.a.writeInt(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n writeShort(int i2) {
        if (!this.b) {
            this.a.writeShort(i2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n x(long j2) {
        if (!this.b) {
            this.a.x(j2);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n z() {
        if (!this.b) {
            long o = this.a.o();
            if (o > 0) {
                this.f15977c.write(this.a, o);
            }
            return this;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J'\u0010\u0005\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u000bJ\u000f\u0010\f\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000e\u0010\rJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"j/g0$a", "Ljava/io/OutputStream;", "", "b", "Lh/t1;", "write", "(I)V", "", "data", "offset", "byteCount", "([BII)V", "flush", "()V", "close", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends OutputStream {
        public a() {
            g0.this = r1;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            g0.this.close();
        }

        @Override // java.io.OutputStream, java.io.Flushable
        public void flush() {
            g0 g0Var = g0.this;
            if (g0Var.b) {
                return;
            }
            g0Var.flush();
        }

        @k.e.a.d
        public String toString() {
            return g0.this + ".outputStream()";
        }

        @Override // java.io.OutputStream
        public void write(int i2) {
            g0 g0Var = g0.this;
            if (!g0Var.b) {
                g0Var.a.writeByte((byte) i2);
                g0.this.z();
                return;
            }
            throw new IOException("closed");
        }

        @Override // java.io.OutputStream
        public void write(@k.e.a.d byte[] bArr, int i2, int i3) {
            g0 g0Var = g0.this;
            if (!g0Var.b) {
                g0Var.a.write(bArr, i2, i3);
                g0.this.z();
                return;
            }
            throw new IOException("closed");
        }
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) {
        if (!this.b) {
            this.a.write(mVar, j2);
            z();
            return;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n write(@k.e.a.d byte[] bArr) {
        if (!this.b) {
            this.a.write(bArr);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.n
    @k.e.a.d
    public n write(@k.e.a.d byte[] bArr, int i2, int i3) {
        if (!this.b) {
            this.a.write(bArr, i2, i3);
            return z();
        }
        throw new IllegalStateException("closed".toString());
    }
}
