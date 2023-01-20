package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.o2.k;
import h.r0;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class ReviewListInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ReviewListInfo> CREATOR = new Creator();
    @e
    private final String avatar;
    @e
    private final String content;
    @e.j.e.r.c("created_at")
    @e
    private final String createdAt;
    @e.j.e.r.c("card_version_id")
    @e
    private final Integer cvId;
    @e.j.e.r.c("card_version_number")
    @e
    private final String cvNumber;
    @e.j.e.r.c("card_version_rarity")
    @e
    private final String cvRarity;
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
    @e.j.e.r.c("reply_list_count")
    @e
    private final Integer replyListCount;
    @e.j.e.r.c("reply_lists")
    @e
    private final List<ReplyListInfo> replyLists;
    @e.j.e.r.c("review_id")
    @e
    private final Integer reviewID;
    @e
    private final Integer score;
    @e.j.e.r.c("user_id")
    @e
    private final Integer userID;
    @e
    private final String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReviewListInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReviewListInfo createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            Boolean valueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList.add(parcel.readInt() == 0 ? null : ReplyListInfo.CREATOR.createFromParcel(parcel));
                }
            }
            return new ReviewListInfo(readString, valueOf, readString2, readString3, readString4, valueOf2, valueOf3, valueOf4, arrayList, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReviewListInfo[] newArray(int i2) {
            return new ReviewListInfo[i2];
        }
    }

    public ReviewListInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 32767, null);
    }

    public ReviewListInfo(@e String str, @e Integer num, @e String str2, @e String str3, @e String str4, @e Boolean bool, @e Integer num2, @e Integer num3, @e List<ReplyListInfo> list, @e Integer num4, @e String str5, @e Integer num5, @e Integer num6, @e String str6, @e String str7) {
        this.avatar = str;
        this.reviewID = num;
        this.content = str2;
        this.createdAt = str3;
        this.diffTime = str4;
        this.isLike = bool;
        this.likeCount = num2;
        this.replyListCount = num3;
        this.replyLists = list;
        this.userID = num4;
        this.username = str5;
        this.score = num5;
        this.cvId = num6;
        this.cvNumber = str6;
        this.cvRarity = str7;
    }

    @e
    public final String component1() {
        return this.avatar;
    }

    @e
    public final Integer component10() {
        return this.userID;
    }

    @e
    public final String component11() {
        return this.username;
    }

    @e
    public final Integer component12() {
        return this.score;
    }

    @e
    public final Integer component13() {
        return this.cvId;
    }

    @e
    public final String component14() {
        return this.cvNumber;
    }

    @e
    public final String component15() {
        return this.cvRarity;
    }

    @e
    public final Integer component2() {
        return this.reviewID;
    }

    @e
    public final String component3() {
        return this.content;
    }

    @e
    public final String component4() {
        return this.createdAt;
    }

    @e
    public final String component5() {
        return this.diffTime;
    }

    @e
    public final Boolean component6() {
        return this.isLike;
    }

    @e
    public final Integer component7() {
        return this.likeCount;
    }

    @e
    public final Integer component8() {
        return this.replyListCount;
    }

    @e
    public final List<ReplyListInfo> component9() {
        return this.replyLists;
    }

    @d
    public final ReviewListInfo copy(@e String str, @e Integer num, @e String str2, @e String str3, @e String str4, @e Boolean bool, @e Integer num2, @e Integer num3, @e List<ReplyListInfo> list, @e Integer num4, @e String str5, @e Integer num5, @e Integer num6, @e String str6, @e String str7) {
        return new ReviewListInfo(str, num, str2, str3, str4, bool, num2, num3, list, num4, str5, num5, num6, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReviewListInfo) {
            ReviewListInfo reviewListInfo = (ReviewListInfo) obj;
            return f0.g(this.avatar, reviewListInfo.avatar) && f0.g(this.reviewID, reviewListInfo.reviewID) && f0.g(this.content, reviewListInfo.content) && f0.g(this.createdAt, reviewListInfo.createdAt) && f0.g(this.diffTime, reviewListInfo.diffTime) && f0.g(this.isLike, reviewListInfo.isLike) && f0.g(this.likeCount, reviewListInfo.likeCount) && f0.g(this.replyListCount, reviewListInfo.replyListCount) && f0.g(this.replyLists, reviewListInfo.replyLists) && f0.g(this.userID, reviewListInfo.userID) && f0.g(this.username, reviewListInfo.username) && f0.g(this.score, reviewListInfo.score) && f0.g(this.cvId, reviewListInfo.cvId) && f0.g(this.cvNumber, reviewListInfo.cvNumber) && f0.g(this.cvRarity, reviewListInfo.cvRarity);
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
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final Integer getCvId() {
        return this.cvId;
    }

    @e
    public final String getCvNumber() {
        return this.cvNumber;
    }

    @e
    public final String getCvRarity() {
        return this.cvRarity;
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
    public final Integer getReplyListCount() {
        return this.replyListCount;
    }

    @e
    public final List<ReplyListInfo> getReplyLists() {
        return this.replyLists;
    }

    @e
    public final Integer getReviewID() {
        return this.reviewID;
    }

    @e
    public final Integer getScore() {
        return this.score;
    }

    @e
    public final Float getScoreNum() {
        try {
            Result.a aVar = Result.Companion;
            Integer score = getScore();
            if (score == null) {
                return null;
            }
            return Float.valueOf(score.intValue());
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return null;
        }
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
        Integer num = this.reviewID;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.content;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.createdAt;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.diffTime;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Boolean bool = this.isLike;
        int hashCode6 = (hashCode5 + (bool == null ? 0 : bool.hashCode())) * 31;
        Integer num2 = this.likeCount;
        int hashCode7 = (hashCode6 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.replyListCount;
        int hashCode8 = (hashCode7 + (num3 == null ? 0 : num3.hashCode())) * 31;
        List<ReplyListInfo> list = this.replyLists;
        int hashCode9 = (hashCode8 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num4 = this.userID;
        int hashCode10 = (hashCode9 + (num4 == null ? 0 : num4.hashCode())) * 31;
        String str5 = this.username;
        int hashCode11 = (hashCode10 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num5 = this.score;
        int hashCode12 = (hashCode11 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.cvId;
        int hashCode13 = (hashCode12 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str6 = this.cvNumber;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.cvRarity;
        return hashCode14 + (str7 != null ? str7.hashCode() : 0);
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
        return "ReviewListInfo(avatar=" + ((Object) this.avatar) + ", reviewID=" + this.reviewID + ", content=" + ((Object) this.content) + ", createdAt=" + ((Object) this.createdAt) + ", diffTime=" + ((Object) this.diffTime) + ", isLike=" + this.isLike + ", likeCount=" + this.likeCount + ", replyListCount=" + this.replyListCount + ", replyLists=" + this.replyLists + ", userID=" + this.userID + ", username=" + ((Object) this.username) + ", score=" + this.score + ", cvId=" + this.cvId + ", cvNumber=" + ((Object) this.cvNumber) + ", cvRarity=" + ((Object) this.cvRarity) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        Integer num = this.reviewID;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.content);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.diffTime);
        Boolean bool = this.isLike;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.likeCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.replyListCount;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        List<ReplyListInfo> list = this.replyLists;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ReplyListInfo replyListInfo : list) {
                if (replyListInfo == null) {
                    parcel.writeInt(0);
                } else {
                    parcel.writeInt(1);
                    replyListInfo.writeToParcel(parcel, i2);
                }
            }
        }
        Integer num4 = this.userID;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.username);
        Integer num5 = this.score;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        Integer num6 = this.cvId;
        if (num6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        }
        parcel.writeString(this.cvNumber);
        parcel.writeString(this.cvRarity);
    }

    public /* synthetic */ ReviewListInfo(String str, Integer num, String str2, String str3, String str4, Boolean bool, Integer num2, Integer num3, List list, Integer num4, String str5, Integer num5, Integer num6, String str6, String str7, int i2, u uVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? 0 : num, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : bool, (i2 & 64) != 0 ? 0 : num2, (i2 & 128) != 0 ? 0 : num3, (i2 & 256) != 0 ? null : list, (i2 & 512) != 0 ? 0 : num4, (i2 & 1024) == 0 ? str5 : "", (i2 & 2048) != 0 ? 0 : num5, (i2 & 4096) != 0 ? 0 : num6, (i2 & 8192) != 0 ? null : str6, (i2 & 16384) == 0 ? str7 : null);
    }
}
