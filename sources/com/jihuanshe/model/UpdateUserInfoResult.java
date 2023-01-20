package com.jihuanshe.model;

import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import k.e.a.d;
import k.e.a.e;

/* loaded from: classes2.dex */
public final class UpdateUserInfoResult {
    @c("avatar")
    @e
    private final String avatar;
    @c("user_id")
    @e
    private final Integer id;
    @c("phone")
    @e
    private final String phone;

    public UpdateUserInfoResult() {
        this(null, null, null, 7, null);
    }

    public UpdateUserInfoResult(@e Integer num, @e String str, @e String str2) {
        this.id = num;
        this.phone = str;
        this.avatar = str2;
    }

    public static /* synthetic */ UpdateUserInfoResult copy$default(UpdateUserInfoResult updateUserInfoResult, Integer num, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = updateUserInfoResult.id;
        }
        if ((i2 & 2) != 0) {
            str = updateUserInfoResult.phone;
        }
        if ((i2 & 4) != 0) {
            str2 = updateUserInfoResult.avatar;
        }
        return updateUserInfoResult.copy(num, str, str2);
    }

    @e
    public final Integer component1() {
        return this.id;
    }

    @e
    public final String component2() {
        return this.phone;
    }

    @e
    public final String component3() {
        return this.avatar;
    }

    @d
    public final UpdateUserInfoResult copy(@e Integer num, @e String str, @e String str2) {
        return new UpdateUserInfoResult(num, str, str2);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof UpdateUserInfoResult) {
            UpdateUserInfoResult updateUserInfoResult = (UpdateUserInfoResult) obj;
            return f0.g(this.id, updateUserInfoResult.id) && f0.g(this.phone, updateUserInfoResult.phone) && f0.g(this.avatar, updateUserInfoResult.avatar);
        }
        return false;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final String getPhone() {
        return this.phone;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.phone;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.avatar;
        return hashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "UpdateUserInfoResult(id=" + this.id + ", phone=" + ((Object) this.phone) + ", avatar=" + ((Object) this.avatar) + ')';
    }

    public /* synthetic */ UpdateUserInfoResult(Integer num, String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2);
    }
}
