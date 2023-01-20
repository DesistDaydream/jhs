package i.b.w3;

import com.umeng.analytics.pro.am;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H&¢\u0006\u0004\b\u0003\u0010\u0004J\u000f\u0010\u0006\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0000¢\u0006\u0004\b\n\u0010\u000bR\u001c\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f8&@&X¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Li/b/w3/b0;", "", "affected", "c", "(Ljava/lang/Object;)Ljava/lang/Object;", "", "toString", "()Ljava/lang/String;", "that", "", "b", "(Li/b/w3/b0;)Z", "Li/b/w3/d;", am.av, "()Li/b/w3/d;", "atomicOp", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public abstract class b0 {
    @k.e.a.e
    public abstract d<?> a();

    public final boolean b(@k.e.a.d b0 b0Var) {
        d<?> a;
        d<?> a2 = a();
        return (a2 == null || (a = b0Var.a()) == null || a2.g() >= a.g()) ? false : true;
    }

    @k.e.a.e
    public abstract Object c(@k.e.a.e Object obj);

    @k.e.a.d
    public String toString() {
        return i.b.r0.a(this) + '@' + i.b.r0.b(this);
    }
}
