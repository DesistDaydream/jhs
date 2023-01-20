package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.b.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b createFromParcel(Parcel parcel) {
            return new b(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public b[] newArray(int i2) {
            return new b[i2];
        }
    };
    private String a;
    private a b;

    /* renamed from: c  reason: collision with root package name */
    private f f4896c;

    public b() {
    }

    public b(Parcel parcel) {
        this.a = parcel.readString();
        this.b = (a) parcel.readParcelable(a.class.getClassLoader());
        this.f4896c = (f) parcel.readParcelable(f.class.getClassLoader());
    }

    public b(String str, String str2, String str3) {
        this.a = str;
        if (TextUtils.isEmpty(str)) {
            this.b = new a();
            this.f4896c = new f();
            return;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.b = a.a(jSONObject.getJSONObject("ctl"));
            f a = f.a(jSONObject.getJSONObject("statics"));
            this.f4896c = a;
            a.c(str2);
            this.f4896c.d(str3);
        } catch (JSONException e2) {
            this.b = new a();
            this.f4896c = new f();
            e.p.a.a.a.f("ControlMessage", "parse control message error " + e2.getMessage());
        }
    }

    public static b a(String str) {
        b bVar = new b();
        try {
            JSONObject jSONObject = new JSONObject(str);
            bVar.a(a.a(jSONObject.getJSONObject("ctl")));
            bVar.a(f.a(jSONObject.getJSONObject("statics")));
        } catch (Exception e2) {
            e.p.a.a.a.f("ControlMessage", "parse control message error " + e2.getMessage());
            bVar.a(new f());
            bVar.a(new a());
        }
        return bVar;
    }

    public a a() {
        return this.b;
    }

    public void a(a aVar) {
        this.b = aVar;
    }

    public void a(f fVar) {
        this.f4896c = fVar;
    }

    public f b() {
        return this.f4896c;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ControlMessage{controlMessage='" + this.a + "', control=" + this.b + ", statics=" + this.f4896c + '}';
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeParcelable(this.b, i2);
        parcel.writeParcelable(this.f4896c, i2);
    }
}
