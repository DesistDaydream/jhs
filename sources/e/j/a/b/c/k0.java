package e.j.a.b.c;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.zzk;

/* loaded from: classes2.dex */
public final class k0 implements Parcelable.Creator<zzk> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        boolean z = false;
        String str = null;
        IBinder iBinder = null;
        boolean z2 = false;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 2) {
                iBinder = SafeParcelReader.Y(parcel, X);
            } else if (O == 3) {
                z = SafeParcelReader.P(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.g0(parcel, X);
            } else {
                z2 = SafeParcelReader.P(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zzk(str, iBinder, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzk[] newArray(int i2) {
        return new zzk[i2];
    }
}
