package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.moor.imkf.model.entity.FromToMessage;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class Banner implements Parcelable {
    @d
    public static final Parcelable.Creator<Banner> CREATOR = new Creator();
    @e.j.e.r.c(TypedValues.Attributes.S_TARGET)
    @e
    private final String deeplink;
    @e.j.e.r.c(FromToMessage.MSG_TYPE_IMAGE)
    @e
    private final String url;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Banner> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Banner createFromParcel(@d Parcel parcel) {
            return new Banner(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Banner[] newArray(int i2) {
            return new Banner[i2];
        }
    }

    public Banner() {
        this(null, null, 3, null);
    }

    public Banner(@e String str, @e String str2) {
        this.url = str;
        this.deeplink = str2;
    }

    public static /* synthetic */ Banner copy$default(Banner banner, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = banner.url;
        }
        if ((i2 & 2) != 0) {
            str2 = banner.deeplink;
        }
        return banner.copy(str, str2);
    }

    @e
    public final String component1() {
        return this.url;
    }

    @e
    public final String component2() {
        return this.deeplink;
    }

    @d
    public final Banner copy(@e String str, @e String str2) {
        return new Banner(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Banner) {
            Banner banner = (Banner) obj;
            return f0.g(this.url, banner.url) && f0.g(this.deeplink, banner.deeplink);
        }
        return false;
    }

    @e
    public final String getDeeplink() {
        return this.deeplink;
    }

    @e
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deeplink;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "Banner(url=" + ((Object) this.url) + ", deeplink=" + ((Object) this.deeplink) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.url);
        parcel.writeString(this.deeplink);
    }

    public /* synthetic */ Banner(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
