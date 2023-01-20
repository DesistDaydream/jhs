package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class PayParams implements Parcelable {
    @d
    public static final Parcelable.Creator<PayParams> CREATOR = new Creator();
    @e.j.e.r.c("nonceStr")
    @e
    private final String nonceStr;
    @e.j.e.r.c("partner_id")
    @e
    private final String partnerId;
    @e.j.e.r.c("package")
    @e
    private final String pkg;
    @e.j.e.r.c("prepay_id")
    @e
    private final String prepayId;
    @e.j.e.r.c("paySign")
    @e
    private final String sign;
    @e.j.e.r.c("timeStamp")
    @e
    private final String timeStamp;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<PayParams> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PayParams createFromParcel(@d Parcel parcel) {
            return new PayParams(parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final PayParams[] newArray(int i2) {
            return new PayParams[i2];
        }
    }

    public PayParams() {
        this(null, null, null, null, null, null, 63, null);
    }

    public PayParams(@e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6) {
        this.pkg = str;
        this.nonceStr = str2;
        this.timeStamp = str3;
        this.sign = str4;
        this.prepayId = str5;
        this.partnerId = str6;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final String getNonceStr() {
        return this.nonceStr;
    }

    @e
    public final String getPartnerId() {
        return this.partnerId;
    }

    @e
    public final String getPkg() {
        return this.pkg;
    }

    @e
    public final String getPrepayId() {
        return this.prepayId;
    }

    @e
    public final String getSign() {
        return this.sign;
    }

    @e
    public final String getTimeStamp() {
        return this.timeStamp;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.pkg);
        parcel.writeString(this.nonceStr);
        parcel.writeString(this.timeStamp);
        parcel.writeString(this.sign);
        parcel.writeString(this.prepayId);
        parcel.writeString(this.partnerId);
    }

    public /* synthetic */ PayParams(String str, String str2, String str3, String str4, String str5, String str6, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3, (i2 & 8) != 0 ? null : str4, (i2 & 16) != 0 ? null : str5, (i2 & 32) != 0 ? null : str6);
    }
}
