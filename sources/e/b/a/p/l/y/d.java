package e.b.a.p.l.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public class d implements n<Uri, InputStream> {
    private final Context a;

    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new d(this.a);
        }
    }

    public d(Context context) {
        this.a = context.getApplicationContext();
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        if (e.b.a.p.j.o.b.d(i2, i3)) {
            return new n.a<>(new e.b.a.u.e(uri), e.b.a.p.j.o.c.d(this.a, uri));
        }
        return null;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return e.b.a.p.j.o.b.a(uri);
    }
}
