package e.j.a.b.d;

import android.os.Bundle;
import e.j.a.b.d.a;

/* loaded from: classes2.dex */
public final class k implements a.InterfaceC0345a {
    private final /* synthetic */ Bundle a;
    private final /* synthetic */ a b;

    public k(a aVar, Bundle bundle) {
        this.b = aVar;
        this.a = bundle;
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final void a(e eVar) {
        e eVar2;
        eVar2 = this.b.a;
        eVar2.onCreate(this.a);
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final int getState() {
        return 1;
    }
}
