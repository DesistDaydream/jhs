package e.j.a.c.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class e implements v {
    public static final float b = 0.35f;
    private float a = 0.35f;

    /* loaded from: classes2.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f10693c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f10694d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f10695e;

        public a(View view, float f2, float f3, float f4, float f5) {
            this.a = view;
            this.b = f2;
            this.f10693c = f3;
            this.f10694d = f4;
            this.f10695e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(u.o(this.b, this.f10693c, this.f10694d, this.f10695e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        public b(View view, float f2) {
            this.a = view;
            this.b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setAlpha(this.b);
        }
    }

    private static Animator c(View view, float f2, float f3, @FloatRange(from = 0.0d, to = 1.0d) float f4, @FloatRange(from = 0.0d, to = 1.0d) float f5, float f6) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new a(view, f2, f3, f4, f5));
        ofFloat.addListener(new b(view, f6));
        return ofFloat;
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, this.a, alpha);
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, this.a, 1.0f, alpha);
    }

    public float d() {
        return this.a;
    }

    public void e(@FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.a = f2;
    }
}
