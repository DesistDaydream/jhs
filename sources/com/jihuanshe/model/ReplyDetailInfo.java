package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.f0;
import h.k2.v.u;
import h.r0;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class ReplyDetailInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ReplyDetailInfo> CREATOR = new Creator();
    @d
    private final String avatar;
    @e
    private String content;
    @e.j.e.r.c("created_at")
    @d
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
    @e.j.e.r.c("is_delete")
    @e
    private final Boolean delete;
    @e.j.e.r.c("diff_time")
    @e
    private final String diffTime;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private final String gameSubKey;
    @e
    private CharSequence handleContent;
    @e.j.e.r.c("review_id")
    private final int id;
    @e.j.e.r.c("is_like")
    private boolean isLike;
    @e.j.e.r.c("like_count")
    private int likeCount;
    @e.j.e.r.c("reply_user_id")
    @e
    private final Integer replyUid;
    @e.j.e.r.c("reply_username")
    @e
    private final String replyUserName;
    @e
    private final Integer score;
    @e.j.e.r.c("user_id")
    private final int userID;
    @d
    private final String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReplyDetailInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyDetailInfo createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt = parcel.readInt();
            boolean z = parcel.readInt() != 0;
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            String readString5 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ReplyDetailInfo(readString, readString2, readString3, readString4, readInt, z, readInt2, readInt3, readString5, valueOf2, valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyDetailInfo[] newArray(int i2) {
            return new ReplyDetailInfo[i2];
        }
    }

    public ReplyDetailInfo(@d String str, @e String str2, @e String str3, @d String str4, int i2, boolean z, int i3, int i4, @d String str5, @e Integer num, @e Boolean bool, @e Integer num2, @e String str6, @e Integer num3, @e String str7, @e String str8, @e String str9, @e String str10) {
        this.avatar = str;
        this.content = str2;
        this.diffTime = str3;
        this.createdAt = str4;
        this.id = i2;
        this.isLike = z;
        this.likeCount = i3;
        this.userID = i4;
        this.username = str5;
        this.score = num;
        this.delete = bool;
        this.replyUid = num2;
        this.replyUserName = str6;
        this.cvId = num3;
        this.cvNumber = str7;
        this.cvRarity = str8;
        this.gameKey = str9;
        this.gameSubKey = str10;
    }

    @d
    public final String component1() {
        return this.avatar;
    }

    @e
    public final Integer component10() {
        return this.score;
    }

    @e
    public final Boolean component11() {
        return this.delete;
    }

    @e
    public final Integer component12() {
        return this.replyUid;
    }

    @e
    public final String component13() {
        return this.replyUserName;
    }

    @e
    public final Integer component14() {
        return this.cvId;
    }

    @e
    public final String component15() {
        return this.cvNumber;
    }

    @e
    public final String component16() {
        return this.cvRarity;
    }

    @e
    public final String component17() {
        return this.gameKey;
    }

    @e
    public final String component18() {
        return this.gameSubKey;
    }

    @e
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

    public final int component5() {
        return this.id;
    }

    public final boolean component6() {
        return this.isLike;
    }

    public final int component7() {
        return this.likeCount;
    }

    public final int component8() {
        return this.userID;
    }

    @d
    public final String component9() {
        return this.username;
    }

    @d
    public final ReplyDetailInfo copy(@d String str, @e String str2, @e String str3, @d String str4, int i2, boolean z, int i3, int i4, @d String str5, @e Integer num, @e Boolean bool, @e Integer num2, @e String str6, @e Integer num3, @e String str7, @e String str8, @e String str9, @e String str10) {
        return new ReplyDetailInfo(str, str2, str3, str4, i2, z, i3, i4, str5, num, bool, num2, str6, num3, str7, str8, str9, str10);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(ReplyDetailInfo.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.ReplyDetailInfo");
            return this.id == ((ReplyDetailInfo) obj).id;
        }
        return false;
    }

    @d
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final String getCContent(@e Integer num) {
        Integer num2 = this.replyUid;
        if (num2 != null && !f0.g(num, num2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("回复");
            StringUtil stringUtil = StringUtil.a;
            int intValue = this.replyUid.intValue();
            String str = this.replyUserName;
            if (str == null) {
                str = "";
            }
            sb.append(stringUtil.d(intValue, str));
            sb.append((char) 65306);
            sb.append((Object) this.content);
            return sb.toString();
        }
        return this.content;
    }

    @e
    public final String getContent() {
        return this.content;
    }

    @d
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
    public final Boolean getDelete() {
        return this.delete;
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

    public final int getId() {
        return this.id;
    }

    public final int getLikeCount() {
        return this.likeCount;
    }

    @e
    public final Integer getReplyUid() {
        return this.replyUid;
    }

    @e
    public final String getReplyUserName() {
        return this.replyUserName;
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

    public final int getUserID() {
        return this.userID;
    }

    @d
    public final String getUsername() {
        return this.username;
    }

    public int hashCode() {
        return this.id;
    }

    public final boolean isLike() {
        return this.isLike;
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

    @d
    public String toString() {
        return "ReplyDetailInfo(avatar=" + this.avatar + ", content=" + ((Object) this.content) + ", diffTime=" + ((Object) this.diffTime) + ", createdAt=" + this.createdAt + ", id=" + this.id + ", isLike=" + this.isLike + ", likeCount=" + this.likeCount + ", userID=" + this.userID + ", username=" + this.username + ", score=" + this.score + ", delete=" + this.delete + ", replyUid=" + this.replyUid + ", replyUserName=" + ((Object) this.replyUserName) + ", cvId=" + this.cvId + ", cvNumber=" + ((Object) this.cvNumber) + ", cvRarity=" + ((Object) this.cvRarity) + ", gameKey=" + ((Object) this.gameKey) + ", gameSubKey=" + ((Object) this.gameSubKey) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        parcel.writeString(this.content);
        parcel.writeString(this.diffTime);
        parcel.writeString(this.createdAt);
        parcel.writeInt(this.id);
        parcel.writeInt(this.isLike ? 1 : 0);
        parcel.writeInt(this.likeCount);
        parcel.writeInt(this.userID);
        parcel.writeString(this.username);
        Integer num = this.score;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.delete;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.replyUid;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.replyUserName);
        Integer num3 = this.cvId;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.cvNumber);
        parcel.writeString(this.cvRarity);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
    }

    public /* synthetic */ ReplyDetailInfo(String str, String str2, String str3, String str4, int i2, boolean z, int i3, int i4, String str5, Integer num, Boolean bool, Integer num2, String str6, Integer num3, String str7, String str8, String str9, String str10, int i5, u uVar) {
        this(str, (i5 & 2) != 0 ? null : str2, (i5 & 4) != 0 ? "" : str3, str4, i2, z, i3, i4, str5, (i5 & 512) != 0 ? 0 : num, (i5 & 1024) != 0 ? null : bool, (i5 & 2048) != 0 ? null : num2, (i5 & 4096) != 0 ? null : str6, (i5 & 8192) != 0 ? 0 : num3, (i5 & 16384) != 0 ? null : str7, (32768 & i5) != 0 ? null : str8, (65536 & i5) != 0 ? null : str9, (i5 & 131072) != 0 ? null : str10);
    }
}
