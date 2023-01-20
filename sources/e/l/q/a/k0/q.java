package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public final class q extends k {

    /* renamed from: c */
    private float f14138c;

    /* renamed from: d */
    private float f14139d;

    public q(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(q qVar) {
        qVar.d().setTranslationY(qVar.d().getMeasuredHeight());
        qVar.f14139d = qVar.d().getTranslationY();
        qVar.d().animate().translationY(qVar.f14138c).alpha(1.0f).setDuration(qVar.c()).start();
    }

    public static /* synthetic */ void j(q qVar) {
        i(qVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().translationY(this.f14139d).alpha(0.0f).setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.h
            @Override // java.lang.Runnable
            public final void run() {
                q.j(q.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
