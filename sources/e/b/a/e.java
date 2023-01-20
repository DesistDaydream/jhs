package e.b.a;

import android.content.Context;
import android.content.ContextWrapper;
import android.widget.ImageView;
import androidx.annotation.GuardedBy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.Registry;
import e.b.a.c;
import e.b.a.t.k.r;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e extends ContextWrapper {
    @VisibleForTesting

    /* renamed from: k */
    public static final k<?, ?> f9335k = new b();
    private final e.b.a.p.k.x.b a;
    private final Registry b;

    /* renamed from: c */
    private final e.b.a.t.k.k f9336c;

    /* renamed from: d */
    private final c.a f9337d;

    /* renamed from: e */
    private final List<e.b.a.t.g<Object>> f9338e;

    /* renamed from: f */
    private final Map<Class<?>, k<?, ?>> f9339f;

    /* renamed from: g */
    private final e.b.a.p.k.i f9340g;

    /* renamed from: h */
    private final f f9341h;

    /* renamed from: i */
    private final int f9342i;
    @Nullable
    @GuardedBy("this")

    /* renamed from: j */
    private e.b.a.t.h f9343j;

    public e(@NonNull Context context, @NonNull e.b.a.p.k.x.b bVar, @NonNull Registry registry, @NonNull e.b.a.t.k.k kVar, @NonNull c.a aVar, @NonNull Map<Class<?>, k<?, ?>> map, @NonNull List<e.b.a.t.g<Object>> list, @NonNull e.b.a.p.k.i iVar, @NonNull f fVar, int i2) {
        super(context.getApplicationContext());
        this.a = bVar;
        this.b = registry;
        this.f9336c = kVar;
        this.f9337d = aVar;
        this.f9338e = list;
        this.f9339f = map;
        this.f9340g = iVar;
        this.f9341h = fVar;
        this.f9342i = i2;
    }

    @NonNull
    public <X> r<ImageView, X> a(@NonNull ImageView imageView, @NonNull Class<X> cls) {
        return this.f9336c.a(imageView, cls);
    }

    @NonNull
    public e.b.a.p.k.x.b b() {
        return this.a;
    }

    public List<e.b.a.t.g<Object>> c() {
        return this.f9338e;
    }

    public synchronized e.b.a.t.h d() {
        if (this.f9343j == null) {
            this.f9343j = this.f9337d.build().m0();
        }
        return this.f9343j;
    }

    @NonNull
    public <T> k<?, T> e(@NonNull Class<T> cls) {
        k<?, T> kVar = (k<?, T>) this.f9339f.get(cls);
        if (kVar == null) {
            for (Map.Entry<Class<?>, k<?, ?>> entry : this.f9339f.entrySet()) {
                if (entry.getKey().isAssignableFrom(cls)) {
                    kVar = (k<?, T>) entry.getValue();
                }
            }
        }
        return kVar == null ? (k<?, T>) f9335k : kVar;
    }

    @NonNull
    public e.b.a.p.k.i f() {
        return this.f9340g;
    }

    public f g() {
        return this.f9341h;
    }

    public int h() {
        return this.f9342i;
    }

    @NonNull
    public Registry i() {
        return this.b;
    }
}
