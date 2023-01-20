package e.j.a.b.c.u.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.converter.zaa;
import com.google.android.gms.common.server.response.FastJsonResponse;

/* loaded from: classes2.dex */
public final class i implements Parcelable.Creator<FastJsonResponse.Field> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        String str2 = null;
        zaa zaaVar = null;
        int i2 = 0;
        int i3 = 0;
        boolean z = false;
        int i4 = 0;
        boolean z2 = false;
        int i5 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel, X);
                    break;
                case 2:
                    i3 = SafeParcelReader.Z(parcel, X);
                    break;
                case 3:
                    z = SafeParcelReader.P(parcel, X);
                    break;
                case 4:
                    i4 = SafeParcelReader.Z(parcel, X);
                    break;
                case 5:
                    z2 = SafeParcelReader.P(parcel, X);
                    break;
                case 6:
                    str = SafeParcelReader.G(parcel, X);
                    break;
                case 7:
                    i5 = SafeParcelReader.Z(parcel, X);
                    break;
                case 8:
                    str2 = SafeParcelReader.G(parcel, X);
                    break;
                case 9:
                    zaaVar = (zaa) SafeParcelReader.C(parcel, X, zaa.CREATOR);
                    break;
                default:
                    SafeParcelReader.g0(parcel, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new FastJsonResponse.Field(i2, i3, z, i4, z2, str, i5, str2, zaaVar);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ FastJsonResponse.Field[] newArray(int i2) {
        return new FastJsonResponse.Field[i2];
    }
}
