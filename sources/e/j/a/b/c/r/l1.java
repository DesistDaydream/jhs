package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.IInterface;

/* loaded from: classes2.dex */
public abstract class l1 extends e.j.a.b.f.b.b implements k1 {
    public static k1 b(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
        if (queryLocalInterface instanceof k1) {
            return (k1) queryLocalInterface;
        }
        return new m1(iBinder);
    }
}
