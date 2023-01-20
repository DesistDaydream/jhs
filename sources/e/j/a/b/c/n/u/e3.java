package e.j.a.b.c.n.u;

import android.app.Dialog;
import androidx.annotation.MainThread;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiActivity;

/* loaded from: classes2.dex */
public final class e3 implements Runnable {
    private final d3 a;
    public final /* synthetic */ c3 b;

    public e3(c3 c3Var, d3 d3Var) {
        this.b = c3Var;
        this.a = d3Var;
    }

    @Override // java.lang.Runnable
    @MainThread
    public final void run() {
        if (this.b.b) {
            ConnectionResult a = this.a.a();
            if (a.hasResolution()) {
                c3 c3Var = this.b;
                c3Var.a.startActivityForResult(GoogleApiActivity.b(c3Var.getActivity(), a.getResolution(), this.a.b(), false), 1);
            } else if (this.b.f10209e.o(a.getErrorCode())) {
                c3 c3Var2 = this.b;
                c3Var2.f10209e.I(c3Var2.getActivity(), this.b.a, a.getErrorCode(), 2, this.b);
            } else if (a.getErrorCode() == 18) {
                Dialog C = e.j.a.b.c.e.C(this.b.getActivity(), this.b);
                c3 c3Var3 = this.b;
                c3Var3.f10209e.E(c3Var3.getActivity().getApplicationContext(), new f3(this, C));
            } else {
                this.b.m(a, this.a.b());
            }
        }
    }
}
