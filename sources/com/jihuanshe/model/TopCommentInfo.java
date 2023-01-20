package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class TopCommentInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<TopCommentInfo> CREATOR = new Creator();
    @e
    private String avatar;
    @e.j.e.r.c("card_version_id")
    @e
    private final Integer cardVersionID;
    @e
    private String content;
    @e.j.e.r.c("created_at")
    @e
    private final String createdAt;
    @e.j.e.r.c("diff_time")
    @e
    private final String diffTime;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private final String gameSubKey;
    @a
    @e
    private CharSequence handleContent;
    @e.j.e.r.c("is_like")
    private boolean isLike;
    @e.j.e.r.c("like_count")
    private int likeCount;
    @e.j.e.r.c("pack_id")
    @e
    private final Integer packID;
    @e.j.e.r.c("parent_review_id")
    @e
    private final Integer parentReviewID;
    @e.j.e.r.c("reply_count")
    @e
    private final Integer replyCount;
    @e.j.e.r.c("reply_lists")
    @e
    private final List<ReplyList> replyLists;
    @e.j.e.r.c("review_id")
    private final int reviewId;
    @e
    private final String type;
    @e.j.e.r.c("updated_at")
    @e
    private final String updatedAt;
    @e.j.e.r.c("user_id")
    @e
    private final Integer userID;
    @e
    private String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<TopCommentInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final TopCommentInfo createFromParcel(@d Parcel parcel) {
            Integer num;
            ArrayList arrayList;
            int i2;
            Integer num2;
            ReplyList createFromParcel;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int i3 = 0;
            boolean z = parcel.readInt() != 0;
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                num = valueOf4;
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                while (i3 != readInt3) {
                    if (parcel.readInt() == 0) {
                        i2 = readInt3;
                        num2 = valueOf4;
                        createFromParcel = null;
                    } else {
                        i2 = readInt3;
                        num2 = valueOf4;
                        createFromParcel = ReplyList.CREATOR.createFromParcel(parcel);
                    }
                    arrayList2.add(createFromParcel);
                    i3++;
                    readInt3 = i2;
                    valueOf4 = num2;
                }
                num = valueOf4;
                arrayList = arrayList2;
            }
            return new TopCommentInfo(readString, readString2, valueOf, readString3, readString4, readString5, readString6, readInt, readInt2, z, valueOf2, valueOf3, num, arrayList, parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final TopCommentInfo[] newArray(int i2) {
            return new TopCommentInfo[i2];
        }
    }

    public TopCommentInfo(@e String str, @e String str2, @e Integer num, @e String str3, @e String str4, @e String str5, @e String str6, int i2, int i3, boolean z, @e Integer num2, @e Integer num3, @e Integer num4, @e List<ReplyList> list, @e String str7, @e String str8, @e Integer num5, @e String str9) {
        this.avatar = str;
        this.diffTime = str2;
        this.cardVersionID = num;
        this.content = str3;
        this.createdAt = str4;
        this.gameKey = str5;
        this.gameSubKey = str6;
        this.reviewId = i2;
        this.likeCount = i3;
        this.isLike = z;
        this.packID = num2;
        this.parentReviewID = num3;
        this.replyCount = num4;
        this.replyLists = list;
        this.type = str7;
        this.updatedAt = str8;
        this.userID = num5;
        this.username = str9;
    }

    @e
    public final String component1() {
        return this.avatar;
    }

    public final boolean component10() {
        return this.isLike;
    }

    @e
    public final Integer component11() {
        return this.packID;
    }

    @e
    public final Integer component12() {
        return this.parentReviewID;
    }

    @e
    public final Integer component13() {
        return this.replyCount;
    }

    @e
    public final List<ReplyList> component14() {
        return this.replyLists;
    }

    @e
    public final String component15() {
        return this.type;
    }

    @e
    public final String component16() {
        return this.updatedAt;
    }

    @e
    public final Integer component17() {
        return this.userID;
    }

    @e
    public final String component18() {
        return this.username;
    }

    @e
    public final String component2() {
        return this.diffTime;
    }

    @e
    public final Integer component3() {
        return this.cardVersionID;
    }

    @e
    public final String component4() {
        return this.content;
    }

    @e
    public final String component5() {
        return this.createdAt;
    }

    @e
    public final String component6() {
        return this.gameKey;
    }

    @e
    public final String component7() {
        return this.gameSubKey;
    }

    public final int component8() {
        return this.reviewId;
    }

    public final int component9() {
        return this.likeCount;
    }

    @d
    public final TopCommentInfo copy(@e String str, @e String str2, @e Integer num, @e String str3, @e String str4, @e String str5, @e String str6, int i2, int i3, boolean z, @e Integer num2, @e Integer num3, @e Integer num4, @e List<ReplyList> list, @e String str7, @e String str8, @e Integer num5, @e String str9) {
        return new TopCommentInfo(str, str2, num, str3, str4, str5, str6, i2, i3, z, num2, num3, num4, list, str7, str8, num5, str9);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof TopCommentInfo) {
            TopCommentInfo topCommentInfo = (TopCommentInfo) obj;
            return f0.g(this.avatar, topCommentInfo.avatar) && f0.g(this.diffTime, topCommentInfo.diffTime) && f0.g(this.cardVersionID, topCommentInfo.cardVersionID) && f0.g(this.content, topCommentInfo.content) && f0.g(this.createdAt, topCommentInfo.createdAt) && f0.g(this.gameKey, topCommentInfo.gameKey) && f0.g(this.gameSubKey, topCommentInfo.gameSubKey) && this.reviewId == topCommentInfo.reviewId && this.likeCount == topCommentInfo.likeCount && this.isLike == topCommentInfo.isLike && f0.g(this.packID, topCommentInfo.packID) && f0.g(this.parentReviewID, topCommentInfo.parentReviewID) && f0.g(this.replyCount, topCommentInfo.replyCount) && f0.g(this.replyLists, topCommentInfo.replyLists) && f0.g(this.type, topCommentInfo.type) && f0.g(this.updatedAt, topCommentInfo.updatedAt) && f0.g(this.userID, topCommentInfo.userID) && f0.g(this.username, topCommentInfo.username);
        }
        return false;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final Integer getCardVersionID() {
        return this.cardVersionID;
    }

    @e
    public final String getContent() {
        return this.content;
    }

    @e
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final String getDiffTime() {
        return this.diffTime;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @e
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    @e
    public final CharSequence getHandleContent() {
        return this.handleContent;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @d
    public final String getLikeCountStr() {
        int i2 = this.likeCount;
        if (i2 < 1) {
            return "0";
        }
        if (i2 < 1000) {
            return String.valueOf(i2);
        }
        if (i2 == 1000) {
            return "1k";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.likeCount / 1000);
        sb.append('k');
        return sb.toString();
    }

    @d
    public final String getNameStr() {
        return f0.C(this.username, com.xiaomi.mipush.sdk.Constants.COLON_SEPARATOR);
    }

    @e
    public final Integer getPackID() {
        return this.packID;
    }

    @e
    public final Integer getParentReviewID() {
        return this.parentReviewID;
    }

    @e
    public final Integer getReplyCount() {
        return this.replyCount;
    }

    @e
    public final List<ReplyList> getReplyLists() {
        return this.replyLists;
    }

    public final int getReviewId() {
        return this.reviewId;
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final String getUpdatedAt() {
        return this.updatedAt;
    }

    @e
    public final Integer getUserID() {
        return this.userID;
    }

    @e
    public final String getUsername() {
        return this.username;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.diffTime;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.cardVersionID;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.content;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.createdAt;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gameKey;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.gameSubKey;
        int hashCode7 = (((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.reviewId) * 31) + this.likeCount) * 31;
        boolean z = this.isLike;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode7 + i2) * 31;
        Integer num2 = this.packID;
        int hashCode8 = (i3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.parentReviewID;
        int hashCode9 = (hashCode8 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.replyCount;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        List<ReplyList> list = this.replyLists;
        int hashCode11 = (hashCode10 + (list == null ? 0 : list.hashCode())) * 31;
        String str7 = this.type;
        int hashCode12 = (hashCode11 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.updatedAt;
        int hashCode13 = (hashCode12 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Integer num5 = this.userID;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str9 = this.username;
        return hashCode14 + (str9 != null ? str9.hashCode() : 0);
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final void setAvatar(@e String str) {
        this.avatar = str;
    }

    public final void setContent(@e String str) {
        this.content = str;
    }

    public final void setHandleContent(@e CharSequence charSequence) {
        this.handleContent = charSequence;
    }

    public final void setLike(boolean z) {
        this.isLike = z;
    }

    public final void setLikeCount(int i2) {
        this.likeCount = i2;
    }

    public final void setUsername(@e String str) {
        this.username = str;
    }

    @d
    public String toString() {
        return "TopCommentInfo(avatar=" + ((Object) this.avatar) + ", diffTime=" + ((Object) this.diffTime) + ", cardVersionID=" + this.cardVersionID + ", content=" + ((Object) this.content) + ", createdAt=" + ((Object) this.createdAt) + ", gameKey=" + ((Object) this.gameKey) + ", gameSubKey=" + ((Object) this.gameSubKey) + ", reviewId=" + this.reviewId + ", likeCount=" + this.likeCount + ", isLike=" + this.isLike + ", packID=" + this.packID + ", parentReviewID=" + this.parentReviewID + ", replyCount=" + this.replyCount + ", replyLists=" + this.replyLists + ", type=" + ((Object) this.type) + ", updatedAt=" + ((Object) this.updatedAt) + ", userID=" + this.userID + ", username=" + ((Object) this.username) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        parcel.writeString(this.diffTime);
        Integer num = this.cardVersionID;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.content);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeInt(this.reviewId);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.isLike ? 1 : 0);
        Integer num2 = this.packID;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.parentReviewID;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.replyCount;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        List<ReplyList> list = this.replyLists;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ReplyList replyList : list) {
                if (replyList == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    replyList.writeToParcel(parcel, i2);
                }
            }
        }
        parcel.writeString(this.type);
        parcel.writeString(this.updatedAt);
        Integer num5 = this.userID;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        parcel.writeString(this.username);
    }

    public /* synthetic */ TopCommentInfo(String str, String str2, Integer num, String str3, String str4, String str5, String str6, int i2, int i3, boolean z, Integer num2, Integer num3, Integer num4, List list, String str7, String str8, Integer num5, String str9, int i4, u uVar) {
        this((i4 & 1) != 0 ? "" : str, (i4 & 2) != 0 ? "" : str2, (i4 & 4) != 0 ? null : num, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? "" : str5, (i4 & 64) != 0 ? "" : str6, i2, (i4 & 256) != 0 ? 0 : i3, z, (i4 & 1024) != 0 ? 0 : num2, (i4 & 2048) != 0 ? 0 : num3, (i4 & 4096) != 0 ? 0 : num4, (i4 & 8192) != 0 ? null : list, (i4 & 16384) != 0 ? "" : str7, (32768 & i4) != 0 ? null : str8, (65536 & i4) != 0 ? 0 : num5, (i4 & 131072) != 0 ? "" : str9);
    }
}
