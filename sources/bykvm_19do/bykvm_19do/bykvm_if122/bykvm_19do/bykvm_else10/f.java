package bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f798c = "f";
    private final Set<String> a;
    private Looper b;

    /* loaded from: classes.dex */
    public class a implements Runnable {
        public a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    /* loaded from: classes.dex */
    public class b implements Runnable {
        public final /* synthetic */ String a;

        public b(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements Runnable {
        public c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onGranted();
        }
    }

    /* loaded from: classes.dex */
    public class d implements Runnable {
        public final /* synthetic */ String a;

        public d(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.onDenied(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static /* synthetic */ class e {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.values().length];
            a = iArr;
            try {
                iArr[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.GRANTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.DENIED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.NOT_FOUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public f() {
        this.a = new HashSet(1);
        this.b = Looper.getMainLooper();
    }

    public f(@NonNull Looper looper) {
        this.a = new HashSet(1);
        this.b = Looper.getMainLooper();
        this.b = looper;
    }

    public final void a(@NonNull String[] strArr) {
        synchronized (this) {
            Collections.addAll(this.a, strArr);
        }
    }

    public final boolean a(@NonNull String str, int i2) {
        boolean a2;
        synchronized (this) {
            a2 = a(str, i2 == 0 ? bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.GRANTED : bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d.DENIED);
        }
        return a2;
    }

    public final boolean a(@NonNull String str, bykvm_19do.bykvm_19do.bykvm_if122.bykvm_19do.bykvm_else10.d dVar) {
        boolean z;
        Handler handler;
        Runnable aVar;
        Handler handler2;
        Runnable bVar;
        synchronized (this) {
            this.a.remove(str);
            int i2 = e.a[dVar.ordinal()];
            z = true;
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 == 3) {
                        if (!shouldIgnorePermissionNotFound(str)) {
                            handler2 = new Handler(this.b);
                            bVar = new d(str);
                        } else if (this.a.isEmpty()) {
                            handler = new Handler(this.b);
                            aVar = new c();
                            handler.post(aVar);
                        }
                    }
                    z = false;
                } else {
                    handler2 = new Handler(this.b);
                    bVar = new b(str);
                }
                handler2.post(bVar);
            } else {
                if (this.a.isEmpty()) {
                    handler = new Handler(this.b);
                    aVar = new a();
                    handler.post(aVar);
                }
                z = false;
            }
        }
        return z;
    }

    public abstract void onDenied(String str);

    public abstract void onGranted();

    public boolean shouldIgnorePermissionNotFound(String str) {
        synchronized (this) {
            String str2 = f798c;
            Log.d(str2, "Permission not found: " + str);
        }
        return true;
    }
}
