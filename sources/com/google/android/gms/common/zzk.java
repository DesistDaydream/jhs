package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.tencent.bugly.Bugly;
import e.j.a.b.c.e0;
import e.j.a.b.c.f0;
import e.j.a.b.c.k0;
import e.j.a.b.c.r.h1;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.d.d;
import e.j.a.b.d.f;
import javax.annotation.Nullable;

@SafeParcelable.a(creator = "GoogleCertificatesQueryCreator")
/* loaded from: classes2.dex */
public final class zzk extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzk> CREATOR = new k0();
    @SafeParcelable.c(getter = "getAllowTestKeys", id = 3)
    private final boolean zzaa;
    @SafeParcelable.c(defaultValue = Bugly.SDK_IS_DEV, getter = "getForbidTestKeys", id = 4)
    private final boolean zzab;
    @SafeParcelable.c(getter = "getCallingPackage", id = 1)
    private final String zzy;
    @SafeParcelable.c(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final e0 zzz;

    @SafeParcelable.b
    public zzk(@SafeParcelable.e(id = 1) String str, @SafeParcelable.e(id = 2) @Nullable IBinder iBinder, @SafeParcelable.e(id = 3) boolean z, @SafeParcelable.e(id = 4) boolean z2) {
        this.zzy = str;
        this.zzz = zza(iBinder);
        this.zzaa = z;
        this.zzab = z2;
    }

    @Nullable
    private static e0 zza(@Nullable IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        try {
            d Z = h1.b(iBinder).Z();
            byte[] bArr = Z == null ? null : (byte[]) f.c(Z);
            if (bArr != null) {
                return new f0(bArr);
            }
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            return null;
        } catch (RemoteException e2) {
            Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            return null;
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        IBinder asBinder;
        int a = a.a(parcel);
        a.X(parcel, 1, this.zzy, false);
        e0 e0Var = this.zzz;
        if (e0Var == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            asBinder = null;
        } else {
            asBinder = e0Var.asBinder();
        }
        a.B(parcel, 2, asBinder, false);
        a.g(parcel, 3, this.zzaa);
        a.g(parcel, 4, this.zzab);
        a.b(parcel, a);
    }

    public zzk(String str, @Nullable e0 e0Var, boolean z, boolean z2) {
        this.zzy = str;
        this.zzz = e0Var;
        this.zzaa = z;
        this.zzab = z2;
    }
}
