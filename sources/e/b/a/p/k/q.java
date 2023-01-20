package e.b.a.p.k;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.bumptech.glide.load.engine.GlideException;
import e.b.a.p.k.g;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class q<Data, ResourceType, Transcode> {
    private final Class<Data> a;
    private final Pools.Pool<List<Throwable>> b;

    /* renamed from: c  reason: collision with root package name */
    private final List<? extends g<Data, ResourceType, Transcode>> f9577c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9578d;

    public q(Class<Data> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<g<Data, ResourceType, Transcode>> list, Pools.Pool<List<Throwable>> pool) {
        this.a = cls;
        this.b = pool;
        this.f9577c = (List) e.b.a.v.l.c(list);
        this.f9578d = "Failed LoadPath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    private s<Transcode> c(e.b.a.p.j.e<Data> eVar, @NonNull e.b.a.p.f fVar, int i2, int i3, g.a<ResourceType> aVar, List<Throwable> list) throws GlideException {
        int size = this.f9577c.size();
        s<Transcode> sVar = null;
        for (int i4 = 0; i4 < size; i4++) {
            try {
                sVar = this.f9577c.get(i4).a(eVar, i2, i3, fVar, aVar);
            } catch (GlideException e2) {
                list.add(e2);
            }
            if (sVar != null) {
                break;
            }
        }
        if (sVar != null) {
            return sVar;
        }
        throw new GlideException(this.f9578d, new ArrayList(list));
    }

    public Class<Data> a() {
        return this.a;
    }

    public s<Transcode> b(e.b.a.p.j.e<Data> eVar, @NonNull e.b.a.p.f fVar, int i2, int i3, g.a<ResourceType> aVar) throws GlideException {
        List<Throwable> list = (List) e.b.a.v.l.d(this.b.acquire());
        try {
            return c(eVar, fVar, i2, i3, aVar, list);
        } finally {
            this.b.release(list);
        }
    }

    public String toString() {
        return "LoadPath{decodePaths=" + Arrays.toString(this.f9577c.toArray()) + '}';
    }
}
