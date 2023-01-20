package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1;

import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class d {
    private final String a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f347c;

    /* renamed from: d  reason: collision with root package name */
    private int f348d;

    /* renamed from: e  reason: collision with root package name */
    private int f349e;

    /* renamed from: f  reason: collision with root package name */
    private int f350f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f351g;

    public d(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 >= this.b) {
            throw new IllegalStateException("Malformed DN: " + this.a);
        }
        char[] cArr = this.f351g;
        char c2 = cArr[i2];
        if (c2 >= '0' && c2 <= '9') {
            i3 = c2 - '0';
        } else if (c2 >= 'a' && c2 <= 'f') {
            i3 = c2 - 'W';
        } else if (c2 < 'A' || c2 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.a);
        } else {
            i3 = c2 - '7';
        }
        char c3 = cArr[i5];
        if (c3 >= '0' && c3 <= '9') {
            i4 = c3 - '0';
        } else if (c3 >= 'a' && c3 <= 'f') {
            i4 = c3 - 'W';
        } else if (c3 < 'A' || c3 > 'F') {
            throw new IllegalStateException("Malformed DN: " + this.a);
        } else {
            i4 = c3 - '7';
        }
        return (i3 << 4) + i4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a0, code lost:
        return new java.lang.String(r0, r1, r9.f350f - r1);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String a() {
        /*
            r9 = this;
            int r0 = r9.f347c
            r9.f348d = r0
            r9.f349e = r0
        L6:
            int r0 = r9.f347c
            int r1 = r9.b
            if (r0 < r1) goto L1a
            char[] r0 = r9.f351g
            int r1 = r9.f348d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f349e
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
            goto La0
        L1a:
            char[] r1 = r9.f351g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L5c
            if (r2 == r5) goto L51
            r5 = 92
            if (r2 == r5) goto L3e
            if (r2 == r4) goto L51
            if (r2 == r3) goto L51
            int r2 = r9.f349e
            int r3 = r2 + 1
            r9.f349e = r3
            char r3 = r1[r0]
            char r3 = (char) r3
            r1[r2] = r3
            goto L4c
        L3e:
            int r0 = r9.f349e
            int r2 = r0 + 1
            r9.f349e = r2
            char r2 = r9.b()
            r1[r0] = r2
            int r0 = r9.f347c
        L4c:
            int r0 = r0 + 1
            r9.f347c = r0
            goto L6
        L51:
            int r0 = r9.f348d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f349e
            int r3 = r3 - r0
            r2.<init>(r1, r0, r3)
            goto La0
        L5c:
            int r2 = r9.f349e
            r9.f350f = r2
            int r0 = r0 + 1
            r9.f347c = r0
            int r0 = r2 + 1
            r9.f349e = r0
            char r0 = (char) r6
            r1[r2] = r0
        L6b:
            int r1 = r9.f347c
            int r2 = r9.b
            if (r1 >= r2) goto L84
            char[] r7 = r9.f351g
            char r8 = r7[r1]
            if (r8 != r6) goto L84
            int r2 = r9.f349e
            int r8 = r2 + 1
            r9.f349e = r8
            r7[r2] = r0
            int r1 = r1 + 1
            r9.f347c = r1
            goto L6b
        L84:
            if (r1 == r2) goto L94
            char[] r0 = r9.f351g
            char r2 = r0[r1]
            if (r2 == r3) goto L94
            char r2 = r0[r1]
            if (r2 == r4) goto L94
            char r0 = r0[r1]
            if (r0 != r5) goto L6
        L94:
            char[] r0 = r9.f351g
            int r1 = r9.f348d
            java.lang.String r2 = new java.lang.String
            int r3 = r9.f350f
            int r3 = r3 - r1
            r2.<init>(r0, r1, r3)
        La0:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_case1.d.a():java.lang.String");
    }

    private char b() {
        int i2 = this.f347c + 1;
        this.f347c = i2;
        if (i2 == this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        char[] cArr = this.f351g;
        char c2 = cArr[i2];
        if (c2 != ' ' && c2 != '%' && c2 != '\\' && c2 != '_' && c2 != '\"' && c2 != '#') {
            switch (c2) {
                case '*':
                case '+':
                case ',':
                    break;
                default:
                    switch (c2) {
                        case ';':
                        case '<':
                        case '=':
                        case '>':
                            break;
                        default:
                            return c();
                    }
            }
        }
        return cArr[i2];
    }

    private char c() {
        int i2;
        int a = a(this.f347c);
        this.f347c++;
        if (a >= 128) {
            if (a < 192 || a > 247) {
                return k.b.a.a.o.e.a;
            }
            if (a <= 223) {
                a &= 31;
                i2 = 1;
            } else if (a <= 239) {
                i2 = 2;
                a &= 15;
            } else {
                i2 = 3;
                a &= 7;
            }
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = this.f347c + 1;
                this.f347c = i4;
                if (i4 == this.b || this.f351g[i4] != '\\') {
                    return k.b.a.a.o.e.a;
                }
                int i5 = i4 + 1;
                this.f347c = i5;
                int a2 = a(i5);
                this.f347c++;
                if ((a2 & 192) != 128) {
                    return k.b.a.a.o.e.a;
                }
                a = (a << 6) + (a2 & 63);
            }
        }
        return (char) a;
    }

    private String d() {
        int i2 = this.f347c;
        if (i2 + 4 >= this.b) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.f348d = i2;
        while (true) {
            this.f347c = i2 + 1;
            i2 = this.f347c;
            if (i2 == this.b) {
                break;
            }
            char[] cArr = this.f351g;
            if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                break;
            } else if (cArr[i2] == ' ') {
                this.f349e = i2;
                do {
                    this.f347c = i2 + 1;
                    i2 = this.f347c;
                    if (i2 >= this.b) {
                        break;
                    }
                } while (this.f351g[i2] == ' ');
            } else if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                cArr[i2] = (char) (cArr[i2] + ' ');
            }
        }
        this.f349e = i2;
        int i3 = this.f349e;
        int i4 = this.f348d;
        int i5 = i3 - i4;
        if (i5 < 5 || (i5 & 1) == 0) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        int i6 = i5 / 2;
        byte[] bArr = new byte[i6];
        int i7 = i4 + 1;
        for (int i8 = 0; i8 < i6; i8++) {
            bArr[i8] = (byte) a(i7);
            i7 += 2;
        }
        return new String(this.f351g, this.f348d, i5);
    }

    private String e() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        char[] cArr;
        while (true) {
            i2 = this.f347c;
            i3 = this.b;
            if (i2 >= i3 || this.f351g[i2] != ' ') {
                break;
            }
            this.f347c = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.f348d = i2;
        do {
            this.f347c = i2 + 1;
            i2 = this.f347c;
            i4 = this.b;
            if (i2 >= i4) {
                break;
            }
            cArr = this.f351g;
            if (cArr[i2] == '=') {
                break;
            }
        } while (cArr[i2] != ' ');
        if (i2 >= i4) {
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        this.f349e = i2;
        if (this.f351g[i2] == ' ') {
            while (true) {
                i5 = this.f347c;
                i6 = this.b;
                if (i5 >= i6) {
                    break;
                }
                char[] cArr2 = this.f351g;
                if (cArr2[i5] == '=' || cArr2[i5] != ' ') {
                    break;
                }
                this.f347c = i5 + 1;
            }
            if (this.f351g[i5] != '=' || i5 == i6) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
        int i7 = this.f347c;
        do {
            this.f347c = i7 + 1;
            i7 = this.f347c;
            if (i7 >= this.b) {
                break;
            }
        } while (this.f351g[i7] == ' ');
        int i8 = this.f349e;
        int i9 = this.f348d;
        if (i8 - i9 > 4) {
            char[] cArr3 = this.f351g;
            if (cArr3[i9 + 3] == '.' && (cArr3[i9] == 'O' || cArr3[i9] == 'o')) {
                int i10 = i9 + 1;
                if (cArr3[i10] == 'I' || cArr3[i10] == 'i') {
                    int i11 = i9 + 2;
                    if (cArr3[i11] == 'D' || cArr3[i11] == 'd') {
                        this.f348d = i9 + 4;
                    }
                }
            }
        }
        char[] cArr4 = this.f351g;
        int i12 = this.f348d;
        return new String(cArr4, i12, this.f349e - i12);
    }

    private String f() {
        int i2 = this.f347c + 1;
        this.f347c = i2;
        this.f348d = i2;
        while (true) {
            this.f349e = i2;
            int i3 = this.f347c;
            if (i3 == this.b) {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
            char[] cArr = this.f351g;
            if (cArr[i3] == '\"') {
                do {
                    this.f347c = i3 + 1;
                    i3 = this.f347c;
                    if (i3 >= this.b) {
                        break;
                    }
                } while (this.f351g[i3] == ' ');
                char[] cArr2 = this.f351g;
                int i4 = this.f348d;
                return new String(cArr2, i4, this.f349e - i4);
            }
            if (cArr[i3] == '\\') {
                cArr[this.f349e] = b();
            } else {
                cArr[this.f349e] = cArr[i3];
            }
            this.f347c++;
            i2 = this.f349e + 1;
        }
    }

    public String a(String str) {
        this.f347c = 0;
        this.f348d = 0;
        this.f349e = 0;
        this.f350f = 0;
        this.f351g = this.a.toCharArray();
        String e2 = e();
        if (e2 == null) {
            return null;
        }
        do {
            int i2 = this.f347c;
            if (i2 == this.b) {
                return null;
            }
            char c2 = this.f351g[i2];
            String a = c2 != '\"' ? c2 != '#' ? (c2 == '+' || c2 == ',' || c2 == ';') ? "" : a() : d() : f();
            if (str.equalsIgnoreCase(e2)) {
                return a;
            }
            int i3 = this.f347c;
            if (i3 >= this.b) {
                return null;
            }
            char[] cArr = this.f351g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f347c = i3 + 1;
            e2 = e();
        } while (e2 != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
