package e.t.h.c.f;

import android.view.View;
import android.view.Window;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import e.t.h.c.f.a;
import k.e.a.d;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0014\u0010\t\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u0014\u0010\r\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/vector/compat/window/status/StatusBarOptImpl;", "Lcom/vector/compat/window/status/StatusBarOpt;", "()V", "flat", "", "window", "Landroid/view/Window;", "setTextColorDark", "setTextColorLight", "addSystemUiVisibility", "Landroid/view/View;", "visibility", "", "clearSystemUiVisibility", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class c implements a {
    private final void f(View view, int i2) {
        view.setSystemUiVisibility(i2 | view.getSystemUiVisibility());
    }

    private final void g(View view, int i2) {
        view.setSystemUiVisibility(((~i2) & view.getSystemUiVisibility()) | 0);
    }

    @Override // e.t.h.c.f.a
    public void a(@d Window window, @ColorInt int i2) {
        a.C0406a.b(this, window, i2);
    }

    @Override // e.t.h.c.f.a
    public void b(@d Window window) {
        f(window.getDecorView(), 1024);
        window.addFlags(Integer.MIN_VALUE);
        window.setStatusBarColor(0);
    }

    @Override // e.t.h.c.f.a
    @RequiresApi(23)
    public void c(@d Window window) {
        f(window.getDecorView(), 8192);
    }

    @Override // e.t.h.c.f.a
    public void d(@d Window window, @ColorInt int i2) {
        a.C0406a.a(this, window, i2);
    }

    @Override // e.t.h.c.f.a
    @RequiresApi(23)
    public void e(@d Window window) {
        g(window.getDecorView(), 8192);
    }
}
