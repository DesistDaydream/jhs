package com.google.android.gms.common.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.IntentSender;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import e.j.a.b.c.m.a;
import e.j.a.b.c.n.f;
import e.j.a.b.c.n.p;
import e.j.a.b.c.n.z;
import e.j.a.b.c.r.y;
import e.j.a.b.c.x.d0;

@SafeParcelable.a(creator = "StatusCreator")
@a
/* loaded from: classes2.dex */
public final class Status extends AbstractSafeParcelable implements p, ReflectedParcelable {
    @SafeParcelable.g(id = 1000)
    private final int zzg;
    @SafeParcelable.c(getter = "getStatusCode", id = 1)
    private final int zzh;
    @Nullable
    @SafeParcelable.c(getter = "getPendingIntent", id = 3)
    private final PendingIntent zzi;
    @Nullable
    @SafeParcelable.c(getter = "getStatusMessage", id = 2)
    private final String zzj;
    @a
    @d0
    public static final Status RESULT_SUCCESS = new Status(0);
    @a
    public static final Status RESULT_INTERRUPTED = new Status(14);
    @a
    public static final Status RESULT_INTERNAL_ERROR = new Status(8);
    @a
    public static final Status RESULT_TIMEOUT = new Status(15);
    @a
    public static final Status RESULT_CANCELED = new Status(16);
    private static final Status zzar = new Status(17);
    @a
    public static final Status RESULT_DEAD_CLIENT = new Status(18);
    public static final Parcelable.Creator<Status> CREATOR = new z();

    @a
    @SafeParcelable.b
    public Status(@SafeParcelable.e(id = 1000) int i2, @SafeParcelable.e(id = 1) int i3, @Nullable @SafeParcelable.e(id = 2) String str, @Nullable @SafeParcelable.e(id = 3) PendingIntent pendingIntent) {
        this.zzg = i2;
        this.zzh = i3;
        this.zzj = str;
        this.zzi = pendingIntent;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Status) {
            Status status = (Status) obj;
            return this.zzg == status.zzg && this.zzh == status.zzh && y.a(this.zzj, status.zzj) && y.a(this.zzi, status.zzi);
        }
        return false;
    }

    public final PendingIntent getResolution() {
        return this.zzi;
    }

    @Override // e.j.a.b.c.n.p
    @a
    public final Status getStatus() {
        return this;
    }

    public final int getStatusCode() {
        return this.zzh;
    }

    @Nullable
    public final String getStatusMessage() {
        return this.zzj;
    }

    @d0
    public final boolean hasResolution() {
        return this.zzi != null;
    }

    public final int hashCode() {
        return y.b(Integer.valueOf(this.zzg), Integer.valueOf(this.zzh), this.zzj, this.zzi);
    }

    public final boolean isCanceled() {
        return this.zzh == 16;
    }

    public final boolean isInterrupted() {
        return this.zzh == 14;
    }

    public final boolean isSuccess() {
        return this.zzh <= 0;
    }

    public final void startResolutionForResult(Activity activity, int i2) throws IntentSender.SendIntentException {
        if (hasResolution()) {
            activity.startIntentSenderForResult(this.zzi.getIntentSender(), i2, null, 0, 0, 0);
        }
    }

    public final String toString() {
        return y.c(this).a(HiAnalyticsConstant.HaKey.BI_KEY_RESULT, zzg()).a("resolution", this.zzi).toString();
    }

    @Override // android.os.Parcelable
    @a
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = e.j.a.b.c.r.i0.a.a(parcel);
        e.j.a.b.c.r.i0.a.F(parcel, 1, getStatusCode());
        e.j.a.b.c.r.i0.a.X(parcel, 2, getStatusMessage(), false);
        e.j.a.b.c.r.i0.a.S(parcel, 3, this.zzi, i2, false);
        e.j.a.b.c.r.i0.a.F(parcel, 1000, this.zzg);
        e.j.a.b.c.r.i0.a.b(parcel, a);
    }

    public final String zzg() {
        String str = this.zzj;
        return str != null ? str : f.a(this.zzh);
    }

    @a
    public Status(int i2) {
        this(i2, null);
    }

    @a
    public Status(int i2, @Nullable String str) {
        this(1, i2, str, null);
    }

    @a
    public Status(int i2, @Nullable String str, @Nullable PendingIntent pendingIntent) {
        this(1, i2, str, pendingIntent);
    }
}
