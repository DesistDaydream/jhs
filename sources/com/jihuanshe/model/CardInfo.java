package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import h.w;
import h.z;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardInfo> CREATOR = new Creator();
    @e.j.e.r.c("attribute")
    @e
    private final String attr;
    @e.j.e.r.c("desc")
    @e
    private final String desc;
    @e.j.e.r.c("desc_evo_cn")
    @e
    private final String descEvo;
    @e.j.e.r.c("desc_main_cn")
    @e
    private final String descMain;
    @e.j.e.r.c("desc_security_cn")
    @e
    private final String descSecurity;
    @e.j.e.r.c("id")
    private final int id;
    @e.j.e.r.c("level")
    @e
    private final String lv;
    @e.j.e.r.c("monster_type")
    @e
    private final String monsterType;
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    @e.j.e.r.c("name_jp")
    @e
    private final String nameJP;
    @e.j.e.r.c("name_tc")
    @e
    private final String nameTC;
    @d
    private final w star$delegate;
    @e.j.e.r.c("type")
    @e
    private final String type;
    @e.j.e.r.c("card_versions")
    @e
    private final List<CardVersion> versions;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardInfo createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList.add(CardVersion.CREATOR.createFromParcel(parcel));
                }
            }
            return new CardInfo(readInt, readString, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardInfo[] newArray(int i2) {
            return new CardInfo[i2];
        }
    }

    public CardInfo() {
        this(0, null, null, null, null, null, null, null, null, null, null, null, null, 8191, null);
    }

    public CardInfo(int i2, @e String str, @e List<CardVersion> list, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e String str10, @e String str11) {
        this.id = i2;
        this.nameCN = str;
        this.versions = list;
        this.desc = str2;
        this.nameJP = str3;
        this.type = str4;
        this.monsterType = str5;
        this.attr = str6;
        this.lv = str7;
        this.descMain = str8;
        this.descEvo = str9;
        this.descSecurity = str10;
        this.nameTC = str11;
        this.star$delegate = z.c(new CardInfo$star$2(this));
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(CardInfo.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.CardInfo");
            return this.id == ((CardInfo) obj).id;
        }
        return false;
    }

    @e
    public final String getAttr() {
        return this.attr;
    }

    @e
    public final String getDesc() {
        return this.desc;
    }

    @e
    public final String getDescEvo() {
        return this.descEvo;
    }

    @e
    public final String getDescMain() {
        return this.descMain;
    }

    @e
    public final String getDescSecurity() {
        return this.descSecurity;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getLv() {
        return this.lv;
    }

    @e
    public final String getMonsterType() {
        return this.monsterType;
    }

    @e
    public final String getNameCN() {
        return this.nameCN;
    }

    @e
    public final String getNameJP() {
        return this.nameJP;
    }

    @e
    public final String getNameTC() {
        return this.nameTC;
    }

    @d
    public final List<Integer> getStar() {
        return (List) this.star$delegate.getValue();
    }

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final List<CardVersion> getVersions() {
        return this.versions;
    }

    public int hashCode() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.nameCN);
        List<CardVersion> list = this.versions;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CardVersion cardVersion : list) {
                cardVersion.writeToParcel(parcel, i2);
            }
        }
        parcel.writeString(this.desc);
        parcel.writeString(this.nameJP);
        parcel.writeString(this.type);
        parcel.writeString(this.monsterType);
        parcel.writeString(this.attr);
        parcel.writeString(this.lv);
        parcel.writeString(this.descMain);
        parcel.writeString(this.descEvo);
        parcel.writeString(this.descSecurity);
        parcel.writeString(this.nameTC);
    }

    public /* synthetic */ CardInfo(int i2, String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : list, (i3 & 8) != 0 ? null : str2, (i3 & 16) != 0 ? null : str3, (i3 & 32) != 0 ? null : str4, (i3 & 64) != 0 ? null : str5, (i3 & 128) != 0 ? null : str6, (i3 & 256) != 0 ? null : str7, (i3 & 512) != 0 ? null : str8, (i3 & 1024) != 0 ? null : str9, (i3 & 2048) != 0 ? null : str10, (i3 & 4096) == 0 ? str11 : null);
    }
}
