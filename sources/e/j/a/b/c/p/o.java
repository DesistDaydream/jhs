package e.j.a.b.c.p;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* loaded from: classes2.dex */
public final class o implements Parcelable.Creator<DataHolder> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder createFromParcel(Parcel parcel) {
        int h0 = SafeParcelReader.h0(parcel);
        String[] strArr = null;
        CursorWindow[] cursorWindowArr = null;
        Bundle bundle = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < h0) {
            int X = SafeParcelReader.X(parcel);
            int O = SafeParcelReader.O(X);
            if (O == 1) {
                strArr = SafeParcelReader.H(parcel, X);
            } else if (O == 2) {
                cursorWindowArr = (CursorWindow[]) SafeParcelReader.K(parcel, X, CursorWindow.CREATOR);
            } else if (O == 3) {
                i3 = SafeParcelReader.Z(parcel, X);
            } else if (O == 4) {
                bundle = SafeParcelReader.g(parcel, X);
            } else if (O != 1000) {
                SafeParcelReader.g0(parcel, X);
            } else {
                i2 = SafeParcelReader.Z(parcel, X);
            }
        }
        SafeParcelReader.N(parcel, h0);
        DataHolder dataHolder = new DataHolder(i2, strArr, cursorWindowArr, i3, bundle);
        dataHolder.zaca();
        return dataHolder;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ DataHolder[] newArray(int i2) {
        return new DataHolder[i2];
    }
}
