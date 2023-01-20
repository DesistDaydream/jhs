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
public final class EtiquetteExamResult implements Parcelable {
    @d
    public static final Parcelable.Creator<EtiquetteExamResult> CREATOR = new Creator();
    @e.j.e.r.c("answer")
    @e
    private Integer correct;
    @e.j.e.r.c("etiquette_question_id")
    @e
    private Integer id;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<EtiquetteExamResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteExamResult createFromParcel(@d Parcel parcel) {
            return new EtiquetteExamResult(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteExamResult[] newArray(int i2) {
            return new EtiquetteExamResult[i2];
        }
    }

    public EtiquetteExamResult() {
        this(null, null, 3, null);
    }

    public EtiquetteExamResult(@e Integer num, @e Integer num2) {
        this.id = num;
        this.correct = num2;
    }

    public static /* synthetic */ EtiquetteExamResult copy$default(EtiquetteExamResult etiquetteExamResult, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = etiquetteExamResult.id;
        }
        if ((i2 & 2) != 0) {
            num2 = etiquetteExamResult.correct;
        }
        return etiquetteExamResult.copy(num, num2);
    }

    @e
    public final Integer component1() {
        return this.id;
    }

    @e
    public final Integer component2() {
        return this.correct;
    }

    @d
    public final EtiquetteExamResult copy(@e Integer num, @e Integer num2) {
        return new EtiquetteExamResult(num, num2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EtiquetteExamResult) {
            EtiquetteExamResult etiquetteExamResult = (EtiquetteExamResult) obj;
            return f0.g(this.id, etiquetteExamResult.id) && f0.g(this.correct, etiquetteExamResult.correct);
        }
        return false;
    }

    @e
    public final Integer getCorrect() {
        return this.correct;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.correct;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setCorrect(@e Integer num) {
        this.correct = num;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    @d
    public String toString() {
        return "EtiquetteExamResult(id=" + this.id + ", correct=" + this.correct + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.correct;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    public /* synthetic */ EtiquetteExamResult(Integer num, Integer num2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2);
    }
}
