package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;

@c
/* loaded from: classes2.dex */
public final class RankTypeInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<RankTypeInfo> CREATOR = new Creator();
    @e.j.e.r.c("desc")
    @d
    private final String desc;
    @e.j.e.r.c("icon")
    @d
    private final String icon;
    @e.j.e.r.c("ranking_type_id")
    private final int rankingTypeID;
    @e.j.e.r.c("ranking_type_name")
    @d
    private final String rankingTypeName;
    @e.j.e.r.c("theme")
    @d
    private final String theme;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<RankTypeInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RankTypeInfo createFromParcel(@d Parcel parcel) {
            return new RankTypeInfo(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final RankTypeInfo[] newArray(int i2) {
            return new RankTypeInfo[i2];
        }
    }

    public RankTypeInfo() {
        this(null, null, null, 0, null, 31, null);
    }

    public RankTypeInfo(@d String str, @d String str2, @d String str3, int i2, @d String str4) {
        this.desc = str;
        this.icon = str2;
        this.theme = str3;
        this.rankingTypeID = i2;
        this.rankingTypeName = str4;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getDesc() {
        return this.desc;
    }

    @d
    public final String getIcon() {
        return this.icon;
    }

    public final int getRankingTypeID() {
        return this.rankingTypeID;
    }

    @d
    public final String getRankingTypeName() {
        return this.rankingTypeName;
    }

    @d
    public final String getTheme() {
        return this.theme;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.desc);
        parcel.writeString(this.icon);
        parcel.writeString(this.theme);
        parcel.writeInt(this.rankingTypeID);
        parcel.writeString(this.rankingTypeName);
    }

    public /* synthetic */ RankTypeInfo(String str, String str2, String str3, int i2, String str4, int i3, u uVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? "" : str2, (i3 & 4) != 0 ? "" : str3, (i3 & 8) != 0 ? 0 : i2, (i3 & 16) != 0 ? "" : str4);
    }
}
