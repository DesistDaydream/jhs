package e.b.a.p.l.y;

import android.content.Context;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.load.resource.bitmap.VideoDecoder;
import e.b.a.p.l.n;
import e.b.a.p.l.o;
import e.b.a.p.l.r;
import java.io.InputStream;

/* loaded from: classes.dex */
public class e implements n<Uri, InputStream> {
    private final Context a;

    /* loaded from: classes.dex */
    public static class a implements o<Uri, InputStream> {
        private final Context a;

        public a(Context context) {
            this.a = context;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Uri, InputStream> c(r rVar) {
            return new e(this.a);
        }
    }

    public e(Context context) {
        this.a = context.getApplicationContext();
    }

    private boolean e(e.b.a.p.f fVar) {
        Long l2 = (Long) fVar.a(VideoDecoder.f1727g);
        return l2 != null && l2.longValue() == -1;
    }

    @Override // e.b.a.p.l.n
    @Nullable
    /* renamed from: c */
    public n.a<InputStream> b(@NonNull Uri uri, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        if (e.b.a.p.j.o.b.d(i2, i3) && e(fVar)) {
            return new n.a<>(new e.b.a.u.e(uri), e.b.a.p.j.o.c.e(this.a, uri));
        }
        return null;
    }

    @Override // e.b.a.p.l.n
    /* renamed from: d */
    public boolean a(@NonNull Uri uri) {
        return e.b.a.p.j.o.b.c(uri);
    }
}
