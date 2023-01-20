package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.r.q;
import e.j.a.b.c.r.x0;

@SafeParcelable.a(creator = "ResolveAccountResponseCreator")
/* loaded from: classes2.dex */
public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountResponse> CREATOR = new x0();
    @SafeParcelable.c(getter = "getConnectionResult", id = 3)
    private ConnectionResult zadi;
    @SafeParcelable.c(getter = "getSaveDefaultAccount", id = 4)
    private boolean zagg;
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(id = 2)
    private IBinder zanx;
    @SafeParcelable.c(getter = "isFromCrossClientAuth", id = 5)
    private boolean zapc;

    @SafeParcelable.b
    public ResolveAccountResponse(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) IBinder iBinder, @SafeParcelable.e(id = 3) ConnectionResult connectionResult, @SafeParcelable.e(id = 4) boolean z, @SafeParcelable.e(id = 5) boolean z2) {
        this.zalf = i2;
        this.zanx = iBinder;
        this.zadi = connectionResult;
        this.zagg = z;
        this.zapc = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ResolveAccountResponse) {
            ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
            return this.zadi.equals(resolveAccountResponse.zadi) && getAccountAccessor().equals(resolveAccountResponse.getAccountAccessor());
        }
        return false;
    }

    public q getAccountAccessor() {
        return q.a.b(this.zanx);
    }

    public ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    public boolean getSaveDefaultAccount() {
        return this.zagg;
    }

    public boolean isFromCrossClientAuth() {
        return this.zapc;
    }

    public ResolveAccountResponse setAccountAccessor(q qVar) {
        this.zanx = qVar == null ? null : qVar.asBinder();
        return this;
    }

    public ResolveAccountResponse setIsFromCrossClientAuth(boolean z) {
        this.zapc = z;
        return this;
    }

    public ResolveAccountResponse setSaveDefaultAccount(boolean z) {
        this.zagg = z;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.B(parcel, 2, this.zanx, false);
        a.S(parcel, 3, getConnectionResult(), i2, false);
        a.g(parcel, 4, getSaveDefaultAccount());
        a.g(parcel, 5, isFromCrossClientAuth());
        a.b(parcel, a);
    }

    public ResolveAccountResponse(ConnectionResult connectionResult) {
        this(1, null, connectionResult, false, false);
    }

    public ResolveAccountResponse(int i2) {
        this(new ConnectionResult(i2, null));
    }
}
