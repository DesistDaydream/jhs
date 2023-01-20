package e.j.a.b.f.c;

import java.util.Objects;

/* loaded from: classes2.dex */
public final class q extends m {
    private final p b = new p();

    @Override // e.j.a.b.f.c.m
    public final void a(Throwable th, Throwable th2) {
        if (th2 != th) {
            Objects.requireNonNull(th2, "The suppressed exception cannot be null.");
            this.b.a(th, true).add(th2);
            return;
        }
        throw new IllegalArgumentException("Self suppression is not allowed.", th2);
    }
}
