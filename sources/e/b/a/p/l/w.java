package e.b.a.p.l;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import e.b.a.p.l.n;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class w<Data> implements n<Uri, Data> {
    private static final Set<String> b = Collections.unmodifiableSet(new HashSet(Arrays.asList("file", "android.resource", "content")));
    private final c<Data> a;

    /* loaded from: classes.dex */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.w.c
        public e.b.a.p.j.d<AssetFileDescriptor> b(Uri uri) {
            return new e.b.a.p.j.a(this.a, uri);
        }

        @Override // e.b.a.p.l.o
        public n<Uri, AssetFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.w.c
        public e.b.a.p.j.d<ParcelFileDescriptor> b(Uri uri) {
            return new e.b.a.p.j.i(this.a, uri);
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> c(r rVar) {
            return new w(this);
        }
    }

    /* loaded from: classes.dex */
    public interface c<Data> {
        e.b.a.p.j.d<Data> b(Uri uri);
    }

    /* loaded from: classes.dex */
    public static class d implements o<Uri, InputStream>, c<InputStream> {
        private final ContentResolver a;

        public d(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.w.c
        public e.b.a.p.j.d<InputStream> b(Uri uri) {
            return new e.b.a.p.j.n(this.a, uri);
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.a = cVar;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<Data> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(uri), this.a.b(uri));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return b.contains(uri.getScheme());
    }
}
