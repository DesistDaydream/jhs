package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.a2.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt___CollectionsKt;

@c
/* loaded from: classes2.dex */
public final class ShopCartItem implements Parcelable {
    @d
    public static final Parcelable.Creator<ShopCartItem> CREATOR = new Creator();
    @e.j.e.r.c("cart_count")
    @e
    private final Integer cartCount;
    @e.j.e.r.c("carts")
    @e
    private final List<CardProduct> carts;
    @e.j.e.r.c("ecommerce_verify")
    @e
    private final Boolean nameVerify;
    @e.j.e.r.c("seller_user_avatar")
    @e
    private final String sellerAvatar;
    @e.j.e.r.c("seller_user_id")
    @e
    private final Integer sellerId;
    @e.j.e.r.c("seller_user_username")
    @e
    private final String sellerName;
    @e.j.e.r.c("verify_status")
    @e
    private final Integer verifyStatus;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ShopCartItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ShopCartItem createFromParcel(@d Parcel parcel) {
            ArrayList arrayList = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Boolean valueOf2 = parcel.readInt() == 0 ? null : Boolean.valueOf(parcel.readInt() != 0);
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i2 = 0; i2 != readInt; i2++) {
                    arrayList.add(CardProduct.CREATOR.createFromParcel(parcel));
                }
            }
            return new ShopCartItem(valueOf, readString, readString2, valueOf2, valueOf3, valueOf4, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ShopCartItem[] newArray(int i2) {
            return new ShopCartItem[i2];
        }
    }

    public ShopCartItem() {
        this(null, null, null, null, null, null, null, 127, null);
    }

    public ShopCartItem(@e Integer num, @e String str, @e String str2, @e Boolean bool, @e Integer num2, @e Integer num3, @e List<CardProduct> list) {
        this.sellerId = num;
        this.sellerName = str;
        this.sellerAvatar = str2;
        this.nameVerify = bool;
        this.verifyStatus = num2;
        this.cartCount = num3;
        this.carts = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getAllName() {
        String Z2;
        List<CardProduct> list = this.carts;
        if (list == null) {
            Z2 = null;
        } else {
            ArrayList arrayList = new ArrayList(u.Y(list, 10));
            for (CardProduct cardProduct : list) {
                arrayList.add(((Object) cardProduct.getNwName()) + " x" + cardProduct.getQuantity());
            }
            Z2 = CollectionsKt___CollectionsKt.Z2(arrayList, "，", null, null, 0, null, null, 62, null);
        }
        return Z2 != null ? Z2 : "";
    }

    @e
    public final Integer getCartCount() {
        return this.cartCount;
    }

    @d
    public final String getCartCover(int i2) {
        CardProduct cardProduct;
        List<CardProduct> list = this.carts;
        String str = null;
        if (list != null && (cardProduct = (CardProduct) CollectionsKt___CollectionsKt.J2(list, i2)) != null) {
            str = cardProduct.getImg();
        }
        return str != null ? str : "";
    }

    @e
    public final List<CardProduct> getCarts() {
        return this.carts;
    }

    @e
    public final Game getGame(int i2) {
        CardProduct cardProduct;
        List<CardProduct> list = this.carts;
        if (list == null || (cardProduct = (CardProduct) CollectionsKt___CollectionsKt.J2(list, i2)) == null) {
            return null;
        }
        return cardProduct.getGame();
    }

    @e
    public final Boolean getNameVerify() {
        return this.nameVerify;
    }

    @e
    public final String getSellerAvatar() {
        return this.sellerAvatar;
    }

    @e
    public final Integer getSellerId() {
        return this.sellerId;
    }

    @e
    public final String getSellerName() {
        return this.sellerName;
    }

    @e
    public final Integer getVerifyStatus() {
        return this.verifyStatus;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.sellerId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.sellerName);
        parcel.writeString(this.sellerAvatar);
        Boolean bool = this.nameVerify;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num2 = this.verifyStatus;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        Integer num3 = this.cartCount;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        List<CardProduct> list = this.carts;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (CardProduct cardProduct : list) {
            cardProduct.writeToParcel(parcel, i2);
        }
    }

    public /* synthetic */ ShopCartItem(Integer num, String str, String str2, Boolean bool, Integer num2, Integer num3, List list, int i2, h.k2.v.u uVar) {
        this((i2 & 1) != 0 ? null : num, (i2 & 2) != 0 ? null : str, (i2 & 4) != 0 ? null : str2, (i2 & 8) != 0 ? Boolean.FALSE : bool, (i2 & 16) != 0 ? null : num2, (i2 & 32) != 0 ? null : num3, (i2 & 64) != 0 ? null : list);
    }
}
