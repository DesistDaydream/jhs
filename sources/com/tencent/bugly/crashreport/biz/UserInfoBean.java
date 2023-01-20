package com.tencent.bugly.crashreport.biz;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.bugly.proguard.ab;
import java.util.Map;

/* loaded from: classes3.dex */
public class UserInfoBean implements Parcelable {
    public static final Parcelable.Creator<UserInfoBean> CREATOR = new Parcelable.Creator<UserInfoBean>() { // from class: com.tencent.bugly.crashreport.biz.UserInfoBean.1
        @Override // android.os.Parcelable.Creator
        public final /* synthetic */ UserInfoBean createFromParcel(Parcel parcel) {
            return new UserInfoBean(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public final /* bridge */ /* synthetic */ UserInfoBean[] newArray(int i2) {
            return new UserInfoBean[i2];
        }
    };
    public long a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f6493c;

    /* renamed from: d  reason: collision with root package name */
    public String f6494d;

    /* renamed from: e  reason: collision with root package name */
    public long f6495e;

    /* renamed from: f  reason: collision with root package name */
    public long f6496f;

    /* renamed from: g  reason: collision with root package name */
    public long f6497g;

    /* renamed from: h  reason: collision with root package name */
    public long f6498h;

    /* renamed from: i  reason: collision with root package name */
    public long f6499i;

    /* renamed from: j  reason: collision with root package name */
    public String f6500j;

    /* renamed from: k  reason: collision with root package name */
    public long f6501k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f6502l;

    /* renamed from: m  reason: collision with root package name */
    public String f6503m;
    public String n;
    public int o;
    public int p;
    public int q;
    public Map<String, String> r;
    public Map<String, String> s;

    public UserInfoBean() {
        this.f6501k = 0L;
        this.f6502l = false;
        this.f6503m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.b);
        parcel.writeString(this.f6493c);
        parcel.writeString(this.f6494d);
        parcel.writeLong(this.f6495e);
        parcel.writeLong(this.f6496f);
        parcel.writeLong(this.f6497g);
        parcel.writeLong(this.f6498h);
        parcel.writeLong(this.f6499i);
        parcel.writeString(this.f6500j);
        parcel.writeLong(this.f6501k);
        parcel.writeByte(this.f6502l ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6503m);
        parcel.writeInt(this.p);
        parcel.writeInt(this.q);
        ab.b(parcel, this.r);
        ab.b(parcel, this.s);
        parcel.writeString(this.n);
        parcel.writeInt(this.o);
    }

    public UserInfoBean(Parcel parcel) {
        this.f6501k = 0L;
        this.f6502l = false;
        this.f6503m = "unknown";
        this.p = -1;
        this.q = -1;
        this.r = null;
        this.s = null;
        this.b = parcel.readInt();
        this.f6493c = parcel.readString();
        this.f6494d = parcel.readString();
        this.f6495e = parcel.readLong();
        this.f6496f = parcel.readLong();
        this.f6497g = parcel.readLong();
        this.f6498h = parcel.readLong();
        this.f6499i = parcel.readLong();
        this.f6500j = parcel.readString();
        this.f6501k = parcel.readLong();
        this.f6502l = parcel.readByte() == 1;
        this.f6503m = parcel.readString();
        this.p = parcel.readInt();
        this.q = parcel.readInt();
        this.r = ab.b(parcel);
        this.s = ab.b(parcel);
        this.n = parcel.readString();
        this.o = parcel.readInt();
    }
}
