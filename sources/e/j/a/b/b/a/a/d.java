package e.j.a.b.b.a.a;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class d implements Parcelable.Creator<GoogleSignInAccount> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        String str6 = null;
        ArrayList arrayList = null;
        String str7 = null;
        String str8 = null;
        long j2 = 0;
        int i2 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel, X);
                    break;
                case 2:
                    str = SafeParcelReader.G(parcel, X);
                    break;
                case 3:
                    str2 = SafeParcelReader.G(parcel, X);
                    break;
                case 4:
                    str3 = SafeParcelReader.G(parcel, X);
                    break;
                case 5:
                    str4 = SafeParcelReader.G(parcel, X);
                    break;
                case 6:
                    uri = (Uri) SafeParcelReader.C(parcel, X, Uri.CREATOR);
                    break;
                case 7:
                    str5 = SafeParcelReader.G(parcel, X);
                    break;
                case 8:
                    j2 = SafeParcelReader.c0(parcel, X);
                    break;
                case 9:
                    str6 = SafeParcelReader.G(parcel, X);
                    break;
                case 10:
                    arrayList = SafeParcelReader.L(parcel, X, Scope.CREATOR);
                    break;
                case 11:
                    str7 = SafeParcelReader.G(parcel, X);
                    break;
                case 12:
                    str8 = SafeParcelReader.G(parcel, X);
                    break;
                default:
                    SafeParcelReader.g0(parcel, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new GoogleSignInAccount(i2, str, str2, str3, str4, uri, str5, j2, str6, arrayList, str7, str8);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ GoogleSignInAccount[] newArray(int i2) {
        return new GoogleSignInAccount[i2];
    }
}
