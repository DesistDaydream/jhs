package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do;

import com.umeng.analytics.pro.cb;
import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/* loaded from: classes.dex */
public class f implements Serializable, Comparable<f> {

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f277d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: e  reason: collision with root package name */
    public static final f f278e = a(new byte[0]);
    public final byte[] a;
    public transient int b;

    /* renamed from: c  reason: collision with root package name */
    public transient String f279c;

    public f(byte[] bArr) {
        this.a = bArr;
    }

    private static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    throw new IllegalArgumentException("Unexpected hex digit: " + c2);
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int a(String str, int i2) {
        int length = str.length();
        int i3 = 0;
        int i4 = 0;
        while (i3 < length) {
            if (i4 == i2) {
                return i3;
            }
            int codePointAt = str.codePointAt(i3);
            if ((Character.isISOControl(codePointAt) && codePointAt != 10 && codePointAt != 13) || codePointAt == 65533) {
                return -1;
            }
            i4++;
            i3 += Character.charCount(codePointAt);
        }
        return str.length();
    }

    public static f a(String str) {
        if (str != null) {
            if (str.length() % 2 != 0) {
                throw new IllegalArgumentException("Unexpected hex string: " + str);
            }
            int length = str.length() / 2;
            byte[] bArr = new byte[length];
            for (int i2 = 0; i2 < length; i2++) {
                int i3 = i2 * 2;
                bArr[i2] = (byte) (a(str.charAt(i3 + 1)) + (a(str.charAt(i3)) << 4));
            }
            return a(bArr);
        }
        throw new IllegalArgumentException("hex == null");
    }

    public static f a(byte... bArr) {
        if (bArr != null) {
            return new f((byte[]) bArr.clone());
        }
        throw new IllegalArgumentException("data == null");
    }

    private f b(String str) {
        try {
            return a(MessageDigest.getInstance(str).digest(this.a));
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }

    public static f c(String str) {
        if (str != null) {
            f fVar = new f(str.getBytes(u.a));
            fVar.f279c = str;
            return fVar;
        }
        throw new IllegalArgumentException("s == null");
    }

    public byte a(int i2) {
        return this.a[i2];
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002a A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x002c A[ORIG_RETURN, RETURN] */
    @Override // java.lang.Comparable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public int compareTo(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f r9) {
        /*
            r8 = this;
            int r0 = r8.e()
            int r1 = r9.e()
            int r2 = java.lang.Math.min(r0, r1)
            r3 = 0
            r4 = 0
        Le:
            r5 = 1
            if (r4 >= r2) goto L25
            byte r6 = r8.a(r4)
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r7 = r9.a(r4)
            r7 = r7 & 255(0xff, float:3.57E-43)
            if (r6 != r7) goto L22
            int r4 = r4 + 1
            goto Le
        L22:
            if (r6 >= r7) goto L2a
            goto L2c
        L25:
            if (r0 != r1) goto L28
            goto L2d
        L28:
            if (r0 < r1) goto L2c
        L2a:
            r3 = 1
            goto L2d
        L2c:
            r3 = -1
        L2d:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f.compareTo(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f):int");
    }

    public f a(int i2, int i3) {
        if (i2 >= 0) {
            byte[] bArr = this.a;
            if (i3 > bArr.length) {
                throw new IllegalArgumentException("endIndex > length(" + this.a.length + ")");
            }
            int i4 = i3 - i2;
            if (i4 >= 0) {
                if (i2 == 0 && i3 == bArr.length) {
                    return this;
                }
                byte[] bArr2 = new byte[i4];
                System.arraycopy(bArr, i2, bArr2, 0, i4);
                return new f(bArr2);
            }
            throw new IllegalArgumentException("endIndex < beginIndex");
        }
        throw new IllegalArgumentException("beginIndex < 0");
    }

    public String a() {
        return b.a(this.a);
    }

    public void a(c cVar) {
        byte[] bArr = this.a;
        cVar.write(bArr, 0, bArr.length);
    }

    public boolean a(int i2, f fVar, int i3, int i4) {
        return fVar.a(i3, this.a, i2, i4);
    }

    public boolean a(int i2, byte[] bArr, int i3, int i4) {
        if (i2 >= 0) {
            byte[] bArr2 = this.a;
            if (i2 <= bArr2.length - i4 && i3 >= 0 && i3 <= bArr.length - i4 && u.a(bArr2, i2, bArr, i3, i4)) {
                return true;
            }
        }
        return false;
    }

    public String b() {
        byte[] bArr = this.a;
        char[] cArr = new char[bArr.length * 2];
        int i2 = 0;
        for (byte b : bArr) {
            int i3 = i2 + 1;
            char[] cArr2 = f277d;
            cArr[i2] = cArr2[(b >> 4) & 15];
            i2 = i3 + 1;
            cArr[i3] = cArr2[b & cb.f7124m];
        }
        return new String(cArr);
    }

    public final boolean b(f fVar) {
        return a(0, fVar, 0, fVar.e());
    }

    public f c() {
        return b("SHA-1");
    }

    public f d() {
        return b("SHA-256");
    }

    public int e() {
        return this.a.length;
    }

    public boolean equals(Object obj) {
        if (obj != this) {
            if (!(obj instanceof f)) {
                return false;
            }
            f fVar = (f) obj;
            int e2 = fVar.e();
            byte[] bArr = this.a;
            if (e2 != bArr.length || !fVar.a(0, bArr, 0, bArr.length)) {
                return false;
            }
        }
        return true;
    }

    public f f() {
        int i2 = 0;
        while (true) {
            byte[] bArr = this.a;
            if (i2 >= bArr.length) {
                return this;
            }
            byte b = bArr[i2];
            if (b < 65 || b > 90) {
                i2++;
            } else {
                byte[] bArr2 = (byte[]) bArr.clone();
                bArr2[i2] = (byte) (b + 32);
                while (true) {
                    i2++;
                    if (i2 >= bArr2.length) {
                        return new f(bArr2);
                    }
                    byte b2 = bArr2[i2];
                    if (b2 >= 65 && b2 <= 90) {
                        bArr2[i2] = (byte) (b2 + 32);
                    }
                }
            }
        }
    }

    public byte[] g() {
        return (byte[]) this.a.clone();
    }

    public String h() {
        String str = this.f279c;
        if (str != null) {
            return str;
        }
        String str2 = new String(this.a, u.a);
        this.f279c = str2;
        return str2;
    }

    public int hashCode() {
        int i2 = this.b;
        if (i2 != 0) {
            return i2;
        }
        int hashCode = Arrays.hashCode(this.a);
        this.b = hashCode;
        return hashCode;
    }

    public String toString() {
        String replace;
        StringBuilder sb;
        if (this.a.length == 0) {
            return "[size=0]";
        }
        String h2 = h();
        int a = a(h2, 64);
        if (a != -1) {
            replace = h2.substring(0, a).replace("\\", "\\\\").replace("\n", "\\n").replace("\r", "\\r");
            if (a < h2.length()) {
                sb = new StringBuilder();
                sb.append("[size=");
                sb.append(this.a.length);
                sb.append(" text=");
                sb.append(replace);
                sb.append("…]");
            } else {
                sb = new StringBuilder();
                sb.append("[text=");
                sb.append(replace);
                sb.append("]");
            }
        } else if (this.a.length <= 64) {
            sb = new StringBuilder();
            sb.append("[hex=");
            replace = b();
            sb.append(replace);
            sb.append("]");
        } else {
            sb = new StringBuilder();
            sb.append("[size=");
            sb.append(this.a.length);
            sb.append(" hex=");
            replace = a(0, 64).b();
            sb.append(replace);
            sb.append("…]");
        }
        return sb.toString();
    }
}
