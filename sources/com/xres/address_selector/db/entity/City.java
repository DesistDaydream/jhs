package com.xres.address_selector.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import e.u.a.d.a.a;
import h.k2.v.f0;
import i.c.c;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@c
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0004HÆ\u0003J\t\u0010\r\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0004HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u0004HÆ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0011HÖ\u0001R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u001d"}, d2 = {"Lcom/xres/address_selector/db/entity/City;", "Landroid/os/Parcelable;", "Lcom/xres/address_selector/db/entity/Division;", "code", "", "name", "provinceCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "getProvinceCode", "component1", "component2", "component3", "copy", "describeContents", "", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class City implements Parcelable, a {
    @d
    public static final Parcelable.Creator<City> CREATOR = new Creator();
    @d
    private final String code;
    @d
    private final String name;
    @d
    private final String provinceCode;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<City> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final City createFromParcel(@d Parcel parcel) {
            return new City(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final City[] newArray(int i2) {
            return new City[i2];
        }
    }

    public City(@d String str, @d String str2, @d String str3) {
        this.code = str;
        this.name = str2;
        this.provinceCode = str3;
    }

    public static /* synthetic */ City copy$default(City city, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = city.getCode();
        }
        if ((i2 & 2) != 0) {
            str2 = city.getName();
        }
        if ((i2 & 4) != 0) {
            str3 = city.provinceCode;
        }
        return city.copy(str, str2, str3);
    }

    @d
    public final String component1() {
        return getCode();
    }

    @d
    public final String component2() {
        return getName();
    }

    @d
    public final String component3() {
        return this.provinceCode;
    }

    @d
    public final City copy(@d String str, @d String str2, @d String str3) {
        return new City(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof City) {
            City city = (City) obj;
            return f0.g(getCode(), city.getCode()) && f0.g(getName(), city.getName()) && f0.g(this.provinceCode, city.provinceCode);
        }
        return false;
    }

    @Override // e.u.a.d.a.a
    @d
    public String getCode() {
        return this.code;
    }

    @Override // e.u.a.d.a.a
    @d
    public String getName() {
        return this.name;
    }

    @d
    public final String getProvinceCode() {
        return this.provinceCode;
    }

    public int hashCode() {
        return (((getCode().hashCode() * 31) + getName().hashCode()) * 31) + this.provinceCode.hashCode();
    }

    @d
    public String toString() {
        return "City(code=" + getCode() + ", name=" + getName() + ", provinceCode=" + this.provinceCode + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
        parcel.writeString(this.provinceCode);
    }
}
