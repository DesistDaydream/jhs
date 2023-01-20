package e.j.d.f;

import android.text.TextUtils;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Map;

/* loaded from: classes2.dex */
public final class y {
    @GuardedBy("this")
    private int a = 0;
    @GuardedBy("this")
    private final Map<Integer, e.j.a.b.j.l<Void>> b = new ArrayMap();
    @GuardedBy("itself")

    /* renamed from: c  reason: collision with root package name */
    private final u f11269c;

    public y(u uVar) {
        this.f11269c = uVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
        if (r4 == 1) goto L13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0038, code lost:
        r7.A(r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003f, code lost:
        if (com.google.firebase.iid.FirebaseInstanceId.C() == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0041, code lost:
        android.util.Log.d("FirebaseInstanceId", "unsubscribe operation succeeded");
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(com.google.firebase.iid.FirebaseInstanceId r7, java.lang.String r8) throws java.io.IOException {
        /*
            java.lang.String r0 = "FirebaseInstanceId"
            java.lang.String r1 = "!"
            java.lang.String[] r8 = r8.split(r1)
            int r1 = r8.length
            r2 = 1
            r3 = 2
            if (r1 != r3) goto La5
            r1 = 0
            r3 = r8[r1]
            r8 = r8[r2]
            r4 = -1
            int r5 = r3.hashCode()     // Catch: java.io.IOException -> L56
            r6 = 83
            if (r5 == r6) goto L2a
            r6 = 85
            if (r5 == r6) goto L20
            goto L33
        L20:
            java.lang.String r5 = "U"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L56
            if (r3 == 0) goto L33
            r4 = 1
            goto L33
        L2a:
            java.lang.String r5 = "S"
            boolean r3 = r3.equals(r5)     // Catch: java.io.IOException -> L56
            if (r3 == 0) goto L33
            r4 = 0
        L33:
            if (r4 == 0) goto L47
            if (r4 == r2) goto L38
            goto La5
        L38:
            r7.A(r8)     // Catch: java.io.IOException -> L56
            boolean r7 = com.google.firebase.iid.FirebaseInstanceId.C()     // Catch: java.io.IOException -> L56
            if (r7 == 0) goto La5
            java.lang.String r7 = "unsubscribe operation succeeded"
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L56
            goto La5
        L47:
            r7.x(r8)     // Catch: java.io.IOException -> L56
            boolean r7 = com.google.firebase.iid.FirebaseInstanceId.C()     // Catch: java.io.IOException -> L56
            if (r7 == 0) goto La5
            java.lang.String r7 = "subscribe operation succeeded"
            android.util.Log.d(r0, r7)     // Catch: java.io.IOException -> L56
            goto La5
        L56:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            java.lang.String r2 = "SERVICE_NOT_AVAILABLE"
            boolean r8 = r2.equals(r8)
            if (r8 != 0) goto L7d
            java.lang.String r8 = r7.getMessage()
            java.lang.String r2 = "INTERNAL_SERVER_ERROR"
            boolean r8 = r2.equals(r8)
            if (r8 == 0) goto L70
            goto L7d
        L70:
            java.lang.String r8 = r7.getMessage()
            if (r8 != 0) goto L7c
            java.lang.String r7 = "Topic operation failed without exception message. Will retry Topic operation."
            android.util.Log.e(r0, r7)
            return r1
        L7c:
            throw r7
        L7d:
            java.lang.String r7 = r7.getMessage()
            java.lang.String r8 = java.lang.String.valueOf(r7)
            int r8 = r8.length()
            int r8 = r8 + 53
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r8)
            java.lang.String r8 = "Topic operation failed: "
            r2.append(r8)
            r2.append(r7)
            java.lang.String r7 = ". Will retry Topic operation."
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            android.util.Log.e(r0, r7)
            return r1
        La5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.d.f.y.d(com.google.firebase.iid.FirebaseInstanceId, java.lang.String):boolean");
    }

    @Nullable
    @GuardedBy("this")
    private final String e() {
        String b;
        synchronized (this.f11269c) {
            b = this.f11269c.b();
        }
        if (TextUtils.isEmpty(b)) {
            return null;
        }
        String[] split = b.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
        if (split.length <= 1 || TextUtils.isEmpty(split[1])) {
            return null;
        }
        return split[1];
    }

    private final synchronized boolean f(String str) {
        synchronized (this.f11269c) {
            String b = this.f11269c.b();
            String valueOf = String.valueOf(str);
            if (b.startsWith(valueOf.length() != 0 ? Constants.ACCEPT_TIME_SEPARATOR_SP.concat(valueOf) : new String(Constants.ACCEPT_TIME_SEPARATOR_SP))) {
                String valueOf2 = String.valueOf(str);
                this.f11269c.d(b.substring((valueOf2.length() != 0 ? Constants.ACCEPT_TIME_SEPARATOR_SP.concat(valueOf2) : new String(Constants.ACCEPT_TIME_SEPARATOR_SP)).length()));
                return true;
            }
            return false;
        }
    }

    public final synchronized e.j.a.b.j.k<Void> a(String str) {
        String b;
        e.j.a.b.j.l<Void> lVar;
        synchronized (this.f11269c) {
            b = this.f11269c.b();
            u uVar = this.f11269c;
            StringBuilder sb = new StringBuilder(String.valueOf(b).length() + 1 + String.valueOf(str).length());
            sb.append(b);
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(str);
            uVar.d(sb.toString());
        }
        lVar = new e.j.a.b.j.l<>();
        this.b.put(Integer.valueOf(this.a + (TextUtils.isEmpty(b) ? 0 : b.split(Constants.ACCEPT_TIME_SEPARATOR_SP).length - 1)), lVar);
        return lVar.a();
    }

    public final synchronized boolean b() {
        return e() != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x000c, code lost:
        if (com.google.firebase.iid.FirebaseInstanceId.C() == false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
        android.util.Log.d("FirebaseInstanceId", "topic sync succeeded");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0016, code lost:
        return true;
     */
    @androidx.annotation.WorkerThread
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(com.google.firebase.iid.FirebaseInstanceId r5) throws java.io.IOException {
        /*
            r4 = this;
        L0:
            monitor-enter(r4)
            java.lang.String r0 = r4.e()     // Catch: java.lang.Throwable -> L42
            r1 = 1
            if (r0 != 0) goto L17
            boolean r5 = com.google.firebase.iid.FirebaseInstanceId.C()     // Catch: java.lang.Throwable -> L42
            if (r5 == 0) goto L15
            java.lang.String r5 = "FirebaseInstanceId"
            java.lang.String r0 = "topic sync succeeded"
            android.util.Log.d(r5, r0)     // Catch: java.lang.Throwable -> L42
        L15:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            return r1
        L17:
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            boolean r2 = d(r5, r0)
            if (r2 != 0) goto L20
            r5 = 0
            return r5
        L20:
            monitor-enter(r4)
            java.util.Map<java.lang.Integer, e.j.a.b.j.l<java.lang.Void>> r2 = r4.b     // Catch: java.lang.Throwable -> L3f
            int r3 = r4.a     // Catch: java.lang.Throwable -> L3f
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch: java.lang.Throwable -> L3f
            java.lang.Object r2 = r2.remove(r3)     // Catch: java.lang.Throwable -> L3f
            e.j.a.b.j.l r2 = (e.j.a.b.j.l) r2     // Catch: java.lang.Throwable -> L3f
            r4.f(r0)     // Catch: java.lang.Throwable -> L3f
            int r0 = r4.a     // Catch: java.lang.Throwable -> L3f
            int r0 = r0 + r1
            r4.a = r0     // Catch: java.lang.Throwable -> L3f
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            if (r2 == 0) goto L0
            r0 = 0
            r2.setResult(r0)
            goto L0
        L3f:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L3f
            throw r5
        L42:
            r5 = move-exception
            monitor-exit(r4)     // Catch: java.lang.Throwable -> L42
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: e.j.d.f.y.c(com.google.firebase.iid.FirebaseInstanceId):boolean");
    }
}
