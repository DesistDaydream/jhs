package e.t.u;

import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0010\u0010\u0012\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u000e\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\tR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vector/util/KeyboardUtil;", "", "()V", "isActive", "", "()Z", "mImm", "Landroid/view/inputmethod/InputMethodManager;", "forceShow", "", "v", "Landroid/view/View;", "hideFromView", "isClearFocus", "hideFromWindow", "windowToken", "Landroid/os/IBinder;", "restartInput", "showFromView", "showSoftKeyboard", "window", "Landroid/view/Window;", "toggle", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class o {
    @k.e.a.d
    public static final o a = new o();
    @k.e.a.e
    private static InputMethodManager b;

    static {
        Object systemService = e.t.a.b().getSystemService("input_method");
        b = systemService instanceof InputMethodManager ? (InputMethodManager) systemService : null;
    }

    private o() {
    }

    @h.k2.k
    public static final void b(@k.e.a.d View view, boolean z) {
        IBinder windowToken = view.getWindowToken();
        if (windowToken != null) {
            d(windowToken);
        }
        if (z) {
            view.clearFocus();
        }
    }

    public static /* synthetic */ void c(View view, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = true;
        }
        b(view, z);
    }

    @h.k2.k
    public static final void d(@k.e.a.d IBinder iBinder) {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.hideSoftInputFromWindow(iBinder, 2);
    }

    public final void a(@k.e.a.d View view) {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 2);
    }

    public final boolean e() {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return false;
        }
        return inputMethodManager.isActive();
    }

    public final boolean f(@k.e.a.d View view) {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return false;
        }
        return inputMethodManager.isActive(view);
    }

    public final void g(@k.e.a.d View view) {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.restartInput(view);
    }

    public final void h(@k.e.a.e View view) {
        if (view == null) {
            return;
        }
        view.requestFocus();
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.showSoftInput(view, 1);
    }

    public final void i(@k.e.a.d Window window) {
        window.setSoftInputMode(5);
    }

    public final void j() {
        InputMethodManager inputMethodManager = b;
        if (inputMethodManager == null) {
            return;
        }
        inputMethodManager.toggleSoftInput(0, 2);
    }
}
