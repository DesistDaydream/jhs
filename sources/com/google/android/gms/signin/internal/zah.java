package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.h.b.h;

@SafeParcelable.a(creator = "SignInRequestCreator")
/* loaded from: classes2.dex */
public final class zah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zah> CREATOR = new h();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getResolveAccountRequest", id = 2)
    private final ResolveAccountRequest zasd;

    @SafeParcelable.b
    public zah(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ResolveAccountRequest resolveAccountRequest) {
        this.zalf = i2;
        this.zasd = resolveAccountRequest;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.S(parcel, 2, this.zasd, i2, false);
        a.b(parcel, a);
    }

    public zah(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }
}
