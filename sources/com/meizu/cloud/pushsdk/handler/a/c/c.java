package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.meizu.cloud.pushsdk.handler.MessageV3;

/* loaded from: classes2.dex */
public class c implements Parcelable {
    public static final Parcelable.Creator<c> CREATOR = new Parcelable.Creator<c>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.c.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c createFromParcel(Parcel parcel) {
            return new c(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public c[] newArray(int i2) {
            return new c[i2];
        }
    };
    private MessageV3 a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f4897c;

    /* renamed from: d  reason: collision with root package name */
    private int f4898d;

    public c(Parcel parcel) {
        this.a = (MessageV3) parcel.readParcelable(MessageV3.class.getClassLoader());
        this.b = parcel.readString();
        this.f4897c = parcel.readInt();
        this.f4898d = parcel.readInt();
    }

    public c(MessageV3 messageV3) {
        this.a = messageV3;
    }

    public MessageV3 a() {
        return this.a;
    }

    public void a(int i2) {
        this.f4897c = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public int b() {
        return this.f4897c;
    }

    public void b(int i2) {
        this.f4898d = i2;
    }

    public int c() {
        return this.f4898d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotificationState{messageV3=" + this.a + ", notificationPkg='" + this.b + "', notificationId='" + this.f4897c + "', state='" + this.f4898d + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.b);
        parcel.writeInt(this.f4897c);
        parcel.writeInt(this.f4898d);
    }
}
