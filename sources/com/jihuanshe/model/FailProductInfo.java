package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;

@c
/* loaded from: classes2.dex */
public final class FailProductInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<FailProductInfo> CREATOR = new Creator();
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
    @e.j.e.r.c("warehouse_order_received_at")
    @d
    private final String orderReceivedDate;
    @e.j.e.r.c("warehouse_order_uuid")
    @d
    private final String orderUuid;
    @e.j.e.r.c("publish_location")
    @d
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private final int quantity;
    @e.j.e.r.c("type")
    @d
    private final String type;
    @e.j.e.r.c("warehouse_product_fail_id")
    private final int warehouseProductFailId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<FailProductInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final FailProductInfo createFromParcel(@d Parcel parcel) {
            return new FailProductInfo(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final FailProductInfo[] newArray(int i2) {
            return new FailProductInfo[i2];
        }
    }

    public FailProductInfo() {
        this(0, null, 0, null, null, null, null, null, null, 0, null, 0, null, null, 16383, null);
    }

    public FailProductInfo(int i2, @d String str, int i3, @d String str2, @d String str3, @d String str4, @d String str5, @d String str6, @d String str7, int i4, @d String str8, int i5, @d String str9, @d String str10) {
        this.cardId = i2;
        this.cardName = str;
        this.cardVersionId = i3;
        this.cardVersionImageUrl = str2;
        this.cardVersionNumber = str3;
        this.cardVersionRarity = str4;
        this.gameKey = str5;
        this.gameSubKey = str6;
        this.publishLocation = str7;
        this.quantity = i4;
        this.type = str8;
        this.warehouseProductFailId = i5;
        this.orderUuid = str9;
        this.orderReceivedDate = str10;
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

    @d
    public final String getOrderReceivedDate() {
        return this.orderReceivedDate;
    }

    @d
    public final String getOrderUuid() {
        return this.orderUuid;
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

    @d
    public final String getType() {
        return this.type;
    }

    public final int getWarehouseProductFailId() {
        return this.warehouseProductFailId;
    }

    @d
    public final String statusCard() {
        String str = this.type;
        return f0.g(str, "condition") ? "品相不符" : f0.g(str, "missing") ? "卡牌缺失" : "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.cardId);
        parcel.writeString(this.cardName);
        parcel.writeInt(this.cardVersionId);
        parcel.writeString(this.cardVersionImageUrl);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeString(this.publishLocation);
        parcel.writeInt(this.quantity);
        parcel.writeString(this.type);
        parcel.writeInt(this.warehouseProductFailId);
        parcel.writeString(this.orderUuid);
        parcel.writeString(this.orderReceivedDate);
    }

    public /* synthetic */ FailProductInfo(int i2, String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, String str8, int i5, String str9, String str10, int i6, u uVar) {
        this((i6 & 1) != 0 ? 0 : i2, (i6 & 2) != 0 ? "" : str, (i6 & 4) != 0 ? 0 : i3, (i6 & 8) != 0 ? "" : str2, (i6 & 16) != 0 ? "" : str3, (i6 & 32) != 0 ? "" : str4, (i6 & 64) != 0 ? "" : str5, (i6 & 128) != 0 ? "" : str6, (i6 & 256) != 0 ? "" : str7, (i6 & 512) != 0 ? 0 : i4, (i6 & 1024) != 0 ? "" : str8, (i6 & 2048) == 0 ? i5 : 0, (i6 & 4096) != 0 ? "" : str9, (i6 & 8192) == 0 ? str10 : "");
    }
}
