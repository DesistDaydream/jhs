package e.t.h.c.e;

import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.RequiresApi;
import com.vector.util.Screen;
import e.t.l.j;
import k.e.a.d;
import kotlin.Metadata;

@RequiresApi(30)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/vector/compat/window/navigation/NavigationBarImpl30;", "Lcom/vector/compat/window/navigation/NavigationBarOpt;", "()V", "setColor", "", "window", "Landroid/view/Window;", "color", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class a implements c {
    @Override // e.t.h.c.e.c
    public void a(@d Window window, int i2) {
        if (Screen.c()) {
            window.addFlags(Integer.MIN_VALUE);
            window.setNavigationBarColor(i2);
            WindowInsetsController insetsController = window.getInsetsController();
            if (insetsController == null) {
                return;
            }
            if (j.f(i2)) {
                insetsController.setSystemBarsAppearance(16, 16);
            } else {
                insetsController.setSystemBarsAppearance(0, 16);
            }
        }
    }
}
