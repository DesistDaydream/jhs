package k.b.a.a.m;

import java.nio.charset.StandardCharsets;

/* loaded from: classes4.dex */
public class b {
    public static String a(String str) {
        return b(str, null);
    }

    public static String b(String str, String str2) {
        return d(str.getBytes(StandardCharsets.UTF_8), str2);
    }

    public static String c(byte[] bArr) {
        return d(bArr, null);
    }

    public static String d(byte[] bArr, String str) {
        if (str == null) {
            return k.e(bArr);
        }
        if (str.startsWith(k.f16118h)) {
            return k.f(bArr, str);
        }
        if (str.startsWith(k.f16116f)) {
            return k.b(bArr, str);
        }
        if (str.startsWith(e.f16076c)) {
            return e.g(bArr, str);
        }
        return l.f(bArr, str);
    }
}
