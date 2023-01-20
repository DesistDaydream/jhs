package e.b.a.p.k.y;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import e.b.a.v.n;
import e.b.a.v.p.a;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public class m {
    private final e.b.a.v.i<e.b.a.p.c, String> a = new e.b.a.v.i<>(1000);
    private final Pools.Pool<b> b = e.b.a.v.p.a.e(10, new a());

    /* loaded from: classes.dex */
    public class a implements a.d<b> {
        public a() {
        }

        @Override // e.b.a.v.p.a.d
        /* renamed from: b */
        public b a() {
            try {
                return new b(MessageDigest.getInstance("SHA-256"));
            } catch (NoSuchAlgorithmException e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    /* loaded from: classes.dex */
    public static final class b implements a.f {
        public final MessageDigest a;
        private final e.b.a.v.p.c b = e.b.a.v.p.c.a();

        public b(MessageDigest messageDigest) {
            this.a = messageDigest;
        }

        @Override // e.b.a.v.p.a.f
        @NonNull
        public e.b.a.v.p.c d() {
            return this.b;
        }
    }

    private String a(e.b.a.p.c cVar) {
        b bVar = (b) e.b.a.v.l.d(this.b.acquire());
        try {
            cVar.updateDiskCacheKey(bVar.a);
            return n.z(bVar.a.digest());
        } finally {
            this.b.release(bVar);
        }
    }

    public String b(e.b.a.p.c cVar) {
        String j2;
        synchronized (this.a) {
            j2 = this.a.j(cVar);
        }
        if (j2 == null) {
            j2 = a(cVar);
        }
        synchronized (this.a) {
            this.a.n(cVar, j2);
        }
        return j2;
    }
}
