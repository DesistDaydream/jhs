package e.j.a.c.s;

import android.os.Build;
import androidx.annotation.RestrictTo;
import java.util.Locale;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class e {
    private static final String a = "lge";
    private static final String b = "samsung";

    /* renamed from: c  reason: collision with root package name */
    private static final String f10976c = "meizu";

    private e() {
    }

    public static boolean a() {
        return b() || d();
    }

    public static boolean b() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(a);
    }

    public static boolean c() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(f10976c);
    }

    public static boolean d() {
        return Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals(b);
    }
}
