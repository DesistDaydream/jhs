package e.b.a.t.l;

import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public class d implements f<Drawable> {
    private final int a;
    private final boolean b;

    public d(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    @Override // e.b.a.t.l.f
    /* renamed from: b */
    public boolean a(Drawable drawable, f.a aVar) {
        Drawable c2 = aVar.c();
        if (c2 == null) {
            c2 = new ColorDrawable(0);
        }
        TransitionDrawable transitionDrawable = new TransitionDrawable(new Drawable[]{c2, drawable});
        transitionDrawable.setCrossFadeEnabled(this.b);
        transitionDrawable.startTransition(this.a);
        aVar.a(transitionDrawable);
        return true;
    }
}
