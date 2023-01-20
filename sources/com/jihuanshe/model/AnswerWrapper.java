package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class AnswerWrapper implements Parcelable {
    @d
    public static final Parcelable.Creator<AnswerWrapper> CREATOR = new Creator();
    @d
    private List<EtiquetteCommit> items;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<AnswerWrapper> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final AnswerWrapper createFromParcel(@d Parcel parcel) {
            int readInt = parcel.readInt();
            ArrayList arrayList = new ArrayList(readInt);
            for (int i2 = 0; i2 != readInt; i2++) {
                arrayList.add(EtiquetteCommit.CREATOR.createFromParcel(parcel));
            }
            return new AnswerWrapper(arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final AnswerWrapper[] newArray(int i2) {
            return new AnswerWrapper[i2];
        }
    }

    public AnswerWrapper(@d List<EtiquetteCommit> list) {
        this.items = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AnswerWrapper copy$default(AnswerWrapper answerWrapper, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = answerWrapper.items;
        }
        return answerWrapper.copy(list);
    }

    @d
    public final List<EtiquetteCommit> component1() {
        return this.items;
    }

    @d
    public final AnswerWrapper copy(@d List<EtiquetteCommit> list) {
        return new AnswerWrapper(list);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AnswerWrapper) && f0.g(this.items, ((AnswerWrapper) obj).items);
    }

    @d
    public final List<EtiquetteCommit> getItems() {
        return this.items;
    }

    public int hashCode() {
        return this.items.hashCode();
    }

    public final void setItems(@d List<EtiquetteCommit> list) {
        this.items = list;
    }

    @d
    public String toString() {
        return "AnswerWrapper(items=" + this.items + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        List<EtiquetteCommit> list = this.items;
        parcel.writeInt(list.size());
        for (EtiquetteCommit etiquetteCommit : list) {
            etiquetteCommit.writeToParcel(parcel, i2);
        }
    }
}
