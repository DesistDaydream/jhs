package e.j.a.b.d;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import e.j.a.b.d.a;

/* loaded from: classes2.dex */
public final class l implements a.InterfaceC0345a {
    private final /* synthetic */ FrameLayout a;
    private final /* synthetic */ LayoutInflater b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ ViewGroup f10492c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ Bundle f10493d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ a f10494e;

    public l(a aVar, FrameLayout frameLayout, LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f10494e = aVar;
        this.a = frameLayout;
        this.b = layoutInflater;
        this.f10492c = viewGroup;
        this.f10493d = bundle;
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final void a(e eVar) {
        e eVar2;
        this.a.removeAllViews();
        FrameLayout frameLayout = this.a;
        eVar2 = this.f10494e.a;
        frameLayout.addView(eVar2.c(this.b, this.f10492c, this.f10493d));
    }

    @Override // e.j.a.b.d.a.InterfaceC0345a
    public final int getState() {
        return 2;
    }
}
