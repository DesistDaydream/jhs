package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.r.i0.a;
import e.j.a.b.c.w.e;
import java.util.List;

@SafeParcelable.a(creator = "WakeLockEventCreator")
/* loaded from: classes2.dex */
public final class WakeLockEvent extends StatsEvent {
    public static final Parcelable.Creator<WakeLockEvent> CREATOR = new e();
    private long durationMillis;
    @SafeParcelable.g(id = 1)
    private final int versionCode;
    @SafeParcelable.c(getter = "getTimeMillis", id = 2)
    private final long zzfo;
    @SafeParcelable.c(getter = "getEventType", id = 11)
    private int zzfp;
    @SafeParcelable.c(getter = "getWakeLockName", id = 4)
    private final String zzfq;
    @SafeParcelable.c(getter = "getSecondaryWakeLockName", id = 10)
    private final String zzfr;
    @SafeParcelable.c(getter = "getCodePackage", id = 17)
    private final String zzfs;
    @SafeParcelable.c(getter = "getWakeLockType", id = 5)
    private final int zzft;
    @SafeParcelable.c(getter = "getCallingPackages", id = 6)
    private final List<String> zzfu;
    @SafeParcelable.c(getter = "getEventKey", id = 12)
    private final String zzfv;
    @SafeParcelable.c(getter = "getElapsedRealtime", id = 8)
    private final long zzfw;
    @SafeParcelable.c(getter = "getDeviceState", id = 14)
    private int zzfx;
    @SafeParcelable.c(getter = "getHostPackage", id = 13)
    private final String zzfy;
    @SafeParcelable.c(getter = "getBeginPowerPercentage", id = 15)
    private final float zzfz;
    @SafeParcelable.c(getter = "getTimeout", id = 16)
    private final long zzga;
    @SafeParcelable.c(getter = "getAcquiredWithTimeout", id = 18)
    private final boolean zzgb;

    @SafeParcelable.b
    public WakeLockEvent(@SafeParcelable.e(id = 1) int i2, @SafeParcelable.e(id = 2) long j2, @SafeParcelable.e(id = 11) int i3, @SafeParcelable.e(id = 4) String str, @SafeParcelable.e(id = 5) int i4, @SafeParcelable.e(id = 6) List<String> list, @SafeParcelable.e(id = 12) String str2, @SafeParcelable.e(id = 8) long j3, @SafeParcelable.e(id = 14) int i5, @SafeParcelable.e(id = 10) String str3, @SafeParcelable.e(id = 13) String str4, @SafeParcelable.e(id = 15) float f2, @SafeParcelable.e(id = 16) long j4, @SafeParcelable.e(id = 17) String str5, @SafeParcelable.e(id = 18) boolean z) {
        this.versionCode = i2;
        this.zzfo = j2;
        this.zzfp = i3;
        this.zzfq = str;
        this.zzfr = str3;
        this.zzfs = str5;
        this.zzft = i4;
        this.durationMillis = -1L;
        this.zzfu = list;
        this.zzfv = str2;
        this.zzfw = j3;
        this.zzfx = i5;
        this.zzfy = str4;
        this.zzfz = f2;
        this.zzga = j4;
        this.zzgb = z;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final int getEventType() {
        return this.zzfp;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long getTimeMillis() {
        return this.zzfo;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i2) {
        int a = a.a(parcel);
        a.F(parcel, 1, this.versionCode);
        a.K(parcel, 2, getTimeMillis());
        a.X(parcel, 4, this.zzfq, false);
        a.F(parcel, 5, this.zzft);
        a.Z(parcel, 6, this.zzfu, false);
        a.K(parcel, 8, this.zzfw);
        a.X(parcel, 10, this.zzfr, false);
        a.F(parcel, 11, getEventType());
        a.X(parcel, 12, this.zzfv, false);
        a.X(parcel, 13, this.zzfy, false);
        a.F(parcel, 14, this.zzfx);
        a.w(parcel, 15, this.zzfz);
        a.K(parcel, 16, this.zzga);
        a.X(parcel, 17, this.zzfs, false);
        a.g(parcel, 18, this.zzgb);
        a.b(parcel, a);
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final long zzu() {
        return this.durationMillis;
    }

    @Override // com.google.android.gms.common.stats.StatsEvent
    public final String zzv() {
        String str = this.zzfq;
        int i2 = this.zzft;
        List<String> list = this.zzfu;
        String join = list == null ? "" : TextUtils.join(Constants.ACCEPT_TIME_SEPARATOR_SP, list);
        int i3 = this.zzfx;
        String str2 = this.zzfr;
        if (str2 == null) {
            str2 = "";
        }
        String str3 = this.zzfy;
        if (str3 == null) {
            str3 = "";
        }
        float f2 = this.zzfz;
        String str4 = this.zzfs;
        String str5 = str4 != null ? str4 : "";
        boolean z = this.zzgb;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(join).length() + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str5).length());
        sb.append("\t");
        sb.append(str);
        sb.append("\t");
        sb.append(i2);
        sb.append("\t");
        sb.append(join);
        sb.append("\t");
        sb.append(i3);
        sb.append("\t");
        sb.append(str2);
        sb.append("\t");
        sb.append(str3);
        sb.append("\t");
        sb.append(f2);
        sb.append("\t");
        sb.append(str5);
        sb.append("\t");
        sb.append(z);
        return sb.toString();
    }

    public WakeLockEvent(long j2, int i2, String str, int i3, List<String> list, String str2, long j3, int i4, String str3, String str4, float f2, long j4, String str5, boolean z) {
        this(2, j2, i2, str, i3, list, str2, j3, i4, str3, str4, f2, j4, str5, z);
    }
}
