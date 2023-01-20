package e.b.a.p.j;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class b<T> implements d<T> {

    /* renamed from: d  reason: collision with root package name */
    private static final String f9448d = "AssetPathFetcher";
    private final String a;
    private final AssetManager b;

    /* renamed from: c  reason: collision with root package name */
    private T f9449c;

    public b(AssetManager assetManager, String str) {
        this.b = assetManager;
        this.a = str;
    }

    @Override // e.b.a.p.j.d
    public void a() {
        T t = this.f9449c;
        if (t == null) {
            return;
        }
        try {
            b(t);
        } catch (IOException unused) {
        }
    }

    public abstract void b(T t) throws IOException;

    @Override // e.b.a.p.j.d
    public void c(@NonNull Priority priority, @NonNull d.a<? super T> aVar) {
        try {
            T d2 = d(this.b, this.a);
            this.f9449c = d2;
            aVar.d(d2);
        } catch (IOException e2) {
            if (Log.isLoggable(f9448d, 3)) {
                Log.d(f9448d, "Failed to load data from asset manager", e2);
            }
            aVar.b(e2);
        }
    }

    @Override // e.b.a.p.j.d
    public void cancel() {
    }

    public abstract T d(AssetManager assetManager, String str) throws IOException;

    @Override // e.b.a.p.j.d
    @NonNull
    public DataSource getDataSource() {
        return DataSource.LOCAL;
    }
}
