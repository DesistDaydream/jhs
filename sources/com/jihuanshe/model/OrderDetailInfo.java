package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.SpannableStringBuilder;
import com.ctetin.expandabletextviewlibrary.ExpandableTextView;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.tencent.qcloud.tuicore.util.DateTimeUtil;
import com.vector.util.Res;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.text.StringsKt__StringsKt;

@c
/* loaded from: classes2.dex */
public class OrderDetailInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<OrderDetailInfo> CREATOR = new Creator();
    @e.j.e.r.c("actual_total_price")
    private float actualPrice;
    @e.j.e.r.c("address")
    @e
    private final String address;
    @e.j.e.r.c("return_goods_status")
    private int backStatus;
    @e.j.e.r.c("can_defer_receive_deadline")
    private final boolean canOvertime;
    @e.j.e.r.c("city")
    @e
    private final String city;
    @e.j.e.r.c("district")
    @e
    private final String district;
    @e.j.e.r.c("express_name")
    @e
    private final String expressName;
    @e.j.e.r.c("express_number")
    @e
    private final String expressNumber;
    @e.j.e.r.c("express_type")
    @e
    private final Integer expressType;
    @e.j.e.r.c("handling_fee")
    @e
    private Float fee;
    @e.j.e.r.c("order_products")
    @e
    private final List<CardProduct> goods;
    @e.j.e.r.c("order_id")
    private final int id;
    @e.j.e.r.c("order_image")
    @e
    private final String image;
    @e.j.e.r.c("receive_left_second")
    @e
    private final Integer leftCount;
    @e.j.e.r.c("order_name")
    @e
    private final String name;
    @e.j.e.r.c("total_price")
    private float orderPrice;
    @e.j.e.r.c("pay_deadline_left")
    @e
    private final Integer payTimeLeft;
    @e.j.e.r.c("phone")
    @e
    private final String phoneNumber;
    @e.j.e.r.c("postcode")
    @e
    private final String postCode;
    @e.j.e.r.c("product_price")
    private final float productPrice;
    @e.j.e.r.c("product_price_snapshot")
    private final float productPriceSnapshot;
    @e.j.e.r.c("province")
    @e
    private final String province;
    @e.j.e.r.c("name")
    @e
    private final String receiverName;
    @e.j.e.r.c("remark")
    @e
    private final String remark;
    @e.j.e.r.c("shipping_price")
    private float shippingPrice;
    @e.j.e.r.c("shipping_price_snapshot")
    private final float shippingPriceSnapshot;
    @e.j.e.r.c("status")
    @e
    private String status;
    @e.j.e.r.c("tech_fee_rate")
    @e
    private final String techFee;
    @e.j.e.r.c("created_at")
    @e
    private final String time;
    @e.j.e.r.c("trans_fee_rate")
    @e
    private final String transFee;
    @e.j.e.r.c(alternate = {"buyer_user_id"}, value = "seller_user_id")
    @e
    private final String uid;
    @e.j.e.r.c(alternate = {"buyer_user_avatar"}, value = "seller_user_avatar")
    @e
    private final String userAvatar;
    @e.j.e.r.c(alternate = {"buyer_username"}, value = "seller_username")
    @e
    private final String userName;
    @e.j.e.r.c("order_uuid")
    @e
    private final String uuid;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<OrderDetailInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderDetailInfo createFromParcel(@d Parcel parcel) {
            float f2;
            ArrayList arrayList;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt2 = parcel.readInt();
            String readString5 = parcel.readString();
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            int i2 = 0;
            boolean z = parcel.readInt() != 0;
            String readString6 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            float readFloat3 = parcel.readFloat();
            float readFloat4 = parcel.readFloat();
            float readFloat5 = parcel.readFloat();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            String readString16 = parcel.readString();
            String readString17 = parcel.readString();
            String readString18 = parcel.readString();
            if (parcel.readInt() == 0) {
                f2 = readFloat2;
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                while (i2 != readInt3) {
                    arrayList2.add(CardProduct.CREATOR.createFromParcel(parcel));
                    i2++;
                    readInt3 = readInt3;
                    readFloat2 = readFloat2;
                }
                f2 = readFloat2;
                arrayList = arrayList2;
            }
            return new OrderDetailInfo(readInt, readString, readString2, readString3, readString4, readInt2, readString5, valueOf, z, readString6, valueOf2, readFloat, f2, readFloat3, readFloat4, readFloat5, readString7, readString8, readString9, readString10, readString11, readString12, readString13, valueOf3, readString14, readString15, readString16, readString17, readString18, arrayList, parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat()), parcel.readString(), parcel.readString(), parcel.readFloat());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderDetailInfo[] newArray(int i2) {
            return new OrderDetailInfo[i2];
        }
    }

    public OrderDetailInfo() {
        this(0, null, null, null, null, 0, null, null, false, null, null, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, -1, 3, null);
    }

    public OrderDetailInfo(int i2, @e String str, @e String str2, @e String str3, @e String str4, int i3, @e String str5, @e Integer num, boolean z, @e String str6, @e Integer num2, float f2, float f3, float f4, float f5, float f6, @e String str7, @e String str8, @e String str9, @e String str10, @e String str11, @e String str12, @e String str13, @e Integer num3, @e String str14, @e String str15, @e String str16, @e String str17, @e String str18, @e List<CardProduct> list, @e Float f7, @e String str19, @e String str20, float f8) {
        this.id = i2;
        this.uuid = str;
        this.name = str2;
        this.image = str3;
        this.status = str4;
        this.backStatus = i3;
        this.remark = str5;
        this.leftCount = num;
        this.canOvertime = z;
        this.time = str6;
        this.payTimeLeft = num2;
        this.orderPrice = f2;
        this.productPrice = f3;
        this.shippingPrice = f4;
        this.productPriceSnapshot = f5;
        this.shippingPriceSnapshot = f6;
        this.receiverName = str7;
        this.phoneNumber = str8;
        this.province = str9;
        this.city = str10;
        this.district = str11;
        this.address = str12;
        this.postCode = str13;
        this.expressType = num3;
        this.expressName = str14;
        this.expressNumber = str15;
        this.uid = str16;
        this.userName = str17;
        this.userAvatar = str18;
        this.goods = list;
        this.fee = f7;
        this.techFee = str19;
        this.transFee = str20;
        this.actualPrice = f8;
    }

    public final int cardNumTotal() {
        List<CardProduct> list = this.goods;
        int i2 = 0;
        if (list != null) {
            for (CardProduct cardProduct : list) {
                i2 += cardProduct.getQuantity();
            }
        }
        return i2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final float getActualPrice() {
        return this.actualPrice;
    }

    @e
    public final String getAddress() {
        return this.address;
    }

    @d
    public final String getAddressDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.province);
        sb.append((Object) this.city);
        sb.append((Object) this.district);
        sb.append((Object) this.address);
        return sb.toString();
    }

    public final int getBackStatus() {
        return this.backStatus;
    }

    public final boolean getCanOvertime() {
        return this.canOvertime;
    }

    @e
    public final String getCity() {
        return this.city;
    }

    @e
    public final String getDistrict() {
        return this.district;
    }

    @d
    public final String getExpectedPriceStr() {
        return Res.a.v(R.string.expected_price, Float.valueOf(this.actualPrice));
    }

    @e
    public final String getExpressName() {
        return this.expressName;
    }

    @d
    public final String getExpressNameStr() {
        return f0.C(this.expressName, "：");
    }

    @e
    public final String getExpressNumber() {
        return this.expressNumber;
    }

    @e
    public final Integer getExpressType() {
        return this.expressType;
    }

    @e
    public final Float getFee() {
        return this.fee;
    }

    @e
    public final List<CardProduct> getGoods() {
        return this.goods;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @e
    public final Integer getLeftCount() {
        return this.leftCount;
    }

    @e
    public final String getName() {
        return this.name;
    }

    public final float getOrderPrice() {
        return this.orderPrice;
    }

    @d
    public final CharSequence getOrderPriceStr() {
        return StringUtil.c(StringUtil.a, this.orderPrice, R.string.shop_price, true, 0, 0, false, 56, null);
    }

    @d
    public final CharSequence getOrderPriceStrBySeller() {
        return StringUtil.c(StringUtil.a, this.actualPrice, R.string.common_total_price, false, 0, 0, false, 60, null);
    }

    @d
    public final CharSequence getOrderPriceStrBySeller2() {
        return StringUtil.c(StringUtil.a, this.actualPrice, R.string.shop_price, true, 0, 0, false, 56, null);
    }

    public final String getPayLeftTimeStr() {
        Integer num = this.payTimeLeft;
        return DateTimeUtil.formatSecondsTo00(num == null ? 0 : num.intValue());
    }

    @e
    public final Integer getPayTimeLeft() {
        return this.payTimeLeft;
    }

    @e
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    @e
    public final String getPostCode() {
        return this.postCode;
    }

    public final float getProductPrice() {
        return this.productPrice;
    }

    public final float getProductPriceSnapshot() {
        return this.productPriceSnapshot;
    }

    @d
    public final String getProductsPriceSnapshotStr() {
        float f2 = this.productPriceSnapshot;
        return ((f2 - ((float) ((int) f2))) > 0.0f ? 1 : ((f2 - ((float) ((int) f2))) == 0.0f ? 0 : -1)) == 0 ? Res.a.v(R.string.shop_price_y, Integer.valueOf((int) f2)) : Res.a.v(R.string.shop_price_y, Float.valueOf(f2));
    }

    @d
    public final String getProductsPriceStr() {
        float f2 = this.productPrice;
        return ((f2 - ((float) ((int) f2))) > 0.0f ? 1 : ((f2 - ((float) ((int) f2))) == 0.0f ? 0 : -1)) == 0 ? Res.a.v(R.string.shop_price_y, Integer.valueOf((int) f2)) : Res.a.v(R.string.shop_price_y, Float.valueOf(f2));
    }

    @e
    public final String getProvince() {
        return this.province;
    }

    @d
    public final CharSequence getReceiveLeftTimeStr() {
        Integer num = this.leftCount;
        String formatSeconds = DateTimeUtil.formatSeconds(num == null ? 0L : num.intValue());
        String v = Res.a.v(R.string.order_sended_tips, formatSeconds);
        int r3 = StringsKt__StringsKt.r3(v, formatSeconds, 0, false, 6, null);
        return e.l.h.f.e.h(new SpannableStringBuilder(v), Res.k(R.color.common_color_1), r3, Integer.valueOf(formatSeconds.length() + r3));
    }

    @e
    public final String getReceiverName() {
        return this.receiverName;
    }

    @e
    public final String getRemark() {
        return this.remark;
    }

    @d
    public final String getServiceCharge() {
        Res res = Res.a;
        Object[] objArr = new Object[2];
        String str = this.techFee;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = this.transFee;
        objArr[1] = str2 != null ? str2 : "";
        return res.v(R.string.service_charge_2, objArr);
    }

    @d
    public final String getServiceCharge2() {
        Res res = Res.a;
        Object[] objArr = new Object[2];
        String str = this.techFee;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        String str2 = this.transFee;
        objArr[1] = str2 != null ? str2 : "";
        return res.v(R.string.service_charge, objArr);
    }

    @d
    public final String getShippingAndFee() {
        Res res = Res.a;
        Object[] objArr = new Object[4];
        StringUtil stringUtil = StringUtil.a;
        objArr[0] = StringUtil.c(stringUtil, this.shippingPrice, R.string.shop_price, true, 0, 0, false, 56, null);
        Float f2 = this.fee;
        objArr[1] = StringUtil.c(stringUtil, f2 == null ? 0.0f : f2.floatValue(), R.string.shop_price, true, 0, 0, false, 56, null);
        String str = this.techFee;
        if (str == null) {
            str = "";
        }
        objArr[2] = str;
        String str2 = this.transFee;
        objArr[3] = str2 != null ? str2 : "";
        return f0.C(res.v(R.string.common_shipping_and_fee, objArr), ExpandableTextView.N);
    }

    public final float getShippingPrice() {
        return this.shippingPrice;
    }

    public final float getShippingPriceSnapshot() {
        return this.shippingPriceSnapshot;
    }

    @d
    public final String getShippingPriceStr() {
        float f2 = this.shippingPrice;
        return ((f2 - ((float) ((int) f2))) > 0.0f ? 1 : ((f2 - ((float) ((int) f2))) == 0.0f ? 0 : -1)) == 0 ? Res.a.v(R.string.shop_price_y, Integer.valueOf((int) f2)) : Res.a.v(R.string.shop_price_y, Float.valueOf(f2));
    }

    @d
    public final String getShippingSnapshotStr() {
        float f2 = this.shippingPriceSnapshot;
        return ((f2 - ((float) ((int) f2))) > 0.0f ? 1 : ((f2 - ((float) ((int) f2))) == 0.0f ? 0 : -1)) == 0 ? Res.a.v(R.string.shop_price_y, Integer.valueOf((int) f2)) : Res.a.v(R.string.shop_price_y, Float.valueOf(f2));
    }

    @e
    public final String getStatus() {
        return this.status;
    }

    @e
    public final String getTechFee() {
        return this.techFee;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    @e
    public final String getTransFee() {
        return this.transFee;
    }

    @e
    public final String getUid() {
        return this.uid;
    }

    @e
    public final String getUserAvatar() {
        return this.userAvatar;
    }

    @e
    public final String getUserName() {
        return this.userName;
    }

    @e
    public final String getUuid() {
        return this.uuid;
    }

    public final boolean isComplete() {
        return f0.g(this.status, "complete");
    }

    public final boolean isWaitConfirm() {
        return f0.g(this.status, "waiting_to_confirm");
    }

    public final boolean isWaitPay() {
        return f0.g(this.status, Constants.STATE_WAITING_PAY);
    }

    public final boolean isWaitReceive() {
        return f0.g(this.status, "waiting_to_receive");
    }

    public final boolean isWaitSend() {
        return f0.g(this.status, "waiting_to_send");
    }

    public final void setActualPrice(float f2) {
        this.actualPrice = f2;
    }

    public final void setBackStatus(int i2) {
        this.backStatus = i2;
    }

    public final void setFee(@e Float f2) {
        this.fee = f2;
    }

    public final void setOrderPrice(float f2) {
        this.orderPrice = f2;
    }

    public final void setShippingPrice(float f2) {
        this.shippingPrice = f2;
    }

    public final void setStatus(@e String str) {
        this.status = str;
    }

    @d
    public final CharSequence shippingStr() {
        return StringUtil.c(StringUtil.a, this.shippingPrice, R.string.common_shipping, true, 0, 0, false, 56, null);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.uuid);
        parcel.writeString(this.name);
        parcel.writeString(this.image);
        parcel.writeString(this.status);
        parcel.writeInt(this.backStatus);
        parcel.writeString(this.remark);
        Integer num = this.leftCount;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeInt(this.canOvertime ? 1 : 0);
        parcel.writeString(this.time);
        Integer num2 = this.payTimeLeft;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeFloat(this.orderPrice);
        parcel.writeFloat(this.productPrice);
        parcel.writeFloat(this.shippingPrice);
        parcel.writeFloat(this.productPriceSnapshot);
        parcel.writeFloat(this.shippingPriceSnapshot);
        parcel.writeString(this.receiverName);
        parcel.writeString(this.phoneNumber);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.district);
        parcel.writeString(this.address);
        parcel.writeString(this.postCode);
        Integer num3 = this.expressType;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        parcel.writeString(this.expressName);
        parcel.writeString(this.expressNumber);
        parcel.writeString(this.uid);
        parcel.writeString(this.userName);
        parcel.writeString(this.userAvatar);
        List<CardProduct> list = this.goods;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CardProduct cardProduct : list) {
                cardProduct.writeToParcel(parcel, i2);
            }
        }
        Float f2 = this.fee;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeString(this.techFee);
        parcel.writeString(this.transFee);
        parcel.writeFloat(this.actualPrice);
    }

    public /* synthetic */ OrderDetailInfo(int i2, String str, String str2, String str3, String str4, int i3, String str5, Integer num, boolean z, String str6, Integer num2, float f2, float f3, float f4, float f5, float f6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, Integer num3, String str14, String str15, String str16, String str17, String str18, List list, Float f7, String str19, String str20, float f8, int i4, int i5, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? 0 : i3, (i4 & 64) != 0 ? null : str5, (i4 & 128) != 0 ? 0 : num, (i4 & 256) == 0 ? z : false, (i4 & 512) != 0 ? null : str6, (i4 & 1024) != 0 ? null : num2, (i4 & 2048) != 0 ? 0.0f : f2, (i4 & 4096) != 0 ? 0.0f : f3, (i4 & 8192) != 0 ? 0.0f : f4, (i4 & 16384) != 0 ? 0.0f : f5, (i4 & 32768) != 0 ? 0.0f : f6, (i4 & 65536) != 0 ? null : str7, (i4 & 131072) != 0 ? null : str8, (i4 & 262144) != 0 ? null : str9, (i4 & 524288) != 0 ? null : str10, (i4 & 1048576) != 0 ? null : str11, (i4 & 2097152) != 0 ? null : str12, (i4 & 4194304) != 0 ? null : str13, (i4 & 8388608) != 0 ? null : num3, (i4 & 16777216) != 0 ? null : str14, (i4 & 33554432) != 0 ? null : str15, (i4 & 67108864) != 0 ? null : str16, (i4 & 134217728) != 0 ? null : str17, (i4 & 268435456) != 0 ? null : str18, (i4 & 536870912) != 0 ? null : list, (i4 & 1073741824) != 0 ? null : f7, (i4 & Integer.MIN_VALUE) != 0 ? null : str19, (i5 & 1) != 0 ? null : str20, (i5 & 2) != 0 ? 0.0f : f8);
    }
}
