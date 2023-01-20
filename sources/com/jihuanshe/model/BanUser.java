package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class BanUser implements Parcelable {
    @d
    public static final Parcelable.Creator<BanUser> CREATOR = new Creator();
    @e.j.e.r.c("ban_user_avatar")
    @e
    private final String avatar;
    @e.j.e.r.c("ban_user_seller_bio")
    @e
    private final String bio;
    @e.j.e.r.c("ban_user_username")
    @e
    private final String name;
    @e.j.e.r.c("ban_user_id")
    private final int uid;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<BanUser> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final BanUser createFromParcel(@d Parcel parcel) {
            return new BanUser(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final BanUser[] newArray(int i2) {
            return new BanUser[i2];
        }
    }

    public BanUser(int i2, @e String str, @e String str2, @e String str3) {
        this.uid = i2;
        this.name = str;
        this.avatar = str2;
        this.bio = str3;
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
    public final String getName() {
        return this.name;
    }

    public final int getUid() {
        return this.uid;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.uid);
        parcel.writeString(this.name);
        parcel.writeString(this.avatar);
        parcel.writeString(this.bio);
    }

    public /* synthetic */ BanUser(int i2, String str, String str2, String str3, int i3, u uVar) {
        this(i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3);
    }
}
