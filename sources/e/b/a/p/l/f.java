package e.b.a.p.l;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class f<Data> implements n<File, Data> {
    private static final String b = "FileLoader";
    private final d<Data> a;

    /* loaded from: classes.dex */
    public static class a<Data> implements o<File, Data> {
        private final d<Data> a;

        public a(d<Data> dVar) {
            this.a = dVar;
        }

        @Override // e.b.a.p.l.o
        public final void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public final n<File, Data> c(@NonNull r rVar) {
            return new f(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class b extends a<ParcelFileDescriptor> {

        /* loaded from: classes.dex */
        public class a implements d<ParcelFileDescriptor> {
            @Override // e.b.a.p.l.f.d
            /* renamed from: b */
            public void f(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // e.b.a.p.l.f.d
            /* renamed from: c */
            public ParcelFileDescriptor a(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }

            @Override // e.b.a.p.l.f.d
            public Class<ParcelFileDescriptor> getDataClass() {
                return ParcelFileDescriptor.class;
            }
        }

        public b() {
            super(new a());
        }
    }

    /* loaded from: classes.dex */
    public static final class c<Data> implements e.b.a.p.j.d<Data> {
        private final File a;
        private final d<Data> b;

        /* renamed from: c  reason: collision with root package name */
        private Data f9688c;

        public c(File file, d<Data> dVar) {
            this.a = file;
            this.b = dVar;
        }

        @Override // e.b.a.p.j.d
        public void a() {
            Data data = this.f9688c;
            if (data != null) {
                try {
                    this.b.f(data);
                } catch (IOException unused) {
                }
            }
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [java.lang.Object, Data] */
        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data a = this.b.a(this.a);
                this.f9688c = a;
                aVar.d(a);
            } catch (FileNotFoundException e2) {
                if (Log.isLoggable(f.b, 3)) {
                    Log.d(f.b, "Failed to open file", e2);
                }
                aVar.b(e2);
            }
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<Data> getDataClass() {
            return this.b.getDataClass();
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes.dex */
    public interface d<Data> {
        Data a(File file) throws FileNotFoundException;

        void f(Data data) throws IOException;

        Class<Data> getDataClass();
    }

    /* loaded from: classes.dex */
    public static class e extends a<InputStream> {

        /* loaded from: classes.dex */
        public class a implements d<InputStream> {
            @Override // e.b.a.p.l.f.d
            /* renamed from: b */
            public void f(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // e.b.a.p.l.f.d
            /* renamed from: c */
            public InputStream a(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }

            @Override // e.b.a.p.l.f.d
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.a = dVar;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull File file, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(file), new c(file, this.a));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
