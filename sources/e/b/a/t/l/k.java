package e.b.a.t.l;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public class k<R> implements f<R> {
    private final a a;

    /* loaded from: classes.dex */
    public interface a {
        Animation a(Context context);
    }

    public k(a aVar) {
        this.a = aVar;
    }

    @Override // e.b.a.t.l.f
    public boolean a(R r, f.a aVar) {
        View b = aVar.b();
        if (b != null) {
            b.clearAnimation();
            b.startAnimation(this.a.a(b.getContext()));
            return false;
        }
        return false;
    }
}
