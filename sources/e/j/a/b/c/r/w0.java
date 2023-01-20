package e.j.a.b.c.r;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class w0 implements Parcelable.Creator<ResolveAccountRequest> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        Account account = null;
        GoogleSignInAccount googleSignInAccount = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                i2 = SafeParcelReader.Z(parcel, X);
            } else if (O == 2) {
                account = (Account) SafeParcelReader.C(parcel, X, Account.CREATOR);
            } else if (O == 3) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O != 4) {
                SafeParcelReader.g0(parcel, X);
            } else {
                googleSignInAccount = (GoogleSignInAccount) SafeParcelReader.C(parcel, X, GoogleSignInAccount.CREATOR);
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new ResolveAccountRequest(i2, account, i3, googleSignInAccount);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ ResolveAccountRequest[] newArray(int i2) {
        return new ResolveAccountRequest[i2];
    }
}
