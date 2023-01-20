package bykvm_19do.bykvm_19do.bykvm_19do;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

/* loaded from: classes.dex */
public final class u0 {

    /* loaded from: classes.dex */
    public static class a implements Runnable {
        private final Runnable a;
        private final String b;

        /* renamed from: c  reason: collision with root package name */
        private final String f171c = Log.getStackTraceString(new RuntimeException("origin stacktrace"));

        public a(Runnable runnable, String str) {
            this.a = runnable;
            this.b = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e2) {
                e2.printStackTrace();
                t0.b("TrackerDr", "Thread:" + this.b + " exception\n" + this.f171c, e2);
            }
        }
    }

    public static void a(String str, Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            str = "TrackerDr";
        }
        new Thread(new a(runnable, str), str).start();
    }

    public static boolean a(Context context, String str) {
        return context.getPackageManager().getPackageInfo(str, 128) != null;
    }
}
