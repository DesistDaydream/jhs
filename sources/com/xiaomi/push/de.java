package com.xiaomi.push;

import java.io.IOException;

/* loaded from: classes3.dex */
public abstract class de {
    public abstract void a(bc bcVar);

    public void a(byte[] bArr, int i2, int i3) {
        try {
            bc a = bc.a(bArr, i2, i3);
            a(a);
            a.c();
        } catch (IOException unused) {
            throw new RuntimeException("Serializing to a byte array threw an IOException (should never happen).");
        }
    }

    public boolean a(ab abVar, int i2) {
        return abVar.b(i2);
    }

    public de b(byte[] bArr) {
        return b(bArr, 0, bArr.length);
    }

    public de b(byte[] bArr, int i2, int i3) {
        try {
            ab a = ab.a(bArr, i2, i3);
            c(a);
            a.a(0);
            return this;
        } catch (cd e2) {
            throw e2;
        } catch (IOException unused) {
            throw new RuntimeException("Reading from a byte array threw an IOException (should never happen).");
        }
    }

    public abstract de c(ab abVar);

    public abstract int k();

    public abstract int l();

    public byte[] z() {
        int l2 = l();
        byte[] bArr = new byte[l2];
        a(bArr, 0, l2);
        return bArr;
    }
}
