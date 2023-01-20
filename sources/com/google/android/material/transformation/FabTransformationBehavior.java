package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.Property;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.j.a.c.a.h;
import e.j.a.c.a.i;
import e.j.a.c.a.j;
import e.j.a.c.k.c;
import java.util.ArrayList;
import java.util.List;

@Deprecated
/* loaded from: classes2.dex */
public abstract class FabTransformationBehavior extends ExpandableTransformationBehavior {

    /* renamed from: f  reason: collision with root package name */
    private final Rect f3137f;

    /* renamed from: g  reason: collision with root package name */
    private final RectF f3138g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f3139h;

    /* renamed from: i  reason: collision with root package name */
    private final int[] f3140i;

    /* renamed from: j  reason: collision with root package name */
    private float f3141j;

    /* renamed from: k  reason: collision with root package name */
    private float f3142k;

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public final /* synthetic */ boolean a;
        public final /* synthetic */ View b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f3143c;

        public a(boolean z, View view, View view2) {
            this.a = z;
            this.b = view;
            this.f3143c = view2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.a) {
                return;
            }
            this.b.setVisibility(4);
            this.f3143c.setAlpha(1.0f);
            this.f3143c.setVisibility(0);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.a) {
                this.b.setVisibility(0);
                this.f3143c.setAlpha(0.0f);
                this.f3143c.setVisibility(4);
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;

        public b(View view) {
            this.a = view;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.invalidate();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends AnimatorListenerAdapter {
        public final /* synthetic */ e.j.a.c.k.c a;
        public final /* synthetic */ Drawable b;

        public c(e.j.a.c.k.c cVar, Drawable drawable) {
            this.a = cVar;
            this.b = drawable;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.a.setCircularRevealOverlayDrawable(this.b);
        }
    }

    /* loaded from: classes2.dex */
    public class d extends AnimatorListenerAdapter {
        public final /* synthetic */ e.j.a.c.k.c a;

        public d(e.j.a.c.k.c cVar) {
            this.a = cVar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            c.e revealInfo = this.a.getRevealInfo();
            revealInfo.f10868c = Float.MAX_VALUE;
            this.a.setRevealInfo(revealInfo);
        }
    }

    /* loaded from: classes2.dex */
    public static class e {
        @Nullable
        public h a;
        public j b;
    }

    public FabTransformationBehavior() {
        this.f3137f = new Rect();
        this.f3138g = new RectF();
        this.f3139h = new RectF();
        this.f3140i = new int[2];
    }

    private int A(@NonNull View view) {
        ColorStateList backgroundTintList = ViewCompat.getBackgroundTintList(view);
        if (backgroundTintList != null) {
            return backgroundTintList.getColorForState(view.getDrawableState(), backgroundTintList.getDefaultColor());
        }
        return 0;
    }

    @Nullable
    private ViewGroup C(View view) {
        if (view instanceof ViewGroup) {
            return (ViewGroup) view;
        }
        return null;
    }

    @Nullable
    private ViewGroup h(@NonNull View view) {
        View findViewById = view.findViewById(R.id.mtrl_child_content_container);
        if (findViewById != null) {
            return C(findViewById);
        }
        if (!(view instanceof TransformationChildLayout) && !(view instanceof TransformationChildCard)) {
            return C(view);
        }
        return C(((ViewGroup) view).getChildAt(0));
    }

    private void i(@NonNull View view, @NonNull e eVar, @NonNull i iVar, @NonNull i iVar2, float f2, float f3, float f4, float f5, @NonNull RectF rectF) {
        float p = p(eVar, iVar, f2, f4);
        float p2 = p(eVar, iVar2, f3, f5);
        Rect rect = this.f3137f;
        view.getWindowVisibleDisplayFrame(rect);
        RectF rectF2 = this.f3138g;
        rectF2.set(rect);
        RectF rectF3 = this.f3139h;
        q(view, rectF3);
        rectF3.offset(p, p2);
        rectF3.intersect(rectF2);
        rectF.set(rectF3);
    }

    private void j(@NonNull View view, @NonNull RectF rectF) {
        q(view, rectF);
        rectF.offset(this.f3141j, this.f3142k);
    }

    @NonNull
    private Pair<i, i> k(float f2, float f3, boolean z, @NonNull e eVar) {
        i h2;
        i h3;
        int i2;
        if (f2 == 0.0f || f3 == 0.0f) {
            h2 = eVar.a.h("translationXLinear");
            h3 = eVar.a.h("translationYLinear");
        } else if ((z && f3 < 0.0f) || (!z && i2 > 0)) {
            h2 = eVar.a.h("translationXCurveUpwards");
            h3 = eVar.a.h("translationYCurveUpwards");
        } else {
            h2 = eVar.a.h("translationXCurveDownwards");
            h3 = eVar.a.h("translationYCurveDownwards");
        }
        return new Pair<>(h2, h3);
    }

    private float l(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f3138g;
        RectF rectF2 = this.f3139h;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(-n(view, view2, jVar), 0.0f);
        return rectF.centerX() - rectF2.left;
    }

    private float m(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        RectF rectF = this.f3138g;
        RectF rectF2 = this.f3139h;
        j(view, rectF);
        q(view2, rectF2);
        rectF2.offset(0.0f, -o(view, view2, jVar));
        return rectF.centerY() - rectF2.top;
    }

    private float n(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerX;
        float centerX2;
        float f2;
        RectF rectF = this.f3138g;
        RectF rectF2 = this.f3139h;
        j(view, rectF);
        q(view2, rectF2);
        int i2 = jVar.a & 7;
        if (i2 == 1) {
            centerX = rectF2.centerX();
            centerX2 = rectF.centerX();
        } else if (i2 == 3) {
            centerX = rectF2.left;
            centerX2 = rectF.left;
        } else if (i2 == 5) {
            centerX = rectF2.right;
            centerX2 = rectF.right;
        } else {
            f2 = 0.0f;
            return f2 + jVar.b;
        }
        f2 = centerX - centerX2;
        return f2 + jVar.b;
    }

    private float o(@NonNull View view, @NonNull View view2, @NonNull j jVar) {
        float centerY;
        float centerY2;
        float f2;
        RectF rectF = this.f3138g;
        RectF rectF2 = this.f3139h;
        j(view, rectF);
        q(view2, rectF2);
        int i2 = jVar.a & 112;
        if (i2 == 16) {
            centerY = rectF2.centerY();
            centerY2 = rectF.centerY();
        } else if (i2 == 48) {
            centerY = rectF2.top;
            centerY2 = rectF.top;
        } else if (i2 == 80) {
            centerY = rectF2.bottom;
            centerY2 = rectF.bottom;
        } else {
            f2 = 0.0f;
            return f2 + jVar.f10559c;
        }
        f2 = centerY - centerY2;
        return f2 + jVar.f10559c;
    }

    private float p(@NonNull e eVar, @NonNull i iVar, float f2, float f3) {
        long c2 = iVar.c();
        long d2 = iVar.d();
        i h2 = eVar.a.h("expansion");
        return e.j.a.c.a.a.a(f2, f3, iVar.e().getInterpolation(((float) (((h2.c() + h2.d()) + 17) - c2)) / ((float) d2)));
    }

    private void q(@NonNull View view, RectF rectF) {
        rectF.set(0.0f, 0.0f, view.getWidth(), view.getHeight());
        int[] iArr = this.f3140i;
        view.getLocationInWindow(iArr);
        rectF.offsetTo(iArr[0], iArr[1]);
        rectF.offset((int) (-view.getTranslationX()), (int) (-view.getTranslationY()));
    }

    private void r(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ViewGroup h2;
        ObjectAnimator ofFloat;
        if (view2 instanceof ViewGroup) {
            if (((view2 instanceof e.j.a.c.k.c) && e.j.a.c.k.b.o == 0) || (h2 = h(view2)) == null) {
                return;
            }
            if (z) {
                if (!z2) {
                    e.j.a.c.a.d.a.set(h2, Float.valueOf(0.0f));
                }
                ofFloat = ObjectAnimator.ofFloat(h2, e.j.a.c.a.d.a, 1.0f);
            } else {
                ofFloat = ObjectAnimator.ofFloat(h2, e.j.a.c.a.d.a, 0.0f);
            }
            eVar.a.h("contentFade").a(ofFloat);
            list.add(ofFloat);
        }
    }

    private void s(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if (view2 instanceof e.j.a.c.k.c) {
            e.j.a.c.k.c cVar = (e.j.a.c.k.c) view2;
            int A = A(view);
            int i2 = 16777215 & A;
            if (z) {
                if (!z2) {
                    cVar.setCircularRevealScrimColor(A);
                }
                ofInt = ObjectAnimator.ofInt(cVar, c.d.a, i2);
            } else {
                ofInt = ObjectAnimator.ofInt(cVar, c.d.a, A);
            }
            ofInt.setEvaluator(e.j.a.c.a.c.b());
            eVar.a.h("color").a(ofInt);
            list.add(ofInt);
        }
    }

    private void t(@NonNull View view, @NonNull View view2, boolean z, @NonNull e eVar, @NonNull List<Animator> list) {
        float n = n(view, view2, eVar.b);
        float o = o(view, view2, eVar.b);
        Pair<i, i> k2 = k(n, o, z, eVar);
        i iVar = (i) k2.first;
        i iVar2 = (i) k2.second;
        Property property = View.TRANSLATION_X;
        float[] fArr = new float[1];
        if (!z) {
            n = this.f3141j;
        }
        fArr[0] = n;
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, property, fArr);
        Property property2 = View.TRANSLATION_Y;
        float[] fArr2 = new float[1];
        if (!z) {
            o = this.f3142k;
        }
        fArr2[0] = o;
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, property2, fArr2);
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    @TargetApi(21)
    private void u(View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofFloat;
        float elevation = ViewCompat.getElevation(view2) - ViewCompat.getElevation(view);
        if (z) {
            if (!z2) {
                view2.setTranslationZ(-elevation);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, 0.0f);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Z, -elevation);
        }
        eVar.a.h("elevation").a(ofFloat);
        list.add(ofFloat);
    }

    private void v(@NonNull View view, View view2, boolean z, boolean z2, @NonNull e eVar, float f2, float f3, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        Animator animator;
        if (view2 instanceof e.j.a.c.k.c) {
            e.j.a.c.k.c cVar = (e.j.a.c.k.c) view2;
            float l2 = l(view, view2, eVar.b);
            float m2 = m(view, view2, eVar.b);
            ((FloatingActionButton) view).k(this.f3137f);
            float width = this.f3137f.width() / 2.0f;
            i h2 = eVar.a.h("expansion");
            if (z) {
                if (!z2) {
                    cVar.setRevealInfo(new c.e(l2, m2, width));
                }
                if (z2) {
                    width = cVar.getRevealInfo().f10868c;
                }
                animator = e.j.a.c.k.a.a(cVar, l2, m2, e.j.a.c.t.a.b(l2, m2, 0.0f, 0.0f, f2, f3));
                animator.addListener(new d(cVar));
                y(view2, h2.c(), (int) l2, (int) m2, width, list);
            } else {
                float f4 = cVar.getRevealInfo().f10868c;
                Animator a2 = e.j.a.c.k.a.a(cVar, l2, m2, width);
                int i2 = (int) l2;
                int i3 = (int) m2;
                y(view2, h2.c(), i2, i3, f4, list);
                x(view2, h2.c(), h2.d(), eVar.a.i(), i2, i3, width, list);
                animator = a2;
            }
            h2.a(animator);
            list.add(animator);
            list2.add(e.j.a.c.k.a.c(cVar));
        }
    }

    private void w(View view, View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, @NonNull List<Animator.AnimatorListener> list2) {
        ObjectAnimator ofInt;
        if ((view2 instanceof e.j.a.c.k.c) && (view instanceof ImageView)) {
            e.j.a.c.k.c cVar = (e.j.a.c.k.c) view2;
            Drawable drawable = ((ImageView) view).getDrawable();
            if (drawable == null) {
                return;
            }
            drawable.mutate();
            if (z) {
                if (!z2) {
                    drawable.setAlpha(255);
                }
                ofInt = ObjectAnimator.ofInt(drawable, e.j.a.c.a.e.b, 0);
            } else {
                ofInt = ObjectAnimator.ofInt(drawable, e.j.a.c.a.e.b, 255);
            }
            ofInt.addUpdateListener(new b(view2));
            eVar.a.h("iconFade").a(ofInt);
            list.add(ofInt);
            list2.add(new c(cVar, drawable));
        }
    }

    private void x(View view, long j2, long j3, long j4, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT >= 21) {
            long j5 = j2 + j3;
            if (j5 < j4) {
                Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
                createCircularReveal.setStartDelay(j5);
                createCircularReveal.setDuration(j4 - j5);
                list.add(createCircularReveal);
            }
        }
    }

    private void y(View view, long j2, int i2, int i3, float f2, @NonNull List<Animator> list) {
        if (Build.VERSION.SDK_INT < 21 || j2 <= 0) {
            return;
        }
        Animator createCircularReveal = ViewAnimationUtils.createCircularReveal(view, i2, i3, f2, f2);
        createCircularReveal.setStartDelay(0L);
        createCircularReveal.setDuration(j2);
        list.add(createCircularReveal);
    }

    private void z(@NonNull View view, @NonNull View view2, boolean z, boolean z2, @NonNull e eVar, @NonNull List<Animator> list, List<Animator.AnimatorListener> list2, @NonNull RectF rectF) {
        ObjectAnimator ofFloat;
        ObjectAnimator ofFloat2;
        float n = n(view, view2, eVar.b);
        float o = o(view, view2, eVar.b);
        Pair<i, i> k2 = k(n, o, z, eVar);
        i iVar = (i) k2.first;
        i iVar2 = (i) k2.second;
        if (z) {
            if (!z2) {
                view2.setTranslationX(-n);
                view2.setTranslationY(-o);
            }
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, 0.0f);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, 0.0f);
            i(view2, eVar, iVar, iVar2, -n, -o, 0.0f, 0.0f, rectF);
        } else {
            ofFloat = ObjectAnimator.ofFloat(view2, View.TRANSLATION_X, -n);
            ofFloat2 = ObjectAnimator.ofFloat(view2, View.TRANSLATION_Y, -o);
        }
        iVar.a(ofFloat);
        iVar2.a(ofFloat2);
        list.add(ofFloat);
        list.add(ofFloat2);
    }

    public abstract e B(Context context, boolean z);

    @Override // com.google.android.material.transformation.ExpandableTransformationBehavior
    @NonNull
    public AnimatorSet g(@NonNull View view, @NonNull View view2, boolean z, boolean z2) {
        e B = B(view2.getContext(), z);
        if (z) {
            this.f3141j = view.getTranslationX();
            this.f3142k = view.getTranslationY();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (Build.VERSION.SDK_INT >= 21) {
            u(view, view2, z, z2, B, arrayList, arrayList2);
        }
        RectF rectF = this.f3138g;
        z(view, view2, z, z2, B, arrayList, arrayList2, rectF);
        float width = rectF.width();
        float height = rectF.height();
        t(view, view2, z, B, arrayList);
        w(view, view2, z, z2, B, arrayList, arrayList2);
        v(view, view2, z, z2, B, width, height, arrayList, arrayList2);
        s(view, view2, z, z2, B, arrayList, arrayList2);
        r(view, view2, z, z2, B, arrayList, arrayList2);
        AnimatorSet animatorSet = new AnimatorSet();
        e.j.a.c.a.b.a(animatorSet, arrayList);
        animatorSet.addListener(new a(z, view2, view));
        int size = arrayList2.size();
        for (int i2 = 0; i2 < size; i2++) {
            animatorSet.addListener(arrayList2.get(i2));
        }
        return animatorSet;
    }

    @Override // com.google.android.material.transformation.ExpandableBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public boolean layoutDependsOn(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View view, @NonNull View view2) {
        if (view.getVisibility() != 8) {
            if (view2 instanceof FloatingActionButton) {
                int expandedComponentIdHint = ((FloatingActionButton) view2).getExpandedComponentIdHint();
                return expandedComponentIdHint == 0 || expandedComponentIdHint == view.getId();
            }
            return false;
        }
        throw new IllegalStateException("This behavior cannot be attached to a GONE view. Set the view to INVISIBLE instead.");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    @CallSuper
    public void onAttachedToLayoutParams(@NonNull CoordinatorLayout.LayoutParams layoutParams) {
        if (layoutParams.dodgeInsetEdges == 0) {
            layoutParams.dodgeInsetEdges = 80;
        }
    }

    public FabTransformationBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f3137f = new Rect();
        this.f3138g = new RectF();
        this.f3139h = new RectF();
        this.f3140i = new int[2];
    }
}
