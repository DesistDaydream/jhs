package k.b.a.a.n;

import java.util.Locale;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public final class m {
    public static String a(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        int length = str.length();
        char[] cArr = new char[length];
        int i2 = 0;
        for (int i3 = 0; i3 < length; i3++) {
            if (Character.isLetter(str.charAt(i3))) {
                cArr[i2] = str.charAt(i3);
                i2++;
            }
        }
        if (i2 == length) {
            return str.toUpperCase(Locale.ENGLISH);
        }
        return new String(cArr, 0, i2).toUpperCase(Locale.ENGLISH);
    }

    public static int b(k.b.a.a.i iVar, String str, String str2) throws EncoderException {
        return c(iVar.f(str), iVar.f(str2));
    }

    public static int c(String str, String str2) {
        if (str == null || str2 == null) {
            return 0;
        }
        int min = Math.min(str.length(), str2.length());
        int i2 = 0;
        for (int i3 = 0; i3 < min; i3++) {
            if (str.charAt(i3) == str2.charAt(i3)) {
                i2++;
            }
        }
        return i2;
    }
}
