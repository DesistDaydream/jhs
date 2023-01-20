package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class f implements Parcelable {
    public static final Parcelable.Creator<f> CREATOR = new Parcelable.Creator<f>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.f.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f createFromParcel(Parcel parcel) {
            return new f(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public f[] newArray(int i2) {
            return new f[i2];
        }
    };
    private String a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f4908c;

    /* renamed from: d  reason: collision with root package name */
    private String f4909d;

    /* renamed from: e  reason: collision with root package name */
    private String f4910e;

    public f() {
        this.f4908c = false;
    }

    public f(Parcel parcel) {
        this.f4908c = false;
        this.a = parcel.readString();
        this.b = parcel.readString();
        this.f4908c = parcel.readByte() != 0;
        this.f4909d = parcel.readString();
        this.f4910e = parcel.readString();
    }

    public static f a(JSONObject jSONObject) {
        String str;
        f fVar = new f();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("taskId")) {
                    fVar.a(jSONObject.getString("taskId"));
                }
                if (!jSONObject.isNull("time")) {
                    fVar.b(jSONObject.getString("time"));
                }
                if (!jSONObject.isNull("pushExtra")) {
                    fVar.a(jSONObject.getInt("pushExtra") == 0);
                }
            } catch (JSONException e2) {
                str = " parse statics message error " + e2.getMessage();
            }
            return fVar;
        }
        str = "no control statics can parse ";
        e.p.a.a.a.f("statics", str);
        return fVar;
    }

    public String a() {
        return this.a;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(boolean z) {
        this.f4908c = z;
    }

    public String b() {
        return this.b;
    }

    public void b(String str) {
        this.b = str;
    }

    public void c(String str) {
        this.f4909d = str;
    }

    public boolean c() {
        return this.f4908c;
    }

    public String d() {
        return this.f4909d;
    }

    public void d(String str) {
        this.f4910e = str;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f4910e;
    }

    public String toString() {
        return "Statics{taskId='" + this.a + "', time='" + this.b + "', pushExtra=" + this.f4908c + ", deviceId='" + this.f4909d + "', seqId='" + this.f4910e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeString(this.b);
        parcel.writeByte(this.f4908c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f4909d);
        parcel.writeString(this.f4910e);
    }
}
