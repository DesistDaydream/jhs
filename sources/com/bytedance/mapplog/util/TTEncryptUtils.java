package com.bytedance.mapplog.util;

import bykvm_19do.bykvm_19do.bykvm_19do.l0;

/* loaded from: classes.dex */
public class TTEncryptUtils {
    static {
        try {
            System.loadLibrary("tobEmbedEncryptForM");
        } catch (UnsatisfiedLinkError e2) {
            l0.a(e2);
        }
    }

    public static byte[] a(byte[] bArr, int i2) {
        try {
            return ttEncrypt(bArr, i2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static native byte[] ttEncrypt(byte[] bArr, int i2);
}
