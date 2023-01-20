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
public final class ApplyForOrder implements Parcelable {
    @d
    public static final Parcelable.Creator<ApplyForOrder> CREATOR = new Creator();
    @e.j.e.r.c("created_at")
    @e
    private final String createdAt;
    @e.j.e.r.c("receive_address")
    @e
    private final String receiveAddress;
    @e.j.e.r.c("receive_name")
    @e
    private final String receiveName;
    @e.j.e.r.c("receive_phone")
    @e
    private final String receivePhone;
    @e.j.e.r.c("uuid")
    @e
    private final String uuid;
    @e.j.e.r.c("warehouse_order_id")
    @e
    private final Integer warehouseOrderId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ApplyForOrder> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ApplyForOrder createFromParcel(@d Parcel parcel) {
            return new ApplyForOrder(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ApplyForOrder[] newArray(int i2) {
            return new ApplyForOrder[i2];
        }
    }

    public ApplyForOrder() {
        this(null, null, null, null, null, null, 63, null);
    }

    public ApplyForOrder(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e Integer num) {
        this.createdAt = str;
        this.receiveAddress = str2;
        this.receiveName = str3;
        this.receivePhone = str4;
        this.uuid = str5;
        this.warehouseOrderId = num;
    }

    public static /* synthetic */ ApplyForOrder copy$default(ApplyForOrder applyForOrder, String str, String str2, String str3, String str4, String str5, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = applyForOrder.createdAt;
        }
        if ((i2 & 2) != 0) {
            str2 = applyForOrder.receiveAddress;
        }
        String str6 = str2;
        if ((i2 & 4) != 0) {
            str3 = applyForOrder.receiveName;
        }
        String str7 = str3;
        if ((i2 & 8) != 0) {
            str4 = applyForOrder.receivePhone;
        }
        String str8 = str4;
        if ((i2 & 16) != 0) {
            str5 = applyForOrder.uuid;
        }
        String str9 = str5;
        if ((i2 & 32) != 0) {
            num = applyForOrder.warehouseOrderId;
        }
        return applyForOrder.copy(str, str6, str7, str8, str9, num);
    }

    @e
    public final String component1() {
        return this.createdAt;
    }

    @e
    public final String component2() {
        return this.receiveAddress;
    }

    @e
    public final String component3() {
        return this.receiveName;
    }

    @e
    public final String component4() {
        return this.receivePhone;
    }

    @e
    public final String component5() {
        return this.uuid;
    }

    @e
    public final Integer component6() {
        return this.warehouseOrderId;
    }

    @d
    public final ApplyForOrder copy(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e Integer num) {
        return new ApplyForOrder(str, str2, str3, str4, str5, num);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplyForOrder) {
            ApplyForOrder applyForOrder = (ApplyForOrder) obj;
            return f0.g(this.createdAt, applyForOrder.createdAt) && f0.g(this.receiveAddress, applyForOrder.receiveAddress) && f0.g(this.receiveName, applyForOrder.receiveName) && f0.g(this.receivePhone, applyForOrder.receivePhone) && f0.g(this.uuid, applyForOrder.uuid) && f0.g(this.warehouseOrderId, applyForOrder.warehouseOrderId);
        }
        return false;
    }

    @d
    public final String getCopyStr() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.receiveName);
        sb.append(' ');
        sb.append((Object) this.receivePhone);
        sb.append(' ');
        sb.append((Object) this.receiveAddress);
        return sb.toString();
    }

    @e
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final String getReceiveAddress() {
        return this.receiveAddress;
    }

    @e
    public final String getReceiveName() {
        return this.receiveName;
    }

    @e
    public final String getReceivePhone() {
        return this.receivePhone;
    }

    @e
    public final String getUuid() {
        return this.uuid;
    }

    @e
    public final Integer getWarehouseOrderId() {
        return this.warehouseOrderId;
    }

    public int hashCode() {
        String str = this.createdAt;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.receiveAddress;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.receiveName;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.receivePhone;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.uuid;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        Integer num = this.warehouseOrderId;
        return hashCode5 + (num != null ? num.hashCode() : 0);
    }

    @d
    public String toString() {
        return "ApplyForOrder(createdAt=" + ((Object) this.createdAt) + ", receiveAddress=" + ((Object) this.receiveAddress) + ", receiveName=" + ((Object) this.receiveName) + ", receivePhone=" + ((Object) this.receivePhone) + ", uuid=" + ((Object) this.uuid) + ", warehouseOrderId=" + this.warehouseOrderId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        int intValue;
        parcel.writeString(this.createdAt);
        parcel.writeString(this.receiveAddress);
        parcel.writeString(this.receiveName);
        parcel.writeString(this.receivePhone);
        parcel.writeString(this.uuid);
        Integer num = this.warehouseOrderId;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
    }

    public /* synthetic */ ApplyForOrder(String str, String str2, String str3, String str4, String str5, Integer num, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : num);
    }
}
