package e.b.a.p.j;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import e.b.a.p.j.e;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class k implements e<InputStream> {
    private static final int b = 5242880;
    private final RecyclableBufferedInputStream a;

    /* loaded from: classes.dex */
    public static final class a implements e.a<InputStream> {
        private final e.b.a.p.k.x.b a;

        public a(e.b.a.p.k.x.b bVar) {
            this.a = bVar;
        }

        @Override // e.b.a.p.j.e.a
        @NonNull
        /* renamed from: b */
        public e<InputStream> a(InputStream inputStream) {
            return new k(inputStream, this.a);
        }

        @Override // e.b.a.p.j.e.a
        @NonNull
        public Class<InputStream> getDataClass() {
            return InputStream.class;
        }
    }

    public k(InputStream inputStream, e.b.a.p.k.x.b bVar) {
        RecyclableBufferedInputStream recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        this.a = recyclableBufferedInputStream;
        recyclableBufferedInputStream.mark(b);
    }

    @Override // e.b.a.p.j.e
    public void a() {
        this.a.k();
    }

    public void c() {
        this.a.j();
    }

    @Override // e.b.a.p.j.e
    @NonNull
    /* renamed from: d */
    public InputStream b() throws IOException {
        this.a.reset();
        return this.a;
    }
}
