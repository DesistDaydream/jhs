package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class WarehouseProductInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<WarehouseProductInfo> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    @e
    private final String avgPrice;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int cardId;
    @e.j.e.r.c("card_name")
    @d
    private final String cardName;
    @e.j.e.r.c("card_version_id")
    private final int cardVersionId;
    @e.j.e.r.c("card_version_image_url")
    @d
    private final String cardVersionImageUrl;
    @e.j.e.r.c("card_version_number")
    @d
    private final String cardVersionNumber;
    @e.j.e.r.c("card_version_rarity")
    @d
    private final String cardVersionRarity;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @d
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @d
    private final String gameSubKey;
    @e.j.e.r.c("min_price")
    @e
    private final String minPrice;
    @e.j.e.r.c("price")
    private float price;
    @e.j.e.r.c("publish_location")
    @d
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private final int quantity;
    @e.j.e.r.c("warehouse_product_id")
    private final int warehouseProductId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WarehouseProductInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WarehouseProductInfo createFromParcel(@d Parcel parcel) {
            return new WarehouseProductInfo(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readString(), parcel.readInt(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WarehouseProductInfo[] newArray(int i2) {
            return new WarehouseProductInfo[i2];
        }
    }

    public WarehouseProductInfo() {
        this(null, 0, null, 0, null, null, null, null, null, null, 0.0f, null, 0, 0, 16383, null);
    }

    public WarehouseProductInfo(@e String str, int i2, @d String str2, int i3, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, @e String str8, float f2, @d String str9, int i4, int i5) {
        this.avgPrice = str;
        this.cardId = i2;
        this.cardName = str2;
        this.cardVersionId = i3;
        this.cardVersionImageUrl = str3;
        this.cardVersionNumber = str4;
        this.cardVersionRarity = str5;
        this.gameKey = str6;
        this.gameSubKey = str7;
        this.minPrice = str8;
        this.price = f2;
        this.publishLocation = str9;
        this.quantity = i4;
        this.warehouseProductId = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getAvgPrice() {
        return this.avgPrice;
    }

    public final int getCardId() {
        return this.cardId;
    }

    @d
    public final String getCardName() {
        return this.cardName;
    }

    @d
    public final CharSequence getCardPrice() {
        float f2 = this.price;
        if (f2 == 0.0f) {
            StringUtil stringUtil = StringUtil.a;
            String str = this.minPrice;
            if (str == null) {
                str = "0";
            }
            return StringUtil.c(stringUtil, Float.parseFloat(str), 0, false, 0, 0, false, 62, null);
        }
        return StringUtil.c(StringUtil.a, f2, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    public final int getCardVersionId() {
        return this.cardVersionId;
    }

    @d
    public final String getCardVersionImageUrl() {
        return this.cardVersionImageUrl;
    }

    @d
    public final String getCardVersionNumber() {
        return this.cardVersionNumber;
    }

    @d
    public final String getCardVersionRarity() {
        return this.cardVersionRarity;
    }

    @d
    public final String getGameKey() {
        return this.gameKey;
    }

    @d
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    @d
    public final String getLocation() {
        String str = this.publishLocation;
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
        return "";
    }

    @e
    public final String getMinPrice() {
        return this.minPrice;
    }

    public final float getPrice() {
        return this.price;
    }

    @d
    public final String getPublishLocation() {
        return this.publishLocation;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @d
    public final String getQuantityContent() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.quantity);
        sb.append((char) 24352);
        return sb.toString();
    }

    public final int getWarehouseProductId() {
        return this.warehouseProductId;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.avgPrice);
        parcel.writeInt(this.cardId);
        parcel.writeString(this.cardName);
        parcel.writeInt(this.cardVersionId);
        parcel.writeString(this.cardVersionImageUrl);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeString(this.minPrice);
        parcel.writeFloat(this.price);
        parcel.writeString(this.publishLocation);
        parcel.writeInt(this.quantity);
        parcel.writeInt(this.warehouseProductId);
    }

    public /* synthetic */ WarehouseProductInfo(String str, int i2, String str2, int i3, String str3, String str4, String str5, String str6, String str7, String str8, float f2, String str9, int i4, int i5, int i6, u uVar) {
        this((i6 & 1) != 0 ? null : str, (i6 & 2) != 0 ? 0 : i2, (i6 & 4) != 0 ? "" : str2, (i6 & 8) != 0 ? 0 : i3, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? "" : str4, (i6 & 64) != 0 ? "" : str5, (i6 & 128) != 0 ? "" : str6, (i6 & 256) != 0 ? "" : str7, (i6 & 512) == 0 ? str8 : null, (i6 & 1024) != 0 ? 0.0f : f2, (i6 & 2048) == 0 ? str9 : "", (i6 & 4096) != 0 ? 0 : i4, (i6 & 8192) == 0 ? i5 : 0);
    }
}
