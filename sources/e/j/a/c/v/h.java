package e.j.a.c.v;

import android.animation.Animator;
import androidx.annotation.NonNull;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;

/* loaded from: classes2.dex */
public abstract class h<T extends Animator> {
    public i a;
    public final float[] b;

    /* renamed from: c  reason: collision with root package name */
    public final int[] f11037c;

    public h(int i2) {
        this.b = new float[i2 * 2];
        this.f11037c = new int[i2];
    }

    public abstract void a();

    public float b(int i2, int i3, int i4) {
        return (i2 - i3) / i4;
    }

    public abstract void c();

    public abstract void d(@NonNull Animatable2Compat.AnimationCallback animationCallback);

    public void e(@NonNull i iVar) {
        this.a = iVar;
    }

    public abstract void f();

    public abstract void g();

    public abstract void h();
}
