package com.bytedance.sdk.openadsdk.api.plugin.a;

import javax.security.auth.x500.X500Principal;
import k.b.a.a.o.e;

/* loaded from: classes.dex */
public final class b {
    private final String a;
    private final int b;

    /* renamed from: c  reason: collision with root package name */
    private int f2403c;

    /* renamed from: d  reason: collision with root package name */
    private int f2404d;

    /* renamed from: e  reason: collision with root package name */
    private int f2405e;

    /* renamed from: f  reason: collision with root package name */
    private int f2406f;

    /* renamed from: g  reason: collision with root package name */
    private char[] f2407g;

    public b(X500Principal x500Principal) {
        String name = x500Principal.getName("RFC2253");
        this.a = name;
        this.b = name.length();
    }

    private String a() {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        while (true) {
            i2 = this.f2403c;
            i3 = this.b;
            if (i2 >= i3 || this.f2407g[i2] != ' ') {
                break;
            }
            this.f2403c = i2 + 1;
        }
        if (i2 == i3) {
            return null;
        }
        this.f2404d = i2;
        this.f2403c = i2 + 1;
        while (true) {
            i4 = this.f2403c;
            i5 = this.b;
            if (i4 >= i5) {
                break;
            }
            char[] cArr = this.f2407g;
            if (cArr[i4] == '=' || cArr[i4] == ' ') {
                break;
            }
            this.f2403c = i4 + 1;
        }
        if (i4 < i5) {
            this.f2405e = i4;
            if (this.f2407g[i4] == ' ') {
                while (true) {
                    i6 = this.f2403c;
                    i7 = this.b;
                    if (i6 >= i7) {
                        break;
                    }
                    char[] cArr2 = this.f2407g;
                    if (cArr2[i6] == '=' || cArr2[i6] != ' ') {
                        break;
                    }
                    this.f2403c = i6 + 1;
                }
                if (this.f2407g[i6] != '=' || i6 == i7) {
                    throw new IllegalStateException("Unexpected end of DN: " + this.a);
                }
            }
            this.f2403c++;
            while (true) {
                int i8 = this.f2403c;
                if (i8 >= this.b || this.f2407g[i8] != ' ') {
                    break;
                }
                this.f2403c = i8 + 1;
            }
            int i9 = this.f2405e;
            int i10 = this.f2404d;
            if (i9 - i10 > 4) {
                char[] cArr3 = this.f2407g;
                if (cArr3[i10 + 3] == '.' && ((cArr3[i10] == 'O' || cArr3[i10] == 'o') && ((cArr3[i10 + 1] == 'I' || cArr3[i10 + 1] == 'i') && (cArr3[i10 + 2] == 'D' || cArr3[i10 + 2] == 'd')))) {
                    this.f2404d = i10 + 4;
                }
            }
            char[] cArr4 = this.f2407g;
            int i11 = this.f2404d;
            return new String(cArr4, i11, this.f2405e - i11);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private String b() {
        int i2 = this.f2403c + 1;
        this.f2403c = i2;
        this.f2404d = i2;
        this.f2405e = i2;
        while (true) {
            int i3 = this.f2403c;
            if (i3 != this.b) {
                char[] cArr = this.f2407g;
                if (cArr[i3] == '\"') {
                    this.f2403c = i3 + 1;
                    while (true) {
                        int i4 = this.f2403c;
                        if (i4 >= this.b || this.f2407g[i4] != ' ') {
                            break;
                        }
                        this.f2403c = i4 + 1;
                    }
                    char[] cArr2 = this.f2407g;
                    int i5 = this.f2404d;
                    return new String(cArr2, i5, this.f2405e - i5);
                }
                if (cArr[i3] == '\\') {
                    cArr[this.f2405e] = e();
                } else {
                    cArr[this.f2405e] = cArr[i3];
                }
                this.f2403c++;
                this.f2405e++;
            } else {
                throw new IllegalStateException("Unexpected end of DN: " + this.a);
            }
        }
    }

    private String c() {
        int i2;
        int i3 = this.f2403c;
        if (i3 + 4 < this.b) {
            this.f2404d = i3;
            this.f2403c = i3 + 1;
            while (true) {
                i2 = this.f2403c;
                if (i2 == this.b) {
                    break;
                }
                char[] cArr = this.f2407g;
                if (cArr[i2] == '+' || cArr[i2] == ',' || cArr[i2] == ';') {
                    break;
                } else if (cArr[i2] == ' ') {
                    this.f2405e = i2;
                    this.f2403c = i2 + 1;
                    while (true) {
                        int i4 = this.f2403c;
                        if (i4 >= this.b || this.f2407g[i4] != ' ') {
                            break;
                        }
                        this.f2403c = i4 + 1;
                    }
                } else {
                    if (cArr[i2] >= 'A' && cArr[i2] <= 'F') {
                        cArr[i2] = (char) (cArr[i2] + ' ');
                    }
                    this.f2403c = i2 + 1;
                }
            }
            this.f2405e = i2;
            int i5 = this.f2405e;
            int i6 = this.f2404d;
            int i7 = i5 - i6;
            if (i7 >= 5 && (i7 & 1) != 0) {
                int i8 = i7 / 2;
                byte[] bArr = new byte[i8];
                int i9 = i6 + 1;
                for (int i10 = 0; i10 < i8; i10++) {
                    bArr[i10] = (byte) a(i9);
                    i9 += 2;
                }
                return new String(this.f2407g, this.f2404d, i7);
            }
            throw new IllegalStateException("Unexpected end of DN: " + this.a);
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a3, code lost:
        return new java.lang.String(r1, r2, r8.f2406f - r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String d() {
        /*
            r8 = this;
            int r0 = r8.f2403c
            r8.f2404d = r0
            r8.f2405e = r0
        L6:
            int r0 = r8.f2403c
            int r1 = r8.b
            if (r0 < r1) goto L19
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f2407g
            int r2 = r8.f2404d
            int r3 = r8.f2405e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L19:
            char[] r1 = r8.f2407g
            char r2 = r1[r0]
            r3 = 44
            r4 = 43
            r5 = 59
            r6 = 32
            if (r2 == r6) goto L60
            if (r2 == r5) goto L53
            r5 = 92
            if (r2 == r5) goto L40
            if (r2 == r4) goto L53
            if (r2 == r3) goto L53
            int r2 = r8.f2405e
            int r3 = r2 + 1
            r8.f2405e = r3
            char r3 = r1[r0]
            r1[r2] = r3
            int r0 = r0 + 1
            r8.f2403c = r0
            goto L6
        L40:
            int r0 = r8.f2405e
            int r2 = r0 + 1
            r8.f2405e = r2
            char r2 = r8.e()
            r1[r0] = r2
            int r0 = r8.f2403c
            int r0 = r0 + 1
            r8.f2403c = r0
            goto L6
        L53:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f2407g
            int r2 = r8.f2404d
            int r3 = r8.f2405e
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        L60:
            int r2 = r8.f2405e
            r8.f2406f = r2
            int r0 = r0 + 1
            r8.f2403c = r0
            int r0 = r2 + 1
            r8.f2405e = r0
            r1[r2] = r6
        L6e:
            int r0 = r8.f2403c
            int r1 = r8.b
            if (r0 >= r1) goto L87
            char[] r2 = r8.f2407g
            char r7 = r2[r0]
            if (r7 != r6) goto L87
            int r1 = r8.f2405e
            int r7 = r1 + 1
            r8.f2405e = r7
            r2[r1] = r6
            int r0 = r0 + 1
            r8.f2403c = r0
            goto L6e
        L87:
            if (r0 == r1) goto L97
            char[] r1 = r8.f2407g
            char r2 = r1[r0]
            if (r2 == r3) goto L97
            char r2 = r1[r0]
            if (r2 == r4) goto L97
            char r0 = r1[r0]
            if (r0 != r5) goto L6
        L97:
            java.lang.String r0 = new java.lang.String
            char[] r1 = r8.f2407g
            int r2 = r8.f2404d
            int r3 = r8.f2406f
            int r3 = r3 - r2
            r0.<init>(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.api.plugin.a.b.d():java.lang.String");
    }

    private char e() {
        int i2 = this.f2403c + 1;
        this.f2403c = i2;
        if (i2 != this.b) {
            char[] cArr = this.f2407g;
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
                                return f();
                        }
                }
            }
            return cArr[i2];
        }
        throw new IllegalStateException("Unexpected end of DN: " + this.a);
    }

    private char f() {
        int i2;
        int i3;
        int a = a(this.f2403c);
        this.f2403c++;
        if (a < 128) {
            return (char) a;
        }
        if (a < 192 || a > 247) {
            return e.a;
        }
        if (a <= 223) {
            i3 = a & 31;
            i2 = 1;
        } else if (a <= 239) {
            i2 = 2;
            i3 = a & 15;
        } else {
            i2 = 3;
            i3 = a & 7;
        }
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = this.f2403c + 1;
            this.f2403c = i5;
            if (i5 == this.b || this.f2407g[i5] != '\\') {
                return e.a;
            }
            int i6 = i5 + 1;
            this.f2403c = i6;
            int a2 = a(i6);
            this.f2403c++;
            if ((a2 & 192) != 128) {
                return e.a;
            }
            i3 = (i3 << 6) + (a2 & 63);
        }
        return (char) i3;
    }

    private int a(int i2) {
        int i3;
        int i4;
        int i5 = i2 + 1;
        if (i5 < this.b) {
            char[] cArr = this.f2407g;
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
        throw new IllegalStateException("Malformed DN: " + this.a);
    }

    public String a(String str) {
        String b;
        this.f2403c = 0;
        this.f2404d = 0;
        this.f2405e = 0;
        this.f2406f = 0;
        this.f2407g = this.a.toCharArray();
        String a = a();
        if (a == null) {
            return null;
        }
        do {
            int i2 = this.f2403c;
            if (i2 == this.b) {
                return null;
            }
            char c2 = this.f2407g[i2];
            if (c2 == '\"') {
                b = b();
            } else if (c2 != '#') {
                b = (c2 == '+' || c2 == ',' || c2 == ';') ? "" : d();
            } else {
                b = c();
            }
            if (str.equalsIgnoreCase(a)) {
                return b;
            }
            int i3 = this.f2403c;
            if (i3 >= this.b) {
                return null;
            }
            char[] cArr = this.f2407g;
            if (cArr[i3] != ',' && cArr[i3] != ';' && cArr[i3] != '+') {
                throw new IllegalStateException("Malformed DN: " + this.a);
            }
            this.f2403c = i3 + 1;
            a = a();
        } while (a != null);
        throw new IllegalStateException("Malformed DN: " + this.a);
    }
}
