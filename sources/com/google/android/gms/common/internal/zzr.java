package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.r.p1;

@SafeParcelable.a(creator = "ValidateAccountRequestCreator")
@Deprecated
/* loaded from: classes2.dex */
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzr> CREATOR = new p1();
    @SafeParcelable.g(id = 1)
    private final int zzg;

    @SafeParcelable.b
    public zzr(@SafeParcelable.e(id = 1) int i2) {
        this.zzg = i2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zzg);
        a.b(parcel, a);
    }
}
