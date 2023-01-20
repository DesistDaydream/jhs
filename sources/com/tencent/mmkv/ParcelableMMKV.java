package com.tencent.mmkv;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import java.io.IOException;

/* loaded from: classes3.dex */
public final class ParcelableMMKV implements Parcelable {
    public static final Parcelable.Creator<ParcelableMMKV> CREATOR = new Parcelable.Creator<ParcelableMMKV>() { // from class: com.tencent.mmkv.ParcelableMMKV.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV createFromParcel(Parcel source) {
            String readString = source.readString();
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            ParcelFileDescriptor parcelFileDescriptor2 = (ParcelFileDescriptor) ParcelFileDescriptor.CREATOR.createFromParcel(source);
            String readString2 = source.readString();
            if (parcelFileDescriptor == null || parcelFileDescriptor2 == null) {
                return null;
            }
            return new ParcelableMMKV(readString, parcelFileDescriptor.detachFd(), parcelFileDescriptor2.detachFd(), readString2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ParcelableMMKV[] newArray(int size) {
            return new ParcelableMMKV[size];
        }
    };
    private int ashmemFD;
    private int ashmemMetaFD;
    private String cryptKey;
    private final String mmapID;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 1;
    }

    public MMKV toMMKV() {
        int i2;
        int i3 = this.ashmemFD;
        if (i3 < 0 || (i2 = this.ashmemMetaFD) < 0) {
            return null;
        }
        return MMKV.mmkvWithAshmemFD(this.mmapID, i3, i2, this.cryptKey);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeString(this.mmapID);
            ParcelFileDescriptor fromFd = ParcelFileDescriptor.fromFd(this.ashmemFD);
            ParcelFileDescriptor fromFd2 = ParcelFileDescriptor.fromFd(this.ashmemMetaFD);
            int i2 = flags | 1;
            fromFd.writeToParcel(dest, i2);
            fromFd2.writeToParcel(dest, i2);
            String str = this.cryptKey;
            if (str != null) {
                dest.writeString(str);
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public ParcelableMMKV(MMKV mmkv) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = mmkv.mmapID();
        this.ashmemFD = mmkv.ashmemFD();
        this.ashmemMetaFD = mmkv.ashmemMetaFD();
        this.cryptKey = mmkv.cryptKey();
    }

    private ParcelableMMKV(String id, int fd, int metaFD, String key) {
        this.ashmemFD = -1;
        this.ashmemMetaFD = -1;
        this.cryptKey = null;
        this.mmapID = id;
        this.ashmemFD = fd;
        this.ashmemMetaFD = metaFD;
        this.cryptKey = key;
    }
}
