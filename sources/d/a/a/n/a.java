package d.a.a.n;

import android.content.SharedPreferences;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public abstract class a<T> {
    public T a;
    public final String b;

    /* renamed from: c  reason: collision with root package name */
    private final Future<SharedPreferences> f9300c;

    public a(Future<SharedPreferences> future, String str) {
        this.f9300c = future;
        this.b = str;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0016  */
    /* JADX WARN: Removed duplicated region for block: B:15:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.content.SharedPreferences.Editor f() {
        /*
            r2 = this;
            r0 = 0
            java.util.concurrent.Future<android.content.SharedPreferences> r1 = r2.f9300c     // Catch: java.util.concurrent.ExecutionException -> La java.lang.InterruptedException -> Lf
            java.lang.Object r1 = r1.get()     // Catch: java.util.concurrent.ExecutionException -> La java.lang.InterruptedException -> Lf
            android.content.SharedPreferences r1 = (android.content.SharedPreferences) r1     // Catch: java.util.concurrent.ExecutionException -> La java.lang.InterruptedException -> Lf
            goto L14
        La:
            r1 = move-exception
            r1.printStackTrace()
            goto L13
        Lf:
            r1 = move-exception
            r1.printStackTrace()
        L13:
            r1 = r0
        L14:
            if (r1 == 0) goto L1a
            android.content.SharedPreferences$Editor r0 = r1.edit()
        L1a:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: d.a.a.n.a.f():android.content.SharedPreferences$Editor");
    }

    public T a() {
        return null;
    }

    public void b(SharedPreferences.Editor editor, T t) {
        editor.putString(this.b, (String) t);
        editor.apply();
    }

    public void c(SharedPreferences sharedPreferences) {
        T t = (T) sharedPreferences.getString(this.b, null);
        if (t == null) {
            d(a());
        } else {
            this.a = t;
        }
    }

    public void d(T t) {
        this.a = t;
        synchronized (this.f9300c) {
            SharedPreferences.Editor f2 = f();
            if (f2 != null) {
                b(f2, this.a);
            }
        }
    }

    public T e() {
        if (this.a == null) {
            synchronized (this.f9300c) {
                SharedPreferences sharedPreferences = null;
                try {
                    sharedPreferences = this.f9300c.get();
                } catch (InterruptedException e2) {
                    e2.printStackTrace();
                } catch (ExecutionException e3) {
                    e3.printStackTrace();
                }
                if (sharedPreferences != null) {
                    c(sharedPreferences);
                }
            }
        }
        return this.a;
    }
}
