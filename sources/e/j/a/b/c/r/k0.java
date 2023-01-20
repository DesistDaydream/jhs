package e.j.a.b.c.r;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.AuthAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class k0 implements Parcelable.Creator<AuthAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        IBinder iBinder = null;
        Scope[] scopeArr = null;
        Integer num = null;
        Integer num2 = null;
        Account account = null;
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel, X);
                    break;
                case 2:
                    iBinder = SafeParcelReader.Y(parcel, X);
                    break;
                case 3:
                    scopeArr = (Scope[]) SafeParcelReader.K(parcel, X, Scope.CREATOR);
                    break;
                case 4:
                    num = SafeParcelReader.a0(parcel, X);
                    break;
                case 5:
                    num2 = SafeParcelReader.a0(parcel, X);
                    break;
                case 6:
                    account = (Account) SafeParcelReader.C(parcel, X, Account.CREATOR);
                    break;
                default:
                    SafeParcelReader.g0(parcel, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new AuthAccountRequest(i2, iBinder, scopeArr, num, num2, account);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ AuthAccountRequest[] newArray(int i2) {
        return new AuthAccountRequest[i2];
    }
}
