package com.tencent.android.tpush;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class XGPushTextMessage implements Parcelable {
    public static final Parcelable.Creator<XGPushTextMessage> CREATOR = new Parcelable.Creator<XGPushTextMessage>() { // from class: com.tencent.android.tpush.XGPushTextMessage.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public XGPushTextMessage createFromParcel(Parcel parcel) {
            return new XGPushTextMessage(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public XGPushTextMessage[] newArray(int i2) {
            return new XGPushTextMessage[i2];
        }
    };
    public long a;
    public String b;

    /* renamed from: c  reason: collision with root package name */
    public String f6039c;

    /* renamed from: d  reason: collision with root package name */
    public String f6040d;

    /* renamed from: e  reason: collision with root package name */
    public int f6041e;

    /* renamed from: f  reason: collision with root package name */
    public String f6042f;

    /* renamed from: g  reason: collision with root package name */
    public String f6043g;

    /* renamed from: h  reason: collision with root package name */
    private Intent f6044h;

    public XGPushTextMessage() {
        this.a = 0L;
        this.b = "";
        this.f6039c = "";
        this.f6040d = "";
        this.f6041e = 100;
        this.f6042f = "";
        this.f6043g = "";
        this.f6044h = null;
    }

    public void a(Intent intent) {
        this.f6044h = intent;
        if (intent != null) {
            intent.removeExtra("content");
        }
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getContent() {
        return this.f6039c;
    }

    public String getCustomContent() {
        return this.f6040d;
    }

    public long getMsgId() {
        return this.a;
    }

    public int getPushChannel() {
        return this.f6041e;
    }

    public String getTemplateId() {
        return this.f6042f;
    }

    public String getTitle() {
        return this.b;
    }

    public String getTraceId() {
        return this.f6043g;
    }

    public String toString() {
        return "XGPushTextMessage [msgId = " + this.a + ", title=" + this.b + ", content=" + this.f6039c + ", customContent=" + this.f6040d + ", pushChannel = " + this.f6041e + ", templateId = " + this.f6042f + ", traceId = " + this.f6043g + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f6039c);
        parcel.writeString(this.f6040d);
        parcel.writeInt(this.f6041e);
        parcel.writeParcelable(this.f6044h, 1);
        parcel.writeString(this.f6042f);
        parcel.writeString(this.f6043g);
    }

    public Intent a() {
        return this.f6044h;
    }

    public XGPushTextMessage(Parcel parcel) {
        this.a = 0L;
        this.b = "";
        this.f6039c = "";
        this.f6040d = "";
        this.f6041e = 100;
        this.f6042f = "";
        this.f6043g = "";
        this.f6044h = null;
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.f6039c = parcel.readString();
        this.f6040d = parcel.readString();
        this.f6041e = parcel.readInt();
        this.f6044h = (Intent) parcel.readParcelable(Intent.class.getClassLoader());
        this.f6042f = parcel.readString();
        this.f6043g = parcel.readString();
    }
}
