package e.j.a.b.c;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class a0 implements Parcelable.Creator<ConnectionResult> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        PendingIntent pendingIntent = null;
        String str = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.C(parcel, X, PendingIntent.CREATOR);
            } else if (O != 4) {
                SafeParcelReader.g0(parcel, X);
            } else {
                str = SafeParcelReader.G(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new ConnectionResult(i2, i3, pendingIntent, str);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ConnectionResult[] newArray(int i2) {
        return new ConnectionResult[i2];
    }
}
