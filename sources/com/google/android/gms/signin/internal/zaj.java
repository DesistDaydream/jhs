package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.h.b.i;

@SafeParcelable.a(creator = "SignInResponseCreator")
/* loaded from: classes2.dex */
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new i();
    @SafeParcelable.c(getter = "getConnectionResult", id = 2)
    private final ConnectionResult zadi;
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getResolveAccountResponse", id = 3)
    private final ResolveAccountResponse zase;

    @SafeParcelable.b
    public zaj(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) ConnectionResult connectionResult, @SafeParcelable.e(id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.zalf = i2;
        this.zadi = connectionResult;
        this.zase = resolveAccountResponse;
    }

    public final ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.S(parcel, 2, this.zadi, i2, false);
        a.S(parcel, 3, this.zase, i2, false);
        a.b(parcel, a);
    }

    public final ResolveAccountResponse zacx() {
        return this.zase;
    }

    public zaj(int i2) {
        this(new ConnectionResult(8, null), null);
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, null);
    }
}
