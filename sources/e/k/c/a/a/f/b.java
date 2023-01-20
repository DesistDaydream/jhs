package e.k.c.a.a.f;

/* loaded from: classes2.dex */
public class b {
    public static int a(String str, char c2, int i2) {
        int length = str.length() - 1;
        while (length >= 0 && (str.charAt(length) != c2 || i2 - 1 > 0)) {
            length--;
        }
        return length;
    }

    public static String b(String str, char c2) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        int length = str.length();
        char[] cArr = new char[length];
        for (int i2 = 0; i2 < length; i2++) {
            cArr[i2] = c2;
        }
        return new String(cArr);
    }

    public static String c(String str, String str2, String str3) {
        if (str == null || str.length() <= 0 || str2.length() <= 0 || str3.length() <= 0) {
            return str;
        }
        char[] charArray = str.toCharArray();
        char[] cArr = new char[str.length()];
        char charAt = str3.charAt(str3.length() - 1);
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            int lastIndexOf = str2.lastIndexOf(c2);
            if (lastIndexOf < 0) {
                cArr[i2] = c2;
            } else {
                cArr[i2] = lastIndexOf >= str3.length() ? charAt : str3.charAt(lastIndexOf);
            }
        }
        return new String(cArr);
    }

    public static String d(String str, String... strArr) {
        if (strArr == null || strArr.length <= 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder(strArr[0]);
        for (int i2 = 1; i2 < strArr.length; i2++) {
            if (strArr[i2] != null) {
                sb.append(str);
                sb.append(strArr[i2]);
            }
        }
        return sb.toString();
    }

    public static String e(String[] strArr, int i2) {
        return (strArr == null || strArr.length <= 0 || i2 < 0 || i2 >= strArr.length) ? "" : strArr[i2];
    }

    public static String[] f(String str, int i2) {
        if (str == null) {
            return new String[]{"", ""};
        }
        return (i2 < 0 || i2 > str.length()) ? new String[]{str, ""} : new String[]{str.substring(0, i2), str.substring(i2)};
    }

    public static String[] g(String str, int i2, int i3) {
        String[] f2 = f(str, i2);
        return m(e(f2, 0), f(e(f2, 1), i3 - i2));
    }

    public static String[] h(String str, int i2, int i3, int i4) {
        String[] f2 = f(str, i2);
        return m(e(f2, 0), g(e(f2, 1), i3 - i2, i4 - i2));
    }

    public static String[] i(String str, int... iArr) {
        if (str == null) {
            return new String[]{""};
        }
        if (str.length() <= 1 || iArr.length <= 0) {
            return new String[]{str};
        }
        if (iArr.length <= 1) {
            return f(str, iArr[0]);
        }
        int i2 = iArr[0];
        int length = iArr.length - 1;
        int[] iArr2 = new int[length];
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            iArr2[i3] = iArr[i4] - i2;
            i3 = i4;
        }
        String[] f2 = f(str, i2);
        return m(e(f2, 0), i(e(f2, 1), iArr2));
    }

    public static String[] j(String[] strArr, String str) {
        return k(strArr, new String[]{str});
    }

    public static String[] k(String[] strArr, String[] strArr2) {
        if (strArr.length <= 0) {
            return strArr2.length <= 0 ? new String[0] : strArr2;
        } else if (strArr2.length <= 0) {
            return strArr;
        } else {
            String[] strArr3 = new String[strArr.length + strArr2.length];
            System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
            System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
            return strArr3;
        }
    }

    public static String[] l(String str, char c2) {
        if (str == null) {
            return new String[0];
        }
        if (str.length() <= 0) {
            return new String[]{str};
        }
        int i2 = 1;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (str.charAt(i3) == c2) {
                i2++;
            }
        }
        if (i2 <= 1) {
            return new String[]{str};
        }
        String[] strArr = new String[i2];
        StringBuilder sb = new StringBuilder(str.length());
        int i4 = 0;
        for (int i5 = 0; i5 < str.length() && i4 < i2; i5++) {
            char charAt = str.charAt(i5);
            if (charAt == c2) {
                strArr[i4] = sb.toString();
                sb.setLength(0);
                i4++;
            } else {
                sb.append(charAt);
            }
        }
        strArr[i4] = sb.toString();
        return strArr;
    }

    public static String[] m(String str, String[] strArr) {
        return k(new String[]{str}, strArr);
    }
}
