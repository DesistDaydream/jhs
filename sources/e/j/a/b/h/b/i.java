package e.j.a.b.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zaj;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<zaj> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        ConnectionResult connectionResult = null;
        ResolveAccountResponse resolveAccountResponse = null;
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, X, ConnectionResult.CREATOR);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                resolveAccountResponse = (ResolveAccountResponse) SafeParcelReader.C(parcel, X, ResolveAccountResponse.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zaj(i2, connectionResult, resolveAccountResponse);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaj[] newArray(int i2) {
        return new zaj[i2];
    }
}
