package i.b.w3;

import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.analytics.pro.am;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;

@h.p0
@Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0081\b\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0013\u0012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u0014\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0003HÂ\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0007\u001a\u00020\u00002\f\b\u0002\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u0003HÆ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\n\u001a\u00020\tHÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u001a\u0010\u0012\u001a\u00020\u00112\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fHÖ\u0003¢\u0006\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00038\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0014¨\u0006\u0017"}, d2 = {"Li/b/w3/o0;", "Lkotlin/coroutines/CoroutineContext$b;", "Li/b/w3/n0;", "Ljava/lang/ThreadLocal;", am.av, "()Ljava/lang/ThreadLocal;", "threadLocal", "b", "(Ljava/lang/ThreadLocal;)Li/b/w3/o0;", "", "toString", "()Ljava/lang/String;", "", TTDownloadField.TT_HASHCODE, "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/ThreadLocal;", "<init>", "(Ljava/lang/ThreadLocal;)V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class o0 implements CoroutineContext.b<n0<?>> {
    private final ThreadLocal<?> a;

    public o0(@k.e.a.d ThreadLocal<?> threadLocal) {
        this.a = threadLocal;
    }

    private final ThreadLocal<?> a() {
        return this.a;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ o0 c(o0 o0Var, ThreadLocal threadLocal, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            threadLocal = o0Var.a;
        }
        return o0Var.b(threadLocal);
    }

    @k.e.a.d
    public final o0 b(@k.e.a.d ThreadLocal<?> threadLocal) {
        return new o0(threadLocal);
    }

    public boolean equals(@k.e.a.e Object obj) {
        if (this != obj) {
            return (obj instanceof o0) && h.k2.v.f0.g(this.a, ((o0) obj).a);
        }
        return true;
    }

    public int hashCode() {
        ThreadLocal<?> threadLocal = this.a;
        if (threadLocal != null) {
            return threadLocal.hashCode();
        }
        return 0;
    }

    @k.e.a.d
    public String toString() {
        return "ThreadLocalKey(threadLocal=" + this.a + ")";
    }
}
