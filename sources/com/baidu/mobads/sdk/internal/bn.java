package com.baidu.mobads.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class bn implements Parcelable {
    public static final String a = "MD5";
    public static final Parcelable.Creator<bn> b = new bo();

    /* renamed from: c  reason: collision with root package name */
    private JSONObject f1517c;

    /* renamed from: d  reason: collision with root package name */
    private double f1518d;

    /* renamed from: e  reason: collision with root package name */
    private String f1519e;

    /* renamed from: f  reason: collision with root package name */
    private String f1520f;

    /* renamed from: g  reason: collision with root package name */
    private String f1521g;

    /* renamed from: h  reason: collision with root package name */
    private int f1522h;

    /* renamed from: i  reason: collision with root package name */
    private int f1523i;

    public /* synthetic */ bn(Parcel parcel, bo boVar) {
        this(parcel);
    }

    public Boolean a() {
        return Boolean.valueOf(this.f1523i == 1);
    }

    public double b() {
        return this.f1518d;
    }

    public String c() {
        return cg.a().c(this.f1519e);
    }

    public String d() {
        return this.f1520f;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String e() {
        return this.f1521g;
    }

    public Boolean f() {
        return Boolean.valueOf(this.f1522h == 1);
    }

    public String toString() {
        return this.f1517c.toString();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.f1520f);
        parcel.writeInt(this.f1523i);
        parcel.writeString(this.f1519e);
        parcel.writeDouble(this.f1518d);
        parcel.writeString(this.f1521g);
        parcel.writeInt(this.f1522h);
    }

    public bn(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            this.f1517c = jSONObject;
            this.f1518d = jSONObject.getDouble("version");
            this.f1519e = this.f1517c.getString("url");
            this.f1520f = this.f1517c.getString("sign");
            this.f1523i = 1;
            this.f1521g = "";
            this.f1522h = 0;
        } catch (JSONException unused) {
            this.f1523i = 0;
        }
        this.f1523i = c() == null ? 0 : 1;
    }

    public bn(bn bnVar, String str, Boolean bool) {
        this.f1518d = bnVar.b();
        this.f1519e = bnVar.c();
        this.f1520f = bnVar.d();
        this.f1523i = bnVar.a().booleanValue() ? 1 : 0;
        this.f1521g = str;
        this.f1522h = bool.booleanValue() ? 1 : 0;
    }

    private bn(Parcel parcel) {
        this.f1520f = parcel.readString();
        this.f1523i = parcel.readInt();
        this.f1519e = parcel.readString();
        this.f1518d = parcel.readDouble();
        this.f1521g = parcel.readString();
        this.f1522h = parcel.readInt();
    }
}
