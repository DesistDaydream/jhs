package e.b.a.p.m.f;

import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import e.b.a.p.k.o;
import e.b.a.p.k.s;
import e.b.a.v.l;

/* loaded from: classes.dex */
public abstract class b<T extends Drawable> implements s<T>, o {
    public final T a;

    public b(T t) {
        this.a = (T) l.d(t);
    }

    public void a() {
        T t = this.a;
        if (t instanceof BitmapDrawable) {
            ((BitmapDrawable) t).getBitmap().prepareToDraw();
        } else if (t instanceof e.b.a.p.m.h.c) {
            ((e.b.a.p.m.h.c) t).e().prepareToDraw();
        }
    }

    @Override // e.b.a.p.k.s
    @NonNull
    /* renamed from: c */
    public final T get() {
        Drawable.ConstantState constantState = this.a.getConstantState();
        if (constantState == null) {
            return this.a;
        }
        return (T) constantState.newDrawable();
    }
}
