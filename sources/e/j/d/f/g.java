package e.j.d.f;

import android.os.Bundle;
import com.google.firebase.iid.zzad;

/* loaded from: classes2.dex */
public final class g extends i<Void> {
    public g(int i2, int i3, Bundle bundle) {
        super(i2, 2, bundle);
    }

    @Override // e.j.d.f.i
    public final void a(Bundle bundle) {
        if (bundle.getBoolean("ack", false)) {
            c(null);
        } else {
            b(new zzad(4, "Invalid response to one way request"));
        }
    }

    @Override // e.j.d.f.i
    public final boolean d() {
        return true;
    }
}
