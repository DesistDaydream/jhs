package e.b.a.p.l;

import android.net.Uri;
import androidx.annotation.NonNull;
import e.b.a.p.l.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class x<Data> implements n<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("http", "https")));
    private final n<g, Data> a;

    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new x(rVar.d(g.class, InputStream.class));
        }
    }

    public x(n<g, Data> nVar) {
        this.a = nVar;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return this.a.b(new g(uri.toString()), i2, i3, fVar);
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
