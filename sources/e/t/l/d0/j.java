package e.t.l.d0;

import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.ViewPropertyAnimator;
import com.meizu.cloud.pushsdk.notification.model.NotifyType;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u0014\u0010\u0006\u001a\u00020\u0003*\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a.\u0010\u0007\u001a\u00020\b*\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\r\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0010\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0011\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u000f2\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u0012\u0010\u0013\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0015\u001a\u001a\u0010\u0016\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u001c\u0010\u0017\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001c\u0010\u0018\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u0001\u001a\u001a\u0010\u0019\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"DURATION", "", "fadeIn", "", "Landroid/view/View;", "duration", "fadeOut", "getTranslate", "Landroid/view/ViewPropertyAnimator;", "x", "", "y", "scale", "rotate", "degree", "", "scaleX", "setAlpha", "alpha", "setListener", NotifyType.LIGHTS, "Landroid/animation/AnimatorListenerAdapter;", "setXY", "translationY", "translationYBy", "width", "destWidth", "vector_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class j {
    public static final long a = 500;

    public static final void a(@k.e.a.d View view, long j2) {
        j(view, 255, j2);
    }

    public static /* synthetic */ void b(View view, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 500;
        }
        a(view, j2);
    }

    public static final void c(@k.e.a.d View view, long j2) {
        j(view, 0, j2);
    }

    public static /* synthetic */ void d(View view, long j2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = 500;
        }
        c(view, j2);
    }

    @k.e.a.d
    public static final ViewPropertyAnimator e(@k.e.a.d View view, float f2, float f3, float f4, long j2) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(j2);
        animate.scaleX(f4);
        animate.scaleY(f4);
        float f5 = 1.0f - f4;
        float f6 = 2;
        animate.x(f2 - ((view.getWidth() * f5) / f6));
        animate.y(f3 - ((f5 * view.getHeight()) / f6));
        return animate;
    }

    public static /* synthetic */ ViewPropertyAnimator f(View view, float f2, float f3, float f4, long j2, int i2, Object obj) {
        float f5 = (i2 & 4) != 0 ? 1.0f : f4;
        if ((i2 & 8) != 0) {
            j2 = 500;
        }
        return e(view, f2, f3, f5, j2);
    }

    public static final void g(@k.e.a.d View view, int i2, long j2) {
        view.animate().setDuration(j2).rotation(i2);
    }

    public static /* synthetic */ void h(View view, int i2, long j2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j2 = 500;
        }
        g(view, i2, j2);
    }

    public static final void i(@k.e.a.d View view, float f2, long j2) {
        view.animate().setDuration(j2).scaleX(f2);
    }

    public static final void j(@k.e.a.d View view, int i2, long j2) {
        view.animate().setDuration(j2).alpha(i2);
    }

    public static /* synthetic */ void k(View view, int i2, long j2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j2 = 500;
        }
        j(view, i2, j2);
    }

    public static final void l(@k.e.a.d View view, @k.e.a.d AnimatorListenerAdapter animatorListenerAdapter) {
        view.animate().setListener(animatorListenerAdapter);
    }

    public static final void m(@k.e.a.d View view, float f2, float f3) {
        e(view, f2, f3, 1.0f, 0L);
    }

    public static final void n(@k.e.a.d View view, float f2, long j2) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(j2);
        animate.y(f2);
        animate.start();
    }

    public static /* synthetic */ void o(View view, float f2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 500;
        }
        n(view, f2, j2);
    }

    public static final void p(@k.e.a.d View view, float f2, long j2) {
        ViewPropertyAnimator animate = view.animate();
        animate.setDuration(j2);
        animate.yBy(f2);
        animate.start();
    }

    public static /* synthetic */ void q(View view, float f2, long j2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            j2 = 500;
        }
        p(view, f2, j2);
    }

    public static final void r(@k.e.a.d View view, int i2, long j2) {
        ObjectAnimator.ofInt(new k(view), "width", i2).setDuration(j2).start();
    }
}
