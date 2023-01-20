package e.b.a.p.l;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class b<Data> implements n<byte[], Data> {
    private final InterfaceC0317b<Data> a;

    /* loaded from: classes.dex */
    public static class a implements o<byte[], ByteBuffer> {

        /* renamed from: e.b.a.p.l.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes.dex */
        public class C0316a implements InterfaceC0317b<ByteBuffer> {
            public C0316a() {
            }

            @Override // e.b.a.p.l.b.InterfaceC0317b
            /* renamed from: b */
            public ByteBuffer a(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }

            @Override // e.b.a.p.l.b.InterfaceC0317b
            public Class<ByteBuffer> getDataClass() {
                return ByteBuffer.class;
            }
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<byte[], ByteBuffer> c(@NonNull r rVar) {
            return new b(new C0316a());
        }
    }

    /* renamed from: e.b.a.p.l.b$b  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0317b<Data> {
        Data a(byte[] bArr);

        Class<Data> getDataClass();
    }

    /* loaded from: classes.dex */
    public static class c<Data> implements e.b.a.p.j.d<Data> {
        private final byte[] a;
        private final InterfaceC0317b<Data> b;

        public c(byte[] bArr, InterfaceC0317b<Data> interfaceC0317b) {
            this.a = bArr;
            this.b = interfaceC0317b;
        }

        @Override // e.b.a.p.j.d
        public void a() {
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Data> aVar) {
            aVar.d((Data) this.b.a(this.a));
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
    public static class d implements o<byte[], InputStream> {

        /* loaded from: classes.dex */
        public class a implements InterfaceC0317b<InputStream> {
            public a() {
            }

            @Override // e.b.a.p.l.b.InterfaceC0317b
            /* renamed from: b */
            public InputStream a(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }

            @Override // e.b.a.p.l.b.InterfaceC0317b
            public Class<InputStream> getDataClass() {
                return InputStream.class;
            }
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<byte[], InputStream> c(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0317b<Data> interfaceC0317b) {
        this.a = interfaceC0317b;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull byte[] bArr, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(bArr), new c(bArr, this.a));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }
}
