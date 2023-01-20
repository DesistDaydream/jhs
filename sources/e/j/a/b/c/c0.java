package e.j.a.b.c;

import android.content.Context;
import android.os.RemoteException;
import android.os.StrictMode;
import android.util.Log;
import com.google.android.gms.common.zzk;
import com.google.android.gms.dynamite.DynamiteModule;
import e.j.a.b.c.r.k1;
import e.j.a.b.c.r.l1;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;

@CheckReturnValue
/* loaded from: classes2.dex */
public final class c0 {
    private static volatile k1 a;
    private static final Object b = new Object();

    /* renamed from: c */
    private static Context f10119c;

    public static l0 a(String str, e0 e0Var, boolean z, boolean z2) {
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            return d(str, e0Var, z, z2);
        } finally {
            StrictMode.setThreadPolicy(allowThreadDiskReads);
        }
    }

    public static final /* synthetic */ String b(boolean z, String str, e0 e0Var) throws Exception {
        boolean z2 = true;
        return l0.e(str, e0Var, z, (z || !d(str, e0Var, true, false).a) ? false : false);
    }

    public static synchronized void c(Context context) {
        synchronized (c0.class) {
            if (f10119c != null) {
                Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
            } else if (context != null) {
                f10119c = context.getApplicationContext();
            }
        }
    }

    private static l0 d(String str, e0 e0Var, boolean z, boolean z2) {
        try {
            if (a == null) {
                e.j.a.b.c.r.a0.k(f10119c);
                synchronized (b) {
                    if (a == null) {
                        a = l1.b(DynamiteModule.e(f10119c, DynamiteModule.f2674l, "com.google.android.gms.googlecertificates").d("com.google.android.gms.common.GoogleCertificatesImpl"));
                    }
                }
            }
            e.j.a.b.c.r.a0.k(f10119c);
            try {
                if (a.m(new zzk(str, e0Var, z, z2), e.j.a.b.d.f.b0(f10119c.getPackageManager()))) {
                    return l0.f();
                }
                return l0.c(new Callable(z, str, e0Var) { // from class: e.j.a.b.c.d0
                    private final boolean a;
                    private final String b;

                    /* renamed from: c */
                    private final e0 f10120c;

                    {
                        this.a = z;
                        this.b = str;
                        this.f10120c = e0Var;
                    }

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        return c0.b(this.a, this.b, this.f10120c);
                    }
                });
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
                return l0.b("module call", e2);
            }
        } catch (DynamiteModule.LoadingException e3) {
            Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e3);
            String valueOf = String.valueOf(e3.getMessage());
            return l0.b(valueOf.length() != 0 ? "module init: ".concat(valueOf) : new String("module init: "), e3);
        }
    }
}
