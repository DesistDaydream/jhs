package e.j.a.c.f;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import e.j.a.c.z.j;

/* loaded from: classes2.dex */
public class a extends AppCompatDialog {
    private BottomSheetBehavior<FrameLayout> a;
    private FrameLayout b;

    /* renamed from: c  reason: collision with root package name */
    private CoordinatorLayout f10634c;

    /* renamed from: d  reason: collision with root package name */
    private FrameLayout f10635d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f10636e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f10637f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f10638g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f10639h;

    /* renamed from: i  reason: collision with root package name */
    private BottomSheetBehavior.g f10640i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10641j;
    @NonNull

    /* renamed from: k  reason: collision with root package name */
    private BottomSheetBehavior.g f10642k;

    /* renamed from: e.j.a.c.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0357a implements OnApplyWindowInsetsListener {
        public C0357a() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (a.this.f10640i != null) {
                a.this.a.O(a.this.f10640i);
            }
            if (windowInsetsCompat != null) {
                a aVar = a.this;
                aVar.f10640i = new f(aVar.f10635d, windowInsetsCompat, null);
                a.this.a.o(a.this.f10640i);
            }
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar = a.this;
            if (aVar.f10637f && aVar.isShowing() && a.this.l()) {
                a.this.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AccessibilityDelegateCompat {
        public c() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (a.this.f10637f) {
                accessibilityNodeInfoCompat.addAction(1048576);
                accessibilityNodeInfoCompat.setDismissable(true);
                return;
            }
            accessibilityNodeInfoCompat.setDismissable(false);
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public boolean performAccessibilityAction(View view, int i2, Bundle bundle) {
            if (i2 == 1048576) {
                a aVar = a.this;
                if (aVar.f10637f) {
                    aVar.cancel();
                    return true;
                }
            }
            return super.performAccessibilityAction(view, i2, bundle);
        }
    }

    /* loaded from: classes2.dex */
    public class d implements View.OnTouchListener {
        public d() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class e extends BottomSheetBehavior.g {
        public e() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(@NonNull View view, float f2) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(@NonNull View view, int i2) {
            if (i2 == 5) {
                a.this.cancel();
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class f extends BottomSheetBehavior.g {
        private final boolean a;
        private final boolean b;

        /* renamed from: c  reason: collision with root package name */
        private final WindowInsetsCompat f10643c;

        public /* synthetic */ f(View view, WindowInsetsCompat windowInsetsCompat, C0357a c0357a) {
            this(view, windowInsetsCompat);
        }

        private void a(View view) {
            if (view.getTop() < this.f10643c.getSystemWindowInsetTop()) {
                a.k(view, this.a);
                view.setPadding(view.getPaddingLeft(), this.f10643c.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                a.k(view, this.b);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onSlide(@NonNull View view, float f2) {
            a(view);
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.g
        public void onStateChanged(@NonNull View view, int i2) {
            a(view);
        }

        private f(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList backgroundTintList;
            this.f10643c = windowInsetsCompat;
            boolean z = Build.VERSION.SDK_INT >= 23 && (view.getSystemUiVisibility() & 8192) != 0;
            this.b = z;
            j C = BottomSheetBehavior.z(view).C();
            if (C != null) {
                backgroundTintList = C.y();
            } else {
                backgroundTintList = ViewCompat.getBackgroundTintList(view);
            }
            if (backgroundTintList != null) {
                this.a = e.j.a.c.l.a.f(backgroundTintList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.a = e.j.a.c.l.a.f(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.a = z;
            }
        }
    }

    public a(@NonNull Context context) {
        this(context, 0);
        this.f10641j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout e() {
        if (this.b == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, null);
            this.b = frameLayout;
            this.f10634c = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.b.findViewById(R.id.design_bottom_sheet);
            this.f10635d = frameLayout2;
            BottomSheetBehavior<FrameLayout> z = BottomSheetBehavior.z(frameLayout2);
            this.a = z;
            z.o(this.f10642k);
            this.a.Y(this.f10637f);
        }
        return this.b;
    }

    private static int getThemeResId(@NonNull Context context, int i2) {
        if (i2 == 0) {
            TypedValue typedValue = new TypedValue();
            if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
                return typedValue.resourceId;
            }
            return R.style.Theme_Design_Light_BottomSheetDialog;
        }
        return i2;
    }

    public static void k(@NonNull View view, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            int systemUiVisibility = view.getSystemUiVisibility();
            view.setSystemUiVisibility(z ? systemUiVisibility | 8192 : systemUiVisibility & (-8193));
        }
    }

    private View m(int i2, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        e();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.b.findViewById(R.id.coordinator);
        if (i2 != 0 && view == null) {
            view = getLayoutInflater().inflate(i2, (ViewGroup) coordinatorLayout, false);
        }
        if (this.f10641j) {
            ViewCompat.setOnApplyWindowInsetsListener(this.f10635d, new C0357a());
        }
        this.f10635d.removeAllViews();
        if (layoutParams == null) {
            this.f10635d.addView(view);
        } else {
            this.f10635d.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new b());
        ViewCompat.setAccessibilityDelegate(this.f10635d, new c());
        this.f10635d.setOnTouchListener(new d());
        return this.b;
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void cancel() {
        BottomSheetBehavior<FrameLayout> f2 = f();
        if (this.f10636e && f2.I() != 5) {
            f2.e0(5);
        } else {
            super.cancel();
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> f() {
        if (this.a == null) {
            e();
        }
        return this.a;
    }

    public boolean g() {
        return this.f10636e;
    }

    public boolean h() {
        return this.f10641j;
    }

    public void i() {
        this.a.O(this.f10642k);
    }

    public void j(boolean z) {
        this.f10636e = z;
    }

    public boolean l() {
        if (!this.f10639h) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.f10638g = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.f10639h = true;
        }
        return this.f10638g;
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window == null || Build.VERSION.SDK_INT < 21) {
            return;
        }
        boolean z = this.f10641j && Color.alpha(window.getNavigationBarColor()) < 255;
        FrameLayout frameLayout = this.b;
        if (frameLayout != null) {
            frameLayout.setFitsSystemWindows(!z);
        }
        CoordinatorLayout coordinatorLayout = this.f10634c;
        if (coordinatorLayout != null) {
            coordinatorLayout.setFitsSystemWindows(!z);
        }
        if (z) {
            window.getDecorView().setSystemUiVisibility(768);
        }
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 21) {
                window.setStatusBarColor(0);
                window.addFlags(Integer.MIN_VALUE);
                if (i2 < 23) {
                    window.addFlags(67108864);
                }
            }
            window.setLayout(-1, -1);
        }
    }

    @Override // android.app.Dialog
    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
        if (bottomSheetBehavior == null || bottomSheetBehavior.I() != 5) {
            return;
        }
        this.a.e0(4);
    }

    @Override // android.app.Dialog
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        if (this.f10637f != z) {
            this.f10637f = z;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.a;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.Y(z);
            }
        }
    }

    @Override // android.app.Dialog
    public void setCanceledOnTouchOutside(boolean z) {
        super.setCanceledOnTouchOutside(z);
        if (z && !this.f10637f) {
            this.f10637f = true;
        }
        this.f10638g = z;
        this.f10639h = true;
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(@LayoutRes int i2) {
        super.setContentView(m(i2, null, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view) {
        super.setContentView(m(0, view, null));
    }

    @Override // androidx.appcompat.app.AppCompatDialog, android.app.Dialog
    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(m(0, view, layoutParams));
    }

    public a(@NonNull Context context, @StyleRes int i2) {
        super(context, getThemeResId(context, i2));
        this.f10637f = true;
        this.f10638g = true;
        this.f10642k = new e();
        supportRequestWindowFeature(1);
        this.f10641j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public a(@NonNull Context context, boolean z, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z, onCancelListener);
        this.f10637f = true;
        this.f10638g = true;
        this.f10642k = new e();
        supportRequestWindowFeature(1);
        this.f10637f = z;
        this.f10641j = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
