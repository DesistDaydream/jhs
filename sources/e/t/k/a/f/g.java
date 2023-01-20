package e.t.k.a.f;

import android.app.Dialog;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import h.t1;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u0014H\u0016J\u0018\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u0014H\u0016J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010 \u001a\u00020\u00142\u0006\u0010!\u001a\u00020\bH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013j\u0004\u0018\u0001`\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\""}, d2 = {"Lcom/vector/design/ui/dialog/InternalDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "themeResId", "", "(Landroid/content/Context;I)V", "canCancel", "", "value", "dismissOnTouchOutside", "getDismissOnTouchOutside", "()Z", "setDismissOnTouchOutside", "(Z)V", "hideOnTouchOutside", "getHideOnTouchOutside", "setHideOnTouchOutside", "onHideListener", "Lkotlin/Function0;", "", "Lcom/vector/ext/NoArgClosure;", "getOnHideListener", "()Lkotlin/jvm/functions/Function0;", "setOnHideListener", "(Lkotlin/jvm/functions/Function0;)V", "hide", "isOutOfBounds", "event", "Landroid/view/MotionEvent;", "onBackPressed", "onTouchEvent", "setCancelable", "flag", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class g extends Dialog {
    @k.e.a.e
    private h.k2.u.a<t1> a;
    private boolean b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f14567c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f14568d;

    public g(@k.e.a.d Context context, int i2) {
        super(context, i2);
        this.b = true;
    }

    private final boolean d(Context context, MotionEvent motionEvent) {
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Window window = getWindow();
        View decorView = window == null ? null : window.getDecorView();
        if (decorView == null) {
            return false;
        }
        int scaledWindowTouchSlop = ViewConfiguration.get(context).getScaledWindowTouchSlop();
        int i2 = -scaledWindowTouchSlop;
        return x < i2 || y < i2 || x > decorView.getWidth() + scaledWindowTouchSlop || y > decorView.getHeight() + scaledWindowTouchSlop;
    }

    public final boolean a() {
        return this.f14568d;
    }

    public final boolean b() {
        return this.f14567c;
    }

    @k.e.a.e
    public final h.k2.u.a<t1> c() {
        return this.a;
    }

    public final void e(boolean z) {
        if (z && !this.b) {
            setCancelable(true);
        }
        this.f14568d = z;
        if (z) {
            f(false);
        }
    }

    public final void f(boolean z) {
        if (z && !this.b) {
            setCancelable(true);
        }
        this.f14567c = z;
        if (z) {
            e(false);
        }
    }

    public final void g(@k.e.a.e h.k2.u.a<t1> aVar) {
        this.a = aVar;
    }

    @Override // android.app.Dialog
    public void hide() {
        super.hide();
        h.k2.u.a<t1> aVar = this.a;
        if (aVar == null) {
            return;
        }
        aVar.invoke();
    }

    @Override // android.app.Dialog
    public void onBackPressed() {
        if (this.f14568d) {
            cancel();
        } else if (this.f14567c) {
            hide();
        } else if (this.b) {
            cancel();
        }
    }

    @Override // android.app.Dialog
    public boolean onTouchEvent(@k.e.a.d MotionEvent motionEvent) {
        boolean z = (motionEvent.getAction() == 0 && d(getContext(), motionEvent)) || motionEvent.getAction() == 4;
        if (this.b && isShowing() && z) {
            if (this.f14568d) {
                cancel();
            } else if (this.f14567c) {
                hide();
            }
            return true;
        }
        return false;
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        this.b = z;
    }
}
