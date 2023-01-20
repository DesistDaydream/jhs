package e.b.a.p.k.y;

import android.content.Context;
import e.b.a.p.k.y.a;
import e.b.a.p.k.y.d;
import java.io.File;

@Deprecated
/* loaded from: classes.dex */
public final class f extends d {

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
            File externalCacheDir = this.a.getExternalCacheDir();
            if (externalCacheDir == null) {
                return null;
            }
            return this.b != null ? new File(externalCacheDir, this.b) : externalCacheDir;
        }
    }

    public f(Context context) {
        this(context, a.InterfaceC0310a.b, a.InterfaceC0310a.a);
    }

    public f(Context context, int i2) {
        this(context, a.InterfaceC0310a.b, i2);
    }

    public f(Context context, String str, int i2) {
        super(new a(context, str), i2);
    }
}
