package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.moor.imkf.IMChatManager;
import com.vector.util.Res;
import e.l.r.j0;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class SearchUser implements Parcelable {
    @d
    public static final Parcelable.Creator<SearchUser> CREATOR = new Creator();
    @e.j.e.r.c("avatar")
    @e
    private String avatar;
    @e.j.e.r.c("seller_bio")
    @e
    private String bio;
    @e.j.e.r.c("credit")
    @e
    private String credit;
    @e.j.e.r.c("ecommerce_verify")
    private boolean ecommerceVerify;
    @e.j.e.r.c("follower_count")
    @e
    private Long fansCount;
    @e.j.e.r.c("is_follow")
    private boolean followed;
    @e.j.e.r.c("user_id")
    @e
    private Integer id;
    @e.j.e.r.c(IMChatManager.CONSTANT_USERNAME)
    @e
    private String name;
    @e.j.e.r.c("verify_status")
    @e
    private Integer verifyStatus;
    @e.j.e.r.c("like_count")
    @e
    private Long zanCount;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SearchUser> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SearchUser createFromParcel(@d Parcel parcel) {
            return new SearchUser(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SearchUser[] newArray(int i2) {
            return new SearchUser[i2];
        }
    }

    public SearchUser() {
        this(null, null, null, null, null, false, null, null, null, false, 1023, null);
    }

    public SearchUser(@e Integer num, @e String str, @e String str2, @e String str3, @e String str4, boolean z, @e Integer num2, @e Long l2, @e Long l3, boolean z2) {
        this.id = num;
        this.name = str;
        this.avatar = str2;
        this.bio = str3;
        this.credit = str4;
        this.ecommerceVerify = z;
        this.verifyStatus = num2;
        this.fansCount = l2;
        this.zanCount = l3;
        this.followed = z2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final String getBio() {
        return this.bio;
    }

    @e
    public final String getBioStr() {
        String str = this.bio;
        return str == null || str.length() == 0 ? Res.w(Res.a, R.string.common_no_bio, null, 2, null) : this.bio;
    }

    @e
    public final String getCredit() {
        return this.credit;
    }

    public final boolean getEcommerceVerify() {
        return this.ecommerceVerify;
    }

    @e
    public final Long getFansCount() {
        return this.fansCount;
    }

    public final boolean getFollowed() {
        return this.followed;
    }

    @d
    public final String getFormatFans() {
        j0 j0Var = j0.a;
        Long l2 = this.fansCount;
        return f0.C(j0Var.a(l2 == null ? 0L : l2.longValue()), Res.w(Res.a, R.string.common_fan, null, 2, null));
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @d
    public final String getUid() {
        Object obj = this.id;
        if (obj == null) {
            obj = "";
        }
        return String.valueOf(obj);
    }

    @e
    public final Integer getVerifyStatus() {
        return this.verifyStatus;
    }

    @e
    public final Long getZanCount() {
        return this.zanCount;
    }

    public final void setAvatar(@e String str) {
        this.avatar = str;
    }

    public final void setBio(@e String str) {
        this.bio = str;
    }

    public final void setCredit(@e String str) {
        this.credit = str;
    }

    public final void setEcommerceVerify(boolean z) {
        this.ecommerceVerify = z;
    }

    public final void setFansCount(@e Long l2) {
        this.fansCount = l2;
    }

    public final void setFollowed(boolean z) {
        this.followed = z;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setVerifyStatus(@e Integer num) {
        this.verifyStatus = num;
    }

    public final void setZanCount(@e Long l2) {
        this.zanCount = l2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.bio);
        parcel.writeString(this.credit);
        parcel.writeInt(this.ecommerceVerify ? 1 : 0);
        Integer num2 = this.verifyStatus;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Long l2 = this.fansCount;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        Long l3 = this.zanCount;
        if (l3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l3.longValue());
        }
        parcel.writeInt(this.followed ? 1 : 0);
    }

    public /* synthetic */ SearchUser(Integer num, String str, String str2, String str3, String str4, boolean z, Integer num2, Long l2, Long l3, boolean z2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? null : str4, (i2 & 32) != 0 ? false : z, (i2 & 64) != 0 ? null : num2, (i2 & 128) != 0 ? null : l2, (i2 & 256) == 0 ? l3 : null, (i2 & 512) == 0 ? z2 : false);
    }
}
