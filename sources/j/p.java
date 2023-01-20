package j;

import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.util.zip.Deflater;
import kotlin.Metadata;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0000\u0012\u0006\u0010\u001c\u001a\u00020\u0019\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010\"B\u0019\b\u0016\u0012\u0006\u0010\u001c\u001a\u00020\u0001\u0012\u0006\u0010 \u001a\u00020\u001d¢\u0006\u0004\b!\u0010#J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001f\u0010\u000b\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\r\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\u0004H\u0000¢\u0006\u0004\b\u000f\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0012\u001a\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0015\u0010\u0016R\u0016\u0010\u0018\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0005\u0010\u0017R\u0016\u0010\u001c\u001a\u00020\u00198\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010 \u001a\u00020\u001d8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001f¨\u0006$"}, d2 = {"Lj/p;", "Lj/k0;", "", "syncFlush", "Lh/t1;", am.av, "(Z)V", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "write", "(Lj/m;J)V", "flush", "()V", "j", "close", "Lj/o0;", "timeout", "()Lj/o0;", "", "toString", "()Ljava/lang/String;", "Z", "closed", "Lj/n;", "b", "Lj/n;", "sink", "Ljava/util/zip/Deflater;", "c", "Ljava/util/zip/Deflater;", "deflater", "<init>", "(Lj/n;Ljava/util/zip/Deflater;)V", "(Lj/k0;Ljava/util/zip/Deflater;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class p implements k0 {
    private boolean a;
    private final n b;

    /* renamed from: c  reason: collision with root package name */
    private final Deflater f15997c;

    public p(@k.e.a.d n nVar, @k.e.a.d Deflater deflater) {
        this.b = nVar;
        this.f15997c = deflater;
    }

    @IgnoreJRERequirement
    private final void a(boolean z) {
        i0 R0;
        int deflate;
        m buffer = this.b.getBuffer();
        while (true) {
            R0 = buffer.R0(1);
            if (z) {
                Deflater deflater = this.f15997c;
                byte[] bArr = R0.a;
                int i2 = R0.f15982c;
                deflate = deflater.deflate(bArr, i2, 8192 - i2, 2);
            } else {
                Deflater deflater2 = this.f15997c;
                byte[] bArr2 = R0.a;
                int i3 = R0.f15982c;
                deflate = deflater2.deflate(bArr2, i3, 8192 - i3);
            }
            if (deflate > 0) {
                R0.f15982c += deflate;
                buffer.K0(buffer.O0() + deflate);
                this.b.z();
            } else if (this.f15997c.needsInput()) {
                break;
            }
        }
        if (R0.b == R0.f15982c) {
            buffer.a = R0.b();
            j0.d(R0);
        }
    }

    @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.a) {
            return;
        }
        Throwable th = null;
        try {
            j();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.f15997c.end();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        try {
            this.b.close();
        } catch (Throwable th4) {
            if (th == null) {
                th = th4;
            }
        }
        this.a = true;
        if (th != null) {
            throw th;
        }
    }

    @Override // j.k0, java.io.Flushable
    public void flush() throws IOException {
        a(true);
        this.b.flush();
    }

    public final void j() {
        this.f15997c.finish();
        a(false);
    }

    @Override // j.k0
    @k.e.a.d
    public o0 timeout() {
        return this.b.timeout();
    }

    @k.e.a.d
    public String toString() {
        return "DeflaterSink(" + this.b + ')';
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) throws IOException {
        j.e(mVar.O0(), 0L, j2);
        while (j2 > 0) {
            i0 i0Var = mVar.a;
            int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
            this.f15997c.setInput(i0Var.a, i0Var.b, min);
            a(false);
            long j3 = min;
            mVar.K0(mVar.O0() - j3);
            int i2 = i0Var.b + min;
            i0Var.b = i2;
            if (i2 == i0Var.f15982c) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            }
            j2 -= j3;
        }
    }

    public p(@k.e.a.d k0 k0Var, @k.e.a.d Deflater deflater) {
        this(z.c(k0Var), deflater);
    }
}
