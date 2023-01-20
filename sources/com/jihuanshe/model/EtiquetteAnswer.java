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
public final class EtiquetteAnswer implements Parcelable {
    @d
    public static final Parcelable.Creator<EtiquetteAnswer> CREATOR = new Creator();
    @e.j.e.r.c("etiquette_question_option_name")
    @e
    private String answerContent;
    @e.j.e.r.c("etiquette_question_option_id")
    @e
    private Integer id;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<EtiquetteAnswer> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteAnswer createFromParcel(@d Parcel parcel) {
            return new EtiquetteAnswer(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteAnswer[] newArray(int i2) {
            return new EtiquetteAnswer[i2];
        }
    }

    public EtiquetteAnswer() {
        this(null, null, 3, null);
    }

    public EtiquetteAnswer(@e Integer num, @e String str) {
        this.id = num;
        this.answerContent = str;
    }

    public static /* synthetic */ EtiquetteAnswer copy$default(EtiquetteAnswer etiquetteAnswer, Integer num, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = etiquetteAnswer.id;
        }
        if ((i2 & 2) != 0) {
            str = etiquetteAnswer.answerContent;
        }
        return etiquetteAnswer.copy(num, str);
    }

    @e
    public final Integer component1() {
        return this.id;
    }

    @e
    public final String component2() {
        return this.answerContent;
    }

    @d
    public final EtiquetteAnswer copy(@e Integer num, @e String str) {
        return new EtiquetteAnswer(num, str);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EtiquetteAnswer) {
            EtiquetteAnswer etiquetteAnswer = (EtiquetteAnswer) obj;
            return f0.g(this.id, etiquetteAnswer.id) && f0.g(this.answerContent, etiquetteAnswer.answerContent);
        }
        return false;
    }

    @e
    public final String getAnswerContent() {
        return this.answerContent;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.answerContent;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public final void setAnswerContent(@e String str) {
        this.answerContent = str;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    @d
    public String toString() {
        return "EtiquetteAnswer(id=" + this.id + ", answerContent=" + ((Object) this.answerContent) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        int intValue;
        Integer num = this.id;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        parcel.writeString(this.answerContent);
    }

    public /* synthetic */ EtiquetteAnswer(Integer num, String str, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str);
    }
}
