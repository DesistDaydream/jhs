package com.vector.design.ui.decor;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.vector.config.AppBarState;
import com.vector.design.ui.nav.AppBar;
import com.vector.design.ui.nav.AppBar2;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.t.l.h;
import e.t.u.p;
import h.k2.u.l;
import h.k2.v.u;
import h.t1;
import h.w;
import h.z;
import k.e.a.d;
import k.e.a.e;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 S2\u00020\u0001:\u0001SB%\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u000106H\u0002J\u001a\u0010K\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u0001062\u0006\u0010L\u001a\u00020\u0007H\u0002J\u0006\u0010M\u001a\u00020IJ\b\u0010N\u001a\u000200H\u0002J\b\u0010O\u001a\u00020IH\u0002J\b\u0010P\u001a\u00020IH\u0002J\u000e\u0010Q\u001a\u00020I2\u0006\u0010R\u001a\u00020\u0007R\u001b\u0010\t\u001a\u00020\n8@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00108@X\u0080\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u000e\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010#\u001a\u0004\u0018\u00010$X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001c\u0010)\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001a\u0010/\u001a\u000200X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001c\u00105\u001a\u0004\u0018\u000106X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001c\u0010;\u001a\u0004\u0018\u00010*X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010,\"\u0004\b=\u0010.R\u001c\u0010>\u001a\u0004\u0018\u000106X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u00108\"\u0004\b@\u0010:R$\u0010C\u001a\u00020B2\u0006\u0010A\u001a\u00020B@@X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010G¨\u0006T"}, d2 = {"Lcom/vector/design/ui/decor/DecorView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appBar", "Lcom/vector/design/ui/nav/AppBar;", "getAppBar$vector_release", "()Lcom/vector/design/ui/nav/AppBar;", "appBar$delegate", "Lkotlin/Lazy;", "appBar2", "Lcom/vector/design/ui/nav/AppBar2;", "getAppBar2$vector_release", "()Lcom/vector/design/ui/nav/AppBar2;", "appBar2$delegate", "appBarDelegate", "Lkotlin/Lazy;", "appBarDelegate2", "appBarState", "Lcom/vector/config/AppBarState;", "getAppBarState$vector_release", "()Lcom/vector/config/AppBarState;", "setAppBarState$vector_release", "(Lcom/vector/config/AppBarState;)V", "contentView", "Lcom/vector/design/ui/decor/PlaceHolder;", "getContentView$vector_release", "()Lcom/vector/design/ui/decor/PlaceHolder;", "setContentView$vector_release", "(Lcom/vector/design/ui/decor/PlaceHolder;)V", "errorClickListener", "Landroid/view/View$OnClickListener;", "getErrorClickListener", "()Landroid/view/View$OnClickListener;", "setErrorClickListener", "(Landroid/view/View$OnClickListener;)V", "errorView", "Lcom/vector/design/ui/decor/ErrorViewEx;", "getErrorView$vector_release", "()Lcom/vector/design/ui/decor/ErrorViewEx;", "setErrorView$vector_release", "(Lcom/vector/design/ui/decor/ErrorViewEx;)V", "lazyLoad", "", "getLazyLoad$vector_release", "()Z", "setLazyLoad$vector_release", "(Z)V", "loadingView", "Landroid/view/View;", "getLoadingView$vector_release", "()Landroid/view/View;", "setLoadingView$vector_release", "(Landroid/view/View;)V", "setUpErrorView", "getSetUpErrorView$vector_release", "setSetUpErrorView$vector_release", "setUpLoadingView", "getSetUpLoadingView$vector_release", "setSetUpLoadingView$vector_release", "value", "Lcom/vector/design/ui/decor/ViewState;", "viewState", "getViewState$vector_release", "()Lcom/vector/design/ui/decor/ViewState;", "setViewState$vector_release", "(Lcom/vector/design/ui/decor/ViewState;)V", "add", "", "v", "belowId", "id", "inflate", "isFloating", "newError", "newLoading", "setLoadingViewBg", "color", "Companion", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class DecorView extends RelativeLayout {
    @d
    public static final a n = new a(null);
    @e
    private PlaceHolder a;
    @e
    private AppBarState b;
    @d

    /* renamed from: c */
    private ViewState f7737c;
    @d

    /* renamed from: d */
    private final w<AppBar> f7738d;
    @d

    /* renamed from: e */
    private final w<AppBar2> f7739e;
    @d

    /* renamed from: f */
    private final w f7740f;
    @d

    /* renamed from: g */
    private final w f7741g;
    @e

    /* renamed from: h */
    private ErrorViewEx f7742h;
    @e

    /* renamed from: i */
    private View f7743i;
    @e

    /* renamed from: j */
    private View f7744j;
    @e

    /* renamed from: k */
    private ErrorViewEx f7745k;
    @e

    /* renamed from: l */
    private View.OnClickListener f7746l;

    /* renamed from: m */
    private boolean f7747m;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/vector/design/ui/decor/DecorView$Companion;", "", "()V", "create", "Lcom/vector/design/ui/decor/DecorView;", "context", "Landroid/content/Context;", "action", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(u uVar) {
            this();
        }

        @d
        public final DecorView a(@d Context context, @d l<? super DecorView, t1> lVar) {
            DecorView decorView = new DecorView(context, null, 0, 6, null);
            lVar.invoke(decorView);
            RelativeLayout.LayoutParams p = p.p(-1, -1);
            if (!decorView.getLazyLoad$vector_release()) {
                PlaceHolder contentView$vector_release = decorView.getContentView$vector_release();
                if (contentView$vector_release != null) {
                    contentView$vector_release.b(decorView, p);
                }
            } else {
                decorView.addView(decorView.getContentView$vector_release(), p);
            }
            return decorView;
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ViewState.values().length];
            iArr[ViewState.NORMAL.ordinal()] = 1;
            iArr[ViewState.LOADING.ordinal()] = 2;
            iArr[ViewState.ERROR.ordinal()] = 3;
            a = iArr;
        }
    }

    public /* synthetic */ DecorView(Context context, AttributeSet attributeSet, int i2, int i3, u uVar) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    private final void c(View view) {
        RelativeLayout.LayoutParams p = p.p(-1, -1);
        if (this.f7738d.isInitialized() && !f()) {
            p.addRule(3, getAppBar$vector_release().getId());
        }
        if (this.f7739e.isInitialized() && !f()) {
            p.addRule(3, getAppBar2$vector_release().getId());
        }
        addView(view, p);
    }

    public final void d(View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view == null ? null : view.getLayoutParams();
        if (layoutParams != null && (layoutParams instanceof RelativeLayout.LayoutParams)) {
            ((RelativeLayout.LayoutParams) layoutParams).addRule(3, i2);
        }
        new h();
    }

    public final boolean f() {
        AppBarState appBarState = this.b;
        if (appBarState == null) {
            appBarState = AppBar.f7769h.a().o();
        }
        return appBarState == AppBarState.FLOATING;
    }

    private final void g() {
        if (this.f7742h == null) {
            ErrorViewEx errorViewEx = this.f7745k;
            if (errorViewEx == null) {
                l<Context, ErrorViewEx> f2 = e.t.a.a().f();
                errorViewEx = f2 == null ? null : f2.invoke(getContext());
                if (errorViewEx == null) {
                    errorViewEx = new ErrorViewImpl(getContext(), null, 0, 6, null);
                }
            }
            this.f7742h = errorViewEx;
            c(errorViewEx);
            ErrorViewEx errorViewEx2 = this.f7742h;
            if (errorViewEx2 == null) {
                return;
            }
            errorViewEx2.setListener(this.f7746l);
        }
    }

    private final void h() {
        if (this.f7743i == null) {
            View view = this.f7744j;
            if (view == null) {
                l<Context, View> i2 = e.t.a.a().i();
                view = i2 == null ? null : i2.invoke(getContext());
                if (view == null) {
                    view = new LoadingView(getContext(), null, 0, 6, null);
                }
            }
            this.f7743i = view;
            c(view);
        }
    }

    public final void e() {
        PlaceHolder placeHolder;
        if (!this.f7747m || (placeHolder = this.a) == null) {
            return;
        }
        placeHolder.a();
    }

    @d
    public final AppBar getAppBar$vector_release() {
        return (AppBar) this.f7740f.getValue();
    }

    @d
    public final AppBar2 getAppBar2$vector_release() {
        return (AppBar2) this.f7741g.getValue();
    }

    @e
    public final AppBarState getAppBarState$vector_release() {
        return this.b;
    }

    @e
    public final PlaceHolder getContentView$vector_release() {
        return this.a;
    }

    @e
    public final View.OnClickListener getErrorClickListener() {
        return this.f7746l;
    }

    @e
    public final ErrorViewEx getErrorView$vector_release() {
        return this.f7742h;
    }

    public final boolean getLazyLoad$vector_release() {
        return this.f7747m;
    }

    @e
    public final View getLoadingView$vector_release() {
        return this.f7743i;
    }

    @e
    public final ErrorViewEx getSetUpErrorView$vector_release() {
        return this.f7745k;
    }

    @e
    public final View getSetUpLoadingView$vector_release() {
        return this.f7744j;
    }

    @d
    public final ViewState getViewState$vector_release() {
        return this.f7737c;
    }

    public final void setAppBarState$vector_release(@e AppBarState appBarState) {
        this.b = appBarState;
    }

    public final void setContentView$vector_release(@e PlaceHolder placeHolder) {
        this.a = placeHolder;
    }

    public final void setErrorClickListener(@e View.OnClickListener onClickListener) {
        this.f7746l = onClickListener;
    }

    public final void setErrorView$vector_release(@e ErrorViewEx errorViewEx) {
        this.f7742h = errorViewEx;
    }

    public final void setLazyLoad$vector_release(boolean z) {
        this.f7747m = z;
    }

    public final void setLoadingView$vector_release(@e View view) {
        this.f7743i = view;
    }

    public final void setLoadingViewBg(int i2) {
        h();
        View view = this.f7743i;
        if (view == null) {
            return;
        }
        view.setBackgroundColor(i2);
    }

    public final void setSetUpErrorView$vector_release(@e ErrorViewEx errorViewEx) {
        this.f7745k = errorViewEx;
    }

    public final void setSetUpLoadingView$vector_release(@e View view) {
        this.f7744j = view;
    }

    public final void setViewState$vector_release(@d ViewState viewState) {
        if (this.f7737c == viewState) {
            return;
        }
        this.f7737c = viewState;
        int i2 = b.a[viewState.ordinal()];
        if (i2 == 1) {
            ViewKt.I(this.a);
            ViewKt.n(this.f7742h);
            ViewKt.n(this.f7743i);
        } else if (i2 == 2) {
            h();
            ViewKt.I(this.f7743i);
            ViewKt.n(this.a);
            ViewKt.n(this.f7742h);
        } else if (i2 != 3) {
        } else {
            g();
            ViewKt.I(this.f7742h);
            ViewKt.n(this.a);
            ViewKt.n(this.f7743i);
        }
    }

    private DecorView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f7737c = ViewState.NORMAL;
        w<AppBar> c2 = z.c(new DecorView$appBarDelegate$1(context, this));
        this.f7738d = c2;
        w<AppBar2> c3 = z.c(new DecorView$appBarDelegate2$1(context, this));
        this.f7739e = c3;
        this.f7740f = c2;
        this.f7741g = c3;
        setLayoutParams(p.v(-1, -1));
        e.t.i.a a2 = e.t.a.a();
        if (a2.c() != 0) {
            setBackgroundResource(a2.c());
        } else if (a2.b() != 0) {
            setBackgroundColor(Res.k(a2.b()));
        }
    }
}
