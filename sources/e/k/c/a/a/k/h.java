package e.k.c.a.a.k;

import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes2.dex */
public class h {
    private static final String a = "SafeStringBuilder";
    private static final String b = "";

    public static String a(StringBuilder sb, int i2) {
        if (!TextUtils.isEmpty(sb) && sb.length() >= i2 && i2 >= 0) {
            try {
                return sb.substring(i2);
            } catch (Exception e2) {
                String str = a;
                Log.e(str, "substring exception: " + e2.getMessage());
            }
        }
        return "";
    }

    public static String b(StringBuilder sb, int i2, int i3) {
        if (!TextUtils.isEmpty(sb) && i2 >= 0 && i3 <= sb.length() && i3 >= i2) {
            try {
                return sb.substring(i2, i3);
            } catch (Exception e2) {
                String str = a;
                Log.e(str, "substring: " + e2.getMessage());
            }
        }
        return "";
    }
}
