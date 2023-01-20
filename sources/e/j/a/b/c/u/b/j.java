package e.j.a.b.c.u.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.zam;

/* loaded from: classes2.dex */
public final class j implements Parcelable.Creator<zam> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        FastJsonResponse.Field field = null;
        int i2 = 0;
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
                field = (FastJsonResponse.Field) SafeParcelReader.C(parcel, X, FastJsonResponse.Field.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zam(i2, str, field);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zam[] newArray(int i2) {
        return new zam[i2];
    }
}
