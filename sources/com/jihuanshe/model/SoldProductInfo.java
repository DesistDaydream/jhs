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
public final class SoldProductInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<SoldProductInfo> CREATOR = new Creator();
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
    @e.j.e.r.c("order_product_id")
    private final int orderProductId;
    @e.j.e.r.c("price")
    private final float price;
    @e.j.e.r.c("publish_location")
    @d
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private final int quantity;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SoldProductInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SoldProductInfo createFromParcel(@d Parcel parcel) {
            return new SoldProductInfo(parcel.readInt(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readFloat(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SoldProductInfo[] newArray(int i2) {
            return new SoldProductInfo[i2];
        }
    }

    public SoldProductInfo() {
        this(0, 0, null, 0, null, null, null, null, null, null, 0.0f, 0, 4095, null);
    }

    public SoldProductInfo(int i2, int i3, @d String str, int i4, @d String str2, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, float f2, int i5) {
        this.orderProductId = i2;
        this.cardId = i3;
        this.cardName = str;
        this.cardVersionId = i4;
        this.cardVersionNumber = str2;
        this.cardVersionRarity = str3;
        this.cardVersionImageUrl = str4;
        this.gameKey = str5;
        this.gameSubKey = str6;
        this.publishLocation = str7;
        this.price = f2;
        this.quantity = i5;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
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
            return StringUtil.c(StringUtil.a, 0.0f, 0, false, 0, 0, false, 62, null);
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

    public final int getOrderProductId() {
        return this.orderProductId;
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

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.orderProductId);
        parcel.writeInt(this.cardId);
        parcel.writeString(this.cardName);
        parcel.writeInt(this.cardVersionId);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeString(this.cardVersionImageUrl);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeString(this.publishLocation);
        parcel.writeFloat(this.price);
        parcel.writeInt(this.quantity);
    }

    public /* synthetic */ SoldProductInfo(int i2, int i3, String str, int i4, String str2, String str3, String str4, String str5, String str6, String str7, float f2, int i5, int i6, u uVar) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? 0 : i3, (i6 & 4) != 0 ? "" : str, (i6 & 8) != 0 ? 0 : i4, (i6 & 16) != 0 ? "" : str2, (i6 & 32) != 0 ? "" : str3, (i6 & 64) != 0 ? "" : str4, (i6 & 128) != 0 ? "" : str5, (i6 & 256) != 0 ? "" : str6, (i6 & 512) == 0 ? str7 : "", (i6 & 1024) != 0 ? 0.0f : f2, (i6 & 2048) == 0 ? i5 : 0);
    }
}
