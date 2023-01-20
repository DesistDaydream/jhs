package e.b.a.t.l;

import com.bumptech.glide.load.DataSource;
import e.b.a.t.l.j;

/* loaded from: classes.dex */
public class i<R> implements g<R> {
    private final j.a a;
    private j<R> b;

    public i(j.a aVar) {
        this.a = aVar;
    }

    @Override // e.b.a.t.l.g
    public f<R> a(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.b == null) {
                this.b = new j<>(this.a);
            }
            return this.b;
        }
        return e.b();
    }
}
