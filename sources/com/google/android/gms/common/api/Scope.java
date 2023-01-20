package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.m.a;
import e.j.a.b.c.n.y;
import e.j.a.b.c.r.a0;

@SafeParcelable.a(creator = "ScopeCreator")
@a
/* loaded from: classes2.dex */
public final class Scope extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new y();
    @SafeParcelable.c(getter = "getScopeUri", id = 2)
    private final String zzaq;
    @SafeParcelable.g(id = 1)
    private final int zzg;

    @SafeParcelable.b
    public Scope(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) String str) {
        a0.h(str, "scopeUri must not be null or empty");
        this.zzg = i2;
        this.zzaq = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Scope) {
            return this.zzaq.equals(((Scope) obj).zzaq);
        }
        return false;
    }

    @a
    public final String getScopeUri() {
        return this.zzaq;
    }

    public final int hashCode() {
        return this.zzaq.hashCode();
    }

    public final String toString() {
        return this.zzaq;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zzg);
        e.j.a.b.c.r.i0.a.X(parcel, 2, getScopeUri(), false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    public Scope(String str) {
        this(1, str);
    }
}
