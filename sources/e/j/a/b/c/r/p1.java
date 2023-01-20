package e.j.a.b.c.r;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.internal.zzr;

/* loaded from: classes2.dex */
public final class p1 implements Parcelable.Creator<zzr> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            if (SafeParcelReader.O(X) != 1) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i2 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zzr(i2);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzr[] newArray(int i2) {
        return new zzr[i2];
    }
}
