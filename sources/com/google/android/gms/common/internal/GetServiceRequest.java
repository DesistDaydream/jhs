package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.f;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.b1;
import e.j.a.b.c.r.q;

@SafeParcelable.a(creator = "GetServiceRequestCreator")
@a
@SafeParcelable.f({9})
/* loaded from: classes2.dex */
public class GetServiceRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GetServiceRequest> CREATOR = new b1();
    @SafeParcelable.g(id = 1)
    private final int version;
    @SafeParcelable.c(id = 2)
    private final int zzdg;
    @SafeParcelable.c(id = 3)
    private int zzdh;
    @SafeParcelable.c(id = 5)
    public IBinder zzdi;
    @SafeParcelable.c(id = 6)
    public Scope[] zzdj;
    @SafeParcelable.c(id = 7)
    public Bundle zzdk;
    @SafeParcelable.c(id = 8)
    public Account zzdl;
    @SafeParcelable.c(id = 10)
    public Feature[] zzdm;
    @SafeParcelable.c(id = 11)
    public Feature[] zzdn;
    @SafeParcelable.c(id = 12)
    private boolean zzdo;
    @SafeParcelable.c(id = 4)
    public String zzy;

    public GetServiceRequest(int i2) {
        this.version = 4;
        this.zzdh = f.a;
        this.zzdg = i2;
        this.zzdo = true;
    }

    @a
    public Bundle getExtraArgs() {
        return this.zzdk;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.version);
        e.j.a.b.c.r.i0.a.F(parcel, 2, this.zzdg);
        e.j.a.b.c.r.i0.a.F(parcel, 3, this.zzdh);
        e.j.a.b.c.r.i0.a.X(parcel, 4, this.zzy, false);
        e.j.a.b.c.r.i0.a.B(parcel, 5, this.zzdi, false);
        e.j.a.b.c.r.i0.a.b0(parcel, 6, this.zzdj, i2, false);
        e.j.a.b.c.r.i0.a.k(parcel, 7, this.zzdk, false);
        e.j.a.b.c.r.i0.a.S(parcel, 8, this.zzdl, i2, false);
        e.j.a.b.c.r.i0.a.b0(parcel, 10, this.zzdm, i2, false);
        e.j.a.b.c.r.i0.a.b0(parcel, 11, this.zzdn, i2, false);
        e.j.a.b.c.r.i0.a.g(parcel, 12, this.zzdo);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @SafeParcelable.b
    public GetServiceRequest(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) int i3, @SafeParcelable.e(id = 3) int i4, @SafeParcelable.e(id = 4) String str, @SafeParcelable.e(id = 5) IBinder iBinder, @SafeParcelable.e(id = 6) Scope[] scopeArr, @SafeParcelable.e(id = 7) Bundle bundle, @SafeParcelable.e(id = 8) Account account, @SafeParcelable.e(id = 10) Feature[] featureArr, @SafeParcelable.e(id = 11) Feature[] featureArr2, @SafeParcelable.e(id = 12) boolean z) {
        this.version = i2;
        this.zzdg = i3;
        this.zzdh = i4;
        if ("com.google.android.gms".equals(str)) {
            this.zzy = "com.google.android.gms";
        } else {
            this.zzy = str;
        }
        if (i2 < 2) {
            this.zzdl = iBinder != null ? e.j.a.b.c.r.a.c(q.a.b(iBinder)) : null;
        } else {
            this.zzdi = iBinder;
            this.zzdl = account;
        }
        this.zzdj = scopeArr;
        this.zzdk = bundle;
        this.zzdm = featureArr;
        this.zzdn = featureArr2;
        this.zzdo = z;
    }
}
