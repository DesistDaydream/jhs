package com.jihuanshe.model;

import com.jihuanshe.R;
import com.vector.util.Res;
import e.j.e.r.c;
import h.k2.v.f0;
import h.k2.v.u;
import h.r0;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

/* loaded from: classes2.dex */
public final class BannerPack {
    @c("grade")
    @e
    private String grade;
    @c("id")
    @e
    private Integer id;
    @c("image_url")
    @e
    private String imageUrl;
    @c("name_cn")
    @e
    private String nameCn;
    @c("name_origin")
    @e
    private String nameOrigin;
    @c("released_at")
    @e
    private String releasedAt;

    public BannerPack() {
        this(null, null, null, null, null, null, 63, null);
    }

    public BannerPack(@e Integer num, @e String str, @e String str2, @e String str3, @e String str4, @e String str5) {
        this.id = num;
        this.nameCn = str;
        this.nameOrigin = str2;
        this.imageUrl = str3;
        this.grade = str4;
        this.releasedAt = str5;
    }

    public static /* synthetic */ BannerPack copy$default(BannerPack bannerPack, Integer num, String str, String str2, String str3, String str4, String str5, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = bannerPack.id;
        }
        if ((i2 & 2) != 0) {
            str = bannerPack.nameCn;
        }
        String str6 = str;
        if ((i2 & 4) != 0) {
            str2 = bannerPack.nameOrigin;
        }
        String str7 = str2;
        if ((i2 & 8) != 0) {
            str3 = bannerPack.imageUrl;
        }
        String str8 = str3;
        if ((i2 & 16) != 0) {
            str4 = bannerPack.grade;
        }
        String str9 = str4;
        if ((i2 & 32) != 0) {
            str5 = bannerPack.releasedAt;
        }
        return bannerPack.copy(num, str6, str7, str8, str9, str5);
    }

    @e
    public final Integer component1() {
        return this.id;
    }

    @e
    public final String component2() {
        return this.nameCn;
    }

    @e
    public final String component3() {
        return this.nameOrigin;
    }

    @e
    public final String component4() {
        return this.imageUrl;
    }

    @e
    public final String component5() {
        return this.grade;
    }

    @e
    public final String component6() {
        return this.releasedAt;
    }

    @d
    public final BannerPack copy(@e Integer num, @e String str, @e String str2, @e String str3, @e String str4, @e String str5) {
        return new BannerPack(num, str, str2, str3, str4, str5);
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BannerPack) {
            BannerPack bannerPack = (BannerPack) obj;
            return f0.g(this.id, bannerPack.id) && f0.g(this.nameCn, bannerPack.nameCn) && f0.g(this.nameOrigin, bannerPack.nameOrigin) && f0.g(this.imageUrl, bannerPack.imageUrl) && f0.g(this.grade, bannerPack.grade) && f0.g(this.releasedAt, bannerPack.releasedAt);
        }
        return false;
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
    public final String getImageUrl() {
        return this.imageUrl;
    }

    @e
    public final String getNameCn() {
        return this.nameCn;
    }

    @e
    public final String getNameOrigin() {
        return this.nameOrigin;
    }

    public final float getRating() {
        if (getScoreNum() == null) {
            return 0.0f;
        }
        return getScoreNum().floatValue();
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

    @e
    public final String getScoreNumStr() {
        String str = this.grade;
        if (str != null && !f0.g(str, "")) {
            return this.grade;
        }
        return Res.w(Res.a, R.string.grade_no_point, null, 2, null);
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.nameCn;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nameOrigin;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.imageUrl;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.grade;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.releasedAt;
        return hashCode5 + (str5 != null ? str5.hashCode() : 0);
    }

    public final void setGrade(@e String str) {
        this.grade = str;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setImageUrl(@e String str) {
        this.imageUrl = str;
    }

    public final void setNameCn(@e String str) {
        this.nameCn = str;
    }

    public final void setNameOrigin(@e String str) {
        this.nameOrigin = str;
    }

    public final void setReleasedAt(@e String str) {
        this.releasedAt = str;
    }

    @d
    public String toString() {
        return "BannerPack(id=" + this.id + ", nameCn=" + ((Object) this.nameCn) + ", nameOrigin=" + ((Object) this.nameOrigin) + ", imageUrl=" + ((Object) this.imageUrl) + ", grade=" + ((Object) this.grade) + ", releasedAt=" + ((Object) this.releasedAt) + ')';
    }

    public /* synthetic */ BannerPack(Integer num, String str, String str2, String str3, String str4, String str5, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? null : str3, (i2 & 16) != 0 ? "" : str4, (i2 & 32) != 0 ? null : str5);
    }
}
