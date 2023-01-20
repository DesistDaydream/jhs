package e.j.a.b.c.p;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import com.google.android.gms.common.data.BitmapTeleporter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class m implements Parcelable.Creator<BitmapTeleporter> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                parcelFileDescriptor = (ParcelFileDescriptor) SafeParcelReader.C(parcel, X, ParcelFileDescriptor.CREATOR);
            } else if (O != 3) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i3 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new BitmapTeleporter(i2, parcelFileDescriptor, i3);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ BitmapTeleporter[] newArray(int i2) {
        return new BitmapTeleporter[i2];
    }
}
