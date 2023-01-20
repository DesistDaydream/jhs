package e.j.a.b.c.n.u;

import e.j.a.b.c.n.u.c;

/* loaded from: classes2.dex */
public final class j1 implements c.a {
    private final /* synthetic */ g a;

    public j1(g gVar) {
        this.a = gVar;
    }

    @Override // e.j.a.b.c.n.u.c.a
    public final void onBackgroundStateChanged(boolean z) {
        this.a.f10240m.sendMessage(this.a.f10240m.obtainMessage(1, Boolean.valueOf(z)));
    }
}
