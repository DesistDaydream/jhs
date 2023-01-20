package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public final class n extends k {

    /* renamed from: c */
    private float f14132c;

    /* renamed from: d */
    private float f14133d;

    public n(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(n nVar) {
        nVar.d().setTranslationY(-nVar.d().getMeasuredHeight());
        nVar.f14133d = -nVar.d().getTranslationY();
        nVar.d().animate().translationY(nVar.f14132c).alpha(1.0f).setDuration(nVar.c()).start();
    }

    public static /* synthetic */ void j(n nVar) {
        i(nVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().translationY(this.f14133d).alpha(0.0f).setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.e
            @Override // java.lang.Runnable
            public final void run() {
                n.j(n.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
