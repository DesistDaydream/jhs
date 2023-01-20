package com.jihuanshe.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.s0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import k.e.a.d;
import k.e.a.e;
import kotlin.collections.CollectionsKt__CollectionsKt;

@c
/* loaded from: classes2.dex */
public final class CardProductNew implements Parcelable {
    @d
    public static final Parcelable.Creator<CardProductNew> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    private float avgPrice;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private int cardId;
    @e.j.e.r.c("card_name_cn")
    @d
    private String cardNameCn;
    @e.j.e.r.c("card_sub_name")
    @d
    private String cardSubName;
    @e.j.e.r.c("card_version_default_image")
    @e
    private String cardVersionDefaultImage;
    @a
    @e
    private Integer cardVersionId;
    @e.j.e.r.c("card_version_image")
    @d
    private String cardVersionImage;
    @e.j.e.r.c("card_version_number")
    @d
    private String cardVersionNumber;
    @e.j.e.r.c("card_version_rarity")
    @d
    private String cardVersionRarity;
    @a
    private boolean clickCloseDefaultImage;
    @e.j.e.r.c("default_product")
    @e
    private GameCard defaultProduct;
    @a
    @e
    private final Game game;
    @a
    @e
    private String gameKey;
    @a
    @e
    private Uri localPhoto;
    @e.j.e.r.c("min_price")
    private float minPrice;
    @e.j.e.r.c("need_publish_location")
    private boolean needPublishLocation;
    @e.j.e.r.c("price")
    private float price;
    @e.j.e.r.c("product_language")
    @e
    private String productLan;
    @e.j.e.r.c("products")
    @e
    private List<? extends GameCard> products;
    @e.j.e.r.c("user_card_version_image")
    @e
    private String userUploadPhotoPath;
    @e.j.e.r.c("warehouse")
    private final boolean warehouse;
    @e.j.e.r.c("warehouse_pending_order_products")
    @d
    private List<PendingProduct> warehousePendingProducts;
    @e.j.e.r.c("warehouse_products")
    @d
    private List<PendingProduct> warehouseProducts;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardProductNew> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardProductNew createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            float readFloat3 = parcel.readFloat();
            boolean z = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt2);
                for (int i2 = 0; i2 != readInt2; i2++) {
                    arrayList2.add(parcel.readParcelable(CardProductNew.class.getClassLoader()));
                }
                arrayList = arrayList2;
            }
            boolean z2 = parcel.readInt() != 0;
            int readInt3 = parcel.readInt();
            ArrayList arrayList3 = new ArrayList(readInt3);
            int i3 = 0;
            while (i3 != readInt3) {
                arrayList3.add(PendingProduct.CREATOR.createFromParcel(parcel));
                i3++;
                readInt3 = readInt3;
            }
            int readInt4 = parcel.readInt();
            ArrayList arrayList4 = new ArrayList(readInt4);
            int i4 = 0;
            while (i4 != readInt4) {
                arrayList4.add(PendingProduct.CREATOR.createFromParcel(parcel));
                i4++;
                readInt4 = readInt4;
            }
            return new CardProductNew(readFloat, readFloat2, readInt, readString, readString2, readString3, readString4, readString5, readString6, readFloat3, z, arrayList, z2, arrayList3, arrayList4, parcel.readString(), parcel.readString(), (GameCard) parcel.readParcelable(CardProductNew.class.getClassLoader()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardProductNew[] newArray(int i2) {
            return new CardProductNew[i2];
        }
    }

    public CardProductNew() {
        this(0.0f, 0.0f, 0, null, null, null, null, null, null, 0.0f, false, null, false, null, null, null, null, null, 262143, null);
    }

    public CardProductNew(float f2, float f3, int i2, @d String str, @d String str2, @d String str3, @e String str4, @d String str5, @d String str6, float f4, boolean z, @e List<? extends GameCard> list, boolean z2, @d List<PendingProduct> list2, @d List<PendingProduct> list3, @e String str7, @e String str8, @e GameCard gameCard) {
        this.avgPrice = f2;
        this.price = f3;
        this.cardId = i2;
        this.cardNameCn = str;
        this.cardSubName = str2;
        this.cardVersionImage = str3;
        this.cardVersionDefaultImage = str4;
        this.cardVersionNumber = str5;
        this.cardVersionRarity = str6;
        this.minPrice = f4;
        this.needPublishLocation = z;
        this.products = list;
        this.warehouse = z2;
        this.warehousePendingProducts = list2;
        this.warehouseProducts = list3;
        this.userUploadPhotoPath = str7;
        this.productLan = str8;
        this.defaultProduct = gameCard;
    }

    public final void clearImage() {
        this.localPhoto = null;
        this.userUploadPhotoPath = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getAvf() {
        if (this.avgPrice > 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.avgPrice);
            sb.append((char) 165);
            return sb.toString();
        }
        return "暂无";
    }

    public final float getAvgPrice() {
        return this.avgPrice;
    }

    @d
    public final CharSequence getCardAvgPrice() {
        float f2 = this.avgPrice;
        return (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? "暂无" : StringUtil.c(StringUtil.a, f2, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    public final int getCardId() {
        return this.cardId;
    }

    @d
    public final CharSequence getCardMinPrice() {
        float f2 = this.minPrice;
        return (f2 > 0.0f ? 1 : (f2 == 0.0f ? 0 : -1)) == 0 ? "暂无" : StringUtil.c(StringUtil.a, f2, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @d
    public final String getCardNameCn() {
        return this.cardNameCn;
    }

    @d
    public final String getCardSubName() {
        return this.cardSubName;
    }

    @d
    public final String getCardVerRarity() {
        return f0.C("罕贵度：", this.cardVersionRarity);
    }

    @e
    public final String getCardVersionDefaultImage() {
        return this.cardVersionDefaultImage;
    }

    @e
    public final Integer getCardVersionId() {
        Integer num = this.cardVersionId;
        if (num == null) {
            return 0;
        }
        return num;
    }

    @d
    public final String getCardVersionImage() {
        return this.cardVersionImage;
    }

    @d
    public final String getCardVersionNum() {
        return f0.C("编号：", this.cardVersionNumber);
    }

    @d
    public final String getCardVersionNumber() {
        return this.cardVersionNumber;
    }

    @d
    public final String getCardVersionRarity() {
        return this.cardVersionRarity;
    }

    public final boolean getClickCloseDefaultImage() {
        return this.clickCloseDefaultImage;
    }

    @e
    public final GameCard getDefaultProduct() {
        return this.defaultProduct;
    }

    @e
    public final Game getGame() {
        Game game = this.game;
        return game == null ? e.l.l.a.a(this.gameKey) : game;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @d
    public final String getImg() {
        return this.cardVersionImage;
    }

    @e
    public final Uri getLocalPhoto() {
        return this.localPhoto;
    }

    @d
    public final String getMin() {
        if (this.minPrice > 0.0f) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.minPrice);
            sb.append((char) 165);
            return sb.toString();
        }
        return "暂无";
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    public final boolean getNeedPublishLocation() {
        return this.needPublishLocation;
    }

    public final float getPrice() {
        return this.price;
    }

    @d
    public final CharSequence getPrice2() {
        float f2 = this.price;
        if (f2 == 0.0f) {
            return "";
        }
        s0 s0Var = s0.a;
        return String.format("%.2f", Arrays.copyOf(new Object[]{Float.valueOf(f2)}, 1));
    }

    @e
    public final String getProductLan() {
        return this.productLan;
    }

    @e
    public final List<GameCard> getProducts() {
        return this.products;
    }

    @e
    public final String getUserUploadPhotoPath() {
        return this.userUploadPhotoPath;
    }

    public final boolean getWarehouse() {
        return this.warehouse;
    }

    @d
    public final List<PendingProduct> getWarehousePendingProducts() {
        return this.warehousePendingProducts;
    }

    @d
    public final List<PendingProduct> getWarehouseProducts() {
        return this.warehouseProducts;
    }

    public final boolean hasImage() {
        if (this.localPhoto == null) {
            String str = this.userUploadPhotoPath;
            if (str == null || str.length() == 0) {
                return false;
            }
        }
        return true;
    }

    public final void setAvgPrice(float f2) {
        this.avgPrice = f2;
    }

    public final void setCardId(int i2) {
        this.cardId = i2;
    }

    public final void setCardNameCn(@d String str) {
        this.cardNameCn = str;
    }

    public final void setCardSubName(@d String str) {
        this.cardSubName = str;
    }

    public final void setCardVersionDefaultImage(@e String str) {
        this.cardVersionDefaultImage = str;
    }

    public final void setCardVersionId(@e Integer num) {
        this.cardVersionId = num;
    }

    public final void setCardVersionImage(@d String str) {
        this.cardVersionImage = str;
    }

    public final void setCardVersionNumber(@d String str) {
        this.cardVersionNumber = str;
    }

    public final void setCardVersionRarity(@d String str) {
        this.cardVersionRarity = str;
    }

    public final void setClickCloseDefaultImage(boolean z) {
        this.clickCloseDefaultImage = z;
    }

    public final void setDefaultProduct(@e GameCard gameCard) {
        this.defaultProduct = gameCard;
    }

    public final void setGameKey(@e String str) {
        this.gameKey = str;
    }

    public final void setLocalPhoto(@e Uri uri) {
        this.localPhoto = uri;
    }

    public final void setMinPrice(float f2) {
        this.minPrice = f2;
    }

    public final void setNeedPublishLocation(boolean z) {
        this.needPublishLocation = z;
    }

    public final void setPrice(float f2) {
        this.price = f2;
    }

    public final void setProductLan(@e String str) {
        this.productLan = str;
    }

    public final void setProducts(@e List<? extends GameCard> list) {
        this.products = list;
    }

    public final void setUserUploadPhotoPath(@e String str) {
        this.userUploadPhotoPath = str;
    }

    public final void setWarehousePendingProducts(@d List<PendingProduct> list) {
        this.warehousePendingProducts = list;
    }

    public final void setWarehouseProducts(@d List<PendingProduct> list) {
        this.warehouseProducts = list;
    }

    public final boolean showDefaultImage() {
        if (!hasImage()) {
            String str = this.cardVersionDefaultImage;
            if (!(str == null || str.length() == 0) && !this.clickCloseDefaultImage) {
                return true;
            }
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeFloat(this.avgPrice);
        parcel.writeFloat(this.price);
        parcel.writeInt(this.cardId);
        parcel.writeString(this.cardNameCn);
        parcel.writeString(this.cardSubName);
        parcel.writeString(this.cardVersionImage);
        parcel.writeString(this.cardVersionDefaultImage);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeFloat(this.minPrice);
        parcel.writeInt(this.needPublishLocation ? 1 : 0);
        List<? extends GameCard> list = this.products;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (GameCard gameCard : list) {
                parcel.writeParcelable(gameCard, i2);
            }
        }
        parcel.writeInt(this.warehouse ? 1 : 0);
        List<PendingProduct> list2 = this.warehousePendingProducts;
        parcel.writeInt(list2.size());
        for (PendingProduct pendingProduct : list2) {
            pendingProduct.writeToParcel(parcel, i2);
        }
        List<PendingProduct> list3 = this.warehouseProducts;
        parcel.writeInt(list3.size());
        for (PendingProduct pendingProduct2 : list3) {
            pendingProduct2.writeToParcel(parcel, i2);
        }
        parcel.writeString(this.userUploadPhotoPath);
        parcel.writeString(this.productLan);
        parcel.writeParcelable(this.defaultProduct, i2);
    }

    public /* synthetic */ CardProductNew(float f2, float f3, int i2, String str, String str2, String str3, String str4, String str5, String str6, float f4, boolean z, List list, boolean z2, List list2, List list3, String str7, String str8, GameCard gameCard, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0.0f : f2, (i3 & 2) != 0 ? 0.0f : f3, (i3 & 4) != 0 ? 0 : i2, (i3 & 8) != 0 ? "" : str, (i3 & 16) != 0 ? "" : str2, (i3 & 32) != 0 ? "" : str3, (i3 & 64) != 0 ? "" : str4, (i3 & 128) != 0 ? "" : str5, (i3 & 256) == 0 ? str6 : "", (i3 & 512) == 0 ? f4 : 0.0f, (i3 & 1024) != 0 ? false : z, (i3 & 2048) != 0 ? CollectionsKt__CollectionsKt.E() : list, (i3 & 4096) == 0 ? z2 : false, (i3 & 8192) != 0 ? CollectionsKt__CollectionsKt.E() : list2, (i3 & 16384) != 0 ? CollectionsKt__CollectionsKt.E() : list3, (i3 & 32768) != 0 ? null : str7, (i3 & 65536) != 0 ? null : str8, (i3 & 131072) == 0 ? gameCard : null);
    }
}
