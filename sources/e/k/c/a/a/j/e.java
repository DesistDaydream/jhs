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
public class e {
    private static final String a = "SSFSecureX509SingleInstance";
    private static volatile k b;

    private e() {
    }

    @SuppressLint({"NewApi"})
    public static k a(Context context) throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        Objects.requireNonNull(context, "context is null");
        e.k.c.a.a.j.q.e.b(context);
        if (b == null) {
            synchronized (e.class) {
                if (b == null) {
                    InputStream o = e.k.c.a.a.j.q.a.o(context);
                    if (o == null) {
                        e.k.c.a.a.j.q.i.e(a, "get assets bks");
                        o = context.getAssets().open("hmsrootcas.bks");
                    } else {
                        e.k.c.a.a.j.q.i.e(a, "get files bks");
                    }
                    b = new k(o, "", true);
                    new e.k.c.a.a.j.q.g().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, context);
                }
            }
        }
        return b;
    }

    public static void b(InputStream inputStream) {
        String str = a;
        e.k.c.a.a.j.q.i.e(str, "update bks");
        long currentTimeMillis = System.currentTimeMillis();
        if (inputStream != null && b != null) {
            b = new k(inputStream, "", true);
            e.k.c.a.a.j.q.i.b(str, "updateBks: new SecureX509TrustManager cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            d.b(b);
            c.b(b);
        }
        e.k.c.a.a.j.q.i.b(str, "update bks cost : " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
    }
}
