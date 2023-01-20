package e.b.a.p.l;

import androidx.annotation.NonNull;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DataSource;
import e.b.a.p.j.d;
import e.b.a.p.l.n;

/* loaded from: classes.dex */
public class v<Model> implements n<Model, Model> {
    private static final v<?> a = new v<>();

    /* loaded from: classes.dex */
    public static class a<Model> implements o<Model, Model> {
        private static final a<?> a = new a<>();

        public static <T> a<T> b() {
            return (a<T>) a;
        }

        @Override // e.b.a.p.l.o
        public void a() {
        }

        @Override // e.b.a.p.l.o
        @NonNull
        public n<Model, Model> c(r rVar) {
            return v.c();
        }
    }

    /* loaded from: classes.dex */
    public static class b<Model> implements e.b.a.p.j.d<Model> {
        private final Model a;

        public b(Model model) {
            this.a = model;
        }

        @Override // e.b.a.p.j.d
        public void a() {
        }

        @Override // e.b.a.p.j.d
        public void c(@NonNull Priority priority, @NonNull d.a<? super Model> aVar) {
            aVar.d((Model) this.a);
        }

        @Override // e.b.a.p.j.d
        public void cancel() {
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public Class<Model> getDataClass() {
            return (Class<Model>) this.a.getClass();
        }

        @Override // e.b.a.p.j.d
        @NonNull
        public DataSource getDataSource() {
            return DataSource.LOCAL;
        }
    }

    public static <T> v<T> c() {
        return (v<T>) a;
    }

    @Override // e.b.a.p.l.n
    public boolean a(@NonNull Model model) {
        return true;
    }

    @Override // e.b.a.p.l.n
    public n.a<Model> b(@NonNull Model model, int i2, int i3, @NonNull e.b.a.p.f fVar) {
        return new n.a<>(new e.b.a.u.e(model), new b(model));
    }
}
