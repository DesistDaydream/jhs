package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.bytedance.msdk.api.reward.RewardItem;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class IllegalData implements Parcelable {
    @d
    public static final Parcelable.Creator<IllegalData> CREATOR = new Creator();
    @e.j.e.r.c("action")
    @e
    private final String action;
    @e.j.e.r.c(RewardItem.KEY_REASON)
    @e
    private final String reason;
    @e.j.e.r.c("created_at")
    @e
    private final String time;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<IllegalData> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final IllegalData createFromParcel(@d Parcel parcel) {
            return new IllegalData(parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final IllegalData[] newArray(int i2) {
            return new IllegalData[i2];
        }
    }

    public IllegalData() {
        this(null, null, null, 7, null);
    }

    public IllegalData(@e String str, @e String str2, @e String str3) {
        this.reason = str;
        this.action = str2;
        this.time = str3;
    }

    public static /* synthetic */ IllegalData copy$default(IllegalData illegalData, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = illegalData.reason;
        }
        if ((i2 & 2) != 0) {
            str2 = illegalData.action;
        }
        if ((i2 & 4) != 0) {
            str3 = illegalData.time;
        }
        return illegalData.copy(str, str2, str3);
    }

    @e
    public final String component1() {
        return this.reason;
    }

    @e
    public final String component2() {
        return this.action;
    }

    @e
    public final String component3() {
        return this.time;
    }

    @d
    public final IllegalData copy(@e String str, @e String str2, @e String str3) {
        return new IllegalData(str, str2, str3);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof IllegalData) {
            IllegalData illegalData = (IllegalData) obj;
            return f0.g(this.reason, illegalData.reason) && f0.g(this.action, illegalData.action) && f0.g(this.time, illegalData.time);
        }
        return false;
    }

    @e
    public final String getAction() {
        return this.action;
    }

    @e
    public final String getReason() {
        return this.reason;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        String str = this.reason;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.action;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.time;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @d
    public String toString() {
        return "IllegalData(reason=" + ((Object) this.reason) + ", action=" + ((Object) this.action) + ", time=" + ((Object) this.time) + ')';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeString(this.reason);
        parcel.writeString(this.action);
        parcel.writeString(this.time);
    }

    public /* synthetic */ IllegalData(String str, String str2, String str3, int i2, u uVar) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? null : str3);
    }
}
