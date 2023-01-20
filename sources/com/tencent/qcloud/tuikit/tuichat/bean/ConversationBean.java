package com.tencent.qcloud.tuikit.tuichat.bean;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class ConversationBean implements Parcelable {
    public static final Parcelable.Creator<ConversationBean> CREATOR = new Parcelable.Creator<ConversationBean>() { // from class: com.tencent.qcloud.tuikit.tuichat.bean.ConversationBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConversationBean createFromParcel(Parcel parcel) {
            return new ConversationBean(parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ConversationBean[] newArray(int i2) {
            return new ConversationBean[i2];
        }
    };
    private String conversationID;
    private int isGroup;
    private String title;

    public ConversationBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getConversationID() {
        return this.conversationID;
    }

    public int getIsGroup() {
        return this.isGroup;
    }

    public String getTitle() {
        return this.title;
    }

    public void setConversationID(String str) {
        this.conversationID = str;
    }

    public void setIsGroup(int i2) {
        this.isGroup = i2;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.conversationID);
        parcel.writeInt(this.isGroup);
        parcel.writeString(this.title);
    }

    public ConversationBean(String str, int i2, String str2) {
        this.conversationID = str;
        this.isGroup = i2;
        this.title = str2;
    }
}
