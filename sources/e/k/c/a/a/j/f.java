package e.k.c.a.a.j;

import android.os.Build;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import org.conscrypt.NativeCrypto;

/* loaded from: classes2.dex */
public abstract class f {
    private static final String a = "SSLUtil";
    private static final String b = "TLSv1.3";

    /* renamed from: c  reason: collision with root package name */
    private static final String f11907c = "TLSv1.2";

    /* renamed from: d  reason: collision with root package name */
    private static final String f11908d = "TLS";

    /* renamed from: e  reason: collision with root package name */
    private static final String f11909e = "TLSv1";

    /* renamed from: f  reason: collision with root package name */
    private static final String[] f11910f = {"TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA"};

    /* renamed from: g  reason: collision with root package name */
    private static final String[] f11911g = {"TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384"};

    /* renamed from: h  reason: collision with root package name */
    private static final String[] f11912h = {"TLS_RSA", "CBC", "TEA", "SHA0", k.b.a.a.m.f.a, "MD4", "RIPEMD", "NULL", "RC4", "DES", "DESX", "DES40", "RC2", "MD5", "ANON", NativeCrypto.TLS_EMPTY_RENEGOTIATION_INFO_SCSV};

    public static String[] a(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledCipherSuites();
    }

    public static String[] b(SSLSocket sSLSocket) {
        return sSLSocket.getEnabledProtocols();
    }

    public static void c(SSLSocket sSLSocket) {
        String[] enabledProtocols;
        for (String str : sSLSocket.getEnabledProtocols()) {
            e.k.c.a.a.j.q.i.e(a, "new enable protocols is : " + str);
        }
        for (String str2 : sSLSocket.getEnabledCipherSuites()) {
            e.k.c.a.a.j.q.i.e(a, "new cipher suites is : " + str2);
        }
    }

    public static boolean d(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        return e(sSLSocket, f11912h);
    }

    public static boolean e(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        int length = enabledCipherSuites.length;
        int i2 = 0;
        while (true) {
            boolean z = true;
            if (i2 >= length) {
                break;
            }
            String str = enabledCipherSuites[i2];
            String upperCase = str.toUpperCase(Locale.ENGLISH);
            int length2 = strArr.length;
            int i3 = 0;
            while (true) {
                if (i3 >= length2) {
                    z = false;
                    break;
                } else if (upperCase.contains(strArr[i3].toUpperCase(Locale.ENGLISH))) {
                    break;
                } else {
                    i3++;
                }
            }
            if (!z) {
                arrayList.add(str);
            }
            i2++;
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }

    public static void f(SSLSocket sSLSocket) {
        if (sSLSocket == null || k(sSLSocket)) {
            return;
        }
        d(sSLSocket);
    }

    public static void g(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            sSLSocket.setEnabledProtocols(new String[]{"TLSv1.3", f11907c});
        }
        if (i2 >= 16 && i2 < 29) {
            sSLSocket.setEnabledProtocols(new String[]{f11907c});
        } else if (i2 < 16) {
            sSLSocket.setEnabledProtocols(new String[]{f11909e});
        }
    }

    public static boolean h(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket != null && strArr != null) {
            try {
                sSLSocket.setEnabledProtocols(strArr);
                return true;
            } catch (Exception e2) {
                e.k.c.a.a.j.q.i.d(a, "setEnabledProtocols: exception : " + e2.getMessage());
            }
        }
        return false;
    }

    public static SSLContext i() throws NoSuchAlgorithmException {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 29) {
            return SSLContext.getInstance("TLSv1.3");
        }
        if (i2 >= 16) {
            return SSLContext.getInstance(f11907c);
        }
        return SSLContext.getInstance("TLS");
    }

    public static void j(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return;
        }
        g(sSLSocket);
        f(sSLSocket);
    }

    public static boolean k(SSLSocket sSLSocket) {
        if (sSLSocket == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            return l(sSLSocket, f11911g);
        }
        return l(sSLSocket, f11910f);
    }

    public static boolean l(SSLSocket sSLSocket, String[] strArr) {
        if (sSLSocket == null) {
            return false;
        }
        String[] enabledCipherSuites = sSLSocket.getEnabledCipherSuites();
        ArrayList arrayList = new ArrayList();
        List asList = Arrays.asList(strArr);
        for (String str : enabledCipherSuites) {
            if (asList.contains(str.toUpperCase(Locale.ENGLISH))) {
                arrayList.add(str);
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        sSLSocket.setEnabledCipherSuites((String[]) arrayList.toArray(new String[arrayList.size()]));
        return true;
    }
}
