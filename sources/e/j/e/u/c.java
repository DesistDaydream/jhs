package e.j.e.u;

import com.tencent.bugly.Bugly;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;

/* loaded from: classes2.dex */
public class c implements Closeable, Flushable {

    /* renamed from: j  reason: collision with root package name */
    private static final Pattern f11319j = Pattern.compile("-?(?:0|[1-9][0-9]*)(?:\\.[0-9]+)?(?:[eE][-+]?[0-9]+)?");

    /* renamed from: k  reason: collision with root package name */
    private static final String[] f11320k = new String[128];

    /* renamed from: l  reason: collision with root package name */
    private static final String[] f11321l;
    private final Writer a;
    private int[] b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    private int f11322c = 0;

    /* renamed from: d  reason: collision with root package name */
    private String f11323d;

    /* renamed from: e  reason: collision with root package name */
    private String f11324e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f11325f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f11326g;

    /* renamed from: h  reason: collision with root package name */
    private String f11327h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11328i;

    static {
        for (int i2 = 0; i2 <= 31; i2++) {
            f11320k[i2] = String.format("\\u%04x", Integer.valueOf(i2));
        }
        String[] strArr = f11320k;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f11321l = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public c(Writer writer) {
        m0(6);
        this.f11324e = Constants.COLON_SEPARATOR;
        this.f11328i = true;
        Objects.requireNonNull(writer, "out == null");
        this.a = writer;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void B0(java.lang.String r9) throws java.io.IOException {
        /*
            r8 = this;
            boolean r0 = r8.f11326g
            if (r0 == 0) goto L7
            java.lang.String[] r0 = e.j.e.u.c.f11321l
            goto L9
        L7:
            java.lang.String[] r0 = e.j.e.u.c.f11320k
        L9:
            java.io.Writer r1 = r8.a
            r2 = 34
            r1.write(r2)
            int r1 = r9.length()
            r3 = 0
            r4 = 0
        L16:
            if (r3 >= r1) goto L45
            char r5 = r9.charAt(r3)
            r6 = 128(0x80, float:1.794E-43)
            if (r5 >= r6) goto L25
            r5 = r0[r5]
            if (r5 != 0) goto L32
            goto L42
        L25:
            r6 = 8232(0x2028, float:1.1535E-41)
            if (r5 != r6) goto L2c
            java.lang.String r5 = "\\u2028"
            goto L32
        L2c:
            r6 = 8233(0x2029, float:1.1537E-41)
            if (r5 != r6) goto L42
            java.lang.String r5 = "\\u2029"
        L32:
            if (r4 >= r3) goto L3b
            java.io.Writer r6 = r8.a
            int r7 = r3 - r4
            r6.write(r9, r4, r7)
        L3b:
            java.io.Writer r4 = r8.a
            r4.write(r5)
            int r4 = r3 + 1
        L42:
            int r3 = r3 + 1
            goto L16
        L45:
            if (r4 >= r1) goto L4d
            java.io.Writer r0 = r8.a
            int r1 = r1 - r4
            r0.write(r9, r4, r1)
        L4d:
            java.io.Writer r9 = r8.a
            r9.write(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.u.c.B0(java.lang.String):void");
    }

    private static boolean H(Class<? extends Number> cls) {
        return cls == Integer.class || cls == Long.class || cls == Double.class || cls == Float.class || cls == Byte.class || cls == Short.class || cls == BigDecimal.class || cls == BigInteger.class || cls == AtomicInteger.class || cls == AtomicLong.class;
    }

    private void I0() throws IOException {
        if (this.f11327h != null) {
            j();
            B0(this.f11327h);
            this.f11327h = null;
        }
    }

    private void X() throws IOException {
        if (this.f11323d == null) {
            return;
        }
        this.a.write(10);
        int i2 = this.f11322c;
        for (int i3 = 1; i3 < i2; i3++) {
            this.a.write(this.f11323d);
        }
    }

    private c c0(int i2, char c2) throws IOException {
        k();
        m0(i2);
        this.a.write(c2);
        return this;
    }

    private int f0() {
        int i2 = this.f11322c;
        if (i2 != 0) {
            return this.b[i2 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void j() throws IOException {
        int f0 = f0();
        if (f0 == 5) {
            this.a.write(44);
        } else if (f0 != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        X();
        o0(4);
    }

    private void k() throws IOException {
        int f0 = f0();
        if (f0 == 1) {
            o0(2);
            X();
        } else if (f0 == 2) {
            this.a.append(',');
            X();
        } else if (f0 != 4) {
            if (f0 != 6) {
                if (f0 == 7) {
                    if (!this.f11325f) {
                        throw new IllegalStateException("JSON must have only one top-level value.");
                    }
                } else {
                    throw new IllegalStateException("Nesting problem.");
                }
            }
            o0(7);
        } else {
            this.a.append((CharSequence) this.f11324e);
            o0(5);
        }
    }

    private void m0(int i2) {
        int i3 = this.f11322c;
        int[] iArr = this.b;
        if (i3 == iArr.length) {
            this.b = Arrays.copyOf(iArr, i3 * 2);
        }
        int[] iArr2 = this.b;
        int i4 = this.f11322c;
        this.f11322c = i4 + 1;
        iArr2[i4] = i2;
    }

    private c o(int i2, int i3, char c2) throws IOException {
        int f0 = f0();
        if (f0 != i3 && f0 != i2) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f11327h == null) {
            this.f11322c--;
            if (f0 == i3) {
                X();
            }
            this.a.write(c2);
            return this;
        }
        throw new IllegalStateException("Dangling name: " + this.f11327h);
    }

    private void o0(int i2) {
        this.b[this.f11322c - 1] = i2;
    }

    public final void A0(boolean z) {
        this.f11328i = z;
    }

    public c C0(double d2) throws IOException {
        I0();
        if (!this.f11325f && (Double.isNaN(d2) || Double.isInfinite(d2))) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        k();
        this.a.append((CharSequence) Double.toString(d2));
        return this;
    }

    public c D0(long j2) throws IOException {
        I0();
        k();
        this.a.write(Long.toString(j2));
        return this;
    }

    public c E0(Boolean bool) throws IOException {
        if (bool == null) {
            return Y();
        }
        I0();
        k();
        this.a.write(bool.booleanValue() ? "true" : Bugly.SDK_IS_DEV);
        return this;
    }

    public boolean F() {
        return this.f11325f;
    }

    public c F0(Number number) throws IOException {
        if (number == null) {
            return Y();
        }
        I0();
        String obj = number.toString();
        if (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN")) {
            Class<?> cls = number.getClass();
            if (!H(cls) && !f11319j.matcher(obj).matches()) {
                throw new IllegalArgumentException("String created by " + cls + " is not a valid JSON number: " + obj);
            }
        } else if (!this.f11325f) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + obj);
        }
        k();
        this.a.append((CharSequence) obj);
        return this;
    }

    public c G0(String str) throws IOException {
        if (str == null) {
            return Y();
        }
        I0();
        k();
        B0(str);
        return this;
    }

    public c H0(boolean z) throws IOException {
        I0();
        k();
        this.a.write(z ? "true" : Bugly.SDK_IS_DEV);
        return this;
    }

    public c J(String str) throws IOException {
        if (str == null) {
            return Y();
        }
        I0();
        k();
        this.a.append((CharSequence) str);
        return this;
    }

    public c M(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.f11327h == null) {
            if (this.f11322c != 0) {
                this.f11327h = str;
                return this;
            }
            throw new IllegalStateException("JsonWriter is closed.");
        }
        throw new IllegalStateException();
    }

    public c Y() throws IOException {
        if (this.f11327h != null) {
            if (this.f11328i) {
                I0();
            } else {
                this.f11327h = null;
                return this;
            }
        }
        k();
        this.a.write("null");
        return this;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.a.close();
        int i2 = this.f11322c;
        if (i2 <= 1 && (i2 != 1 || this.b[i2 - 1] == 7)) {
            this.f11322c = 0;
            return;
        }
        throw new IOException("Incomplete document");
    }

    public void flush() throws IOException {
        if (this.f11322c != 0) {
            this.a.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public c l() throws IOException {
        I0();
        return c0(1, '[');
    }

    public c n() throws IOException {
        I0();
        return c0(3, '{');
    }

    public c q() throws IOException {
        return o(1, 2, ']');
    }

    public c r() throws IOException {
        return o(3, 5, '}');
    }

    public final boolean s() {
        return this.f11328i;
    }

    public final boolean t() {
        return this.f11326g;
    }

    public final void u0(boolean z) {
        this.f11326g = z;
    }

    public final void x0(String str) {
        if (str.length() == 0) {
            this.f11323d = null;
            this.f11324e = Constants.COLON_SEPARATOR;
            return;
        }
        this.f11323d = str;
        this.f11324e = ": ";
    }

    public final void z0(boolean z) {
        this.f11325f = z;
    }
}
