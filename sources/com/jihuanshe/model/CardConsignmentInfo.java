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
public final class CardConsignmentInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<CardConsignmentInfo> CREATOR = new Creator();
    @e.j.e.r.c("created_at")
    @d
    private final String createdAt;
    @e.j.e.r.c("express_image")
    @d
    private final String expressImage;
    @e.j.e.r.c("express_name")
    @d
    private final String expressName;
    @e.j.e.r.c("express_number")
    @d
    private final String expressNumber;
    @e.j.e.r.c("order_image")
    @d
    private final String orderImage;
    @e.j.e.r.c("order_name")
    @d
    private final String orderName;
    @e.j.e.r.c("status")
    @d
    private final String status;
    @e.j.e.r.c("uuid")
    @d
    private final String uuid;
    @e.j.e.r.c("warehouse_order_id")
    private final int warehouseOrderId;
    @e.j.e.r.c("warehouse_return_order_id")
    private final int warehouseReturnOrderId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardConsignmentInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardConsignmentInfo createFromParcel(@d Parcel parcel) {
            return new CardConsignmentInfo(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardConsignmentInfo[] newArray(int i2) {
            return new CardConsignmentInfo[i2];
        }
    }

    public CardConsignmentInfo() {
        this(0, 0, null, null, null, null, null, null, null, null, 1023, null);
    }

    public CardConsignmentInfo(int i2, int i3, @d String str, @d String str2, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, @d String str8) {
        this.warehouseOrderId = i2;
        this.warehouseReturnOrderId = i3;
        this.uuid = str;
        this.orderName = str2;
        this.orderImage = str3;
        this.status = str4;
        this.expressName = str5;
        this.expressNumber = str6;
        this.createdAt = str7;
        this.expressImage = str8;
    }

    public final int component1() {
        return this.warehouseOrderId;
    }

    @d
    public final String component10() {
        return this.expressImage;
    }

    public final int component2() {
        return this.warehouseReturnOrderId;
    }

    @d
    public final String component3() {
        return this.uuid;
    }

    @d
    public final String component4() {
        return this.orderName;
    }

    @d
    public final String component5() {
        return this.orderImage;
    }

    @d
    public final String component6() {
        return this.status;
    }

    @d
    public final String component7() {
        return this.expressName;
    }

    @d
    public final String component8() {
        return this.expressNumber;
    }

    @d
    public final String component9() {
        return this.createdAt;
    }

    @d
    public final CardConsignmentInfo copy(int i2, int i3, @d String str, @d String str2, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, @d String str8) {
        return new CardConsignmentInfo(i2, i3, str, str2, str3, str4, str5, str6, str7, str8);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CardConsignmentInfo) {
            CardConsignmentInfo cardConsignmentInfo = (CardConsignmentInfo) obj;
            return this.warehouseOrderId == cardConsignmentInfo.warehouseOrderId && this.warehouseReturnOrderId == cardConsignmentInfo.warehouseReturnOrderId && f0.g(this.uuid, cardConsignmentInfo.uuid) && f0.g(this.orderName, cardConsignmentInfo.orderName) && f0.g(this.orderImage, cardConsignmentInfo.orderImage) && f0.g(this.status, cardConsignmentInfo.status) && f0.g(this.expressName, cardConsignmentInfo.expressName) && f0.g(this.expressNumber, cardConsignmentInfo.expressNumber) && f0.g(this.createdAt, cardConsignmentInfo.createdAt) && f0.g(this.expressImage, cardConsignmentInfo.expressImage);
        }
        return false;
    }

    @d
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @d
    public final String getExpressImage() {
        return this.expressImage;
    }

    @d
    public final String getExpressName() {
        return this.expressName;
    }

    @d
    public final String getExpressNumber() {
        return this.expressNumber;
    }

    @d
    public final String getOrderExpressName() {
        String str = this.expressName;
        return str == null ? "" : f0.C(str, "：");
    }

    @d
    public final String getOrderImage() {
        return this.orderImage;
    }

    @d
    public final String getOrderName() {
        return this.orderName;
    }

    @d
    public final String getStatus() {
        return this.status;
    }

    @d
    public final String getUuid() {
        return this.uuid;
    }

    @d
    public final String getUuidStr() {
        return f0.C("订单号：", this.uuid);
    }

    public final int getWarehouseOrderId() {
        return this.warehouseOrderId;
    }

    public final int getWarehouseReturnOrderId() {
        return this.warehouseReturnOrderId;
    }

    public int hashCode() {
        return (((((((((((((((((this.warehouseOrderId * 31) + this.warehouseReturnOrderId) * 31) + this.uuid.hashCode()) * 31) + this.orderName.hashCode()) * 31) + this.orderImage.hashCode()) * 31) + this.status.hashCode()) * 31) + this.expressName.hashCode()) * 31) + this.expressNumber.hashCode()) * 31) + this.createdAt.hashCode()) * 31) + this.expressImage.hashCode();
    }

    @d
    public String toString() {
        return "CardConsignmentInfo(warehouseOrderId=" + this.warehouseOrderId + ", warehouseReturnOrderId=" + this.warehouseReturnOrderId + ", uuid=" + this.uuid + ", orderName=" + this.orderName + ", orderImage=" + this.orderImage + ", status=" + this.status + ", expressName=" + this.expressName + ", expressNumber=" + this.expressNumber + ", createdAt=" + this.createdAt + ", expressImage=" + this.expressImage + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.warehouseOrderId);
        parcel.writeInt(this.warehouseReturnOrderId);
        parcel.writeString(this.uuid);
        parcel.writeString(this.orderName);
        parcel.writeString(this.orderImage);
        parcel.writeString(this.status);
        parcel.writeString(this.expressName);
        parcel.writeString(this.expressNumber);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.expressImage);
    }

    public /* synthetic */ CardConsignmentInfo(int i2, int i3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) == 0 ? i3 : 0, (i4 & 4) != 0 ? "" : str, (i4 & 8) != 0 ? "" : str2, (i4 & 16) != 0 ? "" : str3, (i4 & 32) != 0 ? "" : str4, (i4 & 64) != 0 ? "" : str5, (i4 & 128) != 0 ? "" : str6, (i4 & 256) != 0 ? "" : str7, (i4 & 512) == 0 ? str8 : "");
    }
}
