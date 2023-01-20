package e.b.a.t.l;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.bumptech.glide.load.DataSource;
import e.b.a.t.l.k;

/* loaded from: classes.dex */
public class h<R> implements g<R> {
    private final k.a a;
    private f<R> b;

    /* loaded from: classes.dex */
    public static class a implements k.a {
        private final Animation a;

        public a(Animation animation) {
            this.a = animation;
        }

        @Override // e.b.a.t.l.k.a
        public Animation a(Context context) {
            return this.a;
        }
    }

    /* loaded from: classes.dex */
    public static class b implements k.a {
        private final int a;

        public b(int i2) {
            this.a = i2;
        }

        @Override // e.b.a.t.l.k.a
        public Animation a(Context context) {
            return AnimationUtils.loadAnimation(context, this.a);
        }
    }

    public h(Animation animation) {
        this(new a(animation));
    }

    @Override // e.b.a.t.l.g
    public f<R> a(DataSource dataSource, boolean z) {
        if (dataSource != DataSource.MEMORY_CACHE && z) {
            if (this.b == null) {
                this.b = new k(this.a);
            }
            return this.b;
        }
        return e.b();
    }

    public h(int i2) {
        this(new b(i2));
    }

    public h(k.a aVar) {
        this.a = aVar;
    }
}
