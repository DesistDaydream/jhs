package e.b.a.t.l;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;
import e.b.a.t.l.f;

/* loaded from: classes.dex */
public abstract class a<R> implements g<R> {
    private final g<Drawable> a;

    /* renamed from: e.b.a.t.l.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public final class C0324a implements f<R> {
        private final f<Drawable> a;

        public C0324a(f<Drawable> fVar) {
            this.a = fVar;
        }

        @Override // e.b.a.t.l.f
        public boolean a(R r, f.a aVar) {
            return this.a.a(new BitmapDrawable(aVar.b().getResources(), a.this.b(r)), aVar);
        }
    }

    public a(g<Drawable> gVar) {
        this.a = gVar;
    }

    @Override // e.b.a.t.l.g
    public f<R> a(DataSource dataSource, boolean z) {
        return new C0324a(this.a.a(dataSource, z));
    }

    public abstract Bitmap b(R r);
}
