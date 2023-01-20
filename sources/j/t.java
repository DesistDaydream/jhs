package j;

import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import h.q0;
import java.io.IOException;
import java.util.zip.CRC32;
import java.util.zip.Deflater;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0001¢\u0006\u0004\b)\u0010*J\u000f\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001f\u0010\t\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\t\u0010\nJ\u001f\u0010\f\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\nJ\u000f\u0010\r\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0004J\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0004J\u000f\u0010\u0013\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00158\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010$\u001a\u00020!8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0019\u0010(\u001a\u00020\u00128G@\u0006¢\u0006\f\n\u0004\b%\u0010&\u001a\u0004\b'\u0010\u0014¨\u0006+"}, d2 = {"Lj/t;", "Lj/k0;", "Lh/t1;", "n", "()V", "Lj/m;", "buffer", "", "byteCount", NotifyType.LIGHTS, "(Lj/m;J)V", MessageKey.MSG_SOURCE, "write", "flush", "Lj/o0;", "timeout", "()Lj/o0;", "close", "Ljava/util/zip/Deflater;", "j", "()Ljava/util/zip/Deflater;", "Lj/g0;", am.av, "Lj/g0;", "sink", "", e.j.a.b.c.f.f10128d, "Z", "closed", "Lj/p;", "c", "Lj/p;", "deflaterSink", "Ljava/util/zip/CRC32;", com.huawei.hms.push.e.a, "Ljava/util/zip/CRC32;", "crc", "b", "Ljava/util/zip/Deflater;", "k", "deflater", "<init>", "(Lj/k0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class t implements k0 {
    private final g0 a;
    @k.e.a.d
    private final Deflater b;

    /* renamed from: c  reason: collision with root package name */
    private final p f16006c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f16007d;

    /* renamed from: e  reason: collision with root package name */
    private final CRC32 f16008e;

    public t(@k.e.a.d k0 k0Var) {
        g0 g0Var = new g0(k0Var);
        this.a = g0Var;
        Deflater deflater = new Deflater(-1, true);
        this.b = deflater;
        this.f16006c = new p((n) g0Var, deflater);
        this.f16008e = new CRC32();
        m mVar = g0Var.a;
        mVar.writeShort(8075);
        mVar.writeByte(8);
        mVar.writeByte(0);
        mVar.writeInt(0);
        mVar.writeByte(0);
        mVar.writeByte(0);
    }

    private final void l(m mVar, long j2) {
        i0 i0Var = mVar.a;
        while (j2 > 0) {
            int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
            this.f16008e.update(i0Var.a, i0Var.b, min);
            j2 -= min;
            i0Var = i0Var.f15985f;
        }
    }

    private final void n() {
        this.a.a0((int) this.f16008e.getValue());
        this.a.a0((int) this.b.getBytesRead());
    }

    @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f16007d) {
            return;
        }
        Throwable th = null;
        try {
            this.f16006c.j();
            n();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.b.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.a.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.f16007d = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.k0, java.io.Flushable
    public void flush() throws IOException {
        this.f16006c.flush();
    }

    @h.k2.g(name = "-deprecated_deflater")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "deflater", imports = {}))
    @k.e.a.d
    public final Deflater j() {
        return this.b;
    }

    @h.k2.g(name = "deflater")
    @k.e.a.d
    public final Deflater k() {
        return this.b;
    }

    @Override // j.k0
    @k.e.a.d
    public o0 timeout() {
        return this.a.timeout();
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) throws IOException {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        } else if (i2 == 0) {
        } else {
            l(mVar, j2);
            this.f16006c.write(mVar, j2);
        }
    }
}
