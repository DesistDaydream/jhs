package com.tencent.tpns.baseapi.core.c;

import com.umeng.analytics.pro.cb;

/* loaded from: classes3.dex */
public class b {
    private static final char[] a = "0123456789abcdef".toCharArray();

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (byte b : bArr) {
            char[] cArr = a;
            sb.append(cArr[(b >> 4) & 15]);
            sb.append(cArr[b & cb.f7124m]);
        }
        return sb.toString();
    }
}
