package e.b.a.p.l;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public interface n<Model, Data> {

    /* loaded from: classes.dex */
    public static class a<Data> {
        public final e.b.a.p.c a;
        public final List<e.b.a.p.c> b;

        /* renamed from: c  reason: collision with root package name */
        public final e.b.a.p.j.d<Data> f9707c;

        public a(@NonNull e.b.a.p.c cVar, @NonNull e.b.a.p.j.d<Data> dVar) {
            this(cVar, Collections.emptyList(), dVar);
        }

        public a(@NonNull e.b.a.p.c cVar, @NonNull List<e.b.a.p.c> list, @NonNull e.b.a.p.j.d<Data> dVar) {
            this.a = (e.b.a.p.c) e.b.a.v.l.d(cVar);
            this.b = (List) e.b.a.v.l.d(list);
            this.f9707c = (e.b.a.p.j.d) e.b.a.v.l.d(dVar);
        }
    }

    boolean a(@NonNull Model model);

    @Nullable
    a<Data> b(@NonNull Model model, int i2, int i3, @NonNull e.b.a.p.f fVar);
}
