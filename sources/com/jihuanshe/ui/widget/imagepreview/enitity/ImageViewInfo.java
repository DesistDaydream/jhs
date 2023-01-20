package com.jihuanshe.ui.widget.imagepreview.enitity;

import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class ImageViewInfo implements IThumbViewInfo {
    public static final Parcelable.Creator<ImageViewInfo> CREATOR = new a();
    private String avatar;
    private Rect mBounds;
    private String url;
    private String userId;
    private String userName;
    private String videoUrl;

    /* loaded from: classes2.dex */
    public class a implements Parcelable.Creator<ImageViewInfo> {
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public ImageViewInfo createFromParcel(Parcel parcel) {
            return new ImageViewInfo(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: b */
        public ImageViewInfo[] newArray(int i2) {
            return new ImageViewInfo[i2];
        }
    }

    public ImageViewInfo(String str) {
        this.url = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    public String getAvatar() {
        return this.avatar;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    public Rect getBounds() {
        return this.mBounds;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    public String getUrl() {
        return this.url;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    public String getUserId() {
        return this.userId;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    public String getUserName() {
        return this.userName;
    }

    @Override // com.jihuanshe.ui.widget.imagepreview.enitity.IThumbViewInfo
    @Nullable
    public String getVideoUrl() {
        return this.videoUrl;
    }

    public void setAvatar(String str) {
        this.avatar = str;
    }

    public void setBounds(Rect rect) {
        this.mBounds = rect;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setUserName(String str) {
        this.userName = str;
    }

    public void setVideoUrl(String str) {
        this.videoUrl = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.url);
        parcel.writeParcelable(this.mBounds, i2);
        parcel.writeString(this.videoUrl);
        parcel.writeString(this.userId);
        parcel.writeString(this.userName);
        parcel.writeString(this.avatar);
    }

    public ImageViewInfo(String str, String str2) {
        this.url = str2;
        this.videoUrl = str;
    }

    public ImageViewInfo(String str, Rect rect, String str2, String str3, String str4) {
        this.url = str;
        this.mBounds = rect;
        this.userId = str2;
        this.userName = str3;
        this.avatar = str4;
    }

    public ImageViewInfo(Parcel parcel) {
        this.url = parcel.readString();
        this.mBounds = (Rect) parcel.readParcelable(Rect.class.getClassLoader());
        this.videoUrl = parcel.readString();
        this.userId = parcel.readString();
        this.userName = parcel.readString();
        this.avatar = parcel.readString();
    }
}
