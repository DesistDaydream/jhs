package com.meizu.cloud.pushsdk.notification.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class a implements Parcelable {
    public static final Parcelable.Creator<a> CREATOR = new Parcelable.Creator<a>() { // from class: com.meizu.cloud.pushsdk.notification.model.a.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a createFromParcel(Parcel parcel) {
            return new a(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public a[] newArray(int i2) {
            return new a[i2];
        }
    };
    private int a;
    private String b;

    public a() {
        this.a = 0;
    }

    public a(Parcel parcel) {
        this.a = 0;
        this.a = parcel.readInt();
        this.b = parcel.readString();
    }

    public static a a(MessageV3 messageV3) {
        a c2;
        try {
            c2 = !TextUtils.isEmpty(messageV3.getNotificationMessage()) ? a(new JSONObject(messageV3.getNotificationMessage()).getJSONObject("data").getJSONObject("extra").getJSONObject("no")) : null;
        } catch (Exception e2) {
            e.p.a.a.a.f("NotifyOption", "parse flyme NotifyOption setting error " + e2.getMessage() + " so get from notificationMessage");
            c2 = c(messageV3.getNotificationMessage());
        }
        e.p.a.a.a.c("NotifyOption", "current notify option is " + c2);
        return c2;
    }

    public static a a(JSONObject jSONObject) {
        String str;
        a aVar = new a();
        if (jSONObject != null) {
            try {
                if (!jSONObject.isNull("ni")) {
                    aVar.a(jSONObject.getInt("ni"));
                }
                if (!jSONObject.isNull("nk")) {
                    aVar.a(jSONObject.getString("nk"));
                }
            } catch (JSONException e2) {
                str = "parse json obj error " + e2.getMessage();
            }
            return aVar;
        }
        str = "no such tag NotifyOption";
        e.p.a.a.a.f("NotifyOption", str);
        return aVar;
    }

    public static int b(MessageV3 messageV3) {
        a a = a(messageV3);
        if (a != null) {
            return a.a();
        }
        return 0;
    }

    public static a b(String str) {
        JSONObject jSONObject;
        if (!TextUtils.isEmpty(str)) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException e2) {
                e.p.a.a.a.f("NotifyOption", "parse json string error " + e2.getMessage());
            }
            return a(jSONObject);
        }
        jSONObject = null;
        return a(jSONObject);
    }

    private static a c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return b(new JSONObject(str).getString("no"));
        } catch (JSONException e2) {
            e.p.a.a.a.f("NotifyOption", "parse notificationMessage error " + e2.getMessage());
            return null;
        }
    }

    public int a() {
        return this.a;
    }

    public void a(int i2) {
        this.a = i2;
    }

    public void a(String str) {
        this.b = str;
    }

    public String b() {
        return this.b;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "NotifyOption{notifyId=" + this.a + ", notifyKey='" + this.b + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeString(this.b);
    }
}
