package bykvm_19do.bykvm_19do.bykvm_new1.bykvm_19do;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: classes.dex */
public class b {
    private Map<c, List<a>> a = new HashMap();
    private Map<String, String> b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    private final List<f> f1145c;

    /* renamed from: d  reason: collision with root package name */
    private final List<f> f1146d;

    /* renamed from: e  reason: collision with root package name */
    private g f1147e;

    public b() {
        new CopyOnWriteArrayList();
        this.f1145c = new CopyOnWriteArrayList();
        new CopyOnWriteArrayList();
        this.f1146d = new CopyOnWriteArrayList();
        this.f1147e = null;
    }

    @NonNull
    public List<f> a() {
        return this.f1146d;
    }

    @Nullable
    public List<a> a(c cVar) {
        return this.a.get(cVar);
    }

    public void a(g gVar) {
        this.f1147e = gVar;
    }

    public void a(Map<? extends String, ? extends String> map) {
        this.b.putAll(map);
    }

    @Nullable
    public g b() {
        return this.f1147e;
    }

    @NonNull
    public List<f> c() {
        return this.f1145c;
    }

    public Map<String, String> d() {
        return this.b;
    }
}
