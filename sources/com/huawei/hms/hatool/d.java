package com.huawei.hms.hatool;

import android.util.Pair;
import java.nio.charset.Charset;

/* loaded from: classes2.dex */
public class d {
    public static final Charset a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str) {
        if (str == null || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, 32);
        return new Pair<>(e.k.c.a.a.h.g.c.c(substring), str.substring(32));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a2 = a(str);
        return new String(e.k.c.a.a.h.c.a.p(e.k.c.a.a.h.g.c.c((String) a2.second), e.k.c.a.a.h.g.c.c(str2), (byte[]) a2.first), a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] c2 = e.k.c.a.a.h.g.c.c(str);
            if (c2.length >= 16) {
                return e.k.c.a.a.h.g.c.b(e.k.c.a.a.h.c.a.x(bArr, c2));
            }
            str2 = "key length is not right";
        }
        y.b("AesCipher", str2);
        return "";
    }

    public static String b(String str, String str2) {
        return e.k.c.a.a.h.g.c.b(e.k.c.a.a.h.c.a.x(str.getBytes(a), e.k.c.a.a.h.g.c.c(str2)));
    }
}
