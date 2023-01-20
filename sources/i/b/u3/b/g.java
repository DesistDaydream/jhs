package i.b.u3.b;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\u0007\u001a\u00020\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0007\u001a\u00020\u00028\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u001e\u0010\f\u001a\u0004\u0018\u00010\u00018\u0016@\u0016X\u0096\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Li/b/u3/b/g;", "Lh/e2/k/a/c;", "Ljava/lang/StackTraceElement;", "getStackTraceElement", "()Ljava/lang/StackTraceElement;", "b", "Ljava/lang/StackTraceElement;", "stackTraceElement", am.av, "Lh/e2/k/a/c;", "getCallerFrame", "()Lh/e2/k/a/c;", "callerFrame", "<init>", "(Lh/e2/k/a/c;Ljava/lang/StackTraceElement;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class g implements h.e2.k.a.c {
    @k.e.a.e
    private final h.e2.k.a.c a;
    private final StackTraceElement b;

    public g(@k.e.a.e h.e2.k.a.c cVar, @k.e.a.d StackTraceElement stackTraceElement) {
        this.a = cVar;
        this.b = stackTraceElement;
    }

    @Override // h.e2.k.a.c
    @k.e.a.e
    public h.e2.k.a.c getCallerFrame() {
        return this.a;
    }

    @Override // h.e2.k.a.c
    @k.e.a.d
    public StackTraceElement getStackTraceElement() {
        return this.b;
    }
}
