package e.j.a.b.c.q;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class f implements Parcelable.Creator<WebImage> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        Uri uri = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                uri = (Uri) SafeParcelReader.C(parcel, X, Uri.CREATOR);
            } else if (O == 3) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i4 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new WebImage(i2, uri, i3, i4);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WebImage[] newArray(int i2) {
        return new WebImage[i2];
    }
}
