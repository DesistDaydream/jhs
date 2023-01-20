package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.vector.util.Res;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class SellerOrderInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<SellerOrderInfo> CREATOR = new Creator();
    @e.j.e.r.c("return_goods_status")
    private int backStatus;
    @e.j.e.r.c("buyer_user_avatar")
    @e
    private String buyerAvatar;
    @e.j.e.r.c("buyer_user_id")
    private int buyerId;
    @e.j.e.r.c("buyer_username")
    @e
    private String buyerName;
    @e.j.e.r.c("order_id")
    private int id;
    @e.j.e.r.c("order_image")
    @e
    private String image;
    @e.j.e.r.c("order_name")
    @e
    private String name;
    @e.j.e.r.c("total_price")
    private float price;
    @e.j.e.r.c("status")
    @e
    private String status;
    @e.j.e.r.c("created_at")
    @e
    private String time;
    @e.j.e.r.c("order_uuid")
    @e
    private String uuid;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SellerOrderInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SellerOrderInfo createFromParcel(@d Parcel parcel) {
            return new SellerOrderInfo(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SellerOrderInfo[] newArray(int i2) {
            return new SellerOrderInfo[i2];
        }
    }

    public SellerOrderInfo() {
        this(0, null, null, null, 0.0f, null, 0, 0, null, null, null, 2047, null);
    }

    public SellerOrderInfo(int i2, @e String str, @e String str2, @e String str3, float f2, @e String str4, int i3, int i4, @e String str5, @e String str6, @e String str7) {
        this.id = i2;
        this.uuid = str;
        this.name = str2;
        this.image = str3;
        this.price = f2;
        this.status = str4;
        this.backStatus = i3;
        this.buyerId = i4;
        this.buyerName = str5;
        this.buyerAvatar = str6;
        this.time = str7;
    }

    public final int component1() {
        return this.id;
    }

    @e
    public final String component10() {
        return this.buyerAvatar;
    }

    @e
    public final String component11() {
        return this.time;
    }

    @e
    public final String component2() {
        return this.uuid;
    }

    @e
    public final String component3() {
        return this.name;
    }

    @e
    public final String component4() {
        return this.image;
    }

    public final float component5() {
        return this.price;
    }

    @e
    public final String component6() {
        return this.status;
    }

    public final int component7() {
        return this.backStatus;
    }

    public final int component8() {
        return this.buyerId;
    }

    @e
    public final String component9() {
        return this.buyerName;
    }

    @d
    public final SellerOrderInfo copy(int i2, @e String str, @e String str2, @e String str3, float f2, @e String str4, int i3, int i4, @e String str5, @e String str6, @e String str7) {
        return new SellerOrderInfo(i2, str, str2, str3, f2, str4, i3, i4, str5, str6, str7);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof SellerOrderInfo) {
            SellerOrderInfo sellerOrderInfo = (SellerOrderInfo) obj;
            return this.id == sellerOrderInfo.id && f0.g(this.uuid, sellerOrderInfo.uuid) && f0.g(this.name, sellerOrderInfo.name) && f0.g(this.image, sellerOrderInfo.image) && f0.g(Float.valueOf(this.price), Float.valueOf(sellerOrderInfo.price)) && f0.g(this.status, sellerOrderInfo.status) && this.backStatus == sellerOrderInfo.backStatus && this.buyerId == sellerOrderInfo.buyerId && f0.g(this.buyerName, sellerOrderInfo.buyerName) && f0.g(this.buyerAvatar, sellerOrderInfo.buyerAvatar) && f0.g(this.time, sellerOrderInfo.time);
        }
        return false;
    }

    public final int getBackStatus() {
        return this.backStatus;
    }

    @e
    public final String getBuyerAvatar() {
        return this.buyerAvatar;
    }

    public final int getBuyerId() {
        return this.buyerId;
    }

    @e
    public final String getBuyerName() {
        return this.buyerName;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @d
    public final String getOrderNo() {
        Res res = Res.a;
        Object[] objArr = new Object[1];
        String str = this.uuid;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        return res.v(R.string.order_no, objArr);
    }

    @d
    public final CharSequence getOrderPrice() {
        return StringUtil.c(StringUtil.a, this.price, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @d
    public final String getOrderTime() {
        Res res = Res.a;
        Object[] objArr = new Object[1];
        String str = this.time;
        if (str == null) {
            str = "";
        }
        objArr[0] = str;
        return res.v(R.string.order_time, objArr);
    }

    public final float getPrice() {
        return this.price;
    }

    @e
    public final String getStatus() {
        return this.status;
    }

    @d
    public final String getStatusStr() {
        String str = this.status;
        if (str != null) {
            switch (str.hashCode()) {
                case -1561989414:
                    if (str.equals("waiting_to_send")) {
                        return Res.w(Res.a, R.string.order_state_send, null, 2, null);
                    }
                    break;
                case -599445191:
                    if (str.equals("complete")) {
                        return Res.w(Res.a, R.string.order_state_complete, null, 2, null);
                    }
                    break;
                case -14663463:
                    if (str.equals("waiting_to_return_goods")) {
                        return Res.w(Res.a, R.string.common_returning_good, null, 2, null);
                    }
                    break;
                case 503799574:
                    if (str.equals(Constants.STATE_WAITING_PAY)) {
                        return Res.w(Res.a, R.string.order_state_pay, null, 2, null);
                    }
                    break;
                case 1715318318:
                    if (str.equals("waiting_to_confirm")) {
                        return Res.w(Res.a, R.string.order_state_confirm, null, 2, null);
                    }
                    break;
                case 1846491729:
                    if (str.equals("waiting_to_receive")) {
                        return Res.w(Res.a, R.string.order_state_receive, null, 2, null);
                    }
                    break;
                case 2137879114:
                    if (str.equals("waiting_to_refund")) {
                        return this.backStatus == 1 ? Res.w(Res.a, R.string.common_returning_good, null, 2, null) : Res.w(Res.a, R.string.common_refunding, null, 2, null);
                    }
                    break;
            }
        }
        return Res.w(Res.a, R.string.order_state_cancel, null, 2, null);
    }

    @e
    public final String getTime() {
        return this.time;
    }

    @e
    public final String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        int i2 = this.id * 31;
        String str = this.uuid;
        int hashCode = (i2 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.image;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + Float.floatToIntBits(this.price)) * 31;
        String str4 = this.status;
        int hashCode4 = (((((hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31) + this.backStatus) * 31) + this.buyerId) * 31;
        String str5 = this.buyerName;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.buyerAvatar;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.time;
        return hashCode6 + (str7 != null ? str7.hashCode() : 0);
    }

    public final void setBackStatus(int i2) {
        this.backStatus = i2;
    }

    public final void setBuyerAvatar(@e String str) {
        this.buyerAvatar = str;
    }

    public final void setBuyerId(int i2) {
        this.buyerId = i2;
    }

    public final void setBuyerName(@e String str) {
        this.buyerName = str;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    public final void setStatus(@e String str) {
        this.status = str;
    }

    public final void setTime(@e String str) {
        this.time = str;
    }

    public final void setUuid(@e String str) {
        this.uuid = str;
    }

    @d
    public String toString() {
        return "SellerOrderInfo(id=" + this.id + ", uuid=" + ((Object) this.uuid) + ", name=" + ((Object) this.name) + ", image=" + ((Object) this.image) + ", price=" + this.price + ", status=" + ((Object) this.status) + ", backStatus=" + this.backStatus + ", buyerId=" + this.buyerId + ", buyerName=" + ((Object) this.buyerName) + ", buyerAvatar=" + ((Object) this.buyerAvatar) + ", time=" + ((Object) this.time) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.uuid);
        parcel.writeString(this.name);
        parcel.writeString(this.image);
        parcel.writeFloat(this.price);
        parcel.writeString(this.status);
        parcel.writeInt(this.backStatus);
        parcel.writeInt(this.buyerId);
        parcel.writeString(this.buyerName);
        parcel.writeString(this.buyerAvatar);
        parcel.writeString(this.time);
    }

    public /* synthetic */ SellerOrderInfo(int i2, String str, String str2, String str3, float f2, String str4, int i3, int i4, String str5, String str6, String str7, int i5, u uVar) {
        this((i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? null : str, (i5 & 4) != 0 ? null : str2, (i5 & 8) != 0 ? null : str3, (i5 & 16) != 0 ? 0.0f : f2, (i5 & 32) != 0 ? null : str4, (i5 & 64) != 0 ? 0 : i3, (i5 & 128) == 0 ? i4 : 0, (i5 & 256) != 0 ? null : str5, (i5 & 512) != 0 ? null : str6, (i5 & 1024) == 0 ? str7 : null);
    }
}
