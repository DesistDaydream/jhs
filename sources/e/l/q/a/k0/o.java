package e.l.q.a.k0;

import android.view.View;

/* loaded from: classes2.dex */
public final class o extends k {

    /* renamed from: c */
    private float f14134c;

    /* renamed from: d */
    private float f14135d;

    public o(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(o oVar) {
        oVar.d().setTranslationX(oVar.d().getMeasuredWidth());
        oVar.f14135d = oVar.d().getTranslationX();
        oVar.d().animate().translationX(oVar.f14134c).alpha(1.0f).setDuration(oVar.c()).start();
    }

    public static /* synthetic */ void j(o oVar) {
        i(oVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().translationX(this.f14135d).alpha(0.0f).setDuration(c()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.f
            @Override // java.lang.Runnable
            public final void run() {
                o.j(o.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
