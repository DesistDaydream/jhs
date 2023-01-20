package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_if122;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.c0;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class d {
    private final Set<c0> a = new LinkedHashSet();

    public void a(c0 c0Var) {
        synchronized (this) {
            this.a.remove(c0Var);
        }
    }

    public void b(c0 c0Var) {
        synchronized (this) {
            this.a.add(c0Var);
        }
    }

    public boolean c(c0 c0Var) {
        boolean contains;
        synchronized (this) {
            contains = this.a.contains(c0Var);
        }
        return contains;
    }
}
