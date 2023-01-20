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
public final class OrderReturnInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<OrderReturnInfo> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int cardId;
    @e.j.e.r.c("card_name")
    @e
    private final String cardName;
    @e.j.e.r.c("card_version_id")
    private final int cardVersionId;
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
    @e.j.e.r.c("publish_location")
    @e
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private final int quantity;
    @e.j.e.r.c("type")
    @e
    private final String type;
    @e.j.e.r.c("warehouse_return_order_id")
    @e
    private final String warehouseReturnOrderId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<OrderReturnInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderReturnInfo createFromParcel(@d Parcel parcel) {
            return new OrderReturnInfo(parcel.readInt(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final OrderReturnInfo[] newArray(int i2) {
            return new OrderReturnInfo[i2];
        }
    }

    public OrderReturnInfo() {
        this(0, null, 0, null, null, null, null, null, null, 0, null, null, 4095, null);
    }

    public OrderReturnInfo(int i2, @e String str, int i3, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, int i4, @e String str8, @e String str9) {
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
        this.warehouseReturnOrderId = str9;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final int getCardId() {
        return this.cardId;
    }

    @e
    public final String getCardName() {
        return this.cardName;
    }

    public final int getCardVersionId() {
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

    @e
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

    @e
    public final String getType() {
        return this.type;
    }

    @e
    public final String getWarehouseReturnOrderId() {
        return this.warehouseReturnOrderId;
    }

    public final boolean isFail() {
        return f0.g(this.type, "fail");
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
        parcel.writeString(this.warehouseReturnOrderId);
    }

    public /* synthetic */ OrderReturnInfo(int i2, String str, int i3, String str2, String str3, String str4, String str5, String str6, String str7, int i4, String str8, String str9, int i5, u uVar) {
        this((i5 & 1) != 0 ? 0 : i2, (i5 & 2) != 0 ? "" : str, (i5 & 4) != 0 ? 0 : i3, (i5 & 8) != 0 ? "" : str2, (i5 & 16) != 0 ? "" : str3, (i5 & 32) != 0 ? "" : str4, (i5 & 64) != 0 ? "" : str5, (i5 & 128) != 0 ? "" : str6, (i5 & 256) != 0 ? "" : str7, (i5 & 512) == 0 ? i4 : 0, (i5 & 1024) != 0 ? "" : str8, (i5 & 2048) == 0 ? str9 : "");
    }
}
