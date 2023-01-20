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
public final class GradeDetail implements Parcelable {
    @d
    public static final Parcelable.Creator<GradeDetail> CREATOR = new Creator();
    @e
    private final Integer grade;
    @e.j.e.r.c("user_count")
    @e
    private final Integer userCount;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<GradeDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final GradeDetail createFromParcel(@d Parcel parcel) {
            return new GradeDetail(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final GradeDetail[] newArray(int i2) {
            return new GradeDetail[i2];
        }
    }

    public GradeDetail() {
        this(null, null, 3, null);
    }

    public GradeDetail(@e Integer num, @e Integer num2) {
        this.grade = num;
        this.userCount = num2;
    }

    public static /* synthetic */ GradeDetail copy$default(GradeDetail gradeDetail, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = gradeDetail.grade;
        }
        if ((i2 & 2) != 0) {
            num2 = gradeDetail.userCount;
        }
        return gradeDetail.copy(num, num2);
    }

    @e
    public final Integer component1() {
        return this.grade;
    }

    @e
    public final Integer component2() {
        return this.userCount;
    }

    @d
    public final GradeDetail copy(@e Integer num, @e Integer num2) {
        return new GradeDetail(num, num2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof GradeDetail) {
            GradeDetail gradeDetail = (GradeDetail) obj;
            return f0.g(this.grade, gradeDetail.grade) && f0.g(this.userCount, gradeDetail.userCount);
        }
        return false;
    }

    @e
    public final Integer getGrade() {
        return this.grade;
    }

    @e
    public final Integer getUserCount() {
        return this.userCount;
    }

    public int hashCode() {
        Integer num = this.grade;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.userCount;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "GradeDetail(grade=" + this.grade + ", userCount=" + this.userCount + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.grade;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.userCount;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    public /* synthetic */ GradeDetail(Integer num, Integer num2, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0 : num, (i2 & 2) != 0 ? 0 : num2);
    }
}
