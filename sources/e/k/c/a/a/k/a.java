package e.k.c.a.a.k;

import android.text.TextUtils;
import android.util.Log;
import h.t2.y;
import java.util.Locale;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "EncodeUtil";
    private static final char[] b = {',', '.', k.b.a.a.n.l.f16189d};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f11984c = new String[256];

    static {
        for (char c2 = 0; c2 < 255; c2 = (char) (c2 + 1)) {
            if ((c2 >= '0' && c2 <= '9') || ((c2 >= 'A' && c2 <= 'Z') || (c2 >= 'a' && c2 <= 'z'))) {
                f11984c[c2] = null;
            } else {
                f11984c[c2] = f(c2).intern();
            }
        }
    }

    private static Character a(l lVar) {
        lVar.f();
        Character h2 = lVar.h();
        if (h2 == null) {
            lVar.m();
            return null;
        } else if (h2.charValue() != '\\') {
            lVar.m();
            return null;
        } else {
            Character h3 = lVar.h();
            if (h3 == null) {
                lVar.m();
                return null;
            } else if (h3.charValue() == 'b') {
                return '\b';
            } else {
                if (h3.charValue() == 't') {
                    return '\t';
                }
                if (h3.charValue() == 'n') {
                    return '\n';
                }
                if (h3.charValue() == 'v') {
                    return (char) 11;
                }
                if (h3.charValue() == 'f') {
                    return '\f';
                }
                if (h3.charValue() == 'r') {
                    return '\r';
                }
                if (h3.charValue() == '\"') {
                    return Character.valueOf(y.a);
                }
                if (h3.charValue() == '\'') {
                    return '\'';
                }
                if (h3.charValue() == '\\') {
                    return '\\';
                }
                int i2 = 0;
                if (Character.toLowerCase(h3.charValue()) == 'x') {
                    StringBuilder sb = new StringBuilder();
                    while (i2 < 2) {
                        Character i3 = lVar.i();
                        if (i3 != null) {
                            sb.append(i3);
                            i2++;
                        } else {
                            lVar.m();
                            return null;
                        }
                    }
                    try {
                        int parseInt = Integer.parseInt(sb.toString(), 16);
                        if (Character.isValidCodePoint(parseInt)) {
                            return Character.valueOf((char) parseInt);
                        }
                    } catch (NumberFormatException unused) {
                        lVar.m();
                        return null;
                    }
                } else if (Character.toLowerCase(h3.charValue()) == 'u') {
                    StringBuilder sb2 = new StringBuilder();
                    while (i2 < 4) {
                        Character i4 = lVar.i();
                        if (i4 != null) {
                            sb2.append(i4);
                            i2++;
                        } else {
                            lVar.m();
                            return null;
                        }
                    }
                    try {
                        int parseInt2 = Integer.parseInt(sb2.toString(), 16);
                        if (Character.isValidCodePoint(parseInt2)) {
                            return Character.valueOf((char) parseInt2);
                        }
                    } catch (NumberFormatException unused2) {
                        lVar.m();
                        return null;
                    }
                } else if (l.g(h3)) {
                    StringBuilder sb3 = new StringBuilder();
                    sb3.append(h3);
                    Character h4 = lVar.h();
                    if (!l.g(h4)) {
                        lVar.a(h4);
                    } else {
                        sb3.append(h4);
                        Character h5 = lVar.h();
                        if (!l.g(h5)) {
                            lVar.a(h5);
                        } else {
                            sb3.append(h5);
                        }
                    }
                    try {
                        int parseInt3 = Integer.parseInt(sb3.toString(), 8);
                        if (Character.isValidCodePoint(parseInt3)) {
                            return Character.valueOf((char) parseInt3);
                        }
                    } catch (NumberFormatException unused3) {
                        lVar.m();
                        return null;
                    }
                }
                return h3;
            }
        }
    }

    private static String b(char c2) {
        if (c2 < 255) {
            return f11984c[c2];
        }
        return f(c2);
    }

    private static String c(char[] cArr, Character ch) {
        if (e(ch.charValue(), cArr)) {
            return "" + ch;
        } else if (b(ch.charValue()) == null) {
            return "" + ch;
        } else {
            String hexString = Integer.toHexString(ch.charValue());
            if (ch.charValue() < 256) {
                return "\\x" + "00".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
            }
            return "\\u" + "0000".substring(hexString.length()) + hexString.toUpperCase(Locale.ENGLISH);
        }
    }

    private static String d(char[] cArr, String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            sb.append(c(cArr, Character.valueOf(str.charAt(i2))));
        }
        return sb.toString();
    }

    private static boolean e(char c2, char[] cArr) {
        for (char c3 : cArr) {
            if (c2 == c3) {
                return true;
            }
        }
        return false;
    }

    private static String f(char c2) {
        return Integer.toHexString(c2);
    }

    public static String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuilder sb = new StringBuilder();
            l lVar = new l(str);
            while (lVar.b()) {
                Character a2 = a(lVar);
                if (a2 != null) {
                    sb.append(a2);
                } else {
                    sb.append(lVar.h());
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            String str2 = a;
            Log.e(str2, "decode js: " + e2.getMessage());
            return "";
        }
    }

    public static String h(String str) {
        return i(str, b);
    }

    public static String i(String str, char[] cArr) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return d(cArr, str);
        } catch (Exception e2) {
            String str2 = a;
            Log.e(str2, "encode js: " + e2.getMessage());
            return "";
        }
    }
}
