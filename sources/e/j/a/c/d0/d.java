package e.j.a.c.d0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;
import e.j.a.c.s.l;
import e.j.a.c.z.o;

/* loaded from: classes2.dex */
public class d extends e.j.a.c.d0.e {
    private static final boolean q;
    private static final int r = 50;
    private static final int s = 67;

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f10606d;

    /* renamed from: e  reason: collision with root package name */
    private final View.OnFocusChangeListener f10607e;

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.e f10608f;

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.h f10609g;
    @SuppressLint({"ClickableViewAccessibility"})

    /* renamed from: h  reason: collision with root package name */
    private final TextInputLayout.i f10610h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f10611i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10612j;

    /* renamed from: k  reason: collision with root package name */
    private long f10613k;

    /* renamed from: l  reason: collision with root package name */
    private StateListDrawable f10614l;

    /* renamed from: m  reason: collision with root package name */
    private e.j.a.c.z.j f10615m;
    @Nullable
    private AccessibilityManager n;
    private ValueAnimator o;
    private ValueAnimator p;

    /* loaded from: classes2.dex */
    public class a extends l {

        /* renamed from: e.j.a.c.d0.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0355a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public RunnableC0355a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                boolean isPopupShowing = this.a.isPopupShowing();
                d.this.E(isPopupShowing);
                d.this.f10611i = isPopupShowing;
            }
        }

        public a() {
        }

        @Override // e.j.a.c.s.l, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            AutoCompleteTextView y = d.y(d.this.a.getEditText());
            if (d.this.n.isTouchExplorationEnabled() && d.D(y) && !d.this.f10616c.hasFocus()) {
                y.dismissDropDown();
            }
            y.post(new RunnableC0355a(y));
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            d.this.f10616c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }
    }

    /* loaded from: classes2.dex */
    public class c implements View.OnFocusChangeListener {
        public c() {
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view, boolean z) {
            d.this.a.setEndIconActivated(z);
            if (z) {
                return;
            }
            d.this.E(false);
            d.this.f10611i = false;
        }
    }

    /* renamed from: e.j.a.c.d0.d$d  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0356d extends TextInputLayout.e {
        public C0356d(TextInputLayout textInputLayout) {
            super(textInputLayout);
        }

        @Override // com.google.android.material.textfield.TextInputLayout.e, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (!d.D(d.this.a.getEditText())) {
                accessibilityNodeInfoCompat.setClassName(Spinner.class.getName());
            }
            if (accessibilityNodeInfoCompat.isShowingHintText()) {
                accessibilityNodeInfoCompat.setHintText(null);
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, @NonNull AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            AutoCompleteTextView y = d.y(d.this.a.getEditText());
            if (accessibilityEvent.getEventType() == 1 && d.this.n.isTouchExplorationEnabled() && !d.D(d.this.a.getEditText())) {
                d.this.H(y);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class e implements TextInputLayout.h {
        public e() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.h
        public void a(@NonNull TextInputLayout textInputLayout) {
            AutoCompleteTextView y = d.y(textInputLayout.getEditText());
            d.this.F(y);
            d.this.v(y);
            d.this.G(y);
            y.setThreshold(0);
            y.removeTextChangedListener(d.this.f10606d);
            y.addTextChangedListener(d.this.f10606d);
            textInputLayout.setEndIconCheckable(true);
            textInputLayout.setErrorIconDrawable((Drawable) null);
            if (!d.D(y)) {
                ViewCompat.setImportantForAccessibility(d.this.f10616c, 2);
            }
            textInputLayout.setTextInputAccessibilityDelegate(d.this.f10608f);
            textInputLayout.setEndIconVisible(true);
        }
    }

    /* loaded from: classes2.dex */
    public class f implements TextInputLayout.i {

        /* loaded from: classes2.dex */
        public class a implements Runnable {
            public final /* synthetic */ AutoCompleteTextView a;

            public a(AutoCompleteTextView autoCompleteTextView) {
                this.a = autoCompleteTextView;
            }

            @Override // java.lang.Runnable
            public void run() {
                this.a.removeTextChangedListener(d.this.f10606d);
            }
        }

        public f() {
        }

        @Override // com.google.android.material.textfield.TextInputLayout.i
        public void a(@NonNull TextInputLayout textInputLayout, int i2) {
            AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) textInputLayout.getEditText();
            if (autoCompleteTextView == null || i2 != 3) {
                return;
            }
            autoCompleteTextView.post(new a(autoCompleteTextView));
            if (autoCompleteTextView.getOnFocusChangeListener() == d.this.f10607e) {
                autoCompleteTextView.setOnFocusChangeListener(null);
            }
            autoCompleteTextView.setOnTouchListener(null);
            if (d.q) {
                autoCompleteTextView.setOnDismissListener(null);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements View.OnClickListener {
        public g() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.H((AutoCompleteTextView) d.this.a.getEditText());
        }
    }

    /* loaded from: classes2.dex */
    public class h implements View.OnTouchListener {
        public final /* synthetic */ AutoCompleteTextView a;

        public h(AutoCompleteTextView autoCompleteTextView) {
            this.a = autoCompleteTextView;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(@NonNull View view, @NonNull MotionEvent motionEvent) {
            if (motionEvent.getAction() == 1) {
                if (d.this.C()) {
                    d.this.f10611i = false;
                }
                d.this.H(this.a);
            }
            return false;
        }
    }

    /* loaded from: classes2.dex */
    public class i implements AutoCompleteTextView.OnDismissListener {
        public i() {
        }

        @Override // android.widget.AutoCompleteTextView.OnDismissListener
        public void onDismiss() {
            d.this.f10611i = true;
            d.this.f10613k = System.currentTimeMillis();
            d.this.E(false);
        }
    }

    /* loaded from: classes2.dex */
    public class j extends AnimatorListenerAdapter {
        public j() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            d dVar = d.this;
            dVar.f10616c.setChecked(dVar.f10612j);
            d.this.p.start();
        }
    }

    static {
        q = Build.VERSION.SDK_INT >= 21;
    }

    public d(@NonNull TextInputLayout textInputLayout) {
        super(textInputLayout);
        this.f10606d = new a();
        this.f10607e = new c();
        this.f10608f = new C0356d(this.a);
        this.f10609g = new e();
        this.f10610h = new f();
        this.f10611i = false;
        this.f10612j = false;
        this.f10613k = Long.MAX_VALUE;
    }

    private e.j.a.c.z.j A(float f2, float f3, float f4, int i2) {
        o m2 = o.a().K(f2).P(f2).x(f3).C(f3).m();
        e.j.a.c.z.j n = e.j.a.c.z.j.n(this.b, f4);
        n.setShapeAppearanceModel(m2);
        n.p0(0, i2, 0, i2);
        return n;
    }

    private void B() {
        this.p = z(67, 0.0f, 1.0f);
        ValueAnimator z = z(50, 1.0f, 0.0f);
        this.o = z;
        z.addListener(new j());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        long currentTimeMillis = System.currentTimeMillis() - this.f10613k;
        return currentTimeMillis < 0 || currentTimeMillis > 300;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean D(@NonNull EditText editText) {
        return editText.getKeyListener() != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(boolean z) {
        if (this.f10612j != z) {
            this.f10612j = z;
            this.p.cancel();
            this.o.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void F(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (q) {
            int boxBackgroundMode = this.a.getBoxBackgroundMode();
            if (boxBackgroundMode == 2) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f10615m);
            } else if (boxBackgroundMode == 1) {
                autoCompleteTextView.setDropDownBackgroundDrawable(this.f10614l);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"ClickableViewAccessibility"})
    public void G(@NonNull AutoCompleteTextView autoCompleteTextView) {
        autoCompleteTextView.setOnTouchListener(new h(autoCompleteTextView));
        autoCompleteTextView.setOnFocusChangeListener(this.f10607e);
        if (q) {
            autoCompleteTextView.setOnDismissListener(new i());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H(@Nullable AutoCompleteTextView autoCompleteTextView) {
        if (autoCompleteTextView == null) {
            return;
        }
        if (C()) {
            this.f10611i = false;
        }
        if (!this.f10611i) {
            if (q) {
                E(!this.f10612j);
            } else {
                this.f10612j = !this.f10612j;
                this.f10616c.toggle();
            }
            if (this.f10612j) {
                autoCompleteTextView.requestFocus();
                autoCompleteTextView.showDropDown();
                return;
            }
            autoCompleteTextView.dismissDropDown();
            return;
        }
        this.f10611i = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void v(@NonNull AutoCompleteTextView autoCompleteTextView) {
        if (D(autoCompleteTextView)) {
            return;
        }
        int boxBackgroundMode = this.a.getBoxBackgroundMode();
        e.j.a.c.z.j boxBackground = this.a.getBoxBackground();
        int d2 = e.j.a.c.l.a.d(autoCompleteTextView, R.attr.colorControlHighlight);
        int[][] iArr = {new int[]{16842919}, new int[0]};
        if (boxBackgroundMode == 2) {
            x(autoCompleteTextView, d2, iArr, boxBackground);
        } else if (boxBackgroundMode == 1) {
            w(autoCompleteTextView, d2, iArr, boxBackground);
        }
    }

    private void w(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull e.j.a.c.z.j jVar) {
        int boxBackgroundColor = this.a.getBoxBackgroundColor();
        int[] iArr2 = {e.j.a.c.l.a.h(i2, boxBackgroundColor, 0.1f), boxBackgroundColor};
        if (q) {
            ViewCompat.setBackground(autoCompleteTextView, new RippleDrawable(new ColorStateList(iArr, iArr2), jVar, jVar));
            return;
        }
        e.j.a.c.z.j jVar2 = new e.j.a.c.z.j(jVar.getShapeAppearanceModel());
        jVar2.n0(new ColorStateList(iArr, iArr2));
        LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{jVar, jVar2});
        int paddingStart = ViewCompat.getPaddingStart(autoCompleteTextView);
        int paddingTop = autoCompleteTextView.getPaddingTop();
        int paddingEnd = ViewCompat.getPaddingEnd(autoCompleteTextView);
        int paddingBottom = autoCompleteTextView.getPaddingBottom();
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
        ViewCompat.setPaddingRelative(autoCompleteTextView, paddingStart, paddingTop, paddingEnd, paddingBottom);
    }

    private void x(@NonNull AutoCompleteTextView autoCompleteTextView, int i2, int[][] iArr, @NonNull e.j.a.c.z.j jVar) {
        LayerDrawable layerDrawable;
        int d2 = e.j.a.c.l.a.d(autoCompleteTextView, R.attr.colorSurface);
        e.j.a.c.z.j jVar2 = new e.j.a.c.z.j(jVar.getShapeAppearanceModel());
        int h2 = e.j.a.c.l.a.h(i2, d2, 0.1f);
        jVar2.n0(new ColorStateList(iArr, new int[]{h2, 0}));
        if (q) {
            jVar2.setTint(d2);
            ColorStateList colorStateList = new ColorStateList(iArr, new int[]{h2, d2});
            e.j.a.c.z.j jVar3 = new e.j.a.c.z.j(jVar.getShapeAppearanceModel());
            jVar3.setTint(-1);
            layerDrawable = new LayerDrawable(new Drawable[]{new RippleDrawable(colorStateList, jVar2, jVar3), jVar});
        } else {
            layerDrawable = new LayerDrawable(new Drawable[]{jVar2, jVar});
        }
        ViewCompat.setBackground(autoCompleteTextView, layerDrawable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public static AutoCompleteTextView y(EditText editText) {
        if (editText instanceof AutoCompleteTextView) {
            return (AutoCompleteTextView) editText;
        }
        throw new RuntimeException("EditText needs to be an AutoCompleteTextView if an Exposed Dropdown Menu is being used.");
    }

    private ValueAnimator z(int i2, float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(e.j.a.c.a.a.a);
        ofFloat.setDuration(i2);
        ofFloat.addUpdateListener(new b());
        return ofFloat;
    }

    @Override // e.j.a.c.d0.e
    public void a() {
        float dimensionPixelOffset = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_shape_corner_size_small_component);
        float dimensionPixelOffset2 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_elevation);
        int dimensionPixelOffset3 = this.b.getResources().getDimensionPixelOffset(R.dimen.mtrl_exposed_dropdown_menu_popup_vertical_padding);
        e.j.a.c.z.j A = A(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        e.j.a.c.z.j A2 = A(0.0f, dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3);
        this.f10615m = A;
        StateListDrawable stateListDrawable = new StateListDrawable();
        this.f10614l = stateListDrawable;
        stateListDrawable.addState(new int[]{16842922}, A);
        this.f10614l.addState(new int[0], A2);
        this.a.setEndIconDrawable(AppCompatResources.getDrawable(this.b, q ? R.drawable.mtrl_dropdown_arrow : R.drawable.mtrl_ic_arrow_drop_down));
        TextInputLayout textInputLayout = this.a;
        textInputLayout.setEndIconContentDescription(textInputLayout.getResources().getText(R.string.exposed_dropdown_menu_content_description));
        this.a.setEndIconOnClickListener(new g());
        this.a.e(this.f10609g);
        this.a.f(this.f10610h);
        B();
        this.n = (AccessibilityManager) this.b.getSystemService("accessibility");
    }

    @Override // e.j.a.c.d0.e
    public boolean b(int i2) {
        return i2 != 0;
    }

    @Override // e.j.a.c.d0.e
    public boolean d() {
        return true;
    }
}
