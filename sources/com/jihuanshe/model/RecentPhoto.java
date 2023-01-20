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
public final class RecentPhoto implements Parcelable {
    @d
    public static final Parcelable.Creator<RecentPhoto> CREATOR = new Creator();
    @e.j.e.r.c("card_version_image")
    @e
    private final String url;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<RecentPhoto> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RecentPhoto createFromParcel(@d Parcel parcel) {
            return new RecentPhoto(parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RecentPhoto[] newArray(int i2) {
            return new RecentPhoto[i2];
        }
    }

    public RecentPhoto() {
        this(null, 1, null);
    }

    public RecentPhoto(@e String str) {
        this.url = str;
    }

    public static /* synthetic */ RecentPhoto copy$default(RecentPhoto recentPhoto, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = recentPhoto.url;
        }
        return recentPhoto.copy(str);
    }

    @e
    public final String component1() {
        return this.url;
    }

    @d
    public final RecentPhoto copy(@e String str) {
        return new RecentPhoto(str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RecentPhoto) && f0.g(this.url, ((RecentPhoto) obj).url);
    }

    @e
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        String str = this.url;
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    @d
    public String toString() {
        return "RecentPhoto(url=" + ((Object) this.url) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.url);
    }

    public /* synthetic */ RecentPhoto(String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str);
    }
}
