package e.b.a.p.m.h;

import androidx.annotation.NonNull;
import e.b.a.p.k.o;

/* loaded from: classes.dex */
public class e extends e.b.a.p.m.f.b<c> implements o {
    public e(c cVar) {
        super(cVar);
    }

    @Override // e.b.a.p.m.f.b, e.b.a.p.k.o
    public void a() {
        ((c) this.a).e().prepareToDraw();
    }

    @Override // e.b.a.p.k.s
    @NonNull
    public Class<c> b() {
        return c.class;
    }

    @Override // e.b.a.p.k.s
    public int getSize() {
        return ((c) this.a).j();
    }

    @Override // e.b.a.p.k.s
    public void recycle() {
        ((c) this.a).stop();
        ((c) this.a).m();
    }
}
