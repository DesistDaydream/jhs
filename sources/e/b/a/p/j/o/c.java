package e.b.a.p.j.o;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.j.g;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class c implements e.b.a.p.j.d<InputStream> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9473d = "MediaStoreThumbFetcher";
    private final Uri a;
    private final e b;

    /* renamed from: c  reason: collision with root package name */
    private InputStream f9474c;

    /* loaded from: classes.dex */
    public static class a implements d {
        private static final String[] b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f9475c = "kind = 1 AND image_id = ?";
        private final ContentResolver a;

        public a(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // e.b.a.p.j.o.d
        public Cursor query(Uri uri) {
            return this.a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, b, f9475c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* loaded from: classes.dex */
    public static class b implements d {
        private static final String[] b = {"_data"};

        /* renamed from: c  reason: collision with root package name */
        private static final String f9476c = "kind = 1 AND video_id = ?";
        private final ContentResolver a;

        public b(ContentResolver contentResolver) {
            this.a = contentResolver;
        }

        @Override // e.b.a.p.j.o.d
        public Cursor query(Uri uri) {
            return this.a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, b, f9476c, new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    public c(Uri uri, e eVar) {
        this.a = uri;
        this.b = eVar;
    }

    private static c b(Context context, Uri uri, d dVar) {
        return new c(uri, new e(e.b.a.c.e(context).m().g(), dVar, e.b.a.c.e(context).g(), context.getContentResolver()));
    }

    public static c d(Context context, Uri uri) {
        return b(context, uri, new a(context.getContentResolver()));
    }

    public static c e(Context context, Uri uri) {
        return b(context, uri, new b(context.getContentResolver()));
    }

    private InputStream f() throws FileNotFoundException {
        InputStream d2 = this.b.d(this.a);
        int a2 = d2 != null ? this.b.a(this.a) : -1;
        return a2 != -1 ? new g(d2, a2) : d2;
    }

    @Override // e.b.a.p.j.d
    public void a() {
        InputStream inputStream = this.f9474c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // e.b.a.p.j.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super InputStream> aVar) {
        try {
            InputStream f2 = f();
            this.f9474c = f2;
            aVar.d(f2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(f9473d, 3)) {
                Log.d(f9473d, "Failed to find thumbnail file", e2);
            }
            aVar.b(e2);
        }
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public Class<InputStream> getDataClass() {
        return InputStream.class;
    }

    @Override // e.b.a.p.j.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
