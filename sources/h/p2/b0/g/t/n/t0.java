package h.p2.b0.g.t.n;

import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import kotlin.reflect.jvm.internal.impl.types.Variance;

/* loaded from: classes3.dex */
public abstract class t0 implements s0 {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof s0) {
            s0 s0Var = (s0) obj;
            return b() == s0Var.b() && c() == s0Var.c() && getType().equals(s0Var.getType());
        }
        return false;
    }

    public int hashCode() {
        int hashCode = c().hashCode();
        if (y0.v(getType())) {
            return (hashCode * 31) + 19;
        }
        return (hashCode * 31) + (b() ? 17 : getType().hashCode());
    }

    public String toString() {
        if (b()) {
            return "*";
        }
        if (c() == Variance.INVARIANT) {
            return getType().toString();
        }
        return c() + ExpandableTextView.N + getType();
    }
}
