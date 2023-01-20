package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.bytedance.msdk.api.v2.GMNetworkPlatformConst;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.b0;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.y;

@SafeParcelable.a(creator = "FeatureCreator")
@a
/* loaded from: classes2.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new b0();
    @SafeParcelable.c(getter = "getName", id = 1)
    private final String name;
    @SafeParcelable.c(getter = "getOldVersion", id = 2)
    @Deprecated
    private final int zzk;
    @SafeParcelable.c(defaultValue = GMNetworkPlatformConst.AD_NETWORK_NO_PRICE, getter = "getVersion", id = 3)
    private final long zzl;

    @a
    public Feature(String str, long j2) {
        this.name = str;
        this.zzl = j2;
        this.zzk = -1;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            if (((getName() != null && getName().equals(feature.getName())) || (getName() == null && feature.getName() == null)) && getVersion() == feature.getVersion()) {
                return true;
            }
        }
        return false;
    }

    @a
    public String getName() {
        return this.name;
    }

    @a
    public long getVersion() {
        long j2 = this.zzl;
        return j2 == -1 ? this.zzk : j2;
    }

    public int hashCode() {
        return y.b(getName(), Long.valueOf(getVersion()));
    }

    public String toString() {
        return y.c(this).a("name", getName()).a("version", Long.valueOf(getVersion())).toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.X(parcel, 1, getName(), false);
        e.j.a.b.c.r.i0.a.F(parcel, 2, this.zzk);
        e.j.a.b.c.r.i0.a.K(parcel, 3, getVersion());
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @SafeParcelable.b
    public Feature(@SafeParcelable.e(id = 1) String str, @SafeParcelable.e(id = 2) int i2, @SafeParcelable.e(id = 3) long j2) {
        this.name = str;
        this.zzk = i2;
        this.zzl = j2;
    }
}
