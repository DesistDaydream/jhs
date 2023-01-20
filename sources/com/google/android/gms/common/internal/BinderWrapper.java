package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepName;
import e.j.a.b.c.m.a;
import e.j.a.b.c.r.z0;

@a
@KeepName
/* loaded from: classes2.dex */
public final class BinderWrapper implements Parcelable {
    public static final Parcelable.Creator<BinderWrapper> CREATOR = new z0();
    private IBinder zzcz;

    public BinderWrapper() {
        this.zzcz = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeStrongBinder(this.zzcz);
    }

    @a
    public BinderWrapper(IBinder iBinder) {
        this.zzcz = null;
        this.zzcz = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.zzcz = null;
        this.zzcz = parcel.readStrongBinder();
    }

    public /* synthetic */ BinderWrapper(Parcel parcel, z0 z0Var) {
        this(parcel);
    }
}
