package e.b.a.t.l;

import com.bumptech.glide.load.DataSource;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public class e<R> implements f<R> {
    public static final e<?> a = new e<>();
    private static final g<?> b = new a();

    /* loaded from: classes.dex */
    public static class a<R> implements g<R> {
        @Override // e.b.a.t.l.g
        public f<R> a(DataSource dataSource, boolean z) {
            return e.a;
        }
    }

    public static <R> f<R> b() {
        return a;
    }

    public static <R> g<R> c() {
        return (g<R>) b;
    }

    @Override // e.b.a.t.l.f
    public boolean a(Object obj, f.a aVar) {
        return false;
    }
}
