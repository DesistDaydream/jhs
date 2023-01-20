package e.t.l;

import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.ColorInt;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0016\u0010\u000b\u001a\u00020\f*\u0004\u0018\u00010\u00032\b\b\u0001\u0010\r\u001a\u00020\u0001\u001a\u0014\u0010\u000e\u001a\u00020\f*\u0004\u0018\u00010\u00032\u0006\u0010\u000f\u001a\u00020\u0010\u001a\n\u0010\u0011\u001a\u00020\f*\u00020\u0003\u001a\n\u0010\u0012\u001a\u00020\f*\u00020\u0003\u001a\n\u0010\u0013\u001a\u00020\f*\u00020\u0003\u001a\u001a\u0010\u0014\u001a\u00020\f*\u00020\u00032\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\u0016\u0010\u0015\u001a\u00020\f*\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0016\u001a\u00020\u0001\u001a\u0016\u0010\u0017\u001a\u00020\f*\u0004\u0018\u00010\u00032\b\b\u0001\u0010\u0018\u001a\u00020\u0001\"(\u0010\u0002\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007\"(\u0010\b\u001a\u00020\u0001*\u00020\u00032\u0006\u0010\u0000\u001a\u00020\u00018F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u0019"}, d2 = {"value", "", "height", "Landroid/view/Window;", "getHeight", "(Landroid/view/Window;)I", "setHeight", "(Landroid/view/Window;I)V", "width", "getWidth", "setWidth", "adaptStatusBarTextColorByBackground", "", "bgColor", "clearAndSetNavigationBarColor", "res", "Lcom/vector/util/IntRes;", "enterFullScreen", "flatStatusBar", "quitFullScreen", "resize", "setStatusBarColor", "color", "setStatusBarTextColor", "textColor", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class b0 {
    public static final void a(@k.e.a.e Window window, @ColorInt int i2) {
        e.t.h.c.f.a d2 = e.t.h.c.a.a.d();
        if (window == null) {
            return;
        }
        d2.d(window, i2);
    }

    public static final void b(@k.e.a.e Window window, @k.e.a.d e.t.u.m mVar) {
        Integer a;
        if (window == null || (a = mVar.a(window.getContext())) == null) {
            return;
        }
        e.t.h.c.a.a.c().a(window, a.intValue());
    }

    public static final void c(@k.e.a.d Window window) {
        e.t.h.c.a.a.b(window);
    }

    public static final void d(@k.e.a.d Window window) {
        e.t.h.c.a.a.d().b(window);
    }

    public static final int e(@k.e.a.d Window window) {
        return window.getAttributes().height;
    }

    public static final int f(@k.e.a.d Window window) {
        return window.getAttributes().width;
    }

    public static final void g(@k.e.a.d Window window) {
        e.t.h.c.a.a.a(window);
    }

    public static final void h(@k.e.a.d Window window, int i2, int i3) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i2;
        attributes.height = i3;
        window.setAttributes(attributes);
    }

    public static final void i(@k.e.a.d Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.height = i2;
        window.setAttributes(attributes);
    }

    public static final void j(@k.e.a.e Window window, @ColorInt int i2) {
        e.t.h.c.f.a d2 = e.t.h.c.a.a.d();
        if (window == null) {
            return;
        }
        d2.a(window, i2);
    }

    public static final void k(@k.e.a.e Window window, @ColorInt int i2) {
        if (window == null) {
            return;
        }
        if (j.e(i2)) {
            e.t.h.c.a.a.d().c(window);
        } else {
            e.t.h.c.a.a.d().e(window);
        }
    }

    public static final void l(@k.e.a.d Window window, int i2) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = i2;
        window.setAttributes(attributes);
    }
}
