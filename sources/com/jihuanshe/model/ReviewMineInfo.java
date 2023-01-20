package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.k;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ReviewMineInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ReviewMineInfo> CREATOR = new Creator();
    @d
    private final String avatar;
    @d
    private final String content;
    @e.j.e.r.c("created_at")
    @d
    private final String createdAt;
    @e.j.e.r.c("diff_time")
    @e
    private final String diffTime;
    @a
    @e
    private CharSequence handleContent;
    @e.j.e.r.c("is_like")
    @e
    private Boolean isLike;
    @e.j.e.r.c("like_count")
    @e
    private Integer likeCount;
    @e.j.e.r.c("reply_count")
    @e
    private final Integer replyCount;
    @e.j.e.r.c("review_id")
    private final int reviewId;
    private final float score;
    @e.j.e.r.c("updated_at")
    @d
    private final String updatedAt;
    @e.j.e.r.c("user_id")
    private final int userID;
    @d
    private final String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReviewMineInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReviewMineInfo createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ReviewMineInfo(readString, readString2, readString3, readString4, valueOf, parcel.readInt(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readFloat(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReviewMineInfo[] newArray(int i2) {
            return new ReviewMineInfo[i2];
        }
    }

    public ReviewMineInfo(@d String str, @d String str2, @e String str3, @d String str4, @e Boolean bool, int i2, @e Integer num, @e Integer num2, float f2, @d String str5, int i3, @d String str6) {
        this.avatar = str;
        this.content = str2;
        this.diffTime = str3;
        this.createdAt = str4;
        this.isLike = bool;
        this.reviewId = i2;
        this.likeCount = num;
        this.replyCount = num2;
        this.score = f2;
        this.updatedAt = str5;
        this.userID = i3;
        this.username = str6;
    }

    @d
    public final String component1() {
        return this.avatar;
    }

    @d
    public final String component10() {
        return this.updatedAt;
    }

    public final int component11() {
        return this.userID;
    }

    @d
    public final String component12() {
        return this.username;
    }

    @d
    public final String component2() {
        return this.content;
    }

    @e
    public final String component3() {
        return this.diffTime;
    }

    @d
    public final String component4() {
        return this.createdAt;
    }

    @e
    public final Boolean component5() {
        return this.isLike;
    }

    public final int component6() {
        return this.reviewId;
    }

    @e
    public final Integer component7() {
        return this.likeCount;
    }

    @e
    public final Integer component8() {
        return this.replyCount;
    }

    public final float component9() {
        return this.score;
    }

    @d
    public final ReviewMineInfo copy(@d String str, @d String str2, @e String str3, @d String str4, @e Boolean bool, int i2, @e Integer num, @e Integer num2, float f2, @d String str5, int i3, @d String str6) {
        return new ReviewMineInfo(str, str2, str3, str4, bool, i2, num, num2, f2, str5, i3, str6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReviewMineInfo) {
            ReviewMineInfo reviewMineInfo = (ReviewMineInfo) obj;
            return f0.g(this.avatar, reviewMineInfo.avatar) && f0.g(this.content, reviewMineInfo.content) && f0.g(this.diffTime, reviewMineInfo.diffTime) && f0.g(this.createdAt, reviewMineInfo.createdAt) && f0.g(this.isLike, reviewMineInfo.isLike) && this.reviewId == reviewMineInfo.reviewId && f0.g(this.likeCount, reviewMineInfo.likeCount) && f0.g(this.replyCount, reviewMineInfo.replyCount) && f0.g(Float.valueOf(this.score), Float.valueOf(reviewMineInfo.score)) && f0.g(this.updatedAt, reviewMineInfo.updatedAt) && this.userID == reviewMineInfo.userID && f0.g(this.username, reviewMineInfo.username);
        }
        return false;
    }

    @d
    public final String getAvatar() {
        return this.avatar;
    }

    @d
    public final String getContent() {
        return this.content;
    }

    @d
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final String getDiffTime() {
        return this.diffTime;
    }

    @e
    public final CharSequence getHandleContent() {
        return this.handleContent;
    }

    @e
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    @d
    public final String getLikeCountStr() {
        if (this.likeCount == null) {
            return "0";
        }
        boolean z = false;
        k kVar = new k(0, 999);
        Integer num = this.likeCount;
        if (num != null && kVar.m(num.intValue())) {
            z = true;
        }
        if (z) {
            return String.valueOf(this.likeCount);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.likeCount.intValue() / 1000);
        sb.append('k');
        return sb.toString();
    }

    @e
    public final Integer getReplyCount() {
        return this.replyCount;
    }

    public final int getReviewId() {
        return this.reviewId;
    }

    public final float getScore() {
        return this.score;
    }

    @d
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    public final int getUserID() {
        return this.userID;
    }

    @d
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        int hashCode = ((this.avatar.hashCode() * 31) + this.content.hashCode()) * 31;
        String str = this.diffTime;
        int hashCode2 = (((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.createdAt.hashCode()) * 31;
        Boolean bool = this.isLike;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.reviewId) * 31;
        Integer num = this.likeCount;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.replyCount;
        return ((((((((hashCode4 + (num2 != null ? num2.hashCode() : 0)) * 31) + Float.floatToIntBits(this.score)) * 31) + this.updatedAt.hashCode()) * 31) + this.userID) * 31) + this.username.hashCode();
    }

    @e
    public final Boolean isLike() {
        return this.isLike;
    }

    public final void setHandleContent(@e CharSequence charSequence) {
        this.handleContent = charSequence;
    }

    public final void setLike(@e Boolean bool) {
        this.isLike = bool;
    }

    public final void setLikeCount(@e Integer num) {
        this.likeCount = num;
    }

    @d
    public String toString() {
        return "ReviewMineInfo(avatar=" + this.avatar + ", content=" + this.content + ", diffTime=" + ((Object) this.diffTime) + ", createdAt=" + this.createdAt + ", isLike=" + this.isLike + ", reviewId=" + this.reviewId + ", likeCount=" + this.likeCount + ", replyCount=" + this.replyCount + ", score=" + this.score + ", updatedAt=" + this.updatedAt + ", userID=" + this.userID + ", username=" + this.username + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        parcel.writeString(this.content);
        parcel.writeString(this.diffTime);
        parcel.writeString(this.createdAt);
        Boolean bool = this.isLike;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeInt(this.reviewId);
        Integer num = this.likeCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.replyCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeFloat(this.score);
        parcel.writeString(this.updatedAt);
        parcel.writeInt(this.userID);
        parcel.writeString(this.username);
    }

    public /* synthetic */ ReviewMineInfo(String str, String str2, String str3, String str4, Boolean bool, int i2, Integer num, Integer num2, float f2, String str5, int i3, String str6, int i4, u uVar) {
        this(str, str2, (i4 & 4) != 0 ? "" : str3, str4, (i4 & 16) != 0 ? null : bool, i2, (i4 & 64) != 0 ? 0 : num, (i4 & 128) != 0 ? null : num2, f2, str5, i3, str6);
    }
}
