package e.j.a.b.c.n;

import android.app.Activity;
import android.content.IntentSender;
import android.util.Log;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.Status;
import e.j.a.b.c.n.p;
import e.j.a.b.c.r.a0;

/* loaded from: classes2.dex */
public abstract class n<R extends p> extends r<R> {
    private final Activity a;
    private final int b;

    public n(@NonNull Activity activity, int i2) {
        this.a = (Activity) a0.l(activity, "Activity must not be null");
        this.b = i2;
    }

    @Override // e.j.a.b.c.n.r
    @e.j.a.b.c.m.a
    public final void b(@NonNull Status status) {
        if (status.hasResolution()) {
            try {
                status.startResolutionForResult(this.a, this.b);
                return;
            } catch (IntentSender.SendIntentException e2) {
                Log.e("ResolvingResultCallback", "Failed to start resolution", e2);
                d(new Status(8));
                return;
            }
        }
        d(status);
    }

    @Override // e.j.a.b.c.n.r
    public abstract void c(@NonNull R r);

    public abstract void d(@NonNull Status status);
}
