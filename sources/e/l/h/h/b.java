package e.l.h.h;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;
import com.jihuanshe.base.magicindicator.MagicIndicator;
import java.util.ArrayList;
import java.util.List;

@TargetApi(11)
/* loaded from: classes2.dex */
public class b {
    private ValueAnimator b;

    /* renamed from: c  reason: collision with root package name */
    private int f12105c;
    private List<MagicIndicator> a = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f12106d = 150;

    /* renamed from: e  reason: collision with root package name */
    private Interpolator f12107e = new AccelerateDecelerateInterpolator();

    /* renamed from: f  reason: collision with root package name */
    private Animator.AnimatorListener f12108f = new a();

    /* renamed from: g  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f12109g = new C0387b();

    /* loaded from: classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            b.this.e(0);
            b.this.b = null;
        }
    }

    /* renamed from: e.l.h.h.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0387b implements ValueAnimator.AnimatorUpdateListener {
        public C0387b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            int i2 = (int) floatValue;
            float f2 = floatValue - i2;
            if (floatValue < 0.0f) {
                i2--;
                f2 += 1.0f;
            }
            b.this.f(i2, f2, 0);
        }
    }

    public b() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(int i2) {
        for (MagicIndicator magicIndicator : this.a) {
            magicIndicator.a(i2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(int i2, float f2, int i3) {
        for (MagicIndicator magicIndicator : this.a) {
            magicIndicator.b(i2, f2, i3);
        }
    }

    private void g(int i2) {
        for (MagicIndicator magicIndicator : this.a) {
            magicIndicator.c(i2);
        }
    }

    public static e.l.h.h.g.b.a h(List<e.l.h.h.g.b.a> list, int i2) {
        e.l.h.h.g.b.a aVar;
        if (i2 >= 0 && i2 <= list.size() - 1) {
            return list.get(i2);
        }
        e.l.h.h.g.b.a aVar2 = new e.l.h.h.g.b.a();
        if (i2 < 0) {
            aVar = list.get(0);
        } else {
            i2 = (i2 - list.size()) + 1;
            aVar = list.get(list.size() - 1);
        }
        aVar2.a = aVar.a + (aVar.f() * i2);
        aVar2.b = aVar.b;
        aVar2.f12118c = aVar.f12118c + (aVar.f() * i2);
        aVar2.f12119d = aVar.f12119d;
        aVar2.f12120e = aVar.f12120e + (aVar.f() * i2);
        aVar2.f12121f = aVar.f12121f;
        aVar2.f12122g = aVar.f12122g + (i2 * aVar.f());
        aVar2.f12123h = aVar.f12123h;
        return aVar2;
    }

    public void d(MagicIndicator magicIndicator) {
        this.a.add(magicIndicator);
    }

    public void i(int i2) {
        j(i2, true);
    }

    public void j(int i2, boolean z) {
        if (this.f12105c == i2) {
            return;
        }
        if (z) {
            ValueAnimator valueAnimator = this.b;
            if (valueAnimator == null || !valueAnimator.isRunning()) {
                e(2);
            }
            g(i2);
            float f2 = this.f12105c;
            ValueAnimator valueAnimator2 = this.b;
            if (valueAnimator2 != null) {
                f2 = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                this.b.cancel();
                this.b = null;
            }
            ValueAnimator valueAnimator3 = new ValueAnimator();
            this.b = valueAnimator3;
            valueAnimator3.setFloatValues(f2, i2);
            this.b.addUpdateListener(this.f12109g);
            this.b.addListener(this.f12108f);
            this.b.setInterpolator(this.f12107e);
            this.b.setDuration(this.f12106d);
            this.b.start();
        } else {
            g(i2);
            ValueAnimator valueAnimator4 = this.b;
            if (valueAnimator4 != null && valueAnimator4.isRunning()) {
                f(this.f12105c, 0.0f, 0);
            }
            e(0);
            f(i2, 0.0f, 0);
        }
        this.f12105c = i2;
    }

    public void k(int i2) {
        this.f12106d = i2;
    }

    public void l(Interpolator interpolator) {
        if (interpolator == null) {
            this.f12107e = new AccelerateDecelerateInterpolator();
        } else {
            this.f12107e = interpolator;
        }
    }

    public b(MagicIndicator magicIndicator) {
        this.a.add(magicIndicator);
    }
}
