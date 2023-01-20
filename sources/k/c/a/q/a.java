package k.c.a.q;

import android.util.Log;
import java.util.logging.Level;
import k.c.a.f;

/* loaded from: classes4.dex */
public class a implements f {
    private static final boolean b;
    private final String a;

    static {
        boolean z = false;
        try {
            if (Class.forName("android.util.Log") != null) {
                z = true;
            }
        } catch (ClassNotFoundException unused) {
        }
        b = z;
    }

    public a(String str) {
        this.a = str;
    }

    public static boolean c() {
        return b;
    }

    private int d(Level level) {
        int intValue = level.intValue();
        if (intValue < 800) {
            return intValue < 500 ? 2 : 3;
        } else if (intValue < 900) {
            return 4;
        } else {
            return intValue < 1000 ? 5 : 6;
        }
    }

    @Override // k.c.a.f
    public void a(Level level, String str, Throwable th) {
        if (level != Level.OFF) {
            int d2 = d(level);
            String str2 = this.a;
            Log.println(d2, str2, str + "\n" + Log.getStackTraceString(th));
        }
    }

    @Override // k.c.a.f
    public void b(Level level, String str) {
        if (level != Level.OFF) {
            Log.println(d(level), this.a, str);
        }
    }
}
