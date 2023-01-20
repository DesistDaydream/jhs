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
public final class ReturnOrderResult implements Parcelable {
    @d
    public static final Parcelable.Creator<ReturnOrderResult> CREATOR = new Creator();
    @e.j.e.r.c("warehouse_return_order_id")
    @e
    private final Integer orderId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReturnOrderResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReturnOrderResult createFromParcel(@d Parcel parcel) {
            return new ReturnOrderResult(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReturnOrderResult[] newArray(int i2) {
            return new ReturnOrderResult[i2];
        }
    }

    public ReturnOrderResult() {
        this(null, 1, null);
    }

    public ReturnOrderResult(@e Integer num) {
        this.orderId = num;
    }

    public static /* synthetic */ ReturnOrderResult copy$default(ReturnOrderResult returnOrderResult, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = returnOrderResult.orderId;
        }
        return returnOrderResult.copy(num);
    }

    @e
    public final Integer component1() {
        return this.orderId;
    }

    @d
    public final ReturnOrderResult copy(@e Integer num) {
        return new ReturnOrderResult(num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ReturnOrderResult) && f0.g(this.orderId, ((ReturnOrderResult) obj).orderId);
    }

    @e
    public final Integer getOrderId() {
        return this.orderId;
    }

    public int hashCode() {
        Integer num = this.orderId;
        if (num == null) {
            return 0;
        }
        return num.hashCode();
    }

    @d
    public String toString() {
        return "ReturnOrderResult(orderId=" + this.orderId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        int intValue;
        Integer num = this.orderId;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
    }

    public /* synthetic */ ReturnOrderResult(Integer num, int i2, u uVar) {
        this((i2 & 1) != 0 ? 0 : num);
    }
}
