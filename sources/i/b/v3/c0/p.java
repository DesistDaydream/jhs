package i.b.v3.c0;

import androidx.exifinterface.media.ExifInterface;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00028\u00000\u00022\u00060\u0003j\u0002`\u0004B\u001d\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0016\u001a\u00020\u0011¢\u0006\u0004\b\u001a\u0010\u001bJ \u0010\b\u001a\u00020\u00072\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H\u0016ø\u0001\u0000¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\f\u001a\n\u0018\u00010\nj\u0004\u0018\u0001`\u000bH\u0016¢\u0006\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00048V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0016\u001a\u00020\u00118\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u0018\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001c"}, d2 = {"Li/b/v3/c0/p;", ExifInterface.GPS_DIRECTION_TRUE, "Lh/e2/c;", "Lh/e2/k/a/c;", "Lkotlinx/coroutines/internal/CoroutineStackFrame;", "Lkotlin/Result;", "result", "Lh/t1;", "resumeWith", "(Ljava/lang/Object;)V", "Ljava/lang/StackTraceElement;", "Lkotlinx/coroutines/internal/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "Lkotlin/coroutines/CoroutineContext;", "b", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "context", am.av, "Lh/e2/c;", "uCont", "<init>", "(Lh/e2/c;Lkotlin/coroutines/CoroutineContext;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class p<T> implements h.e2.c<T>, h.e2.k.a.c {
    private final h.e2.c<T> a;
    @k.e.a.d
    private final CoroutineContext b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(@k.e.a.d h.e2.c<? super T> cVar, @k.e.a.d CoroutineContext coroutineContext) {
        this.a = cVar;
        this.b = coroutineContext;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public h.e2.k.a.c getCallerFrame() {
        h.e2.c<T> cVar = this.a;
        if (!(cVar instanceof h.e2.k.a.c)) {
            cVar = null;
        }
        return (h.e2.k.a.c) cVar;
    }

    @Override // h.e2.c
    @k.e.a.d
    public CoroutineContext getContext() {
        return this.b;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public StackTraceElement getStackTraceElement() {
        return null;
    }

    @Override // h.e2.c
    public void resumeWith(@k.e.a.d Object obj) {
        this.a.resumeWith(obj);
    }
}
