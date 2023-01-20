package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.utils.StringUtil;
import e.l.g.z;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardPack implements Parcelable, z {
    @d
    public static final Parcelable.Creator<CardPack> CREATOR = new Creator();
    @e.j.e.r.c("id")
    private final int id;
    @e
    private String image;
    private float minPrice;
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    private int versionId;
    @e
    private String versionStr;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardPack> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardPack createFromParcel(@d Parcel parcel) {
            return new CardPack(parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardPack[] newArray(int i2) {
            return new CardPack[i2];
        }
    }

    public CardPack() {
        this(0, null, 3, null);
    }

    public CardPack(int i2, @e String str) {
        this.id = i2;
        this.nameCN = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(CardPack.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.CardPack");
            return this.id == ((CardPack) obj).id;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final String getNameCN() {
        return this.nameCN;
    }

    @d
    public final CharSequence getPrice() {
        return StringUtil.c(StringUtil.a, this.minPrice, 0, false, 0, 0, false, 62, null);
    }

    @Override // e.l.g.z
    @d
    public String getShowContent() {
        String str = this.versionStr;
        return str != null ? str : "";
    }

    public final int getVersionId() {
        return this.versionId;
    }

    @e
    public final String getVersionStr() {
        return this.versionStr;
    }

    public int hashCode() {
        return this.id;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setMinPrice(float f2) {
        this.minPrice = f2;
    }

    public final void setVersionId(int i2) {
        this.versionId = i2;
    }

    public final void setVersionStr(@e String str) {
        this.versionStr = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.nameCN);
    }

    public /* synthetic */ CardPack(int i2, String str, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str);
    }
}
