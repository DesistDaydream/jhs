package e.j.a.b.j;

import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class l<TResult> {
    private final i0<TResult> a = new i0<>();

    public l() {
    }

    @NonNull
    public k<TResult> a() {
        return this.a;
    }

    public void b(@NonNull Exception exc) {
        this.a.y(exc);
    }

    public boolean c(@NonNull Exception exc) {
        return this.a.z(exc);
    }

    public boolean d(TResult tresult) {
        return this.a.A(tresult);
    }

    public void setResult(TResult tresult) {
        this.a.setResult(tresult);
    }

    public l(@NonNull a aVar) {
        aVar.b(new g0(this));
    }
}
