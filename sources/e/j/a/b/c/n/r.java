package e.j.a.b.c.n;

import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.p;

/* loaded from: classes2.dex */
public abstract class r<R extends p> implements q<R> {
    @Override // e.j.a.b.c.n.q
    @e.j.a.b.c.m.a
    public final void a(@NonNull R r) {
        Status status = r.getStatus();
        if (status.isSuccess()) {
            c(r);
            return;
        }
        b(status);
        if (r instanceof m) {
            try {
                ((m) r).release();
            } catch (RuntimeException e2) {
                String valueOf = String.valueOf(r);
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 18);
                sb.append("Unable to release ");
                sb.append(valueOf);
                Log.w("ResultCallbacks", sb.toString(), e2);
            }
        }
    }

    public abstract void b(@NonNull Status status);

    public abstract void c(@NonNull R r);
}
