package e.b.a.p.l.y;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e.b.a.p.l.h;
import e.b.a.p.l.m;
import e.b.a.p.l.n;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public abstract class a<Model> implements n<Model, InputStream> {
    private final n<e.b.a.p.l.g, InputStream> a;
    @Nullable
    private final m<Model, e.b.a.p.l.g> b;

    public a(n<e.b.a.p.l.g, InputStream> nVar) {
        this(nVar, null);
    }

    private static List<e.b.a.p.c> c(Collection<String> collection) {
        ArrayList arrayList = new ArrayList(collection.size());
        for (String str : collection) {
            arrayList.add(new e.b.a.p.l.g(str));
        }
        return arrayList;
    }

    @Override // e.b.a.p.l.n
    @Nullable
    public n.a<InputStream> b(@NonNull Model model, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        m<Model, e.b.a.p.l.g> mVar = this.b;
        e.b.a.p.l.g b = mVar != null ? mVar.b(model, i2, i3) : null;
        if (b == null) {
            String f2 = f(model, i2, i3, fVar);
            if (TextUtils.isEmpty(f2)) {
                return null;
            }
            e.b.a.p.l.g gVar = new e.b.a.p.l.g(f2, e(model, i2, i3, fVar));
            m<Model, e.b.a.p.l.g> mVar2 = this.b;
            if (mVar2 != null) {
                mVar2.c(model, i2, i3, gVar);
            }
            b = gVar;
        }
        List<String> d2 = d(model, i2, i3, fVar);
        n.a<InputStream> b2 = this.a.b(b, i2, i3, fVar);
        return (b2 == null || d2.isEmpty()) ? b2 : new n.a<>(b2.a, c(d2), b2.f9707c);
    }

    public List<String> d(Model model, int i2, int i3, e.b.a.p.f fVar) {
        return Collections.emptyList();
    }

    @Nullable
    public h e(Model model, int i2, int i3, e.b.a.p.f fVar) {
        return h.b;
    }

    public abstract String f(Model model, int i2, int i3, e.b.a.p.f fVar);

    public a(n<e.b.a.p.l.g, InputStream> nVar, @Nullable m<Model, e.b.a.p.l.g> mVar) {
        this.a = nVar;
        this.b = mVar;
    }
}
