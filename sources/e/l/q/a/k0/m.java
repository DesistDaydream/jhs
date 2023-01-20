package e.l.q.a.k0;

import android.view.View;
import android.view.animation.OvershootInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;

/* loaded from: classes2.dex */
public final class m extends k {

    /* renamed from: c */
    private float f14131c;

    public m(@k.e.a.d View view) {
        super(view);
        this.f14131c = 0.75f;
    }

    public static final void i(m mVar) {
        mVar.d().setPivotX(mVar.d().getMeasuredWidth() / 2);
        mVar.d().setPivotY(mVar.d().getMeasuredHeight() / 2);
        mVar.d().animate().scaleX(1.0f).scaleY(1.0f).alpha(1.0f).setDuration(mVar.c()).setInterpolator(new OvershootInterpolator(1.0f)).start();
    }

    public static /* synthetic */ void k(m mVar) {
        i(mVar);
    }

    @Override // e.l.q.a.k0.k
    public void a() {
        d().animate().scaleX(this.f14131c).scaleY(this.f14131c).alpha(0.0f).setDuration(c()).setInterpolator(new FastOutSlowInInterpolator()).start();
    }

    @Override // e.l.q.a.k0.k
    public void b() {
        d().post(new Runnable() { // from class: e.l.q.a.k0.d
            @Override // java.lang.Runnable
            public final void run() {
                m.k(m.this);
            }
        });
    }

    @Override // e.l.q.a.k0.k
    public void e() {
        d().setScaleX(this.f14131c);
        d().setScaleY(this.f14131c);
        d().setAlpha(0.0f);
    }

    public final float j() {
        return this.f14131c;
    }

    public final void l(float f2) {
        this.f14131c = f2;
    }
}
