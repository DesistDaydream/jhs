package e.j.a.c.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public final class r implements v {
    private float a;
    private float b;

    /* renamed from: c  reason: collision with root package name */
    private float f10748c;

    /* renamed from: d  reason: collision with root package name */
    private float f10749d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f10750e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f10751f;

    /* loaded from: classes2.dex */
    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ float f10752c;

        public a(View view, float f2, float f3) {
            this.a = view;
            this.b = f2;
            this.f10752c = f3;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setScaleX(this.b);
            this.a.setScaleY(this.f10752c);
        }
    }

    public r() {
        this(true);
    }

    private static Animator c(View view, float f2, float f3) {
        float scaleX = view.getScaleX();
        float scaleY = view.getScaleY();
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.SCALE_X, scaleX * f2, scaleX * f3), PropertyValuesHolder.ofFloat(View.SCALE_Y, f2 * scaleY, f3 * scaleY));
        ofPropertyValuesHolder.addListener(new a(view, scaleX, scaleY));
        return ofPropertyValuesHolder;
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f10751f) {
            if (this.f10750e) {
                return c(view, this.a, this.b);
            }
            return c(view, this.f10749d, this.f10748c);
        }
        return null;
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        if (this.f10750e) {
            return c(view, this.f10748c, this.f10749d);
        }
        return c(view, this.b, this.a);
    }

    public float d() {
        return this.f10749d;
    }

    public float e() {
        return this.f10748c;
    }

    public float f() {
        return this.b;
    }

    public float g() {
        return this.a;
    }

    public boolean h() {
        return this.f10750e;
    }

    public boolean i() {
        return this.f10751f;
    }

    public void j(boolean z) {
        this.f10750e = z;
    }

    public void k(float f2) {
        this.f10749d = f2;
    }

    public void l(float f2) {
        this.f10748c = f2;
    }

    public void m(float f2) {
        this.b = f2;
    }

    public void n(float f2) {
        this.a = f2;
    }

    public void o(boolean z) {
        this.f10751f = z;
    }

    public r(boolean z) {
        this.a = 1.0f;
        this.b = 1.1f;
        this.f10748c = 0.8f;
        this.f10749d = 1.0f;
        this.f10751f = true;
        this.f10750e = z;
    }
}
