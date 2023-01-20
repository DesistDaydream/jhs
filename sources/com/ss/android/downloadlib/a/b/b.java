package com.ss.android.downloadlib.a.b;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new Parcelable.Creator<b>() { // from class: com.ss.android.downloadlib.a.b.b.1
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
    public int a;
    public int b;

    /* renamed from: c  reason: collision with root package name */
    public String f5204c;

    /* renamed from: d  reason: collision with root package name */
    public int f5205d;

    /* renamed from: e  reason: collision with root package name */
    public String f5206e;

    /* renamed from: f  reason: collision with root package name */
    public String f5207f;

    public b() {
        this.f5204c = "";
        this.f5206e = "";
        this.f5207f = "";
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.b == bVar.b) {
                String str = this.f5204c;
                if (str != null) {
                    return str.equals(bVar.f5204c);
                }
                if (bVar.f5204c == null) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int i2 = ((this.a * 31) + this.b) * 31;
        String str = this.f5204c;
        return i2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeString(this.f5204c);
        parcel.writeString(this.f5206e);
        parcel.writeString(this.f5207f);
        parcel.writeInt(this.f5205d);
    }

    public b(Parcel parcel) {
        this.f5204c = "";
        this.f5206e = "";
        this.f5207f = "";
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.f5204c = parcel.readString();
        this.f5206e = parcel.readString();
        this.f5207f = parcel.readString();
        this.f5205d = parcel.readInt();
    }
}
