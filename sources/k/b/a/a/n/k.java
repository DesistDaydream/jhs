package k.b.a.a.n;

import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class k implements k.b.a.a.i {
    public static final String b = "01360240043788015936020505";

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f16187c = b.toCharArray();

    /* renamed from: d  reason: collision with root package name */
    public static final k f16188d = new k();
    private final char[] a;

    public k() {
        this.a = f16187c;
    }

    public int a(String str, String str2) throws EncoderException {
        return m.b(this, str, str2);
    }

    public char b(char c2) {
        if (Character.isLetter(c2)) {
            return this.a[Character.toUpperCase(c2) - 'A'];
        }
        return (char) 0;
    }

    public String c(String str) {
        if (str == null) {
            return null;
        }
        String a = m.a(str);
        if (a.length() == 0) {
            return a;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(a.charAt(0));
        char c2 = '*';
        for (int i2 = 0; i2 < a.length(); i2++) {
            char b2 = b(a.charAt(i2));
            if (b2 != c2) {
                if (b2 != 0) {
                    sb.append(b2);
                }
                c2 = b2;
            }
        }
        return sb.toString();
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new EncoderException("Parameter supplied to RefinedSoundex encode is not of type java.lang.String");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return c(str);
    }

    public k(char[] cArr) {
        char[] cArr2 = new char[cArr.length];
        this.a = cArr2;
        System.arraycopy(cArr, 0, cArr2, 0, cArr.length);
    }

    public k(String str) {
        this.a = str.toCharArray();
    }
}
