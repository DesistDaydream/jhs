package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class WantBuyList implements Parcelable {
    @d
    public static final Parcelable.Creator<WantBuyList> CREATOR = new Creator();
    @e.j.e.r.c("is_default")
    @e
    private Boolean def;
    @e.j.e.r.c("desc")
    @e
    private final String desc;
    @e.j.e.r.c("wish_list_id")
    private final int id;
    @e.j.e.r.c("name")
    @e
    private String name;
    @e.j.e.r.c("quantity")
    @e
    private final Integer quantity;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<WantBuyList> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WantBuyList createFromParcel(@d Parcel parcel) {
            Boolean valueOf;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            Integer valueOf2 = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            if (parcel.readInt() == 0) {
                valueOf = null;
            } else {
                valueOf = Boolean.valueOf(parcel.readInt() != 0);
            }
            return new WantBuyList(readInt, readString, readString2, valueOf2, valueOf);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final WantBuyList[] newArray(int i2) {
            return new WantBuyList[i2];
        }
    }

    public WantBuyList() {
        this(0, null, null, null, null, 31, null);
    }

    public WantBuyList(int i2, @e String str, @e String str2, @e Integer num, @e Boolean bool) {
        this.id = i2;
        this.name = str;
        this.desc = str2;
        this.quantity = num;
        this.def = bool;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(WantBuyList.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.WantBuyList");
            return this.id == ((WantBuyList) obj).id;
        }
        return false;
    }

    @e
    public final Boolean getDef() {
        return this.def;
    }

    @e
    public final String getDesc() {
        return this.desc;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getName() {
        return this.name;
    }

    @e
    public final Integer getQuantity() {
        return this.quantity;
    }

    public final int getQuantityNum() {
        Integer num = this.quantity;
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int hashCode() {
        return this.id;
    }

    public final void setDef(@e Boolean bool) {
        this.def = bool;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeString(this.desc);
        Integer num = this.quantity;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Boolean bool = this.def;
        if (bool == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(bool.booleanValue() ? 1 : 0);
    }

    public /* synthetic */ WantBuyList(int i2, String str, String str2, Integer num, Boolean bool, int i3, u uVar) {
        this((i3 & 1) != 0 ? 0 : i2, (i3 & 2) != 0 ? null : str, (i3 & 4) != 0 ? null : str2, (i3 & 8) != 0 ? null : num, (i3 & 16) == 0 ? bool : null);
    }
}
