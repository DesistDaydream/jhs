package e.j.a.c.h0.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class d implements w {
    private float a = 1.0f;

    /* loaded from: classes2.dex */
    public static class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f10767c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ float f10768d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ float f10769e;

        public a(View view, float f2, float f3, float f4, float f5) {
            this.a = view;
            this.b = f2;
            this.f10767c = f3;
            this.f10768d = f4;
            this.f10769e = f5;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            this.a.setAlpha(v.o(this.b, this.f10767c, this.f10768d, this.f10769e, ((Float) valueAnimator.getAnimatedValue()).floatValue()));
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

    @Override // e.j.a.c.h0.w.w
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, alpha, 0.0f, 0.0f, 1.0f, alpha);
    }

    @Override // e.j.a.c.h0.w.w
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        float alpha = view.getAlpha() == 0.0f ? 1.0f : view.getAlpha();
        return c(view, 0.0f, alpha, 0.0f, this.a, alpha);
    }

    public float d() {
        return this.a;
    }

    public void e(float f2) {
        this.a = f2;
    }
}
