package com.google.android.gms.common.server.response;

import android.util.Log;
import com.google.android.gms.common.server.response.FastJsonResponse;
import e.j.a.b.c.r.d0;
import e.j.a.b.c.u.b.b;
import e.j.a.b.c.u.b.c;
import e.j.a.b.c.u.b.d;
import e.j.a.b.c.u.b.e;
import e.j.a.b.c.u.b.f;
import e.j.a.b.c.u.b.g;
import e.j.a.b.c.u.b.h;
import e.j.a.b.c.x.r;
import h.t2.y;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Map;
import java.util.Stack;

@e.j.a.b.c.m.a
@d0
/* loaded from: classes2.dex */
public class FastParser<T extends FastJsonResponse> {

    /* renamed from: g  reason: collision with root package name */
    private static final char[] f2654g = {'u', 'l', 'l'};

    /* renamed from: h  reason: collision with root package name */
    private static final char[] f2655h = {'r', 'u', 'e'};

    /* renamed from: i  reason: collision with root package name */
    private static final char[] f2656i = {'r', 'u', 'e', y.a};

    /* renamed from: j  reason: collision with root package name */
    private static final char[] f2657j = {'a', 'l', 's', 'e'};

    /* renamed from: k  reason: collision with root package name */
    private static final char[] f2658k = {'a', 'l', 's', 'e', y.a};

    /* renamed from: l  reason: collision with root package name */
    private static final char[] f2659l = {'\n'};

    /* renamed from: m  reason: collision with root package name */
    private static final a<Integer> f2660m = new e.j.a.b.c.u.b.a();
    private static final a<Long> n = new b();
    private static final a<Float> o = new c();
    private static final a<Double> p = new d();
    private static final a<Boolean> q = new e();
    private static final a<String> r = new f();
    private static final a<BigInteger> s = new g();
    private static final a<BigDecimal> t = new h();
    private final char[] a = new char[1];
    private final char[] b = new char[32];

    /* renamed from: c  reason: collision with root package name */
    private final char[] f2661c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private final StringBuilder f2662d = new StringBuilder(32);

    /* renamed from: e  reason: collision with root package name */
    private final StringBuilder f2663e = new StringBuilder(1024);

    /* renamed from: f  reason: collision with root package name */
    private final Stack<Integer> f2664f = new Stack<>();

    @e.j.a.b.c.m.a
    @d0
    /* loaded from: classes2.dex */
    public static class ParseException extends Exception {
        public ParseException(String str) {
            super(str);
        }

        public ParseException(String str, Throwable th) {
            super(str, th);
        }

        public ParseException(Throwable th) {
            super(th);
        }
    }

    /* loaded from: classes2.dex */
    public interface a<O> {
        O a(FastParser fastParser, BufferedReader bufferedReader) throws ParseException, IOException;
    }

    private final char A(BufferedReader bufferedReader) throws ParseException, IOException {
        if (bufferedReader.read(this.a) == -1) {
            return (char) 0;
        }
        while (Character.isWhitespace(this.a[0])) {
            if (bufferedReader.read(this.a) == -1) {
                return (char) 0;
            }
        }
        return this.a[0];
    }

    private final void B(int i2) throws ParseException {
        if (!this.f2664f.isEmpty()) {
            int intValue = this.f2664f.pop().intValue();
            if (intValue == i2) {
                return;
            }
            StringBuilder sb = new StringBuilder(46);
            sb.append("Expected state ");
            sb.append(i2);
            sb.append(" but had ");
            sb.append(intValue);
            throw new ParseException(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Expected state ");
        sb2.append(i2);
        sb2.append(" but had empty stack");
        throw new ParseException(sb2.toString());
    }

    private final int c(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2;
        char A = A(bufferedReader);
        if (A != 0) {
            if (A != ',') {
                if (A == 'n') {
                    n(bufferedReader, f2654g);
                    return 0;
                }
                bufferedReader.mark(1024);
                if (A == '\"') {
                    i2 = 0;
                    boolean z = false;
                    while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                        char c2 = cArr[i2];
                        if (Character.isISOControl(c2)) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                        if (c2 == '\"' && !z) {
                            bufferedReader.reset();
                            bufferedReader.skip(i2 + 1);
                            return i2;
                        }
                        z = c2 == '\\' ? !z : false;
                        i2++;
                    }
                } else {
                    cArr[0] = A;
                    i2 = 1;
                    while (i2 < cArr.length && bufferedReader.read(cArr, i2, 1) != -1) {
                        if (cArr[i2] == '}' || cArr[i2] == ',' || Character.isWhitespace(cArr[i2]) || cArr[i2] == ']') {
                            bufferedReader.reset();
                            bufferedReader.skip(i2 - 1);
                            cArr[i2] = 0;
                            return i2;
                        }
                        i2++;
                    }
                }
                if (i2 == cArr.length) {
                    throw new ParseException("Absurdly long value");
                }
                throw new ParseException("Unexpected EOF");
            }
            throw new ParseException("Missing value");
        }
        throw new ParseException("Unexpected EOF");
    }

    private final String d(BufferedReader bufferedReader) throws ParseException, IOException {
        this.f2664f.push(2);
        char A = A(bufferedReader);
        if (A == '\"') {
            this.f2664f.push(3);
            String m2 = m(bufferedReader, this.b, this.f2662d, null);
            B(3);
            if (A(bufferedReader) == ':') {
                return m2;
            }
            throw new ParseException("Expected key/value separator");
        } else if (A == ']') {
            B(2);
            B(1);
            B(5);
            return null;
        } else if (A == '}') {
            B(2);
            return null;
        } else {
            StringBuilder sb = new StringBuilder(19);
            sb.append("Unexpected token: ");
            sb.append(A);
            throw new ParseException(sb.toString());
        }
    }

    private final String e(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        char A = A(bufferedReader);
        if (A != '\"') {
            if (A == 'n') {
                n(bufferedReader, f2654g);
                return null;
            }
            throw new ParseException("Expected string");
        }
        return m(bufferedReader, cArr, sb, cArr2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T extends FastJsonResponse> ArrayList<T> f(BufferedReader bufferedReader, FastJsonResponse.Field<?, ?> field) throws ParseException, IOException {
        ArrayList<T> arrayList = (ArrayList<T>) new ArrayList();
        char A = A(bufferedReader);
        if (A == ']') {
            B(5);
            return arrayList;
        } else if (A == 'n') {
            n(bufferedReader, f2654g);
            B(5);
            return null;
        } else if (A == '{') {
            this.f2664f.push(1);
            while (true) {
                try {
                    FastJsonResponse zacp = field.zacp();
                    if (!i(bufferedReader, zacp)) {
                        return arrayList;
                    }
                    arrayList.add(zacp);
                    char A2 = A(bufferedReader);
                    if (A2 != ',') {
                        if (A2 == ']') {
                            B(5);
                            return arrayList;
                        }
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(A2);
                        throw new ParseException(sb.toString());
                    } else if (A(bufferedReader) == '{') {
                        this.f2664f.push(1);
                    } else {
                        throw new ParseException("Expected start of next object in array");
                    }
                } catch (IllegalAccessException e2) {
                    throw new ParseException("Error instantiating inner object", e2);
                } catch (InstantiationException e3) {
                    throw new ParseException("Error instantiating inner object", e3);
                }
            }
        } else {
            StringBuilder sb2 = new StringBuilder(19);
            sb2.append("Unexpected token: ");
            sb2.append(A);
            throw new ParseException(sb2.toString());
        }
    }

    private final <O> ArrayList<O> g(BufferedReader bufferedReader, a<O> aVar) throws ParseException, IOException {
        char A = A(bufferedReader);
        if (A == 'n') {
            n(bufferedReader, f2654g);
            return null;
        } else if (A == '[') {
            this.f2664f.push(5);
            ArrayList<O> arrayList = new ArrayList<>();
            while (true) {
                bufferedReader.mark(1024);
                char A2 = A(bufferedReader);
                if (A2 == 0) {
                    throw new ParseException("Unexpected EOF");
                }
                if (A2 != ',') {
                    if (A2 != ']') {
                        bufferedReader.reset();
                        arrayList.add(aVar.a(this, bufferedReader));
                    } else {
                        B(5);
                        return arrayList;
                    }
                }
            }
        } else {
            throw new ParseException("Expected start of array");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:138:0x029b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:140:0x027d A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean i(java.io.BufferedReader r17, com.google.android.gms.common.server.response.FastJsonResponse r18) throws com.google.android.gms.common.server.response.FastParser.ParseException, java.io.IOException {
        /*
            Method dump skipped, instructions count: 706
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.server.response.FastParser.i(java.io.BufferedReader, com.google.android.gms.common.server.response.FastJsonResponse):boolean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean j(BufferedReader bufferedReader, boolean z) throws ParseException, IOException {
        while (true) {
            char A = A(bufferedReader);
            if (A != '\"') {
                if (A == 'f') {
                    n(bufferedReader, z ? f2658k : f2657j);
                    return false;
                } else if (A == 'n') {
                    n(bufferedReader, f2654g);
                    return false;
                } else if (A == 't') {
                    n(bufferedReader, z ? f2656i : f2655h);
                    return true;
                } else {
                    StringBuilder sb = new StringBuilder(19);
                    sb.append("Unexpected token: ");
                    sb.append(A);
                    throw new ParseException(sb.toString());
                }
            } else if (z) {
                throw new ParseException("No boolean value found in string");
            } else {
                z = true;
            }
        }
    }

    private final String l(BufferedReader bufferedReader) throws ParseException, IOException {
        bufferedReader.mark(1024);
        char A = A(bufferedReader);
        if (A == '\"') {
            if (bufferedReader.read(this.a) != -1) {
                char c2 = this.a[0];
                boolean z = false;
                do {
                    if (c2 != '\"' || z) {
                        z = c2 == '\\' ? !z : false;
                        if (bufferedReader.read(this.a) != -1) {
                            c2 = this.a[0];
                        } else {
                            throw new ParseException("Unexpected EOF while parsing string");
                        }
                    }
                } while (!Character.isISOControl(c2));
                throw new ParseException("Unexpected control character while reading string");
            }
            throw new ParseException("Unexpected EOF while parsing string");
        } else if (A == ',') {
            throw new ParseException("Missing value");
        } else {
            int i2 = 1;
            if (A == '[') {
                this.f2664f.push(5);
                bufferedReader.mark(32);
                if (A(bufferedReader) == ']') {
                    B(5);
                } else {
                    bufferedReader.reset();
                    boolean z2 = false;
                    boolean z3 = false;
                    while (i2 > 0) {
                        char A2 = A(bufferedReader);
                        if (A2 != 0) {
                            if (Character.isISOControl(A2)) {
                                throw new ParseException("Unexpected control character while reading array");
                            }
                            if (A2 == '\"' && !z2) {
                                z3 = !z3;
                            }
                            if (A2 == '[' && !z3) {
                                i2++;
                            }
                            if (A2 == ']' && !z3) {
                                i2--;
                            }
                            z2 = (A2 == '\\' && z3) ? !z2 : false;
                        } else {
                            throw new ParseException("Unexpected EOF while parsing array");
                        }
                    }
                    B(5);
                }
            } else if (A != '{') {
                bufferedReader.reset();
                c(bufferedReader, this.f2661c);
            } else {
                this.f2664f.push(1);
                bufferedReader.mark(32);
                char A3 = A(bufferedReader);
                if (A3 == '}') {
                    B(1);
                } else if (A3 == '\"') {
                    bufferedReader.reset();
                    d(bufferedReader);
                    do {
                    } while (l(bufferedReader) != null);
                    B(1);
                } else {
                    StringBuilder sb = new StringBuilder(18);
                    sb.append("Unexpected token ");
                    sb.append(A3);
                    throw new ParseException(sb.toString());
                }
            }
        }
        char A4 = A(bufferedReader);
        if (A4 == ',') {
            B(2);
            return d(bufferedReader);
        } else if (A4 == '}') {
            B(2);
            return null;
        } else {
            StringBuilder sb2 = new StringBuilder(18);
            sb2.append("Unexpected token ");
            sb2.append(A4);
            throw new ParseException(sb2.toString());
        }
    }

    private static String m(BufferedReader bufferedReader, char[] cArr, StringBuilder sb, char[] cArr2) throws ParseException, IOException {
        boolean z;
        sb.setLength(0);
        bufferedReader.mark(cArr.length);
        boolean z2 = false;
        boolean z3 = false;
        while (true) {
            int read = bufferedReader.read(cArr);
            if (read != -1) {
                for (int i2 = 0; i2 < read; i2++) {
                    char c2 = cArr[i2];
                    if (Character.isISOControl(c2)) {
                        if (cArr2 != null) {
                            for (char c3 : cArr2) {
                                if (c3 == c2) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                        z = false;
                        if (!z) {
                            throw new ParseException("Unexpected control character while reading string");
                        }
                    }
                    if (c2 == '\"' && !z2) {
                        sb.append(cArr, 0, i2);
                        bufferedReader.reset();
                        bufferedReader.skip(i2 + 1);
                        if (z3) {
                            return r.c(sb.toString());
                        }
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        z2 = !z2;
                        z3 = true;
                    } else {
                        z2 = false;
                    }
                }
                sb.append(cArr, 0, read);
                bufferedReader.mark(cArr.length);
            } else {
                throw new ParseException("Unexpected EOF while parsing string");
            }
        }
    }

    private final void n(BufferedReader bufferedReader, char[] cArr) throws ParseException, IOException {
        int i2 = 0;
        while (i2 < cArr.length) {
            int read = bufferedReader.read(this.b, 0, cArr.length - i2);
            if (read == -1) {
                throw new ParseException("Unexpected EOF");
            }
            for (int i3 = 0; i3 < read; i3++) {
                if (cArr[i3 + i2] != this.b[i3]) {
                    throw new ParseException("Unexpected character");
                }
            }
            i2 += read;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String p(BufferedReader bufferedReader) throws ParseException, IOException {
        return e(bufferedReader, this.b, this.f2662d, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int r(BufferedReader bufferedReader) throws ParseException, IOException {
        int i2;
        int i3;
        boolean z;
        int c2 = c(bufferedReader, this.f2661c);
        int i4 = 0;
        if (c2 == 0) {
            return 0;
        }
        char[] cArr = this.f2661c;
        if (c2 > 0) {
            if (cArr[0] == '-') {
                i2 = Integer.MIN_VALUE;
                i3 = 1;
                z = true;
            } else {
                i2 = -2147483647;
                i3 = 0;
                z = false;
            }
            if (i3 < c2) {
                int i5 = i3 + 1;
                int digit = Character.digit(cArr[i3], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                int i6 = -digit;
                i3 = i5;
                i4 = i6;
            }
            while (i3 < c2) {
                int i7 = i3 + 1;
                int digit2 = Character.digit(cArr[i3], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (i4 < -214748364) {
                    throw new ParseException("Number too large");
                }
                int i8 = i4 * 10;
                if (i8 < i2 + digit2) {
                    throw new ParseException("Number too large");
                }
                i4 = i8 - digit2;
                i3 = i7;
            }
            if (z) {
                if (i3 > 1) {
                    return i4;
                }
                throw new ParseException("No digits to parse");
            }
            return -i4;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long s(BufferedReader bufferedReader) throws ParseException, IOException {
        long j2;
        boolean z;
        int c2 = c(bufferedReader, this.f2661c);
        long j3 = 0;
        if (c2 == 0) {
            return 0L;
        }
        char[] cArr = this.f2661c;
        if (c2 > 0) {
            int i2 = 0;
            if (cArr[0] == '-') {
                j2 = Long.MIN_VALUE;
                i2 = 1;
                z = true;
            } else {
                j2 = -9223372036854775807L;
                z = false;
            }
            if (i2 < c2) {
                int i3 = i2 + 1;
                int digit = Character.digit(cArr[i2], 10);
                if (digit < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                i2 = i3;
                j3 = -digit;
            }
            while (i2 < c2) {
                int i4 = i2 + 1;
                int digit2 = Character.digit(cArr[i2], 10);
                if (digit2 < 0) {
                    throw new ParseException("Unexpected non-digit character");
                }
                if (j3 < j.q0.a.f16004c) {
                    throw new ParseException("Number too large");
                }
                long j4 = j3 * 10;
                long j5 = digit2;
                if (j4 < j2 + j5) {
                    throw new ParseException("Number too large");
                }
                j3 = j4 - j5;
                i2 = i4;
            }
            if (z) {
                if (i2 > 1) {
                    return j3;
                }
                throw new ParseException("No digits to parse");
            }
            return -j3;
        }
        throw new ParseException("No number to parse");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigInteger v(BufferedReader bufferedReader) throws ParseException, IOException {
        int c2 = c(bufferedReader, this.f2661c);
        if (c2 == 0) {
            return null;
        }
        return new BigInteger(new String(this.f2661c, 0, c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float w(BufferedReader bufferedReader) throws ParseException, IOException {
        int c2 = c(bufferedReader, this.f2661c);
        if (c2 == 0) {
            return 0.0f;
        }
        return Float.parseFloat(new String(this.f2661c, 0, c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final double y(BufferedReader bufferedReader) throws ParseException, IOException {
        int c2 = c(bufferedReader, this.f2661c);
        if (c2 == 0) {
            return 0.0d;
        }
        return Double.parseDouble(new String(this.f2661c, 0, c2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BigDecimal z(BufferedReader bufferedReader) throws ParseException, IOException {
        int c2 = c(bufferedReader, this.f2661c);
        if (c2 == 0) {
            return null;
        }
        return new BigDecimal(new String(this.f2661c, 0, c2));
    }

    @e.j.a.b.c.m.a
    public void a(InputStream inputStream, T t2) throws ParseException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1024);
        try {
            try {
                this.f2664f.push(0);
                char A = A(bufferedReader);
                if (A != 0) {
                    if (A == '[') {
                        this.f2664f.push(5);
                        Map<String, FastJsonResponse.Field<?, ?>> fieldMappings = t2.getFieldMappings();
                        if (fieldMappings.size() == 1) {
                            FastJsonResponse.Field<?, ?> value = fieldMappings.entrySet().iterator().next().getValue();
                            t2.addConcreteTypeArrayInternal(value, value.zapv, f(bufferedReader, value));
                        } else {
                            throw new ParseException("Object array response class must have a single Field");
                        }
                    } else if (A == '{') {
                        this.f2664f.push(1);
                        i(bufferedReader, t2);
                    } else {
                        StringBuilder sb = new StringBuilder(19);
                        sb.append("Unexpected token: ");
                        sb.append(A);
                        throw new ParseException(sb.toString());
                    }
                    B(0);
                    try {
                        bufferedReader.close();
                        return;
                    } catch (IOException unused) {
                        Log.w("FastParser", "Failed to close reader while parsing.");
                        return;
                    }
                }
                throw new ParseException("No data to parse");
            } catch (IOException e2) {
                throw new ParseException(e2);
            }
        } catch (Throwable th) {
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
                Log.w("FastParser", "Failed to close reader while parsing.");
            }
            throw th;
        }
    }
}
