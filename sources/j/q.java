package j;

import com.tencent.android.tpush.common.MessageKey;
import h.q0;
import java.io.IOException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0001¢\u0006\u0004\b\u0016\u0010\u0017J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000e\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000e\u0010\nJ\u000f\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0014\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0012\u0010\u0013R\u0019\u0010\u0014\u001a\u00020\u00018\u0007@\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u0018"}, d2 = {"Lj/q;", "Lj/k0;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "flush", "()V", "Lj/o0;", "timeout", "()Lj/o0;", "close", "", "toString", "()Ljava/lang/String;", "-deprecated_delegate", "()Lj/k0;", "delegate", "Lj/k0;", "<init>", "(Lj/k0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class q implements k0 {
    @k.e.a.d
    private final k0 delegate;

    public q(@k.e.a.d k0 k0Var) {
        this.delegate = k0Var;
    }

    @h.k2.g(name = "-deprecated_delegate")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "delegate", imports = {}))
    @k.e.a.d
    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final k0 m103deprecated_delegate() {
        return this.delegate;
    }

    @Override // j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @h.k2.g(name = "delegate")
    @k.e.a.d
    public final k0 delegate() {
        return this.delegate;
    }

    @Override // j.k0, java.io.Flushable
    public void flush() throws IOException {
        this.delegate.flush();
    }

    @Override // j.k0
    @k.e.a.d
    public o0 timeout() {
        return this.delegate.timeout();
    }

    @k.e.a.d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }

    @Override // j.k0
    public void write(@k.e.a.d m mVar, long j2) throws IOException {
        this.delegate.write(mVar, j2);
    }
}
