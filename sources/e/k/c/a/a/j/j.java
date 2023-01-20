package e.k.c.a.a.j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.Objects;

/* loaded from: classes2.dex */
public class j {
    private static final String a = "SecureX509SingleInstance";
    private static volatile k b;

    private j() {
    }

    @SuppressLint({"NewApi"})
    public static k a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        long currentTimeMillis = System.currentTimeMillis();
        Objects.requireNonNull(context, "context is null");
        e.k.c.a.a.j.q.e.b(context);
        if (b == null) {
            synchronized (j.class) {
                if (b == null) {
                    InputStream o = e.k.c.a.a.j.q.a.o(context);
                    if (o == null) {
                        e.k.c.a.a.j.q.i.e(a, "get assets bks");
                        o = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.k.c.a.a.j.q.i.e(a, "get files bks");
                    }
                    b = new k(o, "");
                    new e.k.c.a.a.j.q.f().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                }
            }
        }
        String str = a;
        e.k.c.a.a.j.q.i.b(str, "SecureX509TrustManager getInstance: cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        return b;
    }

    public static void b(InputStream inputStream) {
        String str = a;
        e.k.c.a.a.j.q.i.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && b != null) {
            b = new k(inputStream, "");
            h.b(b);
            g.b(b);
        }
        e.k.c.a.a.j.q.i.e(str, "SecureX509TrustManager update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
