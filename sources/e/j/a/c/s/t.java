package e.j.a.c.s;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ViewOverlayApi14;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public class t {

    /* loaded from: classes2.dex */
    public static class a implements Runnable {
        public final /* synthetic */ View a;

        public a(View view) {
            this.a = view;
        }

        @Override // java.lang.Runnable
        public void run() {
            ((InputMethodManager) this.a.getContext().getSystemService("input_method")).showSoftInput(this.a, 1);
        }
    }

    /* loaded from: classes2.dex */
    public static class b implements e {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ boolean b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f11004c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ e f11005d;

        public b(boolean z, boolean z2, boolean z3, e eVar) {
            this.a = z;
            this.b = z2;
            this.f11004c = z3;
            this.f11005d = eVar;
        }

        @Override // e.j.a.c.s.t.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull f fVar) {
            if (this.a) {
                fVar.f11007d += windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean j2 = t.j(view);
            if (this.b) {
                if (j2) {
                    fVar.f11006c += windowInsetsCompat.getSystemWindowInsetLeft();
                } else {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetLeft();
                }
            }
            if (this.f11004c) {
                if (j2) {
                    fVar.a += windowInsetsCompat.getSystemWindowInsetRight();
                } else {
                    fVar.f11006c += windowInsetsCompat.getSystemWindowInsetRight();
                }
            }
            fVar.a(view);
            e eVar = this.f11005d;
            return eVar != null ? eVar.a(view, windowInsetsCompat, fVar) : windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public static class c implements OnApplyWindowInsetsListener {
        public final /* synthetic */ e a;
        public final /* synthetic */ f b;

        public c(e eVar, f fVar) {
            this.a = eVar;
            this.b = fVar;
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            return this.a.a(view, windowInsetsCompat, new f(this.b));
        }
    }

    /* loaded from: classes2.dex */
    public static class d implements View.OnAttachStateChangeListener {
        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(@NonNull View view) {
            view.removeOnAttachStateChangeListener(this);
            ViewCompat.requestApplyInsets(view);
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
        }
    }

    /* loaded from: classes2.dex */
    public interface e {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, f fVar);
    }

    private t() {
    }

    public static void a(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void b(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3) {
        c(view, attributeSet, i2, i3, null);
    }

    public static void c(@NonNull View view, @Nullable AttributeSet attributeSet, int i2, int i3, @Nullable e eVar) {
        TypedArray obtainStyledAttributes = view.getContext().obtainStyledAttributes(attributeSet, R.styleable.Insets, i2, i3);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingBottomSystemWindowInsets, false);
        boolean z2 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingLeftSystemWindowInsets, false);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.Insets_paddingRightSystemWindowInsets, false);
        obtainStyledAttributes.recycle();
        d(view, new b(z, z2, z3, eVar));
    }

    public static void d(@NonNull View view, @NonNull e eVar) {
        ViewCompat.setOnApplyWindowInsetsListener(view, new c(eVar, new f(ViewCompat.getPaddingStart(view), view.getPaddingTop(), ViewCompat.getPaddingEnd(view), view.getPaddingBottom())));
        n(view);
    }

    public static float e(@NonNull Context context, @Dimension(unit = 0) int i2) {
        return TypedValue.applyDimension(1, i2, context.getResources().getDisplayMetrics());
    }

    @Nullable
    public static ViewGroup f(@Nullable View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(16908290);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    @Nullable
    public static s g(@NonNull View view) {
        return h(f(view));
    }

    @Nullable
    public static s h(@Nullable View view) {
        if (view == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT >= 18) {
            return new r(view);
        }
        return ViewOverlayApi14.a(view);
    }

    public static float i(@NonNull View view) {
        float f2 = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            f2 += ViewCompat.getElevation((View) parent);
        }
        return f2;
    }

    public static boolean j(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    public static PorterDuff.Mode k(int i2, PorterDuff.Mode mode) {
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 9) {
                    switch (i2) {
                        case 14:
                            return PorterDuff.Mode.MULTIPLY;
                        case 15:
                            return PorterDuff.Mode.SCREEN;
                        case 16:
                            return PorterDuff.Mode.ADD;
                        default:
                            return mode;
                    }
                }
                return PorterDuff.Mode.SRC_ATOP;
            }
            return PorterDuff.Mode.SRC_IN;
        }
        return PorterDuff.Mode.SRC_OVER;
    }

    public static void l(@Nullable View view, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            m(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void m(@NonNull ViewTreeObserver viewTreeObserver, @NonNull ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            viewTreeObserver.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }

    public static void n(@NonNull View view) {
        if (ViewCompat.isAttachedToWindow(view)) {
            ViewCompat.requestApplyInsets(view);
        } else {
            view.addOnAttachStateChangeListener(new d());
        }
    }

    public static void o(@NonNull View view) {
        view.requestFocus();
        view.post(new a(view));
    }

    /* loaded from: classes2.dex */
    public static class f {
        public int a;
        public int b;

        /* renamed from: c  reason: collision with root package name */
        public int f11006c;

        /* renamed from: d  reason: collision with root package name */
        public int f11007d;

        public f(int i2, int i3, int i4, int i5) {
            this.a = i2;
            this.b = i3;
            this.f11006c = i4;
            this.f11007d = i5;
        }

        public void a(View view) {
            ViewCompat.setPaddingRelative(view, this.a, this.b, this.f11006c, this.f11007d);
        }

        public f(@NonNull f fVar) {
            this.a = fVar.a;
            this.b = fVar.b;
            this.f11006c = fVar.f11006c;
            this.f11007d = fVar.f11007d;
        }
    }
}
