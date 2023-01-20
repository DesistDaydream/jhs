package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.vector.util.Res;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class InteractData implements Parcelable {
    @d
    private static final String TYPE_IMAGE = "image";
    @d
    private static final String TYPE_TEXT = "text";
    @e.j.e.r.c("action")
    @e
    private String action;
    @e.j.e.r.c("content")
    @e
    private String content;
    @e.j.e.r.c("diff_time")
    @e
    private String createTime;
    @e.j.e.r.c("is_delete")
    @e
    private Boolean delete;
    @e.j.e.r.c("from_user_avatar")
    @e
    private String fromUAvatar;
    @e.j.e.r.c("from_username")
    @e
    private String fromUName;
    @e.j.e.r.c("from_user_id")
    @e
    private Integer fromUid;
    @a
    @e
    private CharSequence handleContent;
    @a
    @e
    private CharSequence handleSourceContent;
    @e.j.e.r.c("message_id")
    @e
    private Integer msgId;
    @e.j.e.r.c("is_read")
    @e
    private Boolean readed = Boolean.TRUE;
    @e.j.e.r.c("review_id")
    @e
    private Integer reviewId;
    @e.j.e.r.c("source_content")
    @e
    private String sourceContent;
    @e.j.e.r.c("source_type")
    @e
    private String sourceType;
    @d
    public static final Companion Companion = new Companion(null);
    @d
    public static final Parcelable.Creator<InteractData> CREATOR = new Creator();

    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(u uVar) {
            this();
        }
    }

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<InteractData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final InteractData createFromParcel(@d Parcel parcel) {
            parcel.readInt();
            return new InteractData();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final InteractData[] newArray(int i2) {
            return new InteractData[i2];
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getAction() {
        return this.action;
    }

    @e
    public final String getContent() {
        return this.content;
    }

    @e
    public final String getCreateTime() {
        return this.createTime;
    }

    @e
    public final Boolean getDelete() {
        return this.delete;
    }

    @e
    public final String getFromUAvatar() {
        return this.fromUAvatar;
    }

    @e
    public final String getFromUName() {
        return this.fromUName;
    }

    @e
    public final Integer getFromUid() {
        return this.fromUid;
    }

    @e
    public final CharSequence getHandleContent() {
        return f0.g(this.delete, Boolean.TRUE) ? Res.w(Res.a, R.string.comment_deleted, null, 2, null) : this.handleContent;
    }

    @e
    public final CharSequence getHandleSourceContent() {
        return this.handleSourceContent;
    }

    @e
    public final Integer getMsgId() {
        return this.msgId;
    }

    @e
    public final Boolean getReaded() {
        return this.readed;
    }

    @e
    public final Integer getReviewId() {
        return this.reviewId;
    }

    @e
    public final String getSourceContent() {
        return this.sourceContent;
    }

    @e
    public final String getSourceType() {
        return this.sourceType;
    }

    public final boolean isImage() {
        return f0.g(this.sourceType, "image");
    }

    public final boolean isRead() {
        return f0.g(this.readed, Boolean.TRUE);
    }

    public final boolean isText() {
        return f0.g(this.sourceType, "text");
    }

    public final void setAction(@e String str) {
        this.action = str;
    }

    public final void setContent(@e String str) {
        this.content = str;
    }

    public final void setCreateTime(@e String str) {
        this.createTime = str;
    }

    public final void setDelete(@e Boolean bool) {
        this.delete = bool;
    }

    public final void setFromUAvatar(@e String str) {
        this.fromUAvatar = str;
    }

    public final void setFromUName(@e String str) {
        this.fromUName = str;
    }

    public final void setFromUid(@e Integer num) {
        this.fromUid = num;
    }

    public final void setHandleContent(@e CharSequence charSequence) {
        this.handleContent = charSequence;
    }

    public final void setHandleSourceContent(@e CharSequence charSequence) {
        this.handleSourceContent = charSequence;
    }

    public final void setMsgId(@e Integer num) {
        this.msgId = num;
    }

    public final void setReaded(@e Boolean bool) {
        this.readed = bool;
    }

    public final void setReviewId(@e Integer num) {
        this.reviewId = num;
    }

    public final void setSourceContent(@e String str) {
        this.sourceContent = str;
    }

    public final void setSourceType(@e String str) {
        this.sourceType = str;
    }

    public final int textColor() {
        return Res.k(f0.g(this.delete, Boolean.TRUE) ? R.color.black_b5b5b7 : R.color.black);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(1);
    }
}
