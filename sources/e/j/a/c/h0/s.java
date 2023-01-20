package e.j.a.c.h0;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.annotation.RestrictTo;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes2.dex */
public final class s implements v {

    /* renamed from: c  reason: collision with root package name */
    private static final int f10753c = -1;
    private int a;
    @Px
    private int b = -1;

    /* loaded from: classes2.dex */
    public static class a extends AnimatorListenerAdapter {
        public final /* synthetic */ View a;
        public final /* synthetic */ float b;

        public a(View view, float f2) {
            this.a = view;
            this.b = f2;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.a.setTranslationX(this.b);
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
            this.a.setTranslationY(this.b);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes2.dex */
    public @interface c {
    }

    public s(int i2) {
        this.a = i2;
    }

    private static Animator c(View view, View view2, int i2, @Px int i3) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 48) {
                    if (i2 != 80) {
                        if (i2 == 8388611) {
                            return e(view2, j(view) ? i3 + translationX : translationX - i3, translationX, translationX);
                        } else if (i2 == 8388613) {
                            return e(view2, j(view) ? translationX - i3 : i3 + translationX, translationX, translationX);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i2);
                        }
                    }
                    return f(view2, i3 + translationY, translationY, translationY);
                }
                return f(view2, translationY - i3, translationY, translationY);
            }
            return e(view2, translationX - i3, translationX, translationX);
        }
        return e(view2, i3 + translationX, translationX, translationX);
    }

    private static Animator d(View view, View view2, int i2, @Px int i3) {
        float translationX = view2.getTranslationX();
        float translationY = view2.getTranslationY();
        if (i2 != 3) {
            if (i2 != 5) {
                if (i2 != 48) {
                    if (i2 != 80) {
                        if (i2 == 8388611) {
                            return e(view2, translationX, j(view) ? translationX - i3 : i3 + translationX, translationX);
                        } else if (i2 == 8388613) {
                            return e(view2, translationX, j(view) ? i3 + translationX : translationX - i3, translationX);
                        } else {
                            throw new IllegalArgumentException("Invalid slide direction: " + i2);
                        }
                    }
                    return f(view2, translationY, translationY - i3, translationY);
                }
                return f(view2, translationY, i3 + translationY, translationY);
            }
            return e(view2, translationX, i3 + translationX, translationX);
        }
        return e(view2, translationX, translationX - i3, translationX);
    }

    private static Animator e(View view, float f2, float f3, float f4) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_X, f2, f3));
        ofPropertyValuesHolder.addListener(new a(view, f4));
        return ofPropertyValuesHolder;
    }

    private static Animator f(View view, float f2, float f3, float f4) {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, f2, f3));
        ofPropertyValuesHolder.addListener(new b(view, f4));
        return ofPropertyValuesHolder;
    }

    private int h(Context context) {
        int i2 = this.b;
        return i2 != -1 ? i2 : context.getResources().getDimensionPixelSize(R.dimen.mtrl_transition_shared_axis_slide_distance);
    }

    private static boolean j(View view) {
        return ViewCompat.getLayoutDirection(view) == 1;
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator a(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return d(viewGroup, view, this.a, h(view.getContext()));
    }

    @Override // e.j.a.c.h0.v
    @Nullable
    public Animator b(@NonNull ViewGroup viewGroup, @NonNull View view) {
        return c(viewGroup, view, this.a, h(view.getContext()));
    }

    @Px
    public int g() {
        return this.b;
    }

    public int i() {
        return this.a;
    }

    public void k(@Px int i2) {
        if (i2 >= 0) {
            this.b = i2;
            return;
        }
        throw new IllegalArgumentException("Slide distance must be positive. If attempting to reverse the direction of the slide, use setSlideEdge(int) instead.");
    }

    public void l(int i2) {
        this.a = i2;
    }
}
