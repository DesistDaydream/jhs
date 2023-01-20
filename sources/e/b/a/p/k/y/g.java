package e.b.a.p.k.y;

import android.content.Context;
import androidx.annotation.Nullable;
import e.b.a.p.k.y.a;
import e.b.a.p.k.y.d;
import java.io.File;

/* loaded from: classes.dex */
public final class g extends d {

    /* loaded from: classes.dex */
    public class a implements d.c {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Nullable
        private File b() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }

        @Override // e.b.a.p.k.y.d.c
        public File a() {
            File externalCacheDir;
            File b = b();
            return ((b == null || !b.exists()) && (externalCacheDir = this.a.getExternalCacheDir()) != null && externalCacheDir.canWrite()) ? this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir : b;
        }
    }

    public g(Context context) {
        this(context, a.InterfaceC0310a.b, 262144000L);
    }

    public g(Context context, long j2) {
        this(context, a.InterfaceC0310a.b, j2);
    }

    public g(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
