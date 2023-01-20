package i.b;

import java.util.Objects;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\u0007\u001a\u00020\u0003H\u0016¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u000b\u001a\u00020\u00008V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000f\u001a\u00020\f8V@\u0016X\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0012"}, d2 = {"Li/b/m2;", "Li/b/w3/q;", "Li/b/v1;", "", "state", "m0", "(Ljava/lang/String;)Ljava/lang/String;", "toString", "()Ljava/lang/String;", "c", "()Li/b/m2;", "list", "", "j", "()Z", "isActive", "<init>", "()V", "kotlinx-coroutines-core"}, k = 1, mv = {1, 4, 0})
/* loaded from: classes4.dex */
public final class m2 extends i.b.w3.q implements v1 {
    @Override // i.b.v1
    @k.e.a.d
    public m2 c() {
        return this;
    }

    @Override // i.b.v1
    public boolean j() {
        return true;
    }

    @k.e.a.d
    public final String m0(@k.e.a.d String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        Object U = U();
        Objects.requireNonNull(U, "null cannot be cast to non-null type kotlinx.coroutines.internal.Node /* = kotlinx.coroutines.internal.LockFreeLinkedListNode */");
        boolean z = true;
        for (i.b.w3.s sVar = (i.b.w3.s) U; !h.k2.v.f0.g(sVar, this); sVar = sVar.V()) {
            if (sVar instanceof h2) {
                h2 h2Var = (h2) sVar;
                if (z) {
                    z = false;
                } else {
                    sb.append(", ");
                }
                sb.append(h2Var);
            }
        }
        sb.append("]");
        return sb.toString();
    }

    @Override // i.b.w3.s
    @k.e.a.d
    public String toString() {
        return q0.d() ? m0("Active") : super.toString();
    }
}
