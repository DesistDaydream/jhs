package e.j.a.b.c.r;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class x0 implements Parcelable.Creator<ResolveAccountResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        IBinder iBinder = null;
        ConnectionResult connectionResult = null;
        int i2 = 0;
        boolean z = false;
        boolean z2 = false;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                iBinder = SafeParcelReader.Y(parcel, X);
            } else if (O == 3) {
                connectionResult = (ConnectionResult) SafeParcelReader.C(parcel, X, ConnectionResult.CREATOR);
            } else if (O == 4) {
                z = SafeParcelReader.P(parcel, X);
            } else if (O != 5) {
                SafeParcelReader.g0(parcel, X);
            } else {
                z2 = SafeParcelReader.P(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new ResolveAccountResponse(i2, iBinder, connectionResult, z, z2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountResponse[] newArray(int i2) {
        return new ResolveAccountResponse[i2];
    }
}
