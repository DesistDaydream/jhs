package e.j.d.i;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.firebase.messaging.RemoteMessage;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<RemoteMessage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        Bundle bundle = null;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            if (SafeParcelReader.O(X) != 2) {
                SafeParcelReader.g0(parcel, X);
            } else {
                bundle = SafeParcelReader.g(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new RemoteMessage(bundle);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
