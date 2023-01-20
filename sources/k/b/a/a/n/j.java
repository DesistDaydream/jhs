package k.b.a.a.n;

import java.util.regex.Pattern;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class j implements k.b.a.a.i {
    private static final char[] b = {'A'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f16176c = {'A', 'F'};

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f16177d = {'C'};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f16178e = {'F', 'F'};

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f16179f = {'G'};

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f16180g = {'N'};

    /* renamed from: h  reason: collision with root package name */
    private static final char[] f16181h = {'N', 'N'};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f16182i = {'S'};

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f16183j = {'S', 'S', 'S'};

    /* renamed from: k  reason: collision with root package name */
    private static final Pattern f16184k = Pattern.compile("^MAC");

    /* renamed from: l  reason: collision with root package name */
    private static final Pattern f16185l = Pattern.compile("^KN");

    /* renamed from: m  reason: collision with root package name */
    private static final Pattern f16186m = Pattern.compile("^K");
    private static final Pattern n = Pattern.compile("^(PH|PF)");
    private static final Pattern o = Pattern.compile("^SCH");
    private static final Pattern p = Pattern.compile("(EE|IE)$");
    private static final Pattern q = Pattern.compile("(DT|RT|RD|NT|ND)$");
    private static final char r = ' ';
    private static final int s = 6;
    private final boolean a;

    public j() {
        this(true);
    }

    private static boolean b(char c2) {
        return c2 == 'A' || c2 == 'E' || c2 == 'I' || c2 == 'O' || c2 == 'U';
    }

    private static char[] d(char c2, char c3, char c4, char c5) {
        if (c3 == 'E' && c4 == 'V') {
            return f16176c;
        }
        if (b(c3)) {
            return b;
        }
        if (c3 == 'Q') {
            return f16179f;
        }
        if (c3 == 'Z') {
            return f16182i;
        }
        if (c3 == 'M') {
            return f16180g;
        }
        if (c3 == 'K') {
            if (c4 == 'N') {
                return f16181h;
            }
            return f16177d;
        } else if (c3 == 'S' && c4 == 'C' && c5 == 'H') {
            return f16183j;
        } else {
            if (c3 == 'P' && c4 == 'H') {
                return f16178e;
            }
            return (c3 != 'H' || (b(c2) && b(c4))) ? (c3 == 'W' && b(c2)) ? new char[]{c2} : new char[]{c3} : new char[]{c2};
        }
    }

    public boolean a() {
        return this.a;
    }

    public String c(String str) {
        if (str == null) {
            return null;
        }
        String a = m.a(str);
        if (a.length() == 0) {
            return a;
        }
        String replaceFirst = q.matcher(p.matcher(o.matcher(n.matcher(f16186m.matcher(f16185l.matcher(f16184k.matcher(a).replaceFirst("MCC")).replaceFirst("NN")).replaceFirst("C")).replaceFirst("FF")).replaceFirst("SSS")).replaceFirst("Y")).replaceFirst("D");
        StringBuilder sb = new StringBuilder(replaceFirst.length());
        sb.append(replaceFirst.charAt(0));
        char[] charArray = replaceFirst.toCharArray();
        int length = charArray.length;
        int i2 = 1;
        while (i2 < length) {
            int i3 = length - 1;
            char c2 = r;
            char c3 = i2 < i3 ? charArray[i2 + 1] : r;
            if (i2 < length - 2) {
                c2 = charArray[i2 + 2];
            }
            int i4 = i2 - 1;
            char[] d2 = d(charArray[i4], charArray[i2], c3, c2);
            System.arraycopy(d2, 0, charArray, i2, d2.length);
            if (charArray[i2] != charArray[i4]) {
                sb.append(charArray[i2]);
            }
            i2++;
        }
        if (sb.length() > 1) {
            char charAt = sb.charAt(sb.length() - 1);
            if (charAt == 'S') {
                sb.deleteCharAt(sb.length() - 1);
                charAt = sb.charAt(sb.length() - 1);
            }
            if (sb.length() > 2 && sb.charAt(sb.length() - 2) == 'A' && charAt == 'Y') {
                sb.deleteCharAt(sb.length() - 2);
            }
            if (charAt == 'A') {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        String sb2 = sb.toString();
        return a() ? sb2.substring(0, Math.min(6, sb2.length())) : sb2;
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new EncoderException("Parameter supplied to Nysiis encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return c(str);
    }

    public j(boolean z) {
        this.a = z;
    }
}
