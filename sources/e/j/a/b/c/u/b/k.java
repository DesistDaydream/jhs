package e.j.a.b.c.u.b;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.server.response.zak;
import com.google.android.gms.common.server.response.zal;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class k implements Parcelable.Creator<zak> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        ArrayList arrayList = null;
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                arrayList = SafeParcelReader.L(parcel, X, zal.CREATOR);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                str = SafeParcelReader.G(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new zak(i2, arrayList, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zak[] newArray(int i2) {
        return new zak[i2];
    }
}
