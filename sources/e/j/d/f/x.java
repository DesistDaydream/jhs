package e.j.d.f;

import android.os.Binder;
import android.os.Process;
import android.util.Log;

/* loaded from: classes2.dex */
public final class x extends Binder {
    private final z a;

    public x(z zVar) {
        this.a = zVar;
    }

    public final void a(b0 b0Var) {
        if (Binder.getCallingUid() == Process.myUid()) {
            if (Log.isLoggable("FirebaseInstanceId", 3)) {
                Log.d("FirebaseInstanceId", "service received new intent via bind strategy");
            }
            this.a.a(b0Var.a).f(f0.b(), new e.j.a.b.j.e(b0Var) { // from class: e.j.d.f.a0
                private final b0 a;

                {
                    this.a = b0Var;
                }

                @Override // e.j.a.b.j.e
                public final void onComplete(e.j.a.b.j.k kVar) {
                    this.a.a();
                }
            });
            return;
        }
        throw new SecurityException("Binding only allowed within app");
    }
}
