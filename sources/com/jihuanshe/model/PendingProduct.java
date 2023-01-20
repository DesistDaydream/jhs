package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;

@c
/* loaded from: classes2.dex */
public final class PendingProduct implements Parcelable {
    @d
    public static final Parcelable.Creator<PendingProduct> CREATOR = new Creator();
    @e.j.e.r.c("price")
    private float price;
    @e.j.e.r.c("publish_location")
    @d
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private int quantity;
    @e.j.e.r.c("warehouse_order_product_id")
    private final int warehouseOrderProductId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<PendingProduct> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PendingProduct createFromParcel(@d Parcel parcel) {
            return new PendingProduct(parcel.readFloat(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PendingProduct[] newArray(int i2) {
            return new PendingProduct[i2];
        }
    }

    public PendingProduct() {
        this(0.0f, null, 0, 0, 15, null);
    }

    public PendingProduct(float f2, @d String str, int i2, int i3) {
        this.price = f2;
        this.publishLocation = str;
        this.quantity = i2;
        this.warehouseOrderProductId = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final float getPrice() {
        return this.price;
    }

    @d
    public final CharSequence getProductPrice() {
        return StringUtil.c(StringUtil.a, this.price, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @d
    public final String getPublishLocation() {
        return this.publishLocation;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    public final int getWarehouseOrderProductId() {
        return this.warehouseOrderProductId;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    public final void setQuantity(int i2) {
        this.quantity = i2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeFloat(this.price);
        parcel.writeString(this.publishLocation);
        parcel.writeInt(this.quantity);
        parcel.writeInt(this.warehouseOrderProductId);
    }

    public /* synthetic */ PendingProduct(float f2, String str, int i2, int i3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0.0f : f2, (i4 & 2) != 0 ? "" : str, (i4 & 4) != 0 ? 0 : i2, (i4 & 8) != 0 ? 0 : i3);
    }
}
