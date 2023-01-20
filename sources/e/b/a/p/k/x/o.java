package e.b.a.p.k.x;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.engine.bitmap_recycle.PrettyPrintTreeMap;
import java.util.NavigableMap;

@RequiresApi(19)
/* loaded from: classes.dex */
public final class o implements l {

    /* renamed from: d  reason: collision with root package name */
    private static final int f9636d = 8;
    private final b a = new b();
    private final h<a, Bitmap> b = new h<>();

    /* renamed from: c  reason: collision with root package name */
    private final NavigableMap<Integer, Integer> f9637c = new PrettyPrintTreeMap();

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static final class a implements m {
        private final b a;
        public int b;

        public a(b bVar) {
            this.a = bVar;
        }

        @Override // e.b.a.p.k.x.m
        public void a() {
            this.a.c(this);
        }

        public void b(int i2) {
            this.b = i2;
        }

        public boolean equals(Object obj) {
            return (obj instanceof a) && this.b == ((a) obj).b;
        }

        public int hashCode() {
            return this.b;
        }

        public String toString() {
            return o.h(this.b);
        }
    }

    @VisibleForTesting
    /* loaded from: classes.dex */
    public static class b extends d<a> {
        @Override // e.b.a.p.k.x.d
        /* renamed from: d */
        public a a() {
            return new a(this);
        }

        public a e(int i2) {
            a aVar = (a) super.b();
            aVar.b(i2);
            return aVar;
        }
    }

    private void g(Integer num) {
        Integer num2 = (Integer) this.f9637c.get(num);
        if (num2.intValue() == 1) {
            this.f9637c.remove(num);
        } else {
            this.f9637c.put(num, Integer.valueOf(num2.intValue() - 1));
        }
    }

    public static String h(int i2) {
        return "[" + i2 + "]";
    }

    private static String i(Bitmap bitmap) {
        return h(e.b.a.v.n.h(bitmap));
    }

    @Override // e.b.a.p.k.x.l
    public String a(Bitmap bitmap) {
        return i(bitmap);
    }

    @Override // e.b.a.p.k.x.l
    @Nullable
    public Bitmap b() {
        Bitmap f2 = this.b.f();
        if (f2 != null) {
            g(Integer.valueOf(e.b.a.v.n.h(f2)));
        }
        return f2;
    }

    @Override // e.b.a.p.k.x.l
    public String c(int i2, int i3, Bitmap.Config config) {
        return h(e.b.a.v.n.g(i2, i3, config));
    }

    @Override // e.b.a.p.k.x.l
    public void d(Bitmap bitmap) {
        a e2 = this.a.e(e.b.a.v.n.h(bitmap));
        this.b.d(e2, bitmap);
        Integer num = (Integer) this.f9637c.get(Integer.valueOf(e2.b));
        this.f9637c.put(Integer.valueOf(e2.b), Integer.valueOf(num != null ? 1 + num.intValue() : 1));
    }

    @Override // e.b.a.p.k.x.l
    public int e(Bitmap bitmap) {
        return e.b.a.v.n.h(bitmap);
    }

    @Override // e.b.a.p.k.x.l
    @Nullable
    public Bitmap f(int i2, int i3, Bitmap.Config config) {
        int g2 = e.b.a.v.n.g(i2, i3, config);
        a e2 = this.a.e(g2);
        Integer ceilingKey = this.f9637c.ceilingKey(Integer.valueOf(g2));
        if (ceilingKey != null && ceilingKey.intValue() != g2 && ceilingKey.intValue() <= g2 * 8) {
            this.a.c(e2);
            e2 = this.a.e(ceilingKey.intValue());
        }
        Bitmap a2 = this.b.a(e2);
        if (a2 != null) {
            a2.reconfigure(i2, i3, config);
            g(ceilingKey);
        }
        return a2;
    }

    public String toString() {
        return "SizeStrategy:\n  " + this.b + "\n  SortedSizes" + this.f9637c;
    }
}
