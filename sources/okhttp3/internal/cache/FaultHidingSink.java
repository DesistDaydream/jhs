package okhttp3.internal.cache;

import com.tencent.android.tpush.common.MessageKey;
import h.k2.u.l;
import h.t1;
import j.k0;
import j.m;
import j.q;
import java.io.IOException;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0010\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0016\u001a\u00020\u0015\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f¢\u0006\u0004\b\u0017\u0010\u0018J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u000b\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u000b\u0010\nR%\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00060\f8\u0006@\u0006¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0019"}, d2 = {"Lokhttp3/internal/cache/FaultHidingSink;", "Lj/q;", "Lj/m;", MessageKey.MSG_SOURCE, "", "byteCount", "Lh/t1;", "write", "(Lj/m;J)V", "flush", "()V", "close", "Lkotlin/Function1;", "Ljava/io/IOException;", "onException", "Lh/k2/u/l;", "getOnException", "()Lh/k2/u/l;", "", "hasErrors", "Z", "Lj/k0;", "delegate", "<init>", "(Lj/k0;Lh/k2/u/l;)V", "okhttp"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public class FaultHidingSink extends q {
    private boolean hasErrors;
    @d
    private final l<IOException, t1> onException;

    /* JADX WARN: Multi-variable type inference failed */
    public FaultHidingSink(@d k0 k0Var, @d l<? super IOException, t1> lVar) {
        super(k0Var);
        this.onException = lVar;
    }

    @Override // j.q, j.k0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.close();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @Override // j.q, j.k0, java.io.Flushable
    public void flush() {
        if (this.hasErrors) {
            return;
        }
        try {
            super.flush();
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }

    @d
    public final l<IOException, t1> getOnException() {
        return this.onException;
    }

    @Override // j.q, j.k0
    public void write(@d m mVar, long j2) {
        if (this.hasErrors) {
            mVar.skip(j2);
            return;
        }
        try {
            super.write(mVar, j2);
        } catch (IOException e2) {
            this.hasErrors = true;
            this.onException.invoke(e2);
        }
    }
}
