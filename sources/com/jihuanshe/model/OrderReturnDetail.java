package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.f0;
import h.k2.v.u;
import h.r0;
import i.c.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Result;

@c
/* loaded from: classes2.dex */
public final class OrderReturnDetail implements Parcelable {
    @d
    public static final Parcelable.Creator<OrderReturnDetail> CREATOR = new Creator();
    @e.j.e.r.c("address")
    @e
    private final String address;
    @e.j.e.r.c("city")
    @e
    private final String city;
    @e.j.e.r.c("created_at")
    @e
    private final String createdAt;
    @e.j.e.r.c("district")
    @e
    private final String district;
    @e.j.e.r.c("express_name")
    @e
    private final String expressName;
    @e.j.e.r.c("express_number")
    @e
    private final String expressNumber;
    @e.j.e.r.c("name")
    @e
    private final String name;
    @e.j.e.r.c("order_image")
    @e
    private final String orderImage;
    @e.j.e.r.c("order_name")
    @e
    private final String orderName;
    @e.j.e.r.c("phone")
    @e
    private final String phone;
    @e.j.e.r.c("postcode")
    @e
    private final String postcode;
    @e.j.e.r.c("province")
    @e
    private final String province;
    @e.j.e.r.c("sent_at")
    @e
    private final String sentAt;
    @e.j.e.r.c("shipping_price")
    @e
    private String shippingPrice;
    @e.j.e.r.c("status")
    @e
    private final String status;
    @e.j.e.r.c("uuid")
    @e
    private final String uuid;
    @e.j.e.r.c("warehouse_return_order_id")
    @e
    private final String warehouseReturnOrderId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<OrderReturnDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderReturnDetail createFromParcel(@d Parcel parcel) {
            return new OrderReturnDetail(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderReturnDetail[] newArray(int i2) {
            return new OrderReturnDetail[i2];
        }
    }

    public OrderReturnDetail() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 131071, null);
    }

    public OrderReturnDetail(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e String str10, @e String str11, @e String str12, @e String str13, @e String str14, @e String str15, @e String str16, @e String str17) {
        this.address = str;
        this.city = str2;
        this.createdAt = str3;
        this.district = str4;
        this.expressName = str5;
        this.expressNumber = str6;
        this.name = str7;
        this.orderImage = str8;
        this.orderName = str9;
        this.phone = str10;
        this.postcode = str11;
        this.province = str12;
        this.sentAt = str13;
        this.status = str14;
        this.uuid = str15;
        this.warehouseReturnOrderId = str16;
        this.shippingPrice = str17;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getAddress() {
        return this.address;
    }

    @d
    public final String getAddressDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.province);
        sb.append(' ');
        sb.append((Object) this.city);
        sb.append(' ');
        sb.append((Object) this.district);
        sb.append(' ');
        String str = this.address;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @e
    public final String getCity() {
        return this.city;
    }

    @e
    public final String getCreatedAt() {
        return this.createdAt;
    }

    @e
    public final String getDistrict() {
        return this.district;
    }

    @e
    public final String getExpressName() {
        return this.expressName;
    }

    @e
    public final String getExpressNumber() {
        return this.expressNumber;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @d
    public final String getOrderExpressName() {
        String str = this.expressName;
        return str == null ? "" : f0.C(str, "：");
    }

    @e
    public final String getOrderImage() {
        return this.orderImage;
    }

    @e
    public final String getOrderName() {
        return this.orderName;
    }

    @e
    public final String getPhone() {
        return this.phone;
    }

    @e
    public final String getPostcode() {
        return this.postcode;
    }

    @d
    public final CharSequence getPrice() {
        String str = this.shippingPrice;
        if (str == null || str.length() == 0) {
            this.shippingPrice = "0";
        }
        try {
            Result.a aVar = Result.Companion;
            return StringUtil.c(StringUtil.a, Float.parseFloat(getShippingPrice()), R.string.shop_price, false, 0, 0, false, 56, null);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return StringUtil.c(StringUtil.a, 0.0f, R.string.shop_price, false, 0, 0, false, 56, null);
        }
    }

    @d
    public final String getPriceStr() {
        String str = this.shippingPrice;
        if (str == null || str.length() == 0) {
            this.shippingPrice = "0";
        }
        try {
            Result.a aVar = Result.Companion;
            StringBuilder sb = new StringBuilder();
            sb.append(h.l2.d.H0(Float.parseFloat(getShippingPrice())));
            sb.append((char) 20803);
            return sb.toString();
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return "0元";
        }
    }

    @e
    public final String getProvince() {
        return this.province;
    }

    @e
    public final String getSentAt() {
        return this.sentAt;
    }

    @e
    public final String getShippingPrice() {
        return this.shippingPrice;
    }

    @d
    public final String getShippingPriceStr() {
        String str = this.shippingPrice;
        if (str == null || str.length() == 0) {
            this.shippingPrice = "0";
        }
        try {
            Result.a aVar = Result.Companion;
            return "支付(邮费" + h.l2.d.H0(Float.parseFloat(getShippingPrice())) + "元)";
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
            return "支付";
        }
    }

    @d
    public final String getShippingPriceTip() {
        return f0.C(this.shippingPrice, "元");
    }

    @e
    public final String getStatus() {
        return this.status;
    }

    @e
    public final String getUuid() {
        return this.uuid;
    }

    @e
    public final String getWarehouseReturnOrderId() {
        return this.warehouseReturnOrderId;
    }

    public final void setShippingPrice(@e String str) {
        this.shippingPrice = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.address);
        parcel.writeString(this.city);
        parcel.writeString(this.createdAt);
        parcel.writeString(this.district);
        parcel.writeString(this.expressName);
        parcel.writeString(this.expressNumber);
        parcel.writeString(this.name);
        parcel.writeString(this.orderImage);
        parcel.writeString(this.orderName);
        parcel.writeString(this.phone);
        parcel.writeString(this.postcode);
        parcel.writeString(this.province);
        parcel.writeString(this.sentAt);
        parcel.writeString(this.status);
        parcel.writeString(this.uuid);
        parcel.writeString(this.warehouseReturnOrderId);
        parcel.writeString(this.shippingPrice);
    }

    public /* synthetic */ OrderReturnDetail(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, int i2, u uVar) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) != 0 ? "" : str10, (i2 & 1024) != 0 ? "" : str11, (i2 & 2048) != 0 ? "" : str12, (i2 & 4096) == 0 ? str13 : null, (i2 & 8192) != 0 ? "" : str14, (i2 & 16384) != 0 ? "" : str15, (i2 & 32768) != 0 ? "" : str16, (i2 & 65536) != 0 ? "" : str17);
    }
}
