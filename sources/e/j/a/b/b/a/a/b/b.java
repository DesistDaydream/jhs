package e.j.a.b.b.a.a.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.xiaomi.mipush.sdk.Constants;
import e.j.a.b.c.r.a0;
import e.j.a.b.c.x.d0;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;

/* loaded from: classes2.dex */
public class b {

    /* renamed from: c  reason: collision with root package name */
    private static final Lock f10117c = new ReentrantLock();
    @GuardedBy("sLk")

    /* renamed from: d  reason: collision with root package name */
    private static b f10118d;
    private final Lock a = new ReentrantLock();
    @GuardedBy("mLk")
    private final SharedPreferences b;

    @d0
    private b(Context context) {
        this.b = context.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @e.j.a.b.c.m.a
    public static b b(Context context) {
        a0.k(context);
        Lock lock = f10117c;
        lock.lock();
        try {
            if (f10118d == null) {
                f10118d = new b(context.getApplicationContext());
            }
            b bVar = f10118d;
            lock.unlock();
            return bVar;
        } catch (Throwable th) {
            f10117c.unlock();
            throw th;
        }
    }

    private final void g(String str, String str2) {
        this.a.lock();
        try {
            this.b.edit().putString(str, str2).apply();
        } finally {
            this.a.unlock();
        }
    }

    private static String h(String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 1 + String.valueOf(str2).length());
        sb.append(str);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(str2);
        return sb.toString();
    }

    @d0
    @Nullable
    private final GoogleSignInAccount i(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInAccount", str))) != null) {
            try {
                return GoogleSignInAccount.zaa(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @d0
    @Nullable
    private final GoogleSignInOptions j(String str) {
        String k2;
        if (!TextUtils.isEmpty(str) && (k2 = k(h("googleSignInOptions", str))) != null) {
            try {
                return GoogleSignInOptions.zab(k2);
            } catch (JSONException unused) {
            }
        }
        return null;
    }

    @Nullable
    private final String k(String str) {
        this.a.lock();
        try {
            return this.b.getString(str, null);
        } finally {
            this.a.unlock();
        }
    }

    private final void m(String str) {
        this.a.lock();
        try {
            this.b.edit().remove(str).apply();
        } finally {
            this.a.unlock();
        }
    }

    @e.j.a.b.c.m.a
    public void a() {
        this.a.lock();
        try {
            this.b.edit().clear().apply();
        } finally {
            this.a.unlock();
        }
    }

    @e.j.a.b.c.m.a
    @Nullable
    public GoogleSignInAccount c() {
        return i(k("defaultGoogleSignInAccount"));
    }

    @e.j.a.b.c.m.a
    @Nullable
    public GoogleSignInOptions d() {
        return j(k("defaultGoogleSignInAccount"));
    }

    @e.j.a.b.c.m.a
    @Nullable
    public String e() {
        return k("refreshToken");
    }

    @e.j.a.b.c.m.a
    public void f(GoogleSignInAccount googleSignInAccount, GoogleSignInOptions googleSignInOptions) {
        a0.k(googleSignInAccount);
        a0.k(googleSignInOptions);
        g("defaultGoogleSignInAccount", googleSignInAccount.zab());
        a0.k(googleSignInAccount);
        a0.k(googleSignInOptions);
        String zab = googleSignInAccount.zab();
        g(h("googleSignInAccount", zab), googleSignInAccount.zac());
        g(h("googleSignInOptions", zab), googleSignInOptions.zae());
    }

    public final void l() {
        String k2 = k("defaultGoogleSignInAccount");
        m("defaultGoogleSignInAccount");
        if (TextUtils.isEmpty(k2)) {
            return;
        }
        m(h("googleSignInAccount", k2));
        m(h("googleSignInOptions", k2));
    }
}
