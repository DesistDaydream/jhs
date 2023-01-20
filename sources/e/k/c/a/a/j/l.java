package e.k.c.a.a.j;

import android.content.Context;
import android.net.http.SslError;
import android.webkit.SslErrorHandler;
import e.k.c.a.a.j.m;
import java.security.cert.X509Certificate;

/* loaded from: classes2.dex */
public class l {
    private static final String a = "WebViewSSLCheck";

    public static void a(SslErrorHandler sslErrorHandler, SslError sslError, Context context) {
        b(sslErrorHandler, sslError, null, context, null);
    }

    public static void b(SslErrorHandler sslErrorHandler, SslError sslError, String str, Context context, m.a aVar) {
        String str2 = a;
        e.k.c.a.a.j.q.i.e(str2, " error type : " + sslError.getPrimaryError() + " , cn is : " + sslError.getCertificate().getIssuedTo().getCName());
        X509Certificate a2 = e.k.c.a.a.j.q.d.a(sslError.getCertificate());
        X509Certificate a3 = new e.k.c.a.a.j.q.l(context).a();
        e.k.c.a.a.j.q.i.b(str2, "checkServerCertificateNew: error certificate is : " + a2);
        if (e.k.c.a.a.j.q.d.e(a3, a2)) {
            e.k.c.a.a.j.q.i.e(str2, "checkServerCertificateNew: proceed");
            if (aVar != null) {
                aVar.a(context, str);
                return;
            } else {
                sslErrorHandler.proceed();
                return;
            }
        }
        e.k.c.a.a.j.q.i.d(str2, "checkServerCertificateNew: cancel");
        if (aVar != null) {
            aVar.b(context, str);
        } else {
            sslErrorHandler.cancel();
        }
    }

    public static boolean c(String str, SslError sslError) {
        return d(e.k.c.a.a.j.q.d.b(str), sslError);
    }

    public static boolean d(X509Certificate x509Certificate, SslError sslError) {
        return e.k.c.a.a.j.q.d.e(x509Certificate, e.k.c.a.a.j.q.d.a(sslError.getCertificate()));
    }
}
