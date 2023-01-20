package e.j.e.s.k.c;

import com.ss.android.download.api.constant.BaseConstants;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import k.b.a.a.n.l;

/* loaded from: classes2.dex */
public class a {
    private static final String a = "UTC";
    private static final TimeZone b = TimeZone.getTimeZone("UTC");

    private static boolean a(String str, int i2, char c2) {
        return i2 < str.length() && str.charAt(i2) == c2;
    }

    public static String b(Date date) {
        return d(date, false, b);
    }

    public static String c(Date date, boolean z) {
        return d(date, z, b);
    }

    public static String d(Date date, boolean z, TimeZone timeZone) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar(timeZone, Locale.US);
        gregorianCalendar.setTime(date);
        StringBuilder sb = new StringBuilder(19 + (z ? 4 : 0) + (timeZone.getRawOffset() == 0 ? 1 : 6));
        f(sb, gregorianCalendar.get(1), 4);
        char c2 = l.f16189d;
        sb.append(l.f16189d);
        f(sb, gregorianCalendar.get(2) + 1, 2);
        sb.append(l.f16189d);
        f(sb, gregorianCalendar.get(5), 2);
        sb.append('T');
        f(sb, gregorianCalendar.get(11), 2);
        sb.append(':');
        f(sb, gregorianCalendar.get(12), 2);
        sb.append(':');
        f(sb, gregorianCalendar.get(13), 2);
        if (z) {
            sb.append('.');
            f(sb, gregorianCalendar.get(14), 3);
        }
        int offset = timeZone.getOffset(gregorianCalendar.getTimeInMillis());
        if (offset != 0) {
            int i2 = offset / BaseConstants.Time.MINUTE;
            int abs = Math.abs(i2 / 60);
            int abs2 = Math.abs(i2 % 60);
            if (offset >= 0) {
                c2 = '+';
            }
            sb.append(c2);
            f(sb, abs, 2);
            sb.append(':');
            f(sb, abs2, 2);
        } else {
            sb.append('Z');
        }
        return sb.toString();
    }

    private static int e(String str, int i2) {
        while (i2 < str.length()) {
            char charAt = str.charAt(i2);
            if (charAt < '0' || charAt > '9') {
                return i2;
            }
            i2++;
        }
        return str.length();
    }

    private static void f(StringBuilder sb, int i2, int i3) {
        String num = Integer.toString(i2);
        for (int length = i3 - num.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(num);
    }

    /* JADX WARN: Removed duplicated region for block: B:49:0x00cf A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01b4 A[Catch: IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, NumberFormatException -> 0x01be, IndexOutOfBoundsException -> 0x01c0, TryCatch #2 {IllegalArgumentException | IndexOutOfBoundsException | NumberFormatException -> 0x01bc, blocks: (B:3:0x0004, B:5:0x0016, B:6:0x0018, B:8:0x0024, B:9:0x0026, B:11:0x0035, B:13:0x003b, B:17:0x0050, B:19:0x0060, B:20:0x0062, B:22:0x006e, B:23:0x0070, B:25:0x0076, B:29:0x0080, B:34:0x0090, B:36:0x0098, B:47:0x00c9, B:49:0x00cf, B:51:0x00d6, B:75:0x0183, B:55:0x00e0, B:56:0x00fb, B:57:0x00fc, B:61:0x0118, B:63:0x0125, B:66:0x012e, B:68:0x014d, B:71:0x015c, B:72:0x017e, B:74:0x0181, B:60:0x0107, B:77:0x01b4, B:78:0x01bb, B:40:0x00b0, B:41:0x00b3), top: B:94:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Date g(java.lang.String r17, java.text.ParsePosition r18) throws java.text.ParseException {
        /*
            Method dump skipped, instructions count: 553
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.s.k.c.a.g(java.lang.String, java.text.ParsePosition):java.util.Date");
    }

    private static int h(String str, int i2, int i3) throws NumberFormatException {
        int i4;
        int i5;
        if (i2 < 0 || i3 > str.length() || i2 > i3) {
            throw new NumberFormatException(str);
        }
        if (i2 < i3) {
            i4 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 10);
            if (digit < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = -digit;
        } else {
            i4 = i2;
            i5 = 0;
        }
        while (i4 < i3) {
            int i6 = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 10);
            if (digit2 < 0) {
                throw new NumberFormatException("Invalid number: " + str.substring(i2, i3));
            }
            i5 = (i5 * 10) - digit2;
            i4 = i6;
        }
        return -i5;
    }
}
