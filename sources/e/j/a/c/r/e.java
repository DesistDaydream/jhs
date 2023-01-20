package e.j.a.c.r;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import e.j.a.c.z.j;
import e.j.a.c.z.o;
import java.util.ArrayList;

@RequiresApi(21)
/* loaded from: classes2.dex */
public class e extends d {

    /* loaded from: classes2.dex */
    public static class a extends j {
        public a(o oVar) {
            super(oVar);
        }

        @Override // e.j.a.c.z.j, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public e(FloatingActionButton floatingActionButton, e.j.a.c.y.c cVar) {
        super(floatingActionButton, cVar);
    }

    @NonNull
    private Animator m0(float f2, float f3) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L)).with(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, f3).setDuration(100L));
        animatorSet.setInterpolator(d.F);
        return animatorSet;
    }

    @Override // e.j.a.c.r.d
    public void A() {
    }

    @Override // e.j.a.c.r.d
    public void C() {
        i0();
    }

    @Override // e.j.a.c.r.d
    public void E(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (this.y.isEnabled()) {
                this.y.setElevation(this.f10949h);
                if (this.y.isPressed()) {
                    this.y.setTranslationZ(this.f10951j);
                    return;
                } else if (!this.y.isFocused() && !this.y.isHovered()) {
                    this.y.setTranslationZ(0.0f);
                    return;
                } else {
                    this.y.setTranslationZ(this.f10950i);
                    return;
                }
            }
            this.y.setElevation(0.0f);
            this.y.setTranslationZ(0.0f);
        }
    }

    @Override // e.j.a.c.r.d
    public void F(float f2, float f3, float f4) {
        int i2 = Build.VERSION.SDK_INT;
        if (i2 == 21) {
            this.y.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(d.S, m0(f2, f4));
            stateListAnimator.addState(d.T, m0(f2, f3));
            stateListAnimator.addState(d.U, m0(f2, f3));
            stateListAnimator.addState(d.V, m0(f2, f3));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.y, "elevation", f2).setDuration(0L));
            if (i2 >= 22 && i2 <= 24) {
                FloatingActionButton floatingActionButton = this.y;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.y, View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(d.F);
            stateListAnimator.addState(d.W, animatorSet);
            stateListAnimator.addState(d.X, m0(0.0f, 0.0f));
            this.y.setStateListAnimator(stateListAnimator);
        }
        if (c0()) {
            i0();
        }
    }

    @Override // e.j.a.c.r.d
    public boolean N() {
        return false;
    }

    @Override // e.j.a.c.r.d
    public void Y(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f10944c;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(e.j.a.c.x.b.d(colorStateList));
        } else {
            super.Y(colorStateList);
        }
    }

    @Override // e.j.a.c.r.d
    public boolean c0() {
        return this.z.a() || !e0();
    }

    @Override // e.j.a.c.r.d
    public void g0() {
    }

    @Override // e.j.a.c.r.d
    @NonNull
    public j j() {
        return new a((o) Preconditions.checkNotNull(this.a));
    }

    @NonNull
    public c l0(int i2, ColorStateList colorStateList) {
        Context context = this.y.getContext();
        c cVar = new c((o) Preconditions.checkNotNull(this.a));
        cVar.f(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        cVar.e(i2);
        cVar.d(colorStateList);
        return cVar;
    }

    @Override // e.j.a.c.r.d
    public float n() {
        return this.y.getElevation();
    }

    @Override // e.j.a.c.r.d
    public void s(@NonNull Rect rect) {
        if (this.z.a()) {
            super.s(rect);
        } else if (!e0()) {
            int sizeDimension = (this.f10952k - this.y.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        } else {
            rect.set(0, 0, 0, 0);
        }
    }

    @Override // e.j.a.c.r.d
    public void x(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i2) {
        Drawable drawable;
        j j2 = j();
        this.b = j2;
        j2.setTintList(colorStateList);
        if (mode != null) {
            this.b.setTintMode(mode);
        }
        this.b.Y(this.y.getContext());
        if (i2 > 0) {
            this.f10945d = l0(i2, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f10945d), (Drawable) Preconditions.checkNotNull(this.b)});
        } else {
            this.f10945d = null;
            drawable = this.b;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(e.j.a.c.x.b.d(colorStateList2), drawable, null);
        this.f10944c = rippleDrawable;
        this.f10946e = rippleDrawable;
    }
}
