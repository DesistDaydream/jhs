package e.b.a.o.a;

import androidx.annotation.NonNull;
import e.b.a.p.f;
import e.b.a.p.l.g;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.OkHttpClient;

/* loaded from: classes.dex */
public class c implements n<g, InputStream> {
    private final Call.Factory a;

    /* loaded from: classes.dex */
    public static class a implements o<g, InputStream> {
        private static volatile Call.Factory b;
        private final Call.Factory a;

        public a() {
            this(b());
        }

        private static Call.Factory b() {
            if (b == null) {
                synchronized (a.class) {
                    if (b == null) {
                        b = new OkHttpClient();
                    }
                }
            }
            return b;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<g, InputStream> c(r rVar) {
            return new c(this.a);
        }

        public a(@NonNull Call.Factory factory) {
            this.a = factory;
        }
    }

    public c(@NonNull Call.Factory factory) {
        this.a = factory;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull g gVar, int i2, int i3, @NonNull f fVar) {
        return new n.a<>(gVar, new b(this.a, gVar));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull g gVar) {
        return true;
    }
}
