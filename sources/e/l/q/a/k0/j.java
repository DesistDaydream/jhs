package e.l.q.a.k0;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* loaded from: classes2.dex */
public final class j extends k {
    public j(@k.e.a.d View view) {
        super(view);
    }

    public static final void i(j jVar) {
        jVar.d().animate().setDuration(jVar.c()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    public static /* synthetic */ void j(j jVar) {
        i(jVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().alpha(0.0f).setDuration(c()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.a
            @Override // java.lang.Runnable
            public final void run() {
                j.j(j.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setAlpha(0.0f);
    }
}
