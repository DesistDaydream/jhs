package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes3.dex */
public class Cif extends ByteArrayOutputStream {
    public Cif() {
    }

    public Cif(int i2) {
        super(i2);
    }

    public byte[] a() {
        return ((ByteArrayOutputStream) this).buf;
    }

    public int b() {
        return ((ByteArrayOutputStream) this).count;
    }
}
