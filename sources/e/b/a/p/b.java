package e.b.a.p;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.load.ImageHeaderParser;
import com.bumptech.glide.load.data.ParcelFileDescriptorRewinder;
import com.bumptech.glide.load.resource.bitmap.RecyclableBufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

/* loaded from: classes.dex */
public final class b {
    private static final int a = 5242880;

    /* loaded from: classes.dex */
    public class a implements g {
        public final /* synthetic */ InputStream a;

        public a(InputStream inputStream) {
            this.a = inputStream;
        }

        @Override // e.b.a.p.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.getType(this.a);
            } finally {
                this.a.reset();
            }
        }
    }

    /* renamed from: e.b.a.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0305b implements g {
        public final /* synthetic */ ByteBuffer a;

        public C0305b(ByteBuffer byteBuffer) {
            this.a = byteBuffer;
        }

        @Override // e.b.a.p.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            return imageHeaderParser.getType(this.a);
        }
    }

    /* loaded from: classes.dex */
    public class c implements g {
        public final /* synthetic */ ParcelFileDescriptorRewinder a;
        public final /* synthetic */ e.b.a.p.k.x.b b;

        public c(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, e.b.a.p.k.x.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // e.b.a.p.b.g
        public ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.a.b().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                ImageHeaderParser.ImageType type = imageHeaderParser.getType(recyclableBufferedInputStream);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.a.b();
                return type;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.b();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public class d implements f {
        public final /* synthetic */ InputStream a;
        public final /* synthetic */ e.b.a.p.k.x.b b;

        public d(InputStream inputStream, e.b.a.p.k.x.b bVar) {
            this.a = inputStream;
            this.b = bVar;
        }

        @Override // e.b.a.p.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            try {
                return imageHeaderParser.b(this.a, this.b);
            } finally {
                this.a.reset();
            }
        }
    }

    /* loaded from: classes.dex */
    public class e implements f {
        public final /* synthetic */ ParcelFileDescriptorRewinder a;
        public final /* synthetic */ e.b.a.p.k.x.b b;

        public e(ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, e.b.a.p.k.x.b bVar) {
            this.a = parcelFileDescriptorRewinder;
            this.b = bVar;
        }

        @Override // e.b.a.p.b.f
        public int a(ImageHeaderParser imageHeaderParser) throws IOException {
            RecyclableBufferedInputStream recyclableBufferedInputStream;
            RecyclableBufferedInputStream recyclableBufferedInputStream2 = null;
            try {
                recyclableBufferedInputStream = new RecyclableBufferedInputStream(new FileInputStream(this.a.b().getFileDescriptor()), this.b);
            } catch (Throwable th) {
                th = th;
            }
            try {
                int b = imageHeaderParser.b(recyclableBufferedInputStream, this.b);
                try {
                    recyclableBufferedInputStream.close();
                } catch (IOException unused) {
                }
                this.a.b();
                return b;
            } catch (Throwable th2) {
                th = th2;
                recyclableBufferedInputStream2 = recyclableBufferedInputStream;
                if (recyclableBufferedInputStream2 != null) {
                    try {
                        recyclableBufferedInputStream2.close();
                    } catch (IOException unused2) {
                    }
                }
                this.a.b();
                throw th;
            }
        }
    }

    /* loaded from: classes.dex */
    public interface f {
        int a(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    /* loaded from: classes.dex */
    public interface g {
        ImageHeaderParser.ImageType getType(ImageHeaderParser imageHeaderParser) throws IOException;
    }

    private b() {
    }

    @RequiresApi(21)
    public static int a(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        return c(list, new e(parcelFileDescriptorRewinder, bVar));
    }

    public static int b(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        if (inputStream == null) {
            return -1;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(a);
        return c(list, new d(inputStream, bVar));
    }

    private static int c(@NonNull List<ImageHeaderParser> list, f fVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            int a2 = fVar.a(list.get(i2));
            if (a2 != -1) {
                return a2;
            }
        }
        return -1;
    }

    @NonNull
    private static ImageHeaderParser.ImageType d(@NonNull List<ImageHeaderParser> list, g gVar) throws IOException {
        int size = list.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageHeaderParser.ImageType type = gVar.getType(list.get(i2));
            if (type != ImageHeaderParser.ImageType.UNKNOWN) {
                return type;
            }
        }
        return ImageHeaderParser.ImageType.UNKNOWN;
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable InputStream inputStream, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        if (inputStream == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        if (!inputStream.markSupported()) {
            inputStream = new RecyclableBufferedInputStream(inputStream, bVar);
        }
        inputStream.mark(a);
        return d(list, new a(inputStream));
    }

    @NonNull
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @Nullable ByteBuffer byteBuffer) throws IOException {
        if (byteBuffer == null) {
            return ImageHeaderParser.ImageType.UNKNOWN;
        }
        return d(list, new C0305b(byteBuffer));
    }

    @NonNull
    @RequiresApi(21)
    public static ImageHeaderParser.ImageType getType(@NonNull List<ImageHeaderParser> list, @NonNull ParcelFileDescriptorRewinder parcelFileDescriptorRewinder, @NonNull e.b.a.p.k.x.b bVar) throws IOException {
        return d(list, new c(parcelFileDescriptorRewinder, bVar));
    }
}
