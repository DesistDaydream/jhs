package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.m.a;
import e.j.a.b.c.u.c;

@SafeParcelable.a(creator = "FavaDiagnosticsEntityCreator")
@a
/* loaded from: classes2.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    @a
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new c();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(id = 2)
    private final String zapj;
    @SafeParcelable.c(id = 3)
    private final int zapk;

    @SafeParcelable.b
    public FavaDiagnosticsEntity(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) int i3) {
        this.zalf = i2;
        this.zapj = str;
        this.zapk = i3;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.X(parcel, 2, this.zapj, false);
        e.j.a.b.c.r.i0.a.F(parcel, 3, this.zapk);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @a
    public FavaDiagnosticsEntity(String str, int i2) {
        this.zalf = 1;
        this.zapj = str;
        this.zapk = i2;
    }
}
