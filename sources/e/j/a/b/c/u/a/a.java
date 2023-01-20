package e.j.a.b.c.u.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;
import com.google.android.gms.common.server.converter.zaa;

/* loaded from: classes2.dex */
public final class a implements Parcelable.Creator<zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        StringToIntConverter stringToIntConverter = null;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O != 2) {
                SafeParcelReader.g0(parcel, X);
            } else {
                stringToIntConverter = (StringToIntConverter) SafeParcelReader.C(parcel, X, StringToIntConverter.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zaa(i2, stringToIntConverter);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zaa[] newArray(int i2) {
        return new zaa[i2];
    }
}
