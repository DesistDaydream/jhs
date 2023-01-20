package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardVersion implements Parcelable {
    @d
    public static final Parcelable.Creator<CardVersion> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    @e
    private final Float avgPrice;
    @e.j.e.r.c("id")
    private final int id;
    @e.j.e.r.c("image_url")
    @e
    private final String image;
    @e.j.e.r.c("min_price")
    @e
    private final Float minPrice;
    @e.j.e.r.c("number")
    @e
    private final String number;
    @e.j.e.r.c("packs")
    @e
    private final List<CardPack> pack;
    @e.j.e.r.c("rarity")
    @e
    private final String rarity;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardVersion> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardVersion createFromParcel(@d Parcel parcel) {
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Float valueOf2 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            if (parcel.readInt() != 0) {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList.add(CardPack.CREATOR.createFromParcel(parcel));
                }
            }
            return new CardVersion(readInt, readString, readString2, valueOf, valueOf2, arrayList, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardVersion[] newArray(int i2) {
            return new CardVersion[i2];
        }
    }

    public CardVersion() {
        this(0, null, null, null, null, null, null, 127, null);
    }

    public CardVersion(int i2, @e String str, @e String str2, @e Float f2, @e Float f3, @e List<CardPack> list, @e String str3) {
        this.id = i2;
        this.number = str;
        this.rarity = str2;
        this.minPrice = f2;
        this.avgPrice = f3;
        this.pack = list;
        this.image = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getAvf() {
        if (this.avgPrice == null) {
            return "暂无";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.avgPrice);
        sb.append((char) 165);
        return sb.toString();
    }

    @e
    public final Float getAvgPrice() {
        return this.avgPrice;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @d
    public final String getImg() {
        String str = this.image;
        return str != null ? str : "";
    }

    @d
    public final String getMin() {
        if (this.minPrice == null) {
            return "暂无";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(this.minPrice);
        sb.append((char) 165);
        return sb.toString();
    }

    @e
    public final Float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final String getNumber() {
        return this.number;
    }

    @e
    public final List<CardPack> getPack() {
        return this.pack;
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @d
    public final String getVer() {
        return ((Object) this.number) + " [" + ((Object) this.rarity) + "] $";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.number);
        parcel.writeString(this.rarity);
        Float f2 = this.minPrice;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        Float f3 = this.avgPrice;
        if (f3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f3.floatValue());
        }
        List<CardPack> list = this.pack;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CardPack cardPack : list) {
                cardPack.writeToParcel(parcel, i2);
            }
        }
        parcel.writeString(this.image);
    }

    public /* synthetic */ CardVersion(int i2, String str, String str2, Float f2, Float f3, List list, String str3, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? Float.valueOf(0.0f) : f2, (i3 & 16) != 0 ? Float.valueOf(0.0f) : f3, (i3 & 32) != 0 ? null : list, (i3 & 64) == 0 ? str3 : null);
    }
}
