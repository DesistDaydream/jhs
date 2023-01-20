package com.umeng.analytics.pro;

import java.io.ByteArrayOutputStream;

/* loaded from: classes3.dex */
public class ax extends ByteArrayOutputStream {
    public ax(int i2) {
        super(i2);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }

    public ax() {
    }
}
