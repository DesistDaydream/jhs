package com.jihuanshe.model;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.utils.StringUtil;
import com.umeng.analytics.pro.am;
import e.j.e.r.a;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class WantCard implements Parcelable {
    @d
    public static final Parcelable.Creator<WantCard> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    @e
    private final Integer cid;
    @e.j.e.r.c("name_cn_cnocg")
    @e
    private final String cnocgname;
    @a
    @e
    private Integer condition;
    @a
    @e
    private Game game;
    @e.j.e.r.c("wish_id")
    @e
    private Integer id;
    @e.j.e.r.c("ignore_card_version")
    private int ignoreVersion;
    @e.j.e.r.c("image_url")
    @e
    private String image;
    @e.j.e.r.c("is_sold")
    @e
    private Boolean isShowSold;
    @e.j.e.r.c(am.N)
    @e
    private String lan;
    @e.j.e.r.c("language_text")
    @e
    private String lanText;
    @a
    @e
    private Uri localUri;
    @e.j.e.r.c("publish_location")
    @e
    private String location;
    @e.j.e.r.c("min_price")
    private float minPrice;
    @e.j.e.r.c("number_alias")
    @e
    private String numberAlias;
    @e.j.e.r.c("name_cn")
    @e
    private String nwName;
    @e.j.e.r.c("quantity")
    private int quantity;
    @e.j.e.r.c("rarity")
    @e
    private String rarity;
    @e.j.e.r.c("remark")
    @e
    private String remark;
    @a
    @d
    private String remote;
    @a
    private boolean setDefault;
    @e.j.e.r.c("user_id")
    @e
    private final Integer uid;
    @e.j.e.r.c("card_version_id")
    @e
    private Integer versionId;
    @e.j.e.r.c("number")
    @e
    private String versionNum;
    @e.j.e.r.c("wish_price")
    @e
    private Float wishPrice;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WantCard> {
        @Override // android.os.Parcelable.Creator
        @d
        public final WantCard createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf3 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Integer valueOf4 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            Integer valueOf5 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            String readString8 = parcel.readString();
            float readFloat = parcel.readFloat();
            Float valueOf6 = parcel.readInt() == 0 ? null : Float.valueOf(parcel.readFloat());
            int readInt = parcel.readInt();
            String readString9 = parcel.readString();
            int readInt2 = parcel.readInt();
            String readString10 = parcel.readString();
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new WantCard(valueOf2, valueOf3, readString, readString2, valueOf4, valueOf5, readString3, readString4, readString5, readString6, readString7, readString8, readFloat, valueOf6, readInt, readString9, readInt2, readString10, valueOf);
        }

        @Override // android.os.Parcelable.Creator
        @d
        public final WantCard[] newArray(int i2) {
            return new WantCard[i2];
        }
    }

    public WantCard() {
        this(null, null, null, null, null, null, null, null, null, null, null, null, 0.0f, null, 0, null, 0, null, null, 524287, null);
    }

    public WantCard(@e Integer num, @e Integer num2, @e String str, @e String str2, @e Integer num3, @e Integer num4, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, float f2, @e Float f3, int i2, @e String str9, int i3, @e String str10, @e Boolean bool) {
        this.id = num;
        this.uid = num2;
        this.nwName = str;
        this.cnocgname = str2;
        this.versionId = num3;
        this.cid = num4;
        this.versionNum = str3;
        this.numberAlias = str4;
        this.rarity = str5;
        this.image = str6;
        this.lan = str7;
        this.lanText = str8;
        this.minPrice = f2;
        this.wishPrice = f3;
        this.quantity = i2;
        this.remark = str9;
        this.ignoreVersion = i3;
        this.location = str10;
        this.isShowSold = bool;
        this.remote = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(WantCard.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.WantCard");
            return f0.g(this.id, ((WantCard) obj).id);
        }
        return false;
    }

    @e
    public final Integer getCid() {
        return this.cid;
    }

    @e
    public final String getCnocgname() {
        return this.cnocgname;
    }

    @e
    public final Integer getCondition() {
        return this.condition;
    }

    @e
    public final Game getGame() {
        return this.game;
    }

    @e
    public final Integer getId() {
        return this.id;
    }

    public final int getIgnoreVersion() {
        return this.ignoreVersion;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @e
    public final String getImg() {
        return this.image;
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
    public final Uri getLocalUri() {
        return this.localUri;
    }

    @e
    public final String getLocation() {
        return this.location;
    }

    public final float getMinPrice() {
        return this.minPrice;
    }

    @e
    public final String getNumberAlias() {
        return this.numberAlias;
    }

    @d
    public final String getNumberAliasRarity() {
        return ((Object) this.numberAlias) + "  " + ((Object) this.rarity);
    }

    @e
    public final String getNwName() {
        return this.nwName;
    }

    @d
    public final String getPri() {
        Float f2 = this.wishPrice;
        return String.valueOf(f2 == null ? 0.0f : f2.floatValue());
    }

    @d
    public final CharSequence getPriceStr() {
        Float f2 = this.wishPrice;
        if (f2 == null) {
            return "可议价收";
        }
        return StringUtil.a.h(f2 == null ? 0.0f : f2.floatValue());
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
    public final String getRarity() {
        return this.rarity;
    }

    @e
    public final String getRemark() {
        return this.remark;
    }

    @d
    public final String getRemote() {
        return this.remote;
    }

    public final boolean getSetDefault() {
        return this.setDefault;
    }

    @e
    public final Integer getUid() {
        return this.uid;
    }

    @e
    public final Integer getVersionId() {
        return this.versionId;
    }

    @e
    public final String getVersionNum() {
        return this.versionNum;
    }

    @e
    public final Float getWishPrice() {
        return this.wishPrice;
    }

    public int hashCode() {
        Integer num = this.id;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public final boolean isShowLan() {
        return f0.g(this.lan, "sc");
    }

    public final boolean isShowNum() {
        return this.quantity != 0;
    }

    @e
    public final Boolean isShowSold() {
        return this.isShowSold;
    }

    public final boolean noPrice() {
        Float f2 = this.wishPrice;
        return f2 == null || f0.e(f2, 0.0f);
    }

    public final boolean priceRed() {
        return this.wishPrice != null;
    }

    public final void setCondition(@e Integer num) {
        this.condition = num;
    }

    public final void setGame(@e Game game) {
        this.game = game;
    }

    public final void setId(@e Integer num) {
        this.id = num;
    }

    public final void setIgnoreVersion(int i2) {
        this.ignoreVersion = i2;
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

    public final void setLocalUri(@e Uri uri) {
        this.localUri = uri;
    }

    public final void setLocation(@e String str) {
        this.location = str;
    }

    public final void setMinPrice(float f2) {
        this.minPrice = f2;
    }

    public final void setNumberAlias(@e String str) {
        this.numberAlias = str;
    }

    public final void setNwName(@e String str) {
        this.nwName = str;
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

    public final void setRemote(@d String str) {
        this.remote = str;
    }

    public final void setSetDefault(boolean z) {
        this.setDefault = z;
    }

    public final void setShowSold(@e Boolean bool) {
        this.isShowSold = bool;
    }

    public final void setVersionId(@e Integer num) {
        this.versionId = num;
    }

    public final void setVersionNum(@e String str) {
        this.versionNum = str;
    }

    public final void setWishPrice(@e Float f2) {
        this.wishPrice = f2;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Integer num = this.id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.uid;
        if (num2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num2.intValue());
        }
        parcel.writeString(this.nwName);
        parcel.writeString(this.cnocgname);
        Integer num3 = this.versionId;
        if (num3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num3.intValue());
        }
        Integer num4 = this.cid;
        if (num4 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num4.intValue());
        }
        parcel.writeString(this.versionNum);
        parcel.writeString(this.numberAlias);
        parcel.writeString(this.rarity);
        parcel.writeString(this.image);
        parcel.writeString(this.lan);
        parcel.writeString(this.lanText);
        parcel.writeFloat(this.minPrice);
        Float f2 = this.wishPrice;
        if (f2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeFloat(f2.floatValue());
        }
        parcel.writeInt(this.quantity);
        parcel.writeString(this.remark);
        parcel.writeInt(this.ignoreVersion);
        parcel.writeString(this.location);
        Boolean bool = this.isShowSold;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public /* synthetic */ WantCard(Integer num, Integer num2, String str, String str2, Integer num3, Integer num4, String str3, String str4, String str5, String str6, String str7, String str8, float f2, Float f3, int i2, String str9, int i3, String str10, Boolean bool, int i4, u uVar) {
        this((i4 & 1) != 0 ? null : num, (i4 & 2) != 0 ? null : num2, (i4 & 4) != 0 ? "" : str, (i4 & 8) == 0 ? str2 : "", (i4 & 16) != 0 ? null : num3, (i4 & 32) != 0 ? null : num4, (i4 & 64) != 0 ? null : str3, (i4 & 128) != 0 ? null : str4, (i4 & 256) != 0 ? null : str5, (i4 & 512) != 0 ? null : str6, (i4 & 1024) != 0 ? null : str7, (i4 & 2048) != 0 ? null : str8, (i4 & 4096) != 0 ? 0.0f : f2, (i4 & 8192) != 0 ? null : f3, (i4 & 16384) != 0 ? 0 : i2, (i4 & 32768) != 0 ? null : str9, (i4 & 65536) == 0 ? i3 : 0, (i4 & 131072) != 0 ? null : str10, (i4 & 262144) != 0 ? null : bool);
    }
}
