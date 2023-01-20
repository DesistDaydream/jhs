package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ApplyForItem implements Parcelable {
    @d
    public static final Parcelable.Creator<ApplyForItem> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    @e
    private final Float avgPrice;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    @e
    private final Integer cardId;
    @e.j.e.r.c("card_name")
    @e
    private final String cardName;
    @e.j.e.r.c("card_version_id")
    @e
    private final Integer cardVersionId;
    @e.j.e.r.c("card_version_image_url")
    @e
    private final String cardVersionImageUrl;
    @e.j.e.r.c("card_version_number")
    @e
    private final String cardVersionNumber;
    @e.j.e.r.c("card_version_rarity")
    @e
    private final String cardVersionRarity;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private final String gameSubKey;
    @e.j.e.r.c("min_price")
    private final float minPrice;
    @e.j.e.r.c("need_publish_location")
    @e
    private final Boolean needPublishLocation;
    @e.j.e.r.c("price")
    private final float price;
    @e.j.e.r.c("publish_location")
    @e
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    @e
    private final Integer quantity;
    @e.j.e.r.c("quantity_fail")
    @e
    private final Integer quantityFail;
    @e.j.e.r.c("quantity_pass")
    @e
    private final Integer quantityPass;
    @e.j.e.r.c("warehouse_order_product_id")
    @e
    private final Integer warehouseOrderProductId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ApplyForItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ApplyForItem createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            Float valueOf2 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            float readFloat = parcel.readFloat();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new ApplyForItem(valueOf2, valueOf3, readString, valueOf4, readString2, readString3, readString4, readString5, readString6, readFloat, valueOf, parcel.readFloat(), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ApplyForItem[] newArray(int i2) {
            return new ApplyForItem[i2];
        }
    }

    public ApplyForItem() {
        this(null, null, null, null, null, null, null, null, null, 0.0f, null, 0.0f, null, null, null, null, null, 131071, null);
    }

    public ApplyForItem(@e Float f2, @e Integer num, @e String str, @e Integer num2, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, float f3, @e Boolean bool, float f4, @e String str7, @e Integer num3, @e Integer num4, @e Integer num5, @e Integer num6) {
        this.avgPrice = f2;
        this.cardId = num;
        this.cardName = str;
        this.cardVersionId = num2;
        this.cardVersionImageUrl = str2;
        this.cardVersionNumber = str3;
        this.cardVersionRarity = str4;
        this.gameKey = str5;
        this.gameSubKey = str6;
        this.minPrice = f3;
        this.needPublishLocation = bool;
        this.price = f4;
        this.publishLocation = str7;
        this.quantity = num3;
        this.quantityFail = num4;
        this.quantityPass = num5;
        this.warehouseOrderProductId = num6;
    }

    @e
    public final Float component1() {
        return this.avgPrice;
    }

    public final float component10() {
        return this.minPrice;
    }

    @e
    public final Boolean component11() {
        return this.needPublishLocation;
    }

    public final float component12() {
        return this.price;
    }

    @e
    public final String component13() {
        return this.publishLocation;
    }

    @e
    public final Integer component14() {
        return this.quantity;
    }

    @e
    public final Integer component15() {
        return this.quantityFail;
    }

    @e
    public final Integer component16() {
        return this.quantityPass;
    }

    @e
    public final Integer component17() {
        return this.warehouseOrderProductId;
    }

    @e
    public final Integer component2() {
        return this.cardId;
    }

    @e
    public final String component3() {
        return this.cardName;
    }

    @e
    public final Integer component4() {
        return this.cardVersionId;
    }

    @e
    public final String component5() {
        return this.cardVersionImageUrl;
    }

    @e
    public final String component6() {
        return this.cardVersionNumber;
    }

    @e
    public final String component7() {
        return this.cardVersionRarity;
    }

    @e
    public final String component8() {
        return this.gameKey;
    }

    @e
    public final String component9() {
        return this.gameSubKey;
    }

    @d
    public final ApplyForItem copy(@e Float f2, @e Integer num, @e String str, @e Integer num2, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, float f3, @e Boolean bool, float f4, @e String str7, @e Integer num3, @e Integer num4, @e Integer num5, @e Integer num6) {
        return new ApplyForItem(f2, num, str, num2, str2, str3, str4, str5, str6, f3, bool, f4, str7, num3, num4, num5, num6);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ApplyForItem) {
            ApplyForItem applyForItem = (ApplyForItem) obj;
            return f0.g(this.avgPrice, applyForItem.avgPrice) && f0.g(this.cardId, applyForItem.cardId) && f0.g(this.cardName, applyForItem.cardName) && f0.g(this.cardVersionId, applyForItem.cardVersionId) && f0.g(this.cardVersionImageUrl, applyForItem.cardVersionImageUrl) && f0.g(this.cardVersionNumber, applyForItem.cardVersionNumber) && f0.g(this.cardVersionRarity, applyForItem.cardVersionRarity) && f0.g(this.gameKey, applyForItem.gameKey) && f0.g(this.gameSubKey, applyForItem.gameSubKey) && f0.g(Float.valueOf(this.minPrice), Float.valueOf(applyForItem.minPrice)) && f0.g(this.needPublishLocation, applyForItem.needPublishLocation) && f0.g(Float.valueOf(this.price), Float.valueOf(applyForItem.price)) && f0.g(this.publishLocation, applyForItem.publishLocation) && f0.g(this.quantity, applyForItem.quantity) && f0.g(this.quantityFail, applyForItem.quantityFail) && f0.g(this.quantityPass, applyForItem.quantityPass) && f0.g(this.warehouseOrderProductId, applyForItem.warehouseOrderProductId);
        }
        return false;
    }

    @e
    public final Float getAvgPrice() {
        return this.avgPrice;
    }

    @e
    public final Integer getCardId() {
        return this.cardId;
    }

    @e
    public final String getCardName() {
        return this.cardName;
    }

    @d
    public final CharSequence getCardPrice() {
        float f2 = this.price;
        if (f2 == 0.0f) {
            return StringUtil.c(StringUtil.a, this.minPrice, 0, false, 0, 0, false, 62, null);
        }
        return StringUtil.c(StringUtil.a, f2, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @e
    public final Integer getCardVersionId() {
        return this.cardVersionId;
    }

    @e
    public final String getCardVersionImageUrl() {
        return this.cardVersionImageUrl;
    }

    @e
    public final String getCardVersionNumber() {
        return this.cardVersionNumber;
    }

    @e
    public final String getCardVersionRarity() {
        return this.cardVersionRarity;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @e
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    @d
    public final String getLocation() {
        String str = this.publishLocation;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3398) {
                if (hashCode != 3003594) {
                    if (hashCode == 1544803905) {
                        str.equals("default");
                    }
                } else if (str.equals("asia")) {
                    return "亚洲版";
                }
            } else if (str.equals("jp")) {
                return "日本版";
            }
        }
        return "";
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final Boolean getNeedPublishLocation() {
        return this.needPublishLocation;
    }

    public final float getPrice() {
        return this.price;
    }

    @e
    public final String getPublishLocation() {
        return this.publishLocation;
    }

    @e
    public final Integer getQuantity() {
        return this.quantity;
    }

    @d
    public final String getQuantityContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.quantity);
        sb.append((char) 24352);
        return sb.toString();
    }

    @e
    public final Integer getQuantityFail() {
        return this.quantityFail;
    }

    @e
    public final Integer getQuantityPass() {
        return this.quantityPass;
    }

    @e
    public final Integer getWarehouseOrderProductId() {
        return this.warehouseOrderProductId;
    }

    public int hashCode() {
        Float f2 = this.avgPrice;
        int hashCode = (f2 == null ? 0 : f2.hashCode()) * 31;
        Integer num = this.cardId;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str = this.cardName;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.cardVersionId;
        int hashCode4 = (hashCode3 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str2 = this.cardVersionImageUrl;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardVersionNumber;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.cardVersionRarity;
        int hashCode7 = (hashCode6 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.gameKey;
        int hashCode8 = (hashCode7 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.gameSubKey;
        int hashCode9 = (((hashCode8 + (str6 == null ? 0 : str6.hashCode())) * 31) + Float.floatToIntBits(this.minPrice)) * 31;
        Boolean bool = this.needPublishLocation;
        int hashCode10 = (((hashCode9 + (bool == null ? 0 : bool.hashCode())) * 31) + Float.floatToIntBits(this.price)) * 31;
        String str7 = this.publishLocation;
        int hashCode11 = (hashCode10 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Integer num3 = this.quantity;
        int hashCode12 = (hashCode11 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.quantityFail;
        int hashCode13 = (hashCode12 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.quantityPass;
        int hashCode14 = (hashCode13 + (num5 == null ? 0 : num5.hashCode())) * 31;
        Integer num6 = this.warehouseOrderProductId;
        return hashCode14 + (num6 != null ? num6.hashCode() : 0);
    }

    @d
    public String toString() {
        return "ApplyForItem(avgPrice=" + this.avgPrice + ", cardId=" + this.cardId + ", cardName=" + ((Object) this.cardName) + ", cardVersionId=" + this.cardVersionId + ", cardVersionImageUrl=" + ((Object) this.cardVersionImageUrl) + ", cardVersionNumber=" + ((Object) this.cardVersionNumber) + ", cardVersionRarity=" + ((Object) this.cardVersionRarity) + ", gameKey=" + ((Object) this.gameKey) + ", gameSubKey=" + ((Object) this.gameSubKey) + ", minPrice=" + this.minPrice + ", needPublishLocation=" + this.needPublishLocation + ", price=" + this.price + ", publishLocation=" + ((Object) this.publishLocation) + ", quantity=" + this.quantity + ", quantityFail=" + this.quantityFail + ", quantityPass=" + this.quantityPass + ", warehouseOrderProductId=" + this.warehouseOrderProductId + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Float f2 = this.avgPrice;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        Integer num = this.cardId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.cardName);
        Integer num2 = this.cardVersionId;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.cardVersionImageUrl);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeFloat(this.minPrice);
        Boolean bool = this.needPublishLocation;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        parcel.writeFloat(this.price);
        parcel.writeString(this.publishLocation);
        Integer num3 = this.quantity;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.quantityFail;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        Integer num5 = this.quantityPass;
        if (num5 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num5.intValue());
        }
        Integer num6 = this.warehouseOrderProductId;
        if (num6 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num6.intValue());
    }

    public /* synthetic */ ApplyForItem(Float f2, Integer num, String str, Integer num2, String str2, String str3, String str4, String str5, String str6, float f3, Boolean bool, float f4, String str7, Integer num3, Integer num4, Integer num5, Integer num6, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : f2, (i2 & 2) != 0 ? null : num, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : num2, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? null : str3, (i2 & 64) != 0 ? null : str4, (i2 & 128) != 0 ? null : str5, (i2 & 256) != 0 ? null : str6, (i2 & 512) != 0 ? 0.0f : f3, (i2 & 1024) != 0 ? null : bool, (i2 & 2048) == 0 ? f4 : 0.0f, (i2 & 4096) != 0 ? null : str7, (i2 & 8192) != 0 ? null : num3, (i2 & 16384) != 0 ? null : num4, (i2 & 32768) != 0 ? null : num5, (i2 & 65536) != 0 ? null : num6);
    }
}
