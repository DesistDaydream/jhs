package e.b.a.p.l;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class d implements n<File, ByteBuffer> {
    private static final String a = "ByteBufferFileLoader";

    /* loaded from: classes.dex */
    public static final class a implements e.b.a.p.j.d<ByteBuffer> {
        private final File a;

        public a(File file) {
            this.a = file;
        }

        @Override // e.b.a.p.j.d
        public void a() {
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.d(e.b.a.v.a.a(this.a));
            } catch (IOException e2) {
                if (Log.isLoggable(d.a, 3)) {
                    Log.d(d.a, "Failed to obtain ByteBuffer for file", e2);
                }
                aVar.b(e2);
            }
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<ByteBuffer> getDataClass() {
            return ByteBuffer.class;
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o<File, ByteBuffer> {
        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<File, ByteBuffer> c(@NonNull r rVar) {
            return new d();
        }
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<ByteBuffer> b(@NonNull File file, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(file), new a(file));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull File file) {
        return true;
    }
}
