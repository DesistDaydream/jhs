package k.b.a.a.n;

import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class l implements k.b.a.a.i {

    /* renamed from: d  reason: collision with root package name */
    public static final char f16189d = '-';

    /* renamed from: e  reason: collision with root package name */
    public static final String f16190e = "01230120022455012623010202";

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f16191f = f16190e.toCharArray();

    /* renamed from: g  reason: collision with root package name */
    public static final l f16192g = new l();

    /* renamed from: h  reason: collision with root package name */
    public static final l f16193h = new l(f16190e, false);

    /* renamed from: i  reason: collision with root package name */
    public static final l f16194i = new l("-123-12--22455-12623-1-2-2");
    @Deprecated
    private int a;
    private final char[] b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16195c;

    public l() {
        this.a = 4;
        this.b = f16191f;
        this.f16195c = true;
    }

    private boolean c(char[] cArr) {
        for (char c2 : cArr) {
            if (c2 == '-') {
                return true;
            }
        }
        return false;
    }

    private char d(char c2) {
        int i2 = c2 - 'A';
        if (i2 >= 0) {
            char[] cArr = this.b;
            if (i2 < cArr.length) {
                return cArr[i2];
            }
        }
        throw new IllegalArgumentException("The character is not mapped: " + c2 + " (index=" + i2 + ")");
    }

    public int a(String str, String str2) throws EncoderException {
        return m.b(this, str, str2);
    }

    @Deprecated
    public int b() {
        return this.a;
    }

    @Deprecated
    public void e(int i2) {
        this.a = i2;
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return g((String) obj);
        }
        throw new EncoderException("Parameter supplied to Soundex encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return g(str);
    }

    public String g(String str) {
        char d2;
        if (str == null) {
            return null;
        }
        String a = m.a(str);
        if (a.length() == 0) {
            return a;
        }
        char[] cArr = {'0', '0', '0', '0'};
        char charAt = a.charAt(0);
        cArr[0] = charAt;
        char d3 = d(charAt);
        int i2 = 1;
        for (int i3 = 1; i3 < a.length() && i2 < 4; i3++) {
            char charAt2 = a.charAt(i3);
            if ((!this.f16195c || (charAt2 != 'H' && charAt2 != 'W')) && (d2 = d(charAt2)) != '-') {
                if (d2 != '0' && d2 != d3) {
                    cArr[i2] = d2;
                    i2++;
                }
                d3 = d2;
            }
        }
        return new String(cArr);
    }

    public l(char[] cArr) {
        this.a = 4;
        char[] cArr2 = new char[cArr.length];
        this.b = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
        this.f16195c = !c(cArr2);
    }

    public l(String str) {
        this.a = 4;
        char[] charArray = str.toCharArray();
        this.b = charArray;
        this.f16195c = !c(charArray);
    }

    public l(String str, boolean z) {
        this.a = 4;
        this.b = str.toCharArray();
        this.f16195c = z;
    }
}
