package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.model.Constants;
import com.moor.imkf.model.entity.FromToMessage;
import com.vector.util.Res;
import e.l.r.r0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CardPackage implements Parcelable {
    @d
    public static final Parcelable.Creator<CardPackage> CREATOR = new Creator();
    @e.j.e.r.c("categoryAlias")
    @e
    private String categoryAlias;
    @e.j.e.r.c("categoryId")
    private int categoryId;
    @e.j.e.r.c("categoryName")
    @e
    private String categoryName;
    @e.j.e.r.c(FromToMessage.MSG_TYPE_IMAGE)
    @e
    private String image;
    @e.j.e.r.c("isNew")
    private int isNew;
    @e.j.e.r.c("packAlias")
    @e
    private String packAlias;
    @e.j.e.r.c(r0.f14317k)
    private int packId;
    @e.j.e.r.c(com.tencent.android.tpush.common.Constants.FLAG_PACK_NAME)
    @e
    private String packName;
    @e.j.e.r.c("packReleaseAt")
    @e
    private String packReleaseAt;
    @e.j.e.r.c("type")
    @e
    private Integer type;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CardPackage> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardPackage createFromParcel(@d Parcel parcel) {
            return new CardPackage(parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CardPackage[] newArray(int i2) {
            return new CardPackage[i2];
        }
    }

    public CardPackage(@e Integer num, int i2, @e String str, @e String str2, @e String str3, int i3, @e String str4, @e String str5, int i4, @e String str6) {
        this.type = num;
        this.packId = i2;
        this.packName = str;
        this.packAlias = str2;
        this.packReleaseAt = str3;
        this.categoryId = i3;
        this.categoryName = str4;
        this.categoryAlias = str5;
        this.isNew = i4;
        this.image = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getAlias() {
        String str;
        Integer num = this.type;
        Constants.Companion companion = Constants.Companion;
        int type_child = companion.getTYPE_CHILD();
        if (num != null && num.intValue() == type_child) {
            str = this.categoryAlias;
            if (str == null) {
                return "";
            }
        } else {
            Integer num2 = this.type;
            int type_cp = companion.getTYPE_CP();
            if (num2 != null && num2.intValue() == type_cp) {
                str = this.packAlias;
                if (str == null) {
                    return "";
                }
            } else {
                Integer num3 = this.type;
                return (num3 != null && num3.intValue() == companion.getTYPE_NEWEST()) ? "NEW" : "";
            }
        }
        return str;
    }

    @e
    public final String getCategoryAlias() {
        return this.categoryAlias;
    }

    public final int getCategoryId() {
        return this.categoryId;
    }

    @e
    public final String getCategoryName() {
        return this.categoryName;
    }

    @e
    public final Integer getCid() {
        Integer num = this.type;
        int type_child = Constants.Companion.getTYPE_CHILD();
        if (num != null && num.intValue() == type_child) {
            return Integer.valueOf(this.categoryId);
        }
        return null;
    }

    @e
    public final String getImage() {
        return this.image;
    }

    @d
    public final String getName() {
        String str;
        Integer num = this.type;
        Constants.Companion companion = Constants.Companion;
        int type_child = companion.getTYPE_CHILD();
        if (num != null && num.intValue() == type_child) {
            str = this.categoryName;
            if (str == null) {
                return "";
            }
        } else {
            Integer num2 = this.type;
            int type_cp = companion.getTYPE_CP();
            if (num2 != null && num2.intValue() == type_cp) {
                str = this.packName;
                if (str == null) {
                    return "";
                }
            } else {
                Integer num3 = this.type;
                return (num3 != null && num3.intValue() == companion.getTYPE_NEWEST()) ? Res.w(Res.a, R.string.shop_newest_product, null, 2, null) : "";
            }
        }
        return str;
    }

    @e
    public final String getPackAlias() {
        return this.packAlias;
    }

    public final int getPackId() {
        return this.packId;
    }

    @e
    public final String getPackName() {
        return this.packName;
    }

    @e
    public final String getPackReleaseAt() {
        return this.packReleaseAt;
    }

    @e
    public final Integer getPid() {
        Integer num = this.type;
        int type_cp = Constants.Companion.getTYPE_CP();
        if (num != null && num.intValue() == type_cp) {
            return Integer.valueOf(this.packId);
        }
        return null;
    }

    @e
    public final Integer getType() {
        return this.type;
    }

    public final int isNew() {
        return this.isNew;
    }

    public final void setCategoryAlias(@e String str) {
        this.categoryAlias = str;
    }

    public final void setCategoryId(int i2) {
        this.categoryId = i2;
    }

    public final void setCategoryName(@e String str) {
        this.categoryName = str;
    }

    public final void setImage(@e String str) {
        this.image = str;
    }

    public final void setNew(int i2) {
        this.isNew = i2;
    }

    public final void setPackAlias(@e String str) {
        this.packAlias = str;
    }

    public final void setPackId(int i2) {
        this.packId = i2;
    }

    public final void setPackName(@e String str) {
        this.packName = str;
    }

    public final void setPackReleaseAt(@e String str) {
        this.packReleaseAt = str;
    }

    public final void setType(@e Integer num) {
        this.type = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        int intValue;
        Integer num = this.type;
        if (num == null) {
            intValue = 0;
        } else {
            parcel.writeInt(1);
            intValue = num.intValue();
        }
        parcel.writeInt(intValue);
        parcel.writeInt(this.packId);
        parcel.writeString(this.packName);
        parcel.writeString(this.packAlias);
        parcel.writeString(this.packReleaseAt);
        parcel.writeInt(this.categoryId);
        parcel.writeString(this.categoryName);
        parcel.writeString(this.categoryAlias);
        parcel.writeInt(this.isNew);
        parcel.writeString(this.image);
    }

    public /* synthetic */ CardPackage(Integer num, int i2, String str, String str2, String str3, int i3, String str4, String str5, int i4, String str6, int i5, u uVar) {
        this((i5 & 1) != 0 ? null : num, i2, (i5 & 4) != 0 ? null : str, (i5 & 8) != 0 ? null : str2, (i5 & 16) != 0 ? null : str3, i3, (i5 & 64) != 0 ? null : str4, (i5 & 128) != 0 ? null : str5, i4, (i5 & 512) != 0 ? null : str6);
    }
}
