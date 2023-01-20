package com.tencent.bugly.crashreport.common.strategy;

import android.os.Parcel;
import android.os.Parcelable;
import com.moor.imkf.lib.jobqueue.base.JobManager;
import com.tencent.bugly.proguard.ab;
import java.util.Map;

/* loaded from: classes3.dex */
public class StrategyBean implements Parcelable {
    public static final Parcelable.Creator<StrategyBean> CREATOR = new Parcelable.Creator<StrategyBean>() { // from class: com.tencent.bugly.crashreport.common.strategy.StrategyBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ StrategyBean createFromParcel(Parcel parcel) {
            return new StrategyBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ StrategyBean[] newArray(int i2) {
            return new StrategyBean[i2];
        }
    };
    public static String a = "https://android.bugly.qq.com/rqd/async";
    public static String b = "https://android.bugly.qq.com/rqd/async";

    /* renamed from: c  reason: collision with root package name */
    public long f6531c;

    /* renamed from: d  reason: collision with root package name */
    public long f6532d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f6533e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6534f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6535g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f6536h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f6537i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6538j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f6539k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6540l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f6541m;
    public long n;
    public long o;
    public String p;
    public String q;
    public String r;
    public Map<String, String> s;
    public int t;
    public long u;
    public long v;

    public StrategyBean() {
        this.f6531c = -1L;
        this.f6532d = -1L;
        this.f6533e = true;
        this.f6534f = true;
        this.f6535g = true;
        this.f6536h = true;
        this.f6537i = false;
        this.f6538j = true;
        this.f6539k = true;
        this.f6540l = true;
        this.f6541m = true;
        this.o = JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = 300000L;
        this.v = -1L;
        this.f6532d = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        sb.append("S(@L@L");
        sb.append("@)");
        sb.toString();
        sb.setLength(0);
        sb.append("*^@K#K");
        sb.append("@!");
        this.r = sb.toString();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.f6532d);
        parcel.writeByte(this.f6533e ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6534f ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6535g ? (byte) 1 : (byte) 0);
        parcel.writeString(this.p);
        parcel.writeString(this.q);
        parcel.writeString(this.r);
        ab.b(parcel, this.s);
        parcel.writeByte(this.f6536h ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6537i ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6540l ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6541m ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.o);
        parcel.writeByte(this.f6538j ? (byte) 1 : (byte) 0);
        parcel.writeByte(this.f6539k ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.n);
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeLong(this.v);
    }

    public StrategyBean(Parcel parcel) {
        this.f6531c = -1L;
        this.f6532d = -1L;
        boolean z = true;
        this.f6533e = true;
        this.f6534f = true;
        this.f6535g = true;
        this.f6536h = true;
        this.f6537i = false;
        this.f6538j = true;
        this.f6539k = true;
        this.f6540l = true;
        this.f6541m = true;
        this.o = JobManager.MIN_DELAY_TO_USE_SCHEDULER_IN_MS;
        this.p = a;
        this.q = b;
        this.t = 10;
        this.u = 300000L;
        this.v = -1L;
        try {
            String str = "S(@L@L@)";
            this.f6532d = parcel.readLong();
            this.f6533e = parcel.readByte() == 1;
            this.f6534f = parcel.readByte() == 1;
            this.f6535g = parcel.readByte() == 1;
            this.p = parcel.readString();
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = ab.b(parcel);
            this.f6536h = parcel.readByte() == 1;
            this.f6537i = parcel.readByte() == 1;
            this.f6540l = parcel.readByte() == 1;
            this.f6541m = parcel.readByte() == 1;
            this.o = parcel.readLong();
            this.f6538j = parcel.readByte() == 1;
            if (parcel.readByte() != 1) {
                z = false;
            }
            this.f6539k = z;
            this.n = parcel.readLong();
            this.t = parcel.readInt();
            this.u = parcel.readLong();
            this.v = parcel.readLong();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
