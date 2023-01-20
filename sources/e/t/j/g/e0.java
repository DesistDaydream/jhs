package e.t.j.g;

import android.annotation.SuppressLint;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ScrollView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.core.view.ViewCompat;
import androidx.databinding.BindingAdapter;
import com.vector.ext.view.ViewKt;
import com.vector.util.Res;
import e.t.j.h.k0;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"H\u0007J\u0018\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020 2\u0006\u0010!\u001a\u00020%H\u0007J\u0018\u0010&\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010'\u001a\u00020(H\u0007J\u001a\u0010)\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010*\u001a\u00020(H\u0007J\u001a\u0010+\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010,\u001a\u00020(H\u0007J\u001a\u0010-\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\b\u0001\u0010*\u001a\u00020(H\u0007J\u0018\u0010.\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010/\u001a\u000200H\u0007J\u0018\u00101\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u00020(H\u0007J\u0018\u00103\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00104\u001a\u00020(H\u0007J\u0018\u00105\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00104\u001a\u00020(H\u0007J\u0018\u00106\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00104\u001a\u00020(H\u0007J\u0018\u00107\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00104\u001a\u00020(H\u0007J\u0018\u00108\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u00102\u001a\u00020(H\u0007J\u0018\u00109\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010:\u001a\u00020(H\u0007J\u001e\u0010;\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\f\u0010<\u001a\b\u0012\u0004\u0012\u00020 0=H\u0007J\u0018\u0010;\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020>H\u0007J\u0018\u0010?\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020@H\u0007J\u0018\u0010A\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020BH\u0007J\u001a\u0010C\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010>H\u0007J\u0018\u0010D\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020EH\u0007J\u0018\u0010F\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010G\u001a\u000200H\u0007J\u0018\u0010H\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010I\u001a\u000200H\u0007J\u001a\u0010H\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010 H\u0007J\u001f\u0010L\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020M2\b\u0010N\u001a\u0004\u0018\u000100H\u0007¢\u0006\u0002\u0010OJ\u0018\u0010P\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010Q\u001a\u000200H\u0007J\u0018\u0010R\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010:\u001a\u00020(H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006S"}, d2 = {"Lcom/vector/databinding/adapter/ViewBinding;", "", "()V", "ADD_VIEW", "", "BACKGROUND_ALPHA", "BACKGROUND_RES", "COLOR_INT", "COLOR_RES", "ENABLED", "KEY_LISTENER", "LAYOUT_HEIGHT", "LAYOUT_MARGIN_BOTTOM", "LAYOUT_MARGIN_END", "LAYOUT_MARGIN_START", "LAYOUT_MARGIN_TOP", "LAYOUT_WIDTH", "MIN_HEIGHT", "MIN_WIDTH", "ON_CLICK", "ON_FOCUS_CHANGED", "ON_LAYOUT", "ON_LONG_CLICK", "ON_SCROLL_TOUCH", "ON_SINGLE_CLICK", "ON_TOUCH", "REQUEST_FOCUS", "REQUEST_SELECTED", "VISIBILITY", "doOnLayout", "", "view", "Landroid/view/View;", "binding", "Lcom/vector/databinding/onBind/OnLayoutBinding;", "keyListener", "v", "Lcom/vector/databinding/onBind/OnKeyBinding;", "setBackgroundAlpha", "alpha", "", "setBackgroundColor", "id", "setBackgroundColorInt", "color", "setBackgroundInt", "setEnabled", "enabled", "", "setHeight", "height", "setLayoutMarginBottom", "margin", "setLayoutMarginEnd", "setLayoutMarginStart", "setLayoutMarginTop", "setMinHeight", "setMinWidth", "width", "setOnClick", "live", "Lcom/live/Live;", "Lcom/vector/databinding/onBind/OnClickBinding;", "setOnFocusChanged", "Lcom/vector/databinding/onBind/OnFocusChangedBinding;", "setOnLongClick", "Lcom/vector/databinding/onBind/OnLongClickBinding;", "setOnSingleClick", "setOnTouch", "Lcom/vector/databinding/onBind/OnTouchBinding;", "setRequestFocus", "focus", "setRequestSelected", "isSelected", "Landroid/view/ViewGroup;", "addView", "setScrollTouch", "Landroid/widget/ScrollView;", "b", "(Landroid/widget/ScrollView;Ljava/lang/Boolean;)V", "setVisibility", "visible", "setWidth", "vector_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class e0 {
    @k.e.a.d
    public static final e0 a = new e0();
    @k.e.a.d
    private static final String b = "android:view_requestFocus";
    @k.e.a.d

    /* renamed from: c */
    private static final String f14488c = "android:view_onClick";
    @k.e.a.d

    /* renamed from: d */
    private static final String f14489d = "android:view_onLongClick";
    @k.e.a.d

    /* renamed from: e */
    private static final String f14490e = "android:view_onSingleClick";
    @k.e.a.d

    /* renamed from: f */
    private static final String f14491f = "android:view_onFocusChanged";
    @k.e.a.d

    /* renamed from: g */
    private static final String f14492g = "android:view_onTouch";
    @k.e.a.d

    /* renamed from: h */
    private static final String f14493h = "android:view_scrollTouch";
    @k.e.a.d

    /* renamed from: i */
    private static final String f14494i = "android:view_isSelected";
    @k.e.a.d

    /* renamed from: j */
    private static final String f14495j = "android:visibility";
    @k.e.a.d

    /* renamed from: k */
    private static final String f14496k = "android:enabled";
    @k.e.a.d

    /* renamed from: l */
    private static final String f14497l = "android:backgroundColor";
    @k.e.a.d

    /* renamed from: m */
    private static final String f14498m = "android:backgroundColorInt";
    @k.e.a.d
    private static final String n = "android:backgroundRes";
    @k.e.a.d
    private static final String o = "android:view_backgroundAlpha";
    @k.e.a.d
    private static final String p = "android:layout_marginTop";
    @k.e.a.d
    private static final String q = "android:layout_marginStart";
    @k.e.a.d
    private static final String r = "android:layout_marginEnd";
    @k.e.a.d
    private static final String s = "android:layout_marginBottom";
    @k.e.a.d
    private static final String t = "android:view_layoutWidth";
    @k.e.a.d
    private static final String u = "android:view_layoutHeight";
    @k.e.a.d
    private static final String v = "android:view_minHeight";
    @k.e.a.d
    private static final String w = "android:view_minWidth";
    @k.e.a.d
    private static final String x = "android:view_onLayout";
    @k.e.a.d
    private static final String y = "android:add_view";
    @k.e.a.d
    private static final String z = "android:view_keyListener";

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JP\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007H\u0016¨\u0006\u000f¸\u0006\u0010"}, d2 = {"com/vector/ext/view/ViewKt$doOnNextLayout$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "view", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "vector_release", "com/vector/ext/view/ViewKt$doOnLayout$$inlined$doOnNextLayout$1"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* loaded from: classes3.dex */
    public static final class a implements View.OnLayoutChangeListener {
        public final /* synthetic */ e.t.j.h.o a;

        public a(e.t.j.h.o oVar) {
            this.a = oVar;
        }

        @Override // android.view.View.OnLayoutChangeListener
        public void onLayoutChange(@k.e.a.d View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
            view.removeOnLayoutChangeListener(this);
            this.a.a().invoke(view);
        }
    }

    private e0() {
    }

    public static final void A(e.n.f fVar, View view) {
        fVar.setValue(view);
    }

    @BindingAdapter({f14491f})
    @h.k2.k
    public static final void B(@k.e.a.d View view, @k.e.a.d final e.t.j.h.i iVar) {
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() { // from class: e.t.j.g.k
            @Override // android.view.View.OnFocusChangeListener
            public final void onFocusChange(View view2, boolean z2) {
                e0.C(iVar, view2, z2);
            }
        });
    }

    public static final void C(e.t.j.h.i iVar, View view, boolean z2) {
        iVar.a().invoke(view, Boolean.valueOf(z2));
    }

    @BindingAdapter({f14489d})
    @h.k2.k
    public static final void D(@k.e.a.d View view, @k.e.a.d final e.t.j.h.s sVar) {
        view.setOnLongClickListener(new View.OnLongClickListener() { // from class: e.t.j.g.o
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view2) {
                boolean E;
                E = e0.E(sVar, view2);
                return E;
            }
        });
    }

    public static final boolean E(e.t.j.h.s sVar, View view) {
        return sVar.a().invoke(view).booleanValue();
    }

    @BindingAdapter({f14490e})
    @h.k2.k
    public static final void F(@k.e.a.d View view, @k.e.a.e e.t.j.h.g gVar) {
        if (gVar == null) {
            return;
        }
        ViewKt.B(view, gVar.a());
    }

    @BindingAdapter({f14492g})
    @h.k2.k
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void G(@k.e.a.d View view, @k.e.a.d final k0 k0Var) {
        view.setOnTouchListener(new View.OnTouchListener() { // from class: e.t.j.g.i
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                boolean H;
                H = e0.H(k0Var, view2, motionEvent);
                return H;
            }
        });
    }

    public static final boolean H(k0 k0Var, View view, MotionEvent motionEvent) {
        return k0Var.a().invoke(view, motionEvent).booleanValue();
    }

    @BindingAdapter({b})
    @h.k2.k
    public static final void I(@k.e.a.d final View view, final boolean z2) {
        view.post(new Runnable() { // from class: e.t.j.g.n
            @Override // java.lang.Runnable
            public final void run() {
                e0.J(z2, view);
            }
        });
    }

    public static final void J(boolean z2, View view) {
        if (z2) {
            view.setFocusable(true);
            view.setFocusableInTouchMode(true);
            view.requestFocus();
        } else if (z2) {
        } else {
            view.clearFocus();
        }
    }

    @BindingAdapter({f14494i})
    @h.k2.k
    public static final void K(@k.e.a.d View view, boolean z2) {
        view.setSelected(z2);
    }

    @BindingAdapter({y})
    @h.k2.k
    public static final void L(@k.e.a.d ViewGroup viewGroup, @k.e.a.e View view) {
        if (view == null) {
            return;
        }
        if (view.getParent() == null) {
            viewGroup.addView(view);
        } else if (h.k2.v.f0.g(view.getParent(), viewGroup)) {
        } else {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup2 = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup2 != null) {
                viewGroup2.removeView(view);
            }
            viewGroup.addView(view);
        }
    }

    @BindingAdapter({f14493h})
    @h.k2.k
    @SuppressLint({"ClickableViewAccessibility"})
    public static final void M(@k.e.a.d final ScrollView scrollView, @k.e.a.e Boolean bool) {
        if (h.k2.v.f0.g(bool, Boolean.TRUE)) {
            scrollView.setOverScrollMode(2);
            scrollView.setOnTouchListener(new View.OnTouchListener() { // from class: e.t.j.g.l
                @Override // android.view.View.OnTouchListener
                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    boolean N;
                    N = e0.N(scrollView, view, motionEvent);
                    return N;
                }
            });
        }
    }

    public static final boolean N(ScrollView scrollView, View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 2) {
            scrollView.requestDisallowInterceptTouchEvent(true);
        } else {
            scrollView.requestDisallowInterceptTouchEvent(false);
        }
        return false;
    }

    @BindingAdapter({f14495j})
    @h.k2.k
    public static final void O(@k.e.a.d View view, boolean z2) {
        if (z2) {
            ViewKt.I(view);
        } else {
            ViewKt.n(view);
        }
    }

    @BindingAdapter({t})
    @h.k2.k
    public static final void P(@k.e.a.d View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i2;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter({x})
    @h.k2.k
    public static final void a(@k.e.a.d View view, @k.e.a.d e.t.j.h.o oVar) {
        if (ViewCompat.isLaidOut(view) && !view.isLayoutRequested()) {
            oVar.a().invoke(view);
        } else {
            view.addOnLayoutChangeListener(new a(oVar));
        }
    }

    @BindingAdapter({z})
    @h.k2.k
    public static final void b(@k.e.a.d View view, @k.e.a.d final e.t.j.h.n nVar) {
        view.setOnKeyListener(new View.OnKeyListener() { // from class: e.t.j.g.j
            @Override // android.view.View.OnKeyListener
            public final boolean onKey(View view2, int i2, KeyEvent keyEvent) {
                boolean c2;
                c2 = e0.c(nVar, view2, i2, keyEvent);
                return c2;
            }
        });
    }

    public static final boolean c(e.t.j.h.n nVar, View view, int i2, KeyEvent keyEvent) {
        return nVar.a().invoke(view, Integer.valueOf(i2), keyEvent).booleanValue();
    }

    @BindingAdapter({o})
    @h.k2.k
    public static final void l(@k.e.a.d View view, int i2) {
        view.getBackground().setAlpha(i2);
    }

    @BindingAdapter({f14497l})
    @h.k2.k
    public static final void m(@k.e.a.d View view, @ColorRes int i2) {
        view.setBackgroundColor(Res.k(i2));
    }

    @BindingAdapter({f14498m})
    @h.k2.k
    public static final void n(@k.e.a.d View view, @ColorInt int i2) {
        view.setBackgroundColor(i2);
    }

    @BindingAdapter({n})
    @h.k2.k
    public static final void o(@k.e.a.d View view, @DrawableRes int i2) {
        if (i2 == 0) {
            return;
        }
        ViewCompat.setBackground(view, Res.a.p(view.getContext(), i2));
    }

    @BindingAdapter({f14496k})
    @h.k2.k
    public static final void p(@k.e.a.d View view, boolean z2) {
        view.setEnabled(z2);
    }

    @BindingAdapter({u})
    @h.k2.k
    public static final void q(@k.e.a.d View view, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    @BindingAdapter({s})
    @h.k2.k
    public static final void r(@k.e.a.d View view, int i2) {
        ViewKt.w(view, null, null, null, Integer.valueOf(i2), 7, null);
    }

    @BindingAdapter({r})
    @h.k2.k
    public static final void s(@k.e.a.d View view, int i2) {
        ViewKt.w(view, null, null, Integer.valueOf(i2), null, 11, null);
    }

    @BindingAdapter({q})
    @h.k2.k
    public static final void t(@k.e.a.d View view, int i2) {
        ViewKt.w(view, Integer.valueOf(i2), null, null, null, 14, null);
    }

    @BindingAdapter({p})
    @h.k2.k
    public static final void u(@k.e.a.d View view, int i2) {
        ViewKt.w(view, null, Integer.valueOf(i2), null, null, 13, null);
    }

    @BindingAdapter({v})
    @h.k2.k
    public static final void v(@k.e.a.d View view, int i2) {
        view.setMinimumHeight(i2);
    }

    @BindingAdapter({w})
    @h.k2.k
    public static final void w(@k.e.a.d View view, int i2) {
        view.setMinimumWidth(i2);
    }

    @BindingAdapter({f14488c})
    @h.k2.k
    public static final void x(@k.e.a.d View view, @k.e.a.d final e.n.f<View> fVar) {
        view.setOnClickListener(new View.OnClickListener() { // from class: e.t.j.g.h
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e0.A(fVar, view2);
            }
        });
    }

    @BindingAdapter({f14488c})
    @h.k2.k
    public static final void y(@k.e.a.d View view, @k.e.a.d final e.t.j.h.g gVar) {
        view.setOnClickListener(new View.OnClickListener() { // from class: e.t.j.g.m
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                e0.z(gVar, view2);
            }
        });
    }

    public static final void z(e.t.j.h.g gVar, View view) {
        gVar.a().invoke(view);
    }
}
