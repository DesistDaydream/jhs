package e.j.a.c.a;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class i {
    private long a;
    private long b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private TimeInterpolator f10556c;

    /* renamed from: d  reason: collision with root package name */
    private int f10557d;

    /* renamed from: e  reason: collision with root package name */
    private int f10558e;

    public i(long j2, long j3) {
        this.a = 0L;
        this.b = 300L;
        this.f10556c = null;
        this.f10557d = 0;
        this.f10558e = 1;
        this.a = j2;
        this.b = j3;
    }

    @NonNull
    public static i b(@NonNull ValueAnimator valueAnimator) {
        i iVar = new i(valueAnimator.getStartDelay(), valueAnimator.getDuration(), f(valueAnimator));
        iVar.f10557d = valueAnimator.getRepeatCount();
        iVar.f10558e = valueAnimator.getRepeatMode();
        return iVar;
    }

    private static TimeInterpolator f(@NonNull ValueAnimator valueAnimator) {
        TimeInterpolator interpolator = valueAnimator.getInterpolator();
        if (!(interpolator instanceof AccelerateDecelerateInterpolator) && interpolator != null) {
            if (interpolator instanceof AccelerateInterpolator) {
                return a.f10551c;
            }
            return interpolator instanceof DecelerateInterpolator ? a.f10552d : interpolator;
        }
        return a.b;
    }

    public void a(@NonNull Animator animator) {
        animator.setStartDelay(c());
        animator.setDuration(d());
        animator.setInterpolator(e());
        if (animator instanceof ValueAnimator) {
            ValueAnimator valueAnimator = (ValueAnimator) animator;
            valueAnimator.setRepeatCount(g());
            valueAnimator.setRepeatMode(h());
        }
    }

    public long c() {
        return this.a;
    }

    public long d() {
        return this.b;
    }

    @Nullable
    public TimeInterpolator e() {
        TimeInterpolator timeInterpolator = this.f10556c;
        return timeInterpolator != null ? timeInterpolator : a.b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof i) {
            i iVar = (i) obj;
            if (c() == iVar.c() && d() == iVar.d() && g() == iVar.g() && h() == iVar.h()) {
                return e().getClass().equals(iVar.e().getClass());
            }
            return false;
        }
        return false;
    }

    public int g() {
        return this.f10557d;
    }

    public int h() {
        return this.f10558e;
    }

    public int hashCode() {
        return (((((((((int) (c() ^ (c() >>> 32))) * 31) + ((int) (d() ^ (d() >>> 32)))) * 31) + e().getClass().hashCode()) * 31) + g()) * 31) + h();
    }

    @NonNull
    public String toString() {
        return '\n' + getClass().getName() + '{' + Integer.toHexString(System.identityHashCode(this)) + " delay: " + c() + " duration: " + d() + " interpolator: " + e().getClass() + " repeatCount: " + g() + " repeatMode: " + h() + "}\n";
    }

    public i(long j2, long j3, @NonNull TimeInterpolator timeInterpolator) {
        this.a = 0L;
        this.b = 300L;
        this.f10556c = null;
        this.f10557d = 0;
        this.f10558e = 1;
        this.a = j2;
        this.b = j3;
        this.f10556c = timeInterpolator;
    }
}
