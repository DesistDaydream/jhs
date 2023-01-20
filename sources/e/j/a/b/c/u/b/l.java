package e.j.a.b.c.u.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.zal;
import com.google.android.gms.common.server.response.zam;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class l implements Parcelable.Creator<zal> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        ArrayList arrayList = null;
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
                arrayList = SafeParcelReader.L(parcel, X, zam.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zal(i2, str, arrayList);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zal[] newArray(int i2) {
        return new zal[i2];
    }
}
