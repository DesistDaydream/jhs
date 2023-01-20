package k.c.a;

import android.os.Looper;
import java.io.PrintStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes4.dex */
public interface f {

    /* loaded from: classes4.dex */
    public static class a {
        public static f a() {
            if (k.c.a.q.a.c() && b() != null) {
                return new k.c.a.q.a("EventBus");
            }
            return new c();
        }

        public static Object b() {
            try {
                return Looper.getMainLooper();
            } catch (RuntimeException unused) {
                return null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class b implements f {
        public final Logger a;

        public b(String str) {
            this.a = Logger.getLogger(str);
        }

        @Override // k.c.a.f
        public void a(Level level, String str, Throwable th) {
            this.a.log(level, str, th);
        }

        @Override // k.c.a.f
        public void b(Level level, String str) {
            this.a.log(level, str);
        }
    }

    /* loaded from: classes4.dex */
    public static class c implements f {
        @Override // k.c.a.f
        public void a(Level level, String str, Throwable th) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
            th.printStackTrace(System.out);
        }

        @Override // k.c.a.f
        public void b(Level level, String str) {
            PrintStream printStream = System.out;
            printStream.println("[" + level + "] " + str);
        }
    }

    void a(Level level, String str, Throwable th);

    void b(Level level, String str);
}
