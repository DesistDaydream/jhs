package e.b.a.p.j;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import java.io.FileNotFoundException;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class l<T> implements d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9465d = "LocalUriFetcher";
    private final Uri a;
    private final ContentResolver b;

    /* renamed from: c  reason: collision with root package name */
    private T f9466c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.b = contentResolver;
        this.a = uri;
    }

    @Override // e.b.a.p.j.d
    public void a() {
        T t = this.f9466c;
        if (t != null) {
            try {
                b(t);
            } catch (IOException unused) {
            }
        }
    }

    public abstract void b(T t) throws IOException;

    @Override // e.b.a.p.j.d
    public final void c(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T d2 = d(this.a, this.b);
            this.f9466c = d2;
            aVar.d(d2);
        } catch (FileNotFoundException e2) {
            if (Log.isLoggable(f9465d, 3)) {
                Log.d(f9465d, "Failed to open Uri", e2);
            }
            aVar.b(e2);
        }
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
    }

    public abstract T d(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // e.b.a.p.j.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
