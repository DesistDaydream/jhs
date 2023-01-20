package e.j.f.p.a;

import com.baidu.mobads.sdk.internal.bc;
import com.google.zxing.client.result.ParsedResultType;
import e.t.u.b0;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public final class g extends q {

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f11399m = Pattern.compile("P(?:(\\d+)W)?(?:(\\d+)D)?(?:T(?:(\\d+)H)?(?:(\\d+)M)?(?:(\\d+)S)?)?");
    private static final long[] n = {bc.f1469d, 86400000, com.heytap.mcssdk.constant.a.f3315e, com.heytap.mcssdk.constant.a.f3314d, 1000};
    private static final Pattern o = Pattern.compile("[0-9]{8}(T[0-9]{6}Z?)?");
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final long f11400c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f11401d;

    /* renamed from: e  reason: collision with root package name */
    private final long f11402e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f11403f;

    /* renamed from: g  reason: collision with root package name */
    private final String f11404g;

    /* renamed from: h  reason: collision with root package name */
    private final String f11405h;

    /* renamed from: i  reason: collision with root package name */
    private final String[] f11406i;

    /* renamed from: j  reason: collision with root package name */
    private final String f11407j;

    /* renamed from: k  reason: collision with root package name */
    private final double f11408k;

    /* renamed from: l  reason: collision with root package name */
    private final double f11409l;

    public g(String str, String str2, String str3, String str4, String str5, String str6, String[] strArr, String str7, double d2, double d3) {
        super(ParsedResultType.CALENDAR);
        this.b = str;
        try {
            long r = r(str2);
            this.f11400c = r;
            if (str3 == null) {
                long t = t(str4);
                this.f11402e = t < 0 ? -1L : r + t;
            } else {
                try {
                    this.f11402e = r(str3);
                } catch (ParseException e2) {
                    throw new IllegalArgumentException(e2.toString());
                }
            }
            boolean z = true;
            this.f11401d = str2.length() == 8;
            this.f11403f = (str3 == null || str3.length() != 8) ? false : false;
            this.f11404g = str5;
            this.f11405h = str6;
            this.f11406i = strArr;
            this.f11407j = str7;
            this.f11408k = d2;
            this.f11409l = d3;
        } catch (ParseException e3) {
            throw new IllegalArgumentException(e3.toString());
        }
    }

    private static String d(boolean z, long j2) {
        DateFormat dateTimeInstance;
        if (j2 < 0) {
            return null;
        }
        if (z) {
            dateTimeInstance = DateFormat.getDateInstance(2);
        } else {
            dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateTimeInstance.format(Long.valueOf(j2));
    }

    private static long r(String str) throws ParseException {
        if (o.matcher(str).matches()) {
            if (str.length() == 8) {
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(b0.a.t, Locale.ENGLISH);
                simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
                return simpleDateFormat.parse(str).getTime();
            } else if (str.length() == 16 && str.charAt(15) == 'Z') {
                long s = s(str.substring(0, 15));
                GregorianCalendar gregorianCalendar = new GregorianCalendar();
                long j2 = s + gregorianCalendar.get(15);
                gregorianCalendar.setTime(new Date(j2));
                return j2 + gregorianCalendar.get(16);
            } else {
                return s(str);
            }
        }
        throw new ParseException(str, 0);
    }

    private static long s(String str) throws ParseException {
        return new SimpleDateFormat("yyyyMMdd'T'HHmmss", Locale.ENGLISH).parse(str).getTime();
    }

    private static long t(CharSequence charSequence) {
        if (charSequence == null) {
            return -1L;
        }
        Matcher matcher = f11399m.matcher(charSequence);
        if (!matcher.matches()) {
            return -1L;
        }
        long j2 = 0;
        int i2 = 0;
        while (true) {
            long[] jArr = n;
            if (i2 >= jArr.length) {
                return j2;
            }
            int i3 = i2 + 1;
            String group = matcher.group(i3);
            if (group != null) {
                j2 += jArr[i2] * Integer.parseInt(group);
            }
            i2 = i3;
        }
    }

    @Override // e.j.f.p.a.q
    public String a() {
        StringBuilder sb = new StringBuilder(100);
        q.b(this.b, sb);
        q.b(d(this.f11401d, this.f11400c), sb);
        q.b(d(this.f11403f, this.f11402e), sb);
        q.b(this.f11404g, sb);
        q.b(this.f11405h, sb);
        q.c(this.f11406i, sb);
        q.b(this.f11407j, sb);
        return sb.toString();
    }

    public String[] e() {
        return this.f11406i;
    }

    public String f() {
        return this.f11407j;
    }

    @Deprecated
    public Date g() {
        if (this.f11402e < 0) {
            return null;
        }
        return new Date(this.f11402e);
    }

    public long h() {
        return this.f11402e;
    }

    public double i() {
        return this.f11408k;
    }

    public String j() {
        return this.f11404g;
    }

    public double k() {
        return this.f11409l;
    }

    public String l() {
        return this.f11405h;
    }

    @Deprecated
    public Date m() {
        return new Date(this.f11400c);
    }

    public long n() {
        return this.f11400c;
    }

    public String o() {
        return this.b;
    }

    public boolean p() {
        return this.f11403f;
    }

    public boolean q() {
        return this.f11401d;
    }
}
