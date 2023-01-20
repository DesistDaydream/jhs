package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.utils.StringUtil;
import e.j.e.r.a;
import h.k2.v.f0;
import h.r0;
import i.c.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class CardVersionInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardVersionInfo> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    @e
    private Integer cardID;
    @a
    @e
    private Game game;
    @e
    private String grade;
    @e
    private Integer id;
    @e.j.e.r.c("image_url")
    @e
    private String imageURL;
    @e.j.e.r.c("min_price")
    @e
    private String minPrice;
    @e.j.e.r.c("name_cn")
    @e
    private String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private String nameOrigin;
    @e
    private Integer numMore;
    @e
    private String number;
    @e
    private final Pack pack;
    @e
    private String rarity;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardVersionInfo> {
        @Override // android.os.Parcelable.Creator
        @d
        public final CardVersionInfo createFromParcel(@d Parcel parcel) {
            return new CardVersionInfo(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Pack.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
        }

        @Override // android.os.Parcelable.Creator
        @d
        public final CardVersionInfo[] newArray(int i2) {
            return new CardVersionInfo[i2];
        }
    }

    public CardVersionInfo() {
        this(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
    }

    public CardVersionInfo(@e Integer num, @e Integer num2, @e String str, @e Integer num3, @e String str2, @e String str3, @e String str4, @e String str5, @e Pack pack, @e String str6, @e String str7) {
        this.numMore = num;
        this.cardID = num2;
        this.grade = str;
        this.id = num3;
        this.imageURL = str2;
        this.minPrice = str3;
        this.nameCN = str4;
        this.nameOrigin = str5;
        this.pack = pack;
        this.number = str6;
        this.rarity = str7;
    }

    @e
    public final Integer component1() {
        return this.numMore;
    }

    @e
    public final String component10() {
        return this.number;
    }

    @e
    public final String component11() {
        return this.rarity;
    }

    @e
    public final Integer component2() {
        return this.cardID;
    }

    @e
    public final String component3() {
        return this.grade;
    }

    @e
    public final Integer component4() {
        return this.id;
    }

    @e
    public final String component5() {
        return this.imageURL;
    }

    @e
    public final String component6() {
        return this.minPrice;
    }

    @e
    public final String component7() {
        return this.nameCN;
    }

    @e
    public final String component8() {
        return this.nameOrigin;
    }

    @e
    public final Pack component9() {
        return this.pack;
    }

    @d
    public final CardVersionInfo copy(@e Integer num, @e Integer num2, @e String str, @e Integer num3, @e String str2, @e String str3, @e String str4, @e String str5, @e Pack pack, @e String str6, @e String str7) {
        return new CardVersionInfo(num, num2, str, num3, str2, str3, str4, str5, pack, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardVersionInfo) {
            CardVersionInfo cardVersionInfo = (CardVersionInfo) obj;
            return f0.g(this.numMore, cardVersionInfo.numMore) && f0.g(this.cardID, cardVersionInfo.cardID) && f0.g(this.grade, cardVersionInfo.grade) && f0.g(this.id, cardVersionInfo.id) && f0.g(this.imageURL, cardVersionInfo.imageURL) && f0.g(this.minPrice, cardVersionInfo.minPrice) && f0.g(this.nameCN, cardVersionInfo.nameCN) && f0.g(this.nameOrigin, cardVersionInfo.nameOrigin) && f0.g(this.pack, cardVersionInfo.pack) && f0.g(this.number, cardVersionInfo.number) && f0.g(this.rarity, cardVersionInfo.rarity);
        }
        return false;
    }

    @e
    public final Integer getCardID() {
        return this.cardID;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final String getGrade() {
        return this.grade;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final String getImageURL() {
        return this.imageURL;
    }

    @d
    public final String getImg() {
        String str = this.imageURL;
        if (str == null || str.length() == 0) {
            return "http://cdn.jihuanshe.com/" + this.cardID + ".jpg";
        }
        String str2 = this.imageURL;
        return str2 != null ? str2 : "";
    }

    @e
    public final String getMinPrice() {
        return this.minPrice;
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
    public final Integer getNumMore() {
        return this.numMore;
    }

    @e
    public final String getNumber() {
        return this.number;
    }

    @e
    public final Pack getPack() {
        return this.pack;
    }

    @d
    public final CharSequence getPrice() {
        StringUtil stringUtil = StringUtil.a;
        String str = this.minPrice;
        return StringUtil.c(stringUtil, str == null ? 0.0f : Float.parseFloat(str), 0, false, 0, 0, false, 62, null);
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final Float getScoreNum() {
        try {
            Result.a aVar = Result.Companion;
            String grade = getGrade();
            if (grade == null) {
                return null;
            }
            return Float.valueOf(Float.parseFloat(grade));
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return null;
        }
    }

    public int hashCode() {
        Integer num = this.numMore;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.cardID;
        int hashCode2 = (hashCode + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.grade;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num3 = this.id;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str2 = this.imageURL;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.minPrice;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nameCN;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.nameOrigin;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Pack pack = this.pack;
        int hashCode9 = (hashCode8 + (pack == null ? 0 : pack.hashCode())) * 31;
        String str6 = this.number;
        int hashCode10 = (hashCode9 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.rarity;
        return hashCode10 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setCardID(@e Integer num) {
        this.cardID = num;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setGrade(@e String str) {
        this.grade = str;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setImageURL(@e String str) {
        this.imageURL = str;
    }

    public final void setMinPrice(@e String str) {
        this.minPrice = str;
    }

    public final void setNameCN(@e String str) {
        this.nameCN = str;
    }

    public final void setNameOrigin(@e String str) {
        this.nameOrigin = str;
    }

    public final void setNumMore(@e Integer num) {
        this.numMore = num;
    }

    public final void setNumber(@e String str) {
        this.number = str;
    }

    public final void setRarity(@e String str) {
        this.rarity = str;
    }

    @d
    public String toString() {
        return "CardVersionInfo(numMore=" + this.numMore + ", cardID=" + this.cardID + ", grade=" + ((Object) this.grade) + ", id=" + this.id + ", imageURL=" + ((Object) this.imageURL) + ", minPrice=" + ((Object) this.minPrice) + ", nameCN=" + ((Object) this.nameCN) + ", nameOrigin=" + ((Object) this.nameOrigin) + ", pack=" + this.pack + ", number=" + ((Object) this.number) + ", rarity=" + ((Object) this.rarity) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.numMore;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.cardID;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.grade);
        Integer num3 = this.id;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.imageURL);
        parcel.writeString(this.minPrice);
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOrigin);
        Pack pack = this.pack;
        if (pack == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pack.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.number);
        parcel.writeString(this.rarity);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ CardVersionInfo(java.lang.Integer r13, java.lang.Integer r14, java.lang.String r15, java.lang.Integer r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, com.jihuanshe.model.Pack r21, java.lang.String r22, java.lang.String r23, int r24, h.k2.v.u r25) {
        /*
            r12 = this;
            r0 = r24
            r1 = r0 & 1
            r2 = 0
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            if (r1 == 0) goto Ld
            r1 = r2
            goto Le
        Ld:
            r1 = r13
        Le:
            r3 = r0 & 2
            if (r3 == 0) goto L14
            r3 = r2
            goto L15
        L14:
            r3 = r14
        L15:
            r4 = r0 & 4
            if (r4 == 0) goto L1c
            java.lang.String r4 = "0"
            goto L1d
        L1c:
            r4 = r15
        L1d:
            r5 = r0 & 8
            if (r5 == 0) goto L22
            goto L24
        L22:
            r2 = r16
        L24:
            r5 = r0 & 16
            java.lang.String r6 = ""
            if (r5 == 0) goto L2c
            r5 = r6
            goto L2e
        L2c:
            r5 = r17
        L2e:
            r7 = r0 & 32
            r8 = 0
            if (r7 == 0) goto L35
            r7 = r8
            goto L37
        L35:
            r7 = r18
        L37:
            r9 = r0 & 64
            if (r9 == 0) goto L3d
            r9 = r6
            goto L3f
        L3d:
            r9 = r19
        L3f:
            r10 = r0 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L45
            r10 = r6
            goto L47
        L45:
            r10 = r20
        L47:
            r11 = r0 & 256(0x100, float:3.59E-43)
            if (r11 == 0) goto L4c
            goto L4e
        L4c:
            r8 = r21
        L4e:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L54
            r11 = r6
            goto L56
        L54:
            r11 = r22
        L56:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L5b
            goto L5d
        L5b:
            r6 = r23
        L5d:
            r13 = r12
            r14 = r1
            r15 = r3
            r16 = r4
            r17 = r2
            r18 = r5
            r19 = r7
            r20 = r9
            r21 = r10
            r22 = r8
            r23 = r11
            r24 = r6
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jihuanshe.model.CardVersionInfo.<init>(java.lang.Integer, java.lang.Integer, java.lang.String, java.lang.Integer, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.jihuanshe.model.Pack, java.lang.String, java.lang.String, int, h.k2.v.u):void");
    }
}
