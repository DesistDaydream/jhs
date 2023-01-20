package com.google.firebase.iid;

import android.os.Build;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import e.j.d.f.h0;
import e.j.d.f.p0;
import e.j.d.f.s0;

/* loaded from: classes2.dex */
public class zzd implements Parcelable {
    public static final Parcelable.Creator<zzd> CREATOR = new h0();
    private Messenger zza;
    private p0 zzb;

    /* loaded from: classes2.dex */
    public static final class a extends ClassLoader {
        @Override // java.lang.ClassLoader
        public final Class<?> loadClass(String str, boolean z) throws ClassNotFoundException {
            if ("com.google.android.gms.iid.MessengerCompat".equals(str)) {
                if (FirebaseInstanceId.C()) {
                    Log.d("FirebaseInstanceId", "Using renamed FirebaseIidMessengerCompat class");
                    return zzd.class;
                }
                return zzd.class;
            }
            return super.loadClass(str, z);
        }
    }

    public zzd(IBinder iBinder) {
        if (Build.VERSION.SDK_INT >= 21) {
            this.zza = new Messenger(iBinder);
        } else {
            this.zzb = new s0(iBinder);
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return zza().equals(((zzd) obj).zza());
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public int hashCode() {
        return zza().hashCode();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        Messenger messenger = this.zza;
        if (messenger != null) {
            parcel.writeStrongBinder(messenger.getBinder());
        } else {
            parcel.writeStrongBinder(this.zzb.asBinder());
        }
    }

    public final void zza(Message message) throws RemoteException {
        Messenger messenger = this.zza;
        if (messenger != null) {
            messenger.send(message);
        } else {
            this.zzb.s(message);
        }
    }

    private final IBinder zza() {
        Messenger messenger = this.zza;
        return messenger != null ? messenger.getBinder() : this.zzb.asBinder();
    }
}
