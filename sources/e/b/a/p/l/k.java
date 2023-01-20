package e.b.a.p.l;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import java.io.File;
import java.io.FileNotFoundException;

/* loaded from: classes.dex */
public final class k implements n<Uri, File> {
    private final Context a;

    /* loaded from: classes.dex */
    public static final class a implements o<Uri, File> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, File> c(r rVar) {
            return new k(this.a);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements e.b.a.p.j.d<File> {

        /* renamed from: c  reason: collision with root package name */
        private static final String[] f9703c = {"_data"};
        private final Context a;
        private final Uri b;

        public b(Context context, Uri uri) {
            this.a = context;
            this.b = uri;
        }

        @Override // e.b.a.p.j.d
        public void a() {
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super File> aVar) {
            Cursor query = this.a.getContentResolver().query(this.b, f9703c, null, null, null);
            if (query != null) {
                try {
                    r0 = query.moveToFirst() ? query.getString(query.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    query.close();
                }
            }
            if (TextUtils.isEmpty(r0)) {
                aVar.b(new FileNotFoundException("Failed to find file path for: " + this.b));
                return;
            }
            aVar.d(new File(r0));
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<File> getDataClass() {
            return File.class;
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public k(Context context) {
        this.a = context;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<File> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(uri), new b(this.a, uri));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return e.b.a.p.j.o.b.b(uri);
    }
}
