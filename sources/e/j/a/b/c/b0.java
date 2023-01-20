package e.j.a.b.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class b0 implements Parcelable.Creator<Feature> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        int i2 = 0;
        long j2 = -1;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 2) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                j2 = SafeParcelReader.c0(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new Feature(str, i2, j2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Feature[] newArray(int i2) {
        return new Feature[i2];
    }
}
