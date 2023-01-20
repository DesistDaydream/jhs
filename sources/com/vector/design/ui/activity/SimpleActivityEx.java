package com.vector.design.ui.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.TextView;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.vector.R;
import com.vector.config.AppBarState;
import com.vector.design.ui.activity.SimpleActivityEx;
import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.decor.ErrorViewEx;
import com.vector.design.ui.decor.ErrorViewImpl;
import com.vector.design.ui.decor.ViewState;
import com.vector.design.ui.nav.AppBar;
import com.vector.ext.view.ViewKt;
import e.t.k.a.a;
import e.t.l.b0;
import e.t.l.h;
import e.t.l.r;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import java.util.Objects;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt___CollectionsKt;

@Metadata(d1 = {"\u0000\u0098\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\r\n\u0002\b\u0002\b&\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H$J\b\u0010-\u001a\u00020\u000fH\u0015J\n\u0010.\u001a\u0004\u0018\u00010/H\u0016J\n\u00100\u001a\u0004\u0018\u00010\u001cH\u0016J+\u00101\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020204H\u0004J+\u00108\u001a\u0002022!\u00103\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020204H\u0004J\b\u00109\u001a\u000202H\u0017J\n\u0010:\u001a\u0004\u0018\u00010;H\u0014J\u0010\u0010<\u001a\u0004\u0018\u00010=2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020\u0011H\u0016J\b\u0010A\u001a\u00020\u0017H\u0016J\u0012\u0010B\u001a\u0002022\b\u0010!\u001a\u0004\u0018\u00010 H\u0015J\u0012\u0010C\u001a\u0002022\b\u0010D\u001a\u0004\u0018\u00010EH\u0015J\b\u0010F\u001a\u000202H\u0015J\b\u0010G\u001a\u000202H\u0015J\b\u0010H\u001a\u000202H\u0014J\b\u0010I\u001a\u000202H\u0016J\b\u0010J\u001a\u000202H\u0016J\u0010\u0010K\u001a\u0002022\u0006\u0010L\u001a\u00020MH\u0014R\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\n\u001a\u00020\u000b8\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R#\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\t\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\t\u001a\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001b\u001a\u0004\u0018\u00010\u001c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\"\u0010!\u001a\u0004\u0018\u00010 2\b\u0010\u001f\u001a\u0004\u0018\u00010 @BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R(\u0010&\u001a\u0004\u0018\u00010%2\b\u0010$\u001a\u0004\u0018\u00010%@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006O"}, d2 = {"Lcom/vector/design/ui/activity/SimpleActivityEx;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/vector/design/ui/UIHost;", "()V", "appBar", "Lcom/vector/design/ui/nav/AppBar;", "getAppBar", "()Lcom/vector/design/ui/nav/AppBar;", "appBar$delegate", "Lkotlin/Lazy;", "calledFinish", "", "classTag", "", "decorView", "Lcom/vector/design/ui/decor/DecorView;", "fitInflater", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "getFitInflater", "()Landroid/view/LayoutInflater;", "fitInflater$delegate", "fitResources", "Landroid/content/res/Resources;", "getFitResources", "()Landroid/content/res/Resources;", "fitResources$delegate", "hostView", "Landroid/view/View;", "getHostView", "()Landroid/view/View;", "<set-?>", "Landroid/os/Bundle;", "savedInstanceState", "getSavedInstanceState", "()Landroid/os/Bundle;", "value", "Lcom/vector/design/ui/decor/ViewState;", "viewState", "getViewState", "()Lcom/vector/design/ui/decor/ViewState;", "setViewState", "(Lcom/vector/design/ui/decor/ViewState;)V", "createBinding", "Landroidx/databinding/ViewDataBinding;", "createDecorView", "createErrorView", "Lcom/vector/design/ui/decor/ErrorViewEx;", "createLoadingView", "doOnLayout", "", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnPreDraw", "finish", "getAppBarState", "Lcom/vector/config/AppBarState;", "getFragment", "Landroidx/fragment/app/Fragment;", "index", "", "getLayoutInflater", "getResources", "onCreate", "onNewIntent", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, "Landroid/content/Intent;", "onPause", "onResume", "onRetryClick", "showEnterAnim", "showLeftAnim", "updateErrorText", "text", "", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SimpleActivityEx extends AppCompatActivity implements e.t.k.a.a {
    @d

    /* renamed from: i */
    public static final a f7725i = new a(null);
    @d

    /* renamed from: j */
    public static final String f7726j = "android:support:fragments";
    @d
    private final String a;
    private DecorView b;
    @d

    /* renamed from: c */
    private final w f7727c;
    @e

    /* renamed from: d */
    private ViewState f7728d;
    @e

    /* renamed from: e */
    private Bundle f7729e;
    @RequiresApi(21)

    /* renamed from: f */
    private boolean f7730f;
    @d

    /* renamed from: g */
    private final w f7731g;
    @d

    /* renamed from: h */
    private final w f7732h;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vector/design/ui/activity/SimpleActivityEx$Companion;", "", "()V", "FRAG_TAG", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/vector/ext/view/ViewKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* renamed from: c */
        public final /* synthetic */ ViewTreeObserver f7733c;

        /* renamed from: d */
        public final /* synthetic */ l f7734d;

        public b(View view, boolean z, ViewTreeObserver viewTreeObserver, l lVar) {
            this.a = view;
            this.b = z;
            this.f7733c = viewTreeObserver;
            this.f7734d = lVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f7734d.invoke(this.a);
            if (this.b) {
                return true;
            }
            if (this.f7733c.isAlive()) {
                this.f7733c.removeOnPreDrawListener(this);
                return true;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public SimpleActivityEx() {
        String canonicalName = getClass().getCanonicalName();
        this.a = canonicalName == null ? "" : canonicalName;
        this.f7727c = z.c(new SimpleActivityEx$appBar$2(this));
        this.f7731g = z.c(new SimpleActivityEx$fitInflater$2(this));
        this.f7732h = z.c(new SimpleActivityEx$fitResources$2(this));
    }

    public static final void E(SimpleActivityEx simpleActivityEx, View view) {
        simpleActivityEx.F();
    }

    private final LayoutInflater y() {
        return (LayoutInflater) this.f7731g.getValue();
    }

    private final Resources z() {
        return (Resources) this.f7732h.getValue();
    }

    @e
    public final Fragment A(int i2) {
        return (Fragment) CollectionsKt___CollectionsKt.J2(getSupportFragmentManager().getFragments(), i2);
    }

    @e
    public final Bundle B() {
        return this.f7729e;
    }

    @e
    public final ViewState C() {
        return this.f7728d;
    }

    public void F() {
    }

    public final void G(@e ViewState viewState) {
        if (viewState == null) {
            return;
        }
        DecorView decorView = this.b;
        Objects.requireNonNull(decorView);
        decorView.setViewState$vector_release(viewState);
        this.f7728d = viewState;
    }

    public void H() {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.slide_out_to_left);
    }

    public void I() {
        overridePendingTransition(R.anim.slide_in_from_left, R.anim.slide_out_to_right);
    }

    public void J(@d CharSequence charSequence) {
        DecorView decorView = this.b;
        if (decorView == null) {
            return;
        }
        Objects.requireNonNull(decorView);
        ErrorViewEx errorView$vector_release = decorView.getErrorView$vector_release();
        ErrorViewImpl errorViewImpl = errorView$vector_release instanceof ErrorViewImpl ? (ErrorViewImpl) errorView$vector_release : null;
        if (errorViewImpl != null && errorViewImpl.getChildCount() >= 1) {
            View childAt = errorViewImpl.getChildAt(0);
            if (childAt != null && (childAt instanceof TextView)) {
                ((TextView) childAt).setText(charSequence);
            }
            new h();
        }
    }

    @Override // e.t.k.a.a
    public void b(@ColorInt int i2) {
        a.C0411a.f(this, i2);
    }

    public void d() {
        a.C0411a.c(this);
    }

    public void f() {
        a.C0411a.b(this);
    }

    @Override // android.app.Activity
    @CallSuper
    public void finish() {
        if (Build.VERSION.SDK_INT >= 21) {
            if (this.f7730f) {
                super.finish();
                return;
            } else {
                this.f7730f = true;
                supportFinishAfterTransition();
            }
        } else {
            super.finish();
        }
        I();
    }

    public void g() {
        a.C0411a.d(this);
    }

    @Override // android.app.Activity
    @d
    public LayoutInflater getLayoutInflater() {
        return y();
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    @d
    public Resources getResources() {
        return z();
    }

    public void j() {
        a.C0411a.a(this);
    }

    @Override // e.t.k.a.a
    @e
    public View l() {
        DecorView decorView = this.b;
        Objects.requireNonNull(decorView);
        return decorView;
    }

    @Override // e.t.k.a.a
    public void m(@DrawableRes int i2) {
        a.C0411a.g(this, i2);
    }

    @Override // e.t.k.a.a
    public void o(@e Drawable drawable) {
        a.C0411a.e(this, drawable);
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    @CallSuper
    public void onCreate(@e Bundle bundle) {
        H();
        if (Build.VERSION.SDK_INT >= 21) {
            requestWindowFeature(12);
        }
        requestWindowFeature(1);
        getWindow().setFormat(-2);
        if (e.t.a.a().e()) {
            b0.d(getWindow());
        }
        if (bundle != null) {
            bundle.putParcelable("android:support:fragments", null);
            this.f7729e = bundle;
        }
        e.t.u.l.d(e.t.u.l.a, this, null, 2, null);
        super.onCreate(bundle);
        DecorView r = r();
        this.b = r;
        Objects.requireNonNull(r);
        setContentView(r);
        r.c(Integer.valueOf(e.t.a.a().j()), new SimpleActivityEx$onCreate$1(this));
        DecorView decorView = this.b;
        Objects.requireNonNull(decorView);
        decorView.setErrorClickListener(new View.OnClickListener() { // from class: e.t.k.a.b.a
            {
                SimpleActivityEx.this = this;
            }

            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleActivityEx.E(SimpleActivityEx.this, view);
            }
        });
        g();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onNewIntent(@e Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        e.t.u.l.a.a(this, intent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onPause() {
        super.onPause();
        e.t.t.a.a.b(this, this.a);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    @CallSuper
    public void onResume() {
        super.onResume();
        e.t.t.a.a.c(this, this.a);
    }

    @d
    public abstract ViewDataBinding q();

    @CallSuper
    @d
    public DecorView r() {
        return DecorView.n.a(this, new SimpleActivityEx$createDecorView$1(this));
    }

    @e
    public ErrorViewEx s() {
        return null;
    }

    @e
    public View t() {
        return null;
    }

    public final void u(@d l<? super View, t1> lVar) {
        DecorView decorView = this.b;
        Objects.requireNonNull(decorView);
        if (ViewCompat.isLaidOut(decorView) && !decorView.isLayoutRequested()) {
            lVar.invoke(decorView);
        } else {
            decorView.addOnLayoutChangeListener(new ViewKt.a(lVar));
        }
    }

    public final void v(@d l<? super View, t1> lVar) {
        DecorView decorView = this.b;
        Objects.requireNonNull(decorView);
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new b(decorView, false, viewTreeObserver, lVar));
        }
    }

    @d
    public final AppBar w() {
        return (AppBar) this.f7727c.getValue();
    }

    @e
    public AppBarState x() {
        return null;
    }
}
