package j;

import com.moor.imkf.YKFConstants;
import com.tencent.android.tpush.common.MessageKey;
import com.umeng.analytics.pro.am;
import java.io.OutputStream;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0017\u001a\u00020\u0014\u0012\u0006\u0010\r\u001a\u00020\f¢\u0006\u0004\b\u0018\u0010\u0019J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nJ\u000f\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lj/d0;", "Lj/k0;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "flush", "()V", "close", "Lj/o0;", "timeout", "()Lj/o0;", "", "toString", "()Ljava/lang/String;", "b", "Lj/o0;", "Ljava/io/OutputStream;", am.av, "Ljava/io/OutputStream;", YKFConstants.INVESTIGATE_TYPE_OUT, "<init>", "(Ljava/io/OutputStream;Lj/o0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class d0 implements k0 {
    private final OutputStream a;
    private final o0 b;

    public d0(@k.e.a.d OutputStream outputStream, @k.e.a.d o0 o0Var) {
        this.a = outputStream;
        this.b = o0Var;
    }

    @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // j.k0, java.io.Flushable
    public void flush() {
        this.a.flush();
    }

    @Override // j.k0
    @k.e.a.d
    public o0 timeout() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        return "sink(" + this.a + ')';
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) {
        j.e(mVar.O0(), 0L, j2);
        while (j2 > 0) {
            this.b.throwIfReached();
            i0 i0Var = mVar.a;
            int min = (int) Math.min(j2, i0Var.f15982c - i0Var.b);
            this.a.write(i0Var.a, i0Var.b, min);
            i0Var.b += min;
            long j3 = min;
            j2 -= j3;
            mVar.K0(mVar.O0() - j3);
            if (i0Var.b == i0Var.f15982c) {
                mVar.a = i0Var.b();
                j0.d(i0Var);
            }
        }
    }
}
