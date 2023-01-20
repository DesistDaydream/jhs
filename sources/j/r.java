package j;

import h.q0;
import java.io.IOException;
import kotlin.DeprecationLevel;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001f\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\f\u001a\u00020\u000bH\u0016¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u000f\u001a\u00020\u000eH\u0016¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0013\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0013\u001a\u00020\u00018\u0007@\u0006¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0017"}, d2 = {"Lj/r;", "Lj/m0;", "Lj/m;", "sink", "", "byteCount", "read", "(Lj/m;J)J", "Lj/o0;", "timeout", "()Lj/o0;", "Lh/t1;", "close", "()V", "", "toString", "()Ljava/lang/String;", "-deprecated_delegate", "()Lj/m0;", "delegate", "Lj/m0;", "<init>", "(Lj/m0;)V", "okio"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class r implements m0 {
    @k.e.a.d
    private final m0 delegate;

    public r(@k.e.a.d m0 m0Var) {
        this.delegate = m0Var;
    }

    @h.k2.g(name = "-deprecated_delegate")
    @h.i(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @q0(expression = "delegate", imports = {}))
    @k.e.a.d
    /* renamed from: -deprecated_delegate  reason: not valid java name */
    public final m0 m104deprecated_delegate() {
        return this.delegate;
    }

    @Override // j.m0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.delegate.close();
    }

    @h.k2.g(name = "delegate")
    @k.e.a.d
    public final m0 delegate() {
        return this.delegate;
    }

    @Override // j.m0
    public long read(@k.e.a.d m mVar, long j2) throws IOException {
        return this.delegate.read(mVar, j2);
    }

    @Override // j.m0
    @k.e.a.d
    public o0 timeout() {
        return this.delegate.timeout();
    }

    @k.e.a.d
    public String toString() {
        return getClass().getSimpleName() + '(' + this.delegate + ')';
    }
}
