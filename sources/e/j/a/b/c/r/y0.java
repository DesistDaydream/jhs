package e.j.a.b.c.r;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.SignInButtonConfig;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class y0 implements Parcelable.Creator<SignInButtonConfig> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        int i2 = 0;
        Scope[] scopeArr = null;
        int i3 = 0;
        int i4 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 3) {
                i4 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.g0(parcel, X);
            } else {
                scopeArr = (Scope[]) SafeParcelReader.K(parcel, X, Scope.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new SignInButtonConfig(i2, i3, i4, scopeArr);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ SignInButtonConfig[] newArray(int i2) {
        return new SignInButtonConfig[i2];
    }
}
