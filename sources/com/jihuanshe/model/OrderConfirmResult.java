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
public final class OrderConfirmResult implements Parcelable {
    @d
    public static final Parcelable.Creator<OrderConfirmResult> CREATOR = new Creator();
    @e.j.e.r.c("message")
    @e
    private final String message;
    @e.j.e.r.c("order_id")
    @e
    private final Integer orderId;
    @e.j.e.r.c("pay_now")
    @e
    private final Boolean payNow;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<OrderConfirmResult> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderConfirmResult createFromParcel(@d Parcel parcel) {
            String readString = parcel.readString();
            Boolean bool = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new OrderConfirmResult(readString, valueOf, bool);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderConfirmResult[] newArray(int i2) {
            return new OrderConfirmResult[i2];
        }
    }

    public OrderConfirmResult() {
        this(null, null, null, 7, null);
    }

    public OrderConfirmResult(@e String str, @e Integer num, @e Boolean bool) {
        this.message = str;
        this.orderId = num;
        this.payNow = bool;
    }

    public static /* synthetic */ OrderConfirmResult copy$default(OrderConfirmResult orderConfirmResult, String str, Integer num, Boolean bool, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = orderConfirmResult.message;
        }
        if ((i2 & 2) != 0) {
            num = orderConfirmResult.orderId;
        }
        if ((i2 & 4) != 0) {
            bool = orderConfirmResult.payNow;
        }
        return orderConfirmResult.copy(str, num, bool);
    }

    @e
    public final String component1() {
        return this.message;
    }

    @e
    public final Integer component2() {
        return this.orderId;
    }

    @e
    public final Boolean component3() {
        return this.payNow;
    }

    @d
    public final OrderConfirmResult copy(@e String str, @e Integer num, @e Boolean bool) {
        return new OrderConfirmResult(str, num, bool);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof OrderConfirmResult) {
            OrderConfirmResult orderConfirmResult = (OrderConfirmResult) obj;
            return f0.g(this.message, orderConfirmResult.message) && f0.g(this.orderId, orderConfirmResult.orderId) && f0.g(this.payNow, orderConfirmResult.payNow);
        }
        return false;
    }

    @e
    public final String getMessage() {
        return this.message;
    }

    @e
    public final Integer getOrderId() {
        return this.orderId;
    }

    @e
    public final Boolean getPayNow() {
        return this.payNow;
    }

    public int hashCode() {
        String str = this.message;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.orderId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Boolean bool = this.payNow;
        return hashCode2 + (bool != null ? bool.hashCode() : 0);
    }

    @d
    public String toString() {
        return "OrderConfirmResult(message=" + ((Object) this.message) + ", orderId=" + this.orderId + ", payNow=" + this.payNow + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.message);
        Integer num = this.orderId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.payNow;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public /* synthetic */ OrderConfirmResult(String str, Integer num, Boolean bool, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : bool);
    }
}
