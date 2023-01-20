package e.b.a.p.l;

import android.util.Base64;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public final class e<Model, Data> implements n<Model, Data> {
    private static final String b = "data:image";

    /* renamed from: c  reason: collision with root package name */
    private static final String f9686c = ";base64";
    private final a<Data> a;

    /* loaded from: classes.dex */
    public interface a<Data> {
        Data e(String str) throws IllegalArgumentException;

        void f(Data data) throws IOException;

        Class<Data> getDataClass();
    }

    /* loaded from: classes.dex */
    public static final class b<Data> implements e.b.a.p.j.d<Data> {
        private final String a;
        private final a<Data> b;

        /* renamed from: c  reason: collision with root package name */
        private Data f9687c;

        public b(String str, a<Data> aVar) {
            this.a = str;
            this.b = aVar;
        }

        @Override // e.b.a.p.j.d
        public void a() {
            try {
                this.b.f(this.f9687c);
            } catch (IOException unused) {
            }
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, Data] */
        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            try {
                Data e2 = this.b.e(this.a);
                this.f9687c = e2;
                aVar.d(e2);
            } catch (IllegalArgumentException e3) {
                aVar.b(e3);
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
    public static final class c<Model> implements o<Model, InputStream> {
        private final a<InputStream> a = new a();

        /* loaded from: classes.dex */
        public class a implements a<InputStream> {
            public a() {
            }

            @Override // e.b.a.p.l.e.a
            /* renamed from: a */
            public void f(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // e.b.a.p.l.e.a
            /* renamed from: b */
            public InputStream e(String str) {
                if (str.startsWith(e.b)) {
                    int indexOf = str.indexOf(44);
                    if (indexOf != -1) {
                        if (str.substring(0, indexOf).endsWith(e.f9686c)) {
                            return new ByteArrayInputStream(Base64.decode(str.substring(indexOf + 1), 0));
                        }
                        throw new IllegalArgumentException("Not a base64 image data URL.");
                    }
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                throw new IllegalArgumentException("Not a valid image data URL.");
            }

            @Override // e.b.a.p.l.e.a
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Model, InputStream> c(@NonNull r rVar) {
            return new e(this.a);
        }
    }

    public e(a<Data> aVar) {
        this.a = aVar;
    }

    @Override // e.b.a.p.l.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith(b);
    }

    @Override // e.b.a.p.l.n
    public n.a<Data> b(@NonNull Model model, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(model), new b(model.toString(), this.a));
    }
}
