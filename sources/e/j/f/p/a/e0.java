package e.j.f.p.a;

import com.xiaomi.mipush.sdk.Constants;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class e0 extends t {

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f11391f = Pattern.compile("BEGIN:VCARD", 2);

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f11392g = Pattern.compile("\\d{4}-?\\d{2}-?\\d{2}");

    /* renamed from: h  reason: collision with root package name */
    private static final Pattern f11393h = Pattern.compile("\r\n[ \t]");

    /* renamed from: i  reason: collision with root package name */
    private static final Pattern f11394i = Pattern.compile("\\\\[nN]");

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f11395j = Pattern.compile("\\\\([,;\\\\])");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f11396k = Pattern.compile("=");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f11397l = Pattern.compile(";");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f11398m = Pattern.compile("(?<!\\\\);+");
    private static final Pattern n = Pattern.compile(Constants.ACCEPT_TIME_SEPARATOR_SP);
    private static final Pattern o = Pattern.compile("[;,]");

    private static String[] A(Collection<List<String>> collection) {
        String str;
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str2 = list.get(0);
            if (str2 != null && !str2.isEmpty()) {
                int i2 = 1;
                while (true) {
                    if (i2 >= list.size()) {
                        str = null;
                        break;
                    }
                    str = list.get(i2);
                    int indexOf = str.indexOf(61);
                    if (indexOf < 0) {
                        break;
                    } else if ("TYPE".equalsIgnoreCase(str.substring(0, indexOf))) {
                        str = str.substring(indexOf + 1);
                        break;
                    } else {
                        i2++;
                    }
                }
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    private static String q(CharSequence charSequence, String str) {
        char charAt;
        int length = charSequence.length();
        StringBuilder sb = new StringBuilder(length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (i2 < length) {
            char charAt2 = charSequence.charAt(i2);
            if (charAt2 != '\n' && charAt2 != '\r') {
                if (charAt2 != '=') {
                    w(byteArrayOutputStream, str, sb);
                    sb.append(charAt2);
                } else if (i2 < length - 2 && (charAt = charSequence.charAt(i2 + 1)) != '\r' && charAt != '\n') {
                    i2 += 2;
                    char charAt3 = charSequence.charAt(i2);
                    int l2 = t.l(charAt);
                    int l3 = t.l(charAt3);
                    if (l2 >= 0 && l3 >= 0) {
                        byteArrayOutputStream.write((l2 << 4) + l3);
                    }
                }
            }
            i2++;
        }
        w(byteArrayOutputStream, str, sb);
        return sb.toString();
    }

    private static void r(Iterable<List<String>> iterable) {
        int indexOf;
        if (iterable != null) {
            for (List<String> list : iterable) {
                String str = list.get(0);
                String[] strArr = new String[5];
                int i2 = 0;
                int i3 = 0;
                while (i2 < 4 && (indexOf = str.indexOf(59, i3)) >= 0) {
                    strArr[i2] = str.substring(i3, indexOf);
                    i2++;
                    i3 = indexOf + 1;
                }
                strArr[i2] = str.substring(i3);
                StringBuilder sb = new StringBuilder(100);
                v(strArr, 3, sb);
                v(strArr, 1, sb);
                v(strArr, 2, sb);
                v(strArr, 0, sb);
                v(strArr, 4, sb);
                list.set(0, sb.toString().trim());
            }
        }
    }

    private static boolean s(CharSequence charSequence) {
        return charSequence == null || f11392g.matcher(charSequence).matches();
    }

    public static List<String> t(CharSequence charSequence, String str, boolean z, boolean z2) {
        List<List<String>> u = u(charSequence, str, z, z2);
        if (u == null || u.isEmpty()) {
            return null;
        }
        return u.get(0);
    }

    public static List<List<String>> u(CharSequence charSequence, String str, boolean z, boolean z2) {
        ArrayList arrayList;
        boolean z3;
        String str2;
        String str3;
        int indexOf;
        String replaceAll;
        int length = str.length();
        int i2 = 0;
        int i3 = 0;
        ArrayList arrayList2 = null;
        while (i3 < length) {
            int i4 = 2;
            Matcher matcher = Pattern.compile("(?:^|\n)" + ((Object) charSequence) + "(?:;([^:]*))?:", 2).matcher(str);
            if (i3 > 0) {
                i3--;
            }
            if (!matcher.find(i3)) {
                break;
            }
            int end = matcher.end(i2);
            String group = matcher.group(1);
            if (group != null) {
                String[] split = f11397l.split(group);
                int length2 = split.length;
                int i5 = 0;
                arrayList = null;
                z3 = false;
                str2 = null;
                str3 = null;
                while (i5 < length2) {
                    String str4 = split[i5];
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(str4);
                    String[] split2 = f11396k.split(str4, i4);
                    if (split2.length > 1) {
                        String str5 = split2[0];
                        String str6 = split2[1];
                        if ("ENCODING".equalsIgnoreCase(str5) && "QUOTED-PRINTABLE".equalsIgnoreCase(str6)) {
                            z3 = true;
                        } else if ("CHARSET".equalsIgnoreCase(str5)) {
                            str2 = str6;
                        } else if ("VALUE".equalsIgnoreCase(str5)) {
                            str3 = str6;
                        }
                    }
                    i5++;
                    i4 = 2;
                }
            } else {
                arrayList = null;
                z3 = false;
                str2 = null;
                str3 = null;
            }
            int i6 = end;
            while (true) {
                indexOf = str.indexOf(10, i6);
                if (indexOf < 0) {
                    break;
                }
                if (indexOf < str.length() - 1) {
                    int i7 = indexOf + 1;
                    if (str.charAt(i7) == ' ' || str.charAt(i7) == '\t') {
                        i6 = indexOf + 2;
                    }
                }
                if (!z3) {
                    break;
                }
                if (indexOf > 0) {
                    if (str.charAt(indexOf - 1) == '=') {
                        i6 = indexOf + 1;
                    }
                }
                if (indexOf < 2) {
                    break;
                }
                if (str.charAt(indexOf - 2) != '=') {
                    break;
                }
                i6 = indexOf + 1;
            }
            if (indexOf < 0) {
                i3 = length;
            } else {
                if (indexOf > end) {
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList(1);
                    }
                    if (indexOf > 0 && str.charAt(indexOf - 1) == '\r') {
                        indexOf--;
                    }
                    String substring = str.substring(end, indexOf);
                    if (z) {
                        substring = substring.trim();
                    }
                    if (z3) {
                        replaceAll = q(substring, str2);
                        if (z2) {
                            replaceAll = f11398m.matcher(replaceAll).replaceAll("\n").trim();
                        }
                    } else {
                        if (z2) {
                            substring = f11398m.matcher(substring).replaceAll("\n").trim();
                        }
                        replaceAll = f11395j.matcher(f11394i.matcher(f11393h.matcher(substring).replaceAll("")).replaceAll("\n")).replaceAll("$1");
                    }
                    if ("uri".equals(str3)) {
                        try {
                            replaceAll = URI.create(replaceAll).getSchemeSpecificPart();
                        } catch (IllegalArgumentException unused) {
                        }
                    }
                    if (arrayList == null) {
                        ArrayList arrayList3 = new ArrayList(1);
                        arrayList3.add(replaceAll);
                        arrayList2.add(arrayList3);
                    } else {
                        arrayList.add(0, replaceAll);
                        arrayList2.add(arrayList);
                        i3 = indexOf + 1;
                    }
                }
                i3 = indexOf + 1;
            }
            i2 = 0;
        }
        return arrayList2;
    }

    private static void v(String[] strArr, int i2, StringBuilder sb) {
        if (strArr[i2] == null || strArr[i2].isEmpty()) {
            return;
        }
        if (sb.length() > 0) {
            sb.append(' ');
        }
        sb.append(strArr[i2]);
    }

    private static void w(ByteArrayOutputStream byteArrayOutputStream, String str, StringBuilder sb) {
        String str2;
        if (byteArrayOutputStream.size() > 0) {
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (str == null) {
                str2 = new String(byteArray, StandardCharsets.UTF_8);
            } else {
                try {
                    str2 = new String(byteArray, str);
                } catch (UnsupportedEncodingException unused) {
                    str2 = new String(byteArray, StandardCharsets.UTF_8);
                }
            }
            byteArrayOutputStream.reset();
            sb.append(str2);
        }
    }

    private static String y(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    private static String[] z(Collection<List<String>> collection) {
        if (collection == null || collection.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList(collection.size());
        for (List<String> list : collection) {
            String str = list.get(0);
            if (str != null && !str.isEmpty()) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // e.j.f.p.a.t
    /* renamed from: x */
    public d k(e.j.f.k kVar) {
        String c2 = t.c(kVar);
        Matcher matcher = f11391f.matcher(c2);
        if (matcher.find() && matcher.start() == 0) {
            List<List<String>> u = u("FN", c2, true, false);
            if (u == null) {
                u = u("N", c2, true, false);
                r(u);
            }
            List<String> t = t("NICKNAME", c2, true, false);
            String[] split = t == null ? null : n.split(t.get(0));
            List<List<String>> u2 = u("TEL", c2, true, false);
            List<List<String>> u3 = u("EMAIL", c2, true, false);
            List<String> t2 = t("NOTE", c2, false, false);
            List<List<String>> u4 = u("ADR", c2, true, true);
            List<String> t3 = t("ORG", c2, true, true);
            List<String> t4 = t("BDAY", c2, true, false);
            List<String> list = (t4 == null || s(t4.get(0))) ? t4 : null;
            List<String> t5 = t("TITLE", c2, true, false);
            List<List<String>> u5 = u("URL", c2, true, false);
            List<String> t6 = t("IMPP", c2, true, false);
            List<String> t7 = t("GEO", c2, true, false);
            String[] split2 = t7 == null ? null : o.split(t7.get(0));
            return new d(z(u), split, null, z(u2), A(u2), z(u3), A(u3), y(t6), y(t2), z(u4), A(u4), y(t3), y(list), y(t5), z(u5), (split2 == null || split2.length == 2) ? split2 : null);
        }
        return null;
    }
}
