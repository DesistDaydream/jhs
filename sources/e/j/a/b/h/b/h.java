package e.j.a.b.h.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.signin.internal.zah;

/* loaded from: classes2.dex */
public final class h implements Parcelable.Creator<zah> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zah createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.g0(parcel, X);
            } else {
                resolveAccountRequest = (ResolveAccountRequest) SafeParcelReader.C(parcel, X, ResolveAccountRequest.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zah(i2, resolveAccountRequest);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zah[] newArray(int i2) {
        return new zah[i2];
    }
}
