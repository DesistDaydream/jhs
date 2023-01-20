package e.j.a.c.z;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;

/* loaded from: classes2.dex */
public class k {
    private k() {
    }

    @NonNull
    public static e a(int i2) {
        if (i2 != 0) {
            if (i2 != 1) {
                return b();
            }
            return new f();
        }
        return new n();
    }

    @NonNull
    public static e b() {
        return new n();
    }

    @NonNull
    public static g c() {
        return new g();
    }

    public static void d(@NonNull View view, float f2) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            ((j) background).m0(f2);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof j) {
            f(view, (j) background);
        }
    }

    public static void f(@NonNull View view, @NonNull j jVar) {
        if (jVar.a0()) {
            jVar.r0(e.j.a.c.s.t.i(view));
        }
    }
}
