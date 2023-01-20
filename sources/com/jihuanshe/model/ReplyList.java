package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ReplyList implements Parcelable {
    @d
    public static final Parcelable.Creator<ReplyList> CREATOR = new Creator();
    @e
    private final String avatar;
    @e
    private final String content;
    @e
    private final Integer id;
    @e.j.e.r.c("user_id")
    @e
    private final Integer userID;
    @e
    private final String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReplyList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyList createFromParcel(@d Parcel parcel) {
            return new ReplyList(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyList[] newArray(int i2) {
            return new ReplyList[i2];
        }
    }

    public ReplyList() {
        this(null, null, null, null, null, 31, null);
    }

    public ReplyList(@e String str, @e String str2, @e Integer num, @e Integer num2, @e String str3) {
        this.avatar = str;
        this.content = str2;
        this.id = num;
        this.userID = num2;
        this.username = str3;
    }

    public static /* synthetic */ ReplyList copy$default(ReplyList replyList, String str, String str2, Integer num, Integer num2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = replyList.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = replyList.content;
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            num = replyList.id;
        }
        Integer num3 = num;
        if ((i2 & 8) != 0) {
            num2 = replyList.userID;
        }
        Integer num4 = num2;
        if ((i2 & 16) != 0) {
            str3 = replyList.username;
        }
        return replyList.copy(str, str4, num3, num4, str3);
    }

    @e
    public final String component1() {
        return this.avatar;
    }

    @e
    public final String component2() {
        return this.content;
    }

    @e
    public final Integer component3() {
        return this.id;
    }

    @e
    public final Integer component4() {
        return this.userID;
    }

    @e
    public final String component5() {
        return this.username;
    }

    @d
    public final ReplyList copy(@e String str, @e String str2, @e Integer num, @e Integer num2, @e String str3) {
        return new ReplyList(str, str2, num, num2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReplyList) {
            ReplyList replyList = (ReplyList) obj;
            return f0.g(this.avatar, replyList.avatar) && f0.g(this.content, replyList.content) && f0.g(this.id, replyList.id) && f0.g(this.userID, replyList.userID) && f0.g(this.username, replyList.username);
        }
        return false;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final String getContent() {
        return this.content;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final Integer getUserID() {
        return this.userID;
    }

    @e
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.id;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.userID;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.username;
        return hashCode4 + (str3 != null ? str3.hashCode() : 0);
    }

    @d
    public String toString() {
        return "ReplyList(avatar=" + ((Object) this.avatar) + ", content=" + ((Object) this.content) + ", id=" + this.id + ", userID=" + this.userID + ", username=" + ((Object) this.username) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        parcel.writeString(this.content);
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.userID;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.username);
    }

    public /* synthetic */ ReplyList(String str, String str2, Integer num, Integer num2, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : num, (i2 & 8) != 0 ? 0 : num2, (i2 & 16) != 0 ? "" : str3);
    }
}
