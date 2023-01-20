package e.j.a.b.c.u.a;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.StringToIntConverter;

/* loaded from: classes2.dex */
public final class c implements Parcelable.Creator<StringToIntConverter.zaa> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        String str = null;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i3 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new StringToIntConverter.zaa(i2, str, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ StringToIntConverter.zaa[] newArray(int i2) {
        return new StringToIntConverter.zaa[i2];
    }
}
