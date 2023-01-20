package e.j.a.b.c;

import android.util.Log;
import androidx.annotation.NonNull;
import e.j.a.b.c.x.n;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;

@CheckReturnValue
/* loaded from: classes2.dex */
public class l0 {

    /* renamed from: d  reason: collision with root package name */
    private static final l0 f10157d = new l0(true, null, null);
    public final boolean a;
    private final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Throwable f10158c;

    public l0(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.a = z;
        this.b = str;
        this.f10158c = th;
    }

    public static l0 b(@NonNull String str, @NonNull Throwable th) {
        return new l0(false, str, th);
    }

    public static l0 c(Callable<String> callable) {
        return new n0(callable);
    }

    public static l0 d(@NonNull String str) {
        return new l0(false, str, null);
    }

    public static String e(String str, e0 e0Var, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", z2 ? "debug cert rejected" : "not whitelisted", str, n.a(e.j.a.b.c.x.a.c("SHA-1").digest(e0Var.b0())), Boolean.valueOf(z), "12451009.false");
    }

    public static l0 f() {
        return f10157d;
    }

    @Nullable
    public String a() {
        return this.b;
    }

    public final void g() {
        if (this.a || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.f10158c != null) {
            Log.d("GoogleCertificatesRslt", a(), this.f10158c);
        } else {
            Log.d("GoogleCertificatesRslt", a());
        }
    }
}
