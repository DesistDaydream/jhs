package com.google.android.gms.auth.api.signin.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.b.a.a.b.c;
import e.j.a.b.c.m.a;

@SafeParcelable.a(creator = "GoogleSignInOptionsExtensionCreator")
/* loaded from: classes2.dex */
public class GoogleSignInOptionsExtensionParcelable extends AbstractSafeParcelable {
    public static final Parcelable.Creator<GoogleSignInOptionsExtensionParcelable> CREATOR = new c();
    @SafeParcelable.c(getter = "getBundle", id = 3)
    private Bundle mBundle;
    @SafeParcelable.c(getter = "getType", id = 2)
    private int mType;
    @SafeParcelable.g(id = 1)
    private final int versionCode;

    @SafeParcelable.b
    public GoogleSignInOptionsExtensionParcelable(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) int i3, @SafeParcelable.e(id = 3) Bundle bundle) {
        this.versionCode = i2;
        this.mType = i3;
        this.mBundle = bundle;
    }

    @a
    public int getType() {
        return this.mType;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.versionCode);
        e.j.a.b.c.r.i0.a.F(parcel, 2, getType());
        e.j.a.b.c.r.i0.a.k(parcel, 3, this.mBundle, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    public GoogleSignInOptionsExtensionParcelable(e.j.a.b.b.a.a.a aVar) {
        this(1, aVar.a(), aVar.c());
    }
}
