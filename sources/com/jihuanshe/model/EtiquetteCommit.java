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
public final class EtiquetteCommit implements Parcelable {
    @d
    public static final Parcelable.Creator<EtiquetteCommit> CREATOR = new Creator();
    @e.j.e.r.c("etiquette_question_option_id")
    @e
    private Integer answerId;
    @e.j.e.r.c("etiquette_question_id")
    @e
    private Integer questionId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<EtiquetteCommit> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteCommit createFromParcel(@d Parcel parcel) {
            return new EtiquetteCommit(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() != 0 ? Integer.valueOf(parcel.readInt()) : null);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteCommit[] newArray(int i2) {
            return new EtiquetteCommit[i2];
        }
    }

    public EtiquetteCommit() {
        this(null, null, 3, null);
    }

    public EtiquetteCommit(@e Integer num, @e Integer num2) {
        this.questionId = num;
        this.answerId = num2;
    }

    public static /* synthetic */ EtiquetteCommit copy$default(EtiquetteCommit etiquetteCommit, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = etiquetteCommit.questionId;
        }
        if ((i2 & 2) != 0) {
            num2 = etiquetteCommit.answerId;
        }
        return etiquetteCommit.copy(num, num2);
    }

    @e
    public final Integer component1() {
        return this.questionId;
    }

    @e
    public final Integer component2() {
        return this.answerId;
    }

    @d
    public final EtiquetteCommit copy(@e Integer num, @e Integer num2) {
        return new EtiquetteCommit(num, num2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EtiquetteCommit) {
            EtiquetteCommit etiquetteCommit = (EtiquetteCommit) obj;
            return f0.g(this.questionId, etiquetteCommit.questionId) && f0.g(this.answerId, etiquetteCommit.answerId);
        }
        return false;
    }

    @e
    public final Integer getAnswerId() {
        return this.answerId;
    }

    @e
    public final Integer getQuestionId() {
        return this.questionId;
    }

    public int hashCode() {
        Integer num = this.questionId;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        Integer num2 = this.answerId;
        return hashCode + (num2 != null ? num2.hashCode() : 0);
    }

    public final void setAnswerId(@e Integer num) {
        this.answerId = num;
    }

    public final void setQuestionId(@e Integer num) {
        this.questionId = num;
    }

    @d
    public String toString() {
        return "EtiquetteCommit(questionId=" + this.questionId + ", answerId=" + this.answerId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.questionId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.answerId;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    public /* synthetic */ EtiquetteCommit(Integer num, Integer num2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : num2);
    }
}
