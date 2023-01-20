package androidx.lifecycle;

import i.b.g2;
import i.b.n0;
import java.io.Closeable;
import k.e.a.d;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0007\u001a\u00020\u00068\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Landroidx/lifecycle/CloseableCoroutineScope;", "Ljava/io/Closeable;", "Li/b/n0;", "Lh/t1;", "close", "()V", "Lkotlin/coroutines/CoroutineContext;", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "context", "<init>", "(Lkotlin/coroutines/CoroutineContext;)V", "lifecycle-viewmodel-ktx_release"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes.dex */
public final class CloseableCoroutineScope implements Closeable, n0 {
    @d
    private final CoroutineContext coroutineContext;

    public CloseableCoroutineScope(@d CoroutineContext coroutineContext) {
        this.coroutineContext = coroutineContext;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        g2.j(getCoroutineContext(), null, 1, null);
    }

    @Override // i.b.n0
    @d
    public CoroutineContext getCoroutineContext() {
        return this.coroutineContext;
    }
}
