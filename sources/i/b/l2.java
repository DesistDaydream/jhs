package i.b;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\t\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\t\u0010\nJ\u000f\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0003\u0010\u0004J\u0011\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0005¢\u0006\u0004\b\u0005\u0010\u0004R\u0016\u0010\b\u001a\u00020\u00008&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Li/b/l2;", "Lkotlinx/coroutines/CoroutineDispatcher;", "", "toString", "()Ljava/lang/String;", "A0", "z0", "()Li/b/l2;", "immediate", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class l2 extends CoroutineDispatcher {
    @x1
    @k.e.a.e
    public final String A0() {
        l2 l2Var;
        l2 e2 = b1.e();
        if (this == e2) {
            return "Dispatchers.Main";
        }
        try {
            l2Var = e2.z0();
        } catch (UnsupportedOperationException unused) {
            l2Var = null;
        }
        if (this == l2Var) {
            return "Dispatchers.Main.immediate";
        }
        return null;
    }

    @Override // kotlinx.coroutines.CoroutineDispatcher
    @k.e.a.d
    public String toString() {
        String A0 = A0();
        if (A0 != null) {
            return A0;
        }
        return r0.a(this) + '@' + r0.b(this);
    }

    @k.e.a.d
    public abstract l2 z0();
}
