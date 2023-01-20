package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public final class r extends k {

    /* renamed from: c */
    private float f14140c;

    /* renamed from: d */
    private float f14141d;

    public r(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(r rVar) {
        rVar.d().setTranslationY(rVar.d().getMeasuredHeight());
        rVar.f14141d = rVar.d().getTranslationY();
        rVar.d().setAlpha(1.0f);
        rVar.d().animate().translationY(rVar.f14140c).setDuration(rVar.c()).start();
    }

    public static /* synthetic */ void j(r rVar) {
        i(rVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().translationY(this.f14141d).setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.i
            @Override // java.lang.Runnable
            public final void run() {
                r.j(r.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
