package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122;

import com.m7.imkfsdk.view.pickerview.utils.LunarCalendar;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f603j = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f604k = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f605l = Pattern.compile("(\\d{1,2})[^\\d]*");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f606m = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");
    private final String a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f607c;

    /* renamed from: d  reason: collision with root package name */
    private final String f608d;

    /* renamed from: e  reason: collision with root package name */
    private final String f609e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f610f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f611g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f612h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f613i;

    private l(String str, String str2, long j2, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4) {
        this.a = str;
        this.b = str2;
        this.f607c = j2;
        this.f608d = str3;
        this.f609e = str4;
        this.f610f = z;
        this.f611g = z2;
        this.f613i = z3;
        this.f612h = z4;
    }

    private static int a(String str, int i2, int i3, boolean z) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (((charAt < ' ' && charAt != '\t') || charAt >= 127 || (charAt >= '0' && charAt <= '9') || ((charAt >= 'a' && charAt <= 'z') || ((charAt >= 'A' && charAt <= 'Z') || charAt == ':'))) == (!z)) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    private static long a(String str, int i2, int i3) {
        int a = a(str, i2, i3, false);
        Matcher matcher = f606m.matcher(str);
        int i4 = -1;
        int i5 = -1;
        int i6 = -1;
        int i7 = -1;
        int i8 = -1;
        int i9 = -1;
        while (a < i3) {
            int a2 = a(str, a + 1, i3, true);
            matcher.region(a, a2);
            if (i5 == -1 && matcher.usePattern(f606m).matches()) {
                i5 = Integer.parseInt(matcher.group(1));
                i9 = Integer.parseInt(matcher.group(2));
                i8 = Integer.parseInt(matcher.group(3));
            } else if (i6 == -1 && matcher.usePattern(f605l).matches()) {
                i6 = Integer.parseInt(matcher.group(1));
            } else {
                if (i7 == -1) {
                    Pattern pattern = f604k;
                    if (matcher.usePattern(pattern).matches()) {
                        i7 = pattern.pattern().indexOf(matcher.group(1).toLowerCase(Locale.US)) / 4;
                    }
                }
                if (i4 == -1 && matcher.usePattern(f603j).matches()) {
                    i4 = Integer.parseInt(matcher.group(1));
                }
            }
            a = a(str, a2 + 1, i3, false);
        }
        if (i4 >= 70 && i4 <= 99) {
            i4 += LunarCalendar.MIN_YEAR;
        }
        if (i4 >= 0 && i4 <= 69) {
            i4 += 2000;
        }
        if (i4 >= 1601) {
            if (i7 != -1) {
                if (i6 < 1 || i6 > 31) {
                    throw new IllegalArgumentException();
                }
                if (i5 < 0 || i5 > 23) {
                    throw new IllegalArgumentException();
                }
                if (i9 < 0 || i9 > 59) {
                    throw new IllegalArgumentException();
                }
                if (i8 < 0 || i8 > 59) {
                    throw new IllegalArgumentException();
                }
                GregorianCalendar gregorianCalendar = new GregorianCalendar(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.n);
                gregorianCalendar.setLenient(false);
                gregorianCalendar.set(1, i4);
                gregorianCalendar.set(2, i7 - 1);
                gregorianCalendar.set(5, i6);
                gregorianCalendar.set(11, i5);
                gregorianCalendar.set(12, i9);
                gregorianCalendar.set(13, i8);
                gregorianCalendar.set(14, 0);
                return gregorianCalendar.getTimeInMillis();
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0127  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l a(long r23, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s r25, java.lang.String r26) {
        /*
            Method dump skipped, instructions count: 308
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l.a(long, bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s, java.lang.String):bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.l");
    }

    public static l a(s sVar, String str) {
        return a(System.currentTimeMillis(), sVar, str);
    }

    private static String a(String str) {
        if (str.endsWith(".")) {
            throw new IllegalArgumentException();
        }
        if (str.startsWith(".")) {
            str = str.substring(1);
        }
        String a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(str);
        if (a != null) {
            return a;
        }
        throw new IllegalArgumentException();
    }

    public static List<l> a(s sVar, r rVar) {
        List<String> b = rVar.b("Set-Cookie");
        int size = b.size();
        ArrayList arrayList = null;
        for (int i2 = 0; i2 < size; i2++) {
            l a = a(sVar, b.get(i2));
            if (a != null) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(a);
            }
        }
        return arrayList != null ? Collections.unmodifiableList(arrayList) : Collections.emptyList();
    }

    private static boolean a(String str, String str2) {
        if (str.equals(str2)) {
            return true;
        }
        return str.endsWith(str2) && str.charAt((str.length() - str2.length()) - 1) == '.' && !bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.d(str);
    }

    private static long b(String str) {
        long parseLong;
        try {
            parseLong = Long.parseLong(str);
        } catch (NumberFormatException e2) {
            if (!str.matches("-?\\d+")) {
                throw e2;
            }
            if (!str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
                return Long.MAX_VALUE;
            }
        }
        if (parseLong <= 0) {
            return Long.MIN_VALUE;
        }
        return parseLong;
    }

    public String a() {
        return this.a;
    }

    public String a(boolean z) {
        String a;
        StringBuilder sb = new StringBuilder();
        sb.append(this.a);
        sb.append('=');
        sb.append(this.b);
        if (this.f612h) {
            if (this.f607c == Long.MIN_VALUE) {
                a = "; max-age=0";
            } else {
                sb.append("; expires=");
                a = bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_for12.d.a(new Date(this.f607c));
            }
            sb.append(a);
        }
        if (!this.f613i) {
            sb.append("; domain=");
            if (z) {
                sb.append(".");
            }
            sb.append(this.f608d);
        }
        sb.append("; path=");
        sb.append(this.f609e);
        if (this.f610f) {
            sb.append("; secure");
        }
        if (this.f611g) {
            sb.append("; httponly");
        }
        return sb.toString();
    }

    public String b() {
        return this.b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof l) {
            l lVar = (l) obj;
            if (lVar.a.equals(this.a) && lVar.b.equals(this.b) && lVar.f608d.equals(this.f608d) && lVar.f609e.equals(this.f609e) && lVar.f607c == this.f607c && lVar.f610f == this.f610f && lVar.f611g == this.f611g && lVar.f612h == this.f612h && lVar.f613i == this.f613i) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.a.hashCode();
        int hashCode2 = this.b.hashCode();
        int hashCode3 = this.f608d.hashCode();
        int hashCode4 = this.f609e.hashCode();
        long j2 = this.f607c;
        return ((((((((((((((((hashCode + 527) * 31) + hashCode2) * 31) + hashCode3) * 31) + hashCode4) * 31) + ((int) ((j2 >>> 32) ^ j2))) * 31) + (!this.f610f ? 1 : 0)) * 31) + (!this.f611g ? 1 : 0)) * 31) + (!this.f612h ? 1 : 0)) * 31) + (!this.f613i ? 1 : 0);
    }

    public String toString() {
        return a(false);
    }
}
