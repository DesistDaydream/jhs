package com.xres.address_selector.db.entity;

import android.os.Parcel;
import android.os.Parcelable;
import e.u.a.d.a.a;
import i.c.c;
import k.e.a.d;
import kotlin.Metadata;

@c
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0019\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0014\u0010\u0005\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/xres/address_selector/db/entity/Area;", "Landroid/os/Parcelable;", "Lcom/xres/address_selector/db/entity/Division;", "code", "", "name", "cityCode", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCityCode", "()Ljava/lang/String;", "getCode", "getName", "describeContents", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "address-selector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class Area implements Parcelable, a {
    @d
    public static final Parcelable.Creator<Area> CREATOR = new Creator();
    @d
    private final String cityCode;
    @d
    private final String code;
    @d
    private final String name;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class Creator implements Parcelable.Creator<Area> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Area createFromParcel(@d Parcel parcel) {
            return new Area(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Area[] newArray(int i2) {
            return new Area[i2];
        }
    }

    public Area(@d String str, @d String str2, @d String str3) {
        this.code = str;
        this.name = str2;
        this.cityCode = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @d
    public final String getCityCode() {
        return this.cityCode;
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

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.code);
        parcel.writeString(this.name);
        parcel.writeString(this.cityCode);
    }
}
