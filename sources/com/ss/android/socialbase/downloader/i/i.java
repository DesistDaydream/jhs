package com.ss.android.socialbase.downloader.i;

import h.t2.y;

/* loaded from: classes3.dex */
public class i {
    public static StringBuilder a(StringBuilder sb, String str) {
        sb.append(y.a);
        sb.append(str);
        sb.append(y.a);
        return sb;
    }

    public static StringBuilder b(StringBuilder sb, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            a(sb, strArr[i2]).append(k.b.a.a.o.e.f16243c);
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String str2) {
        sb.append(str);
        sb.append(".\"");
        sb.append(str2);
        sb.append(y.a);
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            sb.append(y.a);
            sb.append(strArr[i2]);
            sb.append(y.a);
            if (i2 < length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String b(String str, String[] strArr, String[] strArr2) {
        StringBuilder sb = new StringBuilder("INSERT OR REPLACE INTO ");
        sb.append(y.a + str + y.a);
        sb.append(" (");
        a(sb, strArr);
        sb.append(") VALUES (");
        a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static StringBuilder a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            if (i3 < i2 - 1) {
                sb.append("?,");
            } else {
                sb.append(k.b.a.a.o.e.a);
            }
        }
        return sb;
    }

    public static StringBuilder a(StringBuilder sb, String str, String[] strArr) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            a(sb, str, strArr[i2]).append(k.b.a.a.o.e.f16243c);
            if (i2 < strArr.length - 1) {
                sb.append(',');
            }
        }
        return sb;
    }

    public static String a(String str, String str2, String[] strArr) {
        StringBuilder sb = new StringBuilder(str);
        sb.append(y.a);
        sb.append(str2);
        sb.append(y.a);
        sb.append(" (");
        a(sb, strArr);
        sb.append(") VALUES (");
        a(sb, strArr.length);
        sb.append(')');
        return sb.toString();
    }

    public static String a(String str, String[] strArr) {
        String str2 = y.a + str + y.a;
        StringBuilder sb = new StringBuilder("DELETE FROM ");
        sb.append(str2);
        if (strArr != null && strArr.length > 0) {
            sb.append(" WHERE ");
            a(sb, str2, strArr);
        }
        return sb.toString();
    }

    public static String a(String str, String[] strArr, String[] strArr2) {
        String str2 = y.a + str + y.a;
        StringBuilder sb = new StringBuilder("UPDATE ");
        sb.append(str2);
        sb.append(" SET ");
        b(sb, strArr);
        if (strArr2 != null && strArr2.length > 0) {
            sb.append(" WHERE ");
            a(sb, str2, strArr2);
        }
        return sb.toString();
    }
}
