package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.r.y0;

@SafeParcelable.a(creator = "SignInButtonConfigCreator")
/* loaded from: classes2.dex */
public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Parcelable.Creator<SignInButtonConfig> CREATOR = new y0();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getScopes", id = 4)
    @Deprecated
    private final Scope[] zany;
    @SafeParcelable.c(getter = "getButtonSize", id = 2)
    private final int zapd;
    @SafeParcelable.c(getter = "getColorScheme", id = 3)
    private final int zape;

    @SafeParcelable.b
    public SignInButtonConfig(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) int i3, @SafeParcelable.e(id = 3) int i4, @SafeParcelable.e(id = 4) Scope[] scopeArr) {
        this.zalf = i2;
        this.zapd = i3;
        this.zape = i4;
        this.zany = scopeArr;
    }

    public int getButtonSize() {
        return this.zapd;
    }

    public int getColorScheme() {
        return this.zape;
    }

    @Deprecated
    public Scope[] getScopes() {
        return this.zany;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.F(parcel, 2, getButtonSize());
        a.F(parcel, 3, getColorScheme());
        a.b0(parcel, 4, getScopes(), i2, false);
        a.b(parcel, a);
    }

    public SignInButtonConfig(int i2, int i3, Scope[] scopeArr) {
        this(1, i2, i3, null);
    }
}
