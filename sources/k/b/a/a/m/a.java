package k.b.a.a.m;

import com.umeng.analytics.pro.cb;
import java.security.SecureRandom;
import java.util.Random;

/* loaded from: classes4.dex */
public class a {
    public static final String a = "./0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    public static final char[] b = a.toCharArray();

    public static void a(byte b2, byte b3, byte b4, int i2, StringBuilder sb) {
        int i3 = ((b2 << cb.n) & 16777215) | ((b3 << 8) & 65535) | (b4 & 255);
        while (true) {
            int i4 = i2 - 1;
            if (i2 <= 0) {
                return;
            }
            sb.append(b[i3 & 63]);
            i3 >>= 6;
            i2 = i4;
        }
    }

    public static String b(int i2) {
        return c(i2, new SecureRandom());
    }

    public static String c(int i2, Random random) {
        StringBuilder sb = new StringBuilder(i2);
        for (int i3 = 1; i3 <= i2; i3++) {
            sb.append(a.charAt(random.nextInt(64)));
        }
        return sb.toString();
    }
}
