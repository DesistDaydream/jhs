package e.b.a.p.k;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.k.e;
import e.b.a.p.l.n;
import java.io.File;
import java.util.List;

/* loaded from: classes.dex */
public class b implements e, d.a<Object> {
    private final List<e.b.a.p.c> a;
    private final f<?> b;

    /* renamed from: c  reason: collision with root package name */
    private final e.a f9508c;

    /* renamed from: d  reason: collision with root package name */
    private int f9509d;

    /* renamed from: e  reason: collision with root package name */
    private e.b.a.p.c f9510e;

    /* renamed from: f  reason: collision with root package name */
    private List<e.b.a.p.l.n<File, ?>> f9511f;

    /* renamed from: g  reason: collision with root package name */
    private int f9512g;

    /* renamed from: h  reason: collision with root package name */
    private volatile n.a<?> f9513h;

    /* renamed from: i  reason: collision with root package name */
    private File f9514i;

    public b(f<?> fVar, e.a aVar) {
        this(fVar.c(), fVar, aVar);
    }

    private boolean a() {
        return this.f9512g < this.f9511f.size();
    }

    @Override // e.b.a.p.j.d.a
    public void b(@NonNull Exception exc) {
        this.f9508c.a(this.f9510e, exc, this.f9513h.f9707c, DataSource.DATA_DISK_CACHE);
    }

    @Override // e.b.a.p.k.e
    public boolean c() {
        while (true) {
            boolean z = false;
            if (this.f9511f != null && a()) {
                this.f9513h = null;
                while (!z && a()) {
                    List<e.b.a.p.l.n<File, ?>> list = this.f9511f;
                    int i2 = this.f9512g;
                    this.f9512g = i2 + 1;
                    this.f9513h = list.get(i2).b(this.f9514i, this.b.s(), this.b.f(), this.b.k());
                    if (this.f9513h != null && this.b.t(this.f9513h.f9707c.getDataClass())) {
                        this.f9513h.f9707c.c(this.b.l(), this);
                        z = true;
                    }
                }
                return z;
            }
            int i3 = this.f9509d + 1;
            this.f9509d = i3;
            if (i3 >= this.a.size()) {
                return false;
            }
            e.b.a.p.c cVar = this.a.get(this.f9509d);
            File b = this.b.d().b(new c(cVar, this.b.o()));
            this.f9514i = b;
            if (b != null) {
                this.f9510e = cVar;
                this.f9511f = this.b.j(b);
                this.f9512g = 0;
            }
        }
    }

    @Override // e.b.a.p.k.e
    public void cancel() {
        n.a<?> aVar = this.f9513h;
        if (aVar != null) {
            aVar.f9707c.cancel();
        }
    }

    @Override // e.b.a.p.j.d.a
    public void d(Object obj) {
        this.f9508c.e(this.f9510e, obj, this.f9513h.f9707c, DataSource.DATA_DISK_CACHE, this.f9510e);
    }

    public b(List<e.b.a.p.c> list, f<?> fVar, e.a aVar) {
        this.f9509d = -1;
        this.a = list;
        this.b = fVar;
        this.f9508c = aVar;
    }
}
