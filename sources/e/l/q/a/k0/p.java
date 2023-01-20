package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public final class p extends k {

    /* renamed from: c */
    private float f14136c;

    /* renamed from: d */
    private float f14137d;

    public p(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(p pVar) {
        pVar.d().setTranslationX(pVar.d().getMeasuredWidth());
        pVar.f14137d = pVar.d().getTranslationX();
        pVar.d().setAlpha(1.0f);
        pVar.d().animate().translationX(pVar.f14136c).setDuration(pVar.c()).start();
    }

    public static /* synthetic */ void j(p pVar) {
        i(pVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().translationX(this.f14137d).setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.g
            @Override // java.lang.Runnable
            public final void run() {
                p.j(p.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
