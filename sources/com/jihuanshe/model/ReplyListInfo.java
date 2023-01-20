package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import android.text.style.StyleSpan;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ReplyListInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ReplyListInfo> CREATOR = new Creator();
    @e
    private final String avatar;
    @e
    private final String content;
    @a
    @e
    private CharSequence handleContent;
    @e.j.e.r.c("reply_user_id")
    @e
    private final Integer replyUserID;
    @e.j.e.r.c("reply_username")
    @e
    private final String replyUsername;
    @e.j.e.r.c("review_id")
    @e
    private final Integer reviewID;
    @e.j.e.r.c("user_id")
    @e
    private final Integer userID;
    @e
    private final String username;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReplyListInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyListInfo createFromParcel(@d Parcel parcel) {
            return new ReplyListInfo(parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReplyListInfo[] newArray(int i2) {
            return new ReplyListInfo[i2];
        }
    }

    public ReplyListInfo() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public ReplyListInfo(@e String str, @e String str2, @e Integer num, @e String str3, @e Integer num2, @e Integer num3, @e String str4) {
        this.avatar = str;
        this.content = str2;
        this.replyUserID = num;
        this.replyUsername = str3;
        this.reviewID = num2;
        this.userID = num3;
        this.username = str4;
    }

    public static /* synthetic */ ReplyListInfo copy$default(ReplyListInfo replyListInfo, String str, String str2, Integer num, String str3, Integer num2, Integer num3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = replyListInfo.avatar;
        }
        if ((i2 & 2) != 0) {
            str2 = replyListInfo.content;
        }
        String str5 = str2;
        if ((i2 & 4) != 0) {
            num = replyListInfo.replyUserID;
        }
        Integer num4 = num;
        if ((i2 & 8) != 0) {
            str3 = replyListInfo.replyUsername;
        }
        String str6 = str3;
        if ((i2 & 16) != 0) {
            num2 = replyListInfo.reviewID;
        }
        Integer num5 = num2;
        if ((i2 & 32) != 0) {
            num3 = replyListInfo.userID;
        }
        Integer num6 = num3;
        if ((i2 & 64) != 0) {
            str4 = replyListInfo.username;
        }
        return replyListInfo.copy(str, str5, num4, str6, num5, num6, str4);
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
        return this.replyUserID;
    }

    @e
    public final String component4() {
        return this.replyUsername;
    }

    @e
    public final Integer component5() {
        return this.reviewID;
    }

    @e
    public final Integer component6() {
        return this.userID;
    }

    @e
    public final String component7() {
        return this.username;
    }

    @d
    public final ReplyListInfo copy(@e String str, @e String str2, @e Integer num, @e String str3, @e Integer num2, @e Integer num3, @e String str4) {
        return new ReplyListInfo(str, str2, num, str3, num2, num3, str4);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReplyListInfo) {
            ReplyListInfo replyListInfo = (ReplyListInfo) obj;
            return f0.g(this.avatar, replyListInfo.avatar) && f0.g(this.content, replyListInfo.content) && f0.g(this.replyUserID, replyListInfo.replyUserID) && f0.g(this.replyUsername, replyListInfo.replyUsername) && f0.g(this.reviewID, replyListInfo.reviewID) && f0.g(this.userID, replyListInfo.userID) && f0.g(this.username, replyListInfo.username);
        }
        return false;
    }

    @e
    public final String getAvatar() {
        return this.avatar;
    }

    @e
    public final String getCContent(@e Integer num) {
        Integer num2 = this.replyUserID;
        if (num2 != null && !f0.g(num, num2)) {
            StringBuilder sb = new StringBuilder();
            sb.append("回复");
            StringUtil stringUtil = StringUtil.a;
            int intValue = this.replyUserID.intValue();
            String str = this.replyUsername;
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

    @e
    public final CharSequence getHandleContent() {
        return this.handleContent;
    }

    @d
    public final CharSequence getHandleContentStr() {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(f0.C(this.username, "："));
        int k2 = Res.k(R.color.black);
        String str = this.username;
        SpannableStringBuilder e2 = e.l.h.f.e.e(spannableStringBuilder, k2, 0, str == null ? null : Integer.valueOf(str.length()), new ReplyListInfo$getHandleContentStr$result$1(this));
        e2.setSpan(new StyleSpan(1), 0, e2.length(), 33);
        e2.append(this.handleContent);
        return e2;
    }

    @e
    public final Integer getReplyUserID() {
        return this.replyUserID;
    }

    @e
    public final String getReplyUsername() {
        return this.replyUsername;
    }

    @e
    public final Integer getReviewID() {
        return this.reviewID;
    }

    @e
    public final Integer getUserID() {
        return this.userID;
    }

    @e
    public final String getUsername() {
        return this.username;
    }

    @d
    public final String getUsernameStr() {
        return f0.C(this.username, "：");
    }

    public int hashCode() {
        String str = this.avatar;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.content;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Integer num = this.replyUserID;
        int hashCode3 = (hashCode2 + (num == null ? 0 : num.hashCode())) * 31;
        String str3 = this.replyUsername;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num2 = this.reviewID;
        int hashCode5 = (hashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.userID;
        int hashCode6 = (hashCode5 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str4 = this.username;
        return hashCode6 + (str4 != null ? str4.hashCode() : 0);
    }

    public final void setHandleContent(@e CharSequence charSequence) {
        this.handleContent = charSequence;
    }

    @d
    public String toString() {
        return "ReplyListInfo(avatar=" + ((Object) this.avatar) + ", content=" + ((Object) this.content) + ", replyUserID=" + this.replyUserID + ", replyUsername=" + ((Object) this.replyUsername) + ", reviewID=" + this.reviewID + ", userID=" + this.userID + ", username=" + ((Object) this.username) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avatar);
        parcel.writeString(this.content);
        Integer num = this.replyUserID;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.replyUsername);
        Integer num2 = this.reviewID;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.userID;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.username);
    }

    public /* synthetic */ ReplyListInfo(String str, String str2, Integer num, String str3, Integer num2, Integer num3, String str4, int i2, u uVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? 0 : num, (i2 & 8) != 0 ? "" : str3, (i2 & 16) != 0 ? 0 : num2, (i2 & 32) != 0 ? 0 : num3, (i2 & 64) != 0 ? "" : str4);
    }
}
