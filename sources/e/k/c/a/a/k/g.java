package e.k.c.a.a.k;

import android.util.Log;

/* loaded from: classes2.dex */
public class g {
    private static final String a = "SafeStringBuffer";
    private static final String b = "";

    public static String a(StringBuffer stringBuffer, int i2) {
        if (stringBuffer != null && stringBuffer.length() >= i2 && i2 >= 0) {
            try {
                return stringBuffer.substring(i2);
            } catch (Exception e2) {
                String str = a;
                Log.e(str, "substring exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static String b(StringBuffer stringBuffer, int i2, int i3) {
        if (stringBuffer != null && i2 >= 0 && i3 <= stringBuffer.length() && i3 >= i2) {
            try {
                return stringBuffer.substring(i2, i3);
            } catch (Exception e2) {
                String str = a;
                Log.e(str, "substring: " + e2.getMessage());
            }
        }
        return "";
    }
}
