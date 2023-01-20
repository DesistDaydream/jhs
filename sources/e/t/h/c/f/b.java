package e.t.h.c.f;

import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import e.t.h.c.f.a;
import k.e.a.d;
import kotlin.Metadata;

@RequiresApi(30)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0004¨\u0006\f"}, d2 = {"Lcom/vector/compat/window/status/StatusBarOptImpl30;", "Lcom/vector/compat/window/status/StatusBarOpt;", "()V", "flat", "", "window", "Landroid/view/Window;", "setTextColorDark", "setTextColorLight", "unsetSystemUiFlag", "systemUiFlag", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b implements a {
    @Override // e.t.h.c.f.a
    public void a(@d Window window, @ColorInt int i2) {
        a.C0406a.b(this, window, i2);
    }

    @Override // e.t.h.c.f.a
    public void b(@d Window window) {
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    @Override // e.t.h.c.f.a
    public void c(@d Window window) {
        WindowInsetsController insetsController = window.getInsetsController();
        if (insetsController == null) {
            return;
        }
        f(window, 8192);
        insetsController.setSystemBarsAppearance(8, 8);
    }

    @Override // e.t.h.c.f.a
    public void d(@d Window window, @ColorInt int i2) {
        a.C0406a.a(this, window, i2);
    }

    @Override // e.t.h.c.f.a
    public void e(@d Window window) {
        WindowInsetsController insetsController = window.getInsetsController();
        if (insetsController == null) {
            return;
        }
        insetsController.setSystemBarsAppearance(0, 8);
    }

    public final void f(@d Window window, int i2) {
        View decorView = window.getDecorView();
        decorView.setSystemUiVisibility((~i2) & decorView.getSystemUiVisibility());
    }
}
