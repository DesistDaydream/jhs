package e.b.a.p.m.d;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;
import e.b.a.t.l.c;

/* loaded from: classes.dex */
public final class i extends e.b.a.k<i, Bitmap> {
    @NonNull
    public static i o(@NonNull e.b.a.t.l.g<Bitmap> gVar) {
        return new i().g(gVar);
    }

    @NonNull
    public static i p() {
        return new i().j();
    }

    @NonNull
    public static i q(int i2) {
        return new i().k(i2);
    }

    @NonNull
    public static i r(@NonNull c.a aVar) {
        return new i().l(aVar);
    }

    @NonNull
    public static i s(@NonNull e.b.a.t.l.c cVar) {
        return new i().m(cVar);
    }

    @NonNull
    public static i t(@NonNull e.b.a.t.l.g<Drawable> gVar) {
        return new i().n(gVar);
    }

    @NonNull
    public i j() {
        return l(new c.a());
    }

    @NonNull
    public i k(int i2) {
        return l(new c.a(i2));
    }

    @NonNull
    public i l(@NonNull c.a aVar) {
        return n(aVar.a());
    }

    @NonNull
    public i m(@NonNull e.b.a.t.l.c cVar) {
        return n(cVar);
    }

    @NonNull
    public i n(@NonNull e.b.a.t.l.g<Drawable> gVar) {
        return g(new e.b.a.t.l.b(gVar));
    }
}
