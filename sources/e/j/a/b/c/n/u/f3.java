package e.j.a.b.c.n.u;

import android.app.Dialog;

/* loaded from: classes2.dex */
public final class f3 extends r1 {
    private final /* synthetic */ Dialog a;
    private final /* synthetic */ e3 b;

    public f3(e3 e3Var, Dialog dialog) {
        this.b = e3Var;
        this.a = dialog;
    }

    @Override // e.j.a.b.c.n.u.r1
    public final void a() {
        this.b.b.p();
        if (this.a.isShowing()) {
            this.a.dismiss();
        }
    }
}
