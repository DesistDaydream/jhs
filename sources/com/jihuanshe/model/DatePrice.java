package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.android.tpush.common.MessageKey;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class DatePrice implements Parcelable {
    @d
    public static final Parcelable.Creator<DatePrice> CREATOR = new Creator();
    @e.j.e.r.c("price")
    private float price;
    @e.j.e.r.c(MessageKey.MSG_DATE)
    @e
    private final String time;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<DatePrice> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final DatePrice createFromParcel(@d Parcel parcel) {
            return new DatePrice(parcel.readString(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final DatePrice[] newArray(int i2) {
            return new DatePrice[i2];
        }
    }

    public DatePrice() {
        this(null, 0.0f, 3, null);
    }

    public DatePrice(@e String str, float f2) {
        this.time = str;
        this.price = f2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final float getPrice() {
        return this.price;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.time);
        parcel.writeFloat(this.price);
    }

    public /* synthetic */ DatePrice(String str, float f2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? 0.0f : f2);
    }
}
