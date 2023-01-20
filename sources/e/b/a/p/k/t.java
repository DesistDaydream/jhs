package e.b.a.p.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.k.e;
import e.b.a.p.l.n;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class t implements e, d.a<Object> {
    private final e.a a;
    private final f<?> b;

    /* renamed from: c  reason: collision with root package name */
    private int f9582c;

    /* renamed from: d  reason: collision with root package name */
    private int f9583d = -1;

    /* renamed from: e  reason: collision with root package name */
    private e.b.a.p.c f9584e;

    /* renamed from: f  reason: collision with root package name */
    private List<e.b.a.p.l.n<File, ?>> f9585f;

    /* renamed from: g  reason: collision with root package name */
    private int f9586g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f9587h;

    /* renamed from: i  reason: collision with root package name */
    private File f9588i;

    /* renamed from: j  reason: collision with root package name */
    private u f9589j;

    public t(f<?> fVar, e.a aVar) {
        this.b = fVar;
        this.a = aVar;
    }

    private boolean a() {
        return this.f9586g < this.f9585f.size();
    }

    @Override // e.b.a.p.j.d.a
    public void b(@NonNull Exception exc) {
        this.a.a(this.f9589j, exc, this.f9587h.f9707c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // e.b.a.p.k.e
    public boolean c() {
        List<e.b.a.p.c> c2 = this.b.c();
        boolean z = false;
        if (c2.isEmpty()) {
            return false;
        }
        List<Class<?>> m2 = this.b.m();
        if (m2.isEmpty()) {
            if (File.class.equals(this.b.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.b.i() + " to " + this.b.q());
        }
        while (true) {
            if (this.f9585f != null && a()) {
                this.f9587h = null;
                while (!z && a()) {
                    List<e.b.a.p.l.n<File, ?>> list = this.f9585f;
                    int i2 = this.f9586g;
                    this.f9586g = i2 + 1;
                    this.f9587h = list.get(i2).b(this.f9588i, this.b.s(), this.b.f(), this.b.k());
                    if (this.f9587h != null && this.b.t(this.f9587h.f9707c.getDataClass())) {
                        this.f9587h.f9707c.c(this.b.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f9583d + 1;
            this.f9583d = i3;
            if (i3 >= m2.size()) {
                int i4 = this.f9582c + 1;
                this.f9582c = i4;
                if (i4 >= c2.size()) {
                    return false;
                }
                this.f9583d = 0;
            }
            e.b.a.p.c cVar = c2.get(this.f9582c);
            Class<?> cls = m2.get(this.f9583d);
            this.f9589j = new u(this.b.b(), cVar, this.b.o(), this.b.s(), this.b.f(), this.b.r(cls), cls, this.b.k());
            File b = this.b.d().b(this.f9589j);
            this.f9588i = b;
            if (b != null) {
                this.f9584e = cVar;
                this.f9585f = this.b.j(b);
                this.f9586g = 0;
            }
        }
    }

    @Override // e.b.a.p.k.e
    public void cancel() {
        n.a<?> aVar = this.f9587h;
        if (aVar != null) {
            aVar.f9707c.cancel();
        }
    }

    @Override // e.b.a.p.j.d.a
    public void d(Object obj) {
        this.a.e(this.f9584e, obj, this.f9587h.f9707c, DataSource.RESOURCE_DISK_CACHE, this.f9589j);
    }
}
