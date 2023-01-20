package e.t.k.a.i;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.core.widget.PopupWindowCompat;
import androidx.databinding.ViewDataBinding;
import e.t.k.a.a;
import e.t.l.k;
import h.k2.v.u;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0016\b&\u0018\u0000 F2\u00020\u00012\u00020\u0002:\u0001FB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010.\u001a\u00020/H&J\u0010\u00100\u001a\u0002012\u0006\u00102\u001a\u00020\u0007H\u0002J\u0006\u00103\u001a\u000201J\b\u00104\u001a\u000201H\u0007J\b\u00105\u001a\u000201H\u0017J\u0012\u00106\u001a\u00020\u00182\b\b\u0001\u00107\u001a\u00020\u000fH\u0002J\u0018\u00108\u001a\u0002012\u0006\u00109\u001a\u00020\u00182\b\b\u0003\u00107\u001a\u00020\u000fJ\u000e\u0010:\u001a\u0002012\u0006\u00109\u001a\u00020\u0018J\u0010\u0010;\u001a\u0002012\u0006\u0010<\u001a\u00020\u0007H\u0002J\"\u0010=\u001a\u0002012\u0006\u0010<\u001a\u00020\u00072\b\b\u0002\u0010>\u001a\u00020\u001e2\b\b\u0002\u0010?\u001a\u00020\u001eJ&\u0010@\u001a\u0002012\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u001e2\u0006\u0010C\u001a\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eJ.\u0010E\u001a\u0002012\u0006\u0010<\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u001e2\u0006\u0010?\u001a\u00020\u001e2\u0006\u0010,\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001eR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0002X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u0011\u0010\u001d\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010!\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010\tR$\u0010$\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR$\u0010&\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\u0011\u0010(\u001a\u00020\u00188F¢\u0006\u0006\u001a\u0004\b(\u0010\u001aR$\u0010)\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u00188F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\u001a\"\u0004\b*\u0010\u001cR\u000e\u0010+\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010,\u001a\u00020\u001e8F¢\u0006\u0006\u001a\u0004\b-\u0010 ¨\u0006G"}, d2 = {"Lcom/vector/design/ui/popupWindow/PopupWindowEx;", "Lcom/vector/design/ui/UIHost;", "Landroid/widget/PopupWindow$OnDismissListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "setContentView", "(Landroid/view/View;)V", "getContext", "()Landroid/content/Context;", "dimAmount", "", "dimWindow", "Landroid/widget/PopupWindow;", "dismissListener", "getDismissListener", "()Landroid/widget/PopupWindow$OnDismissListener;", "setDismissListener", "(Landroid/widget/PopupWindow$OnDismissListener;)V", "enableDim", "", "getEnableDim", "()Z", "setEnableDim", "(Z)V", "height", "", "getHeight", "()I", "hostView", "getHostView", "value", "isFocusable", "setFocusable", "isOutsideTouchable", "setOutsideTouchable", "isShowing", "isTouchable", "setTouchable", "popupWindow", "width", "getWidth", "createBinding", "Landroidx/databinding/ViewDataBinding;", "createDimWindow", "", "v", "dismiss", "initializeFlow", "onDismiss", "setDimAmount", "amount", "setDimEnabled", "enabled", "setTouchOutsideDismissEnabled", "setWithAnchor", "anchor", "showAsDropDown", "xoff", "yoff", "showAtLocation", "parent", "gravity", "x", "y", "update", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class b implements e.t.k.a.a, PopupWindow.OnDismissListener {
    @d

    /* renamed from: h */
    public static final a f14573h = new a(null);

    /* renamed from: i */
    private static final float f14574i = 0.3f;
    @d
    private final Context a;
    @d
    private final PopupWindow b;

    /* renamed from: c */
    private boolean f14575c;
    @e

    /* renamed from: d */
    private PopupWindow f14576d;

    /* renamed from: e */
    private float f14577e = f14574i;
    @e

    /* renamed from: f */
    private PopupWindow.OnDismissListener f14578f;

    /* renamed from: g */
    public View f14579g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vector/design/ui/popupWindow/PopupWindowEx$Companion;", "", "()V", "DEFAULT_DIM_AMOUNT", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    public b(@d Context context) {
        this.a = context;
        this.b = new PopupWindow(context);
        g();
    }

    private final void G(View view) {
        this.b.setWidth(p());
        this.b.setHeight(n());
    }

    public static /* synthetic */ void I(b bVar, View view, int i2, int i3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showAsDropDown");
        }
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = 0;
        }
        bVar.H(view, i2, i3);
    }

    private final void c(View view) {
        if (this.f14576d == null) {
            PopupWindow popupWindow = new PopupWindow(this.a);
            this.f14576d = popupWindow;
            if (popupWindow != null) {
                popupWindow.setContentView(k.l(this.a, 1));
            }
            PopupWindow popupWindow2 = this.f14576d;
            if (popupWindow2 != null) {
                popupWindow2.setWidth(p());
            }
            PopupWindow popupWindow3 = this.f14576d;
            if (popupWindow3 != null) {
                popupWindow3.setHeight(this.b.getMaxAvailableHeight(view));
            }
            PopupWindow popupWindow4 = this.f14576d;
            if (popupWindow4 != null) {
                popupWindow4.setFocusable(false);
            }
            PopupWindow popupWindow5 = this.f14576d;
            if (popupWindow5 != null) {
                popupWindow5.setTouchable(false);
            }
            x(this.f14577e);
        }
    }

    public static final void q(b bVar) {
        a.C0411a.d(bVar);
    }

    public static /* synthetic */ void v(b bVar) {
        q(bVar);
    }

    private final boolean x(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        if (this.f14575c) {
            if (this.f14576d != null) {
                int argb = Color.argb((int) (f2 * 255), 0, 0, 0);
                PopupWindow popupWindow = this.f14576d;
                if (popupWindow == null) {
                    return true;
                }
                popupWindow.setBackgroundDrawable(new ColorDrawable(argb));
                return true;
            }
            this.f14577e = f2;
            return true;
        }
        return false;
    }

    public static /* synthetic */ void z(b bVar, boolean z, float f2, int i2, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setDimEnabled");
        }
        if ((i2 & 2) != 0) {
            f2 = bVar.f14577e;
        }
        bVar.y(z, f2);
    }

    public final void A(@e PopupWindow.OnDismissListener onDismissListener) {
        this.f14578f = onDismissListener;
    }

    public final void B(boolean z) {
        this.f14575c = z;
    }

    public final void C(boolean z) {
        this.b.setFocusable(z);
    }

    public final void D(boolean z) {
        this.b.setOutsideTouchable(z);
    }

    public final void E(boolean z) {
        D(z);
        C(z);
        this.b.setBackgroundDrawable(z ? new ColorDrawable(0) : null);
    }

    public final void F(boolean z) {
        this.b.setTouchable(z);
    }

    public final void H(@d View view, int i2, int i3) {
        G(view);
        if (this.f14575c) {
            c(view);
            PopupWindow popupWindow = this.f14576d;
            if (popupWindow != null) {
                PopupWindowCompat.showAsDropDown(popupWindow, view, i2, i3, 48);
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        }
        PopupWindowCompat.showAsDropDown(this.b, view, i2, i3, 48);
    }

    public final void J(@d View view, int i2, int i3, int i4) {
        G(view);
        if (this.f14575c) {
            c(view);
            PopupWindow popupWindow = this.f14576d;
            if (popupWindow != null) {
                popupWindow.showAtLocation(view, i2, i3, i4);
            }
        }
        this.b.showAtLocation(view, i2, i3, i4);
    }

    @d
    public abstract ViewDataBinding a();

    @Override // e.t.k.a.a
    public void b(@ColorInt int i2) {
        a.C0411a.f(this, i2);
    }

    @Override // e.t.k.a.a
    public void d() {
        a.C0411a.c(this);
    }

    public final void e() {
        this.b.dismiss();
    }

    @Override // e.t.k.a.a
    public void f() {
        a.C0411a.b(this);
    }

    @Override // e.t.k.a.a
    @CallSuper
    public final void g() {
        w(a().getRoot());
        this.b.setContentView(h());
        this.b.setOnDismissListener(this);
        new Handler().post(new Runnable() { // from class: e.t.k.a.i.a
            @Override // java.lang.Runnable
            public final void run() {
                b.v(b.this);
            }
        });
    }

    @d
    public final Context getContext() {
        return this.a;
    }

    @d
    public final View h() {
        View view = this.f14579g;
        Objects.requireNonNull(view);
        return view;
    }

    @e
    public final PopupWindow.OnDismissListener i() {
        return this.f14578f;
    }

    @Override // e.t.k.a.a
    public void j() {
        a.C0411a.a(this);
    }

    public final boolean k() {
        return this.f14575c;
    }

    @Override // e.t.k.a.a
    @d
    public View l() {
        return h();
    }

    @Override // e.t.k.a.a
    public void m(@DrawableRes int i2) {
        a.C0411a.g(this, i2);
    }

    public final int n() {
        return -2;
    }

    @Override // e.t.k.a.a
    public void o(@e Drawable drawable) {
        a.C0411a.e(this, drawable);
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    @CallSuper
    public void onDismiss() {
        PopupWindow popupWindow;
        if (this.f14575c && (popupWindow = this.f14576d) != null) {
            popupWindow.dismiss();
        }
        PopupWindow.OnDismissListener onDismissListener = this.f14578f;
        if (onDismissListener == null) {
            return;
        }
        onDismissListener.onDismiss();
    }

    public final int p() {
        return -2;
    }

    public final boolean r() {
        return this.b.isFocusable();
    }

    public final boolean s() {
        return this.b.isOutsideTouchable();
    }

    public final boolean t() {
        return this.b.isShowing();
    }

    public final boolean u() {
        return this.b.isTouchable();
    }

    public final void update(@d View view, int i2, int i3, int i4, int i5) {
        G(view);
        if (this.f14575c) {
            c(view);
            PopupWindow popupWindow = this.f14576d;
            if (popupWindow != null) {
                popupWindow.update(view, i2, i3, i4, i5);
            }
        }
        this.b.update(view, i2, i3, i4, i5);
    }

    public final void w(@d View view) {
        this.f14579g = view;
    }

    public final void y(boolean z, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.f14575c = z;
        if (!z) {
            f2 = 0.0f;
        }
        x(f2);
    }
}
