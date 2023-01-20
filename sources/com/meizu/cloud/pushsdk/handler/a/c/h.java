package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.push.constant.RemoteMessageConst;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class h implements Parcelable {
    public static final Parcelable.Creator<h> CREATOR = new Parcelable.Creator<h>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.h.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h createFromParcel(Parcel parcel) {
            return new h(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public h[] newArray(int i2) {
            return new h[i2];
        }
    };
    private b a;
    private String b;

    /* renamed from: c  reason: collision with root package name */
    private int f4914c;

    public h(Parcel parcel) {
        this.a = (b) parcel.readParcelable(b.class.getClassLoader());
        this.b = parcel.readString();
        this.f4914c = parcel.readInt();
    }

    public h(String str, String str2, String str3, String str4, String str5) {
        this.b = str2;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull(RemoteMessageConst.Notification.NOTIFY_ID)) {
                this.f4914c = jSONObject.getInt(RemoteMessageConst.Notification.NOTIFY_ID);
            }
        } catch (JSONException e2) {
            e.p.a.a.a.f("WithDrawMessage", "parse WithDrawMessage error " + e2.getMessage());
        }
        this.a = new b(str3, str4, str5);
    }

    public b a() {
        return this.a;
    }

    public int b() {
        return this.f4914c;
    }

    public String c() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WithDrawMessage{controlMessage=" + this.a + ", revokePackageName='" + this.b + "', notifyId=" + this.f4914c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeParcelable(this.a, i2);
        parcel.writeString(this.b);
        parcel.writeInt(this.f4914c);
    }
}
