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
public final class ChooseItem implements Parcelable {
    @d
    public static final Parcelable.Creator<ChooseItem> CREATOR = new Creator();
    @e.j.e.r.c("name")
    @d
    private final String name;
    @e.j.e.r.c("state")
    private int state;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<ChooseItem> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ChooseItem createFromParcel(@d Parcel parcel) {
            return new ChooseItem(parcel.readString(), parcel.readInt());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final ChooseItem[] newArray(int i2) {
            return new ChooseItem[i2];
        }
    }

    public ChooseItem() {
        this(null, 0, 3, null);
    }

    public ChooseItem(@d String str, int i2) {
        this.name = str;
        this.state = i2;
    }

    public static /* synthetic */ ChooseItem copy$default(ChooseItem chooseItem, String str, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = chooseItem.name;
        }
        if ((i3 & 2) != 0) {
            i2 = chooseItem.state;
        }
        return chooseItem.copy(str, i2);
    }

    @d
    public final String component1() {
        return this.name;
    }

    public final int component2() {
        return this.state;
    }

    @d
    public final ChooseItem copy(@d String str, int i2) {
        return new ChooseItem(str, i2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ChooseItem) {
            ChooseItem chooseItem = (ChooseItem) obj;
            return f0.g(this.name, chooseItem.name) && this.state == chooseItem.state;
        }
        return false;
    }

    @d
    public final String getName() {
        return this.name;
    }

    public final int getState() {
        return this.state;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.state;
    }

    public final void setState(int i2) {
        this.state = i2;
    }

    @d
    public String toString() {
        return "ChooseItem(name=" + this.name + ", state=" + this.state + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.name);
        parcel.writeInt(this.state);
    }

    public /* synthetic */ ChooseItem(String str, int i2, int i3, u uVar) {
        this((i3 & 1) != 0 ? "" : str, (i3 & 2) != 0 ? 0 : i2);
    }
}
