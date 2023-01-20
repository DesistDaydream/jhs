package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class SearchResultCount implements Parcelable {
    @d
    public static final Parcelable.Creator<SearchResultCount> CREATOR = new Creator();
    @e.j.e.r.c("user_match_count")
    @e
    private final Long userCount;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<SearchResultCount> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SearchResultCount createFromParcel(@d Parcel parcel) {
            return new SearchResultCount(parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong()));
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final SearchResultCount[] newArray(int i2) {
            return new SearchResultCount[i2];
        }
    }

    public SearchResultCount() {
        this(null, 1, null);
    }

    public SearchResultCount(@e Long l2) {
        this.userCount = l2;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @e
    public final Long getUserCount() {
        return this.userCount;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        Long l2 = this.userCount;
        if (l2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeLong(l2.longValue());
    }

    public /* synthetic */ SearchResultCount(Long l2, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : l2);
    }
}
