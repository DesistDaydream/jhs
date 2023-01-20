package e.b.a.p.l.y;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

@RequiresApi(29)
/* loaded from: classes.dex */
public final class f<DataT> implements n<Uri, DataT> {
    private final Context a;
    private final n<File, DataT> b;

    /* renamed from: c  reason: collision with root package name */
    private final n<Uri, DataT> f9719c;

    /* renamed from: d  reason: collision with root package name */
    private final Class<DataT> f9720d;

    /* loaded from: classes.dex */
    public static abstract class a<DataT> implements o<Uri, DataT> {
        private final Context a;
        private final Class<DataT> b;

        public a(Context context, Class<DataT> cls) {
            this.a = context;
            this.b = cls;
        }

        @Override // e.b.a.p.l.o
        public final void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public final n<Uri, DataT> c(@NonNull r rVar) {
            return new f(this.a, rVar.d(File.class, this.b), rVar.d(Uri.class, this.b), this.b);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class b extends a<ParcelFileDescriptor> {
        public b(Context context) {
            super(context, ParcelFileDescriptor.class);
        }
    }

    @RequiresApi(29)
    /* loaded from: classes.dex */
    public static final class c extends a<InputStream> {
        public c(Context context) {
            super(context, InputStream.class);
        }
    }

    /* loaded from: classes.dex */
    public static final class d<DataT> implements e.b.a.p.j.d<DataT> {

        /* renamed from: k  reason: collision with root package name */
        private static final String[] f9721k = {"_data"};
        private final Context a;
        private final n<File, DataT> b;

        /* renamed from: c  reason: collision with root package name */
        private final n<Uri, DataT> f9722c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f9723d;

        /* renamed from: e  reason: collision with root package name */
        private final int f9724e;

        /* renamed from: f  reason: collision with root package name */
        private final int f9725f;

        /* renamed from: g  reason: collision with root package name */
        private final e.b.a.p.f f9726g;

        /* renamed from: h  reason: collision with root package name */
        private final Class<DataT> f9727h;

        /* renamed from: i  reason: collision with root package name */
        private volatile boolean f9728i;
        @Nullable

        /* renamed from: j  reason: collision with root package name */
        private volatile e.b.a.p.j.d<DataT> f9729j;

        public d(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Uri uri, int i2, int i3, e.b.a.p.f fVar, Class<DataT> cls) {
            this.a = context.getApplicationContext();
            this.b = nVar;
            this.f9722c = nVar2;
            this.f9723d = uri;
            this.f9724e = i2;
            this.f9725f = i3;
            this.f9726g = fVar;
            this.f9727h = cls;
        }

        @Nullable
        private n.a<DataT> b() throws FileNotFoundException {
            if (Environment.isExternalStorageLegacy()) {
                return this.b.b(f(this.f9723d), this.f9724e, this.f9725f, this.f9726g);
            }
            return this.f9722c.b(e() ? MediaStore.setRequireOriginal(this.f9723d) : this.f9723d, this.f9724e, this.f9725f, this.f9726g);
        }

        @Nullable
        private e.b.a.p.j.d<DataT> d() throws FileNotFoundException {
            n.a<DataT> b = b();
            if (b != null) {
                return b.f9707c;
            }
            return null;
        }

        private boolean e() {
            return this.a.checkSelfPermission("android.permission.ACCESS_MEDIA_LOCATION") == 0;
        }

        @NonNull
        private File f(Uri uri) throws FileNotFoundException {
            Cursor cursor = null;
            try {
                Cursor query = this.a.getContentResolver().query(uri, f9721k, null, null, null);
                if (query != null && query.moveToFirst()) {
                    String string = query.getString(query.getColumnIndexOrThrow("_data"));
                    if (!TextUtils.isEmpty(string)) {
                        File file = new File(string);
                        if (query != null) {
                            query.close();
                        }
                        return file;
                    }
                    throw new FileNotFoundException("File path was empty in media store for: " + uri);
                }
                throw new FileNotFoundException("Failed to media store entry for: " + uri);
            } catch (Throwable th) {
                if (0 != 0) {
                    cursor.close();
                }
                throw th;
            }
        }

        @Override // e.b.a.p.j.d
        public void a() {
            e.b.a.p.j.d<DataT> dVar = this.f9729j;
            if (dVar != null) {
                dVar.a();
            }
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super DataT> aVar) {
            try {
                e.b.a.p.j.d<DataT> d2 = d();
                if (d2 == null) {
                    aVar.b(new IllegalArgumentException("Failed to build fetcher for: " + this.f9723d));
                    return;
                }
                this.f9729j = d2;
                if (this.f9728i) {
                    cancel();
                } else {
                    d2.c(priority, aVar);
                }
            } catch (FileNotFoundException e2) {
                aVar.b(e2);
            }
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
            this.f9728i = true;
            e.b.a.p.j.d<DataT> dVar = this.f9729j;
            if (dVar != null) {
                dVar.cancel();
            }
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<DataT> getDataClass() {
            return this.f9727h;
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public f(Context context, n<File, DataT> nVar, n<Uri, DataT> nVar2, Class<DataT> cls) {
        this.a = context.getApplicationContext();
        this.b = nVar;
        this.f9719c = nVar2;
        this.f9720d = cls;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: c */
    public n.a<DataT> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(uri), new d(this.a, this.b, this.f9719c, uri, i2, i3, fVar, this.f9720d));
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return Build.VERSION.SDK_INT >= 29 && e.b.a.p.j.o.b.b(uri);
    }
}
