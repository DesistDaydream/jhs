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
public final class BankDetail implements Parcelable {
    @d
    public static final Parcelable.Creator<BankDetail> CREATOR = new Creator();
    @e.j.e.r.c("code")
    @e
    private final String code;
    @e.j.e.r.c("full_name")
    @e
    private final String name;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<BankDetail> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final BankDetail createFromParcel(@d Parcel parcel) {
            return new BankDetail(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final BankDetail[] newArray(int i2) {
            return new BankDetail[i2];
        }
    }

    public BankDetail() {
        this(null, null, 3, null);
    }

    public BankDetail(@e String str, @e String str2) {
        this.code = str;
        this.name = str2;
    }

    public static /* synthetic */ BankDetail copy$default(BankDetail bankDetail, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bankDetail.code;
        }
        if ((i2 & 2) != 0) {
            str2 = bankDetail.name;
        }
        return bankDetail.copy(str, str2);
    }

    @e
    public final String component1() {
        return this.code;
    }

    @e
    public final String component2() {
        return this.name;
    }

    @d
    public final BankDetail copy(@e String str, @e String str2) {
        return new BankDetail(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BankDetail) {
            BankDetail bankDetail = (BankDetail) obj;
            return f0.g(this.code, bankDetail.code) && f0.g(this.name, bankDetail.name);
        }
        return false;
    }

    @e
    public final String getCode() {
        return this.code;
    }

    @e
    public final String getName() {
        return this.name;
    }

    public int hashCode() {
        String str = this.code;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.name;
        return hashCode + (str2 != null ? str2.hashCode() : 0);
    }

    @d
    public String toString() {
        return "BankDetail(code=" + ((Object) this.code) + ", name=" + ((Object) this.name) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
    }

    public /* synthetic */ BankDetail(String str, String str2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2);
    }
}
