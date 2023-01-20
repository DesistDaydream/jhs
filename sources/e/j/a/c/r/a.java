package e.j.a.c.r;

import android.animation.Animator;
import androidx.annotation.Nullable;

/* loaded from: classes2.dex */
public class a {
    @Nullable
    private Animator a;

    public void a() {
        Animator animator = this.a;
        if (animator != null) {
            animator.cancel();
        }
    }

    public void b() {
        this.a = null;
    }

    public void c(Animator animator) {
        a();
        this.a = animator;
    }
}
