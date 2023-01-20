package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.ParcelFileDescriptor;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* loaded from: classes.dex */
public interface v {

    /* loaded from: classes.dex */
    public static final class a implements v {
        private final e.b.a.p.j.k a;
        private final e.b.a.p.k.x.b b;

        /* renamed from: c  reason: collision with root package name */
        private final List<ImageHeaderParser> f9794c;

        public a(InputStream inputStream, List<ImageHeaderParser> list, e.b.a.p.k.x.b bVar) {
            this.b = (e.b.a.p.k.x.b) e.b.a.v.l.d(bVar);
            this.f9794c = (List) e.b.a.v.l.d(list);
            this.a = new e.b.a.p.j.k(inputStream, bVar);
        }

        @Override // e.b.a.p.m.d.v
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeStream(this.a.b(), null, options);
        }

        @Override // e.b.a.p.m.d.v
        public void b() {
            this.a.c();
        }

        @Override // e.b.a.p.m.d.v
        public int c() throws IOException {
            return e.b.a.p.b.b(this.f9794c, this.a.b(), this.b);
        }

        @Override // e.b.a.p.m.d.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return e.b.a.p.b.getType(this.f9794c, this.a.b(), this.b);
        }
    }

    @RequiresApi(21)
    /* loaded from: classes.dex */
    public static final class b implements v {
        private final e.b.a.p.k.x.b a;
        private final List<ImageHeaderParser> b;

        /* renamed from: c  reason: collision with root package name */
        private final ParcelFileDescriptorRewinder f9795c;

        public b(ParcelFileDescriptor parcelFileDescriptor, List<ImageHeaderParser> list, e.b.a.p.k.x.b bVar) {
            this.a = (e.b.a.p.k.x.b) e.b.a.v.l.d(bVar);
            this.b = (List) e.b.a.v.l.d(list);
            this.f9795c = new ParcelFileDescriptorRewinder(parcelFileDescriptor);
        }

        @Override // e.b.a.p.m.d.v
        @Nullable
        public Bitmap a(BitmapFactory.Options options) throws IOException {
            return BitmapFactory.decodeFileDescriptor(this.f9795c.b().getFileDescriptor(), null, options);
        }

        @Override // e.b.a.p.m.d.v
        public void b() {
        }

        @Override // e.b.a.p.m.d.v
        public int c() throws IOException {
            return e.b.a.p.b.a(this.b, this.f9795c, this.a);
        }

        @Override // e.b.a.p.m.d.v
        public ImageHeaderParser.ImageType d() throws IOException {
            return e.b.a.p.b.getType(this.b, this.f9795c, this.a);
        }
    }

    @Nullable
    Bitmap a(BitmapFactory.Options options) throws IOException;

    void b();

    int c() throws IOException;

    ImageHeaderParser.ImageType d() throws IOException;
}
