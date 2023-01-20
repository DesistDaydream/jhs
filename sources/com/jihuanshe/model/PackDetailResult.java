package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.t0;
import h.k2.v.u;
import h.r0;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;
import kotlin.collections.CollectionsKt__CollectionsKt;

@c
/* loaded from: classes2.dex */
public final class PackDetailResult implements Parcelable {
    @d
    public static final Parcelable.Creator<PackDetailResult> CREATOR = new Creator();
    @e.j.e.r.c("card_version_count")
    @e
    private final Integer cardVersionCount;
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
    @e
    private final String imageURL;
    @e.j.e.r.c("is_desire")
    private boolean isDesire;
    @e.j.e.r.c("is_grade")
    private final boolean isGrade;
    @e.j.e.r.c("is_like")
    private boolean isLike;
    @a
    private boolean isNeedRequest;
    @e.j.e.r.c("like_count")
    @e
    private Integer likeCount;
    @e.j.e.r.c("name_cn")
    @e
    private final String nameCN;
    @e.j.e.r.c("name_origin")
    @e
    private final String nameOrigin;
    @e
    private final String number;
    @e
    private final Ranking ranking;
    @e.j.e.r.c("released_at")
    @e
    private final String releasedAt;
    @e
    private final String specs;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<PackDetailResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PackDetailResult createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList.add(CardVersionInfo.CREATOR.createFromParcel(parcel));
                }
            }
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt2);
            for (int i3 = 0; i3 != readInt2; i3++) {
                arrayList2.add(GradeDetail.CREATOR.createFromParcel(parcel));
            }
            return new PackDetailResult(valueOf, arrayList, valueOf2, readString, arrayList2, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() != 0, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() != 0 ? Ranking.CREATOR.createFromParcel(parcel) : null, parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PackDetailResult[] newArray(int i2) {
            return new PackDetailResult[i2];
        }
    }

    public PackDetailResult(@e Integer num, @e List<CardVersionInfo> list, @e Integer num2, @e String str, @d List<GradeDetail> list2, @e Integer num3, @e Integer num4, @e Integer num5, @e String str2, boolean z, boolean z2, boolean z3, @e Integer num6, @e String str3, @e String str4, @e String str5, @e Ranking ranking, @e String str6, @e String str7) {
        this.cardVersionCount = num;
        this.cardVersions = list;
        this.desireCount = num2;
        this.grade = str;
        this.gradeDetail = list2;
        this.gradeUserTotal = num3;
        this.gradeTotal = num4;
        this.id = num5;
        this.imageURL = str2;
        this.isDesire = z;
        this.isGrade = z2;
        this.isLike = z3;
        this.likeCount = num6;
        this.nameCN = str3;
        this.nameOrigin = str4;
        this.number = str5;
        this.ranking = ranking;
        this.releasedAt = str6;
        this.specs = str7;
        this.isNeedRequest = true;
    }

    public static /* synthetic */ void isNeedRequest$annotations() {
    }

    @e
    public final Integer component1() {
        return this.cardVersionCount;
    }

    public final boolean component10() {
        return this.isDesire;
    }

    public final boolean component11() {
        return this.isGrade;
    }

    public final boolean component12() {
        return this.isLike;
    }

    @e
    public final Integer component13() {
        return this.likeCount;
    }

    @e
    public final String component14() {
        return this.nameCN;
    }

    @e
    public final String component15() {
        return this.nameOrigin;
    }

    @e
    public final String component16() {
        return this.number;
    }

    @e
    public final Ranking component17() {
        return this.ranking;
    }

    @e
    public final String component18() {
        return this.releasedAt;
    }

    @e
    public final String component19() {
        return this.specs;
    }

    @e
    public final List<CardVersionInfo> component2() {
        return this.cardVersions;
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

    @e
    public final String component9() {
        return this.imageURL;
    }

    @d
    public final PackDetailResult copy(@e Integer num, @e List<CardVersionInfo> list, @e Integer num2, @e String str, @d List<GradeDetail> list2, @e Integer num3, @e Integer num4, @e Integer num5, @e String str2, boolean z, boolean z2, boolean z3, @e Integer num6, @e String str3, @e String str4, @e String str5, @e Ranking ranking, @e String str6, @e String str7) {
        return new PackDetailResult(num, list, num2, str, list2, num3, num4, num5, str2, z, z2, z3, num6, str3, str4, str5, ranking, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof PackDetailResult) {
            PackDetailResult packDetailResult = (PackDetailResult) obj;
            return f0.g(this.cardVersionCount, packDetailResult.cardVersionCount) && f0.g(this.cardVersions, packDetailResult.cardVersions) && f0.g(this.desireCount, packDetailResult.desireCount) && f0.g(this.grade, packDetailResult.grade) && f0.g(this.gradeDetail, packDetailResult.gradeDetail) && f0.g(this.gradeUserTotal, packDetailResult.gradeUserTotal) && f0.g(this.gradeTotal, packDetailResult.gradeTotal) && f0.g(this.id, packDetailResult.id) && f0.g(this.imageURL, packDetailResult.imageURL) && this.isDesire == packDetailResult.isDesire && this.isGrade == packDetailResult.isGrade && this.isLike == packDetailResult.isLike && f0.g(this.likeCount, packDetailResult.likeCount) && f0.g(this.nameCN, packDetailResult.nameCN) && f0.g(this.nameOrigin, packDetailResult.nameOrigin) && f0.g(this.number, packDetailResult.number) && f0.g(this.ranking, packDetailResult.ranking) && f0.g(this.releasedAt, packDetailResult.releasedAt) && f0.g(this.specs, packDetailResult.specs);
        }
        return false;
    }

    @e
    public final Integer getCardVersionCount() {
        return this.cardVersionCount;
    }

    @e
    public final List<CardVersionInfo> getCardVersions() {
        return this.cardVersions;
    }

    @d
    public final List<CardVersionInfo> getCardVersionsResult() {
        List<CardVersionInfo> list = this.cardVersions;
        if (list == null) {
            return CollectionsKt__CollectionsKt.E();
        }
        for (CardVersionInfo cardVersionInfo : list) {
            cardVersionInfo.setGame(getGame());
        }
        Integer num = this.cardVersionCount;
        if ((num == null ? 0 : num.intValue()) < 9) {
            return this.cardVersions;
        }
        CardVersionInfo cardVersionInfo2 = new CardVersionInfo(null, null, null, null, null, null, null, null, null, null, null, 2047, null);
        Integer num2 = this.cardVersionCount;
        cardVersionInfo2.setNumMore(num2 == null ? null : Integer.valueOf(num2.intValue() - 9));
        if (this.cardVersions.size() < 10) {
            List<CardVersionInfo> list2 = this.cardVersions;
            Objects.requireNonNull(list2, "null cannot be cast to non-null type kotlin.collections.MutableList<com.jihuanshe.model.CardVersionInfo>");
            t0.g(list2).add(cardVersionInfo2);
        }
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

    @e
    public final String getImageURL() {
        return this.imageURL;
    }

    @e
    public final String getImg() {
        return this.imageURL;
    }

    @e
    public final Integer getLikeCount() {
        return this.likeCount;
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
    public final String getNumber() {
        return this.number;
    }

    @e
    public final Ranking getRanking() {
        return this.ranking;
    }

    @e
    public final String getReleasedAt() {
        return this.releasedAt;
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

    @e
    public final String getSpecs() {
        return this.specs;
    }

    @d
    public final String getSpecsStr() {
        return f0.C("规格: ", this.specs);
    }

    public final int gradeUserTotalNum() {
        Integer num = this.gradeUserTotal;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public int hashCode() {
        Integer num = this.cardVersionCount;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<CardVersionInfo> list = this.cardVersions;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        Integer num2 = this.desireCount;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str = this.grade;
        int hashCode4 = (((hashCode3 + (str == null ? 0 : str.hashCode())) * 31) + this.gradeDetail.hashCode()) * 31;
        Integer num3 = this.gradeUserTotal;
        int hashCode5 = (hashCode4 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.gradeTotal;
        int hashCode6 = (hashCode5 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.id;
        int hashCode7 = (hashCode6 + (num5 == null ? 0 : num5.hashCode())) * 31;
        String str2 = this.imageURL;
        int hashCode8 = (hashCode7 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isDesire;
        int i2 = z;
        if (z != 0) {
            i2 = 1;
        }
        int i3 = (hashCode8 + i2) * 31;
        boolean z2 = this.isGrade;
        int i4 = z2;
        if (z2 != 0) {
            i4 = 1;
        }
        int i5 = (i3 + i4) * 31;
        boolean z3 = this.isLike;
        int i6 = (i5 + (z3 ? 1 : z3 ? 1 : 0)) * 31;
        Integer num6 = this.likeCount;
        int hashCode9 = (i6 + (num6 == null ? 0 : num6.hashCode())) * 31;
        String str3 = this.nameCN;
        int hashCode10 = (hashCode9 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.nameOrigin;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.number;
        int hashCode12 = (hashCode11 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Ranking ranking = this.ranking;
        int hashCode13 = (hashCode12 + (ranking == null ? 0 : ranking.hashCode())) * 31;
        String str6 = this.releasedAt;
        int hashCode14 = (hashCode13 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.specs;
        return hashCode14 + (str7 != null ? str7.hashCode() : 0);
    }

    public final boolean isDesire() {
        return this.isDesire;
    }

    public final boolean isGrade() {
        return this.isGrade;
    }

    public final boolean isLike() {
        return this.isLike;
    }

    public final boolean isNeedRequest() {
        return this.isNeedRequest;
    }

    public final void setDesire(boolean z) {
        this.isDesire = z;
    }

    public final void setDesireCount(@e Integer num) {
        this.desireCount = num;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setLike(boolean z) {
        this.isLike = z;
    }

    public final void setLikeCount(@e Integer num) {
        this.likeCount = num;
    }

    public final void setNeedRequest(boolean z) {
        this.isNeedRequest = z;
    }

    @d
    public String toString() {
        return "PackDetailResult(cardVersionCount=" + this.cardVersionCount + ", cardVersions=" + this.cardVersions + ", desireCount=" + this.desireCount + ", grade=" + ((Object) this.grade) + ", gradeDetail=" + this.gradeDetail + ", gradeUserTotal=" + this.gradeUserTotal + ", gradeTotal=" + this.gradeTotal + ", id=" + this.id + ", imageURL=" + ((Object) this.imageURL) + ", isDesire=" + this.isDesire + ", isGrade=" + this.isGrade + ", isLike=" + this.isLike + ", likeCount=" + this.likeCount + ", nameCN=" + ((Object) this.nameCN) + ", nameOrigin=" + ((Object) this.nameOrigin) + ", number=" + ((Object) this.number) + ", ranking=" + this.ranking + ", releasedAt=" + ((Object) this.releasedAt) + ", specs=" + ((Object) this.specs) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.cardVersionCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
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
        Integer num2 = this.desireCount;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.grade);
        List<GradeDetail> list2 = this.gradeDetail;
        parcel.writeInt(list2.size());
        for (GradeDetail gradeDetail : list2) {
            gradeDetail.writeToParcel(parcel, i2);
        }
        Integer num3 = this.gradeUserTotal;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.gradeTotal;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        Integer num5 = this.id;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        parcel.writeString(this.imageURL);
        parcel.writeInt(this.isDesire ? 1 : 0);
        parcel.writeInt(this.isGrade ? 1 : 0);
        parcel.writeInt(this.isLike ? 1 : 0);
        Integer num6 = this.likeCount;
        if (num6 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num6.intValue());
        }
        parcel.writeString(this.nameCN);
        parcel.writeString(this.nameOrigin);
        parcel.writeString(this.number);
        Ranking ranking = this.ranking;
        if (ranking == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            ranking.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.releasedAt);
        parcel.writeString(this.specs);
    }

    public /* synthetic */ PackDetailResult(Integer num, List list, Integer num2, String str, List list2, Integer num3, Integer num4, Integer num5, String str2, boolean z, boolean z2, boolean z3, Integer num6, String str3, String str4, String str5, Ranking ranking, String str6, String str7, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0 : num, list, (i2 & 4) != 0 ? 0 : num2, (i2 & 8) != 0 ? "" : str, list2, (i2 & 32) != 0 ? 0 : num3, (i2 & 64) != 0 ? 0 : num4, (i2 & 128) != 0 ? 0 : num5, str2, z, z2, z3, (i2 & 4096) != 0 ? 0 : num6, str3, str4, (32768 & i2) != 0 ? "" : str5, (65536 & i2) != 0 ? null : ranking, str6, (i2 & 262144) != 0 ? null : str7);
    }
}
