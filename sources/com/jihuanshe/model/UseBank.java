package com.jihuanshe.model;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UseBank {
    @c("account_number")
    @e
    private final String account;
    @c("account_bank")
    @e
    private final String bank;
    @c("bank_name")
    @e
    private final String fullName;
    @c("bank_branch_id")
    @e
    private final String id;
    @c("verify_result")
    @e
    private final String state;

    public UseBank() {
        this(null, null, null, null, null, 31, null);
    }

    public UseBank(@e String str, @e String str2, @e String str3, @e String str4, @e String str5) {
        this.bank = str;
        this.account = str2;
        this.id = str3;
        this.fullName = str4;
        this.state = str5;
    }

    @e
    public final String getAccount() {
        return this.account;
    }

    @e
    public final String getBank() {
        return this.bank;
    }

    @d
    public final String getBankAccount() {
        Res res = Res.a;
        Object[] objArr = new Object[1];
        String str = this.account;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        return res.v(R.string.confirm_bank_account, objArr);
    }

    @d
    public final String getBankName() {
        Res res = Res.a;
        boolean z = true;
        Object[] objArr = new Object[1];
        String str = this.fullName;
        if (str != null && str.length() != 0) {
            z = false;
        }
        objArr[0] = (z || f0.g(this.fullName, "未填写")) ? this.bank : this.fullName;
        return res.v(R.string.confirm_use_bank, objArr);
    }

    @d
    public final String getChangingStr() {
        Res res = Res.a;
        Object[] objArr = new Object[2];
        String str = this.bank;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = this.account;
        objArr[1] = str2 != null ? str2 : "";
        return res.v(R.string.confirm_change_bank, objArr);
    }

    @e
    public final String getFullName() {
        return this.fullName;
    }

    @e
    public final String getId() {
        return this.id;
    }

    @e
    public final String getState() {
        return this.state;
    }

    public final boolean isVerifying() {
        return f0.g(this.state, "VERIFYING");
    }

    public /* synthetic */ UseBank(String str, String str2, String str3, String str4, String str5, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5);
    }
}
