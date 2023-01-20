package k.b.a.a.n;

import com.moor.imkf.lib.jsoup.nodes.Attributes;
import java.util.Locale;
import org.apache.commons.codec.EncoderException;

/* loaded from: classes4.dex */
public class e implements k.b.a.a.i {
    private static final char[] a = {'A', 'E', 'I', 'J', 'O', 'U', 'Y'};
    private static final char[] b = {'C', 'S', 'Z'};

    /* renamed from: c  reason: collision with root package name */
    private static final char[] f16135c = {'F', 'P', 'V', 'W'};

    /* renamed from: d  reason: collision with root package name */
    private static final char[] f16136d = {'G', 'K', 'Q'};

    /* renamed from: e  reason: collision with root package name */
    private static final char[] f16137e = {'C', 'K', 'Q'};

    /* renamed from: f  reason: collision with root package name */
    private static final char[] f16138f = {'A', 'H', 'K', 'L', 'O', 'Q', 'R', 'U', 'X'};

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f16139g = {'S', 'Z'};

    /* renamed from: h  reason: collision with root package name */
    private static final char[] f16140h = {'A', 'H', 'K', 'O', 'Q', 'U', 'X'};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f16141i = {'D', 'T', 'X'};

    /* renamed from: j  reason: collision with root package name */
    private static final char f16142j = '-';

    /* loaded from: classes4.dex */
    public class b extends a {
        public b(char[] cArr) {
            super(cArr);
        }

        @Override // k.b.a.a.n.e.a
        public char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            char[] cArr2 = this.a;
            System.arraycopy(cArr2, (cArr2.length - this.b) + i2, cArr, 0, i3);
            return cArr;
        }

        public char c() {
            return this.a[d()];
        }

        public int d() {
            return this.a.length - this.b;
        }

        public char e() {
            this.b--;
            return c();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {

        /* renamed from: d  reason: collision with root package name */
        private char f16145d;

        public c(int i2) {
            super(i2);
            this.f16145d = Attributes.InternalPrefix;
        }

        @Override // k.b.a.a.n.e.a
        public char[] a(int i2, int i3) {
            char[] cArr = new char[i3];
            System.arraycopy(this.a, i2, cArr, 0, i3);
            return cArr;
        }

        public void c(char c2) {
            if (c2 != '-' && this.f16145d != c2 && (c2 != '0' || this.b == 0)) {
                char[] cArr = this.a;
                int i2 = this.b;
                cArr[i2] = c2;
                this.b = i2 + 1;
            }
            this.f16145d = c2;
        }
    }

    private static boolean a(char[] cArr, char c2) {
        for (char c3 : cArr) {
            if (c3 == c2) {
                return true;
            }
        }
        return false;
    }

    private char[] d(String str) {
        char[] charArray = str.toUpperCase(Locale.GERMAN).toCharArray();
        for (int i2 = 0; i2 < charArray.length; i2++) {
            char c2 = charArray[i2];
            if (c2 == 196) {
                charArray[i2] = 'A';
            } else if (c2 == 214) {
                charArray[i2] = 'O';
            } else if (c2 == 220) {
                charArray[i2] = 'U';
            }
        }
        return charArray;
    }

    public String b(String str) {
        if (str == null) {
            return null;
        }
        b bVar = new b(d(str));
        c cVar = new c(bVar.b() * 2);
        char c2 = '-';
        while (bVar.b() > 0) {
            char e2 = bVar.e();
            char c3 = bVar.b() > 0 ? bVar.c() : '-';
            if (e2 >= 'A' && e2 <= 'Z') {
                if (a(a, e2)) {
                    cVar.c('0');
                } else if (e2 != 'B' && (e2 != 'P' || c3 == 'H')) {
                    if ((e2 == 'D' || e2 == 'T') && !a(b, c3)) {
                        cVar.c('2');
                    } else if (a(f16135c, e2)) {
                        cVar.c('3');
                    } else if (a(f16136d, e2)) {
                        cVar.c('4');
                    } else if (e2 == 'X' && !a(f16137e, c2)) {
                        cVar.c('4');
                        cVar.c('8');
                    } else if (e2 == 'S' || e2 == 'Z') {
                        cVar.c('8');
                    } else if (e2 == 'C') {
                        if (cVar.b() == 0) {
                            if (a(f16138f, c3)) {
                                cVar.c('4');
                            } else {
                                cVar.c('8');
                            }
                        } else if (!a(f16139g, c2) && a(f16140h, c3)) {
                            cVar.c('4');
                        } else {
                            cVar.c('8');
                        }
                    } else if (a(f16141i, e2)) {
                        cVar.c('8');
                    } else if (e2 == 'R') {
                        cVar.c('7');
                    } else if (e2 == 'L') {
                        cVar.c('5');
                    } else if (e2 == 'M' || e2 == 'N') {
                        cVar.c('6');
                    } else if (e2 == 'H') {
                        cVar.c('-');
                    }
                } else {
                    cVar.c('1');
                }
                c2 = e2;
            }
        }
        return cVar.toString();
    }

    public boolean c(String str, String str2) {
        return b(str).equals(b(str2));
    }

    @Override // k.b.a.a.f
    public Object encode(Object obj) throws EncoderException {
        if (obj instanceof String) {
            return f((String) obj);
        }
        throw new EncoderException("This method's parameter was expected to be of the type " + String.class.getName() + ". But actually it was of the type " + obj.getClass().getName() + ".");
    }

    @Override // k.b.a.a.i
    public String f(String str) {
        return b(str);
    }

    /* loaded from: classes4.dex */
    public abstract class a {
        public final char[] a;
        public int b;

        public a(char[] cArr) {
            this.b = 0;
            this.a = cArr;
            this.b = cArr.length;
        }

        public abstract char[] a(int i2, int i3);

        public int b() {
            return this.b;
        }

        public String toString() {
            return new String(a(0, this.b));
        }

        public a(int i2) {
            this.b = 0;
            this.a = new char[i2];
            this.b = 0;
        }
    }
}
