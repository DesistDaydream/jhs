package com.meizu.cloud.pushsdk.handler.a.c;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class g implements Parcelable {
    public static final Parcelable.Creator<g> CREATOR = new Parcelable.Creator<g>() { // from class: com.meizu.cloud.pushsdk.handler.a.c.g.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g createFromParcel(Parcel parcel) {
            return new g(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public g[] newArray(int i2) {
            return new g[i2];
        }
    };
    private int a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private List<String> f4911c;

    /* renamed from: d  reason: collision with root package name */
    private b f4912d;

    /* renamed from: e  reason: collision with root package name */
    private String f4913e;

    public g(Parcel parcel) {
        this.a = parcel.readInt();
        this.b = parcel.readByte() != 0;
        this.f4911c = parcel.createStringArrayList();
        this.f4912d = (b) parcel.readParcelable(b.class.getClassLoader());
        this.f4913e = parcel.readString();
    }

    public g(String str, String str2, String str3, String str4) {
        this.f4913e = str;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (!jSONObject.isNull("max_size")) {
                this.a = jSONObject.getInt("max_size");
            }
            if (!jSONObject.isNull("wifi_upload")) {
                this.b = jSONObject.getBoolean("wifi_upload");
            }
            if (!jSONObject.isNull("upload_files")) {
                JSONArray jSONArray = jSONObject.getJSONArray("upload_files");
                this.f4911c = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.f4911c.add(jSONArray.getString(i2));
                }
            }
        } catch (JSONException e2) {
            e.p.a.a.a.f("UploadLogMessage", "parse upload message error " + e2.getMessage());
        }
        this.f4912d = new b(str2, str3, str4);
    }

    public int a() {
        return this.a;
    }

    public boolean b() {
        return this.b;
    }

    public List<String> c() {
        return this.f4911c;
    }

    public b d() {
        return this.f4912d;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "UploadLogMessage{maxSize=" + this.a + ", wifiUpload=" + this.b + ", fileList=" + this.f4911c + ", controlMessage=" + this.f4912d + ", uploadMessage='" + this.f4913e + "'}";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeByte(this.b ? (byte) 1 : (byte) 0);
        parcel.writeStringList(this.f4911c);
        parcel.writeParcelable(this.f4912d, i2);
        parcel.writeString(this.f4913e);
    }
}
