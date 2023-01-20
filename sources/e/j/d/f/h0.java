package e.j.d.f;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.firebase.iid.zzd;

/* loaded from: classes2.dex */
public final class h0 implements Parcelable.Creator<zzd> {
    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd createFromParcel(Parcel parcel) {
        IBinder readStrongBinder = parcel.readStrongBinder();
        if (readStrongBinder != null) {
            return new zzd(readStrongBinder);
        }
        return null;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ zzd[] newArray(int i2) {
        return new zzd[i2];
    }
}
