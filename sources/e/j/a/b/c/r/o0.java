package e.j.a.b.c.r;

import android.content.Intent;

/* loaded from: classes2.dex */
public final class o0 extends i {
    private final /* synthetic */ Intent a;
    private final /* synthetic */ e.j.a.b.c.n.u.k b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ int f10439c;

    public o0(Intent intent, e.j.a.b.c.n.u.k kVar, int i2) {
        this.a = intent;
        this.b = kVar;
        this.f10439c = i2;
    }

    @Override // e.j.a.b.c.r.i
    public final void d() {
        Intent intent = this.a;
        if (intent != null) {
            this.b.startActivityForResult(intent, this.f10439c);
        }
    }
}
