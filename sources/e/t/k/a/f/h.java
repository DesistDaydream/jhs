package e.t.k.a.f;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import com.vector.R;
import com.vector.design.ui.dialog.DialogEx;
import com.vector.ext.bind.BindViewKt;
import com.vector.view.ProgressView;
import e.t.l.b0;
import e.t.u.p;
import h.k2.v.n0;
import h.k2.v.u;
import h.p2.n;
import i.b.q0;
import kotlin.Metadata;
import kotlin.jvm.internal.PropertyReference1Impl;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0017H\u0016J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0016J\u0010\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\"\u0010\u001e\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0005H\u0002J\u0012\u0010$\u001a\u00020\u00172\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0007\"\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lcom/vector/design/ui/dialog/LoadingDialog;", "Lcom/vector/design/ui/dialog/DialogEx;", "context", "Landroid/content/Context;", "isCancelable", "", "(Landroid/content/Context;Z)V", "()Z", "setCancelable", "(Z)V", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "progressView", "Lcom/vector/view/ProgressView;", "getProgressView", "()Lcom/vector/view/ProgressView;", "progressView$delegate", "Lkotlin/properties/ReadOnlyProperty;", "createBinding", "Landroidx/databinding/ViewDataBinding;", "flowOfSetup", "", "onDestroy", "onStart", "onStop", "setView", "dialog", "Landroid/app/Dialog;", "setWindowFlag", "window", "Landroid/view/Window;", "bits", "", q0.f15781d, "setWindowParams", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class h extends DialogEx {

    /* renamed from: l */
    public static final /* synthetic */ n<Object>[] f14569l = {n0.r(new PropertyReference1Impl(n0.d(h.class), "progressView", "getProgressView()Lcom/vector/view/ProgressView;"))};

    /* renamed from: j */
    private boolean f14570j;
    @k.e.a.d

    /* renamed from: k */
    private final h.m2.e f14571k;

    public h(@k.e.a.e Context context, boolean z) {
        super(context);
        this.f14570j = z;
        this.f14571k = BindViewKt.v(this, R.id.progress_view);
    }

    private final ProgressView X() {
        return (ProgressView) this.f14571k.a(this, f14569l[0]);
    }

    private final void a0(Window window, int i2, boolean z) {
        int i3;
        WindowManager.LayoutParams attributes = window == null ? null : window.getAttributes();
        if (attributes == null) {
            return;
        }
        if (z) {
            i3 = i2 | attributes.flags;
        } else {
            i3 = (~i2) & attributes.flags;
        }
        attributes.flags = i3;
        if (window == null) {
            return;
        }
        window.setAttributes(attributes);
    }

    private final void b0(Window window) {
        View decorView;
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        if (window != null && (decorView = window.getDecorView()) != null) {
            decorView.setPadding(0, 0, 0, 0);
        }
        if (window != null) {
            window.setFlags(16777216, 16777216);
        }
        if (window != null) {
            window.clearFlags(2);
        }
        if (window != null) {
            window.setSoftInputMode(16);
        }
        View decorView2 = window == null ? null : window.getDecorView();
        if (decorView2 != null) {
            decorView2.setSystemUiVisibility(1280);
        }
        if (Build.VERSION.SDK_INT >= 21) {
            a0(window, 201326592, false);
            if (window != null) {
                window.setStatusBarColor(0);
            }
            if (window == null) {
                return;
            }
            window.addFlags(Integer.MIN_VALUE);
        }
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    public void I() {
        X().A();
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    public void N() {
        X().z();
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    public void O() {
        X().A();
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    public void V(@k.e.a.d Dialog dialog) {
        b0(dialog.getWindow());
        super.V(dialog);
        b0.k(dialog.getWindow(), ViewCompat.MEASURED_STATE_MASK);
    }

    public final boolean Y() {
        return this.f14570j;
    }

    public final void Z(boolean z) {
        this.f14570j = z;
    }

    @Override // com.vector.design.ui.dialog.DialogEx, e.t.k.a.a
    public void d() {
        p(false);
        i(this.f14570j);
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    @k.e.a.d
    public ViewDataBinding k() {
        e.t.j.b d2 = e.t.j.b.d(s());
        d2.h(this);
        return d2;
    }

    @Override // com.vector.design.ui.dialog.DialogEx
    @k.e.a.e
    public ViewGroup.LayoutParams t() {
        return p.v(-1, -1);
    }

    public /* synthetic */ h(Context context, boolean z, int i2, u uVar) {
        this(context, (i2 & 2) != 0 ? true : z);
    }
}
