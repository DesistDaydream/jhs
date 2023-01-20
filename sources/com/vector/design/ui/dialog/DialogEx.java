package com.vector.design.ui.dialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.FloatRange;
import androidx.annotation.StyleRes;
import androidx.core.content.ContextCompat;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.umeng.analytics.pro.am;
import com.vector.R;
import com.vector.design.ui.dialog.DialogEx;
import com.vector.ext.AnyKt;
import e.t.k.a.a;
import e.t.k.a.f.f;
import e.t.k.a.f.g;
import e.t.u.p;
import h.r0;
import h.t1;
import h.w;
import h.z;
import java.lang.ref.WeakReference;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000 \u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001XB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u0017\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020 J\b\u00101\u001a\u000202H&J\u0006\u00103\u001a\u000204J\u000e\u00105\u001a\u00020\u00002\u0006\u00103\u001a\u00020 J\b\u00106\u001a\u000207H\u0016J\u0010\u00108\u001a\u0002042\u0006\u00109\u001a\u00020:H\u0016J\u0006\u0010;\u001a\u000204J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010;\u001a\u00020 J\b\u0010=\u001a\u000204H\u0002J\b\u0010>\u001a\u00020 H\u0016J\u001a\u0010?\u001a\u0002042\u0010\u0010@\u001a\f\u0012\u0004\u0012\u0002040Aj\u0002`BH\u0016J\b\u0010C\u001a\u000204H\u0017J\b\u0010D\u001a\u000204H\u0016J\u001a\u0010E\u001a\u0002042\u0010\u0010@\u001a\f\u0012\u0004\u0012\u0002040Aj\u0002`BH\u0016J\u001a\u0010F\u001a\u0002042\u0010\u0010@\u001a\f\u0012\u0004\u0012\u0002040Aj\u0002`BH\u0016J\b\u0010G\u001a\u000204H\u0016J\b\u0010H\u001a\u000204H\u0016J\u0010\u0010I\u001a\u0002042\b\b\u0001\u0010J\u001a\u00020\u0007J\u0010\u0010K\u001a\u0002042\b\b\u0001\u0010L\u001a\u00020MJ\u000e\u0010N\u001a\u0002042\u0006\u0010O\u001a\u00020\u0007J\u0006\u0010P\u001a\u000204J\u0010\u0010Q\u001a\u0002042\b\u0010R\u001a\u0004\u0018\u00010,J\u000e\u0010S\u001a\u0002042\u0006\u0010T\u001a\u00020\u0007J\u0010\u0010U\u001a\u0002042\u0006\u0010\u000f\u001a\u00020VH\u0016J\u0006\u0010W\u001a\u000204R\u000e\u0010\t\u001a\u00020\nX\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0011\u001a\u00020\u00128BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0017\u001a\u00020\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u0016\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u001f\u001a\u00020 8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010!R\u001b\u0010\"\u001a\u00020#8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b&\u0010\u0016\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010+\u001a\u0004\u0018\u00010,8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u0006Y"}, d2 = {"Lcom/vector/design/ui/dialog/DialogEx;", "Lcom/vector/design/ui/UIHost;", "Landroidx/lifecycle/LifecycleOwner;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "themeId", "", "(Landroid/content/Context;I)V", "TAG", "", "contentView", "Landroid/view/View;", "getContext", "()Landroid/content/Context;", "dialog", "Lcom/vector/design/ui/dialog/InternalDialog;", "dispatcher", "Lcom/vector/design/ui/dialog/DialogLifecycleDispatcher;", "getDispatcher", "()Lcom/vector/design/ui/dialog/DialogLifecycleDispatcher;", "dispatcher$delegate", "Lkotlin/Lazy;", "eventObserver", "Landroidx/lifecycle/LifecycleEventObserver;", "getEventObserver", "()Landroidx/lifecycle/LifecycleEventObserver;", "eventObserver$delegate", "hostView", "getHostView", "()Landroid/view/View;", "isShowing", "", "()Z", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "onDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "onShowListener", "Landroid/content/DialogInterface$OnShowListener;", "params", "Landroid/view/ViewGroup$LayoutParams;", "getParams", "()Landroid/view/ViewGroup$LayoutParams;", "cancelable", "flag", "createBinding", "Landroidx/databinding/ViewDataBinding;", "dismiss", "", "dismissOnTouchOutside", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "handleWindow", "window", "Landroid/view/Window;", "hide", "hideOnTouchOutside", "initBackPress", "onBackPress", "onCancel", "callback", "Lkotlin/Function0;", "Lcom/vector/ext/NoArgClosure;", "onCreate", "onDestroy", "onDismiss", "onShow", "onStart", "onStop", "setAnimation", "dialogStyleId", "setDimAmount", "amount", "", "setGravity", "gravity", "setOutSideTouchMode", "setParams", am.ax, "setType", "type", "setView", "Landroid/app/Dialog;", TTLogUtil.TAG_EVENT_SHOW, "DismissListener", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class DialogEx implements e.t.k.a.a, LifecycleOwner {
    @d
    private final String a;
    private View b;
    @e

    /* renamed from: c */
    private DialogInterface.OnShowListener f7749c;
    @e

    /* renamed from: d */
    private DialogInterface.OnDismissListener f7750d;
    @d

    /* renamed from: e */
    private final w f7751e;
    @d

    /* renamed from: f */
    private final w f7752f;
    @d

    /* renamed from: g */
    private final w f7753g;
    @d

    /* renamed from: h */
    private final Context f7754h;
    @d

    /* renamed from: i */
    private final g f7755i;

    @Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
    /* renamed from: com.vector.design.ui.dialog.DialogEx$1 */
    /* loaded from: classes3.dex */
    public static final class AnonymousClass1 extends Lambda implements h.k2.u.a<t1> {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1() {
            super(0);
            DialogEx.this = r1;
        }

        @Override // h.k2.u.a
        public /* bridge */ /* synthetic */ t1 invoke() {
            invoke2();
            return t1.a;
        }

        @Override // h.k2.u.a
        /* renamed from: invoke */
        public final void invoke2() {
            DialogEx.this.q().g();
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\u0002\u001a\u0004\u0018\u00010\rH\u0016R\"\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/vector/design/ui/dialog/DialogEx$DismissListener;", "Landroid/content/DialogInterface$OnDismissListener;", "dialog", "Lcom/vector/design/ui/dialog/DialogEx;", "(Lcom/vector/design/ui/dialog/DialogEx;)V", "ref", "Ljava/lang/ref/WeakReference;", "getRef", "()Ljava/lang/ref/WeakReference;", "setRef", "(Ljava/lang/ref/WeakReference;)V", "onDismiss", "", "Landroid/content/DialogInterface;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements DialogInterface.OnDismissListener {
        @e
        private WeakReference<DialogEx> a;

        public a(@d DialogEx dialogEx) {
            this.a = new WeakReference<>(dialogEx);
        }

        @e
        public final WeakReference<DialogEx> a() {
            return this.a;
        }

        public final void b(@e WeakReference<DialogEx> weakReference) {
            this.a = weakReference;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(@e DialogInterface dialogInterface) {
            DialogEx dialogEx;
            DialogInterface.OnDismissListener onDismissListener;
            DialogEx dialogEx2;
            WeakReference<DialogEx> weakReference = this.a;
            if (weakReference != null && (dialogEx2 = weakReference.get()) != null) {
                dialogEx2.q().e();
            }
            WeakReference<DialogEx> weakReference2 = this.a;
            if (weakReference2 == null || (dialogEx = weakReference2.get()) == null || (onDismissListener = dialogEx.f7750d) == null) {
                return;
            }
            onDismissListener.onDismiss(dialogInterface);
        }
    }

    public DialogEx(@e Context context, int i2) {
        this.a = "DialiogEx";
        this.f7751e = z.c(new DialogEx$layoutInflater$2(context));
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.f7752f = z.b(lazyThreadSafetyMode, new DialogEx$dispatcher$2(this));
        this.f7753g = z.b(lazyThreadSafetyMode, new DialogEx$eventObserver$2(this));
        Objects.requireNonNull(context, "context can not be null");
        this.f7754h = context;
        g gVar = new g(context, i2);
        this.f7755i = gVar;
        gVar.g(new AnonymousClass1());
        gVar.setOnDismissListener(new a(this));
        q().a(r());
        q().d();
    }

    public static final void G(h.k2.u.a aVar, DialogInterface dialogInterface) {
        aVar.invoke();
    }

    public static final void K(h.k2.u.a aVar, DialogInterface dialogInterface) {
        aVar.invoke();
    }

    public static final void M(h.k2.u.a aVar, DialogInterface dialogInterface) {
        aVar.invoke();
    }

    public final f q() {
        return (f) this.f7752f.getValue();
    }

    private final LifecycleEventObserver r() {
        return (LifecycleEventObserver) this.f7753g.getValue();
    }

    private final void x() {
        this.f7755i.setOnKeyListener(new DialogInterface.OnKeyListener() { // from class: e.t.k.a.f.b
            {
                DialogEx.this = this;
            }

            @Override // android.content.DialogInterface.OnKeyListener
            public final boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                boolean y;
                y = DialogEx.y(DialogEx.this, dialogInterface, i2, keyEvent);
                return y;
            }
        });
    }

    public static final boolean y(DialogEx dialogEx, DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
        if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
            return dialogEx.E();
        }
        return false;
    }

    public boolean E() {
        return false;
    }

    public void F(@d final h.k2.u.a<t1> aVar) {
        this.f7755i.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: e.t.k.a.f.e
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                DialogEx.G(aVar, dialogInterface);
            }
        });
    }

    @CallSuper
    public void H() {
        ViewDataBinding k2 = k();
        k2.setLifecycleOwner(this);
        this.b = k2.getRoot();
        V(this.f7755i);
        T(t());
        g();
        x();
    }

    public void I() {
    }

    public void J(@d final h.k2.u.a<t1> aVar) {
        this.f7750d = new DialogInterface.OnDismissListener() { // from class: e.t.k.a.f.d
            @Override // android.content.DialogInterface.OnDismissListener
            public final void onDismiss(DialogInterface dialogInterface) {
                DialogEx.K(aVar, dialogInterface);
            }
        };
    }

    public void L(@d final h.k2.u.a<t1> aVar) {
        this.f7749c = new DialogInterface.OnShowListener() { // from class: e.t.k.a.f.a
            @Override // android.content.DialogInterface.OnShowListener
            public final void onShow(DialogInterface dialogInterface) {
                DialogEx.M(aVar, dialogInterface);
            }
        };
    }

    public void N() {
    }

    public void O() {
    }

    public final void P(@StyleRes int i2) {
        Window window = this.f7755i.getWindow();
        if (window == null) {
            return;
        }
        window.setWindowAnimations(i2);
    }

    public final void Q(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        Window window = this.f7755i.getWindow();
        if (window == null) {
            return;
        }
        window.setDimAmount(f2);
    }

    public final void R(int i2) {
        Window window = this.f7755i.getWindow();
        if (window == null) {
            return;
        }
        window.setGravity(i2);
    }

    public final void S() {
        Window window = this.f7755i.getWindow();
        if (window != null) {
            window.setFlags(32, 32);
        }
        Window window2 = this.f7755i.getWindow();
        if (window2 == null) {
            return;
        }
        window2.setFlags(262144, 262144);
    }

    public final void T(@e ViewGroup.LayoutParams layoutParams) {
        Window window;
        if (layoutParams == null) {
            return;
        }
        Window window2 = this.f7755i.getWindow();
        WindowManager.LayoutParams attributes = window2 == null ? null : window2.getAttributes();
        boolean z = false;
        boolean z2 = true;
        if (layoutParams.width == -1) {
            if (attributes != null) {
                attributes.width = -1;
            }
            z = true;
        }
        if (layoutParams.height != -1) {
            z2 = z;
        } else if (attributes != null) {
            attributes.height = -1;
        }
        if (z2 && (window = this.f7755i.getWindow()) != null) {
            window.setAttributes(attributes);
        }
        Window window3 = this.f7755i.getWindow();
        if (window3 == null) {
            return;
        }
        u(window3);
    }

    public final void U(int i2) {
        if (i2 == 2003) {
            if (!(ContextCompat.checkSelfPermission(this.f7754h, "android.permission.SYSTEM_ALERT_WINDOW") != 0)) {
                throw new IllegalArgumentException("please add permission in manifest android.permission.SYSTEM_ALERT_WINDOW".toString());
            }
        }
        Window window = this.f7755i.getWindow();
        if (window == null) {
            return;
        }
        window.setType(i2);
    }

    public void V(@d Dialog dialog) {
        View view = this.b;
        Objects.requireNonNull(view);
        dialog.setContentView(view, p.v(-1, -1));
    }

    public final void W() {
        Context context = this.f7754h;
        if (!(context instanceof Activity) || ((Activity) context).isFinishing()) {
            return;
        }
        q().f();
        AnyKt.v(null, new DialogEx$show$1(this), 1, null);
    }

    @Override // e.t.k.a.a
    public void b(@ColorInt int i2) {
        a.C0411a.f(this, i2);
    }

    @Override // e.t.k.a.a
    public void d() {
        a.C0411a.c(this);
    }

    @Override // e.t.k.a.a
    public void f() {
        a.C0411a.b(this);
    }

    @Override // e.t.k.a.a
    public void g() {
        a.C0411a.d(this);
    }

    @d
    public final Context getContext() {
        return this.f7754h;
    }

    @Override // androidx.lifecycle.LifecycleOwner
    @d
    public Lifecycle getLifecycle() {
        return q().b();
    }

    @d
    public final DialogEx i(boolean z) {
        this.f7755i.setCancelable(z);
        return this;
    }

    @Override // e.t.k.a.a
    public void j() {
        a.C0411a.a(this);
    }

    @d
    public abstract ViewDataBinding k();

    @Override // e.t.k.a.a
    @e
    public View l() {
        View view = this.b;
        Objects.requireNonNull(view);
        return view;
    }

    @Override // e.t.k.a.a
    public void m(@DrawableRes int i2) {
        a.C0411a.g(this, i2);
    }

    public final void n() {
        try {
            Result.a aVar = Result.Companion;
            this.f7755i.dismiss();
            Result.m106constructorimpl(t1.a);
        } catch (Throwable th) {
            Result.a aVar2 = Result.Companion;
            Result.m106constructorimpl(r0.a(th));
        }
    }

    @Override // e.t.k.a.a
    public void o(@e Drawable drawable) {
        a.C0411a.e(this, drawable);
    }

    @d
    public final DialogEx p(boolean z) {
        this.f7755i.e(z);
        return this;
    }

    @d
    public final LayoutInflater s() {
        return (LayoutInflater) this.f7751e.getValue();
    }

    @e
    public ViewGroup.LayoutParams t() {
        return null;
    }

    public void u(@d Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        if (attributes != null && attributes.height == -1) {
            try {
                window.setFlags(8, 8);
                window.getDecorView().setPadding(0, 0, 0, 0);
                if (Build.VERSION.SDK_INT >= 28) {
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
                window.clearFlags(8);
            } catch (Exception e2) {
                String str = this.a;
                String message = e2.getMessage();
                if (message == null) {
                    message = e2.toString();
                }
                Log.e(str, message);
            }
        }
    }

    public final void v() {
        this.f7755i.hide();
    }

    @d
    public final DialogEx w(boolean z) {
        this.f7755i.f(z);
        return this;
    }

    public final boolean z() {
        return this.f7755i.isShowing();
    }

    public DialogEx(@e Context context) {
        this(context, R.style.Theme_Dialog);
    }
}
