package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.a1;
import e.j.a.b.c.r.i0.a;

@SafeParcelable.a(creator = "ConnectionInfoCreator")
/* loaded from: classes2.dex */
public final class zzb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzb> CREATOR = new a1();
    @SafeParcelable.c(id = 1)
    public Bundle zzda;
    @SafeParcelable.c(id = 2)
    public Feature[] zzdb;

    @SafeParcelable.b
    public zzb(@SafeParcelable.e(id = 1) Bundle bundle, @SafeParcelable.e(id = 2) Feature[] featureArr) {
        this.zzda = bundle;
        this.zzdb = featureArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.k(parcel, 1, this.zzda, false);
        a.b0(parcel, 2, this.zzdb, i2, false);
        a.b(parcel, a);
    }

    public zzb() {
    }
}
