package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import java.util.List;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ExpressList implements Parcelable {
    @d
    public static final Parcelable.Creator<ExpressList> CREATOR = new Creator();
    @e.j.e.r.c("express")
    @e
    private final List<String> data;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ExpressList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ExpressList createFromParcel(@d Parcel parcel) {
            return new ExpressList(parcel.createStringArrayList());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ExpressList[] newArray(int i2) {
            return new ExpressList[i2];
        }
    }

    public ExpressList() {
        this(null, 1, null);
    }

    public ExpressList(@e List<String> list) {
        this.data = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final List<String> getData() {
        return this.data;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeStringList(this.data);
    }

    public /* synthetic */ ExpressList(List list, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : list);
    }
}
