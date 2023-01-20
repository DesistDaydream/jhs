package e.l.q.c.t0;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.jihuanshe.R;
import e.b.a.t.g;
import e.b.a.t.k.p;

/* loaded from: classes2.dex */
public class a implements e.l.q.c.t0.c.b {
    public static final /* synthetic */ boolean a = false;

    /* renamed from: e.l.q.c.t0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0396a implements g<Bitmap> {
        public final /* synthetic */ e.l.q.c.t0.c.a a;

        public C0396a(e.l.q.c.t0.c.a aVar) {
            this.a = aVar;
        }

        @Override // e.b.a.t.g
        /* renamed from: a */
        public boolean onResourceReady(Bitmap bitmap, Object obj, p<Bitmap> pVar, DataSource dataSource, boolean z) {
            this.a.a();
            return false;
        }

        @Override // e.b.a.t.g
        public boolean onLoadFailed(@Nullable GlideException glideException, Object obj, p<Bitmap> pVar, boolean z) {
            this.a.onLoadFailed(null);
            return false;
        }
    }

    @Override // e.l.q.c.t0.c.b
    public void a(@NonNull Context context) {
        e.t.r.a.l.a.b(context).c();
    }

    @Override // e.l.q.c.t0.c.b
    public void b(@NonNull Fragment fragment) {
        e.t.r.a.l.a.l(fragment).onStop();
    }

    @Override // e.l.q.c.t0.c.b
    public void c(@NonNull Fragment fragment, @NonNull String str, @Nullable ImageView imageView, @NonNull e.l.q.c.t0.c.a aVar) {
        e.t.r.a.l.a.l(fragment).m().v1(str).z(R.drawable.bg_err_image).D().U0(new C0396a(aVar)).m1(imageView);
    }

    @Override // e.l.q.c.t0.c.b
    public void d(@NonNull Fragment fragment, @NonNull String str, @Nullable ImageView imageView, @NonNull e.l.q.c.t0.c.a aVar) {
    }
}
