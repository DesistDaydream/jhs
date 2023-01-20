package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.app.FrameMetricsAggregator;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class UserAddress implements Parcelable {
    @d
    public static final Parcelable.Creator<UserAddress> CREATOR = new Creator();
    @e.j.e.r.c("address")
    @e
    private String address;
    @e.j.e.r.c("city")
    @e
    private String city;
    @e.j.e.r.c("district")
    @e
    private String district;
    @e.j.e.r.c("address_id")
    private final int id;
    @e.j.e.r.c("is_default")
    private int isDefault;
    @e.j.e.r.c("name")
    @e
    private String name;
    @e.j.e.r.c("phone")
    @e
    private String phone;
    @e.j.e.r.c("postcode")
    @e
    private String postCode;
    @e.j.e.r.c("province")
    @e
    private String province;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<UserAddress> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final UserAddress createFromParcel(@d Parcel parcel) {
            return new UserAddress(parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final UserAddress[] newArray(int i2) {
            return new UserAddress[i2];
        }
    }

    public UserAddress() {
        this(0, null, null, null, null, null, null, null, 0, FrameMetricsAggregator.EVERY_DURATION, null);
    }

    public UserAddress(int i2, @e String str, @e String str2, @e String str3, @e String str4, @e String str5, @e String str6, @e String str7, int i3) {
        this.id = i2;
        this.name = str;
        this.phone = str2;
        this.province = str3;
        this.city = str4;
        this.district = str5;
        this.address = str6;
        this.postCode = str7;
        this.isDefault = i3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(UserAddress.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.UserAddress");
            return this.id == ((UserAddress) obj).id;
        }
        return false;
    }

    @e
    public final String getAddress() {
        return this.address;
    }

    @d
    public final String getAddressDetail() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.province);
        sb.append(' ');
        sb.append((Object) this.city);
        sb.append(' ');
        sb.append((Object) this.district);
        sb.append(' ');
        String str = this.address;
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    @e
    public final String getCity() {
        return this.city;
    }

    @e
    public final String getDistrict() {
        return this.district;
    }

    public final int getId() {
        return this.id;
    }

    @d
    public final String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append((Object) this.name);
        sb.append((char) 65292);
        sb.append((Object) this.phone);
        return sb.toString();
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final String getPhone() {
        return this.phone;
    }

    @e
    public final String getPostCode() {
        return this.postCode;
    }

    @e
    public final String getProvince() {
        return this.province;
    }

    public int hashCode() {
        return this.id;
    }

    public final int isDefault() {
        return this.isDefault;
    }

    public final void setAddress(@e String str) {
        this.address = str;
    }

    public final void setCity(@e String str) {
        this.city = str;
    }

    public final void setDefault(int i2) {
        this.isDefault = i2;
    }

    public final void setDistrict(@e String str) {
        this.district = str;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setPhone(@e String str) {
        this.phone = str;
    }

    public final void setPostCode(@e String str) {
        this.postCode = str;
    }

    public final void setProvince(@e String str) {
        this.province = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.phone);
        parcel.writeString(this.province);
        parcel.writeString(this.city);
        parcel.writeString(this.district);
        parcel.writeString(this.address);
        parcel.writeString(this.postCode);
        parcel.writeInt(this.isDefault);
    }

    public /* synthetic */ UserAddress(int i2, String str, String str2, String str3, String str4, String str5, String str6, String str7, int i3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? null : str, (i4 & 4) != 0 ? null : str2, (i4 & 8) != 0 ? null : str3, (i4 & 16) != 0 ? null : str4, (i4 & 32) != 0 ? null : str5, (i4 & 64) != 0 ? null : str6, (i4 & 128) == 0 ? str7 : null, (i4 & 256) == 0 ? i3 : 0);
    }
}
