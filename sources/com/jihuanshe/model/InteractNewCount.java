package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class InteractNewCount implements Parcelable {
    @d
    public static final Parcelable.Creator<InteractNewCount> CREATOR = new Creator();
    @e.j.e.r.c("no_read_detail")
    @e
    private String lastContent;
    @e.j.e.r.c("no_read_total")
    @e
    private String totalUnreadCount;
    @e.j.e.r.c("no_read_review_reply")
    @e
    private Integer newReply = 0;
    @e.j.e.r.c("no_read_review_at")
    @e
    private Integer newAt = 0;
    @e.j.e.r.c("no_read_review_like")
    @e
    private Integer newLike = 0;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<InteractNewCount> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final InteractNewCount createFromParcel(@d Parcel parcel) {
            parcel.readInt();
            return new InteractNewCount();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final InteractNewCount[] newArray(int i2) {
            return new InteractNewCount[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getAtNumStr() {
        return getNewAt().intValue() > 99 ? "99+" : String.valueOf(getNewAt());
    }

    @e
    public final String getLastContent() {
        return this.lastContent;
    }

    @d
    public final String getLikeNumStr() {
        return getNewLike().intValue() > 99 ? "99+" : String.valueOf(getNewLike());
    }

    @e
    public final Integer getNewAt() {
        Integer num = this.newAt;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @e
    public final Integer getNewLike() {
        Integer num = this.newLike;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @e
    public final Integer getNewReply() {
        Integer num = this.newReply;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @d
    public final String getReplyNumStr() {
        return getNewReply().intValue() > 99 ? "99+" : String.valueOf(getNewReply());
    }

    @e
    public final String getTotalUnreadCount() {
        return this.totalUnreadCount;
    }

    public final void setLastContent(@e String str) {
        this.lastContent = str;
    }

    public final void setNewAt(@e Integer num) {
        this.newAt = num;
    }

    public final void setNewLike(@e Integer num) {
        this.newLike = num;
    }

    public final void setNewReply(@e Integer num) {
        this.newReply = num;
    }

    public final void setTotalUnreadCount(@e String str) {
        this.totalUnreadCount = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(1);
    }
}
