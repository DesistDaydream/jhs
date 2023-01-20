package com.jihuanshe.utils;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ClipInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ClipInfo> CREATOR = new Creator();
    private final boolean min;
    @e
    private final Uri uri;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ClipInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ClipInfo createFromParcel(@d Parcel parcel) {
            return new ClipInfo((Uri) parcel.readParcelable(ClipInfo.class.getClassLoader()), parcel.readInt() != 0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ClipInfo[] newArray(int i2) {
            return new ClipInfo[i2];
        }
    }

    public ClipInfo() {
        this(null, false, 3, null);
    }

    public ClipInfo(@e Uri uri, boolean z) {
        this.uri = uri;
        this.min = z;
    }

    public static /* synthetic */ ClipInfo copy$default(ClipInfo clipInfo, Uri uri, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            uri = clipInfo.uri;
        }
        if ((i2 & 2) != 0) {
            z = clipInfo.min;
        }
        return clipInfo.copy(uri, z);
    }

    @e
    public final Uri component1() {
        return this.uri;
    }

    public final boolean component2() {
        return this.min;
    }

    @d
    public final ClipInfo copy(@e Uri uri, boolean z) {
        return new ClipInfo(uri, z);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ClipInfo) {
            ClipInfo clipInfo = (ClipInfo) obj;
            return f0.g(this.uri, clipInfo.uri) && this.min == clipInfo.min;
        }
        return false;
    }

    public final boolean getMin() {
        return this.min;
    }

    @e
    public final Uri getUri() {
        return this.uri;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Uri uri = this.uri;
        int hashCode = (uri == null ? 0 : uri.hashCode()) * 31;
        boolean z = this.min;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        return hashCode + i2;
    }

    @d
    public String toString() {
        return "ClipInfo(uri=" + this.uri + ", min=" + this.min + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeParcelable(this.uri, i2);
        parcel.writeInt(this.min ? 1 : 0);
    }

    public /* synthetic */ ClipInfo(Uri uri, boolean z, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : uri, (i2 & 2) != 0 ? false : z);
    }
}
