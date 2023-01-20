package i.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u001d\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0004\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0004\u0010\u0005R\u0016\u0010\t\u001a\u00020\u00068\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u001c\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\f¨\u0006\u0010"}, d2 = {"Li/b/w2;", "Ljava/lang/Runnable;", "Lkotlinx/coroutines/Runnable;", "Lh/t1;", "run", "()V", "Lkotlinx/coroutines/CoroutineDispatcher;", am.av, "Lkotlinx/coroutines/CoroutineDispatcher;", "dispatcher", "Li/b/n;", "b", "Li/b/n;", "continuation", "<init>", "(Lkotlinx/coroutines/CoroutineDispatcher;Li/b/n;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class w2 implements Runnable {
    private final CoroutineDispatcher a;
    private final n<h.t1> b;

    /* JADX WARN: Multi-variable type inference failed */
    public w2(@k.e.a.d CoroutineDispatcher coroutineDispatcher, @k.e.a.d n<? super h.t1> nVar) {
        this.a = coroutineDispatcher;
        this.b = nVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.E(this.a, h.t1.a);
    }
}
