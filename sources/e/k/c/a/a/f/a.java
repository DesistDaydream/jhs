package e.k.c.a.a.f;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.mipush.sdk.Constants;
import k.b.a.a.n.l;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "Anonymizer";

    public static String a(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        if (str.length() < 8) {
            return d(str, 0, 1);
        }
        return d(str, 0, 4);
    }

    public static String b(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return b.b(str, '*');
        }
        if (str.length() >= 11 && str.length() < 20) {
            return d(str, 4, 4);
        }
        return d(str, 6, 4);
    }

    public static String c(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 4) {
            return b.b(str, '*');
        }
        String[] f2 = b.f(str, 4);
        return b.d("", b.e(f2, 0), b.c(b.e(f2, 1), "0123456789", "*"));
    }

    public static String d(String str, int i2, int i3) {
        int length;
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (i2 < 0) {
            i2 = 0;
        }
        if (i3 < 0) {
            i3 = 0;
        }
        if (str.length() <= i2 + i3) {
            length = str.length() - 1;
            i2 = 1;
        } else {
            length = str.length() - i3;
        }
        String[] g2 = b.g(str, i2, length);
        return b.d("", b.e(g2, 0), b.b(b.e(g2, 1), '*'), b.e(g2, 2));
    }

    public static String e(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 1) {
            return "*";
        }
        int indexOf = str.indexOf(64);
        if (indexOf < 0) {
            String[] f2 = b.f(str, 1);
            return b.d("", b.e(f2, 0), b.b(b.e(f2, 1), '*'));
        }
        String[] h2 = b.h(str, indexOf, indexOf + 1, str.lastIndexOf(46));
        return b.d("", b.b(b.e(h2, 0), '*'), b.e(h2, 1), b.b(b.e(h2, 2), '*'), b.e(h2, 3));
    }

    public static String f(String str) {
        return (str == null || str.length() <= 0) ? "" : d(str, str.length() - 12, 0);
    }

    public static String g(String str) {
        return (str == null || str.length() <= 0) ? "" : d(str, str.length() - 4, 0);
    }

    public static String h(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        if (lastIndexOf < 0) {
            return b.b(str, '*');
        }
        String[] f2 = b.f(str, lastIndexOf + 1);
        return b.d("", b.e(f2, 0), b.b(b.e(f2, 1), '*'));
    }

    public static String i(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        String[] l2 = b.l(str, ':');
        if (l2.length <= 1) {
            return b.b(str, '*');
        }
        if (l2.length != 8) {
            String[] f2 = b.f(str, str.indexOf(58) + 1);
            return b.d("", b.e(f2, 0), b.c(b.e(f2, 1), "0123456789ABCDEFabcdef", "*"));
        }
        l2[2] = j(l2[2]);
        for (int i2 = 3; i2 < l2.length; i2++) {
            l2[i2] = b.b(l2[i2], '*');
        }
        return b.d(Constants.COLON_SEPARATOR, l2);
    }

    public static String j(String str) {
        if (TextUtils.isEmpty(str)) {
            Log.e(a, "maskLower8Bit: s is null");
            return "";
        } else if (str.length() <= 2) {
            return b.b(str, '*');
        } else {
            String[] f2 = b.f(str, str.length() - 2);
            return b.d("", b.e(f2, 0), b.b(b.e(f2, 1), '*'));
        }
    }

    public static String k(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int a2 = b.a(str, l.f16189d, 2);
        if (a2 < 0) {
            return b.c(str, "0123456789ABCDEFabcdef", "*");
        }
        String[] f2 = b.f(str, a2);
        return b.d("", b.e(f2, 0), b.c(b.e(f2, 1), "0123456789ABCDEFabcdef", "*"));
    }

    public static String l(String str) {
        return (str == null || str.length() <= 0) ? "" : str.length() <= 1 ? "*" : d(str, 1, 0);
    }

    public static String m(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        if (str.length() <= 2) {
            return b.b(str, '*');
        }
        if (str.length() >= 8 && str.length() < 11) {
            return d(str, 2, 2);
        }
        return d(str, 3, 4);
    }
}
