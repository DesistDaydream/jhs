package e.b.a.p.m.d;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import e.b.a.p.m.d.o;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c0 implements e.b.a.p.g<InputStream, Bitmap> {
    private final o a;
    private final e.b.a.p.k.x.b b;

    /* loaded from: classes.dex */
    public static class a implements o.b {
        private final RecyclableBufferedInputStream a;
        private final e.b.a.v.e b;

        public a(RecyclableBufferedInputStream recyclableBufferedInputStream, e.b.a.v.e eVar) {
            this.a = recyclableBufferedInputStream;
            this.b = eVar;
        }

        @Override // e.b.a.p.m.d.o.b
        public void a(e.b.a.p.k.x.e eVar, Bitmap bitmap) throws IOException {
            IOException k2 = this.b.k();
            if (k2 != null) {
                if (bitmap != null) {
                    eVar.d(bitmap);
                }
                throw k2;
            }
        }

        @Override // e.b.a.p.m.d.o.b
        public void b() {
            this.a.j();
        }
    }

    public c0(o oVar, e.b.a.p.k.x.b bVar) {
        this.a = oVar;
        this.b = bVar;
    }

    @Override // e.b.a.p.g
    /* renamed from: c */
    public e.b.a.p.k.s<Bitmap> b(@NonNull InputStream inputStream, int i2, int i3, @NonNull e.b.a.p.f fVar) throws IOException {
        RecyclableBufferedInputStream recyclableBufferedInputStream;
        boolean z;
        if (inputStream instanceof RecyclableBufferedInputStream) {
            recyclableBufferedInputStream = (RecyclableBufferedInputStream) inputStream;
            z = false;
        } else {
            recyclableBufferedInputStream = new RecyclableBufferedInputStream(inputStream, this.b);
            z = true;
        }
        e.b.a.v.e l2 = e.b.a.v.e.l(recyclableBufferedInputStream);
        try {
            return this.a.g(new e.b.a.v.j(l2), i2, i3, fVar, new a(recyclableBufferedInputStream, l2));
        } finally {
            l2.n();
            if (z) {
                recyclableBufferedInputStream.k();
            }
        }
    }

    @Override // e.b.a.p.g
    /* renamed from: d */
    public boolean a(@NonNull InputStream inputStream, @NonNull e.b.a.p.f fVar) {
        return this.a.p(inputStream);
    }
}
