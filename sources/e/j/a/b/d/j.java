package e.j.a.b.d;

import android.app.Activity;
import android.os.Bundle;
import e.j.a.b.d.a;

/* loaded from: classes2.dex */
public final class j implements a.InterfaceC0345a {
    private final /* synthetic */ Activity a;
    private final /* synthetic */ Bundle b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Bundle f10490c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ a f10491d;

    public j(a aVar, Activity activity, Bundle bundle, Bundle bundle2) {
        this.f10491d = aVar;
        this.a = activity;
        this.b = bundle;
        this.f10490c = bundle2;
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final void a(e eVar) {
        e eVar2;
        eVar2 = this.f10491d.a;
        eVar2.b(this.a, this.b, this.f10490c);
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final int getState() {
        return 0;
    }
}
