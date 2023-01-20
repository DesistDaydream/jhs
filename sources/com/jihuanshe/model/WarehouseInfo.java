package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class WarehouseInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<WarehouseInfo> CREATOR = new Creator();
    @e.j.e.r.c("max_quantity")
    private final int maxQuantity;
    @e.j.e.r.c("max_quantity_rule")
    @d
    private final String ruleUrl;
    @e.j.e.r.c("sale_amount")
    private final int saleAmount;
    @e.j.e.r.c("sold_quantity")
    private final int soldQuantity;
    @e.j.e.r.c("used_quantity")
    private final int usedQuantity;
    @e.j.e.r.c("warehouse_instruction")
    @e
    private final String wareIns;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WarehouseInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WarehouseInfo createFromParcel(@d Parcel parcel) {
            return new WarehouseInfo(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WarehouseInfo[] newArray(int i2) {
            return new WarehouseInfo[i2];
        }
    }

    public WarehouseInfo() {
        this(0, 0, 0, null, 0, null, 63, null);
    }

    public WarehouseInfo(int i2, int i3, int i4, @d String str, int i5, @e String str2) {
        this.soldQuantity = i2;
        this.usedQuantity = i3;
        this.maxQuantity = i4;
        this.ruleUrl = str;
        this.saleAmount = i5;
        this.wareIns = str2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getMaxQuantity() {
        return this.maxQuantity;
    }

    @d
    public final String getMaxQuantityStr() {
        return String.valueOf(this.maxQuantity);
    }

    @d
    public final String getRuleUrl() {
        return this.ruleUrl;
    }

    public final int getSaleAmount() {
        return this.saleAmount;
    }

    @d
    public final String getSaleAmountStr() {
        return String.valueOf(this.saleAmount);
    }

    public final int getSoldQuantity() {
        return this.soldQuantity;
    }

    @d
    public final String getSoldQuantityStr() {
        return String.valueOf(this.soldQuantity);
    }

    public final int getUsedQuantity() {
        return this.usedQuantity;
    }

    @d
    public final String getUsedQuantityStr() {
        return String.valueOf(this.usedQuantity);
    }

    @e
    public final String getWareIns() {
        return this.wareIns;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.soldQuantity);
        parcel.writeInt(this.usedQuantity);
        parcel.writeInt(this.maxQuantity);
        parcel.writeString(this.ruleUrl);
        parcel.writeInt(this.saleAmount);
        parcel.writeString(this.wareIns);
    }

    public /* synthetic */ WarehouseInfo(int i2, int i3, int i4, String str, int i5, String str2, int i6, u uVar) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 0 : i3, (i6 & 4) != 0 ? 0 : i4, (i6 & 8) != 0 ? "" : str, (i6 & 16) == 0 ? i5 : 0, (i6 & 32) != 0 ? null : str2);
    }
}
