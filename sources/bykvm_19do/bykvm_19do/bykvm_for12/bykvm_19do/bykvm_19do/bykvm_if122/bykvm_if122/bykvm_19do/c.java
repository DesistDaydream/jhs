package bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do;

import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.e;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.f;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.t;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.b0;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.s;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.u;
import bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.z;
import com.bytedance.msdk.adapter.util.ThreadHelper;
import com.caverock.androidsvg.SVG;
import com.xiaomi.mipush.sdk.Constants;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.IDN;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class c {
    public static final byte[] a;
    public static final String[] b = new String[0];

    /* renamed from: c  reason: collision with root package name */
    public static final b0 f542c;

    /* renamed from: d  reason: collision with root package name */
    private static final f f543d;

    /* renamed from: e  reason: collision with root package name */
    private static final f f544e;

    /* renamed from: f  reason: collision with root package name */
    private static final f f545f;

    /* renamed from: g  reason: collision with root package name */
    private static final f f546g;

    /* renamed from: h  reason: collision with root package name */
    private static final f f547h;

    /* renamed from: i  reason: collision with root package name */
    public static final Charset f548i;

    /* renamed from: j  reason: collision with root package name */
    private static final Charset f549j;

    /* renamed from: k  reason: collision with root package name */
    private static final Charset f550k;

    /* renamed from: l  reason: collision with root package name */
    private static final Charset f551l;

    /* renamed from: m  reason: collision with root package name */
    private static final Charset f552m;
    public static final TimeZone n;
    public static final Comparator<String> o;
    private static final Pattern p;

    /* loaded from: classes.dex */
    public static final class a implements Comparator<String> {
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(String str, String str2) {
            return str.compareTo(str2);
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements ThreadFactory {
        public final /* synthetic */ String a;
        public final /* synthetic */ boolean b;

        public b(String str, boolean z) {
            this.a = str;
            this.b = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, ThreadHelper.THREDA_NAME_PREFIX + this.a);
            thread.setDaemon(this.b);
            thread.setPriority(10);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        a = bArr;
        f542c = b0.a(null, bArr);
        z.a((u) null, bArr);
        f543d = f.a("efbbbf");
        f544e = f.a("feff");
        f545f = f.a("fffe");
        f546g = f.a("0000ffff");
        f547h = f.a("ffff0000");
        f548i = Charset.forName("UTF-8");
        Charset.forName("ISO-8859-1");
        f549j = Charset.forName(k.b.a.a.c.f16035d);
        f550k = Charset.forName(k.b.a.a.c.f16036e);
        f551l = Charset.forName("UTF-32BE");
        f552m = Charset.forName("UTF-32LE");
        n = TimeZone.getTimeZone("GMT");
        o = new a();
        p = Pattern.compile("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
    }

    public static int a(char c2) {
        if (c2 < '0' || c2 > '9') {
            char c3 = 'a';
            if (c2 < 'a' || c2 > 'f') {
                c3 = 'A';
                if (c2 < 'A' || c2 > 'F') {
                    return -1;
                }
            }
            return (c2 - c3) + 10;
        }
        return c2 - '0';
    }

    public static int a(String str, int i2, int i3, char c2) {
        while (i2 < i3) {
            if (str.charAt(i2) == c2) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, int i2, int i3, String str2) {
        while (i2 < i3) {
            if (str2.indexOf(str.charAt(i2)) != -1) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int a(String str, long j2, TimeUnit timeUnit) {
        int i2 = (j2 > 0L ? 1 : (j2 == 0L ? 0 : -1));
        if (i2 < 0) {
            throw new IllegalArgumentException(str + " < 0");
        }
        Objects.requireNonNull(timeUnit, "unit == null");
        long millis = timeUnit.toMillis(j2);
        if (millis > 2147483647L) {
            throw new IllegalArgumentException(str + " too large.");
        } else if (millis != 0 || i2 <= 0) {
            return (int) millis;
        } else {
            throw new IllegalArgumentException(str + " too small.");
        }
    }

    public static int a(Comparator<String> comparator, String[] strArr, String str) {
        int length = strArr.length;
        for (int i2 = 0; i2 < length; i2++) {
            if (comparator.compare(strArr[i2], str) == 0) {
                return i2;
            }
        }
        return -1;
    }

    public static AssertionError a(String str, Exception exc) {
        return (AssertionError) new AssertionError(str).initCause(exc);
    }

    public static String a(s sVar, boolean z) {
        String g2;
        if (sVar.g().contains(Constants.COLON_SEPARATOR)) {
            g2 = "[" + sVar.g() + "]";
        } else {
            g2 = sVar.g();
        }
        if (z || sVar.j() != s.c(sVar.m())) {
            return g2 + Constants.COLON_SEPARATOR + sVar.j();
        }
        return g2;
    }

    public static String a(String str) {
        if (str.contains(Constants.COLON_SEPARATOR)) {
            InetAddress a2 = (str.startsWith("[") && str.endsWith("]")) ? a(str, 1, str.length() - 1) : a(str, 0, str.length());
            if (a2 != null) {
                byte[] address = a2.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError("Invalid IPv6 address: '" + str + "'");
            }
        } else {
            try {
                String lowerCase = IDN.toASCII(str).toLowerCase(Locale.US);
                if (!lowerCase.isEmpty()) {
                    if (!b(lowerCase)) {
                        return lowerCase;
                    }
                }
            } catch (IllegalArgumentException unused) {
            }
        }
        return null;
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.US, str, objArr);
    }

    private static String a(byte[] bArr) {
        int i2 = 0;
        int i3 = -1;
        int i4 = 0;
        int i5 = 0;
        while (i4 < bArr.length) {
            int i6 = i4;
            while (i6 < 16 && bArr[i6] == 0 && bArr[i6 + 1] == 0) {
                i6 += 2;
            }
            int i7 = i6 - i4;
            if (i7 > i5 && i7 >= 4) {
                i3 = i4;
                i5 = i7;
            }
            i4 = i6 + 2;
        }
        bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
        while (i2 < bArr.length) {
            if (i2 == i3) {
                cVar.writeByte(58);
                i2 += i5;
                if (i2 == 16) {
                    cVar.writeByte(58);
                }
            } else {
                if (i2 > 0) {
                    cVar.writeByte(58);
                }
                cVar.e(((bArr[i2] & 255) << 8) | (bArr[i2 + 1] & 255));
                i2 += 2;
            }
        }
        return cVar.n();
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.InetAddress a(java.lang.String r12, int r13, int r14) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = -1
            r3 = 0
            r4 = 0
            r5 = -1
            r6 = -1
        L9:
            r7 = 0
            if (r13 >= r14) goto L7c
            if (r4 != r0) goto L10
            goto L91
        L10:
            int r8 = r13 + 2
            r9 = 1
            if (r8 > r14) goto L2a
            java.lang.String r10 = "::"
            r11 = 2
            boolean r10 = r12.regionMatches(r13, r10, r3, r11)
            if (r10 == 0) goto L2a
            if (r5 == r2) goto L22
            goto L91
        L22:
            int r4 = r4 + 2
            r5 = r4
            if (r8 != r14) goto L28
            goto L7c
        L28:
            r6 = r8
            goto L4c
        L2a:
            if (r4 == 0) goto L4b
            java.lang.String r8 = ":"
            boolean r8 = r12.regionMatches(r13, r8, r3, r9)
            if (r8 == 0) goto L37
            int r13 = r13 + 1
            goto L4b
        L37:
            java.lang.String r8 = "."
            boolean r13 = r12.regionMatches(r13, r8, r3, r9)
            if (r13 == 0) goto L91
            int r13 = r4 + (-2)
            boolean r12 = a(r12, r6, r14, r1, r13)
            if (r12 != 0) goto L48
            goto L91
        L48:
            int r4 = r4 + 2
            goto L7c
        L4b:
            r6 = r13
        L4c:
            r13 = r6
            r8 = 0
        L4e:
            if (r13 >= r14) goto L61
            char r10 = r12.charAt(r13)
            int r10 = a(r10)
            if (r10 != r2) goto L5b
            goto L61
        L5b:
            int r8 = r8 << 4
            int r8 = r8 + r10
            int r13 = r13 + 1
            goto L4e
        L61:
            int r10 = r13 - r6
            if (r10 == 0) goto L91
            r11 = 4
            if (r10 <= r11) goto L69
            goto L91
        L69:
            int r7 = r4 + 1
            int r10 = r8 >>> 8
            r10 = r10 & 255(0xff, float:3.57E-43)
            byte r10 = (byte) r10
            byte r10 = (byte) r10
            r1[r4] = r10
            r4 = r8 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            byte r4 = (byte) r4
            r1[r7] = r4
            int r4 = r7 + 1
            goto L9
        L7c:
            if (r4 == r0) goto L8d
            if (r5 != r2) goto L81
            goto L91
        L81:
            int r12 = r4 - r5
            int r13 = 16 - r12
            java.lang.System.arraycopy(r1, r5, r1, r13, r12)
            int r0 = r0 - r4
            int r0 = r0 + r5
            java.util.Arrays.fill(r1, r5, r0, r3)
        L8d:
            java.net.InetAddress r7 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L92
        L91:
            return r7
        L92:
            java.lang.AssertionError r12 = new java.lang.AssertionError
            r12.<init>()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_if122.bykvm_19do.c.a(java.lang.String, int, int):java.net.InetAddress");
    }

    public static Charset a(e eVar, Charset charset) throws IOException {
        f fVar = f543d;
        if (eVar.a(0L, fVar)) {
            eVar.skip(fVar.e());
            return f548i;
        }
        f fVar2 = f544e;
        if (eVar.a(0L, fVar2)) {
            eVar.skip(fVar2.e());
            return f549j;
        }
        f fVar3 = f545f;
        if (eVar.a(0L, fVar3)) {
            eVar.skip(fVar3.e());
            return f550k;
        }
        f fVar4 = f546g;
        if (eVar.a(0L, fVar4)) {
            eVar.skip(fVar4.e());
            return f551l;
        }
        f fVar5 = f547h;
        if (eVar.a(0L, fVar5)) {
            eVar.skip(fVar5.e());
            return f552m;
        }
        return charset;
    }

    public static <T> List<T> a(List<T> list) {
        return Collections.unmodifiableList(new ArrayList(list));
    }

    public static <T> List<T> a(T... tArr) {
        return Collections.unmodifiableList(Arrays.asList((Object[]) tArr.clone()));
    }

    public static ThreadFactory a(String str, boolean z) {
        return new b(str, z);
    }

    public static void a(long j2, long j3, long j4) {
        if ((j3 | j4) < 0 || j3 > j2 || j2 - j3 < j4) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (RuntimeException e2) {
                throw e2;
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Socket socket) {
        if (socket != null) {
            try {
                socket.close();
            } catch (AssertionError e2) {
                if (!a(e2)) {
                    throw e2;
                }
            } catch (RuntimeException | Exception unused) {
            }
        }
    }

    public static boolean a(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s sVar, int i2, TimeUnit timeUnit) {
        try {
            return b(sVar, i2, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static boolean a(AssertionError assertionError) {
        return (assertionError.getCause() == null || assertionError.getMessage() == null || !assertionError.getMessage().contains("getsockname failed")) ? false : true;
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    private static boolean a(String str, int i2, int i3, byte[] bArr, int i4) {
        int i5 = i4;
        while (i2 < i3) {
            if (i5 == bArr.length) {
                return false;
            }
            if (i5 != i4) {
                if (str.charAt(i2) != '.') {
                    return false;
                }
                i2++;
            }
            int i6 = i2;
            int i7 = 0;
            while (i6 < i3) {
                char charAt = str.charAt(i6);
                if (charAt < '0' || charAt > '9') {
                    break;
                } else if ((i7 == 0 && i2 != i6) || (i7 = ((i7 * 10) + charAt) - 48) > 255) {
                    return false;
                } else {
                    i6++;
                }
            }
            if (i6 - i2 == 0) {
                return false;
            }
            bArr[i5] = (byte) i7;
            i5++;
            i2 = i6;
        }
        return i5 == i4 + 4;
    }

    public static String[] a(Comparator<? super String> comparator, String[] strArr, String[] strArr2) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            int length = strArr2.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                } else if (comparator.compare(str, strArr2[i2]) == 0) {
                    arrayList.add(str);
                    break;
                } else {
                    i2++;
                }
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String[] a(String[] strArr, String str) {
        int length = strArr.length + 1;
        String[] strArr2 = new String[length];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        strArr2[length - 1] = str;
        return strArr2;
    }

    public static int b(String str, int i2, int i3) {
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static boolean b(bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.s sVar, int i2, TimeUnit timeUnit) throws IOException {
        long nanoTime = System.nanoTime();
        long c2 = sVar.b().d() ? sVar.b().c() - nanoTime : Long.MAX_VALUE;
        sVar.b().a(Math.min(c2, timeUnit.toNanos(i2)) + nanoTime);
        try {
            bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c cVar = new bykvm_19do.bykvm_19do.bykvm_for12.bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.c();
            while (sVar.a(cVar, SVG.A) != -1) {
                cVar.j();
            }
            int i3 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            t b2 = sVar.b();
            if (i3 == 0) {
                b2.a();
            } else {
                b2.a(c2 + nanoTime);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i4 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            t b3 = sVar.b();
            if (i4 == 0) {
                b3.a();
            } else {
                b3.a(c2 + nanoTime);
            }
            return false;
        } catch (Throwable th) {
            int i5 = (c2 > Long.MAX_VALUE ? 1 : (c2 == Long.MAX_VALUE ? 0 : -1));
            t b4 = sVar.b();
            if (i5 == 0) {
                b4.a();
            } else {
                b4.a(c2 + nanoTime);
            }
            throw th;
        }
    }

    private static boolean b(String str) {
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127 || " #%/:?@[\\]".indexOf(charAt) != -1) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(Comparator<String> comparator, String[] strArr, String[] strArr2) {
        if (strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0) {
            return false;
        }
        for (String str : strArr) {
            for (String str2 : strArr2) {
                if (comparator.compare(str, str2) == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int c(String str) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            char charAt = str.charAt(i2);
            if (charAt <= 31 || charAt >= 127) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static int c(String str, int i2, int i3) {
        while (true) {
            i3--;
            if (i3 < i2) {
                return i2;
            }
            char charAt = str.charAt(i3);
            if (charAt != '\t' && charAt != '\n' && charAt != '\f' && charAt != '\r' && charAt != ' ') {
                return i3 + 1;
            }
        }
    }

    public static String d(String str, int i2, int i3) {
        int b2 = b(str, i2, i3);
        return str.substring(b2, c(str, b2, i3));
    }

    public static boolean d(String str) {
        return p.matcher(str).matches();
    }
}
