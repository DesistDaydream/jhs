package e.t.h.c;

import android.view.Window;
import e.t.u.y;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\f\u001a\u00020\u0004J\u0010\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0006\u0010\u000e\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/vector/compat/window/WindowCompat;", "Lcom/vector/compat/window/WindowOpt;", "()V", "navigationBarOpt", "Lcom/vector/compat/window/navigation/NavigationBarOpt;", "opt", "statusBarOpt", "Lcom/vector/compat/window/status/StatusBarOpt;", "enterFullScreen", "", "window", "Landroid/view/Window;", "navigationBar", "quitFullScreen", "statusBar", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements b {
    @k.e.a.d
    public static final a a = new a();
    @k.e.a.d
    private static final b b;
    @k.e.a.d

    /* renamed from: c  reason: collision with root package name */
    private static final e.t.h.c.e.c f14454c;
    @k.e.a.d

    /* renamed from: d  reason: collision with root package name */
    private static final e.t.h.c.f.a f14455d;

    static {
        b dVar;
        e.t.h.c.e.c bVar;
        e.t.h.c.f.a cVar;
        if (y.a(30)) {
            dVar = new c();
        } else {
            dVar = new d();
        }
        b = dVar;
        if (y.a(30)) {
            bVar = new e.t.h.c.e.a();
        } else {
            bVar = new e.t.h.c.e.b();
        }
        f14454c = bVar;
        if (y.a(30)) {
            cVar = new e.t.h.c.f.b();
        } else {
            cVar = new e.t.h.c.f.c();
        }
        f14455d = cVar;
    }

    private a() {
    }

    @Override // e.t.h.c.b
    public void a(@k.e.a.d Window window) {
        b.a(window);
    }

    @Override // e.t.h.c.b
    public void b(@k.e.a.d Window window) {
        b.b(window);
    }

    @k.e.a.d
    public final e.t.h.c.e.c c() {
        return f14454c;
    }

    @k.e.a.d
    public final e.t.h.c.f.a d() {
        return f14455d;
    }
}
