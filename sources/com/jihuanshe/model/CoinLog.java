package com.jihuanshe.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.jihuanshe.R;
import com.jihuanshe.utils.StringUtil;
import h.k2.v.f0;
import h.k2.v.u;
import i.c.c;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;

@c
/* loaded from: classes2.dex */
public final class CoinLog implements Parcelable {
    @d
    public static final Parcelable.Creator<CoinLog> CREATOR = new Creator();
    @e.j.e.r.c("withdraw_log_id")
    private final int id;
    @e.j.e.r.c("money")
    private final float money;
    @e.j.e.r.c("remark")
    @e
    private final String remark;
    @e.j.e.r.c("status")
    private final int status;
    @e.j.e.r.c("status_text")
    @e
    private final String statusText;
    @e.j.e.r.c("created_at")
    @e
    private final String time;

    /* loaded from: classes2.dex */
    public static final class Creator implements Parcelable.Creator<CoinLog> {
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CoinLog createFromParcel(@d Parcel parcel) {
            return new CoinLog(parcel.readInt(), parcel.readFloat(), parcel.readInt(), parcel.readString(), parcel.readString(), parcel.readString());
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        @d
        public final CoinLog[] newArray(int i2) {
            return new CoinLog[i2];
        }
    }

    public CoinLog() {
        this(0, 0.0f, 0, null, null, null, 63, null);
    }

    public CoinLog(int i2, float f2, int i3, @e String str, @e String str2, @e String str3) {
        this.id = i2;
        this.money = f2;
        this.status = i3;
        this.statusText = str;
        this.remark = str2;
        this.time = str3;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(@e Object obj) {
        if (this == obj) {
            return true;
        }
        if (f0.g(CoinLog.class, obj == null ? null : obj.getClass())) {
            Objects.requireNonNull(obj, "null cannot be cast to non-null type com.jihuanshe.model.CoinLog");
            return this.id == ((CoinLog) obj).id;
        }
        return false;
    }

    public final int getId() {
        return this.id;
    }

    public final float getMoney() {
        return this.money;
    }

    @d
    public final CharSequence getMoneyStr() {
        return StringUtil.c(StringUtil.a, this.money, R.string.shop_price, false, 0, 0, false, 60, null);
    }

    @e
    public final String getRemark() {
        return this.remark;
    }

    public final int getStatus() {
        return this.status;
    }

    @e
    public final String getStatusText() {
        return this.statusText;
    }

    @e
    public final String getTime() {
        return this.time;
    }

    public int hashCode() {
        return this.id;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(@d Parcel parcel, int i2) {
        parcel.writeInt(this.id);
        parcel.writeFloat(this.money);
        parcel.writeInt(this.status);
        parcel.writeString(this.statusText);
        parcel.writeString(this.remark);
        parcel.writeString(this.time);
    }

    public /* synthetic */ CoinLog(int i2, float f2, int i3, String str, String str2, String str3, int i4, u uVar) {
        this((i4 & 1) != 0 ? 0 : i2, (i4 & 2) != 0 ? 0.0f : f2, (i4 & 4) == 0 ? i3 : 0, (i4 & 8) != 0 ? null : str, (i4 & 16) != 0 ? null : str2, (i4 & 32) != 0 ? null : str3);
    }
}
