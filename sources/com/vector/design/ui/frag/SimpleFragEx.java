package com.vector.design.ui.frag;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.CallSuper;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.databinding.ViewDataBinding;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.vector.config.AppBarState;
import com.vector.design.ui.decor.DecorView;
import com.vector.design.ui.decor.ErrorViewEx;
import com.vector.design.ui.decor.ViewState;
import com.vector.design.ui.frag.SimpleFragEx;
import com.vector.design.ui.nav.AppBar;
import com.vector.design.ui.nav.AppBar2;
import com.vector.ext.view.ViewKt;
import e.t.k.a.a;
import e.t.l.k;
import e.t.u.r;
import h.i;
import h.k2.u.l;
import h.k2.v.f0;
import h.q0;
import h.t1;
import h.w;
import h.z;
import java.util.Arrays;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001pB\u0005¢\u0006\u0002\u0010\u0003J\b\u00107\u001a\u000208H\u0002J\b\u00109\u001a\u00020:H&J\b\u0010;\u001a\u00020\u0012H\u0014J\n\u0010<\u001a\u0004\u0018\u00010=H\u0016J\n\u0010>\u001a\u0004\u0018\u00010\u0016H\u0016J)\u0010?\u001a\u0002082!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080AJ)\u0010E\u001a\u0002082!\u0010@\u001a\u001d\u0012\u0013\u0012\u00110\u0016¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080AJ\b\u0010F\u001a\u000208H\u0002J#\u0010G\u001a\u0004\u0018\u0001HH\"\n\b\u0000\u0010H*\u0004\u0018\u00010\u00162\u0006\u0010I\u001a\u00020JH\u0016¢\u0006\u0002\u0010KJ\n\u0010L\u001a\u0004\u0018\u00010MH\u0014J\b\u0010N\u001a\u00020\u0016H\u0002J\b\u0010O\u001a\u000208H\u0002J\b\u0010P\u001a\u000208H\u0016J\u0012\u0010Q\u001a\u0002082\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\"\u0010R\u001a\u0002082\u0006\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020J2\b\u0010U\u001a\u0004\u0018\u00010VH\u0007J&\u0010W\u001a\u0004\u0018\u00010\u00162\u0006\u0010X\u001a\u00020Y2\b\u0010Z\u001a\u0004\u0018\u00010[2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010\\\u001a\u000208H\u0016J\u0012\u0010]\u001a\u00020Y2\b\u0010-\u001a\u0004\u0018\u00010,H\u0016J\b\u0010^\u001a\u000208H\u0017J\"\u0010_\u001a\u0002082\u0006\u0010S\u001a\u00020J2\u0006\u0010T\u001a\u00020J2\b\u0010U\u001a\u0004\u0018\u00010VH\u0016J\b\u0010`\u001a\u000208H\u0017J\b\u0010a\u001a\u000208H\u0014J\b\u0010b\u001a\u000208H\u0002J\u0010\u0010c\u001a\u0002082\u0006\u0010d\u001a\u00020\u0000H\u0002J\u000e\u0010e\u001a\u0002082\u0006\u0010f\u001a\u00020JJ'\u0010g\u001a\u0002082\u0006\u0010h\u001a\u00020V2\u0012\u0010i\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0j\"\u00020,¢\u0006\u0002\u0010kJ+\u0010g\u001a\u0002082\n\u0010l\u001a\u0006\u0012\u0002\b\u00030m2\u0012\u0010i\u001a\n\u0012\u0006\b\u0001\u0012\u00020,0j\"\u00020,¢\u0006\u0002\u0010nJ\u0018\u0010o\u001a\u0002082\u0006\u0010h\u001a\u00020V2\u0006\u0010S\u001a\u00020JH\u0016J \u0010o\u001a\u0002082\u0006\u0010h\u001a\u00020V2\u0006\u0010S\u001a\u00020J2\u0006\u0010\u0013\u001a\u00020\u0000H\u0002J\u001a\u0010o\u001a\u0002082\n\u0010l\u001a\u0006\u0012\u0002\b\u00030m2\u0006\u0010S\u001a\u00020JR\u001b\u0010\u0004\u001a\u00020\u00058FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0015\u001a\u0004\u0018\u00010\u00168VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u00020!X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u000e\u0010*\u001a\u00020!X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010+\u001a\u0004\u0018\u00010,@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/R(\u00102\u001a\u0004\u0018\u0001012\b\u00100\u001a\u0004\u0018\u000101@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106¨\u0006q"}, d2 = {"Lcom/vector/design/ui/frag/SimpleFragEx;", "Landroidx/fragment/app/Fragment;", "Lcom/vector/design/ui/UIHost;", "()V", "appBar", "Lcom/vector/design/ui/nav/AppBar;", "getAppBar", "()Lcom/vector/design/ui/nav/AppBar;", "appBar$delegate", "Lkotlin/Lazy;", "appBar2", "Lcom/vector/design/ui/nav/AppBar2;", "getAppBar2", "()Lcom/vector/design/ui/nav/AppBar2;", "appBar2$delegate", "classTag", "", "decorView", "Lcom/vector/design/ui/decor/DecorView;", "fragChild", "fragRoot", "hostView", "Landroid/view/View;", "getHostView", "()Landroid/view/View;", "idleHandler", "Landroid/os/MessageQueue$IdleHandler;", "getIdleHandler", "()Landroid/os/MessageQueue$IdleHandler;", "idleHandler$delegate", "idleLazyDelegate", "Lkotlin/Lazy;", "initializeFlowOver", "", "getInitializeFlowOver", "()Z", "setInitializeFlowOver", "(Z)V", "lazyLoadMode", "Lcom/vector/design/ui/frag/SimpleFragEx$LazyLoadMode;", "getLazyLoadMode", "()Lcom/vector/design/ui/frag/SimpleFragEx$LazyLoadMode;", "nativeIsVisible", "<set-?>", "Landroid/os/Bundle;", "savedInstanceState", "getSavedInstanceState", "()Landroid/os/Bundle;", "value", "Lcom/vector/design/ui/decor/ViewState;", "viewState", "getViewState", "()Lcom/vector/design/ui/decor/ViewState;", "setViewState", "(Lcom/vector/design/ui/decor/ViewState;)V", "addIdleHandler", "", "createBinding", "Landroidx/databinding/ViewDataBinding;", "createDecorView", "createErrorView", "Lcom/vector/design/ui/decor/ErrorViewEx;", "createLoadingView", "doOnLayout", "action", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "view", "doOnPreDraw", "findRootFragment", "findViewById", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "id", "", "(I)Landroid/view/View;", "getAppBarState", "Lcom/vector/config/AppBarState;", "getBindingView", "initDecorView", "initializeFlow", "onActivityCreated", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onGetLayoutInflater", "onPause", "onResultData", "onResume", "onRetryClick", "removeIdleHandler", "saveResponseChild", "fragment", "setLoadingBg", "color", "startActivity", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, NotificationCompat.MessagingStyle.Message.KEY_EXTRAS_BUNDLE, "", "(Landroid/content/Intent;[Landroid/os/Bundle;)V", "clz", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;[Landroid/os/Bundle;)V", "startActivityForResult", "LazyLoadMode", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public abstract class SimpleFragEx extends Fragment implements e.t.k.a.a {
    @d
    private final String a;
    @e
    private DecorView b;
    @d

    /* renamed from: c */
    private final w f7756c;
    @d

    /* renamed from: d */
    private final w f7757d;
    @e

    /* renamed from: e */
    private ViewState f7758e;
    @e

    /* renamed from: f */
    private Bundle f7759f;
    @d

    /* renamed from: g */
    private final LazyLoadMode f7760g;
    @d

    /* renamed from: h */
    private final w<MessageQueue.IdleHandler> f7761h;
    @d

    /* renamed from: i */
    private final w f7762i;

    /* renamed from: j */
    private boolean f7763j;

    /* renamed from: k */
    private boolean f7764k;
    @e

    /* renamed from: l */
    private SimpleFragEx f7765l;
    @e

    /* renamed from: m */
    private SimpleFragEx f7766m;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/vector/design/ui/frag/SimpleFragEx$LazyLoadMode;", "", "(Ljava/lang/String;I)V", "NONE", "IDLE", "RESUME", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public enum LazyLoadMode {
        NONE,
        IDLE,
        RESUME
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[LazyLoadMode.values().length];
            iArr[LazyLoadMode.NONE.ordinal()] = 1;
            iArr[LazyLoadMode.IDLE.ordinal()] = 2;
            a = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, d2 = {"com/vector/ext/view/ViewKt$doOnPreDraw$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class b implements ViewTreeObserver.OnPreDrawListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ boolean b;

        /* renamed from: c */
        public final /* synthetic */ ViewTreeObserver f7767c;

        /* renamed from: d */
        public final /* synthetic */ l f7768d;

        public b(View view, boolean z, ViewTreeObserver viewTreeObserver, l lVar) {
            this.a = view;
            this.b = z;
            this.f7767c = viewTreeObserver;
            this.f7768d = lVar;
        }

        @Override // android.view.ViewTreeObserver.OnPreDrawListener
        public boolean onPreDraw() {
            this.f7768d.invoke(this.a);
            if (this.b) {
                return true;
            }
            if (this.f7767c.isAlive()) {
                this.f7767c.removeOnPreDrawListener(this);
                return true;
            }
            this.a.getViewTreeObserver().removeOnPreDrawListener(this);
            return true;
        }
    }

    public SimpleFragEx() {
        String canonicalName = getClass().getCanonicalName();
        this.a = canonicalName == null ? "" : canonicalName;
        this.f7756c = z.c(new SimpleFragEx$appBar$2(this));
        this.f7757d = z.c(new SimpleFragEx$appBar2$2(this));
        this.f7760g = LazyLoadMode.NONE;
        w<MessageQueue.IdleHandler> c2 = z.c(new SimpleFragEx$idleLazyDelegate$1(this));
        this.f7761h = c2;
        this.f7762i = c2;
    }

    public final View C() {
        ViewDataBinding s = s();
        s.setLifecycleOwner(this);
        return s.getRoot();
    }

    private final MessageQueue.IdleHandler D() {
        return (MessageQueue.IdleHandler) this.f7762i.getValue();
    }

    private final void I() {
        DecorView t = t();
        this.b = t;
        if (t == null) {
            return;
        }
        t.setErrorClickListener(new View.OnClickListener() { // from class: e.t.k.a.g.b
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                SimpleFragEx.K(SimpleFragEx.this, view);
            }
        });
    }

    public static final void J(SimpleFragEx simpleFragEx, View view) {
        simpleFragEx.M();
    }

    public static /* synthetic */ void K(SimpleFragEx simpleFragEx, View view) {
        J(simpleFragEx, view);
    }

    private final void N() {
        if (this.f7761h.isInitialized()) {
            Looper.myQueue().removeIdleHandler(D());
        }
    }

    private final void O(SimpleFragEx simpleFragEx) {
        this.f7766m = simpleFragEx;
    }

    private final void r() {
        Looper.myQueue().addIdleHandler(D());
    }

    private final void y() {
        if (this.f7765l != null) {
            return;
        }
        SimpleFragEx simpleFragEx = (SimpleFragEx) getParentFragment();
        this.f7765l = simpleFragEx;
        if (simpleFragEx == null) {
            return;
        }
        while (true) {
            SimpleFragEx simpleFragEx2 = this.f7765l;
            Fragment fragment = null;
            if ((simpleFragEx2 == null ? null : simpleFragEx2.getParentFragment()) == null) {
                return;
            }
            SimpleFragEx simpleFragEx3 = this.f7765l;
            if (simpleFragEx3 != null) {
                fragment = simpleFragEx3.getParentFragment();
            }
            this.f7765l = (SimpleFragEx) fragment;
        }
    }

    @d
    public final AppBar2 A() {
        return (AppBar2) this.f7757d.getValue();
    }

    @e
    public AppBarState B() {
        return null;
    }

    public final boolean E() {
        return this.f7764k;
    }

    @d
    public LazyLoadMode F() {
        return this.f7760g;
    }

    @e
    public final Bundle G() {
        return this.f7759f;
    }

    @e
    public final ViewState H() {
        return this.f7758e;
    }

    public void L(int i2, int i3, @e Intent intent) {
    }

    public void M() {
    }

    public final void P(boolean z) {
        this.f7764k = z;
    }

    public final void Q(int i2) {
        DecorView decorView = this.b;
        if (decorView == null) {
            return;
        }
        decorView.setLoadingViewBg(i2);
    }

    public final void R(@e ViewState viewState) {
        if (viewState == null) {
            return;
        }
        DecorView decorView = this.b;
        if (decorView != null) {
            decorView.setViewState$vector_release(viewState);
        }
        this.f7758e = viewState;
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

    @e
    public <V extends View> V findViewById(int i2) {
        DecorView decorView = this.b;
        if (decorView == null) {
            return null;
        }
        return (V) decorView.findViewById(i2);
    }

    public synchronized void g() {
        if (this.f7764k) {
            return;
        }
        d();
        this.f7764k = true;
    }

    public void j() {
        a.C0411a.a(this);
    }

    @Override // e.t.k.a.a
    @e
    public View l() {
        return this.b;
    }

    @Override // e.t.k.a.a
    public void m(@DrawableRes int i2) {
        a.C0411a.g(this, i2);
    }

    @Override // e.t.k.a.a
    public void o(@e Drawable drawable) {
        a.C0411a.e(this, drawable);
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityCreated(@e Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.f7764k) {
            return;
        }
        j();
        int i2 = a.a[F().ordinal()];
        if (i2 == 1) {
            g();
        } else if (i2 != 2) {
        } else {
            r();
        }
    }

    @Override // androidx.fragment.app.Fragment
    @i(message = "Do not use this method to receive callbacks", replaceWith = @q0(expression = "this.onResultData", imports = {}))
    public final void onActivityResult(int i2, int i3, @e Intent intent) {
        SimpleFragEx simpleFragEx = this.f7766m;
        if (simpleFragEx == null) {
            L(i2, i3, intent);
        } else if (simpleFragEx == null) {
        } else {
            simpleFragEx.L(i2, i3, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    @e
    public View onCreateView(@d LayoutInflater layoutInflater, @e ViewGroup viewGroup, @e Bundle bundle) {
        this.f7759f = bundle;
        DecorView decorView = this.b;
        if (decorView != null) {
            return decorView;
        }
        e.t.u.l.a.c(this);
        I();
        f();
        return this.b;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        N();
        this.b = null;
    }

    @Override // androidx.fragment.app.Fragment
    @d
    public LayoutInflater onGetLayoutInflater(@e Bundle bundle) {
        Context context = getContext();
        if (context != null && !f0.g(context, super.getContext())) {
            return k.b(context);
        }
        return super.onGetLayoutInflater(bundle);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onPause() {
        super.onPause();
        e.t.t.a.a.g(getContext(), this.a);
    }

    @Override // androidx.fragment.app.Fragment
    @CallSuper
    public void onResume() {
        super.onResume();
        if (F() != LazyLoadMode.NONE) {
            if (F() == LazyLoadMode.IDLE) {
                N();
            }
            if (getHost() != null && !this.f7764k) {
                DecorView decorView = this.b;
                if (decorView != null) {
                    decorView.e();
                }
                g();
            }
        }
        e.t.t.a.a.h(getContext(), this.a);
    }

    @d
    public abstract ViewDataBinding s();

    public final void startActivity(@d h.p2.d<?> dVar, @d Bundle... bundleArr) {
        r.a.startActivity(this, dVar, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    @Override // androidx.fragment.app.Fragment
    public void startActivityForResult(@d Intent intent, int i2) {
        startActivityForResult(intent, i2, this);
    }

    @d
    public DecorView t() {
        return DecorView.n.a(requireContext(), new SimpleFragEx$createDecorView$1(this));
    }

    @e
    public ErrorViewEx u() {
        return null;
    }

    @e
    public View v() {
        return null;
    }

    public final void w(@d l<? super View, t1> lVar) {
        DecorView decorView = this.b;
        if (decorView == null) {
            return;
        }
        if (ViewCompat.isLaidOut(decorView) && !decorView.isLayoutRequested()) {
            lVar.invoke(decorView);
        } else {
            decorView.addOnLayoutChangeListener(new ViewKt.a(lVar));
        }
    }

    public final void x(@d l<? super View, t1> lVar) {
        DecorView decorView = this.b;
        if (decorView == null) {
            return;
        }
        ViewTreeObserver viewTreeObserver = decorView.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.addOnPreDrawListener(new b(decorView, false, viewTreeObserver, lVar));
        }
    }

    @d
    public final AppBar z() {
        return (AppBar) this.f7756c.getValue();
    }

    public final void startActivity(@d Intent intent, @d Bundle... bundleArr) {
        r.a.startActivity(this, intent, (Bundle[]) Arrays.copyOf(bundleArr, bundleArr.length));
    }

    public final void startActivityForResult(@d h.p2.d<?> dVar, int i2) {
        startActivityForResult(new Intent(getContext(), h.k2.a.c(dVar)), i2, this);
    }

    private final void startActivityForResult(Intent intent, int i2, SimpleFragEx simpleFragEx) {
        y();
        SimpleFragEx simpleFragEx2 = this.f7765l;
        if (simpleFragEx2 != null) {
            simpleFragEx2.O(simpleFragEx);
        }
        super.startActivityForResult(intent, i2);
    }
}
