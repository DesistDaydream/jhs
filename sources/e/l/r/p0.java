package e.l.r;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;

/* loaded from: classes2.dex */
public final class p0 {
    @k.e.a.d

    /* renamed from: d */
    public static final a f14296d = new a(null);
    @k.e.a.d
    private final View a;
    private int b;
    @k.e.a.e

    /* renamed from: c */
    private b f14297c;

    /* loaded from: classes2.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(h.k2.v.u uVar) {
            this();
        }

        public final void a(@k.e.a.d Activity activity, @k.e.a.d b bVar) {
            new p0(activity).e(bVar);
        }
    }

    /* loaded from: classes2.dex */
    public interface b {
        void a(int i2);

        void b(int i2);
    }

    public p0(@k.e.a.d Activity activity) {
        View decorView = activity.getWindow().getDecorView();
        this.a = decorView;
        decorView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() { // from class: e.l.r.o
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public final void onGlobalLayout() {
                p0.d(p0.this);
            }
        });
    }

    public static final void a(p0 p0Var) {
        Rect rect = new Rect();
        p0Var.a.getWindowVisibleDisplayFrame(rect);
        int height = rect.height();
        if (p0Var.c() == 0) {
            p0Var.f(height);
        } else if (p0Var.c() == height) {
        } else {
            if (p0Var.c() - height > 200) {
                b bVar = p0Var.f14297c;
                if (bVar != null) {
                    bVar.b(p0Var.c() - height);
                }
                p0Var.f(height);
            } else if (height - p0Var.c() > 200) {
                b bVar2 = p0Var.f14297c;
                if (bVar2 != null) {
                    bVar2.a(height - p0Var.c());
                }
                p0Var.f(height);
            }
        }
    }

    public static /* synthetic */ void d(p0 p0Var) {
        a(p0Var);
    }

    public final void e(b bVar) {
        this.f14297c = bVar;
    }

    public final int c() {
        return this.b;
    }

    public final void f(int i2) {
        this.b = i2;
    }
}
