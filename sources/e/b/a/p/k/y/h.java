package e.b.a.p.k.y;

import android.content.Context;
import e.b.a.p.k.y.a;
import e.b.a.p.k.y.d;
import java.io.File;

/* loaded from: classes.dex */
public final class h extends d {

    /* loaded from: classes.dex */
    public class a implements d.c {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;

        public a(Context context, String str) {
            this.a = context;
            this.b = str;
        }

        @Override // e.b.a.p.k.y.d.c
        public File a() {
            File cacheDir = this.a.getCacheDir();
            if (cacheDir == null) {
                return null;
            }
            return this.b != null ? new File(cacheDir, this.b) : cacheDir;
        }
    }

    public h(Context context) {
        this(context, a.InterfaceC0310a.b, 262144000L);
    }

    public h(Context context, long j2) {
        this(context, a.InterfaceC0310a.b, j2);
    }

    public h(Context context, String str, long j2) {
        super(new a(context, str), j2);
    }
}
