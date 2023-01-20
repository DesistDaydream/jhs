package com.tencent.android.tpush.data;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes3.dex */
public class StorageEntity implements Parcelable {
    public static final Parcelable.Creator<StorageEntity> CREATOR = new Parcelable.Creator<StorageEntity>() { // from class: com.tencent.android.tpush.data.StorageEntity.1
        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StorageEntity createFromParcel(Parcel parcel) {
            return new StorageEntity(parcel);
        }

        @Override // android.os.Parcelable.Creator
        /* renamed from: a */
        public StorageEntity[] newArray(int i2) {
            return new StorageEntity[i2];
        }
    };
    public String a = "";
    public int b = -1;

    /* renamed from: c  reason: collision with root package name */
    public boolean f6101c;

    /* renamed from: d  reason: collision with root package name */
    public String f6102d;

    /* renamed from: e  reason: collision with root package name */
    public int f6103e;

    /* renamed from: f  reason: collision with root package name */
    public float f6104f;

    /* renamed from: g  reason: collision with root package name */
    public long f6105g;

    public StorageEntity() {
    }

    private void a(Parcel parcel) {
        this.a = parcel.readString();
        this.b = parcel.readInt();
        this.f6101c = parcel.readByte() == 1;
        this.f6102d = parcel.readString();
        this.f6103e = parcel.readInt();
        this.f6104f = parcel.readFloat();
        this.f6105g = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "StorageEntity[key:" + this.a + ",type:" + this.b + ",strValue:" + this.f6102d + ",boolValue:" + this.f6101c + ",intValue" + this.f6103e + ",floatValue:" + this.f6104f + ",longValue:" + this.f6105g + "]";
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.a);
        parcel.writeInt(this.b);
        parcel.writeByte(this.f6101c ? (byte) 1 : (byte) 0);
        parcel.writeString(this.f6102d);
        parcel.writeInt(this.f6103e);
        parcel.writeFloat(this.f6104f);
        parcel.writeLong(this.f6105g);
    }

    public StorageEntity(Parcel parcel) {
        a(parcel);
    }
}
