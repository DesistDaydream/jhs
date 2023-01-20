package com.tencent.tpns.mqttchannel.core.common.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.tpns.baseapi.base.util.Md5;
import com.tencent.tpns.mqttchannel.core.common.a.a;
import com.tencent.tpns.mqttchannel.core.common.a.b;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class Request implements Parcelable {
    public static final Parcelable.Creator<Request> CREATOR = new Parcelable.Creator<Request>() { // from class: com.tencent.tpns.mqttchannel.core.common.data.Request.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Request createFromParcel(Parcel parcel) {
            return new Request(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public Request[] newArray(int i2) {
            return new Request[i2];
        }
    };
    public static final int TYPE_EXPAND = 4;
    public static final int TYPE_PUBLISH = 2;
    public static final int TYPE_SEND_PUBLISH_DATA = 5;
    public static final int TYPE_SEND_REQUST = 6;
    public static final int TYPE_SUBSCRIBE = 1;
    public static final int TYPE_UNSUBSCRIBE = 3;
    private long a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private String f6930c;
    public int type;
    public volatile boolean isSent = false;

    /* renamed from: d  reason: collision with root package name */
    private String f6931d = "";

    /* renamed from: e  reason: collision with root package name */
    private int f6932e = 0;

    public Request(Parcel parcel) {
        this.a = parcel.readLong();
        this.b = parcel.readString();
        this.f6930c = parcel.readString();
    }

    public void addRetryCount() {
        this.f6932e++;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Request request = (Request) obj;
        return this.type == request.type && this.a == request.a;
    }

    public String getContent() {
        return this.f6930c;
    }

    public long getId() {
        return this.a;
    }

    public String getParamsMd5() {
        return this.f6931d;
    }

    public int getRetryCount() {
        return this.f6932e;
    }

    public String getTopic() {
        return this.b;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public void setContent(String str) {
        this.f6930c = str;
    }

    public void setId(long j2) {
        this.a = j2;
    }

    public void setToken(String str) {
        if (b.a(str)) {
            return;
        }
        try {
            if (!b.a(this.f6930c)) {
                JSONObject jSONObject = new JSONObject(this.f6930c);
                a.b("Request", "Update token to: " + str);
                jSONObject.put("token", str);
                String jSONObject2 = jSONObject.toString();
                this.f6930c = jSONObject2;
                this.f6931d = Md5.md5(jSONObject2);
            } else {
                a.d("Request", "request content null");
            }
        } catch (Throwable th) {
            a.a("Request", "setCurrentToken", th);
        }
    }

    public void setTopic(String str) {
        this.b = str;
    }

    public String toString() {
        return "Request{type=" + this.type + ", id=" + this.a + ", topic='" + this.b + "', content='" + this.f6930c + "', retryCount=" + this.f6932e + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeLong(this.a);
        parcel.writeString(this.b);
        parcel.writeString(this.f6930c);
    }

    public Request(long j2, String str, String str2) {
        this.a = j2;
        this.b = str;
        this.f6930c = str2;
    }
}
