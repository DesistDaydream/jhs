package e.j.a.b.c.u.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.SafeParcelResponse;
import com.google.android.gms.common.server.response.zak;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<SafeParcelResponse> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        Parcel parcel2 = null;
        zak zakVar = null;
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                parcel2 = SafeParcelReader.y(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                zakVar = (zak) SafeParcelReader.C(parcel, X, zak.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new SafeParcelResponse(i2, parcel2, zakVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SafeParcelResponse[] newArray(int i2) {
        return new SafeParcelResponse[i2];
    }
}
