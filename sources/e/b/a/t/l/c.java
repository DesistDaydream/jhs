package e.b.a.t.l;

import android.graphics.drawable.Drawable;
import com.bumptech.glide.load.DataSource;

/* loaded from: classes.dex */
public class c implements g<Drawable> {
    private final int a;
    private final boolean b;

    /* renamed from: c  reason: collision with root package name */
    private d f9933c;

    /* loaded from: classes.dex */
    public static class a {

        /* renamed from: c  reason: collision with root package name */
        private static final int f9934c = 300;
        private final int a;
        private boolean b;

        public a() {
            this(300);
        }

        public c a() {
            return new c(this.a, this.b);
        }

        public a b(boolean z) {
            this.b = z;
            return this;
        }

        public a(int i2) {
            this.a = i2;
        }
    }

    public c(int i2, boolean z) {
        this.a = i2;
        this.b = z;
    }

    private f<Drawable> b() {
        if (this.f9933c == null) {
            this.f9933c = new d(this.a, this.b);
        }
        return this.f9933c;
    }

    @Override // e.b.a.t.l.g
    public f<Drawable> a(DataSource dataSource, boolean z) {
        if (dataSource == DataSource.MEMORY_CACHE) {
            return e.b();
        }
        return b();
    }
}
