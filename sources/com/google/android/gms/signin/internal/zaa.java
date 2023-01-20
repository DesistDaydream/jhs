package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.n.p;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.h.b.b;

@SafeParcelable.a(creator = "AuthAccountResultCreator")
/* loaded from: classes2.dex */
public final class zaa extends AbstractSafeParcelable implements p {
    public static final Parcelable.Creator<zaa> CREATOR = new b();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getConnectionResultCode", id = 2)
    private int zarz;
    @SafeParcelable.c(getter = "getRawAuthResolutionIntent", id = 3)
    private Intent zasa;

    @SafeParcelable.b
    public zaa(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) int i3, @SafeParcelable.e(id = 3) Intent intent) {
        this.zalf = i2;
        this.zarz = i3;
        this.zasa = intent;
    }

    @Override // e.j.a.b.c.n.p
    public final Status getStatus() {
        if (this.zarz == 0) {
            return Status.RESULT_SUCCESS;
        }
        return Status.RESULT_CANCELED;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.F(parcel, 2, this.zarz);
        a.S(parcel, 3, this.zasa, i2, false);
        a.b(parcel, a);
    }

    public zaa() {
        this(0, null);
    }

    private zaa(int i2, Intent intent) {
        this(2, 0, null);
    }
}
