package e.b.a.p.m.d;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;

/* loaded from: classes.dex */
public class c extends e.b.a.p.m.f.b<BitmapDrawable> implements e.b.a.p.k.o {
    private final e.b.a.p.k.x.e b;

    public c(BitmapDrawable bitmapDrawable, e.b.a.p.k.x.e eVar) {
        super(bitmapDrawable);
        this.b = eVar;
    }

    @Override // e.b.a.p.m.f.b, e.b.a.p.k.o
    public void a() {
        ((BitmapDrawable) this.a).getBitmap().prepareToDraw();
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<BitmapDrawable> b() {
        return BitmapDrawable.class;
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return e.b.a.v.n.h(((BitmapDrawable) this.a).getBitmap());
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
        this.b.d(((BitmapDrawable) this.a).getBitmap());
    }
}
