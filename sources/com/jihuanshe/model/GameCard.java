package com.jihuanshe.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.jihuanshe.R;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import com.jihuanshe.utils.StringUtil;
import com.moor.imkf.IMChatManager;
import com.umeng.analytics.pro.am;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.text.DecimalFormat;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public class GameCard implements Parcelable {
    @d
    public static final Parcelable.Creator<GameCard> CREATOR = new Creator();
    @e.j.e.r.c("avg_price")
    private float avgPrice;
    @e.j.e.r.c("city")
    @e
    private String buyCity;
    @e.j.e.r.c("province")
    @e
    private String buyProvince;
    @e.j.e.r.c(alternate = {"price"}, value = "product_price")
    private float cardPrice;
    @e.j.e.r.c(alternate = {"card_name_cn_cnocg", "card_sub_name"}, value = "name_cn_cnocg")
    @e
    private String cnocgname;
    @e.j.e.r.c("condition")
    @e
    private Integer condition;
    @e.j.e.r.c("seller_credit_rank")
    @e
    private String creditRank;
    @e.j.e.r.c("is_default")
    private boolean defaultProduct;
    @a
    @e
    private Game game;
    @e.j.e.r.c("grade")
    @e
    private String grade;
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private int id;
    @e.j.e.r.c(alternate = {"card_version_image"}, value = "image_url")
    @e
    private String image;
    private boolean isOnSale;
    @e.j.e.r.c("is_selling")
    private boolean isSelling;
    @e.j.e.r.c(am.N)
    @e
    private String lan;
    @e.j.e.r.c("language_text")
    @e
    private String lanText;
    @a
    @e
    private Uri localPhoto;
    @e.j.e.r.c(alternate = {"wish_price"}, value = "max_wish_price")
    private float maxWantPrice;
    @e.j.e.r.c("min_price")
    private float minPrice;
    @e.j.e.r.c("ecommerce_verify")
    @e
    private Boolean nameVerify;
    @e.j.e.r.c(alternate = {"card_name_cn"}, value = "name_cn")
    @e
    private String nwName;
    @e.j.e.r.c(SearchChildCheckFragment.C)
    private int onSell;
    @e.j.e.r.c("pay_count")
    private int payCount;
    @e.j.e.r.c(Constants.KEY_PARAM_PRODUCT_ID)
    @e
    private Integer productId;
    @e.j.e.r.c("product_language")
    @e
    private String productLan;
    @e.j.e.r.c("product_quantity")
    private int productQuantity;
    @e.j.e.r.c("pull_off")
    private boolean pullOff;
    @e.j.e.r.c("quantity")
    private int quantity;
    @e.j.e.r.c(alternate = {"card_version_rarity"}, value = "rarity")
    @e
    private String rarity;
    @e.j.e.r.c("remark")
    @e
    private String remark;
    @e.j.e.r.c(alternate = {"avatar"}, value = "seller_user_avatar")
    @e
    private String sellerAvatar;
    @e.j.e.r.c("seller_city")
    @e
    private String sellerCity;
    @e.j.e.r.c(alternate = {"user_id"}, value = "seller_user_id")
    private int sellerId;
    @e.j.e.r.c(alternate = {IMChatManager.CONSTANT_USERNAME}, value = "seller_username")
    @e
    private String sellerName;
    @e.j.e.r.c("seller_province")
    @e
    private String sellerProvince;
    @e.j.e.r.c("user_card_version_image")
    @e
    private String userImage;
    @e.j.e.r.c("verify_status")
    @e
    private Integer verifyStatus;
    @e.j.e.r.c("card_version_id")
    private int versionId;
    @e.j.e.r.c(alternate = {"card_version_number"}, value = "number")
    @e
    private String versionNum;
    @e.j.e.r.c("number_alias")
    @e
    private String versionNumAlias;
    @e.j.e.r.c("wish_id")
    @e
    private Integer wishId;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<GameCard> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final GameCard createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            int readInt = parcel.readInt();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            int readInt2 = parcel.readInt();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            String readString9 = parcel.readString();
            float readFloat = parcel.readFloat();
            float readFloat2 = parcel.readFloat();
            int readInt3 = parcel.readInt();
            float readFloat3 = parcel.readFloat();
            boolean z = parcel.readInt() != 0;
            int readInt4 = parcel.readInt();
            String readString10 = parcel.readString();
            String readString11 = parcel.readString();
            String readString12 = parcel.readString();
            String readString13 = parcel.readString();
            String readString14 = parcel.readString();
            String readString15 = parcel.readString();
            int readInt5 = parcel.readInt();
            int readInt6 = parcel.readInt();
            float readFloat4 = parcel.readFloat();
            String readString16 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new GameCard(readInt, valueOf2, readString, readString2, readInt2, readString3, readString4, readString5, readString6, valueOf3, readString7, readString8, readString9, readFloat, readFloat2, readInt3, readFloat3, z, readInt4, readString10, readString11, readString12, readString13, readString14, readString15, readInt5, readInt6, readFloat4, readString16, valueOf, parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readString(), parcel.readInt(), parcel.readInt() != 0, parcel.readString(), parcel.readInt() != 0, parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final GameCard[] newArray(int i2) {
            return new GameCard[i2];
        }
    }

    public GameCard() {
        this(0, null, null, null, 0, null, null, null, null, null, null, null, null, 0.0f, 0.0f, 0, 0.0f, false, 0, null, null, null, null, null, null, 0, 0, 0.0f, null, null, null, null, null, 0, false, null, false, null, -1, 63, null);
    }

    public GameCard(int i2, @e Integer num, @e String str, @e String str2, int i3, @e String str3, @e String str4, @e String str5, @e String str6, @e Integer num2, @e String str7, @e String str8, @e String str9, float f2, float f3, int i4, float f4, boolean z, int i5, @e String str10, @e String str11, @e String str12, @e String str13, @e String str14, @e String str15, int i6, int i7, float f5, @e String str16, @e Boolean bool, @e Integer num3, @e Integer num4, @e String str17, int i8, boolean z2, @e String str18, boolean z3, @e String str19) {
        this.id = i2;
        this.productId = num;
        this.nwName = str;
        this.cnocgname = str2;
        this.versionId = i3;
        this.versionNum = str3;
        this.versionNumAlias = str4;
        this.rarity = str5;
        this.image = str6;
        this.condition = num2;
        this.lan = str7;
        this.productLan = str8;
        this.lanText = str9;
        this.minPrice = f2;
        this.cardPrice = f3;
        this.payCount = i4;
        this.maxWantPrice = f4;
        this.isSelling = z;
        this.sellerId = i5;
        this.sellerName = str10;
        this.sellerAvatar = str11;
        this.sellerProvince = str12;
        this.sellerCity = str13;
        this.buyProvince = str14;
        this.buyCity = str15;
        this.quantity = i6;
        this.productQuantity = i7;
        this.avgPrice = f5;
        this.remark = str16;
        this.nameVerify = bool;
        this.verifyStatus = num3;
        this.wishId = num4;
        this.grade = str17;
        this.onSell = i8;
        this.defaultProduct = z2;
        this.userImage = str18;
        this.pullOff = z3;
        this.creditRank = str19;
        this.isOnSale = true;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(getClass(), obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.GameCard");
            GameCard gameCard = (GameCard) obj;
            if (this.versionId != gameCard.versionId) {
                return false;
            }
            Integer num = this.productId;
            return (num == null || f0.g(num, gameCard.productId)) && this.id == gameCard.id;
        }
        return false;
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

    @e
    public final String getBuyCity() {
        return this.buyCity;
    }

    @d
    public final String getBuyLocationCity() {
        String str = this.buyCity;
        return str == null || str.length() == 0 ? "" : String.valueOf(this.buyCity);
    }

    @e
    public final String getBuyProvince() {
        return this.buyProvince;
    }

    public final float getCardPrice() {
        return this.cardPrice;
    }

    @d
    public final String getCardVerRarity() {
        return f0.C("罕贵度：", this.rarity);
    }

    @d
    public final String getCardVersionNum() {
        return f0.C("编号：", this.versionNum);
    }

    @e
    public final String getCnocgname() {
        return this.cnocgname;
    }

    @e
    public final Integer getCondition() {
        return this.condition;
    }

    @d
    public final String getConditionStr() {
        Integer num = this.condition;
        return CardProductKt.getConditionStr(num == null ? 0 : num.intValue());
    }

    @e
    public final String getCreditRank() {
        return this.creditRank;
    }

    @e
    public final Integer getCreditRankDrawable() {
        String str = this.creditRank;
        if (str != null) {
            int hashCode = str.hashCode();
            if (hashCode != 83) {
                if (hashCode != 2656) {
                    if (hashCode != 1554081906) {
                        switch (hashCode) {
                            case 65:
                                if (str.equals(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_a);
                                }
                                break;
                            case 66:
                                if (str.equals("B")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_b);
                                }
                                break;
                            case 67:
                                if (str.equals("C")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_c);
                                }
                                break;
                            case 68:
                                if (str.equals("D")) {
                                    return Integer.valueOf((int) R.drawable.svg_credit_rank_d);
                                }
                                break;
                        }
                    } else if (str.equals("Beginner")) {
                        return Integer.valueOf((int) R.drawable.svg_credit_rank_beginner);
                    }
                } else if (str.equals("SS")) {
                    return Integer.valueOf((int) R.drawable.svg_credit_rank_ss);
                }
            } else if (str.equals(ExifInterface.LATITUDE_SOUTH)) {
                return Integer.valueOf((int) R.drawable.svg_credit_rank_s);
            }
        }
        return null;
    }

    public final boolean getDefaultProduct() {
        return this.defaultProduct;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final String getGrade() {
        return this.grade;
    }

    @d
    public final String getGradeStr() {
        String str = this.grade;
        return str == null ? com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER : str;
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
        String str = this.image;
        return str != null ? str : "";
    }

    @e
    public final String getLan() {
        return this.lan;
    }

    @e
    public final String getLanText() {
        return this.lanText;
    }

    @e
    public final Uri getLocalPhoto() {
        return this.localPhoto;
    }

    @d
    public final String getLocation() {
        String str = this.sellerProvince;
        boolean z = false;
        if (str == null || str.length() == 0) {
            String str2 = this.sellerCity;
            if ((str2 == null || str2.length() == 0) ? true : true) {
                return "";
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.sellerProvince);
        sb.append(' ');
        sb.append((Object) this.sellerCity);
        return sb.toString();
    }

    @d
    public final String getLocationCity() {
        String str = this.sellerCity;
        return str == null || str.length() == 0 ? "" : String.valueOf(this.sellerCity);
    }

    public final float getMaxWantPrice() {
        return this.maxWantPrice;
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

    @d
    public final CharSequence getMinP() {
        return StringUtil.c(StringUtil.a, this.minPrice, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final Boolean getNameVerify() {
        return this.nameVerify;
    }

    @e
    public final String getNotEmptyImage() {
        String str = this.image;
        return str == null || str.length() == 0 ? "1" : this.image;
    }

    @e
    public final String getNwName() {
        return this.nwName;
    }

    public final int getOnSell() {
        return this.onSell;
    }

    public final int getPayCount() {
        return this.payCount;
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
        return new DecimalFormat("#.##").format(Float.valueOf(this.cardPrice));
    }

    @e
    public final Integer getProductId() {
        return this.productId;
    }

    @e
    public final String getProductLan() {
        return this.productLan;
    }

    public final int getProductQuantity() {
        return this.productQuantity;
    }

    public final boolean getPullOff() {
        return this.pullOff;
    }

    public final int getQuantity() {
        return this.quantity;
    }

    @d
    public final String getQuantityContent() {
        int i2 = this.productQuantity;
        if (i2 == 0 && this.quantity == 0) {
            return "";
        }
        if (i2 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(this.productQuantity);
            sb.append((char) 24352);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.quantity);
        sb2.append((char) 24352);
        return sb2.toString();
    }

    @e
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final String getRemark() {
        return this.remark;
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
    public final String getUserImage() {
        return this.userImage;
    }

    @d
    public final String getVer() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.versionNum);
        sb.append(' ');
        sb.append((Object) this.rarity);
        return sb.toString();
    }

    @d
    public final String getVerAlias() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.versionNumAlias);
        sb.append(' ');
        sb.append((Object) this.rarity);
        return sb.toString();
    }

    @e
    public final Integer getVerifyStatus() {
        return this.verifyStatus;
    }

    public final int getVersionId() {
        return this.versionId;
    }

    @e
    public final String getVersionNum() {
        return this.versionNum;
    }

    @e
    public final String getVersionNumAlias() {
        return this.versionNumAlias;
    }

    @e
    public final Integer getWishId() {
        return this.wishId;
    }

    @d
    public final CharSequence getWishPrice() {
        return StringUtil.a.h(this.maxWantPrice);
    }

    public int hashCode() {
        return this.id;
    }

    public final boolean isOnSale() {
        return this.isOnSale;
    }

    public final boolean isRealName() {
        return f0.g(this.nameVerify, Boolean.TRUE);
    }

    public final boolean isRealStore() {
        Integer num = this.verifyStatus;
        return num != null && num.intValue() == 1;
    }

    public final boolean isSelling() {
        return this.isSelling;
    }

    public final boolean isShowLan() {
        return f0.g(this.lan, "sc");
    }

    public final boolean isShowNum() {
        return (this.productQuantity == 0 && this.quantity == 0) ? false : true;
    }

    @e
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
        return this.lan;
    }

    public final boolean noPrice() {
        if (!this.isOnSale) {
            if (this.maxWantPrice <= 0.0f) {
                return true;
            }
        } else {
            if (this.cardPrice == 0.0f) {
                if (this.minPrice == 0.0f) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean priceRed() {
        return this.minPrice > 0.0f || this.cardPrice > 0.0f;
    }

    @d
    public final String rarityStr() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.versionNum);
        sb.append(' ');
        sb.append((Object) this.rarity);
        return sb.toString();
    }

    public final void setAvgPrice(float f2) {
        this.avgPrice = f2;
    }

    public final void setBuyCity(@e String str) {
        this.buyCity = str;
    }

    public final void setBuyProvince(@e String str) {
        this.buyProvince = str;
    }

    public final void setCardPrice(float f2) {
        this.cardPrice = f2;
    }

    public final void setCnocgname(@e String str) {
        this.cnocgname = str;
    }

    public final void setCondition(@e Integer num) {
        this.condition = num;
    }

    public final void setCreditRank(@e String str) {
        this.creditRank = str;
    }

    public final void setDefaultProduct(boolean z) {
        this.defaultProduct = z;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setGrade(@e String str) {
        this.grade = str;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setLan(@e String str) {
        this.lan = str;
    }

    public final void setLanText(@e String str) {
        this.lanText = str;
    }

    public final void setLocalPhoto(@e Uri uri) {
        this.localPhoto = uri;
    }

    public final void setMaxWantPrice(float f2) {
        this.maxWantPrice = f2;
    }

    public final void setMinPrice(float f2) {
        this.minPrice = f2;
    }

    public final void setNameVerify(@e Boolean bool) {
        this.nameVerify = bool;
    }

    public final void setNwName(@e String str) {
        this.nwName = str;
    }

    public final void setOnSale(boolean z) {
        this.isOnSale = z;
    }

    public final void setOnSell(int i2) {
        this.onSell = i2;
    }

    public final void setPayCount(int i2) {
        this.payCount = i2;
    }

    public final void setProductId(@e Integer num) {
        this.productId = num;
    }

    public final void setProductLan(@e String str) {
        this.productLan = str;
    }

    public final void setProductQuantity(int i2) {
        this.productQuantity = i2;
    }

    public final void setPullOff(boolean z) {
        this.pullOff = z;
    }

    public final void setQuantity(int i2) {
        this.quantity = i2;
    }

    public final void setRarity(@e String str) {
        this.rarity = str;
    }

    public final void setRemark(@e String str) {
        this.remark = str;
    }

    public final void setSellerAvatar(@e String str) {
        this.sellerAvatar = str;
    }

    public final void setSellerCity(@e String str) {
        this.sellerCity = str;
    }

    public final void setSellerId(int i2) {
        this.sellerId = i2;
    }

    public final void setSellerName(@e String str) {
        this.sellerName = str;
    }

    public final void setSellerProvince(@e String str) {
        this.sellerProvince = str;
    }

    public final void setSelling(boolean z) {
        this.isSelling = z;
    }

    public final void setUserImage(@e String str) {
        this.userImage = str;
    }

    public final void setVerifyStatus(@e Integer num) {
        this.verifyStatus = num;
    }

    public final void setVersionId(int i2) {
        this.versionId = i2;
    }

    public final void setVersionNum(@e String str) {
        this.versionNum = str;
    }

    public final void setVersionNumAlias(@e String str) {
        this.versionNumAlias = str;
    }

    public final void setWishId(@e Integer num) {
        this.wishId = num;
    }

    public final boolean showLocationCity() {
        if (this.isSelling) {
            if (getLocationCity().length() > 0) {
                return true;
            }
        } else if (getBuyLocationCity().length() > 0) {
            return true;
        }
        return false;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        Integer num = this.productId;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.nwName);
        parcel.writeString(this.cnocgname);
        parcel.writeInt(this.versionId);
        parcel.writeString(this.versionNum);
        parcel.writeString(this.versionNumAlias);
        parcel.writeString(this.rarity);
        parcel.writeString(this.image);
        Integer num2 = this.condition;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.lan);
        parcel.writeString(this.productLan);
        parcel.writeString(this.lanText);
        parcel.writeFloat(this.minPrice);
        parcel.writeFloat(this.cardPrice);
        parcel.writeInt(this.payCount);
        parcel.writeFloat(this.maxWantPrice);
        parcel.writeInt(this.isSelling ? 1 : 0);
        parcel.writeInt(this.sellerId);
        parcel.writeString(this.sellerName);
        parcel.writeString(this.sellerAvatar);
        parcel.writeString(this.sellerProvince);
        parcel.writeString(this.sellerCity);
        parcel.writeString(this.buyProvince);
        parcel.writeString(this.buyCity);
        parcel.writeInt(this.quantity);
        parcel.writeInt(this.productQuantity);
        parcel.writeFloat(this.avgPrice);
        parcel.writeString(this.remark);
        Boolean bool = this.nameVerify;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Integer num3 = this.verifyStatus;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.wishId;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.grade);
        parcel.writeInt(this.onSell);
        parcel.writeInt(this.defaultProduct ? 1 : 0);
        parcel.writeString(this.userImage);
        parcel.writeInt(this.pullOff ? 1 : 0);
        parcel.writeString(this.creditRank);
    }

    public /* synthetic */ GameCard(int i2, Integer num, String str, String str2, int i3, String str3, String str4, String str5, String str6, Integer num2, String str7, String str8, String str9, float f2, float f3, int i4, float f4, boolean z, int i5, String str10, String str11, String str12, String str13, String str14, String str15, int i6, int i7, float f5, String str16, Boolean bool, Integer num3, Integer num4, String str17, int i8, boolean z2, String str18, boolean z3, String str19, int i9, int i10, u uVar) {
        this((i9 & 1) != 0 ? 0 : i2, (i9 & 2) != 0 ? null : num, (i9 & 4) != 0 ? "" : str, (i9 & 8) == 0 ? str2 : "", (i9 & 16) != 0 ? 0 : i3, (i9 & 32) != 0 ? null : str3, (i9 & 64) != 0 ? null : str4, (i9 & 128) != 0 ? null : str5, (i9 & 256) != 0 ? null : str6, (i9 & 512) != 0 ? null : num2, (i9 & 1024) != 0 ? null : str7, (i9 & 2048) != 0 ? null : str8, (i9 & 4096) != 0 ? null : str9, (i9 & 8192) != 0 ? 0.0f : f2, (i9 & 16384) != 0 ? 0.0f : f3, (i9 & 32768) != 0 ? 0 : i4, (i9 & 65536) != 0 ? 0.0f : f4, (i9 & 131072) != 0 ? false : z, (i9 & 262144) != 0 ? 0 : i5, (i9 & 524288) != 0 ? null : str10, (i9 & 1048576) != 0 ? null : str11, (i9 & 2097152) != 0 ? null : str12, (i9 & 4194304) != 0 ? null : str13, (i9 & 8388608) != 0 ? null : str14, (i9 & 16777216) != 0 ? null : str15, (i9 & 33554432) != 0 ? 0 : i6, (i9 & 67108864) != 0 ? 0 : i7, (i9 & 134217728) == 0 ? f5 : 0.0f, (i9 & 268435456) != 0 ? null : str16, (i9 & 536870912) != 0 ? Boolean.FALSE : bool, (i9 & 1073741824) != 0 ? null : num3, (i9 & Integer.MIN_VALUE) != 0 ? null : num4, (i10 & 1) != 0 ? null : str17, (i10 & 2) != 0 ? 0 : i8, (i10 & 4) != 0 ? false : z2, (i10 & 8) != 0 ? null : str18, (i10 & 16) != 0 ? false : z3, (i10 & 32) != 0 ? null : str19);
    }
}
