package com.jihuanshe.ui.page.detail;

import android.os.Parcel;
import android.os.Parcelable;
import com.moor.imkf.model.entity.FromToMessage;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardViewInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardViewInfo> CREATOR = new Creator();
    @e.j.e.r.c("seller_avatar")
    @e
    private String avatar;
    @e.j.e.r.c(FromToMessage.MSG_TYPE_IMAGE)
    @e
    private String image;
    @e.j.e.r.c("seller_user_id")
    private int userId;
    @e.j.e.r.c("seller_username")
    @e
    private String userName;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardViewInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardViewInfo createFromParcel(@d Parcel parcel) {
            return new CardViewInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardViewInfo[] newArray(int i2) {
            return new CardViewInfo[i2];
        }
    }

    public CardViewInfo() {
        this(0, null, null, null, 15, null);
    }

    public CardViewInfo(int i2, @e String str, @e String str2, @e String str3) {
        this.userId = i2;
        this.userName = str;
        this.avatar = str2;
        this.image = str3;
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
    public final String getImage() {
        return this.image;
    }

    public final int getUserId() {
        return this.userId;
    }

    @e
    public final String getUserName() {
        return this.userName;
    }

    public final void setAvatar(@e String str) {
        this.avatar = str;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setUserId(int i2) {
        this.userId = i2;
    }

    public final void setUserName(@e String str) {
        this.userName = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.avatar);
        parcel.writeString(this.image);
    }

    public /* synthetic */ CardViewInfo(int i2, String str, String str2, String str3, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : str3);
    }
}
