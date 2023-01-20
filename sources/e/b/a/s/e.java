package e.b.a.s;

import androidx.annotation.NonNull;
import e.b.a.p.g;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class e {
    private final List<String> a = new ArrayList();
    private final Map<String, List<a<?, ?>>> b = new HashMap();

    /* loaded from: classes.dex */
    public static class a<T, R> {
        private final Class<T> a;
        public final Class<R> b;

        /* renamed from: c  reason: collision with root package name */
        public final g<T, R> f9868c;

        public a(@NonNull Class<T> cls, @NonNull Class<R> cls2, g<T, R> gVar) {
            this.a = cls;
            this.b = cls2;
            this.f9868c = gVar;
        }

        public boolean a(@NonNull Class<?> cls, @NonNull Class<?> cls2) {
            return this.a.isAssignableFrom(cls) && cls2.isAssignableFrom(this.b);
        }
    }

    @NonNull
    private synchronized List<a<?, ?>> c(@NonNull String str) {
        List<a<?, ?>> list;
        if (!this.a.contains(str)) {
            this.a.add(str);
        }
        list = this.b.get(str);
        if (list == null) {
            list = new ArrayList<>();
            this.b.put(str, list);
        }
        return list;
    }

    public synchronized <T, R> void a(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(new a<>(cls, cls2, gVar));
    }

    @NonNull
    public synchronized <T, R> List<g<T, R>> b(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.a) {
            List<a<?, ?>> list = this.b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2)) {
                        arrayList.add(aVar.f9868c);
                    }
                }
            }
        }
        return arrayList;
    }

    @NonNull
    public synchronized <T, R> List<Class<R>> d(@NonNull Class<T> cls, @NonNull Class<R> cls2) {
        ArrayList arrayList;
        arrayList = new ArrayList();
        for (String str : this.a) {
            List<a<?, ?>> list = this.b.get(str);
            if (list != null) {
                for (a<?, ?> aVar : list) {
                    if (aVar.a(cls, cls2) && !arrayList.contains(aVar.b)) {
                        arrayList.add(aVar.b);
                    }
                }
            }
        }
        return arrayList;
    }

    public synchronized <T, R> void e(@NonNull String str, @NonNull g<T, R> gVar, @NonNull Class<T> cls, @NonNull Class<R> cls2) {
        c(str).add(0, new a<>(cls, cls2, gVar));
    }

    public synchronized void f(@NonNull List<String> list) {
        ArrayList<String> arrayList = new ArrayList(this.a);
        this.a.clear();
        for (String str : list) {
            this.a.add(str);
        }
        for (String str2 : arrayList) {
            if (!list.contains(str2)) {
                this.a.add(str2);
            }
        }
    }
}
