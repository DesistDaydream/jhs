package j;

import com.umeng.analytics.pro.am;
import java.io.IOException;
import java.io.InputStream;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0014\u001a\u00020\u0011\u0012\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0014\u001a\u00020\u00118\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lj/y;", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lh/t1;", "close", "()V", "Lj/o0;", "timeout", "()Lj/o0;", "", "toString", "()Ljava/lang/String;", "Ljava/io/InputStream;", am.av, "Ljava/io/InputStream;", "input", "b", "Lj/o0;", "<init>", "(Ljava/io/InputStream;Lj/o0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class y implements m0 {
    private final InputStream a;
    private final o0 b;

    public y(@k.e.a.d InputStream inputStream, @k.e.a.d o0 o0Var) {
        this.a = inputStream;
        this.b = o0Var;
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.a.close();
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 == 0) {
            return 0L;
        }
        if (i2 >= 0) {
            try {
                this.b.throwIfReached();
                i0 R0 = mVar.R0(1);
                int read = this.a.read(R0.a, R0.f15982c, (int) Math.min(j2, 8192 - R0.f15982c));
                if (read == -1) {
                    if (R0.b == R0.f15982c) {
                        mVar.a = R0.b();
                        j0.d(R0);
                        return -1L;
                    }
                    return -1L;
                }
                R0.f15982c += read;
                long j3 = read;
                mVar.K0(mVar.O0() + j3);
                return j3;
            } catch (AssertionError e2) {
                if (z.e(e2)) {
                    throw new IOException(e2);
                }
                throw e2;
            }
        }
        throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.b;
    }

    @k.e.a.d
    public String toString() {
        return "source(" + this.a + ')';
    }
}
