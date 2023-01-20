package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public final class bo implements Parcelable.Creator<bn> {
    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bn createFromParcel(Parcel parcel) {
        return new bn(parcel, null);
    }

    @Override // android.os.Parcelable.Creator
    /* renamed from: a */
    public bn[] newArray(int i2) {
        return new bn[i2];
    }
}
