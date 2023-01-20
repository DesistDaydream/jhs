package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Dimension;
import androidx.annotation.MenuRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.j.a.c.s.t;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes2.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    public static final int A = 1;
    private static final int B = 0;
    private static final int v = R.style.Widget_MaterialComponents_BottomAppBar;
    private static final long w = 300;
    public static final int x = 0;
    public static final int y = 1;
    public static final int z = 0;
    private final int a;
    private final e.j.a.c.z.j b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private Animator f2768c;
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private Animator f2769d;

    /* renamed from: e  reason: collision with root package name */
    private int f2770e;

    /* renamed from: f  reason: collision with root package name */
    private int f2771f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f2772g;

    /* renamed from: h  reason: collision with root package name */
    private final boolean f2773h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f2774i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f2775j;

    /* renamed from: k  reason: collision with root package name */
    private int f2776k;

    /* renamed from: l  reason: collision with root package name */
    private ArrayList<j> f2777l;
    @MenuRes

    /* renamed from: m  reason: collision with root package name */
    private int f2778m;
    private boolean n;
    private boolean o;
    private Behavior p;
    private int q;
    private int r;
    private int s;
    @NonNull
    public AnimatorListenerAdapter t;
    @NonNull
    public e.j.a.c.a.k<FloatingActionButton> u;

    /* loaded from: classes2.dex */
    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new a();
        public int fabAlignmentMode;
        public boolean fabAttached;

        /* loaded from: classes2.dex */
        public static class a implements Parcelable.ClassLoaderCreator<SavedState> {
            @Override // android.os.Parcelable.Creator
            @Nullable
            /* renamed from: a */
            public SavedState createFromParcel(@NonNull Parcel parcel) {
                return new SavedState(parcel, null);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            @NonNull
            /* renamed from: b */
            public SavedState createFromParcel(@NonNull Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            @NonNull
            /* renamed from: c */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(@NonNull Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }

        public SavedState(@NonNull Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }
    }

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.this.n) {
                return;
            }
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.U(bottomAppBar.f2770e, BottomAppBar.this.o);
        }
    }

    /* loaded from: classes2.dex */
    public class b implements e.j.a.c.a.k<FloatingActionButton> {
        public b() {
        }

        @Override // e.j.a.c.a.k
        /* renamed from: c */
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            BottomAppBar.this.b.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // e.j.a.c.a.k
        /* renamed from: d */
        public void b(@NonNull FloatingActionButton floatingActionButton) {
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.this.getTopEdgeTreatment().k() != translationX) {
                BottomAppBar.this.getTopEdgeTreatment().q(translationX);
                BottomAppBar.this.b.invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.this.getTopEdgeTreatment().e() != max) {
                BottomAppBar.this.getTopEdgeTreatment().l(max);
                BottomAppBar.this.b.invalidateSelf();
            }
            BottomAppBar.this.b.o0(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements t.e {
        public c() {
        }

        @Override // e.j.a.c.s.t.e
        @NonNull
        public WindowInsetsCompat a(View view, @NonNull WindowInsetsCompat windowInsetsCompat, @NonNull t.f fVar) {
            boolean z;
            if (BottomAppBar.this.f2773h) {
                BottomAppBar.this.q = windowInsetsCompat.getSystemWindowInsetBottom();
            }
            boolean z2 = false;
            if (BottomAppBar.this.f2774i) {
                z = BottomAppBar.this.s != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.this.s = windowInsetsCompat.getSystemWindowInsetLeft();
            } else {
                z = false;
            }
            if (BottomAppBar.this.f2775j) {
                boolean z3 = BottomAppBar.this.r != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.this.r = windowInsetsCompat.getSystemWindowInsetRight();
                z2 = z3;
            }
            if (z || z2) {
                BottomAppBar.this.J();
                BottomAppBar.this.b0();
                BottomAppBar.this.a0();
            }
            return windowInsetsCompat;
        }
    }

    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.N();
            BottomAppBar.this.f2768c = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.O();
        }
    }

    /* loaded from: classes2.dex */
    public class e extends FloatingActionButton.b {
        public final /* synthetic */ int a;

        /* loaded from: classes2.dex */
        public class a extends FloatingActionButton.b {
            public a() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
            public void b(FloatingActionButton floatingActionButton) {
                BottomAppBar.this.N();
            }
        }

        public e(int i2) {
            this.a = i2;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.b
        public void a(@NonNull FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.this.S(this.a));
            floatingActionButton.A(new a());
        }
    }

    /* loaded from: classes2.dex */
    public class f extends AnimatorListenerAdapter {
        public f() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.this.N();
            BottomAppBar.this.n = false;
            BottomAppBar.this.f2769d = null;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.O();
        }
    }

    /* loaded from: classes2.dex */
    public class g extends AnimatorListenerAdapter {
        public boolean a;
        public final /* synthetic */ ActionMenuView b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f2783c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f2784d;

        public g(ActionMenuView actionMenuView, int i2, boolean z) {
            this.b = actionMenuView;
            this.f2783c = i2;
            this.f2784d = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.a = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            boolean z = BottomAppBar.this.f2778m != 0;
            BottomAppBar bottomAppBar = BottomAppBar.this;
            bottomAppBar.Z(bottomAppBar.f2778m);
            BottomAppBar.this.f0(this.b, this.f2783c, this.f2784d, z);
        }
    }

    /* loaded from: classes2.dex */
    public class h implements Runnable {
        public final /* synthetic */ ActionMenuView a;
        public final /* synthetic */ int b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f2786c;

        public h(ActionMenuView actionMenuView, int i2, boolean z) {
            this.a = actionMenuView;
            this.b = i2;
            this.f2786c = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuView actionMenuView = this.a;
            actionMenuView.setTranslationX(BottomAppBar.this.R(actionMenuView, this.b, this.f2786c));
        }
    }

    /* loaded from: classes2.dex */
    public class i extends AnimatorListenerAdapter {
        public i() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.t.onAnimationStart(animator);
            FloatingActionButton P = BottomAppBar.this.P();
            if (P != null) {
                P.setTranslationX(BottomAppBar.this.getFabTranslationX());
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(BottomAppBar bottomAppBar);

        void b(BottomAppBar bottomAppBar);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface k {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes2.dex */
    public @interface l {
    }

    public BottomAppBar(@NonNull Context context) {
        this(context, null, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I(@NonNull FloatingActionButton floatingActionButton) {
        floatingActionButton.f(this.t);
        floatingActionButton.g(new i());
        floatingActionButton.h(this.u);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Animator animator = this.f2769d;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f2768c;
        if (animator2 != null) {
            animator2.cancel();
        }
    }

    private void L(int i2, @NonNull List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(P(), "translationX", S(i2));
        ofFloat.setDuration(300L);
        list.add(ofFloat);
    }

    private void M(int i2, boolean z2, @NonNull List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        if (Math.abs(actionMenuView.getTranslationX() - R(actionMenuView, i2, z2)) > 1.0f) {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.addListener(new g(actionMenuView, i2, z2));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(150L);
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        } else if (actionMenuView.getAlpha() < 1.0f) {
            list.add(ofFloat);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void N() {
        ArrayList<j> arrayList;
        int i2 = this.f2776k - 1;
        this.f2776k = i2;
        if (i2 != 0 || (arrayList = this.f2777l) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().a(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        ArrayList<j> arrayList;
        int i2 = this.f2776k;
        this.f2776k = i2 + 1;
        if (i2 != 0 || (arrayList = this.f2777l) == null) {
            return;
        }
        Iterator<j> it = arrayList.iterator();
        while (it.hasNext()) {
            it.next().b(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public FloatingActionButton P() {
        View Q = Q();
        if (Q instanceof FloatingActionButton) {
            return (FloatingActionButton) Q;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:8:0x001e  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public android.view.View Q() {
        /*
            r4 = this;
            android.view.ViewParent r0 = r4.getParent()
            boolean r0 = r0 instanceof androidx.coordinatorlayout.widget.CoordinatorLayout
            r1 = 0
            if (r0 != 0) goto La
            return r1
        La:
            android.view.ViewParent r0 = r4.getParent()
            androidx.coordinatorlayout.widget.CoordinatorLayout r0 = (androidx.coordinatorlayout.widget.CoordinatorLayout) r0
            java.util.List r0 = r0.getDependents(r4)
            java.util.Iterator r0 = r0.iterator()
        L18:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L2d
            java.lang.Object r2 = r0.next()
            android.view.View r2 = (android.view.View) r2
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.FloatingActionButton
            if (r3 != 0) goto L2c
            boolean r3 = r2 instanceof com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton
            if (r3 == 0) goto L18
        L2c:
            return r2
        L2d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.Q():android.view.View");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float S(int i2) {
        boolean j2 = t.j(this);
        if (i2 == 1) {
            return ((getMeasuredWidth() / 2) - (this.a + (j2 ? this.s : this.r))) * (j2 ? -1 : 1);
        }
        return 0.0f;
    }

    private boolean T() {
        FloatingActionButton P = P();
        return P != null && P.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void U(int i2, boolean z2) {
        if (!ViewCompat.isLaidOut(this)) {
            this.n = false;
            Z(this.f2778m);
            return;
        }
        Animator animator = this.f2769d;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!T()) {
            i2 = 0;
            z2 = false;
        }
        M(i2, z2, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f2769d = animatorSet;
        animatorSet.addListener(new f());
        this.f2769d.start();
    }

    private void V(int i2) {
        if (this.f2770e == i2 || !ViewCompat.isLaidOut(this)) {
            return;
        }
        Animator animator = this.f2768c;
        if (animator != null) {
            animator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.f2771f == 1) {
            L(i2, arrayList);
        } else {
            K(i2, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.f2768c = animatorSet;
        animatorSet.addListener(new d());
        this.f2768c.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a0() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.f2769d != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (!T()) {
            e0(actionMenuView, 0, false);
        } else {
            e0(actionMenuView, this.f2770e, this.o);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b0() {
        getTopEdgeTreatment().q(getFabTranslationX());
        View Q = Q();
        this.b.o0((this.o && T()) ? 1.0f : 0.0f);
        if (Q != null) {
            Q.setTranslationY(getFabTranslationY());
            Q.setTranslationX(getFabTranslationX());
        }
    }

    private void e0(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        f0(actionMenuView, i2, z2, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f0(@NonNull ActionMenuView actionMenuView, int i2, boolean z2, boolean z3) {
        h hVar = new h(actionMenuView, i2, z2);
        if (z3) {
            actionMenuView.post(hVar);
        } else {
            hVar.run();
        }
    }

    @Nullable
    private ActionMenuView getActionMenuView() {
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getBottomInset() {
        return this.q;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getFabTranslationX() {
        return S(this.f2770e);
    }

    private float getFabTranslationY() {
        return -getTopEdgeTreatment().e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getLeftInset() {
        return this.s;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRightInset() {
        return this.r;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @NonNull
    public e.j.a.c.d.a getTopEdgeTreatment() {
        return (e.j.a.c.d.a) this.b.getShapeAppearanceModel().p();
    }

    public void H(@NonNull j jVar) {
        if (this.f2777l == null) {
            this.f2777l = new ArrayList<>();
        }
        this.f2777l.add(jVar);
    }

    public void K(int i2, List<Animator> list) {
        FloatingActionButton P = P();
        if (P == null || P.q()) {
            return;
        }
        O();
        P.o(new e(i2));
    }

    public int R(@NonNull ActionMenuView actionMenuView, int i2, boolean z2) {
        if (i2 == 1 && z2) {
            boolean j2 = t.j(this);
            int measuredWidth = j2 ? getMeasuredWidth() : 0;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                    if (j2) {
                        measuredWidth = Math.min(measuredWidth, childAt.getLeft());
                    } else {
                        measuredWidth = Math.max(measuredWidth, childAt.getRight());
                    }
                }
            }
            return measuredWidth - ((j2 ? actionMenuView.getRight() : actionMenuView.getLeft()) + (j2 ? this.r : -this.s));
        }
        return 0;
    }

    public void W() {
        getBehavior().d(this);
    }

    public void X() {
        getBehavior().e(this);
    }

    public void Y(@NonNull j jVar) {
        ArrayList<j> arrayList = this.f2777l;
        if (arrayList == null) {
            return;
        }
        arrayList.remove(jVar);
    }

    public void Z(@MenuRes int i2) {
        if (i2 != 0) {
            this.f2778m = 0;
            getMenu().clear();
            inflateMenu(i2);
        }
    }

    public void c0(int i2, @MenuRes int i3) {
        this.f2778m = i3;
        this.n = true;
        U(i2, this.o);
        V(i2);
        this.f2770e = i2;
    }

    public boolean d0(@Px int i2) {
        float f2 = i2;
        if (f2 != getTopEdgeTreatment().j()) {
            getTopEdgeTreatment().p(f2);
            this.b.invalidateSelf();
            return true;
        }
        return false;
    }

    @Nullable
    public ColorStateList getBackgroundTint() {
        return this.b.Q();
    }

    @Dimension
    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().e();
    }

    public int getFabAlignmentMode() {
        return this.f2770e;
    }

    public int getFabAnimationMode() {
        return this.f2771f;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().g();
    }

    @Dimension
    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().h();
    }

    public boolean getHideOnScroll() {
        return this.f2772g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        e.j.a.c.z.k.f(this, this.b);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        if (z2) {
            J();
            b0();
        }
        a0();
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f2770e = savedState.fabAlignmentMode;
        this.o = savedState.fabAttached;
    }

    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    @NonNull
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.f2770e;
        savedState.fabAttached = this.o;
        return savedState;
    }

    public void setBackgroundTint(@Nullable ColorStateList colorStateList) {
        DrawableCompat.setTintList(this.b, colorStateList);
    }

    public void setCradleVerticalOffset(@Dimension float f2) {
        if (f2 != getCradleVerticalOffset()) {
            getTopEdgeTreatment().l(f2);
            this.b.invalidateSelf();
            b0();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        this.b.m0(f2);
        getBehavior().c(this, this.b.J() - this.b.I());
    }

    public void setFabAlignmentMode(int i2) {
        c0(i2, 0);
    }

    public void setFabAnimationMode(int i2) {
        this.f2771f = i2;
    }

    public void setFabCornerSize(@Dimension float f2) {
        if (f2 != getTopEdgeTreatment().f()) {
            getTopEdgeTreatment().m(f2);
            this.b.invalidateSelf();
        }
    }

    public void setFabCradleMargin(@Dimension float f2) {
        if (f2 != getFabCradleMargin()) {
            getTopEdgeTreatment().n(f2);
            this.b.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(@Dimension float f2) {
        if (f2 != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().o(f2);
            this.b.invalidateSelf();
        }
    }

    public void setHideOnScroll(boolean z2) {
        this.f2772g = z2;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public BottomAppBar(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    @NonNull
    public Behavior getBehavior() {
        if (this.p == null) {
            this.p = new Behavior();
        }
        return this.p;
    }

    /* loaded from: classes2.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        private final Rect f2779i;

        /* renamed from: j  reason: collision with root package name */
        private WeakReference<BottomAppBar> f2780j;

        /* renamed from: k  reason: collision with root package name */
        private int f2781k;

        /* renamed from: l  reason: collision with root package name */
        private final View.OnLayoutChangeListener f2782l;

        /* loaded from: classes2.dex */
        public class a implements View.OnLayoutChangeListener {
            public a() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.this.f2780j.get();
                if (bottomAppBar != null && (view instanceof FloatingActionButton)) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.l(Behavior.this.f2779i);
                    int height = Behavior.this.f2779i.height();
                    bottomAppBar.d0(height);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().r().a(new RectF(Behavior.this.f2779i)));
                    CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                    if (Behavior.this.f2781k == 0) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = bottomAppBar.getBottomInset() + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((floatingActionButton.getMeasuredHeight() - height) / 2));
                        ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = bottomAppBar.getLeftInset();
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = bottomAppBar.getRightInset();
                        if (t.j(floatingActionButton)) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin += bottomAppBar.a;
                            return;
                        } else {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin += bottomAppBar.a;
                            return;
                        }
                    }
                    return;
                }
                view.removeOnLayoutChangeListener(this);
            }
        }

        public Behavior() {
            this.f2782l = new a();
            this.f2779i = new Rect();
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: i */
        public boolean onLayoutChild(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, int i2) {
            this.f2780j = new WeakReference<>(bottomAppBar);
            View Q = bottomAppBar.Q();
            if (Q != null && !ViewCompat.isLaidOut(Q)) {
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) Q.getLayoutParams();
                layoutParams.anchorGravity = 49;
                this.f2781k = ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin;
                if (Q instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) Q;
                    floatingActionButton.addOnLayoutChangeListener(this.f2782l);
                    bottomAppBar.I(floatingActionButton);
                }
                bottomAppBar.b0();
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i2);
            return super.onLayoutChild(coordinatorLayout, bottomAppBar, i2);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        /* renamed from: j */
        public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull BottomAppBar bottomAppBar, @NonNull View view, @NonNull View view2, int i2, int i3) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, bottomAppBar, view, view2, i2, i3);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f2782l = new a();
            this.f2779i = new Rect();
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public BottomAppBar(@androidx.annotation.NonNull android.content.Context r11, @androidx.annotation.Nullable android.util.AttributeSet r12, int r13) {
        /*
            r10 = this;
            int r6 = com.google.android.material.bottomappbar.BottomAppBar.v
            android.content.Context r11 = e.j.a.c.e0.a.a.c(r11, r12, r13, r6)
            r10.<init>(r11, r12, r13)
            e.j.a.c.z.j r11 = new e.j.a.c.z.j
            r11.<init>()
            r10.b = r11
            r7 = 0
            r10.f2776k = r7
            r10.f2778m = r7
            r10.n = r7
            r0 = 1
            r10.o = r0
            com.google.android.material.bottomappbar.BottomAppBar$a r0 = new com.google.android.material.bottomappbar.BottomAppBar$a
            r0.<init>()
            r10.t = r0
            com.google.android.material.bottomappbar.BottomAppBar$b r0 = new com.google.android.material.bottomappbar.BottomAppBar$b
            r0.<init>()
            r10.u = r0
            android.content.Context r8 = r10.getContext()
            int[] r2 = com.google.android.material.R.styleable.BottomAppBar
            int[] r5 = new int[r7]
            r0 = r8
            r1 = r12
            r3 = r13
            r4 = r6
            android.content.res.TypedArray r0 = e.j.a.c.s.m.j(r0, r1, r2, r3, r4, r5)
            int r1 = com.google.android.material.R.styleable.BottomAppBar_backgroundTint
            android.content.res.ColorStateList r1 = e.j.a.c.w.c.a(r8, r0, r1)
            int r2 = com.google.android.material.R.styleable.BottomAppBar_elevation
            int r2 = r0.getDimensionPixelSize(r2, r7)
            int r3 = com.google.android.material.R.styleable.BottomAppBar_fabCradleMargin
            int r3 = r0.getDimensionPixelOffset(r3, r7)
            float r3 = (float) r3
            int r4 = com.google.android.material.R.styleable.BottomAppBar_fabCradleRoundedCornerRadius
            int r4 = r0.getDimensionPixelOffset(r4, r7)
            float r4 = (float) r4
            int r5 = com.google.android.material.R.styleable.BottomAppBar_fabCradleVerticalOffset
            int r5 = r0.getDimensionPixelOffset(r5, r7)
            float r5 = (float) r5
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAlignmentMode
            int r9 = r0.getInt(r9, r7)
            r10.f2770e = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_fabAnimationMode
            int r9 = r0.getInt(r9, r7)
            r10.f2771f = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_hideOnScroll
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f2772g = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingBottomSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f2773h = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingLeftSystemWindowInsets
            boolean r9 = r0.getBoolean(r9, r7)
            r10.f2774i = r9
            int r9 = com.google.android.material.R.styleable.BottomAppBar_paddingRightSystemWindowInsets
            boolean r7 = r0.getBoolean(r9, r7)
            r10.f2775j = r7
            r0.recycle()
            android.content.res.Resources r0 = r10.getResources()
            int r7 = com.google.android.material.R.dimen.mtrl_bottomappbar_fabOffsetEndMode
            int r0 = r0.getDimensionPixelOffset(r7)
            r10.a = r0
            e.j.a.c.d.a r0 = new e.j.a.c.d.a
            r0.<init>(r3, r4, r5)
            e.j.a.c.z.o$b r3 = e.j.a.c.z.o.a()
            e.j.a.c.z.o$b r0 = r3.G(r0)
            e.j.a.c.z.o r0 = r0.m()
            r11.setShapeAppearanceModel(r0)
            r0 = 2
            r11.w0(r0)
            android.graphics.Paint$Style r0 = android.graphics.Paint.Style.FILL
            r11.q0(r0)
            r11.Y(r8)
            float r0 = (float) r2
            r10.setElevation(r0)
            androidx.core.graphics.drawable.DrawableCompat.setTintList(r11, r1)
            androidx.core.view.ViewCompat.setBackground(r10, r11)
            com.google.android.material.bottomappbar.BottomAppBar$c r11 = new com.google.android.material.bottomappbar.BottomAppBar$c
            r11.<init>()
            e.j.a.c.s.t.c(r10, r12, r13, r6, r11)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.bottomappbar.BottomAppBar.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
