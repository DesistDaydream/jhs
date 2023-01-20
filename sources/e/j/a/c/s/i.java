package e.j.a.c.s;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.util.StateSet;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import java.util.ArrayList;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
/* loaded from: classes2.dex */
public final class i {
    private final ArrayList<b> a = new ArrayList<>();
    @Nullable
    private b b = null;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    public ValueAnimator f10996c = null;

    /* renamed from: d  reason: collision with root package name */
    private final Animator.AnimatorListener f10997d = new a();

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            i iVar = i.this;
            if (iVar.f10996c == animator) {
                iVar.f10996c = null;
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        public final int[] a;
        public final ValueAnimator b;

        public b(int[] iArr, ValueAnimator valueAnimator) {
            this.a = iArr;
            this.b = valueAnimator;
        }
    }

    private void b() {
        ValueAnimator valueAnimator = this.f10996c;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f10996c = null;
        }
    }

    private void e(@NonNull b bVar) {
        ValueAnimator valueAnimator = bVar.b;
        this.f10996c = valueAnimator;
        valueAnimator.start();
    }

    public void a(int[] iArr, ValueAnimator valueAnimator) {
        b bVar = new b(iArr, valueAnimator);
        valueAnimator.addListener(this.f10997d);
        this.a.add(bVar);
    }

    public void c() {
        ValueAnimator valueAnimator = this.f10996c;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f10996c = null;
        }
    }

    public void d(int[] iArr) {
        b bVar;
        int size = this.a.size();
        int i2 = 0;
        while (true) {
            if (i2 >= size) {
                bVar = null;
                break;
            }
            bVar = this.a.get(i2);
            if (StateSet.stateSetMatches(bVar.a, iArr)) {
                break;
            }
            i2++;
        }
        b bVar2 = this.b;
        if (bVar == bVar2) {
            return;
        }
        if (bVar2 != null) {
            b();
        }
        this.b = bVar;
        if (bVar != null) {
            e(bVar);
        }
    }
}
