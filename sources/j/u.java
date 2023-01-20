package j;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.EOFException;
import java.io.IOException;
import java.util.Arrays;
import java.util.zip.CRC32;
import java.util.zip.Inflater;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010-\u001a\u00020\u0001¢\u0006\u0004\b.\u0010/J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0005\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0005\u0010\u0004J'\u0010\u000b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000b\u0010\fJ'\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u001f\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\bH\u0016¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u001a\u0010\u0004R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010!\u001a\u00020\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010 R\u0016\u0010%\u001a\u00020\"8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010)\u001a\u00020&8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b+\u0010,¨\u00060"}, d2 = {"Lj/u;", "Lj/m0;", "Lh/t1;", "j", "()V", "k", "Lj/m;", "buffer", "", "offset", "byteCount", NotifyType.LIGHTS, "(Lj/m;JJ)V", "", "name", "", "expected", "actual", am.av, "(Ljava/lang/String;II)V", "sink", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "close", "Ljava/util/zip/Inflater;", "c", "Ljava/util/zip/Inflater;", "inflater", "", "B", "section", "Lj/x;", e.j.a.b.c.f.f10128d, "Lj/x;", "inflaterSource", "Ljava/util/zip/CRC32;", com.huawei.hms.push.e.a, "Ljava/util/zip/CRC32;", "crc", "Lj/h0;", "b", "Lj/h0;", MessageKey.MSG_SOURCE, "<init>", "(Lj/m0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class u implements m0 {
    private byte a;
    private final h0 b;

    /* renamed from: c  reason: collision with root package name */
    private final Inflater f16009c;

    /* renamed from: d  reason: collision with root package name */
    private final x f16010d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f16011e;

    public u(@k.e.a.d m0 m0Var) {
        h0 h0Var = new h0(m0Var);
        this.b = h0Var;
        Inflater inflater = new Inflater(true);
        this.f16009c = inflater;
        this.f16010d = new x((o) h0Var, inflater);
        this.f16011e = new CRC32();
    }

    private final void a(String str, int i2, int i3) {
        if (i3 != i2) {
            throw new IOException(String.format("%s: actual 0x%08x != expected 0x%08x", Arrays.copyOf(new Object[]{str, Integer.valueOf(i3), Integer.valueOf(i2)}, 3)));
        }
    }

    private final void j() throws IOException {
        this.b.R(10L);
        byte m0 = this.b.a.m0(3L);
        boolean z = ((m0 >> 1) & 1) == 1;
        if (z) {
            l(this.b.a, 0L, 10L);
        }
        a("ID1ID2", 8075, this.b.readShort());
        this.b.skip(8L);
        if (((m0 >> 2) & 1) == 1) {
            this.b.R(2L);
            if (z) {
                l(this.b.a, 0L, 2L);
            }
            long N = this.b.a.N();
            this.b.R(N);
            if (z) {
                l(this.b.a, 0L, N);
            }
            this.b.skip(N);
        }
        if (((m0 >> 3) & 1) == 1) {
            long T = this.b.T((byte) 0);
            if (T != -1) {
                if (z) {
                    l(this.b.a, 0L, T + 1);
                }
                this.b.skip(T + 1);
            } else {
                throw new EOFException();
            }
        }
        if (((m0 >> 4) & 1) == 1) {
            long T2 = this.b.T((byte) 0);
            if (T2 != -1) {
                if (z) {
                    l(this.b.a, 0L, T2 + 1);
                }
                this.b.skip(T2 + 1);
            } else {
                throw new EOFException();
            }
        }
        if (z) {
            a("FHCRC", this.b.N(), (short) this.f16011e.getValue());
            this.f16011e.reset();
        }
    }

    private final void k() throws IOException {
        a("CRC", this.b.n0(), (int) this.f16011e.getValue());
        a("ISIZE", this.b.n0(), (int) this.f16009c.getBytesWritten());
    }

    private final void l(m mVar, long j2, long j3) {
        int i2;
        i0 i0Var = mVar.a;
        while (true) {
            int i3 = i0Var.f15982c;
            int i4 = i0Var.b;
            if (j2 < i3 - i4) {
                break;
            }
            j2 -= i3 - i4;
            i0Var = i0Var.f15985f;
        }
        while (j3 > 0) {
            int min = (int) Math.min(i0Var.f15982c - i2, j3);
            this.f16011e.update(i0Var.a, (int) (i0Var.b + j2), min);
            j3 -= min;
            i0Var = i0Var.f15985f;
            j2 = 0;
        }
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f16010d.close();
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) throws IOException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (i2 == 0) {
            return 0L;
        } else {
            if (this.a == 0) {
                j();
                this.a = (byte) 1;
            }
            if (this.a == 1) {
                long O0 = mVar.O0();
                long read = this.f16010d.read(mVar, j2);
                if (read != -1) {
                    l(mVar, O0, read);
                    return read;
                }
                this.a = (byte) 2;
            }
            if (this.a == 2) {
                k();
                this.a = (byte) 3;
                if (!this.b.b0()) {
                    throw new IOException("gzip finished without exhausting source");
                }
            }
            return -1L;
        }
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.b.timeout();
    }
}
