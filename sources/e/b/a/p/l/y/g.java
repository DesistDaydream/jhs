package e.b.a.p.l.y;

import androidx.annotation.NonNull;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;
import java.net.URL;

/* loaded from: classes.dex */
public class g implements n<URL, InputStream> {
    private final n<e.b.a.p.l.g, InputStream> a;

    /* loaded from: classes.dex */
    public static class a implements o<URL, InputStream> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<URL, InputStream> c(r rVar) {
            return new g(rVar.d(e.b.a.p.l.g.class, InputStream.class));
        }
    }

    public g(n<e.b.a.p.l.g, InputStream> nVar) {
        this.a = nVar;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull URL url, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return this.a.b(new e.b.a.p.l.g(url), i2, i3, fVar);
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull URL url) {
        return true;
    }
}
