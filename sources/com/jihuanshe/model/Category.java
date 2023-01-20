package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class Category implements Parcelable {
    @d
    public static final Parcelable.Creator<Category> CREATOR = new Creator();
    @e.j.e.r.c("categoryId")
    private int id;
    @e.j.e.r.c("categoryName")
    @e
    private String name;
    @e.j.e.r.c("parent_id")
    private int parentId;
    @e.j.e.r.c("packList")
    @e
    private List<CardPackage> plist;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<Category> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Category createFromParcel(@d Parcel parcel) {
            ArrayList arrayList;
            int readInt = parcel.readInt();
            String readString = parcel.readString();
            int readInt2 = parcel.readInt();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt3 = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt3);
                for (int i2 = 0; i2 != readInt3; i2++) {
                    arrayList2.add(CardPackage.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new Category(readInt, readString, readInt2, arrayList);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final Category[] newArray(int i2) {
            return new Category[i2];
        }
    }

    public Category(int i2, @e String str, int i3, @e List<CardPackage> list) {
        this.id = i2;
        this.name = str;
        this.parentId = i3;
        this.plist = list;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(Category.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.Category");
            return this.id == ((Category) obj).id;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    @e
    public final String getName() {
        return this.name;
    }

    public final int getParentId() {
        return this.parentId;
    }

    @e
    public final List<CardPackage> getPlist() {
        return this.plist;
    }

    public int hashCode() {
        return this.id;
    }

    public final void setId(int i2) {
        this.id = i2;
    }

    public final void setName(@e String str) {
        this.name = str;
    }

    public final void setParentId(int i2) {
        this.parentId = i2;
    }

    public final void setPlist(@e List<CardPackage> list) {
        this.plist = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeString(this.name);
        parcel.writeInt(this.parentId);
        List<CardPackage> list = this.plist;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (CardPackage cardPackage : list) {
            cardPackage.writeToParcel(parcel, i2);
        }
    }

    public /* synthetic */ Category(int i2, String str, int i3, List list, int i4, u uVar) {
        this(i2, (i4 & 2) != 0 ? null : str, i3, (i4 & 8) != 0 ? null : list);
    }
}
