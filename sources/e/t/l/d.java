package e.t.l;

import android.app.Activity;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.AnimRes;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0003\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005\u001a\n\u0010\u0006\u001a\u00020\u0001*\u00020\u0002\u001a\u0012\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\t\u001a(\u0010\n\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u0005\u001a\u001e\u0010\r\u001a\u00020\u0001*\u00020\u00022\b\b\u0001\u0010\u000e\u001a\u00020\u00052\b\b\u0001\u0010\u000f\u001a\u00020\u0005¨\u0006\u0010"}, d2 = {"enterFullScreen", "", "Landroid/app/Activity;", "matchScreenWidth", "gravity", "", "quitFullScreen", "setNavigationBarColor", "res", "Lcom/vector/util/IntRes;", "setWindowAttr", "width", "height", "withAnim", "enter", "exit", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class d {
    public static final void a(@k.e.a.d Activity activity) {
        b0.c(activity.getWindow());
    }

    public static final void b(@k.e.a.d Activity activity, int i2) {
        WindowManager windowManager = activity.getWindowManager();
        if (e.t.u.y.a(30)) {
            f(activity, i2, windowManager.getCurrentWindowMetrics().getBounds().left, 0, 4, null);
            return;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getSize(point);
        f(activity, i2, point.x, 0, 4, null);
    }

    public static final void c(@k.e.a.d Activity activity) {
        b0.g(activity.getWindow());
    }

    public static final void d(@k.e.a.d Activity activity, @k.e.a.d e.t.u.m mVar) {
        b0.b(activity.getWindow(), mVar);
    }

    public static final void e(@k.e.a.d Activity activity, int i2, int i3, int i4) {
        WindowManager.LayoutParams attributes = activity.getWindow().getAttributes();
        attributes.width = i3;
        attributes.height = i4;
        attributes.gravity = i2;
        activity.getWindow().setAttributes(attributes);
    }

    public static /* synthetic */ void f(Activity activity, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            i2 = 17;
        }
        if ((i5 & 2) != 0) {
            i3 = -1;
        }
        if ((i5 & 4) != 0) {
            i4 = -1;
        }
        e(activity, i2, i3, i4);
    }

    public static final void g(@k.e.a.d Activity activity, @AnimRes int i2, @AnimRes int i3) {
        activity.overridePendingTransition(i2, i3);
    }
}
