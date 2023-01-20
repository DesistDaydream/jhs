package e.j.e.u;

import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.tencent.bugly.Bugly;
import e.j.e.s.e;
import h.t2.y;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes2.dex */
public class a implements Closeable {
    private static final int A = 10;
    private static final int B = 11;
    private static final int C = 12;
    private static final int D = 13;
    private static final int E = 14;
    private static final int F = 15;
    private static final int G = 16;
    private static final int H = 17;
    private static final int I = 0;
    private static final int J = 1;
    private static final int K = 2;
    private static final int L = 3;
    private static final int M = 4;
    private static final int N = 5;
    private static final int O = 6;
    private static final int P = 7;
    public static final int Q = 1024;
    private static final long p = -922337203685477580L;
    private static final int q = 0;
    private static final int r = 1;
    private static final int s = 2;
    private static final int t = 3;
    private static final int u = 4;
    private static final int v = 5;
    private static final int w = 6;
    private static final int x = 7;
    private static final int y = 8;
    private static final int z = 9;
    private final Reader a;
    private boolean b = false;

    /* renamed from: c  reason: collision with root package name */
    private final char[] f11302c = new char[1024];

    /* renamed from: d  reason: collision with root package name */
    private int f11303d = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f11304e = 0;

    /* renamed from: f  reason: collision with root package name */
    private int f11305f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f11306g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f11307h = 0;

    /* renamed from: i  reason: collision with root package name */
    private long f11308i;

    /* renamed from: j  reason: collision with root package name */
    private int f11309j;

    /* renamed from: k  reason: collision with root package name */
    private String f11310k;

    /* renamed from: l  reason: collision with root package name */
    private int[] f11311l;

    /* renamed from: m  reason: collision with root package name */
    private int f11312m;
    private String[] n;
    private int[] o;

    /* renamed from: e.j.e.u.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0380a extends e {
        @Override // e.j.e.s.e
        public void a(a aVar) throws IOException {
            if (aVar instanceof e.j.e.s.k.a) {
                ((e.j.e.s.k.a) aVar).S0();
                return;
            }
            int i2 = aVar.f11307h;
            if (i2 == 0) {
                i2 = aVar.o();
            }
            if (i2 == 13) {
                aVar.f11307h = 9;
            } else if (i2 == 12) {
                aVar.f11307h = 8;
            } else if (i2 == 14) {
                aVar.f11307h = 10;
            } else {
                throw new IllegalStateException("Expected a name but was " + aVar.C0() + aVar.X());
            }
        }
    }

    static {
        e.a = new C0380a();
    }

    public a(Reader reader) {
        int[] iArr = new int[32];
        this.f11311l = iArr;
        this.f11312m = 0;
        this.f11312m = 0 + 1;
        iArr[0] = 6;
        this.n = new String[32];
        this.o = new int[32];
        Objects.requireNonNull(reader, "in == null");
        this.a = reader;
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
        l();
     */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String B0() throws java.io.IOException {
        /*
            r6 = this;
            r0 = 0
            r1 = 0
        L2:
            r2 = 0
        L3:
            int r3 = r6.f11303d
            int r4 = r3 + r2
            int r5 = r6.f11304e
            if (r4 >= r5) goto L4e
            char[] r4 = r6.f11302c
            int r3 = r3 + r2
            char r3 = r4[r3]
            r4 = 9
            if (r3 == r4) goto L5c
            r4 = 10
            if (r3 == r4) goto L5c
            r4 = 12
            if (r3 == r4) goto L5c
            r4 = 13
            if (r3 == r4) goto L5c
            r4 = 32
            if (r3 == r4) goto L5c
            r4 = 35
            if (r3 == r4) goto L4a
            r4 = 44
            if (r3 == r4) goto L5c
            r4 = 47
            if (r3 == r4) goto L4a
            r4 = 61
            if (r3 == r4) goto L4a
            r4 = 123(0x7b, float:1.72E-43)
            if (r3 == r4) goto L5c
            r4 = 125(0x7d, float:1.75E-43)
            if (r3 == r4) goto L5c
            r4 = 58
            if (r3 == r4) goto L5c
            r4 = 59
            if (r3 == r4) goto L4a
            switch(r3) {
                case 91: goto L5c;
                case 92: goto L4a;
                case 93: goto L5c;
                default: goto L47;
            }
        L47:
            int r2 = r2 + 1
            goto L3
        L4a:
            r6.l()
            goto L5c
        L4e:
            char[] r3 = r6.f11302c
            int r3 = r3.length
            if (r2 >= r3) goto L5e
            int r3 = r2 + 1
            boolean r3 = r6.s(r3)
            if (r3 == 0) goto L5c
            goto L3
        L5c:
            r0 = r2
            goto L7e
        L5e:
            if (r1 != 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r3 = 16
            int r3 = java.lang.Math.max(r2, r3)
            r1.<init>(r3)
        L6b:
            char[] r3 = r6.f11302c
            int r4 = r6.f11303d
            r1.append(r3, r4, r2)
            int r3 = r6.f11303d
            int r3 = r3 + r2
            r6.f11303d = r3
            r2 = 1
            boolean r2 = r6.s(r2)
            if (r2 != 0) goto L2
        L7e:
            if (r1 != 0) goto L8a
            java.lang.String r1 = new java.lang.String
            char[] r2 = r6.f11302c
            int r3 = r6.f11303d
            r1.<init>(r2, r3, r0)
            goto L95
        L8a:
            char[] r2 = r6.f11302c
            int r3 = r6.f11303d
            r1.append(r2, r3, r0)
            java.lang.String r1 = r1.toString()
        L95:
            int r2 = r6.f11303d
            int r2 = r2 + r0
            r6.f11303d = r2
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.u.a.B0():java.lang.String");
    }

    private int D0() throws IOException {
        int i2;
        String str;
        String str2;
        char c2 = this.f11302c[this.f11303d];
        if (c2 == 't' || c2 == 'T') {
            i2 = 5;
            str = "true";
            str2 = "TRUE";
        } else if (c2 == 'f' || c2 == 'F') {
            i2 = 6;
            str = Bugly.SDK_IS_DEV;
            str2 = "FALSE";
        } else if (c2 != 'n' && c2 != 'N') {
            return 0;
        } else {
            i2 = 7;
            str = "null";
            str2 = "NULL";
        }
        int length = str.length();
        for (int i3 = 1; i3 < length; i3++) {
            if (this.f11303d + i3 >= this.f11304e && !s(i3 + 1)) {
                return 0;
            }
            char c3 = this.f11302c[this.f11303d + i3];
            if (c3 != str.charAt(i3) && c3 != str2.charAt(i3)) {
                return 0;
            }
        }
        if ((this.f11303d + length < this.f11304e || s(length + 1)) && M(this.f11302c[this.f11303d + length])) {
            return 0;
        }
        this.f11303d += length;
        this.f11307h = i2;
        return i2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:55:0x0095, code lost:
        if (M(r14) != false) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0097, code lost:
        if (r9 != 2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x0099, code lost:
        if (r10 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009f, code lost:
        if (r11 != Long.MIN_VALUE) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00a1, code lost:
        if (r13 == false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a7, code lost:
        if (r11 != 0) goto L18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a9, code lost:
        if (r13 != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x00ab, code lost:
        if (r13 == false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ae, code lost:
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00af, code lost:
        r18.f11308i = r11;
        r18.f11303d += r8;
        r18.f11307h = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00ba, code lost:
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00bb, code lost:
        if (r9 == 2) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00be, code lost:
        if (r9 == 4) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c1, code lost:
        if (r9 != 7) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00c4, code lost:
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c6, code lost:
        r18.f11309j = r8;
        r18.f11307h = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00cc, code lost:
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x00cd, code lost:
        return 0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int E0() throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 252
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.u.a.E0():int");
    }

    private void F0(int i2) {
        int i3 = this.f11312m;
        int[] iArr = this.f11311l;
        if (i3 == iArr.length) {
            int i4 = i3 * 2;
            this.f11311l = Arrays.copyOf(iArr, i4);
            this.o = Arrays.copyOf(this.o, i4);
            this.n = (String[]) Arrays.copyOf(this.n, i4);
        }
        int[] iArr2 = this.f11311l;
        int i5 = this.f11312m;
        this.f11312m = i5 + 1;
        iArr2[i5] = i2;
    }

    private char G0() throws IOException {
        int i2;
        int i3;
        if (this.f11303d == this.f11304e && !s(1)) {
            throw N0("Unterminated escape sequence");
        }
        char[] cArr = this.f11302c;
        int i4 = this.f11303d;
        int i5 = i4 + 1;
        this.f11303d = i5;
        char c2 = cArr[i4];
        if (c2 == '\n') {
            this.f11305f++;
            this.f11306g = i5;
        } else if (c2 != '\"' && c2 != '\'' && c2 != '/' && c2 != '\\') {
            if (c2 != 'b') {
                if (c2 != 'f') {
                    if (c2 != 'n') {
                        if (c2 != 'r') {
                            if (c2 != 't') {
                                if (c2 == 'u') {
                                    if (i5 + 4 > this.f11304e && !s(4)) {
                                        throw N0("Unterminated escape sequence");
                                    }
                                    char c3 = 0;
                                    int i6 = this.f11303d;
                                    int i7 = i6 + 4;
                                    while (i6 < i7) {
                                        char c4 = this.f11302c[i6];
                                        char c5 = (char) (c3 << 4);
                                        if (c4 < '0' || c4 > '9') {
                                            if (c4 >= 'a' && c4 <= 'f') {
                                                i2 = c4 - 'a';
                                            } else if (c4 < 'A' || c4 > 'F') {
                                                throw new NumberFormatException("\\u" + new String(this.f11302c, this.f11303d, 4));
                                            } else {
                                                i2 = c4 - 'A';
                                            }
                                            i3 = i2 + 10;
                                        } else {
                                            i3 = c4 - '0';
                                        }
                                        c3 = (char) (c5 + i3);
                                        i6++;
                                    }
                                    this.f11303d += 4;
                                    return c3;
                                }
                                throw N0("Invalid escape sequence");
                            }
                            return '\t';
                        }
                        return '\r';
                    }
                    return '\n';
                }
                return '\f';
            }
            return '\b';
        }
        return c2;
    }

    private void I0(char c2) throws IOException {
        char[] cArr = this.f11302c;
        do {
            int i2 = this.f11303d;
            int i3 = this.f11304e;
            while (i2 < i3) {
                int i4 = i2 + 1;
                char c3 = cArr[i2];
                if (c3 == c2) {
                    this.f11303d = i4;
                    return;
                } else if (c3 == '\\') {
                    this.f11303d = i4;
                    G0();
                    i2 = this.f11303d;
                    i3 = this.f11304e;
                } else {
                    if (c3 == '\n') {
                        this.f11305f++;
                        this.f11306g = i4;
                    }
                    i2 = i4;
                }
            }
            this.f11303d = i2;
        } while (s(1));
        throw N0("Unterminated string");
    }

    private boolean J0(String str) throws IOException {
        int length = str.length();
        while (true) {
            if (this.f11303d + length > this.f11304e && !s(length)) {
                return false;
            }
            char[] cArr = this.f11302c;
            int i2 = this.f11303d;
            if (cArr[i2] != '\n') {
                for (int i3 = 0; i3 < length; i3++) {
                    if (this.f11302c[this.f11303d + i3] != str.charAt(i3)) {
                        break;
                    }
                }
                return true;
            }
            this.f11305f++;
            this.f11306g = i2 + 1;
            this.f11303d++;
        }
    }

    private void K0() throws IOException {
        char c2;
        do {
            if (this.f11303d >= this.f11304e && !s(1)) {
                return;
            }
            char[] cArr = this.f11302c;
            int i2 = this.f11303d;
            int i3 = i2 + 1;
            this.f11303d = i3;
            c2 = cArr[i2];
            if (c2 == '\n') {
                this.f11305f++;
                this.f11306g = i3;
                return;
            }
        } while (c2 != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x0048, code lost:
        l();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void L0() throws java.io.IOException {
        /*
            r4 = this;
        L0:
            r0 = 0
        L1:
            int r1 = r4.f11303d
            int r2 = r1 + r0
            int r3 = r4.f11304e
            if (r2 >= r3) goto L51
            char[] r2 = r4.f11302c
            int r1 = r1 + r0
            char r1 = r2[r1]
            r2 = 9
            if (r1 == r2) goto L4b
            r2 = 10
            if (r1 == r2) goto L4b
            r2 = 12
            if (r1 == r2) goto L4b
            r2 = 13
            if (r1 == r2) goto L4b
            r2 = 32
            if (r1 == r2) goto L4b
            r2 = 35
            if (r1 == r2) goto L48
            r2 = 44
            if (r1 == r2) goto L4b
            r2 = 47
            if (r1 == r2) goto L48
            r2 = 61
            if (r1 == r2) goto L48
            r2 = 123(0x7b, float:1.72E-43)
            if (r1 == r2) goto L4b
            r2 = 125(0x7d, float:1.75E-43)
            if (r1 == r2) goto L4b
            r2 = 58
            if (r1 == r2) goto L4b
            r2 = 59
            if (r1 == r2) goto L48
            switch(r1) {
                case 91: goto L4b;
                case 92: goto L48;
                case 93: goto L4b;
                default: goto L45;
            }
        L45:
            int r0 = r0 + 1
            goto L1
        L48:
            r4.l()
        L4b:
            int r1 = r4.f11303d
            int r1 = r1 + r0
            r4.f11303d = r1
            return
        L51:
            int r1 = r1 + r0
            r4.f11303d = r1
            r0 = 1
            boolean r0 = r4.s(r0)
            if (r0 != 0) goto L0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.u.a.L0():void");
    }

    private boolean M(char c2) throws IOException {
        if (c2 == '\t' || c2 == '\n' || c2 == '\f' || c2 == '\r' || c2 == ' ') {
            return false;
        }
        if (c2 != '#') {
            if (c2 == ',') {
                return false;
            }
            if (c2 != '/' && c2 != '=') {
                if (c2 == '{' || c2 == '}' || c2 == ':') {
                    return false;
                }
                if (c2 != ';') {
                    switch (c2) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        l();
        return false;
    }

    private IOException N0(String str) throws IOException {
        throw new MalformedJsonException(str + X());
    }

    private void l() throws IOException {
        if (!this.b) {
            throw N0("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    private void n() throws IOException {
        u0(true);
        int i2 = this.f11303d - 1;
        this.f11303d = i2;
        if (i2 + 5 <= this.f11304e || s(5)) {
            int i3 = this.f11303d;
            char[] cArr = this.f11302c;
            if (cArr[i3] == ')' && cArr[i3 + 1] == ']' && cArr[i3 + 2] == '}' && cArr[i3 + 3] == '\'' && cArr[i3 + 4] == '\n') {
                this.f11303d = i3 + 5;
            }
        }
    }

    private boolean s(int i2) throws IOException {
        int i3;
        int i4;
        char[] cArr = this.f11302c;
        int i5 = this.f11306g;
        int i6 = this.f11303d;
        this.f11306g = i5 - i6;
        int i7 = this.f11304e;
        if (i7 != i6) {
            int i8 = i7 - i6;
            this.f11304e = i8;
            System.arraycopy(cArr, i6, cArr, 0, i8);
        } else {
            this.f11304e = 0;
        }
        this.f11303d = 0;
        do {
            Reader reader = this.a;
            int i9 = this.f11304e;
            int read = reader.read(cArr, i9, cArr.length - i9);
            if (read == -1) {
                return false;
            }
            i3 = this.f11304e + read;
            this.f11304e = i3;
            if (this.f11305f == 0 && (i4 = this.f11306g) == 0 && i3 > 0 && cArr[0] == 65279) {
                this.f11303d++;
                this.f11306g = i4 + 1;
                i2++;
                continue;
            }
        } while (i3 < i2);
        return true;
    }

    private String t(boolean z2) {
        StringBuilder sb = new StringBuilder();
        sb.append('$');
        int i2 = 0;
        while (true) {
            int i3 = this.f11312m;
            if (i2 < i3) {
                int i4 = this.f11311l[i2];
                if (i4 == 1 || i4 == 2) {
                    int i5 = this.o[i2];
                    if (z2 && i5 > 0 && i2 == i3 - 1) {
                        i5--;
                    }
                    sb.append('[');
                    sb.append(i5);
                    sb.append(']');
                } else if (i4 == 3 || i4 == 4 || i4 == 5) {
                    sb.append('.');
                    String[] strArr = this.n;
                    if (strArr[i2] != null) {
                        sb.append(strArr[i2]);
                    }
                }
                i2++;
            } else {
                return sb.toString();
            }
        }
    }

    private int u0(boolean z2) throws IOException {
        char[] cArr = this.f11302c;
        int i2 = this.f11303d;
        int i3 = this.f11304e;
        while (true) {
            if (i2 == i3) {
                this.f11303d = i2;
                if (!s(1)) {
                    if (z2) {
                        throw new EOFException("End of input" + X());
                    }
                    return -1;
                }
                i2 = this.f11303d;
                i3 = this.f11304e;
            }
            int i4 = i2 + 1;
            char c2 = cArr[i2];
            if (c2 == '\n') {
                this.f11305f++;
                this.f11306g = i4;
            } else if (c2 != ' ' && c2 != '\r' && c2 != '\t') {
                if (c2 == '/') {
                    this.f11303d = i4;
                    if (i4 == i3) {
                        this.f11303d = i4 - 1;
                        boolean s2 = s(2);
                        this.f11303d++;
                        if (!s2) {
                            return c2;
                        }
                    }
                    l();
                    int i5 = this.f11303d;
                    char c3 = cArr[i5];
                    if (c3 == '*') {
                        this.f11303d = i5 + 1;
                        if (J0(k.b.a.a.n.n.e.f16211c)) {
                            i2 = this.f11303d + 2;
                            i3 = this.f11304e;
                        } else {
                            throw N0("Unterminated comment");
                        }
                    } else if (c3 != '/') {
                        return c2;
                    } else {
                        this.f11303d = i5 + 1;
                        K0();
                        i2 = this.f11303d;
                        i3 = this.f11304e;
                    }
                } else if (c2 == '#') {
                    this.f11303d = i4;
                    l();
                    K0();
                    i2 = this.f11303d;
                    i3 = this.f11304e;
                } else {
                    this.f11303d = i4;
                    return c2;
                }
            }
            i2 = i4;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005c, code lost:
        if (r1 != null) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006c, code lost:
        r1.append(r0, r3, r2 - r3);
        r9.f11303d = r2;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String z0(char r10) throws java.io.IOException {
        /*
            r9 = this;
            char[] r0 = r9.f11302c
            r1 = 0
        L3:
            int r2 = r9.f11303d
            int r3 = r9.f11304e
        L7:
            r4 = r3
            r3 = r2
        L9:
            r5 = 16
            r6 = 1
            if (r2 >= r4) goto L5c
            int r7 = r2 + 1
            char r2 = r0[r2]
            if (r2 != r10) goto L28
            r9.f11303d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L20
            java.lang.String r10 = new java.lang.String
            r10.<init>(r0, r3, r7)
            return r10
        L20:
            r1.append(r0, r3, r7)
            java.lang.String r10 = r1.toString()
            return r10
        L28:
            r8 = 92
            if (r2 != r8) goto L4f
            r9.f11303d = r7
            int r7 = r7 - r3
            int r7 = r7 - r6
            if (r1 != 0) goto L40
            int r1 = r7 + 1
            int r1 = r1 * 2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r2.<init>(r1)
            r1 = r2
        L40:
            r1.append(r0, r3, r7)
            char r2 = r9.G0()
            r1.append(r2)
            int r2 = r9.f11303d
            int r3 = r9.f11304e
            goto L7
        L4f:
            r5 = 10
            if (r2 != r5) goto L5a
            int r2 = r9.f11305f
            int r2 = r2 + r6
            r9.f11305f = r2
            r9.f11306g = r7
        L5a:
            r2 = r7
            goto L9
        L5c:
            if (r1 != 0) goto L6c
            int r1 = r2 - r3
            int r1 = r1 * 2
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = java.lang.Math.max(r1, r5)
            r4.<init>(r1)
            r1 = r4
        L6c:
            int r4 = r2 - r3
            r1.append(r0, r3, r4)
            r9.f11303d = r2
            boolean r2 = r9.s(r6)
            if (r2 == 0) goto L7a
            goto L3
        L7a:
            java.lang.String r10 = "Unterminated string"
            java.io.IOException r10 = r9.N0(r10)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.e.u.a.z0(char):java.lang.String");
    }

    public String A0() throws IOException {
        String str;
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 10) {
            str = B0();
        } else if (i2 == 8) {
            str = z0('\'');
        } else if (i2 == 9) {
            str = z0(y.a);
        } else if (i2 == 11) {
            str = this.f11310k;
            this.f11310k = null;
        } else if (i2 == 15) {
            str = Long.toString(this.f11308i);
        } else if (i2 == 16) {
            str = new String(this.f11302c, this.f11303d, this.f11309j);
            this.f11303d += this.f11309j;
        } else {
            throw new IllegalStateException("Expected a string but was " + C0() + X());
        }
        this.f11307h = 0;
        int[] iArr = this.o;
        int i3 = this.f11312m - 1;
        iArr[i3] = iArr[i3] + 1;
        return str;
    }

    public JsonToken C0() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        switch (i2) {
            case 1:
                return JsonToken.BEGIN_OBJECT;
            case 2:
                return JsonToken.END_OBJECT;
            case 3:
                return JsonToken.BEGIN_ARRAY;
            case 4:
                return JsonToken.END_ARRAY;
            case 5:
            case 6:
                return JsonToken.BOOLEAN;
            case 7:
                return JsonToken.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return JsonToken.STRING;
            case 12:
            case 13:
            case 14:
                return JsonToken.NAME;
            case 15:
            case 16:
                return JsonToken.NUMBER;
            case 17:
                return JsonToken.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    public String F() {
        return t(true);
    }

    public boolean H() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        return (i2 == 2 || i2 == 4 || i2 == 17) ? false : true;
    }

    public final void H0(boolean z2) {
        this.b = z2;
    }

    public final boolean J() {
        return this.b;
    }

    public void M0() throws IOException {
        int i2 = 0;
        do {
            int i3 = this.f11307h;
            if (i3 == 0) {
                i3 = o();
            }
            if (i3 == 3) {
                F0(1);
            } else if (i3 == 1) {
                F0(3);
            } else {
                if (i3 == 4) {
                    this.f11312m--;
                } else if (i3 == 2) {
                    this.f11312m--;
                } else {
                    if (i3 == 14 || i3 == 10) {
                        L0();
                    } else if (i3 == 8 || i3 == 12) {
                        I0('\'');
                    } else if (i3 == 9 || i3 == 13) {
                        I0(y.a);
                    } else if (i3 == 16) {
                        this.f11303d += this.f11309j;
                    }
                    this.f11307h = 0;
                }
                i2--;
                this.f11307h = 0;
            }
            i2++;
            this.f11307h = 0;
        } while (i2 != 0);
        int[] iArr = this.o;
        int i4 = this.f11312m;
        int i5 = i4 - 1;
        iArr[i5] = iArr[i5] + 1;
        this.n[i4 - 1] = "null";
    }

    public String X() {
        return " at line " + (this.f11305f + 1) + " column " + ((this.f11303d - this.f11306g) + 1) + " path " + getPath();
    }

    public boolean Y() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 5) {
            this.f11307h = 0;
            int[] iArr = this.o;
            int i3 = this.f11312m - 1;
            iArr[i3] = iArr[i3] + 1;
            return true;
        } else if (i2 == 6) {
            this.f11307h = 0;
            int[] iArr2 = this.o;
            int i4 = this.f11312m - 1;
            iArr2[i4] = iArr2[i4] + 1;
            return false;
        } else {
            throw new IllegalStateException("Expected a boolean but was " + C0() + X());
        }
    }

    public double c0() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 15) {
            this.f11307h = 0;
            int[] iArr = this.o;
            int i3 = this.f11312m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f11308i;
        }
        if (i2 == 16) {
            this.f11310k = new String(this.f11302c, this.f11303d, this.f11309j);
            this.f11303d += this.f11309j;
        } else if (i2 == 8 || i2 == 9) {
            this.f11310k = z0(i2 == 8 ? '\'' : y.a);
        } else if (i2 == 10) {
            this.f11310k = B0();
        } else if (i2 != 11) {
            throw new IllegalStateException("Expected a double but was " + C0() + X());
        }
        this.f11307h = 11;
        double parseDouble = Double.parseDouble(this.f11310k);
        if (!this.b && (Double.isNaN(parseDouble) || Double.isInfinite(parseDouble))) {
            throw new MalformedJsonException("JSON forbids NaN and infinities: " + parseDouble + X());
        }
        this.f11310k = null;
        this.f11307h = 0;
        int[] iArr2 = this.o;
        int i4 = this.f11312m - 1;
        iArr2[i4] = iArr2[i4] + 1;
        return parseDouble;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f11307h = 0;
        this.f11311l[0] = 8;
        this.f11312m = 1;
        this.a.close();
    }

    public int f0() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 15) {
            long j2 = this.f11308i;
            int i3 = (int) j2;
            if (j2 == i3) {
                this.f11307h = 0;
                int[] iArr = this.o;
                int i4 = this.f11312m - 1;
                iArr[i4] = iArr[i4] + 1;
                return i3;
            }
            throw new NumberFormatException("Expected an int but was " + this.f11308i + X());
        }
        if (i2 == 16) {
            this.f11310k = new String(this.f11302c, this.f11303d, this.f11309j);
            this.f11303d += this.f11309j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected an int but was " + C0() + X());
        } else {
            if (i2 == 10) {
                this.f11310k = B0();
            } else {
                this.f11310k = z0(i2 == 8 ? '\'' : y.a);
            }
            try {
                int parseInt = Integer.parseInt(this.f11310k);
                this.f11307h = 0;
                int[] iArr2 = this.o;
                int i5 = this.f11312m - 1;
                iArr2[i5] = iArr2[i5] + 1;
                return parseInt;
            } catch (NumberFormatException unused) {
            }
        }
        this.f11307h = 11;
        double parseDouble = Double.parseDouble(this.f11310k);
        int i6 = (int) parseDouble;
        if (i6 == parseDouble) {
            this.f11310k = null;
            this.f11307h = 0;
            int[] iArr3 = this.o;
            int i7 = this.f11312m - 1;
            iArr3[i7] = iArr3[i7] + 1;
            return i6;
        }
        throw new NumberFormatException("Expected an int but was " + this.f11310k + X());
    }

    public String getPath() {
        return t(false);
    }

    public void j() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 3) {
            F0(1);
            this.o[this.f11312m - 1] = 0;
            this.f11307h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_ARRAY but was " + C0() + X());
    }

    public void k() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 1) {
            F0(3);
            this.f11307h = 0;
            return;
        }
        throw new IllegalStateException("Expected BEGIN_OBJECT but was " + C0() + X());
    }

    public long m0() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 15) {
            this.f11307h = 0;
            int[] iArr = this.o;
            int i3 = this.f11312m - 1;
            iArr[i3] = iArr[i3] + 1;
            return this.f11308i;
        }
        if (i2 == 16) {
            this.f11310k = new String(this.f11302c, this.f11303d, this.f11309j);
            this.f11303d += this.f11309j;
        } else if (i2 != 8 && i2 != 9 && i2 != 10) {
            throw new IllegalStateException("Expected a long but was " + C0() + X());
        } else {
            if (i2 == 10) {
                this.f11310k = B0();
            } else {
                this.f11310k = z0(i2 == 8 ? '\'' : y.a);
            }
            try {
                long parseLong = Long.parseLong(this.f11310k);
                this.f11307h = 0;
                int[] iArr2 = this.o;
                int i4 = this.f11312m - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return parseLong;
            } catch (NumberFormatException unused) {
            }
        }
        this.f11307h = 11;
        double parseDouble = Double.parseDouble(this.f11310k);
        long j2 = (long) parseDouble;
        if (j2 == parseDouble) {
            this.f11310k = null;
            this.f11307h = 0;
            int[] iArr3 = this.o;
            int i5 = this.f11312m - 1;
            iArr3[i5] = iArr3[i5] + 1;
            return j2;
        }
        throw new NumberFormatException("Expected a long but was " + this.f11310k + X());
    }

    public int o() throws IOException {
        int u0;
        int[] iArr = this.f11311l;
        int i2 = this.f11312m;
        int i3 = iArr[i2 - 1];
        if (i3 == 1) {
            iArr[i2 - 1] = 2;
        } else if (i3 == 2) {
            int u02 = u0(true);
            if (u02 != 44) {
                if (u02 != 59) {
                    if (u02 == 93) {
                        this.f11307h = 4;
                        return 4;
                    }
                    throw N0("Unterminated array");
                }
                l();
            }
        } else if (i3 == 3 || i3 == 5) {
            iArr[i2 - 1] = 4;
            if (i3 == 5 && (u0 = u0(true)) != 44) {
                if (u0 != 59) {
                    if (u0 == 125) {
                        this.f11307h = 2;
                        return 2;
                    }
                    throw N0("Unterminated object");
                }
                l();
            }
            int u03 = u0(true);
            if (u03 == 34) {
                this.f11307h = 13;
                return 13;
            } else if (u03 == 39) {
                l();
                this.f11307h = 12;
                return 12;
            } else if (u03 == 125) {
                if (i3 != 5) {
                    this.f11307h = 2;
                    return 2;
                }
                throw N0("Expected name");
            } else {
                l();
                this.f11303d--;
                if (M((char) u03)) {
                    this.f11307h = 14;
                    return 14;
                }
                throw N0("Expected name");
            }
        } else if (i3 == 4) {
            iArr[i2 - 1] = 5;
            int u04 = u0(true);
            if (u04 != 58) {
                if (u04 == 61) {
                    l();
                    if (this.f11303d < this.f11304e || s(1)) {
                        char[] cArr = this.f11302c;
                        int i4 = this.f11303d;
                        if (cArr[i4] == '>') {
                            this.f11303d = i4 + 1;
                        }
                    }
                } else {
                    throw N0("Expected ':'");
                }
            }
        } else if (i3 == 6) {
            if (this.b) {
                n();
            }
            this.f11311l[this.f11312m - 1] = 7;
        } else if (i3 == 7) {
            if (u0(false) == -1) {
                this.f11307h = 17;
                return 17;
            }
            l();
            this.f11303d--;
        } else if (i3 == 8) {
            throw new IllegalStateException("JsonReader is closed");
        }
        int u05 = u0(true);
        if (u05 == 34) {
            this.f11307h = 9;
            return 9;
        } else if (u05 == 39) {
            l();
            this.f11307h = 8;
            return 8;
        } else {
            if (u05 != 44 && u05 != 59) {
                if (u05 == 91) {
                    this.f11307h = 3;
                    return 3;
                } else if (u05 != 93) {
                    if (u05 != 123) {
                        this.f11303d--;
                        int D0 = D0();
                        if (D0 != 0) {
                            return D0;
                        }
                        int E0 = E0();
                        if (E0 != 0) {
                            return E0;
                        }
                        if (M(this.f11302c[this.f11303d])) {
                            l();
                            this.f11307h = 10;
                            return 10;
                        }
                        throw N0("Expected value");
                    }
                    this.f11307h = 1;
                    return 1;
                } else if (i3 == 1) {
                    this.f11307h = 4;
                    return 4;
                }
            }
            if (i3 != 1 && i3 != 2) {
                throw N0("Unexpected value");
            }
            l();
            this.f11303d--;
            this.f11307h = 7;
            return 7;
        }
    }

    public String o0() throws IOException {
        String z0;
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 14) {
            z0 = B0();
        } else if (i2 == 12) {
            z0 = z0('\'');
        } else if (i2 == 13) {
            z0 = z0(y.a);
        } else {
            throw new IllegalStateException("Expected a name but was " + C0() + X());
        }
        this.f11307h = 0;
        this.n[this.f11312m - 1] = z0;
        return z0;
    }

    public void q() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 4) {
            int i3 = this.f11312m - 1;
            this.f11312m = i3;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f11307h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_ARRAY but was " + C0() + X());
    }

    public void r() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 2) {
            int i3 = this.f11312m - 1;
            this.f11312m = i3;
            this.n[i3] = null;
            int[] iArr = this.o;
            int i4 = i3 - 1;
            iArr[i4] = iArr[i4] + 1;
            this.f11307h = 0;
            return;
        }
        throw new IllegalStateException("Expected END_OBJECT but was " + C0() + X());
    }

    public String toString() {
        return getClass().getSimpleName() + X();
    }

    public void x0() throws IOException {
        int i2 = this.f11307h;
        if (i2 == 0) {
            i2 = o();
        }
        if (i2 == 7) {
            this.f11307h = 0;
            int[] iArr = this.o;
            int i3 = this.f11312m - 1;
            iArr[i3] = iArr[i3] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + C0() + X());
    }
}
