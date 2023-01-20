package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;

@c
/* loaded from: classes2.dex */
public final class WithDrawResult implements Parcelable {
    @d
    public static final Parcelable.Creator<WithDrawResult> CREATOR = new Creator();
    @e.j.e.r.c("balance")
    private final float balance;
    @e.j.e.r.c("status")
    private final int status;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WithDrawResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WithDrawResult createFromParcel(@d Parcel parcel) {
            return new WithDrawResult(parcel.readFloat(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WithDrawResult[] newArray(int i2) {
            return new WithDrawResult[i2];
        }
    }

    public WithDrawResult() {
        this(0.0f, 0, 3, null);
    }

    public WithDrawResult(float f2, int i2) {
        this.balance = f2;
        this.status = i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final float getBalance() {
        return this.balance;
    }

    public final int getStatus() {
        return this.status;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeFloat(this.balance);
        parcel.writeInt(this.status);
    }

    public /* synthetic */ WithDrawResult(float f2, int i2, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0.0f : f2, (i3 & 2) != 0 ? 0 : i2);
    }
}
