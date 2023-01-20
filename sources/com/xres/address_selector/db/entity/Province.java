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
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u00012\u00020\u0002B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\t\u0010\n\u001a\u00020\u0004HÆ\u0003J\t\u0010\u000b\u001a\u00020\u0004HÆ\u0003J\u001d\u0010\f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0004HÆ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u000eHÖ\u0001J\t\u0010\u0014\u001a\u00020\u0004HÖ\u0001J\u0019\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000eHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00020\u00048\u0016X\u0097\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u001a"}, d2 = {"Lcom/xres/address_selector/db/entity/Province;", "Landroid/os/Parcelable;", "Lcom/xres/address_selector/db/entity/Division;", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", TTDownloadField.TT_HASHCODE, "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Province implements Parcelable, a {
    @d
    public static final Parcelable.Creator<Province> CREATOR = new Creator();
    @e.j.e.r.c("id")
    @d
    private final String code;
    @e.j.e.r.c("name")
    @d
    private final String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Province> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Province createFromParcel(@d Parcel parcel) {
            return new Province(parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Province[] newArray(int i2) {
            return new Province[i2];
        }
    }

    public Province(@d String str, @d String str2) {
        this.code = str;
        this.name = str2;
    }

    public static /* synthetic */ Province copy$default(Province province, String str, String str2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = province.getCode();
        }
        if ((i2 & 2) != 0) {
            str2 = province.getName();
        }
        return province.copy(str, str2);
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
    public final Province copy(@d String str, @d String str2) {
        return new Province(str, str2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Province) {
            Province province = (Province) obj;
            return f0.g(getCode(), province.getCode()) && f0.g(getName(), province.getName());
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

    public int hashCode() {
        return (getCode().hashCode() * 31) + getName().hashCode();
    }

    @d
    public String toString() {
        return "Province(code=" + getCode() + ", name=" + getName() + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
    }
}
