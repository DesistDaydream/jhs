package e.j.a.c.h0.w;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
/* loaded from: classes2.dex */
public final class s implements w {
    private float a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f10829c;

    /* renamed from: d  reason: collision with root package name */
    private float f10830d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10831e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10832f;

    /* loaded from: classes2.dex */
    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f10833c;

        public a(View view, float f2, float f3) {
            this.a = view;
            this.b = f2;
            this.f10833c = f3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setScaleX(this.b);
            this.a.setScaleY(this.f10833c);
        }
    }

    public s() {
        this(true);
    }

    private static Animator c(View view, float f2, float f3) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f2, scaleX * f3), PropertyValuesHolder.ofFloat(View.SCALE_Y, f2 * scaleY, f3 * scaleY));
        ofPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return ofPropertyValuesHolder;
    }

    @Override // e.j.a.c.h0.w.w
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f10832f) {
            if (this.f10831e) {
                return c(view, this.a, this.b);
            }
            return c(view, this.f10830d, this.f10829c);
        }
        return null;
    }

    @Override // e.j.a.c.h0.w.w
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f10831e) {
            return c(view, this.f10829c, this.f10830d);
        }
        return c(view, this.b, this.a);
    }

    public float d() {
        return this.f10830d;
    }

    public float e() {
        return this.f10829c;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.a;
    }

    public boolean h() {
        return this.f10831e;
    }

    public boolean i() {
        return this.f10832f;
    }

    public void j(boolean z) {
        this.f10831e = z;
    }

    public void k(float f2) {
        this.f10830d = f2;
    }

    public void l(float f2) {
        this.f10829c = f2;
    }

    public void m(float f2) {
        this.b = f2;
    }

    public void n(float f2) {
        this.a = f2;
    }

    public void o(boolean z) {
        this.f10832f = z;
    }

    public s(boolean z) {
        this.a = 1.0f;
        this.b = 1.1f;
        this.f10829c = 0.8f;
        this.f10830d = 1.0f;
        this.f10832f = true;
        this.f10831e = z;
    }
}
