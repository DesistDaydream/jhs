package com.qiniu.android.storage;

/* loaded from: classes3.dex */
public interface Recorder {
    void del(String str);

    byte[] get(String str);

    String getFileName();

    void set(String str, byte[] bArr);
}
