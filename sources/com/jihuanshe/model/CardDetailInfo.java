package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.utils.StringUtil;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import h.r0;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class CardDetailInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardDetailInfo> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int cardID;
    @e.j.e.r.c("card_versions")
    @e
    private final List<CardVersionInfo> cardVersions;
    @e.j.e.r.c("desire_count")
    @e
    private Integer desireCount;
    @a
    @e
    private Game game;
    @e
    private final String grade;
    @e.j.e.r.c("grade_detail")
    @d
    private final List<GradeDetail> gradeDetail;
    @e.j.e.r.c("grade_total")
    @e
    private final Integer gradeTotal;
    @e.j.e.r.c("grade_user_total")
    @e
    private final Integer gradeUserTotal;
    @e
    private final Integer id;
    @e.j.e.r.c("image_url")
    @d
    private final String imageURL;
    @e.j.e.r.c("is_desire")
    @e
    private Boolean isDesire;
    @e.j.e.r.c("is_grade")
    @e
    private final Boolean isGrade;
    @e.j.e.r.c("is_like")
    @e
    private Boolean isLike;
    @d
    private final String language;
    @e.j.e.r.c("like_count")
    @e
    private Integer likeCount;
    @e.j.e.r.c("min_price")
    @e
    private final String minPrice;
    @e.j.e.r.c("name_cn")
    @d
    private final String nameCN;
    @e.j.e.r.c("name_origin")
    @d
    private final String nameOrigin;
    @d
    private final String number;
    @e
    private final Pack pack;
    @e
    private final Ranking ranking;
    @e
    private final String rarity;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardDetailInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardDetailInfo createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                arrayList = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList.add(CardVersionInfo.CREATOR.createFromParcel(parcel));
                }
            }
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            int readInt3 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt3);
            for (int i3 = 0; i3 != readInt3; i3++) {
                arrayList2.add(GradeDetail.CREATOR.createFromParcel(parcel));
            }
            return new CardDetailInfo(readInt, arrayList, valueOf, readString, arrayList2, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Pack.CREATOR.createFromParcel(parcel), parcel.readInt() != 0 ? Ranking.CREATOR.createFromParcel(parcel) : null, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardDetailInfo[] newArray(int i2) {
            return new CardDetailInfo[i2];
        }
    }

    public CardDetailInfo(int i2, @e List<CardVersionInfo> list, @e Integer num, @e String str, @d List<GradeDetail> list2, @e Integer num2, @e Integer num3, @e Integer num4, @d String str2, @e Boolean bool, @e Boolean bool2, @e Boolean bool3, @d String str3, @e Integer num5, @e String str4, @d String str5, @d String str6, @d String str7, @e Pack pack, @e Ranking ranking, @e String str8) {
        this.cardID = i2;
        this.cardVersions = list;
        this.desireCount = num;
        this.grade = str;
        this.gradeDetail = list2;
        this.gradeUserTotal = num2;
        this.gradeTotal = num3;
        this.id = num4;
        this.imageURL = str2;
        this.isDesire = bool;
        this.isGrade = bool2;
        this.isLike = bool3;
        this.language = str3;
        this.likeCount = num5;
        this.minPrice = str4;
        this.nameCN = str5;
        this.nameOrigin = str6;
        this.number = str7;
        this.pack = pack;
        this.ranking = ranking;
        this.rarity = str8;
    }

    public final int component1() {
        return this.cardID;
    }

    @e
    public final Boolean component10() {
        return this.isDesire;
    }

    @e
    public final Boolean component11() {
        return this.isGrade;
    }

    @e
    public final Boolean component12() {
        return this.isLike;
    }

    @d
    public final String component13() {
        return this.language;
    }

    @e
    public final Integer component14() {
        return this.likeCount;
    }

    @e
    public final String component15() {
        return this.minPrice;
    }

    @d
    public final String component16() {
        return this.nameCN;
    }

    @d
    public final String component17() {
        return this.nameOrigin;
    }

    @d
    public final String component18() {
        return this.number;
    }

    @e
    public final Pack component19() {
        return this.pack;
    }

    @e
    public final List<CardVersionInfo> component2() {
        return this.cardVersions;
    }

    @e
    public final Ranking component20() {
        return this.ranking;
    }

    @e
    public final String component21() {
        return this.rarity;
    }

    @e
    public final Integer component3() {
        return this.desireCount;
    }

    @e
    public final String component4() {
        return this.grade;
    }

    @d
    public final List<GradeDetail> component5() {
        return this.gradeDetail;
    }

    @e
    public final Integer component6() {
        return this.gradeUserTotal;
    }

    @e
    public final Integer component7() {
        return this.gradeTotal;
    }

    @e
    public final Integer component8() {
        return this.id;
    }

    @d
    public final String component9() {
        return this.imageURL;
    }

    @d
    public final CardDetailInfo copy(int i2, @e List<CardVersionInfo> list, @e Integer num, @e String str, @d List<GradeDetail> list2, @e Integer num2, @e Integer num3, @e Integer num4, @d String str2, @e Boolean bool, @e Boolean bool2, @e Boolean bool3, @d String str3, @e Integer num5, @e String str4, @d String str5, @d String str6, @d String str7, @e Pack pack, @e Ranking ranking, @e String str8) {
        return new CardDetailInfo(i2, list, num, str, list2, num2, num3, num4, str2, bool, bool2, bool3, str3, num5, str4, str5, str6, str7, pack, ranking, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardDetailInfo) {
            CardDetailInfo cardDetailInfo = (CardDetailInfo) obj;
            return this.cardID == cardDetailInfo.cardID && f0.g(this.cardVersions, cardDetailInfo.cardVersions) && f0.g(this.desireCount, cardDetailInfo.desireCount) && f0.g(this.grade, cardDetailInfo.grade) && f0.g(this.gradeDetail, cardDetailInfo.gradeDetail) && f0.g(this.gradeUserTotal, cardDetailInfo.gradeUserTotal) && f0.g(this.gradeTotal, cardDetailInfo.gradeTotal) && f0.g(this.id, cardDetailInfo.id) && f0.g(this.imageURL, cardDetailInfo.imageURL) && f0.g(this.isDesire, cardDetailInfo.isDesire) && f0.g(this.isGrade, cardDetailInfo.isGrade) && f0.g(this.isLike, cardDetailInfo.isLike) && f0.g(this.language, cardDetailInfo.language) && f0.g(this.likeCount, cardDetailInfo.likeCount) && f0.g(this.minPrice, cardDetailInfo.minPrice) && f0.g(this.nameCN, cardDetailInfo.nameCN) && f0.g(this.nameOrigin, cardDetailInfo.nameOrigin) && f0.g(this.number, cardDetailInfo.number) && f0.g(this.pack, cardDetailInfo.pack) && f0.g(this.ranking, cardDetailInfo.ranking) && f0.g(this.rarity, cardDetailInfo.rarity);
        }
        return false;
    }

    public final int getCardID() {
        return this.cardID;
    }

    @e
    public final List<CardVersionInfo> getCardVersions() {
        return this.cardVersions;
    }

    @e
    public final Integer getDesireCount() {
        return this.desireCount;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final String getGrade() {
        return this.grade;
    }

    @d
    public final List<GradeDetail> getGradeDetail() {
        return this.gradeDetail;
    }

    @e
    public final Integer getGradeTotal() {
        return this.gradeTotal;
    }

    @e
    public final Integer getGradeUserTotal() {
        return this.gradeUserTotal;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @d
    public final String getImageURL() {
        return this.imageURL;
    }

    @d
    public final String getImg() {
        return this.imageURL;
    }

    @d
    public final String getLanguage() {
        return this.language;
    }

    @e
    public final Integer getLikeCount() {
        return this.likeCount;
    }

    @e
    public final String getMinPrice() {
        return this.minPrice;
    }

    @d
    public final String getNameCN() {
        return this.nameCN;
    }

    @d
    public final String getNameOrigin() {
        return this.nameOrigin;
    }

    @d
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
    public final Ranking getRanking() {
        return this.ranking;
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

    @d
    public final String getScoreNumStr() {
        String str = this.grade;
        return (str == null || f0.g(str, "")) ? "0" : this.grade;
    }

    public final int gradeUserTotalNum() {
        Integer num = this.gradeUserTotal;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        int i2 = this.cardID * 31;
        List<CardVersionInfo> list = this.cardVersions;
        int hashCode = (i2 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num = this.desireCount;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.grade;
        int hashCode3 = (((hashCode2 + (str == null ? 0 : str.hashCode())) * 31) + this.gradeDetail.hashCode()) * 31;
        Integer num2 = this.gradeUserTotal;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.gradeTotal;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.id;
        int hashCode6 = (((hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31) + this.imageURL.hashCode()) * 31;
        Boolean bool = this.isDesire;
        int hashCode7 = (hashCode6 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.isGrade;
        int hashCode8 = (hashCode7 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        Boolean bool3 = this.isLike;
        int hashCode9 = (((hashCode8 + (bool3 == null ? 0 : bool3.hashCode())) * 31) + this.language.hashCode()) * 31;
        Integer num5 = this.likeCount;
        int hashCode10 = (hashCode9 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str2 = this.minPrice;
        int hashCode11 = (((((((hashCode10 + (str2 == null ? 0 : str2.hashCode())) * 31) + this.nameCN.hashCode()) * 31) + this.nameOrigin.hashCode()) * 31) + this.number.hashCode()) * 31;
        Pack pack = this.pack;
        int hashCode12 = (hashCode11 + (pack == null ? 0 : pack.hashCode())) * 31;
        Ranking ranking = this.ranking;
        int hashCode13 = (hashCode12 + (ranking == null ? 0 : ranking.hashCode())) * 31;
        String str3 = this.rarity;
        return hashCode13 + (str3 != null ? str3.hashCode() : 0);
    }

    @e
    public final Boolean isDesire() {
        return this.isDesire;
    }

    @e
    public final Boolean isGrade() {
        return this.isGrade;
    }

    @e
    public final Boolean isLike() {
        return this.isLike;
    }

    public final void setDesire(@e Boolean bool) {
        this.isDesire = bool;
    }

    public final void setDesireCount(@e Integer num) {
        this.desireCount = num;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setLike(@e Boolean bool) {
        this.isLike = bool;
    }

    public final void setLikeCount(@e Integer num) {
        this.likeCount = num;
    }

    @d
    public String toString() {
        return "CardDetailInfo(cardID=" + this.cardID + ", cardVersions=" + this.cardVersions + ", desireCount=" + this.desireCount + ", grade=" + ((Object) this.grade) + ", gradeDetail=" + this.gradeDetail + ", gradeUserTotal=" + this.gradeUserTotal + ", gradeTotal=" + this.gradeTotal + ", id=" + this.id + ", imageURL=" + this.imageURL + ", isDesire=" + this.isDesire + ", isGrade=" + this.isGrade + ", isLike=" + this.isLike + ", language=" + this.language + ", likeCount=" + this.likeCount + ", minPrice=" + ((Object) this.minPrice) + ", nameCN=" + this.nameCN + ", nameOrigin=" + this.nameOrigin + ", number=" + this.number + ", pack=" + this.pack + ", ranking=" + this.ranking + ", rarity=" + ((Object) this.rarity) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.cardID);
        List<CardVersionInfo> list = this.cardVersions;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CardVersionInfo cardVersionInfo : list) {
                cardVersionInfo.writeToParcel(parcel, i2);
            }
        }
        Integer num = this.desireCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.grade);
        List<GradeDetail> list2 = this.gradeDetail;
        parcel.writeInt(list2.size());
        for (GradeDetail gradeDetail : list2) {
            gradeDetail.writeToParcel(parcel, i2);
        }
        Integer num2 = this.gradeUserTotal;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.gradeTotal;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.id;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.imageURL);
        Boolean bool = this.isDesire;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.isGrade;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        Boolean bool3 = this.isLike;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.language);
        Integer num5 = this.likeCount;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        parcel.writeString(this.minPrice);
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOrigin);
        parcel.writeString(this.number);
        Pack pack = this.pack;
        if (pack == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            pack.writeToParcel(parcel, i2);
        }
        Ranking ranking = this.ranking;
        if (ranking == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ranking.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.rarity);
    }

    public /* synthetic */ CardDetailInfo(int i2, List list, Integer num, String str, List list2, Integer num2, Integer num3, Integer num4, String str2, Boolean bool, Boolean bool2, Boolean bool3, String str3, Integer num5, String str4, String str5, String str6, String str7, Pack pack, Ranking ranking, String str8, int i3, u uVar) {
        this(i2, (i3 & 2) != 0 ? null : list, (i3 & 4) != 0 ? 0 : num, (i3 & 8) != 0 ? "0" : str, list2, (i3 & 32) != 0 ? 0 : num2, (i3 & 64) != 0 ? 0 : num3, (i3 & 128) != 0 ? 0 : num4, str2, (i3 & 512) != 0 ? null : bool, (i3 & 1024) != 0 ? null : bool2, (i3 & 2048) != 0 ? null : bool3, str3, (i3 & 8192) != 0 ? 0 : num5, (i3 & 16384) != 0 ? null : str4, str5, str6, str7, (262144 & i3) != 0 ? null : pack, (524288 & i3) != 0 ? null : ranking, (i3 & 1048576) != 0 ? "" : str8);
    }
}
