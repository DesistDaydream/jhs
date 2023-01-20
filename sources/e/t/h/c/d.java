package e.t.h.c;

import android.view.View;
import android.view.Window;
import e.t.u.y;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\b"}, d2 = {"Lcom/vector/compat/window/WindowOptImpl;", "Lcom/vector/compat/window/WindowOpt;", "()V", "enterFullScreen", "", "window", "Landroid/view/Window;", "quitFullScreen", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d implements b {
    @Override // e.t.h.c.b
    public void a(@k.e.a.d Window window) {
        View decorView = window.getDecorView();
        int i2 = e.t.a.a().e() ? 5632 : 4608;
        int systemUiVisibility = decorView.getSystemUiVisibility();
        if ((systemUiVisibility & 256) != 0) {
            i2 |= 256;
        }
        if (y.a(23) && (systemUiVisibility & 8192) != 0) {
            i2 |= 8192;
        }
        decorView.setSystemUiVisibility(i2);
    }

    @Override // e.t.h.c.b
    public void b(@k.e.a.d Window window) {
        View decorView = window.getDecorView();
        int systemUiVisibility = decorView.getSystemUiVisibility();
        int i2 = (systemUiVisibility & 256) != 0 ? 5894 : 5638;
        if (y.a(23) && (systemUiVisibility & 8192) != 0) {
            i2 |= 8192;
        }
        decorView.setSystemUiVisibility(i2);
    }
}
