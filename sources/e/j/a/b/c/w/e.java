package e.j.a.b.c.w;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.common.stats.WakeLockEvent;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public final class e implements Parcelable.Creator<WakeLockEvent> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        String str = null;
        ArrayList<String> arrayList = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        String str5 = null;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        float f2 = 0.0f;
        boolean z = false;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            switch (SafeParcelReader.O(X)) {
                case 1:
                    i2 = SafeParcelReader.Z(parcel, X);
                    break;
                case 2:
                    j2 = SafeParcelReader.c0(parcel, X);
                    break;
                case 3:
                case 7:
                case 9:
                default:
                    SafeParcelReader.g0(parcel, X);
                    break;
                case 4:
                    str = SafeParcelReader.G(parcel, X);
                    break;
                case 5:
                    i4 = SafeParcelReader.Z(parcel, X);
                    break;
                case 6:
                    arrayList = SafeParcelReader.I(parcel, X);
                    break;
                case 8:
                    j3 = SafeParcelReader.c0(parcel, X);
                    break;
                case 10:
                    str3 = SafeParcelReader.G(parcel, X);
                    break;
                case 11:
                    i3 = SafeParcelReader.Z(parcel, X);
                    break;
                case 12:
                    str2 = SafeParcelReader.G(parcel, X);
                    break;
                case 13:
                    str4 = SafeParcelReader.G(parcel, X);
                    break;
                case 14:
                    i5 = SafeParcelReader.Z(parcel, X);
                    break;
                case 15:
                    f2 = SafeParcelReader.V(parcel, X);
                    break;
                case 16:
                    j4 = SafeParcelReader.c0(parcel, X);
                    break;
                case 17:
                    str5 = SafeParcelReader.G(parcel, X);
                    break;
                case 18:
                    z = SafeParcelReader.P(parcel, X);
                    break;
            }
        }
        SafeParcelReader.N(parcel, h0);
        return new WakeLockEvent(i2, j2, i3, str, i4, arrayList, str2, j3, i5, str3, str4, f2, j4, str5, z);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ WakeLockEvent[] newArray(int i2) {
        return new WakeLockEvent[i2];
    }
}
