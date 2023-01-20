package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.r.w0;

@SafeParcelable.a(creator = "ResolveAccountRequestCreator")
/* loaded from: classes2.dex */
public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ResolveAccountRequest> CREATOR = new w0();
    @SafeParcelable.g(id = 1)
    private final int zalf;
    @SafeParcelable.c(getter = "getSessionId", id = 3)
    private final int zapa;
    @SafeParcelable.c(getter = "getSignInAccountHint", id = 4)
    private final GoogleSignInAccount zapb;
    @SafeParcelable.c(getter = "getAccount", id = 2)
    private final Account zax;

    @SafeParcelable.b
    public ResolveAccountRequest(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) Account account, @SafeParcelable.e(id = 3) int i3, @SafeParcelable.e(id = 4) GoogleSignInAccount googleSignInAccount) {
        this.zalf = i2;
        this.zax = account;
        this.zapa = i3;
        this.zapb = googleSignInAccount;
    }

    public Account getAccount() {
        return this.zax;
    }

    public int getSessionId() {
        return this.zapa;
    }

    @Nullable
    public GoogleSignInAccount getSignInAccountHint() {
        return this.zapb;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.zalf);
        a.S(parcel, 2, getAccount(), i2, false);
        a.F(parcel, 3, getSessionId());
        a.S(parcel, 4, getSignInAccountHint(), i2, false);
        a.b(parcel, a);
    }

    public ResolveAccountRequest(Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i2, googleSignInAccount);
    }
}
