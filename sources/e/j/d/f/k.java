package e.j.d.f;

import android.os.Bundle;

/* loaded from: classes2.dex */
public final class k extends i<Bundle> {
    public k(int i2, int i3, Bundle bundle) {
        super(i2, 1, bundle);
    }

    @Override // e.j.d.f.i
    public final void a(Bundle bundle) {
        Bundle bundle2 = bundle.getBundle("data");
        if (bundle2 == null) {
            bundle2 = Bundle.EMPTY;
        }
        c(bundle2);
    }

    @Override // e.j.d.f.i
    public final boolean d() {
        return false;
    }
}
