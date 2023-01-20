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
public final class Pack implements Parcelable {
    @d
    public static final Parcelable.Creator<Pack> CREATOR = new Creator();
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private final String nameOrigin;
    @e.j.e.r.c("pack_id")
    @e
    private final Integer packId;
    @e.j.e.r.c("released_at")
    @e
    private final String releasedAt;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Pack> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Pack createFromParcel(@d Parcel parcel) {
            return new Pack(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Pack[] newArray(int i2) {
            return new Pack[i2];
        }
    }

    public Pack() {
        this(null, null, null, null, 15, null);
    }

    public Pack(@e Integer num, @e String str, @e String str2, @e String str3) {
        this.packId = num;
        this.nameCN = str;
        this.nameOrigin = str2;
        this.releasedAt = str3;
    }

    public static /* synthetic */ Pack copy$default(Pack pack, Integer num, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = pack.packId;
        }
        if ((i2 & 2) != 0) {
            str = pack.nameCN;
        }
        if ((i2 & 4) != 0) {
            str2 = pack.nameOrigin;
        }
        if ((i2 & 8) != 0) {
            str3 = pack.releasedAt;
        }
        return pack.copy(num, str, str2, str3);
    }

    @e
    public final Integer component1() {
        return this.packId;
    }

    @e
    public final String component2() {
        return this.nameCN;
    }

    @e
    public final String component3() {
        return this.nameOrigin;
    }

    @e
    public final String component4() {
        return this.releasedAt;
    }

    @d
    public final Pack copy(@e Integer num, @e String str, @e String str2, @e String str3) {
        return new Pack(num, str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Pack) {
            Pack pack = (Pack) obj;
            return f0.g(this.packId, pack.packId) && f0.g(this.nameCN, pack.nameCN) && f0.g(this.nameOrigin, pack.nameOrigin) && f0.g(this.releasedAt, pack.releasedAt);
        }
        return false;
    }

    @e
    public final String getNameCN() {
        return this.nameCN;
    }

    @e
    public final String getNameOrigin() {
        return this.nameOrigin;
    }

    @e
    public final Integer getPackId() {
        return this.packId;
    }

    @e
    public final String getReleasedAt() {
        return this.releasedAt;
    }

    public int hashCode() {
        Integer num = this.packId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.nameCN;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nameOrigin;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.releasedAt;
        return hashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    @d
    public String toString() {
        return "Pack(packId=" + this.packId + ", nameCN=" + ((Object) this.nameCN) + ", nameOrigin=" + ((Object) this.nameOrigin) + ", releasedAt=" + ((Object) this.releasedAt) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        int intValue;
        Integer num = this.packId;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOrigin);
        parcel.writeString(this.releasedAt);
    }

    public /* synthetic */ Pack(Integer num, String str, String str2, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3);
    }
}
