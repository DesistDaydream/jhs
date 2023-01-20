package e.b.a.p.l.y;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.j.j;
import e.b.a.p.l.m;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public class b implements n<e.b.a.p.l.g, InputStream> {
    public static final e.b.a.p.e<Integer> b = e.b.a.p.e.g("com.bumptech.glide.load.model.stream.HttpGlideUrlLoader.Timeout", 2500);
    @Nullable
    private final m<e.b.a.p.l.g, e.b.a.p.l.g> a;

    /* loaded from: classes.dex */
    public static class a implements o<e.b.a.p.l.g, InputStream> {
        private final m<e.b.a.p.l.g, e.b.a.p.l.g> a = new m<>(500);

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<e.b.a.p.l.g, InputStream> c(r rVar) {
            return new b(this.a);
        }
    }

    public b() {
        this(null);
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull e.b.a.p.l.g gVar, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        m<e.b.a.p.l.g, e.b.a.p.l.g> mVar = this.a;
        if (mVar != null) {
            e.b.a.p.l.g b2 = mVar.b(gVar, 0, 0);
            if (b2 == null) {
                this.a.c(gVar, 0, 0, gVar);
            } else {
                gVar = b2;
            }
        }
        return new n.a<>(gVar, new j(gVar, ((Integer) fVar.a(b)).intValue()));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull e.b.a.p.l.g gVar) {
        return true;
    }

    public b(@Nullable m<e.b.a.p.l.g, e.b.a.p.l.g> mVar) {
        this.a = mVar;
    }
}
