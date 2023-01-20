package e.j.a.b.c.r;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.GetServiceRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class b1 implements Parcelable.Creator<GetServiceRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Bundle bundle = null;
        Account account = null;
        Feature[] featureArr = null;
        Feature[] featureArr2 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        boolean z = false;
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
                    i4 = SafeParcelReader.Z(parcel, X);
                    break;
                case 4:
                    str = SafeParcelReader.G(parcel, X);
                    break;
                case 5:
                    iBinder = SafeParcelReader.Y(parcel, X);
                    break;
                case 6:
                    scopeArr = (Scope[]) SafeParcelReader.K(parcel, X, Scope.CREATOR);
                    break;
                case 7:
                    bundle = SafeParcelReader.g(parcel, X);
                    break;
                case 8:
                    account = (Account) SafeParcelReader.C(parcel, X, Account.CREATOR);
                    break;
                case 9:
                default:
                    SafeParcelReader.g0(parcel, X);
                    break;
                case 10:
                    featureArr = (Feature[]) SafeParcelReader.K(parcel, X, Feature.CREATOR);
                    break;
                case 11:
                    featureArr2 = (Feature[]) SafeParcelReader.K(parcel, X, Feature.CREATOR);
                    break;
                case 12:
                    z = SafeParcelReader.P(parcel, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new GetServiceRequest(i2, i3, i4, str, iBinder, scopeArr, bundle, account, featureArr, featureArr2, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GetServiceRequest[] newArray(int i2) {
        return new GetServiceRequest[i2];
    }
}
