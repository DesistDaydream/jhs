package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.a;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.r.k0;
import e.j.a.b.c.r.q;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Nullable;

@SafeParcelable.a(creator = "AuthAccountRequestCreator")
/* loaded from: classes2.dex */
public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AuthAccountRequest> CREATOR = new k0();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(id = 2)
    @Deprecated
    private final IBinder zanx;
    @SafeParcelable.c(id = 3)
    private final Scope[] zany;
    @SafeParcelable.c(id = 4)
    private Integer zanz;
    @SafeParcelable.c(id = 5)
    private Integer zaoa;
    @SafeParcelable.c(id = 6, type = "android.accounts.Account")
    private Account zax;

    @SafeParcelable.b
    public AuthAccountRequest(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) IBinder iBinder, @SafeParcelable.e(id = 3) Scope[] scopeArr, @SafeParcelable.e(id = 4) Integer num, @SafeParcelable.e(id = 5) Integer num2, @SafeParcelable.e(id = 6) Account account) {
        this.zalf = i2;
        this.zanx = iBinder;
        this.zany = scopeArr;
        this.zanz = num;
        this.zaoa = num2;
        this.zax = account;
    }

    public Account getAccount() {
        Account account = this.zax;
        if (account != null) {
            return account;
        }
        IBinder iBinder = this.zanx;
        if (iBinder != null) {
            return a.c(q.a.b(iBinder));
        }
        return null;
    }

    @Nullable
    public Integer getOauthPolicy() {
        return this.zanz;
    }

    @Nullable
    public Integer getPolicyAction() {
        return this.zaoa;
    }

    public Set<Scope> getScopes() {
        return new HashSet(Arrays.asList(this.zany));
    }

    public AuthAccountRequest setOauthPolicy(@Nullable Integer num) {
        this.zanz = num;
        return this;
    }

    public AuthAccountRequest setPolicyAction(@Nullable Integer num) {
        this.zaoa = num;
        return this;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, this.zalf);
        e.j.a.b.c.r.i0.a.B(parcel, 2, this.zanx, false);
        e.j.a.b.c.r.i0.a.b0(parcel, 3, this.zany, i2, false);
        e.j.a.b.c.r.i0.a.I(parcel, 4, this.zanz, false);
        e.j.a.b.c.r.i0.a.I(parcel, 5, this.zaoa, false);
        e.j.a.b.c.r.i0.a.S(parcel, 6, this.zax, i2, false);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    @Deprecated
    public AuthAccountRequest(q qVar, Set<Scope> set) {
        this(3, qVar.asBinder(), (Scope[]) set.toArray(new Scope[set.size()]), null, null, null);
    }

    public AuthAccountRequest(Account account, Set<Scope> set) {
        this(3, null, (Scope[]) set.toArray(new Scope[set.size()]), null, null, (Account) a0.k(account));
    }
}
