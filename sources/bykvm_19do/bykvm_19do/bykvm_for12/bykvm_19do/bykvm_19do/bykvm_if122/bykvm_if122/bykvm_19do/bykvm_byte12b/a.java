package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_byte12b;

import androidx.exifinterface.media.ExifInterface;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.j;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.l;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.util.Objects;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

/* loaded from: classes.dex */
public final class a {

    /* renamed from: e */
    private static final byte[] f341e = {ExifInterface.START_CODE};

    /* renamed from: f */
    private static final String[] f342f = new String[0];

    /* renamed from: g */
    private static final String[] f343g = {"*"};

    /* renamed from: h */
    private static final a f344h = new a();
    private final AtomicBoolean a = new AtomicBoolean(false);
    private final CountDownLatch b = new CountDownLatch(1);

    /* renamed from: c */
    private byte[] f345c;

    /* renamed from: d */
    private byte[] f346d;

    public static a a() {
        return f344h;
    }

    private static String a(byte[] bArr, byte[][] bArr2, int i2) {
        int i3;
        boolean z;
        int i4;
        int i5;
        int length = bArr.length;
        int i6 = 0;
        while (i6 < length) {
            int i7 = (i6 + length) / 2;
            while (i7 > -1 && bArr[i7] != 10) {
                i7--;
            }
            int i8 = i7 + 1;
            int i9 = 1;
            while (true) {
                i3 = i8 + i9;
                if (bArr[i3] == 10) {
                    break;
                }
                i9++;
            }
            int i10 = i3 - i8;
            int i11 = i2;
            boolean z2 = false;
            int i12 = 0;
            int i13 = 0;
            while (true) {
                if (z2) {
                    i4 = 46;
                    z = false;
                } else {
                    z = z2;
                    i4 = bArr2[i11][i12] & 255;
                }
                i5 = i4 - (bArr[i8 + i13] & 255);
                if (i5 == 0) {
                    i13++;
                    i12++;
                    if (i13 == i10) {
                        break;
                    } else if (bArr2[i11].length != i12) {
                        z2 = z;
                    } else if (i11 == bArr2.length - 1) {
                        break;
                    } else {
                        i11++;
                        z2 = true;
                        i12 = -1;
                    }
                } else {
                    break;
                }
            }
            if (i5 >= 0) {
                if (i5 <= 0) {
                    int i14 = i10 - i13;
                    int length2 = bArr2[i11].length - i12;
                    while (true) {
                        i11++;
                        if (i11 >= bArr2.length) {
                            break;
                        }
                        length2 += bArr2[i11].length;
                    }
                    if (length2 >= i14) {
                        if (length2 <= i14) {
                            return new String(bArr, i8, i10, c.f548i);
                        }
                    }
                }
                i6 = i3 + 1;
            }
            length = i8 - 1;
        }
        return null;
    }

    private String[] a(String[] strArr) {
        String str;
        String str2;
        String str3;
        int i2 = 0;
        if (this.a.get() || !this.a.compareAndSet(false, true)) {
            try {
                this.b.await();
            } catch (InterruptedException unused) {
            }
        } else {
            c();
        }
        synchronized (this) {
            if (this.f345c == null) {
                throw new IllegalStateException("Unable to load publicsuffixes.gz resource from the classpath.");
            }
        }
        int length = strArr.length;
        byte[][] bArr = new byte[length];
        for (int i3 = 0; i3 < strArr.length; i3++) {
            bArr[i3] = strArr[i3].getBytes(c.f548i);
        }
        int i4 = 0;
        while (true) {
            str = null;
            if (i4 >= length) {
                str2 = null;
                break;
            }
            str2 = a(this.f345c, bArr, i4);
            if (str2 != null) {
                break;
            }
            i4++;
        }
        if (length > 1) {
            byte[][] bArr2 = (byte[][]) bArr.clone();
            for (int i5 = 0; i5 < bArr2.length - 1; i5++) {
                bArr2[i5] = f341e;
                str3 = a(this.f345c, bArr2, i5);
                if (str3 != null) {
                    break;
                }
            }
        }
        str3 = null;
        if (str3 != null) {
            while (true) {
                if (i2 >= length - 1) {
                    break;
                }
                String a = a(this.f346d, bArr, i2);
                if (a != null) {
                    str = a;
                    break;
                }
                i2++;
            }
        }
        if (str != null) {
            return ("!" + str).split("\\.");
        } else if (str2 == null && str3 == null) {
            return f343g;
        } else {
            String[] split = str2 != null ? str2.split("\\.") : f342f;
            String[] split2 = str3 != null ? str3.split("\\.") : f342f;
            return split.length > split2.length ? split : split2;
        }
    }

    private void b() throws IOException {
        InputStream resourceAsStream = a.class.getResourceAsStream(PublicSuffixDatabase.PUBLIC_SUFFIX_RESOURCE);
        if (resourceAsStream == null) {
            return;
        }
        e a = l.a(new j(l.a(resourceAsStream)));
        try {
            byte[] bArr = new byte[a.readInt()];
            a.readFully(bArr);
            byte[] bArr2 = new byte[a.readInt()];
            a.readFully(bArr2);
            synchronized (this) {
                this.f345c = bArr;
                this.f346d = bArr2;
            }
            this.b.countDown();
        } finally {
            c.a(a);
        }
    }

    private void c() {
        boolean z = false;
        while (true) {
            try {
                try {
                    b();
                    break;
                } catch (InterruptedIOException unused) {
                    z = true;
                } catch (IOException e2) {
                    bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.bykvm_try19.e.b().a(5, "Failed to read public suffix list", e2);
                    if (!z) {
                        return;
                    }
                }
            } catch (Throwable th) {
                if (z) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (!z) {
            return;
        }
        Thread.currentThread().interrupt();
    }

    public String a(String str) {
        Objects.requireNonNull(str, "domain == null");
        String[] split = IDN.toUnicode(str).split("\\.");
        String[] a = a(split);
        if (split.length != a.length || a[0].charAt(0) == '!') {
            char charAt = a[0].charAt(0);
            int length = split.length;
            int length2 = a.length;
            if (charAt != '!') {
                length2++;
            }
            StringBuilder sb = new StringBuilder();
            String[] split2 = str.split("\\.");
            for (int i2 = length - length2; i2 < split2.length; i2++) {
                sb.append(split2[i2]);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            return sb.toString();
        }
        return null;
    }
}
