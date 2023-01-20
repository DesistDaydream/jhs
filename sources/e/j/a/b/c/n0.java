package e.j.a.b.c;

import java.util.concurrent.Callable;

/* loaded from: classes2.dex */
public final class n0 extends l0 {

    /* renamed from: e  reason: collision with root package name */
    private final Callable<String> f10348e;

    private n0(Callable<String> callable) {
        super(false, null, null);
        this.f10348e = callable;
    }

    @Override // e.j.a.b.c.l0
    public final String a() {
        try {
            return this.f10348e.call();
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }
}
