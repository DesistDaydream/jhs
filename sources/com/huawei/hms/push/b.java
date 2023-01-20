package com.huawei.hms.push;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class b implements Parcelable.Creator<RemoteMessage> {
    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage createFromParcel(Parcel parcel) {
        return new RemoteMessage(parcel);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.os.Parcelable.Creator
    public RemoteMessage[] newArray(int i2) {
        return new RemoteMessage[i2];
    }
}
