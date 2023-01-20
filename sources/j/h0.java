package j;

import androidx.exifinterface.media.ExifInterface;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import kotlin.Metadata;
import okio.ByteString;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010s\u001a\u00020p¢\u0006\u0004\bz\u0010{J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0013\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010 \u001a\u00020\u001fH\u0016¢\u0006\u0004\b \u0010!J\u0017\u0010\"\u001a\u00020\u001f2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\"\u0010#J\u0017\u0010\b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001fH\u0016¢\u0006\u0004\b\b\u0010$J\u0017\u0010%\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u001fH\u0016¢\u0006\u0004\b%\u0010&J'\u0010\b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001cH\u0016¢\u0006\u0004\b\b\u0010(J\u0017\u0010\b\u001a\u00020\u001c2\u0006\u0010\u0005\u001a\u00020)H\u0016¢\u0006\u0004\b\b\u0010*J\u001f\u0010+\u001a\u00020\r2\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b+\u0010,J\u0017\u0010.\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020-H\u0016¢\u0006\u0004\b.\u0010/J\u000f\u00101\u001a\u000200H\u0016¢\u0006\u0004\b1\u00102J\u0017\u00103\u001a\u0002002\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b3\u00104J\u0017\u00107\u001a\u0002002\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u0002002\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u00106\u001a\u000205H\u0016¢\u0006\u0004\b9\u0010:J\u0011\u0010;\u001a\u0004\u0018\u000100H\u0016¢\u0006\u0004\b;\u00102J\u000f\u0010<\u001a\u000200H\u0016¢\u0006\u0004\b<\u00102J\u0017\u0010>\u001a\u0002002\u0006\u0010=\u001a\u00020\u0006H\u0016¢\u0006\u0004\b>\u00104J\u000f\u0010?\u001a\u00020\u001cH\u0016¢\u0006\u0004\b?\u0010@J\u000f\u0010B\u001a\u00020AH\u0016¢\u0006\u0004\bB\u0010CJ\u000f\u0010D\u001a\u00020AH\u0016¢\u0006\u0004\bD\u0010CJ\u000f\u0010E\u001a\u00020\u001cH\u0016¢\u0006\u0004\bE\u0010@J\u000f\u0010F\u001a\u00020\u001cH\u0016¢\u0006\u0004\bF\u0010@J\u000f\u0010G\u001a\u00020\u0006H\u0016¢\u0006\u0004\bG\u0010HJ\u000f\u0010I\u001a\u00020\u0006H\u0016¢\u0006\u0004\bI\u0010HJ\u000f\u0010J\u001a\u00020\u0006H\u0016¢\u0006\u0004\bJ\u0010HJ\u000f\u0010K\u001a\u00020\u0006H\u0016¢\u0006\u0004\bK\u0010HJ\u0017\u0010L\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\bL\u0010\u000fJ\u0017\u0010N\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u0012H\u0016¢\u0006\u0004\bN\u0010OJ\u001f\u0010Q\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bQ\u0010RJ'\u0010T\u001a\u00020\u00062\u0006\u0010M\u001a\u00020\u00122\u0006\u0010P\u001a\u00020\u00062\u0006\u0010S\u001a\u00020\u0006H\u0016¢\u0006\u0004\bT\u0010UJ\u0017\u0010W\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0015H\u0016¢\u0006\u0004\bW\u0010XJ\u001f\u0010Y\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\bY\u0010ZJ\u0017\u0010\\\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\\\u0010XJ\u001f\u0010]\u001a\u00020\u00062\u0006\u0010[\u001a\u00020\u00152\u0006\u0010P\u001a\u00020\u0006H\u0016¢\u0006\u0004\b]\u0010ZJ\u001f\u0010^\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u0015H\u0016¢\u0006\u0004\b^\u0010_J/\u0010a\u001a\u00020\n2\u0006\u0010'\u001a\u00020\u00062\u0006\u0010V\u001a\u00020\u00152\u0006\u0010`\u001a\u00020\u001c2\u0006\u0010\u0007\u001a\u00020\u001cH\u0016¢\u0006\u0004\ba\u0010bJ\u000f\u0010c\u001a\u00020\u0001H\u0016¢\u0006\u0004\bc\u0010dJ\u000f\u0010f\u001a\u00020eH\u0016¢\u0006\u0004\bf\u0010gJ\u000f\u0010h\u001a\u00020\nH\u0016¢\u0006\u0004\bh\u0010\fJ\u000f\u0010i\u001a\u00020\rH\u0016¢\u0006\u0004\bi\u0010jJ\u000f\u0010l\u001a\u00020kH\u0016¢\u0006\u0004\bl\u0010mJ\u000f\u0010n\u001a\u000200H\u0016¢\u0006\u0004\bn\u00102R\u0016\u0010o\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\bM\u0010 R\u0016\u0010s\u001a\u00020p8\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001d\u0010v\u001a\u00020\u00028Ö\u0002@\u0016X\u0096\u0004¢\u0006\f\u0012\u0004\bu\u0010j\u001a\u0004\bt\u0010\u0004R\u0016\u0010y\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0006\n\u0004\bw\u0010x¨\u0006|"}, d2 = {"Lj/h0;", "Lj/o;", "Lj/m;", am.aH, "()Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "", "b0", "()Z", "Lh/t1;", "R", "(J)V", "G", "(J)Z", "", "readByte", "()B", "Lokio/ByteString;", "j0", "()Lokio/ByteString;", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(J)Lokio/ByteString;", "Lj/c0;", "options", "", "y0", "(Lj/c0;)I", "", "Z", "()[B", "L", "(J)[B", "([B)I", "readFully", "([B)V", "offset", "([BII)I", "Ljava/nio/ByteBuffer;", "(Ljava/nio/ByteBuffer;)I", "h", "(Lj/m;J)V", "Lj/k0;", "s0", "(Lj/k0;)J", "", "p0", "()Ljava/lang/String;", "U", "(J)Ljava/lang/String;", "Ljava/nio/charset/Charset;", "charset", "g0", "(Ljava/nio/charset/Charset;)Ljava/lang/String;", "q0", "(JLjava/nio/charset/Charset;)Ljava/lang/String;", "y", ExpandableTextView.P, "limit", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "h0", "()I", "", "readShort", "()S", "N", "readInt", "n0", "readLong", "()J", "O", "d0", "w0", "skip", "b", ExifInterface.GPS_DIRECTION_TRUE, "(B)J", "fromIndex", "g", "(BJ)J", "toIndex", "m", "(BJJ)J", "bytes", "f", "(Lokio/ByteString;)J", com.huawei.hms.push.e.a, "(Lokio/ByteString;J)J", "targetBytes", am.ax, "Q", "C", "(JLokio/ByteString;)Z", "bytesOffset", "K", "(JLokio/ByteString;II)Z", "peek", "()Lj/o;", "Ljava/io/InputStream;", "inputStream", "()Ljava/io/InputStream;", "isOpen", "close", "()V", "Lj/o0;", "timeout", "()Lj/o0;", "toString", "closed", "Lj/m0;", "c", "Lj/m0;", MessageKey.MSG_SOURCE, "getBuffer", "getBuffer$annotations", "buffer", am.av, "Lj/m;", "bufferField", "<init>", "(Lj/m0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class h0 implements o {
    @h.k2.d
    @k.e.a.d
    public final m a = new m();
    @h.k2.d
    public boolean b;
    @h.k2.d
    @k.e.a.d

    /* renamed from: c */
    public final m0 f15978c;

    public h0(@k.e.a.d m0 m0Var) {
        this.f15978c = m0Var;
    }

    public static /* synthetic */ void j() {
    }

    @Override // j.o
    @k.e.a.d
    public String A(long j2) {
        if (j2 >= 0) {
            long j3 = j2 == Long.MAX_VALUE ? Long.MAX_VALUE : j2 + 1;
            byte b = (byte) 10;
            long m2 = m(b, 0L, j3);
            if (m2 != -1) {
                return j.q0.a.b0(this.a, m2);
            }
            if (j3 < Long.MAX_VALUE && G(j3) && this.a.m0(j3 - 1) == ((byte) 13) && G(1 + j3) && this.a.m0(j3) == b) {
                return j.q0.a.b0(this.a, j3);
            }
            m mVar = new m();
            m mVar2 = this.a;
            mVar2.H(mVar, 0L, Math.min(32, mVar2.O0()));
            throw new EOFException("\\n not found: limit=" + Math.min(this.a.O0(), j2) + " content=" + mVar.j0().hex() + "…");
        }
        throw new IllegalArgumentException(("limit < 0: " + j2).toString());
    }

    @Override // j.o
    public boolean C(long j2, @k.e.a.d ByteString byteString) {
        return K(j2, byteString, 0, byteString.size());
    }

    @Override // j.o
    public boolean G(long j2) {
        if (j2 >= 0) {
            if (!this.b) {
                while (this.a.O0() < j2) {
                    if (this.f15978c.read(this.a, 8192) == -1) {
                        return false;
                    }
                }
                return true;
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.o
    @k.e.a.d
    public String I() {
        return A(Long.MAX_VALUE);
    }

    @Override // j.o
    public boolean K(long j2, @k.e.a.d ByteString byteString, int i2, int i3) {
        int i4;
        if (!this.b) {
            if (j2 >= 0 && i2 >= 0 && i3 >= 0 && byteString.size() - i2 >= i3) {
                while (i4 < i3) {
                    long j3 = i4 + j2;
                    i4 = (G(1 + j3) && this.a.m0(j3) == byteString.getByte(i2 + i4)) ? i4 + 1 : 0;
                }
                return true;
            }
            return false;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.o
    @k.e.a.d
    public byte[] L(long j2) {
        R(j2);
        return this.a.L(j2);
    }

    @Override // j.o
    public short N() {
        R(2L);
        return this.a.N();
    }

    @Override // j.o
    public long O() {
        R(8L);
        return this.a.O();
    }

    @Override // j.o
    public long Q(@k.e.a.d ByteString byteString, long j2) {
        if (!(!this.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long Q = this.a.Q(byteString, j2);
            if (Q != -1) {
                return Q;
            }
            long O0 = this.a.O0();
            if (this.f15978c.read(this.a, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, O0);
        }
    }

    @Override // j.o
    public void R(long j2) {
        if (!G(j2)) {
            throw new EOFException();
        }
    }

    @Override // j.o
    public long T(byte b) {
        return m(b, 0L, Long.MAX_VALUE);
    }

    @Override // j.o
    @k.e.a.d
    public String U(long j2) {
        R(j2);
        return this.a.U(j2);
    }

    @Override // j.o
    @k.e.a.d
    public ByteString V(long j2) {
        R(j2);
        return this.a.V(j2);
    }

    @Override // j.o
    @k.e.a.d
    public byte[] Z() {
        this.a.E(this.f15978c);
        return this.a.Z();
    }

    @Override // j.o
    public boolean b0() {
        if (!this.b) {
            return this.a.b0() && this.f15978c.read(this.a, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.b) {
            return;
        }
        this.b = true;
        this.f15978c.close();
        this.a.l();
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x002c, code lost:
        if (r9 == 0) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0053, code lost:
        throw new java.lang.NumberFormatException("Expected leading [0-9] or '-' character but was 0x" + java.lang.Integer.toString(r8, h.t2.b.a(h.t2.b.a(16))));
     */
    @Override // j.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long d0() {
        /*
            r10 = this;
            r0 = 1
            r10.R(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.G(r6)
            if (r8 == 0) goto L54
            j.m r8 = r10.a
            byte r8 = r8.m0(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2c
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r9 == 0) goto L2f
            goto L54
        L2f:
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Expected leading [0-9] or '-' character but was 0x"
            r1.append(r2)
            r2 = 16
            int r2 = h.t2.b.a(r2)
            int r2 = h.t2.b.a(r2)
            java.lang.String r2 = java.lang.Integer.toString(r8, r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L54:
            j.m r0 = r10.a
            long r0 = r0.d0()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: j.h0.d0():long");
    }

    @Override // j.o
    public long e(@k.e.a.d ByteString byteString, long j2) {
        if (!(!this.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long e2 = this.a.e(byteString, j2);
            if (e2 != -1) {
                return e2;
            }
            long O0 = this.a.O0();
            if (this.f15978c.read(this.a, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (O0 - byteString.size()) + 1);
        }
    }

    @Override // j.o
    public long f(@k.e.a.d ByteString byteString) {
        return e(byteString, 0L);
    }

    @Override // j.o
    public long g(byte b, long j2) {
        return m(b, j2, Long.MAX_VALUE);
    }

    @Override // j.o
    @k.e.a.d
    public String g0(@k.e.a.d Charset charset) {
        this.a.E(this.f15978c);
        return this.a.g0(charset);
    }

    @Override // j.o
    @k.e.a.d
    public m getBuffer() {
        return this.a;
    }

    @Override // j.o
    public void h(@k.e.a.d m mVar, long j2) {
        try {
            R(j2);
            this.a.h(mVar, j2);
        } catch (EOFException e2) {
            mVar.E(this.a);
            throw e2;
        }
    }

    @Override // j.o
    public int h0() {
        R(1L);
        byte m0 = this.a.m0(0L);
        if ((m0 & 224) == 192) {
            R(2L);
        } else if ((m0 & 240) == 224) {
            R(3L);
        } else if ((m0 & 248) == 240) {
            R(4L);
        }
        return this.a.h0();
    }

    @Override // j.o
    @k.e.a.d
    public InputStream inputStream() {
        return new a();
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.b;
    }

    @Override // j.o
    @k.e.a.d
    public ByteString j0() {
        this.a.E(this.f15978c);
        return this.a.j0();
    }

    @Override // j.o
    public long m(byte b, long j2, long j3) {
        boolean z = true;
        if (!this.b) {
            if (!((0 > j2 || j3 < j2) ? false : false)) {
                throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
            }
            while (j2 < j3) {
                long m2 = this.a.m(b, j2, j3);
                if (m2 != -1) {
                    return m2;
                }
                long O0 = this.a.O0();
                if (O0 >= j3 || this.f15978c.read(this.a, 8192) == -1) {
                    return -1L;
                }
                j2 = Math.max(j2, O0);
            }
            return -1L;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // j.o
    public int n0() {
        R(4L);
        return this.a.n0();
    }

    @Override // j.o
    public long p(@k.e.a.d ByteString byteString) {
        return Q(byteString, 0L);
    }

    @Override // j.o
    @k.e.a.d
    public String p0() {
        this.a.E(this.f15978c);
        return this.a.p0();
    }

    @Override // j.o
    @k.e.a.d
    public o peek() {
        return z.d(new e0(this));
    }

    @Override // j.o
    @k.e.a.d
    public String q0(long j2, @k.e.a.d Charset charset) {
        R(j2);
        return this.a.q0(j2, charset);
    }

    @Override // j.o
    public int read(@k.e.a.d byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    @Override // j.o
    public byte readByte() {
        R(1L);
        return this.a.readByte();
    }

    @Override // j.o
    public void readFully(@k.e.a.d byte[] bArr) {
        try {
            R(bArr.length);
            this.a.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.a.O0() > 0) {
                m mVar = this.a;
                int read = mVar.read(bArr, i2, (int) mVar.O0());
                if (read == -1) {
                    throw new AssertionError();
                }
                i2 += read;
            }
            throw e2;
        }
    }

    @Override // j.o
    public int readInt() {
        R(4L);
        return this.a.readInt();
    }

    @Override // j.o
    public long readLong() {
        R(8L);
        return this.a.readLong();
    }

    @Override // j.o
    public short readShort() {
        R(2L);
        return this.a.readShort();
    }

    @Override // j.o
    public long s0(@k.e.a.d k0 k0Var) {
        long j2 = 0;
        while (this.f15978c.read(this.a, 8192) != -1) {
            long o = this.a.o();
            if (o > 0) {
                j2 += o;
                k0Var.write(this.a, o);
            }
        }
        if (this.a.O0() > 0) {
            long O0 = j2 + this.a.O0();
            m mVar = this.a;
            k0Var.write(mVar, mVar.O0());
            return O0;
        }
        return j2;
    }

    @Override // j.o
    public void skip(long j2) {
        if (!(!this.b)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.a.O0() == 0 && this.f15978c.read(this.a, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.a.O0());
            this.a.skip(min);
            j2 -= min;
        }
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.f15978c.timeout();
    }

    @k.e.a.d
    public String toString() {
        return "buffer(" + this.f15978c + ')';
    }

    @Override // j.o
    @k.e.a.d
    public m u() {
        return this.a;
    }

    @Override // j.o
    public long w0() {
        byte m0;
        R(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!G(i3)) {
                break;
            }
            m0 = this.a.m0(i2);
            if ((m0 < ((byte) 48) || m0 > ((byte) 57)) && ((m0 < ((byte) 97) || m0 > ((byte) 102)) && (m0 < ((byte) 65) || m0 > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            throw new NumberFormatException("Expected leading [0-9a-fA-F] character but was 0x" + Integer.toString(m0, h.t2.b.a(h.t2.b.a(16))));
        }
        return this.a.w0();
    }

    @Override // j.o
    @k.e.a.e
    public String y() {
        long T = T((byte) 10);
        if (T == -1) {
            if (this.a.O0() != 0) {
                return U(this.a.O0());
            }
            return null;
        }
        return j.q0.a.b0(this.a, T);
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0023, code lost:
        return -1;
     */
    @Override // j.o
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int y0(@k.e.a.d j.c0 r9) {
        /*
            r8 = this;
            boolean r0 = r8.b
            r1 = 1
            r0 = r0 ^ r1
            if (r0 == 0) goto L38
        L6:
            j.m r0 = r8.a
            int r0 = j.q0.a.d0(r0, r9, r1)
            r2 = -2
            r3 = -1
            if (r0 == r2) goto L25
            if (r0 == r3) goto L23
            okio.ByteString[] r9 = r9.g()
            r9 = r9[r0]
            int r9 = r9.size()
            j.m r1 = r8.a
            long r2 = (long) r9
            r1.skip(r2)
            goto L37
        L23:
            r0 = -1
            goto L37
        L25:
            j.m0 r0 = r8.f15978c
            j.m r2 = r8.a
            r4 = 8192(0x2000, float:1.14794E-41)
            long r4 = (long) r4
            long r4 = r0.read(r2, r4)
            r6 = -1
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 != 0) goto L6
            goto L23
        L37:
            return r0
        L38:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "closed"
            java.lang.String r0 = r0.toString()
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: j.h0.y0(j.c0):int");
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) {
        if (j2 >= 0) {
            if (true ^ this.b) {
                if (this.a.O0() == 0 && this.f15978c.read(this.a, 8192) == -1) {
                    return -1L;
                }
                return this.a.read(mVar, Math.min(j2, this.a.O0()));
            }
            throw new IllegalStateException("closed".toString());
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\n\u0018\u00002\u00020\u0001J\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J'\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\tJ\u000f\u0010\n\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0004J\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"j/h0$a", "Ljava/io/InputStream;", "", "read", "()I", "", "data", "offset", "byteCount", "([BII)I", "available", "Lh/t1;", "close", "()V", "", "toString", "()Ljava/lang/String;", "okio"}, k = 1, mv = {1, 4, 0})
    /* loaded from: classes4.dex */
    public static final class a extends InputStream {
        public a() {
            h0.this = r1;
        }

        @Override // java.io.InputStream
        public int available() {
            h0 h0Var = h0.this;
            if (!h0Var.b) {
                return (int) Math.min(h0Var.a.O0(), Integer.MAX_VALUE);
            }
            throw new IOException("closed");
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            h0.this.close();
        }

        @Override // java.io.InputStream
        public int read() {
            h0 h0Var = h0.this;
            if (!h0Var.b) {
                if (h0Var.a.O0() == 0) {
                    h0 h0Var2 = h0.this;
                    if (h0Var2.f15978c.read(h0Var2.a, 8192) == -1) {
                        return -1;
                    }
                }
                return h0.this.a.readByte() & 255;
            }
            throw new IOException("closed");
        }

        @k.e.a.d
        public String toString() {
            return h0.this + ".inputStream()";
        }

        @Override // java.io.InputStream
        public int read(@k.e.a.d byte[] bArr, int i2, int i3) {
            if (!h0.this.b) {
                j.e(bArr.length, i2, i3);
                if (h0.this.a.O0() == 0) {
                    h0 h0Var = h0.this;
                    if (h0Var.f15978c.read(h0Var.a, 8192) == -1) {
                        return -1;
                    }
                }
                return h0.this.a.read(bArr, i2, i3);
            }
            throw new IOException("closed");
        }
    }

    @Override // j.o
    public int read(@k.e.a.d byte[] bArr, int i2, int i3) {
        long j2 = i3;
        j.e(bArr.length, i2, j2);
        if (this.a.O0() == 0 && this.f15978c.read(this.a, 8192) == -1) {
            return -1;
        }
        return this.a.read(bArr, i2, (int) Math.min(j2, this.a.O0()));
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@k.e.a.d ByteBuffer byteBuffer) {
        if (this.a.O0() == 0 && this.f15978c.read(this.a, 8192) == -1) {
            return -1;
        }
        return this.a.read(byteBuffer);
    }
}
