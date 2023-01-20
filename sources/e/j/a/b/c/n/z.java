package e.j.a.b.c.n;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class z implements Parcelable.Creator<Status> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        PendingIntent pendingIntent = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                str = SafeParcelReader.G(parcel, X);
            } else if (O == 3) {
                pendingIntent = (PendingIntent) SafeParcelReader.C(parcel, X, PendingIntent.CREATOR);
            } else if (O != 1000) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i2 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new Status(i2, i3, str, pendingIntent);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Status[] newArray(int i2) {
        return new Status[i2];
    }
}
