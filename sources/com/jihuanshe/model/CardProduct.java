package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import com.moor.imkf.model.entity.FromToMessage;
import com.umeng.analytics.pro.am;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardProduct implements Parcelable {
    @d
    public static final Parcelable.Creator<CardProduct> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    @e
    private final Float avgPrice;
    @e.j.e.r.c(alternate = {"price"}, value = "product_price")
    private final float cardPrice;
    @e.j.e.r.c("cart_id")
    private final int cid;
    @e.j.e.r.c(alternate = {"card_name_cn_cnocg"}, value = "name_cn_cnocg")
    @e
    private final String cnocgname;
    @a
    @e
    private Game game;
    @e.j.e.r.c(alternate = {"product_game_key"}, value = Constants.KEY_PARAM_GAME_KEY)
    @e
    private String gameKey;
    @e.j.e.r.c(alternate = {"product_game_sub_key"}, value = Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private String gameSubKey;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int id;
    @e.j.e.r.c(alternate = {"card_version_image", FromToMessage.MSG_TYPE_IMAGE}, value = "image_url")
    @e
    private String image;
    @e.j.e.r.c("is_selling")
    private final boolean isSelling;
    @e.j.e.r.c(am.N)
    @e
    private final String lan;
    @e.j.e.r.c("max_wish_price")
    private final float maxWantPrice;
    @e.j.e.r.c("min_price")
    private final float minPrice;
    @e.j.e.r.c(alternate = {"card_name_cn", "title"}, value = "name_cn")
    @e
    private String nwName;
    @e.j.e.r.c("cart_price")
    private final float originPrice;
    @e.j.e.r.c("pay_count")
    private final int payCount;
    @e.j.e.r.c(Constants.KEY_PARAM_PRODUCT_ID)
    private final int pid;
    @e.j.e.r.c(alternate = {"condition"}, value = "product_condition")
    private final int productCondition;
    @e.j.e.r.c("product_language")
    @e
    private String productLan;
    @e.j.e.r.c("product_quantity")
    private final int productQuantity;
    @e.j.e.r.c(alternate = {"remark"}, value = "product_remark")
    @e
    private final String productRemark;
    @e.j.e.r.c("cart_status")
    private final int productStatus;
    @e.j.e.r.c("products")
    @e
    private List<CardProduct> products;
    @e.j.e.r.c(alternate = {"publish_location"}, value = "product_publish_location")
    @e
    private String publishLocation;
    @e.j.e.r.c("quantity")
    private int quantity;
    @e.j.e.r.c(alternate = {"card_version_rarity"}, value = "rarity")
    @e
    private String rarity;
    @a
    private transient int selectCount;
    @e.j.e.r.c("seller_user_avatar")
    @e
    private final String sellerAvatar;
    @e.j.e.r.c("seller_city")
    @e
    private final String sellerCity;
    @e.j.e.r.c("seller_user_id")
    private final int sellerId;
    @e.j.e.r.c("seller_username")
    @e
    private final String sellerName;
    @e.j.e.r.c("seller_province")
    @e
    private final String sellerProvince;
    @e.j.e.r.c("card_sub_name")
    @e
    private final String subName;
    @e.j.e.r.c("user_card_version_image")
    @e
    private String userCardImg;
    @e.j.e.r.c("card_version_id")
    private int versionId;
    @e.j.e.r.c(alternate = {"card_version_number"}, value = "number")
    @e
    private String versionNum;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardProduct> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardProduct createFromParcel(@d Parcel parcel) {
            String str;
            String str2;
            String str3;
            ArrayList arrayList;
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            int readInt4 = parcel.readInt();
            String readString = parcel.readString();
            int readInt5 = parcel.readInt();
            float readFloat = parcel.readFloat();
            int readInt6 = parcel.readInt();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            int readInt7 = parcel.readInt();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            float readFloat2 = parcel.readFloat();
            Float valueOf = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            float readFloat3 = parcel.readFloat();
            int readInt8 = parcel.readInt();
            float readFloat4 = parcel.readFloat();
            boolean z = parcel.readInt() != 0;
            int readInt9 = parcel.readInt();
            String readString9 = parcel.readString();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            int readInt10 = parcel.readInt();
            if (parcel.readInt() == 0) {
                str3 = readString5;
                str2 = readString6;
                arrayList = null;
                str = readString7;
            } else {
                int readInt11 = parcel.readInt();
                str = readString7;
                ArrayList arrayList2 = new ArrayList(readInt11);
                str2 = readString6;
                int i2 = 0;
                while (i2 != readInt11) {
                    arrayList2.add(CardProduct.CREATOR.createFromParcel(parcel));
                    i2++;
                    readInt11 = readInt11;
                    readString5 = readString5;
                }
                str3 = readString5;
                arrayList = arrayList2;
            }
            return new CardProduct(readInt, readInt2, readInt3, readInt4, readString, readInt5, readFloat, readInt6, readString2, readString3, readString4, readInt7, str3, str2, str, readString8, readFloat2, valueOf, readFloat3, readInt8, readFloat4, z, readInt9, readString9, readString10, readString11, readString12, readInt10, arrayList, parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardProduct[] newArray(int i2) {
            return new CardProduct[i2];
        }
    }

    public CardProduct(int i2, int i3, int i4, int i5, @e String str, int i6, float f2, int i7, @e String str2, @e String str3, @e String str4, int i8, @e String str5, @e String str6, @e String str7, @e String str8, float f3, @e Float f4, float f5, int i9, float f6, boolean z, int i10, @e String str9, @e String str10, @e String str11, @e String str12, int i11, @e List<CardProduct> list, @e String str13, @e String str14, @e String str15, @e String str16, @e String str17) {
        this.cid = i2;
        this.pid = i3;
        this.productQuantity = i4;
        this.productCondition = i5;
        this.productRemark = str;
        this.productStatus = i6;
        this.originPrice = f2;
        this.id = i7;
        this.nwName = str2;
        this.cnocgname = str3;
        this.subName = str4;
        this.versionId = i8;
        this.versionNum = str5;
        this.rarity = str6;
        this.image = str7;
        this.lan = str8;
        this.minPrice = f3;
        this.avgPrice = f4;
        this.cardPrice = f5;
        this.payCount = i9;
        this.maxWantPrice = f6;
        this.isSelling = z;
        this.sellerId = i10;
        this.sellerName = str9;
        this.sellerAvatar = str10;
        this.sellerProvince = str11;
        this.sellerCity = str12;
        this.quantity = i11;
        this.products = list;
        this.productLan = str13;
        this.publishLocation = str14;
        this.userCardImg = str15;
        this.gameKey = str16;
        this.gameSubKey = str17;
        this.selectCount = 1;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(CardProduct.class, obj == null ? null : obj.getClass()) && super.equals(obj)) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.CardProduct");
            return this.pid == ((CardProduct) obj).pid;
        }
        return false;
    }

    @e
    public final Float getAvgPrice() {
        return this.avgPrice;
    }

    public final float getCardPrice() {
        return this.cardPrice;
    }

    public final int getCid() {
        return this.cid;
    }

    @e
    public final String getCnocgname() {
        return this.cnocgname;
    }

    @d
    public final String getConditionStr() {
        return CardProductKt.getConditionStr(this.productCondition) + "  " + lanStr();
    }

    @d
    public final String getConditionText() {
        return CardProductKt.getConditionStr(this.productCondition);
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @e
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @d
    public final String getImg() {
        String str;
        String str2 = this.userCardImg;
        if (!(str2 == null || str2.length() == 0)) {
            str = this.userCardImg;
            if (str == null) {
                return "";
            }
        } else {
            str = this.image;
            if (str == null) {
                return "";
            }
        }
        return str;
    }

    @e
    public final String getLan() {
        return this.lan;
    }

    @d
    public final String getLocation() {
        String str = this.publishLocation;
        return f0.g(str, "asia") ? "亚洲版" : f0.g(str, "jp") ? "日本版" : "";
    }

    public final float getMaxWantPrice() {
        return this.maxWantPrice;
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final String getNwName() {
        return this.nwName;
    }

    public final float getOriginPrice() {
        return this.originPrice;
    }

    public final int getPayCount() {
        return this.payCount;
    }

    public final int getPid() {
        return this.pid;
    }

    @d
    public final CharSequence getPrice() {
        float f2 = this.cardPrice;
        if (f2 == 0.0f) {
            return StringUtil.c(StringUtil.a, this.minPrice, 0, false, 0, 0, false, 62, null);
        }
        return StringUtil.c(StringUtil.a, f2, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @d
    public final CharSequence getPrice2() {
        return StringUtil.c(StringUtil.a, this.cardPrice, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    public final int getProductCondition() {
        return this.productCondition;
    }

    @e
    public final String getProductLan() {
        return this.productLan;
    }

    public final int getProductQuantity() {
        return this.productQuantity;
    }

    @e
    public final String getProductRemark() {
        return this.productRemark;
    }

    public final int getProductStatus() {
        return this.productStatus;
    }

    @e
    public final List<CardProduct> getProducts() {
        return this.products;
    }

    @e
    public final String getPublishLocation() {
        return this.publishLocation;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @d
    public final String getQuantityStr() {
        return String.valueOf(this.quantity);
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @d
    public final String getRemarkStr() {
        String location = getLocation();
        boolean z = true;
        if (location.length() > 0) {
            String str = this.productRemark;
            if (str != null && str.length() != 0) {
                z = false;
            }
            if (z) {
                return location;
            }
            return location + (char) 65292 + ((Object) this.productRemark);
        }
        String str2 = this.productRemark;
        return str2 != null ? str2 : "";
    }

    public final int getSelectCount() {
        return this.selectCount;
    }

    @e
    public final String getSellerAvatar() {
        return this.sellerAvatar;
    }

    @e
    public final String getSellerCity() {
        return this.sellerCity;
    }

    public final int getSellerId() {
        return this.sellerId;
    }

    @e
    public final String getSellerName() {
        return this.sellerName;
    }

    @e
    public final String getSellerProvince() {
        return this.sellerProvince;
    }

    @e
    public final String getSubName() {
        return this.subName;
    }

    @e
    public final String getUserCardImg() {
        return this.userCardImg;
    }

    public final int getVersionId() {
        return this.versionId;
    }

    @e
    public final String getVersionNum() {
        return this.versionNum;
    }

    public int hashCode() {
        return (super.hashCode() * 31) + this.pid;
    }

    public final boolean isSelling() {
        return this.isSelling;
    }

    public final boolean isShowLan() {
        return f0.g(this.productLan, "简中");
    }

    public final boolean isShowSubName() {
        String str = this.subName;
        return (str == null || f0.g(str, "")) ? false : true;
    }

    @d
    public final String lanStr() {
        String str = this.lan;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 3241) {
                if (hashCode != 3398) {
                    if (hashCode != 3664) {
                        if (hashCode == 3695 && str.equals("tc")) {
                            return "繁中";
                        }
                    } else if (str.equals("sc")) {
                        return "简中";
                    }
                } else if (str.equals("jp")) {
                    return "日版";
                }
            } else if (str.equals("en")) {
                return "英文";
            }
        }
        return "";
    }

    public final boolean priceRed() {
        return this.minPrice > 0.0f || this.cardPrice > 0.0f;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setGameKey(@e String str) {
        this.gameKey = str;
    }

    public final void setGameSubKey(@e String str) {
        this.gameSubKey = str;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setNwName(@e String str) {
        this.nwName = str;
    }

    public final void setProductLan(@e String str) {
        this.productLan = str;
    }

    public final void setProducts(@e List<CardProduct> list) {
        this.products = list;
    }

    public final void setPublishLocation(@e String str) {
        this.publishLocation = str;
    }

    public final void setQuantity(int i2) {
        this.quantity = i2;
    }

    public final void setRarity(@e String str) {
        this.rarity = str;
    }

    public final void setSelectCount(int i2) {
        this.selectCount = i2;
    }

    public final void setUserCardImg(@e String str) {
        this.userCardImg = str;
    }

    public final void setVersionId(int i2) {
        this.versionId = i2;
    }

    public final void setVersionNum(@e String str) {
        this.versionNum = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.cid);
        parcel.writeInt(this.pid);
        parcel.writeInt(this.productQuantity);
        parcel.writeInt(this.productCondition);
        parcel.writeString(this.productRemark);
        parcel.writeInt(this.productStatus);
        parcel.writeFloat(this.originPrice);
        parcel.writeInt(this.id);
        parcel.writeString(this.nwName);
        parcel.writeString(this.cnocgname);
        parcel.writeString(this.subName);
        parcel.writeInt(this.versionId);
        parcel.writeString(this.versionNum);
        parcel.writeString(this.rarity);
        parcel.writeString(this.image);
        parcel.writeString(this.lan);
        parcel.writeFloat(this.minPrice);
        Float f2 = this.avgPrice;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeFloat(this.cardPrice);
        parcel.writeInt(this.payCount);
        parcel.writeFloat(this.maxWantPrice);
        parcel.writeInt(this.isSelling ? 1 : 0);
        parcel.writeInt(this.sellerId);
        parcel.writeString(this.sellerName);
        parcel.writeString(this.sellerAvatar);
        parcel.writeString(this.sellerProvince);
        parcel.writeString(this.sellerCity);
        parcel.writeInt(this.quantity);
        List<CardProduct> list = this.products;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (CardProduct cardProduct : list) {
                cardProduct.writeToParcel(parcel, i2);
            }
        }
        parcel.writeString(this.productLan);
        parcel.writeString(this.publishLocation);
        parcel.writeString(this.userCardImg);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
    }

    public /* synthetic */ CardProduct(int i2, int i3, int i4, int i5, String str, int i6, float f2, int i7, String str2, String str3, String str4, int i8, String str5, String str6, String str7, String str8, float f3, Float f4, float f5, int i9, float f6, boolean z, int i10, String str9, String str10, String str11, String str12, int i11, List list, String str13, String str14, String str15, String str16, String str17, int i12, int i13, u uVar) {
        this((i12 & 1) != 0 ? 0 : i2, (i12 & 2) != 0 ? 0 : i3, (i12 & 4) != 0 ? 0 : i4, i5, (i12 & 16) != 0 ? null : str, i6, (i12 & 64) != 0 ? 0.0f : f2, (i12 & 128) != 0 ? 0 : i7, (i12 & 256) != 0 ? "" : str2, (i12 & 512) != 0 ? "" : str3, (i12 & 1024) != 0 ? "" : str4, (i12 & 2048) != 0 ? 0 : i8, (i12 & 4096) != 0 ? null : str5, (i12 & 8192) != 0 ? null : str6, (i12 & 16384) != 0 ? null : str7, (32768 & i12) != 0 ? null : str8, (65536 & i12) != 0 ? 0.0f : f3, (131072 & i12) != 0 ? Float.valueOf(0.0f) : f4, (262144 & i12) != 0 ? 0.0f : f5, (524288 & i12) != 0 ? 0 : i9, (1048576 & i12) != 0 ? 0.0f : f6, (2097152 & i12) != 0 ? false : z, (4194304 & i12) != 0 ? 0 : i10, (8388608 & i12) != 0 ? null : str9, (16777216 & i12) != 0 ? null : str10, (33554432 & i12) != 0 ? null : str11, (67108864 & i12) != 0 ? null : str12, (134217728 & i12) != 0 ? 0 : i11, (268435456 & i12) != 0 ? null : list, (536870912 & i12) != 0 ? null : str13, (1073741824 & i12) != 0 ? null : str14, (i12 & Integer.MIN_VALUE) != 0 ? null : str15, (i13 & 1) != 0 ? null : str16, (i13 & 2) != 0 ? null : str17);
    }
}
