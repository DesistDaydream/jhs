package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.u.b.j;

@SafeParcelable.a(creator = "FieldMapPairCreator")
@d0
/* loaded from: classes2.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new j();
    @SafeParcelable.g(id = 1)
    private final int versionCode;
    @SafeParcelable.c(id = 2)
    public final String zaqz;
    @SafeParcelable.c(id = 3)
    public final FastJsonResponse.Field<?, ?> zara;

    @SafeParcelable.b
    public zam(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str, @SafeParcelable.e(id = 3) FastJsonResponse.Field<?, ?> field) {
        this.versionCode = i2;
        this.zaqz = str;
        this.zara = field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.versionCode);
        a.X(parcel, 2, this.zaqz, false);
        a.S(parcel, 3, this.zara, i2, false);
        a.b(parcel, a);
    }

    public zam(String str, FastJsonResponse.Field<?, ?> field) {
        this.versionCode = 1;
        this.zaqz = str;
        this.zara = field;
    }
}
