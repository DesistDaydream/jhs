package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class EtiquetteQuestion implements Parcelable {
    @d
    public static final Parcelable.Creator<EtiquetteQuestion> CREATOR = new Creator();
    @e.j.e.r.c("etiquette_question_options")
    @e
    private List<EtiquetteAnswer> answer;
    @e.j.e.r.c("etiquette_question_id")
    @e
    private Integer id;
    @e.j.e.r.c("etiquette_question_name")
    @e
    private String question;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<EtiquetteQuestion> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteQuestion createFromParcel(@d Parcel parcel) {
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList2.add(EtiquetteAnswer.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new EtiquetteQuestion(valueOf, readString, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final EtiquetteQuestion[] newArray(int i2) {
            return new EtiquetteQuestion[i2];
        }
    }

    public EtiquetteQuestion() {
        this(null, null, null, 7, null);
    }

    public EtiquetteQuestion(@e Integer num, @e String str, @e List<EtiquetteAnswer> list) {
        this.id = num;
        this.question = str;
        this.answer = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ EtiquetteQuestion copy$default(EtiquetteQuestion etiquetteQuestion, Integer num, String str, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = etiquetteQuestion.id;
        }
        if ((i2 & 2) != 0) {
            str = etiquetteQuestion.question;
        }
        if ((i2 & 4) != 0) {
            list = etiquetteQuestion.answer;
        }
        return etiquetteQuestion.copy(num, str, list);
    }

    @e
    public final Integer component1() {
        return this.id;
    }

    @e
    public final String component2() {
        return this.question;
    }

    @e
    public final List<EtiquetteAnswer> component3() {
        return this.answer;
    }

    @d
    public final EtiquetteQuestion copy(@e Integer num, @e String str, @e List<EtiquetteAnswer> list) {
        return new EtiquetteQuestion(num, str, list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof EtiquetteQuestion) {
            EtiquetteQuestion etiquetteQuestion = (EtiquetteQuestion) obj;
            return f0.g(this.id, etiquetteQuestion.id) && f0.g(this.question, etiquetteQuestion.question) && f0.g(this.answer, etiquetteQuestion.answer);
        }
        return false;
    }

    @e
    public final List<EtiquetteAnswer> getAnswer() {
        return this.answer;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    @e
    public final String getQuestion() {
        return this.question;
    }

    public int hashCode() {
        Integer num = this.id;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.question;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        List<EtiquetteAnswer> list = this.answer;
        return hashCode2 + (list != null ? list.hashCode() : 0);
    }

    public final void setAnswer(@e List<EtiquetteAnswer> list) {
        this.answer = list;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setQuestion(@e String str) {
        this.question = str;
    }

    @d
    public String toString() {
        return "EtiquetteQuestion(id=" + this.id + ", question=" + ((Object) this.question) + ", answer=" + this.answer + ')';
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
        parcel.writeString(this.question);
        List<EtiquetteAnswer> list = this.answer;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (EtiquetteAnswer etiquetteAnswer : list) {
            etiquetteAnswer.writeToParcel(parcel, i2);
        }
    }

    public /* synthetic */ EtiquetteQuestion(Integer num, String str, List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : list);
    }
}
