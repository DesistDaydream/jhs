package e.j.a.b.c.r;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zzb;

/* loaded from: classes2.dex */
public final class a1 implements Parcelable.Creator<zzb> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        Bundle bundle = null;
        Feature[] featureArr = null;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                bundle = SafeParcelReader.g(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.g0(parcel, X);
            } else {
                featureArr = (Feature[]) SafeParcelReader.K(parcel, X, Feature.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zzb(bundle, featureArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzb[] newArray(int i2) {
        return new zzb[i2];
    }
}
