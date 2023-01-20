package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class WareCache implements Parcelable {
    @d
    public static final Parcelable.Creator<WareCache> CREATOR = new Creator();
    @e.j.e.r.c("express_number")
    @e
    private String expressNumber;
    @e.j.e.r.c("express_type")
    @e
    private String expressType;
    @e.j.e.r.c("image_url")
    @e
    private String imageUrl;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WareCache> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WareCache createFromParcel(@d Parcel parcel) {
            return new WareCache(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WareCache[] newArray(int i2) {
            return new WareCache[i2];
        }
    }

    public WareCache() {
        this(null, null, null, 7, null);
    }

    public WareCache(@e String str, @e String str2, @e String str3) {
        this.expressType = str;
        this.expressNumber = str2;
        this.imageUrl = str3;
    }

    public static /* synthetic */ WareCache copy$default(WareCache wareCache, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = wareCache.expressType;
        }
        if ((i2 & 2) != 0) {
            str2 = wareCache.expressNumber;
        }
        if ((i2 & 4) != 0) {
            str3 = wareCache.imageUrl;
        }
        return wareCache.copy(str, str2, str3);
    }

    @e
    public final String component1() {
        return this.expressType;
    }

    @e
    public final String component2() {
        return this.expressNumber;
    }

    @e
    public final String component3() {
        return this.imageUrl;
    }

    @d
    public final WareCache copy(@e String str, @e String str2, @e String str3) {
        return new WareCache(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof WareCache) {
            WareCache wareCache = (WareCache) obj;
            return f0.g(this.expressType, wareCache.expressType) && f0.g(this.expressNumber, wareCache.expressNumber) && f0.g(this.imageUrl, wareCache.imageUrl);
        }
        return false;
    }

    @e
    public final String getExpressNumber() {
        return this.expressNumber;
    }

    @e
    public final String getExpressType() {
        return this.expressType;
    }

    @e
    public final String getImageUrl() {
        return this.imageUrl;
    }

    public int hashCode() {
        String str = this.expressType;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.expressNumber;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setExpressNumber(@e String str) {
        this.expressNumber = str;
    }

    public final void setExpressType(@e String str) {
        this.expressType = str;
    }

    public final void setImageUrl(@e String str) {
        this.imageUrl = str;
    }

    @d
    public String toString() {
        return "WareCache(expressType=" + ((Object) this.expressType) + ", expressNumber=" + ((Object) this.expressNumber) + ", imageUrl=" + ((Object) this.imageUrl) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.expressType);
        parcel.writeString(this.expressNumber);
        parcel.writeString(this.imageUrl);
    }

    public /* synthetic */ WareCache(String str, String str2, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }
}
