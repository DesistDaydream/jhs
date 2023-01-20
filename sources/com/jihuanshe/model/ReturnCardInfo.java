package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.ui.page.entrepot.SearchChildCheckFragment;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class ReturnCardInfo implements Parcelable {
    @d
    public static final Parcelable.Creator<ReturnCardInfo> CREATOR = new Creator();
    @e.j.e.r.c(Constants.KEY_PARAM_CARD_ID)
    private final int cardId;
    @e.j.e.r.c("card_name")
    @e
    private final String cardName;
    @e.j.e.r.c("card_name_origin")
    @e
    private final String cardNameOrigin;
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
    @e.j.e.r.c("fail_type")
    @e
    private final String failType;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_KEY)
    @e
    private final String gameKey;
    @e.j.e.r.c(Constants.KEY_PARAM_GAME_SUB_KEY)
    @e
    private final String gameSubKey;
    @e.j.e.r.c("id")
    @e
    private final String id;
    private boolean isChecked;
    @e.j.e.r.c("publish_location")
    @e
    private final String publishLocation;
    @e.j.e.r.c("quantity")
    private final int quantity;
    @e.j.e.r.c("status")
    @e
    private final String status;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ReturnCardInfo> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReturnCardInfo createFromParcel(@d Parcel parcel) {
            return new ReturnCardInfo(parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ReturnCardInfo[] newArray(int i2) {
            return new ReturnCardInfo[i2];
        }
    }

    public ReturnCardInfo() {
        this(null, 0, null, null, 0, null, null, null, null, null, null, null, 0, null, 16383, null);
    }

    public ReturnCardInfo(@e String str, int i2, @e String str2, @e String str3, int i3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e String str10, int i4, @e String str11) {
        this.id = str;
        this.cardId = i2;
        this.cardName = str2;
        this.cardNameOrigin = str3;
        this.cardVersionId = i3;
        this.cardVersionImageUrl = str4;
        this.cardVersionNumber = str5;
        this.cardVersionRarity = str6;
        this.failType = str7;
        this.gameKey = str8;
        this.gameSubKey = str9;
        this.publishLocation = str10;
        this.quantity = i4;
        this.status = str11;
    }

    @e
    public final String component1() {
        return this.id;
    }

    @e
    public final String component10() {
        return this.gameKey;
    }

    @e
    public final String component11() {
        return this.gameSubKey;
    }

    @e
    public final String component12() {
        return this.publishLocation;
    }

    public final int component13() {
        return this.quantity;
    }

    @e
    public final String component14() {
        return this.status;
    }

    public final int component2() {
        return this.cardId;
    }

    @e
    public final String component3() {
        return this.cardName;
    }

    @e
    public final String component4() {
        return this.cardNameOrigin;
    }

    public final int component5() {
        return this.cardVersionId;
    }

    @e
    public final String component6() {
        return this.cardVersionImageUrl;
    }

    @e
    public final String component7() {
        return this.cardVersionNumber;
    }

    @e
    public final String component8() {
        return this.cardVersionRarity;
    }

    @e
    public final String component9() {
        return this.failType;
    }

    @d
    public final ReturnCardInfo copy(@e String str, int i2, @e String str2, @e String str3, int i3, @e String str4, @e String str5, @e String str6, @e String str7, @e String str8, @e String str9, @e String str10, int i4, @e String str11) {
        return new ReturnCardInfo(str, i2, str2, str3, i3, str4, str5, str6, str7, str8, str9, str10, i4, str11);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ReturnCardInfo) {
            ReturnCardInfo returnCardInfo = (ReturnCardInfo) obj;
            return f0.g(this.id, returnCardInfo.id) && this.cardId == returnCardInfo.cardId && f0.g(this.cardName, returnCardInfo.cardName) && f0.g(this.cardNameOrigin, returnCardInfo.cardNameOrigin) && this.cardVersionId == returnCardInfo.cardVersionId && f0.g(this.cardVersionImageUrl, returnCardInfo.cardVersionImageUrl) && f0.g(this.cardVersionNumber, returnCardInfo.cardVersionNumber) && f0.g(this.cardVersionRarity, returnCardInfo.cardVersionRarity) && f0.g(this.failType, returnCardInfo.failType) && f0.g(this.gameKey, returnCardInfo.gameKey) && f0.g(this.gameSubKey, returnCardInfo.gameSubKey) && f0.g(this.publishLocation, returnCardInfo.publishLocation) && this.quantity == returnCardInfo.quantity && f0.g(this.status, returnCardInfo.status);
        }
        return false;
    }

    public final int getCardId() {
        return this.cardId;
    }

    @e
    public final String getCardName() {
        return this.cardName;
    }

    @e
    public final String getCardNameOrigin() {
        return this.cardNameOrigin;
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
    public final String getFailType() {
        return this.failType;
    }

    @e
    public final String getGameKey() {
        return this.gameKey;
    }

    @e
    public final String getGameSubKey() {
        return this.gameSubKey;
    }

    @e
    public final String getId() {
        return this.id;
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
    public final String getStatus() {
        return this.status;
    }

    public int hashCode() {
        String str = this.id;
        int hashCode = (((str == null ? 0 : str.hashCode()) * 31) + this.cardId) * 31;
        String str2 = this.cardName;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.cardNameOrigin;
        int hashCode3 = (((hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.cardVersionId) * 31;
        String str4 = this.cardVersionImageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.cardVersionNumber;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.cardVersionRarity;
        int hashCode6 = (hashCode5 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.failType;
        int hashCode7 = (hashCode6 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.gameKey;
        int hashCode8 = (hashCode7 + (str8 == null ? 0 : str8.hashCode())) * 31;
        String str9 = this.gameSubKey;
        int hashCode9 = (hashCode8 + (str9 == null ? 0 : str9.hashCode())) * 31;
        String str10 = this.publishLocation;
        int hashCode10 = (((hashCode9 + (str10 == null ? 0 : str10.hashCode())) * 31) + this.quantity) * 31;
        String str11 = this.status;
        return hashCode10 + (str11 != null ? str11.hashCode() : 0);
    }

    public final boolean isChecked() {
        return this.isChecked;
    }

    public final void setChecked(boolean z) {
        this.isChecked = z;
    }

    @d
    public final String statusCard() {
        String str = this.failType;
        return str == null || str.length() == 0 ? f0.g(this.status, SearchChildCheckFragment.C) ? "在售中" : "未上架" : f0.g(this.failType, "condition") ? "品相不符" : "";
    }

    @d
    public String toString() {
        return "ReturnCardInfo(id=" + ((Object) this.id) + ", cardId=" + this.cardId + ", cardName=" + ((Object) this.cardName) + ", cardNameOrigin=" + ((Object) this.cardNameOrigin) + ", cardVersionId=" + this.cardVersionId + ", cardVersionImageUrl=" + ((Object) this.cardVersionImageUrl) + ", cardVersionNumber=" + ((Object) this.cardVersionNumber) + ", cardVersionRarity=" + ((Object) this.cardVersionRarity) + ", failType=" + ((Object) this.failType) + ", gameKey=" + ((Object) this.gameKey) + ", gameSubKey=" + ((Object) this.gameSubKey) + ", publishLocation=" + ((Object) this.publishLocation) + ", quantity=" + this.quantity + ", status=" + ((Object) this.status) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.id);
        parcel.writeInt(this.cardId);
        parcel.writeString(this.cardName);
        parcel.writeString(this.cardNameOrigin);
        parcel.writeInt(this.cardVersionId);
        parcel.writeString(this.cardVersionImageUrl);
        parcel.writeString(this.cardVersionNumber);
        parcel.writeString(this.cardVersionRarity);
        parcel.writeString(this.failType);
        parcel.writeString(this.gameKey);
        parcel.writeString(this.gameSubKey);
        parcel.writeString(this.publishLocation);
        parcel.writeInt(this.quantity);
        parcel.writeString(this.status);
    }

    public /* synthetic */ ReturnCardInfo(String str, int i2, String str2, String str3, int i3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, int i4, String str11, int i5, u uVar) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? 0 : i2, (i5 & 4) != 0 ? "" : str2, (i5 & 8) != 0 ? "" : str3, (i5 & 16) != 0 ? 0 : i3, (i5 & 32) != 0 ? "" : str4, (i5 & 64) != 0 ? "" : str5, (i5 & 128) != 0 ? "" : str6, (i5 & 256) != 0 ? "" : str7, (i5 & 512) != 0 ? "" : str8, (i5 & 1024) != 0 ? "" : str9, (i5 & 2048) != 0 ? "" : str10, (i5 & 4096) == 0 ? i4 : 0, (i5 & 8192) == 0 ? str11 : "");
    }
}
